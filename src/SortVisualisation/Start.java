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

        SuperController.bootSuperController(args);
    }


}
