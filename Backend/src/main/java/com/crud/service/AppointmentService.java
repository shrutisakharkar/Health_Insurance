package com.crud.service;

import com.crud.dto.AppointmentRequest;
import com.crud.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment bookAppointment(AppointmentRequest request);

    List<Appointment> getAppointmentsByDoctorId(Long doctorId);

    List<Appointment> getAppointmentsByUserProfileId(Long userProfileId);

    List<Appointment> getAllAppointments();
}
