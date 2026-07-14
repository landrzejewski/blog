package pl.training.blog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.blog.domain.*;
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
    public GetAllArticleDraftsUseCase getAllArticleDraftsUseCase(ArticleDraftReader articleDraftReader) {
        return new GetAllArticleDraftsUseCase(articleDraftReader);
    }

    @Bean
    public Supplier<UUID> uuidSupplier() {
        return UUID::randomUUID;
    }

}
