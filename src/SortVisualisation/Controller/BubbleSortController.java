package SortVisualisation.Controller;

import SortVisualisation.Model.ChartDataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;

import java.util.stream.IntStream;

/**
 * Created by peterzen on 2017-02-27.
 * Part of the big-java-assignment-sorting project.
 */
public class BubbleSortController {
    @FXML
    private NumberAxis bcYAxis;
    @FXML
    private CategoryAxis bcXAxis;
    @FXML
    private Button btnOneStep;
    @FXML
    private Button btnStartPause;
    @FXML
    private BarChart barChart;

    private ChartDataManager chartData;
    private int[] inputArray;

    private static int fakePointer = 0;

    public BubbleSortController() {
        inputArray = new int[100];
        IntStream.range(0, 100)
                .forEach(i -> {
                    Double random = (Math.random() * 100 * i);
                    inputArray[i] = random.intValue();
                });
    }

    public void visualiseOneSortingStep(ActionEvent actionEvent) {
        // @TODO: perform one step of our sorting algorithm

        // Prepare the (updated) collection of random numeric values for our BarChart
        chartData.updateDataSet(inputArray);

        // Load the prepared data into our BarChart
        chartData.load();

        // Set-up appropriate styling classes for each bar
        chartData.styleChartData("BarChart-default");

        chartData.clearSelectedNodes();
        // @TODO: retrieve pointer (selected index) information from sort method class
        IntStream.range(fakePointer, fakePointer+2).forEach(i -> chartData.selectNode(i));
        fakePointer++;

        System.out.println(btnOneStep.getText() + " == Done");
    }

    public void startOrPauseSorting(ActionEvent actionEvent) {
        System.out.println("This should start/pause the continuous sorting of the BubbleSort algorithm");
        System.out.println(btnStartPause.getText());
    }

    /**
     * This method is automatically invoked when an fxml file, that points to this
     * Controller, is loaded.
     */
    @SuppressWarnings("unused")
    public void initialize() {
        // Use the ChartDataManager to manage our BarChart data
        this.chartData = new ChartDataManager(barChart);

        // Prepare the collection of random numeric values for our BarChart
        chartData.updateDataSet(inputArray); // @TODO: replace this method call with the actual RandomGen data

        // Load the prepared data into our BarChart instance
        chartData.load();

        // Add a css class to each Bar in our BarChart
        chartData.styleChartData("BarChart-default");
    }

}
