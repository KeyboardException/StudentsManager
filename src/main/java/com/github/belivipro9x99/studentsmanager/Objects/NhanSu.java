package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;

public class NhanSu implements Serializable {
	private static final long serialVersionUID = 7093552118543864508L;

	public String ten;
	public NgayThang ngaySinh;
	public Boolean gioiTinh = true;
	public String soDienThoai;
	public String email;

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

	@Override
	public String toString() {
		return String.format("NhanSu[ten=%s]", ten);
	}
}
