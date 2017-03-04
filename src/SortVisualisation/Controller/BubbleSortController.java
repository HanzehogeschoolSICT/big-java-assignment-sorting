package SortVisualisation.Controller;

import SortVisualisation.Model.ChartDataManager;
import SortVisualisation.Model.RandomGen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private Button btnInput;
    @FXML
    private BarChart barChart;
    @FXML
    private TextField fldInput;


    private ChartDataManager chartData;

    private static int fakePointer = 0;

    public BubbleSortController() {
    }

    public void visualiseOneSortingStep(ActionEvent actionEvent) {
        // @TODO: perform one step of our sorting algorithm

        chartData.clearSelectedNodes();
        // @TODO: retrieve pointer (selected index) information from sort factory
        IntStream.range(fakePointer, fakePointer + 2).forEach(i -> chartData.selectNode(i));
        fakePointer++;

        System.out.println(btnOneStep.getText() + " == Done");
    }

    public void startOrPauseSorting(ActionEvent actionEvent) {
        System.out.println("This should start/pause the continuous sorting of the BubbleSort algorithm");
        System.out.println(btnStartPause.getText() + " == Done");
    }

    /**
     * This method is automatically invoked when an fxml file, that points to this
     * Controller, is loaded.
     */
    @SuppressWarnings("unused")
    public void initialize() {
        // Use the ChartDataManager to manage our BarChart data
        this.chartData = new ChartDataManager(barChart);

        // @TODO: generate the chartData in the visualiseInput callback
//        // Prepare the collection of random numeric values for our BarChart
//        chartData.updateDataSet(inputArray); // @TODO: replace this method call with the actual RandomGen data
//
//        // Load the prepared data into our BarChart instance
//        chartData.load();
//
//        // Add a css class to each Bar in our BarChart
//        chartData.styleChartData("BarChart-default");
    }

    public void visualiseInput(ActionEvent actionEvent) {
        // @TODO: fix proper error handling
        if (!textFieldHasValidInt(fldInput)) {
            System.out.println("Error: You have not entered a number for how many bars you would like to see.");
            return;
        }

        // generate the random integers collection
        int[] randomIntegers = RandomGen.generateRandomInts(Integer.parseInt(fldInput.getText()));

        // update the barChart
        chartData.updateDataSet(randomIntegers);
        chartData.load();
        chartData.styleChartData("BarChart-default");

        // unlock the sorting buttons
        btnStartPause.disableProperty().setValue(false);
        btnOneStep.disableProperty().setValue(false);

        System.out.println(btnInput.getText() + " == Done");
    }

    private boolean textFieldHasValidInt(TextField fldText) {
        try {
            int i = Integer.parseInt(fldText.getText());
            System.out.println(i + " is valid");
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input: "+ fldText.getText() +" could not be parsed to an integer");
        }
        return false;
    }

}
