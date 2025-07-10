import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindrome(String text) {
        // Text bereinigen: Leerzeichen entfernen, Kleinbuchstaben
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.prinln("Geben Sie einen Text ein: ");
        String test = scanner.nextLine();
        
        if (isPalindrome(test)) {
            System.out.println("\"" + test + "\" ist ein Palindrom.");
        } else {
            System.out.println("\"" + test + "\" ist kein Palindrom.");
        }
    }
}
