package pl.training.blog.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface JpaArticleRepository extends JpaRepository<ArticleEntity, UUID> {

    @Query("select a from Article a where a.isDraft = false")
    List<ArticleEntity> findAllDrafts();

}
