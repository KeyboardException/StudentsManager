package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;

public class LopHoc implements Serializable {
    private static final long serialVersionUID = 7426763019335067858L;
    
    private String maLop;
    private String monHoc;
    private int soTinChi;
    NgayThang thoiGian;
    PhongHoc phongHoc;
    SinhVien[] sinhVien;
    GiangVien giangVien;
    int trangThai;

    public String getTrangThai(){
        return new String[] {
            "Học",
            "Học online",
            "Nghỉ"
        }[trangThai];
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }
    
    @Override
    public String toString(){
        return String.format("LopHoc[maLop=%s]", maLop);
    }
}
