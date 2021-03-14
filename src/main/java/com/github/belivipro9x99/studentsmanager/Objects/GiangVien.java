package com.github.belivipro9x99.studentsmanager.Objects;

import java.util.ArrayList;

public class GiangVien extends NhanSu {
    private static final long serialVersionUID = 6492855057322778620L;
    
    public String maGV;
    public ArrayList<LopHoc> lophoc;
    public int trinhDoHocVan = 0;

    public GiangVien() {}

    public GiangVien(String maGV, int trinhDoHocVan) {
        this.maGV = maGV;
        this.trinhDoHocVan = trinhDoHocVan;
    }

    public String gettrinhDoHocVan() {
        return new String[] {
            "Thạc Sĩ",
            "Tiến Sĩ",
            "Phó Giáo Sư",
            "Giáo Sư",
        }[trinhDoHocVan];
    }
    
    @Override
    public String toString() {
        return String.format("GiangVien(%s)[maGV=%s]", super.toString(), maGV);
    }
}
