package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.github.belivipro9x99.studentsmanager.Exception.ExceptionHandler;
import com.github.belivipro9x99.studentsmanager.Exception.GiangVienExistException;
import com.github.belivipro9x99.studentsmanager.Exception.LopHocExistException;
import com.github.belivipro9x99.studentsmanager.Exception.SinhVienExistException;

public class KhoaController {
	public static Khoa khoa = new Khoa();
	public static String filePath = "data.dat";
	public static File dataFile = new File(filePath);

	public KhoaController() throws FileNotFoundException, IOException, ClassNotFoundException {
		if (!dataFile.exists()) {
			khoa = new Khoa();
			KhoaController.save();
		} else
			KhoaController.load();
	}

	//* ======================= CÁC HÀM PROCESS SINH VIÊN =======================
	public static void addSinhVien(SinhVien sinhVien) throws SinhVienExistException {
		for (SinhVien item: getSinhVienList())
			if (item.getMaSV().equals(sinhVien.getMaSV()))
				throw new SinhVienExistException(item);

		khoa.sinhVien.add(sinhVien);
		safeSave();
	}

	public static ArrayList<SinhVien> getSinhVienList() {
		return khoa.sinhVien;
	}

	public static ArrayList<SinhVien> getSinhVienList(String query) {
		if (query == null || query.length() == 0 || query == "")
			return getSinhVienList();

		String[] tokens = query.toLowerCase().split(" ");
		ArrayList<SinhVien> filtered = new ArrayList<SinhVien>();

		for (SinhVien item : khoa.sinhVien) {
			Boolean valid = false;

			for (String token : tokens)
				if (
						item.getMaSV().toLowerCase().contains(token)
					||	item.getTen().toLowerCase().contains(token)
					||	item.getEmail().toLowerCase().contains(token)
					||	item.getSoDienThoai().contains(token)
					||	String.valueOf(item.getKhoa()).contains(token)
				) {
					valid = true;
				} else {
					valid = false;
					break;
				}

			if (valid)
				filtered.add(item);
		}

		return filtered;
	}

	public static void removeSinhVien(SinhVien sinhVien) {
		khoa.sinhVien.remove(sinhVien);
		safeSave();
	}
	
	//* ======================= CÁC HÀM PROCESS GIẢNG VIÊN =======================
	public static void addGiangVien(GiangVien giangVien) throws GiangVienExistException {
		for (GiangVien item: getGiangVienList())
			if (item.maGV.equals(giangVien.maGV))
				throw new GiangVienExistException(item);

		khoa.giangVien.add(giangVien);
		safeSave();
	}

	public static ArrayList<GiangVien> getGiangVienList() {
		return khoa.giangVien;
	}

	public static ArrayList<GiangVien> getGiangVienList(String query) {
		if (query == null || query.length() == 0 || query == "")
			return getGiangVienList();

		String[] tokens = query.toLowerCase().split(" ");
		ArrayList<GiangVien> filtered = new ArrayList<GiangVien>();

		for (GiangVien item : khoa.giangVien) {
			Boolean valid = false;

			for (String token : tokens)
				if (
						item.getMaGV().toLowerCase().contains(token)
					||	item.getTen().toLowerCase().contains(token)
					||	item.getEmail().toLowerCase().contains(token)
					||	item.getSoDienThoai().contains(token)
				) {
					valid = true;
				} else {
					valid = false;
					break;
				}

			if (valid)
				filtered.add(item);
		}

		return filtered;
	}

	public static void removeGiangVien(GiangVien giangVien) {
		khoa.giangVien.remove(giangVien);
		safeSave();
	}

	//* ======================= CÁC HÀM PROCESS LỚP HỌC =======================
	public static void addLopHoc(LopHoc lopHoc) throws LopHocExistException {
		for (LopHoc item: getLopHocList())
			if (item.maLop.equals(lopHoc.maLop))
				throw new LopHocExistException(item);

		khoa.lopHoc.add(lopHoc);
		safeSave();
	}

	public static LopHoc getLopHoc(String maLop) {
		for (LopHoc lopHoc : getLopHocList())
			if (lopHoc.maLop == maLop)
				return lopHoc;

		return null;
	}

	public static ArrayList<LopHoc> getLopHocList() {
		return khoa.lopHoc;
	}

	public static ArrayList<LopHoc> getLopHocList(String query) {
		if (query == null || query.length() == 0 || query == "")
			return getLopHocList();

		String[] tokens = query.toLowerCase().split(" ");
		ArrayList<LopHoc> filtered = new ArrayList<LopHoc>();

		for (LopHoc item : khoa.lopHoc) {
			Boolean valid = false;

			for (String token : tokens)
				if (
						item.getMaLop().toLowerCase().contains(token)
					||	item.getMonHoc().toLowerCase().contains(token)
					||	item.getGiangVien().toString().toLowerCase().contains(token)
					||	item.getTrangThai().toLowerCase().contains(token)
				) {
					valid = true;
				} else {
					valid = false;
					break;
				}

			if (valid)
				filtered.add(item);
		}

		return filtered;
	}

	public static void removeLopHoc(LopHoc lopHoc) {
		khoa.lopHoc.remove(lopHoc);
		safeSave();
	}

	//* ======================= CÁC HÀM PROCESS BÀN HỌC =======================
	public static void addBanHoc(BanHoc banHoc) {
		khoa.banHoc.add(banHoc);
		safeSave();
	}

	public static ArrayList<BanHoc> getBanHocList() {
		return khoa.banHoc;
	}

	public static void removeBanHoc(BanHoc banHoc) {
		khoa.banHoc.remove(banHoc);
		safeSave();
	}
	
	//* ======================= CÁC HÀM PROCESS MÁY CHIẾU =======================
	public static void addMayChieu(MayChieu mayChieu) {
		khoa.mayChieu.add(mayChieu);
		safeSave();
	}

	public static ArrayList<MayChieu> getMayChieuList() {
		return khoa.mayChieu;
	}

	public static void removeMayChieu(MayChieu mayChieu) {
		khoa.mayChieu.remove(mayChieu);
		safeSave();
	}

	//* ======================= LƯU VÀ ĐỌC FILE =======================
	public static void safeSave() {
		try {
			save();
		} catch (Exception e) {
			ExceptionHandler.handle(e);
		}
	}

	public static void safeLoad() {
		try {
			load();
		} catch (Exception e) {
			ExceptionHandler.handle(e);
		}
	}

	/**
	 * Write {@code Khoa} into file input stream
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void save() throws FileNotFoundException, IOException {
		System.out.println("Saving files to " + dataFile.getAbsolutePath());
		FileOutputStream fileOut = new FileOutputStream(dataFile);
		ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

		objOut.flush();
		objOut.writeObject(khoa);

		objOut.close();
		fileOut.close();
	}

	/**
	 * Try to read data in the file input stream, then
	 * cast into {@code Khoa}
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void load() throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("Loading data from " + dataFile.getAbsolutePath());
		FileInputStream fileIn = new FileInputStream(dataFile);
		ObjectInputStream objIn = new ObjectInputStream(fileIn);

		khoa = (Khoa) objIn.readObject();
		objIn.close();
		fileIn.close();
	}
}
