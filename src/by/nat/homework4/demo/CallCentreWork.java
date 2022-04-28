
package by.nat.homework4.demo;

import by.nat.homework4.domain.CallCentre;
import by.nat.homework4.domain.Client;
import by.nat.homework4.util.CreateCallCentre;
import by.nat.homework4.util.CreateThreads;
import by.nat.homework4.util.Information;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class CallCentreWork {

    public static BlockingQueue<Client> clientsQueue =
            new ArrayBlockingQueue<>(Information.getInformation
                    (CreateCallCentre.FILE_NAME_CALL_CENTRE, CreateCallCentre.OPERATORS_NUMBER));

    public static void main(String[] args) throws InterruptedException {
        CallCentre callCentre = CreateCallCentre.createCallCentre();

        System.out.println("Call center starts working");

        //starting threads of operators, clients and call center
        CreateThreads.generateExecutorOperators();
        CreateThreads.generateExecutorClients(callCentre);
        CreateThreads.generateCallCentreThread(callCentre);

        System.out.println("Call center closes");
    }
}



