package hisglobal.exceptions;

import java.util.Map;

public class HisRecordNotFoundException extends HisException
{

	private Map essentialMap;

	public Map getEssentialMap()
	{
		return essentialMap;
	}

	public void setEssentialMap(Map essentialMap)
	{
		this.essentialMap = essentialMap;
	}

	public HisRecordNotFoundException(String str)
	{

		super(str);
	}

	public HisRecordNotFoundException(String str, Map _mp)
	{
		super(str);
		this.essentialMap = _mp;
	}

	public HisRecordNotFoundException()
	{
		super("Record Not Found Exception");
	}
}
