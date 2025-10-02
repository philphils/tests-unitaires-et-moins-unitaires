# Formation : Tests unitaires

# ...et moins unitaires...

![](img%5Cdiapo_tests_unitaires_0.png)

---

- Tour de parole pour mesurer le niveau d'expérience
- Questions organisationnelles

# Plan

<span style="color:#000080"> __Généralités sur les tests unitaires__ </span>

<span style="color:#000080"> __Le framework JUnit__ </span>

<span style="color:#000080"> __Junit : Fonctionnalités plus avancées__ </span>

<span style="color:#000080"> __Conseils\, bonnes pratiques et stratégie de test__ </span>

<span style="color:#000080"> __Isolation des tests : les Fakes et les Mocks__ </span>

<span style="color:#000080"> __Tests et base de données__ </span>

<span style="color:#000080"> __DBUnit : Une gestion via XML des jeux de test__ </span>

<span style="color:#000080"> __Généralités sur les tests unitaires__ </span>

# Pourquoi tester



* <span style="color:#000080"> __S’assurer que le code « fonctionne »__ </span>
* <span style="color:#000080"> __Valider\, guider les développements__ </span>
* <span style="color:#000080"> __Sécuriser les livraisons__ </span>
* <span style="color:#000080"> __S’assurer que ce qu’on a déjà codé continu de fonctionner \(non\-régression\)__ </span>
* <span style="color:#000080"> __En cas de maintenance :__ </span>
  * <span style="color:#000080"> __Vérifier que le bug est bien résolu__ </span>
  * <span style="color:#000080"> __S’assurer qu’il ne se reproduira plus__ </span>


# Pourquoi un test « unitaire » ?

<span style="color:#000080"> __Test : Vérifie que le code effectue le traitement attendu__ </span>

<span style="color:#000080"> __Unitaire : Porte sur une partie précise du programme__ </span>

<span style="color:#000080"> __On teste de manière isolée une portion du code \(une « unité »\)__ </span>

<span style="color:#000080"> __Selon les écoles\, portion de code plus ou moins petite__ </span>

<span style="color:#000080"> __Pour des tests sur des fonctionnalités entières on parle de « tests d’intégration »__ </span>

# Quelles utilités ?

<span style="color:#000080"> __Localiser plus rapidement les erreurs du code__ </span>

<span style="color:#000080"> __Prévenir la régression__ </span>

<span style="color:#000080"> __Sécuriser les livraisons__ </span>

<span style="color:#000080"> __Aide à la documentation et à la compréhension du code__ </span>

<span style="color:#000080"> __Structurer les développements \(TDD\)__ </span>

# Localisation rapide des erreurs



* <span style="color:#000080"> __Tests nombreux et sur des parties réduites du code :__ </span>
  * <span style="color:#000080"> __→ __ </span>  <span style="color:#000080"> __Détection rapide de l’origine des erreurs__ </span>
* <span style="color:#000080"> __Inconvénient :__ </span>
    * <span style="color:#000080"> __Coûts de développement élevé__ </span>
    * <span style="color:#000080"> __Coûts de maintenance__ </span>
* <span style="color:#000080"> __Définir une stratégie de test__ </span>
* <span style="color:#000080"> __Adopter une stratégie « raisonnable »__ </span>


# Prévention de la régression

<span style="color:#000080"> __Durée de vie d’une application peut\-être longue \(10 ans ou plus\)__ </span>

<span style="color:#000080"> __Nombreuses évolutions\, corrections de bugs\, perte d’informations__ </span>

<span style="color:#000080"> __Comment s’assurer que des évolutions/corrections n’impactent pas d’autres fonctionnalités ?__ </span>

<span style="color:#000080"> __Solution : Mise en place de tests \(et d’abord sur la partie qu’on modifie \!\)__ </span>

# Sécuriser les mises en production

![](img%5Cdiapo_tests_unitaires_1.png)

<span style="color:#000080"> __Je livre / je livre pas ? …  __ </span>

<span style="color:#000080"> __Rejeu de l’ensemble des tests avant chaque livraison \(via maven par ex\)__ </span>

<span style="color:#000080"> __Permet de limiter les erreurs de « dernière minute »__ </span>

<span style="color:#000080"> __Vérifier la non\-régression du code applicatif__ </span>

# Outil de compréhension du code

<span style="color:#000080"> __Les tests peuvent être vu comme une partie intégrante de la doc de l’application__ </span>

<span style="color:#000080"> __Peut permettre de mieux comprendre le fonctionnement de l’application__ </span>

<span style="color:#000080"> __Attention : bien documenter les tests eux\-mêmes \!__ </span>

# Comment tester ?



* <span style="color:#000080"> __Impact fort sur la manière de programmer __ </span>
* <span style="color:#000080"> __Charge importante : 1/3 du temps par ex\.__ </span>
* <span style="color:#000080"> __Nécessite la mise en place d’une « stratégie de test » a__ </span>  <span style="color:#000080"> __u niveau du projet :__ </span>
  * <span style="color:#000080"> __Qu’est\-ce qu’on teste en priorité ?__ </span>  <span style="color:#000080"> __	__ </span>
  * <span style="color:#000080"> __Comment on teste ?__ </span>
  * <span style="color:#000080"> __Quels outils on utilise ?__ </span>
  * <span style="color:#000080"> __Quels données de test ?__ </span>
* <span style="color:#000080"> __Nombreux outils pour faciliter les tests__ </span>


# Structure de base d’un test



* <span style="color:#000080"> __Décomposition en 3 étapes :__ </span>
  * <span style="color:#000080"> __GIVEN : Constitution des données et des conditions du test__ </span>
  * <span style="color:#000080"> __WHEN : Exécution du traitement à tester__ </span>
  * <span style="color:#000080"> __THEN : Vérification du bon fonctionnement du code__ </span>
