package com.crud.service;

import com.crud.entity.Hospital;
import java.util.List;

public interface HospitalService {

    Hospital saveHospital(Hospital hospital);

    List<Hospital> getAllHospitals();

    Hospital getHospitalById(Long id);

    Hospital updateHospital(Long id, Hospital updatedHospital);

    void deleteHospital(Long id);
}
