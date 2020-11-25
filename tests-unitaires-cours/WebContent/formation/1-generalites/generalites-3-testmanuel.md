## Les tests "main"

Une première approche des **tests unitaires** 

que l'ont retrouve dans pas mal de vieilles applications, 

ce sont **les tests mis en oeuvre dans des méthodes *main*. **

====
Ce type de test respecte **un bon principe :**

### une classe = un test

En effet, le test est écrit dans la méthode *main* de la classe à tester.

====
### Exemple 
(*cf. exemple01 dans le projet eclipse*) 

Une classe modèle *Voiture* :

	public class ModeleVoiture {
		private String nomConstructeur;
		private String nomModele;
		private Carburant carburant;
		private Date anneeConstruction;
		
		...

====
Un service *métier* :

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

====
Un test dans la méthode *main* de cette classe de service :

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

====
Pour exécuter ce test dans *Eclipse*, il faut se placer sur la classe et lancer un *Run*.

Le résultat s'affiche dans la console via une commande *sysout*.

Résultat :

	Liste des modèles avant filtrage
	ModeleVoiture [nomConstructeur=Citroen, nomModele=Saxo, carburant=ESSENCE, anneeConstruction=Sun Jan 01 00:00:00 CET 1995]
	ModeleVoiture [nomConstructeur=Peugeot, nomModele=405, carburant=DIESEL, anneeConstruction=Sat Jan 01 00:00:00 CET 2000]
	ModeleVoiture [nomConstructeur=Renault, nomModele=Clio, carburant=ESSENCE, anneeConstruction=Fri Jan 01 00:00:00 CET 1999]
	ModeleVoiture [nomConstructeur=Citroen, nomModele=Saxo, carburant=ELECTRIQUE, anneeConstruction=Thu Jan 01 00:00:00 CET 2015]
	ModeleVoiture [nomConstructeur=Renault, nomModele=Clio, carburant=GPL, anneeConstruction=Tue Jan 01 00:00:00 CET 2013]
	Liste des modèles après filtrage
	ModeleVoiture [nomConstructeur=Renault, nomModele=Clio, carburant=ESSENCE, anneeConstruction=Fri Jan 01 00:00:00 CET 1999]
	ModeleVoiture [nomConstructeur=Citroen, nomModele=Saxo, carburant=ELECTRIQUE, anneeConstruction=Thu Jan 01 00:00:00 CET 2015]
	ModeleVoiture [nomConstructeur=Renault, nomModele=Clio, carburant=GPL, anneeConstruction=Tue Jan 01 00:00:00 CET 2013]

====
#### Mais de nombreux défauts : 
- Quid pour une classe de batch qui a déjà une méthode *main* ?
- Pas pratique de lancer les tests : un par un à la main.
- Noyé au milieu du code : pas de séparation claire entre test et non test.
- Il faut visualiser la log et la console pour savoir si le test est réussi ou non : non automatisé.    

====
Remarque : il est possible d'améliorer simplement et rapidement ce test
- organisation du code : séparer le code dans des **classes jumelles**
- faire un lanceur de tests  -> **JUnit**
- mettre en place des outils pour automatiser le contrôle des tests -> **JUnit**    