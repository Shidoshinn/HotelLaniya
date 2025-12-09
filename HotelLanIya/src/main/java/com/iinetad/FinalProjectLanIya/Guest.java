/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iinetad.FinalProjectLanIya;

import java.time.LocalDate;

public class Guest {
    private int guestId;
    private String fullName;
    private LocalDate birthday;
    private String email;
    private String contact;

    public Guest() {}

    public Guest(String fullName, LocalDate birthday, String email, String contact) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.email = email;
        this.contact = contact;
    }

    // getters / setters
    public int getGuestId() { return guestId; }
    public void setGuestId(int guestId) { this.guestId = guestId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public LocalDate getBirthday() { return birthday; }
    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public int getAge() {
        return java.time.temporal.ChronoUnit.YEARS.between(birthday, LocalDate.now()) > Integer.MAX_VALUE
               ? 0
               : (int) java.time.temporal.ChronoUnit.YEARS.between(birthday, LocalDate.now());
    }
}
