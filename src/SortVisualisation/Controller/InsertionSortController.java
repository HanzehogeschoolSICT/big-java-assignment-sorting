package SortVisualisation.Controller;

import SortVisualisation.Model.ChartDataManager;
import SortVisualisation.Model.Sorting.InsertionSort;
import javafx.event.ActionEvent;

/**
 * Created by peterzen on 2017-02-28.
 * Modified by femkeh on 2017-05-03.
 * Part of the big-java-assignment-sorting project.
 */
public class InsertionSortController extends AbstractSortController {

    public InsertionSortController() {
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
        sorter = new InsertionSort(unsortedIntegers);

        // update the barChart default selected nodes
        chartData.selectNode(0);
        chartData.selectNode(1); // the pointer always starts at 0 (and compares with 1)
    }

//    private void updateBarChartInsertSelected() {
//        chartData.clearSelectedNodes();
//        int pointer = sorter.getPointer();
//        chartData.selectNode(pointer);
//        if (pointer+1 <= unsortedIntegers.length-1) { //otherwise index out of bounds at the end when done with sort
//            chartData.selectNode(pointer + 1);
//        }
//        while (sorter.getTemp() < 5) {
//            int temp = sorter.getTemp();
//            chartData.selectNode(temp);
//            if (temp+1 <= unsortedIntegers.length-1) { //otherwise index out of bounds at the end when done with sort
//                chartData.selectNode(temp + 1);
//            }
//        }
//    }

}
