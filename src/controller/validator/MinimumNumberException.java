package controller.validator;

public class MinimumNumberException extends Exception 
{	
	private static final long serialVersionUID = 1L;
	
	public MinimumNumberException(String field, long maximum)
	{
		super(field + " must be less than or equals to " + maximum + " .");
	}
	public MinimumNumberException(String field, double maximum)
	{
		super(field + " must be less than or equals to " + maximum + " .");
	}
}
