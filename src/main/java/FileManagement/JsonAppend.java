package FileManagement;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonAppend {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String filePath = "output/records.json";

        // Read existing JSON data from the file
        JSONArray existingData = readJSONData(filePath);

        // New records to append in JSON format
        JSONArray newRecords = new JSONArray();

        JSONObject record1 = new JSONObject();
        record1.put("firstName", "Sarah");
        record1.put("lastName", "Thompson");
        record1.put("phoneNumber", "(555) 342-7654");
        record1.put("address", "123 Elm St., Springfield, IL 62704");
        record1.put("birthDate", "03-12-1985");
        newRecords.add(record1);

        JSONObject record2 = new JSONObject();
        record2.put("firstName", "James");
        record2.put("lastName", "Wilson");
        record2.put("phoneNumber", "(555) 847-3921");
        record2.put("address", "456 Oak Ave., Rivertown, TX 75001");
        record2.put("birthDate", "11-05-1992");
        newRecords.add(record2);

        JSONObject record3 = new JSONObject();
        record3.put("firstName", "Emily");
        record3.put("lastName", "Garcia");
        record3.put("phoneNumber", "(555) 210-9814");
        record3.put("address", "789 Pine Ln., Lakeview, FL 33101");
        record3.put("birthDate", "07-22-1990");
        newRecords.add(record3);

        JSONObject record4 = new JSONObject();
        record4.put("firstName", "Michael");
        record4.put("lastName", "Johnson");
        record4.put("phoneNumber", "(555) 674-8293");
        record4.put("address", "321 Maple Rd., Greenfield, WI 53228");
        record4.put("birthDate", "01-14-1980");
        newRecords.add(record4);

        JSONObject record5 = new JSONObject();
        record5.put("firstName", "Olivia");
        record5.put("lastName", "Martinez");
        record5.put("phoneNumber", "(555) 926-5648");
        record5.put("address", "901 Cedar St., Clearwater, CO 80903");
        record5.put("birthDate", "09-03=1996");
        newRecords.add(record5);

        // Merge the existing data and the new records
        for (Object record : newRecords) {
            existingData.add(record);
        }

        // Write the updated data to the file
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(existingData.toJSONString());
            System.out.println("Data appended to JSON file successfully!");
        } catch (IOException e) {
            System.out.println("Error appending data to JSON file: " + e.getMessage());
        }
    }

    private static JSONArray readJSONData(String filePath) {
        JSONParser parser = new JSONParser();
        try (FileReader file = new FileReader(filePath)) {
            Object obj = parser.parse(file);
            return (JSONArray) obj;
        } catch (IOException | ParseException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
            return new JSONArray();
        }
    }
}
