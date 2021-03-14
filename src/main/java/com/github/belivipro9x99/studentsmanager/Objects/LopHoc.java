package com.github.belivipro9x99.studentsmanager.Objects;

public class LopHoc {
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

