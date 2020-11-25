package fr.insee.formation.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonneTest {

	@Test
	public void testerCreationUnePersonne() {
		// Given
		final String nom = "DURAND";
		final String prenom = "Mathieu";

		// when
		Personne unePersonne = new Personne(nom, prenom);
		
		// then
		assertEquals("Erreur sur la personne créée", 
				"Personne [nom=" + nom + ", prenom=" + prenom + "]", 
				unePersonne.toString());
		
	}

	@Test
	public void testerTutu() {
//		// contexte
//		MaClasseBatch.main("TRACE");
//		//vérifications
	}
}
