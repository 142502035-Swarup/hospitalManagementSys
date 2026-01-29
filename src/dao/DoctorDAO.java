package dao;

import db.DBConnection;
import entity.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorDAO {

    public void addDoctor(Doctor doctor) {

        String sql = "INSERT INTO doctors(name, specialization) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.executeUpdate();

            System.out.println("Doctor added successfully");

        } catch (SQLException e) {
            System.out.println("Error while adding doctor");
            e.printStackTrace();
        }
    }

    public void viewDoctors() {

        String sql = "SELECT * FROM doctors";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("specialization")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error while fetching doctors");
            e.printStackTrace();
        }
    }
}
