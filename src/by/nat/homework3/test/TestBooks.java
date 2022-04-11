package by.nat.homework3.test;

import by.nat.homework3.domain.Book;
import by.nat.homework3.util.ChoiceCompareTo;
import by.nat.homework3.util.GeneratorBooks;
import by.nat.homework3.util.OutputOnDisplay;

import java.util.List;
import java.util.Set;

public class TestBooks {


    public static void main(String[] args) {
        //Generate a list of 20 books in random order without repeating elements and show all books
        int listSize = GeneratorBooks.LIST_SIZE;
        List<Book> listOfBooks = GeneratorBooks.getListOfBooks(listSize);
        OutputOnDisplay.showObject(listOfBooks);

        //Remove the 7th book in the list and show new List
        int remoteBookIndex = 6;
        listOfBooks.remove(remoteBookIndex);
        System.out.println("Modified list without " + (remoteBookIndex + 1) + "th book: ");
        OutputOnDisplay.showObject(listOfBooks);

        //Generate a Set in random order and show set size
        Set<Book> setOfBooks = GeneratorBooks.getSetOfBooks();
        OutputOnDisplay.showObject(setOfBooks);
        System.out.println("A set of books includes: " + setOfBooks.size());

        //Sort the Set and select books with titles start with a vowel and show this set
        GeneratorBooks.titleBooksStartedWithVowel(setOfBooks);
        OutputOnDisplay.showObject(setOfBooks);

        /*Select a sorting method:
          COMPARE_TO_BY_AUTHORS_SURNAME - Sort by author's surname,
          COMPARE_TO_BY_AUTHORS_NAMES - Sort by author name,
          COMPARE_TO_BY_AUTHORS_MIDDLE_NAME - Sort by author's middle name
          */

        //Sort and show collection of books

        //compareType is "Sort by author's surname";
        GeneratorBooks.sorting(listOfBooks, ChoiceCompareTo.COMPARE_TO_BY_AUTHORS_SURNAME.ordinal());

        System.out.println("Sorted list of books (by author's surname): ");
        OutputOnDisplay.showObject(listOfBooks);

        //compareType is "Sort by author name";
        GeneratorBooks.sorting(listOfBooks, ChoiceCompareTo.COMPARE_TO_BY_AUTHORS_MIDDLE_NAME.ordinal());

        System.out.println("Sorted list of books (by author's name): ");
        OutputOnDisplay.showObject(listOfBooks);

        //compareType is "Sort by author's middle name";
        GeneratorBooks.sorting(listOfBooks, ChoiceCompareTo.COMPARE_TO_BY_AUTHORS_MIDDLE_NAME.ordinal());

        System.out.println("Sorted list of books (by author's middle name): ");
        OutputOnDisplay.showObject(listOfBooks);
    }
}
