package mms.patDtl;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;
public class GlobalVO implements TransferObject
{
	
	private static final long serialVersionUID = 02L;
	
		
	private String strMsgString = "";
	private String strMsgType = "0";
	
	private String strValue1 = "0";
	private String strValue2 = "0";
	private String strValue3 = "0";
		
	private WebRowSet gblWs1 = null;
	private WebRowSet gblWs2 = null;
	private WebRowSet gblWs3 = null;
	
	
	public String getStrValue1() {
		return strValue1;
	}

	public void setStrValue1(String strValue1) {
		this.strValue1 = strValue1;
	}

	

	public WebRowSet getGblWs1() {
		return gblWs1;
	}

	public void setGblWs1(WebRowSet gblWs1) {
		this.gblWs1 = gblWs1;
	}

	
	public String getStrMsgString() {
		return strMsgString;
	}

	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	public String getStrMsgType() {
		return strMsgType;
	}

	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	public String getStrValue2() {
		return strValue2;
	}

	public void setStrValue2(String strValue2) {
		this.strValue2 = strValue2;
	}

	public WebRowSet getGblWs2() {
		return gblWs2;
	}

	public void setGblWs2(WebRowSet gblWs2) {
		this.gblWs2 = gblWs2;
	}

	public String getStrValue3() {
		return strValue3;
	}

	public void setStrValue3(String strValue3) {
		this.strValue3 = strValue3;
	}

	public WebRowSet getGblWs3() {
		return gblWs3;
	}

	public void setGblWs3(WebRowSet gblWs3) {
		this.gblWs3 = gblWs3;
	}
	
}
