package hisglobal.backutil.exception;

/*
Developed By          : Partha P Chattaraj
Creation Dated        : 17-06-2006
Modification Dated    : 07-05-2008
Version               : HIMS 2.0

*/


public class GlobalException extends RuntimeException
{
	public GlobalException(){ super("Global Exception"); }
    public GlobalException(String _msg){ super(_msg);}
}
