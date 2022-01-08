package ex03;

public class ExecuteTimeCalculator implements Calculator{
	private Calculator delegate; 
		
		public ExecuteTimeCalculator(Calculator delegate) {
			this.delegate = delegate;
		}
		
		@Override
		public long factorial(long num) {
	
			long begin = System.nanoTime();
			long result = delegate.factorial(num);
			long end = System.nanoTime();
			System.out.printf("%s.factorial(%d) 실행시간 >>> %d\n", delegate.getClass().getSimpleName(), num, (end - begin));
					
			return result;
		}	

}
