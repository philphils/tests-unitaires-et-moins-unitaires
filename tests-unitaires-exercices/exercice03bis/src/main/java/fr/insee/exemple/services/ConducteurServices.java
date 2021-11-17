package fr.insee.exemple.services;

import java.util.List;
import java.util.stream.Collectors;

import fr.insee.exemple.model.Conducteur;
import fr.insee.exemple.model.ModeleVoiture;
import fr.insee.exemple.model.Voiture;

public class ConducteurServices {
	
	private IModeleVoitureServices modeleVoitureServices;
	
	public ConducteurServices(IModeleVoitureServices modeleVoitureServices) {
		this.modeleVoitureServices = modeleVoitureServices;
	}

	private boolean estUnConducteurPossedantAuMoinsUnModelePeuPolluant(Conducteur conducteur) {
		List<ModeleVoiture> modelesPossedesParConducteur = conducteur.getVoitures().stream().map(Voiture::getModele).collect(Collectors.toList());
		return !modeleVoitureServices.filtrerModelesMoinsPolluants(modelesPossedesParConducteur).isEmpty();
	}
	
	public List<Conducteur> filtrerConducteursPossedantAuMoinsUnModelePeuPolluant(List<Conducteur> conducteurs) {
		return conducteurs.stream()
				.filter(this::estUnConducteurPossedantAuMoinsUnModelePeuPolluant)
				.collect(Collectors.toList());
	}
}
