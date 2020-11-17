package com.github.faeldn.aep.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.faeldn.aep.factory.FactoryJDBC;
import com.github.faeldn.aep.models.Doctor;

public class RepositoryDocDB implements RepositoryID<Integer, Doctor> {

	@Override
	public List<Doctor> all() {
		List<Doctor> lista = new ArrayList<Doctor>();

		try (Connection conn = FactoryJDBC.criaConn()) {
			String sql = "SELECT * FROM Doctors";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				Doctor d = new Doctor(rs.getInt("crm"), rs.getString("docname"), rs.getString("spec"));

				lista.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Doctor one(Integer crm) {

		try (Connection conn = FactoryJDBC.criaConn()) {
			String sql = "SELECT * FROM Doctors WHERE crm = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, crm);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Doctor d = new Doctor(rs.getInt("crm"), rs.getString("docname"), rs.getString("spec"));

				return d;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Doctor entity) {
		try (Connection conn = FactoryJDBC.criaConn()) {
			String sql = "INSERT INTO Doctors (crm,docname,spec) VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, entity.getCrm());
			ps.setString(2, entity.getDocname());
			ps.setString(3, entity.getSpec());
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
