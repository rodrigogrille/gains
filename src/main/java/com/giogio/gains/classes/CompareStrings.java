package com.giogio.gains.classes;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CompareStrings {

	public static Boolean compareUserName(ArrayList<User> array, String userName) {
		for (User user : array) {
			if (user.getId().toUpperCase().equals(userName.toUpperCase())) {
				
				return true;
			}
		}
		return false;
	}

	public static Boolean comparePasswordSignIn(char[] pass1, char[] pass2) {
		if (Arrays.equals(pass1, pass2)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean dateValidation(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		try {
			java.util.Date parsed = format.parse(date);
		} catch (ParseException e) {
			log.error(e);
			return false;
		}
		return true;
	}
	
	public static Boolean compareUserNamePass(ArrayList<User> array, String userName, String pass) {
		for (User user : array) {
			if (user.getId().toUpperCase().equals(userName.toUpperCase())) {
				if (  user.getPasswd().equals(PasswordEncrypt.encryptPassword(pass))) {
					return true;
				}
			}
		}
		return false;
	}
}
