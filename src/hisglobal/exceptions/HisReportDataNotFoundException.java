package hisglobal.exceptions;

public class HisReportDataNotFoundException extends Exception
{

	public HisReportDataNotFoundException(String str)
	{
		super(str);
	}

	public HisReportDataNotFoundException()
	{
		super("Report Data Not Found Exception");
	}

}
