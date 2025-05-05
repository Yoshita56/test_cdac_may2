/**
 * 
 */
package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import hisglobal.hisconfig.Config;
import hisglobal.transactionutil.TransInterface;

/**
 * @author Anshul Jindal
 *
 */
public class RateContractDtlTransUTL extends TransInterface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 02L;
	HttpSession httpSession = null;
	String[] cmbVal = null;

	public void setHttpSession(HttpSession session) {
		this.httpSession = session;
	}

	public void setCombo(String[] cmb) {
		this.cmbVal = cmb;
	}

	public String getMasterName() {
		String masterName = "Rate Contract Details";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) {
		StringBuffer brMainQuery = new StringBuffer(500);
		String strHospitalCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		// System.out.println("HOSPITAL_CODE-"+strHospitalCode);
		brMainQuery.append("select C.HSTNUM_SUPPLIER_ID||'@'||C.HSTNUM_CONTRACT_TYPE_ID||'@'||" +
				"C.HSTNUM_ITEM_ID||'@'||" +" C.HSTNUM_ITEMBRAND_ID ||'@'||C.GNUM_HOSPITAL_CODE||'@'||" +
						" C.HSTNUM_SLNO||'@'||c.hstnum_ratecontract_id "
						+ "||'^'|| C.supplier_name ||'^'|| NVL(c.HSTSTR_RATECONTRACT_LEVEL,'NA') || '^' || rate_per_unit ||'^'|| c.TAX || '^' || TO_CHAR (c.hstdt_contract_frmdate, 'dd-Mon-yyyy')|| '^' || TO_CHAR (c.hstdt_contract_todate, 'dd-Mon-yyyy')|| '^' ||hstnum_ratecontract_id || '^' || tender  AS DATA" +						
						" FROM (SELECT hstnum_supplier_id, hstnum_contract_type_id, hstnum_item_id," +
						"hstnum_itembrand_id, gnum_hospital_code, hstnum_slno,hstnum_ratecontract_id,mms_mst.get_item_dtl (1," +
						"gnum_hospital_code,hstnum_itembrand_id) item_name,hstnum_rate|| ' / '||" +
						" mms_mst.getunitname (gnum_hospital_code, hstnum_rate_unitid) rate_per_unit,HSTNUM_CONTRACT_QTY,HSTNUM_SECURITY_AMOUNT,MMS_MST.GET_ITEM_DTL(1, GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID) AS TAX ," +
						"hstdt_contract_frmdate, hstdt_contract_todate,HSTSTR_RATECONTRACT_LEVEL,SSTNUM_ITEM_CAT_NO,hstnum_ratecontract_status, gnum_isvalid ,mms_mst.get_supp_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID) as supplier_name,hststr_tender_itemno as tender " +
						"FROM hstt_ratecontract_item_dtl WHERE gnum_isvalid = 1 AND TRUNC (SYSDATE) >= " +
						"hstdt_contract_frmdate AND TRUNC (SYSDATE) <= hstdt_contract_todate) c"+ 
						" WHERE C.GNUM_HOSPITAL_CODE ="+strHospitalCode);
						
		if (cmb != null) {

        if (!cmb[0].equals("0")){
					brMainQuery.append(" AND C.SSTNUM_ITEM_CAT_NO = ");
				    brMainQuery.append(cmb[0]);
			
			}
			
			if (!cmb[1].equals("0")){
				String temp[] = cmb[1].replace("^", "#").split("#");
					brMainQuery.append(" AND C.HSTNUM_SUPPLIER_ID = ");
				    brMainQuery.append(temp[0]);		
			
			}
			
			if (!cmb[2].equals("0")){
				brMainQuery.append(" AND C.HSTNUM_CONTRACT_TYPE_ID = ");
				brMainQuery.append(cmb[2]);	
			}
			
			if (cmb[3].equals("1")){
			    brMainQuery.append(" AND TRUNC (SYSDATE) >= c.hstdt_contract_frmdate AND TRUNC (SYSDATE) <= c.hstdt_contract_todate AND C.HSTNUM_RATECONTRACT_STATUS = ");
				brMainQuery.append(cmb[3]);
			}
			
			else if (cmb[3].equals("2")){
			    brMainQuery.append(" AND TRUNC (SYSDATE) >= c.hstdt_contract_frmdate AND TRUNC (SYSDATE) <= c.hstdt_contract_todate AND C.HSTNUM_RATECONTRACT_STATUS = ");
				brMainQuery.append(cmb[3]);
			}
			
			else if (cmb[3].equals("3")){
				brMainQuery.delete(0, brMainQuery.length());
				
				brMainQuery.append("select C.HSTNUM_SUPPLIER_ID||'@'||C.HSTNUM_CONTRACT_TYPE_ID||'@'||" +
						"C.HSTNUM_ITEM_ID||'@'||" +" C.HSTNUM_ITEMBRAND_ID ||'@'||C.GNUM_HOSPITAL_CODE||'@'||" +
								" C.HSTNUM_SLNO||'@'||c.hstnum_ratecontract_id "
								+ "||'^'|| C.supplier_name ||'^'|| NVL(c.HSTSTR_RATECONTRACT_LEVEL,'NA') || '^' || rate_per_unit ||'^'|| c.TAX || '^' || TO_CHAR (c.hstdt_contract_frmdate, 'dd-Mon-yyyy')|| '^' || TO_CHAR (c.hstdt_contract_todate, 'dd-Mon-yyyy')|| '^' ||hstnum_ratecontract_id || '^' || tender  AS DATA" +						
								" FROM (SELECT hstnum_supplier_id, hstnum_contract_type_id, hstnum_item_id," +
								"hstnum_itembrand_id, gnum_hospital_code, hstnum_slno,hstnum_ratecontract_id,mms_mst.get_item_dtl (1," +
								"gnum_hospital_code,hstnum_itembrand_id) item_name,hstnum_rate|| ' / '||" +
								" mms_mst.getunitname (gnum_hospital_code, hstnum_rate_unitid) rate_per_unit,HSTNUM_CONTRACT_QTY,HSTNUM_SECURITY_AMOUNT,MMS_MST.GET_ITEM_DTL(1, GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID) AS TAX ," +
								"hstdt_contract_frmdate, hstdt_contract_todate,HSTSTR_RATECONTRACT_LEVEL,SSTNUM_ITEM_CAT_NO,hstnum_ratecontract_status, gnum_isvalid ,mms_mst.get_supp_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID) as supplier_name,hststr_tender_itemno as tender " +
								"FROM hstt_ratecontract_item_dtl WHERE gnum_isvalid = 1 AND TRUNC (SYSDATE) > " +
								"hstdt_contract_frmdate AND TRUNC (SYSDATE) > hstdt_contract_todate) c"+ 
								" WHERE C.GNUM_HOSPITAL_CODE ="+strHospitalCode);
				
				
				
				if (!cmb[0].equals("0")){
					brMainQuery.append(" AND C.SSTNUM_ITEM_CAT_NO = ");
				    brMainQuery.append(cmb[0]);
			
				}
				
				if (!cmb[1].equals("0")){
					String temp[] = cmb[1].replace("^", "#").split("#");
						brMainQuery.append(" AND C.HSTNUM_SUPPLIER_ID = ");
					    brMainQuery.append(temp[0]);		
				
				}
				
			   // brMainQuery.append(" AND TRUNC (SYSDATE) > c.hstdt_contract_frmdate AND TRUNC (SYSDATE) > c.hstdt_contract_todate ");
			}

		}
        
		
		System.out.println("Rate Contract brMainQuery.toString()->"+brMainQuery.toString());
		return brMainQuery.toString();
	}

	public String[] getSearchField() 
	{
		String search_field[] = {"1", "C.supplier_name","4","C.TAX","7","hstnum_ratecontract_id"};
		return search_field;
	}

	public String[] getComboHeader() 
	{
		String[] strComboHeader = {"0^1","Item Category","0^1","Supplier Name","0^2","Contract Type","1","Status"};
	    return strComboHeader;
	}

	public String[] getColumnHeader() 
	{
		String[] strColumnHeader = {  "Supplier Name","Level","Rate/Unit","Item","Contract From", "Contract To","Rc No.","RC/Tender No."};
		return strColumnHeader;
	}      

	public String[] getComboQuery() 
	{
	
		String[] comboQuery = new String[4];
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		
		comboQuery[0] = "select sstnum_item_cat_no,sstnum_item_cat_name from sstt_item_category_mst where gnum_isvalid = 1 and gnum_hospital_code = ? order by sstnum_item_cat_no";
		comboQuery[0] = comboQuery[0].replace("?", Config.SUPER_USER_HOSPITAL_CODE);
		
		comboQuery[1] = "select HSTNUM_SUPPLIER_ID||'^'||SSTNUM_ITEM_CAT_NO" +
				"||'^'|| mms_mst.get_itemcat_dtl(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO),INITCAP(HSTSTR_SUPPLIER_NAME) from HSTT_SUPPLIER_MST " +
				"where  GNUM_ISVALID = 1 and HSTNUM_SUPPLIER_STATUS=1 and SSTNUM_ITEM_CAT_NO = #1#  and GNUM_HOSPITAL_CODE = ?	and (HSTNUM_IS_SUPPLIER = 1 " +
				"OR HSTNUM_IS_MANUFACTURER=1) ORDER BY HSTSTR_SUPPLIER_NAME";
		comboQuery[1] = comboQuery[1].replace("?", Config.SUPER_USER_HOSPITAL_CODE);
		
		comboQuery[2] = "SELECT SSTNUM_CONTRACTTYPE_ID,SSTSTR_CONTRACTTYPE_NAME FROM " +
				"SSTT_RATE_CONTRACTTYPE_MST WHERE GNUM_ISVALID=1 AND GNUM_HOSPITAL_CODE=? order by hstnum_s_no";
		comboQuery[2] = comboQuery[2].replace("?", Config.SUPER_USER_HOSPITAL_CODE);

		comboQuery[3] = "1^Active#2^Canceled#3^Expired";
		
		//System.out.println("comboQuery[0]-"+comboQuery[0]);
		//System.out.println("comboQuery[1]-"+comboQuery[1]);
		//System.out.println("comboQuery[2]-"+comboQuery[2]);

		return comboQuery;
	}
	

	public String getViewQuery() {
		return "";
	}

	public String getButtons() {
		String strButtons = "";
		//"<a style=cursor:pointer><img src='../../hisglobal/images/btn-ccl.png'  border=0 tabindex='1' onKeyPress='cancelPage();' onClick='cancelPage();' ></a>";
		return strButtons;
	}

	public String[] getDeleteQuery() {
		String deleteQuery[] = new String[1];
		deleteQuery[0] = "";

		return deleteQuery;
	}

	public List<String> getDeleteData(String chk) {
		String a[] = null;
		 
		List<String> deleteData = new ArrayList<String>();
		a = (chk.replace('|', '#')).split("#");
	 		
		deleteData.add(a[0].replace('@', '#').split("#")[0]);
		return deleteData;
	}

	public String getJsFiles() {
		String files = "../js/rate_contract_trans.js";
		return files;

	}

	public String[] getRowStatus() {
		String[] status = {"Autrin Cap", "2", "brown", ""};
		return status;
	}

	public String getEventState() {
		String str = "";
		return str;
	}

	public String getButtonConfiguration() {
		return "left";
	}

	public String[] getUserDefinedButtons() {
		String[] strButtons = {"Add@validateAddRateContract(document.forms[0],'ADD')@0@3b5998@glyphicon-plus",
				"Renew@validateRenew(document.forms[0],'RENEW')@1@ea4c89@glyphicon-share",
				"Cancel@validateCancelRateContract(document.forms[0],'CANCEL')@1@bb0000@glyphicon-remove",
				"View@validateViewRateContract(document.forms[0],'VIEW')@1@007bb6@glyphicon-fullscreen",
				"RC EXTN@validateRateContractExtn(document.forms[0],'RCEXTN')@1@517fa4@glyphicon-export",
				"MODIFY@validateRateContractModify(document.forms[0],'MODIFY')@1@ff5057@glyphicon-edit"};		
		return strButtons;
	}

	public String[] getDbButtons() {
		//String[] str = { "1" };
		return null;
	}

	public int getMinPanelButton() {
		return 1;
	}

	public String getMenuOption() {
		String menuType = "Tiles";
		return menuType;
	}

	public String getComboEventState() {
		return "";
	}

	public String[] getOrderBy() {
		String orderBy[] = { "1", "c.item_name"};
		return orderBy;
	}
	
	@Override
	public String[] getButtonIcons() {
		String[] str={"AddOnDesk.png","RenewOnDesk.png","CancelOnDesk.png","ViewOnDesk.png","ViewOnDesk.png","ViewOnDesk.png"};
		// TODO Auto-generated method stub
		return str;
	}
	
}
