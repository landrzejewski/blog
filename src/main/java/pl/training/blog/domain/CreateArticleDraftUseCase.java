package pl.training.blog.domain;

import pl.training.blog.domain.model.ArticleDraft;

public class CreateArticleDraftUseCase {

    private static final String EMPTY_TEXT = "";

    public ArticleDraft handle() {
        return new ArticleDraft(EMPTY_TEXT, EMPTY_TEXT);
    }

}
