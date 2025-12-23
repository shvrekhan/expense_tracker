package com.utility.expence_tracker.Presentation.port;

import com.utility.expence_tracker.Presentation.dto.BaseResponse;
import com.utility.expence_tracker.Presentation.dto.CreateUserRequest;
import com.utility.expence_tracker.Presentation.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserApis {
    
    Mono<UserDto> createUser(CreateUserRequest request);
    
    Mono<UserDto> getUserByTelegramId(String telegramId);
    
    Flux<UserDto> getAllUsers();
    
    Mono<UserDto> updateUser(String telegramId, CreateUserRequest request);
    
    Mono<BaseResponse> deleteUser(String telegramId);
    
    Mono<Boolean> userExists(String telegramId);
}
