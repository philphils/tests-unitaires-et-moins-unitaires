package fr.insee.exemple.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import fr.insee.exemple.model.Carburant;
import fr.insee.exemple.model.ModeleVoiture;

@Testcontainers
public class ModeleVoitureDaoTest {

    @Container
    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15.3")
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
        System.out.println("⭐ Base de données de test disponible sur : " + url);
        System.out.println("⭐ Utilisateur : " + user);
        System.out.println("⭐ Mot de passe : " + pass);
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

        ModeleVoiture mv = new ModeleVoiture("Renault", "Clio", Carburant.ESSENCE, LocalDate.of(2022, 1, 1));
        long id = dao.insert(mv, connection);
        assertThat(id).isGreaterThan(0);

        ModeleVoiture loaded = dao.findById(id, connection);
        assertThat(loaded).isEqualTo(mv);
    }
}
