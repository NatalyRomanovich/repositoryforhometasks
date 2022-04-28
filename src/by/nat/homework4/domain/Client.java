package by.nat.homework4.domain;

import java.util.Objects;


public class Client implements Runnable {

    public static final Client POISON_PILL = new Client(0, 0);
    private int id;
    private int issueResolutionTime;


    public Client() {
    }

    public Client(int id, int issueResolutionTime) {
        this.id = id;
        this.issueResolutionTime = issueResolutionTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIssueResolutionTime() {
        return issueResolutionTime;
    }

    public void setIssueResolutionTime(int issueResolutionTime) {
        this.issueResolutionTime = issueResolutionTime;
    }

    //clients calling description
    @Override
    public void run() {
        try {
            Thread.sleep(getIssueResolutionTime());
            System.out.println("Client id №" + getId() + " dialing the call center number");

        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && issueResolutionTime == client.issueResolutionTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, issueResolutionTime);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", issueResolutionTime=" + issueResolutionTime +
                '}';
    }
}

