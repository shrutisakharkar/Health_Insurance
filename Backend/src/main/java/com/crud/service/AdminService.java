package com.crud.service;

import com.crud.entity.Admin;
import com.crud.entity.UserPolicy;
import com.crud.enums.Role;
import java.util.List;
import java.util.Optional;

public interface AdminService {

    Admin registerAdmin(Admin admin);
    Admin save(Admin admin);
    Optional<Admin> findByEmail(String email);
    Optional<Admin> findById(Long id);
    List<Admin> getAllAdmins();
    void deleteById(Long id);

    List<Admin> getAdminsByRole(Role role);


    UserPolicy activatePolicy(Long policyId);
    UserPolicy rejectPolicy(Long policyId);
    UserPolicy updateNomineeDetails(Long policyId, String nominee, String nomineeRelation);
    void expireExpiredPolicies();



}
