public class Person {
    private String name;
    
    private boolean isdriver;
    
    private int contactnum;

    private int numseats;
    
    private Location startloc;

    private Location destin;
    
    public Person(String nam, boolean isdri, int contact, int seats, Location l, Location d){
        name = nam;
        isdriver = isdri;
        contactnum = contact;
        numseats = seats;
        startloc = l;
        destin = d;
    }
    
}
