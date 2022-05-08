package by.nat.homework4.util;

import by.nat.homework4.domain.Client;

import java.util.ArrayList;
import java.util.List;


public class GeneratorClients {
    public static final String FILE_NAME_CLIENTS = "application_clients";
    public static final String MIN_RESOLUTION_TIME = "minResolutionTime";
    public static final String MAX_RESOLUTION_TIME = "maxResolutionTime";
    public static final String CLIENTS_NUMBER = "clientsNumber";

    static List createClientsList() {
        List<Client> clientList = new ArrayList<>();

        for (int i = 0; i < Information.getInformation(FILE_NAME_CLIENTS, CLIENTS_NUMBER); i++) {
            clientList.add(createClient(i));
        }

        return clientList;
    }

    static Client createClient(int clientsNumber) {

        int resolutionTime = Information.getRandomValue(FILE_NAME_CLIENTS, MAX_RESOLUTION_TIME, MIN_RESOLUTION_TIME);

        Client client = new Client((++clientsNumber), resolutionTime);

        return client;
    }

}
