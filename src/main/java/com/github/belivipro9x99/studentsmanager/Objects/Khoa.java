package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Khoa implements Serializable {
	private static final long serialVersionUID = 6541209675058522106L;

	public String ten = "Trường ĐH Mở Hà Nội - Khoa CNTT";
	public String diaChi = "69 Định Công, Thanh Xuân, Hà Nội";
	public NhanSu truongKhoa;
	public NhanSu phoKhoa;

	public ArrayList<GiangVien> giangVien = new ArrayList<GiangVien>();
	public ArrayList<SinhVien> sinhVien = new ArrayList<SinhVien>();
	public ArrayList<LopHoc> lopHoc = new ArrayList<LopHoc>();

	public ArrayList<BanHoc> banHoc = new ArrayList<BanHoc>();
	public ArrayList<MayChieu> mayChieu = new ArrayList<MayChieu>();

	public Khoa() {}

	@Override
	public String toString() {
		return String.format("Khoa[ten=%s]", ten);
	}
}
