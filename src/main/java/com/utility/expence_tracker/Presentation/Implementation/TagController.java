package com.utility.expence_tracker.Presentation.Implementation;

import com.utility.expence_tracker.Presentation.dto.BaseResponse;
import com.utility.expence_tracker.Presentation.dto.CreateTagRequest;
import com.utility.expence_tracker.Presentation.port.TagApis;
import com.utility.expence_tracker.application.service.TagService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TagController implements TagApis {

    TagService tagService;

    TagController(@Qualifier("DefaultTagService") TagService tagService) {
        this.tagService = tagService;
    }

    @Override
    public Mono<BaseResponse> createTag(CreateTagRequest createTagRequest) {
        return tagService.createTag(createTagRequest);
    }
}
