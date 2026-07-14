package pl.training.blog.adapters.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.blog.domain.InvalidContentException;
import pl.training.blog.domain.UpdateArticleDraftUseCase;
import pl.training.blog.domain.model.ArticleDraft;
import pl.training.blog.domain.model.ArticleDraftId;

import java.util.UUID;

@RestController
public class UpdateArticleDraftController {

    private final UpdateArticleDraftUseCase useCase;

    public UpdateArticleDraftController(final UpdateArticleDraftUseCase useCase) {
        this.useCase = useCase;
    }

    @PutMapping("article-drafts/{id:\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}}")
    ResponseEntity<Void> handle(@PathVariable UUID id,
                                @Valid @RequestBody UpdateArticleDraftRequest requestBody) throws InvalidContentException {
        var articleDraft = UpdateArticleDraftMapper.toDomain(id, requestBody);
        useCase.handle(articleDraft);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(InvalidContentException.class)
    ResponseEntity<ExceptionResponse> onInvalidContent() {
        return ResponseEntity.badRequest()
                .body(new ExceptionResponse("Invalid content"));
    }

}

record UpdateArticleDraftRequest(
        @NotBlank String title,
        @NotBlank String content) {
}

class UpdateArticleDraftMapper {

    static ArticleDraft toDomain(UUID id, UpdateArticleDraftRequest requestBody) {
        return new ArticleDraft(new ArticleDraftId(id), requestBody.title(), requestBody.content());
    }

}