package by.nat.homework3.domain;

import by.nat.homework3.util.GeneratorBooks;

import java.util.Random;

public interface BookInformation {
    int LENGTH_OF_RANDOM_STRING = 5;

    String[] TITLES_OF_THE_BOOK = {"Master and Margarita", "Roadside Picnic", "Amber Chronicles", "Calculator",
            "Viy", "Monday starts on Saturday", "The gods themselves", "Indomitable planet", "Witch Age",
            "Naked sun", "Blood brothers", "Fever", "Evenings on a Farm Near Dikanka", "Game of Thrones",
            "Hobbit, or there and back", "Lord of the Rings", "1984", "Mathematics", "Witcher",
            "Effective Java: Programming Language Guide"};

    String[] AUTHORS_SURNAMES = {"Bulgakov", "Strugatsky", "Zelazny", "Gromov", "Gogol", "Strugatsky", "Asimov",
            "Harrison", "Dyachenko", "Asimov", "Pekhov", "Dyachenko", "Gogol", "Martin", "Tolkien", "Tolkien", "Orwell",
            "Author unknown", "Sapkowski", "Bloch"};

    String[] AUTHORS_NAMES = {"Mikhail", "Arkady and Boris", "Roger", "Alexey",
            "Nikolay", "Arkady and Boris", "Isaak", "Harry", "Maria and Sergei",
            "Isaak", "Alexey", "Maria and Sergei", "Nikolay", "George",
            "John", "John", "George", "Author unknown", "Andrzej", "Joshua"};

    String[] AUTHORS_MIDDLE_NAME = {"Afanasyevich", "Natanovich and Natanovich", "Joseph", "Alekseevich",
            "Vasilievich", "Natanovich and Natanovich", "Yudovich", "Maxwell", "Yurievna and Sergeevich",
            "Yudovich", "Yurievich", "Yurievna and Sergeevich", "Vasilievich", "Richard Raymond",
            "Ronald Reuel", "Ronald Reuel", " ", "Author unknown", " ", "J."};

    String[] BOOK_DESCRIPTION = getRandomBookDescription(GeneratorBooks.LIST_SIZE);

    private static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
        Random random = new Random();
        StringBuffer string = new StringBuffer();

        for (int i = 0; i < length; i++) {

            int number = random.nextInt(str.length());
            string.append(str.charAt(number));

        }
        return string.toString();
    }

    private static String[] getRandomBookDescription(int count) {
        String[] bookDescription = new String[count];

        for (int i = 0; i < count; i++) {
            bookDescription[i] = getRandomString(LENGTH_OF_RANDOM_STRING);
        }

        return bookDescription;
    }
}

