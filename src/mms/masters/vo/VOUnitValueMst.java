package mms.masters.vo;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericFormBean;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

public class VOUnitValueMst extends GenericFormBean {

	private static final long serialVersionUID = 02L;
	private String StrLastSeatId = "";
	private String StrSeatId = "";
	private String StrHospitalCode = "";
	private String StrCtDate = "";
	private String StrEntryDate = "";
	private String chk1 = "";
	private String moduleName = "";
	private String fromUnit = "";
	private String toUnit = "";
	private String fromUnit1 = "";
	private String toUnit1 = "";
	private String effectiveFrom = null;
	private String convertedValue = "";
	private String remark = "";
	private String isValid = "";
	private String strErrorMsg = "";
	private String StrWarning = "";
	private String StrMsg = "";
	private String StrFromUnitCombo = "";
	private String StrToUnitCombo = "";
	private String StrModuleId = "";
	private String strCmbval = "";
	private String strUnitId = "";
	public String[] temp1 = null;
	private String strUnitLevel = ""; 
	private String StrModuleName = ""; 

	public String getStrModuleId() {
		return StrModuleId;
	}

	public void setStrModuleId(String strModuleId) {
		this.StrModuleId = strModuleId;
	}

	public String getChk1() {
		return chk1;
	}

	public void setChk1(String chk1) {
		this.chk1 = chk1;
	}

	public String getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(String convertedValue) {
		this.convertedValue = convertedValue;
	}

	public String getFromUnit() {
		return fromUnit;
	}

