package Week5.BookSorter;

import java.lang.Comparable;


public class Book implements Comparable{
    private final String name;
    private final int pageCount;

    Book(String name, int pageCount)
    {
        this.name = name;
        this.pageCount = pageCount;
    }

    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public int compareTo(Object o) {
            return name.compareTo(((Book) o).getName());
    }
}
