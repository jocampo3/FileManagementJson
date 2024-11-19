package FileManagement;

// General imports.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class txtDisplay {

    public static void main(String[] args) {
        
        // Load data from file "output/records.txt".
        String filePath = "output/records.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            
            // Arraylist to store strings.
            List<String[]> tableData = new ArrayList<>();

            // Load content of file and split
            // lines based on comma-separated
            // values.
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");

                // Adding each string to arraylist.
                tableData.add(row);
            }

            // Print the table. 
            for (String[] row : tableData) {
                System.out.println(Arrays.toString(row));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}