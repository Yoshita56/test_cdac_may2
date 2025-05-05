package hissso.exceptions;

public abstract class TicketException extends Exception
{
	private static final long serialVersionUID = 19L;

	private String code;
	protected String reason;

	public TicketException(final String code)
	{
		this.code = code;
	}

	public TicketException(final String code, final Throwable throwable)
	{
		super(throwable);
		this.code = code;
	}

	public final String getCode()
	{
		return (this.getCause() != null) ? this.getCause().toString() : this.code;
	}

	public final String getMessage()
	{
		return (this.code + " :: " + this.reason + ((this.getCause() != null) ? "; " + this.getCause().toString() : this.code));
	}
}
