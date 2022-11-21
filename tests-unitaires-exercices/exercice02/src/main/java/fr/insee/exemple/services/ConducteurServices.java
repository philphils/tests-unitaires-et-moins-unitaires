package fr.insee.exemple.services;

import java.util.ArrayList;
import java.util.List;

import fr.insee.exemple.model.Conducteur;
import fr.insee.exemple.model.ModeleVoiture;
import fr.insee.exemple.model.Voiture;

public class ConducteurServices {

	private ModeleVoitureServices modeleVoitureServices;

	public ConducteurServices(ModeleVoitureServices modeleVoitureServices) {
		this.modeleVoitureServices = modeleVoitureServices;
	}

	/**
	 * Correction sans Java 8
	 */
	public List<Conducteur> filtrerConducteursPossedantAuMoinsUnModelePeuPolluant(List<Conducteur> conducteurs) {

		List<Conducteur> conducteursResult = new ArrayList<>();

		// Correction 1 : Sans Java 8
		for (Conducteur conducteur : conducteurs) {

			List<ModeleVoiture> modeleVoitures = new ArrayList<>();

			for (Voiture voiture : conducteur.getVoitures()) {

				modeleVoitures.add(voiture.getModele());

			}

			if (modeleVoitureServices.filtrerModelesMoinsPolluants(modeleVoitures).size() > 0) {
				conducteursResult.add(conducteur);
			}

		}

		return conducteursResult;

	}

	/**
	 * Correction avec Java 8
	 */
//	private boolean estUnConducteurPossedantAuMoinsUnModelePeuPolluant(Conducteur conducteur) {
//		List<ModeleVoiture> modelesPossedesParConducteur = conducteur.getVoitures().stream().map(Voiture::getModele).collect(Collectors.toList());
//		return !modeleVoitureServices.filtrerModelesMoinsPolluants(modelesPossedesParConducteur).isEmpty();
//	}
//	
//	public List<Conducteur> filtrerConducteursPossedantAuMoinsUnModelePeuPolluant(List<Conducteur> conducteurs) {
//		return conducteurs.stream()
//				.filter(this::estUnConducteurPossedantAuMoinsUnModelePeuPolluant)
//				.collect(Collectors.toList());
//	}
}
