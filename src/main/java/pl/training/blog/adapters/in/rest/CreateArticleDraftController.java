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
    CreateArticleDraftResponse create() {
        var articleDraft = useCase.handle();
        return Mapper.map(articleDraft);
    }

}

record CreateArticleDraftResponse(String title, String content) {
}

class Mapper {

    public static CreateArticleDraftResponse map(ArticleDraft draft) {
        return new CreateArticleDraftResponse(draft.getTitle(), draft.getContent());
    }

}

