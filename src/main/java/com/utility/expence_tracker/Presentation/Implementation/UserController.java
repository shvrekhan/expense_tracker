package com.utility.expence_tracker.Presentation.Implementation;

import com.utility.expence_tracker.Presentation.dto.BaseResponse;
import com.utility.expence_tracker.Presentation.dto.CreateUserRequest;
import com.utility.expence_tracker.Presentation.dto.UserDto;
import com.utility.expence_tracker.Presentation.port.UserApis;
import com.utility.expence_tracker.application.service.UserService;
import com.utility.expence_tracker.domain.enums.ResponseMessages;
import com.utility.expence_tracker.domain.enums.ResponseStatus;
import com.utility.expence_tracker.infrastructure.annotation.LogRequestResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController implements UserApis {

    private final UserService userService;

    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @Override
    @LogRequestResponse("Create new user")
    @PostMapping("/user")
    public Mono<UserDto> createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @Override
    @LogRequestResponse("Get user by telegram ID")
    @GetMapping("/user/{telegramId}")
    public Mono<UserDto> getUserByTelegramId(@PathVariable String telegramId) {
        return userService.getUserByTelegramId(telegramId);
    }

    @Override
    @LogRequestResponse("Get all users")
    @GetMapping("/user")
    public Flux<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @LogRequestResponse("Update user")
    @PutMapping("/user/{telegramId}")
    public Mono<UserDto> updateUser(@PathVariable String telegramId, @RequestBody CreateUserRequest request) {
        return userService.updateUser(telegramId, request);
    }

    @Override
    @LogRequestResponse("Delete user")
    @DeleteMapping("/user/{telegramId}")
    public Mono<BaseResponse> deleteUser(@PathVariable String telegramId) {
        return userService.deleteUser(telegramId)
                .then(Mono.just(new BaseResponse(ResponseStatus.SUCCESS, ResponseMessages.USER_DELETED_SUCCESS)));
    }

    @Override
    @LogRequestResponse("Check if user exists")
    @GetMapping("/user/exists/{telegramId}")
    public Mono<Boolean> userExists(@PathVariable String telegramId) {
        return userService.userExists(telegramId);
    }
}
