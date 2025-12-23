package com.utility.expence_tracker.Presentation.dto;

import com.utility.expence_tracker.domain.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    private ResponseStatus status;
    private String message;
}
