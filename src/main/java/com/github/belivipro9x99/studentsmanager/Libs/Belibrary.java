package com.github.belivipro9x99.studentsmanager.Libs;

public class Belibrary {
	public static String sanitizeNumber(String value) {
		if (value != null && !value.matches("\\d*"))
			value = value.replaceAll("[^\\d]", "");

		if (value == null || value == "" || value.length() == 0)
			return "0";

		return value;
	}

	public static String sanitizeDouble(String value) {
		if (value != null && !value.matches("\\d*\\.*"))
			value = value.replaceAll("[^\\d\\.]", "");

		if (value == null || value == "" || value.length() == 0)
			return "0";

		return value;
	}
}
