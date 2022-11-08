package fr.insee.exemple.services;

import java.util.List;
import java.util.stream.Collectors;

import fr.insee.exemple.model.Conducteur;
import fr.insee.exemple.model.ModeleVoiture;
import fr.insee.exemple.model.Voiture;
import fr.insee.exemple.services.exceptions.ServeurMailConnexionException;

public class ConducteurServices {

	private IModeleVoitureServices modeleVoitureServices;

	private IMessagerieService messagerieService;

	public ConducteurServices(IModeleVoitureServices modeleVoitureServices) {
		this.modeleVoitureServices = modeleVoitureServices;
	}

	
	public ConducteurServices(IModeleVoitureServices modeleVoitureServices, IMessagerieService messagerieService) {
		this.modeleVoitureServices = modeleVoitureServices;
		this.messagerieService = messagerieService;
	}
	
	private boolean estUnConducteurPossedantAuMoinsUnModelePeuPolluant(Conducteur conducteur) {
		List<ModeleVoiture> modelesPossedesParConducteur = conducteur.getVoitures().stream().map(Voiture::getModele)
				.collect(Collectors.toList());
		return !modeleVoitureServices.filtrerModelesMoinsPolluants(modelesPossedesParConducteur).isEmpty();
	}

	public List<Conducteur> filtrerConducteursPossedantAuMoinsUnModelePeuPolluant(List<Conducteur> conducteurs) {
		return conducteurs.stream().filter(this::estUnConducteurPossedantAuMoinsUnModelePeuPolluant)
				.collect(Collectors.toList());
	}

	public List<ModeleVoiture> filtrerModelePolluantEtAvertirConducteur(Conducteur conducteur)
			throws ServeurMailConnexionException {
		List<ModeleVoiture> list = modeleVoitureServices.filtrerModelesMoinsPolluants(
				conducteur.getVoitures().stream().map(v -> v.getModele()).collect(Collectors.toList()));
		messagerieService.avertirConducteur(conducteur,
				"Vous avez " + list.size() + " modèles de voitures non polluantes");
		return list;
	}

}
