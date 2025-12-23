package com.utility.expence_tracker.infrastructure.util;

import java.util.UUID;

public final class UuidUtil {
    
    private UuidUtil() {
        // Utility class
    }
    
    public static String generateCleanUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }
    
    public static String cleanUuid(String uuid) {
        return uuid.replace("-", "");
    }
}