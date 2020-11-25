Exercice 04 - instructions

Une nouvelle spécification vient de nous être fournie.

Désormais les régles pour les voitures essence et diesel sont les suivantes :
- une voiture essence est considérée comme peu polluante si elle a moins de 5 ans
- une voiture diesel est considérée comme peu polluante si elle a moins de 3 ans

1. modifier le code et le test pour tenir compte de cette spécification

2. le test fonctionnera-t'il encore dansc 1 ans sans être modifié (durabilité) ?
Pourquoi ?

3. implémenter une solution avec une horloge

Une horloge est une classe utilitaire qui contient une méthode qui renvoie la date du jour.
Par défaut, la date du jour est la date système.
Mais, si on active un flag et qu'on donne une date "fictive" à l'horloge, c'est cette date fictive qu'elle renverra à chaque appel de la méthode.

En vous servant de cette horloge, réécrivez votre code.
Et réécrivez votre test pour le rendre durable. 
