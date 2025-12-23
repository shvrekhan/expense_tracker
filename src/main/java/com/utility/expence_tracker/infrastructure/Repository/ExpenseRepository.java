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
public interface ExpenseRepository extends R2dbcRepository<Expense, Long> {
    
    Flux<Expense> findByUserId(Long userId);
    
    Flux<Expense> findByUserIdAndCategory(Long userId, String category);
    
    @Query("SELECT * FROM expenses WHERE user_id = :userId AND expense_date BETWEEN :startDate AND :endDate ORDER BY expense_date DESC")
    Flux<Expense> findByUserIdAndDateRange(Long userId, LocalDateTime startDate, LocalDateTime endDate);
    
    @Query("SELECT SUM(amount) FROM expenses WHERE user_id = :userId")
    Mono<BigDecimal> getTotalExpensesByUserId(Long userId);
    
    @Query("SELECT SUM(amount) FROM expenses WHERE user_id = :userId AND category = :category")
    Mono<BigDecimal> getTotalExpensesByUserIdAndCategory(Long userId, String category);
    
    @Query("SELECT * FROM expenses WHERE user_id = :userId ORDER BY expense_date DESC LIMIT :limit")
    Flux<Expense> findRecentExpensesByUserId(Long userId, int limit);
    
    Mono<Void> deleteByUserId(Long userId);
}