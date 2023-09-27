package com.sofka.inventory.usecases;

import com.sofka.inventory.dtos.BranchDTO;
import com.sofka.inventory.model.Branch;
import com.sofka.inventory.repository.BranchRepository;
import com.sofka.inventory.utilities.MapperUtils;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Data
@Service
@RequiredArgsConstructor
public class CreateBranchUseCase {

    private final BranchRepository branchRepository;
    private final MapperUtils mapperUtils;

    public Mono<Branch> createBranch(BranchDTO branchDTO){
       return branchRepository.save(mapperUtils.mapperToBranch().apply(branchDTO));
    }

}
