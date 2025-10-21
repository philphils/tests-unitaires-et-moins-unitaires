# Formation 

# Tests unitaires...


---
# ...et moins unitaires !

![](img%5Cdiapo_tests_unitaires_0.png)


<div style="position: absolute; bottom: 20px; right: 30px; font-size: 0.8em; color: #444; font-style: italic">
#TuPeuxPasTest
</div>

---

* Tour de parole :
  * Avez-vous déjà pratiqué les tests ?
* Questions organisationnelles :
  * Début ? Fin ? Pause ?


---
# Plan


* __Généralités sur les tests unitaires__

* __Le framework JUnit__

* __Junit : Fonctionnalités plus avancées__

* __Conseils, bonnes pratiques et stratégie de test__

* __Isolation des tests : les Fakes et les Mocks__

---

# Plan (suite)

* __Tests et base de données__

* __DBUnit : Une gestion via XML des jeux de test__

---

<section
  data-markdown="chapitre1-generalites.md"
  data-separator-vertical="^--$">
</section>

---



 __Isolation des tests : Les Fakes et les Mocks__ 


---
# Introduction



*  __Principe de test : une classe → un test__ 
*  __En mode test « unitaire » : On ne teste normalement que le code de la classe__ 
*  __Questions :__ 
  *  __Comment faire pour les autres classes qui sont appelées par le code ? \(ex : autres classes service\)__ 
  *  __Comment faire pour les services extérieurs disponibles en environnement de production seulement ? \(ex : accès à la base\, messagerie\, annuaire…\)__ 
  *  __Comment faire pour tester le bon comportement en cas d’erreur difficile ou impossible à reproduire ? \(ex : réseau\)__ 



---
# Solution : La simulation



*  __On va chercher à reproduire le comportement d’une classe sans l’appeler réellement__ 
*  __Définition ad hoc des résultats à renvoyer pour des paramètres données qui seront passés pour le test__ 
*  __Plusieurs solutions de mise en œuvre :__ 
  *  __Solution manuelle : les Fakes__ 
  *  __Solution outillée : les Mocks__ 



---
# Les Fakes

 __Réalisation d’une « fausse » classe de service pour un test donnée__ 

 __Contraint à créer un constructeur permettant l’injection du fake \(injection de dépendance\) :__ 

 __Le Fake implémente l’interface de service__ 

 __Les méthodes sont défini pour renvoyer un résultat correspondant au contexte du test__ 

 __Inconvénient : long à développer__ 

 __→ __    __Utiliser un outil adéquat : les Mocks__ 

![](img%5Cdiapo_tests_unitaires_12.png)


---
# Les Mocks



*  __Utilisation de librairies permettant la génération de « mocks »__ 
*  __Mock : Classe qui porte le même nom mais dont chaque méthode par défaut ne fait rien__ 
*  __La librairie comporte des méthodes pour configurer le comportement du mock__ 
*  __Utiles dans différents contextes :__ 
  *  __Simuler le comportement classe externes__ 
  *  __Simuler appel services extérieurs \(api\, messagerie\, annuaire\.\.\.\)__ 
  *  __Pouvoir développer certains composants avant que d’autres ne soient développés \(bouchon\, prestataire…\)__ 
  *  __Simuler des erreurs complexes à reproduire \(ex :réseau\)__ 
  *  __Pouvoir contrôler les méthodes qui sont appelée sur les mocks__ 



---
# Les Mocks : Mise en œuvre

 __Plusieurs librairies sur le marché : Mockito\, PowerMock\, EasyMock…__ 

 __La plus répandue : Mockito__ 

 __Exemple :__ 

![](img%5Cdiapo_tests_unitaires_13.png)

![](img%5Cdiapo_tests_unitaires_14.png)


---
# Les Mocks : Annotations

 __Les méthodes plus récentes pour créer des Mocks utilisent les annotations__ 

 __Il faut d’abord utiliser le Runner Mockito :__ 

 __Puis on peut créer des attributs « mockés » avec__    __ __   <span style="color:#a0a0a0"> _@Mock_    __ :__ 

 __On configure et utilise ensuite le mock comme précédemment__ 

![](img%5Cdiapo_tests_unitaires_15.png)

![](img%5Cdiapo_tests_unitaires_16.png)


---
# Les Mocks : Exemples



*  __Utilisation des filtres sur les arguments avec __   <span style="color:#666666"> __when\(\)__    __ :__ 
    * <span style="color:#666666"> __Any\(\)\, anyString\(\)\, anyList\(\) \.\.\.__ 
*  __Réutilisation des arguments avec __   <span style="color:#666666"> __thenAnswer\(\)__    __ : __ 
    * <span style="color:#666666"> __Mockito\.when\(myMock\.myFunction\(anyString\(\)\)\)__ 
    * <span style="color:#666666"> __\.thenAnswer\(i \-> i\.getArguments\(\)\[0\]\)__ 
