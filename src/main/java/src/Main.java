package src;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Finder finder = new Finder();
        System.out.println("Enter 'STOP' to stop.\n");
        while (true) {
            System.out.println("Enter command name here (find): ");
            String commandName = scan.nextLine();
            if (commandName.equalsIgnoreCase("stop")) {
                System.out.println("System terminating...");
                System.exit(0);
            } else {
                System.out.println("Enter query here: ");
                String commandQuery = scan.nextLine();
                System.out.println("Enter file name here: ");
                String commandFileName = scan.nextLine();
                if (!Validator.validateFind(commandName)) {
                    System.out.println("Invalid command name. Please try again.\n");
                } else if (!Validator.validateFileExists(commandFileName)) {
                    System.out.println("Invalid file name. Please try again.\n");
                } else if (!Validator.validateQuery(commandQuery, commandFileName)) {
                    System.out.println("Invalid query. Please try again.\n");
                } else {
                    HashSet<String> lines = finder.find(commandName, commandQuery, commandFileName);
                    printLines(lines);
                }
            }
        }
    }

    private static void printLines(HashSet<String> lines) {
        System.out.println("Printing all lines");
        System.out.println("---------------------------------------");
        for (String line: lines) {
            System.out.println(line);
        }
        System.out.println("---------------------------------------");
    }
}