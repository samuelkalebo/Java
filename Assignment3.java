
//Spelet sten, sax, påse där användaren kan spela mot datorn

import java.util.Random;
import java.util.Scanner;

/**
 * Detta är ett program som läser in en mening från användaren i form av tre olika alternativ,
 * tillger varje alternativ ett värde och jämför detta mot datorns slumpade alternativ.
 * Kontrollerar sedans om användarens inmatade eller datorns slumpade alternativ har högst värde.
 * Programet ger sedan ett meddelande om vem som "van". Bäst av 5 vinner totalt.
 * @author Samuel Kälebo
 * @version 2019-12-10
 */

public class Assignment3 {

/**
 * Startar programmet
 * @param args inte använda
 */
    public static void main(String[] args) {
        rockPaperScissors ();
    }

/**
 * kör programmet
 */
    public static void rockPaperScissors() {
        Scanner scanner = new Scanner(System.in);
        String inputString = "";
        int[] score;
        String[] alternatives = {"rock", "scissors", "paper"};
        String[] methods = {"crushes", "cuts", "covers"};
        boolean quit = false, isWinner;

//  Avsluta programet vid felaktigt värde. Metod utskrift sker - och dess system.out.println sker. 
        while (!quit) {
            utskrift();
            isWinner = false;
            score = new int[2];
//  Kör programet på nytt vid felaktigt värde.
//  Ber användaren ange ett alternativ.
            while (!quit && !isWinner) {
                System.out.println("Make your choice (rock, paper or scissors): ");
                inputString = scanner.nextLine().trim();
//  Avsluta programet utan omstart om användaren anger "Quit"
                if (inputString.equalsIgnoreCase("Quit")) {
                    System.out.println("Bye!");
                    quit = true;
                } else {
                    int input = -1;
//  Konvertera annars imput till ett värde.
                    for (int i = 0; i < alternatives.length; i++) {
                        if (alternatives[i].equalsIgnoreCase(inputString)) {
                            input = i;
                        }
                    }
//  Återge felmeddelande om användaren ej anger en mening.
                    if (input == -1) {
                        System.out.println("Invalid input. Valid input is rock, paper or scissors.");
                    } else {

//  Slumpa annars ett alternativ "från datorns sida" och läs upp ett meddeland som talar om vilket.
                        int computerChoice = new Random().nextInt(3);
                        System.out.println("Computer chooses " + alternatives[computerChoice] + ".");

//  Om värdet av datorns val - 1 = värdet av imput eller om datorns val + 2 = värdet av imput,
//  ge ett meddelande om att datorn van. 
//  Om värdet av datorns val = värdet av imput, ge ett meddelande om att ingen vinnare finns. 
                        if ((computerChoice - 1) == input || (computerChoice + 2) == input) {
                            score[0]++; 
                            System.out.println("Your " + alternatives[input] + " " + methods[input] + " computers "
                                    + alternatives[computerChoice] + " (" + score[0] + " - " + score[1] + ").");
                        } else if (computerChoice == input) {
                            System.out.println("Same choise, no winner.");
                        } else {
//  Om datorn van spelet, addera då en 1:a på datorns score och ge ett meddelande om  detta. 
                            score[1]++;
                            System.out.println("Computers " + alternatives[computerChoice] + " " + methods[computerChoice]
                                    + " your " + alternatives[input] + " (" + score[0] + " - " + score[1] + ").");
                        }
                        isWinner = calculateWinner(score);
                    }
                }
            }
        }
        scanner.close();
    }

/**
 * Ge följande utskrivt vid programstart
 */
    public static void utskrift() {
        System.out.println("** WELCOME TO ROCK-PAPER-SCISSORS **");
        System.out.println("The game where rock crushes scissors, scissors cuts paper and paper covers rock. Best of five wins.");
        System.out.println("Terminate program by typing Quit.");
    }

/**
 * Beräkna vem som vunnit totalt och ge en utskrift om detta. 
 * @param antalVinster beräknar antalet totala vinster
 * @return True om någon fått 3 vinster
 */ 
    public static boolean calculateWinner(int[] antalVinster) {
//  Om datorn har vunnit 3 gånger, återge ett meddelande om att datorn vunnit
        if (antalVinster[0] == 3 || antalVinster[1] == 3) {
            String winner = "Computer";
//  Om användaren vunnit 3 gånger, återge ett meddelande om att du vunnit. 
            if (antalVinster[0] == 3) {
                winner = "You";
            }
            System.out.println(winner + " have won (" + antalVinster[0] + " - " + antalVinster[1] + ")!");
            return true;
        } else {
            return false;
        }
    }
}
