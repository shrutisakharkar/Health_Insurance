package com.crud.controller;

import com.crud.entity.Claim;
import com.crud.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;


    @PostMapping("/add")
    public ResponseEntity<Claim> addClaim(@RequestBody Claim claim){
        Claim savedClaim = claimService.addClaim(claim);
                return ResponseEntity.ok(savedClaim);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Claim>> getClaimsByUserId(@PathVariable Long userId) {
        List<Claim> claims = claimService.getClaimsByUserId(userId);
        return ResponseEntity.ok(claims);
    }


}
