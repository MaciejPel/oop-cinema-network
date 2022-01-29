package cinemaNetwork;
import java.util.ArrayList;
import java.util.List;

public class Hall extends DatabaseObject{
    private typeOfHall type;
    private List<Row<Integer, Integer>> listOfSeats;
    private ArrayList<Seance> seances;

    public Hall(String name, typeOfHall type, List<Row<Integer, Integer>> listOfSeats, ArrayList<Seance> seances) {
        super(name);
        this.type = type;
        this.listOfSeats = listOfSeats;
        this.seances = seances;
    }

    public typeOfHall getType() {
        return type;
    }

    public void setType(typeOfHall type) {
        this.type = type;
    }

    public List<Row<Integer, Integer>> getListOfSeats() {
        return listOfSeats;
    }

    public void setListOfSeats(List<Row<Integer, Integer>> listOfSeats) {
        this.listOfSeats = listOfSeats;
    }

    public ArrayList<Seance> getSeances() {
        return seances;
    }

    public void addSeance(Seance seance) {
        this.seances.add(seance);
    }

    public void setSeances(ArrayList<Seance> seances) {
        this.seances = seances;
    }

    @Override
    public String toString(){
        String s= "[\n\tID: "+ this.getId() + "\n\tType: " + this.getClass().getSimpleName() + "\n\tName: " + this.getName() + "\n\tType of hall: " + this.getType().getName() + "\n\tList of seats: [";
        for(Row i : this.listOfSeats){
            s+= "Row "+i.getRowNumber()+"- "+i.getNumberOfSeats()+", ";
        }
        s+="]\n\tSeances: [";
        for(Seance i: this.seances){
            s+= i.toString()+", ";
        }
        s+="]\n]";
        return s;
    }
}
