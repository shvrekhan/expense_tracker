package com.utility.expence_tracker.Presentation.port;

import com.utility.expence_tracker.Presentation.dto.BaseResponse;
import com.utility.expence_tracker.Presentation.dto.CreateTagRequest;
import reactor.core.publisher.Mono;

public interface TagApis {

    Mono<BaseResponse> createTag(CreateTagRequest createTagRequest);
}
