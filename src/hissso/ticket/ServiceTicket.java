package hissso.ticket;

import javax.servlet.http.HttpSession;

import hissso.exceptions.TicketStatusInitializationException;
import hissso.validation.credentails.authorization.AuthorizationCredentials;
import hissso.validation.credentails.authorization.HISService;

public interface ServiceTicket extends Ticket, TicketStatus
{
	String PREFIX = "ST";

	// Get Service Detail
	HISService getService();

	// Get User Authorization Detail
	AuthorizationCredentials getAuthorization();

	// Associating Service Status with Client based on Given Expiration Policy  
	boolean associateServiceAtClient(HttpSession objSession) throws TicketStatusInitializationException;
	
	// Get Grant Service Ticket
	GrantTicket getServiceGrantTicket();

	// Checking Expiration of Service (Called through TGT)
	boolean isExpiredAtClient();

	// Killing Service at Client as well as SSO (Called through TGT)
	void killService();
	
	// Expire Ticket On Service Session Expiration
	void expire();

	// Forceful Logout Service Ticket
	void logout();
	
	// From New Login
	boolean isFromNewLogin();
}
