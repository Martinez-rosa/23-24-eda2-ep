package entregas.martinezMaura.Reto-003.src;

public class Book {
    private String title;
    private String Final category;
    private String author;
    private int year;
    private int id;
   

    public Book( int id, String title, String category, String author, int year) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.year = year;
        this.id = id;
        this.type = type;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
       this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public int getId() {
        return id;
    }
    public void setId(){
        this.id = id;
    }

    @Override
    public String toString() {
        return ">Book {" +
                "Title = '" + title + '\'' +
                ", Category = '" + category + '\'' +
                ", Author = '" + author + '\'' +
                ", Year of Publication = " + year +
                "id=" + id +
                
                '}';
    }
}
