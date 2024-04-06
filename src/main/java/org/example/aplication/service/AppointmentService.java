package org.example.aplication.service;

import org.example.domain.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> findAll();
    Appointment findById(int id);
    void save(Appointment appointment);
    void update(Appointment appointment);
    void delete(int id);
}
