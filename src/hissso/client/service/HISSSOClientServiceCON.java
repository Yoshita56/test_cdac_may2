package hissso.client.service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

public interface HISSSOClientServiceCON
{
	// Checking Service Ticket Expiration Status
	public HISClientSO isServiceTicketExpiredAtClient(HISClientSO objSO_p,  @Context HttpServletRequest objRequest);

	// killing Service Ticket
	public HISClientSO killServiceTicketAtClient(HISClientSO objSO_p,  @Context HttpServletRequest objRequest);
}
