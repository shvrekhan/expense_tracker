package com.utility.expence_tracker.domain.enums;

import lombok.Data;

public enum ResponseStatus {
    SUCCESS("SUCCESS"),
    FAILED("FAILED"),
    ERROR("ERROR"),
    NOT_FOUND("NOT_FOUND"),
    INVALID_REQUEST("INVALID_REQUEST"),
    UNAUTHORIZED("UNAUTHORIZED");
    
    private final String value;
    
    ResponseStatus(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value;
    }
}