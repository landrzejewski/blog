package pl.training.blog.adapters.out.persistence;

import pl.training.blog.common.Adapter;
import pl.training.blog.domain.ArticleDraftReader;
import pl.training.blog.domain.ArticleDraftWriter;
import pl.training.blog.domain.model.ArticleDraft;

import java.util.List;

@Adapter
public class JpaArticleRepositoryAdapter implements ArticleDraftReader, ArticleDraftWriter {

    private final JpaArticleRepository repository;
    private final JpaArticleMapper mapper;

    public JpaArticleRepositoryAdapter(final JpaArticleRepository repository, final JpaArticleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ArticleDraft> readAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();

    }

    @Override
    public void write(final ArticleDraft draft) {
        var entity = mapper.toEntity(draft);
        repository.save(entity);
    }

}