*  __Vérification sur les appels de méthodes avec __   <span style="color:#666666"> __verify\(\)__    __ :__ 
    * <span style="color:#666666"> __Mockito\.verify\(myMock\)\.uneMethode\(arguments\)  __ 
    * <span style="color:#3465a4"> __→ __   <span style="color:#3465a4"> __Vérifie que la méthode « uneMethode » a été appelée avec « arguments »__ 
    * <span style="color:#666666"> __Mockito\.verify\(myMock\, times\(2\)\)\.uneMethode\(\)__ 
    * <span style="color:#3465a4"> __→ __   <span style="color:#3465a4"> __Vérifie que la méthode « uneMethode » a été appelée 2 fois__ 
    * <span style="color:#666666"> __Mockito\.verify\(myMock\, atLeast\(2\)\)\.uneMethode\(\)__ 
    * <span style="color:#3465a4"> __→ __   <span style="color:#3465a4"> __Vérifie que la méthode « uneMethode » a été appelée au moins 2 fois__ 
    * <span style="color:#666666"> __Mockito\.verifyZeroInteractions\(myMock\)__ 
    * <span style="color:#3465a4"> __→ __   <span style="color:#3465a4"> __Vérifie que le mock n’a eu aucune interaction__ 



---
# Les Mocks : Objectif

 __On va ainsi redéfinir au cas par cas les fonction de la classe qu’on « mock »__ 

 __Mockito est assez souple et permet de s’adapter à de nombreux cas__ 

 __Exemple : Levée d’exception\, réponse selon les types d’arguments\, réutilisation des arguments dans le résultats\, compter le nombre d’appels\, etc\.__ 

 __Reste coûteux à développer et assez peu lisible__ 

 __Très utiles pour les appel à services extérieurs__ 

 __Possibilité d’utiliser les Spy pour conserver une partie du code de la classe__ 


---
# Les Spy

 __Logique inverse des Mocks__ 

 __On a une classe qui fait par défaut la même chose que la classe qu’on « spy »__ 

 __Mais on peut redéfinir ses comportements pour le besoin des tests__ 

 __E__    __t surtout on peut contrôler les appels à ses différentes méthodes avec __   <span style="color:#1290c3"> __Mockito__   <span style="color:#666666"> __\.__   <span style="color:#96ec3f"> _verify_ 

 __Mise en œuvre similaire avec __   <span style="color:#1290c3"> __Mockito__   <span style="color:#666666"> __\.__   <span style="color:#96ec3f"> _spy_   <span style="color:#666666"> __\(__   <span style="color:#80f2f6"> __InterfaceService__   <span style="color:#666666"> __\.__   <span style="color:#cc6c1d"> __class__   <span style="color:#666666"> __\)__    __ ou __ 

![](img%5Cdiapo_tests_unitaires_17.png)

![](img%5Cdiapo_tests_unitaires_18.png)

 __Exercice 3 et 3 bis : Fake et Mock__ 

<span style="color:#3465a4"> __\(Instructions contenues dans le readme\)__ 

 __Tests et base de données__ 

<span style="color:#3465a4"> __Question : Comment sont gérés les jeux de test sur vos applications ?__ 


---
# Comment stocker les données de test ?



*  __On peut tester les méthodes en créant des objets en Java__ 
*  __Méthode permettant le plus d’isolation__ 
*  __On peut vouloir tester le code en utilisant une base de donnée de test :__ 
  *  __Pour tester la couche DAO \(requête SQL\, Hibernate etc\.\)__ 
  *  __Pour des tests d’intégration__ 
  *  __Pour des tests « moins » unitaires mais plus « couvrants » \(passage au travers de plusieurs couches\)__ 



---
# Comment concevoir un jeu de test ?

 __Tentation : Récupérer des données de production__ 

 __Problème : Méconnaissance du contenu exact des données__ 

 __Idéal : Constituer un jeu de données de test « ad hoc »__ 

 __Réalité : Inspiration et récupération d’une partie des données de production \(ex : nomenclature\)__ 

 __Attention : Mettre en commun les données de test des différents test créée une dépendance__ 

 __Limite : Multiplier les jeux de données de test augmente la charge de maintenance des tests__ 

 __Dans la réalité on cherche un compromis raisonnable__ 


---
# Plusieurs solutions pour les BDD de test

 __Plusieurs solutions techniques existent pour gérer les données de test__ 

 __Base distante : Utilisation d’un serveur BDD distant \(au CEI\)__ 

 __Base locale : Installation sur le poste développeur d’une BDD__ 

 __Base embarquée : Utilisation de librairies permettant de déployer une BDD au moment du test__ 

 __Base mémoire : Base embarquée stockée en RAM__ 

 __Question de l’isomorphisme avec l’environnement de production importante\, en particulier pour les fonction « propriétaires » du SGBD__ 


---
# Base distante



*  __Demande au CEI d’une BDD de test__ 
*  __Avantage : Les tests s’exécutent avec la même architecture que la production__ 
*  __Inconvénients :__ 
  *  __Dépendance au réseau__ 
  *  __Lenteurs possibles__ 
  *  __Comment gérer l’exécution simultanée des tests par plusieurs développeurs ? \(un schéma par développeur\)__ 
  *  __Comment gérer l’exécution sur la PIC ?__ 
