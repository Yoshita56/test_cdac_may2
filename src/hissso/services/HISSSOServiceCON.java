package hissso.services;

import hissso.ticket.HISServiceGrantTicket;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

public interface HISSSOServiceCON
{
	public HISServiceGrantTicket authenticate(HISServiceSO objHISServiceSO, @Context HttpServletRequest objRequest, @PathParam("agentId") String agentId);
}
