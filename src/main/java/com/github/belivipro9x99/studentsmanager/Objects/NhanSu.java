package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;

public class NhanSu implements Serializable {
	private static final long serialVersionUID = 7093552118543864508L;

	private String ten;
	public NgayThang ngaySinh = new NgayThang();
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

	public String getSurname() {
		if (ten == null)
			return null;

		String[] part = ten.split(" ");
		String surname = "";

		for (int i = 0; i < part.length - 1; i++)
			surname += part[i] + ((i == part.length - 2) ? "" : " ");

		return surname;
	}

	public String getName() {
		if (ten == null)
			return null;
			
		String[] part = ten.split(" ");
		return part[part.length - 1];
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

	public Boolean getGioiTinhAsBool() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getNgaySinh() {
		return ngaySinh.toString();
	}

	public void setNgaySinh(NgayThang ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public Double tinhLuong() {
		return 0d;
	}

	@Override
	public String toString() {
		return ten;
	}
}
