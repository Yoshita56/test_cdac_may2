package hisglobal;

import java.lang.reflect.*;
import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;

public abstract class His_Patient_Form extends HisForm
{

	private String crNo;
	private String patientName;
	private String age;
	private String gender;
	private String category;

	public void reset(ActionMapping mapping, HttpServletRequest request)
	{
		this.setPatientName(null);
		this.setAge(null);
		this.setCategory(null);
		this.setGender(null);
	}

	/*
	 * Getter
	 */
	public String getCrNo()
	{
		return this.crNo;
	}

	public String getPatientName()
	{
		return this.patientName;
	}

	public String getAge()
	{
		return this.age;
	}

	public String getGender()
	{
		return this.gender;
	}

	public String getCategory()
	{
		return this.category;
	}

	/*
	 * Setter
	 */
	public void setCrNo(String para)
	{
		this.crNo = para;
	}

	public void setPatientName(String para)
	{
		this.patientName = para;
	}

	public void setAge(String para)
	{
		this.age = para;
	}

	public void setGender(String para)
	{
		this.gender = para;
	}

	public void setCategory(String para)
	{
		this.category = para;
	}

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
