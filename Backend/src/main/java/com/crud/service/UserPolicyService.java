package com.crud.service;

import com.crud.dto.PurchaseRequest;
import com.crud.entity.UserPolicy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface UserPolicyService {

    UserPolicy purchasePolicy(PurchaseRequest request);
    UserPolicy getPolicyByUserId(Long userId);
    List<UserPolicy> getAllPoliciesByUserId(Long userId);

    List<UserPolicy> getAllPolicies();

    UserPolicy updatePolicy(Long policyId, UserPolicy updatedPolicy);

    void deletePolicy(Long policyId);

    UserPolicy getPolicyById(Long policyId);

    UserPolicy updateNomineeDetails(Long policyId, String nominee, String nomineeRelation);

    List<UserPolicy> getPendingPoliciesByAdminId(Long adminId);

    List<UserPolicy> getActivePoliciesByAdminId(Long adminId);








}


