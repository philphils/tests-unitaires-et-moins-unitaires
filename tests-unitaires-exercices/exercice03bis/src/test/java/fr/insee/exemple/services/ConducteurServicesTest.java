package fr.insee.exemple.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.insee.exemple.model.Carburant;
import fr.insee.exemple.model.Conducteur;
import fr.insee.exemple.model.ModeleVoiture;
import fr.insee.exemple.model.Voiture;

public class ConducteurServicesTest {

	@Test
	public void filtrerConducteursPossedantToujoursAuMoinsUnModelePeuPolluantTest() {
		// GIVEN
<<<<<<< HEAD
		
		// Un modele (peu polluant ou pas, peu importe)
		final ModeleVoiture unModele = new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE,	 	LocalDate.of(1995, 01, 01));
		
		// Des conducteurs
		final Conducteur conducteurAvecUnSeulVehicule = new Conducteur("POLLUEUR", "x"); 
		conducteurAvecUnSeulVehicule.addVoiture(new Voiture("1", unModele));
		
		final Conducteur conducteurAvecDeuxVehicules= new Conducteur("MOYENPOLLUEUR", "x"); 
		conducteurAvecDeuxVehicules.addVoiture(new Voiture("3", unModele));
		conducteurAvecDeuxVehicules.addVoiture(new Voiture("4", unModele));

		List<Conducteur> conducteurs = Arrays.asList(conducteurAvecDeuxVehicules, conducteurAvecUnSeulVehicule);

		// WHEN
		IModeleVoitureServices modeleVoitureServices = Mockito.mock(IModeleVoitureServices.class);
		Mockito.when(modeleVoitureServices.filtrerModelesMoinsPolluants(Mockito.anyListOf(ModeleVoiture.class))).thenReturn(Arrays.asList(unModele));
		ConducteurServices conducteurServices = new ConducteurServices(modeleVoitureServices);
		List<Conducteur> conducteursAvecAuMoinsUneVoiturePeuPolluante = conducteurServices.filtrerConducteursPossedantAuMoinsUnModelePeuPolluant(conducteurs);
		
