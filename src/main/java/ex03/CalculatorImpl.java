package ex03;

public class CalculatorImpl implements Calculator{

	@Override
	public long factorial(long num) {
		// 시작시간
		long begin = System.nano();
		
		long result = 1;
		for (long i = 1; i <= num; i ++) {
			result *= i;
		}
		
		// 종료시간
		long end = System.nano();
		System.out.printf("CalculatorImpl.factorial(%d) 실행시간 >>> %d", num, (end - begin));
		return result;

	}


	
}
