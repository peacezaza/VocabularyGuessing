package Program;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Guess guess = new Guess();
        String action;
        do {
            System.out.print("1.Play 2.Exit: ");
            action = scan.next();

        } while (guess.execute(action) != true);
    }
}