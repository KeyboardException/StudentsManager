package com.github.belivipro9x99.studentsmanager.Objects;

import java.util.ArrayList;

public class SinhVien extends NhanSu {
    public String maSV, queQuan;
    public ArrayList<LopHoc> lophoc;
    public ArrayList<KetQua> ketqua;
    public int khoa;

    public SinhVien(){
        maSV = "";
        queQuan = "";
        khoa = 0;
    }
    public SinhVien( String maSV, String queQuan, int khoa){
        this.maSV = maSV;
        this.queQuan = queQuan;
        this.khoa = khoa;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
        "maSV=" + maSV +
        "queQuan=" + queQuan +
        "khoa=" + khoa +
        '}';
    }
}
