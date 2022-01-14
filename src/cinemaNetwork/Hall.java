package cinemaNetwork;
import java.util.List;

public class Hall extends DatabaseObject{
    private typeOfHall type;
    List<Row<Integer, Integer>> listOfSeats;

    public Hall(String name, typeOfHall type, List<Row<Integer, Integer>> listOfSeats) {
        super(name);
        this.type = type;
        this.listOfSeats = listOfSeats;
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

    public String toString(){
        String s= "[\n\tID: "+ this.getId() + "\n\tType: " + this.getClass().getSimpleName() + "\n\tName: " + this.getName() + "\n\tType of hall: " + this.getType().getName() + "\n\tList of seats: [";
        for(Row i : this.listOfSeats){
            s+= "Row "+i.getRowNumber()+"- "+i.getNumberOfSeats()+", ";
        }
        s+="]\n]";
        return s;
    }
}
