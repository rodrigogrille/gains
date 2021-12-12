/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giogio.gains.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.giogio.gains.classes.Role;
import com.giogio.gains.classes.Table;
import com.giogio.gains.naming.BdNaming;
import com.giogio.gains.naming.RoleNaming;
import com.giogio.gains.naming.TableNaming;

/**
 *
 * @author rgrille
 */
public class RoleDao {
	// Ejecuta la conexion a la base de datos
	private static Connection conectar() {
		Connection con = null;

		String url = "jdbc:mysql://localhost/coppermind";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "");
		} catch (SQLException ex) {
			System.out.println("Cannot connect to db");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}
	// Ejecuta una INSERT a la base de datos hacia la tabla user_role
	public static boolean create(Role role) {
		if (role != null) {
			Connection conexion = conectar();

			String sql = "INSERT INTO " + BdNaming.USER_ROLE + " (" + RoleNaming.ID + ", " + RoleNaming.NAME + " ) "
					+ " VALUES ( ?,   ? )";

			try {
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setInt(1, role.getId());
				sentencia.setString(2, role.getName());
				sentencia.executeUpdate();
				conexion.close();
			} catch (SQLException ex) {
				System.out.println(ex);
				return false;
			}
		}
		return true;
	}
	// Ejecuta una SELECT a la base de datos hacia la tabla user_role devolviendo un ArrayList de Objetos Role
	public static ArrayList<Role> read() {
		Role role = null;
		ArrayList<Role> array = new ArrayList();
		String sql = "SELECT * FROM " + BdNaming.USER_ROLE;
		try {
			Connection conexion = conectar();
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(RoleNaming.ID);
				String name = rs.getString(RoleNaming.NAME);
				role = new Role(id, name);
				array.add(role);
			}
			conexion.close();
		} catch (SQLException ex) {
			System.out.println("Error on role query");
		}

		return array;
	}
	// Ejecuta una UPDATE a la base de datos hacia la tabla user_role
	public static boolean update(Role role) {
		if (role != null) {
			String sql = "UPDATE " + BdNaming.USER_ROLE + " SET " + RoleNaming.NAME + "=? " + " WHERE "
					+ RoleNaming.ID + "=?";
			try {
				Connection conexion = conectar();
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setString(1, role.getName());
				sentencia.setInt(2, role.getId());
				sentencia.executeUpdate();
				conexion.close();
			} catch (SQLException ex) {
				return false;
			}
		}
		return true;
	}
	// Ejecuta una DELETE a la base de datos hacia la tabla user_role
	public static boolean delete(Role role) {
		String sql = "DELETE FROM " + BdNaming.USER_ROLE + " WHERE " + RoleNaming.ID + "=?";
		try {
			Connection conexion = conectar();
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, role.getId());
			sentencia.executeUpdate();
			conexion.close();
		} catch (SQLException ex) {
			return false;
		}
		return true;
	}
}
