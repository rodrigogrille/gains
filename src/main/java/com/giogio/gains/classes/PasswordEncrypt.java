package com.giogio.gains.classes;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @author Rodrigo
 *
 */
public class PasswordEncrypt {
	// Hace md5Sum a un String que se le pasa
	public static String encryptPassword(String password) {
		boolean respuesta;
		String md5 = DigestUtils.md5Hex(password);
		return md5;
	}
}
