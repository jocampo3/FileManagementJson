package FileManagement;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDisplay {
    public static void main(String[] args) {
        // Define the file path
        String filePath = "records.json";

        // Initialize a list to store the records
        List<JSONObject> records = new ArrayList<>();

        try {
            // Read the JSON file
            FileReader fileReader = new FileReader(new File(filePath));
            StringBuilder jsonContent = new StringBuilder();
            int ch;
            while ((ch = fileReader.read()) != -1) {
                jsonContent.append((char) ch);
            }

            // Parse the JSON content into a JSONObject or JSONArray
            Object obj = new JSONParser().parse(jsonContent.toString());

            if (obj instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) obj;

                // Store each record in the list
                for (int i = 0; i < jsonArray.size(); i++) {
                    records.add((JSONObject) jsonArray.get(i));
                }
            } else if (obj instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) obj;

                // Extract the JSONArray from the JSONObject
                JSONArray jsonArray = (JSONArray) jsonObject.get("records");

                if (jsonArray != null) {
                    // Store each record in the list
                    for (int i = 0; i < jsonArray.size(); i++) {
                        records.add((JSONObject) jsonArray.get(i));
                    }
                }
            }

            // Print the records in table format
            printTable(records);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void printTable(List<JSONObject> records) {
        System.out.println("First Name\tLast Name\tPhone Number\tAddress\tBirth Date");
        for (JSONObject record : records) {
            System.out.println(record.get("firstName") + "\t" + record.get("lastName") + "\t" + record.get("phoneNumber") + "\t" + record.get("address") + "\t" + record.get("birthDate"));
        }
    }
}
