package SortVisualisation.Model.Sorting;

import SortVisualisation.Model.Pointer;

/**
 * Created by femkeh on 04/03/17.
 * Part of the big-java-assignment-sorting project.
 */
public abstract class AbstractSort {
    protected int[] sortArray;

    protected AbstractSort(int[] unsortedArray) {
        this.sortArray = unsortedArray;
    }

    abstract public Pointer getPointer();

    abstract public int[] sortOneStep();

    abstract public boolean isFinished();
}
