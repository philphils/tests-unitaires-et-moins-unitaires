
# Tests et base de données

--

<span style="color:#3465a4"> __Question : Comment sont gérés les jeux de test sur vos applications ?__ 


--
# Comment stocker
# les données de test ?

*  __Création des objets en Java__ 
* __Méthode permettant une isolation et une indépendance maximum__
* __Ex:__
    ```java
        Personne jojo = new Personne("Joseph", "Dupont");
        monService.methodeATester(jojo);
        Assert.assertThat(jojo)...
    ```
--
# Comment stocker
# les données de test ?

*  __On peut vouloir tester le code en utilisant une base de donnée de test :__
    *  __Pour tester la couche DAO \(requête SQL\, Hibernate etc\.\)__ 
    *  __Pour des tests d’intégration__ 
    *  __Pour des tests « moins » unitaires mais plus « couvrants »__ 

--
# Comment concevoir un jeu de test ?

* __Tentation : Récupérer des données de production__ 

* __Problème : Méconnaissance du contenu exact des données__ 

* __Idéal : Constituer un jeu de données de test « ad hoc »... Mais très chronophage !__ 

* __Réalité : Inspiration et récupération d’une partie des données de production \(ex : nomenclature\)__ 

--
# Comment concevoir un jeu de test ?

* __Tentation : Mettre en commun les données de tests des différents cas...__

* __Problème : Mettre en commun les données de test des différents test crée une dépendance__ 

* __Limite : Multiplier les jeux de données de test augmente la charge de maintenance des tests__ 

* __Dans la réalité on cherche un compromis raisonnable__ 


--
# Solutions pour les BDD de test

* __Plusieurs solutions techniques existent pour gérer les données de test :__ 

    * __Base distante : Utilisation d’un serveur BDD distant \(au CEI\)__ 

    * __Base locale : Installation sur le poste développeur d’une BDD__ 

    * __Base embarquée : Utilisation de librairies permettant de déployer une BDD au moment du test__ 

    * __Base mémoire : Base embarquée stockée en RAM__ 

--
# Solutions pour les BDD de test

* __On recherche une solution qui soit la plus proche du stockage final en production__
* __Mais on veut une solution indépendante de l'environnement__
* __On veut aussi que les tests s'exécutent rapidement__

--
# Base distante

*  __Utilisation d'un base de dev pour l'exécution des tests__
*  __✅ Même architecture que la production__ 
*  __❌ Inconvénients :__
    *  __Dépendance au réseau__
    *  __Lenteurs possibles__
    *  __Comment gérer l’exécution simultanée des tests par plusieurs développeurs ? \(un schéma par développeur\)__
    *  __Comment gérer l’exécution en CI/CD ?__


--
# Base locale : Avantages

*  __Installation sur le poste développeur d’une BDD__ 
*  __Idéal : Choix d’une version identique à la prod__ 
*  __Indépendance vis-à-vis du réseau, bonnes performances__ 

--
# Base locale : Inconvénients


*  __Requiert des manipulations et configuration sur chaque poste développeur__ 
*  __Problème éventuel de droits \(version portable\)__ 
*  __Comment gérer l’exécution des tests en CI/CD ? (solution possible avec les services Gitlab)__ 

--
# Base en mémoire

*  __BDD SQL contenue dans la RAM__ 
*  __Déployée à partir d’une librairie qu’on ajoute au POM__ 
*  __Avantages :__ 
    *  __Indépendance__ 
    *  __Performances__ 
    * __Exécution CI/CD sans problème__

--
# Base en mémoire

*  __Inconvénients : Problème potentiel de différence entre les environnements__ 
*  __Impossible de tester les requêtes propriétaire de la BDD (ex: `copy` de Postgres)__ 
*  __Consultation possible du contenu de la base mais en mode dégradé__ 



--
# Base en mémoire : Exemple

* __Cette solution reste statisfaisante dans beaucoup de cas__
* __2 produits majeurs : H2\, HSQLDB__ 
* __H2 peut fonctionner avec un driver Postgres__ 

![](./img/diapo_tests_unitaires_19.png)

--
# Base en mémoire : Exemple

* __Connexion avec SD44Configuration :__ 
```java
SD44Configuration.getPool("poolTest").getConnection();
```

* __Connexion sans SD44Configuration \(ou plus simple encore avec les properties seulement en Spring Boot\) :__ 

![](./img/diapo_tests_unitaires_21.png)


--
# Base embarquée

* __Certaines librairies proposent des bases identiques au BDD de production en mode embarqué__ 

* __Permet d’avoir l’indépendance et l’isomorphisme vis\-à\-vis de l’environnement de production__ 

* __Plus lent que les bases en mémoire__ 

* __Permet de tester les requêtes SQL « propriétaires »__ 


--
# Base embarquée : Exemple

* __La librairie Zonky permet de disposer d’une BDD Postgres embarquée démarrée au début du test__ 

* __La base est stocké sur le disque → Lenteurs au démarrage__ 

* __La log de la base est consultable\, la config de la BDD paramétrable__ 

* __On peut se connecter à la base en plaçant des points d’arrêt \(debug\)__ 

--
# Base embarquée : Exemple

* __Installation :__ 
![](./img/diapo_tests_unitaires_22.png)

* __Utilisation :__ 
![](./img/diapo_tests_unitaires_23.png)

* __Très bien pour les tests d’intégration\, souplesse pour le paramétrage__ 


--
# Base embarquée : Exemple


* __Pour Postgres, il faut aussi ajouter la librairie :__
```xml
    <dependency>
        <groupId>io.zonky.test</groupId>
        <artifactId>embedded-postgres</artifactId>
        <version>1.2.9</version>
        <scope>test</scope>
    </dependency>
```

--
# Solution à l'état de l'art :
# Docker !

- __On peut utiliser une solution basée sur Docker__
- __Permet d'avoir une base à l'image de la production__
- __Déploiement rapide et simple__
- __Cf Partie [Testcontainer](#/9) !__

