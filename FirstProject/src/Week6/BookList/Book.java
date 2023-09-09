package Week6.BookList;

import java.util.Date;

public class Book {
    private String name;
    private int page;
    private String author;
    private Date publishDate;

    public Book(String name, String author, int page, Date publishDate)
    {
        this.name = name;
        this.author = author;
        this.page = page;
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPage() {
        return page;
    }

    public Date getPublishDate() {
        return publishDate;
    }
}
