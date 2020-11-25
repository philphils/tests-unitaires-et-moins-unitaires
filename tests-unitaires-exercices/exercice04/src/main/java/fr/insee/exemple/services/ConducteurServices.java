package fr.insee.exemple.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.insee.exemple.model.Conducteur;
import fr.insee.exemple.model.ModeleVoiture;
import fr.insee.exemple.model.Voiture;

public class ConducteurServices {
	
	private ModeleVoitureServices modeleVoitureServices;
	
	public ConducteurServices() {
		this.modeleVoitureServices = new ModeleVoitureServices();
	}

	public List<Conducteur> filtrerConducteursAvecVoituresMoinsPolluantes(List<Conducteur> conducteurs) {
		List<Conducteur> resultat = new ArrayList<>();
		for (Conducteur conducteur : conducteurs) {
			if (testerSiConducteurPossedeVoitureMoinsPolluante(conducteur))
				resultat.add(conducteur);
		}
		return resultat;
	}

	private boolean testerSiConducteurPossedeVoitureMoinsPolluante(Conducteur conducteur) {
		return modeleVoitureServices.filtrerModelesMoinsPolluants( getModeles( conducteur.getVoitures() ) ).size() > 0;
	}

	private List<ModeleVoiture> getModeles(List<Voiture> voitures) {
		return voitures.stream()
				.map(v -> v.getModele())
				.collect(Collectors.toList());
	}
	

}
