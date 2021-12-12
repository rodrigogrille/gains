/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giogio.gains.classes;

import java.sql.Date;

/**
 *
 * @author rgrille
 */
//Objeto que guarda los datos de la tabla user_user de la base de datos
public class User {

	private String id;
	private String name;
	private String passwd;
	private String email;
	private Date born_date;
	private int role_id;

	public User(String id, String name, String passwd, String email, Date born_date, int role_id) {
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.email = email;
		this.born_date = born_date;
		this.role_id = role_id;
	}

	public User(String id, String name, String email, Date born_date, int role_id) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.born_date = born_date;
		this.role_id = role_id;
	}

	public User(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBorn_date() {
		return born_date;
	}

	public void setBorn_date(Date born_date) {
		this.born_date = born_date;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return id;
	}

}
