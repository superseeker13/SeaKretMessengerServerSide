package test.Account;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
/**
 * @author Daniel Tomlinson
 * @author Edward Conn
 */

public class csvFileReader {
     
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    
   
    public static boolean isUsernameTaken(String fileName, String username) {
 
        BufferedReader fileReader;
        //Create a new HashMap of accounts to be filled by CSV file data
        Map<String,String> accountMap = new HashMap<>();
        String line;
      
        try {
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));
             
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new account and add to HashMap
                    accountMap.put(tokens[0],tokens[1]);
                }
            }
            fileReader.close();
        } 
        catch (IOException e) {
            System.out.println("Error in CsvFileReader !!!");
        }
    return accountMap.containsKey(username);
    }
}