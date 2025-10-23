package fr.insee.exemple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import fr.insee.exemple.model.Carburant;
import fr.insee.exemple.model.ModeleVoiture;

public class ModeleVoitureDao {

	public void createTableIfNotExists(Connection c) throws SQLException {
		try (Statement s = c.createStatement()) {
			s.executeUpdate("CREATE TABLE IF NOT EXISTS modele_voiture (id SERIAL PRIMARY KEY, nom_constructeur VARCHAR(255), nom_modele VARCHAR(255), carburant VARCHAR(50), annee_construction DATE)");
		}
	}

	public long insert(ModeleVoiture mv, Connection c) throws SQLException {
		String sql = "INSERT INTO modele_voiture (nom_constructeur, nom_modele, carburant, annee_construction) VALUES (?, ?, ?, ?)";
		try (PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, mv.getNomConstructeur());
			ps.setString(2, mv.getNomModele());
			ps.setString(3, mv.getCarburant() == null ? null : mv.getCarburant().name());
			ps.setDate(4, mv.getAnneeConstruction() == null ? null : Date.valueOf(mv.getAnneeConstruction()));
			ps.executeUpdate();
			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) return rs.getLong(1);
			}
		}
		return -1L;
	}

	public ModeleVoiture findById(long id, Connection c) throws SQLException {
		String sql = "SELECT nom_constructeur, nom_modele, carburant, annee_construction FROM modele_voiture WHERE id = ?";
		try (PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					String nomConstructeur = rs.getString(1);
					String nomModele = rs.getString(2);
					String carburant = rs.getString(3);
					Date annee = rs.getDate(4);
					ModeleVoiture mv = new ModeleVoiture(nomConstructeur, nomModele, carburant == null ? null : Carburant.valueOf(carburant), annee == null ? null : annee.toLocalDate());
					return mv;
				}
			}
		}
		return null;
	}

}