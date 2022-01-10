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

    public String displayName() { return displayName; }

    public int getByIndex() {
        return indexNumber;
    }

    public static typeOfHall retrieveByIndex(int n) {
        for (typeOfHall hall : typeOfHall.values()) {
            if (hall.getByIndex() == n) {
                return hall;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "\t" + indexNumber + ". " + displayName;
    }
}
