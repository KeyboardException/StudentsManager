package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;

/**
 * Thiết Bị
 * @author	Belikhun
 */
public abstract class ExamClass implements Serializable {
	public String phongHoc;
	public String hangSX;

	/**
	 * @return the hangSX
	 */
	public String getHangSX() {
		return hangSX;
	}

	/**
	 * @param hangSX the hangSX to set
	 */
	public void setHangSX(String hangSX) {
		this.hangSX = hangSX;
	}

	public ExamClass() {}

	/**
	 * @param phongHoc
	 * @param hangSX
	 */
	public ExamClass(String phongHoc, String hangSX) {
		this.phongHoc = phongHoc;
		this.hangSX = hangSX;
	}

	/**
	 * @return the phongHoc
	 */
	public String getPhongHoc() {
		return phongHoc;
	}

	/**
	 * @param phongHoc the phongHoc to set
	 */
	public void setPhongHoc(String phongHoc) {
		this.phongHoc = phongHoc;
	}

	public Double giaTri() {
		return 0d;
	}
}
