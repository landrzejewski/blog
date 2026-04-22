package pl.training.blog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.blog.adapters.out.persistence.JpaArticleRepositoryAdapter;
import pl.training.blog.domain.ArticleDraftWriter;
import pl.training.blog.domain.CreateArticleDraftUseCase;
import pl.training.blog.domain.UpdateArticleDraftUseCase;
import pl.training.blog.domain.model.ArticleDraftId;

import java.util.UUID;
import java.util.function.Supplier;

@Configuration
public class BlogConfiguration {

    @Bean
    public CreateArticleDraftUseCase createArticleDraftUseCase(Supplier<UUID> uuidSupplier) {
        return new CreateArticleDraftUseCase(uuidSupplier);
    }

    @Bean
    public UpdateArticleDraftUseCase updateArticleDraftUseCase(ArticleDraftWriter articleDraftWriter) {
        return new UpdateArticleDraftUseCase(articleDraftWriter);
    }

    @Bean
    public Supplier<UUID> uuidSupplier() {
        return UUID::randomUUID;
    }

}
