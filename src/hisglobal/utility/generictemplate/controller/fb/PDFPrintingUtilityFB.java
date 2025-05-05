package hisglobal.utility.generictemplate.controller.fb;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class PDFPrintingUtilityFB extends ActionForm
{
	private String modePrint; //HTML or PDF or ONLYHTML 
	private String errorMode; //NONE or OK or ERROR or TRY
	// if TRY fetch data from opener with field value 'pdfPrintingHTMLData'
	private String errorMessage;
	private String htmlCode;
	private String waterMarkText;
	
	public PDFPrintingUtilityFB()
	{
		this.modePrint="HTML";
		this.errorMode="NONE";
		this.htmlCode="";
		this.errorMessage="";
		this.waterMarkText="";
	}
	
	public void reset(ActionMapping mapping,HttpServletRequest request) 
	{
		this.modePrint="HTML";
		this.errorMode="NONE";
		this.htmlCode="";
		this.errorMessage="";
		this.waterMarkText="";
	}

	public String getModePrint()
	{
		return modePrint;
	}

	public void setModePrint(String modePrint)
	{
		this.modePrint = modePrint;
	}

	public String getHtmlCode()
	{
		return htmlCode;
	}

	public void setHtmlCode(String htmlCode)
	{
		this.htmlCode = htmlCode;
	}

	public String getErrorMode()
	{
		return errorMode;
	}

	public void setErrorMode(String errorMode)
	{
		this.errorMode = errorMode;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}

	public String getWaterMarkText()
	{
		return waterMarkText;
	}

	public void setWaterMarkText(String waterMarkText)
	{
		this.waterMarkText = waterMarkText;
	}

}
