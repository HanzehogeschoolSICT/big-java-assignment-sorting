package SortVisualisation.Model.Sorting;

/**
 * Created by femkeh on 05/03/17.
 * Part of the big-java-assignment-sorting project.
 */
public class InsertionSort extends AbstractSort {
    private int length;

    public InsertionSort(int[] unsortedArray) {
        super(unsortedArray);
        this.length = unsortedArray.length;
    }

    @Override
    public int[] sortOneStep() {
        if (!isFinished()) {
            // first i ints are already in order
            int insert = sortArray[pointer + 1]; // get i int to put in order
            temp = pointer;
            while (temp >= 0 && insert < sortArray[temp]) {
                // all ints larger than i move one place to the right in the array
                sortArray[temp + 1] = sortArray[temp];
                temp--;
            }
            sortArray[temp + 1] = insert; // put int in right place
            pointer++;
        }
        return sortArray;
    }

    @Override
    public boolean isFinished() {
        return pointer + 1 == this.length;
    }
}
