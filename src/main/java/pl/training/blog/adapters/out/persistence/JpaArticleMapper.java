package pl.training.blog.adapters.out.persistence;

import pl.training.blog.common.Mapper;
import pl.training.blog.domain.model.ArticleDraft;

@Mapper
public class JpaArticleMapper {

    public ArticleEntity toEntity(final ArticleDraft draft) {
        var entity = new ArticleEntity();
        entity.setId(draft.getId().value());
        entity.setTitle(draft.getTitle());
        entity.setContent(draft.getContent());
        entity.setDraft(true);
        return entity;
    }

}
