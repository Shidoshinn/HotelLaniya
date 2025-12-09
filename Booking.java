package com.iinetad.FinalProjectLanIya;

import java.time.LocalDate;

public class Booking {
    private int bookingId;
    private int guestId;
    private String roomType;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int nights;
    private double totalAmount;

    public Booking() {}

    public Booking(int guestId, String roomType, LocalDate checkIn, LocalDate checkOut, int nights, double totalAmount) {
        this.guestId = guestId;
        this.roomType = roomType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.nights = nights;
        this.totalAmount = totalAmount;
    }

    // getters/setters...
    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }
    public int getGuestId() { return guestId; }
    public String getRoomType() { return roomType; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public int getNights() { return nights; }
    public double getTotalAmount() { return totalAmount; }
}
