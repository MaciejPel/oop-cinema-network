package cinemaNetwork;
import java.util.ArrayList;

public class Cinema extends DatabaseObject{
    private String address;
    private ArrayList<Employee> employees;
    private ArrayList<Hall> halls;
    private ArrayList<Seance> seances;
    private int phone;

    public Cinema(String name, String address, ArrayList<Employee> employees, ArrayList<Hall> halls, ArrayList<Seance> seances, int phone) {
        super(name);
        this.address = address;
        this.employees = employees;
        this.halls = halls;
        this.seances = seances;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Hall> getHalls() {
        return halls;
    }

    public void setHalls(ArrayList<Hall> halls) {
        this.halls = halls;
    }

    public ArrayList<Seance> getSeances() {
        return seances;
    }

    public void setSeances(ArrayList<Seance> seances) {
        this.seances = seances;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
