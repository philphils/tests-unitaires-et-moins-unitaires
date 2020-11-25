## Une limite de tests unitaires

**Un test = une classe** 

Mais alors quid des dépendances entre classes ?

====
Illustration :

Le service *ConducteurServices* a besoin de la classe *ModeleVoitureServices*.

		public class ConducteurServices {
			
			private ModeleVoitureServices modeleVoitureServices;
			
			public ConducteurServices() {
				this.modeleVoitureServices = new ModeleVoitureServices();
			}
		
		...

!!!!
## Solution sans framework
Il faut simuler la classe dépendante par une autre classe.

Le **FAKE** !

====
## Fake : le principe

On applique le design pattern Proxy

https://fr.wikipedia.org/wiki/Proxy_(patron_de_conception)

====
## Fake : un exemple
 
Exercice 03 ;-)

====
## Fake : les limites

- Long et pénible à développer (donc source d'erreurs) 

- Pour faire un fake "intelligent", il faut beaucoup investir.

!!!!
## Mieux que les fakes ? 

Les **mocks** !

Un **mock** est un **fake** plus "simple" à écrire.

====
## Un mock ?
Les doublures d'objets ou les objets de type mock permettent de simuler 

le comportement d'autres objets. 

Ils peuvent trouver de nombreuses utilités notamment dans les tests unitaires 

où ils permettent de tester le code en maitrisant le comportement des dépendances.

Concrètement, nous utilisons des mock pour simuler le comportement d'autres classes. 

====
Plusieurs cas de figure peuvent justifier l'utilisation de mock :

- Nous faisons appel à une resource qui n'est pas accessible hors production : le mock simulera alors la resource
- Nous faisons appel à un traitement qui a déjà été testé et dont le temps d'exécution est long : dans la mesure où le traitement a déjà été testé, inutile de re-tester son fonctionnement, nous le simulons donc.
- Nous voulons simuler un comportement difficilement reproductible : par exemple une erreur sur le réseau. Dans ce cas, nous ne pouvons que la simuler
- Nous voulons utiliser un composant qui n'a pas encore été développé

====
Globalement, l'utilisation de mock peut être faite à chaque fois 

que nous faisons appel à une autre classe que celle que laquelle nous testons. 

Il convient cependant de ne pas multiplier les mock 

afin de ne pas complexifier le test : **écrire un mock prend du temps**.

====
## Les outils

A l'Insee, on trouve souvent *Mockito* mais aussi *PowerMock*

http://static.javadoc.io/org.mockito/mockito-core/2.23.0/org/mockito/Mockito.html

Mais il en existe d'autres :
- JMock
- EasyMock
- jMockit (Google)
- RMock
- ...

!!!!
## Mockito : installation
Comme d'habitude, on ajoute une dépendance dans le *pom.xml*.

	<dependency>
	    <groupId>org.mockito</groupId>
	    <artifactId>mockito-all</artifactId>
	    <version>1.10.19</version>
	    <scope>test</scope>
	</dependency>

!!!!
## Mockito : un exemple

Pour mocker une classe, il suffit d'appeler *Mockito.mock()* 

en indiquant la classe qu'on souhaite mocker.

	@Test
	public void test1(){
		User user = Mockito.mock(User.class);
		System.out.println(user.getLogin()); // affiche null
		user.setLogin("bob");
		System.out.println(user.getLogin()); // affiche encore null !
		Mockito.when(user.getLogin()).thenReturn("bob");
		System.out.println(user.getLogin()); // affiche "bob"
	}

====
### Attention !

**Un mock ne fait rien par défaut !**

Si vous voulez une classe simulée 

qui, par défaut, fait la même chose que la classe à simuler, 

il faut plutôt utiliser un *spy*.  

https://javapointers.com/tutorial/difference-between-spy-and-mock-in-mockito/
https://www.stevenschwenke.de/spyingWithMockito

!!!!
## Mockito 

Le mieux, c'est de pratiquer !

https://site.mockito.org/

https://www.docdoku.com/blog/2015/03/23/tests-unitaires-avec-mockito/

http://www.vogella.com/tutorials/Mockito/article.html

https://javacodehouse.com/blog/mockito-tutorial/


!!!!
## Les limites des fakes et des mocks

C'est du code pas toujours bien compris.

Ca peut devenir très lourd rapidement si on veut simuler des comportements complexes.

Dans ce cas, est-ce que ça vaut vraiment la peine ?
