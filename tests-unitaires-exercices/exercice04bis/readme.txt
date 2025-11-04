Exercice 04bis - Tests avec IA sur un calculateur de bonus/malus écologique
=================================================================

Objectif
--------
L'objectif de cet exercice est d'expérimenter l'utilisation de l'IA (ChatGPT) pour générer des tests unitaires sur une classe qui calcule les bonus/malus écologiques des véhicules. Cet exercice permettra de comparer l'approche générée par l'IA avec l'écriture manuelle de tests.

Code fourni
-----------
- ModeleVoiture.java : Classe représentant un modèle de voiture avec son type de carburant et son année
- Carburant.java : Énumération des types de carburant (ESSENCE, DIESEL, GPL, ELECTRIQUE, HYBRIDE)
- VehiculePrixServices.java : Service de calcul des bonus/malus et prix des véhicules
- Horloge.java : Utilitaire pour gérer la date courante dans les tests

Votre mission
------------
1. Analyser le code fourni, particulièrement la nouvelle classe VehiculePrixServices.java et ses règles métier
2. Utiliser ChatGPT pour générer des tests unitaires :
   - Fournir à ChatGPT le code des classes ModeleVoiture, Carburant et VehiculePrixServices
   - Demander des tests JUnit 5 avec AssertJ
   - Demander explicitement de tester les règles de bonus/malus
3. Créer une classe VehiculePrixServicesTest et y implémenter les tests générés. Lancer les nouveaux tests.
4. Analyser les tests générés, réfléchir aux améliorations :
   - Identifier les cas de test manquants
   - Corriger les éventuelles erreurs ou imprécisions
   - Adapter le style aux conventions du projet
5. Écrire manuellement des tests complémentaires si nécessaire
6. Comparer l'approche IA vs manuelle :
   - Noter les avantages et inconvénients
   - Évaluer la qualité des tests générés
   - Mesurer le temps gagné/perdu

Indications
----------
- Utilisez les annotations @Test de JUnit 5
- Préférez les assertions AssertJ (assertThat)
- Structurez vos tests avec des commentaires GIVEN/WHEN/THEN
- Pensez aux cas limites : prix négatifs, remises > 100%, etc.
- Pour le prompt ChatGPT, demandez explicitement :
  * Des tests JUnit 5 avec AssertJ
  * Des tests pour les cas limites et exceptions
  * Une structure GIVEN/WHEN/THEN
  * Des noms de méthodes explicites