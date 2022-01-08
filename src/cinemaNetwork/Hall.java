package cinemaNetwork;
import java.util.List;

public class Hall {
    private int numberOfSeats;
    private typeOfHall type;
    private List<List> seats;

    public Hall(int numberOfSeats, typeOfHall type) {
        this.numberOfSeats = numberOfSeats;
        this.type = type;
    }
}
