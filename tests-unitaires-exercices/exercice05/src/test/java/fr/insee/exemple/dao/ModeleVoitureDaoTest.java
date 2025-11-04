package fr.insee.exemple.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

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
        connection = DriverManager.getConnection(url, user, pass);
    }

    @AfterAll
    public static void stopContainer() throws Exception {
        if (connection != null && !connection.isClosed())
            connection.close();
        postgres.stop();
    }

    @Test
    public void testInsertAndFindById() throws Exception {
        ModeleVoitureDao dao = new ModeleVoitureDao();
        dao.createTableIfNotExists(connection);

        ModeleVoiture mv = new ModeleVoiture("Toyota", "Corolla", null, null);

        long id = dao.insert(mv, connection);

        ModeleVoiture retrievedMv = dao.findById(id, connection);

        boolean condition = true;

        assert retrievedMv != null;
        assert "Toyota".equals(retrievedMv.getNomConstructeur());

    }

}
