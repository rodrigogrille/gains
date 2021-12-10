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

import com.giogio.gains.classes.Workout;
import com.giogio.gains.naming.TableNaming;
import com.giogio.gains.naming.UserNaming;
import com.giogio.gains.naming.WorkoutNaming;

/**
 *
 * @author rgrille
 */
public class WorkoutDao {
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

    public static boolean create(Workout workout) {
        if (workout != null) {
            Connection conexion = conectar();

            String sql = "INSERT INTO " + TableNaming.WORKOUT  + " (" + WorkoutNaming.ID + ", " + WorkoutNaming.NAME + ", " + WorkoutNaming.DESCRIPTION + ", " + WorkoutNaming.VIDEO +  " ) "
                    + "             VALUES ( ?,   ?,   ?,   ? )";

            try {
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                sentencia.setInt(1, workout.getId());
                sentencia.setString(2, workout.getName());
                sentencia.setString(3, workout.getDescription());
                sentencia.setString(4, workout.getVideo());
                sentencia.executeUpdate();
                conexion.close();
            } catch (SQLException ex) {
            	System.out.println(ex);
                return false;
            }
        }
        return true;
    }
    
    public static ArrayList<Workout> read() {
        Workout workout = null;
        ArrayList<Workout> array = new ArrayList();
        String sql = "SELECT " + WorkoutNaming.ID + ", " + WorkoutNaming.NAME + ", " +  WorkoutNaming.DESCRIPTION + ", " + WorkoutNaming.VIDEO +  " FROM " + TableNaming.WORKOUT;
        try {
            Connection conexion = conectar();

            PreparedStatement sentencia = conexion.prepareStatement(sql);

            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(WorkoutNaming.ID);
                String name = rs.getString(WorkoutNaming.NAME);
                String description = rs.getString(WorkoutNaming.DESCRIPTION);
                String video = rs.getString(WorkoutNaming.VIDEO);
                workout = new Workout(id, name, description, video);
                array.add(workout);
            }
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error on workout query");
        }

        return array;
    }

    public static boolean update(Workout workout) {
        if (workout != null) {
            String sql = "UPDATE "+ TableNaming.WORKOUT  + " SET " +  WorkoutNaming.ID + "=?, " + WorkoutNaming.NAME + "=?, " + WorkoutNaming.DESCRIPTION + "=?, " + WorkoutNaming.VIDEO + "=?";
            try {
                Connection conexion = conectar();
                PreparedStatement sentencia = conexion.prepareStatement(sql);

                sentencia.setInt(1, workout.getId());
                sentencia.setString(2, workout.getName());
                sentencia.setString(3, workout.getDescription());
                sentencia.setString(4, workout.getVideo());
                sentencia.executeUpdate();
                conexion.close();
            } catch (SQLException ex) {
                return false;
            }
        }
        return true;
    }

    public static boolean delete(Workout workout) {
        String sql = "DELETE FROM " + TableNaming.WORKOUT  + " WHERE " + WorkoutNaming.ID + "=?";
        try {
            Connection conexion = conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, workout.getId());
            sentencia.executeUpdate();
            conexion.close();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
}
