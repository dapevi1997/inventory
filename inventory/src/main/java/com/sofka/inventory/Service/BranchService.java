package com.sofka.inventory.Service;

import com.sofka.inventory.model.Branch;
import com.sofka.inventory.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;

    public Mono<Branch> save(Branch branch){
        return branchRepository.save(branch);
    }
}
