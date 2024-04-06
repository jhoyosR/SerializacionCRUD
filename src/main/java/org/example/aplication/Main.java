package org.example.aplication;

import org.example.aplication.service.AppointmentService;
import org.example.aplication.service.AppointmentServiceImpl;
import org.example.aplication.service.PatientService;
import org.example.aplication.service.PatientServiceImpl;
import org.example.domain.Appointment;
import org.example.domain.Patient;
import org.example.infraestructure.repository.AppointmentRepositoryImpl;
import org.example.infraestructure.repository.PatientRepositoryImpl;
import org.example.interfaces.AppointmentRepository;
import org.example.interfaces.PatientRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PatientService patientService;
    private static final AppointmentService appointmentService;

    static {
        PatientRepository patientRepository = new PatientRepositoryImpl();
        patientService = new PatientServiceImpl(patientRepository);

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
            System.out.println("6. Display Appointments Assigned");
            System.out.println("7. Display Appointments Registered For A Specific Patient");
            System.out.println("0. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    updatePatientData();
                    break;
                case 3:
                    registerAppointmentForPatient();
                    break;
                case 4:
                    deleteAppointment();
                    break;
                case 5:
                    displayPatients();
                    break;
                case 6:
                    displayAppointments();
                    break;
                case 7:

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
        scanner.nextLine();
        System.out.println("Enter the Patient's gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter the Patient's address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the Patient's Phone Number: ");
        String phoneNumber = scanner.next();

        List<Patient> patients = patientService.findAll();
        Patient patient = new Patient(patients.size(), name, lastName, age, gender, address, phoneNumber);

        try {
            patientService.save(patient);
            System.out.println("Patient successfully registered");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updatePatientData(){
        System.out.println("Enter the Patient's id to update");
        int id = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientService.findById(id);
        if (patient == null) {
            System.out.println("Couldn't find a Patient with that id");
            return;
        }

        System.out.println("Enter the new name for the client (leave blank so as not to change): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            patient.setName(name);
        }

        System.out.println("Enter the new last name for the client (leave blank so as not to change): ");
        String lastName = scanner.nextLine();
        if (!lastName.isEmpty()) {
            patient.setName(lastName);
        }

        System.out.println("Enter the new age for the client (0 to not change): ");
        int age = scanner.nextInt();
        scanner.nextLine();
        if (age > 0) {
            patient.setAge(age);
        }

        System.out.println("Enter the new gender for the client (leave blank so as not to change): ");
        String gender = scanner.nextLine();
        if (!gender.isEmpty()) {
            patient.setGender(gender);
        }

        System.out.println("Enter the new address for the client (leave blank so as not to change): ");
        String address = scanner.nextLine();
        if (!address.isEmpty()) {
            patient.setAddress(address);
        }

        System.out.println("Enter the new phone number for the client (leave blank so as not to change): ");
        String phoneNumber = scanner.nextLine();
        if (!phoneNumber.isEmpty()) {
            patient.setPhoneNumber(phoneNumber);
        }

        try {
            patientService.update(patient);
            System.out.println("Patient successfully updated");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registerAppointmentForPatient(){
        System.out.println("Enter the Patient's id you would like to schedule an Appointment ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the date for the Patient's appointment: ");
        String date = scanner.nextLine();
        System.out.println("Enter the hour for the Patient's appointment: ");
        String hour = scanner.nextLine();
        System.out.println("Enter the reason for the Patient's appointment: ");
        String reason = scanner.nextLine();

        List<Appointment> appointments = appointmentService.findAll();

        Patient patient = patientService.findById(id);

        Appointment appointment = new Appointment(appointments.size(), date, hour, reason, patient);

        try {
            appointmentService.save(appointment);
            System.out.println("Appointment successfully registered for " + patient);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteAppointment(){
        System.out.println("Enter the Appointment's id you would like to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Appointment appointment = appointmentService.findById(id);
        if (appointment == null) {
            System.out.println("Appointment not found for id number: " + id);
            return;
        }

        appointmentService.delete(id);
        System.out.println("Appointment successfully deleted");
    }

    private static void displayPatients() {
        List<Patient> patients = patientService.findAll();
        if (patients.isEmpty()) {
            System.out.println("No Patients Registered");
        } else {
            System.out.println("Patients Registered: ");
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    private static void displayAppointments() {
        List<Appointment> appointments = appointmentService.findAll();
        if (appointments.isEmpty()) {
            System.out.println("No Appointments Assigned");
        } else {
            System.out.println("Appointments Assigned: ");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }
}

