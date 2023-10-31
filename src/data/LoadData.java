package data;

import objects.ToyotaVehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadData {

    private ArrayList<ToyotaVehicle> toyotaVehicleCatalog;

    public LoadData() {}

    public void load() {
        toyotaVehicleCatalog = new ArrayList<>();
        List<String> list = new ArrayList<>(); // <--- This list is only for debugging purposes
        try (BufferedReader br = new BufferedReader(new FileReader("./src/files/yotaList.txt"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(":", -1);
                if (fields.length != 6) { // <--- Also debugging
                    list.add(line);
                    //System.out.println("Number of fields: " + fields.length);
                    continue;
                }
                ToyotaVehicle vehicle1 = new ToyotaVehicle(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], fields[4].length() < 2 ? true : false, fields[5]);
                toyotaVehicleCatalog.add(vehicle1);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        list.forEach(System.out::println); //Debugging
    }

    public ArrayList<ToyotaVehicle> getToyotaVehicleCatalog() {
        return toyotaVehicleCatalog;
    }
}
