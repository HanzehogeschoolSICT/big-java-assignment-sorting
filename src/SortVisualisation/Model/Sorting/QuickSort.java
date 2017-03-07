package SortVisualisation.Model.Sorting;

import SortVisualisation.Model.Pointer;

import java.util.concurrent.Semaphore;

/**
 * Created by peterzen on 2017-03-05.
 * Part of the big-java-assignment-sorting project.
 * With the help of: http://www.programcreek.com/2012/11/quicksort-array-in-java/
 */
public class QuickSort extends AbstractSort {
    private int arrLength;
    private boolean isFinished = false;
    private Pointer pointer;
    private SteppableThread steppableThread;
    private static final Semaphore blockToStepsSemaphore = new Semaphore(0);

    public QuickSort(int[] sortArray) {
        super(sortArray);

        this.arrLength = sortArray.length;
        pointer = new Pointer();
    }

    @Override
    public Pointer getPointer() {
        return pointer;
    }

    @Override
    public int[] sortOneStep() {
        if (steppableThread == null) {
            steppableThread = new SteppableThread();
            steppableThread.start();
        } else {
            blockToStepsSemaphore.release(); // release a semaphore permit so the SteppableThread stops blocking
        }

        return sortArray;
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    private void swapValues(int index1, int index2) {
        int temp = sortArray[index1];
        sortArray[index1] = sortArray[index2];
        sortArray[index2] = temp;
    }

    private class SteppableThread extends Thread {

        private int selectPivot(int[] inputArray, int fromIndex, int toIndex) {
            int pivotIndex = fromIndex + (toIndex - fromIndex) / 2;
            pointer.setCurrent(pivotIndex);
            return inputArray[pivotIndex];
        }

        @Override
        public void run() {
            try {
                recursiveQuickSort(sortArray, 0, arrLength - 1);
                // if we get here, we can assume the quickSort finished
                isFinished = true;
                System.out.println("WE FINISHED!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void recursiveQuickSort(int[] inputArray, int fromIndex, int toIndex) throws InterruptedException {
            if (inputArray == null || inputArray.length == 0 || fromIndex >= toIndex)
                return;

            int pivotValue = selectPivot(inputArray, fromIndex, toIndex);
            blockToStepsSemaphore.acquire(); // acquire semaphore to block until sortOneStep is called

            int leftPointer = fromIndex;
            int rightPointer = toIndex;
            pointer.setCurrent(new int[]{leftPointer, rightPointer});
            blockToStepsSemaphore.acquire(); // acquire semaphore to block until sortOneStep is called
            while (leftPointer <= rightPointer) {
                // while values are on the correct side from the pivot, skip them
                while (inputArray[leftPointer] < pivotValue) {
                    leftPointer++;
                    pointer.updateIndex(0, leftPointer);
                    blockToStepsSemaphore.acquire(); // acquire semaphore to block until sortOneStep is called
                }

                while (inputArray[rightPointer] > pivotValue) {
                    rightPointer--;
                    pointer.updateIndex(1, rightPointer);
                    blockToStepsSemaphore.acquire(); // acquire semaphore to block until sortOneStep is called
                }

                if (leftPointer <= rightPointer) {
                    swapValues(leftPointer, rightPointer);
                    pointer.setCurrent(new int[]{leftPointer, rightPointer});
                    blockToStepsSemaphore.acquire(); // acquire semaphore to block until sortOneStep is called

                    leftPointer++;
                    pointer.updateIndex(0, leftPointer);
                    blockToStepsSemaphore.acquire(); // acquire semaphore to block until sortOneStep is called

                    rightPointer--;
                    pointer.updateIndex(1, rightPointer);
                    blockToStepsSemaphore.acquire(); // acquire semaphore to block until sortOneStep is called
                }
            }

            if (fromIndex < rightPointer) {
                // we have sub-array on the left side from the pivot,
                // that needs to be recursively called
                recursiveQuickSort(inputArray, fromIndex, rightPointer);
            }
            if (toIndex > leftPointer) {
                // we have sub-array on the right side from the pivot,
                // that needs to be recursively called
                recursiveQuickSort(inputArray, leftPointer, toIndex);
            }
        }
    }

}
