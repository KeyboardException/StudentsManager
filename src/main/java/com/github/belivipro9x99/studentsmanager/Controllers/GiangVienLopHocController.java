package com.github.belivipro9x99.studentsmanager.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.github.belivipro9x99.studentsmanager.Objects.GiangVien;
import com.github.belivipro9x99.studentsmanager.Objects.KhoaController;
import com.github.belivipro9x99.studentsmanager.Objects.LopHoc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class GiangVienLopHocController implements Initializable {
	private Stage stage;

	public Label mainTitle;
	public Label subTitle;

	public TableView<LopHoc> lopHocTable;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setGiangVien(GiangVien giangVien) {
		// Set Header
		mainTitle.setText("Lớp Học Của Giảng Viên " + giangVien.getTen());
		subTitle.setText("Mã GV: " + giangVien.getMaGV());

		// Set Up Table
		ObservableList<TableColumn<LopHoc, ?>> columnList = lopHocTable.getColumns();

        TableColumn<LopHoc, String> idColumn = new TableColumn<>("Mã Lớp");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("maLop"));
        idColumn.setMinWidth(120);
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

        TableColumn<LopHoc, String> statusColumn = new TableColumn<>("Trạng Thái");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("trangThai"));
        columnList.add(statusColumn);

		// Update Table Rows
		ArrayList<LopHoc> filtered = new ArrayList<LopHoc>();

		for (LopHoc lopHoc : KhoaController.getLopHocList())
			if (lopHoc.getGiangVien() == giangVien)
				filtered.add(lopHoc);

		ObservableList<LopHoc> list = FXCollections.observableArrayList(filtered);
        lopHocTable.setItems(list);
	}

	public void closeWindow() {
		stage.close();
	}
}
