package fr.insee.exemple.services.exceptions;

public class EnvoiMailException extends Exception {

	public EnvoiMailException(String message, Exception exception) {
		super(message, exception);
	}

}
