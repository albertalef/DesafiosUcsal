package br.ucsal;

import java.util.Locale;
import java.util.function.Supplier;

public class Tester {

	private Tester(){}

	public static <R> R testAndReturn( Supplier<R> yourCode ){
		long nano = System.currentTimeMillis();
		R result = yourCode.get();
		System.out.printf(Locale.ENGLISH, "Timestamp: %.3f seconds %n", (System.currentTimeMillis() - nano) / 1000D);
		return result;
	}
	public static double testAndGetTime( Runnable yourCode ){
		long nano = System.currentTimeMillis();
		yourCode.run();
		return (System.currentTimeMillis() - nano) / 1000D;
	}

	public static void testAndPrintTime( Runnable yourCode ){
		System.out.printf(Locale.ENGLISH, "Timestamp: %.3f seconds %n", testAndGetTime(yourCode));
	}

	public static double testAndGetAverage( int times, boolean showEveryTimeResult, Runnable yourCode ) {
		int realTimes = times;

		if(times == 0) realTimes = 1;
		if(times < 0) realTimes *= -1;

		double total = 0;
		for(int i = 1; i <= realTimes; i++) {
			double result = testAndGetTime(yourCode);
			if(showEveryTimeResult) System.out.format(Locale.ENGLISH, "%d° test: %.3f seconds%n%n", i, result);
			total += result;
		}

		double result = total / realTimes;
		if(showEveryTimeResult) System.out.printf(Locale.ENGLISH, "Average: %.3f seconds %n", result);

		return result;
	}


}
