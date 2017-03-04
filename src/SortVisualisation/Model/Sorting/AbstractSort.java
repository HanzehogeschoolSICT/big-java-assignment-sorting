package SortVisualisation.Model.Sorting;

import SortVisualisation.Model.RandomGen;

/**
 * Created by femkeh on 04/03/17.
 * Part of the big-java-assignment-sorting project.
 */
public abstract class AbstractSort {
    int max = 6; // info from controller of visualiseInput()
    int[] sortArray = RandomGen.generateRandomInts(max);
    int pointer = 0;
    int length = sortArray.length;

    protected AbstractSort(int[] unsortedArray) {
        this.sortArray = unsortedArray;
    }

    public int getPointer() {
        return pointer;
    }

    abstract public int[] sortOneStep();

    abstract public boolean isFinished();
}
