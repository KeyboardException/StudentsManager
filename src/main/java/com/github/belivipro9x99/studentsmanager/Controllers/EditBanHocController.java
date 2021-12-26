package com.github.belivipro9x99.studentsmanager.Controllers;

import com.github.belivipro9x99.studentsmanager.App;
import com.github.belivipro9x99.studentsmanager.Components.OSCButton;
import com.github.belivipro9x99.studentsmanager.Libs.Belibrary;
import com.github.belivipro9x99.studentsmanager.Objects.BanHoc;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditBanHocController {
	private BanHoc banHoc;
	private Stage stage;

	public String userAction = "cancel";

	public TextField phongHocInput;
	public TextField hangSXInput;
	public TextField donGiaInput;
	public TextField soLuongInput;
	public TextField chieuDaiInput;
	public TextField chieuRongInput;

	public OSCButton cancelButton;
	public OSCButton deleteButton;

	public void setBanHoc(BanHoc banHoc) {
		this.banHoc = banHoc;

		updateInputValue();
		attachListeners();
	}

	public void updateInputValue() {
		phongHocInput.setText(banHoc.getPhongHoc());
		hangSXInput.setText(banHoc.getHangSX());
		donGiaInput.setText(String.valueOf(banHoc.getDonGia()));
		soLuongInput.setText(String.valueOf(banHoc.getSoLuong()));
		chieuDaiInput.setText(String.valueOf(banHoc.getChieuDai()));
		chieuRongInput.setText(String.valueOf(banHoc.getChieuRong()));
	}

	public void attachListeners() {
		phongHocInput.setOnKeyTyped(e -> {
			banHoc.setPhongHoc(phongHocInput.getText());
		});

		hangSXInput.setOnKeyTyped(e -> {
			banHoc.setHangSX(hangSXInput.getText());
		});

		// Số lượng là một số nguyên, lọc các chữ cái ra khỏi
		// input bằng hàm Belibrary.sanitizeNumber và chuyển về dạng `int`
		soLuongInput.setOnKeyTyped(e -> {
			// Lấy giá trị của input
			String value = soLuongInput.getText();

			// Lấy chuỗi kí tự khi lọc bỏ kí tự không
			// mong muốn
			String sVal = Belibrary.sanitizeNumber(value);

			// Nếu chuỗi đã được lọc khác với giá trị input,
			// update input thành chuỗi đã lọc
			if (value != sVal)
				soLuongInput.setText(sVal);

			// Chuyển chuỗi đã lọc về int và update giá trị
			// của banHoc
			if (sVal.length() > 0)
				banHoc.setSoLuong(Integer.parseInt(sVal));
		});

		// Đơn giá là một số thực, lọc các chữ cái ra khỏi
		// input bằng hàm Belibrary.sanitizeDouble và chuyển về dạng `Double`
		donGiaInput.setOnKeyTyped(e -> {
			String value = donGiaInput.getText();
			String sVal = Belibrary.sanitizeDouble(value);

			if (value != sVal)
				donGiaInput.setText(sVal);

			if (sVal.length() > 0)
				banHoc.setDonGia(Double.parseDouble(sVal));
		});

		// Chiều dài là một số thực, lọc các chữ cái ra khỏi
		// input bằng hàm Belibrary.sanitizeDouble và chuyển về dạng `Double`
		chieuDaiInput.setOnKeyTyped(e -> {
			String value = chieuDaiInput.getText();
			String sVal = Belibrary.sanitizeDouble(value);

			if (value != sVal)
				chieuDaiInput.setText(sVal);

			if (sVal.length() > 0)
				banHoc.setChieuDai(Double.parseDouble(sVal));
		});

		chieuRongInput.setOnKeyTyped(e -> {
			String value = chieuRongInput.getText();
			String sVal = Belibrary.sanitizeDouble(value);

			if (value != sVal)
				chieuRongInput.setText(sVal);

			if (sVal.length() > 0)
				banHoc.setChieuRong(Double.parseDouble(sVal));
		});
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
		String action = App.deleteConfirmation("Bạn Có Chắc Muốn Xóa Bàn Học Này Không?");

		if (action == "delete") {
			this.userAction = "delete";
			this.closeWindow();
		}
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void closeWindow() {
		this.stage.close();
	}
}
