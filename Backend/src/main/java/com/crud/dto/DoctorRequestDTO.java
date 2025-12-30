package com.crud.dto;

public class DoctorRequestDTO {

    private String doctorName;
    private String specialization;
    private String status;
    private String availableTime;
    private String email;
    private Long hospitalId; //  new field for hospital mapping

    // Getters and Setters
    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAvailableTime() { return availableTime; }
    public void setAvailableTime(String availableTime) { this.availableTime = availableTime; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getHospitalId() { return hospitalId; }
    public void setHospitalId(Long hospitalId) { this.hospitalId = hospitalId; }
}
