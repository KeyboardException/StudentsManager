package com.github.belivipro9x99.studentsmanager.Objects;

import com.github.belivipro9x99.studentsmanager.Interfaces.IExamInterface;

public class BanHoc extends ExamClass implements IExamInterface {
	public Double donGia = 250000d;

	public int soLuong;
	public Double chieuDai;
	public Double chieuRong;

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

	/**
	 * @return the soLuong
	 */
	public int getSoLuong() {
		return soLuong;
	}

	/**
	 * @param soLuong the soLuong to set
	 */
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	/**
	 * @return the chieuDai
	 */
	public Double getChieuDai() {
		return chieuDai;
	}

	/**
	 * @param chieuDai the chieuDai to set
	 */
	public void setChieuDai(Double chieuDai) {
		this.chieuDai = chieuDai;
	}

	/**
	 * @return the chieuRong
	 */
	public Double getChieuRong() {
		return chieuRong;
	}

	/**
	 * @param chieuRong the chieuRong to set
	 */
	public void setChieuRong(Double chieuRong) {
		this.chieuRong = chieuRong;
	}

	public BanHoc() {}

	/**
	 * @param phongHoc
	 * @param hangSX
	 * @param soLuong
	 * @param chieuDai
	 * @param chieuRong
	 */
	public BanHoc(String phongHoc, String hangSX, int soLuong, Double chieuDai, Double chieuRong) {
		super(phongHoc, hangSX);
		this.soLuong = soLuong;
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	public Double getGiaTri() {
		return soLuong * donGia;
	}

	@Override
	public Double getDienTich() {
		return chieuDai * chieuRong;
	}

	@Override
	public String getKichThuoc() {
		return String.format("%.3fx%.3f", this.chieuDai, this.chieuRong);
	}
}
