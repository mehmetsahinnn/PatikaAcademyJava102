package BookList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Book {
    String bookName;
    Integer pageNumber;
    String authorName;
    Date relaseDate;

    public Book(String bookName, Integer pageNumber, String authorName, Date relaseDate) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.relaseDate = relaseDate;
    }

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            bookList.add(new Book("Kitap" + i, 100 * i, "Yazar" + i, new Date()));
        }

        Map<String, String> bookMap = bookList.stream()
                .collect(Collectors.toMap(Book::getBookName, Book::getAuthorName));

        bookMap.
                forEach((bookName, authorName) -> System.out.println(bookName + " " + authorName));

        System.out.println("-------------------");

        bookList.stream()
                .filter(book -> book.getPageNumber() > 100)
                .forEach(book -> System.out.println(book.bookName));

    }

    public String getBookName() {
        return bookName;
    }


    public Integer getPageNumber() {
        return pageNumber;
    }


    public String getAuthorName() {
        return authorName;
    }
}
