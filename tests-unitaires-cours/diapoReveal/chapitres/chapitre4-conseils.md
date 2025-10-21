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

* __On écrit le test qui doit planter au début : données\(GIVEN\)\, appel à la méthode \(__    __WHEN\)\, vérification des résultats attendus \(THEN\)__ 

* __On écrit ou modifie ensuite le code de la méthode__ 

* __Le test doit passer au vert à l’issu du développement ✅__ 

--

 # Exercice 2 :
 # Test nouvelle méthode service

![](../img/diapo_tests_unitaires_11.png)

<span style="color:#3465a4"> __\(Instructions contenues dans le readme\)__ 