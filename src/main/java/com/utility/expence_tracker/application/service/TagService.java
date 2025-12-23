package com.utility.expence_tracker.application.service;

import com.utility.expence_tracker.Presentation.dto.BaseResponse;
import com.utility.expence_tracker.Presentation.dto.CreateTagRequest;
import reactor.core.publisher.Mono;

public interface TagService {

    Mono<BaseResponse> createTag(CreateTagRequest createTagRequest);
}
