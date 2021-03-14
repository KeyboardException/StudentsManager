package com.github.belivipro9x99.studentsmanager.Objects;

public class Khoa {
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
