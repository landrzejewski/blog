package pl.training.blog.domain;

import pl.training.blog.domain.model.ArticleDraft;

public class UpdateArticleDraftUseCase {

    private final ArticleDraftWriter writer;

    public UpdateArticleDraftUseCase(ArticleDraftWriter writer) {
        this.writer = writer;
    }

    public void handle(ArticleDraft draft) throws WriteFailedException {
        if (!draft.hasContent()) {
            throw new WriteFailedException();
        }
        writer.write(draft);
    }

}
