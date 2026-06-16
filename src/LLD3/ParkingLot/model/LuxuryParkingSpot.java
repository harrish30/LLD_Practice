package LLD3.ParkingLot.model;

public class LuxuryParkingSpot extends ParkingSpot{
    private String guard;

    public LuxuryParkingSpot() {
    }

    public LuxuryParkingSpot(String guard) {
        this.guard = guard;
    }

    public String getGuard() {
        return guard;
    }

    public void setGuard(String guard) {
        this.guard = guard;
    }
}
