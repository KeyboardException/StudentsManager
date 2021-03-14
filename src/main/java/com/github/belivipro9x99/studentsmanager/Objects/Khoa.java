package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Khoa implements Serializable {
	private static final long serialVersionUID = 6541209675058522106L;

	public String ten = "Trường Đại Học Mở Hà Nội";
	public String diaChi = "69 Định Công, Thanh Xuân, Hà Nội";
	public NhanSu truongKhoa;
	public NhanSu phoKhoa;

	public ArrayList<GiangVien> giangVien = new ArrayList<GiangVien>();
	public ArrayList<SinhVien> sinhVien = new ArrayList<SinhVien>();
	public ArrayList<PhongHoc> phongHoc = new ArrayList<PhongHoc>();

	public Khoa() {}

	@Override
	public String toString() {
		return String.format("Khoa[ten=%s]", ten);
	}
}
