package cinemaNetwork;
import java.util.List;

public class Hall extends DatabaseObject{
    private typeOfHall type;
    List<Row<Integer, Integer>> listOfLists;

    public Hall(String name, typeOfHall type, List<Row<Integer, Integer>> listOfLists) {
        super(name);
        this.type = type;
        this.listOfLists = listOfLists;
    }

    public typeOfHall getType() {
        return type;
    }

    public void setType(typeOfHall type) {
        this.type = type;
    }

    public List<Row<Integer, Integer>> getListOfLists() {
        return listOfLists;
    }

    public void setListOfLists(List<Row<Integer, Integer>> listOfLists) {
        this.listOfLists = listOfLists;
    }
}
