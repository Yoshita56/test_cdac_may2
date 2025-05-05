package mms.masters.vo;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericFormBean;
import hisglobal.utility.HisUtil;

public class VOUnitMst extends GenericFormBean {

	private static final long serialVersionUID = 02L;
	private String strHospitalCode = ""; // add by anshul
	private String StrSeatId = "";
	private String strModuleVal = "";
	private String strUnitName = "";
	private String strIsBaseUnit = "0";
	private String strBaseUnit = "";
	private String strEffectiveDate = "";
	private String strRemarks = "";
	private String strValid = "";
	private String strComboValues = "";
	private String strUnitComboValues = "";
	private String strLastModSeatId = "";
	private String strErr = "";
	private String strWarning = "";
	private String strMsg = "";

	private String strCtDate = "";

	private String strModuleName = ""; // add by Anshul to display module
											// name on add page 
	
	private String strIsDecimal = ""; // added on 29th-April-09

	public String getStrModuleVal() {
		return strModuleVal;
	}

	public void setStrModuleVal(String moduleVal) {
		this.strModuleVal = moduleVal;
	}

	public String getStrUnitName() {
		return strUnitName;
	}

	public void setStrUnitName(String unitName) {
		this.strUnitName = unitName;
	}

	public String getStrIsBaseUnit() {
		return strIsBaseUnit;
	}

	public void setStrIsBaseUnit(String isBaseUnit) {
		this.strIsBaseUnit = isBaseUnit;
	}

	public String getStrBaseUnit() {
		return strBaseUnit;
	}

	public void setStrBaseUnit(String baseUnit) {
		this.strBaseUnit = baseUnit;
	}

	/**
	 * retrieves Current Date from Application Server
	 * 
	 * @return current Date.
	 */
	public String getStrEffectiveDate() {

		if (this.strEffectiveDate == null) {

			HisUtil util = new HisUtil("Remarks Master", "VORemarksMst");
			try {
				strEffectiveDate = util.getASDate("dd-MMM-yyyy");
				util = null;
			} catch (Exception e) {

				new HisException("Remarks Master",
						"VORemarksMst.getEffectiveDate()", e.getMessage());
			}
		}

		return strEffectiveDate;
	}

	public void setStrEffectiveDate(String effectiveDate) {
		this.strEffectiveDate = effectiveDate;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String remarks) {
		this.strRemarks = remarks;
	}

	public String getStrErr() {
		return strErr;
	}

	public void setStrErr(String err) {
		this.strErr = err;
	}

	/**
	 * retrieves and gets the Unit Option Values.
	 * 
	 * @return Unit Option Value String
	 */
	public String getStrComboValues() {
		// changes by Anshul

		/*
		 * HisUtil hisUtil = new HisUtil("Unit Master",
		 * "BoUnitMst.getModuleNames");
		 * 
		 * try {
		 * 
		 * String qry =
		 * billing.qryHandler_billing.getQuery(1,"select.unitMst.2");
		 * 
		 * if (strModuleVal == null) strModuleVal = "0";
		 * 
		 * strComboValues = hisUtil.getOptionValue(qry.replace('?', '0'),
		 * strModuleVal, "0^Select Value"); hisUtil = null;
		 *  } catch (Exception e) { new HisException("Unit Master",
		 * "VOUnitMst.getComboValues", e.getMessage()); }
		 */

		return strComboValues;
	}

	public String getStrValid() {
		return strValid;
	}

	public void setStrValid(String valid) {
		this.strValid = valid;
	}

	public String getStrLastModSeatId() {
		return strLastModSeatId;
	}

	public void setStrLastModSeatId(String lastModSeatId) {
		this.strLastModSeatId = lastModSeatId;
	}

	/*
	 * public String getUnitComboValues() {
	 * 
	 * 
	 * return unitComboValues; }
	 */

	/**
	 * retrieves and gets the Module Name Option Values.
	 * 
	 * @return Module Name Option Value String
	 */
	public String getStrUnitComboValues() {

		/*
		 * HisUtil hisUtil = new HisUtil("Unit Master",
		 * "BoUnitMst.getModuleNames");//  System.out.println("in vo -->module
		 * id-->"+this.getStrModuleVal());
		 * 
		 * try {
		 * 
		 * strUnitComboValues = "<option value='0'> Select Value </option>";
		 * String qry =
		 * billing.qryHandler_billing.getQuery(1,"select.unitMst.3");
		 * 
		 * if (this.getStrModuleVal() == null) this.setStrModuleVal("0");
		 * 
		 * strUnitComboValues = hisUtil.getOptionValue(qry.replace("?",
		 * this.getStrModuleVal()), "0","0^Select Value"); hisUtil = null; }
		 * catch (Exception e) { new HisException("Unit Master",
		 * "BoUnitMst.getComboValues", e.getMessage()); }
		 */

		return strUnitComboValues;
	}

	public String getStrWarning() {
		return strWarning;
	}

	public void setStrWarning(String warning) {
		this.strWarning = warning;
	}

	public String getStrMsg() {
		return strMsg;
	}

	public void setStrMsg(String msg) {
		this.strMsg = msg;
	}

	public String getStrSeatId() {
		return StrSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		StrSeatId = strSeatId;
	}

	public String getStrModuleName() {
		return strModuleName;
	}

	public void setStrModuleName(String strModuleName) {
		this.strModuleName = strModuleName;
	}

	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	public void setStrUnitComboValues(String strUnitComboValues) {
		this.strUnitComboValues = strUnitComboValues;
	}

	public String getStrCtDate() {
		HisUtil util = new HisUtil("Indent Type Master", "VOIndentTypeMst");
		try {
			strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
		} catch (Exception e) {
			new HisException("Store Module", "Indent Type Master",
					"VOIndentTypeMst.getStrCtDate()-->" + e.getMessage());
		}
		return strCtDate;

	}

	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * @return the strIsDecimal
	 */
	public String getStrIsDecimal() {
		return strIsDecimal;
	}

	/**
	 * @param strIsDecimal the strIsDecimal to set
	 */
	public void setStrIsDecimal(String strIsDecimal) {
		this.strIsDecimal = strIsDecimal;
	}

}
