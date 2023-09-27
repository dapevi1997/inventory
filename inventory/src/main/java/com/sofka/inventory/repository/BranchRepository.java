package com.sofka.inventory.repository;

import com.sofka.inventory.model.Branch;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends R2dbcRepository<Branch, Long> {
}
