import java.util.concurrent.Semaphore;

public class FuelStation {

    private final Semaphore semaphore;

    public FuelStation() {
        semaphore = new Semaphore(3, true);
    }

    public void refuel(String name) {
        System.out.println(String.format("[%s] arrived at the fuel Station", name));
        try {
            semaphore.acquire();
            System.out.println(String.format("[%s] is refueling now ... ", name));
            Thread.sleep(5000);
            System.out.println(String.format("[%s] is done and left the station. ", name));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();

    }
}
