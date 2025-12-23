package com.utility.expence_tracker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("expenses")
public class Expense {
    
    @Id
    private Long id;
    
    private Long userId;
    private String description;
    private BigDecimal amount;
    private String category;
    private LocalDateTime expenseDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}