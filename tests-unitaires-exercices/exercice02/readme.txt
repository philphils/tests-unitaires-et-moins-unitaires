Exercice 02 - instructions

Le but de l'exercice est d'intégrer petit à petit les notions de fake et mock dans la réalisation des tests unitaires.
Tout en continuant à se questionner sur la pertinence de certains tests ou la façon de les faire (cf. cours - bonnes pratiques)

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
- développer le service et mettre en place un test avec ce qu'on a déjà vu en cours
- se poser quelques questions...