package cinemaNetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cinemaNetwork {

    private static ArrayList<Integer> tab = new ArrayList<>();

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
        tab.clear();
        for(DatabaseObject i:data){
            if(i.getClass().getSimpleName().equals(type)){
                tab.add(i.getId());
                System.out.println("\t"+i.getId()+". "+i.getName());
                count++;
            }
        }
        return count > 0;
    }

    private static int requestInt(){
        Scanner s = new Scanner(System.in);
        int i;
        while(true){
            try{
                String str = s.nextLine();
                i = Integer.parseInt(str);
                if(i>=0) {
                    break;
                }else{
                    System.out.println("Provided value is negative, please try again");
                }
            }
            catch(Exception e){
                System.out.println("Provided value is invalid, please try again");
            }
        }
        return i;
    }

    public static void main(String[] args) {
        ArrayList<DatabaseObject> data = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        boolean state = true;

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
                    XII. Method operation.
                    XXX. Exit program.""");
            String line = s.nextLine();
            switch (line) {
                case "I" -> {
                    System.out.println("Cinema name:");
                    String i1 = s.nextLine();
                    System.out.println("Cinema address:");
                    String i2 = s.nextLine();
                    System.out.println("Cinema phone number:");
                    int nc3 = requestInt();
                    data.add(new Cinema(i1, i2, new ArrayList<>(), new ArrayList<>(), nc3));
                    System.out.println("A new cinema has been added.");
                }
                case "II" -> {
                    System.out.println("Employee name:");
                    String i1 = s.nextLine();

                    System.out.println("Employee birth date [YYYY-MM-DD]:");
                    String[] i2 = s.nextLine().split("-");
                    Date employeeDate=new Date(Integer.parseInt(i2[0]), Integer.parseInt(i2[1]), Integer.parseInt(i2[2]), null, null);

                    System.out.println("Select one of available employee positions:");
                    for (typeOfPosition position : typeOfPosition.values()) {
                        System.out.println("\t" + position.getIndex()+ ". " + position.getName());
                    }
                    typeOfPosition i3 = typeOfPosition.retrieveByIndex(requestInt());
                    Employee userInput= new Employee(i1, i3, employeeDate);
                    data.add(userInput);
                    System.out.println("A new employee has been added.");
                    System.out.println("Do you want to add this employee to the cinema? [Y to continue]");
                    while(s.nextLine().equals("Y")){
                        if(!listObjectsOfGivenType("Cinema", data)){
                            System.out.println("There are no cinemas in the system yet.");
                            break;
                        }
                        System.out.println("Type-in one of listed above cinema's IDs");
                        int t=requestInt();
                        boolean tmp=false;
                        if(!tab.contains(t)){
                            System.out.println("Provided value does not match any of listed above IDs. Wanna try again? [Y to continue]");
                            continue;
                        }
                        for(Employee i: ((Cinema) findObjectById(t, data)).getEmployees()){
                            if(i.getId()== userInput.getId()){
                                System.out.println("Employee already is in this cinema! Wanna try again? [Y to continue]");
                                tmp=true;
                                break;
                            }
                        }
                        if(!tmp){
                            ((Cinema) findObjectById(t, data)).addEmployee(userInput);
                            System.out.println("Success. Add to another one? [Y to continue]");
                        }
                    }
                }
                case "III"->{
                    System.out.println("Hall name:");
                    String i1 = s.nextLine();
                    System.out.println("Select one of available hall types:");
                    for (typeOfHall type: typeOfHall.values()){
                        System.out.println("\t" + type.getIndex()+ ". " + type.getName());
                    }
                    typeOfHall i2 = typeOfHall.retrieveByIndex(requestInt());
                    System.out.println("How many rows does hall have?");
                    int j = requestInt();
                    List<Row<Integer, Integer>> rows = new ArrayList<>();
                    for(int i = 0; i < j; i++){
                        System.out.println("Type-in number of seats for row " + (i+1));
                        rows.add(new Row((i+1), requestInt()));
                    }
                    Hall userInput= new Hall(i1, i2, rows, new ArrayList<>());
                    data.add(userInput);
                    System.out.println("A new hall has been added.");
                    System.out.println("Do you want to assign this hall to the cinema? [Y to continue]");
                    while(s.nextLine().equals("Y")){
                        if(!listObjectsOfGivenType("Cinema", data)){
                            System.out.println("Currently there are no cinemas in the system yet.");
                            break;
                        }
                        System.out.println("Type-in cinema's ID");
                        int t=requestInt();
                        if(!tab.contains(t)){
                            System.out.println("Provided value does not match any of listed above IDs. Wanna try again? [Y to continue]");
                            continue;
                        }
                        ((Cinema) findObjectById(t, data)).addHall(userInput);
                        System.out.println("Success");
                        break;
                    }
                }
                case "IV" -> {
                    System.out.println("Seance name:");
                    String i1 = s.nextLine();
                    System.out.println("Seance date [YYYY-MM-DD]:");
                    String[] i2 = s.nextLine().split("-");
                    System.out.println("Seance hour [HH:MM]:");
                    String[] i3 = s.nextLine().split(":");
                    Date seanceDate = new Date(Integer.parseInt(i2[0]), Integer.parseInt(i2[1]), Integer.parseInt(i2[2]), Integer.parseInt(i3[0]), Integer.parseInt(i3[1]));
                    System.out.println("Ticket price:");
                    int i4 = requestInt();
                    Seance userInput= new Seance(i1, seanceDate, null, new ArrayList<>(), null, i4);
                    data.add(userInput);
                    System.out.println("A new seance has been added.");

                    System.out.println("Do you want to add this seance to the hall? [Y to continue]");
                    while(s.nextLine().equals("Y")){
                        if(!listObjectsOfGivenType("Hall", data)){
                            System.out.println("Currently there are no halls in the system yet.");
                            break;
                        }
                        System.out.println("Type-in one of listed above halls");
                        int t=requestInt();
                        boolean tmp=false;
                        if(!tab.contains(t)){
                            System.out.println("Provided value does not match any of listed above IDs. Wanna try again? [Y to continue]");
                            continue;
                        }
                        for(Seance i: ((Hall) findObjectById(t, data)).getSeances()){
                            if(i.getId()== userInput.getId()){
                                System.out.println("Seance is already in this hall. Wanna try again? [Y to continue]");
                                tmp=true;
                                break;
                            }
                        }
                        if(!tmp){
                            ((Hall)findObjectById(t, data)).addSeance(userInput);
                            System.out.println("Success. Add to another one? [Y to continue]");
                        }
                    }
                }
                case "V"->{
                    System.out.println("Movie name:");
                    String i1 = s.nextLine();
                    System.out.println("Premiere date [YYYY-MM-DD]:");
                    String[] i2 = s.nextLine().split("-");
                    Date premiere=new Date(Integer.parseInt(i2[0]), Integer.parseInt(i2[1]), Integer.parseInt(i2[2]), null, null);
                    System.out.println("Provide movie duration in minutes:");
                    int i3 = requestInt();
                    System.out.println("Select one of available genres:");
                    for (Genre genre: Genre.values()){
                        System.out.println("\t" + genre.getIndex()+ ". " + genre.getName());
                    }
                    Genre i4 = Genre.retrieveByIndex(requestInt());

                    Movie userInput= new Movie(i1, premiere, new ArrayList<>(), null, i3, i4);
                    data.add(userInput);
                    System.out.println("New movie has been added.");
                    System.out.println("Do you want to assign this movie to seance? [Y to continue]");
                    while(s.nextLine().equals("Y")){
                        if(!listObjectsOfGivenType("Seance", data)){
                            System.out.println("Currently there are no seances in the system yet.");
                            break;
                        }
                        System.out.println("Type-in seance's ID");
                        int t=requestInt();
                        if(!tab.contains(t)){
                            System.out.println("Provided value does not match any of listed above IDs. Wanna try again? [Y to continue]");
                            continue;
                        }
                        ((Seance) findObjectById(t, data)).setMovie(userInput);
                        System.out.println("Success. Assign to another one? [Y to continue]");
                    }
                }
                case "VI"->{
                    System.out.println("Advertisement name:");
                    String i1 = s.nextLine();
                    System.out.println("Provide advertisement duration [s]:");
                    int i2 = requestInt();
                    System.out.println("Advertisement description: ");
                    String i3 = s.nextLine();
                    Advertisement userInput= new Advertisement(i1, i2, i3);
                    data.add(userInput);
                    System.out.println("A new advertisement have been added.");
                    System.out.println("Do you want to add this advertisement to seance? [Y to continue]");
                    while(s.nextLine().equals("Y")){
                        if(!listObjectsOfGivenType("Seance", data)){
                            System.out.println("Currently there are no seances in the system.");
                            break;
                        }
                        System.out.println("Type-in seance's ID");
                        int t=requestInt();
                        boolean tmp=false;
                        if(!tab.contains(t)){
                            System.out.println("Provided value does not match any of listed above IDs. Wanna try again? [Y to continue]");
                            continue;
                        }
                        for(Advertisement i: ((Seance) findObjectById(t, data)).getAdvertisements()){
                            if(i.getId() == userInput.getId()){
                                System.out.println("Ad already is in this seance. Wanna try again? [Y to continue]");
                                tmp = true;
                                break;
                            }
                        }
                        if(!tmp){
                            ((Seance) findObjectById(t, data)).addAdvertisement(userInput);
                            System.out.println("Success. Add to another one? [Y to continue]");
                        }
                    }
                }
                case "VII"-> {
                    System.out.println("Filmmaker name:");
                    String i1 = s.nextLine();
                    System.out.println("Filmmaker date of birth [YYYY-MM-DD]:");
                    String[] i5 = s.nextLine().split("-");
                    Date filmmakerDate=new Date(Integer.parseInt(i5[0]), Integer.parseInt(i5[1]), Integer.parseInt(i5[2]), null, null);
                    System.out.println("Select filmmaker default role:");
                    for (typeOfRole type: typeOfRole.values()){
                        System.out.println("\t" + type.getIndex()+ ". " + type.getName());
                    }
                    typeOfRole i2 = typeOfRole.retrieveByIndex(requestInt());
                    System.out.println("Choose nationality:");
                    for (Country country: Country.values()){
                        System.out.println("\t" + country.getIndex()+ ". " + country.getName());
                    }
                    Country i3 = Country.retrieveByIndex(requestInt());
                    Filmmaker userInput= new Filmmaker(i1, filmmakerDate, i3, i2);
                    data.add(userInput);
                    System.out.println("New filmmaker has been added.");

                    if(userInput.getDefaultRole().getName().equals("Director")){
                        System.out.println("Assign director to the movie? [Y to continue]");
                        while(s.nextLine().equals("Y")){
                            if(!listObjectsOfGivenType("Movie", data)){
                                System.out.println("Currently there are no movies in the system yet.");
                                break;
                            }
                            System.out.println("Type-in one of available above movie's ID");
                            int i=requestInt();
                            if(!tab.contains(i)){
                                System.out.println("Provided value does not match any of listed above IDs. Wanna try again? [Y to continue]");
                                continue;
                            }
                            ((Movie) findObjectById(i, data)).setDirector(userInput);
                            System.out.println("Success. Assign to other one? [Y to continue]");
                        }
                    }
                    if(userInput.getDefaultRole().getName().equals("Actor")){
                        System.out.println("Add actor to the movie? [Y to continue]");
                        while(s.nextLine().equals("Y")){
                            System.out.println("Type-in one of available below movie's ID");
                            if(!listObjectsOfGivenType("Movie", data)){
                                System.out.println("Currently there are no movies in the system yet.");
                                break;
                            }
                            int i=requestInt();
                            boolean tmp=false;
                            if(!tab.contains(i)){
                                System.out.println("Provided value does not match any of listed above IDs. Wanna try again? [Y to continue]");
                                continue;
                            }
                            for(Filmmaker j: ((Movie) findObjectById(i, data)).getActors()){
                                if(j.getId()==userInput.getId()){
                                    System.out.println("Actor already in this move. Wanna try again? [Y to continue]");
                                    tmp=true;
                                    break;
                                }
                            }
                            if(!tmp){
                                ((Movie) findObjectById(i, data)).addActor(userInput);
                                System.out.println("Success. Add to another one? [Y to continue]");
                            }
                        }
                    }
                }
                case "VIII"->{
                    if(data.size()>0){
                        for(DatabaseObject i:data){
                            System.out.println("\t"+ i.getId()+". "+i.getName());
                        }
                        System.out.println("Type-in ID of object that is going to be deleted:");
                        int i1 = requestInt();
                        boolean success=false;
                        for(DatabaseObject i:data){
                            if(i.getId()==i1){
                                data.remove(i);
                                System.out.println("Element has been deleted.");
                                success=true;
                                break;
                            }
                        }
                        if(!success){
                            System.out.println("Such element does not yet exist.");
                        }
                    }
                    else{
                        System.out.println("There are no elements to delete");
                    }
                }
                case "IX"->{
                    if(data.size()>0) {
                        for (DatabaseObject i : data) {
                            System.out.println(i.toString() + ",");
                        }
                    }
                    else{
                        System.out.println("Currently there is no data available.");
                    }
                }
                case "X"->{
                    System.out.println("Provide one of following types: Cinema, Hall, Movie, Seance, Advertisement, Filmmaker or Employee.");
                    String i1 = s.nextLine();
                    for(DatabaseObject i:data){
                        if(i.getClass().getSimpleName().equals(i1)){
                                System.out.println(i);
                        }
                    }
                    if(data.size()==0) System.out.println("Currently there is no data in the system");
                }
                case "XI"->{
                    System.out.println("Type-in searched text you're looking for");
                    String i1=s.nextLine();
                    for(DatabaseObject i: data){
                        if(i.getName().contains(i1)){
                            System.out.println(i);
                        }
                    }
                }
                case "XII"->{
                    tab.clear();
                    for (DatabaseObject i:data){
                        if(i instanceof Movie){
                            System.out.println("\t"+i.getId()+". "+ i.getName());
                            tab.add(i.getId());
                        }
                        if(i instanceof Advertisement){
                            System.out.println("\t"+i.getId()+". "+ i.getName());
                            tab.add(i.getId());
                        }
                    }
                    System.out.println("Type-in one of listed above IDs");
                    int t= requestInt();
                    if(tab.contains(t)){
                        if(findObjectById(t, data).getClass().getSimpleName().equals("Movie")){
                            System.out.println(((Movie)findObjectById(t, data)).isFamilyFriendly()?"This movie is family-friendly":"This movie is not family-friendly");
                        }
                        if(findObjectById(t, data).getClass().getSimpleName().equals("Advertisement")){
                            System.out.println(((Advertisement)findObjectById(t, data)).isFamilyFriendly()?"This ad is family-friendly":"This ad is not family-friendly");
                        }
                    }
                    else{
                        System.out.println("Invalid value has been provided");
                    }
                }
                case "XXX" -> state = false;
                default -> System.out.println("There is no functionality of given type. Please try again");
            }
        }
    }
}