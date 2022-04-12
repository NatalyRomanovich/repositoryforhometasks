package by.nat.homework3.util;

import by.nat.homework3.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateUsers {

    public static final String[] NAME_OF_USERS = {"Slava", "Matvei", "Lisa", "Ivan", "Artiom", "Sam", "Arina", "Mark",
            "Tom", "Inna", "Nik"};

    public static final String[] SURNAME_OF_USERS = {"Ivanov", "Petrov", "Sidorova", "Pupkin", "Morozov", "Jackson",
            "Nikitina", "Tven", "Edison", "Orlova", "Cage"};

    public static final String FIRST_PERSONS_NAME = "Slava";

    public static final Integer NUMBER_OF_LEVEL = 5;

    public static final int MAX_NUMBER_OF_FRIENDS = 3, MIN_NUMBER_OF_FRIENDS = 2;


    //select the number of friends of each user randomly in a given range from minimum to maximum

    public static int getNumberOfFriends() {
        int max = MAX_NUMBER_OF_FRIENDS, min = MIN_NUMBER_OF_FRIENDS;
        int numberOfFriends = (int) (Math.random() * ((max - min) + 1)) + min;
        return numberOfFriends;
    }
    //select a random index to create a list of friends in random order

    public static int getRandomIndex() {
        int randomIndex = (int) (Math.random() * (NAME_OF_USERS.length));
        return randomIndex;
    }

    //search the index in of user with given name in the data array NAME_OF_USERS

    public static int searchIndexOfFirstUser(String userName) {
        List<String> namesOfUsers = Arrays.asList(NAME_OF_USERS);
        return namesOfUsers.indexOf(userName);
    }
    //This method creates user with given name and with him friendList

    public static User getUser(String userFirstName) {

        List<User> listOfFriends = getFriends(FIRST_PERSONS_NAME, NUMBER_OF_LEVEL);

        int index = searchIndexOfFirstUser(userFirstName);
        User user = new User(index + 1, userFirstName, SURNAME_OF_USERS[index], listOfFriends);
        return user;
    }
    //These methods help to create user with given name and with him friendList

    public static User getUser(String userName, int countLevel) {

        User user = new User(userName, getFriends(userName, countLevel - 1));
        return user;
    }

    public static List getFriends(String userName, int countLevel) {
        List<User> listOfFriends = new ArrayList<>();

        if (countLevel > 0) {

            while (listOfFriends.size() < getNumberOfFriends()) {

                User friend = getUser(NAME_OF_USERS[getRandomIndex()], countLevel);

                if (!friend.getName().equals(userName) && !isInclude(listOfFriends, friend)) {

                    listOfFriends.add(friend);
                }
            }
        }
        return listOfFriends;
    }

    //checking for repeating friends in the friendList

    public static boolean isInclude(List<User> listOfFriends, User userName) {

        boolean result = false;

        for (int i = 0; i < listOfFriends.size(); i++) {

            if (listOfFriends.get(i).getName().equals(userName.getName())) {
                result = true;
            }
        }
        return result;
    }

    //This method shows information about the user with the given name
    public static void showUsers(User userFirstName) {
        System.out.println("\n" + userFirstName.getName() + "'s friends:" + "\n" + "--->");
    }

    //This method shows information about the friends of the user with the given name

    public static void showUsers(User userName, int countLevel) {

        List<User> nameFriendsForShow = new ArrayList<>(userName.getFriends());

        for (int i = 0; i < nameFriendsForShow.size(); i++) {

            System.out.println(nameFriendsForShow.get(i).getName());
        }
        System.out.println("--->");

        if (countLevel > 0) {

            for (int j = 0; j < nameFriendsForShow.size(); j++) {

                System.out.println(nameFriendsForShow.get(j).getName() + "'s friends:");
                showUsers(nameFriendsForShow.get(j), countLevel - 1);
            }
        }
    }

    //This method shows information about user and his/her friends and their friends in the given form
    public static void showAllFriends(User userName, int countLevel) {
        showUsers(userName);
        showUsers(userName, countLevel);
    }
}



