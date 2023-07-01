package CollectionAndMap;

import java.util.*;

public class Book implements Comparable<Book> {
    String name;
    Integer pageNumber;
    String author;
    String releaseDate;

    public Book(String name, Integer pageNumber, String author, String releaseDate) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public static void main(String[] args) {

        Set<Book> set = new LinkedHashSet<>();

        set.add(new Book("A", 250, "Author A", "2022-01-01"));
        set.add(new Book("B", 200, "Author B", "2021-01-01"));
        set.add(new Book("C", 300, "Author C", "2023-01-01"));
        set.add(new Book("D", 150, "Author D", "2020-01-01"));
        set.add(new Book("E", 100, "Author E", "2019-01-01"));

        System.out.println("Books sorted by title:");
        for (Book book : set) {
            System.out.println(book.name);
        }

        System.out.println("- - - - - - - - - - - - - - - - - - - - -");

        Set<Book> pageNumber = new TreeSet<>(Comparator.comparingInt(Book::getPageNumber));

        pageNumber.add(new Book("A", 250, "Author A", "2022-01-01"));
        pageNumber.add(new Book("B", 200, "Author B", "2021-01-01"));
        pageNumber.add(new Book("C", 300, "Author C", "2023-01-01"));
        pageNumber.add(new Book("D", 150, "Author D", "2020-01-01"));
        pageNumber.add(new Book("E", 100, "Author E", "2019-01-01"));

        System.out.println("Books sorted by page number:");
        for (Book book : pageNumber) {
            System.out.println(book.pageNumber);
        }

    }

    @Override
    public int compareTo(Book otherBook) {
        return this.name.compareTo(otherBook.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


}