* <span style="color:#000080"> __Permet de guider l’écriture du test__ </span>
* <span style="color:#000080"> __Les étapes peuvent être indiquées clairement en commentaires \(conseillé\)__ </span>
* <span style="color:#000080"> __Certaines étapes peuvent être vides selon les tests \(ex : GIVEN\)__ </span>


# Première approche : les tests « main »



* <span style="color:#000080"> __Méthode archaïque de test__ </span>
* <span style="color:#000080"> __Encore présente dans certaines applications__ </span>
* <span style="color:#000080"> __Écriture d’une classe avec une méthode :__ </span>
* <span style="color:#cc6c1d"> __public__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#cc6c1d"> __static__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#cc6c1d"> __void__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#1eb540"> __main__ </span>  <span style="color:#000000"> __\(__ </span>  <span style="color:#1290c3"> __String__ </span>  <span style="color:#000000"> __\[\] __ </span>  <span style="color:#79abff"> __args__ </span>  <span style="color:#000000"> __\)__ </span>
* <span style="color:#000080"> __Vérification du bon fonctionnement « manuelle » :__ </span>
    * <span style="color:#000080"> __Plantage ou non ?__ </span>
    * <span style="color:#000080"> __Lecture de l’affichage console__ </span>
    * <span style="color:#000080"> __Observation des données en base__ </span>


# Exemple 1 : Test main

![](img%5Cdiapo_tests_unitaires_2.png)

<span style="color:#000080"> __Présentation du modèle__ </span>

<span style="color:#000080"> __Test de : __ </span>  <span style="color:#a7ec21"> __filtrerModelesMoinsPolluants__ </span>

<span style="color:#000080"> __Repérage de la structure du test \(GIVEN\, WHEN\, THEN\)__ </span>

<span style="color:#000080"> __Exécution du test__ </span>

<span style="color:#000080"> __Observation des résultats__ </span>

<span style="color:#000080"> __Commentaires ?__ </span>

<span style="color:#000080"> __Inconvénients ?__ </span>

# Tests « main » : le bilan

<span style="color:#000080"> __Rend le service de base\, mais…__ </span>

<span style="color:#000080"> __Comment faire si fonction main existe déjà ?__ </span>

<span style="color:#000080"> __Lancement manuel des tests un à un__ </span>

<span style="color:#000080"> __Pas de séparation claire entre le code de test et de production__ </span>

<span style="color:#000080"> __Travail de vérification par l’utilisateur __ </span>

<span style="color:#000080"> __Risque d’erreur__ </span>

<span style="color:#000080"> __→ __ </span>  <span style="color:#000080"> __Besoin d’outiller les tests \!__ </span>

<span style="color:#000080"> __Le framework JUnit__ </span>

# Les 5 propriétés d’un bon test

<span style="color:#000080"> __Isolation : Le test porte sur une partie déterminée du code et les interactions avec des parties externes sont contrôlées__ </span>

<span style="color:#000080"> __Rapidité : Doit s’exécuter en un temps relativement court__ </span>

<span style="color:#000080"> __Automatisation : Doit pouvoir être lancé avec peu ou pas d’intervention manuelle__ </span>

<span style="color:#000080"> __Durabilité : Doit rester fonctionnel sur le long terme\, avec un coût de maintenance limité__ </span>

<span style="color:#000080"> __Reproductibilité : Doit pouvoir être relancé sans conditions préalables et dans tous les environnements__ </span>

# Principes du framework JUnit

<span style="color:#000080"> __JUnit est un outil d’automatisation et de réalisation des tests__ </span>

<span style="color:#000080"> __Réalisation des tests simplifiée__ </span>

<span style="color:#000080"> __Contrôles de vérification facilités__ </span>

<span style="color:#000080"> __Automatisation du lancement des tests__ </span>

<span style="color:#000080"> __Aide à la mise en place du contexte \(avant le test\, après le test…\)__ </span>

<span style="color:#000080"> __Intégration avec des outils de build \(Maven par ex\) __ </span>

# Mise en place de JUnit

<span style="color:#000080"> __A__ </span>  <span style="color:#000080"> __jout de la dépendance Maven au pom :__ </span>

<span style="color:#808080"> __<__ </span>  <span style="color:#569cd6"> __dependency__ </span>  <span style="color:#808080"> __>__ </span>

<span style="color:#808080"> __    __ </span>  <span style="color:#808080"> __<__ </span>  <span style="color:#569cd6"> __groupId__ </span>  <span style="color:#808080"> __>__ </span>  <span style="color:#aaaaaa"> __junit__ </span>  <span style="color:#808080"> __</__ </span>  <span style="color:#569cd6"> __groupId__ </span>  <span style="color:#808080"> __>__ </span>

<span style="color:#808080"> __    __ </span>  <span style="color:#808080"> __<__ </span>  <span style="color:#569cd6"> __artifactId__ </span>  <span style="color:#808080"> __>__ </span>  <span style="color:#aaaaaa"> __junit__ </span>  <span style="color:#808080"> __</__ </span>  <span style="color:#569cd6"> __artifactId__ </span>  <span style="color:#808080"> __>__ </span>

<span style="color:#808080"> __    __ </span>  <span style="color:#808080"> __<__ </span>  <span style="color:#569cd6"> __version__ </span>  <span style="color:#808080"> __>__ </span>  <span style="color:#aaaaaa"> __4\.13\.2__ </span>  <span style="color:#808080"> __</__ </span>  <span style="color:#569cd6"> __version__ </span>  <span style="color:#808080"> __>__ </span>

<span style="color:#808080"> __    __ </span>  <span style="color:#808080"> __<__ </span>  <span style="color:#569cd6"> __scope__ </span>  <span style="color:#808080"> __>__ </span>  <span style="color:#aaaaaa"> __test__ </span>  <span style="color:#808080"> __</__ </span>  <span style="color:#569cd6"> __scope__ </span>  <span style="color:#808080"> __>__ </span>

