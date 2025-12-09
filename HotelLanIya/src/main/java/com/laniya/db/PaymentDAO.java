/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laniya.db;

import com.laniya.view.AppState;
import java.sql.*;

public class PaymentDAO {

    public static void savePayment(int bookingId) throws Exception {

        AppState s = AppState.getInstance();
        double vat = (s.getTotalAmount() / 1.12) * 0.12;

        String sql = "INSERT INTO payments(booking_id, payment_method, total_amount, vat_amount) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bookingId);
            ps.setString(2, s.getPaymentMethod());
            ps.setDouble(3, s.getTotalAmount());
            ps.setDouble(4, vat);
            ps.executeUpdate();
        }
    }
}