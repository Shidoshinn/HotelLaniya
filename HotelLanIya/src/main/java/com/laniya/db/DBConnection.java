/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laniya.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/laniya_hotel"; // change if needed
    private static final String USER = "root";
    private static final String PASS = "your_password_here";

    public static Connection getConnection() throws SQLException {
        // Simple connection method for beginners.
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}