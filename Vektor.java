import java.util.Scanner;

public class Vektor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner eingabe = new Scanner(System.in);
		Scanner eingabe2 = new Scanner(System.in);
		int[]vector1 = null;
		int[]vector2 = null;
		int scalar = 0;
		int[][]matrix = null;
		
		while(true) {
			System.out.println("Bitte wählen Sie die gewünschte Methode aus, um fortzufahren:");
			System.out.println("1. Skalarmultiplikation");
			System.out.println("2. Kreuzprodukt zweier Vektoren");
			System.out.println("3. Vektor Länge");
			System.out.println("4. Matrix multiplikation");
			System.out.println("5. Schließen");
			System.out.print("Eingabe: ");
			int wahl = eingabe.nextInt();
			
			//1.Skalarmultiplikation
			
			if(wahl == 1) {
				System.out.println("Einen neun Vektor erstellen ? [Y/N]");
				System.out.print("Eingabe: ");
				String wahl2 = eingabe2.nextLine();
				if(wahl2.toUpperCase().equals("Y")) {
					System.out.print("Wie viele Zahlen wollen Sie eingeben: ");
					int wahl3 = eingabe.nextInt();
					int position = 0;
					vector1 = new int[wahl3];
					while(position < wahl3) {
						System.out.print((position+1) + " Zahl für Vektor1: ");
						int wahl4 = eingabe.nextInt();
						vector1[position] = wahl4;
						position++;
					}
					System.out.print("Geben Sie ein multiplikator ein: ");
					int wahl5 = eingabe.nextInt();
					System.out.println("Ergebnis: ");
					scalarMultiplication(vector1, wahl5);
					System.out.println("");
				}
				else if(wahl2.toUpperCase().equals("N") && vector1 != null) {
					System.out.print("Geben Sie ein multiplikator ein: ");
					int wahl5 = eingabe.nextInt();
					scalarMultiplication(vector1, wahl5);
				}
				else {
					System.out.println("Ungültige Eingabe oder Vector ist leer");
				}
			}
			
			//2. Kreuzprodukt
			
			else if(wahl == 2) {
				System.out.print("Wie viele Zahlen wollen Sie eingeben: ");
				int wahl2 = eingabe.nextInt();
				int position = 0;
				vector1 = new int[wahl2];
				while(position < wahl2) {
					System.out.print((position+1) + " Zahl für Vektor1: ");
					int wahl3 = eingabe.nextInt();
					vector1[position] = wahl3;
					position++;
				}
				position = 0;
				vector2 = new int[wahl2];
				while(position < wahl2) {
					System.out.print((position+1) + " Zahl für Vektor2: ");
					int wahl3 = eingabe.nextInt();
					vector2[position] = wahl3;
					position++;
				}
				System.out.println("Ergebnis: ");
				vectorProduct(vector1,vector2);
				System.out.println("");
			}
			
			//3. Vektor Länge
			
			else if(wahl == 3) {
				System.out.print("Wie viele Zahlen wollen Sie eingeben: ");
				int wahl2 = eingabe.nextInt();
				int position = 0;
				vector1 = new int[wahl2];
				while(position < wahl2) {
					System.out.print((position+1) + " Zahl für Vektor1: ");
					int wahl3 = eingabe.nextInt();
					vector1[position] = wahl3;
					position++;
				}
				System.out.println(vectorLength(vector1));
			}
			
			//4. Matrix Pultiplikation
			
			else if(wahl == 4) {
				System.out.println("Ein neuen Matrix erstellen ? [Y/N]");
				System.out.print("Eingabe: ");
				String wahl5 = eingabe2.nextLine();
				
				if(wahl5.toUpperCase().equals("Y")) {
					System.out.print("Wie viele Spalten soll der matrix haben: ");
					int wahl2 = eingabe.nextInt();
					System.out.print("Wie viele Zeilen soll der matrix haben: ");
					int wahl3 = eingabe.nextInt();
					matrix = new int[wahl3][wahl2];
					int positionZeilen = 0;
					while(positionZeilen < wahl3) {
						int positionSpalten = 0;
						while(positionSpalten < wahl2) {
							System.out.print((positionSpalten+1) + " Zahl in Zeile " + (positionZeilen+1) + " für Matrix: ");
							int wahl4 = eingabe.nextInt();
							matrix[positionZeilen][positionSpalten] = wahl4;
							positionSpalten++;
						}
						positionZeilen++;
					}
					System.out.print("Geben Sie ein multiplikator ein: ");
					int wahl6 = eingabe.nextInt();
					System.out.println("Ergebnis: ");
					matrixMultiplication(matrix,wahl6);
				}
				else if(wahl5.toUpperCase().equals("N") && matrix != null) {
					System.out.print("Geben Sie ein multiplikator ein: ");
					int wahl6 = eingabe.nextInt();
					System.out.println("Ergebnis: ");
					matrixMultiplication(matrix,wahl6);
				}
				else {
					System.out.println("Ungültige Eingabe oder Matrix ist leer");
				}
			}
			
			//5. Schließen
			
			else if(wahl == 5) {
				System.out.println("Programm schließt");
				break;
			}
			else {
				System.out.println("Ungültige Eingabe!");
			}
		}
	}
	public static void scalarMultiplication(int[]vector, int scalar) {

		for(int position = 0; position < vector.length; position++) {
			vector[position] = vector[position] * scalar;
			System.out.println(vector[position] + " ");
		}
	}
	public static void vectorProduct(int[] vector1, int[] vector2) {
		
		int[]ergebnis = new int[vector1.length];
		
		if(vector1.length == 2) {
			int erg1 = vector1[0] * vector2[1];
			int erg2 = vector1[1] * vector2[0];
			ergebnis[0] = erg1 - erg2;
			System.out.print(ergebnis[0] + " ");
			System.out.println();
		}
		else if(vector1.length == 3) {
			int[] result = new int[3];
            result[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1];
            result[1] = vector1[2] * vector2[0] - vector1[0] * vector2[2];
            result[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0];
            System.out.println("3D Kreuzprodukt (Vektor): [" + result[0] + ", " + result[1] + ", " + result[2] + "]");
		}
	}
	public static double vectorLength(int[] vector) {
		double erg1 = 0;
		for(int position = 0; position < vector.length; position++) {
			erg1 =  erg1 + vector[position] * vector[position];
		}
		double erg2 = Math.sqrt(erg1);
		
		return erg2;
	}
	public static int[][] matrixMultiplication(int[][] matrix, int scalar){
		for(int positionReihe = 0; positionReihe < matrix.length; positionReihe++) {
			if(matrix.length != 3) {
				System.out.println("NULL");
				return null;
			}
			for(int positionSpalte = 0; positionSpalte < matrix.length; positionSpalte++) {
				if(matrix[positionSpalte].length != 3) {
					System.out.println("NULL");
					return null;
				}
				matrix[positionReihe][positionSpalte] = matrix[positionReihe][positionSpalte] * scalar;
				System.out.print(matrix[positionReihe][positionSpalte] + " ");
			}
			System.out.println("");
		}
		return matrix;
	}
}
