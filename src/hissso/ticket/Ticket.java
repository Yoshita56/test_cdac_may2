package hissso.ticket;

import hissso.validation.credentails.authentication.AuthenticationCredentials;
import hissso.validation.credentails.authorization.AuthorizationCredentials;

import java.io.Serializable;

public interface Ticket extends Serializable
{
	// Getting Ticket ID which travels over Browsers
	String getTicketId();

	// Getting TGT ID from Ticket
	String getGrantingTicketId();

	// Getting Authentication
	AuthenticationCredentials getAuthentication();

	// Getting Authorization
	AuthorizationCredentials getAuthorization();
}
