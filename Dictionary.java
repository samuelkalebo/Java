// Glosträning Svenska - Engelska.
package assignment.pkg4.dictionary;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/**
 * Detta är ett program som läser upp ett ord på svenska och som sedan ber
 * användaren skriva in den engelska översättningen. programmet kontrollerar
 * sedan om användarens svar stämmer överens med "facit" och ger statistik på
 * antal rätta svar.
 * @author Samuel Kälebo
 * @version 2019-12-27
 */
public class Dictionary {

    /**
     * Ge följande utskrivt vid programstart
     */
    public void showintro() {
        System.out.println("** GLOSÖVNING - ENGELSKA**");
        System.out.println("Skriv in det engelska ordet. Avsluta programmet genom att skriva Quit");
    }

    /**
     * Jämför input med engelsk översättning och ge ett meddelande om resultat.
     * @param kartan lagrar glosorna och översättning i en hashmap
     * @return värdet points
     */
    public int askuser(Map kartan) {
        int points = 0;
        Scanner sc = new Scanner(System.in);
        for (Object value : kartan.keySet()) {
            System.out.println("Det svenska ordet Är: " + value);
            String svara;
            System.out.print("Vad är den engelska Översättningen? ");
            String engelsktOrd = kartan.get(value).toString();
            svara = sc.next();
            if (svara.equalsIgnoreCase("Quit")) {
                System.out.println("Bye!");
                System.exit(0);
            } else if (svara.equals(engelsktOrd)) {
                points = points + 1;
                System.out.println("Korrekt");
                System.out.println("Antal rätt:" + points);
            }
            Distance distanceObject = new Distance();
            int diffen = distanceObject.LD(engelsktOrd, svara);
            if (diffen <= 2 && diffen > 0) {
                System.out.println("Nästan rätt");
                System.out.println("Antal rätt:" + points);
            } else if (!svara.equals(engelsktOrd)) {
                System.out.println("Fel svar");
                System.out.println("Antal rätt:" + points);
            }
        }
        sc.close();
        return points;
    }

    /**
     * Avsluta programet
     */
    public void plzdie() {
        System.exit(0);
    }
}

/**
 * Detta är ett program som läser upp ett ord på svenska och som sedan ber
 * användaren skriva in den engelska översättningen. programmet kontrollerar
 * sedan om användarens svar stämmer överens med "facit" och ger statistik på
 * antal rätta svar.
 * @author Samuel Kälebo
 * @version 2019-12-28
 */
class Main {

    /**
     * Startar programmet
     * @param args inte använda
     */
    public static void main(String[] args) {
        vocabularyTraining();
    }

    /**
     * kör programmet
     */
    public static void vocabularyTraining() {
// Lagra svenska ord och respektive engelsk översättning som keys och values i en hashmap 
        Dictionary DictionaryObject = new Dictionary();
        DictionaryObject.showintro();
        Map<String, String> kartan = new HashMap<String, String>();
        kartan.put("båt", "boat");
        kartan.put("telefon", "phone");
        kartan.put("fönster", "window");
        kartan.put("program", "program");
        kartan.put("dator", "computer");
        kartan.put("penna", "pencil");
        kartan.put("trappa", "stairs");
        kartan.put("dörr", "door");
        kartan.put("ord", "word");
        kartan.put("papper", "paper");
        int points = DictionaryObject.askuser(kartan);
        System.out.println("Du fick " + points + " poäng av " + kartan.size());
        DictionaryObject.plzdie();
    }

}

/**
 * Beräkna skillnaden mellan imput och facit för att avgöra om användarens svar
 * "nästan är rätt"
 * @author Samuel Kälebo
 * @version 2019-12-28
 */
class Distance {

    /**
     * beräknar den minsta antalet som behöver ändras för att ändra ett ord till
     * ett annat.
     */
    public int Minimum(int a, int b, int c) {
        int mi;
        mi = a;
        if (b < mi) {
            mi = b;
        }
        if (c < mi) {
            mi = c;
        }
        return mi;
    }

    /**
     * beräknar skillnaden i mellan två angivna strings.
     */
    public int LD(String s, String t) {
        int d[][]; // matrix
        int n; // length of s
        int m; // length of t
        int i; // iterates through s
        int j; // iterates through t
        char s_i; // ith character of s
        char t_j; // jth character of t
        int cost; // cost
        n = s.length();
        m = t.length();
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        d = new int[n + 1][m + 1];
        for (i = 0; i <= n; i++) {
            d[i][0] = i;
        }
        for (j = 0; j <= m; j++) {
            d[0][j] = j;
        }
        for (i = 1; i <= n; i++) {
            s_i = s.charAt(i - 1);
            for (j = 1; j <= m; j++) {
                t_j = t.charAt(j - 1);
                if (s_i == t_j) {
                    cost = 0;
                } else {
                    cost = 1;
                }

                d[i][j] = Minimum(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + cost);
            }
        }
        return d[n][m];
    }

}
