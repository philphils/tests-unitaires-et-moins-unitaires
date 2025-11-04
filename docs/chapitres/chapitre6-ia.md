# Utilisation de l'IA pour les tests

--
# Génération des tests avec l'IA

* __L'IA très intéressant comme assistant pour la génération de tests unitaires__

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
# Points de vigilance

* __Limites et points d'attention :__
    * __Nécessité de revoir et adapter le code généré__
    * __Qualité variable selon la complexité du code__
    * __Risque de tests incomplets ou incorrects__
    * __Ne remplace pas la réflexion sur les cas métier__

--

# ⚠️ Sécurité et confidentialité

* __Attention au code confidentiel :__
    * __NE JAMAIS soumettre de code sensible aux LLM publics (ChatGPT, etc.)__
    * __NE JAMAIS soumettre de données personnelles ou administratives__
    * __Le code soumis devient accessible à l'éditeur du LLM__
    * __Risque de fuite de données ou de logique métier sensible__

--

# ⚠️ Sécurité et confidentialité

* __Bonnes pratiques :__
    * __Utiliser uniquement les LLM internes pour le code sensible__
    * __Pour les LLM publics : du code public/open source ou non sensible__
    * __Anonymiser/nettoyer le code si nécessaire__
    * __En cas de doute, consulter la politique de sécurité__

--

# ❌ Mauvaise utilisation des LLM

* __À ne JAMAIS soumettre aux LLM publics :__
    * __Données personnelles ou administratives__
    * __Credentials, tokens, clés de chiffrement__
    * __Règles métier confidentielles__
    * __Configurations de sécurité__

--

#  ✅ Bonne utilisation des 
# LLM externes

* __Utilisation possible avec précaution :__
    * __Code technique standard (CRUD, validations, etc.)__
    * __Tests unitaires sans données sensibles sur des composants__
    * __Requêtes SQL génériques__
    * __Classes modèle simples__

--
#  ✅ Bonne utilisation des 
# LLM externes

* __Bonnes pratiques :__
    * __Anonymiser les noms si besoin__
    * __Utiliser des données factices__
    * __Privilégier les LLM internes si disponibles__
    * __En cas de doute, consulter l'équipe sécurité__

--
# Génération des tests avec ChatGPT

* __Pas de Copilot sur des projets Insee non-libres -> accès à l'ensemble du projet__
* __Avec ChatGPT, bonnes pratiques :__
    * __Fournir le contexte complet (classe à tester + dépendances)__
    * __Demander des tests spécifiques pour les cas limites__
    * __Vérifier la cohérence avec les spécifications__
    * __Adapter les tests générés aux conventions du projet__

--
# Génération des tests avec ChatGPT

* __Exemple de prompt :__
    * __"Générer des tests JUnit 5 pour la classe X"__
    * __"Inclure les cas limites et les exceptions"__
    * __"Utiliser AssertJ pour les assertions"__
    * __"Respecter le format GIVEN/WHEN/THEN"__

--

# Exercice 4 bis : 
# Utiliser ChatGPT pour les tests

![](./img/diapo_tests_unitaires_18.png)

<span style="color:#3465a4"> __\(Instructions contenues dans le readme\)__ 