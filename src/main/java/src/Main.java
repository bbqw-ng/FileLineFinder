package src;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        final Finder finder = new Finder();
        System.out.println("Please type a command 'find query filename', query can have quotes surrounding it to include spaces.");
        String command = scan.nextLine();
        System.out.println(command);
    }

    private static void printLines(ArrayList<String> lines) {
        for (String line: lines) {
            System.out.println(line);
        }
    }
}