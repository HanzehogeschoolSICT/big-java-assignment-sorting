package SortVisualisation.Model.Sorting;

import SortVisualisation.Model.Pointer;

/**
 * Created by femkeh on 02/03/17.
 * Part of the big-java-assignment-sorting project.
 */
public class BubbleSort extends AbstractSort {
    private boolean counting = false; // are we counting no-swaps from the start index?
    private int noSwaps = 0;
    private int length;
    private int pointer = 0;

    public BubbleSort(int[] unsortedArray) {
        super(unsortedArray);
        this.length = unsortedArray.length;
    }

    @Override
    public Pointer getPointer() {
        return new Pointer(new int[]{pointer, pointer + 1});
    }

    @Override
    public int[] sortOneStep() {
        if (!isFinished()) {
            if (sortArray[pointer] > sortArray[pointer + 1]) {
                // we need to swap, so turn of the counting and reset the noSwaps counter
                counting = false;
                noSwaps = 0;

                int swap = sortArray[pointer];
                sortArray[pointer] = sortArray[pointer + 1];
                sortArray[pointer + 1] = swap;
            } else {
                if (!counting && pointer == 0)
                    counting = true; // start counting, because we had a no-swap at index 0

                if (counting)
                    noSwaps++;
            }

            pointer++;
            if (pointer == this.length - 1)
                pointer = 0; // reset pointer to the start
        } else {
            pointer = 0;
        }
        return sortArray;
    }

    @Override
    public boolean isFinished() {
        return noSwaps == this.length;
    }


}
