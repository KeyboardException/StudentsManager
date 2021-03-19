package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;

public class KetQua implements Serializable {
    private static final long serialVersionUID = 665498274625279382L;

    private String maLop;
    public float diemCC, diemDK, diemHK;
    
    public KetQua(String maLop) {
        this.maLop = maLop;
    }

    public KetQua(String maLop, float diemCC, float diemDK, float diemHK) 
    {
        this.maLop = maLop;
        this.diemCC = diemCC;
        this.diemDK = diemDK;
        this.diemHK = diemHK;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public float getDiemCC() {
        return diemCC;
    }
     
    public void setDiemCC(float diemCC) {
        this.diemCC = diemCC;
    }

    public float getDiemDK() {
        return diemDK;
    }

    public void setDiemDK(float diemDK) {
        this.diemDK = diemDK;
    }

    public float getDiemHK() {
        return diemHK;
    }

    public void setDiemHK(float diemHK) {
        this.diemHK = diemHK;
    }

    public float diemHS10() {
        return 0.1f * diemCC + 0.2f * diemDK + 0.7f * diemHK;
    }

    public float diemHS4() {
        float d = diemHS10();

        if (d >= 8.5)
            return 4.0f;
        else if (d >= 8.0)
            return 3.5f;
        else if (d >= 7.0)
            return 3.0f;
        else if (d >= 6.5)
            return 2.5f;
        else if (d >= 5.5)
            return 2.0f;
        else if (d >= 5.0)
            return 1.5f;
        else if (d >= 4.0)
            return 1.0f;

        return 0f;
    }

    public String xepLoai() {
        float d = diemHS10();

        if (d >= 9.5)
            return "A+";
        else if (d >= 8.5)
            return "A";
        else if (d >= 8.0)
            return "B+";
        else if (d >= 7.0)
            return "B";
        else if (d >= 6.5)
            return "C+";
        else if (d >= 5.5)
            return "C";
        else if (d >= 5.0)
            return "D+";
        else if (d >= 4.0)
            return "D";

        return "F";
    }
}
