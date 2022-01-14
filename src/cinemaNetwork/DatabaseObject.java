package cinemaNetwork;

import java.text.SimpleDateFormat;

public abstract class DatabaseObject {
    private int id;
    private String name;
    private Date creationDate;
    private static int idNumerator = 1;


    public DatabaseObject(String name) {
        this.id = idNumerator;
        this.name = name;
        java.util.Date temp= new java.util.Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String[] x=formatter.format(temp).split("-");
        this.creationDate = new Date(Integer.parseInt(x[0]), Integer.parseInt(x[1]),Integer.parseInt(x[2]),Integer.parseInt(x[3]),Integer.parseInt(x[4]));
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
