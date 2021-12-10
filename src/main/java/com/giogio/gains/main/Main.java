/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giogio.gains.main;

import java.sql.Date;

import com.giogio.gains.classes.PasswordEncrypt;
import com.giogio.gains.classes.User;
import com.giogio.gains.classes.Workout;
import com.giogio.gains.dao.UserDao;
import com.giogio.gains.dao.WorkoutDao;

/**
 *
 * @author rgrille
 */
public class Main {
    public static void main(String[] args) {
        for (User user : UserDao.read()) {
        	System.out.println(user.toString());
        }
        for (Workout workout : WorkoutDao.read()) {
        	System.out.println(workout.toString());
        }
    }
}
