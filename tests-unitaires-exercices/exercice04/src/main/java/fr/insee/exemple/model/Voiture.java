package fr.insee.exemple.model;

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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((immatriculation == null) ? 0 : immatriculation.hashCode());
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
		Voiture other = (Voiture) obj;
		if (immatriculation == null) {
			if (other.immatriculation != null)
				return false;
		} else if (!immatriculation.equals(other.immatriculation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Voiture [immatriculation=%s, modele=%s]", immatriculation, modele);
	}

}
