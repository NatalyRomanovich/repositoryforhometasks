package by.nat.homework3.test;

import by.nat.homework3.domain.User;
import by.nat.homework3.util.CreateUsers;
import by.nat.homework3.util.OtherCreateUser;

public class TestUser {

    public static void main(String[] args) {

        //Create user with given name and with him friendList

        User userWithFirstPersonName = CreateUsers.getUser(CreateUsers.FIRST_PERSONS_NAME, CreateUsers.NUMBER_OF_LEVEL);
        //Show user normally
        System.out.println(userWithFirstPersonName);

        //Show user and his/her friends and their friends in the given form
        CreateUsers.showAllFriends(userWithFirstPersonName, CreateUsers.NUMBER_OF_LEVEL);

    }

}
