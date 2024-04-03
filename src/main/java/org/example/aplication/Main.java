package org.example.aplication;

import org.example.aplication.service.AppointmentService;
import org.example.aplication.service.AppointmentServiceImpl;
import org.example.domain.Patient;
import org.example.infraestructure.repository.AppointmentRepositoryImpl;
import org.example.interfaces.AppointmentRepository;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AppointmentService appointmentService;

    static {
        AppointmentRepository appointmentRepository = new AppointmentRepositoryImpl();
        appointmentService = new AppointmentServiceImpl(appointmentRepository);
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Register Patient");
            System.out.println("2. Update Patient Data");
            System.out.println("3. Register New Appointment For Existing Patient");
            System.out.println("4. Delete Appointment Assigned");
            System.out.println("5. Display Patients Registered");
            System.out.println("6. Display Appointments Registered For A Specific Patient");
            System.out.println("0. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    private static void registerPatient(){
        System.out.println("Enter the Patient's name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the Patient's last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the Patient's age: ");
        int age = scanner.nextInt();
        System.out.println("Enter the Patient's gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter the Patient's address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the Patient's Phone Number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();

        Patient patient = new Patient(name, lastName, age, gender, address, phoneNumber);
        //Dónde se supone que los meto para guardarlos y luego agregarlos a las citas, no tiene sentido
    }
}
