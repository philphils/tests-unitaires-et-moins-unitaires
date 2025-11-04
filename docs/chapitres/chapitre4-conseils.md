# Conseils\, 
# bonnes pratiques et 
# stratégie de test

--

# Quelle méthode teste-t-on ?

* __Quel type de méthode tester ?__ 

* __Private ? Protected ? Public ?__ 

* __Pourquoi ?__ 

* __Peut\-on changer une visibilité pour pouvoir tester ?__ 


--
# Réponse :

* __Idée : On ne teste que les méthodes public car ce sont elles qui exposent un service__ 

* __Le reste est l’implémentation qui peut évoluer et reste interne par définition__ 

* __Idée : On ne change pas le code applicatif \(visibilité par ex\) pour les tests__ 

* __Les tests sont faits pour sécuriser le code applicatif, pas l’inverse__ 

* __Cas du code legacy__ 

--
# Quelle couche teste-t-on ?

* __Quelle couche teste-t-on prioritairement ?__ 

* __DAO ? Model ? Service ? IHM ? Batch ?__ 

* __Pourquoi ?__ 

* __Comment s’assurer qu’on teste bien tout le code ?__ 


--
# Réponse :

* __Idéal : test de toute les méthodes__ 

* __Réalité : trouver un compromis raisonnable__ 

* __Test prioritaire de la couche Service__ 

* __Inutile de tester du code généré simple \(ex : Getter/Setter\)__ 

* __Attention : le code des tests appartient à l’application et doit donc être maintenu \!__ 

* __On s’assure qu’on couvre bien tout le code avec des outils \(cf diapo suivante\)__ 


--
# Couverture de test

*  __Notion de couverture : ensemble du code qui est exécuté par l’un des tests au moins__ 
*  __Idéal : Couverture de 100 % du code de l’application__ 
*  __Outils pour contrôler la couverture du code :__ 
    *  __Plugin Eclipse (EclEmma) ou VS Code__
    *  __Sonar__ 

--
# Couverture de test


*  __Arbitrage nécessaire :__ 
    *  __Test unitaire :__
        *  __✅ : Isolation\, indépendance, précision__
        *  __❌ : faible couverture de test, besoin de mock, intéractions pas vérifiées__ 
    *  __Test d’integration :__
        * __✅ : grande couverture de test, proche réalité, test l'ensemble et les intéractions__
        * __❌ : pas d’isolation, dépendance, pas précis__ 
    


--
# Stratégie de test

* __Test d’intégration permettent de couvrir un maximum de code \(niveau API service ou batch\)__ 

* __Test unitaire sont utiles pendant le développement \(cf TDD diapo suivante\) et pour débuggage__ 

* __Fixer des objectifs de couverture de tests avec l’équipe__ 

--
# Stratégie de test

* __DAO : Si méthodes générées (ex: Spring Data), test des méthodes complexes seulement__ 

* __Model : Si méthode complexe (peu normalement)__ 

* __Service : à tester !!!__ 

* __IHM : peut\-être délégué à d’autres outils \(les framework JS ont leur outils de tests\)\, Selenium en mode test d’intégration__ 


--
# Test Driven Development (TDD)

* __Méthode de développement basé sur les tests__ 

* __Idée : on a jamais le temps pour les tests \(1 tier du temps de dév normalement \!\)__ 

* __→ Écrire le test avant le code \!__

* __Un peu déroutant mais très efficace__


--
# Test Driven Development (TDD)

* __On crée seulement la signature de la méthode à tester__ 

* __On écrit le test qui doit planter au début : données\(GIVEN\)\, appel à la méthode \(__    __WHEN\)\, vérification des résultats attendus \(THEN\)__ 

* __On écrit ou modifie ensuite le code de la méthode__ 

--
# Génération des tests avec l'IA

* __L'IA comme assistant pour la génération de tests unitaires__

* __Avantages :__
    * __Gain de temps considérable sur les cas simples__
    * __Aide à la couverture de test initiale__
    * __Propose des cas de tests auxquels on n'aurait pas pensé__

--
# Génération des tests avec l'IA

* __Aide précieuse pour le code legacy :__
    * __Analyse du comportement attendu du code existant__
    * __Documentation implicite via les tests générés__
    * __Identification des cas limites cachés dans le code__
    * __Support pour la compréhension du code ancien__

--
# Génération des tests avec l'IA

* __Limites et points d'attention :__
    * __Nécessité de revoir et adapter le code généré__
    * __Qualité variable selon la complexité du code__
    * __Risque de tests incomplets ou incorrects__
    * __Ne remplace pas la réflexion sur les cas métier__

--
# Utilisation de ChatGPT pour les tests

* __Pas de possibilités d'utiliser Copilot sur des projets Insee non-libres__
* __Avec ChatGPT, bonnes pratiques :__
    * __Fournir le contexte complet (classe à tester + dépendances)__
    * __Demander des tests spécifiques pour les cas limites__
    * __Vérifier la cohérence avec les spécifications__
    * __Adapter les tests générés aux conventions du projet__

--
# Génération des tests avec l'IA

* __Exemple de prompt :__
    * __"Générer des tests JUnit 5 pour la classe X"__
    * __"Inclure les cas limites et les exceptions"__
    * __"Utiliser AssertJ pour les assertions"__
    * __"Respecter le format GIVEN/WHEN/THEN"__

--
# Exercice : Tests avec IA

1. __Prendre une classe existante du projet__
2. __Utiliser ChatGPT pour générer des tests unitaires__
3. __Analyser et améliorer les tests générés :__
    * __Identifier les cas manquants__
    * __Corriger les erreurs éventuelles__
    * __Adapter aux conventions du projet__
4. __Comparer avec des tests écrits manuellement__
5. __Discussion : avantages/inconvénients constatés__

* __Le test doit passer au vert à l’issu du développement ✅__ 

--

 # Exercice 2 :
 # Test nouvelle méthode service

![](./img/diapo_tests_unitaires_11.png)

<span style="color:#3465a4"> __\(Instructions contenues dans le readme\)__ 