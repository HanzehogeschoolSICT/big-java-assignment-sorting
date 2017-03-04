package SortVisualisation;

import SortVisualisation.Controller.SuperController;
import SortVisualisation.Model.RandomGen;
import SortVisualisation.Model.Sorting.AbstractSort;
import SortVisualisation.Model.Sorting.BubbleSort;

/**
 * Created by peterzen on 2017-02-16.
 * Part of the big-java-assignment-sorting project.
 */
public class Start {

    public static void main(String[] args) {
        System.out.println("Hello world from the SortVisualisation.Start class");

        AbstractSort sorter = new BubbleSort(RandomGen.generateRandomInts(6));
//        int[] sortedArray = sorter.sortOneStep();
//        System.out.println("Once");
//        for(int i = 0; i < 6; i++) {
//            System.out.println(sortedArray[i]);
//        }
//        sortedArray = sorter.sortOneStep();
//        System.out.println("Twice");
//        for(int i = 0; i < 6; i++) {
//            System.out.println(sortedArray[i]);
//        }
//        sortedArray = sorter.sortOneStep();
//        System.out.println("Thrice");
//        for(int i = 0; i < 6; i++) {
//            System.out.println(sortedArray[i]);
//        }

        while (!sorter.isFinished()) {
            System.out.println("Step, Pointer: "+sorter.getPointer());
            int[] current = sorter.sortOneStep();
            for (int i : current) {
                System.out.print(i + ", ");
            }
        }
        System.out.println("Finished sorting!");


//        SuperController.bootSuperController(args);
    }


}
