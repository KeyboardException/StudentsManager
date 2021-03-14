package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class KhoaController {
	public static String savePath = "data.dat";
	public static Khoa khoa;

	public KhoaController() throws FileNotFoundException, IOException, ClassNotFoundException {
		File saveFile = new File(savePath);

		if (!saveFile.exists()) {
			khoa = new Khoa();
			this.save(saveFile);
		} else {
			this.load(saveFile);
		}
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
