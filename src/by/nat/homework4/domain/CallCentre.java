package by.nat.homework4.domain;

import by.nat.homework4.demo.CallCentreWork;
import by.nat.homework4.util.CreateCallCentre;
import by.nat.homework4.util.GeneratorClients;
import by.nat.homework4.util.Information;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class CallCentre implements Runnable {

    private int capacity;
    private int operatorsNumber;
    private List<Operator> operators;
    private List<Client> clients;
    private BlockingQueue<Client> clientsQueue;

    public CallCentre() {
    }

    public CallCentre(int capacity, int operatorsNumber, List<Operator> operators, List<Client> clients,
                      BlockingQueue<Client> clientsQueue) {

        this.capacity = capacity;
        this.operatorsNumber = operatorsNumber;
        this.operators = operators;
        this.clients = clients;
        this.clientsQueue = new ArrayBlockingQueue<>(Information.getInformation
                (CreateCallCentre.FILE_NAME_CALL_CENTRE, CreateCallCentre.OPERATORS_NUMBER));
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getOperatorsNumber() {
        return operatorsNumber;
    }

    public void setOperatorsNumber(int operatorsNumber) {
        this.operatorsNumber = operatorsNumber;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public BlockingQueue<Client> getClientsQueue() {
        return clientsQueue;
    }

    public void setClientsQueue(BlockingQueue<Client> clientsQueue) {
        this.clientsQueue = clientsQueue;
    }

    @Override
    public void run() {

        addClientsInQueue();
        addPoisonPill();

    }
    //adding clients to the queue

    public void addClientsInQueue() {
        int callingCustomersNumber = Information.getInformation(GeneratorClients.FILE_NAME_CLIENTS,
                GeneratorClients.CLIENTS_NUMBER);

        for (int i = 0; i < callingCustomersNumber; i++) {

            try {
                Client calledClient = clients.get(i);

                Thread.sleep(Information.getInformation(CreateCallCentre.FILE_NAME_CALL_CENTRE,
                        CreateCallCentre.CALL_TIME));

                System.out.println("Client id №" + calledClient.getId() + " called and queued up");
                clientsQueue.put(calledClient);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //adding "POISON_PILL" in queue
    //"POISON_PILL" is special null object,
    //which is a signal that the client queue is empty and operators can finish the job
    public void addPoisonPill() {
        for (int i = 0; i < getOperatorsNumber(); i++) {
            try {
                clientsQueue.put(Client.POISON_PILL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallCentre that = (CallCentre) o;
        return capacity == that.capacity &&
                operatorsNumber == that.operatorsNumber &&
                Objects.equals(operators, that.operators) &&
                Objects.equals(clients, that.clients) &&
                Objects.equals(clientsQueue, that.clientsQueue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, operatorsNumber, operators, clients, clientsQueue);
    }

    @Override
    public String toString() {
        return "CallCentre{" +
                "capacity=" + capacity +
                ", operatorsNumber=" + operatorsNumber +
                ", operators=" + operators +
                ", clients=" + clients +
                ", clientsQueue=" + clientsQueue +
                '}';
    }
}
