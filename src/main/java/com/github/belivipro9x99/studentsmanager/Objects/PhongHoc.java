package com.github.belivipro9x99.studentsmanager.Objects;

public class PhongHoc {
    String soPhong;
    LopHoc[] lopHoc;


    @Override
    public String toString(){
        return String.format("SoPhong[soPhong=%s]", soPhong);
    }
}