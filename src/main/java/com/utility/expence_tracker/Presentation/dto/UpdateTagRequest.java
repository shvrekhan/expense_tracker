package com.utility.expence_tracker.Presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTagRequest {
    private String name;
    private String description;
    private String color;
}