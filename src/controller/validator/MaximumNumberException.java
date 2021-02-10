package controller.validator;

public class MaximumNumberException extends Exception 
{	
	private static final long serialVersionUID = 1L;
	
	public MaximumNumberException(String field, long minimum)
	{
		super(field + " must be greater than or equals to " + minimum + " .");
	}
	public MaximumNumberException(String field, double minimum)
	{
		super(field + " must be greater than or equals to " + minimum + " .");
	}
}
