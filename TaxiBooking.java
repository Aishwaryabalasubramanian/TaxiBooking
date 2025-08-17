import javax.xml.ws.soap.MTOM;
import java.util.*;

public class TaxiBooking {

    Scanner sc;
    private  int bookingId=0;
    int earning,totalEarning;
    Customer customer;
    private List<Taxi> taxiList;
    private  Map<Integer,TaxiBooking> bookingMap=new HashMap<>();
    public TaxiBooking(Scanner sc, List<Taxi> taxiList) {
        this.sc=sc;
        this.taxiList= taxiList;
    }
    private TaxiBooking(Customer customer,int earning,int totalEarning){
        this.customer=customer;
        this.earning=earning;
        this.totalEarning=totalEarning;



    }

    public void bookTaxi() {

    }


    private Taxi findNearestTaxies(Station pickup,int time) {

        Taxi availableTaxi=null;
        int min =Integer.MAX_VALUE;
        int minEarning=Integer.MAX_VALUE;
        for (Taxi taxi : taxiList){
            if(taxi.getNextFreeTime()<=time && min>=Math.abs(pickup.compareTo(taxi.getCurrentLocation())) && minEarning>=taxi.getEarnings()){
                min=Math.abs(pickup.compareTo(taxi.getCurrentLocation()));
                minEarning= taxi.getEarnings();
                availableTaxi=taxi;

            }
        }
        return availableTaxi;

    }

    public void allotTaxi(Customer customer) {
        Taxi freeTaxi = findNearestTaxies(customer.getPickup(),customer.getPickupTime());
        if(freeTaxi==null){
            System.out.print("\nNo Taxi Available. Booking Cancelled");
        }
        else {
            System.out.print("\nTaxi Can Be Allocated\nTaxi "+freeTaxi.getTaxId()+ " Is Allocated\n");
            freeTaxi.setCurrentLocation(customer.getDrop());
            int between = Math.abs(customer.getPickup().compareTo(customer.getDrop()));
            freeTaxi.setNextFreeTime(customer.getPickupTime()+between);
            int earningForRide=calculateEarning(between);
            freeTaxi.setEarnings(freeTaxi.getEarnings()+earningForRide);
            bookingMap.put(++bookingId,new TaxiBooking(customer, freeTaxi.getEarnings(), earningForRide));

        }
    }



    private int calculateEarning(int between) {
        int distanceTravelled = between*15;
        return 100+(distanceTravelled-5)*10;
    }


}
