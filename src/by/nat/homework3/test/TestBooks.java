package by.nat.homework3.test;

import by.nat.homework3.domain.Book;
import by.nat.homework3.util.ChoiceCompareTo;
import by.nat.homework3.util.GeneratorBooks;
import by.nat.homework3.util.OutputOnDisplay;

import java.util.List;
import java.util.Set;

public class TestBooks {
    public static final Integer REMOTE_BOOK_INDEX = 6;

    public static void main(String[] args) {
        //Generate a list of 20 books in random order without repeating elements and show all books
        int listSize = GeneratorBooks.LIST_SIZE;
        List<Book> listOfBooks = GeneratorBooks.getListOfBooks(listSize);
        System.out.println("\n" + "The list of my favorite books: " + "\n");
        OutputOnDisplay.showObject(listOfBooks);

        //Remove the 7th book in the list and show new List
        listOfBooks.remove(REMOTE_BOOK_INDEX);
        System.out.println("\n" + "Modified list without " + (REMOTE_BOOK_INDEX + 1) + "th book: " + "\n");
        OutputOnDisplay.showObject(listOfBooks);

        //Generate a Set in random order and show set size
        Set<Book> setOfBooks = GeneratorBooks.getSetOfBooks();
        System.out.println("\n" + "A set of books includes: " + setOfBooks.size());

        //Sort the Set and select books with titles start with a vowel and show this set
        Set<Book> setOfSortedBooks = GeneratorBooks.titleBooksStartedWithVowel(setOfBooks);
        System.out.println("\n" + "A set of books with titles start with a vowel: " + setOfBooks.size() + "\n");
        OutputOnDisplay.showObject(setOfSortedBooks);

        /*Select a sorting method:
          COMPARE_TO_BY_AUTHORS_SURNAME - Sort by author's surname,
          COMPARE_TO_BY_AUTHORS_NAMES - Sort by author name,
          COMPARE_TO_BY_AUTHORS_MIDDLE_NAME - Sort by author's middle name
          */

        //Sort and show collection of books

        //compareType is "Sort by author's surname";
        GeneratorBooks.sorting(listOfBooks, ChoiceCompareTo.COMPARE_TO_BY_AUTHORS_SURNAME.ordinal());

        System.out.println("\n" + "Sorted list of books (by author's surname): " + "\n");
        OutputOnDisplay.showObject(listOfBooks);

        //compareType is "Sort by author name";
        GeneratorBooks.sorting(listOfBooks, ChoiceCompareTo.COMPARE_TO_BY_AUTHORS_NAMES.ordinal());

        System.out.println("\n" + "Sorted list of books (by author's name): " + "\n");
        OutputOnDisplay.showObject(listOfBooks);

        //compareType is "Sort by author's middle name";
        GeneratorBooks.sorting(listOfBooks, ChoiceCompareTo.COMPARE_TO_BY_AUTHORS_MIDDLE_NAME.ordinal());

        System.out.println("\n" + "Sorted list of books (by author's middle name): " + "\n");
        OutputOnDisplay.showObject(listOfBooks);
    }
}
