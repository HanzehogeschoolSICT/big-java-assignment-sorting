package SortVisualisation;

import SortVisualisation.Controller.SuperController;
import SortVisualisation.Model.RandomGen;
import SortVisualisation.Model.Sorting.AbstractSort;
import SortVisualisation.Model.Sorting.BubbleSort;
import SortVisualisation.Model.Sorting.InsertionSort;

/**
 * Created by peterzen on 2017-02-16.
 * Part of the big-java-assignment-sorting project.
 */
public class Start {

    public static void main(String[] args) {
        System.out.println("Hello world from the SortVisualisation.Start class");

       // AbstractSort sorter = new InsertionSort(RandomGen.generateRandomInts(6));
//        int[] sortArray = {6,5,7,3,5,1};
//        AbstractSort sorter = new InsertionSort(sortArray);
//
//        while (!sorter.isFinished()) {
//            System.out.println("Step, Pointer: "+sorter.getPointer());
//            int[] current = sorter.sortOneStep();
//            for (int i : current) {
//                System.out.print(i + ", ");
//            }
//        }
//        System.out.println("Finished sorting!");

        SuperController.bootSuperController(args);
    }


}
