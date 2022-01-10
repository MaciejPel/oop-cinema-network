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
            System.out.println("I. Create a new cinema.");
            System.out.println("II. Add a new employee.");
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
                    data.add(new Cinema(i1, i2, null, null, null, nc3));
                    System.out.println("A new cinema has been added:");
                    s.nextLine();
                }
                case "II" -> {
                    System.out.println("Employee name:");
                    String i1 = s.nextLine();
                    System.out.println("Select one of available employee positions:");
                    for (typeOfPosition position: typeOfPosition.values()){
                        System.out.println(position);
                    }
                    typeOfPosition i2 = typeOfPosition.retrieveByIndex(s.nextInt());
                    data.add(new Employee(i1, i2));
                    for(DatabaseObject i: data){
                        if(i instanceof Cinema){
                            System.out.println(i.getName());
                        }
                    }
                    s.nextLine();
                }
                case "III"->{
//                    System.out.println("How many rows does hall have?");
//                    int i1 = s.nextInt();
//
//                    System.out.println("Select one of available hall types:");
//                    for (typeOfHall hall: typeOfHall.values()){
//                        System.out.println(hall);
//                    }
//                    typeOfHall i2 = typeOfHall.retrieveByIndex(s.nextInt());
////                    data.add(new Hall(i1, i2));
//                    System.out.println("A new hall has been added");
//                    s.nextLine();
                }
                    case "XXX" -> state = false;
                default -> System.out.println("There is no functionality of given type. Please try again");
            }
        }
    }
}