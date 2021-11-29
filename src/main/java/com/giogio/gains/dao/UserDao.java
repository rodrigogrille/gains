/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giogio.gains.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.giogio.gains.classes.User;
import com.giogio.gains.naming.TableNaming;
import com.giogio.gains.naming.UserNaming;

/**
 *
 * @author rgrille
 */
public class UserDao {

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

    public static boolean create(User user) {
        if (user != null) {
            Connection conexion = conectar();

            String sql = "INSERT INTO " + TableNaming.USER_USER  + " (" + UserNaming.ID + ", " + UserNaming.NAME + ", " + UserNaming.PASS + ", " + UserNaming.EMAIL + ", " + UserNaming.BORN + ", " + UserNaming.ROLE + ") "
                    + "             VALUES ( ?,   ?,   ?,   ?,   ?,   ? )";

            try {
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                sentencia.setString(1, user.getId());
                sentencia.setString(2, user.getName());
                sentencia.setString(3, user.getPasswd());
                sentencia.setString(4, user.getEmail());
                sentencia.setDate(5, user.getBorn_date());
                sentencia.setInt(6, user.getRole_id());
                sentencia.executeUpdate();
                conexion.close();
            } catch (SQLException ex) {
            	System.out.println(ex);
                return false;
            }
        }
        return true;
    }

    public static Boolean readUser(String name) {
    	String sql = "SELECT " + UserNaming.ID  + " FROM " + TableNaming.USER_USER;
        try {
            Connection conexion = conectar();

            PreparedStatement sentencia = conexion.prepareStatement(sql);

            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                String id = rs.getString(UserNaming.ID);
                if ( id.equals(name)) {
                	return true;
                }
            }
            conexion.close();
        } catch (SQLException ex) {
        	System.out.println("Error on user query");
        	return false;
        }
    	return false;
    }
    
    public static ArrayList<User> read() {
        User user = null;
        ArrayList<User> array = new ArrayList();
        String sql = "SELECT " + UserNaming.ID + ", " + UserNaming.NAME + ", " + UserNaming.EMAIL + ", " + UserNaming.BORN + ", " + UserNaming.ROLE + " FROM " + TableNaming.USER_USER;
        try {
            Connection conexion = conectar();

            PreparedStatement sentencia = conexion.prepareStatement(sql);

            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                String id = rs.getString(UserNaming.ID);
                String name = rs.getString(UserNaming.NAME);
                String email = rs.getString(UserNaming.EMAIL);
                Date born_date = rs.getDate(UserNaming.BORN);
                int role_id = rs.getInt(UserNaming.ROLE);

                user = new User(id, name, email, born_date, role_id);
                array.add(user);
            }
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error on user query");
        }

        return array;
    }

    public static boolean update(User user) {
        if (user != null) {
            String sql = "UPDATE "+ TableNaming.USER_USER  + " SET " +  UserNaming.NAME + "=?, " + UserNaming.PASS + "=?, " + UserNaming.EMAIL + "=?, " + UserNaming.BORN + "=?, " + UserNaming.ROLE + "=? " + " WHERE " + UserNaming.ID + "=?";
            try {
                Connection conexion = conectar();
                PreparedStatement sentencia = conexion.prepareStatement(sql);

                sentencia.setString(1, user.getName());
                sentencia.setString(2, user.getPasswd());
                sentencia.setString(3, user.getEmail());
                sentencia.setDate(4, user.getBorn_date());
                sentencia.setInt(5, user.getRole_id());
                sentencia.setString(6, user.getId());
                sentencia.executeUpdate();
                conexion.close();
            } catch (SQLException ex) {
                return false;
            }
        }
        return true;
    }

    public static boolean delete(User user) {
        String sql = "DELETE FROM " + TableNaming.USER_USER  + " WHERE " + UserNaming.ID + "=?";
        try {
            Connection conexion = conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, user.getId());
            sentencia.executeUpdate();
            conexion.close();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
}
