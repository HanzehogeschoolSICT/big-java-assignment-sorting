package SortVisualisation.Model.Sorting;

/**
 * Created by femkeh on 02/03/17.
 * Part of the big-java-assignment-sorting project.
 */
public class BubbleSort extends AbstractSort {
    @Override
    public int[] sortOneStep() {
        if (pointer < length && times != 0) {
            if (sortArray[pointer] > sortArray[pointer + 1]) {
                int swap = sortArray[pointer];
                sortArray[pointer] = sortArray[pointer + 1];
                sortArray[pointer + 1] = swap;
            }

            pointer++;
        } else {
            times--;
            pointer = 0;
        }
        return sortArray;
    }
}
