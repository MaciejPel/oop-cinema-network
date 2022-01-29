package cinemaNetwork;

public enum Country {
    France("France", 1),
    Poland("Poland", 2),
    USA("USA", 3),
    Russia("Russia", 4);

    private String displayName;
    private int indexNumber;

    Country(String displayName, int indexNumber) {
        this.displayName = displayName;
        this.indexNumber = indexNumber;
    }

    public String getName() { return displayName; }

    public int getIndex() { return indexNumber; }

    public static Country retrieveByIndex(int n) {
        for (Country country : Country.values()) {
            if (country.getIndex() == n) {
                return country;
            }
        }
        return null;
    }
}