package file_management_maven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {
   public static void main(String args[]) throws Exception {
      String delimiter = ",";
      String lineData;
      File csvFile = new File("fake_data.csv");

      try {
          BufferedReader read = new BufferedReader(new FileReader(csvFile));
          JSONArray arrayofJSONObjects = new JSONArray();
          
          // Skip the header line if present
          lineData = read.readLine();
          
          while ((lineData = read.readLine()) != null) {
            String[] individualRecordFromCSV = lineData.split(delimiter);

            // Creating JSON object in a specific order
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("FirstName", individualRecordFromCSV[0]);
            jsonObj.put("LastName", individualRecordFromCSV[1]);
            jsonObj.put("DateOfBirth", individualRecordFromCSV[2]);
            jsonObj.put("PhoneNumber", individualRecordFromCSV[3]);
            jsonObj.put("StreetAddress", individualRecordFromCSV[4]);
            jsonObj.put("City", individualRecordFromCSV[5]);
            jsonObj.put("State", individualRecordFromCSV[6]);
            jsonObj.put("Zip", individualRecordFromCSV[7]);

            arrayofJSONObjects.add(jsonObj);
          }

          // Print JSON array
          System.out.println(arrayofJSONObjects);
          try {
            FileWriter file = new FileWriter("output.json");
            file.write(arrayofJSONObjects.toString());
            // file.write(arrayofJSONObjects.toJSONString());
            file.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

          read.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
