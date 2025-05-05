package ipd;

import java.util.Map;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

public class IpdVO implements TransferObject{

private static final long serialVersionUID = 02L;
	
	private String strMsgString = "";
	private String strMsgType = "0";

	private String strImagePath="";
	private String strValue1 = "0";
	private String strValue2 = "0";
	private String strValue3 = "0";
	private String strValue4 = "";
	private String strValue5 = "";
	private String strValue6 = "";
	private String strValue7 = "";
	private String strValue8 = "";
	private String strValue9 = "";
	private String strWardCode = "";
	private String strRoomCode = "";
	private int strWinResize = 0;
	private String strBedTypeCode = "";
	private String strDeptUnitCode = "";
	private String strDeptCode = "";
	private String strBedProperty = "";
	private String strHospCode = "";
	private String strValue10 = "";
	private String strErrMsgString = "";
	private String strBedChartMode = "";
	private String strFromDate = "";
	private String strToDate = "";
	private String strProcessName="";
	private String strMenuName="";
	private String strFromDateActivitylog = "";
	private String strToDateActivitylog = "";
	private String strUsrId = "";
	private String strVacantBed="";
	private String strCRNo = "";
	private WebRowSet gblWs1 = null;
	private WebRowSet gblWs2 = null;
	private WebRowSet gblWs3 = null;
	private WebRowSet gblWs4 = null;
	private WebRowSet gblWs5 = null;
	private WebRowSet bedDetailWS=null;
	private WebRowSet bedPropertiesWS=null;
	private Map<String,String> mapBedProperties = null;
	private String strSeatId = "";
	private String hospitalCode = "";
	private String wardStatistics="";
	private String strHospDtl="";
	private WebRowSet bedstatusDashWS=null;
	private WebRowSet roomWS=null;
	private WebRowSet bedValuesDashWS=null;
	private WebRowSet bedPropsMapping=null;
	private String strModuleName = "";
	
		
	
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	/**
	 * @return the strImagePath
	 */
	public String getStrImagePath() {
		return strImagePath;
	}
	/**
	 * @param strImagePath the strImagePath to set
	 */
	public void setStrImagePath(String strImagePath) {
		this.strImagePath = strImagePath;
	}
	/**
	 * @return the strCRNo
	 */
	public String getStrCRNo() {
		return strCRNo;
	}
	/**
	 * @param strCRNo the strCRNo to set
	 */
	public void setStrCRNo(String strCRNo) {
		this.strCRNo = strCRNo;
	}
	/**
	 * @return the mapBedProperties
	 */
	public Map<String,String> getMapBedProperties() {
		return mapBedProperties;
	}
	/**
	 * @param mapBedProperties the mapBedProperties to set
	 */
	public void setMapBedProperties(Map<String,String> mapBedProperties) {
		this.mapBedProperties = mapBedProperties;
	}
	public WebRowSet getBedPropertiesWS() {
		return bedPropertiesWS;
	}
	public void setBedPropertiesWS(WebRowSet bedPropertiesWS) {
		this.bedPropertiesWS = bedPropertiesWS;
	}
	public WebRowSet getBedDetailWS() {
		return bedDetailWS;
	}
	public void setBedDetailWS(WebRowSet bedDetailWS) {
		this.bedDetailWS = bedDetailWS;
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
	public String getStrValue1() {
		return strValue1;
	}
	public void setStrValue1(String strValue1) {
		this.strValue1 = strValue1;
	}
	public String getStrValue2() {
		return strValue2;
	}
	public void setStrValue2(String strValue2) {
		this.strValue2 = strValue2;
	}
	public String getStrValue3() {
		return strValue3;
	}
	public void setStrValue3(String strValue3) {
		this.strValue3 = strValue3;
	}
	public WebRowSet getGblWs1() {
		return gblWs1;
	}
	public void setGblWs1(WebRowSet gblWs1) {
		this.gblWs1 = gblWs1;
	}
	public WebRowSet getGblWs2() {
		return gblWs2;
	}
	public void setGblWs2(WebRowSet gblWs2) {
		this.gblWs2 = gblWs2;
	}
	public WebRowSet getGblWs3() {
		return gblWs3;
	}
	public void setGblWs3(WebRowSet gblWs3) {
		this.gblWs3 = gblWs3;
	}
	public WebRowSet getGblWs4() {
		return gblWs4;
	}
	public void setGblWs4(WebRowSet gblWs4) {
		this.gblWs4 = gblWs4;
	}
	public WebRowSet getGblWs5() {
		return gblWs5;
	}
	public void setGblWs5(WebRowSet gblWs5) {
		this.gblWs5 = gblWs5;
	}
	public String getStrValue4() {
		return strValue4;
	}
	public void setStrValue4(String strValue4) {
		this.strValue4 = strValue4;
	}
	public String getStrValue5() {
		return strValue5;
	}
	public void setStrValue5(String strValue5) {
		this.strValue5 = strValue5;
	}
	public String getStrValue6() {
		return strValue6;
	}
	public void setStrValue6(String strValue6) {
		this.strValue6 = strValue6;
	}
	public String getStrValue7() {
		return strValue7;
	}
	public void setStrValue7(String strValue7) {
		this.strValue7 = strValue7;
	}
	/**
	 * @return the strValue8
	 */
	public String getStrValue8() {
		return strValue8;
	}
	/**
	 * @param strValue8 the strValue8 to set
	 */
	public void setStrValue8(String strValue8) {
		this.strValue8 = strValue8;
	}
	/**
	 * @return the strValue9
	 */
	public String getStrValue9() {
		return strValue9;
	}
	/**
	 * @param strValue9 the strValue9 to set
	 */
	public void setStrValue9(String strValue9) {
		this.strValue9 = strValue9;
	}
	/**
	 * @return the strValue10
	 */
	public String getStrValue10() {
		return strValue10;
	}
	/**
	 * @param strValue10 the strValue10 to set
	 */
	public void setStrValue10(String strValue10) {
		this.strValue10 = strValue10;
	}
	public String getStrWardCode() {
		return strWardCode;
	}
	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}
	public String getStrRoomCode() {
		return strRoomCode;
	}
	public void setStrRoomCode(String strRoomCode) {
		this.strRoomCode = strRoomCode;
	}
	public String getStrBedTypeCode() {
		return strBedTypeCode;
	}
	public void setStrBedTypeCode(String strBedTypeCode) {
		this.strBedTypeCode = strBedTypeCode;
	}
	public String getStrDeptUnitCode() {
		return strDeptUnitCode;
	}
	public void setStrDeptUnitCode(String strDeptUnitCode) {
		this.strDeptUnitCode = strDeptUnitCode;
	}
	public String getStrHospCode() {
		return strHospCode;
	}
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getStrErrMsgString() {
		return strErrMsgString;
	}
	public void setStrErrMsgString(String strErrMsgString) {
		this.strErrMsgString = strErrMsgString;
	}
	public String getStrBedProperty() {
		return strBedProperty;
	}
	public void setStrBedProperty(String strBedProperty) {
		this.strBedProperty = strBedProperty;
	}
	public int getStrWinResize() {
		return strWinResize;
	}
	public void setStrWinResize(int strWinResize) {
		this.strWinResize = strWinResize;
	}
	public String getStrBedChartMode() {
		return strBedChartMode;
	}
	public void setStrBedChartMode(String strBedChartMode) {
		this.strBedChartMode = strBedChartMode;
	}
	public String getStrVacantBed() {
		return strVacantBed;
	}
	public void setStrVacantBed(String strVacantBed) {
		this.strVacantBed = strVacantBed;
	}
	public String getStrDeptCode() {
		return strDeptCode;
	}
	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}
	public String getWardStatistics() {
		return wardStatistics;
	}
	public void setWardStatistics(String wardStatistics) {
		this.wardStatistics = wardStatistics;
	}
	public String getStrHospDtl() {
		return strHospDtl;
	}
	public void setStrHospDtl(String strHospDtl) {
		this.strHospDtl = strHospDtl;
	}
	public WebRowSet getBedstatusDashWS() {
		return bedstatusDashWS;
	}
	public void setBedstatusDashWS(WebRowSet bedstatusDashWS) {
		this.bedstatusDashWS = bedstatusDashWS;
	}
	public WebRowSet getBedValuesDashWS() {
		return bedValuesDashWS;
	}
	public void setBedValuesDashWS(WebRowSet bedValuesDashWS) {
		this.bedValuesDashWS = bedValuesDashWS;
	}
	public WebRowSet getRoomWS() {
		return roomWS;
	}
	public void setRoomWS(WebRowSet roomWS) {
		this.roomWS = roomWS;
	}
	public WebRowSet getBedPropsMapping() {
		return bedPropsMapping;
	}
	public void setBedPropsMapping(WebRowSet bedPropsMapping) {
		this.bedPropsMapping = bedPropsMapping;
	}
	public String getStrFromDate() {
		return strFromDate;
	}
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}
	public String getStrToDate() {
		return strToDate;
	}
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}
	public String getStrUsrId() {
		return strUsrId;
	}
	public void setStrUsrId(String strUsrId) {
		this.strUsrId = strUsrId;
	}
	public String getStrFromDateActivitylog() {
		return strFromDateActivitylog;
	}
	public void setStrFromDateActivitylog(String strFromDateActivitylog) {
		this.strFromDateActivitylog = strFromDateActivitylog;
	}
	public String getStrToDateActivitylog() {
		return strToDateActivitylog;
	}
	public void setStrToDateActivitylog(String strToDateActivitylog) {
		this.strToDateActivitylog = strToDateActivitylog;
	}
	public String getStrProcessName() {
		return strProcessName;
	}
	public void setStrProcessName(String strProcessName) {
		this.strProcessName = strProcessName;
	}
	public String getStrMenuName() {
		return strMenuName;
	}
	public void setStrMenuName(String strMenuName) {
		this.strMenuName = strMenuName;
	}
	public String getStrModuleName() {
		return strModuleName;
	}
	public void setStrModuleName(String strModuleName) {
		this.strModuleName = strModuleName;
	}
	


	
}