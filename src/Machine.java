public class Machine implements Runnable {
    private final String name;
    private float fuelVolume;
    private final float consumption;
    private final FuelStation fuelStation;

    public Machine(String name, float fuelVolume, float consumption, FuelStation fuelStation) {
        this.fuelVolume = fuelVolume;
        this.consumption = consumption;
        this.name = name;
        this.fuelStation = fuelStation;
    }


    @Override
    public void run() {
        System.out.println(String.format("[%s] is ready to ride", name));
        while (fuelVolume > consumption) {
            System.out.println(String.format("[%s] is driving and has %s fuel reserve", name, fuelVolume));
            try {
                Thread.sleep(3000);
                fuelVolume -= consumption;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(String.format("[%s] Fuel is running out...", name));
        fuelStation.refuel(name);
    }

}
