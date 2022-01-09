package cinemaNetwork;

public class Filmmaker extends Person{
    private Country origin;
    private typeOfRole defaultRole;

    public Filmmaker(String name, Country origin, typeOfRole defaultRole) {
        super(name);
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
}
