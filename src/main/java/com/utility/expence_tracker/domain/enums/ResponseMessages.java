package com.utility.expence_tracker.domain.enums;

public final class ResponseMessages {
    
    // User Messages
    public static final String USER_CREATED_SUCCESS = "User created successfully";
    public static final String USER_UPDATED_SUCCESS = "User updated successfully";
    public static final String USER_DELETED_SUCCESS = "User deleted successfully";
    public static final String USER_NOT_FOUND = "User not found";
    public static final String USER_ALREADY_EXISTS = "User already exists";
    
    // Expense Messages
    public static final String EXPENSE_CREATED_SUCCESS = "Expense created successfully";
    public static final String EXPENSE_UPDATED_SUCCESS = "Expense updated successfully";
    public static final String EXPENSE_DELETED_SUCCESS = "Expense deleted successfully";
    public static final String EXPENSE_NOT_FOUND = "Expense not found";
    
    // General Messages
    public static final String OPERATION_SUCCESS = "Operation completed successfully";
    public static final String OPERATION_FAILED = "Operation failed";
    public static final String INVALID_REQUEST = "Invalid request data";
    public static final String UNAUTHORIZED_ACCESS = "Unauthorized access";
    
    private ResponseMessages() {
        // Utility class
    }
}