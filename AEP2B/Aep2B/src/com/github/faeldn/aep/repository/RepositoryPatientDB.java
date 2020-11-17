package com.github.faeldn.aep.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.faeldn.aep.factory.FactoryJDBC;
import com.github.faeldn.aep.models.Patient;

public class RepositoryPatientDB implements RepositoryI<Long, Patient> {

	@Override
	public List<Patient> all() {
		List<Patient> lista = new ArrayList<Patient>();

		try (Connection conn = FactoryJDBC.criaConn()) {
			String sql = "SELECT * FROM Patients";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				Patient p = new Patient(rs.getString("cpf"), rs.getString("name"), rs.getLong("cel"), rs.getString("birthdate"),
						rs.getString("adress"), rs.getString("cep"), rs.getString("city"), rs.getString("state"),
						rs.getString("suscode"), rs.getString("namemom"), rs.getString("infcompl"));

				lista.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Patient one(Long cpf) {

		try (Connection conn = FactoryJDBC.criaConn()) {
			String sql = "SELECT * FROM Patients WHERE cpf = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, cpf);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Patient p = new Patient(rs.getString("cpf"), rs.getString("name"), rs.getLong("cel"), rs.getString("birthdate"),
						rs.getString("adress"), rs.getString("cep"), rs.getString("city"), rs.getString("state"),
						rs.getString("suscode"), rs.getString("namemom"), rs.getString("infcompl"));

				return p;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Patient entity) {
		try (Connection conn = FactoryJDBC.criaConn()){
			String sql = "INSERT INTO Patients (cpf,name,cel,birthdate,adress,cep,city,state,suscode,namemom,infcompl) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, entity.getCpf());
			ps.setString(2, entity.getName());
			ps.setLong(3, entity.getCel());
			ps.setString(4, entity.getBirthdate());
			ps.setString(5, entity.getAdress());
			ps.setString(6, entity.getCep());
			ps.setString(7, entity.getCity());
			ps.setString(8, entity.getState());
			ps.setString(9, entity.getSuscode());
			ps.setString(10, entity.getNamemom());
			ps.setString(11, entity.getInfcompl());
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Long cpf) {
		try (Connection conn = FactoryJDBC.criaConn()) {
			String sql = "DELETE FROM Patients WHERE cpf = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, cpf);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
