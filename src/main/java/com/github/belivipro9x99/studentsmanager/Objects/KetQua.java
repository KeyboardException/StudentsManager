package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;

public class KetQua implements Serializable {
    private static final long serialVersionUID = 665498274625279382L;

    private String maLop;
    public Double diemCC = 0d, diemDK = 0d, diemHK = 0d;
    
    public KetQua(String maLop) {
        this.maLop = maLop;
    }

    public KetQua(String maLop, Double diemCC, Double diemDK, Double diemHK) 
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

    public Double getDiemCC() {
        return diemCC;
    }
     
    public void setDiemCC(Double diemCC) {
        this.diemCC = diemCC;
    }

    public Double getDiemDK() {
        return diemDK;
    }

    public void setDiemDK(Double diemDK) {
        this.diemDK = diemDK;
    }

    public Double getDiemHK() {
        return diemHK;
    }

    public void setDiemHK(Double diemHK) {
        this.diemHK = diemHK;
    }

    public Double diemHS10() {
        return 0.1f * diemCC + 0.2f * diemDK + 0.7f * diemHK;
    }

    public Double diemHS4() {
        Double d = diemHS10();

        if (d >= 8.5)
            return 4.0d;
        else if (d >= 8.0)
            return 3.5d;
        else if (d >= 7.0)
            return 3.0d;
        else if (d >= 6.5)
            return 2.5d;
        else if (d >= 5.5)
            return 2.0d;
        else if (d >= 5.0)
            return 1.5d;
        else if (d >= 4.0)
            return 1.0d;

        return 0d;
    }

    public String xepLoai() {
        Double d = diemHS10();

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
