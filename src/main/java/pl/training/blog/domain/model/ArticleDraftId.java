package pl.training.blog.domain.model;

import java.util.UUID;

public record ArticleDraftId(UUID value) {

    @Override
    public String toString() {
        return value.toString();
    }

}
