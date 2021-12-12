package com.giogio.gains.classes;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordEncrypt {

	public static String encryptPassword(String password) {
		boolean respuesta;
		String md5 = DigestUtils.md5Hex(password);
		return md5;
	}
}
