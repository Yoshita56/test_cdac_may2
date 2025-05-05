package hisglobal.backutil.exception;

/*
Developed By          : Pradumna Dixit
Creation Dated        :
Modification Dated    :
Version               : HIMS 2.0

*/



public class CASHException extends RuntimeException
{
	public CASHException()
	{
		super("Cash Exception");
	}
    public CASHException(String _msg)
    {
    	super(_msg);
    }
}
