package com.crud.serviceimpl;

import com.crud.entity.Admin;
import com.crud.entity.AdminProfile;
import com.crud.repository.AdminProfileRepository;
import com.crud.repository.AdminRepository;
import com.crud.service.AdminProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminProfileServiceImpl implements AdminProfileService {

    @Autowired
    private AdminProfileRepository adminProfileRepository;

    @Autowired
    private AdminRepository adminRepository;

    // Create Admin Profile with linked Admin ID
    @Override
    public AdminProfile createProfileWithAdminId(Long adminId, AdminProfile adminProfile) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found with ID: " + adminId));

        // Prevent duplicate profile
        if (admin.getProfile() != null) {
            throw new RuntimeException("Admin profile already exists for Admin ID: " + adminId);
        }

        adminProfile.setAdmin(admin);
        admin.setProfile(adminProfile);
        return adminProfileRepository.save(adminProfile);
    }

    //  Get all Admin Profiles (for Super Admin)
    @Override
    public List<AdminProfile> getAllAdminProfiles() {
        return adminProfileRepository.findAll();
    }

    //  Get Profile by Admin ID
    @Override
    public AdminProfile getProfileByAdminId(Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found with ID: " + adminId));

        if (admin.getProfile() == null) {
            throw new RuntimeException("Profile not found for Admin ID: " + adminId);
        }

        return admin.getProfile();
    }

    //  Update Admin Profile
    @Override
    public AdminProfile updateAdminProfile(Long id, AdminProfile updatedProfile) {
        AdminProfile existingProfile = adminProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AdminProfile not found with ID: " + id));

        existingProfile.setName(updatedProfile.getName());
        existingProfile.setEmail(updatedProfile.getEmail());
        existingProfile.setPassword(updatedProfile.getPassword());
        existingProfile.setPhoneNumber(updatedProfile.getPhoneNumber());
        existingProfile.setDateOfBirth(updatedProfile.getDateOfBirth());
        existingProfile.setCompanyName(updatedProfile.getCompanyName());
        existingProfile.setCompanyType(updatedProfile.getCompanyType());
        existingProfile.setGstNumber(updatedProfile.getGstNumber());
        existingProfile.setPanNumber(updatedProfile.getPanNumber());
        existingProfile.setHeadOfficeAddress(updatedProfile.getHeadOfficeAddress());
        existingProfile.setCity(updatedProfile.getCity());
        existingProfile.setState(updatedProfile.getState());
        existingProfile.setCountry(updatedProfile.getCountry());
        existingProfile.setPinCode(updatedProfile.getPinCode());
        existingProfile.setCorrespondenceAddress(updatedProfile.getCorrespondenceAddress());
        existingProfile.setPermanentAddress(updatedProfile.getPermanentAddress());

        // Update linked Admin basic info too
        if (existingProfile.getAdmin() != null) {
            Admin admin = existingProfile.getAdmin();
            admin.setUsername(existingProfile.getName());
            admin.setEmail(existingProfile.getEmail());
            adminRepository.save(admin);
        }

        return adminProfileRepository.save(existingProfile);
    }

    //  Delete Admin Profile
    @Override
    public void deleteAdminProfile(Long id) {
        AdminProfile profile = adminProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AdminProfile not found with ID: " + id));

        // Unlink profile from Admin
        Admin admin = profile.getAdmin();
        if (admin != null) {
            admin.setProfile(null);
            adminRepository.save(admin);
        }

        adminProfileRepository.deleteById(id);
    }
}