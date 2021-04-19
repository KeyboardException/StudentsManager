package com.github.belivipro9x99.studentsmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Modality;

import java.io.IOException;
import java.util.ArrayList;

import com.github.belivipro9x99.studentsmanager.Controllers.EditBanHocController;
import com.github.belivipro9x99.studentsmanager.Controllers.EditClassController;
import com.github.belivipro9x99.studentsmanager.Controllers.EditController;
import com.github.belivipro9x99.studentsmanager.Controllers.PopupController;
import com.github.belivipro9x99.studentsmanager.Exception.ExceptionHandler;
import com.github.belivipro9x99.studentsmanager.Libs.Belibrary;
import com.github.belivipro9x99.studentsmanager.Objects.BanHoc;
import com.github.belivipro9x99.studentsmanager.Objects.KetQua;
import com.github.belivipro9x99.studentsmanager.Objects.KhoaController;
import com.github.belivipro9x99.studentsmanager.Objects.LopHoc;
import com.github.belivipro9x99.studentsmanager.Objects.NhanSu;

/**
 * JavaFX App
 */
public class App extends Application {
    public static Stage primaryStage;
    private static Scene scene;
    public static KhoaController khoaController;
    
    @Override
    public void start(Stage stage) {
        App.primaryStage = stage;
        try {
            App.khoaController = new KhoaController();
            FXMLLoader fxmlLoader = loadFXML("main");
            Parent root = fxmlLoader.load();
            App.scene = new Scene(root, 980, 560);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            ExceptionHandler.handle(e);
        }

        ExceptionHandler eHandler = new ExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(eHandler);
    }

    public static FXMLLoader loadFXML(String fxml) throws IOException {
        return new FXMLLoader(App.class.getResource("layouts/" + fxml + ".fxml"));
    }

    public static Stage createMoralWindow(Scene scene, String title, Stage owner) {
        if (owner == null)
            owner = App.primaryStage;

        Stage newWindow = new Stage();
        newWindow.setTitle(title);
        newWindow.setScene(scene);

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);

        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(owner);
        
        return newWindow;
    }

    public static String editNhanSu(NhanSu nhanSu, Boolean isNew) {
        return editNhanSu(nhanSu, isNew, null);
    }

    public static String editNhanSu(NhanSu nhanSu, Boolean isNew, KetQua ketQua) {
        try {
            FXMLLoader fxmlLoader = loadFXML("edit");
            Parent root = fxmlLoader.load();
            EditController controller = fxmlLoader.getController();
            controller.setNhanSu(nhanSu);

            Scene scene = new Scene(root);
            Stage window = createMoralWindow(scene, "Đang Chỉnh Sửa " + nhanSu.getClass().getName(), App.primaryStage);

            controller.setStage(window);

            if (isNew)
                Belibrary.hide(controller.deleteButton);
            else
                Belibrary.hide(controller.cancelButton);

            if (ketQua != null)
                controller.setEditKetQua(ketQua);

            window.setWidth(800);
            window.setHeight(500);
            window.showAndWait();

            return controller.userAction;
        } catch (IOException e) {
            ExceptionHandler.handle(e);
        }

        return null;
    }

    public static String editLopHoc(LopHoc lopHoc, Boolean isNew) {
        try {
            FXMLLoader fxmlLoader = loadFXML("editClass");
            Parent root = fxmlLoader.load();
            EditClassController controller = fxmlLoader.getController();
            controller.setLopHoc(lopHoc);

            Scene scene = new Scene(root);
            Stage window = createMoralWindow(scene, "Đang Chỉnh Sửa " + lopHoc.getClass().getName(), App.primaryStage);

            controller.setStage(window);
            if (isNew)
                Belibrary.hide(controller.deleteButton);
            else
                Belibrary.hide(controller.cancelButton);

            window.setWidth(800);
            window.setHeight(500);
            window.showAndWait();

            return controller.userAction;
        } catch (IOException e) {
            ExceptionHandler.handle(e);
        }

        return null;
    }

    public static String editBanHoc(BanHoc banHoc, Boolean isNew) {
        try {
            FXMLLoader fxmlLoader = loadFXML("editBanHoc");
            Parent root = fxmlLoader.load();
            EditBanHocController controller = fxmlLoader.getController();
            controller.setBanHoc(banHoc);

            Scene scene = new Scene(root);
            Stage window = createMoralWindow(scene, "Đang Chỉnh Sửa " + banHoc.getClass().getName(), App.primaryStage);

            controller.setStage(window);
            if (isNew)
                Belibrary.hide(controller.deleteButton);
            else
                Belibrary.hide(controller.cancelButton);

            window.setWidth(800);
            window.setHeight(500);
            window.showAndWait();

            return controller.userAction;
        } catch (IOException e) {
            ExceptionHandler.handle(e);
        }

        return null;
    }

    public static String askForID(String type) {
        try {
            FXMLLoader fxmlLoader = loadFXML("popup");
            Parent root = fxmlLoader.load();
            PopupController controller = fxmlLoader.getController();
            controller.setType("input");
    
            Scene scene = new Scene(root);
            Stage window = createMoralWindow(scene, "Nhập ID Cho " + type, App.primaryStage);
            window.initStyle(StageStyle.UNDECORATED);
            window.setWidth(455);
            window.setHeight(300);
            window.setResizable(false);
            
            controller.setStage(window);
            controller.setTitle("Tạo " + type);
            controller.setLabel("Nhập Mã " + type + ":");
            window.showAndWait();
    
            return controller.getValue();
        } catch (IOException e) {
            ExceptionHandler.handle(e);
        }

        return null;
    }

    public static <T> T askForChoice(ArrayList<T> choices, String prompt, Stage parent) {
        try {
            FXMLLoader fxmlLoader = loadFXML("popup");
            Parent root = fxmlLoader.load();
            PopupController controller = fxmlLoader.getController();
            controller.setType("select");
    
            Scene scene = new Scene(root);
            Stage window = createMoralWindow(scene, "Lựa Chọn", parent);
            window.initStyle(StageStyle.UNDECORATED);
            window.setWidth(455);
            window.setHeight(300);
            window.setResizable(false);
            
            controller.setStage(window);
            controller.setTitle("Lựa Chọn");
            controller.setLabel(prompt);
            controller.setChoiceValues(choices);
            window.showAndWait();
    
            return controller.getChoiceValue();
        } catch (IOException e) {
            ExceptionHandler.handle(e);
        }

        return null;
    }

    public static String deleteConfirmation(String action) {
        try {
            FXMLLoader fxmlLoader = loadFXML("popup");
            Parent root = fxmlLoader.load();
            PopupController controller = fxmlLoader.getController();
            controller.setType("delete");
    
            Scene scene = new Scene(root);
            Stage window = createMoralWindow(scene, "Xác Nhận", App.primaryStage);
            window.initStyle(StageStyle.UNDECORATED);
            window.setWidth(455);
            window.setHeight(280);
            window.setResizable(false);
            
            controller.setStage(window);
            controller.setTitle("Xác Nhận");
            controller.setLabel(action);
            controller.setText("Hành động này không thể hoàn tác một khi đã thực hiện!");
            window.showAndWait();
    
            return controller.getValue();
        } catch (IOException e) {
            ExceptionHandler.handle(e);
        }

        return null;
    }

    public static void main(String[] args) {
        launch();
    }
}