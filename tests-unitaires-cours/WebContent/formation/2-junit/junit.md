# JUnit ?
**JUnit** est un framework Java qui facilite l'écriture des tests unitaires.

Il respecte les bonnes pratiques établies sur les tests unitaires.

====
### JUnit permet :

- d'écrire les tests unitaires de façon très simple,

- d'écrire simplement des contrôles,

- de faciliter les tâches avant et après les tests</br>(initialisation et nettoyage des données),

- de lancer les tests de façon automatique.

!!!!
## Installation
Avec Maven, une simple dépendance à ajouter dans le *pom.xml* :

	<dependency>
	    <groupId>junit</groupId>
	    <artifactId>junit</artifactId>
	    <version>4.12</version>
	    <scope>test</scope>
	</dependency>


**Attention au scope !**

!!!!
## Mais quelle version ?

**Utilisez la version 4 ou 5.**

Dans cette formation, nous utiliserons 

la version 4 stable la plus récente : 

la **4.12**

====
## La version 3 ?
* Encore potentiellement présente dans certaines applications Insee.

* Facile à détecter :</br>
une classe de test doit obligatoirement hériter de la classe *TestCase*. 

* Le nom d'une méthode de test doit obligatoirement commencer par *test*</br>
Exemple : *test*UneMethode()

====
## Qu'apporte JUnit 4 ?
https://junit.org/junit4/

* Des annotations !!!

* Pas de norme de nommage imposée sur les méthodes de test.</br>
(*mais des conventions que nous verrons plus loin*)

* Juste une annotation *@Test* à placer sur la méthode ou sur la classe.

====
## Et la version 5 alors ?
https://junit.org/junit5/

* 3 modules au lieu d'un.

JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage

====
* Support de Java 8 (lambdas).

	    @Test
	    void groupedAssertions() {
	        // In a grouped assertion all assertions are executed, and any
	        // failures will be reported together.
	        assertAll("person",
	            () -> assertEquals("John", person.getFirstName()),
	            () -> assertEquals("Doe", person.getLastName())
	        );
	    }

====
* Des annotations renommées et de nouvelles annotations.

