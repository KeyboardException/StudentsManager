package com.github.belivipro9x99.studentsmanager.Objects;

import com.github.belivipro9x99.studentsmanager.Interfaces.IExamInterface;

public class BanHoc extends ExamClass implements IExamInterface {
	public Double donGia = 250000d;

	public int soLuong;
	public Double chieuDai;
	public Double chieuRong;

	public BanHoc() {}

	/**
	 * @param maLopHoc
	 * @param ten
	 * @param soLuong
	 * @param chieuDai
	 * @param chieuRong
	 */
	public BanHoc(String maLopHoc, String ten, int soLuong, Double chieuDai, Double chieuRong) {
		super(maLopHoc, ten);
		this.soLuong = soLuong;
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	public Double giaTri() {
		return soLuong * donGia;
	}

	@Override
	public Double dienTich() {
		return chieuDai * chieuRong;
	}

	@Override
	public String kichThuoc() {
		return String.format("%.3fx%.3f", this.chieuDai, this.chieuRong);
	}
}
