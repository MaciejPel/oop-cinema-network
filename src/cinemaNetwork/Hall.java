package cinemaNetwork;
import java.util.List;

public class Hall extends DatabaseObject{
    private int numberOfSeats;
    private typeOfHall type;
    List<Pair<Integer, Integer>> listOfLists;

    public Hall(String name, int numberOfSeats, typeOfHall type, List<Pair<Integer, Integer>> listOfLists) {
        super(name);
        this.numberOfSeats = numberOfSeats;
        this.type = type;
        this.listOfLists = listOfLists;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public typeOfHall getType() {
        return type;
    }

    public void setType(typeOfHall type) {
        this.type = type;
    }

    public List<Pair<Integer, Integer>> getListOfLists() {
        return listOfLists;
    }

    public void setListOfLists(List<Pair<Integer, Integer>> listOfLists) {
        this.listOfLists = listOfLists;
    }
}
