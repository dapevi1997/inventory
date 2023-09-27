package com.sofka.inventory.router;

import com.sofka.inventory.dtos.BranchDTO;
import com.sofka.inventory.model.Branch;
import com.sofka.inventory.usecases.CreateBranchUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
@Slf4j
public class BranchRouter {
    @Bean
    public RouterFunction<ServerResponse> createBranch(CreateBranchUseCase createBranchUseCase){

        Function<BranchDTO, Mono<ServerResponse>> executor = branchDTO -> {
            return createBranchUseCase.createBranch(branchDTO)
                    .flatMap(branch -> {
                        return ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(branch);
                    });
        };

        return route(POST("/createBranch").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BranchDTO.class)
                        .flatMap(executor)
        );
    }
}
