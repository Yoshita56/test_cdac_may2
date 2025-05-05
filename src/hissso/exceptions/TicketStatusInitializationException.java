package hissso.exceptions;

public class TicketStatusInitializationException extends TicketException
{
	private static final long serialVersionUID = 1911L;
	
	private static final String CODE = "CANT_INIT_TICKET_STATUS";
	
	public TicketStatusInitializationException(final String reason)
	{
		super(CODE);
		this.reason = reason;
	}

	public String getReason()
	{
		return this.reason;
	}

}
