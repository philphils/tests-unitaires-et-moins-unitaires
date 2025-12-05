# Généralités sur les tests

--

## 1. Pourquoi tester ?

Les tests logiciels ont plusieurs objectifs fondamentaux :

-   **Vérifier que le code fonctionne conformément au besoin**
-   **Prévenir les régressions** lors des évolutions
-   **Sécuriser les mises en production**
-   **Faciliter la maintenance et la compréhension du code**
-   **Servir de documentation technique vivante**

--

## 2. Qu'est-ce qu'un test unitaire ?

### Définition

* Un **test** vérifie qu'un traitement produit le résultat attendu.
* Un **test unitaire** porte sur une unité logicielle isolée (méthode,
classe, module).

--

### Notion d'isolation

On isole la portion de code testée pour : 
* Eliminer les dépendances
extérieures
* Cibler précisément les erreurs
* Accélérer l'exécution des tests.

--

### Avantages des tests

-   Localisation rapide des erreurs
-   Prévention de la régression
-   Documentation du comportement attendu
-   Support au développement (ex. **TDD**)

--

### Inconvénients

- Coût de développement
- Coût de maintenance non négligeable
- Besoin de discipline et de structuration

--

## Tests unitaires vs tests d'intégration

-   Les **tests unitaires** vérifient des éléments isolés du code.
-   Les **tests d'intégration** valident le fonctionnement global d'une
    fonctionnalité complète.

--

## Stratégie de test

Chaque projet doit définir sa **stratégie de test** :

-   Que teste-t-on en priorité ?
-   Comment teste-t-on ?
-   Quels outils utilise-t-on ?
-   Quelles données de test ?
-   Quel niveau de couverture est acceptable ?

--

## Stratégie de test

* Les pratiques varient selon les écoles
* L'essentiel est d'avoir une
stratégie raisonnable et adaptée au projet et à l'équipe
* Important d'avoir une vision partagée par tous les membres

--

## Impact sur le projet

-   On considère que les tests représentent **1/3 du temps projet**
-   Automatisation via **CI/CD** (Maven, GitLab CI...)
-   Rejeu automatique des tests avant livraison
-   Réduction des erreurs de dernière minute
-   Possibilité d'utiliser l'IA pour générer des cas simples

--

## Structure d'un test unitaire : GIVEN / WHEN / THEN

On structure un test en trois étapes :

1.  **GIVEN** : Mise en place des données et du contexte
2.  **WHEN** : Exécution du traitement
3.  **THEN** : Vérification du résultat

--

## Structure d'un test unitaire : GIVEN / WHEN / THEN

- Les étapes peuvent être clairement indiquées en commentaires.
- Certaines peuvent être vides (ex : GIVEN vide si aucun prérequis).

--

## Première approche naïve : les tests "main"

Avant les frameworks de test, certains projets utilisaient des classes
`main` :

``` java
public static void main(String[] args) {
    // Test manuel d'une méthode
}
```


--
# Exemple 1 : Test main

![](./img/diapo_tests_unitaires_2.png)

* __Présentation du modèle__ 

* __Test de :__   <span style="color:#a7ec21; font-weight: bold">filtrerModelesMoinsPolluants</span>

* __Repérage de la structure du test \(GIVEN\, WHEN\, THEN\)__ 

--
# Exemple 1 : Test main

* __Exécution du test__ 

* __Observation des résultats__ 

* __Commentaires ?__ 

* __Inconvénients ?__ 


--

### Inconvénients majeurs

-   Lancement manuel
-   Vérification manuelle (console, logs...)
-   Mélange code de test / code métier
-   Non réutilisable
-   Risque élevé d'erreur humaine

--

## 8. Conclusion

Nous avons vu : - Pourquoi tester
- Ce qu'est un test unitaire
- Comment structurer un test
- Les limites des approches manuelles
- La nécessité d'outiller les tests

👉 La suite : introduction à **JUnit**, le framework standard des tests
unitaires en Java.
