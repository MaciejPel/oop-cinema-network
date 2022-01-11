package cinemaNetwork;

public class Row<rowNumber, numberOfSeats> {
    private rowNumber rowNumber;
    private numberOfSeats numberOfSeats;
    public Row(rowNumber rowNumber, numberOfSeats numberOfSeats){
        this.rowNumber = rowNumber;
        this.numberOfSeats = numberOfSeats;
    }
    public rowNumber getRowNumber(){ return rowNumber; }
    public numberOfSeats getNumberOfSeats(){ return numberOfSeats; }
    public void setL(rowNumber rowNumber){ this.rowNumber = rowNumber; }
    public void setR(numberOfSeats numberOfSeats){ this.numberOfSeats = numberOfSeats; }
}
