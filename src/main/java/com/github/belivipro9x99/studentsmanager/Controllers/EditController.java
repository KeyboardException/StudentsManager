package com.github.belivipro9x99.studentsmanager.Controllers;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.time.ZoneId;

import com.github.belivipro9x99.studentsmanager.App;
import com.github.belivipro9x99.studentsmanager.Components.OSCButton;
import com.github.belivipro9x99.studentsmanager.Libs.Belibrary;
import com.github.belivipro9x99.studentsmanager.Objects.GiangVien;
import com.github.belivipro9x99.studentsmanager.Objects.KetQua;
import com.github.belivipro9x99.studentsmanager.Objects.NgayThang;
import com.github.belivipro9x99.studentsmanager.Objects.NhanSu;
import com.github.belivipro9x99.studentsmanager.Objects.SinhVien;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditController implements Initializable {
	@FXML
	private Stage stage;
	private NhanSu nhanSu;

	public Label mainTitle;
	public Label subTitle;

	public String userAction = "none";

	public OSCButton deleteButton;
	public OSCButton cancelButton;

	// Default Fields
	public TextField nameInput;
	public DatePicker dobInput;
	public RadioButton maleButton;
	public RadioButton femaleButton;
	public TextField phoneInput;
	public TextField emailInput;

	// SinhVien
	public VBox sinhVienBox;
	public TextField homeInput;
	public TextField khoaInput;

	// SinhVienKetQua
	public VBox sinhVienKetQuaBox;
	public Label sinhVienKetQuaLabel;
	public TextField diemCCInput;
	public TextField diemDKInput;
	public TextField diemHKInput;

	// GiangVien
	public VBox giangVienBox;
	public RadioButton tdThSButton;
	public RadioButton tdTSButton;
	public RadioButton tdPGSButton;
	public RadioButton tdGSButton;


	@Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading " + this.getClass().getName());
    }

	public void setNhanSu(NhanSu nhanSu) {
		this.nhanSu = nhanSu;
		System.out.println("Got " + nhanSu);

		// Ẩn tất cả các Box để đoạn sau kiểm tra và hiện lại
		// Box cần dùng
		Belibrary.hide(sinhVienKetQuaBox);
		Belibrary.hide(sinhVienBox);
		Belibrary.hide(giangVienBox);

		if (nhanSu instanceof SinhVien)
			// Nếu là sinh viên, hiện sinhVienBox
			Belibrary.show(sinhVienBox);
		else if (nhanSu instanceof GiangVien)
			// Nếu là giảng viên, hiện giangVienBox
			Belibrary.show(giangVienBox);

		updateHeader();
		updateInputValue();
		attachListeners();
	}

	public void updateHeader() {
		if (nhanSu instanceof SinhVien) {
			SinhVien sinhVien = (SinhVien) nhanSu;
			mainTitle.setText("Chỉnh Sửa Thông Tin Sinh Viên");
			subTitle.setText("Sinh Viên " + sinhVien.getTen() + ". Mã SV: " + sinhVien.getMaSV());
		} else if (nhanSu instanceof GiangVien) {
			GiangVien giangVien = (GiangVien) nhanSu;
			mainTitle.setText("Chỉnh Sửa Thông Tin Giảng Viên");
			subTitle.setText("Giảng Viên " + giangVien.getTen() + ". Mã GV: " + giangVien.getMaGV());
		} else {
			mainTitle.setText("Chỉnh Sửa Thông Tin Nhân Sự");
			subTitle.setText(nhanSu.getClass().getSimpleName());
		}
	}

	public void updateInputValue() {
		nameInput.setText(nhanSu.getTen());
		dobInput.setValue(LocalDate.ofInstant(nhanSu.ngaySinh.getDate().toInstant(), ZoneId.systemDefault()));

		if (nhanSu.getGioiTinhAsBool())
			maleButton.setSelected(true);
		else
			femaleButton.setSelected(true);

		phoneInput.setText(nhanSu.getSoDienThoai());
		emailInput.setText(nhanSu.getEmail());

		if (nhanSu instanceof SinhVien) {
			SinhVien sinhVien = (SinhVien) nhanSu;

			homeInput.setText(sinhVien.getQueQuan());
			khoaInput.setText(String.valueOf(sinhVien.getKhoa()));
		} else if (nhanSu instanceof GiangVien) {
			GiangVien giangVien = (GiangVien) nhanSu;

			switch (giangVien.trinhDoHocVan) {
				case 0:
					tdThSButton.setSelected(true);
					break;

				case 1:
					tdTSButton.setSelected(true);
					break;

				case 2:
					tdPGSButton.setSelected(true);
					break;

				case 3:
					tdGSButton.setSelected(true);
					break;
			
				default:
					break;
			}
		}
	}

	public void attachListeners() {
		nameInput.setOnKeyTyped(e -> {
			nhanSu.setTen(nameInput.getText());
			updateHeader();
		});

		dobInput.valueProperty().addListener((ov, oldValue, newValue) -> {
			LocalDate localDate = dobInput.getValue();
			Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
			Date date = Date.from(instant);
			nhanSu.setNgaySinh(new NgayThang(date));
		});

		maleButton.setOnMouseClicked(e -> {
			nhanSu.setGioiTinh(maleButton.isSelected());
		});

		femaleButton.setOnMouseClicked(e -> {
			nhanSu.setGioiTinh(maleButton.isSelected());
		});

		phoneInput.setOnKeyTyped(e -> {
			String value = phoneInput.getText();
			String sVal = Belibrary.sanitizeNumber(value);

			if (value != sVal)
				phoneInput.setText(sVal);

			nhanSu.setSoDienThoai(sVal);
		});

		emailInput.setOnKeyTyped(e -> { nhanSu.setEmail(emailInput.getText()); });

		if (nhanSu instanceof SinhVien) {
			SinhVien sinhVien = (SinhVien) nhanSu;

			homeInput.setOnKeyTyped(e -> { sinhVien.setQueQuan(homeInput.getText()); });

			khoaInput.setOnKeyTyped(e -> {
				String value = khoaInput.getText();
				String sVal = Belibrary.sanitizeNumber(value);

				if (value != sVal)
					khoaInput.setText(sVal);

				sinhVien.setKhoa(Integer.parseInt(sVal));
			});
		} else if (nhanSu instanceof GiangVien) {
			GiangVien giangVien = (GiangVien) nhanSu;

			tdThSButton.setOnMouseClicked(e -> { giangVien.setTrinhDoHocVan(0); });
			tdTSButton.setOnMouseClicked(e -> { giangVien.setTrinhDoHocVan(1); });
			tdPGSButton.setOnMouseClicked(e -> { giangVien.setTrinhDoHocVan(2); });
			tdGSButton.setOnMouseClicked(e -> { giangVien.setTrinhDoHocVan(3); });
		}
	}

	public void setStage(Stage stage) {
		this.stage = stage;
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
		String action;

		if (nhanSu instanceof SinhVien) {
			SinhVien sinhVien = (SinhVien) nhanSu;
			action = App.deleteConfirmation("Bạn Có Chắc Muốn Xóa Sinh Viên \"" + sinhVien.getMaSV() + "\" Không?");
		} else if (nhanSu instanceof GiangVien) {
			GiangVien giangVien = (GiangVien) nhanSu;
			action = App.deleteConfirmation("Bạn Có Chắc Muốn Xóa Giảng Viên \"" + giangVien.getMaGV() + "\" Không?");
		} else {
			action = App.deleteConfirmation("Bạn Có Chắc Muốn Xóa Nhân Sự \"" + nhanSu.getTen() + "\" Không?");
		}

		if (action == "delete") {
			this.userAction = "delete";
			this.closeWindow();
		}
	}

	public void closeWindow() {
		stage.close();
	}

	public void setEditKetQua(KetQua ketQua) {
		if (!(nhanSu instanceof SinhVien))
			return;

		Belibrary.show(sinhVienKetQuaBox);
		sinhVienKetQuaLabel.setText("CHỈNH SỬA ĐIỂM CỦA LỚP " + ketQua.getMaLop());
		diemCCInput.setText(String.valueOf(ketQua.diemCC));
		diemDKInput.setText(String.valueOf(ketQua.diemDK));
		diemHKInput.setText(String.valueOf(ketQua.diemHK));

		diemCCInput.setOnKeyTyped(e -> {
			String value = diemCCInput.getText();
			String sVal = Belibrary.sanitizeDouble(value);

			if (value != sVal)
				diemCCInput.setText(sVal);

			ketQua.setDiemCC(Double.parseDouble(sVal));
		});

		diemDKInput.setOnKeyTyped(e -> {
			String value = diemDKInput.getText();
			String sVal = Belibrary.sanitizeDouble(value);

			if (value != sVal)
				diemDKInput.setText(sVal);

			ketQua.setDiemDK(Double.parseDouble(sVal));
		});

		diemHKInput.setOnKeyTyped(e -> {
			String value = diemHKInput.getText();
			String sVal = Belibrary.sanitizeDouble(value);

			if (value != sVal)
				diemHKInput.setText(sVal);

			ketQua.setDiemHK(Double.parseDouble(sVal));
		});
	}
}
