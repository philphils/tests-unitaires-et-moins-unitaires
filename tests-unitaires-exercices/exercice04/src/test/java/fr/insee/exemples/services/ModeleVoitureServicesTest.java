package fr.insee.exemples.services;

<<<<<<< HEAD

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
=======
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
>>>>>>> refs/heads/TP_EXERCICES

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import fr.insee.exemple.model.Carburant;
import fr.insee.exemple.model.ModeleVoiture;
import fr.insee.exemple.services.Horloge;
import fr.insee.exemple.services.ModeleVoitureServices;

public class ModeleVoitureServicesTest {

<<<<<<< HEAD
	
	// PROBLEME : Ce test va dépendre de la date du jour. Donc dans 1 an son résultat ne sera plus bon.
	
=======
	private ModeleVoitureServices mvs = new ModeleVoitureServices();

	// cf. solution 3 sur assertions multiples
	@Rule
	public ErrorCollector collector = new ErrorCollector();

>>>>>>> refs/heads/TP_EXERCICES
	@Test
	public void filtrerModelesMoinsPolluantsTest() {
		// GIVEN
	
		// Ce test se déroulera comme si on était le 1er janvier 2019
		Horloge.fixNow(LocalDate.of(2019, 1, 1));
		
		final ModeleVoiture citroenSaxoEssence1995 = new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE,	 	LocalDate.of(1995, 01, 01));
		final ModeleVoiture peugeot405Diesel2000 = new ModeleVoiture("Peugeot", "405",  Carburant.DIESEL,  	LocalDate.of(2000, 01, 01));
		final ModeleVoiture renaultClioEssence1999 = new ModeleVoiture("Renault", "Clio", Carburant.ESSENCE, 	LocalDate.of(2014, 01, 01));
		final ModeleVoiture citroenSaxoElectrique2015 = new ModeleVoiture("Citroen", "Saxo", Carburant.ELECTRIQUE, 	LocalDate.of(2015, 01, 01));
		final ModeleVoiture renaultClioGpl2013 = new ModeleVoiture("Renault", "Clio", Carburant.GPL, 		LocalDate.of(2013, 01, 01));
		
		List<ModeleVoiture> modeles = new ArrayList<>();
<<<<<<< HEAD
		modeles.add(citroenSaxoEssence1995 );
		modeles.add(peugeot405Diesel2000 );
		modeles.add(renaultClioEssence1999 );
		modeles.add(citroenSaxoElectrique2015 );
		modeles.add(renaultClioGpl2013 );
		
=======
		modeles.add(
				new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE, DateUtils.asDate(LocalDate.of(1995, 01, 01))));
		modeles.add(
				new ModeleVoiture("Peugeot", "405", Carburant.DIESEL, DateUtils.asDate(LocalDate.of(2000, 01, 01))));

		ModeleVoiture modeleMoinsPolluant1 = new ModeleVoiture("Renault", "Clio", Carburant.ESSENCE,
				DateUtils.asDate(LocalDate.of(1999, 01, 01)));
		modeles.add(modeleMoinsPolluant1);
		ModeleVoiture modeleMoinsPolluant2 = new ModeleVoiture("Renault", "Clio", Carburant.DIESEL,
				DateUtils.asDate(LocalDate.of(2015, 01, 01)));
		modeles.add(modeleMoinsPolluant2);
		ModeleVoiture modeleMoinsPolluant3 = new ModeleVoiture("Citroen", "Saxo", Carburant.ELECTRIQUE,
				DateUtils.asDate(LocalDate.of(2015, 01, 01)));
		modeles.add(modeleMoinsPolluant3);
		ModeleVoiture modeleMoinsPolluant4 = new ModeleVoiture("Renault", "Clio", Carburant.GPL,
				DateUtils.asDate(LocalDate.of(2013, 01, 01)));
		modeles.add(modeleMoinsPolluant4);

>>>>>>> refs/heads/TP_EXERCICES
		System.out.println("Liste des modèles avant filtrage");
		for (ModeleVoiture modeleVoiture : modeles) {
			System.out.println(modeleVoiture);
		}

<<<<<<< HEAD
		// WHEN
		ModeleVoitureServices service = new ModeleVoitureServices();
		List<ModeleVoiture> voituresMoinsPolluantes = service.filtrerModelesMoinsPolluants(modeles);
		
		// THEN
=======
		List<ModeleVoiture> modelesPeuPolluants = mvs.filtrerModelesMoinsPolluants(modeles);

>>>>>>> refs/heads/TP_EXERCICES
		System.out.println("Liste des modèles après filtrage");
		for (ModeleVoiture modeleVoiture : voituresMoinsPolluantes) {
			System.out.println(modeleVoiture);
		}
<<<<<<< HEAD
		
	
		// modeles attendus après filtrage
		
		assertThat(voituresMoinsPolluantes, 
				containsInAnyOrder(renaultClioEssence1999, citroenSaxoElectrique2015, renaultClioGpl2013)
				);
	}
	
	
	// NE PAS OUBLIER DE REMETTRE L'HORLOGE A ZERO POUR LES AUTRES TESTS OU TRAITEMENTS 
	@After
    public void reinitHorloge() {
		Horloge.fixNow(null);
=======

		// Solution 1
		// assertThat("contient tous les moins polluants", modelesPeuPolluants,
		// hasItems(modeleMoinsPolluant1, modeleMoinsPolluant2, modeleMoinsPolluant3,
		// modeleMoinsPolluant4));
		// assertThat("contient exactement 4 éléments", modelesPeuPolluants.size(),
		// equalTo(4));

		// Solution 2
		// assertThat("contient exactement tous les moins polluants",
		// modelesPeuPolluants, allOf(hasItems(modeleMoinsPolluant1,
		// modeleMoinsPolluant2, modeleMoinsPolluant3, modeleMoinsPolluant4),
		// hasSize(4)));

		// Solution 3 - cf.
		// https://carminetech.wordpress.com/2015/10/30/junit-how-to-collect-multiple-assertion-results-in-one-test/
		collector.checkThat(modelesPeuPolluants,
				hasItems(modeleMoinsPolluant1, modeleMoinsPolluant2, modeleMoinsPolluant3, modeleMoinsPolluant4));
		collector.checkThat(modelesPeuPolluants.size(), equalTo(4));
>>>>>>> refs/heads/TP_EXERCICES
	}
}
