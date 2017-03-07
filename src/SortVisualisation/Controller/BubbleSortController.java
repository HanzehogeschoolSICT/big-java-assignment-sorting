package SortVisualisation.Controller;

import SortVisualisation.Model.ChartDataManager;
import SortVisualisation.Model.Sorting.BubbleSort;
import javafx.event.ActionEvent;

/**
 * Created by peterzen on 2017-02-27.
 * Modified by femkeh on 2017-3-2.
 * Part of the big-java-assignment-sorting project.
 */
public class BubbleSortController extends AbstractSortController {

    public BubbleSortController() {
    }

    /**
     * This method is automatically invoked when an fxml file, that points to this
     * Controller, is loaded.
     */
    @SuppressWarnings("unused")
    public void initialize() {
        // Use the ChartDataManager to manage our BarChart data
        this.chartData = new ChartDataManager(barChart);
    }

    public void visualiseInput(ActionEvent actionEvent) {
        super.visualiseInput(actionEvent);

        // initialize our sorting algorithm
        sorter = null;
        sorter = new BubbleSort(unsortedIntegers);

        // set default pointers within barChart
        chartData.selectNode(0);
        chartData.selectNode(1); // the pointer always starts at 0 (and compares with 1)
    }

}