<span style="color:#808080"> __</__ </span>  <span style="color:#569cd6"> __dependency__ </span>  <span style="color:#808080"> __>__ </span>

<span style="color:#000080"> __Attention au « scope = test »__ </span>

<span style="color:#000080"> __Pas besoin de la librairie en environnement de production__ </span>

# Choix de la version



* <span style="color:#000080"> __Version 3 encore en usage dans certaines applis :__ </span>
    * <span style="color:#000080"> __La classe de test doit hériter de TestCase__ </span>
    * <span style="color:#000080"> __Convention de nommage pour les méthodes de test : doivent être préfixée par « test » \(ex : testMethode\(\)\)__ </span>
* <span style="color:#000080"> __Nouveautés version 4 :__ </span>
    * <span style="color:#000080"> __Arrivée des annotations__ </span>
    * <span style="color:#000080"> __Plus de convention de nommage : __ </span>  <span style="color:#000080"> __Il suffit d’un @Test au\-dessus de la méthode__ </span>
    * <span style="color:#000080"> __@Before\, @After\, @BeforeClass\, @AfterClass__ </span>
    * <span style="color:#000080"> __Assertions__ </span>
    * <span style="color:#000080"> __Beaucoup d’autre choses \(cf : __ </span>  <span style="color:#000080"> __[https://github\.com/junit\-team/junit4/wiki](https://github.com/junit-team/junit4/wiki)__ </span>  <span style="color:#000080"> __\)__ </span>
* <span style="color:#000080"> __Version 5 :__ </span>
    * <span style="color:#000080"> __Contient 3 modules en un : JUnit Platform \+ JUnit Jupiter \+ JUnit Vintage__ </span>
    * <span style="color:#000080"> __Support de Java 8__ </span>
    * <span style="color:#000080"> __Test paramétrés \(exécutions successives avec jeu de paramètres\)__ </span>


# Structure du code de tests



* <span style="color:#000080"> __Déportation du code de test dans des classes dédiées__ </span>
* <span style="color:#000080"> __Utilisation d’un répertoire « ad hoc » : __ </span>
* <span style="color:#000080"> __Principe de jumelage du code de test/production :__ </span>
    * <span style="color:#000080"> __Une classe de code = Une classe de test \(même nom suffixé Test\)__ </span>
    * <span style="color:#000080"> __Reproduction de l’arborescence de src/main/java dans le répertoire src/test/java__ </span>
    * <span style="color:#000080"> __Réutilisation des noms de méthodes avec préfixe test et suffixe pour indiquer le cas de test \(ex : testNomMethodeParametreVide\(\) \)__ </span>
* <span style="color:#000080"> __Structure identique → Navigation facilitée__ </span>


![](img%5Cdiapo_tests_unitaires_3.png)

# Exemple 2 : Premier test JUnit

![](img%5Cdiapo_tests_unitaires_4.png)



* <span style="color:#000080"> __Test du constructeur de la classe Personne__ </span>
* <span style="color:#000080"> __Structure du code :__ </span>
* <span style="color:#000080"> __M__ </span>  <span style="color:#000080"> __éthode de test : __ </span>
* <span style="color:#a0a0a0"> _@Test_ </span>
* <span style="color:#cc6c1d"> __public__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#cc6c1d"> __void__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#1eb540"> __testCreationPersonne__ </span>  <span style="color:#000000"> __\(\)__ </span>
* <span style="color:#000080"> __Exécution du test__ </span>
* <span style="color:#000080"> __Lecture et compréhension du code__ </span>


![](img%5Cdiapo_tests_unitaires_5.png)

# Les assertions



* <span style="color:#000080"> __Intégrées nativement à Junit__ </span>
* <span style="color:#000080"> __Contenue dans la classe Assert__ </span>
* <span style="color:#000080"> __Ensemble de méthodes statiques \(kesako?\) permettant de réaliser des contrôles de manière simple__ </span>
* <span style="color:#000080"> __Leur échec provoque le plantage du test :__ </span>
* <span style="color:#000080"> __Ex :__ </span>
      * <span style="color:#000080"> _Assert\.assertEquals\(int a\, int b\)_ </span>
      * <span style="color:#000080"> _Assert\.assertEquals\(Object a\, Object b\)_ </span>
      * <span style="color:#000080"> _Assert\.assertTrue\(boolean a\)_ </span>
      * <span style="color:#000080"> _Assert\.assertFalse\(boolean a\)_ </span>
      * <span style="color:#000080"> _Assert\.assertArrayEquals\(String\[\] a\, String\[\] b\)_ </span>
      * <span style="color:#000080"> _etc\._ </span>


![](img%5Cdiapo_tests_unitaires_6.png)

# Les assertions bis



* <span style="color:#000080"> __P__ </span>  <span style="color:#000080"> __our chaque méthode assert\* \, 2 signatures :__ </span>
      * <span style="color:#000080"> _Assert\.assertEquals\(int a\, int b\)_ </span>
      * <span style="color:#000080"> _Assert\.assertEquals\(String message\, int a\, int b\)_ </span>
* <span style="color:#000080"> __Possibilité d’indiquer un message d’erreur pour avoir des infos plus précises__ </span>
* <span style="color:#000080"> __E__ </span>  <span style="color:#000080"> __x :__ </span>
* <span style="color:#96ec3f"> _assertEquals_ </span>  <span style="color:#000000"> __\(__ </span>  <span style="color:#17c6a3"> __"Erreur sur la personne créée"__ </span>  <span style="color:#000000"> __\, __ </span>  <span style="color:#17c6a3"> __"Personne__ </span>  <span style="color:#000000"> __ __ </span>  <span style="color:#17c6a3"> __\[nom="__ </span>  <span style="color:#000000"> __ \+__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#f3ec79"> __nom__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#000000"> __\+__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#17c6a3"> __"\, prenom="__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#000000"> __\+__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#f3ec79"> __prenom__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#000000"> __\+__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#17c6a3"> __"\]"__ </span>  <span style="color:#000000"> __\,__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#f3ec79"> __unePersonne__ </span>  <span style="color:#e6e6fa"> __\.__ </span>  <span style="color:#a7ec21"> __toString__ </span>  <span style="color:#000000"> __\(\)\);__ </span>
* <span style="color:#000080"> __M__ </span>  <span style="color:#000080"> __éthode spéciale : __ </span>  <span style="color:#000080"> _Assert\.fail\(\)_ </span>
* <span style="color:#000080"> __Permet de déclencher la mise en échec du test__ </span>
* <span style="color:#000080"> __Utile par exemple si le traitement aurait du s’arrêter avant__ </span>


![](img%5Cdiapo_tests_unitaires_7.png)

<span style="color:#000080"> __Exercice 1 : Structurer un test__ </span>

<span style="color:#3465a4"> __\(Instructions contenues dans le readme\)__ </span>

<span style="color:#000080"> __JUnit : Fonctionnalités plus avancées__ </span>

# Tester les exceptions

<span style="color:#000080"> __P__ </span>  <span style="color:#000080"> __ossibilité de vérifier la levée d’Exception avec JUnit 4\, avec l’attribut « expected » :__ </span>

<span style="color:#a0a0a0"> _@Test_ </span>  <span style="color:#000000"> __\(__ </span>  <span style="color:#eb4b64"> __expected__ </span>  <span style="color:#000000"> __ =__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#1290c3"> _MonException_ </span>  <span style="color:#000000"> _\._ </span>  <span style="color:#cc6c1d"> _class_ </span>  <span style="color:#000000"> __\)__ </span>

<span style="color:#cc6c1d"> __public__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#cc6c1d"> __void__ </span>  <span style="color:#d9e8f7"> __ __ </span>  <span style="color:#1eb540"> __testMaMethodeException__ </span>  <span style="color:#000000"> __\(\)\{\.\.\.\}__ </span>

<span style="color:#000080"> __Possible en utilisant __ </span>  <span style="color:#000080"> _Assert\.fail\(\)_ </span>  <span style="color:#000080"> __ aussi__ </span>

![](img%5Cdiapo_tests_unitaires_8.png)

# Les Hooks

<span style="color:#000080"> __Méthode permettant la mise en place du contexte de test :__ </span>

<span style="color:#000080"> __Permet par exemple la création du jeu de données\, la mise en place d’une BDD pour les tests\, le nettoyage etc\.__ </span>

| <span style="color:#000000"> __@Before__ </span> | <span style="color:#000000">Exécutée avant chaque méthode préfixée par @Test</span> |
| :-: | :-: |
| <span style="color:#000000"> __@BeforeClass__ </span> | <span style="color:#000000">Exécutée une fois avant l'exécution de la classe de test</span> |
| <span style="color:#000000"> __@After__ </span> | <span style="color:#000000">Exécutée après chaque méthode préfixée par @Test</span> |
| <span style="color:#000000"> __@AfterClass__ </span> | <span style="color:#000000">Exécutée une fois après l'exécution de la classe de test</span> |

# Les Matchers



* <span style="color:#000080"> __Outils plus avancés pour réaliser des assertions__ </span>
* <span style="color:#000080"> __L__ </span>  <span style="color:#000080"> __’objet à tester et le « matcher » sont passés à la méthode : __ </span>
    * <span style="color:#000080"> _Assert\.assertThat\(\.\.\.\)_ </span>
* <span style="color:#000080"> __Contraintes plus élaborées comme : est égal et inférieur à\, la chaîne contient tel mot mais pas tel autre etc\.__ </span>
* <span style="color:#000080"> __Ex avec la librairie Harmcrest :__ </span>
* <span style="color:#000080"> __La librairie Hamcrest permet de bénéficier de fonctionnalités de Matcher plus complète encore \(cf correction exercice 1\)__ </span>


![](img%5Cdiapo_tests_unitaires_9.png)

# AssertJ

<span style="color:#000080"> __Une librairie de matchers plus récente__ </span>

<span style="color:#000080"> __Synthaxe plus lisible et fluide__ </span>

<span style="color:#000080"> __Bonne articulation avec JUnit 5__ </span>

<span style="color:#000080"> __Ex :__ </span>

![](img%5Cdiapo_tests_unitaires_10.png)

# D’autres fonctionnalités

<span style="color:#000080"> __Ignorer un test : __ </span>  <span style="color:#000080"> _@Ignore_ </span>

<span style="color:#000080"> __Assume : Test de conditions d’exécution du test __ </span>

<span style="color:#000080"> __Tests paramétrés : Répéter un test avec des paramètres différents\, par ex\. depuis un fichier CSV__ </span>

<span style="color:#000080"> __Test timeout : Tester le temps d’exécution__ </span>

<span style="color:#000080"> __@Rule : Mise en place de composant complexe utile au test \(ex : BDD embarquée Posgres\)__ </span>

<span style="color:#000080"> __Et bien d’autres\.\.\.__ </span>

<span style="color:#000080"> __Conseils\, bonnes pratiques et stratégie de test__ </span>

# Quelle méthode test-t-on ?

<span style="color:#000080"> __Quel type de méthode tester ?__ </span>

<span style="color:#000080"> __Private ? Protected ? Public ?__ </span>

<span style="color:#000080"> __Pourquoi ?__ </span>

<span style="color:#000080"> __Peut\-on changer une visibilité pour pouvoir tester ?__ </span>

# Quelle méthode test-t-on ? (Réponse)

<span style="color:#000080"> __Idée : On ne teste que les méthodes public car ce sont elles qui exposent un service__ </span>

<span style="color:#000080"> __Le reste est l’implémentation qui peut évoluer et reste interne par définition__ </span>

<span style="color:#000080"> __Idée : On ne change pas le code applicatif \(visibilité par ex\) pour les tests__ </span>

<span style="color:#000080"> __Les tests sont faits pour sécuriser le code applicaf\, pas l’inverse__ </span>

<span style="color:#000080"> __Cas du code legacy__ </span>

# Quelle couche test-t-on ?

<span style="color:#000080"> __Quelle couche test\-t\-on prioritairement ?__ </span>

<span style="color:#000080"> __DAO ? Model ? Service ? IHM ? Batch ?__ </span>

<span style="color:#000080"> __Pourquoi ?__ </span>

<span style="color:#000080"> __Comment s’assurer qu’on teste bien tout le code ?__ </span>

# Quelle couche test-t-on ? (Réponse)

<span style="color:#000080"> __Idéal : test de toute les méthodes__ </span>

<span style="color:#000080"> __Réalité : trouver un compromis raisonnable__ </span>

<span style="color:#000080"> __Test prioritaire de la couche Service__ </span>

<span style="color:#000080"> __Inutile de tester du code généré simple \(ex : Getter/Setter\)__ </span>

<span style="color:#000080"> __Attention : le code des tests appartient à l’application et doit donc être maintenu \!__ </span>

<span style="color:#000080"> __On s’assure qu’on couvre bien tout le code avec des outils \(cf diapo suivante\)__ </span>

# Couverture de test



* <span style="color:#000080"> __Notion de couverture : ensemble du code qui est exécuté par l’un des tests au moins__ </span>
* <span style="color:#000080"> __Idéal : Couverture de 100 % du code de l’application__ </span>
* <span style="color:#000080"> __Outils pour contrôler la couverture du code :__ </span>
    * <span style="color:#000080"> __Plugin Eclipse : EclEmma Java Code Coverage__ </span>
    * <span style="color:#000080"> __Sonar \(et plugin Eclipse Sonar\) Ex : __ </span>
* <span style="color:#000080"> __Arbitrage : __ </span>
    * <span style="color:#000080"> __Test unitaire →  Isolation\, indépendance / faible couverture de test__ </span>
    * <span style="color:#000080"> __Test d’integration → pas d’isolation\, dépendance / grande couverture de test__ </span>


# Stratégie de test

<span style="color:#000080"> __Test d’intégration permettent de couvrir un maximum de code \(niveau API service ou batch\)__ </span>

<span style="color:#000080"> __Test unitaire sont utiles pendant le développement \(cf TDD diapo suivante\) et pour débuggage__ </span>

<span style="color:#000080"> __Fixer des objectifs de couverture de tests avec l’équipe__ </span>

<span style="color:#000080"> __DAO : Si méthodes générées\, test des méthodes complexes seulement__ </span>

<span style="color:#000080"> __Model : Si méthode complexe \(peu normalement\)__ </span>

<span style="color:#000080"> __Service : à tester__ </span>

<span style="color:#000080"> __IHM : peut\-être délégué à d’autres outils \(les framework JS ont leur outils de tests\)\, Selenium en mode test d’intégration__ </span>

# Test Driven Development (TDD)

<span style="color:#000080"> __Méthode de développement basé sur les tests__ </span>

<span style="color:#000080"> __Idée : on a jamais le temps pour les tests \(1 tier du temps de dév normalement \!\)__ </span>

<span style="color:#000080"> __→ __ </span>  <span style="color:#000080"> __Écrire le test avant le code \!__ </span>

<span style="color:#000080"> __On crée seulement la signature de la méthode à tester __ </span>

<span style="color:#000080"> __On écrit le test qui doit planter au début : données\(GIVEN\)\, appel à la méthode \(__ </span>  <span style="color:#000080"> __WHEN\)\, vérification des résultats attendus \(THEN\)__ </span>

<span style="color:#000080"> __On écrit ou modifie ensuite le code de la méthode__ </span>

<span style="color:#000080"> __Le test doit passer au vert à l’issu du développement__ </span>

![](img%5Cdiapo_tests_unitaires_11.png)

<span style="color:#000080"> __Exercice 2 : Test nouvelle méthode service__ </span>

<span style="color:#3465a4"> __\(Instructions contenues dans le readme\)__ </span>

<span style="color:#000080"> __Isolation des tests : Les Fakes et les Mocks__ </span>

# Introduction



* <span style="color:#000080"> __Principe de test : une classe → un test__ </span>
* <span style="color:#000080"> __En mode test « unitaire » : On ne teste normalement que le code de la classe__ </span>
* <span style="color:#000080"> __Questions :__ </span>
  * <span style="color:#000080"> __Comment faire pour les autres classes qui sont appelées par le code ? \(ex : autres classes service\)__ </span>
  * <span style="color:#000080"> __Comment faire pour les services extérieurs disponibles en environnement de production seulement ? \(ex : accès à la base\, messagerie\, annuaire…\)__ </span>
  * <span style="color:#000080"> __Comment faire pour tester le bon comportement en cas d’erreur difficile ou impossible à reproduire ? \(ex : réseau\)__ </span>


# Solution : La simulation



* <span style="color:#000080"> __On va chercher à reproduire le comportement d’une classe sans l’appeler réellement__ </span>
* <span style="color:#000080"> __Définition ad hoc des résultats à renvoyer pour des paramètres données qui seront passés pour le test__ </span>
* <span style="color:#000080"> __Plusieurs solutions de mise en œuvre :__ </span>
  * <span style="color:#000080"> __Solution manuelle : les Fakes__ </span>
  * <span style="color:#000080"> __Solution outillée : les Mocks__ </span>


# Les Fakes

<span style="color:#000080"> __Réalisation d’une « fausse » classe de service pour un test donnée__ </span>

<span style="color:#000080"> __Contraint à créer un constructeur permettant l’injection du fake \(injection de dépendance\) :__ </span>

<span style="color:#000080"> __Le Fake implémente l’interface de service__ </span>

<span style="color:#000080"> __Les méthodes sont défini pour renvoyer un résultat correspondant au contexte du test__ </span>

<span style="color:#000080"> __Inconvénient : long à développer__ </span>

<span style="color:#000080"> __→ __ </span>  <span style="color:#000080"> __Utiliser un outil adéquat : les Mocks__ </span>

![](img%5Cdiapo_tests_unitaires_12.png)

# Les Mocks



* <span style="color:#000080"> __Utilisation de librairies permettant la génération de « mocks »__ </span>
* <span style="color:#000080"> __Mock : Classe qui porte le même nom mais dont chaque méthode par défaut ne fait rien__ </span>
* <span style="color:#000080"> __La librairie comporte des méthodes pour configurer le comportement du mock__ </span>
* <span style="color:#000080"> __Utiles dans différents contextes :__ </span>
  * <span style="color:#000080"> __Simuler le comportement classe externes__ </span>
  * <span style="color:#000080"> __Simuler appel services extérieurs \(api\, messagerie\, annuaire\.\.\.\)__ </span>
  * <span style="color:#000080"> __Pouvoir développer certains composants avant que d’autres ne soient développés \(bouchon\, prestataire…\)__ </span>
  * <span style="color:#000080"> __Simuler des erreurs complexes à reproduire \(ex :réseau\)__ </span>
  * <span style="color:#000080"> __Pouvoir contrôler les méthodes qui sont appelée sur les mocks__ </span>


# Les Mocks : Mise en œuvre

<span style="color:#000080"> __Plusieurs librairies sur le marché : Mockito\, PowerMock\, EasyMock…__ </span>

<span style="color:#000080"> __La plus répandue : Mockito__ </span>

<span style="color:#000080"> __Exemple :__ </span>

![](img%5Cdiapo_tests_unitaires_13.png)

![](img%5Cdiapo_tests_unitaires_14.png)

# Les Mocks : Annotations

<span style="color:#000080"> __Les méthodes plus récentes pour créer des Mocks utilisent les annotations__ </span>

<span style="color:#000080"> __Il faut d’abord utiliser le Runner Mockito :__ </span>

<span style="color:#000080"> __Puis on peut créer des attributs « mockés » avec__ </span>  <span style="color:#000080"> __ __ </span>  <span style="color:#a0a0a0"> _@Mock_ </span>  <span style="color:#000080"> __ :__ </span>

<span style="color:#000080"> __On configure et utilise ensuite le mock comme précédemment__ </span>

![](img%5Cdiapo_tests_unitaires_15.png)

![](img%5Cdiapo_tests_unitaires_16.png)

# Les Mocks : Exemples



* <span style="color:#000080"> __Utilisation des filtres sur les arguments avec __ </span>  <span style="color:#666666"> __when\(\)__ </span>  <span style="color:#000080"> __ :__ </span>
    * <span style="color:#666666"> __Any\(\)\, anyString\(\)\, anyList\(\) \.\.\.__ </span>
* <span style="color:#000080"> __Réutilisation des arguments avec __ </span>  <span style="color:#666666"> __thenAnswer\(\)__ </span>  <span style="color:#000080"> __ : __ </span>
    * <span style="color:#666666"> __Mockito\.when\(myMock\.myFunction\(anyString\(\)\)\)__ </span>
    * <span style="color:#666666"> __\.thenAnswer\(i \-> i\.getArguments\(\)\[0\]\)__ </span>
* <span style="color:#000080"> __Vérification sur les appels de méthodes avec __ </span>  <span style="color:#666666"> __verify\(\)__ </span>  <span style="color:#000080"> __ :__ </span>
    * <span style="color:#666666"> __Mockito\.verify\(myMock\)\.uneMethode\(arguments\)  __ </span>
    * <span style="color:#3465a4"> __→ __ </span>  <span style="color:#3465a4"> __Vérifie que la méthode « uneMethode » a été appelée avec « arguments »__ </span>
    * <span style="color:#666666"> __Mockito\.verify\(myMock\, times\(2\)\)\.uneMethode\(\)__ </span>
    * <span style="color:#3465a4"> __→ __ </span>  <span style="color:#3465a4"> __Vérifie que la méthode « uneMethode » a été appelée 2 fois__ </span>
    * <span style="color:#666666"> __Mockito\.verify\(myMock\, atLeast\(2\)\)\.uneMethode\(\)__ </span>
    * <span style="color:#3465a4"> __→ __ </span>  <span style="color:#3465a4"> __Vérifie que la méthode « uneMethode » a été appelée au moins 2 fois__ </span>
    * <span style="color:#666666"> __Mockito\.verifyZeroInteractions\(myMock\)__ </span>
    * <span style="color:#3465a4"> __→ __ </span>  <span style="color:#3465a4"> __Vérifie que le mock n’a eu aucune interaction__ </span>


# Les Mocks : Objectif

<span style="color:#000080"> __On va ainsi redéfinir au cas par cas les fonction de la classe qu’on « mock »__ </span>

<span style="color:#000080"> __Mockito est assez souple et permet de s’adapter à de nombreux cas__ </span>

<span style="color:#000080"> __Exemple : Levée d’exception\, réponse selon les types d’arguments\, réutilisation des arguments dans le résultats\, compter le nombre d’appels\, etc\.__ </span>

<span style="color:#000080"> __Reste coûteux à développer et assez peu lisible__ </span>

<span style="color:#000080"> __Très utiles pour les appel à services extérieurs__ </span>

<span style="color:#000080"> __Possibilité d’utiliser les Spy pour conserver une partie du code de la classe__ </span>

# Les Spy

<span style="color:#000080"> __Logique inverse des Mocks__ </span>

<span style="color:#000080"> __On a une classe qui fait par défaut la même chose que la classe qu’on « spy »__ </span>

<span style="color:#000080"> __Mais on peut redéfinir ses comportements pour le besoin des tests__ </span>

<span style="color:#000080"> __E__ </span>  <span style="color:#000080"> __t surtout on peut contrôler les appels à ses différentes méthodes avec __ </span>  <span style="color:#1290c3"> __Mockito__ </span>  <span style="color:#666666"> __\.__ </span>  <span style="color:#96ec3f"> _verify_ </span>

<span style="color:#000080"> __Mise en œuvre similaire avec __ </span>  <span style="color:#1290c3"> __Mockito__ </span>  <span style="color:#666666"> __\.__ </span>  <span style="color:#96ec3f"> _spy_ </span>  <span style="color:#666666"> __\(__ </span>  <span style="color:#80f2f6"> __InterfaceService__ </span>  <span style="color:#666666"> __\.__ </span>  <span style="color:#cc6c1d"> __class__ </span>  <span style="color:#666666"> __\)__ </span>  <span style="color:#000080"> __ ou __ </span>

![](img%5Cdiapo_tests_unitaires_17.png)

![](img%5Cdiapo_tests_unitaires_18.png)

<span style="color:#000080"> __Exercice 3 et 3 bis : Fake et Mock__ </span>

<span style="color:#3465a4"> __\(Instructions contenues dans le readme\)__ </span>

<span style="color:#000080"> __Tests et base de données__ </span>

<span style="color:#3465a4"> __Question : Comment sont gérés les jeux de test sur vos applications ?__ </span>

# Comment stocker les données de test ?



* <span style="color:#000080"> __On peut tester les méthodes en créant des objets en Java__ </span>
* <span style="color:#000080"> __Méthode permettant le plus d’isolation__ </span>
* <span style="color:#000080"> __On peut vouloir tester le code en utilisant une base de donnée de test :__ </span>
  * <span style="color:#000080"> __Pour tester la couche DAO \(requête SQL\, Hibernate etc\.\)__ </span>
  * <span style="color:#000080"> __Pour des tests d’intégration__ </span>
  * <span style="color:#000080"> __Pour des tests « moins » unitaires mais plus « couvrants » \(passage au travers de plusieurs couches\)__ </span>


# Comment concevoir un jeu de test ?

<span style="color:#000080"> __Tentation : Récupérer des données de production__ </span>

<span style="color:#000080"> __Problème : Méconnaissance du contenu exact des données__ </span>

<span style="color:#000080"> __Idéal : Constituer un jeu de données de test « ad hoc »__ </span>

<span style="color:#000080"> __Réalité : Inspiration et récupération d’une partie des données de production \(ex : nomenclature\)__ </span>

<span style="color:#000080"> __Attention : Mettre en commun les données de test des différents test créée une dépendance__ </span>

<span style="color:#000080"> __Limite : Multiplier les jeux de données de test augmente la charge de maintenance des tests__ </span>

<span style="color:#000080"> __Dans la réalité on cherche un compromis raisonnable__ </span>

# Plusieurs solutions pour les BDD de test

<span style="color:#000080"> __Plusieurs solutions techniques existent pour gérer les données de test__ </span>

<span style="color:#000080"> __Base distante : Utilisation d’un serveur BDD distant \(au CEI\)__ </span>

<span style="color:#000080"> __Base locale : Installation sur le poste développeur d’une BDD__ </span>

<span style="color:#000080"> __Base embarquée : Utilisation de librairies permettant de déployer une BDD au moment du test__ </span>

<span style="color:#000080"> __Base mémoire : Base embarquée stockée en RAM__ </span>

<span style="color:#000080"> __Question de l’isomorphisme avec l’environnement de production importante\, en particulier pour les fonction « propriétaires » du SGBD__ </span>

# Base distante



* <span style="color:#000080"> __Demande au CEI d’une BDD de test__ </span>
* <span style="color:#000080"> __Avantage : Les tests s’exécutent avec la même architecture que la production__ </span>
* <span style="color:#000080"> __Inconvénients :__ </span>
  * <span style="color:#000080"> __Dépendance au réseau__ </span>
  * <span style="color:#000080"> __Lenteurs possibles__ </span>
  * <span style="color:#000080"> __Comment gérer l’exécution simultanée des tests par plusieurs développeurs ? \(un schéma par développeur\)__ </span>
  * <span style="color:#000080"> __Comment gérer l’exécution sur la PIC ?__ </span>
* <span style="color:#000080"> __Tentation d’utiliser des données de production de manière persistante \(ex : Lei\)__ </span>
* <span style="color:#000080"> __Différence progressive entre données de production et données de tests__ </span>


# Base locale



* <span style="color:#000080"> __Installation sur le poste développeur d’une BDD__ </span>
* <span style="color:#000080"> __Idéal : Choix d’une version identique à la prod__ </span>
* <span style="color:#000080"> __Plus de dépendance au réseau\, performances__ </span>
* <span style="color:#000080"> __Inconvénients :__ </span>
  * <span style="color:#000080"> __Requiert des manipulations et configuration sur chaque poste développeur__ </span>
  * <span style="color:#000080"> __Problème éventuel de droits \(version portable\)__ </span>
  * <span style="color:#000080"> __Comment gérer l’exécution des tests sur la PIC ?__ </span>


# Base en mémoire



* <span style="color:#000080"> __BDD SQL contenue dans la RAM__ </span>
* <span style="color:#000080"> __Déployée à partir d’une librairie qu’on ajoute au POM__ </span>
* <span style="color:#000080"> __Avantages :__ </span>
  * <span style="color:#000080"> __Indépendance__ </span>
  * <span style="color:#000080"> __Performances__ </span>
  * <span style="color:#000080"> __Exécution sur la PIC sans problème__ </span>
* <span style="color:#000080"> __Inconvénients : Problème potentiel de différence entre les environnements__ </span>
* <span style="color:#000080"> __Solution satisfaisante de manière général__ </span>
* <span style="color:#000080"> __Impossible de tester les requêtes propriétaire de la BDD \(par ex pgSql\)__ </span>
* <span style="color:#000080"> __Consultation possible du contenu de la base mais en mode dégradé__ </span>


# Base en mémoire : Exemple

<span style="color:#000080"> __2 produits majeurs : H2\, HSQLDB__ </span>

<span style="color:#000080"> __H2 peut fonctionner avec un driver Postgres__ </span>

<span style="color:#000080"> __Connexion avec InseeConfig :__ </span>

<span style="color:#000080"> __Connexion sans InseeConfig \(ou plus simple encore avec les properties seulement en Spring Boot\) :__ </span>

![](img%5Cdiapo_tests_unitaires_19.png)

![](img%5Cdiapo_tests_unitaires_20.png)

![](img%5Cdiapo_tests_unitaires_21.png)

# Base embarquée

<span style="color:#000080"> __Certaines librairies proposent des base identique au BDD de production en mode embarqué__ </span>

<span style="color:#000080"> __Permet d’avoir l’indépendance et l’isomorphisme vis\-à\-vis de l’environnement de production__ </span>

<span style="color:#000080"> __Plus lent que les bases en mémoire__ </span>

<span style="color:#000080"> __Permet de tester les requêtes SQL « propriétaires » \(ex : copy en Postgres\)__ </span>

# Base embarquée : Exemple

<span style="color:#000080"> __La librairie Zonky permet de disposer d’une BDD Postgres embarquée démarrée au début du test__ </span>

<span style="color:#000080"> __La base est stocké sur le disque → Lenteurs au démarrage__ </span>

<span style="color:#000080"> __La log de la base est consultable\, la config de la BDD paramétrable__ </span>

<span style="color:#000080"> __On peut se connecter à la base en plaçant des points d’arrêt \(debug\)__ </span>

<span style="color:#000080"> __Installation :__ </span>

<span style="color:#000080"> __Utilisation :__ </span>

<span style="color:#000080"> __Très bien pour les tests d’intégration\, souplesse pour le paramétrage__ </span>

![](img%5Cdiapo_tests_unitaires_22.png)

![](img%5Cdiapo_tests_unitaires_23.png)

<span style="color:#000080"> __DBUnit : Une gestion via XML des jeux de test__ </span>

# Outil de gestion des données de test

<span style="color:#000080"> __Question : Sous quelle forme stocker\, insérer les données de test ?__ </span>

<span style="color:#000080"> __DBUnit est un framework permettant la gestion des données de test via fichiers XML \(appelé « dataset »\)__ </span>

<span style="color:#000080"> __En utilisation dans plusieurs applications du parc Insee__ </span>

<span style="color:#000080"> __Moins utilisé maintenant car assez verbeux et coût en maintenance__ </span>

# Digression : Les étapes d’un test



* <span style="color:#000080"> __Avant le test :__ </span>
  * <span style="color:#000080"> __Ouvrir une connexion à la base__ </span>
  * <span style="color:#000080"> __Créer la structure de la base__ </span>
  * <span style="color:#000080"> __Remplir la base avec les données utiles au test qui va suivre__ </span>
  * <span style="color:#000080"> __Fermer la connexion__ </span>
* <span style="color:#000080"> __Test__ </span>
* <span style="color:#000080"> __Après le test :__ </span>
  * <span style="color:#000080"> __Rien si vous avez bien conçu votre affaire ;\-\)__ </span>
  * <span style="color:#000080"> __Nettoyer un peu le contenu de la base sinon__ </span>


# DBUnit : Exemple

![](img%5Cdiapo_tests_unitaires_24.png)



* <span style="color:#000080"> __Installation :__ </span>
* <span style="color:#000080"> __Exécution d’un script pour créer le schéma :__ </span>
* <span style="color:#000080"> __Constitution d’un dataset contenant les données de test :__ </span>


![](img%5Cdiapo_tests_unitaires_25.png)

![](img%5Cdiapo_tests_unitaires_26.png)

# DBUnit : Chargement dataset



* <span style="color:#000080"> __On charge ensuite le contenu du fichier XML dans la base de données :__ </span>
* <span style="color:#000080"> __Conclusion : DBUnit offre une méthode de gestion des jeux de données de test__ </span>
* <span style="color:#000080"> __Inconvénients :__ </span>
  * <span style="color:#000080"> __Fichier dataset très verbeux__ </span>
  * <span style="color:#000080"> __Coût de maintenance important en cas de modification du modèle de données__ </span>
  * <span style="color:#000080"> __Problème potentiel pour gérer l’ordre d’insertion__ </span>
* <span style="color:#000080"> __Autre solution : Créer les objets en Java\, les insérer avec Hibernate… Mais c’est un autre sujet __ </span>


![](img%5Cdiapo_tests_unitaires_27.png)

![](img%5Cdiapo_tests_unitaires_28.png)

<span style="color:#000080"> __Merci de votre attention__ </span>

<span style="color:#000080"> __Avez\-vous des questions ?__ </span>

<span style="color:#ff6633"> _Prénom Nom_ </span>  <span style="color:#ff6633"> __ __ </span>  <span style="color:#000080"> __Philippe SABAA__ </span>

<span style="color:#000080">Mél : philippe\.sabaa@insee\.fr</span>

<span style="color:#000080">Très inspiré du diapo de </span>  <span style="color:#000080"> __Michael Genet__ </span>

<span style="color:#ff6633"> __Insee__ </span>

<span style="color:#ff6633">Établissement : </span>  <span style="color:#000080"> __SNDI de Nantes__ </span>

