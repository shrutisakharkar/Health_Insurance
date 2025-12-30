package com.crud.dto;

import com.crud.entity.PolicyPlan;
import lombok.Data;

@Data
public class PolicyPlanResponse {
    private Long id;
    private String policyName;
    private String policyType;
    private Double coverage;
    private Double premium;
    private Integer durationInYears;
    private String imageUrl;

    public PolicyPlanResponse(PolicyPlan plan) {
        this.id = plan.getId();
        this.policyName = plan.getPolicyName();
        this.policyType = plan.getPolicyType();
        this.coverage = plan.getCoverage();
        this.premium = plan.getPremium();
        this.durationInYears = plan.getDurationInYears();
        this.imageUrl = plan.getImageUrl();
    }
}
