package cinemaNetwork;

public abstract class Person extends DatabaseObject{
    private Date dateOfBirth;

    public Person(String name) {
        super(name);
    }
}
