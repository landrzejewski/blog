package pl.training.blog.domain.model;

public record Title(String text) {

    private static final String WORD_SEPARATOR = " ";
    private static final int MIN_WORDS_COUNT = 5;

    public Title {
        if (text.split(WORD_SEPARATOR).length < MIN_WORDS_COUNT) {
            throw new IllegalArgumentException();
        }
    }

}
