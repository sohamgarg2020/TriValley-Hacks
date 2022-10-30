public class Person {
    private String name;
    
    private boolean isdriver;
    
    private double contactnum;

    private int numseats;
    
    private Location startloc;

    private Location destin;
    
    public Person(String nam, boolean isdri, double contact, int seats, Location l, Location d){
        name = nam;
        isdriver = isdri;
        contactnum = contact;
        numseats = seats;
        startloc = l;
        destin = d;
    }
    public int getX(){
        return startloc.getX();
    }
    public int getY(){
        return startloc.getY();
    }
    

}
