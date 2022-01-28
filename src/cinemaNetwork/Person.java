package cinemaNetwork;

public abstract class Person extends DatabaseObject{
    private Date dateOfBirth;

    public abstract boolean isAdult();

    public Person(String name, Date dateOfBirth) {
        super(name);
        this.dateOfBirth= dateOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
