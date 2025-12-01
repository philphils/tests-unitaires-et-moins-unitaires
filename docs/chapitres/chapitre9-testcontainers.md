# TestContainer

--
# Qu'est-ce que TestContainer ?

* __Bibliothèque Java qui permet d'exécuter des tests avec des conteneurs Docker__ 
* __Supporte de nombreux systèmes : PostgreSQL, ElasticSearch, MySQL, MongoDB... etc.__
* __Idéal pour reproduire son environnement de production en tests d'intégration__


--
# Qu'est-ce que TestContainer ?

* __Avantages :__
    * __Environnement de test isolé et jetable__
    * __Très proche de la production__
    * __Pas de configuration nécessaire sur le poste de dev__
    * __Fonctionne parfaitement en CI/CD... normalement !__
    * __... Mais pas encore à l'Insee 😭__


--
# Qu'est-ce que TestContainer ?

* __Inconvénients :__
    * __Nécessite un environnement Docker sur la machine__
    * __Sur les postes Insee possible avec Podman mais pas trivial : https://sndi-nantes.gitlab-pages.insee.fr/portail-des-connaissances/service-production/outils-prod/podman/__
    * __Pas d'environnement Docker pour l'instant en CI/CD... (désactivation des tests en CI/CD ou contournement avec les Gitlab Services)__
--
# Comment ça marche ?

* __TestContainer démarre un conteneur Docker au début du test__
* __Le conteneur est automatiquement détruit à la fin du test__
* __Les ports sont attribués dynamiquement__
* __Possibilité de se connecter en debug à la base de données__

--
# Installation

* __Ajouter les dépendances Maven :__
```xml
<!-- TestContainer -->
<dependency>
    <groupId>org.testcontainer</groupId>
    <artifactId>testcontainer</artifactId>
    <version>1.19.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.testcontainer</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>1.19.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.testcontainer</groupId>
    <artifactId>postgresql</artifactId>
    <version>1.19.0</version>
    <scope>test</scope>
</dependency>
<!-- Driver JDBC -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.6.0</version>
    <scope>test</scope>
</dependency>
```

--
# Exemple : Test d'une DAO

* __La classe de test :__
```java
@TestContainer
public class ModeleVoitureDaoTest {

    @Container
    public static PostgreSQLContainer<?> postgres 
            = new PostgreSQLContainer<>("postgres:15.3")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    private static Connection connection;

    @BeforeAll
    public static void startContainer() throws Exception {
        postgres.start();
        String url = postgres.getJdbcUrl();
        String user = postgres.getUsername();
        String pass = postgres.getPassword();
        connection = DriverManager.getConnection(url, user, pass);
    }

    @AfterAll
    public static void stopContainer() throws Exception {
        if (connection != null && !connection.isClosed()) connection.close();
        postgres.stop();
    }

    @Test
    public void testInsertAndFind() throws Exception {
        ModeleVoitureDao dao = new ModeleVoitureDao();
        dao.createTableIfNotExists(connection);

        ModeleVoiture mv = new ModeleVoiture("Renault", "Clio", 
            Carburant.ESSENCE, LocalDate.of(2022, 1, 1));
        long id = dao.insert(mv, connection);
        
        ModeleVoiture loaded = dao.findById(id, connection);
        assertThat(loaded).isEqualTo(mv);
    }
}
```

--
# Connexion en debug avec DBeaver

1. __Ajouter l'affichage des informations de connexion :__
```java
@BeforeAll
public static void startContainer() throws Exception {
    //...
    System.out.println("⭐ Base de données de test disponible sur : " + url);
    System.out.println("⭐ Utilisateur : " + user);
    System.out.println("⭐ Mot de passe : " + pass);
    //...
}
```

2. __Placer un point d'arrêt dans le test__
3. __Lancer en debug__
4. __Créer une connexion dans DBeaver avec les informations affichées__

--
# Exercice 5 : 
# Utiliser Testcontainer

![](./img/diapo_tests_unitaires_18.png)

<span style="color:#3465a4"> __\(Instructions contenues dans le readme\)__ 

--
# Avantages de cette approche

* __Tests plus fiables car proche de la production__
* __Pas de mock des requêtes SQL__
* __Teste le vrai comportement de la base__
* __Environnement propre à chaque exécution__
* __Facilité de debug avec les outils standards__


--

![](./img/diapo_tests_unitaires_28.png)

 __Merci de votre attention__ 

 __Avez\-vous des questions ?__ 

Prénom Nom :   <span style="color:#ff6633">__Philippe SABAA__</span>

Très inspiré du diapo de __Michael Genet__