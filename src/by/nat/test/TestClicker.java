package by.nat.test;



public class TestClicker {
    public static void main(String[] args) throws InterruptedException {
        Clicker clicker = new Clicker();
        clicker.start();

        Thread.sleep(5000);

        clicker.stopClicking();
        clicker.join();

        System.out.println("Finish!" + clicker.getClick());
    }
}
