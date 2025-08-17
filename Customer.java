import java.util.Scanner;

public class Customer {
    private  int customerId=0;
    private Station pickup;
    private Station drop;
    private int pickupTime;
    private Scanner sc;

    public Customer(Scanner sc) {
        this.sc=sc;
    }
    public Customer(int customerId,Station pickup,Station drop,int pickupTime){
        this.customerId=customerId;
        this.pickup=pickup;
        this.drop=drop;
        this.pickupTime=pickupTime;

    }

    public Station getPickup() {
        return pickup;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public Station getDrop() {
        return drop;
    }

    public Customer bookTaxi() {

        ++customerId;

        System.out.print("\nPickup Point:");
        Station pickup=Station.valueOf(sc.next().toUpperCase());

        System.out.print("\nDrop Point:");
        Station drop=Station.valueOf(sc.next().toUpperCase());

        int pickupTime = getTime();
        if(pickupTime<0){
            System.out.print("\n Invalid time.Try Again");
            getTime();

        }
        return (new Customer(++customerId,pickup,drop,pickupTime));


    }


    private int getTime() {

        System.out.print("\nPickup Time:");
        int time = sc.nextInt();
        if(time>=0 && time<=24){
            return time;
        }
        return -1;

    }
}
