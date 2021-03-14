package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;

public class KetQua implements Serializable {
    private static final long serialVersionUID = 665498274625279382L;

    public float diemCC, diemDK, diemHK;
    
    public KetQua() {
        diemCC = 0;
        diemDK = 0;
        diemHK = 0;
    }

    public KetQua(float diemCC,float diemDK,float diemHK) {
        this.diemCC = diemCC;
        this.diemDK = diemDK;
        this.diemHK = diemHK;
    }
     
    public float diemTB10() {
        return 0.1f * diemCC + 0.2f * diemDK + 0.7f * diemHK;
    }

    public float diemTB4() {
        return 0;
    }
}
