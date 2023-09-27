package com.sofka.inventory.usecases;

import com.sofka.inventory.dtos.ProductDTO;
import com.sofka.inventory.dtos.UserDTO;
import com.sofka.inventory.model.Product;
import com.sofka.inventory.model.User;
import com.sofka.inventory.repository.UserRepository;
import com.sofka.inventory.utilities.MapperUtils;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Data
@Service
@RequiredArgsConstructor
public class CreateUserUseCase {
    private final MapperUtils mapperUtils;
    private final UserRepository userRepository;

    public Mono<User> createUser(UserDTO userDTO){
        return userRepository.save(mapperUtils.mapperToUser().apply(userDTO));
    }
}
