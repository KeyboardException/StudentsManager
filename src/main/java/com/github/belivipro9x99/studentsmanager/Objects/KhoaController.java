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

	public KhoaController(File dataFile) throws FileNotFoundException, IOException, ClassNotFoundException {
		if (!dataFile.exists()) {
			khoa = new Khoa();
			this.save(dataFile);
		} else
			this.load(dataFile);
	}

	public void addSinhVien(SinhVien sinhVien) throws SinhVienExistException {
		for (SinhVien item: getSinhVienList())
			if (item.maSV.equals(sinhVien.maSV))
				throw new SinhVienExistException(item);

		khoa.sinhVien.add(sinhVien);
	}

	public ArrayList<SinhVien> getSinhVienList() {
		return khoa.sinhVien;
	}

	public void removeSinhVien(SinhVien sinhVien) {
		khoa.sinhVien.remove(sinhVien);
	}
	
	public void addGiangVien(GiangVien giangVien) throws GiangVienExistException {
		for (GiangVien item: getGiangVienList())
			if (item.maGV.equals(giangVien.maGV))
				throw new GiangVienExistException(item);

		khoa.giangVien.add(giangVien);
	}

	public ArrayList<GiangVien> getGiangVienList() {
		return khoa.giangVien;
	}

	public void removeGiangVien(GiangVien giangVien) {
		khoa.giangVien.remove(giangVien);
	}


	/**
	 * Write {@code Khoa} into file input stream
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void save(File file) throws FileNotFoundException, IOException {
		System.out.println("Saving files to " + file.getAbsolutePath());
		FileOutputStream fileOut = new FileOutputStream(file);
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
	public void load(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("Loading data from " + file.getAbsolutePath());
		FileInputStream fileIn = new FileInputStream(file);
		ObjectInputStream objIn = new ObjectInputStream(fileIn);

		khoa = (Khoa) objIn.readObject();
		objIn.close();
		fileIn.close();
	}
}
