import java.util.Scanner;

public class Time {


//Uhrzeit checke. Gültige Uhzeiten: 0:00 - 23:59

	
	public static void main(String[] args) {
		
		Scanner eingabe = new Scanner(System.in);
		
		System.out.print("Geben Sie eine Zeit ein: ");
		String time = eingabe.nextLine();
		
		System.out.println(timeCheck(time));
		
	}

	public static boolean timeCheck(String time) {
		boolean match = time.matches("(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]");
		return match;
	}

}
