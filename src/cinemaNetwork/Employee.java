package cinemaNetwork;

public class Employee extends Person{
    private typeOfPosition position;

    public Employee(String name, typeOfPosition position, Date dateOfBirth) {
        super(name ,dateOfBirth);
        this.position = position;
    }

    public typeOfPosition getPosition() {
        return position;
    }

    public void setPosition(typeOfPosition position) {
        this.position = position;
    }
}
