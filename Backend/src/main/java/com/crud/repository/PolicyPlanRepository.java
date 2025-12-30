package com.crud.repository;

import com.crud.entity.PolicyPlan;
import com.crud.entity.Admin;
import com.crud.entity.UserPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyPlanRepository extends JpaRepository<PolicyPlan, Long> {
    List<PolicyPlan> findByAdmin(Admin admin);


}
