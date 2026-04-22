package pl.training.blog.adapters.out.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface JpaArticleRepository extends CrudRepository<ArticleEntity, UUID> {
}
