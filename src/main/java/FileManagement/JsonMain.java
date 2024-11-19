package FileManagement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonMain {
    public static void main(String[] args) {
        // Update the path to your desired directory
        String filePath = "records.json";

        // Sample data arrays
        String[] firstNames = {"Sarah", "James", "Emily", "Michael", "Olivia", "David", "Sophia", "Daniel", "Isabella", "Matthew"};
        String[] lastNames = {"Thompson", "Wilson", "Garcia", "Johnson", "Martinez", "Brown", "Hernandez", "Lopez", "Clark", "Walker"};
        String[] streets = {"Elm St.", "Oak Ave.", "Pine Ln.", "Maple Rd.", "Birch St.", "Cedar Ct.", "Willow Dr.", "Ash Blvd.", "Spruce Way", "Poplar Pl."};
        String[] cities = {"Springfield", "Rivertown", "Lakeview", "Greenfield", "Clearwater", "Sunnyvale", "Meadowbrook", "Stonehaven", "Brookside", "Fairview"};
        String[] states = {"IL", "TX", "FL", "WI", "CO", "CA", "NY", "GA", "AZ", "WA"};
        String[] zipCodes = {"62704", "75001", "33101", "53228", "80903", "94086", "10001", "30303", "85001", "98101"};

        Random random = new Random();
        JSONArray records = new JSONArray();

        for (int i = 1; i <= 10; i++) {
            // Generate random index for each field
            int firstNameIndex = random.nextInt(firstNames.length);
            int lastNameIndex = random.nextInt(lastNames.length);
            int streetIndex = random.nextInt(streets.length);
            int cityIndex = random.nextInt(cities.length);
            int stateIndex = random.nextInt(states.length);
            int zipIndex = random.nextInt(zipCodes.length);

            // Generate random birth date
            int year = random.nextInt(40) + 1980; // Random year between 1980 and 2019
            int month = random.nextInt(12) + 1;   // Random month between 1 and 12
            int day = random.nextInt(28) + 1;    // Random day between 1 and 28
            String birthDate = String.format("%02d-%02d-%d", month, day, year);

            // Generate random phone number
            String phoneNumber = String.format("(555) %03d-%04d", random.nextInt(900) + 100, random.nextInt(10000));

            // Create a JSON object for the record
            JSONObject record = new JSONObject();
            record.put("firstName", firstNames[firstNameIndex]);
            record.put("lastName", lastNames[lastNameIndex]);
            record.put("birthDate", birthDate);
            record.put("phoneNumber", phoneNumber);
            record.put("address", (random.nextInt(999) + 1) + " " + streets[streetIndex] + ", " + cities[cityIndex] + ", " + states[stateIndex] + " " + zipCodes[zipIndex]);

            // Add the record to the array
            records.add(record);
        }
        // Write the JSON array to a file
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(records.toJSONString());
            System.out.println("JSON file created: " + records);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}