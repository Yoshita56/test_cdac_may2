package hissso.exceptions;

import hissso.validation.credentails.authorization.HISService;

public class TicketValidationException extends TicketException
{
	private static final long serialVersionUID = 1911L;

	private static final String CODE = "INVALID_SERVICE";

	private final HISService service;

	public TicketValidationException(final HISService service)
	{
		super(CODE);
		this.service = service;
	}

	public HISService getOriginalService()
	{
		return this.service;
	}

}
