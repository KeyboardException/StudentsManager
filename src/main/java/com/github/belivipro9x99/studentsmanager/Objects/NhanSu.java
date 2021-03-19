package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;

public class NhanSu implements Serializable {
	private static final long serialVersionUID = 7093552118543864508L;

	private String ten;
	public NgayThang ngaySinh;
	private Boolean gioiTinh = true;
	private String soDienThoai;
	private String email;

	public NhanSu() {}

	public NhanSu(String ten) {
		this.ten = ten;
	}

	public NhanSu(
		String ten,
		NgayThang ngaySinh,
		Boolean gioiTinh,
		String soDienThoai,
		String email
	) {
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGioiTinh() {
		return gioiTinh
			? "Nam"
			: "Nữ";
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@Override
	public String toString() {
		return String.format("NhanSu[ten=%s]", ten);
	}
}
