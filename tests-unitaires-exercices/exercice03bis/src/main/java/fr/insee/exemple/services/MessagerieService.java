package fr.insee.exemple.services;

import fr.insee.exemple.model.Conducteur;
import fr.insee.exemple.services.exceptions.ServeurMailConnexionException;

public class MessagerieService implements IMessagerieService {

	@Override
	public String avertirConducteur(Conducteur conducteur, String message) throws ServeurMailConnexionException {

		return envoyerMail(conducteur.getMail(), message);
	}

	private String envoyerMail(String mail, String message) throws ServeurMailConnexionException {

		if (testConnexionServeurMail()) {
			System.out.println("Mail envoyé à l'adresse : " + mail);
			System.out.println("Corps du message : " + message);
		} else {
			throw new ServeurMailConnexionException();
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
