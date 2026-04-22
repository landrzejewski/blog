package pl.training.blog.domain;

import pl.training.blog.domain.model.ArticleDraft;

public interface ArticleDraftWriter {

    void write(ArticleDraft draft);

}
