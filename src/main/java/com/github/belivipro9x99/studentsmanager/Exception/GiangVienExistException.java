package com.github.belivipro9x99.studentsmanager.Exception;

import com.github.belivipro9x99.studentsmanager.Objects.GiangVien;

public class GiangVienExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public GiangVienExistException(GiangVien giangVien) {
		super("Đã tồn tại Giảng Viên: " + giangVien);
	}
}
