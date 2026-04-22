package pl.training.blog.adapters.in.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.training.blog.domain.GetAllArticleDraftsUseCase;
import pl.training.blog.domain.model.ArticleDraft;

import java.util.List;

import static pl.training.blog.adapters.in.rest.GetAllArticleDraftsMapper.toResponse;

@RestController
public class GetAllArticleDraftsController {

    private final GetAllArticleDraftsUseCase useCase;

    public GetAllArticleDraftsController(final GetAllArticleDraftsUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("article-drafts")
    ResponseEntity<List<GetAllArticleDraftsResponse>> handle() {
        return ResponseEntity.ok(toResponse(useCase.handle()));
    }

}

record GetAllArticleDraftsResponse(String id, String title, String content) {
}

class GetAllArticleDraftsMapper {

    static List<GetAllArticleDraftsResponse> toResponse(List<ArticleDraft> articleDrafts) {
        return articleDrafts.stream().map(GetAllArticleDraftsMapper::toResponse).toList();
    }

    static GetAllArticleDraftsResponse toResponse(ArticleDraft articleDrafts) {
        return new GetAllArticleDraftsResponse(
                articleDrafts.getId().toString(),
                articleDrafts.getTitle(),
                articleDrafts.getContent()
        );
    }

}