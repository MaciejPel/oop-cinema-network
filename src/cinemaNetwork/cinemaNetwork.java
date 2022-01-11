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
            System.out.println("III. Add a new hall.");
            System.out.println("IV. Add a new seance.");
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
                    data.add(new Cinema(i1, i2, new ArrayList<Employee>(), new ArrayList<Hall>(), new ArrayList<Seance>(), nc3));
                    System.out.println("A new cinema has been added:");
                    s.nextLine();
                }
                case "II" -> {
                    System.out.println("Employee name:");
                    String i1 = s.nextLine();
                    System.out.println("Select one of available employee positions:");
                    for (typeOfPosition position : typeOfPosition.values()) {
                        System.out.println(position);
                    }
                    typeOfPosition i2 = typeOfPosition.retrieveByIndex(s.nextInt());
                    int counter = 0;
                    for (int i = 0; i < data.size(); i++){
                        if(data.get(i) instanceof Cinema){
                            counter++;
                        }
                    }
                    if(counter > 0){
                        System.out.println("Select the cinema to which the employee is to be assigned");
                        for (DatabaseObject i : data) {
                            if (i instanceof Cinema) {
                                System.out.println("\t" + i.getId() + ". " +i.getName() + " - " + ((Cinema) i).getAddress());
                            }
                        }
                        int i3 = s.nextInt();
                        Employee i4 = new Employee(i1, i2);
                        data.add(i4);
                        for (DatabaseObject i : data) {
                            if(i.getId() == i3){
                                ((Cinema) i).addEmployee(i4);
                                System.out.println("Employee has been added to cinema successfully");
                            }
                        }
                    }
                    else{
                        System.out.println("New employee cannot be added- there are no available workplaces to assign");
                    }
                    s.nextLine();
                }
                case "III"->{
                    System.out.println("Hall name:");
                    String i1 = s.nextLine();

                    System.out.println("Select one of available hall types:");
                    for (typeOfHall hall: typeOfHall.values()){
                        System.out.println(hall);
                    }
                    typeOfHall i2 = typeOfHall.retrieveByIndex(s.nextInt());
                    System.out.println("How many rows does hall have?");

                    int temp = s.nextInt();
                    List<Row<Integer, Integer>> temp2 = new ArrayList<>();
                    for(int i = 0; i < temp; i++){
                        System.out.println("Type-in number of seats for row " + (i+1));
                        int temp3 = s.nextInt();
                        temp2.add(new Row((i+1), temp3));
                        s.nextLine();
                    }
                    int counter = 0;
                    for (int i = 0; i < data.size(); i++){
                        if(data.get(i) instanceof Cinema){
                            counter++;
                        }
                    }
                    if(counter > 0){
                        System.out.println("Select the cinema to which the hall is to be assigned");
                        for (DatabaseObject i : data) {
                            if (i instanceof Cinema) {
                                System.out.println("\t" + i.getId() + ". " +i.getName() + " - " + ((Cinema) i).getAddress());
                            }
                        }
                        int i3 = s.nextInt();
                        Hall i4 = new Hall(i1, i2, temp2);
                        data.add(i4);
                        for (DatabaseObject i : data) {
                            if(i.getId() == i3){
                                ((Cinema) i).addHall(i4);
                                System.out.println("Hall has been added to cinema successfully");
                            }
                        }
                    }
                    else{
                        System.out.println("New hall cannot be added- there are no available cinemas to assign");
                    }
                    s.nextLine();
                }
                case "IV" -> {
                    System.out.println("Seance name:");
                    String i1 = s.nextLine();
                    System.out.println("Seance date [YYYY-MM-DD]:");
                    String i2 = s.nextLine();
                    String[] splitI2 = i2.split("-");
                    System.out.println("Seance hour [HH:MM]:");
                    String i3 = s.nextLine();
                    String[] splitI3 = i3.split(":");
                    Date seanceDate = new Date(Integer.parseInt(splitI2[0]), Integer.parseInt(splitI2[1]), Integer.parseInt(splitI2[2]), Integer.parseInt(splitI3[0]), Integer.parseInt(splitI2[1]));
                    System.out.println("Ticket price:");
                    int i4 = s.nextInt();
                    s.nextLine();


                    int counter = 0;
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i) instanceof Movie) {
                            counter++;
                        }
                    }
                    Movie i6 = null;
                    if (counter > 0) {
                        System.out.println("Select movie for the Seance");
                        for (DatabaseObject i : data) {
                            if (i instanceof Movie) {
                                System.out.println("\t" + i.getId() + ". " + ((Movie) i).getTitle() + " - " + ((Movie) i).getDuration() + "min.");
                            }
                        }
                        int i5 = s.nextInt();
                        for (DatabaseObject i : data) {
                            if (i.getId() == i5) {
                                i6 = (Movie) i;
                            }
                        }
                    } else {
                        System.out.println("New seance cannot be added- there are no available movies to display");
                    }


                    counter = 0;
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i) instanceof Hall) {
                            counter++;
                        }
                    }
                    Hall i8 = null;
                    if (counter > 0) {
                        System.out.println("Select the hall where seance is going to take place");
                        for (DatabaseObject i : data) {
                            if (i instanceof Hall) {
                                String temp = null;
                                for (DatabaseObject j : data) {
                                    if (j instanceof Cinema) {
                                        for (Hall k : ((Cinema) j).getHalls()) {
                                            if (k.getId() == i.getId()) {
                                                temp = j.getName() + " - " + ((Cinema) j).getAddress();
                                            }
                                        }
                                    }
                                }
                                System.out.println("\t" + i.getId() + ". " + i.getName() + " - " + ((Hall) i).getType() + " - " + temp);
                            }
                        }
                        int i7 = s.nextInt();
                        for (DatabaseObject i : data) {
                            if (i.getId() == i7) {
                                i8 = (Hall) i;
                            }
                        }
                    } else {
                        System.out.println("New seance cannot be added- there are no available halls to assign");
                    }
                    Seance i7 = new Seance(i1, seanceDate, i6, i8, i4);
                    s.nextLine();
                }
                    case "XXX" -> state = false;
                default -> System.out.println("There is no functionality of given type. Please try again");
            }
        }
    }
}