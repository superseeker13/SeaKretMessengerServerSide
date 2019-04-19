package babycakes.seakretmess.Account;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
/**
 * @author Daniel Tomlinson
 * @author Edward Conn
 */
public class csvFileWriter {
     
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
     
    //CSV file header
    private static final String FILE_HEADER = "username,password";
 
    public static void writeCsvFile(String fileName, String username, String password) {
         
        //Create a new HashMap of accounts
        Map<String,String> accountMap = new HashMap<>();
            accountMap.put(username,password);  
         
        FileWriter fileWriter;
                 
        try {
            fileWriter = new FileWriter(fileName, true);
             
            //Write a new accountHashMap to a file
            for (Map.Entry<String, String> entry:accountMap.entrySet()) {
                String key = entry.getKey();  
                String value = entry.getValue();
                fileWriter.append(key);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(value);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
    
            System.out.println("CSV file was created successfully !!!");
             
            fileWriter.flush();
            fileWriter.close();
            
        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
        }
    }
}
