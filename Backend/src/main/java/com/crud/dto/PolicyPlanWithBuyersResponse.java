package com.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyPlanWithBuyersResponse {

    
    private Long id;
    private String policyName;
    private String policyType;
    private Double coverage;
    private Double premium;
    private int durationInYears;
    private List<UserDetailsResponse> buyers;
}
