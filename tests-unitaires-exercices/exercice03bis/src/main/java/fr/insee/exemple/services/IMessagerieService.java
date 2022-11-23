package fr.insee.exemple.services;

import fr.insee.exemple.model.Conducteur;
import fr.insee.exemple.services.exceptions.ConnexionServeurMailException;

public interface IMessagerieService {

	/**
	 * Envoi un message au conducteur
	 * 
	 * @param conducteur
	 * @param message    TODO
	 * @return Renvoie le message destiné au conducteur (qui est passé en paramêtre)
	 * @throws ConnexionServeurMailException
	 */
	public String avertirConducteur(Conducteur conducteur, String message) throws ConnexionServeurMailException;

}
