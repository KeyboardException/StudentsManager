package com.github.belivipro9x99.studentsmanager.Objects;

import java.util.ArrayList;

public class SinhVien extends NhanSu {
    private static final long serialVersionUID = 7932796623774919940L;
    
    public String maSV;
    public String queQuan;
    public ArrayList<LopHoc> lophoc;
    public ArrayList<KetQua> ketqua;
    public int khoa;

    public SinhVien() {}

    public SinhVien(String ten, String maSV) {
        this.ten = ten;
        this.maSV = maSV;
    }

    public SinhVien(String ten, String maSV, String queQuan, int khoa) {
        super(ten);
        this.maSV = maSV;
        this.queQuan = queQuan;
        this.khoa = khoa;
    }

    public SinhVien(
        String ten,
		NgayThang ngaySinh,
		Boolean gioiTinh,
		String soDienThoai,
		String email,
        String maSV,
        String queQuan,
        int khoa
    ) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.maSV = maSV;
        this.queQuan = queQuan;
        this.khoa = khoa;
    }

    @Override
    public String toString() {
        return String.format("SinhVien(%s)[maSV=%s]", super.toString(), maSV);
    }
}
