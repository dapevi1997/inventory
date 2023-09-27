package com.sofka.inventory.router;

import com.sofka.inventory.dtos.ProductDTO;
import com.sofka.inventory.dtos.UserDTO;
import com.sofka.inventory.usecases.CreateProductUseCase;
import com.sofka.inventory.usecases.CreateUserUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@Slf4j
public class UserRoute {
    @Bean
    public RouterFunction<ServerResponse> createUser(CreateUserUseCase createUserUseCase){

        Function<UserDTO, Mono<ServerResponse>> executor = userDTO -> {
            return createUserUseCase.createUser(userDTO)
                    .flatMap(user -> {
                        return ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(user);
                    });
        };

        return route(POST("/createUser").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UserDTO.class)
                        .flatMap(executor)
        );
    }
}
