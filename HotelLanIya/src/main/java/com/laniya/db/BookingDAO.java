/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laniya.db;

import com.laniya.view.AppState;
import java.sql.*;

public class BookingDAO {

    public static int saveBooking(int guestId, int roomId, String season) throws Exception {

        AppState s = AppState.getInstance();

        String sql = "INSERT INTO bookings(guest_id, destination, check_in, check_out, nights, room_id, season, room_rate) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, guestId);
            ps.setString(2, s.getDestination());
            ps.setDate(3, Date.valueOf(s.getCheckIn()));
            ps.setDate(4, Date.valueOf(s.getCheckOut()));
            ps.setInt(5, s.getNights());
            ps.setInt(6, roomId);
            ps.setString(7, season);
            ps.setDouble(8, s.getRoomRate());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1); // booking_id
        }
        return -1;
    }
}