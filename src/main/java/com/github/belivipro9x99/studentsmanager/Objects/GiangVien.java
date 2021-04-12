package com.github.belivipro9x99.studentsmanager.Objects;

public class GiangVien extends NhanSu {
    private static final long serialVersionUID = 6492855057322778620L;

    public String maGV;
    public int trinhDoHocVan = 0;

    public GiangVien(String maGV) {
        super();
        this.maGV = maGV;
    }

    public GiangVien(String ten, String maGV) {
        super(ten);
        this.maGV = maGV;
    }

    public GiangVien(String ten, String maGV, int trinhDoHocVan) {
        super(ten);
        this.maGV = maGV;
        this.trinhDoHocVan = trinhDoHocVan;
    }

    public GiangVien(
        String ten,
        String maGV,
		NgayThang ngaySinh,
		Boolean gioiTinh,
		String soDienThoai,
		String email,
        int trinhDoHocVan
    ) {
        super(ten, ngaySinh, gioiTinh, soDienThoai, email);
        this.maGV = maGV;
        this.trinhDoHocVan = trinhDoHocVan;
    }

    public String getTrinhDoHocVan() {
        return new String[] {
            "Thạc Sĩ",
            "Tiến Sĩ",
            "Phó Giáo Sư",
            "Giáo Sư",
        }[trinhDoHocVan];
    }

    public void setTrinhDoHocVan(int trinhDoHocVan) {
        this.trinhDoHocVan = trinhDoHocVan;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", super.toString(), maGV);
    }
}
