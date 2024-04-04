package org.example.infraestructure.repository;

import org.example.domain.Appointment;
import org.example.domain.Patient;
import org.example.interfaces.PatientRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientRepositoryImpl implements PatientRepository {
    private static final String FILE_NAME = "patients.dat";

    @Override
    public List<Patient> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Patient>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
    @Override
    public Patient findById(int id) {
        return findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @Override
    public void save(Patient patient) {
        List<Patient> patients = findAll();
        patients.add(patient);
        saveAll(patients);
    }

    @Override
    public void update(Patient patient) {
        List<Patient> patients = findAll();
        patients = patients.stream()
                .map(p -> p.getId() == patient.getId() ? patient : p)
                .collect(Collectors.toList());
        saveAll(patients);
    }

    @Override
    public void delete(int id) {
        List<Patient> patients = findAll();
        patients = patients.stream()
                .filter(p -> p.getId() != id)
                .collect(Collectors.toList());
        saveAll(patients);
    }

    private void saveAll(List<Patient> patients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(patients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
