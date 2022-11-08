package fr.insee.exemple.services.exceptions;

public class ServeurMailConnexionException extends Exception {
	
	public ServeurMailConnexionException() {
		super("Connexion impossible au serveur de messagerie mail");
	}

}
