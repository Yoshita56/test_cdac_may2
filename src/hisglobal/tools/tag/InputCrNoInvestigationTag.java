package hisglobal.tools.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import hisglobal.hisconfig.Config;
import hisglobal.presentation.Status;
import hisglobal.presentation.WebUTIL;
import hisglobal.vo.PatientVO;
import hisglobal.vo.UserVO;

public class InputCrNoInvestigationTag extends TagSupport
{
	private PatientVO crNoFB = new PatientVO();
	
	public int doStartTag() throws JspException
	{
		try
		{
			this.crNoFB.setPatCrNo((String) TagUtil.invokeGetterFor(this.getBean(), "PatCrNo"));
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

			boolean isStatusNew = TagUtil.isStatusNew((Status) (TagUtil.getAttribute(this.pageContext, Config.STATUS_OBJECT)));
			JspWriter out = this.pageContext.getOut();
			String sizeValue = Config.CR_NO_FORMAT_SIZE;
			int size = Integer.parseInt(sizeValue);
		
			
		      
			/*if(sizeValue.equals(Config.CR_NO_FORMAT_SIZE_TWELVE))
				out.println(this.getBodyTop(isStatusNew,request,size));
			if(sizeValue.equals(Config.CR_NO_FORMAT_SIZE_THIRTEEN))
				out.println(this.getBodyTopThirteen(isStatusNew,request));*/

			out.println(this.getBodyTop(isStatusNew, request, size));
			//System.out.println("is status new.......readonly..............." + isStatusNew);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException
	{
		return endingTag();
	}

	public int endingTag() throws JspException
	{
		try
		{
			//System.out.println("do after body............................................................");
			JspWriter out = this.pageContext.getOut();
			out.println(this.getBodyClose());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_PAGE;
	}

	/*protected String getBodyTopThirteen(boolean _isReadOnly, HttpServletRequest _request)
	{
		System.out.println("get body top...............");
		String strReturn;
		String isReadOnly = "";
		String isMandatory = "*";
		if (!_isReadOnly)
		{
			isReadOnly = "readonly=\"readonly\"";
			isMandatory = "";
		}

		//WebUTIL.setAttributeInSession(_request,RegistrationConfig.YEAR,year);
		this.setCRNoValue();
		strReturn = "<!--Cr No Input Tile-->" + "\n<table width = \"100%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"1\">" + "\n<tr>"
				+ "\n<td width=\"17%\" nowrap Class=\"tdfonthead\">" + "\n<div align=\"left\">"
				+ "\n<font color=\"#FF0000\" size=\"1\" face=\"Verdana, Arial, Helvetica, sans-serif\">"
				+ isMandatory
				+ "</font>"
				+ "<b><font color=\"#000000\" size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">"
				+ "CR Number"
				+ "\n</font></b>"
				+ "\n</div>"
				+ "\n</td>"
				+ "\n<td width=\"17%\"  Class = \"tdfont\" nowrap>"
				+ "\n<font color=\"#000000\" size=\"1em\" face=\"Verdana, Arial, Helvetica, sans-serif\">"
				+ "\n<input type=\"text\" name=\"crNo1\" maxlength=\"3\" size=\"3\" value=\""
				+ this.crNoFB.getCrNo1()
				+ "\" onkeydown=\"setPrevValue(this, event);\" onkeyup=\"moveToRight(this, event);\" onkeypress=\"return validateNumeric(event)\""
				+ isReadOnly
				+ ">"
				+ "\n<input type=\"text\" name=\"crNo2\" maxlength=\"2\" size=\"2\" value=\""
				+ this.crNoFB.getCrNo2()
				+ "\" onkeydown=\"setPrevValue(this, event);\" onkeyup=\"moveToRight(this, event);\" onkeypress=\"return validateNumeric(event)\" onblur=\"padWithZeros(this)\""
				+ isReadOnly
				+ ">"
				+ "\n<input type=\"text\" name=\"crNo3\" maxlength=\"10\" size=\"11\" tabindex=\"1\" value=\""
				+ this.crNoFB.getCrNo3()
				+ "\" onkeydown=\"setPrevValue(this, event);\" onkeyup=\"moveToRight(this, event);\" onkeypress=\"if(event.keyCode==13) submitFormOnValidate(validateCRNo(),'GETPATDTL'); return validateNumeric(event); \"onblur=\"padWithZeros(this)\""
				+ isReadOnly + ">" + "\n</font>" + "\n</td>" + "\n<td width=\"49%\" align=\"left\" class=\"tdfont\">";
		

		return strReturn;
	}*/

	protected String getBodyTop(boolean _isReadOnly, HttpServletRequest _request, int size)
	{
		//System.out.println("get body top...............");
		String strReturn;
		String isReadOnly = "";
		String isMandatory = "*";
		if (!_isReadOnly)
		{
			isReadOnly = "readonly=\"readonly\"";
			isMandatory = "";
		}
		 UserVO uservo=null;
		 Date todayDateobj = new Date();
			SimpleDateFormat dateob = new SimpleDateFormat("yy");
			String strDate= dateob.format(todayDateobj);
	    
	      String hospitalCode=uservo.getHospitalCode();
		String setValueInTextBox=hospitalCode+strDate;
		int maxlength=0;
		if(hospitalCode.length()==3)
		{
			maxlength=13;
		}
		if(hospitalCode.length()==5)
		{
			maxlength=15;
		}
		
			this.setCRNoValue();
		strReturn = "<!--Cr No Input Tile-->" + "\n<table width = \"100%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"1\">" + "\n<tr>"
				+ "\n<td width=\"17%\" nowrap Class=\"tdfont\">" + "\n<div align=\"left\">"
				+ "\n<font color=\"#FF0000\" size=\"1\" face=\"Verdana, Arial, Helvetica, sans-serif\">"
				+ isMandatory
				+ "</font>"
				+ "<b><font color=\"#000000\" size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">"
				+ "CR Number"
				+ "\n</font></b>"
				+ "\n</div>"
				+ "\n</td>"
				+ "\n<td width=\"17%\"  Class = \"tdfont\" nowrap>"
				+ "\n<font color=\"#FF0000\" size=\"1em\" face=\"Verdana, Arial, Helvetica, sans-serif\">"
				+ "\n<input type=\"text\" class=\"textBoxCss\" name=\"patCrNo\" maxlength=\""
				+ maxlength
				+ "\" tabindex=\"1\" size=\""
				+ 20
				+ "\" value=\""
				+ setValueInTextBox
				+ "\" onkeydown=\"setPrevValue(this, event);\"  onkeypress=\"if(event.keyCode!=13) return validateNumeric(event); else "
				+ "return  validateCRNoCHE('"+hospitalCode+ "'); \"" + isReadOnly + ">" +

				"\n</font>" + "\n</td>" + "\n<td width=\"49%\" align=\"left\" class=\"tdfont\">";
		if (isReadOnly == "")
		{
			strReturn += "\n<img class=\"button\" src='/INVMGM/hisglobal/images/GO.png' tabindex=\"1\" style=cursor:pointer onclick=\" return validateCRNoCHE('"
					+ hospitalCode
					+ "')\" onkeypress=\"if(event.keyCode==13)return  validateCRNoCHE('"
					+ hospitalCode
					+ "') \" size = '7' border=\"0\"> </td>"
					+ "<td width=\"17%\" class=\"tdfont\"><div align=\"right\"><img class=\"button\" src='/INVMGM/hisglobal/images/btn-search.png' tabindex=\"1\" style=cursor:pointer onclick=\"openPopup('/INVMGM/registration/searchByNamePopup.cnt',event,300,700)\" onkeypress=\"if(event.keyCode==13) openPopup('/HISInvestigationG5/registration/searchByNamePopup.cnt',event,300,700)\"></div>";
					
		}

		return strReturn;
	}

	protected String getBodyClose()
	{
		String strReturn = "\n</td>" + "\n</tr>" + "\n</table>" + "<!--Cr No Input Tile ends here-->";

		return strReturn;
	}

	String name;
	Object bean;

	public Object getBean()
	{
		return bean;
	}

	public void setBean() throws JspException
	{
		this.bean = TagUtil.getAttribute(this.pageContext, this.getName());
		if (this.bean == null) throw new RuntimeException("No bean with name: " + this.getName());
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) throws JspException
	{
		this.name = name;
		this.setBean();
	}

	public void setCRNoValue()
	{
		if (this.crNoFB.getPatCrNo() == null || this.crNoFB.getPatCrNo().trim().length() == 0)
		{
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			String valuePatCrNo = (String) WebUTIL.getSession(request).getAttribute(Config.DEFAULT_VALUE_CR_NO_FORMAT);
			this.crNoFB.setPatCrNo(valuePatCrNo==null?"":valuePatCrNo);

			//this.crNoFB.setCrNo1(Config.HOSPITAL_CODE_VALUE);
			/*HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			String st= (String)WebUTIL.getSession(request).getAttribute("SYSDATE");
			int ln=st.length();
			String year=st.substring(8,10);
			this.crNoFB.setCrNo2Thirteen(year);*/
		}
	}

}
