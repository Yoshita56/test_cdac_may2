package hissso.services;

import hissso.validation.credentails.authorization.HISService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HISServiceSO
{
	protected String varGrantingTicketId;
	
	protected HISService objService;

	@XmlElement
	public String getVarGrantingTicketId()
	{
		return varGrantingTicketId;
	}

	public void setVarGrantingTicketId(String varGrantingTicketId)
	{
		this.varGrantingTicketId = varGrantingTicketId;
	}

	@XmlElement
	public HISService getObjService()
	{
		return objService;
	}

	public void setObjService(HISService objService)
	{
		this.objService = objService;
	}
}
