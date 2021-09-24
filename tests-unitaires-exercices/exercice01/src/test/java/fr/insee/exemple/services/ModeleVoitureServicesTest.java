package fr.insee.exemple.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.insee.exemple.model.Carburant;
import fr.insee.exemple.model.ModeleVoiture;

public class ModeleVoitureServicesTest {

	public void filtrerModelesMoinsPolluantsTest() {
		// GIVEN
		final ModeleVoiture citroenSaxoEssence1995 = new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE,	 	LocalDate.of(1995, 01, 01));
		final ModeleVoiture peugeot405Diesel2000 = new ModeleVoiture("Peugeot", "405",  Carburant.DIESEL,  	LocalDate.of(2000, 01, 01));
		final ModeleVoiture renaultClioEssence1999 = new ModeleVoiture("Renault", "Clio", Carburant.ESSENCE, 	LocalDate.of(1999, 01, 01));
		final ModeleVoiture citroenSaxoElectrique2015 = new ModeleVoiture("Citroen", "Saxo", Carburant.ELECTRIQUE, 	LocalDate.of(2015, 01, 01));
		final ModeleVoiture renaultClioGpl2013 = new ModeleVoiture("Renault", "Clio", Carburant.GPL, 		LocalDate.of(2013, 01, 01));
		
		List<ModeleVoiture> modeles = new ArrayList<>();
		modeles.add(citroenSaxoEssence1995 );
		modeles.add(peugeot405Diesel2000 );
		modeles.add(renaultClioEssence1999 );
		modeles.add(citroenSaxoElectrique2015 );
		modeles.add(renaultClioGpl2013 );
		
		System.out.println("Liste des modèles avant filtrage");
		for (ModeleVoiture modeleVoiture : modeles) {
			System.out.println(modeleVoiture);
		}

		// WHEN
		ModeleVoitureServices service = new ModeleVoitureServices();
		List<ModeleVoiture> voituresMoinsPolluantes = service.filtrerModelesMoinsPolluants(modeles);
		
		// THEN
		System.out.println("Liste des modèles après filtrage");
		for (ModeleVoiture modeleVoiture : voituresMoinsPolluantes) {
			System.out.println(modeleVoiture);
		}
		
		final List<ModeleVoiture> voituresMoinsPolluantesAttendues = Arrays.asList(renaultClioEssence1999, citroenSaxoElectrique2015, renaultClioGpl2013);
		for (ModeleVoiture modeleVoitureAttendu : voituresMoinsPolluantesAttendues) {
			if (!voituresMoinsPolluantes.contains(modeleVoitureAttendu)) {
				System.out.println("Erreur : Le modèle " + modeleVoitureAttendu + " devrait figurer dans le résultat.");
			}
		}
		for (ModeleVoiture modeleVoiture : voituresMoinsPolluantes) {
			if (!voituresMoinsPolluantesAttendues.contains(modeleVoiture)) {
				System.out.println("Erreur : Le modèle " + modeleVoiture + " ne devrait pas figurer dans le résultat.");
			}
		}

	}
	
	public static void main(String[] args) {
		new ModeleVoitureServicesTest().filtrerModelesMoinsPolluantsTest();
	}
	
	
}
