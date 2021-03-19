package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.github.belivipro9x99.studentsmanager.Exception.GiangVienExistException;
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

	public static void addSinhVien(SinhVien sinhVien) throws SinhVienExistException {
		for (SinhVien item: getSinhVienList())
			if (item.getMaSV().equals(sinhVien.getMaSV()))
				throw new SinhVienExistException(item);

		khoa.sinhVien.add(sinhVien);
	}

	public static ArrayList<SinhVien> getSinhVienList() {
		return khoa.sinhVien;
	}

	public static void removeSinhVien(SinhVien sinhVien) {
		khoa.sinhVien.remove(sinhVien);
	}
	
	public static void addGiangVien(GiangVien giangVien) throws GiangVienExistException {
		for (GiangVien item: getGiangVienList())
			if (item.maGV.equals(giangVien.maGV))
				throw new GiangVienExistException(item);

		khoa.giangVien.add(giangVien);
	}

	public static ArrayList<GiangVien> getGiangVienList() {
		return khoa.giangVien;
	}

	public static void removeGiangVien(GiangVien giangVien) {
		khoa.giangVien.remove(giangVien);
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
