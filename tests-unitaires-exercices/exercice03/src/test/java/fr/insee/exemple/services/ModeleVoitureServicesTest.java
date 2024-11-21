package fr.insee.exemple.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.insee.exemple.model.Carburant;
import fr.insee.exemple.model.ModeleVoiture;

public class ModeleVoitureServicesTest {

	private IModeleVoitureServices mvs = new ModeleVoitureServices();

	@Test
	public void testerFiltrerModelesMoinsPolluants() {
		// GIVEN
		List<ModeleVoiture> modeles = new ArrayList<>();
		modeles.add(new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE, LocalDate.of(1995, 01, 01)));
		modeles.add(new ModeleVoiture("Peugeot", "405", Carburant.DIESEL, LocalDate.of(2000, 01, 01)));

		ModeleVoiture modeleMoinsPolluant1 = new ModeleVoiture("Renault", "Clio", Carburant.ESSENCE,
				LocalDate.of(1999, 01, 01));
		modeles.add(modeleMoinsPolluant1);
		ModeleVoiture modeleMoinsPolluant2 = new ModeleVoiture("Renault", "Clio", Carburant.DIESEL,
				LocalDate.of(2015, 01, 01));
		modeles.add(modeleMoinsPolluant2);
		ModeleVoiture modeleMoinsPolluant3 = new ModeleVoiture("Citroen", "Saxo", Carburant.ELECTRIQUE,
				LocalDate.of(2015, 01, 01));
		modeles.add(modeleMoinsPolluant3);
		ModeleVoiture modeleMoinsPolluant4 = new ModeleVoiture("Renault", "Clio", Carburant.GPL,
				LocalDate.of(2013, 01, 01));
		modeles.add(modeleMoinsPolluant4);

		System.out.println("Liste des modèles avant filtrage");
		for (ModeleVoiture modeleVoiture : modeles) {
			System.out.println(modeleVoiture);
		}

		// WHEN
		List<ModeleVoiture> modelesPeuPolluants = mvs.filtrerModelesMoinsPolluants(modeles);

		System.out.println("Liste des modèles après filtrage");
		for (ModeleVoiture modeleVoiture : modelesPeuPolluants) {
			System.out.println(modeleVoiture);
		}

		// THEN
		// avec message d'erreur
		assertThat(modelesPeuPolluants).as("Doit contenir les 4 modèles les moins polluants").containsExactlyInAnyOrder(
				modeleMoinsPolluant1, modeleMoinsPolluant2, modeleMoinsPolluant3, modeleMoinsPolluant4);

	}
}
