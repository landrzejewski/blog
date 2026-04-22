package pl.training.blog.domain;

import pl.training.blog.domain.model.ArticleDraft;

import java.util.List;

public interface ArticleDraftReader {

    List<ArticleDraft> readAll();

}
