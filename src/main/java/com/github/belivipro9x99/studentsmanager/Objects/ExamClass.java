package com.github.belivipro9x99.studentsmanager.Objects;

/**
 * Thiết Bị
 * @author	Belikhun
 */
public abstract class ExamClass {
	public String maLopHoc;
	public String ten;

	public ExamClass() {}

	/**
	 * @param maLopHoc
	 * @param ten
	 */
	public ExamClass(String maLopHoc, String ten) {
		this.maLopHoc = maLopHoc;
		this.ten = ten;
	}

	public Double giaTri() {
		return 0d;
	}
}
