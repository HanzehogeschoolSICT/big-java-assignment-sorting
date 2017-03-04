package SortVisualisation.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.lang.reflect.Field;

/**
 * Created by peterzen on 2017-02-27.
 * Modified by femkeh on 2017-3-2.
 * Part of the big-java-assignment-sorting project.
 */
public class BubbleSortController {
    @FXML private Button btnOneStep;
    @FXML private Button btnStartPause;
    @FXML private Button btnInput;
    @FXML private TextField fldInput;

    public void visualiseOneSortingStep(ActionEvent actionEvent) {
        System.out.println("This should do 1 visual sorting step of the BubbleSort algorithm.");
        System.out.println(btnOneStep.getText());
    }

    public void startOrPauseSorting(ActionEvent actionEvent) {
        System.out.println("This should start/pause the continuous sorting of the BubbleSort algorithm");
        System.out.println(btnStartPause.getText());
    }

    public void visualiseInput(ActionEvent actionEvent) {
        if ((fldInput.getText() != null && !fldInput.getText().isEmpty())) {
            System.out.println("This should visualise " + fldInput.getText() + " bars in the bar chart.");
        } else {
            System.out.println("You have not entered a number for how many bars you would like to see.");
        }
        System.out.println(btnInput.getText());
    }
}
