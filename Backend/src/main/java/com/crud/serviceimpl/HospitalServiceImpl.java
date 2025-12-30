package com.crud.serviceimpl;

import com.crud.entity.Hospital;
import com.crud.repository.HospitalRepository;
import com.crud.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Hospital saveHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital getHospitalById(Long id) {
        return hospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital not found with id: " + id));
    }

    @Override
    public Hospital updateHospital(Long id, Hospital updatedHospital) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital not found with id: " + id));

        hospital.setHospitalName(updatedHospital.getHospitalName());
        hospital.setCity(updatedHospital.getCity());
        hospital.setSpeciality(updatedHospital.getSpeciality());
        hospital.setContactNumber(updatedHospital.getContactNumber());

        return hospitalRepository.save(hospital);
    }

    @Override
    public void deleteHospital(Long id) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital not found with id: " + id));
        hospitalRepository.delete(hospital);
    }
}
