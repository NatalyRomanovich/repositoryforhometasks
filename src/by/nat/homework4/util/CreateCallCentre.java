package by.nat.homework4.util;

import by.nat.homework4.demo.CallCentreWork;
import by.nat.homework4.domain.CallCentre;

import java.util.List;
import java.util.Random;

public class CreateCallCentre {

    public static final String CALL_TIME = "callTime";
    public static final String FILE_NAME_CALL_CENTRE = "application_call_centre";
    public static final String OPERATORS_NUMBER = "operatorsNumber";
    public static final String CALL_CENTRE_CAPACITY = "callCentreCapacity";
    public static final String BREAKS_BETWEEN_OPERATOR_ACTIVATIONS = "breaksBetweenOperatorsActivations";
    public static final String MAX_BREAK_TIME = "maxBreakTime";
    public static final String MIN_BREAK_TIME = "minBreakTime";

    //create call centre
    public static CallCentre createCallCentre() {

        List operatorCallCentreList = GeneratorOperators.createOperatorsList();
        List clientsCallCentreList = GeneratorClients.createClientsList();

       CallCentre callCentre = new CallCentre(Information.getInformation(FILE_NAME_CALL_CENTRE, CALL_CENTRE_CAPACITY),
                Information.getInformation(FILE_NAME_CALL_CENTRE, OPERATORS_NUMBER),
                operatorCallCentreList,
                clientsCallCentreList);

        return callCentre;
    }

    //create random call time between customer calls
    public static int customerCalls(CallCentre callCentre) {

        int breakBetweenCustomerCalls = Information.getRandomValue(FILE_NAME_CALL_CENTRE, MAX_BREAK_TIME, MIN_BREAK_TIME);

        return breakBetweenCustomerCalls;
    }

    //create time of call centre working
    public static int timeCallCentreWorking(CallCentre callCentre) {

        int timeWorking = Information.getInformation(FILE_NAME_CALL_CENTRE, BREAKS_BETWEEN_OPERATOR_ACTIVATIONS);

        int callsInCallCentreNumber = Information.getInformation(GeneratorClients.FILE_NAME_CLIENTS,
                GeneratorClients.CLIENTS_NUMBER);

        for (int i = 0; i < callsInCallCentreNumber; i++) {

            timeWorking += callCentre.getClients().get(i).getIssueResolutionTime();
        }
        return timeWorking;
    }
}
