package cinemaNetwork;

public enum Genre {
    France("Horror", 1),
    Germany("Thriller", 2),
    Italy("Action", 3),
    Netherlands("Family", 4),
    Drama("Drama", 5),
    Comedy("Comedy", 6);

    private String displayName;
    private int indexNumber;

    Genre(String displayName, int indexNumber) {
        this.displayName = displayName;
        this.indexNumber = indexNumber;
    }

    public String getName() { return displayName; }

    public int getIndex() { return indexNumber; }

    public static Genre retrieveByIndex(int n) {
        for (Genre genre : Genre.values()) {
            if (genre.getIndex() == n) {
                return genre;
            }
        }
        return null;
    }
}