package pl.training.blog.adapters.persistence;

import pl.training.blog.common.Mapper;
import pl.training.blog.domain.model.ArticleDraft;
import pl.training.blog.domain.model.ArticleDraftId;

import java.util.UUID;

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

    public ArticleDraft toDomain(final ArticleEntity entity) {
        return new ArticleDraft(
                toDomain(entity.getId()),
                entity.getTitle(),
                entity.getContent()
        );
    }

    private ArticleDraftId toDomain(UUID id) {
        return new ArticleDraftId(id);
    }

}
