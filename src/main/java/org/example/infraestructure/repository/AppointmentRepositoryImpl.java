package org.example.infraestructure.repository;

import org.example.domain.Appointment;
import org.example.interfaces.AppointmentRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentRepositoryImpl implements AppointmentRepository {
    private static final String FILE_NAME = "appointments.dat";

    @Override
    public List<Appointment> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Appointment>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
    @Override
    public Appointment findById(int id) {
        return findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @Override
    public void save(Appointment appointment) {
        List<Appointment> appointments = findAll();
        appointments.add(appointment);
        saveAll(appointments);
    }

    @Override
    public void update(Appointment appointment) {
        List<Appointment> appointments = findAll();
        appointments = appointments.stream()
                .map(p -> p.getId() == appointment.getId() ? appointment : p)
                .collect(Collectors.toList());
        saveAll(appointments);
    }

    @Override
    public void delete(int id) {
        List<Appointment> appointments = findAll();
        appointments = appointments.stream()
                .filter(p -> p.getId() != id)
                .collect(Collectors.toList());
        saveAll(appointments);
    }

    private void saveAll(List<Appointment> appointments) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(appointments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
