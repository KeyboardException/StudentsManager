package com.github.belivipro9x99.studentsmanager.Objects;

import java.util.ArrayList;

public class GiangVien extends NhanSu {
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
            "Giáo SƯ",
        }[trinhDoHocVan];
    }
    
    @Override
    public String toString() {
        return "GiangVien{" +
                "maGV=" + maGV +
                "trinhDoHocVan=" + trinhDoHocVan +
                '}';
    }
}

