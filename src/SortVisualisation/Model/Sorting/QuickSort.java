package SortVisualisation.Model.Sorting;

import SortVisualisation.Model.Pointer;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by peterzen on 2017-03-05.
 * Part of the big-java-assignment-sorting project.
 * With the help of: http://www.programcreek.com/2012/11/quicksort-array-in-java/
 */
public class QuickSort extends AbstractSort {
    private int arrLength;
    private Pointer pointer;
    private QuickSortQueue taskQueue;

    public QuickSort(int[] sortArray) {
        super(sortArray);

        this.arrLength = sortArray.length;
        pointer = new Pointer();
    }

    @Override
    public Pointer getPointer() {
        return null;
    }

    @Override
    public int[] sortOneStep() {
        if (taskQueue == null) {
            taskQueue = new QuickSortQueue();
        }

        return sortArray;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    private void oneRecursiveStep(int[] inputArray, int fromIndex, int toIndex, Integer pivot) {
        if (pivot == null) {
            selectPivot();
            return;
        }

//        leftPointer = fromIndex;
//        rightPointer = toIndex;
//        while (leftPointer <= rightPointer) { // @TODO: possibly change this to an if statement and queue whether it needs to be checked again
//            // while values are on the correct side from the pivot, skip them
//            while (inputArray[leftPointer] < pivotValue)
//                leftPointer++;
//            while (inputArray[rightPointer] > pivotValue)
//                rightPointer++;
//
//            if (leftPointer <= rightPointer) {
//                swapValues(leftPointer, rightPointer);
//                leftPointer++;
//                rightPointer++;
//            }
//        }
//
//        if (fromIndex < rightPointer) {
//            // we have sub-array on the left side from the pivot,
//            // that needs to be recursively called
//            // @TODO: idea: create a queue of next steps needed with the parameters needed for the
//            // next recursive step
//        }
//        if (toIndex > leftPointer) {
//            // we have sub-array on the right side from the pivot,
//            // that needs to be recursively called
//
//        }
//
//        pivotSelected = false;
    }

    private void swapValues(int index1, int index2) {
        int temp = sortArray[index1];
        sortArray[index1] = sortArray[index2];
        sortArray[index2] = temp;
    }

    private int selectPivot() {
        int pivotIndex = arrLength / 2;
        pointer.setCurrent(pivotIndex);
        return sortArray[pivotIndex];
    }

    private class QuickSortQueue implements Queue {

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public Object[] toArray(Object[] objects) {
            return new Object[0];
        }

        @Override
        public boolean add(Object o) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean addAll(Collection collection) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean retainAll(Collection collection) {
            return false;
        }

        @Override
        public boolean removeAll(Collection collection) {
            return false;
        }

        @Override
        public boolean containsAll(Collection collection) {
            return false;
        }

        @Override
        public boolean offer(Object o) {
            return false;
        }

        @Override
        public Object remove() {
            return null;
        }

        @Override
        public Object poll() {
            return null;
        }

        @Override
        public Object element() {
            return null;
        }

        @Override
        public Object peek() {
            return null;
        }
    }

}
