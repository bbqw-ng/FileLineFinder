package src;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Finder finder = new Finder();
        System.out.println( "--------------------");
        System.out.println("Enter 'STOP' to stop.");
        System.out.println( "--------------------\n");
        while (true) {
            System.out.println("Please type in a command in the form 'find pattern file'");
            String input = scan.nextLine();
            ArrayList<String> reformatted = reformatCommand(input);
            ArrayList<String> linesFound = finder.find(reformatted.get(1), reformatted.get(2));
            printLines(linesFound);
        }
    }

    public static ArrayList<String> reformatCommand(String command) {
        ArrayList<String> components = new ArrayList<>();
        try {
            //grabs "find" last character is excluded
            String findPart = command.substring(0, 4);
            if (!findPart.equals("find")) {
                throw new Exception();
            }
            components.add(findPart);

            String restOfString = command.substring(5);

            String newFormattedString = "";
            Stack<String> quoteStack = new Stack<>();
            boolean swap = false;
            boolean quoted = false;
            for (int i = 0; i < restOfString.length(); i++) {
                if (i + 2 <= restOfString.length() && restOfString.substring(i, i+2).equals("\"\"")) {
                    newFormattedString += "\"";
                    i++;
                } else {
                    if (restOfString.substring(i, i+1).equals("\"")) {
                        //if false mean opening quote so add, true means need closing quote so pop.
                        if (!swap) {
                            quoteStack.add("\"");
                            swap = true;
                        } else {
                            quoteStack.pop();
                            swap = false;
                            quoted = true;
                        }
                    } else {
                        newFormattedString += restOfString.charAt(i);
                    }
                }
            }

            String[] commandSplit = command.split(" ");
            String fileName = commandSplit[commandSplit.length-1];
            String pattern = newFormattedString.substring(0,newFormattedString.length()-fileName.length()-1);
            String[] splitPattern = pattern.split("");
            ArrayList<String> checkForSpace = new ArrayList<>(Arrays.asList(splitPattern));
            //means there is an unclosed quote
            if (!quoteStack.isEmpty())
                throw new Exception();
            else if (!quoted && checkForSpace.contains(" "))
                throw new Exception();

            components.add(pattern);
            components.add(fileName);
            return components;

        } catch (Exception e) {
            System.out.println("Invalid command format. Please try again.");
            return null;
        }
    }

    private static void printLines(ArrayList<String> lines) {
        System.out.println("Printing all lines containing pattern:");
        System.out.println("---------------------------------------");
        for (String line: lines) {
            System.out.println(line);
        }
        System.out.println("---------------------------------------");
    }
}