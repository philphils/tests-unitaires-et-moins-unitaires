
# Généralités sur les tests unitaires

--

# Pourquoi tester

*  __S’assurer que le code « fonctionne »__ 
*  __Valider\, guider les développements__ 
*  __Sécuriser les livraisons__ 
*  __S’assurer que ce qu’on a déjà codé continu de fonctionner \(non\-régression\)__ 
*  __En cas de maintenance :__ 
  *  __Vérifier que le bug est bien résolu__ 
  *  __S’assurer qu’il ne se reproduira plus__ 

--
# Pourquoi un test « unitaire » ?

 __Test : Vérifie que le code effectue le traitement attendu__ 

 __Unitaire : Porte sur une partie précise du programme__ 

 __On teste de manière isolée une portion du code \(une « unité »\)__ 

 __Selon les écoles\, portion de code plus ou moins petite__ 

 __Pour des tests sur des fonctionnalités entières on parle de « tests d’intégration »__ 


--
# Quelles utilités ?

 __Localiser plus rapidement les erreurs du code__ 

 __Prévenir la régression__ 

 __Sécuriser les livraisons__ 

 __Aide à la documentation et à la compréhension du code__ 

 __Structurer les développements \(TDD\)__ 


--
# Localisation rapide des erreurs



*  __Tests nombreux et sur des parties réduites du code :__ 
  *  → __Détection rapide de l’origine des erreurs__ 
*  __Inconvénient :__ 
    *  __Coûts de développement élevé__ 
    *  __Coûts de maintenance__ 
*  __Définir une stratégie de test__ 
*  __Adopter une stratégie « raisonnable »__ 



--
# Prévention de la régression

 __Durée de vie d’une application peut\-être longue \(10 ans ou plus\)__ 

 __Nombreuses évolutions\, corrections de bugs\, perte d’informations__ 

 __Comment s’assurer que des évolutions/corrections n’impactent pas d’autres fonctionnalités ?__ 

 __Solution : Mise en place de tests \(et d’abord sur la partie qu’on modifie \!\)__ 


--
# Sécuriser les mises en production

![](../img/diapo_tests_unitaires_1.png)

 __Je livre / je livre pas ? …  __ 

 __Rejeu de l’ensemble des tests avant chaque livraison \(via maven par ex\)__ 

 __Permet de limiter les erreurs de « dernière minute »__ 

 __Vérifier la non\-régression du code applicatif__ 


--
# Outil de compréhension du code

 __Les tests peuvent être vu comme une partie intégrante de la doc de l’application__ 

 __Peut permettre de mieux comprendre le fonctionnement de l’application__ 

 __Attention : bien documenter les tests eux\-mêmes \!__ 


--
# Comment tester ?



*  __Impact fort sur la manière de programmer __ 
*  __Charge importante : 1/3 du temps par ex\.__ 
*  __Nécessite la mise en place d’une « stratégie de test » a__    __u niveau du projet :__ 
  *  __Qu’est\-ce qu’on teste en priorité ?__    __	__ 
  *  __Comment on teste ?__ 
  *  __Quels outils on utilise ?__ 
  *  __Quels données de test ?__ 
*  __Nombreux outils pour faciliter les tests__ 



--
# Structure de base d’un test



*  __Décomposition en 3 étapes :__ 
  *  __GIVEN : Constitution des données et des conditions du test__ 
  *  __WHEN : Exécution du traitement à tester__ 
  *  __THEN : Vérification du bon fonctionnement du code__ 
*  __Permet de guider l’écriture du test__ 
*  __Les étapes peuvent être indiquées clairement en commentaires \(conseillé\)__ 
*  __Certaines étapes peuvent être vides selon les tests \(ex : GIVEN\)__ 



--
# Première approche : les tests « main »



*  __Méthode archaïque de test__ 
*  __Encore présente dans certaines applications__ 
*  __Écriture d’une classe avec une méthode :__ 
* <span style="color:#cc6c1d"> __public__   <span style="color:#d9e8f7"> __ __   <span style="color:#cc6c1d"> __static__   <span style="color:#d9e8f7"> __ __   <span style="color:#cc6c1d"> __void__   <span style="color:#d9e8f7"> __ __   <span style="color:#1eb540"> __main__   <span style="color:#000000"> __\(__   <span style="color:#1290c3"> __String__   <span style="color:#000000"> __\[\] __   <span style="color:#79abff"> __args__   <span style="color:#000000"> __\)__ 
*  __Vérification du bon fonctionnement « manuelle » :__ 
    *  __Plantage ou non ?__ 
    *  __Lecture de l’affichage console__ 
    *  __Observation des données en base__ 



--
# Exemple 1 : Test main

![](../img/diapo_tests_unitaires_2.png)

 __Présentation du modèle__ 

 __Test de : __   <span style="color:#a7ec21"> __filtrerModelesMoinsPolluants__ 

 __Repérage de la structure du test \(GIVEN\, WHEN\, THEN\)__ 

 __Exécution du test__ 

 __Observation des résultats__ 

 __Commentaires ?__ 

 __Inconvénients ?__ 


--
# Tests « main » : le bilan

 __Rend le service de base\, mais…__ 

 __Comment faire si fonction main existe déjà ?__ 

 __Lancement manuel des tests un à un__ 

 __Pas de séparation claire entre le code de test et de production__ 

 __Travail de vérification par l’utilisateur __ 

 __Risque d’erreur__ 

 __→ __    __Besoin d’outiller les tests \!__ 