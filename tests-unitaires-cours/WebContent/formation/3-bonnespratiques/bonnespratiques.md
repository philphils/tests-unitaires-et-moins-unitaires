## La régle à retenir

**Il n'est pas rentable de tout tester**

**il faut tester tout ce que qui est susceptible de planter !**

!!!!
## Il faut tester quoi ?
Méthodes *public* ? *protected* ? *private* ?

A votre avis ? 

Et pourquoi ?

====
Réponse :

On ne teste que les méthodes *public*.

Ce qui est *public*, c'est le contrat !

Le reste, c'est du détail d'implémentation.

Ca peut changer (instable) 

et ça ne nous regarde pas (c'est pour ça qu'on le cache).

====

#### Une erreur à ne jamais commettre :

**on ne change pas une méthode *private* en méthode *public* **

**pour en faire un test.**

====
Mais alors comment on s'assure qu'on teste le code d'une méthode *private* ?

Avec la *couverture de test* !

!!!!
## La couverture de test
C'est quoi ?

C'est l'ensemble des lignes de code source "couvertes" par les tests.

</br>

Et "couvertes" alors, ça veut dire quoi ?

Une ligne est "couverte" si on est certain que cette ligne s'exécute pendant les tests.

====
###Un outil dans Eclipse

*EclEmma Java Code Coverage* 

Installation via *marketplace* si pas déjà installé dans votre *Eclipse*.

Et une mise en pratique sur l'exercice 1 ! 

====
###Ou bien sur Gitlab : Sonar

Demander de l'aide au groupe Support Dév ;-)

Possiblilité également de rajouter un plugin dans Eclipse.

!!!!
## Il faut tester quoi ? (suite)

Les getters et les setters ?

Les DAO ?

Les services ?

====
**Réponse : on ne teste pas le code généré.**

!!!!
## Et le cas du code legacy ?
C'est quoi ?

C'est du code source sans tests...

Une démarche existe pour travailler sur du code legacy.

On verra ça plus en détail plus tard.

!!!!
## Tester avant d'écrire le code : le TDD
#### Principe

**Ecrire les tests avant d'écrire le code testé !**

====
#### En pratique

- Ecrire un test
- Vérifier qu'il échoue (normal puisque le code n'existe pas)
- Ecrire le code à tester pour que le test passe (premier jet)
- Vérifier que le test passe
- Refactorer le code en vérifiant en permanence que le test passe toujours. 

!!!!
## Des tests rejouables (reproductibles)
#### Le cas des dates

Cf. exercice 4 !!!!

!!!!
## Des ressources pour approfondir

https://www.javaworld.com/article/2076265/testing-debugging/junit-best-practices.html

https://putaindecode.io/fr/articles/tdd/

https://en.wikipedia.org/wiki/Legacy_code
https://talentsoftdevelopers.wordpress.com/2014/01/22/quest-ce-que-le-code-legacy/
https://blog.xebia.fr/2015/01/23/legacy-code-se-defaire-des-dependances-statiques/

