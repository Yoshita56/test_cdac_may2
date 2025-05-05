package hisglobal.exceptions;

public class TransactionException extends HisException
{
	protected TransactionException()
	{
		super();
	}

	public TransactionException(String message)
	{
		super(message);
	}
}
