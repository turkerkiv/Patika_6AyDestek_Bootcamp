package Week5.BookSorter;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Book> books = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.compareTo(o2);
            }
        });

        books.add(new Book("Yürümenin felsefesi", 191));
        books.add(new Book("Insanın anlam arayışı", 165));
        books.add(new Book("Bir delinin hatıra defteri", 128));
        books.add(new Book("Genç Werther'in acıları", 160));
        books.add(new Book("Dönüşüm", 95));

        for(Book b : books)
        {
            System.out.println("Name: "+ b.getName() +" --- Pages: " + b.getPageCount());
        }

        System.out.println();
        System.out.println("--------------------------");
        System.out.println();

        Set<Book> books2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageCount() - o2.getPageCount();
            }
        });

        books2.add(new Book("Yürümenin felsefesi", 191));
        books2.add(new Book("Insanın anlam arayışı", 165));
        books2.add(new Book("Bir delinin hatıra defteri", 128));
        books2.add(new Book("Genç Werther'in acıları", 160));
        books2.add(new Book("Dönüşüm", 95));

        for(Book b : books2)
        {
            System.out.println("Name: "+ b.getName() +" --- Pages: " + b.getPageCount());
        }
    }
}
