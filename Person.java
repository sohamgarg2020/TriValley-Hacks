public class Person {
    private String name;
    private boolean isdriver;
    private int contactnum;
    private int numseats;
    private Location startloc;
    public Person(String nam, boolean isdri, int contact, int seats, Location l){
        name = nam;
        isdriver = isdri;
        contactnum = contact;
        numseats = seats;
        startloc = l;
    }
    public int getX(){
        return startloc.getX();
    }
    public int getY(){
        return startloc.getY();
    }
    

}
