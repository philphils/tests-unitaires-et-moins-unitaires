package fr.insee.exemple.model;

import java.time.LocalDate;

public class ModeleVoiture {
	private String nomConstructeur;
	private String nomModele;
	private Carburant carburant;
	private LocalDate anneeConstruction;

	public ModeleVoiture(String nomConstructeur, String nomModele, Carburant carburant, LocalDate anneeConstruction) {
		super();
		this.nomConstructeur = nomConstructeur;
		this.nomModele = nomModele;
		this.carburant = carburant;
		this.anneeConstruction = anneeConstruction;
	}

	public String getNomConstructeur() {
		return nomConstructeur;
	}

	public void setNomConstructeur(String nomConstructeur) {
		this.nomConstructeur = nomConstructeur;
	}

	public String getNomModele() {
		return nomModele;
	}

	public void setNomModele(String nomModele) {
		this.nomModele = nomModele;
	}

	public Carburant getCarburant() {
		return carburant;
	}

	public void setCarburant(Carburant carburant) {
		this.carburant = carburant;
	}

	public LocalDate getAnneeConstruction() {
		return anneeConstruction;
	}

	public void setAnneeConstruction(LocalDate anneeConstruction) {
		this.anneeConstruction = anneeConstruction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anneeConstruction == null) ? 0 : anneeConstruction.hashCode());
		result = prime * result + ((carburant == null) ? 0 : carburant.hashCode());
		result = prime * result + ((nomConstructeur == null) ? 0 : nomConstructeur.hashCode());
		result = prime * result + ((nomModele == null) ? 0 : nomModele.hashCode());
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
		ModeleVoiture other = (ModeleVoiture) obj;
		if (anneeConstruction == null) {
			if (other.anneeConstruction != null)
				return false;
		} else if (!anneeConstruction.equals(other.anneeConstruction))
			return false;
		if (carburant != other.carburant)
			return false;
		if (nomConstructeur == null) {
			if (other.nomConstructeur != null)
				return false;
		} else if (!nomConstructeur.equals(other.nomConstructeur))
			return false;
		if (nomModele == null) {
			if (other.nomModele != null)
				return false;
		} else if (!nomModele.equals(other.nomModele))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("ModeleVoiture [nomConstructeur=%s, nomModele=%s, carburant=%s, anneeConstruction=%s]",
				nomConstructeur, nomModele, carburant, anneeConstruction);
	}

	
	public Boolean estPeuPolluante() {
		return    Carburant.ELECTRIQUE.equals(carburant)
			   || Carburant.GPL.equals(carburant)
			   || (Carburant.ESSENCE.equals(carburant) && anneeConstruction.isAfter(LocalDate.of(1998,  01,  01)))
			   || (Carburant.DIESEL.equals(carburant) && anneeConstruction.isAfter(LocalDate.of(2011, 01, 01)))
				;
	}

}
