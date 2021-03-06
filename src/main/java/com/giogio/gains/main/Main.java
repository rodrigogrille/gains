/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giogio.gains.main;

import java.sql.Date;

import com.giogio.gains.classes.PasswordEncrypt;
import com.giogio.gains.classes.Table;
import com.giogio.gains.classes.User;
import com.giogio.gains.classes.Exercice;
import com.giogio.gains.dao.UserDao;
import com.giogio.gains.dao.ExerciceDao;
import com.giogio.gains.dao.TableDao;

/**
 *
 * @author rgrille
 */
public class Main {
    public static void main(String[] args) {
        for (User user : UserDao.read()) {
        	System.out.println(user.toString());
        }
        for (Exercice workout : ExerciceDao.read()) {
        	System.out.println(workout.toString());
        }
        for (Table workout : TableDao.read()) {
        	System.out.println(workout.toString());
        }
    }
}
