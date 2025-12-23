package com.utility.expence_tracker.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Table("user_tags")
public class UserTags {

    @Id
    private Long id;

    private Long userId;
    private String tag;
}
