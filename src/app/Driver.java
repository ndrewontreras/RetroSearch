package app;

import objects.ToyotaVehicle;
import data.LoadData;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        LoadData data = new LoadData();
        data.load();
        ArrayList<ToyotaVehicle> vehicleCatalog = data.getToyotaVehicleCatalog();

        //This is the main user prompt to have them enter a valid search attribute
        System.out.printf("%40s %n%n", "\t\t\t----- RetroSearch -----\n\n" +
                "------- Please enter one of the following: ------\n" +
                "- • model year (e.g, '1985')   -\n" +
                "- • model code (e.g., 'A60')   -\n" +
                "- • model name (e.g., 'Toyota Supra')   -\n" +
                "- • Sedan? (e.g., 'Y', 'N')   -\n" +
                "- • 'All' to display all vehicles   -\n" +
                "- • 'Quit' to quit the application   -\n\n\n" +
                "---- For more information, please review the ----\n" +
                "--- user guide located in the project folder. ---\n\n " +
                "\t\t\t--- Happy searching! --- ");

        Scanner input = new Scanner(System.in);

        boolean userDone = false;
        do {
            System.out.print("--- Please enter one of the attributes listed above: ");
            String userInput = input.nextLine();
            for (ToyotaVehicle toyotaVehicle : vehicleCatalog) {
                if (userInput.equals("All")) {
                    System.out.println(toyotaVehicle);
                } else if (userInput.equals("Quit")) {
                    userDone = true;
                } else if (userInput.length() == 3) {
                    if (toyotaVehicle.getModelCode().equals(userInput)) {
                        System.out.println(toyotaVehicle);
                    }
                } else if (userInput.length() > 4) {
                    if ((toyotaVehicle.getModelName()).equals(userInput)) {
                        System.out.println(toyotaVehicle);
                    }
                } else if (userInput.length() == 1) {
                    if (userInput.equals("Y")) {
                        if (toyotaVehicle.isSedan()) {
                            System.out.println(toyotaVehicle);
                        }
                    } else if (userInput.equals("N")) {
                        if (!toyotaVehicle.isSedan()) {
                            System.out.println(toyotaVehicle);
                        }
                    }
                } else if (isInt(userInput)) {
                    if (Integer.parseInt(userInput) < 1990 && Integer.parseInt(userInput) > 1979) {
                        if ((toyotaVehicle.getModelYear()) == Integer.parseInt(userInput)) {
                            System.out.println(toyotaVehicle);
                        }
                    }
                }
            }
        } while (!userDone);
        
        input.close();
        System.out.println("\n\n--- Thanks for using RetroSearch! ---\n------------- Goodbye! --------------");
    }

    public static boolean isInt(String s) {
        for (int a = 0; a < s.length(); a++) {
            if (a == 0 && s.charAt(a) == '-') {
               return true;
            } else if (!Character.isDigit(s.charAt(a))) {
                return false;
            }
        }
        return true;
    }
}