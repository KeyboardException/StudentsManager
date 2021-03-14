package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;

public class LopHoc implements Serializable {
    private static final long serialVersionUID = 7426763019335067858L;
    
    String maLop;
    String monHoc;
    int soTinChi;
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

    @Override
    public String toString(){
        return String.format("LopHoc[maLop=%s]", maLop);
    }
}
