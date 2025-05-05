package hissso.exceptions;

public class TicketGenerationException extends TicketException
{
	private static final long serialVersionUID = 1910L;

	private static final String CODE = "CANT_GENERATE_TICKET";

	//private final HISTicket ticket;

	public TicketGenerationException(final String reason)
	{
		super(CODE);
		this.reason = reason;
	}

	public String getReason()
	{
		return this.reason;
	}

	// public HISTicket getTicket()
	// {
	// return this.reason;
	// }
}
