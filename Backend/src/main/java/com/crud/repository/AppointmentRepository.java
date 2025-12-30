package com.crud.repository;

import com.crud.entity.Appointment;
import com.crud.entity.Doctor;
import com.crud.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByDoctor(Doctor doctor);

    List<Appointment> findByUserProfile(UserProfile userProfile);

    boolean existsByDoctorAndAppointmentDate(Doctor doctor, LocalDate appointmentDate);

    void deleteAllByDoctor(Doctor doctor);

    List<Appointment> findByUserProfileAndAppointmentDate(UserProfile userProfile, LocalDate appointmentDate);
}
