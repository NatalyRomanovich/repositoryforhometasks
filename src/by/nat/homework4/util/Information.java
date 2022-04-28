package by.nat.homework4.util;

import by.nat.homework4.demo.CallCentreWork;
import by.nat.homework4.domain.Client;

import java.util.Random;
import java.util.ResourceBundle;

public class Information {
    public static final String FILE_NAME_OPERATORS = "application_operators";
//get information from ResourceBundle files

    //get information about operator's names
    public static String[] getInformation(String key) {

        String operatorsName = ResourceBundle.getBundle(FILE_NAME_OPERATORS).getString(key);
        String[] operatorsNamesList = operatorsName.split(",");

        for (int i = 0; i < operatorsNamesList.length; i++)
            operatorsNamesList[i] = operatorsNamesList[i].trim(); //remove spaces from a string

        return operatorsNamesList;
    }

    //get information of type Integer
    public static Integer getInformation(String fileName, String key) {

        String parameter = ResourceBundle.getBundle(fileName).getString(key);

        String parameterWithoutSpace = parameter.replaceAll("\\s", "");  //remove spaces from a string

        Integer parameterValue = Integer.parseInt(parameterWithoutSpace); //convert information to Integer type
        return parameterValue;
    }

    //generate random according to the maximum and minimum value specified in ResourceBundle files
    public static Integer getRandomValue(String fileName, String keyMaxNumber, String keyMinNumber) {
        Integer maxNumber = getInformation(fileName, keyMaxNumber);
        Integer minNumber = getInformation(fileName, keyMinNumber);

        int randomValue = new Random().nextInt(maxNumber - minNumber) + minNumber;

        return randomValue;
    }

}
