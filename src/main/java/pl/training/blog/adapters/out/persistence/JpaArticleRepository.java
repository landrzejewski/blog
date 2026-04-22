package pl.training.blog.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaArticleRepository extends JpaRepository<ArticleEntity, UUID> {
}
