package pl.training.blog.domain.model;

public class ArticleDraft {

    private String title;
    private String content;

    public ArticleDraft(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean hasContent() {
        return !content.isBlank();
    }

}
