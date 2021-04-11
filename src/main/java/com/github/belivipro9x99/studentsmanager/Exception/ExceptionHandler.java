package com.github.belivipro9x99.studentsmanager.Exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.github.belivipro9x99.studentsmanager.App;
import com.github.belivipro9x99.studentsmanager.Controllers.PopupController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
	public static void handle(Throwable e) {
		try {
            FXMLLoader fxmlLoader = App.loadFXML("popup");
            Parent root = fxmlLoader.load();
            PopupController controller = fxmlLoader.getController();
            controller.setType("error");
    
            Scene scene = new Scene(root);
            Stage window = App.createMoralWindow(scene, "Exception Occured", App.primaryStage);
            window.initStyle(StageStyle.UNDECORATED);
            window.setWidth(455);
            window.setHeight(460);
            window.setResizable(false);

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            
            controller.setStage(window);
            controller.setTitle("Toang Rồi Ông Giáo Ạ!");
            controller.setLabel(e.getMessage());
            controller.setTextArea(sw.toString());
            window.showAndWait();
        } catch (Exception error) {
            System.err.println("During handling exception, another exception occured. (Oops)");
			System.err.print(error);
            e.printStackTrace();
        }
	}

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        handle(e);
    }
}
