package com.github.belivipro9x99.studentsmanager.Objects;

import java.util.ArrayList;

public class SinhVien extends NhanSu {
    private static final long serialVersionUID = 7932796623774919940L;
    
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
        return String.format("SinhVien(%s)[maSV=%s]", super.toString(), maSV);
    }
}
