package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;

public class Khoa implements Serializable {
	private static final long serialVersionUID = 6541209675058522106L;

	public String ten = "Trường Đại Học Mở Hà Nội";
	public String diaChi = "69 Định Công, Thanh Xuân, Hà Nội";
	public NhanSu truongKhoa;
	public NhanSu phoKhoa;

	public GiangVien[] giangVien;
	public SinhVien[] sinhVien;
	public PhongHoc[] phongHoc;

	@Override
	public String toString() {
		return String.format("Khoa[ten=%s]", ten);
	}
}
