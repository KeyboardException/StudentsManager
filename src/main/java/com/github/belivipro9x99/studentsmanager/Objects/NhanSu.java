package com.github.belivipro9x99.studentsmanager.Objects;

public class NhanSu {
	public String ten;
	public NgayThang ngaySinh;
	public Boolean gioiTinh;
	public String soDienThoai;
	public String email;

	public NhanSu() {}

	@Override
	public String toString() {
		return String.format("NhanSu[ten=%s]");
	}
}
