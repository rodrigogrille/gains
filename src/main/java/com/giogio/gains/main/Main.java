/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giogio.gains.main;

import com.giogio.gains.classes.User;
import com.giogio.gains.dao.UserDao;
import java.sql.Date;

/**
 *
 * @author rgrille
 */
public class Main {
    public static void main(String[] args) {
        Date date = new Date(2020,11,11);
        User usuario = new User("pepe","pepe","a","a",date,1);
        UserDao.create(usuario);
    }
}
