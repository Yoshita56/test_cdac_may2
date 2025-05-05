package hisglobal.exceptions;

public class HisDataAccessException extends HisException
{

	public HisDataAccessException()
	{
		super("HIS Data Access Exception");
	}

	public HisDataAccessException(String _msg)
	{
		super(_msg);
	}

}
