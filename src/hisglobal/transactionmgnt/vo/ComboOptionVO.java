/**
 * 
 */
package hisglobal.transactionmgnt.vo;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

/**
 * @author Pankaj Kumar
 *
 */
public class ComboOptionVO implements TransferObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String strMsgString="";
	String strMsgType="";
	String strProcedureName;
	String strQuery;
	LinkedHashMap<String,String> mapProcedureParam;
	HashMap<String,String> mapQueryParam;
	WebRowSet wsOptionValues;
	
	public void resetVO(){
		strMsgString="";
		strMsgType="";
		strProcedureName="";
		strQuery="";
		mapProcedureParam=null;
		wsOptionValues=null;
	}
	/**
	 * @return the mapQueryParam
	 */
	public HashMap<String, String> getMapQueryParam() {
		return mapQueryParam;
	}
	/**
	 * @param mapQueryParam the mapQueryParam to set
	 */
	public void setMapQueryParam(HashMap<String, String> mapQueryParam) {
		this.mapQueryParam = mapQueryParam;
	}
	/**
	 * @return the mapProcedureParam
	 */
	public LinkedHashMap<String, String> getMapProcedureParam() {
		return mapProcedureParam;
	}
	/**
	 * @param mapProcedureParam the mapProcedureParam to set
	 */
	public void setMapProcedureParam(LinkedHashMap<String, String> mapProcedureParam) {
		this.mapProcedureParam = mapProcedureParam;
	}
	/**
	 * @return the wsOptionValues
	 */
	public WebRowSet getWsOptionValues() {
		return wsOptionValues;
	}
	/**
	 * @param wsOptionValues the wsOptionValues to set
	 */
	public void setWsOptionValues(WebRowSet wsOptionValues) {
		this.wsOptionValues = wsOptionValues;
	}
	/**
	 * @return the strProcedureName
	 */
	public String getStrProcedureName() {
		return strProcedureName;
	}
	/**
	 * @param strProcedureName the strProcedureName to set
	 */
	public void setStrProcedureName(String strProcedureName) {
		this.strProcedureName = strProcedureName;
	}
	/**
	 * @return the strQuery
	 */
	public String getStrQuery() {
		return strQuery;
	}
	/**
	 * @param strQuery the strQuery to set
	 */
	public void setStrQuery(String strQuery) {
		this.strQuery = strQuery;
	}
	/**
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}
	/**
	 * @param strMsgString the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	/**
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}
	/**
	 * @param strMsgType the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	
	

}
