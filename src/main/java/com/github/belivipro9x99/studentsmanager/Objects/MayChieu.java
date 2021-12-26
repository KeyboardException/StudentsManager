package com.github.belivipro9x99.studentsmanager.Objects;

public class MayChieu extends ExamClass {
	public Double donGia;

	public MayChieu() {}

	/**
	 * @param phongHoc
	 * @param hangSX
	 * @param donGia
	 */
	public MayChieu(String phongHoc, String hangSX, Double donGia) {
		super(phongHoc, hangSX);
		this.donGia = donGia;
	}

	/**
	 * @return the donGia
	 */
	public Double getDonGia() {
		return donGia;
	}

	/**
	 * @param donGia the donGia to set
	 */
	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}
}
