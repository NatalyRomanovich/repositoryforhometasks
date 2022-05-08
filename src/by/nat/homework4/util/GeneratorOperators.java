package by.nat.homework4.util;

import by.nat.homework4.domain.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorOperators {
    public static final String OPERATORS_NAMES_KEY = "operatorsNames";

    //create List of operators
    static List createOperatorsList() {

        List<Operator> operatorsList = new ArrayList<>();

        int operatorsListSize = Information.getInformation(CreateCallCentre.FILE_NAME_CALL_CENTRE,
                CreateCallCentre.OPERATORS_NUMBER);

        for (int i = 0; i < operatorsListSize; i++) {

            operatorsList.add(createOperator(i));
        }
        return operatorsList;
    }

    //create each operator
    static Operator createOperator(int operatorsIndex) {

        String[] operatorsNamesList = Information.getInformation(OPERATORS_NAMES_KEY);
        Operator operator = new Operator(operatorsNamesList[operatorsIndex], isOperatorSkilled());

        return operator;
    }

    //To evaluate the experience of the operator, a 5-point scale is used
    //If the level of the operator exceeds 4 (testPoint), the operator is considered skilled, if less - not skilled
    public static boolean isOperatorSkilled() {

        boolean skill = true;

        int maxPointSkills = 5;
        int minPointSkills = 1;
        int testPoint = 4;

        int operatorsSkill = new Random().nextInt((maxPointSkills - minPointSkills) + 1) + minPointSkills;

        if (operatorsSkill < testPoint) {
            skill = false;
        }
        return skill;
    }
}
