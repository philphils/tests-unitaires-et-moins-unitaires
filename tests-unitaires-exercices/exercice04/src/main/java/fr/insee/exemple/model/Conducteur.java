package fr.insee.exemple.model;

import java.util.ArrayList;
import java.util.List;

public class Conducteur {

	private String nom;
	private String prenom;
	private List<Voiture> voitures;

	public Conducteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.voitures = new ArrayList<>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	@Override
	public String toString() {
		return String.format("Conducteur [nom=%s, prenom=%s, voitures=%s]", nom, prenom, voitures);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conducteur other = (Conducteur) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	public void addVoiture(Voiture nouvelleVoiture) {
		voitures.add(nouvelleVoiture);
	}
	
}
