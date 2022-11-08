package fr.insee.exemple.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Conducteur {

	private String nom;
	private String prenom;
	private String mail;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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
		return Objects.hash(mail, nom, prenom, voitures);
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
		return Objects.equals(mail, other.mail) && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom) && Objects.equals(voitures, other.voitures);
	}

	@Override
	public String toString() {
		return "Conducteur [nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", voitures=" + voitures + "]";
	}
	
	
	

}
