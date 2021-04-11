package com.github.belivipro9x99.studentsmanager.Exception;

import com.github.belivipro9x99.studentsmanager.Objects.LopHoc;

public class LopHocExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public LopHocExistException(LopHoc lopHoc) {
		super("Đã tồn tại Lớp Học: " + lopHoc);
	}
}
