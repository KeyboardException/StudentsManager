package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NgayThang implements Serializable {
	private static final long serialVersionUID = -2779251502539110801L;
	
	public long timestamp;
	public Date date;

	public NgayThang() {
		date = new Date();
		timestamp = date.getTime();
	}

	public NgayThang(long time) {
		this.timestamp = time;
		date = new Date(time);
	}

	public String toDateString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		return dateFormat.format(date);
	}

	public String toTimeString() {
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		return dateFormat.format(date);
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
		return dateFormat.format(date);
	}
}
