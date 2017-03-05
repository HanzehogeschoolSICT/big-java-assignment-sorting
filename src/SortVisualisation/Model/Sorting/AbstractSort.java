package SortVisualisation.Model.Sorting;

/**
 * Created by femkeh on 04/03/17.
 * Part of the big-java-assignment-sorting project.
 */
public abstract class AbstractSort {
    protected int[] sortArray;
    protected int pointer = 0;

    protected AbstractSort(int[] unsortedArray) {
        this.sortArray = unsortedArray;
    }

    public int getPointer() {
        return pointer;
    }

    abstract public int[] sortOneStep();

    abstract public boolean isFinished();
}
