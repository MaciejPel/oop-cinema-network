package cinemaNetwork;

public class Filmmaker extends Person{
    private Country origin;
    private typeOfRole defaultRole;

    public Filmmaker(String name, Date dateOfBirth, Country origin, typeOfRole defaultRole) {
        super(name, dateOfBirth);
        this.origin = origin;
        this.defaultRole = defaultRole;
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

    @Override
    public String typeInfo() {
        return "Filmmaker, role: "+this.defaultRole.getName();
    }

    @Override
    public String toString(){
        return "[\n\tID: "+ this.getId() + "\n\tType: " + this.getClass().getSimpleName() + "\n\tName: " + this.getName()+ "\n\tOrigin: " +this.getOrigin()+ "\n\tDefault Role: " +this.getDefaultRole()+"\n]";
    }
}
