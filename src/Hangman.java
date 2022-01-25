import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangmans {
    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();
        String word = Files.readAllLines(Paths.get("C:\\Users\\mubas\\Documents\\Coding\\Intellij Workspaces\\Primary Intellij Workspace\\Hangman\\Words.txt")).get(random.nextInt(12));
        System.out.println("Hangman Game");
        System.out.println();
        char[] letters = word.toCharArray();
        int correctCount = 0;
        int wrong = 0;

        List<Character> letter = new ArrayList<Character>();
        for (char c : letters) {
            letter.add(c);
        }

        List<Character>dashes = new ArrayList<Character>();
        for (int i = 0; i < letter.size(); i++) {
            dashes.add('_');
        }

        for (int i = 0; i < dashes.size() ; i++) {
            System.out.print(dashes.get(i));
        }


        while (true) {
            char attempt = keyboard.next().charAt(0);
            for (int i = 0; i < letter.size(); i++) {
                if (attempt == letter.get(i)) {
                    dashes.set(i,attempt);
                    correctCount++;
                }
            }

            for (int i = 0; i < dashes.size(); i++) {
                System.out.print(dashes.get(i));
            }

            if (correctCount == word.length()){
                System.out.println();
                System.out.println("Yay you Win !!");
                break;
            }

            if (!(letter.contains(attempt))) {
                System.out.println();
                System.out.println("Wrong Letter Try again");
                wrong++;
                drawHangman(wrong);
                System.out.println();

                if (wrong == 6) {
                    System.out.println();
                    System.out.println("You Lose");
                    System.out.println("The Word was" + word);
                    break;
                }
            }
        }
    }

    public static void drawHangman(int l) {
        if (l == 0) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");

        } else if (l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|  --|");
            System.out.println("|");
        } else if (l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|  --|--");
            System.out.println("|");
        } else if (l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|  --|--");
            System.out.println("|   /");
        } else {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|  --|--");
            System.out.println("|   / \\");
        }
    }
}
