package com.github.belivipro9x99.studentsmanager.Objects;

import java.util.ArrayList;

public class SinhVien extends NhanSu {
    private static final long serialVersionUID = 7932796623774919940L;
    
    private String maSV;
    private String queQuan;
    private int khoa;

    public ArrayList<KetQua> ketQua = new ArrayList<KetQua>();

    public SinhVien(String maSV) {
        super();
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

    public KetQua getKetQua(String maLop) {
        if (ketQua == null)
            ketQua = new ArrayList<KetQua>();

        for (KetQua item : ketQua)
            if (item.getMaLop() == maLop)
                return item;

        // KetQua not found. So we init a new KetQua and return it
        KetQua newKQ = new KetQua(maLop);
        ketQua.add(newKQ);
        return newKQ;
    }

    public void setKetQua(String maLop, KetQua newKQ) {
        for (KetQua item : ketQua)
            if (item.getMaLop() == maLop) {
                item = newKQ;
                break;
            }
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", super.toString(), maSV);
    }
}
