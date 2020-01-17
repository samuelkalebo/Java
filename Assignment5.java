// Filmdatabas som innehåller titlar och betyg samt sparar till disk
package test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Detta är ett program där användaren kan söka efter filmer baserat på titlar och betyg.
 * Användaren kan även addera ytterliggare filmer till programmet genom att ange titel och betyg.
 * Detta lagras då i en databasfil.
 * @author samuelkalebo
 * @version 2020-01-16
 */
public class Assignment5 {

    /**
     * Mainfunktionen som startar programmet, om filläsning blir felaktig kasta
     * då ett felmeddelande som ett IOExecption. Programmet anropar class
     * MovieDatabaseUI där all funktionalitet finns.
     */
    public static void main(String[] args) throws IOException {
        //Construct and start the UI
        new MovieDatabaseUI().startUI();
    }
}

/**
 * Funktionsclassen MovieDatabaseUI
 * @author samuelkalebo
 * @version 2020-01-16
 */
class MovieDatabaseUI {
    private Scanner _scanner;

    /**
     * Skapa MovieDatabaseUI där allt innehåll finns.
     */
    public MovieDatabaseUI() {
    }
    /**
     * Skapa startfunktion som anropas i main.
     */
    public void startUI() throws IOException {
        _scanner = new Scanner(System.in);
        int input;
        boolean quit = false;
//  Här skapas en hashmap som lagrar unika filmtitlar samt betyg 
//  av typerna string och integer
        Map<String, Integer> kartan = new HashMap<String, Integer>();
//  Här har olika filmer lagrats för test
//  kartan.put("The Dark Knight", 5);
//  kartan.put("Kill Bill", 4);
//  kartan.put("Snabba Cash", 5);
        Path currentRelativePath = Paths.get("");
        String cwd = currentRelativePath.toAbsolutePath().toString();
//  Databasen sparas i nuvarande map som programmet körs i
        try (BufferedReader br = new BufferedReader(new FileReader(cwd + "/databas.db"))) {
            String line;
//  Databasen läses in och sparas i hashmap           
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                String title = parts[0];
                String betyg = parts[1];
                int foo = Integer.parseInt(betyg);
                kartan.put(title, foo);
            }
        }
        System.out.println("** FILMDATABAS **");
//  Input valideras och fördelas till respektive funktioner     
        while (!quit) {
            input = getNumberInput(_scanner, 1, 4, getMainMenu());
            switch (input) {
                case 1: searchTitel(kartan);
                    break;
                case 2: searchReviewScore(kartan);
                    break;
                case 3: addMovie(kartan);
                    break;
                case 4: quit = true;
            }
        }
        System.out.println("Progammet avslutat");
        _scanner.close();
    }

    /**
     * Hämtar input-numret användaren angivit
     * @param scanner hämta input
     * @param min minst tillåtna nummer
     * @param max högsta tillåtna nummer
     * @param message sting-meddelande till användaren
     * @return returnerar det angivna numret
     */
    private int getNumberInput(Scanner scanner, int min, int max, String message) {
        int input = -1;
        while (input < 0) {
            System.out.println(message);
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException nfe) {
                input = -1;
            }
            if (input < min || input > max) {
                System.out.println("Ogiltigt värde.");
            }
        }
        return input;
    }

    /**
     * Söker i hashmap efter titlar baserat på string-input
     */
    private void searchTitel(Map kartan) {
        System.out.print("Ange sökord: ");
        String title = _scanner.nextLine().trim();
//  loopar hashmap      
        for (Object value : kartan.keySet()) {
//  string konverteras till lowercase för matcha korrekt       
            if (value.toString().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Titel:" + value);
                String betyg = kartan.get(value).toString();
                System.out.println("Betyg:" + betyg + "/5");
            }
        }
    }

    /**
     * Söker i hashmap efter betyg baserat på nummerbaserad input
     */
    private void searchReviewScore(Map kartan) {
        int review = getNumberInput(_scanner, 1, 5, "Ange minimibetyg (1 - 5): ");
        for (Object value : kartan.keySet()) {
//  Undersök om betyg stämmer med input          
            if (kartan.get(value).equals(review)) {
                System.out.println("Titel:" + value);
                String betyg = kartan.get(value).toString();
                System.out.println("Betyg:" + betyg + "/5");
            }
        }
    }

    /**
     * Lagra film i hashmap och spara databas till disk
     */
    private void addMovie(Map kartan) {
        System.out.print("Titel: ");
        String title = _scanner.nextLine().trim();
        int reviewScore = getNumberInput(_scanner, 1, 5, "Betyg (1 - 5): ");
        kartan.put(title, reviewScore);
        System.out.println("Filmen är nu tillagd");
        Path currentRelativePath = Paths.get("");
        String cwd = currentRelativePath.toAbsolutePath().toString();
        File file = new File(cwd + "/databas.db");
        BufferedWriter bf = null;
        try { 
            bf = new BufferedWriter(new FileWriter(file));
            for (Object entry : kartan.keySet()) {
                bf.write(entry + ":" + kartan.get(entry));
                bf.newLine();
            }
            bf.flush();
//  Vid problem med filsystem, kasta ut ett IOException           
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (Exception e) {
            }
        }
    }   

    /**
     * Ge denna utskrift vid programstart
     */
    private String getMainMenu() {
        return "-------------------\n"
                + "1. Sök på titel\n"
                + "2. Sök på betyg\n"
                + "3. Lägg till film\n"
                + "-------------------\n"
                + "4. Avsluta";
    }
}
