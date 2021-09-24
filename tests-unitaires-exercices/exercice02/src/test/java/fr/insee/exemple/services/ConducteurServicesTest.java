package fr.insee.exemple.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.insee.exemple.model.Carburant;
import fr.insee.exemple.model.Conducteur;
import fr.insee.exemple.model.ModeleVoiture;
import fr.insee.exemple.model.Voiture;

public class ConducteurServicesTest {

	@Test
	public void filtrerConducteursPossedantAuMoinsUnModelePeuPolluantTest() {
		// GIVEN
		
		// Un modele peu polluant et un polluant
		final ModeleVoiture polluant = new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE,	 	LocalDate.of(1995, 01, 01));
		final ModeleVoiture peuPolluant = new ModeleVoiture("Citroen", "Saxo", Carburant.ELECTRIQUE, 	LocalDate.of(2015, 01, 01));
		
		// Des conducteurs
		final Conducteur conducteurAvecUnSeulVehiculePolluant = new Conducteur("POLLUEUR", "x"); 
		conducteurAvecUnSeulVehiculePolluant.addVoiture(new Voiture("1", polluant));
		
		final Conducteur conducteurAvecUnSeulVehiculePeuPolluant = new Conducteur("PEUPOLLUEUR", "x"); 
		conducteurAvecUnSeulVehiculePeuPolluant.addVoiture(new Voiture("2", peuPolluant));

		final Conducteur conducteurAvecUnVehiculePolluantEtUnPeuPolluant = new Conducteur("MOYENPOLLUEUR", "x"); 
		conducteurAvecUnVehiculePolluantEtUnPeuPolluant.addVoiture(new Voiture("3", polluant));
		conducteurAvecUnVehiculePolluantEtUnPeuPolluant.addVoiture(new Voiture("4", peuPolluant));

		List<Conducteur> conducteurs = Arrays.asList(conducteurAvecUnSeulVehiculePolluant, conducteurAvecUnSeulVehiculePeuPolluant, conducteurAvecUnVehiculePolluantEtUnPeuPolluant);

		// WHEN
		ModeleVoitureServices modeleVoitureServices = new ModeleVoitureServices();
		ConducteurServices conducteurServices = new ConducteurServices(modeleVoitureServices);
		List<Conducteur> conducteursAvecAuMoinsUneVoiturePeuPolluante = conducteurServices.filtrerConducteursPossedantAuMoinsUnModelePeuPolluant(conducteurs);
		
		// THEN
		System.out.println("Liste des conducteurs après filtrage");
		for (Conducteur conducteur : conducteursAvecAuMoinsUneVoiturePeuPolluante) {
			System.out.println(conducteur);
		}
		
		assertThat(conducteursAvecAuMoinsUneVoiturePeuPolluante, 
				containsInAnyOrder(conducteurAvecUnSeulVehiculePeuPolluant, conducteurAvecUnVehiculePolluantEtUnPeuPolluant)
				);
	}
}