(https://howtoprogram.xyz/2016/08/10/junit-5-vs-junit-4/)

====
* Support natif des tests paramétrés</br>
*un même code permet de tester plusieurs jeux de données*

		@ParameterizedTest
		@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
		void palindromes(String candidate) {
		    assertTrue(isPalindrome(candidate));
		}

!!!!
# Un premier exemple

====
Soit la classe *Personne* suivante :

	public class Personne {
		private String nom;
		private String prenom;
	
		public Personne(String nom, String prenom) {
			this.nom = nom;
			this.prenom = prenom;
		}
		
		...
		
		@Override
		public String toString() {
			return String.format("Personne [nom=%s, prenom=%s]", nom, prenom);
		}
	}

====
Je veux tester la création d'une personne</br>
(sans me soucier de savoir si c'est pertinent ou non pour l'instant).
</br>
</br>
**Idée :**
- je crée une personne avec le constructeur
- puis je vérifie que la méthode *toString()* renvoie la chaine correcte.

====
Voilà ce que ça donne :

	import static org.junit.Assert.assertEquals;
	
	import org.junit.Test;
	
	public class PersonneTest {
		
		 @Test
		 public void testCreationUnePersonne() {
			 Personne unePersonne = new Personne("DURAND", "Mathieu");
			 assertEquals("Erreur sur La personne créée", 
			 			  "Personne [nom=DURAND, prenom=Mathieu]", unePersonne.toString());
		 }
	}
	
!!!!
## Quelques conventions

* Les tests unitaires sont dans le répertoire *src/test*

* La classe qui teste la classe *A* se nomme *ATest*
</br>*on parle de classes jumelles*

*Aparté :* [Maven surefire](https://maven.apache.org/surefire/maven-surefire-plugin/examples/inclusion-exclusion.html) !

====
* Les méthodes de test se nomment toujours *testXXXX*...

* Un test se déroule en 3 temps : GIVEN, WHEN, THEN

Il est recommandé de bien faire apparaître ces 3 temps 

dans le code des tests quand ce code est long.

!!!!
## Les assertions
Pour valider les résulats, nous allons utiliser la classe Assert qui permet de réaliser des contrôles. 

Méthode												| Comportement
---------- 											| ------------ 
*Assert.assertEquals(int a, int b)* 				| Le contrôle est correct si *a==b*
*Assert.assertEquals(double a, double b, double c)* | Le contrôle est correct si *abs(b-a)<c*
*Assert.assertEquals(Object a, Object b)* 			| Le contrôle est correct si *a.equals(b)*
*Assert.assertTrue(boolean a)* 						| Le contrôle est correct si *a* est *true*
*Assert.assertFalse(boolean a)* 					| Le contrôle est correct si *a* est *false*
... 												| ...

====
Je préconise d'utiliser systématiquement la version des méthodes avec commentaire.

Pour avoir un résultat plus lisible.

Exemple :

		 assertEquals("Erreur sur la personne créée", "Personne [nom=DURAND, prenom=Mathieu]", unePersonne.toString());

Plutôt que :

		 assertEquals("Personne [nom=DURAND, prenom=Mathieu]", unePersonne.toString());

====
Et le *fail* !!!!

Méthode			| Comportement
---------- 		| ------------ 
*Assert.fail()* | Si nous exécutons cette ligne, le test échoue !

</br>

Mais à quoi ça sert ce truc ?

!!!!
## Tester la survenue d'exceptions
Le test consiste alors à vérifier 

qu'une exception est bien levée dans un certain contexte.

Il y a au moins deux façons de faire avec JUnit 4.

====
**Première solution :**

Il suffit d'ajouter un attribut dans l'annotation *@Test*. 

	public class ClasseATesterTest {
		@Test ( expected = IllegalArgumentException.class )
		public void testExplosif ( ) throws Exception {
			racineCarree (-10) ;
		}
	}


====
**Deuxième solution :**

Faire un *try catch* et utiliser le *fail()* !!!!

	public class ClasseATesterTest {
		@Test
		public void testExplosif ( ) {
			try {
				racineCarree (-10) ;
				fail() ;
			}
			catch ( IllegalArgumentException e ) {
				assertEquals ( "Nombre inférieur à 0", e.getMessage() ) ;
			}
		}
	} 

!!!!
## Tester une durée maximale d'exécution
Le test consiste à vérifier notamment 

que le traitement se termine en mois de x millisecondes.

		@Test(timeout=1000)
		public void testWithTimeout() {
		  ...
		}

</br>

Pour plus de détails : https://github.com/junit-team/junit4/wiki/Timeout-for-tests

!!!!
## Tester un traitement qui lance des exits
Ce n'est pas anodin.

Dans une application legacy, comment faire pour tester un batch qui se termine par un exit ?

Remarque judicieuse : est-ce un test unitaire ?

====
Non, plutôt un test d'intégration.

Mais dans le contexte cité, avez-vous vraiment le choix ?

Utilisé sur Sirene 3 et Esane !

====
Il existe une solution : la bibliothèque *sytem rules*.

https://blog.developpez.com/ddelbecq/p11275/java/system-exit-et-test-unitaire

!!!!
## Des précisions

====
* C'est quoi un *import static* ? 

Depuis Java 5, on peut appeler une méthode *public static* d'une autre classe 

sans spécifier cette classe en ajoutant un *import static*.

Exemple avec les assert :

		 import static org.junit.Assert.assertEquals;
		
		 import org.junit.Test;
		
		 public class PersonneTest {
	
		 @Test
		 public void testCreationUnePersonne() {
			 Personne unePersonne = new Personne("DURAND", "Mathieu");
			 assertEquals("Erreur sur La personne créée", "Personne [nom=DURAND, prenom=Mathieu]", unePersonne.toString());
		 }
 
[Définition sur wikipedia](https://en.wikipedia.org/wiki/Static_import)

====
* 1 assert = 1 test pour JUnit

**Attention ! Le test s'arrête au premier assert non vérifié.**

====
* 1 assert = 1 test pour JUnit (suite)

Pour plus tard : beaucoup de discussions autour de ce principe.

[is-it-ok-to-have-multiple-asserts-in-a-single-unit-test?](https://softwareengineering.stackexchange.com/questions/7823/is-it-ok-to-have-multiple-asserts-in-a-single-unit-test)

[multiple-asserts-in-a-single-unit-test-method](https://elgaard.blog/2011/02/06/multiple-asserts-in-a-single-unit-test-method/)

====
Possibilité de faire des assertions multiples ?
- [Multiple asserts](https://github.com/nunit/docs/wiki/Multiple-Asserts)
- Les matchers !!!! qu'on verra plus loin
- D'autres solutions qu'on verra en exercice ? ;-) 

!!!!
## Nouvel exemple 
Un exercice ! 
reprise du test manuel sur les modèles de voiture

!!!!
# Les hooks
Afin de mettre en place l'environnement d'exécution des tests, 

il est possible d'écrire des méthodes qui sont exécutées avant et après le test.
 
Ces méthodes sont annotées grâce aux annotations (JUnit 4 !) définies ci-dessous :

Annotation | Execution
---------- | ----------
@Before	| Exécutée avant chaque méthode préfixée par @Test
@BeforeClass |Exécutée une fois avant l'exécution de la classe de test
@After |Exécutée après chaque méthode préfixée par @Test
@AfterClass | Exécutée une fois après l'exécution de la classe de test

====
Usages :
* Initialiser le contexte avant les tests.
* Nettoyer le contexte après les tests.

!!!!
# Aller plus loin avec les assertions
Les assertions permettent de réaliser pas mal de contrôles.

Mais elles présentent des défauts que [certains trouvent rédhibitoires](https://blog.xebia.fr/2008/04/02/simplifier-les-assertions-junit-et-ameliorer-vos-tests/).

*(messages peu explicites en cas de failure,*

*d'où l'obligation de gérer des messages soi même et de les maintenir,*

*commandes peu logique,* 

*pas possible de combiner les assertions...)*
   


====
# Les matchers
JUnit fournit une autre façon de faire les assertions.

Une nouvelle méthode *assertThat(Object value, org.hamcrest.Matcher matcher)*.

- *value* est l'objet à tester 

- et *matcher* est un ensemble de contraintes à vérifier sur l'objet. 

JUnit 4.4 et + incorpore en standard certains matchers 

dans la classe *org.hamcrest.CoreMatchers*.

====
Un exemple est plus parlant :

	assertThat(x, is(3));
	assertThat(x, is(not(4)));
	assertThat(responseString, either(containsString("color")).or(containsString("colour")));
	assertThat(myList, hasItem("3"));

</br>

Source : extrait du site https://github.com/junit-team/junit4/wiki/matchers-and-assertthat.

====
#### Avantages :

Les messages retournés en cas de failure sont plus explicites.

	assertTrue(responseString.contains("color") || responseString.contains("colour"));
	// ==> failure message: 
	// java.lang.AssertionError:
	
	
	assertThat(responseString, anyOf(containsString("color"), containsString("colour")));
	// ==> failure message:
	// java.lang.AssertionError: 
	// Expected: (a string containing "color" or a string containing "colour")
	//      got: "Please choose a font"


====
## Hamcrest
Par défaut, JUnit fournit une version de *assertThat* basée sur des matchers JUnit.

Mais il y a une version plus complète : **Hamcrest**

http://hamcrest.org/JavaHamcrest/

http://www.vogella.com/tutorials/Hamcrest/article.html

https://code.google.com/archive/p/hamcrest/wikis/Tutorial.wiki

====
En pratique :

- ajouter la librairie *hamcrest-library* dans votre *pom.xml*;

- utiliser la méthode *assertThat* de Hamcrest en incluant les *imports static* suivants (à la main) :

		import static org.hamcrest.MatcherAssert.assertThat;
		import static org.hamcrest.Matchers.*;

!!!!
## Resources pour aller encore plus loin

Sur le site Junit 4 : https://junit.org/junit4/
- Ignorer un test
- Assume
- Tests paramétrés
- Rules
- Theories
- ... 

