package fr.insee.exemple.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.insee.exemple.DateUtils;
import fr.insee.exemple.model.Carburant;
import fr.insee.exemple.model.ModeleVoiture;

public class ModeleVoitureServices {

	/**
	 * Méthode qui filtre une liste de modèles de voitures pour ne conserver que les modèles considérés comme
	 * peu polluant, à savoir :
	 * - les modèles éléctrique, hybrides ou GPL
	 * - les modèles essences construits après 1997 strictement
	 * - les modèles diesel construits après 2012 strictement
	 * @param modeles
	 * @return liste des modeles considérés comme moins polluants
	 */
	public List<ModeleVoiture> filtrerModelesMoinsPolluants(List<ModeleVoiture> modeles) {
		return modeles.stream()
				.filter(m -> m.estPeuPolluante())
				.collect(Collectors.toList());
	}
	
	
	public static void main(String[] args) {
		List<ModeleVoiture> modeles = new ArrayList<>();
		modeles.add(new ModeleVoiture("Citroen", "Saxo", Carburant.ESSENCE,	 	DateUtils.asDate(LocalDate.of(1995, 01, 01))) );
		modeles.add(new ModeleVoiture("Peugeot", "405",  Carburant.DIESEL,  	DateUtils.asDate(LocalDate.of(2000, 01, 01))) );
		modeles.add(new ModeleVoiture("Renault", "Clio", Carburant.ESSENCE, 	DateUtils.asDate(LocalDate.of(1999, 01, 01))) );
		modeles.add(new ModeleVoiture("Citroen", "Saxo", Carburant.ELECTRIQUE, 	DateUtils.asDate(LocalDate.of(2015, 01, 01))) );
		modeles.add(new ModeleVoiture("Renault", "Clio", Carburant.GPL, 		DateUtils.asDate(LocalDate.of(2013, 01, 01))) );
		
		System.out.println("Liste des modèles avant filtrage");
		for (ModeleVoiture modeleVoiture : modeles) {
			System.out.println(modeleVoiture);
		}

		ModeleVoitureServices service = new ModeleVoitureServices();
		List<ModeleVoiture> voituresMoinsPolluantes = service.filtrerModelesMoinsPolluants(modeles);
		
		System.out.println("Liste des modèles après filtrage");
		for (ModeleVoiture modeleVoiture : voituresMoinsPolluantes) {
			System.out.println(modeleVoiture);
		}
	}
}
