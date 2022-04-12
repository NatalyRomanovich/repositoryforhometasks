package by.nat.homework3.domain;

import by.nat.homework3.util.ChoiceCompareTo;
import by.nat.homework3.util.GeneratorBooks;

import java.util.Objects;

public class Book implements Comparable<Book> {

    private String titleOfBook;
    private String authorsSurname;
    private String authorsName;
    private String authorsMiddleName;
    private String description;

    public Book() {
    }

    public Book(String nameOfBook, String authorsSurname, String authorsName,
                String authorsMiddleName, String description) {
        this.titleOfBook = nameOfBook;
        this.authorsSurname = authorsSurname;
        this.authorsName = authorsName;
        this.authorsMiddleName = authorsMiddleName;
        this.description = description;
    }

    public void setNameOfBook(String nameOfBook) {
        this.titleOfBook = nameOfBook;
    }

    public void setAuthorsSurname(String authorsSurname) {
        this.authorsSurname = authorsSurname;
    }

    public void setAuthorsName(String authorsName) {
        this.authorsName = authorsName;
    }

    public void setAuthorsMiddleName(String authorsMiddleName) {
        this.authorsMiddleName = authorsMiddleName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitleOfBook() {
        return titleOfBook;
    }

    public String getAuthorsSurname() {
        return authorsSurname;
    }

    public String getAuthorsName() {
        return authorsName;
    }

    public String getAuthorsMiddleName() {
        return authorsMiddleName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(titleOfBook, book.titleOfBook) &&
                Objects.equals(authorsSurname, book.authorsSurname) &&
                Objects.equals(authorsName, book.authorsName) &&
                Objects.equals(authorsMiddleName,
                        book.authorsMiddleName) &&
                Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleOfBook, authorsSurname, authorsName, authorsMiddleName, description);
    }

    @Override
    public String toString() {
        return "book: tittle of book '" + titleOfBook + " " +
                ", author '" + authorsSurname + " " +
                authorsName + " " + authorsMiddleName + '\'' +
                " " + ", description '" + description + '\'' +
                '}';

    }

    @Override
    public int compareTo(Book b) {

        if (GeneratorBooks.compareType == ChoiceCompareTo.COMPARE_TO_BY_AUTHORS_SURNAME.ordinal()) {

            return compareToAuthorsSurname(b);

        } else if (GeneratorBooks.compareType == ChoiceCompareTo.COMPARE_TO_BY_AUTHORS_NAMES.ordinal()) {

            return compareToAuthorsName(b);

        } else if (GeneratorBooks.compareType == ChoiceCompareTo.COMPARE_TO_BY_AUTHORS_MIDDLE_NAME.ordinal()) {

            return compareToAuthorsMiddleName(b);
        }

        return compareTittleBook(b);
    }

    public int compareToAuthorsSurname(Book b) {
        if (getAuthorsSurname() == null || b.getAuthorsSurname() == null) {
            return 0;
        }
        return getAuthorsSurname().compareTo(b.getAuthorsSurname());
    }

    public int compareToAuthorsName(Book b) {
        if (getAuthorsName() == null || b.getAuthorsName() == null) {
            return 0;
        }
        return getAuthorsName().compareTo(b.getAuthorsName());
    }

    public int compareToAuthorsMiddleName(Book b) {
        if (getAuthorsMiddleName() == null || b.getAuthorsMiddleName() == null) {
            return 0;
        }
        return getAuthorsMiddleName().compareTo(b.getAuthorsMiddleName());
    }

    public int compareTittleBook(Book b) {
        if (getTitleOfBook() == null || b.getTitleOfBook() == null) {
            return 0;
        }
        return getAuthorsMiddleName().compareTo(b.getAuthorsMiddleName());
    }

}
