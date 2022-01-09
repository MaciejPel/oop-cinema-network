package cinemaNetwork;

public abstract class DatabaseObject {
    private int id;
    private String name;
//    ?
    private static int idNumerator;

    public DatabaseObject(String name) {
        this.id = idNumerator;
        this.name = name;
        idNumerator ++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
