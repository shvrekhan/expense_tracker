package com.utility.expence_tracker.infrastructure.Repository;

import com.utility.expence_tracker.domain.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends R2dbcRepository<User, Long> {
    
    Mono<User> findByTelegramId(String telegramId);
    
    Mono<Boolean> existsByTelegramId(String telegramId);
    
    @Query("SELECT * FROM users WHERE username = :username")
    Mono<User> findByUsername(String username);
    
    @Query("DELETE FROM users WHERE telegram_id = :telegramId")
    Mono<Void> deleteByTelegramId(String telegramId);
}