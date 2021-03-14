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
        float d = diemTB10();
        if(d >= 8.5)
            {return 4.0f;}
        else if(d >= 8.0)
            {return 3.5f;}
        else if(d >= 7.0)
            {return 3.0;}
        else if(d >= 6.5)
            {return 2.5;}
        else if(d >= 5.5)
            {return 2.0;}
        else if(d >= 5.0)
            {return 1.5;}
        else if (d >= 4.0)
            {return 1.0;}
        else if(d <= 4.0)
        {return 0;}
    }
    public String xepLoai() 
    {
        float d = diemTB10();
        if(d >= 9.5)
            {return "A+";}
        else if(d >= 8.5)
            {return "A";}
        else if(d >= 8.0)
            {return "B+";}
        else if(d >= 7.0)
            {return "B";}
        else if(d >= 6.5)
            {return "C+";}
        else if(d >= 5.5)
            {return "C";}
        else if(d >= 5.0)
            {return "D+";}
        else if (d >= 4.0)
            {return "D";}

        return "F";
    }
}
