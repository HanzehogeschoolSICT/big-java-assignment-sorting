package SortVisualisation.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by peterzen on 2017-02-27.
 * Part of the big-java-assignment-sorting project.
 */
public class BubbleSortController {
    @FXML private Button btnOneStep;
    @FXML private Button btnStartPause;

    public void visualiseOneSortingStep(ActionEvent actionEvent) {
        System.out.println("This should do 1 visual sorting step of the BubbleSort algorithm.");
        System.out.println(btnOneStep.getText());
    }

    public void startOrPauseSorting(ActionEvent actionEvent) {
        System.out.println("This should start/pause the continuous sorting of the BubbleSort algorithm");
        System.out.println(btnStartPause.getText());
    }
}
