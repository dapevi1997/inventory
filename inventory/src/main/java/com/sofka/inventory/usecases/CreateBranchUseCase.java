package com.sofka.inventory.usecases;

import com.sofka.inventory.model.Branch;
import com.sofka.inventory.repository.BranchRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Data
@Service
@RequiredArgsConstructor
public class CreateBranchUseCase {

    private final BranchRepository branchRepository;

    public Mono<Branch> createBranch(Branch branch){
       return branchRepository.save(branch);
    }

    public Mono<ServerResponse> executor (Branch branch){
        return createBranch(branch)
                .flatMap(branch1 -> {
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(branch1);
                });
    }
}
