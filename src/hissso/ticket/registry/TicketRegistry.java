package hissso.ticket.registry;

import hissso.ticket.Ticket;

import java.util.Collection;

public interface TicketRegistry
{
	// Adding Ticket
	void addTicket(Ticket ticket);

	// Getting Ticket Based on TicketId
	Ticket getTicket(String ticketId);

	// Delete Ticket from Registry
	boolean deleteTicket(String ticketId);

	// Getting All Tickets
	Collection<Ticket> getTickets();

	// Getting Tickets Count
	int ticketCount();

	// Getting Service Ticket Count
	int serviceTicketCount();
	
	// Cleaning Whole Registry
	void clean();

}
