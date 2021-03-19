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
        System.out.println("Loading " + this.getClass().getName());

        mainTitle.setText(KhoaController.khoa.ten);
        subTitle.setText(KhoaController.khoa.diaChi);

        setupStudentsTable();
    }

    public void setupStudentsTable() {
        ObservableList<TableColumn<SinhVien, ?>> columnList = studentsTable.getColumns();

        TableColumn<SinhVien, String> idColumn = new TableColumn<>("Mã SV");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("maSV"));
        columnList.add(idColumn);

        TableColumn<SinhVien, String> nameColumn = new TableColumn<>("Họ Tên");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnList.add(nameColumn);

        TableColumn<SinhVien, String> dobColumn = new TableColumn<>("Ngày Sinh");
        dobColumn.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        columnList.add(dobColumn);

        TableColumn<SinhVien, String> genderColumn = new TableColumn<>("Giới Tính");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        columnList.add(genderColumn);

        TableColumn<SinhVien, String> phoneColumn = new TableColumn<>("Số Điện Thoại");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("soDienThoai"));
        columnList.add(phoneColumn);

        TableColumn<SinhVien, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnList.add(emailColumn);

        TableColumn<SinhVien, String> homeColumn = new TableColumn<>("Quê Quán");
        homeColumn.setCellValueFactory(new PropertyValueFactory<>("queQuan"));
        columnList.add(homeColumn);

        TableColumn<SinhVien, String> khoaColumn = new TableColumn<>("Khóa");
        khoaColumn.setCellValueFactory(new PropertyValueFactory<>("khoa"));
        columnList.add(khoaColumn);

        updateStudentsTable();
    }

    public void updateStudentsTable() {
        ObservableList<SinhVien> list = FXCollections.observableArrayList(KhoaController.getSinhVienList());
        list.add(new SinhVien("asdasdaf"));
        studentsTable.setItems(list);
    }
}