package com.utility.expence_tracker.application.service.Impl;

import com.utility.expence_tracker.Presentation.dto.CreateUserRequest;
import com.utility.expence_tracker.Presentation.dto.UserDto;
import com.utility.expence_tracker.application.service.UserService;
import com.utility.expence_tracker.domain.User;
import com.utility.expence_tracker.infrastructure.Repository.UserRepository;
import com.utility.expence_tracker.infrastructure.util.UuidUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<UserDto> createUser(CreateUserRequest request) {
        User user = new User();
        // Don't set ID - let database generate UUID
        user.setTelegramId(request.getTelegramId());
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(null);
        user.setPassword(null);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(user)
                .doOnSuccess(savedUser -> System.out.println("User saved: " + savedUser.getId()))
                .doOnError(error -> System.err.println("Error saving user: " + error.getMessage()))
                .map(this::mapToDto);
    }

    @Override
    public Mono<UserDto> getUserByTelegramId(String telegramId) {
        return userRepository.findByTelegramId(telegramId)
                .map(this::mapToDto);
    }

    @Override
    public Flux<UserDto> getAllUsers() {
        return userRepository.findAll()
                .map(this::mapToDto);
    }

    @Override
    public Mono<UserDto> updateUser(String telegramId, CreateUserRequest request) {
        return userRepository.findByTelegramId(telegramId)
                .flatMap(user -> {
                    user.setUsername(request.getUsername());
                    user.setFirstName(request.getFirstName());
                    user.setLastName(request.getLastName());
                    user.setUpdatedAt(LocalDateTime.now());
                    return userRepository.save(user);
                })
                .map(this::mapToDto);
    }

    @Override
    public Mono<Void> deleteUser(String telegramId) {
        return userRepository.deleteByTelegramId(telegramId);
    }

    @Override
    public Mono<Boolean> userExists(String telegramId) {
        return userRepository.existsByTelegramId(telegramId);
    }

    private UserDto mapToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getTelegramId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}