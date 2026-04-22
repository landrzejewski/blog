package pl.training.blog.domain.model;

public class ArticleDraft {

    private ArticleDraftId id;
    private String title;
    private String content;

    public ArticleDraft(ArticleDraftId id, String title, String content) {
        this.id = id;
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

    public ArticleDraftId getId() {
        return id;
    }

}
