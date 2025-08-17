import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n= 4;
        List<Taxi> taxiList = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            Taxi taxi = new Taxi(i,Station.A,6,0);
            taxiList.add(taxi);


        }
        Scanner sc = new Scanner(System.in);
        System.out.print("\nTaxi Booking Application");
        boolean isRunning=true;
        while (isRunning){
            System.out.println("\n1.Book Taxi\n2.Display Taxi Details\n3.Exit");
            int choice = sc.nextInt();
            switch (choice){
                case  1:
                    Customer customer=new Customer(sc);
                    TaxiBooking taxiBooking= new TaxiBooking(sc,taxiList);
                    taxiBooking.allotTaxi(customer.bookTaxi());
                    break;

                case 2:
                    taxiBooking.displayBookings();
                case 3 :
                    isRunning=false;
                    sc.close();
            }
        }
    }
}