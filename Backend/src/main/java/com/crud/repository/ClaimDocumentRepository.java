package com.crud.repository;

import com.crud.entity.ClaimDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClaimDocumentRepository extends JpaRepository<ClaimDocument, Long> {
    List<ClaimDocument> findByClaim_ClaimId(Long claimId);
}
