package hissso.ticket;

public interface TicketStatus
{
	// Getting Status of Ticket Expiration
	boolean isExpired();

	// Getting Count of Ticket Accessed By User
	int getCountOfAccess();

	// Last Time Used
	long getLastTimeUsed();

	// Getting Ticket Creation Date and Time
	long getCreationTime();
}
