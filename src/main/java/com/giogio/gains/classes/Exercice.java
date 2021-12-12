package com.giogio.gains.classes;

import java.util.ResourceBundle;
/**
 * 
 * @author Rodrigo
 *
 */
// Objeto que guarda los datos de la tabla Workout de la base de datos
public class Exercice {
	int id;
	String name;
	String description;
	String video;

	public Exercice(int id, String name, String description, String video) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.video = video;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	// Devuelve la traduccion del ejercicio segun el idioma que estea seleccionado
	@Override
	public String toString() {
		return ResourceBundle.getBundle("i18n").getString(name);
	}

}
