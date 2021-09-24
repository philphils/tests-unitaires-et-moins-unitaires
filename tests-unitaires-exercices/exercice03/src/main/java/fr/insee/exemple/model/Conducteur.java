package fr.insee.exemple.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Conducteur {

	private String nom;
	private String prenom;
	private Set<Voiture> voitures;

	public Conducteur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		voitures = new HashSet<>();
	}

	public Set<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(Set<Voiture> voitures) {
		this.voitures = voitures;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Set<Voiture> addVoiture(Voiture nouvelleVoiture) {
		voitures.add(nouvelleVoiture);
		return voitures;
	}

	public Set<Voiture> removeVoiture(Voiture ancienneVoiture) {
		voitures.remove(ancienneVoiture);
		return voitures;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom, prenom);
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
		return Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}

	@Override
	public String toString() {
		return String.format("Conducteur [nom=%s, prenom=%s, voitures=%s]", nom, prenom, voitures);
	}

}
