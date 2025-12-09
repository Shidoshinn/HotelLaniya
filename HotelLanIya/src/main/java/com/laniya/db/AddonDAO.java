/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laniya.db;

import com.laniya.view.AppState;
import java.sql.*;

public class AddonDAO {

    public static void saveAddons(int bookingId) throws Exception {

        AppState s = AppState.getInstance();

        String sql = "INSERT INTO addons(booking_id, extra_bed, blankets, pillows) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bookingId);
            ps.setBoolean(2, s.isExtraBed());
            ps.setInt(3, s.getBlankets());
            ps.setInt(4, s.getPillows());
            ps.executeUpdate();
        }
    }
}