package com.github.belivipro9x99.studentsmanager.Exception;

import com.github.belivipro9x99.studentsmanager.Objects.SinhVien;

public class SinhVienExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public SinhVienExistException(SinhVien sinhVien) {
		super("Đã tồn tại Sinh Viên: " + sinhVien);
	}
}
