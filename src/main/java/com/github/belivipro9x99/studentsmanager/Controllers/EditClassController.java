package com.github.belivipro9x99.studentsmanager.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.github.belivipro9x99.studentsmanager.App;
import com.github.belivipro9x99.studentsmanager.Components.OSCButton;
import com.github.belivipro9x99.studentsmanager.Libs.Belibrary;
import com.github.belivipro9x99.studentsmanager.Objects.GiangVien;
import com.github.belivipro9x99.studentsmanager.Objects.KhoaController;
import com.github.belivipro9x99.studentsmanager.Objects.LopHoc;
import com.github.belivipro9x99.studentsmanager.Objects.SinhVien;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EditClassController implements Initializable {
	private LopHoc lopHoc;
	private Stage stage;

	public String userAction = "cancel";

	public Label mainTitle;
	public Label subTitle;

	public OSCButton cancelButton;
	public OSCButton deleteButton;

	public TextField subjectInput;
	public TextField stcInput;
	public TextField roomInput;

	public ChoiceBox<GiangVien> giangVienInput;
	public RadioButton ttHocButton;
	public RadioButton ttNghiButton;
	public RadioButton ttHocOnlineButton;

	public HBox studentsContainer;

	@FXML
	public TableView<SinhVien> sinhVienTable;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sinhVienTable.setRowFactory(tv -> {
            TableRow<SinhVien> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    SinhVien sinhVien = row.getItem();
                    String action = App.editNhanSu(sinhVien, false, sinhVien.getKetQua(lopHoc.maLop));

                    switch (action) {
                        case "delete":
							lopHoc.maSV.remove(sinhVien.getMaSV());
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
	}

	public void setLopHoc(LopHoc lopHoc) {
		this.lopHoc = lopHoc;
		System.out.println("Got " + lopHoc);
		subTitle.setText("Mã Lớp: " + lopHoc.maLop);

		updateHeader();
		updateInputValue();
		attachListeners();

		setupSinhVienTable();
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void updateHeader() {
		
	}

	public void updateInputValue() {
		subjectInput.setText(lopHoc.getMonHoc());
		stcInput.setText(String.valueOf(lopHoc.getSoTinChi()));
		roomInput.setText(lopHoc.getPhongHoc());

		ObservableList<GiangVien> giangVien = FXCollections.observableArrayList(KhoaController.getGiangVienList());
		giangVienInput.getItems().setAll(giangVien);

		if (lopHoc.giangVien != null)
			giangVienInput.setValue(lopHoc.giangVien);

		switch (lopHoc.trangThai) {
			case 0:
				ttHocButton.setSelected(true);
				break;

			case 1:
				ttHocOnlineButton.setSelected(true);
				break;

			case 2:
				ttNghiButton.setSelected(true);
				break;
		
			default:
				break;
		}
	}

	public void attachListeners() {
		subjectInput.setOnKeyTyped(e -> {
			lopHoc.setMonHoc(subjectInput.getText());
		});

		stcInput.setOnKeyTyped(e -> {
			String value = stcInput.getText();
			String sVal = Belibrary.sanitizeNumber(value);

			if (value != sVal)
				stcInput.setText(sVal);

			lopHoc.setSoTinChi(Integer.parseInt(sVal));
		});

		roomInput.setOnKeyTyped(e -> {
			lopHoc.setPhongHoc(roomInput.getText());
		});

		giangVienInput.setOnAction(e -> {
			lopHoc.setGiangVien(giangVienInput.getValue());
		});

		ttHocButton.setOnMouseClicked(e -> { lopHoc.setTrangThai(0); });
		ttHocOnlineButton.setOnMouseClicked(e -> { lopHoc.setTrangThai(1); });
		ttNghiButton.setOnMouseClicked(e -> { lopHoc.setTrangThai(2); });
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

        TableColumn<SinhVien, String> khoaColumn = new TableColumn<>("Khóa");
        khoaColumn.setCellValueFactory(new PropertyValueFactory<>("khoa"));
        columnList.add(khoaColumn);

		TableColumn<SinhVien, Double> diemCCColumn = new TableColumn<>("Điểm Chuyên Cần");
        diemCCColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getKetQua(lopHoc.maLop).diemCC).asObject());
        columnList.add(diemCCColumn);

		TableColumn<SinhVien, Double> diemDKColumn = new TableColumn<>("Điểm Điều Kiện");
        diemDKColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getKetQua(lopHoc.maLop).diemDK).asObject());
        columnList.add(diemDKColumn);

		TableColumn<SinhVien, Double> diemHKColumn = new TableColumn<>("Điểm Học Kì");
        diemHKColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getKetQua(lopHoc.maLop).diemHK).asObject());
        columnList.add(diemHKColumn);

        updateSinhVienTable();
    }

    public void updateSinhVienTable() {
		ArrayList<SinhVien> sinhVienList = new ArrayList<SinhVien>();

		for (SinhVien item : KhoaController.getSinhVienList())
			if (lopHoc.maSV.contains(item.getMaSV()))
				sinhVienList.add(item);

        ObservableList<SinhVien> list = FXCollections.observableArrayList(sinhVienList);
        sinhVienTable.setItems(list);
        sinhVienTable.refresh();
    }

	@FXML
	public void studentAdd() {
		SinhVien add = App.askForChoice(KhoaController.getSinhVienList(), "Chọn Sinh Viên Muốn Thêm", stage);

		if (add == null)
			return;

		if (lopHoc.maSV.contains(add.getMaSV()))
			return;

		lopHoc.maSV.add(add.getMaSV());
		updateSinhVienTable();
		KhoaController.safeSave();
	}

	@FXML
	public void studentRemove() {
		SinhVien selected = sinhVienTable.getSelectionModel().getSelectedItem();

		if (selected == null)
			return;

		String action = App.deleteConfirmation("Loại Bỏ Sinh Viên \"" + selected.getTen() + "\" Khỏi Lớp \"" + lopHoc.maLop + "\" Không?");

		if (action == "delete") {
			lopHoc.maSV.remove(selected.getMaSV());
			updateSinhVienTable();
			KhoaController.safeSave();
		}
	}

	public void userSubmit() {
		this.userAction = "submit";
		this.closeWindow();
	}

	public void userCancel() {
		this.userAction = "cancel";
		this.closeWindow();
	}

	public void userDelete() {
		String action = App.deleteConfirmation("Bạn Có Chắc Muốn Xóa Lớp Học \"" + lopHoc.getMaLop() + "\" Không?");

		if (action == "delete") {
			this.userAction = "delete";
			this.closeWindow();
		}
	}

	public void closeWindow() {
		stage.close();
	}
}
