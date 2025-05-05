/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

public class CondemnItemDetailRptFB extends ActionForm{
	private static final long serialVersionUID = 02L;
	private String strNormalMsg="";
	private String strErrMsg="";
	private String strWarningMsg="";
	private String strHospCode="";
	private String strIsFooter="";
	private String strUserRemarks="";
	private String strItemCategVal="";
	private String strItemCategId = "";
	private String strItemCategoryName = "";
	private String strReportId = "";
	private String strReportFormat = "";
	public String getStrReportId() {
		return strReportId;
	}
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
	}
	public String getStrReportFormat() {
		return strReportFormat;
	}
	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}
	public String getStrItemCategVal() {
		return strItemCategVal;
	}
	public void setStrItemCategVal(String strItemCategVal) {
		this.strItemCategVal = strItemCategVal;
	}
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	public String getStrHospCode() {
		return strHospCode;
	}
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}
	public String getStrIsFooter() {
		return strIsFooter;
	}
	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}
	public String getStrUserRemarks() {
		return strUserRemarks;
	}
	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}
	public String getStrItemCategId() {
		return strItemCategId;
	}
	public void setStrItemCategId(String strItemCategId) {
		this.strItemCategId = strItemCategId;
	}
	/**
	 * @return the strItemCategoryName
	 */
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}
	/**
	 * @param strItemCategoryName the strItemCategoryName to set
	 */
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

}
