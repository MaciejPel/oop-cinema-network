package cinemaNetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cinemaNetwork {

    private static Hall getHall(){
        Scanner s = new Scanner(System.in);
        System.out.println("Hall name:");
        String i1 = s.nextLine();

        System.out.println("Select one of available hall types:");
        for (typeOfHall type: typeOfHall.values()){
            System.out.println("\t" + type.getIndex()+ ". " + type.getName());
        }
        typeOfHall i2 = typeOfHall.retrieveByIndex(s.nextInt());

        System.out.println("How many rows does hall have?");
        int j = s.nextInt();
        List<Row<Integer, Integer>> temp2 = new ArrayList<>();
        for(int i = 0; i < j; i++){
            System.out.println("Type-in number of seats for row " + (i+1));
            temp2.add(new Row((i+1), s.nextInt()));
            s.nextLine();
        }
        return new Hall(i1, i2, temp2);
    }

    private static Filmmaker getFilmmaker(){
        Scanner s = new Scanner(System.in);
        System.out.println("Filmmaker name:");
        String i1 = s.nextLine();

        System.out.println("Filmmaker date of birth [YYYY-MM-DD]:");
        String[] i5 = s.nextLine().split("-");
        Date filmmakerDate=new Date(Integer.parseInt(i5[0]), Integer.parseInt(i5[1]), Integer.parseInt(i5[2]), null, null);

        System.out.println("Select filmmaker default role:");
        for (typeOfRole type: typeOfRole.values()){
            System.out.println("\t" + type.getIndex()+ ". " + type.getName());
        }
        typeOfRole i2 = typeOfRole.retrieveByIndex(s.nextInt());

        System.out.println("Choose nationality:");
        for (Country country: Country.values()){
            System.out.println("\t" + country.getIndex()+ ". " + country.getName());
        }
        Country i3 = Country.retrieveByIndex(s.nextInt());
        s.nextLine();

        return new Filmmaker(i1, filmmakerDate, i3, i2);
    }

    public static Employee getEmployee(){
        Scanner s = new Scanner(System.in);
        System.out.println("Employee name:");
        String i1 = s.nextLine();

        System.out.println("Employee birth date [YYYY-MM-DD]:");
        String[] i2 = s.nextLine().split("-");
        Date employeeDate=new Date(Integer.parseInt(i2[0]), Integer.parseInt(i2[1]), Integer.parseInt(i2[2]), null, null);

        System.out.println("Select one of available employee positions:");
        for (typeOfPosition position : typeOfPosition.values()) {
            System.out.println("\t" + position.getIndex()+ ". " + position.getName());
        }
        typeOfPosition i3 = typeOfPosition.retrieveByIndex(s.nextInt());
        s.nextLine();

        return new Employee(i1, i3, employeeDate);
    }

    public static Movie getMovie(){
        Scanner s = new Scanner(System.in);
        System.out.println("Movie name:");
        String i1 = s.nextLine();

        System.out.println("Premiere date [YYYY-MM-DD]:");
        String[] i2 = s.nextLine().split("-");
        Date premiere=new Date(Integer.parseInt(i2[0]), Integer.parseInt(i2[1]), Integer.parseInt(i2[2]), null, null);

        System.out.println("Provide movie duration in minutes:");
        int i3 = s.nextInt();
        s.nextLine();

        return new Movie(i1, premiere, new ArrayList<>(), null, i3);
    }

    public static Seance getSeance(){
        Scanner s = new Scanner(System.in);
        System.out.println("Seance name:");
        String i1 = s.nextLine();
        System.out.println("Seance date [YYYY-MM-DD]:");
        String[] i2 = s.nextLine().split("-");
        System.out.println("Seance hour [HH:MM]:");
        String[] i3 = s.nextLine().split(":");
        Date seanceDate = new Date(Integer.parseInt(i2[0]), Integer.parseInt(i2[1]), Integer.parseInt(i2[2]), Integer.parseInt(i3[0]), Integer.parseInt(i3[1]));
        System.out.println("Ticket price:");
        int i4 = s.nextInt();
        s.nextLine();

        Hall hall= null;
        System.out.println("Add a hall? [T/N]");
        if(s.nextLine().equals("T")){
            hall=getHall();
            System.out.println("New hall added.");
        }
        Movie movie=null;
        System.out.println("Add a movie? [T/N]");
        if(s.nextLine().equals("T")){
            movie=getMovie();
            System.out.println("New movie added.");
        }
        return new Seance(i1, seanceDate, movie, hall, i4);
    }

    public static void main(String[] args) {
        ArrayList<DatabaseObject> data = new ArrayList<>();

        ArrayList<Employee> emptye  = new ArrayList<>();
        ArrayList<Hall> emptyh= new ArrayList<>();
        ArrayList<Seance> emptys= new ArrayList<>();
        ArrayList<Movie> emptym= new ArrayList<>();
        ArrayList<Filmmaker> emptya= new ArrayList<>();
        List<Row<Integer, Integer>> tempex = new ArrayList<>();
        tempex.add(new Row(1, 5));
        Hall h = new Hall("h1", typeOfHall.IMAX, tempex);
        Filmmaker f = new Filmmaker("Woźniak", new Date(2000, 3, 5, null, null), Country.France, typeOfRole.Actor);
        Movie m=new Movie("m1", new Date(2022, 11, 10,null,null), emptya, f, 150);
        data.add(h);
        data.add(f);
        data.add(m);
        data.add(new Cinema("n1", "a1", emptye, emptyh, emptys, 123456789));
        data.add(new Employee("Jacula", typeOfPosition.janitor, new Date(2000,20,10,null,null)));
        data.add(new Seance("s1", new Date(2022, 12, 20, 15, 15), m, h, 15));

        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the cinemaNetwork");
        boolean state = true;
        while (state) {
            System.out.println("Select one of listed below commands to continue" +"\nI. Add a new cinema." +"\nII. Add a new employee." +"\nIII. Add a new hall." +"\nIV. Add a new seance." +"\nV. Add a new movie." +"\nVI. Add a new filmmaker." +"\nVII. Delete element by ID." +"\nVIII. Show gathered data info." +"\nIX. Show elements of given type." +"\nX. Search for element by name." +"\nXXX. Exit program.");
            String line = s.nextLine();
            switch (line) {
                case "I" -> {
                    System.out.println("Cinema name:");
                    String i1 = s.nextLine();
                    System.out.println("Cinema address:");
                    String i2 = s.nextLine();
                    System.out.println("Cinema phone number:");
                    int nc3 = s.nextInt();
                    s.nextLine();

                    ArrayList<Hall> hall= new ArrayList<>();
                    System.out.println("Add new hall? [T/N]");
                    if(s.nextLine().equals("T")){
                        do {
                            hall.add(getHall());
                            System.out.println("New hall added. Add another one? [T/N]");
                        } while (!s.nextLine().equals("N"));
                    }
                    ArrayList<Employee> employee= new ArrayList<>();
                    System.out.println("Add new Employee? [T/N]");
                    if(s.nextLine().equals("T")){
                        do {
                            employee.add(getEmployee());
                            System.out.println("New employee added. Add another one? [T/N]");
                        } while (!s.nextLine().equals("N"));
                    }
                    ArrayList<Seance> seance= new ArrayList<>();
                    System.out.println("Add new seance? [T/N]");
                    if(s.nextLine().equals("T")){
                        do {
                            seance.add(getSeance());
                            System.out.println("New seance added. Add another one? [T/N]");
                        } while (!s.nextLine().equals("N"));
                    }
                    data.add(new Cinema(i1, i2, employee, hall, seance, nc3));
                    System.out.println("A new cinema has been added.");
                }
                case "II" -> {
                    data.add(getEmployee());
                    for(DatabaseObject i: data){
                        if(i instanceof Cinema){
                            System.out.println("\t"+i.getId()+". "+i.getName());
                        }
                    }
                    System.out.println("Type-in cinema's ID");
                    int t=s.nextInt();
                    s.nextLine();
                    System.out.println("A new employee have been added.");
                }
                case "III"->{
                    data.add(getHall());
                    for(DatabaseObject i:data){
                        if(i instanceof Cinema){
                            System.out.println("\t"+i.getId()+". "+i.getName());
                        }
                    }
                    System.out.println("Type-in cinema's ID");
                    int t=s.nextInt();
                    s.nextLine();
                    System.out.println("A new hall has been added.");
                }
                case "IV" -> {
                    data.add(getSeance());
                    for(DatabaseObject i: data){
                        if(i instanceof Cinema){
                            System.out.println("\t"+i.getId()+". "+i.getName());
                        }
                    }
                    System.out.println("Type-in cinema's ID");
                    int t=s.nextInt();
                    s.nextLine();
                    System.out.println("New seance has been added");
                }
                case "V"->{
                    data.add(getMovie());
                    for(DatabaseObject i: data){
                        if(i instanceof Seance){
                            System.out.println("\t"+i.getId()+". "+i.getName());
                        }
                    }
                    System.out.println("Type-in seance's ID");
                    int t = s.nextInt();
                    s.nextLine();
                    System.out.println("New movie has been added.");
                }
                case "VI"-> {
                    data.add(getFilmmaker());
                    System.out.println("Type-in one of available below movie's ID");
                    for(DatabaseObject i:data){
                        if(i instanceof Movie){
                            System.out.println("\t"+i.getId()+". "+i.getName());
                        }
                    }
                    int t=s.nextInt();
                    s.nextLine();
                    System.out.println("New filmmaker have been added.");
                }
                case "VII"->{
                    for(DatabaseObject i:data){
                        System.out.println(i.getId());
                    }
                    System.out.println("Type-in ID of object that is going to be deleted:");
                    int i1 = s.nextInt();
                    s.nextLine();
                    boolean success=false;
                    for(DatabaseObject i:data){
                        if(i.getId()==i1){
                            data.set(data.indexOf(i), null);
                            System.out.println("Element has been deleted.");
                            success=true;
                            break;
                        }
                    }
                    if(!success){
                        System.out.println("Such element does not yet exist.");
                    }
                }
                case "VIII"->{
                    for(DatabaseObject i: data){
                        System.out.println(i.toString()+",");
                    }
                }
                case "IX"->{
                    String i1=s.nextLine();
                    for(DatabaseObject i:data){
                        if(i.getClass().getSimpleName().equals(i1))
                        System.out.println(i.getName());
                    }
                }
                case "X"->{
                    String i1=s.nextLine();
                    for(DatabaseObject i:data){
                        if(i.getName().contains(i1)){
                            System.out.println(i.getName());
                        };
                    }
                }
                case "XI"->{
                    // Wykonanie operacji zawartej w interfejsie na wszystkich obiektach klas implementujących ten interfejs.
                }
                case "XII"->{
                    // Walidacja wprowadzanych danych liczbowych poprzez obsługę wyjątku przy konwersji
                }
                case "XXX" -> state = false;
                default -> System.out.println("There is no functionality of given type. Please try again");
            }
        }
    }
}