package com.crud.repository;

import com.crud.entity.UserPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserPolicyRepository extends JpaRepository<UserPolicy, Long> {

    Optional<UserPolicy> findByUserId(Long userId);
    List<UserPolicy> findAllByUserId(Long userId);

    List<UserPolicy> findByPolicyPlanId(Long policyPlanId);

    List<UserPolicy> findByPolicyPlan_Admin_IdAndPolicyStatus(Long adminId, String policyStatus);










}