		// THEN
		assertThat(conducteursAvecAuMoinsUneVoiturePeuPolluante, 
				containsInAnyOrder(conducteurAvecDeuxVehicules, conducteurAvecUnSeulVehicule)
				);
	}
	
	
	@Test
	public void filtrerConducteurNePossedantJamaisUnModelePeuPolluantTest() {
		// GIVEN
		
		// Un modele (peu polluant ou pas, peu importe)
		final ModeleVoiture unModele = new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE,	 	LocalDate.of(1995, 01, 01));
		
		// Des conducteurs
		final Conducteur conducteurAvecUnSeulVehicule = new Conducteur("POLLUEUR", "x"); 
		conducteurAvecUnSeulVehicule.addVoiture(new Voiture("1", unModele));
		
		final Conducteur conducteurAvecDeuxVehicules= new Conducteur("MOYENPOLLUEUR", "x"); 
		conducteurAvecDeuxVehicules.addVoiture(new Voiture("3", unModele));
		conducteurAvecDeuxVehicules.addVoiture(new Voiture("4", unModele));

		List<Conducteur> conducteurs = Arrays.asList(conducteurAvecDeuxVehicules, conducteurAvecUnSeulVehicule);

		// WHEN
		
		// Ici on utilise une lambda directement pour donner le comportement du fake : c'est possible car on a affaire à une interface fonctionnelle
		// Donc on va faire un service qui renvoie tjs une liste vide signifiant que jamais un modele n'est peu polluant.
		IModeleVoitureServices modeleVoitureServices = Mockito.mock(IModeleVoitureServices.class);
		Mockito.when(modeleVoitureServices.filtrerModelesMoinsPolluants(Mockito.anyListOf(ModeleVoiture.class))).thenReturn(new ArrayList<ModeleVoiture>());
		ConducteurServices conducteurServices = new ConducteurServices(modeleVoitureServices);
		List<Conducteur> conducteursAvecAuMoinsUneVoiturePeuPolluante = conducteurServices.filtrerConducteursPossedantAuMoinsUnModelePeuPolluant(conducteurs);
		
		// THEN
		assertTrue(conducteursAvecAuMoinsUneVoiturePeuPolluante.isEmpty());
	}
	
	
	
	// ce test n'est pas du tout nécessaire d'un point de vue couverture de test : c'est du temps perdu !
	@SuppressWarnings("unchecked")
	// Mais c'est pour montrer une mise en oeuvre plus compliquée d'un fake
	@Test
	public void filtrerConducteurTest() {
		// GIVEN
		
		// Un modele (peu polluant ou pas, peu importe)
		final ModeleVoiture unModele = new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE,	 	LocalDate.of(1995, 01, 01));
		
		// Des conducteurs
		final Conducteur conducteurAvecUnSeulVehicule = new Conducteur("POLLUEUR", "x"); 
		conducteurAvecUnSeulVehicule.addVoiture(new Voiture("1", unModele));
		
		final Conducteur conducteurAvecDeuxVehicules= new Conducteur("MOYENPOLLUEUR", "x"); 
		conducteurAvecDeuxVehicules.addVoiture(new Voiture("3", unModele));
		conducteurAvecDeuxVehicules.addVoiture(new Voiture("4", unModele));

		List<Conducteur> conducteurs = Arrays.asList(conducteurAvecDeuxVehicules, conducteurAvecUnSeulVehicule);

		// WHEN
		
		// Ici on utilise une lambda directement pour donner le comportement du fake : c'est possible car on a affaire à une interface fonctionnelle
		// Donc on va faire un service qui renvoie une liste vide 1 fois sur 2
		IModeleVoitureServices modeleVoitureServices = Mockito.mock(IModeleVoitureServices.class);
		Mockito.when(modeleVoitureServices.filtrerModelesMoinsPolluants(Mockito.anyListOf(ModeleVoiture.class))).thenReturn(Arrays.asList(unModele), new ArrayList<ModeleVoiture>());
		ConducteurServices conducteurServices = new ConducteurServices(modeleVoitureServices);
		List<Conducteur> conducteursAvecAuMoinsUneVoiturePeuPolluante = conducteurServices.filtrerConducteursPossedantAuMoinsUnModelePeuPolluant(conducteurs);
		
		// THEN
		assertThat(conducteursAvecAuMoinsUneVoiturePeuPolluante, 
				containsInAnyOrder(conducteurAvecDeuxVehicules)
				);
	}
	
