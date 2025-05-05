package hisglobal.exceptions;

public class HisApplicationExecutionException extends HisException
{

	public HisApplicationExecutionException()
	{
		super("HIS Application Execution Exception");
	}

	public HisApplicationExecutionException(String _msg)
	{
		super(_msg);
	}

}
