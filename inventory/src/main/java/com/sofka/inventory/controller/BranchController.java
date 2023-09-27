package com.sofka.inventory.controller;

import com.sofka.inventory.Service.BranchService;
import com.sofka.inventory.model.Branch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;
    @PostMapping("/createBranch")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Branch> createTutorial(@RequestBody Branch branch) {
        Branch branch1 = new Branch();
        branch1.setBranchName(branch.getBranchName());
        branch1.setBranchLocation(branch.getBranchLocation());
        return branchService.save(branch1);
    }
}
