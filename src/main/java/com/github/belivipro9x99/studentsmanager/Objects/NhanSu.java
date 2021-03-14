package com.github.belivipro9x99.studentsmanager.Objects;

public class NhanSu {
	public String ten;
	public NgayThang ngaySinh;
	public Boolean gioiTinh = true;
	public String soDienThoai;
	public String email;

	public NhanSu() {}

	public NhanSu(String ten) {
		this.ten = ten;
		this.ngaySinh = new NgayThang();
	}

	@Override
	public String toString() {
		return String.format("NhanSu[ten=%s]");
	}
}
