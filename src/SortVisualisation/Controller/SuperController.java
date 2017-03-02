package SortVisualisation.Controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by peterzen on 2017-02-17.
 * Part of the big-java-assignment-sorting project.
 */
public class SuperController extends Application {

    @FXML private TabPane tabPane;

    public static void bootSuperController(String[] args) {
        SuperController.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello world from the SuperController");
        Parent root = FXMLLoader.load(getClass().getResource("../View/Super.fxml"));

        stage.setScene(new Scene(root, 900, 1600));
        stage.show();
    }


    /**
     * This method is automatically invoked when an fxml file, that points to this
     * Controller, is loaded.
     *
     * This method then uses the dynamicLoadSceneTabs method to load extra tabs,
     * defined in fxml files, located in the SortVisualisation.View.Tabs package.
     */
    @SuppressWarnings("unused")
    public void initialize() {
        try {
            this.dynamicLoadSceneTabs();
        } catch (IOException | URISyntaxException e) {
            // @TODO: create proper error messages
            System.out.println("Error while loading the Scene Tabs:");
            e.printStackTrace();
        }
    }

    private void dynamicLoadSceneTabs() throws IOException, URISyntaxException {
        File folder = new File(getClass().getResource("../View/Tabs/").toURI());

        File[] listOfFiles = folder.listFiles((File f) -> {
            return f.getName().endsWith(".fxml");
        });

        for (File file : listOfFiles) {
            System.out.println("Loaded fxml Tab file:"+getClass().getResource("../View/Tabs/"+file.getName()));
            tabPane.getTabs().add(
                FXMLLoader.load(
                    new URL(getClass().getResource("../View/Tabs/") + file.getName())
                )
            );
        }
    }
}
