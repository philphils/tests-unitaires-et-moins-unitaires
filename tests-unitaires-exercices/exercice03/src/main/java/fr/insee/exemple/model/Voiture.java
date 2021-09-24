package fr.insee.exemple.model;

import java.util.Objects;

public class Voiture {

	private String immatriculation;
	private ModeleVoiture modele;

	public Voiture(String immatriculation, ModeleVoiture modele) {
		super();
		this.immatriculation = immatriculation;
		this.modele = modele;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public ModeleVoiture getModele() {
		return modele;
	}

	public void setModele(ModeleVoiture modele) {
		this.modele = modele;
	}

	@Override
	public int hashCode() {
		return Objects.hash(immatriculation, modele);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voiture other = (Voiture) obj;
		return Objects.equals(immatriculation, other.immatriculation) && Objects.equals(modele, other.modele);
	}

	@Override
	public String toString() {
		return String.format("Voiture [immatriculation=%s, modele=%s]", immatriculation, modele);
	}

}
