package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class HospitalManagementSystem {
    private static final String url = "jdbc:mysql://127.0.0.1:3307/Hospital_db";
    private static final String username = "admin";
    private static final String password = "admin";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Patient patient = new Patient(connection, scanner);
            Doctor doctor = new Doctor(connection);
            while (true) {
                System.out.println("HOSPITAL MANAGMENT SYSTEM");
                System.out.println("1. ADD PATIENT");
                System.out.println("2. VIEW PATIENT");
                System.out.println("3. VIEW DOCTOR");
                System.out.println("4. BOOK APPOINTMENT");
                System.out.println("5. EXIT");
                System.out.println("ENTER YOUR CHOICE");
                int Choice = scanner.nextInt();

                switch (Choice) {
                    case 1:
                        // ADD PATEENT
                        patient.addPatient();
                        System.out.println();
                        break;
                    case 2:
                        // VIEW PATEENT
                        patient.viewPatient();
                        System.out.println();
                        break;
                    case 3:
                        // VIEW DOCTOR
                        doctor.viewDoctors();
                        System.out.println();
                        break;
                    case 4:
                        // BOOK APPOINTMENT
                        bookAppointment(patient, doctor, connection, scanner);
                        System.out.println();
                    case 5:
                        return;

                    default:
                        System.out.println("ENTER VAILD CHOICE");

                }

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void bookAppointment(Patient patient, Doctor doctor, Connection connection, Scanner scanner) {
        System.out.println("Enter patient id ");
        int patientid = scanner.nextInt();
        System.out.println("Enter Doctor ID: ");
        int doctorid = scanner.nextInt();
        System.out.println("Enter the appointment Date (yyyy-mm-dd)");
        String appointmentDate = scanner.next();
        if (patient.getPatientByID(patientid) && doctor.getDoctorByID(doctorid)) {
            if (checkDoctorAvailable(doctorid, appointmentDate, connection)) {
                String appointmetQuery = "INSERT INTO appointments(patient_id,doctor_id,appointment_date) VALUES(?,?,?)";
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(appointmetQuery);
                    preparedStatement.setInt(1, patientid);
                    preparedStatement.setInt(2, doctorid);
                    preparedStatement.setString(3, appointmentDate);
                    int checkupdate = preparedStatement.executeUpdate();
                    if (checkupdate > 0) {
                        System.out.println("Appointmet Booked");
                    } else {
                        System.out.println("Failed to book");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Doctor Not avaiable");
            }
        } else {
            System.out.println("Either doctor or patient doesn't Exist!!");
        }

    }

    public static boolean checkDoctorAvailable(int doctorid, String appointmentDate, Connection connection) {
        String query = "SELECT COUNT(*) FROM appointments where doctor_id=? AND appointment_date =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, doctorid);
            preparedStatement.setString(2, appointmentDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count == 0) {
                    return true;
                } else {
                    return false;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return false;
    }

}
