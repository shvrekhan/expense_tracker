package com.utility.expence_tracker.infrastructure.Repository;

import com.utility.expence_tracker.domain.Tag;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TagRepository extends R2dbcRepository<Tag, String> {
    
    Flux<Tag> findByUserId(String userId);
    
    Mono<Tag> findByUserIdAndName(String userId, String name);
    
    Mono<Boolean> existsByUserIdAndName(String userId, String name);
    
    Mono<Void> deleteByUserId(String userId);
}