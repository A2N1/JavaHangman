import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to Hangman! You have 6 lives to guess the word. Good Luck!");
        File dictionary = new File("C:\\Development\\Java\\Hangman\\dictionary.txt");

        // Scanner zum Lesen der Datei und für die Benutzereingabe
        Scanner textScanner = new Scanner(dictionary);
        Scanner input = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>();
        // Wörter aus der Datei einlesen
        while (textScanner.hasNextLine()) {
            String word = textScanner.nextLine().trim();
            if (!word.isEmpty()) {
                words.add(word);
            }
        }
        
        textScanner.close(); // Schließen des Scanners nach dem Einlesen

        // Überprüfen, ob Wörter geladen wurden
        if (words.isEmpty()) {
            System.out.println("The dictionary file is empty or contains only empty lines. Please add some words to the file.");
            return; // Programm beenden, wenn keine Wörter vorhanden sind
        }

        // Ein zufälliges Wort auswählen
        String hidden_text = words.get((int) (Math.random() * words.size()));
        char[] textArray = hidden_text.toCharArray();
        char[] myAnswers = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            myAnswers[i] = '?'; // Setze Platzhalter
        }

        boolean finished = false;
        int lives = 6;

        while (!finished) {
            System.out.println("*************************");

            // Eingabe des Benutzers
            System.out.print("Enter a letter (or 'exit' to quit): ");
            String letter = input.next();
            if (letter.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing!");
                finished = true;
                break; // Beenden des Spiels
            }

            // Eingabevalidierung
            while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                System.out.print("Invalid input, please enter a letter: ");
                letter = input.next();
            }

            // Überprüfen, ob der Buchstabe im Wort enthalten ist
            boolean found = false;
            for (int i = 0; i < textArray.length; i++) {
                if (letter.charAt(0) == textArray[i]) {
                    myAnswers[i] = textArray[i];
                    found = true;
                }
            }

            if (!found) {
                lives--;
                System.out.println("Not the correct letter");
            }

            boolean done = true; // Überprüfen, ob das Wort vollständig erraten wurde
            for (int i = 0; i < myAnswers.length; i++) {
                if (myAnswers[i] == '?') {
                    System.out.print(" _");
                    done = false; // Noch nicht fertig
                } else {
                    System.out.print(" " + myAnswers[i]);
                }
            }

            System.out.println("\nLives Left: " + lives);
            drawHangman(lives);

            // Überprüfen, ob das Spiel zu Ende ist
            if (done) {
                System.out.println("Congratulations! You found the word and won!");
                finished = true;
            } else if (lives <= 0) {
                System.out.println("You are dead! The word was: " + hidden_text + ". Nice Try!");
                finished = true;
            }
        }

        // Scanner für die Benutzereingabe nach Ende des Spiels schließen
        input.close();
    }

    public static void drawHangman(int l) {
        if (l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}
