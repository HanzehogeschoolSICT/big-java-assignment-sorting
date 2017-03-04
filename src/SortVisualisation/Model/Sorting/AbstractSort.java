package SortVisualisation.Model.Sorting;

import SortVisualisation.Model.RandomGen;

/**
 * Created by femkeh on 04/03/17.
 * Part of the big-java-assignment-sorting project.
 */
public abstract class AbstractSort {
    RandomGen list = new RandomGen();
    int max = 6; // info from controller of visualiseInput()
    int[] sortArray = list.generateRandomInts(max);
    int pointer = 0;
    int times = sortArray.length;
    int length = sortArray.length;

    abstract public int[] sortOneStep();
}
