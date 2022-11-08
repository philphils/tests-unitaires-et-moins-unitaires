package fr.insee.exemple.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.insee.exemple.model.Carburant;
import fr.insee.exemple.model.Conducteur;
import fr.insee.exemple.model.ModeleVoiture;
import fr.insee.exemple.model.Voiture;
import fr.insee.exemple.services.exceptions.ServeurMailConnexionException;

public class ConducteurServicesMessagerieTest {

	// EXERCICE 3 BIS//

	/**
	 * 1 - Tester qu'on récupère bien l'exception si le service de messagerie n'est
	 * pas mocké. Modifier l'annotation @Test au besoin
	 */
	@Test(expected = ServeurMailConnexionException.class)
	public void testServeurMailConnexionException() throws ServeurMailConnexionException {
		// GIVEN
		List<ModeleVoiture> modeles = new ArrayList<>();
		modeles.add(new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE, LocalDate.of(1995, 01, 01)));
		modeles.add(new ModeleVoiture("Peugeot", "405", Carburant.DIESEL, LocalDate.of(2000, 01, 01)));
		modeles.add(new ModeleVoiture("Renault", "Clio", Carburant.ESSENCE, LocalDate.of(1999, 01, 01)));
		modeles.add(new ModeleVoiture("Renault", "Clio", Carburant.DIESEL, LocalDate.of(2015, 01, 01)));
		modeles.add(new ModeleVoiture("Citroen", "Saxo", Carburant.ELECTRIQUE, LocalDate.of(2015, 01, 01)));
		modeles.add(new ModeleVoiture("Renault", "Clio", Carburant.GPL, LocalDate.of(2013, 01, 01)));

		final Conducteur conducteur = new Conducteur("CONDUCTEUR AVEC UNE VOITURE POLLUANTE SUR 5", "x");
		conducteur.addVoiture(new Voiture("1", modeles.get(0)));
		conducteur.addVoiture(new Voiture("2", modeles.get(1)));
		conducteur.addVoiture(new Voiture("3", modeles.get(2)));
		conducteur.addVoiture(new Voiture("4", modeles.get(3)));
		conducteur.addVoiture(new Voiture("5", modeles.get(4)));
		conducteur.addVoiture(new Voiture("6", modeles.get(5)));

		conducteur.setMail("conducteur@pollution.mail");

		/*
		 * Compléter à partir d'ici
		 */

	}

	/**
	 * 2 - Testez la méthode filtrerModelePolluantEtAvertirConducteur en mockant la
	 * interface IMessagerieService Vérifier qu'il y a bien 4 voitures
	 * non-polluantes à l'issue.
	 * 
	 * @throws ServeurMailConnexionException
	 */
	@Test
	public void testFiltrerModelePolluantEtAvertirConducteur() throws ServeurMailConnexionException {

		// GIVEN
		List<ModeleVoiture> modeles = new ArrayList<>();
		modeles.add(new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE, LocalDate.of(1995, 01, 01)));
		modeles.add(new ModeleVoiture("Peugeot", "405", Carburant.DIESEL, LocalDate.of(2000, 01, 01)));
		modeles.add(new ModeleVoiture("Renault", "Clio", Carburant.ESSENCE, LocalDate.of(1999, 01, 01)));
		modeles.add(new ModeleVoiture("Renault", "Clio", Carburant.DIESEL, LocalDate.of(2015, 01, 01)));
		modeles.add(new ModeleVoiture("Citroen", "Saxo", Carburant.ELECTRIQUE, LocalDate.of(2015, 01, 01)));
		modeles.add(new ModeleVoiture("Renault", "Clio", Carburant.GPL, LocalDate.of(2013, 01, 01)));

		final Conducteur conducteur = new Conducteur("CONDUCTEUR AVEC UNE VOITURE POLLUANTE SUR 5", "x");
		conducteur.addVoiture(new Voiture("1", modeles.get(0)));
		conducteur.addVoiture(new Voiture("2", modeles.get(1)));
		conducteur.addVoiture(new Voiture("3", modeles.get(2)));
		conducteur.addVoiture(new Voiture("4", modeles.get(3)));
		conducteur.addVoiture(new Voiture("5", modeles.get(4)));
		conducteur.addVoiture(new Voiture("6", modeles.get(5)));

		conducteur.setMail("conducteur@pollution.mail");

		/*
		 * Compléter à partir d'ici
		 */

	}

}
