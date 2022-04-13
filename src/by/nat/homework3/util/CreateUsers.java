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

    public static final Integer NUMBER_OF_LEVEL = 2;

    public static final int MAX_NUMBER_OF_FRIENDS = 2, MIN_NUMBER_OF_FRIENDS = 2;

    //select the number of friends of each user randomly in a given range from minimum to maximum

    public static int getNumberOfFriends() {

        int max = MAX_NUMBER_OF_FRIENDS, min = MIN_NUMBER_OF_FRIENDS;
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
    //select a random index to create a list of friends in random order

    public static int getRandomIndex() {

        return (int) (Math.random() * (NAME_OF_USERS.length));
    }

    //search the index in of user with given name in the data array NAME_OF_USERS

    public static int searchIndexOfFirstUser(String personsFirstName) {

        List<String> namesOfUsers = Arrays.asList(NAME_OF_USERS);
        return namesOfUsers.indexOf(personsFirstName);
    }

    //These methods help to create user with given name and with him friendList

    public static User getUser(String userName, int countLevel) {

        User otherUser = new User(userName, getFriends(userName, countLevel));
        return otherUser;
    }

    public static List getFriends(String userName, int countLevel) {

        List<User> listOfFriends = new ArrayList<>();

        if (countLevel > 0) {

            while (listOfFriends.size() < getNumberOfFriends()) {

                User friend = getUser(NAME_OF_USERS[getRandomIndex()], countLevel - 1);

                if (!friend.getName().equals(userName) && !isInclude(listOfFriends, friend)) {

                    listOfFriends.add(friend);
                }
            }
        }
        return listOfFriends;
    }

    //checking for repeating friends in the friendList

    public static boolean isInclude(List<User> listOfFriends, User userName) {

        boolean isInclude = false;

        for (User friend : listOfFriends) {

            if (friend.getName().equals(userName.getName())) {
                isInclude = true;
                break;
            }
        }
        return isInclude;
    }

    //This method shows information about the user with the given name

    public static void showUsers(User personFirstName) {
        System.out.println("\n" + personFirstName.getName() + "'s friends:" + "\n" + "--->");
    }

    //This method shows information about the friends of the user with the given name

    public static void showUsers(User userName, int countLevel) {

        List<User> namesFriendsForShow = new ArrayList<>(userName.getFriends());

        for (User friend : namesFriendsForShow) {

            System.out.println(friend.getName());
        }
        System.out.println("--->");

        if (countLevel-- > 0) {
            for (int j = 0; j < namesFriendsForShow.size(); j++) {

                System.out.println(namesFriendsForShow.get(j).getName() + "'s friends:");
                showUsers(namesFriendsForShow.get(j), countLevel - 1);
            }
        }
    }

    //This method shows information about user and his/her friends and their friends in the given form

    public static void showAllFriends(User firstUser, int countLevel) {
        showUsers(firstUser);
        showUsers(firstUser, countLevel);
    }
}



