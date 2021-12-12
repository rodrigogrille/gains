package com.giogio.gains.classes;

/**
 * 
 * @author Rodrigo
 *
 */
//Objeto que guarda los datos de la tabla user_role de la base de datos
public class Role {
	int id;
	String name;

	public Role(int id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return name;
	}

}
