package cinemaNetwork;

public class Person extends DatabaseObject{
    private Date dateOfBirth;

    public Person(String name, int id) {
        super(name, id);
    }
}
