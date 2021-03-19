package com.github.belivipro9x99.studentsmanager.Objects;

import java.util.ArrayList;

public class SinhVien extends NhanSu {
    private static final long serialVersionUID = 7932796623774919940L;
    
    private String maSV;
    private String queQuan;
    public ArrayList<LopHoc> lopHoc = new ArrayList<LopHoc>();
    public ArrayList<KetQua> ketQua = new ArrayList<KetQua>();
    private int khoa;

    public SinhVien(String maSV) {
        this.maSV = maSV;
    }

    public SinhVien(String ten, String maSV) {
        super(ten);
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
        String maSV,
		NgayThang ngaySinh,
		Boolean gioiTinh,
		String soDienThoai,
		String email,
        String queQuan,
        int khoa
    ) {
        super(ten, ngaySinh, gioiTinh, soDienThoai, email);
        this.maSV = maSV;
        this.queQuan = queQuan;
        this.khoa = khoa;
    }

    public String getMaSV() {
        return maSV;
    }
    
    public String getQueQuan() {
        return queQuan;
    }

    public int getKhoa() {
        return khoa;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }

    @Override
    public String toString() {
        return String.format("SinhVien(%s)[maSV=%s]", super.toString(), maSV);
    }
}
