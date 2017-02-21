package com.deckard.helloboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class HelloController {
    @RequestMapping("/pow")
    public String pow(@RequestParam("number") int number) {
        double n = Math.pow((double) number, 2);
        return String.valueOf(n);
    }

    @RequestMapping("/newfriend")
    public String addNewFriend(@RequestParam("name") String name) {
        //insertNewFriendToDb(name);
        return "New friend added";
    }

    @RequestMapping("/myfriends")
    public String getMyFriends() {
        return getFriendsFromDb();
    }

    private void insertNewFriendToDb(String name) {
        Connection mariaDb = getDbConnection();
        Statement stmt = null;
        try {
            stmt = mariaDb.createStatement();
            stmt.executeUpdate("insert into friends values('" + name + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getFriendsFromDb() {
        StringBuilder friends = new StringBuilder();
        Connection mariaDb = null;
        Statement stmt = null;
        try {
            mariaDb = getDbConnection();
            stmt = mariaDb.createStatement();
            ResultSet results = stmt.executeQuery("select * from friends");
            while(results.next()) {
                String friend = results.getString("name");
                friends.append(friend);
                friends.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return friends.toString();
    }

    private Connection getDbConnection() {
        Connection mariaDbConnection = null;
        try {
            mariaDbConnection = DriverManager.getConnection("j  dbc:mariadb://localhost:3306/people?user=root&password=charade");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mariaDbConnection;
    }
}
