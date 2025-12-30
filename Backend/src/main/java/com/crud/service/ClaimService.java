package com.crud.service;

import com.crud.entity.Claim;

import java.util.List;

public interface ClaimService {

    Claim addClaim(Claim claim);
    List<Claim> getClaimsByUserId(Long userId);


}
