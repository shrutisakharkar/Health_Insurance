package com.crud.repository;

import com.crud.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    // 1 Find doctors by Hospital city and status
    List<Doctor> findByHospitalCityAndStatus(String city, String status);

    //  Find all independent/self doctors (hospital is null)
    List<Doctor> findByHospitalIsNull();

    // Optional: Find doctors under a hospital by status
    List<Doctor> findByHospitalIdAndStatus(Long hospitalId, String status);
}
