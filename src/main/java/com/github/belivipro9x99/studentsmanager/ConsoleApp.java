package com.github.belivipro9x99.studentsmanager;

import java.io.File;

import com.github.belivipro9x99.studentsmanager.Objects.GiangVien;
import com.github.belivipro9x99.studentsmanager.Objects.KhoaController;
import com.github.belivipro9x99.studentsmanager.Objects.SinhVien;

public class ConsoleApp {

	public static void main(String[] args) throws Exception {
		new KhoaController();

		KhoaController.addSinhVien(new SinhVien("Vu Tuan Dat", "20A234524141"));

		for (SinhVien sinhVien: KhoaController.getSinhVienList())
			System.out.println(sinhVien);

		for (GiangVien giangVien: KhoaController.getGiangVienList())
			System.out.println(giangVien);

		KhoaController.save();
	}
}
