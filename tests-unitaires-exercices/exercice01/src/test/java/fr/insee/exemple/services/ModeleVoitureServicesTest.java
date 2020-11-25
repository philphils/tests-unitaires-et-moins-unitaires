package fr.insee.exemple.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.insee.exemple.DateUtils;
import fr.insee.exemple.model.Carburant;
import fr.insee.exemple.model.ModeleVoiture;

public class ModeleVoitureServicesTest {

	@BeforeClass
	public static void avantLEnsembleDesTests() {
		System.out.println("Se lance avant tous les tests");
	}
	
	
	@Before
	public void avantChaqueTest() {
		System.out.println("Se lance avant chaque test");
	}
	
	@Test
	public void testerToujoursVrai() {
		System.out.println("Test tjs vrai");
		assertTrue(true);
	}
	
	@Test
	public void testerFiltrerModelesVoitures() {
		// GIVEN
		final ModeleVoiture modeleCitroenSaxoEssence1995 = new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE,	 	DateUtils.asDate(LocalDate.of(1995, 01, 01)));
		final ModeleVoiture modelePeugeot405Diesel2000 = new ModeleVoiture("Peugeot", "405",  Carburant.DIESEL,  	DateUtils.asDate(LocalDate.of(2000, 01, 01)));
		final ModeleVoiture modeleRenaultClioEssence1999 = new ModeleVoiture("Renault", "Clio", Carburant.ESSENCE, 	DateUtils.asDate(LocalDate.of(1999, 01, 01)));
		final ModeleVoiture modeleCitroenSaxoElectrique2015 = new ModeleVoiture("Citroen", "Saxo", Carburant.ELECTRIQUE, 	DateUtils.asDate(LocalDate.of(2015, 01, 01)));
		final ModeleVoiture modeleRenaultClioGpl2013 = new ModeleVoiture("Renault", "Clio", Carburant.GPL, 		DateUtils.asDate(LocalDate.of(2013, 01, 01)));
		
		List<ModeleVoiture> modeles = new ArrayList<>();
		modeles.add(modeleCitroenSaxoEssence1995);
		modeles.add(modelePeugeot405Diesel2000);
		modeles.add(new ModeleVoiture("Renault", "Clio", Carburant.ESSENCE, 	DateUtils.asDate(LocalDate.of(1999, 01, 01))));
		modeles.add(modeleCitroenSaxoElectrique2015);
		modeles.add(modeleRenaultClioGpl2013);
		
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
		
//		// 1ère façon si on connait l'ordre des réponses attendues
//		List<ModeleVoiture> modelesAttendusApresFlitrage = new ArrayList<>();
//		modelesAttendusApresFlitrage.add(modeleRenaultClioEssence1999);
//		modelesAttendusApresFlitrage.add(modeleCitroenSaxoElectrique2015);
//		modelesAttendusApresFlitrage.add(modeleRenaultClioGpl2013);
//		
//		assertArrayEquals("Les voitures moins polluantes obtenues ne sont pas correctes", modelesAttendusApresFlitrage.toArray(), voituresMoinsPolluantes.toArray());
//	
//		// 2ème façon si on ne connaît pas l'ordre des réponses attendu
//		assertTrue(voituresMoinsPolluantes.contains(modeleRenaultClioEssence1999));
//		assertTrue(voituresMoinsPolluantes.contains(modeleCitroenSaxoElectrique2015));
//		assertTrue(voituresMoinsPolluantes.contains(modeleRenaultClioGpl2013));
//		assertEquals("Nombre d'éléments attendus incorrect- contenu : " + voituresMoinsPolluantes, 3, voituresMoinsPolluantes.size());
	
		assertThat(voituresMoinsPolluantes, 
				containsInAnyOrder(modeleRenaultClioEssence1999, modeleCitroenSaxoElectrique2015, modeleRenaultClioGpl2013)
				);
	}
}
