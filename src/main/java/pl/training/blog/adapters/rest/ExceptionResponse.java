package pl.training.blog.adapters.rest;

import java.time.Instant;

public record ExceptionResponse(Instant timestamp, String description) {

    public ExceptionResponse(String description) {
        this(Instant.now(), description);
    }

}
