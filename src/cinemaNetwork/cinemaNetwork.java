package cinemaNetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cinemaNetwork {

    private static Cinema requestCinema(){
        Scanner s = new Scanner(System.in);
        System.out.println("Cinema name:");
        String i1 = s.nextLine();
        System.out.println("Cinema address:");
        String i2 = s.nextLine();
        System.out.println("Cinema phone number:");
        int nc3 = s.nextInt();
        s.nextLine();
        return new Cinema(i1, i2, new ArrayList<>(), new ArrayList<>(), nc3);
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
        List<Row<Integer, Integer>> rows = new ArrayList<>();
        for(int i = 0; i < j; i++){
            System.out.println("Type-in number of seats for row " + (i+1));
            rows.add(new Row((i+1), s.nextInt()));
            s.nextLine();
        }
        return new Hall(i1, i2, rows, new ArrayList<>());
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
        return new Seance(i1, seanceDate, null, new ArrayList<>(), null, i4);
    }

    private static Advertisement requestAdvertisement(){
        Scanner s = new Scanner(System.in);
        System.out.println("Advertisement name:");
        String i1 = s.nextLine();
        System.out.println("Provide advertisement duration [s]:");
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

    private static boolean listObjectsOfGivenType(String type, ArrayList<DatabaseObject> data){
        int count=0;
        for(DatabaseObject i:data){
            if(i.getClass().getSimpleName().equals(type)){
                System.out.println("\t"+i.getId()+". "+i.getName());
                count++;
            }
        }
        return count > 0;
    }

    private static boolean checkIfEmployeeAlreadyInCinema(int objectID, int requestedID, ArrayList<DatabaseObject> data){
        for(Employee i: ((Cinema) findObjectById(objectID, data)).getEmployees()){
            if(i.getId()==requestedID){
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfSeanceAlreadyInHall(int objectID, int requestedID, ArrayList<DatabaseObject> data){
        for(Seance i: ((Hall) findObjectById(objectID, data)).getSeances()){
            if(i.getId()==requestedID){
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfAdAlreadyInSeance(int objectID, int requestedID, ArrayList<DatabaseObject> data){
        for(Advertisement i: ((Seance) findObjectById(objectID, data)).getAdvertisements()){
            if(i.getId()==requestedID){
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfActorAlreadyInMovie(int objectID, int requestedID, ArrayList<DatabaseObject> data){
        for(Filmmaker i: ((Movie) findObjectById(objectID, data)).getActors()){
            if(i.getId()==requestedID){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<DatabaseObject> data = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        boolean state = true;

//        ArrayList<Employee> emptye  = new ArrayList<>();
//        ArrayList<Hall> emptyh= new ArrayList<>();
//        ArrayList<Seance> emptys= new ArrayList<>();
//        ArrayList<Movie> emptym= new ArrayList<>();
//        ArrayList<Filmmaker> emptyf= new ArrayList<>();
//        ArrayList<Advertisement> emptya= new ArrayList<>();
//        List<Row<Integer, Integer>> tempex = new ArrayList<>();
//        tempex.add(new Row(1, 5));
//        Hall h = new Hall("h1", typeOfHall.IMAX, tempex, new ArrayList<>());
//        Filmmaker f = new Filmmaker("Woźniak", new Date(2000, 3, 5, null, null), Country.France, typeOfRole.Actor);
//        Movie m=new Movie("m1", new Date(2022, 11, 10,null,null), emptyf, f, 150);
//        data.add(h);
//        data.add(f);
//        data.add(m);
//        data.add(new Cinema("n1", "a1", emptye, emptyh, emptys, 123456789));
//        data.add(new Employee("Jacula", typeOfPosition.janitor, new Date(2000,20,10,null,null)));
//        data.add(new Seance("s1", new Date(2022, 12, 20, 15, 15), m, emptya, h, 15));

        System.out.println("Welcome to the cinemaNetwork");
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
                    Cinema userInput= requestCinema();
                    data.add(userInput);
                    System.out.println("A new cinema has been added.");
                }
                case "II" -> {
                    Employee userInput= requestEmployee();
                    data.add(userInput);
                    System.out.println("A new employee have been added.");
                    System.out.println("Do you want to add this employee to the cinema? [Y/N]");
                    while(s.nextLine().equals("Y")){
                        if(!listObjectsOfGivenType("Cinema", data)){
                            System.out.println("There are no cinemas in the system yet.");
                            break;
                        }
                        System.out.println("Type-in one of listed above cinema's IDs");
                        int t=s.nextInt();
                        s.nextLine();
                        if(!checkIfEmployeeAlreadyInCinema(t, userInput.getId(), data)){
                            ((Cinema) findObjectById(t, data)).addEmployee(userInput);
                            System.out.println("Success. Add to another one? [Y/N]");
                        }
                        else{
                            System.out.println("Employee already is in this cinema! Wanna try again? [Y/N]");
                        }
                    }
                }
                case "III"->{
                    Hall userInput= requestHall();
                    data.add(userInput);
                    System.out.println("A new hall has been added.");
                    System.out.println("Do you want to assign this hall to the cinema? [Y/N]");
                    if(s.nextLine().equals("Y")){
                        listObjectsOfGivenType("Cinema", data);
                        System.out.println("Type-in cinema's ID");
                        int t=s.nextInt();
                        s.nextLine();
                        ((Cinema) findObjectById(t, data)).addHall(userInput);
                        System.out.println("Success");
                    }
                }
                case "IV" -> {
                    Seance userInput= requestSeance();
                    data.add(userInput);
                    System.out.println("A new seance have been added.");
                    System.out.println("Do you want to add this seance to the cinema? [Y/N]");
                    while(s.nextLine().equals("Y")){
                        if(!listObjectsOfGivenType("Cinema", data)){
                            System.out.println("There are no cinemas in the system yet.");
                            break;
                        }
                        System.out.println("Type-in one of listed above cinema's IDs");
                        int t=s.nextInt();
                        s.nextLine();
                        if(!checkIfSeanceAlreadyInHall(t, userInput.getId(), data)){
                            ((Hall) findObjectById(t, data)).addSeance(userInput);
                            System.out.println("Success. Add to another one? [Y/N]");
                        }
                        else{
                            System.out.println("Seance already is in this cinema! Wanna try again? [Y/N]");
                        }
                    }
                }
                case "V"->{
                    Movie userInput= requestMovie();
                    data.add(userInput);
                    System.out.println("New movie have been added.");
                    System.out.println("Do you want to add this movie to seance? [Y/N]");
                    if(s.nextLine().equals("Y")){
                        listObjectsOfGivenType("Seance", data);
                        System.out.println("Type-in seance's ID");
                        int t=s.nextInt();
                        s.nextLine();
                        if(!checkIfSeanceAlreadyInHall(t, userInput.getId(), data)){
                            ((Seance) findObjectById(t, data)).setMovie(userInput);
                            System.out.println("Success");
                        }
                        else{
                            System.out.println("Seance already is in this hall");
                        }
                    }
                }
                case "VI"->{
                    Advertisement userInput= requestAdvertisement();
                    data.add(userInput);
                    System.out.println("A new advertisement have been added.");
                    System.out.println("Do you want to add this advertisement to seance? [Y/N]");
                    if(s.nextLine().equals("Y")){
                        listObjectsOfGivenType("Seance", data);
                        System.out.println("Type-in seance's ID");
                        int t=s.nextInt();
                        s.nextLine();
                        if(!checkIfAdAlreadyInSeance(t, userInput.getId(), data)){
                            ((Seance) findObjectById(t, data)).addAdvertisement(userInput);
                            System.out.println("Success");
                        }
                        else{
                            System.out.println("Ad already is in this seance");
                        }
                    }
                }
                case "VII"-> {
                    Filmmaker userInput= requestFilmmaker();
                    data.add(userInput);
                    System.out.println("New filmmaker have been added.");
                    if(userInput.getDefaultRole().getName().equals("Director")){
                        System.out.println("Set director to the movie? [Y/N]");
                        String t=s.nextLine();
                        if(t.equals("Y")){
                            listObjectsOfGivenType("Movie", data);
                            System.out.println("Type-in one of available above movie's ID");
                            int i=s.nextInt();
                            s.nextLine();
                            ((Movie) findObjectById(i, data)).setDirector(userInput);
                        }
                    }
                    if(userInput.getDefaultRole().getName().equals("Actor")){
                        System.out.println("Add actor to the movie? [Y/N]");
                        String t=s.nextLine();
                        if(t.equals("Y")){
                            System.out.println("Type-in one of available below movie's ID");
                            listObjectsOfGivenType("Movie", data);
                            int i=s.nextInt();
                            s.nextLine();
                            if(!checkIfActorAlreadyInMovie(i, userInput.getId(), data)){
                                ((Movie) findObjectById(i, data)).addActor(userInput);
                                System.out.println("Success. Add to another one? [Y/N]");
                            }
                            else{
                                System.out.println("Actor already in this move. Wanna try again? [Y/N]");
                            }
                        }
                    }
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
                case "XII"->{}
                case "XXX" -> state = false;
                default -> System.out.println("There is no functionality of given type. Please try again");
            }
        }
    }
}