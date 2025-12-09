/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laniya.db;

import com.iinetad.FinalProjectLanIya.Guest;
import com.laniya.controller.DBConnection;
import com.iinetad.FinalProjectLanIya.Guest;
import java.sql.*;

public class GuestDAO {

    public static int saveGuest(Guest guest) throws Exception {
        String sql = "INSERT INTO guests(full_name, birthday, email, contact) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, guest.getFullName());
            ps.setDate(2, Date.valueOf(guest.getBirthday()));
            ps.setString(3, guest.getEmail());
            ps.setString(4, guest.getContact());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // return guest_id
            }
        }
        return -1;
    }
}