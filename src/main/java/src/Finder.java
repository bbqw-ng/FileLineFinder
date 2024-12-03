package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {
    public Finder() {
    }

    public ArrayList<String> find(String commandQuery, String commandFile) {
        File myFile = new File(Validator.sampleFilePath + commandFile);
        HashSet<String> noDuplicateLines= new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(" ");
                ArrayList<String> wordContainer = new ArrayList<>(Arrays.asList(splitLine));
                if (wordContainer.contains(commandQuery)) {
                    noDuplicateLines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> reversed = new ArrayList<>(noDuplicateLines);
        Collections.reverse(reversed);
        return reversed;
    }
}

