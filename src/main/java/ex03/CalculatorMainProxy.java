package ex03;

public class CalculatorMainProxy {
	
	public static void main(String[] args) {
		long num = 10;
		
		ExecuteTimeCalculator etc1 = new ExecuteTimeCalculator(new CalculatorImpl());
		System.out.println(etc1.factorial(num));
		
		ExecuteTimeCalculator etc2 = new ExecuteTimeCalculator(new CalculatorImplRecursive());
		System.out.println(etc2.factorial(num));

	}


}
