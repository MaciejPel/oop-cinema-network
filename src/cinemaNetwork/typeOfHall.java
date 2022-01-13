package cinemaNetwork;

public enum typeOfHall {
    IMAX("IMAX", 1),
    STANDARD("Standard", 2),
    REAL_3D("Real 3D", 3);

    private String displayName;
    private int indexNumber;

    typeOfHall(String displayName, int indexNumber) {
        this.displayName = displayName;
        this.indexNumber = indexNumber;
    }

    public String getName() { return displayName; }

    public int getIndex() { return indexNumber; }

    public static typeOfHall retrieveByIndex(int n) {
        for (typeOfHall hall : typeOfHall.values()) {
            if (hall.getIndex() == n) {
                return hall;
            }
        }
        return null;
    }
}
