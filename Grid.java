import java.io.*;
import java.util.*;
public class Grid {
    static BufferedReader br;
    static PrintWriter pw;
    static Person driver;
    static ArrayList<Person> passengers;
    static ArrayList<Location> locs;
    static Person[][] grid;

    static int factorial(int n){
        if (n == 1){
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }

    static int getSmallestDistance(ArrayList<Location> sample){
        int[] xStuff = new int[sample.size()];
        int[] yStuff = new int[sample.size()];

        for (int i = 0; i < sample.size(); i++){
            xStuff[i] = sample.get(i).getXValue();
            yStuff[i] = sample.get(i).getYValue();
        }

        Location starting = sample.get(0);
        Location ending = sample.get(sample.size()-1);
        int sum = 0;
        int minimum = Integer.MAX_VALUE;
        for (int i = 1; i < 4; i++){
            for (int j = 1; j < 4; j++){
                sum = 0;
                if (j == i){
                    continue;
                }
                int z = 1+2+3-j-i;
                sum += Math.abs(starting.getXValue() - sample.get(i).getXValue()) + Math.abs(sample.get(i).getXValue() - sample.get(j).getXValue()) + Math.abs(sample.get(j).getXValue() - sample.get(z).getXValue()) + Math.abs(sample.get(z).getXValue() - ending.getXValue());
                sum += Math.abs(starting.getYValue() - sample.get(i).getYValue()) + Math.abs(sample.get(i).getYValue() - sample.get(j).getYValue()) + Math.abs(sample.get(j).getYValue() - sample.get(z).getYValue()) + Math.abs(sample.get(z).getYValue() - ending.getYValue());
                if (sum < minimum){
                    minimum = sum;
                    
                }
                
            }
        }
        return minimum;
    }
    public static void main(String args[]) throws IOException{
        locs = new ArrayList<Location>();
        grid = new Person[20][20];
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter driver name: ");
        String drivername = br.readLine();
        System.out.println("Enter contact number: ");
        double contactnum = Double.parseDouble(br.readLine());
        System.out.println("Enter the number of free seats in your car: ");
        int numseats = Integer.parseInt(br.readLine());
        System.out.println("Enter the x coordinate of your location: ");
        int driverx = Integer.parseInt(br.readLine());
        System.out.println("Enter the y coordinate of your location: ");
        int drivery = Integer.parseInt(br.readLine());
        System.out.println("Enter the x coordinate of your destination: ");
        int destinationdriverx = Integer.parseInt(br.readLine());
        System.out.println("Enter the y coordinate of your destination: ");
        int destinationdrivery = Integer.parseInt(br.readLine());
        driver = new Person(drivername, true, contactnum, numseats, new Location(driverx, drivery), new Location(destinationdriverx, destinationdrivery));
        locs.add(new Location(driverx, drivery));
        grid[driverx][drivery] = driver;
        System.out.println("Enter the number of passengers: ");
        int passengersnum = Integer.parseInt(br.readLine());
        passengers = new ArrayList<Person>();
        for (int i = 0; i<passengersnum; i++){
            System.out.println("Enter passenger name: ");
            String passengername = br.readLine();
            System.out.println("Enter contact number: ");
            double contact = Double.parseDouble(br.readLine());
            System.out.println("Enter the x coordinate of your location: ");
            int passengerx = Integer.parseInt(br.readLine());
            System.out.println("Enter the y coordinate of your location: ");
            int passengery = Integer.parseInt(br.readLine());
            Person passenger = new Person(passengername, false, contactnum, 0, new Location(passengerx, passengery), new Location(destinationdriverx, destinationdrivery));
            locs.add(new Location(passengerx, passengery));
            passengers.add(passenger);
            grid[passengerx][passengery] = passenger;
        }
        locs.add(new Location(destinationdriverx, destinationdrivery));

        System.out.println("The smallest distance the driver has to travel is " + getSmallestDistance(locs));

        

        br.close();
    }
}
