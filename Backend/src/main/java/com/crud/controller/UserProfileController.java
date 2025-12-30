package com.crud.controller;

import com.crud.entity.UserProfile;
import com.crud.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-profiles")

public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;


    // Super Admin: Get all user profiles
    @GetMapping("/all")
    public List<UserProfile> getAllProfilesForSuperAdmin() {
        return userProfileService.getAllUserProfiles();
    }


    @PostMapping("/save/{userId}")
    public UserProfile createUserProfile(@PathVariable Long userId, @RequestBody UserProfile userProfile) {
        return userProfileService.createProfileWithUserId(userId, userProfile);
    }

    @GetMapping("/by-user/{userId}")
    public UserProfile getByUserId(@PathVariable Long userId) {
        return userProfileService.getProfileByUserId(userId);
    }


    @PutMapping("/{id}")
    public UserProfile updateUserProfile(@PathVariable Long id, @RequestBody UserProfile updatedProfile) {
        return userProfileService.updateUserProfile(id, updatedProfile);
    }

    @DeleteMapping("/{id}")
    public String deleteUserProfile(@PathVariable Long id) {
        userProfileService.deleteUserProfile(id);
        return "User profile with ID " + id + " deleted successfully.";
    }

   /* // Optional: Update by user ID
    @PutMapping("/by-user/{userId}")
    public UserProfile updateByUserId(@PathVariable Long userId, @RequestBody UserProfile updatedProfile) {
        UserProfile existing = userProfileService.getProfileByUserId(userId);
        return userProfileService.updateUserProfile(existing.getId(), updatedProfile);
    }

    //  Optional: Delete by user ID
    @DeleteMapping("/by-user/{userId}")
    public String deleteByUserId(@PathVariable Long userId) {
        UserProfile existing = userProfileService.getProfileByUserId(userId);
        userProfileService.deleteUserProfile(existing.getId());
        return "Deleted profile of user ID: " + userId;
    }*/
}
