package com.crud.serviceimpl;

import com.crud.entity.Admin;
import com.crud.entity.UserPolicy;
import com.crud.enums.Role;
import com.crud.repository.AdminRepository;
import com.crud.service.AdminService;
import com.crud.service.UserPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserPolicyService userPolicyService;

    @Override
    public Admin registerAdmin(Admin admin) {
        Optional<Admin> existing = adminRepository.findByEmail(admin.getEmail());
        if (existing.isPresent()) {
            throw new RuntimeException("Admin with email already exists");
        }
        admin.setRole(Role.ADMIN);
        return adminRepository.save(admin);
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Optional<Admin> findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public List<Admin> getAdminsByRole(Role role) {
        return adminRepository.findByRole(role);
    }


    @Override
    public UserPolicy activatePolicy(Long policyId) {
        UserPolicy policy = userPolicyService.getPolicyById(policyId);
        policy.setPolicyStatus("ACTIVE");
        return userPolicyService.updatePolicy(policyId, policy);
    }

    @Override
    public UserPolicy rejectPolicy(Long policyId) {
        UserPolicy policy = userPolicyService.getPolicyById(policyId);
        policy.setPolicyStatus("REJECTED");
        return userPolicyService.updatePolicy(policyId, policy);
    }

    @Override
    public UserPolicy updateNomineeDetails(Long policyId, String nominee, String nomineeRelation) {
        return userPolicyService.updateNomineeDetails(policyId, nominee, nomineeRelation);
    }

    @Override
    public void expireExpiredPolicies() {
        List<UserPolicy> activePolicies = userPolicyService.getAllPolicies();
        for (UserPolicy policy : activePolicies) {
            if (policy.getEndDate().isBefore(LocalDate.now()) &&
                    "ACTIVE".equalsIgnoreCase(policy.getPolicyStatus())) {
                policy.setPolicyStatus("INACTIVE");
                userPolicyService.updatePolicy(policy.getId(), policy);
            }
        }
    }



}



