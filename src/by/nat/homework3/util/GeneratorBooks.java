package by.nat.homework3.util;

import by.nat.homework3.domain.Book;
import by.nat.homework3.domain.BookInformation;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class GeneratorBooks implements BookInformation {

    public static final Integer NUMBER_OF_REPEATING_ELEMENTS = 6;
    public static final Integer PLACE_OF_CHECKED_LETTER = 0;
    public static final Integer LIST_SIZE = 20;
    public static final Integer REPEATING_LIST_SIZE = 25;
    public static int compareType;

    //These methods create books in random order
    public static Book getRandomBook() {
        int randomIndex = (int) (Math.random() * (TITLES_OF_THE_BOOK.length));

        return new Book(TITLES_OF_THE_BOOK[randomIndex], AUTHORS_SURNAMES[randomIndex],
                AUTHORS_NAMES[randomIndex], AUTHORS_MIDDLE_NAME[randomIndex], BOOK_DESCRIPTION[randomIndex]);
    }

    // generate list of book without repeating elements
    public static List getListOfBooks(int listSize) {
        List<Book> listOfBooks = new LinkedList<>();

        while (listOfBooks.size() < listSize) {
            Book book = getRandomBook();
            if (!listOfBooks.contains(book)) { //check that there are no duplicate books
                listOfBooks.add(book);
            }
        }
        return listOfBooks;
    }

    // generate list of book with repeating elements
    public static List getListOfBooks(int setSize, int countRepeatingElements) {
        List<Book> listOfBooks = new LinkedList<>();

        int randomIndex = (int) (Math.random() * (setSize));

        while (setSize > (listOfBooks.size() - countRepeatingElements)) { //generate repeating books
            listOfBooks.add(getRandomBook());
        }
        while (listOfBooks.size() < setSize) {                         //generate others books
            listOfBooks.add(listOfBooks.get(randomIndex));
        }
        return listOfBooks;
    }

    public static Set getSetOfBooks() {
        List<Book> listOfBooks = getListOfBooks(REPEATING_LIST_SIZE, NUMBER_OF_REPEATING_ELEMENTS);
        Set<Book> setOfBooks = new HashSet<>(listOfBooks);
        return setOfBooks;
    }

    public static boolean isVowel(char firstLetter) {
        char[] vowels = new char[]{'A', 'E', 'I', 'O', 'U', 'Y'};
        firstLetter = Character.toUpperCase(firstLetter);  //check that the title of the book starts with a vowel
        for (char a : vowels) {
            if (firstLetter == a)
                return true;
        }
        return false;
    }

    public static Set titleBooksStartedWithVowel(Set<Book> setOfAllBooks) {

        Set<Book> setOfSortedBooks = new HashSet<>();
        for (Book book : setOfAllBooks) {
            char[] bookName = book.getTitleOfBook().toCharArray();
            char firstLetter = bookName[PLACE_OF_CHECKED_LETTER];
            if (isVowel(firstLetter)) {
                setOfSortedBooks.add(book);
            }
        }
        return setOfSortedBooks;
    }

    public static void sorting(List<Book> listOfBooks, int descriptionCompareTo) {
        GeneratorBooks.compareType = descriptionCompareTo;
        Collections.sort(listOfBooks);
    }
}
