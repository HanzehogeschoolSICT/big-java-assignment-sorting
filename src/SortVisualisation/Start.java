package SortVisualisation;

import SortVisualisation.Controller.SuperController;
import SortVisualisation.Model.RandomGen;
import SortVisualisation.Model.Sorting.AbstractSort;
import SortVisualisation.Model.Sorting.BubbleSort;
import SortVisualisation.Model.Pointer;
import SortVisualisation.Model.Sorting.QuickSort;

import java.util.Arrays;

/**
 * Created by peterzen on 2017-02-16.
 * Part of the big-java-assignment-sorting project.
 */
public class Start {

    public static void main(String[] args) {
        System.out.println("Hello world from the SortVisualisation.Start class");

//        AbstractSort sorter = new QuickSort(RandomGen.generateRandomInts(10));
//        int[] result = sorter.sortOneStep();
//        Pointer pointer = sorter.getPointer();
//        pointer.getIndices().forEach(i -> System.out.println("Pointer index: " + i));
//
//        System.out.println(Arrays.toString(result));
//        System.out.println();

        SuperController.bootSuperController(args);
    }


}
