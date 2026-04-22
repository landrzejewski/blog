package pl.training.blog.domain;

import pl.training.blog.common.Atomic;
import pl.training.blog.domain.model.ArticleDraft;
import pl.training.blog.domain.model.ArticleDraftId;

import java.util.UUID;
import java.util.function.Supplier;

@Atomic
public class CreateArticleDraftUseCase {

    private static final String EMPTY_TEXT = "";

    private final Supplier<UUID> uuidSupplier;

    public CreateArticleDraftUseCase(final Supplier<UUID> uuidSupplier) {
        this.uuidSupplier = uuidSupplier;
    }

    public ArticleDraft handle() {
        var id = new ArticleDraftId(uuidSupplier.get());
        return new ArticleDraft(id, EMPTY_TEXT, EMPTY_TEXT);
    }

}
