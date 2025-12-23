package com.utility.expence_tracker.application.service.Impl;

import com.utility.expence_tracker.Presentation.dto.BaseResponse;
import com.utility.expence_tracker.Presentation.dto.CreateTagRequest;
import com.utility.expence_tracker.application.service.TagService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service("DefaultTagService")
public class TagServiceImpl implements TagService {

    @Override
    public Mono<BaseResponse> createTag(CreateTagRequest createTagRequest) {
        return null;
    }
}
