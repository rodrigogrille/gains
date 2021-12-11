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

import com.giogio.gains.classes.Exercice;
import com.giogio.gains.classes.Table;
import com.giogio.gains.naming.BdNaming;
import com.giogio.gains.naming.TableNaming;
import com.giogio.gains.naming.WorkoutNaming;

/**
 *
 * @author rgrille
 */
public class TableDao {
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

	public static boolean create(Table table) {
		if (table != null) {
			Connection conexion = conectar();

			String sql = "INSERT INTO " + BdNaming.TABLE + " (" + TableNaming.TABLE_ID + ", " + TableNaming.TABLE_NAME
					+ ", " + TableNaming.USER_ID + " ) " + "             VALUES ( ?,   ?,   ? )";

			try {
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setInt(1, table.getId());
				sentencia.setString(2, table.getName());
				sentencia.setString(3, table.getUser_id());
				sentencia.executeUpdate();
				conexion.close();
			} catch (SQLException ex) {
				System.out.println(ex);
				return false;
			}
		}
		return true;
	}

	public static ArrayList<Table> read() {
		Table table = null;
		ArrayList<Table> array = new ArrayList();
		String sql = "SELECT * FROM " + BdNaming.TABLE;
		try {
			Connection conexion = conectar();
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(TableNaming.TABLE_ID);
				String name = rs.getString(TableNaming.TABLE_NAME);
				String user_id = rs.getString(TableNaming.USER_ID);
				table = new Table(id, name, user_id);
				array.add(table);
			}
			conexion.close();
		} catch (SQLException ex) {
			System.out.println("Error on table query");
		}

		return array;
	}

	public static boolean update(Table table) {
		if (table != null) {
			String sql = "UPDATE " + BdNaming.TABLE + " SET " + TableNaming.TABLE_NAME + "=?, " + TableNaming.USER_ID
					+ "=? " + " WHERE " + TableNaming.TABLE_ID + "=?";
			try {
				Connection conexion = conectar();
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setString(1, table.getName());
				sentencia.setString(2, table.getUser_id());
				sentencia.setInt(3, table.getId());
				sentencia.executeUpdate();
				conexion.close();
			} catch (SQLException ex) {
				return false;
			}
		}
		return true;
	}

	public static boolean delete(Table table) {
		String sql = "DELETE FROM " + BdNaming.TABLE + " WHERE " + TableNaming.TABLE_ID + "=?";
		try {
			Connection conexion = conectar();
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, table.getId());
			sentencia.executeUpdate();
			conexion.close();
		} catch (SQLException ex) {
			return false;
		}
		return true;
	}
}
