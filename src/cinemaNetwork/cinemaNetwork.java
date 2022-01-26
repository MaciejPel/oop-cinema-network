package cinemaNetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cinemaNetwork {

    private static Hall requestHall(){
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

    private static Filmmaker requestFilmmaker(){
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

    private static Employee requestEmployee(){
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

    private static Movie requestMovie(){
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

    private static Seance requestSeance(){
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
        System.out.println("Add a hall? [Y/N]");
        if(s.nextLine().equals("Y")){
            hall= requestHall();
            System.out.println("New hall added.");
        }
        ArrayList<Advertisement> advertisements=new ArrayList<>();
        System.out.println("Add advertisement? [Y/N]");
        if(s.nextLine().equals("Y")){
            do {
                advertisements.add(requestAdvertisement());
                System.out.println("Advertisement added. Add another one? [Y/N]");
            } while (!s.nextLine().equals("N"));
        }
        Movie movie=null;
        System.out.println("Add a movie? [Y/N]");
        if(s.nextLine().equals("Y")){
            movie= requestMovie();
            System.out.println("New movie added.");
        }
        return new Seance(i1, seanceDate, movie, advertisements, hall, i4);
    }

    private static Advertisement requestAdvertisement(){
        Scanner s = new Scanner(System.in);
        System.out.println("Advertisement name:");
        String i1 = s.nextLine();

        System.out.println("Provide advertisement duration in seconds:");
        int i2 = s.nextInt();
        s.nextLine();

        return new Advertisement(i1, i2);
    }

    private static DatabaseObject findObjectById(int ID, ArrayList<DatabaseObject> data){
        for(DatabaseObject i: data){
            if(i.getId()==ID){
                return i;
            }
        }
        return null;
    }

    private static void listObjectsOfGivenType(String type, ArrayList<DatabaseObject> data){
        for(DatabaseObject i:data){
            if(i.getClass().getSimpleName().equals(type)){
                System.out.println("\t"+i.getId()+". "+i.getName());
            }
        }
    }

    public static void main(String[] args) {

//        ArrayList<Employee> emptye  = new ArrayList<>();
//        ArrayList<Hall> emptyh= new ArrayList<>();
//        ArrayList<Seance> emptys= new ArrayList<>();
//        ArrayList<Movie> emptym= new ArrayList<>();
//        ArrayList<Filmmaker> emptya= new ArrayList<>();
//        List<Row<Integer, Integer>> tempex = new ArrayList<>();
//        tempex.add(new Row(1, 5));
//        Hall h = new Hall("h1", typeOfHall.IMAX, tempex);
//        Filmmaker f = new Filmmaker("Woźniak", new Date(2000, 3, 5, null, null), Country.France, typeOfRole.Actor);
//        Movie m=new Movie("m1", new Date(2022, 11, 10,null,null), emptya, f, 150);
//        data.add(h);
//        data.add(f);
//        data.add(m);
//        data.add(new Cinema("n1", "a1", emptye, emptyh, emptys, 123456789));
//        data.add(new Employee("Jacula", typeOfPosition.janitor, new Date(2000,20,10,null,null)));
//        data.add(new Seance("s1", new Date(2022, 12, 20, 15, 15), m, h, 15));

        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the cinemaNetwork");
        ArrayList<DatabaseObject> data = new ArrayList<>();
        boolean state = true;
        while (state) {
            System.out.println("""
                    Select one of listed below commands to continue
                    I. Add a new cinema.
                    II. Add a new employee.
                    III. Add a new hall.
                    IV. Add a new seance.
                    V. Add a new movie.
                    VI. Add a new advertisement.
                    VII. Add a new filmmaker.
                    VIII. Delete element by ID.
                    IX. Show gathered data info.
                    X. Show elements of given type.
                    XI. Search for element by name.
                    XII. An operation.
                    XXX. Exit program.""");
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
                    System.out.println("Add new hall? [Y/N]");
                    if(s.nextLine().equals("Y")){
                        do {
                            hall.add(requestHall());
                            System.out.println("New hall added. Add another one? [Y/N]");
                        } while (!s.nextLine().equals("N"));
                    }
                    ArrayList<Employee> employee= new ArrayList<>();
                    System.out.println("Add new Employee? [Y/N]");
                    if(s.nextLine().equals("Y")){
                        do {
                            employee.add(requestEmployee());
                            System.out.println("New employee added. Add another one? [Y/N]");
                        } while (!s.nextLine().equals("N"));
                    }
                    ArrayList<Seance> seance= new ArrayList<>();
                    System.out.println("Add new seance? [Y/N]");
                    if(s.nextLine().equals("Y")){
                        do {
                            seance.add(requestSeance());
                            System.out.println("New seance added. Add another one? [Y/N]");
                        } while (!s.nextLine().equals("N"));
                    }
                    data.add(new Cinema(i1, i2, employee, hall, seance, nc3));
                    System.out.println("A new cinema has been added.");
                }
                case "II" -> {
                    Employee userInput= requestEmployee();
                    data.add(userInput);
                    listObjectsOfGivenType("Cinema", data);
                    System.out.println("Type-in cinema's ID");
                    int t=s.nextInt();
                    s.nextLine();
                    ((Cinema) findObjectById(t, data)).addEmployee(userInput);
                    System.out.println("A new employee have been added.");
                }
                case "III"->{
                    Hall userInput= requestHall();
                    data.add(userInput);
                    listObjectsOfGivenType("Cinema", data);
                    System.out.println("Type-in cinema's ID");
                    int t=s.nextInt();
                    s.nextLine();
                    ((Cinema) findObjectById(t, data)).addHall(userInput);
                    System.out.println("A new employee have been added.");
                }
                case "IV" -> {
                    Seance userInput= requestSeance();
                    data.add(userInput);
                    listObjectsOfGivenType("Cinema", data);
                    System.out.println("Type-in cinema's ID");
                    int t=s.nextInt();
                    s.nextLine();
                    ((Cinema) findObjectById(t, data)).addSeance(userInput);
                    System.out.println("A new employee have been added.");
                }
                case "V"->{
                    Movie userInput= requestMovie();
                    data.add(userInput);
                    listObjectsOfGivenType("Seance", data);
                    System.out.println("Type-in seance's ID");
                    int t=s.nextInt();
                    s.nextLine();
                    ((Seance) findObjectById(t, data)).setMovie(userInput);
                    System.out.println("A new movie have been added.");
                }
                case "VI"->{
                    Advertisement userInput= requestAdvertisement();
                    data.add(userInput);

                    System.out.println("Assign ad to seance? [Y/N]");
                    if(s.nextLine().equals("Y")){
                        do {
                            listObjectsOfGivenType("Seance", data);
                            System.out.println("Type-in seance's ID");
                            int temp=s.nextInt();
                            s.nextLine();
                            ((Seance) findObjectById(temp, data)).addAdvertisement(userInput);
                            System.out.println("Advertisement assigned. Add another one? [Y/N]");
                        } while (!s.nextLine().equals("N"));
                    }
                    System.out.println("A new advertisement have been added.");
                }
                case "VII"-> {
                    Filmmaker userInput= requestFilmmaker();
                    data.add(userInput);
                    if(userInput.getDefaultRole().getName()=="Director"){
                        System.out.println("Set director to the movie? [Y/N]");
                        String t=s.nextLine();
                        if(t.equals("Y")){
                            System.out.println("Type-in one of available below movie's ID");
                            listObjectsOfGivenType("Movie", data);
                            int i=s.nextInt();
                            s.nextLine();
                            ((Movie) findObjectById(i, data)).setDirector(userInput);
                        }
                    }
                    if(userInput.getDefaultRole().getName()=="Actor"){
                        System.out.println("Add actor to the movie? [Y/N]");
                        String t=s.nextLine();
                        if(t.equals("Y")){
                            System.out.println("Type-in one of available below movie's ID");
                            listObjectsOfGivenType("Movie", data);

                            int i=s.nextInt();
                            s.nextLine();
                            ((Movie) findObjectById(i, data)).addActor(userInput);
                        }
                    }
                    System.out.println("New filmmaker have been added.");
                }
                case "VIII"->{
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
                case "IX"->{
                    for(DatabaseObject i: data){
                        System.out.println(i.toString()+",");
                    }
                }
                case "X"->{
                    System.out.println("Provide one of following types: Cinema, Hall, Movie, Seance, Advertisement, Filmmaker or Employee.");
                    String i1=s.nextLine();
                    for(DatabaseObject i:data){
                        if(i.getClass().getSimpleName().equals(i1)){
                            System.out.println(i);
                        }
                    }
                }
                case "XI"->{
                    String i1=s.nextLine();
                    for(DatabaseObject i: data){
                        if(i.getName().contains(i1)){
                            System.out.println(i);
                        }
                    }
                }
                case "XII"->{
                    // Wykonanie operacji zawartej w interfejsie na wszystkich obiektach klas implementujących ten interfejs.
                }
                case "XXX" -> state = false;
                default -> System.out.println("There is no functionality of given type. Please try again");
            }
        }
    }
}