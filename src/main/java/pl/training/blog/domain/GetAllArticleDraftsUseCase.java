package pl.training.blog.domain;

import pl.training.blog.common.Atomic;
import pl.training.blog.domain.model.ArticleDraft;

import java.util.List;

@Atomic
public class GetAllArticleDraftsUseCase {

    private final ArticleDraftReader reader;

    public GetAllArticleDraftsUseCase(final ArticleDraftReader reader) {
        this.reader = reader;
    }

    public List<ArticleDraft> handle() {
        return reader.readAll();
    }

}