=======

		// Un modele (peu polluant ou pas, peu importe)
		final ModeleVoiture unModele = new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE,
				LocalDate.of(1995, 01, 01));

		// Des conducteurs
		final Conducteur conducteurAvecUnSeulVehicule = new Conducteur("POLLUEUR", "x");
		conducteurAvecUnSeulVehicule.addVoiture(new Voiture("1", unModele));

		final Conducteur conducteurAvecDeuxVehicules = new Conducteur("MOYENPOLLUEUR", "x");
		conducteurAvecDeuxVehicules.addVoiture(new Voiture("3", unModele));
		conducteurAvecDeuxVehicules.addVoiture(new Voiture("4", unModele));

		List<Conducteur> conducteurs = Arrays.asList(conducteurAvecDeuxVehicules, conducteurAvecUnSeulVehicule);

		// WHEN
		IModeleVoitureServices modeleVoitureServices = Mockito.mock(IModeleVoitureServices.class);
		Mockito.when(modeleVoitureServices.filtrerModelesMoinsPolluants(Mockito.anyList()))
				.thenReturn(Arrays.asList(unModele));
		ConducteurServices conducteurServices = new ConducteurServices(modeleVoitureServices);
		List<Conducteur> conducteursAvecAuMoinsUneVoiturePeuPolluante = conducteurServices
				.filtrerConducteursPossedantAuMoinsUnModelePeuPolluant(conducteurs);

		// THEN
		assertThat(conducteursAvecAuMoinsUneVoiturePeuPolluante,
				containsInAnyOrder(conducteurAvecDeuxVehicules, conducteurAvecUnSeulVehicule));
	}

	@Test
	public void filtrerConducteurNePossedantJamaisUnModelePeuPolluantTest() {
		// GIVEN

		// Un modele (peu polluant ou pas, peu importe)
		final ModeleVoiture unModele = new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE,
				LocalDate.of(1995, 01, 01));

		// Des conducteurs
		final Conducteur conducteurAvecUnSeulVehicule = new Conducteur("POLLUEUR", "x");
		conducteurAvecUnSeulVehicule.addVoiture(new Voiture("1", unModele));

		final Conducteur conducteurAvecDeuxVehicules = new Conducteur("MOYENPOLLUEUR", "x");
		conducteurAvecDeuxVehicules.addVoiture(new Voiture("3", unModele));
		conducteurAvecDeuxVehicules.addVoiture(new Voiture("4", unModele));

		List<Conducteur> conducteurs = Arrays.asList(conducteurAvecDeuxVehicules, conducteurAvecUnSeulVehicule);

		// WHEN

		// Ici on utilise une lambda directement pour donner le comportement du fake :
		// c'est possible car on a affaire à une interface fonctionnelle
		// Donc on va faire un service qui renvoie tjs une liste vide signifiant que
		// jamais un modele n'est peu polluant.
		IModeleVoitureServices modeleVoitureServices = Mockito.mock(IModeleVoitureServices.class);
		Mockito.when(modeleVoitureServices.filtrerModelesMoinsPolluants(Mockito.anyList()))
				.thenReturn(new ArrayList<ModeleVoiture>());
		ConducteurServices conducteurServices = new ConducteurServices(modeleVoitureServices);
		List<Conducteur> conducteursAvecAuMoinsUneVoiturePeuPolluante = conducteurServices
				.filtrerConducteursPossedantAuMoinsUnModelePeuPolluant(conducteurs);

		// THEN
		assertTrue(conducteursAvecAuMoinsUneVoiturePeuPolluante.isEmpty());
	}

	// ce test n'est pas du tout nécessaire d'un point de vue couverture de test :
	// c'est du temps perdu !
	@SuppressWarnings("unchecked")
	// Mais c'est pour montrer une mise en oeuvre plus compliquée d'un fake
	@Test
	public void filtrerConducteurTest() {
		// GIVEN

		// Un modele (peu polluant ou pas, peu importe)
		final ModeleVoiture unModele = new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE,
				LocalDate.of(1995, 01, 01));

		// Des conducteurs
		final Conducteur conducteurAvecUnSeulVehicule = new Conducteur("POLLUEUR", "x");
		conducteurAvecUnSeulVehicule.addVoiture(new Voiture("1", unModele));

		final Conducteur conducteurAvecDeuxVehicules = new Conducteur("MOYENPOLLUEUR", "x");
		conducteurAvecDeuxVehicules.addVoiture(new Voiture("3", unModele));
		conducteurAvecDeuxVehicules.addVoiture(new Voiture("4", unModele));

		List<Conducteur> conducteurs = Arrays.asList(conducteurAvecDeuxVehicules, conducteurAvecUnSeulVehicule);

		// WHEN

		// Ici on utilise une lambda directement pour donner le comportement du fake :
		// c'est possible car on a affaire à une interface fonctionnelle
		// Donc on va faire un service qui renvoie une liste vide 1 fois sur 2
		IModeleVoitureServices modeleVoitureServices = Mockito.mock(IModeleVoitureServices.class);
		Mockito.when(modeleVoitureServices.filtrerModelesMoinsPolluants(Mockito.anyList()))
				.thenReturn(Arrays.asList(unModele), new ArrayList<ModeleVoiture>());
		ConducteurServices conducteurServices = new ConducteurServices(modeleVoitureServices);
		List<Conducteur> conducteursAvecAuMoinsUneVoiturePeuPolluante = conducteurServices
				.filtrerConducteursPossedantAuMoinsUnModelePeuPolluant(conducteurs);

		// THEN
		assertThat(conducteursAvecAuMoinsUneVoiturePeuPolluante, containsInAnyOrder(conducteurAvecDeuxVehicules));
	}
>>>>>>> refs/heads/TP_EXERCICES

}
