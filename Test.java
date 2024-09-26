import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to the Word Loader Test!");
        File dictionary = new File("C:\\Development\\Java\\Hangman\\dictionary.txt");

        // Überprüfen, ob die Datei existiert
        if (!dictionary.exists()) {
            System.out.println("The dictionary file does not exist. Please check the file path.");
            return;  // Programm beenden, wenn die Datei nicht existiert
        }

        // Scanner zum Lesen der Datei
        Scanner textScanner = new Scanner(dictionary);
        ArrayList<String> words = new ArrayList<>();

        // Wörter aus der Datei in die Liste einlesen
        while (textScanner.hasNextLine()) {
            String word = textScanner.nextLine().trim();  // Entfernen von Leerzeichen
            if (!word.isEmpty()) {  // Nur nicht-leere Wörter hinzufügen
                words.add(word);
            }
        }

        // Scanner schließen
        textScanner.close();

        // Überprüfen, ob die Liste leer ist
        if (words.isEmpty()) {
            System.out.println("The dictionary file is empty or contains only empty lines. Please add some words to the file.");
        } else {
            // Wörter ausgeben, um sicherzustellen, dass sie korrekt geladen wurden
            System.out.println("Words loaded:");
            for (String word : words) {
                System.out.println(word);  // Ausgabe jedes geladenen Wortes
            }
        }
    }
}
