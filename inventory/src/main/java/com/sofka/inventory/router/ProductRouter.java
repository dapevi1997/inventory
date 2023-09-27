package com.sofka.inventory.router;

import com.sofka.inventory.dtos.BranchDTO;
import com.sofka.inventory.dtos.ProductDTO;
import com.sofka.inventory.usecases.CreateBranchUseCase;
import com.sofka.inventory.usecases.CreateProductUseCase;
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
public class ProductRouter {
    @Bean
    public RouterFunction<ServerResponse> createProduct(CreateProductUseCase createProductUseCase){

        Function<ProductDTO, Mono<ServerResponse>> executor = productDTO -> {
            return createProductUseCase.createProduct(productDTO)
                    .flatMap(product -> {
                        return ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(product);
                    });
        };

        return route(POST("/createProduct").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDTO.class)
                        .flatMap(executor)
        );
    }
}
