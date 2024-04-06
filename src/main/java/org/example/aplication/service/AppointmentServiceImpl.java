package org.example.aplication.service;

import org.example.domain.Appointment;
import org.example.interfaces.AppointmentRepository;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment findById(int id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void update(Appointment appointment) {
        appointmentRepository.update(appointment);
    }

    @Override
    public void delete(int id) {
        appointmentRepository.delete(id);
    }
}
