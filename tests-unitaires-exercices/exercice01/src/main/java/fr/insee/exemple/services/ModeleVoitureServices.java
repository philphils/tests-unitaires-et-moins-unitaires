package fr.insee.exemple.services;

import java.util.List;
import java.util.stream.Collectors;

import fr.insee.exemple.model.ModeleVoiture;

public class ModeleVoitureServices {

	/**
	 * Méthode qui filtre une liste de modèles de voitures pour ne conserver que les modèles considérés comme
	 * peu polluant, à savoir :
	 * - les modèles éléctrique, hybrides ou GPL
	 * - les modèles essences construits après 1997 strictement
	 * - les modèles diesel construits après 2012 strictement
	 * @param modeles
	 * @return liste des modeles considérés comme moins polluants
	 */
	public List<ModeleVoiture> filtrerModelesMoinsPolluants(List<ModeleVoiture> modeles) {
		return modeles.stream()
				.filter(m -> m.estPeuPolluante())
				.collect(Collectors.toList());
	}

}
