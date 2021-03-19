package com.github.belivipro9x99.studentsmanager.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import com.github.belivipro9x99.studentsmanager.Objects.KhoaController;
import com.github.belivipro9x99.studentsmanager.Objects.SinhVien;

public class MainController implements Initializable {
    public Label mainTitle;
    public Label subTitle;
    public TableView<SinhVien> studentsTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading MainController");

        mainTitle.setText(KhoaController.khoa.ten);
        subTitle.setText(KhoaController.khoa.diaChi);

        setupStudentsTable();
    }

    public void setupStudentsTable() {
        TableColumn<SinhVien, String> idColumn = new TableColumn<>("Mã SV");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("maSV"));

        studentsTable.getColumns().add(idColumn);
        updateStudentsTable();
    }

    public void updateStudentsTable() {
        ObservableList<SinhVien> list = FXCollections.observableArrayList(KhoaController.getSinhVienList());
        //list.add(new SinhVien("asdasdaf"));
        studentsTable.setItems(list);
    }
}