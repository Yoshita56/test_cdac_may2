package hisglobal.exceptions;

import java.util.Map;

public class HisDuplicateRecordException extends HisException
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

	public HisDuplicateRecordException(String str)
	{

		super(str);
	}

	public HisDuplicateRecordException(String str, Map _mp)
	{
		super(str);
		this.essentialMap = _mp;
	}

	public HisDuplicateRecordException()
	{
		super("Duplicate Record");
	}
}
