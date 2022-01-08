package cinemaNetwork;
import java.util.ArrayList;

public class Cinema extends DatabaseObject{
    private String address;
    private ArrayList<Employee> employees;
    private ArrayList<Seance> seances;
    private ArrayList<Hall> halls;
    private int phone;


    public Cinema(String name, int id) {
        super(name, id);
    }
}
