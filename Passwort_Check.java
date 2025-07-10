package uebung4;
import java.util.Scanner;

//Dieses Programm prüft eingegebene Passwörter auf ihre Sicherheit
public class Passwort_Check {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String passwort;

        while (true) {
            System.out.print("Bitte ein Passwort eingeben: ");
            passwort = scanner.nextLine();

            if (!checkLaenge(passwort)) {
                System.out.println("Das Passwort ist zu kurz.");
                continue;
            }
            if (!checkKleinBuchstaben(passwort)) {
                System.out.println("Es fehlen Kleinbuchstaben.");
                continue;
            }
            if (!checkGrossBuchstaben(passwort)) {
                System.out.println("Es fehlen Großbuchstaben.");
                continue;
            }
            if (!checkZiffer(passwort)) {
                System.out.println("Es fehlen Ziffern.");
                continue;
            }
            if (!checkSonderZeichen(passwort)) {
                System.out.println("Es fehlen Sonderzeichen.");
                continue;
            }

            System.out.println("Passwort ist sicher.");
            //Scanner schließen
            scanner.close(); 
            return;
        }
    }

    // Länge des Passworts prüfen
    public static boolean checkLaenge(String pw) {
        return pw.length() >= 20;
    }

    // auf Kleinbuchstaben prüfen
    public static boolean checkKleinBuchstaben(String pw) {
        return pw.chars().filter(Character::isLowerCase).count() >= 3;
    }

    // auf Großbuchstaben prüfen
    public static boolean checkGrossBuchstaben(String pw) {
        return pw.chars().filter(Character::isUpperCase).count() >= 3;
    }

    // auf Ziffern prüfen
    public static boolean checkZiffer(String pw) {
        return pw.chars().filter(Character::isDigit).count() >= 3;
    }

    // auf Sonderzeichen prüfen (nicht Buchstabe und nicht Ziffer)
    public static boolean checkSonderZeichen(String pw) {
        return pw.chars()
                 .filter(c -> !Character.isLetterOrDigit(c))
                 .count() >= 3;
    }
}
