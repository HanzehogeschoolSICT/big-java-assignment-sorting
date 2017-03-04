package SortVisualisation.Model.Sorting;

/**
 * Created by femkeh on 02/03/17.
 * Part of the big-java-assignment-sorting project.
 */
public class BubbleSort extends AbstractSort {
    int noSwaps = 0;

    public BubbleSort(int[] unsortedArray) {
        super(unsortedArray);
    }

    @Override
    public int[] sortOneStep() {
        if (pointer < length && !isFinished()) { //&& times != 0
            if (sortArray[pointer] > sortArray[pointer + 1]) {
                int swap = sortArray[pointer];
                sortArray[pointer] = sortArray[pointer + 1];
                sortArray[pointer + 1] = swap;
            }

            pointer++;
            noSwaps = 0;
        } else {
            //times--;
            //pointer = 0;
            noSwaps++;
        }
        return sortArray;
    }

    @Override
    public boolean isFinished() {
        if (noSwaps == length) {
            return true;
        }
        return false;
    }


}
