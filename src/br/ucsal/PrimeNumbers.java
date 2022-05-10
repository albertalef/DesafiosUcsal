package br.ucsal;

public class PrimeNumbers {

	public static void main( String[] args ) {
		Tester.testAndPrintTime(() -> run(100));
	}

	public static void run(int range){
		int prime = 2;
//		System.out.println(prime++);
		for(int step = 2; step <= range; prime+=2){
			boolean isPrime = true;
			for(int divider = 3; divider * divider <= prime; divider += 2){
				if(prime % divider == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) step++;
		}
		int ultimo = prime - 2;
		System.out.format("%d° valor: %d%n", range, ultimo);
	}

}
