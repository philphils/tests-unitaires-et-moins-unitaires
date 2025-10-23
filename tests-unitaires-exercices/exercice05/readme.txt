Exercice 05 - Tests avec Testcontainers
================================

Objectif
--------
L'objectif de cet exercice est d'apprendre à utiliser Testcontainers pour tester une DAO avec une vraie base de données PostgreSQL.

Code fourni
-----------
- ModeleVoiture.java : Une classe représentant un modèle de voiture
- Carburant.java : Une énumération des types de carburant
- ModeleVoitureDao.java : Une DAO JDBC avec les méthodes de base

Votre mission
------------
1. Vérifier que Docker (ou Podman sur poste Insee) est installé et configuré
2. Examiner le pom.xml pour comprendre les dépendances Testcontainers
3. Créer une classe de test ModeleVoitureDaoTest qui :
   - Démarre un conteneur PostgreSQL avec Testcontainers
   - Crée la table nécessaire via la DAO
   - Teste l'insertion et la lecture d'une voiture
4. Bonus : Se connecter à la base en debug avec DBeaver

Indications
----------
- L'annotation @Testcontainers est nécessaire sur la classe de test
- Utiliser @Container sur le conteneur PostgreSQL
- Le conteneur doit être static
- Penser à fermer les ressources dans @AfterAll
- Sur poste Insee, suivre la procédure d'installation de Podman :
  https://sndi-nantes.gitlab-pages.insee.fr/portail-des-connaissances/service-production/outils-prod/podman/