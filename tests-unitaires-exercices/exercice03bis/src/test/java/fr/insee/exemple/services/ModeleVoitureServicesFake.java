package fr.insee.exemple.services;

import java.util.List;

import fr.insee.exemple.model.ModeleVoiture;

public class ModeleVoitureServicesFake implements IModeleVoitureServices {

	@Override
	public List<ModeleVoiture> filtrerModelesMoinsPolluants(List<ModeleVoiture> modeles) {
		return modeles;
	}
	
}
