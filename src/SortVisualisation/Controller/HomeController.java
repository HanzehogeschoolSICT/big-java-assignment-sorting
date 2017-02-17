package SortVisualisation.Controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by peterzen on 2017-02-17.
 * Part of the big-java-assignment-sorting project.
 */
public class HomeController extends Application {

    @FXML
    private Button testButton;

    public static void main(String[] args) {
        HomeController.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../View/Home.fxml"));
        stage.setTitle("Hello world from the HomeController");
        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }

    public void handleTestButton(ActionEvent actionEvent) {
        System.out.println("Hello from testButton's eventHandler method!");
    }
}
