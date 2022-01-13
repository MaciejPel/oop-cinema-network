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

    public String getName() { return displayName; }

    public int getIndex() {
        return indexNumber;
    }

    public static typeOfPosition retrieveByIndex(int n) {
        for (typeOfPosition position : typeOfPosition.values()) {
            if (position.getIndex() == n) {
                return position;
            }
        }
        return null;
    }
}
