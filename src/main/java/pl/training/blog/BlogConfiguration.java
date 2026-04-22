package pl.training.blog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.blog.domain.CreateArticleDraftUseCase;

@Configuration
public class BlogConfiguration {

    @Bean
    public CreateArticleDraftUseCase createArticleDraftUseCase() {
        return new CreateArticleDraftUseCase();
    }

}
