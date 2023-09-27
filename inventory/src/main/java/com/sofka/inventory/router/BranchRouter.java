package com.sofka.inventory.router;

import com.sofka.inventory.model.Branch;
import com.sofka.inventory.usecases.CreateBranchUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class BranchRouter {
    @Bean
    public RouterFunction<ServerResponse> createBranch(CreateBranchUseCase createBranchUseCase){
        return route(POST("/createBranch").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(Branch.class)
                        .flatMap(branch -> createBranchUseCase.executor(branch))
        );
    }
}
