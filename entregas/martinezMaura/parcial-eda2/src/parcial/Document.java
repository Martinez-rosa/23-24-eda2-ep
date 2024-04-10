package parcial;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private int id;
    private String title;
    private int publicationYear;
    private DocumentType type;
    private List<String> keywords;

    public Document(int id, String title, int publicationYear, DocumentType type) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.type = type;
        this.keywords = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    public List<String> getKeywords() {
        return new ArrayList<>(keywords);
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = new ArrayList<>(keywords);
    }

    public void addKeyword(String keyword) {
        this.keywords.add(keyword);
    }

    public void removeKeyword(String keyword) {
        this.keywords.remove(keyword);
    }

    @Override
    public String toString() {
        return "> Document [id=" + id + ", title=" + title + ", publicationYear=" + publicationYear + ", type=" + type
                + ", keywords=" + keywords + "]";
    }
}
