package cinemaNetwork;

public enum typeOfRole {
    Director("Director", 1),
    Actor("Actor", 2),
    Screenwriter("Screenwriter", 3),
    Score_Composer("Score Composer", 4);

    private String displayName;
    private int indexNumber;

    typeOfRole(String displayName, int indexNumber) {
        this.displayName = displayName;
        this.indexNumber = indexNumber;
    }

    public String displayName() { return displayName; }

    public int getByIndex() {
        return indexNumber;
    }

    public static typeOfRole retrieveByIndex(int n) {
        for (typeOfRole role : typeOfRole.values()) {
            if (role.getByIndex() == n) {
                return role;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "\t" + indexNumber + ". " + displayName;
    }
}
