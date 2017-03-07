package SortVisualisation.Model.Sorting;

import SortVisualisation.Model.Pointer;

/**
 * Created by femkeh on 05/03/17.
 * Part of the big-java-assignment-sorting project.
 */
public class InsertionSort extends AbstractSort {
    private int length;
    private int firstPointer = 0;
    private int temp;

    public InsertionSort(int[] unsortedArray) {
        super(unsortedArray);
        this.length = unsortedArray.length;
    }

    @Override
    public Pointer getPointer() {
        if (isFinished()) // this solves the going out of bounds bug from issue #14
            return new Pointer(firstPointer);
        return new Pointer(new int[]{firstPointer, firstPointer+1});
    }

    @Override
    public int[] sortOneStep() {
        if (!isFinished()) {
            // first pointer+1 ints are already in order
            int insert = sortArray[firstPointer + 1]; // get pointer+1 int to put in order
            temp = firstPointer;
            while (temp >= 0 && insert < sortArray[temp]) {
                // all ints larger than pointer+1 move one place to the right in the array
                sortArray[temp + 1] = sortArray[temp];
                temp--;
            }
            sortArray[temp + 1] = insert; // put int in right place
            firstPointer++;
            System.out.println("Are we going out of bounds? " + firstPointer);
        }
        
        return sortArray;
    }

    @Override
    public boolean isFinished() {
        return firstPointer + 1 == this.length;
    }
}
