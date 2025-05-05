package hisglobal.exceptions;

public class HisInvalidSessionException extends HisException {

	public HisInvalidSessionException()
	{
		super("HIS Invalid Session");
	}

	public HisInvalidSessionException(String _msg)
	{
		super(_msg);
	}

}
