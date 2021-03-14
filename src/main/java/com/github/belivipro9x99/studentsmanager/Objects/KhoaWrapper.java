package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class KhoaWrapper {
	public static String savePath = "data.dat";
	public static Khoa khoa;

	public KhoaWrapper() throws FileNotFoundException, IOException {
		File saveFile = new File(savePath);

		if (!saveFile.exists()) {
			khoa = new Khoa();
			this.save(saveFile);
		}
	}

	/**
	 * Write {@code Khoa} into file input stream
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void save(File file) throws FileNotFoundException, IOException {
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
		FileInputStream fileIn = new FileInputStream(file);
		ObjectInputStream objIn = new ObjectInputStream(fileIn);

		khoa = (Khoa) objIn.readObject();
		objIn.close();
		fileIn.close();
	}
}
