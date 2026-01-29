package dao;

import db.DBConnection;
import entity.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO {

    public void addPatient(Patient patient) {

        String sql = "INSERT INTO patients(name, age, gender) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());

            ps.executeUpdate();
            System.out.println("Patient added successfully");

        } catch (SQLException e) {
            System.out.println("Error while adding patient");
            e.printStackTrace();
        }
    }

    public void viewPatients() {

        String sql = "SELECT * FROM patients";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("gender")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error while fetching patients");
            e.printStackTrace();
        }
    }
}
