package hisglobal.backutil.exception;

public class BudgetException extends RuntimeException
{
	public BudgetException(){ super("Budget Exception"); }
    public BudgetException(String _msg){ super(_msg);}
}

