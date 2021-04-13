package com.github.belivipro9x99.studentsmanager.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.github.belivipro9x99.studentsmanager.Objects.KetQua;
import com.github.belivipro9x99.studentsmanager.Objects.KhoaController;
import com.github.belivipro9x99.studentsmanager.Objects.SinhVien;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SinhVienKetQuaController implements Initializable {
	private Stage stage;

	public Label mainTitle;
	public Label subTitle;

	public TableView<KetQua> ketQuaTable;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setSinhVien(SinhVien sinhVien) {
		// Set Header
		mainTitle.setText("Bảng Điểm Của Sinh Viên " + sinhVien.getTen());
		subTitle.setText("Mã SV: " + sinhVien.getMaSV() + ". Khóa " + sinhVien.getKhoa());

		// Set Up Table
		ObservableList<TableColumn<KetQua, ?>> columnList = ketQuaTable.getColumns();

        TableColumn<KetQua, String> idColumn = new TableColumn<>("Mã Lớp");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("maLop"));
        idColumn.setMinWidth(120);
        columnList.add(idColumn);
		
		TableColumn<KetQua, String> subjColumn = new TableColumn<>("Môn Học");
        subjColumn.setCellValueFactory(data -> new SimpleStringProperty(
			KhoaController.getLopHoc(
				data.getValue().getMaLop()
			).getMonHoc())
		);
        columnList.add(subjColumn);

		TableColumn<KetQua, String> diemCCColumn = new TableColumn<>("Điểm Chuyên Cần");
        diemCCColumn.setCellValueFactory(new PropertyValueFactory<>("diemCC"));
        columnList.add(diemCCColumn);

		TableColumn<KetQua, String> diemDKColumn = new TableColumn<>("Điểm Điều Kiện");
        diemDKColumn.setCellValueFactory(new PropertyValueFactory<>("diemDK"));
        columnList.add(diemDKColumn);

		TableColumn<KetQua, String> diemHKColumn = new TableColumn<>("Điểm Học Kì");
        diemHKColumn.setCellValueFactory(new PropertyValueFactory<>("diemHK"));
        columnList.add(diemHKColumn);

		// Update Table Rows
		if (sinhVien.ketQua != null) {
			ObservableList<KetQua> list = FXCollections.observableArrayList(sinhVien.ketQua);
			ketQuaTable.setItems(list);
		}
	}

	public void closeWindow() {
		stage.close();
	}
}
