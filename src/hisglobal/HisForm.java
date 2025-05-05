package hisglobal;

import org.apache.struts.action.*;
import org.apache.struts.validator.ValidatorForm;
import java.lang.reflect.*;

public abstract class HisForm extends ValidatorForm
{
	private String seatId;
	private String empId;

	/*
	Getter
	 */
	public String getSeatId()
	{
		return this.seatId;
	}

	public String getEmpId()
	{
		return this.empId;
	}

	/*
	Setter
	 */

	public void setSeatId(String seatId)
	{
		this.seatId = seatId;
	}

	public void setEmpId(String empId)
	{
		this.empId = empId;
	}

	/*public ActionErrors validate(ActionMapping mapping,HttpServletRequest request)
	{
		super.validate(mapping,request);
		
		ActionErrors errors = new ActionErrors();
		 
		if(this.seatId==null || this.seatId.length()==0)
			errors.add("seatId",new ActionError("app.seatId.required"));
			
		if(this.empId==null || this.empId.length()==0)
			errors.add("empId",new ActionError("app.empId.required"));
			
		return errors;	
	}*///Not Required As Child validates all its member
	protected ActionErrors validateClassMember(Object child)
	{
		ActionErrors errors = new ActionErrors();

		Class formClass = child.getClass();
		Field[] members = formClass.getDeclaredFields();

		for (int i = 0; i < members.length; i++)
		{
			String obj = null;

			try
			{
				obj = (String) members[i].get(child);
			}
			catch (Exception e)
			{
				System.out.println("Exception at getValue of Member " + e);
			}

			if (obj == null || obj.length() == 0) errors.add(members[i].getName(), new ActionError("app." + members[i].getName() + ".required"));

		}

		return errors;

	}

}
