package hissso.client.service;

import hissso.validation.credentails.authorization.HISService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HISClientSO
{
	protected String grantingTicketId;
	protected String serviceTicketId;
	protected String actionStatus;

	protected HISService objService;

	public String getActionStatus()
	{
		return actionStatus;
	}

	public void setActionStatus(String actionStatus)
	{
		this.actionStatus = actionStatus;
	}

	@XmlElement
	public String getGrantingTicketId()
	{
		return grantingTicketId;
	}

	public void setGrantingTicketId(String grantingTicketId)
	{
		this.grantingTicketId = grantingTicketId;
	}

	@XmlElement
	public String getServiceTicketId()
	{
		return serviceTicketId;
	}

	public void setServiceTicketId(String serviceTicketId)
	{
		this.serviceTicketId = serviceTicketId;
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
