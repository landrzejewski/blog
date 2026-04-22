package pl.training.blog.domain;

import pl.training.blog.common.Atomic;
import pl.training.blog.domain.model.ArticleDraft;

@Atomic
public class UpdateArticleDraftUseCase {

    private final ArticleDraftWriter writer;

    public UpdateArticleDraftUseCase(final ArticleDraftWriter writer) {
        this.writer = writer;
    }

    public void handle(ArticleDraft draft) throws InvalidContentException {
        if (!draft.hasContent()) {
            throw new InvalidContentException();
        }
        writer.write(draft);
    }

}
