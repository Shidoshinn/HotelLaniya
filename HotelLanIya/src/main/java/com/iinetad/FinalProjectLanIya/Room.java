/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iinetad.FinalProjectLanIya;

public class Room {
    private String roomType;
    private int capacity;
    private int available;

    public Room(String roomType, int capacity, int available) {
        this.roomType = roomType;
        this.capacity = capacity;
        this.available = available;
    }

    public String getRoomType() { return roomType; }
    public int getCapacity() { return capacity; }
    public int getAvailable() { return available; }
    public void setAvailable(int available) { this.available = available; }
}