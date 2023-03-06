package com.example.demo.pojo;

public enum SportsType {
	FOOTBALL,CRICKET,BADMINTON,TABLETENNIS,TENNIS,BASKETBALL;
	
    public static Sports fromString(String sport) {
        for (Sports s : Sports.values()) {
            if (s.toString().equalsIgnoreCase(sport)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Invalid sport: " + sport);
    }

//    public static Sports[] values() {
//        return Sports.values();
//    }

}
