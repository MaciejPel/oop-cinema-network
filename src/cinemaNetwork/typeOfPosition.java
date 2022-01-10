package cinemaNetwork;

public enum typeOfPosition {
    manager("Manager", 1),
    ticket_seller("Ticket Seller", 2),
    janitor("Janitor", 3);

    private String displayName;
    private int indexNumber;

    typeOfPosition(String displayName, int indexNumber) {
        this.displayName = displayName;
        this.indexNumber = indexNumber;
    }

    public String displayName() { return displayName; }

    public int getByIndex() {
        return indexNumber;
    }

    public static typeOfPosition retrieveByIndex(int n) {
        for (typeOfPosition position : typeOfPosition.values()) {
            if (position.getByIndex() == n) {
                return position;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "\t" + indexNumber + ". " + displayName;
    }
}
