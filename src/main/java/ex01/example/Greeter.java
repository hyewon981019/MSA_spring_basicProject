package ex01.example;

public class Greeter {

	private String format;
	
	public String greet(String name) {
		return String.format(format, name);
	}
	
	public void setFormat(String format) {
		this.format = format;
	}

}
