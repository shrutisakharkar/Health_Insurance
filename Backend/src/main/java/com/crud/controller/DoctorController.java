package com.crud.controller;

import com.crud.entity.Doctor;
import com.crud.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
//@CrossOrigin("http://localhost:3000")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //  Create doctor under a specific hospital
    @PostMapping("/save/{hospitalId}")
    public Doctor createDoctorUnderHospital(@PathVariable Long hospitalId, @RequestBody Doctor doctor) {
        return doctorService.createDoctorWithHospital(hospitalId, doctor);
    }

    //  Create self/independent doctor
    @PostMapping("/save/self")
    public Doctor createSelfDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveSelfDoctor(doctor);
    }

    //  Get all doctors under a hospital
    @GetMapping("/hospital/{hospitalId}")
    public List<Doctor> getDoctorsByHospital(@PathVariable Long hospitalId) {
        return doctorService.getDoctorsByHospital(hospitalId);
    }

    //  Get all self/independent doctors
    @GetMapping("/self")
    public List<Doctor> getSelfDoctors() {
        return doctorService.getSelfDoctors();
    }

    //  Get doctor by ID (works for both)
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    //  Update doctor under a hospital
    @PutMapping("/update/{hospitalId}/{doctorId}")
    public Doctor updateDoctorUnderHospital(@PathVariable Long hospitalId,
                                            @PathVariable Long doctorId,
                                            @RequestBody Doctor doctor) {
        return doctorService.updateDoctorWithHospital(hospitalId, doctorId, doctor);
    }

    //  Update self doctor
    @PutMapping("/update/self/{doctorId}")
    public Doctor updateSelfDoctor(@PathVariable Long doctorId, @RequestBody Doctor doctor) {
        return doctorService.updateSelfDoctor(doctorId, doctor);
    }

    //   Delete doctor by ID (works for both)
    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "Doctor deleted successfully.";
    }
}
