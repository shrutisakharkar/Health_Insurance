package com.crud.service;

import com.crud.dto.PolicyPlanRequest;
import com.crud.dto.PolicyPlanWithBuyersResponse;
import com.crud.entity.PolicyPlan;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PolicyPlanservice {

    PolicyPlan createPlan(PolicyPlanRequest request, Long adminId);

    PolicyPlan updatePlan(Long planId, PolicyPlanRequest request, Long adminId);

    void deletePlan(Long planId, Long adminId);

    List<PolicyPlan> getPlansByAdmin(Long adminId);

    List<PolicyPlan> getAllPlans();

    PolicyPlan getPlanById(Long planId);

    PolicyPlan save(PolicyPlan plan);

    // New methods for file upload
    PolicyPlan storePolicyWithImage(MultipartFile file, Long adminId, String policyJson) throws Exception;

    PolicyPlan updatePolicyWithImage(Long planId, MultipartFile file, String policyJson, Long adminId) throws Exception;

    PolicyPlanWithBuyersResponse getPolicyPlanWithBuyers(Long planId);
}
