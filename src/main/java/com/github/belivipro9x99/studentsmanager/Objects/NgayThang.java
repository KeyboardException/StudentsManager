package com.github.belivipro9x99.studentsmanager.Objects;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NgayThang implements Serializable {
	private static final long serialVersionUID = -2779251502539110801L;
	
	private long timestamp;
	private Date date;

	public NgayThang() {
		date = new Date();
		timestamp = date.getTime();
	}

	public NgayThang(Date date) {
		this.date = date;
		this.timestamp = date.getTime();
	}

	public NgayThang(long time) {
		this.timestamp = time;
		date = new Date(time);
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public String toDateString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}

	public String toTimeString() {
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		return dateFormat.format(date);
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return dateFormat.format(date);
	}
}
