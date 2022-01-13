package cinemaNetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cinemaNetwork {

    public static void main(String[] args) {
        ArrayList<DatabaseObject> data = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the cinemaNetwork");
        boolean state = true;
        while (state) {
            System.out.println("Select one of listed below commands to continue");
            System.out.println("I. Add a new cinema.");
            System.out.println("II. Add a new employee.");
            System.out.println("III. Add a new hall.");
            System.out.println("IV. Add a new seance.");
            System.out.println("V. Add a new movie.");
            System.out.println("VI. Add a new filmmaker.");
            System.out.println("VII. Delete element by ID.");
            System.out.println("VIII. Show gathered data info.");
            System.out.println("IX. Show elements of given type.");
            System.out.println("XXX. Exit program.");
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

                    data.add(new Cinema(i1, i2, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), nc3));
                    System.out.println("A new cinema has been added.");
                }
                case "II" -> {
                    System.out.println("Employee name:");
                    String i1 = s.nextLine();
                    System.out.println("Employee birth date[YYYY-MM-DD]:");
                    String[] i2 = s.nextLine().split("-");
                    Date employeeDate=new Date(Integer.parseInt(i2[0]), Integer.parseInt(i2[1]), Integer.parseInt(i2[2]), null, null);

                    System.out.println("Select one of available employee positions:");
                    for (typeOfPosition position : typeOfPosition.values()) {
                        System.out.println("\t" + position.getIndex()+ ". " + position.getName());
                    }
                    typeOfPosition i3 = typeOfPosition.retrieveByIndex(s.nextInt());
                    s.nextLine();

                    data.add(new Employee(i1, i3, employeeDate));
                    System.out.println("A new employee have been added.");
                }
                case "III"->{
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

                    data.add(new Hall(i1, i2, temp2));
                    System.out.println("A new hall has been added.");
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
                    int i4 = s.nextInt();
                    s.nextLine();

                    data.add(new Seance(i1, seanceDate, null, null, i4));
                    System.out.println("New seance has been added");
                }
                case "V"->{
                    System.out.println("Movie name:");
                    String i1 = s.nextLine();

                    System.out.println("Premiere date [YYYY-MM-DD]:");
                    String[] i2 = s.nextLine().split("-");
                    Date premiere=new Date(Integer.parseInt(i2[0]), Integer.parseInt(i2[1]), Integer.parseInt(i2[2]), null, null);

                    System.out.println("Provide movie duration in minutes:");
                    int i3 = s.nextInt();
                    s.nextLine();

                    data.add(new Movie(i1, i1, premiere, null, null, i3));
                    System.out.println("New movie has been added.");
                }
                case "VI"-> {
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

                    data.add(new Filmmaker(i1, filmmakerDate, i3, i2));
                    System.out.println("New filmmaker have been added.");
                }
                case "VII"->{
                    for(DatabaseObject i:data){
                        System.out.println(i.getId());
                    }
                    System.out.println("Type-in ID of object that is going to be deleted:");
                    int i1 = s.nextInt();
                    s.nextLine();
                    for(DatabaseObject i:data){
                        if(i.getId()==i1){
                            data.set(data.indexOf(i), null);
                        }
                    }
                    System.out.println("Element has been deleted.");
                }
                case "VIII"->{}
                case "IX"->{}
                case "XXX" -> state = false;
                default -> System.out.println("There is no functionality of given type. Please try again");
            }
        }
    }
}