package com.crud.service;

import com.crud.dto.DoctorRequestDTO;
import com.crud.entity.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor createDoctorWithHospital(Long hospitalId, Doctor doctor);
    Doctor saveSelfDoctor(Doctor doctor);

    List<Doctor> getDoctorsByHospital(Long hospitalId);
    List<Doctor> getSelfDoctors();

    Doctor getDoctorById(Long id);

    Doctor updateDoctorWithHospital(Long hospitalId, Long doctorId, Doctor doctor);
    Doctor updateSelfDoctor(Long doctorId, Doctor doctor);

    List<Doctor> getAllDoctors();

    void deleteDoctor(Long id);
    Doctor saveDoctor(DoctorRequestDTO dto);
}
