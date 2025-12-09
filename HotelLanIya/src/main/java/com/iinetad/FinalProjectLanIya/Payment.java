/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iinetad.FinalProjectLanIya;

public class Payment {
    private int paymentId;
    private int bookingId;
    private String method;
    private double amount;
    private String transId;

    public Payment(int bookingId, String method, double amount, String transId) {
        this.bookingId = bookingId; this.method = method; this.amount = amount; this.transId = transId;
    }
    // getters / setters omitted for brevity
}