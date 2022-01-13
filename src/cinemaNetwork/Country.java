package cinemaNetwork;

public enum Country {
    France("France", 1),
    Germany("Germany", 2),
    Italy("Italy", 3),
    Netherlands("Netherlands", 4),
    Poland("Poland", 5),
    Spain("Spain", 6),
    Sweden("Sweden", 7),
    Turkey("Turkey", 8),
    USA("USA", 9),
    Russia("Russia", 10);

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