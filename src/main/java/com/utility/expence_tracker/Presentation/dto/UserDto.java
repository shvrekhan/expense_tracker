package com.utility.expence_tracker.Presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private String telegramId;
    private String username;
    private String firstName;
    private String lastName;
}