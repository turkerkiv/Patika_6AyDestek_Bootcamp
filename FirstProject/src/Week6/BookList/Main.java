package Week6.BookList;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();

        for(int i = 0; i < 10; i++)
        {
            books.add(new Book((i+10) + " days in the wood", "charlie " + i, 95 + i, new Date(2023, Calendar.OCTOBER, 10)));
        }

        Map<String, String> bookAuthors = new HashMap<>();
        books.forEach(book -> bookAuthors.put(book.getName(), book.getAuthor()));

        System.out.println("All books with authors:");
        for(Map.Entry<String, String> entry : bookAuthors.entrySet())
        {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        List<Book> longBooks = books.stream().filter(book -> book.getPage() > 100).toList();

        System.out.println();
        System.out.println("Books that are longer than 100 pages:");
        for(Book book : longBooks)
        {
            System.out.println(book.getName() + " - " + book.getPage());
        }
    }
}
