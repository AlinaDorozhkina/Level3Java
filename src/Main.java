import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        FuelStation fuelStation = new FuelStation();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Machine[] machines = {
                new Car("Toyota", fuelStation),
                new Car("BMW", fuelStation),
                new Car("Audi", fuelStation),
                new Truck("Foton", fuelStation),
                new Truck("Kamaz", fuelStation),
                new Truck("Volvo FH12", fuelStation),
                new Truck("ZIL 4505", fuelStation),
                new Bus("MAN Lion", fuelStation),
                new Bus("Volvo 7900", fuelStation)
        };
        for (Machine m : machines) {
            executorService.execute(m);
        }
        executorService.shutdown();

    }
}
