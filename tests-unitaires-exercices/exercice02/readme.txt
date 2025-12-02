Exercice 02 - instructions

On part d'une classe de service avec son test (déjà écrits).
On va faire évoluer le code et vérifier avec la réalisation d'un nouveau test.

0- examiner le code du test disponible
cf. cours sur matcher, hamcrest et tests multiples

1- évolution du code 
on veut faire évoluer le code
désormais on veut gérer des conducteurs et des voitures en plus des modèles de voitures

- une voiture est caractérisée par une immatriculation (identifiant de la voiture) et un modèle de voiture
créer la classe voiture et générer tous les éléments nécessaires avec Eclipse (getters, setter, toString... etc)

- un conducteur est caractérisé par un nom et un prénom (qu'on considérera comme ses identifiants unique)
il possède une à plusieurs voitures
créer la classe conducteur et tous les éléments nécessaires

2- on veut maintenant disposer d'un service métier qui, partant d'une liste de conducteurs, renvoie la liste des conducteurs possédant un véhicule considéré comme peu polluant
ce service devra s'appuyer sur le service déjà existant qui filtre les modèles de voiture peu polluants
(vous pouvez modifier l'ordre des étapes pour développer en TDD)
- développer le service
- mettre en place un test avec ce qu'on a déjà vu en cours
- se poser quelques questions...