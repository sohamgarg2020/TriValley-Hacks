import java.awt.Dimension;
import java.io.*;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
public class Grid{
    static BufferedReader br;
    static PrintWriter pw;
    static Person driver;
    static ArrayList<Person> passengers;
    static ArrayList<Location> locs;
    static Person[][] grid;
    static String order;

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
                    order = i + " " + j + " " + z;
                }
                
            }
        }
        return minimum;
    }
    public static void main(String args[]) throws IOException{
        locs = new ArrayList<Location>();
        grid = new Person[20][20];
        ImageIcon img = new ImageIcon("./soham.png");
        JLabel label = new JLabel();
        label.setText("soham owes me");
        label.setIcon(img);
      
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.add(label);
        frame.setVisible(true);

        String drivername = JOptionPane.showInputDialog(null,"Enter name");
        double contactnum = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter contact number: "));
        int numseats = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the number of free seats in your car: "));
        int driverx = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the x coordinate of your location: "));
        int drivery = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the y coordinate of your location: "));
        int destinationdriverx = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the x coordinate of your destination: "));
        int destinationdrivery = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the y coordinate of your destination: "));
        driver = new Person(drivername, true, contactnum, numseats, new Location(driverx, drivery), new Location(destinationdriverx, destinationdrivery));
        locs.add(new Location(driverx, drivery));
        grid[driverx][drivery] = driver;
        frame.setVisible(false);
        frame.dispose();
        passengers = new ArrayList<Person>();
        int passengersnum = numseats;
        


        for (int i = 0; i<passengersnum; i++){
            ImageIcon imge = new ImageIcon("./passenger" + i + ".png");
            JLabel labele = new JLabel();
            labele.setText("soham owes me");
            labele.setIcon(imge);
      
            JFrame framee = new JFrame();
            framee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            framee.setSize(800,800);
            framee.add(labele);
            framee.setVisible(true);

            String passengername = JOptionPane.showInputDialog(null,"Enter name");
            double contact = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter contact number: "));
            int passengerx = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the x coordinate of your location: "));
            int passengery = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the y coordinate of your location: "));
            Person passenger = new Person(passengername, false, contact, 0, new Location(passengerx, passengery), new Location(destinationdriverx, destinationdrivery));
            framee.setVisible(false);
            framee.dispose();
            locs.add(new Location(passengerx, passengery));
            passengers.add(passenger);
            grid[passengerx][passengery] = passenger;
        }
        locs.add(new Location(destinationdriverx, destinationdrivery));

        JLabel labele = new JLabel();
        labele.setText("The order to pick up the drivers are " + passengers.get(0).getName() + ", " + passengers.get(1).getName() + ", " + passengers.get(2).getName() + ".\n " + "The total distance to travel would be " + getSmallestDistance(locs) + " miles.");
      
        JFrame framee = new JFrame();
        framee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framee.setSize(800,100);
        framee.add(labele);
        framee.setVisible(true);
    }
}
