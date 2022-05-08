package by.nat.homework4.domain;

import by.nat.homework4.util.GeneratorClients;
import by.nat.homework4.util.Information;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Operator implements Runnable {

    private String nameOperator;
    private boolean isSkilled;
    private volatile boolean isBusy;
    private BlockingQueue<Client> clientsQueue;

    public Operator() {
    }

    public Operator(String nameOperator, boolean isSkilled, BlockingQueue<Client> clientsQueue) {
        this.nameOperator = nameOperator;
        this.isSkilled = isSkilled;
        this.isBusy = false;
        this.clientsQueue = CallCentre.getClientsQueue();

    }

    // operator's work description
    @Override
    public void run() {
        System.out.println(getNameOperator() + " started work");

        while (true) {
            try {
                Client clientServedQueue = clientsQueue.take();

                if (isEndingWork(clientServedQueue)) {
                    System.out.println(getNameOperator() + " finished work");
                    return;

                } else if (isNotEmptyQueue(clientServedQueue)) {
                    servedClients(clientServedQueue);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }

    // condition of operator's end of working - receiving "POISON_PILL"
    //"POISON_PILL" is special null object,
    //which is a signal that the client queue is empty and operators can finish the job
    public boolean isEndingWork(Client clientServedQueue) {
        boolean result = false;
        if (clientServedQueue.equals(Client.POISON_PILL)) {
            result = true;
        }
        return result;
    }

    // checking a pending client
    public boolean isNotEmptyQueue(Client clientServedQueue) {
        boolean result = false;
        if (clientServedQueue != null) {
            result = true;
        }
        return result;
    }

    //checking is client first
    public boolean isFirstClient(Client clientServedQueue) {
        boolean result = false;

        int idNextClient = Information.getInformation(GeneratorClients.FILE_NAME_CLIENTS,
                GeneratorClients.CLIENTS_NUMBER);

        if (clientServedQueue.getId() <= idNextClient) {
            result = true;
        }
        return result;
    }

    //show information about service each client
    public void servedClients(Client clientServedQueue) throws InterruptedException {
        if (isFirstClient(clientServedQueue)) {
            servedFirstClient(clientServedQueue);
        } else {
            servedNextClient(clientServedQueue);
        }
    }

    //show information if operator takes first client
    public void servedFirstClient(Client clientServedQueue) throws InterruptedException {

        System.out.println(getNameOperator() + " takes Client id  № " +
                clientServedQueue.getId());
        Thread.sleep(clientServedQueue.getIssueResolutionTime());
        showService(clientServedQueue);

    }

    //show information if operator takes next client
    public void servedNextClient(Client clientServedQueue) throws InterruptedException {

        System.out.println(getNameOperator() + " takes next Client id № " +
                clientServedQueue.getId());
        Thread.sleep(clientServedQueue.getIssueResolutionTime());
        showService(clientServedQueue);
    }

    //show information about served each client
    public void showService(Client clientServedQueue) {
        System.out.println(getNameOperator() + " served Client id  № " +
                clientServedQueue.getId());
    }

    public String getNameOperator() {
        return nameOperator;
    }

    public void setNameOperator(String nameOperator) {
        this.nameOperator = nameOperator;
    }

    public boolean isSkilled() {
        return isSkilled;
    }

    public void setSkilled(boolean skilled) {
        isSkilled = skilled;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public BlockingQueue<Client> getClientsQueue() {
        return clientsQueue;
    }

    public void setClientsQueue(BlockingQueue<Client> clientsQueue) {
        this.clientsQueue = clientsQueue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return isSkilled == operator.isSkilled &&
                isBusy == operator.isBusy &&
                Objects.equals(nameOperator, operator.nameOperator) &&
                Objects.equals(clientsQueue, operator.clientsQueue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOperator, isSkilled, isBusy, clientsQueue);
    }

    @Override
    public String toString() {
        return "Operator{" +
                "nameOperator='" + nameOperator + '\'' +
                ", isSkilled=" + isSkilled +
                ", isBusy=" + isBusy +
                ", clientsQueue=" + clientsQueue +
                '}';
    }
}
