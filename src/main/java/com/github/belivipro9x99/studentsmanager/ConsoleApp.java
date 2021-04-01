package com.github.belivipro9x99.studentsmanager;

import com.github.belivipro9x99.studentsmanager.Objects.GiangVien;
import com.github.belivipro9x99.studentsmanager.Objects.KhoaController;
import com.github.belivipro9x99.studentsmanager.Objects.NgayThang;
import com.github.belivipro9x99.studentsmanager.Objects.SinhVien;

public class ConsoleApp {

	public static void main(String[] args) throws Exception {
		new KhoaController();

		KhoaController.addGiangVien(new GiangVien(
			"Trịnh Thị Xuân",
			"GV14",
			new NgayThang(),
			false,
			"0315239335",
			"trinhxuan@hou.edu.vn",
			2
		));

		for (SinhVien sinhVien: KhoaController.getSinhVienList())
			System.out.println(sinhVien);

		for (GiangVien giangVien: KhoaController.getGiangVienList())
			System.out.println(giangVien);

		KhoaController.save();
	}
}
