/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giogio.gains.main;

import java.sql.Date;

import com.giogio.gains.classes.PasswordEncrypt;
import com.giogio.gains.classes.User;
import com.giogio.gains.dao.UserDao;

/**
 *
 * @author rgrille
 */
public class Main {
    public static void main(String[] args) {
        Date date = new Date(2020,11,11);
        User usuario = new User("pepe","pipo","a","a",date,1);
        for (User user : UserDao.read()) {
        	System.out.println(user.toString());
        }
    }
}
