package com.crud.serviceimpl;

import com.crud.dto.DoctorRequestDTO;
import com.crud.entity.Doctor;
import com.crud.entity.Hospital;
import com.crud.repository.AppointmentRepository;
import com.crud.repository.DoctorRepository;
import com.crud.repository.HospitalRepository;
import com.crud.service.DoctorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    //  Self / Independent Doctors
    @Override
    public Doctor saveSelfDoctor(Doctor doctor) {
        doctor.setHospital(null); // independent doctor
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateSelfDoctor(Long doctorId, Doctor updatedDoctor) {
        Optional<Doctor> existingDoctorOpt = doctorRepository.findById(doctorId);
        if (existingDoctorOpt.isPresent()) {
            Doctor existingDoctor = existingDoctorOpt.get();
            existingDoctor.setDoctorName(updatedDoctor.getDoctorName());
            existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
            existingDoctor.setStatus(updatedDoctor.getStatus());
            existingDoctor.setAvailableTime(updatedDoctor.getAvailableTime());
            existingDoctor.setEmail(updatedDoctor.getEmail());
            existingDoctor.setHospital(null); // ensure independent
            return doctorRepository.save(existingDoctor);
        }
        return null;
    }

    @Override
    public List<Doctor> getSelfDoctors() {
        return doctorRepository.findByHospitalIsNull();
    }
    //  Doctors linked to a Hospital
    @Override
    public Doctor createDoctorWithHospital(Long hospitalId, Doctor doctor) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new RuntimeException("Hospital not found"));
        doctor.setHospital(hospital);
        return doctorRepository.save(doctor);
    }
    @Override
    public Doctor updateDoctorWithHospital(Long hospitalId, Long doctorId, Doctor updatedDoctor) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new RuntimeException("Hospital not found"));

        Optional<Doctor> existingDoctorOpt = doctorRepository.findById(doctorId);
        if (existingDoctorOpt.isPresent()) {
            Doctor existingDoctor = existingDoctorOpt.get();
            existingDoctor.setDoctorName(updatedDoctor.getDoctorName());
            existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
            existingDoctor.setStatus(updatedDoctor.getStatus());
            existingDoctor.setAvailableTime(updatedDoctor.getAvailableTime());
            existingDoctor.setEmail(updatedDoctor.getEmail());
            existingDoctor.setHospital(hospital);
            return doctorRepository.save(existingDoctor);
        }
        return null;
    }

    //  DTO-based save
    @Override
    public Doctor saveDoctor(DoctorRequestDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setDoctorName(dto.getDoctorName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setStatus(dto.getStatus());
        doctor.setAvailableTime(dto.getAvailableTime());
        doctor.setEmail(dto.getEmail());

        if (dto.getHospitalId() != null) {
            Hospital hospital = hospitalRepository.findById(dto.getHospitalId())
                    .orElseThrow(() -> new RuntimeException("Hospital not found"));
            doctor.setHospital(hospital);
        } else {
            doctor.setHospital(null); // independent doctor
        }
        return doctorRepository.save(doctor);
    }

    // Common methods
    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Doctor> getDoctorsByHospital(Long hospitalId) {
        return doctorRepository.findByHospitalIdAndStatus(hospitalId, "ACTIVE");
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        appointmentRepository.deleteAllByDoctor(doctor);
        doctorRepository.delete(doctor);
    }
}
