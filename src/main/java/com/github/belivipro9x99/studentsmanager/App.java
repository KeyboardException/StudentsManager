package com.github.belivipro9x99.studentsmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.github.belivipro9x99.studentsmanager.Objects.KhoaController;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static KhoaController khoaController;
    
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        khoaController = new KhoaController();

        scene = new Scene(loadFXML("main"), 860, 520);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("layouts/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}