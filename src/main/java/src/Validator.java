package src;

import java.io.*;

public class Validator {
    public static final String sampleFilePath = "SampleFiles" + File.separator;

    public static boolean validateFind(String find) {
        return find.equalsIgnoreCase("find");
    }

    public static boolean validateQuery(String query, String fileName) {
        if (query.length() <= determineMaxLengthOfLineInFile(fileName)) {
            return true;
        }
        return false;
    }

    //gets the max length of the longest line in the file.
    private static int determineMaxLengthOfLineInFile(String fileName) {
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
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
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
