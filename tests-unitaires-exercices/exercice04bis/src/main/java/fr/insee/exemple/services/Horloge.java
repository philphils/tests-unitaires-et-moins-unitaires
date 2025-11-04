package fr.insee.exemple.services;

import java.time.LocalDate;

public class Horloge {
    private static LocalDate now = LocalDate.now();
    
    public static LocalDate now() {
        return now;
    }
    
    public static void set(LocalDate date) {
        now = date;
    }
    
    public static void reset() {
        now = LocalDate.now();
    }
}