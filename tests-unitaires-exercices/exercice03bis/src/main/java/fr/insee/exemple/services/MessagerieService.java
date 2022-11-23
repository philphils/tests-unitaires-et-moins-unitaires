package fr.insee.exemple.services;

import fr.insee.exemple.model.Conducteur;
import fr.insee.exemple.services.exceptions.ConnexionServeurMailException;

public class MessagerieService implements IMessagerieService {

	@Override
	public String avertirConducteur(Conducteur conducteur, String message) throws ConnexionServeurMailException {

		return envoyerMail(conducteur.getMail(), message);
	}

	private String envoyerMail(String mail, String message) throws ConnexionServeurMailException {

		if (testConnexionServeurMail()) {
			System.out.println("Mail envoyé à l'adresse : " + mail);
			System.out.println("Corps du message : " + message);
		} else {
			throw new ConnexionServeurMailException();
		}

		return message;
	}

	/**
	 * Méthode qui renvoie toujours faux pour les besoins de l'exercice
	 * 
	 * @return
	 */
	private boolean testConnexionServeurMail() {
		return false;
	}

}
