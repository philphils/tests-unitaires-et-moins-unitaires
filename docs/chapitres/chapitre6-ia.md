# Utilisation de l’IA 
# pour les tests unitaires

--

## Pourquoi utiliser l’IA ?

- **Gain de temps** : accélère la création des tests unitaires, surtout pour les cas simples.
- **Aide à la couverture de tests** : suggère des cas auxquels on ne pense pas toujours.
- **Support pour le code legacy** :
  - Analyse le comportement attendu du code existant.
  - Génère des tests servant de documentation implicite.
  - Identifie les cas limites cachés dans le code.

--

## Limites à connaître

- **Validation indispensable** : les tests générés doivent toujours être revus et adaptés.
- **Qualité variable** : dépend de la complexité du code.
- **Réflexion métier non remplacée** : l’IA ne comprend pas les règles fonctionnelles.
- **Risque de tests incomplets ou incorrects** : ne pas se fier aveuglément au résultat.

--

## Bonnes pratiques d’utilisation

- **Fournir le contexte complet** : inclure la classe à tester et ses dépendances.
- **Demander des cas spécifiques** : cas limites, exceptions, scénarios métiers.
- **Utiliser les conventions du projet** : nommage, framework de test, style GIVEN/WHEN/THEN.
- **Adapter les tests générés** : les intégrer proprement au projet.

--

## Sécurité et confidentialité

### ❌ À ne jamais soumettre aux LLM publics

- Données personnelles ou administratives.
- Credentials, tokens, clés de chiffrement.
- Logique métier confidentielle.
- Fichiers de configuration sensibles.

--

### ✅ Utilisation raisonnable possible avec précaution

- Code technique générique (CRUD, validations).
- Tests unitaires sans données sensibles.
- Requêtes SQL ou classes modèle simples.
- Logique métier non sensible
- Utilisation de **LLM internes** préférée si disponibles.

--

### 🔒 Bonnes pratiques de sécurité

- **Anonymiser les noms** si besoin.
- **Nettoyer le code** avant soumission.
- **Vérifier la politique de sécurité** en vigueur.
- **Demander l’avis de l’équipe sécurité** en cas de doute.

--

## Exemple de prompt efficace

```plaintext
Génère des tests JUnit 5 pour la classe X.
Inclure les cas limites et les exceptions.
Utiliser AssertJ.
Suivre le format GIVEN / WHEN / THEN.
```
(fournir la classe en PJ)

--

# Exercice 4 bis : 
# Utiliser ChatGPT pour les tests

![](./img/diapo_tests_unitaires_18.png)

<span style="color:#3465a4"> __\(Instructions contenues dans le readme\)__ 