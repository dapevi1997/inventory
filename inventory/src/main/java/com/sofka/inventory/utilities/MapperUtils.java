package com.sofka.inventory.utilities;

import com.sofka.inventory.dtos.BranchDTO;
import com.sofka.inventory.model.Branch;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Function;

@Service
public class MapperUtils {
    public Function<BranchDTO, Branch> mapperToBranch(){
        return branchDTO -> {
            Branch branch = new Branch();
            branch.setBranchId(UUID.randomUUID().toString());
            branch.setBranchName(branchDTO.getBranchName());
            branch.setBranchLocation(branchDTO.getBranchLocation());

            return branch;

        };
    }
}
