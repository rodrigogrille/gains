package com.giogio.gains.classes;

public class Table {
	int id;
	String name;
	String user_id;

	public Table(int id, String name, String user_id) {
		this.id = id;
		this.name = name;
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return name;
	}

}
