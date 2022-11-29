package fr.insee.exemples.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import fr.insee.exemple.model.Carburant;
import fr.insee.exemple.model.ModeleVoiture;
import fr.insee.exemple.services.Horloge;
import fr.insee.exemple.services.ModeleVoitureServices;

public class ModeleVoitureServicesMockTest {

	// Correction en utilisant la possibilité de Mockito de mocker les méthodes
	// statiques

	@Test
	public void filtrerModelesMoinsPolluantsTest() {
		// GIVEN

		// Ce test se déroulera comme si on était le 1er janvier 2019

		final ModeleVoiture citroenSaxoEssence1995 = new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE,
				LocalDate.of(1995, 01, 01));
		final ModeleVoiture peugeot405Diesel2000 = new ModeleVoiture("Peugeot", "405", Carburant.DIESEL,
				LocalDate.of(2000, 01, 01));
		final ModeleVoiture renaultClioEssence1999 = new ModeleVoiture("Renault", "Clio", Carburant.ESSENCE,
				LocalDate.of(2014, 01, 01));
		final ModeleVoiture citroenSaxoElectrique2015 = new ModeleVoiture("Citroen", "Saxo", Carburant.ELECTRIQUE,
				LocalDate.of(2015, 01, 01));
		final ModeleVoiture renaultClioGpl2013 = new ModeleVoiture("Renault", "Clio", Carburant.GPL,
				LocalDate.of(2013, 01, 01));

		List<ModeleVoiture> modeles = new ArrayList<>();
		modeles.add(citroenSaxoEssence1995);
		modeles.add(peugeot405Diesel2000);
		modeles.add(renaultClioEssence1999);
		modeles.add(citroenSaxoElectrique2015);
		modeles.add(renaultClioGpl2013);

		System.out.println("Liste des modèles avant filtrage");
		for (ModeleVoiture modeleVoiture : modeles) {
			System.out.println(modeleVoiture);
		}

		List<ModeleVoiture> voituresMoinsPolluantes = null;

		try (MockedStatic<Horloge> utilities = Mockito.mockStatic(Horloge.class)) {

			utilities.when(Horloge::now).thenReturn(LocalDate.of(2019, 1, 1));

			// WHEN
			ModeleVoitureServices service = new ModeleVoitureServices();
			voituresMoinsPolluantes = service.filtrerModelesMoinsPolluants(modeles);

		}

		// THEN
		System.out.println("Liste des modèles après filtrage");
		for (ModeleVoiture modeleVoiture : voituresMoinsPolluantes) {
			System.out.println(modeleVoiture);
		}

		// modeles attendus après filtrage

		assertThat(voituresMoinsPolluantes,
				containsInAnyOrder(renaultClioEssence1999, citroenSaxoElectrique2015, renaultClioGpl2013));
	}

}
