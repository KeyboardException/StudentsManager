package com.github.belivipro9x99.studentsmanager;

import com.github.belivipro9x99.studentsmanager.Objects.GiangVien;
import com.github.belivipro9x99.studentsmanager.Objects.KhoaController;
import com.github.belivipro9x99.studentsmanager.Objects.NgayThang;
import com.github.belivipro9x99.studentsmanager.Objects.SinhVien;

public class ConsoleApp {

	public static void main(String[] args) throws Exception {
		new KhoaController();

		KhoaController.addSinhVien(new SinhVien(
			"Nguyễn Văn Thụy",
			"20A428947298",
			new NgayThang(),
			true,
			"04374623874",
			"werwetgdqw@gmail.com",
			"Thái Bình",
			20
		));

		for (SinhVien sinhVien: KhoaController.getSinhVienList())
			System.out.println(sinhVien);

		for (GiangVien giangVien: KhoaController.getGiangVienList())
			System.out.println(giangVien);

		KhoaController.save();
	}
}
