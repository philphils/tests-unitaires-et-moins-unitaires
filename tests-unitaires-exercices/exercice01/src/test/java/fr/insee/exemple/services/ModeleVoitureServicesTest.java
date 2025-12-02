package fr.insee.exemple.services;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.insee.exemple.model.Carburant;
import fr.insee.exemple.model.ModeleVoiture;

public class ModeleVoitureServicesTest {

	@Test
	public void testFiltrerModelesMoinsPolluants() {
		// GIVEN
		final ModeleVoiture citroenSaxoEssence1995 = new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE,
				LocalDate.of(1995, 01, 01));
		final ModeleVoiture peugeot405Diesel2000 = new ModeleVoiture("Peugeot", "405", Carburant.DIESEL,
				LocalDate.of(2000, 01, 01));
		final ModeleVoiture renaultClioEssence1999 = new ModeleVoiture("Renault", "Clio", Carburant.ESSENCE,
				LocalDate.of(1999, 01, 01));
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

		// WHEN
		ModeleVoitureServices service = new ModeleVoitureServices();
		List<ModeleVoiture> voituresMoinsPolluantes = service.filtrerModelesMoinsPolluants(modeles);

		// THEN
		System.out.println("Liste des modèles après filtrage");
		for (ModeleVoiture modeleVoiture : voituresMoinsPolluantes) {
			System.out.println(modeleVoiture);
		}

		// modeles attendus après filtrage
		assertTrue(voituresMoinsPolluantes.contains(renaultClioEssence1999));
		assertTrue(voituresMoinsPolluantes.contains(citroenSaxoElectrique2015));
		assertTrue(voituresMoinsPolluantes.contains(renaultClioGpl2013));

		assertEquals(3, voituresMoinsPolluantes.size());

		// Avec les Matcher (cf partie suivante du diapo)
		assertThat(voituresMoinsPolluantes).containsExactlyInAnyOrder(renaultClioEssence1999, citroenSaxoElectrique2015,
				renaultClioGpl2013);

	}

}
