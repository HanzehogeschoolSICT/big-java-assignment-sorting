package SortVisualisation.Controller;

import SortVisualisation.Model.ChartDataManager;
import SortVisualisation.Model.Sorting.QuickSort;
import javafx.event.ActionEvent;

/**
 * Created by peterzen on 2017-02-28.
 * Part of the big-java-assignment-sorting project.
 */
public class QuickSortController extends AbstractSortController {

    public QuickSortController() {
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

    @Override
    public void visualiseInput(ActionEvent actionEvent) {
        super.visualiseInput(actionEvent);

        // initialize our sorting algorithm
        sorter = null;
        sorter = new QuickSort(unsortedIntegers);
    }

}
