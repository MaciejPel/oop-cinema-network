package cinemaNetwork;

public class Employee extends Person{
    private typeOfPosition position;

    public Employee(String name, int id, typeOfPosition position) {
        super(name, id);
        this.position = position;
    }

    public typeOfPosition getPosition() {
        return position;
    }

    public void setPosition(typeOfPosition position) {
        this.position = position;
    }
}
