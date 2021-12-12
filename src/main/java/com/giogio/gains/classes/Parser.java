package com.giogio.gains.classes;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Parser {
	static Date sql;

	public static Date getDate(String date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date parsed;
		try {
			parsed = format.parse(date);
			sql = new Date(parsed.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sql;
	}
	
	public static String getPass(char[] pass) {
		return String.valueOf(pass);
	}

}
