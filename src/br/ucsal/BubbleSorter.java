package br.ucsal;

public class BubbleSorter {


	public static void main( String[] args ) {

		for(int value : bubbleSort(4, 9, 7, 6, 8, 1, 2, 3)) System.out.println(value);
	}
	public static int[] bubbleSort( int... values){
		for(int i = 0; i < values.length; i++){
			for(int n = 0; n < values.length; n++){
				if(n == values.length - 1) break;
				if(values[n] > values[n+1]){
					int aux = values[n];
					values[n] = values[n+1];
					values[n+1] = aux;
				}
			}
		}
		return values;
	}
}