
package portfölj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author samuelkalebo
 */
public class Portfölj {

    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) throws IOException {
        System.out.println("NORDEA");
        URL url1 = new URL("https://www.cnbc.com/quotes/?symbol=NDA-SE&qsearchterm=nordea");
        URLConnection urlConn = url1.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        String low = "not found";
        String high = "not found";
        String price = "not found";
        String beta = "not found";
        String change = "not found";
        String line = buff.readLine();
        while (line != null) {
            if (line.contains("\"last\"")) {
                int target = line.indexOf("\"last\"");
                int deci = line.indexOf(".", target);
                int start = deci;
                while (line.charAt(start) != '\"') {
                    start--;
                }
                price = line.substring(start + 1, deci + 3);
            }
            if (line.contains("beta")) {
                int target = line.indexOf("beta");
                int deci = line.indexOf(".", target);
                int start = deci;
                while (line.charAt(start) != '\"') {
                    start--;
                }
                beta = line.substring(start + 1, deci + 5);
            }
            if (line.contains("yrhiprice")) {
                int target = line.indexOf("yrhiprice");
                int deci = line.indexOf(".", target);
                int start = deci;
                while (line.charAt(start) != '\"') {
                    start--;
                }
                high = line.substring(start + 1, deci + 3);
            }
            if (line.contains("yrloprice")) {
                int target = line.indexOf("yrloprice");
                int deci = line.indexOf(".", target);
                int start = deci;
                while (line.charAt(start) != '\"') {
                    start--;
                }
                low = line.substring(start + 1, deci + 3);
            }
            if (line.contains("change_pct\":\"")) {
                int target = line.indexOf("change_pct\":\"");
                int deci = line.indexOf(".", target);
                int start = deci;
                while (line.charAt(start) != '\"') {
                    start--;
                }
                change = line.substring(start + 1, deci + 3);
            }
            line = buff.readLine();
        }
        System.out.println("Stock price : " + price);
        System.out.println(BLUE + "52 week High: " + high);
        System.out.println(RED + "52 week Low: " + low);
        System.out.println("Change today: " + change + " % ");
        System.out.println("------------------");

        System.out.println("ISOFOL");
        URL url2 = new URL("https://www.cnbc.com/quotes/?symbol=ISOFOL-SE&qsearchterm=isofol");
        URLConnection urlConn2 = url2.openConnection();
        InputStreamReader inStream2 = new InputStreamReader(urlConn2.getInputStream());
        BufferedReader br = new BufferedReader(inStream2);

        String low2 = "not found";
        String high2 = "not found";
        String price2 = "not found";
        String beta2 = "not found";
        String change2 = "not found";
        String line2 = br.readLine();

        while (line2 != null) {
            if (line2.contains("comments\":\"RIC")) {
                int target = line2.indexOf("comments\":\"RIC");
                int deci = line2.indexOf(".", target);
                int start = deci;
                while (line2.charAt(start) != '\"') {
                    start--;
                }
                price2 = line2.substring(start + 1, deci + 3);
            }
            if (line2.contains("beta")) {
                int target = line2.indexOf("beta");
                int deci = line2.indexOf(".", target);
                int start = deci;
                while (line2.charAt(start) != '\"') {
                    start--;
                }
                beta2 = line2.substring(start + 1, deci + 5);
            }
            if (line2.contains("yrhiprice")) {
                int target = line2.indexOf("yrhiprice");
                int deci = line2.indexOf(".", target);
                int start = deci;
                while (line2.charAt(start) != '\"') {
                    start--;
                }
                high2 = line2.substring(start + 1, deci + 2);
            }
            if (line2.contains("yrloprice")) {
                int target = line2.indexOf("yrloprice");
                int deci = line2.indexOf(".", target);
                int start = deci;
                while (line2.charAt(start) != '\"') {
                    start--;
                }
                low2 = line2.substring(start + 1, deci + 2);
            }
            if (line2.contains("change_pct\":\"")) {
                int target = line2.indexOf("change_pct\":\"");
                int deci = line2.indexOf(".", target);
                int start = deci;
                while (line2.charAt(start) != '\"') {
                    start--;
                }
                change2 = line2.substring(start + 1, deci + 3);
            }
            line2 = br.readLine();
        }
        System.out.println("Stock price: " + price2);
        System.out.println(BLUE + "52 week High: " + high2);
        System.out.println(RED + "52 week Low: " + low2);
        System.out.println("Change today: " + change2 + " % ");
        System.out.println("------------------");

        System.out.println("CYXONE");
        URL url3 = new URL("https://www.cnbc.com/quotes/?symbol=CYXO-SE&qsearchterm=cyxone");
        URLConnection urlConn3 = url3.openConnection();
        InputStreamReader inStream3 = new InputStreamReader(urlConn3.getInputStream());
        BufferedReader br1 = new BufferedReader(inStream3);

        String low3 = "not found";
        String high3 = "not found";
        String price3 = "not found";
        String beta3 = "not found";
        String change3 = "not found";
        String line3 = br1.readLine();

        while (line3 != null) {
            if (line3.contains("comments\":\"RIC")) {
                int target = line3.indexOf("comments\":\"RIC");
                int deci = line3.indexOf(".", target);
                int start = deci;
                while (line3.charAt(start) != '\"') {
                    start--;
                }
                price3 = line3.substring(start + 1, deci + 3);
            }
            if (line3.contains("beta")) {
                int target = line3.indexOf("beta");
                int deci = line3.indexOf(".", target);
                int start = deci;
                while (line3.charAt(start) != '\"') {
                    start--;
                }
                beta3 = line3.substring(start + 1, deci + 5);
            }
            if (line3.contains("yrhiprice")) {
                int target = line3.indexOf("yrhiprice");
                int deci = line3.indexOf(".", target);
                int start = deci;
                while (line3.charAt(start) != '\"') {
                    start--;
                }
                high3 = line3.substring(start + 1, deci + 2);
            }
            if (line3.contains("yrloprice")) {
                int target = line3.indexOf("yrloprice");
                int deci = line3.indexOf(".", target);
                int start = deci;
                while (line3.charAt(start) != '\"') {
                    start--;
                }
                low3 = line3.substring(start + 1, deci + 2);
            }
            if (line3.contains("change_pct\":\"")) {
                int target = line3.indexOf("change_pct\":\"");
                int deci = line3.indexOf(".", target);
                int start = deci;
                while (line3.charAt(start) != '\"') {
                    start--;
                }
                change3 = line3.substring(start + 1, deci + 3);
            }
            line3 = br1.readLine();
        }
        System.out.println("Stock price : " + price3);
        System.out.println(BLUE + "52 week High: " + high3);
        System.out.println(RED + "52 week Low: " + low3);
        System.out.println("Change today: " + change3 + " % ");
        System.out.println("------------------");

        System.out.println("OMX30");
        URL url4 = new URL("https://www.cnbc.com/quotes/?symbol=.OMXS30&qsearchterm=omx");
        URLConnection urlConn4 = url4.openConnection();
        InputStreamReader inStream4 = new InputStreamReader(urlConn4.getInputStream());
        BufferedReader br2 = new BufferedReader(inStream4);

        String low4 = "not found";
        String high4 = "not found";
        String price4 = "not found";
        String beta4 = "not found";
        String change4 = "not found";
        String line4 = br2.readLine();

        while (line4 != null) {
            if (line4.contains("comments\":\"RIC")) {
                int target = line4.indexOf("comments\":\"RIC");
                int deci = line4.indexOf(".", target);
                int start = deci;
                while (line4.charAt(start) != '\"') {
                    start--;
                }
                price4 = line4.substring(start + 1, deci + 3);
            }
            if (line4.contains("beta")) {
                int target = line4.indexOf("beta");
                int deci = line4.indexOf(".", target);
                int start = deci;
                while (line4.charAt(start) != '\"') {
                    start--;
                }
                beta4 = line4.substring(start + 1, deci + 5);
            }
            if (line4.contains("yrhiprice")) {
                int target = line4.indexOf("yrhiprice");
                int deci = line4.indexOf(".", target);
                int start = deci;
                while (line4.charAt(start) != '\"') {
                    start--;
                }
                high4 = line4.substring(start + 1, deci + 2);
            }
            if (line4.contains("yrloprice")) {
                int target = line4.indexOf("yrloprice");
                int deci = line4.indexOf(".", target);
                int start = deci;
                while (line4.charAt(start) != '\"') {
                    start--;
                }
                low4 = line4.substring(start + 1, deci + 2);
            }
            if (line4.contains("change_pct\":\"")) {
                int target = line4.indexOf("change_pct\":\"");
                int deci = line4.indexOf(".", target);
                int start = deci;
                while (line4.charAt(start) != '\"') {
                    start--;
                }
                change4 = line4.substring(start + 1, deci + 3);
            }
            line4 = br2.readLine();
        }
        System.out.println("Stock price : " + price4);
        System.out.println(BLUE + "52 week High: " + high4);
        System.out.println(RED + "52 week Low: " + low4);
        System.out.println("Change today: " + change4 + " % ");

    }
}
