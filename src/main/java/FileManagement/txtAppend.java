package FileManagement;

// General imports.
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class txtAppend {

    public static void main(String[] args) {
        String filePath = "records.txt";

        // Five new records to append
        // to the existing "records.txt"
        // file.
        String newText = """
                         Sarah,Thompson,03-12-1985,(555) 342-7654,123 Elm St.,Springfield,IL,62704\r
                         James,Wilson,11-05-1992,(555) 847-3921,456 Oak Ave.,Rivertown,TX,75001\r
                         Emily,Garcia,07-22-1990,(555) 210-9814,789 Pine Ln.,Lakeview,FL,33101\r
                         Michael,Johnson,01-14-1980,(555) 674-8293,321 Maple Rd.,Greenfield,WI,53228\r
                         Olivia,Martinez,09-03-1996,(555) 926-5648,101 Birch St.,Clearwater,CO,80903\r
                         """;

        // Append strings of the new records
        // to "records.txt".
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(newText);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}