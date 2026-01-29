import dao.*;
import entity.*;

import java.sql.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        while (true) {
            System.out.println("""
                \n--- Hospital Management System ---
                1. Add Patient
                2. View Patients
                3. Add Doctor
                4. View Doctors
                5. Book Appointment
                6. Exit
                """);

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    System.out.print("Gender: ");
                    String gender = sc.next();
                    patientDAO.addPatient(new Patient(name, age, gender));
                }
                case 2 -> patientDAO.viewPatients();
                case 3 -> {
                    System.out.print("Doctor Name: ");
                    String name = sc.next();
                    System.out.print("Specialization: ");
                    String spec = sc.next();
                    doctorDAO.addDoctor(new Doctor(name, spec));
                }
                case 4 -> doctorDAO.viewDoctors();
                case 5 -> {
                    System.out.print("Patient ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Doctor ID: ");
                    int did = sc.nextInt();
                    System.out.print("Date (YYYY-MM-DD): ");
                    Date date = Date.valueOf(sc.next());
                    appointmentDAO.bookAppointment(
                            new Appointment(pid, did, date));
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
            }
        }
    }
}
