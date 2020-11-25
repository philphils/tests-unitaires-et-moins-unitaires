# DBUnit ?
*DBUnit* est une extension du framework *JUnit* permettant d'écrire des cas de tests 

en manipulant des bases de données. 

Il permet d'initialiser une base de données et de charger des données.

http://dbunit.sourceforge.net/

!!!!
## Se lancer avec méthode !
Un processus à penser en amont

Faire des tests avec une base de données mérite un peu de réflexion.

Et des choix à faire. 

http://dbunit.sourceforge.net/bestpractices.html

!!!!
## La base de données ?
Les choix possibles :
- avec une base distante
- avec une base locale
- avec une base en mémoire ou embarquée

====
#### une base distante 

Souvent, on dispose déjà d'une base distante (typiquement la base de développement).

Cette base existe et est déjà remplie de données.

Donc on peut facilement s'y greffer pour faire des tests.

====
#### une base distante 

Mais accès partagé ?

Que se passe-t'il si plusieurs personnes lancent des tests en mêmes temps?

Des ennuis...

====
#### une base distante 

Une solution : un schéma par utilisateur.

Mais ça complique le code car il faut gérer la notion de schéma. 

Et il reste le problème de l'accès réseau.

Cet accès peut être lent...

... voire impossible (sauf dérogation) depuis certaines plateformes (gitlab ?)

====
#### une base locale

On élimine le problème du réseau et de la gestion des schémas.

Mais il faut être capable d'installer une base en local sur son poste.

Et quid de Gitlab ?

====
#### une base en mémoire ou embarquée

La solution ultime : isolation, performance et fonctionne sur Gitlab !

Mais dans ce cas, il faut un mécanisme pour créer la base quand les tests démarrent.

Et pour la remplir.

Ca peut paraître très compliqué mais avec des outils comme hibernate, c'est simple.

====
#### une base en mémoire ou embarquée

Un défaut des bases en mémoire : la compatibilité avec PostgreSql.

Pê une solution : PostgreSql embarqué ?

!!!!
## Les étapes du test unitaire avec une base 

Un tests unitaire qui utilise une base doit suivre ces étapes :

1. avant le test :
 - ouvrir une connexion à la base
 - créer la structure de la base (pour le premier test en cas d'enchaînement)
 - remplir la base avec les données utiles au test qui va suivre
 - fermer la connexion

2. le test

3. après le test
 - rien si vous avez bien conçu votre affaire ;-)
 - nettoyer un peu le contenu de la base sinon

!!!!
## Sans DBUnit : un exemple avec base distante ou locale

Exercice 05 !!!

C'est parti ;-)

!!!!
## Installation de DBUnit

Toujours dans le *pom.xml*

	<dependency>
	  <groupId>org.dbunit</groupId>
	  <artifactId>dbunit</artifactId>
	  <version>${dbunitVersion}</version>
	  <scope>test</scope>
	</dependency>

</br>

La version la plus récente aujourd'hui : **2.6.0**

!!!!
## Avec DBUnit : un exemple avec une base en mémoire

Principe

Plutôt qu'une base qui tourne en permanence (listener),

on utilise une base qui n'est activée que pendant les tests.

La base démarre au début des tests.

Et elle est arrêtée à la fin.

Toutes les données sont en mémoire (hyper rapide).

====
Inconvénients : 

* il faut recréer la base à chaque fois qu'on lance les tests

donc il faut du code pour ça !

* plus perturbant : à la fin des tests, impossible de consulter la base

elle est arrêtée et disparue... 

donc il faut tout contrôler pendant le test !

====
Avantages :

* hyper rapide

* isolation 

* fonctionne sur la PIC

* force à respecter les bonnes régles d'un test unitaire

====
#### Quel SGBD ?

Il en existe plusieurs.

Dont [HSQLDB](http://hsqldb.org/),

Et [H2](http://www.h2database.com/html/main.html).

H2 a un avantage : il a des [modes de compatibilités](http://www.h2database.com/html/features.html#compatibility) avec les autres SGBD.

Et (expérimental) H2 peut fonctionner avec un driver PostgreSql !


====
#### Installation de H2

Oh surprise ! Encore une dépendance *maven* !

	<dependency>
		<groupId>com.h2database</groupId>
		<artifactId>h2</artifactId>
		<version>1.4.197</version>
		<scope>test</scope>
	</dependency>

====
#### Mise en oeuvre - Démarrer la base et se connecter

Avec *InseeConfig*, juste renseigner les propriétés comme il faut :


Puis demander une connexion à InseeConfig :

	InseeConfig.getPool("poolTest").getConnection();

====
#### Mise en oeuvre - Démarrer la base et se connecter

Sans *InseeConfig*, directement en JDBC :

	JdbcDataSource dataSource = new JdbcDataSource();
	dataSource.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
	dataSource.setUser("sa");
	dataSource.setPassword("");
	try {
		cnx = dataSource.getConnection();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
  
====
#### Mise en oeuvre - Création de la structure de la base

Il est possible de créer la structure de la base de données à l'aide de DBUnit. 

On fait exécuter à DBUnit un script sql de la manière suivante :

	File init=new File("src/test/resources/inti_database.sql");
	try (InputStreamReader fr = new FileReader(init); BufferedReader br = new BufferedReader(fr)) {
		RunScript.execute(cnx, br);
	}

Notons que le script entier est exécuté 

et qu'il peut contenir des INSERT pour ajouter des données dans la base.

====
#### Mise en oeuvre - Chargement des dataset

Si vous ne savez pas comment écrire des requêtes INSERT 

ou si vous avez envie d'utiliser un mécanisme de chargement de données basé sur des fichiers xml 

vous pouvez utiliser les dataset.

Les dataset présentent le contenu de la base de données sous forme de fichier xml. Par exemple :

	<?xml version="1.0" encoding="UTF-8"?>  
	<dataset>  
		<table1 id="1" libelle="A" />
	    <table2 id="2" id_table_1="1" />
	</dataset>

====
#### Mise en oeuvre - Chargement des dataset

Le chargement des dataset se fait après la création de la structure de la base et de la manière suivante :

	IDatabaseConnection dbUnitConnection = new DatabaseConnection(cnx);
	File init=new File("src/test/resources/inti_database.sql");
	try (InputStreamReader fr = new FileReader(init); BufferedReader br = new BufferedReader(fr)) {
		RunScript.execute(cnx, br);
	}
	FlatXmlDataSetBuilder xmlDSBuilder = new FlatXmlDataSetBuilder();
	xmlDSBuilder.setCaseSensitiveTableNames(false);
	InputStream inputStreamXML = new FileInputStream("src/test/resources/dataset.xml");
	IDataSet dataSet = xmlDSBuilder.build(inputStreamXML);
	DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnection, dataSet);

====
#### Mise en oeuvre

Et maintenant il faut mettre en pratique.


!!!!
## Pour approfondir : postgresql embarqué

https://github.com/yandex-qatools/postgresql-embedded

https://github.com/opentable/otj-pg-embedded

https://dzone.com/articles/using-embedded-postgresql-databases-for-unit-testi

https://hackage.haskell.org/package/postgres-embedded
