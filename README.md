

# Hospital Management System

This Java project is a console-based Hospital Management System. It utilizes MySQL for database management and provides functionalities for managing patients and doctors, as well as booking appointments.

#### Features

1. **Add Patient**: Allows the addition of new patients to the system.
2. **View Patient**: Retrieves and displays details of patients.
3. **View Doctor**: Retrieves and displays details of doctors.
4. **Book Appointment**: Facilitates the booking of appointments between patients and doctors.

#### Project Structure

- **HospitalManagementSystem.java**: The main class that drives the application. It provides the user interface for interacting with the system and connects to the MySQL database.
- **Patient.java**: Manages patient-related operations such as adding and viewing patient details.
- **Doctor.java**: Manages doctor-related operations such as viewing doctor details and checking doctor availability by ID.

#### Database Schema

The project requires a MySQL database with the following schema:

**Database Name**: `Hospital_db`

**Tables**:
- `patients`
  - `id` (INT) - Primary Key
  - `name` (VARCHAR)
  - `age` (INT)
  - `gender` (VARCHAR)
  - `diagnosis` (VARCHAR)
  
- `doctors`
  - `id` (INT) - Primary Key
  - `name` (VARCHAR)
  - `specialization` (VARCHAR)

#### How to Run

1. Set up the MySQL database using the schema provided above.
2. Update the database connection details in `HospitalManagementSystem.java`:
   ```java
   private static final String url = "jdbc:mysql://127.0.0.1:3307/Hospital_db";
   private static final String username = "admin";
   private static final String password = "admin";
   ```
3. Compile and run the application using your preferred Java IDE or command line.

#### Dependencies

- MySQL JDBC Driver
- Java Development Kit (JDK)

#### Usage

Upon running the application, you will be presented with a menu to perform various operations:
```
HOSPITAL MANAGEMENT SYSTEM
1. ADD PATIENT
2. VIEW PATIENT
3. VIEW DOCTOR
4. BOOK APPOINTMENT
5. EXIT
ENTER YOUR CHOICE:
```
Select the appropriate option and follow the prompts to manage hospital data effectively.

#### Future Enhancements

- Add more comprehensive patient and doctor management features.
- Implement user authentication and authorization.
- Develop a graphical user interface (GUI) for better user interaction.
- Integrate with additional external systems such as pharmacy management and billing systems.

#### Contribution

Contributions are welcome! If you have suggestions for improvements or new features, please open an issue or submit a pull request. Here’s how you can contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Make your changes and commit them (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a pull request.

#### Clone the Repository

To clone this repository, run the following command in your terminal:

git clone https://github.com/kumar-rakshith/Hospital_Management_System.git



#### License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

