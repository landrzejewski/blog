package pl.training.blog.adapters.in.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.training.blog.domain.CreateArticleDraftUseCase;
import pl.training.blog.domain.model.ArticleDraft;

@RestController
class CreateArticleDraftController {

    private final CreateArticleDraftUseCase useCase;

    public CreateArticleDraftController(final CreateArticleDraftUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("article-drafts")
    CreateArticleDraftResponse handle() {
        var articleDraft = useCase.handle();
        return CreateArticleDraftMapper.toResponse(articleDraft);
    }

}

record CreateArticleDraftResponse(String id, String title, String content) {
}

class CreateArticleDraftMapper {

    static CreateArticleDraftResponse toResponse(ArticleDraft draft) {
        return new CreateArticleDraftResponse(
                draft.getId().toString(),
                draft.getTitle(),
                draft.getContent()
        );
    }

}

