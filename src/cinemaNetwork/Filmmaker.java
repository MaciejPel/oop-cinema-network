package cinemaNetwork;

import java.util.Calendar;

public class Filmmaker extends Person{
    private Country origin;
    private typeOfRole defaultRole;

    public Filmmaker(String name, Date dateOfBirth, Country origin, typeOfRole defaultRole) {
        super(name, dateOfBirth);
        this.origin = origin;
        this.defaultRole = defaultRole;
    }

    public boolean isAdult(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int x=this.getDateOfBirth().getYear()-year;
        return x<18?false:true;
    }

    public Country getOrigin() {
        return origin;
    }

    public void setOrigin(Country origin) {
        this.origin = origin;
    }

    public typeOfRole getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(typeOfRole defaultRole) {
        this.defaultRole = defaultRole;
    }

    public String toString(){
        return "[\n\tID: "+ this.getId() + "\n\tType: " + this.getClass().getSimpleName() + "\n\tName: " + this.getName()+ "\n\tOrigin: " +this.getOrigin()+ "\n\tDefault Role: " +this.getDefaultRole()+"\n]";
    }
}
