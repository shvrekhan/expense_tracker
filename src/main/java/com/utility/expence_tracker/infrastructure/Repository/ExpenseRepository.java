package com.utility.expence_tracker.infrastructure.Repository;

import com.utility.expence_tracker.domain.Expense;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface ExpenseRepository extends R2dbcRepository<Expense, String> {
    
    Flux<Expense> findByUserId(String userId);
    
    Flux<Expense> findByUserIdAndTagId(String userId, String tagId);
    
    @Query("SELECT * FROM expense WHERE user_id = :userId AND expense_date BETWEEN :startDate AND :endDate ORDER BY expense_date DESC")
    Flux<Expense> findByUserIdAndDateRange(String userId, LocalDateTime startDate, LocalDateTime endDate);
    
    @Query("SELECT SUM(amount) FROM expense WHERE user_id = :userId")
    Mono<BigDecimal> getTotalExpensesByUserId(String userId);
    
    @Query("SELECT SUM(amount) FROM expense WHERE user_id = :userId AND tag_id = :tagId")
    Mono<BigDecimal> getTotalExpensesByUserIdAndTagId(String userId, String tagId);
    
    @Query("SELECT * FROM expense WHERE user_id = :userId ORDER BY expense_date DESC LIMIT :limit")
    Flux<Expense> findRecentExpensesByUserId(String userId, int limit);
    
    Mono<Void> deleteByUserId(String userId);
    
    Flux<Expense> findByTagId(String tagId);
}