package org.example.interfaces;

import org.example.domain.Appointment;
import org.example.domain.Patient;

import java.util.List;

public interface AppointmentRepository {
    List<Appointment> findAll();
    Appointment findById(int id);
    void save(Appointment appointment);
    void update(Appointment appointment);
    void delete(int id);
}
