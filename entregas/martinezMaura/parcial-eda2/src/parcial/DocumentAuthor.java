package parcial;

public class DocumentAuthor {
    private int documentId;
    private int authorId;

    public DocumentAuthor(int documentId, int authorId) {
        this.documentId = documentId;
        this.authorId = authorId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "> AuthorBook [documentId=" + documentId + ", authorId=" + authorId + "]";
    }
}
