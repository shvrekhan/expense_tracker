package com.utility.expence_tracker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("expense")
public class Expense {
    
    @Id
    private String id;
    
    @Column("user_id")
    private String userId;
    
    @Column("tag_id")
    private String tagId;
    
    private String description;
    private BigDecimal amount;
    
    @Column("expense_date")
    private LocalDateTime expenseDate;
    
    @Column("created_at")
    private LocalDateTime createdAt;
    
    @Column("updated_at")
    private LocalDateTime updatedAt;
}