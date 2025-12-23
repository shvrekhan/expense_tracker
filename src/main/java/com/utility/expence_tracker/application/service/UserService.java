package com.utility.expence_tracker.application.service;

import com.utility.expence_tracker.Presentation.dto.CreateUserRequest;
import com.utility.expence_tracker.Presentation.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    
    Mono<UserDto> createUser(CreateUserRequest request);
    
    Mono<UserDto> getUserByTelegramId(String telegramId);
    
    Flux<UserDto> getAllUsers();
    
    Mono<UserDto> updateUser(String telegramId, CreateUserRequest request);
    
    Mono<Void> deleteUser(String telegramId);
    
    Mono<Boolean> userExists(String telegramId);
}