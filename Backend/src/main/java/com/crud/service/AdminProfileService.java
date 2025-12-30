package com.crud.service;

import com.crud.entity.AdminProfile;
import java.util.List;

public interface AdminProfileService {

    AdminProfile createProfileWithAdminId(Long adminId, AdminProfile adminProfile);

    List<AdminProfile> getAllAdminProfiles();

    AdminProfile getProfileByAdminId(Long adminId);

    AdminProfile updateAdminProfile(Long id, AdminProfile updatedProfile);

    void deleteAdminProfile(Long id);
}
