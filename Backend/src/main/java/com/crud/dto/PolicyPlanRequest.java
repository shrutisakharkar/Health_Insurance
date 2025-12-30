package com.crud.dto;

import lombok.Data;

@Data
public class PolicyPlanRequest {

    private String policyName;
    private String policyType;
    private Double coverage;
    private Double premium;
    private Integer durationInYears;


}
