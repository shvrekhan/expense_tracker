package com.utility.expence_tracker.Presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {
    private String id;
    private String name;
    private String description;
    private String userId;
    private String color;
}