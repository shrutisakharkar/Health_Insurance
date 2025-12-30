package com.crud.controller;

import com.crud.entity.AdminProfile;
import com.crud.service.AdminProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin-profiles")
public class AdminProfileController {

    @Autowired
    private AdminProfileService adminProfileService;

    // Super Admin: Get all admin profiles
    @GetMapping("/all")
    public List<AdminProfile> getAllAdminsForSuperAdmin() {
        return adminProfileService.getAllAdminProfiles();
    }

    // Create Admin Profile and link with Admin (by adminId)
    @PostMapping("/save/{adminId}")
    public AdminProfile createAdminProfile(@PathVariable Long adminId, @RequestBody AdminProfile adminProfile) {
        return adminProfileService.createProfileWithAdminId(adminId, adminProfile);
    }

    // Get Admin Profile by Admin ID
    @GetMapping("/by-admin/{adminId}")
    public AdminProfile getProfileByAdminId(@PathVariable Long adminId) {
        return adminProfileService.getProfileByAdminId(adminId);
    }

    // Update Admin Profile
    @PutMapping("/{id}")
    public AdminProfile updateAdminProfile(@PathVariable Long id, @RequestBody AdminProfile updatedProfile) {
        return adminProfileService.updateAdminProfile(id, updatedProfile);
    }

    // Delete Admin Profile
    @DeleteMapping("/{id}")
    public String deleteAdminProfile(@PathVariable Long id) {
        adminProfileService.deleteAdminProfile(id);
        return "Admin profile with ID " + id + " deleted successfully.";
    }
}