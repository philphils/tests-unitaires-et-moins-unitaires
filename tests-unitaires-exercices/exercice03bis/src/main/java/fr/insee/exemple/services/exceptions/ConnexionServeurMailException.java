package fr.insee.exemple.services.exceptions;

public class ConnexionServeurMailException extends Exception {
	
	public ConnexionServeurMailException() {
		super("Connexion impossible au serveur de messagerie mail");
	}

}
