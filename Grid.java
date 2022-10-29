import java.io.*;
import java.util.*;
public class Grid {
    static BufferedReader br;
    static PrintWriter pw;
    static Person driver;
    static ArrayList<Person> passengers;
    static Person[][] grid;
    public static void main(String args[]) throws IOException{
        grid = new Person[20][20];
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        pw.println("Enter driver name: ");
        String drivername = br.readLine();
        pw.println("Enter contact number: ");
        int contactnum = Integer.parseInt(br.readLine());
        pw.println("Enter the number of free seats in your car: ");
        int numseats = Integer.parseInt(br.readLine());
        pw.println("Enter the x coordinate of your location: ");
        int driverx = Integer.parseInt(br.readLine());
        pw.println("Enter the y coordinate of your location: ");
        int drivery = Integer.parseInt(br.readLine());
        driver = new Person(drivername, true, contactnum, numseats, new Location(driverx, drivery));
        grid[driverx][drivery] = driver;
        pw.println("Enter the number of passengers: ");
        int passengersnum = Integer.parseInt(br.readLine());
        passengers = new ArrayList<Person>();
        for (int i = 0; i<passengersnum; i++){
            pw.println("Enter passenger name: ");
            String passengername = br.readLine();
            pw.println("Enter contact number: ");
            int contact = Integer.parseInt(br.readLine());
            pw.println("Enter the x coordinate of your location: ");
            int passengerx = Integer.parseInt(br.readLine());
            pw.println("Enter the y coordinate of your location: ");
            int passengery = Integer.parseInt(br.readLine());
            Person passenger = new Person(passengername, false, contactnum, 0, new Location(passengerx, passengery));
            passengers.add(passenger);
            grid[passengerx][passengery] = passenger;
        }

        

        br.close();
        pw.close();
    }
}
