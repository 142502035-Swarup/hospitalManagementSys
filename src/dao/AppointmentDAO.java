package dao;

import db.DBConnection;
import entity.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppointmentDAO {

    public void bookAppointment(Appointment appointment) {

        String sql =
                "INSERT INTO appointments(patient_id, doctor_id, appointment_date) " +
                        "VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setDate(3, appointment.getDate());

            ps.executeUpdate();
            System.out.println("Appointment booked successfully");

        } catch (SQLException e) {
            System.out.println("Error while booking appointment");
            e.printStackTrace();
        }
    }
}
