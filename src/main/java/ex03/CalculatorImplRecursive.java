package ex03;

public class CalculatorImplRecursive implements Calculator{

	@Override
	public long factorial(long num) {
		if (num <= 1) {
			return 1;
		} else {
			return num * factorial(num - 1);
		}
	}

}
