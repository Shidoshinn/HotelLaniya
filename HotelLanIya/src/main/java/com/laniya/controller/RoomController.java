/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laniya.controller;

import java.time.LocalDate;

public class RoomController {
    
    public static String verifySeason(LocalDate date) {
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        
        if ((month == 6 && day >= 1) || (month == 7) || (month == 8) || (month == 9 && day <= 30) || (month == 10 && day <= 31)) {
            return "Lean";
        } else if ((month == 11 && day >= 1 && day <= 19) || (month == 1 && day >= 6) || (month == 2 && day <= 28)) {
            return "High";
        } else if ((month == 3 && day >= 1 && day <= 15) || (month == 4 && (day <= 15 || day >= 23)) || (month == 5 && day <= 31)) {
            return "Peak";
        }else if ((month == 12 && day >= 20) || (month == 1 && day <= 5) || (month == 1 && day == 29) || (month == 4 && day >= 16 && day <= 22)) {
            return "Super Peak";
        }
        return "Lean";
        }
     public static int getLocalRoomRate(String season, String roomType) {
        roomType = roomType.trim().toLowerCase();
        if (roomType.contains("standard")) {
            switch (season) {
                case "Lean": return 2000;
                case "High": return 4000;
                case "Peak": return 6000;
                case "Super Peak": return 9000;
            }
        } else if (roomType.contains("deluxe")) {
            switch (season) {
                case "Lean": return 3000;
                case "High": return 5000;
                case "Peak": return 8000;
                case "Super Peak": return 12000;
            }
        } else if (roomType.contains("quadruple")) {
            switch (season) {
                case "Lean": return 4000;
                case "High": return 7000;
                case "Peak": return 10000;
                case "Super Peak": return 15000;
            }
        } else if (roomType.contains("family")) {
            switch (season) {
                case "Lean": return 5000;
                case "High": return 9000;
                case "Peak": return 12000;
                case "Super Peak": return 18000;
            }
        } else if (roomType.contains("suite")) {
            switch (season) {
                case "Lean": return 6000;
                case "High": return 11000;
                case "Peak": return 14000;
                case "Super Peak": return 21000;
            }
        }
        return 0;
    }
}