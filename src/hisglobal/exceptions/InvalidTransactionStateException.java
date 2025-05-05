package hisglobal.exceptions;

public class InvalidTransactionStateException extends TransactionException
{
	protected InvalidTransactionStateException()
	{
		super();
	}

	public InvalidTransactionStateException(String _message)
	{
		super(_message);
	}
}
