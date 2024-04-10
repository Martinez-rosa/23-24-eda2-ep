package parcial;

public class Author {
    private int id;
    private String fullName;

    public Author(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Author: " + fullName + " with id: " + id;
    }
}
