package com.utility.expence_tracker.Presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateExpenseRequest {
    private String telegramId;
    private String description;
    private BigDecimal amount;
    private String category;
    private LocalDateTime expenseDate;
}