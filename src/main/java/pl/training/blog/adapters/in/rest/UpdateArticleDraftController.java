package pl.training.blog.adapters.in.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.training.blog.domain.UpdateArticleDraftUseCase;
import pl.training.blog.domain.WriteFailedException;
import pl.training.blog.domain.model.ArticleDraft;
import pl.training.blog.domain.model.ArticleDraftId;

import java.util.UUID;

@RestController
public class UpdateArticleDraftController {

    private final UpdateArticleDraftUseCase useCase;

    public UpdateArticleDraftController(final UpdateArticleDraftUseCase useCase) {
        this.useCase = useCase;
    }

    @PutMapping("article-drafts/{id}")
    ResponseEntity<Void> handle(@PathVariable UUID id, @RequestBody UpdateArticleDraftRequest requestBody) throws WriteFailedException {
        var articleDraft = UpdateArticleDraftMapper.toDomain(id, requestBody);
        useCase.handle(articleDraft);
        return ResponseEntity.noContent().build();
    }

}

record UpdateArticleDraftRequest(String title, String content) {
}

class UpdateArticleDraftMapper {

    static ArticleDraft toDomain(UUID id, UpdateArticleDraftRequest requestBody) {
        return new ArticleDraft(new ArticleDraftId(id), requestBody.title(), requestBody.content());
    }

}