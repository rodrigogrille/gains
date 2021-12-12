package com.giogio.gains.classes;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Rodrigo
 *
 */
public class Parser {
	static Date sql;
	// Transforma la fecha de String a Date
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
	// Devuelve un array de char convertido a String
	public static String getPass(char[] pass) {
		return String.valueOf(pass);
	}

}
