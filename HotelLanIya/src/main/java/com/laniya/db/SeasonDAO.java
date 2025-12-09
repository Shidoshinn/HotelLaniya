/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laniya.db;

import com.laniya.controller.DBConnection;
import java.sql.*;
import java.time.LocalDate;

public class SeasonDAO {

    public static String getSeason(LocalDate date) throws Exception {
        String sql = "SELECT season_name FROM seasons WHERE " +
                "(start_month < end_month AND " +
                " ( ( ? > STR_TO_DATE(CONCAT(start_month, '-', start_day), '%m-%d') AND ? < STR_TO_DATE(CONCAT(end_month, '-', end_day), '%m-%d') ) ) ) OR " +

                "(start_month > end_month AND " + 
                " ( ( ? >= STR_TO_DATE(CONCAT(start_month, '-', start_day), '%m-%d') OR ? <= STR_TO_DATE(CONCAT(end_month, '-', end_day), '%m-%d') ) ) ) " +

                "LIMIT 1";

        java.sql.Date sqlDate = java.sql.Date.valueOf(date);

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, sqlDate);
            ps.setDate(2, sqlDate);
            ps.setDate(3, sqlDate);
            ps.setDate(4, sqlDate);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("season_name");
            }
        }

        return "Lean"; // default
    }
}
