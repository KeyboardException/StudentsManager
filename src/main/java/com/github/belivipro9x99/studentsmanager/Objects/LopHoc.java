package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;
import java.util.ArrayList;

public class LopHoc implements Serializable {
    private static final long serialVersionUID = 7426763019335067858L;
    
    public String maLop;
    private String monHoc;
    private int soTinChi;
    private String phongHoc;
    public ArrayList<String> maSV = new ArrayList<String>();
    public GiangVien giangVien;
    public int trangThai;

    public LopHoc(String maLop) {
        this.maLop = maLop;
    }

    public String getTrangThai() {
        return new String[] {
            "Học",
            "Học Trực Tuyến",
            "Nghỉ"
        }[trangThai];
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
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

    /**
     * @return the phongHoc
     */
    public String getPhongHoc() {
        return phongHoc;
    }

    /**
     * @param phongHoc the phongHoc to set
     */
    public void setPhongHoc(String phongHoc) {
        this.phongHoc = phongHoc;
    }

    /**
     * @return the giangVien
     */
    public GiangVien getGiangVien() {
        return giangVien;
    }

    /**
     * @param giangVien the giangVien to set
     */
    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }
}
