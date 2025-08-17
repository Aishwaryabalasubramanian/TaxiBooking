import java.util.List;

public class Taxi {
    private int taxId;
    private Station currentLocation;
    private int nextFreeTime;
    private int earnings;

    public Station getCurrentLocation() {
        return currentLocation;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public int getNextFreeTime() {
        return nextFreeTime;
    }

    public void setCurrentLocation(Station currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setNextFreeTime(int nextFreeTime) {
        this.nextFreeTime = nextFreeTime;
    }

    public int getTaxId() {
        return taxId;
    }

    public int getEarnings() {
        return earnings;
    }

    public Taxi(int taxId, Station currentLocation, int nextFreeTime, int earnings) {
        this.taxId = taxId;
        this.currentLocation = currentLocation;
        this.nextFreeTime = nextFreeTime;
        this.earnings = earnings;
    }
}