	public void setFromUnit(String fromUnit) {
		this.fromUnit = fromUnit;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getToUnit() {
		return toUnit;
	}

	public void setToUnit(String toUnit) {
		this.toUnit = toUnit;
	}

	public String getCmbval1() {
		String errMsg = "";
		String val1 = this.getModuleName();

		String comboValues = "<option value='0'> Select Value </option>";
		HisUtil hisUtil = new HisUtil("Unit Value Master", "CNTUnitValueMst");

		try {
			String qry = mms.qryHandler_mms.getQuery(1,
					"select.unitvalue.3");

			int qryIndex;
			HisDAO dao = null;

			dao = new HisDAO("Billing", "DAOUnitValueMst");

			qryIndex = dao.setQuery(qry);

			dao.setQryValue(qryIndex, 1, this.getStrHospitalCode());
			dao.setQryValue(qryIndex, 2, val1);
			WebRowSet wb = dao.executeQry(qryIndex);

			if (val1 == null)
				val1 = "0";
			comboValues = hisUtil.getOptionValue(wb, "0", "0^Select Value",
					false);

			hisUtil = null;

		} catch (Exception e) {
			errMsg = "billing.VOUnitValueMst() -->" + e.getMessage();
			new HisException("billing", "VOUnitValueMst().getCmbval1()", errMsg);

		}

		return comboValues;
	}

	public String getStrErrorMsg() {
		return strErrorMsg;
	}

	public void setStrErrorMsg(String strErrorMsg) {
		this.strErrorMsg = strErrorMsg;
	}

	public String getStrLastSeatId() {
		return StrLastSeatId;
	}

	public void setStrLastSeatId(String strLastSeatId) {
		this.StrLastSeatId = strLastSeatId;
	}

	public String getStrSeatId() {
		return StrSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.StrSeatId = strSeatId;
	}

	public String getStrHospitalCode() {
		return StrHospitalCode;
	}

	public void setStrHospitalCode(String strHospitalCode) {
		this.StrHospitalCode = strHospitalCode;
	}

	public String getStrCtDate() {
		HisUtil util = new HisUtil("Unit Value Master", "VOUnitValueMst");
		try {
			StrCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
		} catch (Exception e) {
			new HisException("Billing Module", "Unit Value Master",
					"VOUnitValueMst.getStrCtDate()-->" + e.getMessage());
		}
		return StrCtDate;
	}

	public void setStrCtDate(String strCtDate) {
		this.StrCtDate = strCtDate;
	}

	public String getStrEntryDate() {
		return StrEntryDate;
	}

	public void setStrEntryDate(String strEntryDate) {
		this.StrEntryDate = strEntryDate;
	}

	public String getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(String effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getStrWarning() {
		return StrWarning;
	}

	public void setStrWarning(String strWarning) {
		this.StrWarning = strWarning;
	}

	public String getStrMsg() {
		return StrMsg;
	}

	public void setStrMsg(String strMsg) {
		this.StrMsg = strMsg;
	}

	public String getCmbval2() {
		String errMsg = "";
		String val = this.getFromUnit();
		String val1 = this.getModuleName();

		String qry = new String();

		String comboValues = "<option value='0'> Select Value </option>";
		HisUtil hisUtil = new HisUtil("Unit Value Master", "CNTUnitValueMst");
		try {
			qry = mms.qryHandler_mms.getQuery(1, "select.unitvalue.4");

			comboValues = hisUtil.getOptionValue(qry.replace("?", val), "0",
					"0^Select Value");

			int qryIndex;
			HisDAO dao = null;

			dao = new HisDAO("Billing", "DAOUnitValueMst");

			qryIndex = dao.setQuery(qry);

			dao.setQryValue(qryIndex, 1, this.getStrHospitalCode());
			dao.setQryValue(qryIndex, 2, val1);
			dao.setQryValue(qryIndex, 3, val);

			WebRowSet wb = dao.executeQry(qryIndex);

			if (val1 == null)
				val1 = "0";
			comboValues = hisUtil.getOptionValue(wb, "0", "0^Select Value",
					false);

			hisUtil = null;

		} catch (Exception e) {
			errMsg = "billing.VOUnitValueMst() -->" + e.getMessage();
			new HisException("billing", "VOUnitValueMst().getCmbval2()", errMsg);

		}

		return comboValues;
	}

	public String getStrFromUnitCombo() {
		return StrFromUnitCombo;
	}

	public void setStrFromUnitCombo(String strFromUnitCombo) {
		this.StrFromUnitCombo = strFromUnitCombo;
	}

	public String getStrToUnitCombo() {
		return StrToUnitCombo;
	}

	public void setStrToUnitCombo(String strToUnitCombo) {
		this.StrToUnitCombo = strToUnitCombo;
	}

	public String getFromUnit1() {
		return fromUnit1;
	}

	public void setFromUnit1(String fromUnit1) {
		this.fromUnit1 = fromUnit1;
	}

	public String getToUnit1() {
		return toUnit1;
	}

	public void setToUnit1(String toUnit1) {
		this.toUnit1 = toUnit1;
	}

	public String getStrCmbval() {
		String errMsg = "";
		String cmbstr = "";
		HisUtil hisutil = new HisUtil("Billing", "VOUnitValueMst");

	//	System.out.println("this.getStrModuleId()-"+this.getStrModuleId());
		String qry = mms.qryHandler_mms.getQuery(1,
				"select.unitvalue.1").replace("?",
				"" + this.getStrHospitalCode() + "");
		qry=qry.concat(" AND "+ mms.qryHandler_mms.getQuery(1,
				"select.unitValMst.cond.2").replace("?",
				"" + this.getStrModuleId() + ""));

	//	System.out.println("qry-"+qry);
		int qryIndex;
		HisDAO dao = null;

		try {
			dao = new HisDAO("Billing", "DAOUnitValueMst");
			qryIndex = dao.setQuery(qry);

			cmbstr = hisutil.getOptionValue(qry, "0", "0^Select Value");

		}

		catch (Exception e) {

		}

		return cmbstr;
	}

	public void setStrCmbval(String strCmbval) {
		this.strCmbval = strCmbval;
	}

	public String getStrUnitId() {
		return strUnitId;
	}

	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}

	public String getStrUnitLevel() {
		return strUnitLevel;
	}

	public void setStrUnitLevel(String strUnitLevel) {
		this.strUnitLevel = strUnitLevel;
	}

}
