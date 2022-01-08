package ex01.exception;

public class DuplicateMemberException extends Exception{
	
	public DuplicateMemberException()
	{
		super();
	}
	
	public DuplicateMemberException(String message)
	{
		super(message);
	}
}