*  __Tentation d’utiliser des données de production de manière persistante \(ex : Lei\)__ 
*  __Différence progressive entre données de production et données de tests__ 



---
# Base locale



*  __Installation sur le poste développeur d’une BDD__ 
*  __Idéal : Choix d’une version identique à la prod__ 
*  __Plus de dépendance au réseau\, performances__ 
*  __Inconvénients :__ 
  *  __Requiert des manipulations et configuration sur chaque poste développeur__ 
  *  __Problème éventuel de droits \(version portable\)__ 
  *  __Comment gérer l’exécution des tests sur la PIC ?__ 



---
# Base en mémoire



*  __BDD SQL contenue dans la RAM__ 
*  __Déployée à partir d’une librairie qu’on ajoute au POM__ 
*  __Avantages :__ 
  *  __Indépendance__ 
  *  __Performances__ 
  *  __Exécution sur la PIC sans problème__ 
*  __Inconvénients : Problème potentiel de différence entre les environnements__ 
*  __Solution satisfaisante de manière général__ 
*  __Impossible de tester les requêtes propriétaire de la BDD \(par ex pgSql\)__ 
*  __Consultation possible du contenu de la base mais en mode dégradé__ 



---
# Base en mémoire : Exemple

 __2 produits majeurs : H2\, HSQLDB__ 

 __H2 peut fonctionner avec un driver Postgres__ 

 __Connexion avec InseeConfig :__ 

 __Connexion sans InseeConfig \(ou plus simple encore avec les properties seulement en Spring Boot\) :__ 

![](img%5Cdiapo_tests_unitaires_19.png)

![](img%5Cdiapo_tests_unitaires_20.png)

![](img%5Cdiapo_tests_unitaires_21.png)


---
# Base embarquée

 __Certaines librairies proposent des base identique au BDD de production en mode embarqué__ 

 __Permet d’avoir l’indépendance et l’isomorphisme vis\-à\-vis de l’environnement de production__ 

 __Plus lent que les bases en mémoire__ 

 __Permet de tester les requêtes SQL « propriétaires » \(ex : copy en Postgres\)__ 


---
# Base embarquée : Exemple

 __La librairie Zonky permet de disposer d’une BDD Postgres embarquée démarrée au début du test__ 

 __La base est stocké sur le disque → Lenteurs au démarrage__ 

 __La log de la base est consultable\, la config de la BDD paramétrable__ 

 __On peut se connecter à la base en plaçant des points d’arrêt \(debug\)__ 

 __Installation :__ 

 __Utilisation :__ 

 __Très bien pour les tests d’intégration\, souplesse pour le paramétrage__ 

![](img%5Cdiapo_tests_unitaires_22.png)

![](img%5Cdiapo_tests_unitaires_23.png)

 __DBUnit : Une gestion via XML des jeux de test__ 


---
# Outil de gestion des données de test

 __Question : Sous quelle forme stocker\, insérer les données de test ?__ 

 __DBUnit est un framework permettant la gestion des données de test via fichiers XML \(appelé « dataset »\)__ 

 __En utilisation dans plusieurs applications du parc Insee__ 

 __Moins utilisé maintenant car assez verbeux et coût en maintenance__ 


---
# Digression : Les étapes d’un test



*  __Avant le test :__ 
  *  __Ouvrir une connexion à la base__ 
  *  __Créer la structure de la base__ 
  *  __Remplir la base avec les données utiles au test qui va suivre__ 
  *  __Fermer la connexion__ 
*  __Test__ 
*  __Après le test :__ 
  *  __Rien si vous avez bien conçu votre affaire ;\-\)__ 
  *  __Nettoyer un peu le contenu de la base sinon__ 



---
# DBUnit : Exemple

![](img%5Cdiapo_tests_unitaires_24.png)



*  __Installation :__ 
*  __Exécution d’un script pour créer le schéma :__ 
*  __Constitution d’un dataset contenant les données de test :__ 


![](img%5Cdiapo_tests_unitaires_25.png)

![](img%5Cdiapo_tests_unitaires_26.png)


---
# DBUnit : Chargement dataset



*  __On charge ensuite le contenu du fichier XML dans la base de données :__ 
*  __Conclusion : DBUnit offre une méthode de gestion des jeux de données de test__ 
*  __Inconvénients :__ 
  *  __Fichier dataset très verbeux__ 
  *  __Coût de maintenance important en cas de modification du modèle de données__ 
  *  __Problème potentiel pour gérer l’ordre d’insertion__ 
*  __Autre solution : Créer les objets en Java\, les insérer avec Hibernate… Mais c’est un autre sujet __ 


![](img%5Cdiapo_tests_unitaires_27.png)

![](img%5Cdiapo_tests_unitaires_28.png)

 __Merci de votre attention__ 

 __Avez\-vous des questions ?__ 

<span style="color:#ff6633"> _Prénom Nom_   <span style="color:#ff6633"> __ __    __Philippe SABAA__ 

Mél : philippe\.sabaa@insee\.fr

Très inspiré du diapo de    __Michael Genet__ 

<span style="color:#ff6633"> __Insee__ 

<span style="color:#ff6633">Établissement :    __SNDI de Nantes__ 

