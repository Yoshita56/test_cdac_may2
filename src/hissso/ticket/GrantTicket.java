package hissso.ticket;

import hissso.validation.credentails.authorization.AuthorizationCredentials;
import hissso.validation.credentails.authorization.HISService;

public interface GrantTicket extends Ticket
{
	String PREFIX = "GT";

	// Get Service Detail
	HISService getService();

	// Get User Authorization Detail
	AuthorizationCredentials getAuthorization();

	// Get Expiration
	int getExpiry();

	// Get Secret Key
	String getSecretKey();
	
	// Get Hash Salt
	String getHashSalt();
}
