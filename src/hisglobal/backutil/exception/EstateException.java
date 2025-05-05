package hisglobal.backutil.exception;

public class EstateException extends RuntimeException
{
	public EstateException(){ super("Estate Exception"); }
    public EstateException(String _msg){ super(_msg);}
}
