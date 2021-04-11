package com.github.belivipro9x99.studentsmanager.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import com.github.belivipro9x99.studentsmanager.Objects.KhoaController;
import com.github.belivipro9x99.studentsmanager.Objects.LopHoc;
import com.github.belivipro9x99.studentsmanager.Objects.SinhVien;
import com.github.belivipro9x99.studentsmanager.App;
import com.github.belivipro9x99.studentsmanager.Exception.ExceptionHandler;
import com.github.belivipro9x99.studentsmanager.Objects.GiangVien;

public class MainController implements Initializable {
    public Label mainTitle;
    public Label subTitle;

    public TableView<SinhVien> sinhVienTable;
    public TableView<GiangVien> giangVienTable;
    public TableView<LopHoc> lopHocTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading " + this.getClass().getName());

        mainTitle.setText(KhoaController.khoa.ten);
        subTitle.setText(KhoaController.khoa.diaChi);

        sinhVienTable.setRowFactory(tv -> {
            TableRow<SinhVien> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    SinhVien sinhVien = row.getItem();
                    String action = App.editNhanSu(sinhVien, false);

                    switch (action) {
                        case "delete":
                            KhoaController.removeSinhVien(sinhVien);
                            break;
                    
                        default:
                            break;
                    }

                    updateSinhVienTable();
                    KhoaController.safeSave();
                }
            });

            return row;
        });

        giangVienTable.setRowFactory(tv -> {
            TableRow<GiangVien> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    GiangVien giangVien = row.getItem();
                    String action = App.editNhanSu(giangVien, false);

                    switch (action) {
                        case "delete":
                            KhoaController.removeGiangVien(giangVien);
                            break;
                    
                        default:
                            break;
                    }

                    updateGiangVienTable();
                    KhoaController.safeSave();
                }
            });

            return row;
        });

        lopHocTable.setRowFactory(tv -> {
            TableRow<LopHoc> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    LopHoc lopHoc = row.getItem();
                    String action = App.editLopHoc(lopHoc, false);

                    switch (action) {
                        case "delete":
                            KhoaController.removeLopHoc(lopHoc);
                            break;
                    
                        default:
                            break;
                    }

                    updateLopHocTable();
                    KhoaController.safeSave();
                }
            });

            return row;
        });

        setupSinhVienTable();
        setupGiangVienTable();
        setupLopHocTable();
    }

    public void setupSinhVienTable() {
        ObservableList<TableColumn<SinhVien, ?>> columnList = sinhVienTable.getColumns();

        TableColumn<SinhVien, String> idColumn = new TableColumn<>("Mã SV");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("maSV"));
        columnList.add(idColumn);

        TableColumn<SinhVien, String> surnameColumn = new TableColumn<>("Họ");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        columnList.add(surnameColumn);

        TableColumn<SinhVien, String> nameColumn = new TableColumn<>("Tên");
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
        phoneColumn.setMinWidth(140);
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

        updateSinhVienTable();
    }

    public void updateSinhVienTable() {
        ObservableList<SinhVien> list = FXCollections.observableArrayList(KhoaController.getSinhVienList());
        sinhVienTable.setItems(list);
        sinhVienTable.refresh();
    }

    @FXML
    public void addSinhVien() {
        System.out.println("Add SinhVien");
        String id = App.askForID("Sinh Viên");
        System.out.println("Got ID " + id);

        if (id == null || id.length() < 1)
            return;

        SinhVien sinhVien = new SinhVien(id);
        String action = App.editNhanSu(sinhVien, true);

        switch (action) {
            case "submit":
                try {
                    KhoaController.addSinhVien(sinhVien);
                } catch (Exception e) {
                    ExceptionHandler.handle(e);
                }
                break;
                
            default:
                break;
        }

        updateSinhVienTable();
    }

    public void setupGiangVienTable() {
        ObservableList<TableColumn<GiangVien, ?>> columnList = giangVienTable.getColumns();

        TableColumn<GiangVien, String> idColumn = new TableColumn<>("Mã GV");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("maGV"));
        columnList.add(idColumn);

        TableColumn<GiangVien, String> surnameColumn = new TableColumn<>("Họ");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        columnList.add(surnameColumn);

        TableColumn<GiangVien, String> nameColumn = new TableColumn<>("Tên");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnList.add(nameColumn);

        TableColumn<GiangVien, String> dobColumn = new TableColumn<>("Ngày Sinh");
        dobColumn.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        columnList.add(dobColumn);

        TableColumn<GiangVien, String> genderColumn = new TableColumn<>("Giới Tính");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        columnList.add(genderColumn);

        TableColumn<GiangVien, String> phoneColumn = new TableColumn<>("Số Điện Thoại");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("soDienThoai"));
        phoneColumn.setMinWidth(140);
        columnList.add(phoneColumn);

        TableColumn<GiangVien, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnList.add(emailColumn);

        TableColumn<GiangVien, String> trinhDoColumn = new TableColumn<>("Trình Độ Học Vấn");
        trinhDoColumn.setCellValueFactory(new PropertyValueFactory<>("trinhDoHocVan"));
        columnList.add(trinhDoColumn);

        updateGiangVienTable();
    }

    public void updateGiangVienTable() {
        ObservableList<GiangVien> list = FXCollections.observableArrayList(KhoaController.getGiangVienList());
        giangVienTable.setItems(list);
        giangVienTable.refresh();
    }

    @FXML
    public void addGiangVien() {
        System.out.println("Add GiangVien");
        String id = App.askForID("Giảng Viên");
        System.out.println("Got ID " + id);

        if (id == null || id.length() < 1)
            return;

        GiangVien giangVien = new GiangVien(id);
        String action = App.editNhanSu(giangVien, true);

        switch (action) {
            case "submit":
                try {
                    KhoaController.addGiangVien(giangVien);
                } catch (Exception e) {
                    ExceptionHandler.handle(e);
                }
                break;
                
            default:
                break;
        }

        updateGiangVienTable();
    }

    public void setupLopHocTable() {
        ObservableList<TableColumn<LopHoc, ?>> columnList = lopHocTable.getColumns();

        TableColumn<LopHoc, String> idColumn = new TableColumn<>("Mã Lớp");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("maLop"));
        columnList.add(idColumn);

        TableColumn<LopHoc, String> subjColumn = new TableColumn<>("Môn Học");
        subjColumn.setCellValueFactory(new PropertyValueFactory<>("monHoc"));
        columnList.add(subjColumn);

        TableColumn<LopHoc, String> stcColumn = new TableColumn<>("Số Tín Chỉ");
        stcColumn.setCellValueFactory(new PropertyValueFactory<>("soTinChi"));
        columnList.add(stcColumn);

        TableColumn<LopHoc, String> roomColumn = new TableColumn<>("Phòng Học");
        roomColumn.setCellValueFactory(new PropertyValueFactory<>("phongHoc"));
        columnList.add(roomColumn);

        TableColumn<LopHoc, String> gvColumn = new TableColumn<>("Giảng Viên");
        gvColumn.setCellValueFactory(new PropertyValueFactory<>("giangVien"));
        columnList.add(gvColumn);

        TableColumn<LopHoc, String> statusColumn = new TableColumn<>("Trạng Thái");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("trangThai"));
        columnList.add(statusColumn);

        updateLopHocTable();
    }

    public void updateLopHocTable() {
        ObservableList<LopHoc> list = FXCollections.observableArrayList(KhoaController.getLopHocList());
        lopHocTable.setItems(list);
        lopHocTable.refresh();
    }

    @FXML
    public void addLopHoc() {
        System.out.println("Add LopHoc");
        String id = App.askForID("Lớp Học");
        System.out.println("Got ID " + id);

        if (id == null || id.length() < 1)
            return;

        LopHoc lopHoc = new LopHoc(id);
        String action = App.editLopHoc(lopHoc, true);

        switch (action) {
            case "submit":
                try {
                    KhoaController.addLopHoc(lopHoc);
                } catch (Exception e) {
                    ExceptionHandler.handle(e);
                }
                break;
                
            default:
                break;
        }

        updateLopHocTable();
    }
}