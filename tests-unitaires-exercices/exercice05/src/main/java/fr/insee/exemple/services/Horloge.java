package fr.insee.exemple.services;

import java.time.LocalDate;

public class Horloge {
	
	private static LocalDate fixedNow;
	
	public static void fixNow(LocalDate fixedNow) {
		Horloge.fixedNow = fixedNow;
	}

	public static LocalDate now() {
		return fixedNow == null ? LocalDate.now() : fixedNow;
	}
}