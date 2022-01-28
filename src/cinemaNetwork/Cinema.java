package cinemaNetwork;
import java.util.ArrayList;

public class Cinema extends DatabaseObject{
    private String address;
    private ArrayList<Employee> employees;
    private ArrayList<Hall> halls;
    private int phone;

    public Cinema(String name, String address, ArrayList<Employee> employees, ArrayList<Hall> halls, int phone) {
        super(name);
        this.address = address;
        this.employees = employees;
        this.halls = halls;
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

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public ArrayList<Hall> getHalls() {
        return halls;
    }

    public void setHalls(ArrayList<Hall> halls) {
        this.halls = halls;
    }

    public void addHall(Hall hall) {
        this.halls.add(hall);
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString(){
         String s = "[\n\tID: "+ this.getId() + "\n\tType: " + this.getClass().getSimpleName() + "\n\tName: " + this.getName() + "\n\tAddress: " + this.getAddress() + "\n\tPhone: " + this.getPhone();

         s+="\n\tEmployees: [";
         for(Employee i: this.employees){
             s+= i.toString()+", ";
         }
        s+="] ";

        s+="\n\tHalls: [";
        for(Hall i: this.halls){
            s+= i.toString()+", ";
        }
        s+="]\n]";
        return s;
    }
}
