Exercice 3 Bis :

On décide désormais de créer et tester une méthode qui filtre les voitures polluantes d'un conducteur
 et à l'issue de l'avertir par mail du nombre de voitures non-polluantes dont il dispose.
 
 On a ajouté un champ "mail" dans la classe conducteur.
 
 Il s'agit donc de tester la méthode filtrerModelePolluantEtAvertirConducteur de la classe 
 ConducteurServices (cette méthode est déjà écrite).
 
 La méthode fait appel à l'interface IMessagerieService dont la responsabilité est de gérer le lien avec le 
 serveur mail externe (envoyer un mail au conducteur pour l'informer du nombre de voitures non-polluantes qu'il
 possède).
 
 Nous sommes dans un environnement de test, nous ne souhaitons donc pas envoyer réellement de requête à un serveur
 mail.
 
 Vous devez compléter la classe de test ConducteurServicesMessagerieTest en créant un Mock de l'interface IMessagerieService.
 
 Ce Mock tâchera de reproduire le comportement de la méthode avertirConducteur de IMessagerieService 
 mais en "court-circuitant" l'envoi de mail.
 
 En cas d'appel au serveur de mail externe en environnement de test,
  une exception ServeurMailConnexionException est levée.

 
 