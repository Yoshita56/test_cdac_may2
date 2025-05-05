package hissso.ticket;

import hissso.ticket.expiration.HISExpiration;
import hissso.validation.credentails.authorization.AuthorizationCredentials;
import hissso.validation.credentails.authorization.HISService;

import java.util.List;

public interface TicketGrantingTicket extends Ticket
{
	String PREFIX = "TGT";

	// Get User Authorization Detail
	AuthorizationCredentials getAuthorization();

	// Granting Service Ticket
	GrantTicket grantServiceTicket(HISService objService, HISExpiration expirationPolicy);

	// Logout Ticket if all Service Tickets are Expired on (Session Expiration)
	boolean expire();

	// Logout Ticket as well as all other Service Ticket
	void logout();

	// Getting List of Accessed Services
	List<HISService> getServiceUsed();
}
