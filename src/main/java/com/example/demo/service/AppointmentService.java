package com.example.demo.service;

import com.example.demo.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    private List<Appointment> appointments = new ArrayList<>();
    private long nextId = 1;

    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public Appointment createAppointment(Appointment appointment) {
        appointment.setId(nextId++);
        appointments.add(appointment);
        return appointment;
    }

    // Other service methods for updating and deleting appointments
}