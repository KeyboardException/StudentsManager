package com.github.belivipro9x99.studentsmanager.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import com.github.belivipro9x99.studentsmanager.Objects.KhoaController;
import com.github.belivipro9x99.studentsmanager.Objects.LopHoc;
import com.github.belivipro9x99.studentsmanager.Objects.SinhVien;
import com.github.belivipro9x99.studentsmanager.App;
import com.github.belivipro9x99.studentsmanager.Exception.ExceptionHandler;
import com.github.belivipro9x99.studentsmanager.Objects.BanHoc;
import com.github.belivipro9x99.studentsmanager.Objects.GiangVien;

public class MainController implements Initializable {
    public Label mainTitle;
    public Label subTitle;

    public TableView<SinhVien> sinhVienTable;
    public TableView<GiangVien> giangVienTable;
    public TableView<LopHoc> lopHocTable;
    public TableView<BanHoc> banHocTable;

    public HBox sinhVienSearchBox;
    public TextField sinhVienSearch;
    public String sinhVienQuery;

    public HBox giangVienSearchBox;
    public TextField giangVienSearch;
    public String giangVienQuery;

    public HBox lopHocSearchBox;
    public TextField lopHocSearch;
    public String lopHocQuery;

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

        // Th??m b??? l???ng nghe khi nh???n ????p chu???t v??o m???t h??ng trong b???ng
        // banHoc
        banHocTable.setRowFactory(tv -> {
            TableRow<BanHoc> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                // Ki???m tra s??? l???n click li??n ti???p l?? 2 v??
                // h??ng kh??ng ch???a d??? li???u tr???ng
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    // L???y object banHoc ???????c nh???n ????p chu???t
                    BanHoc banHoc = row.getItem();

                    // M??? c???a s??? edit b??n h???c
                    String action = App.editBanHoc(banHoc, false);

                    // N???u ng?????i d??ng nh???n n??t X??A, th???c hi???n x??a
                    // b??n h???c kh???i danh s??ch
                    switch (action) {
                        case "delete":
                            KhoaController.removeBanHoc(banHoc);
                            break;
                    
                        default:
                            break;
                    }

                    updateBanHoc();
                    KhoaController.safeSave();
                }
            });

            return row;
        });

        setupSinhVienTable();
        setupGiangVienTable();
        setupLopHocTable();

        setupBanHoc();
    }

    //* ======================= SINH VI??N =======================
    public void setupSinhVienTable() {
        ObservableList<TableColumn<SinhVien, ?>> columnList = sinhVienTable.getColumns();

        TableColumn<SinhVien, String> idColumn = new TableColumn<>("M?? SV");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("maSV"));
        idColumn.setMinWidth(120);
        columnList.add(idColumn);

        TableColumn<SinhVien, String> surnameColumn = new TableColumn<>("H???");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        columnList.add(surnameColumn);

        TableColumn<SinhVien, String> nameColumn = new TableColumn<>("T??n");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnList.add(nameColumn);

        TableColumn<SinhVien, String> dobColumn = new TableColumn<>("Ng??y Sinh");
        dobColumn.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        columnList.add(dobColumn);

        TableColumn<SinhVien, String> genderColumn = new TableColumn<>("Gi???i T??nh");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        columnList.add(genderColumn);

        TableColumn<SinhVien, String> phoneColumn = new TableColumn<>("S??? ??i???n Tho???i");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("soDienThoai"));
        phoneColumn.setMinWidth(140);
        columnList.add(phoneColumn);

        TableColumn<SinhVien, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnList.add(emailColumn);

        TableColumn<SinhVien, String> homeColumn = new TableColumn<>("Qu?? Qu??n");
        homeColumn.setCellValueFactory(new PropertyValueFactory<>("queQuan"));
        columnList.add(homeColumn);

        TableColumn<SinhVien, String> khoaColumn = new TableColumn<>("Kh??a");
        khoaColumn.setCellValueFactory(new PropertyValueFactory<>("khoa"));
        columnList.add(khoaColumn);

        // Handle event ng?????i d??ng nh???p v??o ?? t??m ki???m
        // Khi ng?????i d??ng nh???p ch??? v??o ?? th???c hi???n l??u ??o???n query
        // v?? update b???ng v???i query
        sinhVienSearch.setOnKeyTyped(e -> {
			sinhVienQuery = sinhVienSearch.getText();
            updateSinhVienTable();
		});

        updateSinhVienTable();
    }

    public void updateSinhVienTable() {
        ObservableList<SinhVien> list = FXCollections.observableArrayList(KhoaController.getSinhVienList(sinhVienQuery));
        sinhVienTable.setItems(list);
        sinhVienTable.refresh();
    }

    @FXML
    public void addSinhVien() {
        System.out.println("Add SinhVien");
        String id = App.askForID("Sinh Vi??n");
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

    //* ======================= GI???NG VI??N =======================
    public void setupGiangVienTable() {
        ObservableList<TableColumn<GiangVien, ?>> columnList = giangVienTable.getColumns();

        TableColumn<GiangVien, String> idColumn = new TableColumn<>("M?? GV");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("maGV"));
        idColumn.setMinWidth(120);
        columnList.add(idColumn);

        TableColumn<GiangVien, String> surnameColumn = new TableColumn<>("H???");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        columnList.add(surnameColumn);

        TableColumn<GiangVien, String> nameColumn = new TableColumn<>("T??n");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnList.add(nameColumn);

        TableColumn<GiangVien, String> dobColumn = new TableColumn<>("Ng??y Sinh");
        dobColumn.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        columnList.add(dobColumn);

        TableColumn<GiangVien, String> genderColumn = new TableColumn<>("Gi???i T??nh");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        columnList.add(genderColumn);

        TableColumn<GiangVien, String> phoneColumn = new TableColumn<>("S??? ??i???n Tho???i");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("soDienThoai"));
        phoneColumn.setMinWidth(140);
        columnList.add(phoneColumn);

        TableColumn<GiangVien, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnList.add(emailColumn);

        TableColumn<GiangVien, String> trinhDoColumn = new TableColumn<>("Tr??nh ????? H???c V???n");
        trinhDoColumn.setCellValueFactory(new PropertyValueFactory<>("trinhDoHocVan"));
        columnList.add(trinhDoColumn);

        // Handle event ng?????i d??ng nh???p v??o ?? t??m ki???m
        // Khi ng?????i d??ng nh???p ch??? v??o ?? th???c hi???n l??u ??o???n query
        // v?? update b???ng v???i query
        giangVienSearch.setOnKeyTyped(e -> {
			giangVienQuery = giangVienSearch.getText();
            updateGiangVienTable();
		});

        updateGiangVienTable();
    }

    public void updateGiangVienTable() {
        ObservableList<GiangVien> list = FXCollections.observableArrayList(KhoaController.getGiangVienList(giangVienQuery));
        giangVienTable.setItems(list);
        giangVienTable.refresh();
    }

    @FXML
    public void addGiangVien() {
        System.out.println("Add GiangVien");
        String id = App.askForID("Gi???ng Vi??n");
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

    //* ======================= L???P H???C =======================
    public void setupLopHocTable() {
        ObservableList<TableColumn<LopHoc, ?>> columnList = lopHocTable.getColumns();

        TableColumn<LopHoc, String> idColumn = new TableColumn<>("M?? L???p");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("maLop"));
        idColumn.setMinWidth(120);
        columnList.add(idColumn);

        TableColumn<LopHoc, String> subjColumn = new TableColumn<>("M??n H???c");
        subjColumn.setCellValueFactory(new PropertyValueFactory<>("monHoc"));
        columnList.add(subjColumn);

        TableColumn<LopHoc, String> stcColumn = new TableColumn<>("S??? T??n Ch???");
        stcColumn.setCellValueFactory(new PropertyValueFactory<>("soTinChi"));
        columnList.add(stcColumn);

        TableColumn<LopHoc, String> roomColumn = new TableColumn<>("Ph??ng H???c");
        roomColumn.setCellValueFactory(new PropertyValueFactory<>("phongHoc"));
        columnList.add(roomColumn);

        TableColumn<LopHoc, String> gvColumn = new TableColumn<>("Gi???ng Vi??n");
        gvColumn.setCellValueFactory(new PropertyValueFactory<>("giangVien"));
        columnList.add(gvColumn);

        TableColumn<LopHoc, String> statusColumn = new TableColumn<>("Tr???ng Th??i");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("trangThai"));
        columnList.add(statusColumn);

        // Handle event ng?????i d??ng nh???p v??o ?? t??m ki???m
        // Khi ng?????i d??ng nh???p ch??? v??o ?? th???c hi???n l??u ??o???n query
        // v?? update b???ng v???i query
        lopHocSearch.setOnKeyTyped(e -> {
			lopHocQuery = lopHocSearch.getText();
            updateLopHocTable();
		});

        updateLopHocTable();
    }

    public void updateLopHocTable() {
        ObservableList<LopHoc> list = FXCollections.observableArrayList(KhoaController.getLopHocList(lopHocQuery));
        lopHocTable.setItems(list);
        lopHocTable.refresh();
    }

    @FXML
    public void addLopHoc() {
        System.out.println("Add LopHoc");
        String id = App.askForID("L???p H???c");
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

    //* ======================= B??N H???C =======================
    public void setupBanHoc() {
        ObservableList<TableColumn<BanHoc, ?>> columnList = banHocTable.getColumns();

        TableColumn<BanHoc, String> classColumn = new TableColumn<>("Ph??ng H???c");
        classColumn.setCellValueFactory(new PropertyValueFactory<>("phongHoc"));
        classColumn.setMinWidth(120);
        columnList.add(classColumn);

        TableColumn<BanHoc, String> hangSXColumn = new TableColumn<>("H??ng S???n Xu???t");
        hangSXColumn.setCellValueFactory(new PropertyValueFactory<>("hangSX"));
        columnList.add(hangSXColumn);

        TableColumn<BanHoc, Double> donGiaColumn = new TableColumn<>("????n Gi??");
        donGiaColumn.setCellValueFactory(new PropertyValueFactory<>("donGia"));
        columnList.add(donGiaColumn);

        TableColumn<BanHoc, Double> soLuongColumn = new TableColumn<>("S??? L?????ng");
        soLuongColumn.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        columnList.add(soLuongColumn);

        TableColumn<BanHoc, Double> giaTriColumn = new TableColumn<>("Gi?? Tr???");
        giaTriColumn.setCellValueFactory(new PropertyValueFactory<>("giaTri"));
        columnList.add(giaTriColumn);

        TableColumn<BanHoc, String> kichThuocColumn = new TableColumn<>("K??ch Th?????c");
        kichThuocColumn.setCellValueFactory(new PropertyValueFactory<>("kichThuoc"));
        columnList.add(kichThuocColumn);

        TableColumn<BanHoc, Double> dienTichColumn = new TableColumn<>("Di???n T??ch");
        dienTichColumn.setCellValueFactory(new PropertyValueFactory<>("dienTich"));
        columnList.add(dienTichColumn);

        updateBanHoc();
    }

    public void updateBanHoc() {
        ObservableList<BanHoc> list = FXCollections.observableArrayList(KhoaController.getBanHocList());
        banHocTable.setItems(list);
        banHocTable.refresh();
    }

    public void addBanHoc() {
        BanHoc banHoc = new BanHoc();
        String action = App.editBanHoc(banHoc, true);

        switch (action) {
            case "submit":
                try {
                    KhoaController.addBanHoc(banHoc);
                } catch (Exception e) {
                    ExceptionHandler.handle(e);
                }
                break;
                
            default:
                break;
        }

        updateBanHoc();
    }
    
    //? =================== THAO T??C ===================
    public void showSinhVienKetQua() {
        SinhVien sinhVien = App.askForChoice(KhoaController.getSinhVienList(), "Ch???n Sinh Vi??n Mu???n Xem", App.primaryStage);

		if (sinhVien == null)
			return;

        try {
            FXMLLoader fxmlLoader = App.loadFXML("sinhVienKetQua");
            Parent root = fxmlLoader.load();
            SinhVienKetQuaController controller = fxmlLoader.getController();
            
            Scene scene = new Scene(root);
            Stage window = App.createMoralWindow(scene, "SinhVienKetQua", App.primaryStage);
    
            controller.setStage(window);
            controller.setSinhVien(sinhVien);
    
            window.setWidth(800);
            window.setHeight(500);
            window.showAndWait();
        } catch (Exception e) {
            ExceptionHandler.handle(e);
        }
    }

    public void showGiangVienLopHoc() {
        GiangVien giangVien = App.askForChoice(KhoaController.getGiangVienList(), "Ch???n Gi???ng Vi??n Mu???n Xem", App.primaryStage);

		if (giangVien == null)
			return;

        try {
            FXMLLoader fxmlLoader = App.loadFXML("giangVienLopHoc");
            Parent root = fxmlLoader.load();
            GiangVienLopHocController controller = fxmlLoader.getController();
            
            Scene scene = new Scene(root);
            Stage window = App.createMoralWindow(scene, "GiangVienLopHoc", App.primaryStage);
    
            controller.setStage(window);
            controller.setGiangVien(giangVien);
    
            window.setWidth(800);
            window.setHeight(500);
            window.showAndWait();
        } catch (Exception e) {
            ExceptionHandler.handle(e);
        }
    }
}