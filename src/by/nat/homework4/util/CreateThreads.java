package by.nat.homework4.util;

import by.nat.homework4.domain.CallCentre;
import by.nat.homework4.domain.Client;
import by.nat.homework4.domain.Operator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateThreads {

    //create executor for operator's threads
    public static void generateExecutorOperators() throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();

        int threadNumber = Information.getInformation(CreateCallCentre.FILE_NAME_CALL_CENTRE,
                CreateCallCentre.OPERATORS_NUMBER);

        for (int i = 0; i < threadNumber; i++) {

            Operator callCentreOperator = GeneratorOperators.createOperator(i);
            service.execute(callCentreOperator);

            Thread.sleep(Information.getInformation(CreateCallCentre.FILE_NAME_CALL_CENTRE,
                    CreateCallCentre.BREAKS_BETWEEN_OPERATOR_ACTIVATIONS));
        }
        service.shutdown();
    }

    //create executor for client's threads
    public static void generateExecutorClients(CallCentre callCentre) throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();

        int threadNumber = Information.getInformation(GeneratorClients.FILE_NAME_CLIENTS,
                GeneratorClients.CLIENTS_NUMBER);

        for (int i = 0; i < threadNumber; i++) {

            Client calledClient = GeneratorClients.createClient(i);
            service.execute(calledClient);
            Thread.sleep(CreateCallCentre.customerCalls(callCentre));
        }
        service.shutdown();
    }

    //create call centre's thread
    public static void generateCallCentreThread(CallCentre callCentre) throws InterruptedException {

        Thread callCentreThread = new Thread(callCentre);
        callCentreThread.start();
        Thread.sleep(CreateCallCentre.timeCallCentreWorking(callCentre));
    }
}
