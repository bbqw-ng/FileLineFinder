package src;

import java.io.*;
import java.util.ArrayList;

public class Validator {
    public static final String sampleFilePath = "SampleFiles" + File.separator;

    public static boolean validateCommand(ArrayList<String> commandParts) {
        if (validateFind(commandParts.get(0))) {
            if (validateFileExists(commandParts.get(2))) {
                return validatePattern(commandParts.get(1), commandParts.get(2));
            }
        }
        return false;
    }

    public static boolean validateFind(String find) {
        return find.equalsIgnoreCase("find");
    }

    public static boolean validatePattern(String query, String fileName) {
        return query.length() <= determineMaxLengthOfLineInFile(fileName);
    }

    public static int determineMaxLengthOfLineInFile(String fileName) {
        File myFile = new File(sampleFilePath + fileName);
        int maxLength = 0;

        if (validateFileExists(fileName)){
            try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Check if the current line is longer than the current max length
                    if (line.length() > maxLength) {
                        maxLength = line.length();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return maxLength;
        } else {
            return 0;
        }
    }

    public static boolean validateFileExists(String fileName) {
        File myFile = new File(sampleFilePath + fileName);
        return myFile.exists();
    }
}
