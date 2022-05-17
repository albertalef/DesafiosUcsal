package br.ucsal;

public class Progression {

	public static void main( String[] args ) {
		printMatrix("Matrix", getProgression(3, 5, 8, 2));

	}
	private static int[][] getProgression(int lines, int columns, int initialValue, int ratio){
		int actualValue = initialValue;
		int[][] matrix = new int[lines][columns];

		for(int linha = 0; linha < matrix.length; linha++) {
			for(int coluna = 0; coluna < matrix[linha].length; coluna++) {
				matrix[linha][coluna] += actualValue;
				actualValue += ratio;
			}
		}
		return matrix;
	}
	private static void printMatrix(String name, int[][] ints){
		System.out.printf("%n%n%s:%n", name);
		for(int[] anInt : ints) {
			System.out.print("|");
			for(int i : anInt) {
				System.out.print(centerString(6, String.valueOf(i)));
			}
			System.out.println("|");
		}
	}

	@SuppressWarnings("all")
	private static String centerString (int width, String s) {
		return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}
}
