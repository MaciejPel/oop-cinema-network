package cinemaNetwork;

import java.util.ArrayList;
import java.util.Scanner;

public class cinemaNetwork {

    public static void main(String[] args) {
        ArrayList<Cinema> cinemas = new ArrayList<Cinema>();
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the cinemaNetwork");
        System.out.println("Select one of listed below commands to continue");
        System.out.println("I. Create a new cinema.");
        System.out.println("XXX. Exit program.");
        boolean state = true;
        while (state) {
            String line = s.nextLine();
            switch (line) {
                case "I" -> {

                    cinemas.add(new Cinema("", "", null, null, null, 1));

                    s.nextLine();
                }
                case "XXX" -> state = false;
                default -> System.out.println("There is no functionality of given type. Please try again");
            }
        }
    }
}