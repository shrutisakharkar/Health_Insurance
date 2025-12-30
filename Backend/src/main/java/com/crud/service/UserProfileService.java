package com.crud.service;

import com.crud.entity.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserProfileService {
    UserProfile createUserProfile(UserProfile userProfile);

    Optional<UserProfile> getUserProfileById(Long id);

    List<UserProfile> getAllUserProfiles();

    UserProfile updateUserProfile(Long id, UserProfile updatedProfile);

    void deleteUserProfile(Long id);

    UserProfile getProfileByUserId(Long userId);

    UserProfile createProfileWithUserId(Long userId, UserProfile profile);


}
