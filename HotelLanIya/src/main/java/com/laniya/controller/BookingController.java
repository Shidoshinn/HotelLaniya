/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laniya.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.temporal.ChronoUnit;

public class BookingController {

    // compute nights between dates
    public static int computeNights(java.time.LocalDate checkIn, java.time.LocalDate checkOut) {
        return (int) ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    // save guest (returns generated id) - simple example using DBConnection
    public static int saveGuest(Guest g) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO guests (full_name, birthday, email, contact) VALUES (?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            p.setString(1, g.getFullName());
            p.setDate(2, java.sql.Date.valueOf(g.getBirthday()));
            p.setString(3, g.getEmail());
            p.setString(4, g.getContact());
            p.executeUpdate();
            ResultSet rs = p.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    // save booking (simple)
    public static int saveBooking(Booking b) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO bookings (guest_id, room_type, check_in, check_out, nights, total_amount) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            p.setInt(1, b.getGuestId());
            p.setString(2, b.getRoomType());
            p.setDate(3, java.sql.Date.valueOf(b.getCheckIn()));
            p.setDate(4, java.sql.Date.valueOf(b.getCheckOut()));
            p.setInt(5, b.getNights());
            p.setDouble(6, b.getTotalAmount());
            p.executeUpdate();
            ResultSet rs = p.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    private static class Booking {

        public Booking() {
        }

        private int getGuestId() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getRoomType() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getCheckIn() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getCheckOut() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private int getNights() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private double getTotalAmount() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class Guest {

        public Guest() {
        }

        private String getContact() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getBirthday() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getFullName() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getEmail() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
