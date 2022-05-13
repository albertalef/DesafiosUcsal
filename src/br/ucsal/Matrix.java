package br.ucsal;

import java.util.Scanner;

public class Matrix {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int nColunasA = getInt("Informe o número de colunas da Matriz A: ");
		int nLinhasA = getInt("Informe o número de linhas da Matriz A: ");
		int nColunasB = getInt("Informe o número de colunas da Matriz B");

		int[][] matrizA = new int[nLinhasA][nColunasA];
		int[][] matrizB = new int[nColunasB][nColunasA];
		int[][] resultado = new int[nLinhasA][nColunasB];

		System.out.println("------------------------------------");
		setMatrixValues("A", "linha", matrizA);
		System.out.println("------------------------------------");
		setMatrixValues("B", "coluna", matrizB);


		for(int linha = 0; linha < matrizA.length; linha++) {
			for(int colunaB = 0; colunaB < matrizB.length; colunaB++) {
				for(int coluna = 0; coluna < matrizA[linha].length; coluna++) {
					int valorB = matrizB[colunaB][coluna];
					int valorA = matrizA[linha][coluna];
					resultado[linha][colunaB] += valorB * valorA;
				}
			}

		}

		printMatrix("Matriz A", matrizA);
		printInverseMatrix("Matrix B", nColunasA, matrizB);
		printMatrix("Resultado", resultado);
	}
	private static int getInt(String text){
		System.out.println(text);
		return sc.nextInt();
	}
	private static void setMatrixValues(String matrixLetter, String mainAxle, int[][] matrix){
		for(int linha = 0; linha < matrix.length; linha++) {
			for(int coluna = 0; coluna < matrix[linha].length; coluna++) {
				System.out.printf("Digite o %d° valor da %s %d da Matriz %s: ", coluna + 1, mainAxle, linha + 1, matrixLetter);
				matrix[linha][coluna] = sc.nextInt();
			}
		}
	}
	private static void printMatrix(String name, int[][] ints){
		System.out.printf("%n%n%s:%n", name);
		for(int linha = 0; linha < ints.length; linha++) {
			System.out.print("|");
			for(int coluna = 0; coluna < ints[linha].length; coluna++) {
				System.out.print(centerString(6, String.valueOf(ints[linha][coluna])));
			}
			System.out.println("|");
		}
	}
	private static void printInverseMatrix(String name, int priority, int[][] ints){
		System.out.printf("%n%n%s:%n", name);
		for(int coluna = 0; coluna < priority; coluna++) {
			System.out.print("|");
			for(int linha = 0; linha < ints.length; linha++) {
				System.out.print(centerString(6, String.valueOf(ints[linha][coluna])));
			}
			System.out.println("|");
		}
	}
	private static String centerString (int width, String s) {
		return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}

}