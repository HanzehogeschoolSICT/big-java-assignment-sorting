package SortVisualisation.Model.Sorting;

/**
 * Created by femkeh on 05/03/17.
 * Part of the big-java-assignment-sorting project.
 */
public class InsertionSort extends AbstractSort{
    private boolean counting = false; // are we counting no-swaps from the start index?
    private int noSwaps = 0;
    private int length;

    public InsertionSort(int[] unsortedArray) {
        super(unsortedArray);
        this.length = unsortedArray.length;
    }

    @Override
    public int[] sortOneStep() {
        if (!isFinished()) { //&& pointer+1 != this.length
            // first i ints are already in order
            int insert = sortArray[pointer+1]; // get i int to put in order
            int j=pointer; // compare with int before i (i-1)
            while(j>=0 && insert<sortArray[j]){
                // all ints larger than i move one place to the right in the array
                sortArray[j+1] = sortArray[j];
                System.out.println("j: " + j);
                j--;
            }
            sortArray[j+1] = insert; // put int on right place
            pointer++;
        }
        return sortArray;
    }

    @Override
    public boolean isFinished() {
        return pointer+1 == this.length;
    }
}
