/**
 * 
 */
package mms.transactions.dao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import hisglobal.utility.SMSHttpsNICPostClient;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.vo.PODeskGenerateTransNewVO;
import mms.transactions.vo.PODeskGenerateTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskGenerateTransDAO {

public static void getPODetails(PODeskGenerateTransVO _PODeskGenerateTransVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Po_Details(?,?,?,?,?,?)}"; // 6
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS","transactions.PODeskGenerateTransDAO.getPODetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "4",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "pono", _PODeskGenerateTransVO.getStrPONo(),3);
			dao.setProcInValue(nProcIndex, "storeId", _PODeskGenerateTransVO.getStrStoreId(),4);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				wsResult.next();
				_PODeskGenerateTransVO.setStrPODate(wsResult.getString(1));
				_PODeskGenerateTransVO.setStrSupplierName(wsResult.getString(2));
				_PODeskGenerateTransVO.setStrPOType(wsResult.getString(3));
				_PODeskGenerateTransVO.setStrSupplierId(wsResult.getString(7));
				_PODeskGenerateTransVO.setStrPOTypeId(wsResult.getString(8));
				_PODeskGenerateTransVO.setStrItemCat(wsResult.getString(11));
				_PODeskGenerateTransVO.setStrItemCatName(wsResult.getString(12));
				_PODeskGenerateTransVO.setStrTotalPOCost(wsResult.getString(6));
				_PODeskGenerateTransVO.setStrStoreName(wsResult.getString(35));
				// //System.out.println("Qu No:::"+wsResult.getString(24));
				// PO_DATE ^ SUPP NAME ^ PO TYPE ^ CURRENCY CODE ^ NET ADVANCE ^
				// PO NET AMOUNT ^ SUPPLIER ID ^ PO Type ^ Currency Id ^
				// Currency Value ^ Item Catg No ^ Catg Name ^ Purchase Source
				// ID ^ Purchase Source Name ^ Currency Id ^ Currency Value ^
				// Advance Amt ^ PO Prefix With PO No ^ Delivery Date ^ PO
				// PreFix ^ TAX ^ Tender No ^ Tender Date ^ Qutation No ^
				// Qutation Date ^ PO Date ^ Verify Date ^ Verify By ^ (29)
				// Financial Start Date ^ (30) Financial End Date
				_PODeskGenerateTransVO.setStrPOHiddenValue(wsResult
						.getString(1)
						+ "^"
						+ wsResult.getString(2)
						+ "^"
						+ wsResult.getString(3)
						+ "^"
						+ wsResult.getString(4)
						+ "^"
						+ wsResult.getString(5)
						+ "^"
						+ wsResult.getString(6)
						+ "^"
						+ wsResult.getString(7)
						+ "^"
						+ wsResult.getString(8)
						+ "^"
						+ wsResult.getString(9)
						+ "^"
						+ wsResult.getString(10)
						+ "^"
						+ wsResult.getString(11)
						+ "^"
						+ wsResult.getString(12)
						+ "^"
						+ wsResult.getString(13)
						+ "^"
						+ wsResult.getString(14)
						+ "^"
						+ wsResult.getString(15)
						+ "^"
						+ wsResult.getString(16)
						+ "^"
						+ wsResult.getString(17)
						+ "^"
						+ wsResult.getString(18)
						+ "^"
						+ wsResult.getString(19)
						+ "^"
						+ wsResult.getString(20)
						+ "^"
						+ wsResult.getString(21)
						+ "^"
						+ wsResult.getString(22)
						+ "^"
						+ wsResult.getString(23)
						+ "^"
						+ wsResult.getString(24)
						+ "^"
						+ wsResult.getString(25)
						+ "^"
						+ wsResult.getString(26)
						+ "^"
						+ wsResult.getString(27)
						+ "^"
						+ wsResult.getString(28)
						+ "^"
						+ wsResult.getString(29)
						+ "^"
						+ wsResult.getString(30)
						+ "^"
						+ wsResult.getString(36)
						+ "^"
						+ wsResult.getString(37));
			
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getPODetails() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	/**
	 * To get the item category values
	 * 
	 */
	public static void setItemCatValues(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_item_category_list(?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransDAO.setItemCatValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setItemCatValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "3",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO
					.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex, "store_id",  (_poDeskGenerateTransVO.getStrStoreId()==null || _poDeskGenerateTransVO.getStrStoreId().equals(""))?"0":_poDeskGenerateTransVO.getStrStoreId(),2);
			dao.setProcInValue(nProcIndex, "reqType", "0",4); // Default Value
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_poDeskGenerateTransVO.setStrItemCatValues(util.getOptionValue(
						wsResult, "", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.setItemCatValues() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	/**
	 * To get the item category values
	 * 
	 */
	public static void getPOPrefixCmb1(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_POPrefix_list(?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransDAO.setPOPrefixCmb()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getPOPrefixCmb()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
			{
				String strPrefix = _poDeskGenerateTransVO.getStrPoRefrenceNo();
								
				int intStrLen = strPrefix.length();
				int intEndIndex = strPrefix.lastIndexOf("/");
				strPrefix = strPrefix.substring(0,intEndIndex);
				
				intStrLen = strPrefix.length();
				intEndIndex = strPrefix.lastIndexOf("/");
				strPrefix = strPrefix.substring(0,intEndIndex);
				
				//System.out.println("strPrefix = "+strPrefix);
				//System.out.println("intIndex = "+intEndIndex);
				
				_poDeskGenerateTransVO
						.setStrPoRefrenceNoCmb(util.getOptionValue(wsResult,
								strPrefix,
								"0^Select Value", false,true));
			}
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.setPOPrefixCmb() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}
	
	/**
	 * To get the PO Type values
	 * 
	 */
	public static void setPOTypeValues(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Sstt_indenttype_Dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransDAO.setItemCatValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setItemCatValues()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "req_for", "2",3);
			dao.setProcInValue(nProcIndex, "item_cat", _poDeskGenerateTransVO.getStrItemCat(),4);
			dao.setProcInValue(nProcIndex, "store_id", _poDeskGenerateTransVO.getStrStoreId(),5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_poDeskGenerateTransVO.setStrPOTypeValues(util.getOptionValue(
						wsResult, "", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.setPOTypeValues() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void setSupplierValues(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {

		String strproc_name = "{call pkg_mms_view.Proc_Supplier_List(?,?,?,?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS","transactions.PODeskGenerateTransDAO.setSupplierValues()");
			dao = new HisDAO("MMS",	"transactions.PODeskGenerateTransDAO.setSupplierValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			
			if (!_poDeskGenerateTransVO.getStrContractType().equals(""))
				dao.setProcInValue(nProcIndex, "modeval", "7",1);
			else
				dao.setProcInValue(nProcIndex, "modeval", "1",1); //ALL Supplier List
			
			    dao.setProcInValue(nProcIndex, "catCode", _poDeskGenerateTransVO.getStrItemCat(),2);
			    dao.setProcInValue(nProcIndex, "branditem_id", "0",3);// default value
			    dao.setProcInValue(nProcIndex, "contractType",	_poDeskGenerateTransVO.getStrContractType(),4);
                dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode(),5);   
			    dao.setProcOutValue(nProcIndex, "err", 1,6);
			    dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			    //System.out.println("contractType :"+_poDeskGenerateTransVO.getStrContractType()+"Cat Code :"+_poDeskGenerateTransVO.getStrItemCat()+"Hosp Code :"+_poDeskGenerateTransVO.getStrHospitalCode());
			    dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_poDeskGenerateTransVO.setStrSupplierValues(util
						.getOptionValue(wsResult, "", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.setSupplierValues() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}
	
	public static void setSupplierValuesBasedOnRC(PODeskGenerateTransVO _poDeskGenerateTransVO) {

		String strproc_name = "{call pkg_mms_view.Proc_Supplier_List(?,?,?,?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try 
		{
			
			
			
			util = new HisUtil("MMS","transactions.PODeskGenerateTransDAO.setSupplierValues()");
			dao = new HisDAO("MMS",	"transactions.PODeskGenerateTransDAO.setSupplierValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			
				if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("21"))
				{
					System.out.println("--------------- PODeskGenerateTransDAO.setSupplierValuesBasedOnRC ---- [  pkg_mms_view.Proc_Supplier_List - 12 ]---------------");
					dao.setProcInValue(nProcIndex, "modeval", "12",1); //Supplier Based on RC in case of bulk demand
				}else
				{
					System.out.println("--------------- PODeskGenerateTransDAO.setSupplierValuesBasedOnRC ---- [  pkg_mms_view.Proc_Supplier_List - 15 ]---------------");
					dao.setProcInValue(nProcIndex, "modeval", "15",1);
				}
			
			    dao.setProcInValue(nProcIndex, "catCode", _poDeskGenerateTransVO.getStrItemCat(),2);
			    dao.setProcInValue(nProcIndex, "branditem_id", _poDeskGenerateTransVO.getStrItemBrandIds(),3);
			    dao.setProcInValue(nProcIndex, "contractType",	_poDeskGenerateTransVO.getStrContractType(),4);
                dao.setProcInValue(nProcIndex, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode(),5);   
			    dao.setProcOutValue(nProcIndex, "err", 1,6);
			    dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			    //System.out.println("contractType :"+_poDeskGenerateTransVO.getStrContractType()+"Cat Code :"+_poDeskGenerateTransVO.getStrItemCat()+"Hosp Code :"+_poDeskGenerateTransVO.getStrHospitalCode()+"brand"+_poDeskGenerateTransVO.getStrItemBrandIds());
			    dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
			{
				if(wsResult.size() > 0)
				{
					wsResult.next();
					
					_poDeskGenerateTransVO.setStrSupp(wsResult.getString(1));
					
					wsResult.beforeFirst();
					
					_poDeskGenerateTransVO.setStrSupplierValuesRC(util.getOptionValue(wsResult, "", "", false));
					
					
					
				}
				else
				{	
					_poDeskGenerateTransVO.setStrSupp("0@0@0@0@0@0");
					_poDeskGenerateTransVO.setStrSupplierValuesRC(util
							.getOptionValue(wsResult, "", "0@0^Select Value", false));
				}
				
			}
				
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.setSupplierValues() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}
	
	public static void setSupplierValuesBasedOnRCDraftPO(PODeskGenerateTransVO _poDeskGenerateTransVO) {

		String strproc_name = "{call pkg_mms_view.Proc_Supplier_List(?,?,?,?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try 
		{
			System.out.println("------------- PODeskGenerateTransDAO.setSupplierValuesBasedOnRCDraftPO ------pkg_mms_view.Proc_Supplier_List-[ Mode - 18]----------");
			
			util = new HisUtil("MMS","transactions.PODeskGenerateTransDAO.setSupplierValues()");
			dao = new HisDAO("MMS",	"transactions.PODeskGenerateTransDAO.setSupplierValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			
				//if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("21"))
					dao.setProcInValue(nProcIndex, "modeval", "18",1); //Supplier Based on RC in case of bulk demand
				//else
				//	dao.setProcInValue(nProcIndex, "modeval", "15",1);
			
			    dao.setProcInValue(nProcIndex, "catCode", _poDeskGenerateTransVO.getStrSupplierId().split("@")[0],2); //user to get particular supplier only which was used while saving draft PO 
			    dao.setProcInValue(nProcIndex, "branditem_id", _poDeskGenerateTransVO.getStrItemBrandIds(),3);
			    dao.setProcInValue(nProcIndex, "contractType",	_poDeskGenerateTransVO.getStrContractType(),4);
                dao.setProcInValue(nProcIndex, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode(),5);   
			    dao.setProcOutValue(nProcIndex, "err", 1,6);
			    dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			    //System.out.println("contractType :"+_poDeskGenerateTransVO.getStrContractType()+"Cat Code :"+_poDeskGenerateTransVO.getStrItemCat()+"Hosp Code :"+_poDeskGenerateTransVO.getStrHospitalCode()+"brand"+_poDeskGenerateTransVO.getStrItemBrandIds());
			    dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
			{
				if(wsResult.size() > 0)
				{
					wsResult.next();
					_poDeskGenerateTransVO.setStrSupp(wsResult.getString(1));
					wsResult.beforeFirst();
					_poDeskGenerateTransVO.setStrSupplierValuesRC(util
							.getOptionValue(wsResult, _poDeskGenerateTransVO.getStrSupplierId(), "", false));
					
					
				}
				else
				{	
					_poDeskGenerateTransVO.setStrSupp("0@0@0@0");
					_poDeskGenerateTransVO.setStrSupplierValuesRC(util
							.getOptionValue(wsResult, "", "0@0^Select Value", false));
				}
				
			}
				
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.setSupplierValues() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}
	
	public static void setSupplierDetailsBasedOnRC(PODeskGenerateTransVO _poDeskGenerateTransVO) {

		String strproc_name = "{call pkg_mms_view.Proc_Supplier_List(?,?,?,?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS","transactions.PODeskGenerateTransDAO.setSupplierValues()");
			dao = new HisDAO("MMS",	"transactions.PODeskGenerateTransDAO.setSupplierValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			
			
				dao.setProcInValue(nProcIndex, "modeval", "16",1); //Supplier Based on RC
			
			    dao.setProcInValue(nProcIndex, "catCode", _poDeskGenerateTransVO.getStrSupplierId().split("@")[0],2);
			    dao.setProcInValue(nProcIndex, "branditem_id", _poDeskGenerateTransVO.getStrItemBrandIds(),3);
			    dao.setProcInValue(nProcIndex, "contractType",	_poDeskGenerateTransVO.getStrContractType(),4);
                dao.setProcInValue(nProcIndex, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode(),5);   
			    dao.setProcOutValue(nProcIndex, "err", 1,6);
			    dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			    //System.out.println("contractType :"+_poDeskGenerateTransVO.getStrContractType()+"Cat Code :"+_poDeskGenerateTransVO.getStrItemCat()+"Hosp Code :"+_poDeskGenerateTransVO.getStrHospitalCode()+"brand"+_poDeskGenerateTransVO.getStrItemBrandIds());
			    dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				if(wsResult.size()>0)
					_poDeskGenerateTransVO.setSupplierDetail(util
						.getOptionValue(wsResult, "", "0@0^Select Value", false));
				else
					_poDeskGenerateTransVO.setSupplierDetail(util
							.getOptionValue(wsResult, "", "0@0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.setSupplierValues() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}
	public static void setPurchaseSourceValues(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {

		String strproc_name = "{call pkg_mms_view.Proc_sstt_purchase_source_mst(?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransDAO.setPurchaseSourceValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setPurchaseSourceValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO
					.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_poDeskGenerateTransVO.setStrPurchaseSourceValues(util
						.getOptionValue(wsResult, "", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.setPurchaseSourceValues() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void getPOItemList1(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {

		String strproc_name = "{call pkg_mms_view.proc_item_list_for_po(?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?)}"; // 10
																								// Variables

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;
		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransDAO.getPOItemList()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getPOItemList()");

			nProcIndex = dao.setProcedure(strproc_name);
			// //System.out.println("Hosp
			// Code:::"+_poDeskGenerateTransVO.getStrHospitalCode());
			// //System.out.println("catCode:::"+_poDeskGenerateTransVO.getStrItemCat());
			// //System.out.println("po_store_id:::"+_poDeskGenerateTransVO.getStrStoreId());
			// //System.out.println("startDate:::"+_poDeskGenerateTransVO.getStrFinancialStartDate());
			// //System.out.println("endDate:::"+_poDeskGenerateTransVO.getStrFinancialToDate());

			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "catCode", _poDeskGenerateTransVO.getStrPONo(),3);
			dao.setProcInValue(nProcIndex, "po_store_id",_poDeskGenerateTransVO.getStrStoreId(),4);
			dao.setProcInValue(nProcIndex, "startDate", _poDeskGenerateTransVO.getStrFinancialStartDate(),5);
			dao.setProcInValue(nProcIndex, "endDate", _poDeskGenerateTransVO.getStrFinancialToDate(),6);

			dao.setProcInValue(nProcIndex, "suppId", "0",7);
			dao.setProcInValue(nProcIndex, "poRefDate", "0",8);

			dao.setProcOutValue(nProcIndex, "err", 1,9);
			dao.setProcOutValue(nProcIndex, "resultset", 2,10);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_poDeskGenerateTransVO.setStrPOItemCmb(util.getOptionValue(
						wsResult, "0", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getPOItemList() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}
	
	
	public static void setDeliveryLocationValues(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {

		String strproc_name = "{call Pkg_Mms_View.proc_hstt_store_mst_time_bound(?,?,?,?,?,?,?,?)}";
		//	"{call pkg_mms_view.proc_hstt_store_mst(?,?,?,?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransDAO.setDeliveryLocationValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setDeliveryLocationValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex, "seatid", _poDeskGenerateTransVO.getStrSeatId(),2);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "storeid", _poDeskGenerateTransVO.getStrItemCatNo(),4);//here category is passed as store id to get delivery location based on category
			dao.setProcInValue(nProcIndex, "storetype_id", "0",5);
			dao.setProcInValue(nProcIndex, "reqtype", "22,87,90",6);	//Indent for Annual Purchase,Bulk purchase
			/* Setting Default Value End */

			
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
 
			if (strErr == null || strErr.equals(""))
				_poDeskGenerateTransVO.setStrDeliveryLocationValues(util
						.getOptionValue(wsResult, _poDeskGenerateTransVO.getStrStoreId(), "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.setDeliveryLocationValues() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void setAgentNameValues(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {

		String strproc_name = "{call pkg_mms_view.Proc_Supplier_List(?,?,?,?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransDAO.setAgentNameValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setAgentNameValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "8",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO
					.getStrHospitalCode(),5);
			dao.setProcInValue(nProcIndex, "catCode", _poDeskGenerateTransVO
					.getStrItemCat(),2);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "branditem_id", "0",3);
			dao.setProcInValue(nProcIndex, "contractType", "0",4);
			/* Setting Default Value End */
		 
			
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_poDeskGenerateTransVO.setStrAgentNameValues(util
						.getOptionValue(wsResult, "", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.setAgentNameValues() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void setCurrencyValues(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {

		String strproc_name = "{call pkg_mms_view.proc_currency_list(?,?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransDAO.setCurrencyValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setCurrencyValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "isDefault", "0",3); // Default value
			dao.setProcOutValue(nProcIndex, "err", 1,4);
			dao.setProcOutValue(nProcIndex, "resultset", 2,5);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_poDeskGenerateTransVO.setStrCurrencyValues(util
						.getOptionValue(wsResult, "", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.setCurrencyValues() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void getRequestDetails(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
		//String strproc_name = "{call PKG_MMS_VIEW.Proc_Hstt_Agenda_Dtl(?,?,?,?,?,?,?,?,?)}";
		String strproc_name = "{call PKG_MMS_VIEW.PROC_SSTT_INDENT_DTL(?,?,?,?,? ,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getRequestDetails()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			/*dao.setProcInValue(nProcIndex, "modval", "4",1);
			
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex, "po_type", _poDeskGenerateTransVO.getStrPOTypeId().substring(0,2),6);
			dao.setProcInValue(nProcIndex, "store_id", _poDeskGenerateTransVO.getStrStoreId(),2);
			dao.setProcInValue(nProcIndex, "item_cat", _poDeskGenerateTransVO.getStrItemCat(),5);
			dao.setProcInValue(nProcIndex, "grant_type", _poDeskGenerateTransVO.getStrPOGrantType(),7);
			dao.setProcInValue(nProcIndex, "agenda_no", "",4); // Default value*/

//			//System.out.println("hosp_code->>"+_poDeskGenerateTransVO.getStrHospitalCode());
//			//System.out.println("po_type->>"+_poDeskGenerateTransVO.getStrPOTypeId());
//			//System.out.println("store_id->>"+_poDeskGenerateTransVO.getStrStoreId());
//			//System.out.println("item_cat->>"+_poDeskGenerateTransVO.getStrItemCat());
//			//System.out.println("grant_type->>"+_poDeskGenerateTransVO.getStrPOGrantType());
			
			
			
			/*dao.setProcOutValue(nProcIndex, "err", 1,8);
			dao.setProcOutValue(nProcIndex, "resultset", 2,9);*/
			String var ;
			if(_poDeskGenerateTransVO.getStrPOTypeId().replace("^","#").split("#")[0].equals("87"))
				var="86"; //Indent for Buy and Supply patient i.e. local purchase without RC
			else if(_poDeskGenerateTransVO.getStrPOTypeId().replace("^","#").split("#")[0].equals("21"))
				var = "90"; // Indent for purchase  for dept with RC
			else
				var="11";//Indent for Buy and Supply dept i.e. local purchase without RC
			dao.setProcInValue(nProcIndex, "modval", "1",1);
			
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "store_id", _poDeskGenerateTransVO.getStrStoreId(),3);
			dao.setProcInValue(nProcIndex, "item_cat", _poDeskGenerateTransVO.getStrItemCat(),4);
			dao.setProcInValue(nProcIndex,"req_type",var,5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				_poDeskGenerateTransVO.setWbRequestDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getRequestDetails() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void getComponentDetail(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strproc_name = "{call PKG_MMS_VIEW.PROC_HSTT_POTYPE_COMPONENT_MST(?,?,?, ?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getComponentDetail()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code","100",2);// _poDeskGenerateTransVO.getStrHospitalCode(),2); all 3 lines commented bcz of global master
			dao.setProcInValue(nProcIndex, "po_type","0",3);// _poDeskGenerateTransVO.getStrPOTypeId().substring(0,2),3);
			dao.setProcInValue(nProcIndex, "item_cat", "0",4);//_poDeskGenerateTransVO.getStrItemCat(),4);
			
			//dao.setProcInValue(nProcIndex, "compTypeId", ""); //default

			
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";
			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			String[] strComponentName = new String[wsResult.size()];
			String[] strComponentID = new String[wsResult.size()];
			String[] strComponentValue = new String[wsResult.size()];

			if (strErr.equals("")) {
				for (int nTmpI = 0; wsResult.next(); nTmpI++) {
					strComponentID[nTmpI] = wsResult.getString(1);
					strComponentName[nTmpI] = wsResult.getString(2);
					strComponentValue[nTmpI]=(wsResult.getString(3).equals(".")?"":wsResult.getString(3))+" "+(wsResult.getString(4).equals(".")?"":wsResult.getString(4));
				}

			} else
				throw new Exception(strErr);
			_poDeskGenerateTransVO.setStrComponentID(strComponentID);
			_poDeskGenerateTransVO.setStrComponentName(strComponentName);
			_poDeskGenerateTransVO.setStrComponentValue(strComponentValue);
			
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getComponentDetail() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void getRequestItemDetails(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_po_item_dtl(?,?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
			System.out.println("----------- PODeskGenerateTransDAO . getRequestItemDetails -----------");
			
			System.out.println("----------- pkg_mms_view.proc_po_item_dtl -[ Mode - 2 ]----------");
			
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getRequestItemDetails()");
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "req_no", _poDeskGenerateTransVO.getStrRequestId(),3);
			dao.setProcInValue(nProcIndex, "item_cat", _poDeskGenerateTransVO.getStrItemCat(),6);
			dao.setProcInValue(nProcIndex, "supplier_id",_poDeskGenerateTransVO.getStrSupplierId(),4);
			dao.setProcInValue(nProcIndex, "contract_type",_poDeskGenerateTransVO.getStrContractType(),7);
			dao.setProcInValue(nProcIndex, "po_type", _poDeskGenerateTransVO.getStrPOTypeId().substring(0,2),8);
			dao.setProcInValue(nProcIndex, "store_id", _poDeskGenerateTransVO.getStrStoreId(),5);
			dao.setProcOutValue(nProcIndex, "err", 1,9);
			dao.setProcOutValue(nProcIndex, "resultset", 2,10);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			if (strErr == null || strErr.equals("")) {
				_poDeskGenerateTransVO.setWbRequestItemDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getRequestItemDetails() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	public static void getRequestModifyItemDetails(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_po_item_dtl(?,?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getRequestItemDetails()");
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "3",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "req_no", _poDeskGenerateTransVO.getStrRequestId(),3);
			dao.setProcInValue(nProcIndex, "item_cat", _poDeskGenerateTransVO.getStrItemCat(),6);
			dao.setProcInValue(nProcIndex, "supplier_id",_poDeskGenerateTransVO.getStrPoNo(),4); // Passing PONO 
			dao.setProcInValue(nProcIndex, "contract_type",_poDeskGenerateTransVO.getStrContractType(),7);
			dao.setProcInValue(nProcIndex, "po_type", _poDeskGenerateTransVO.getStrPOTypeId().substring(0,2),8);
			dao.setProcInValue(nProcIndex, "store_id", _poDeskGenerateTransVO.getStrStoreId(),5);
			dao.setProcOutValue(nProcIndex, "err", 1,9);
			dao.setProcOutValue(nProcIndex, "resultset", 2,10);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			if (strErr == null || strErr.equals("")) {
				_poDeskGenerateTransVO.setWbRequestItemDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getRequestItemDetails() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	
	
	public static void finalizePO(PODeskGenerateTransVO _poDeskGenerateTransVO) 
	{
		String strproc_name = "{call pkg_mms_view.proc_draft_po(?,?,?,?,? ,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
			System.out.println("------------- PODeskGenerateTransHLP.finalizePO ----pkg_mms_view.proc_draft_po-[ Mode - 1]------------");
			
			dao = new HisDAO("MMS","transactions.PODeskGenerateTransDAO.finalizePO()");
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modval", 		"1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", 	_poDeskGenerateTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "pono", 			_poDeskGenerateTransVO.getStrPoNo(),3);
			dao.setProcInValue(nProcIndex, "storeid", 		_poDeskGenerateTransVO.getStrStoreId(),4);
			dao.setProcOutValue(nProcIndex, "err", 			1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 	2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			if (strErr == null || strErr.equals("")) {
				_poDeskGenerateTransVO.setWbRequestItemDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getRequestItemDetails() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	public static void getPOItemDetails(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_po_item_dtl(?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getRequestItemDetails()");
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "6",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "pono", _poDeskGenerateTransVO.getStrPONo(),4);
			dao.setProcInValue(nProcIndex, "storeid", _poDeskGenerateTransVO.getStrStoreId(),3);
			dao.setProcInValue(nProcIndex, "item_id","0",5);
			dao.setProcInValue(nProcIndex, "item_brand_id", "0",6);
			dao.setProcInValue(nProcIndex, "schedule_no", "0",7);
			dao.setProcOutValue(nProcIndex, "err", 1,8);
			dao.setProcOutValue(nProcIndex, "resultset", 2,9);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			if (strErr == null || strErr.equals("")) {
				_poDeskGenerateTransVO.setWbRequestItemDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getRequestItemDetails() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	
	public static void getCRWiseItemDetails(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_CR_WISE_item_dtl(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getRequestItemDetails()");
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "mode", "1",1);
			dao.setProcInValue(nProcIndex, "gnum_hospital_code", _poDeskGenerateTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "itemid", _poDeskGenerateTransVO.getStrItemId(),3);
			dao.setProcInValue(nProcIndex, "brandid", _poDeskGenerateTransVO.getStrItemBrandIds(),4);
			dao.setProcInValue(nProcIndex, "reqid",_poDeskGenerateTransVO.getStrRequestId(),5);
			dao.setProcInValue(nProcIndex, "storeid",_poDeskGenerateTransVO.getStrStoreId(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			if (strErr == null || strErr.equals("")) {
				_poDeskGenerateTransVO.setWbItemDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getRequestItemDetails() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	
	
	
	public static void getDeptItemDetails(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_CR_WISE_item_dtl(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getRequestItemDetails()");
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "mode", "2",1);
			dao.setProcInValue(nProcIndex, "gnum_hospital_code", _poDeskGenerateTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "itemid", _poDeskGenerateTransVO.getStrItemId(),3);
			dao.setProcInValue(nProcIndex, "brandid", _poDeskGenerateTransVO.getStrItemBrandIds(),4);
			dao.setProcInValue(nProcIndex, "reqid",_poDeskGenerateTransVO.getStrRequestId(),5);
			dao.setProcInValue(nProcIndex, "storeid",_poDeskGenerateTransVO.getStrStoreId(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			if (strErr == null || strErr.equals("")) {
				_poDeskGenerateTransVO.setWbItemDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getRequestItemDetails() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void setUnitValues(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
	String strproc_name = "{call pkg_mms_view.proc_gblt_unit_mst(?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransDAO.setUnitValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setUnitValues()");
			////System.out.println("_poDeskGenerateTransVO.getStrRateUnitId().substring(0,4)"+_poDeskGenerateTransVO.getStrRateUnitId().substring(0,4));
			////System.out.println("_poDeskGenerateTransVO.getStrInventoryUnitId()"+_poDeskGenerateTransVO.getStrInventoryUnitId());
			nProcIndex = dao.setProcedure(strproc_name);
			if(_poDeskGenerateTransVO.getStrInventoryUnitId().length() == 4)
				dao.setProcInValue(nProcIndex, "modeval", "5",4);
			else
				dao.setProcInValue(nProcIndex, "modeval", "1",4);
			//dao.setProcInValue(nProcIndex, "modeval", "5",4);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode(),1);
			dao.setProcInValue(nProcIndex, "unit_id", (_poDeskGenerateTransVO.getStrInventoryUnitId()==null || _poDeskGenerateTransVO.getStrInventoryUnitId().equals(""))?_poDeskGenerateTransVO.getStrRateUnitId().substring(0,4):_poDeskGenerateTransVO.getStrInventoryUnitId() ,2);//changed by shalini 
			dao.setProcInValue(nProcIndex, "module_id", "",3); //default value.
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			if (strErr == null || strErr.equals(""))
				_poDeskGenerateTransVO.setStrRateUnitValues(util.getOptionValue(wsResult,"","", false,false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.setUnitValues() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void setManufacturerValues(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_supplier_list(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransDAO.setManufacturerValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setManufacturerValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO
					.getStrHospitalCode(),5);
			dao.setProcInValue(nProcIndex, "catCode", _poDeskGenerateTransVO
					.getStrItemCat(),2);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "branditem_id", "0",3);
			dao.setProcInValue(nProcIndex, "contractType", "0",4);
			/* Setting Default Value End */
			
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_poDeskGenerateTransVO.setStrManufacturerValues(util
						.getOptionValue(wsResult, "", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.setManufacturerValues() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void getIndentPopupDetails(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Indent_Item_Dtls(?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getIndentPopupDetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "indentno", _poDeskGenerateTransVO
					.getStrIndentNo(),3);
			dao.setProcInValue(nProcIndex, "frmstoreid", _poDeskGenerateTransVO
					.getStrStoreId(),4);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				_poDeskGenerateTransVO.setWbRequestDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getIndentPopupDetails() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static String getPONo(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strProcName = "{? = call MMS_MST.generate_poNo(?,?,?,?)}";
		HisDAO dao = null;

		int funcIndex = 0;
		String strPONo = "";

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getPONo()");

			funcIndex = dao.setFunction(strProcName);

			dao.setFuncInValue(funcIndex, 2, _poDeskGenerateTransVO
					.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3, _poDeskGenerateTransVO
					.getStrStoreId());
			dao.setFuncInValue(funcIndex, 4, _poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			dao.setFuncInValue(funcIndex, 5, _poDeskGenerateTransVO
					.getStrItemCat());
			dao.setFuncOutValue(funcIndex, 1);

			dao.executeFunction(funcIndex);
			strPONo = dao.getFuncString(funcIndex);

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getPONo() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return strPONo;
	}

	public static void getItemPopupData(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strProcName = "{? = call MMS_MST.Get_item_property (?,?,?,?,?)}";
		HisDAO dao = null;

		int funcIndex = 0;
		String strItemPopupData = "";

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getItemPopupData()");

			funcIndex = dao.setFunction(strProcName);

			dao.setFuncInValue(funcIndex, 2, "5");
			dao.setFuncInValue(funcIndex, 3, _poDeskGenerateTransVO
					.getStrItemId());
			dao.setFuncInValue(funcIndex, 4, _poDeskGenerateTransVO
					.getStrHospitalCode());
			
			/* Setting Default Value Start*/
			dao.setFuncInValue(funcIndex, 5, "0");
			dao.setFuncInValue(funcIndex, 6, "0");
			/* Setting Default Value End */
			
			dao.setFuncOutValue(funcIndex, 1);

			dao.executeFunction(funcIndex);
			strItemPopupData = dao.getFuncString(funcIndex);

			_poDeskGenerateTransVO.setStrItemPopupData(strItemPopupData);

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getItemPopupData() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	/**
	 * This function is used to set details in approved By Combo. 
	 * @param _PODeskGenerateTransVO
	 */
	public static void getApprovedByCombo(PODeskGenerateTransVO _PODeskGenerateTransVO)
	{
		
		String strProcName = "{call PKG_MMS_VIEW.proc_consultant_name(?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj  = new HisDAO("MMSModule","PODeskGenerateTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransVO.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "seatId", _PODeskGenerateTransVO.getStrSeatId(),4);
			
			daoObj.setProcInValue(nProcIndex, "deptunitcode", "0",2);

			daoObj.setProcOutValue(nProcIndex, "err",1,5); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if(strErr.equals(""))
			{
				_PODeskGenerateTransVO.setWbApprovedBy(ws);
			}
		}
		catch(Exception _err)
		{
			_PODeskGenerateTransVO.setStrMsgString("PODeskGenerateTransDAO.getApprovedByCombo() --> "
					+ _err.getMessage());
			_PODeskGenerateTransVO.setStrMsgType("1");
		}
	}
	public static void insertDraft(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strProcName  = "{call PKG_MMS_DML.dml_hstt_po_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";	//26+ 2(Added by Adil for PO Prefix and PO Date)= 28 Variable
		String strProcName1 = "{call PKG_MMS_DML.Dml_hstt_po_req_Dtl(?,?,?,?,?,?,?,?,?,?,?,?)}";
		String strProcName2 = "{call PKG_MMS_DML.Dml_hstt_po_Item_Dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";	//35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		String strProcName3 = "{call PKG_MMS_DML.dml_hstt_potype_component_mst(?,?,?,?,?,?,?,?)}";
		String strProcName4 = "{call PKG_MMS_DML.dml_sstt_po_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //34+ 2+2(Added by Adil for PO Prefix and PO Date)=36 variable
		String strProcName5 = "{call PKG_MMS_DML.dml_hstt_foreignnpo_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";
		String strProcName6 = "{call PKG_MMS_DML.dml_hstt_po_schedule_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}";
		String strProcName7 = "{call PKG_MMS_DML.dml_hstt_po_req_item_dtl(?,?,?,?,?,?,?,?,?,?,?)}";
		String strProcName8 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		String strProcName9 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		//String strProcName10 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		//String strProcName11 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		String strProcName12 = "{call PKG_MMS_DML.dml_sstt_po_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //34+ 2(Added by Adil for PO Prefix and PO Date)=36 variable
		String strProcName13 = "{call PKG_MMS_DML.DML_FIN_CONCURRENCE_DTL(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;
		int nProc1Index = 0;
		int nProc2Index = 0;
		int nProc3Index = 0;
		int nProc4Index = 0;
		int nProc5Index = 0;
		int nProc6Index = 0;
		int nProc7Index = 0;
		int nProc8Index = 0;
		int nProc9Index = 0;
		//int nProc10Index = 0;
		//int nProc11Index = 0;
		int nProc12Index = 0,nProc13Index = 0;
		int funcIndex=0;
		String strErr = "";
		String strPONo = "";
		String combinedpono="";
		double[] tmpvalue= new double[_poDeskGenerateTransVO.getStrHiddenValue().length];
		String[] potmpno = new String[_poDeskGenerateTransVO.getStrDLstSupplierId().length];
		//double taxamt=0.0 ;
		//String[] tmpPONo=new String[_poDeskGenerateTransVO.getStrDLstSupplierId().length];
		MmsConfigUtil mmsConfigUtil = null;
		//boolean flag = false;
		try {
			mmsConfigUtil = new MmsConfigUtil(_poDeskGenerateTransVO.getStrHospitalCode());
			
			dao = new HisDAO("MMS","transactions.PODeskGenerateTransDAO.insert()");
			
			Map mp=new HashMap();

			for (int nTmpI = 0; nTmpI < _poDeskGenerateTransVO.getStrDLstSupplierId().length; nTmpI++) 
			{
			
				funcIndex = dao.setFunction("{? = call MMS_MST.generate_poNo(?,?,?,?)}");

				dao.setFuncInValue(funcIndex, 2, _poDeskGenerateTransVO
						.getStrHospitalCode());
				dao.setFuncInValue(funcIndex, 3, _poDeskGenerateTransVO
						.getStrStoreId());
				dao.setFuncInValue(funcIndex, 4, _poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
				dao.setFuncInValue(funcIndex, 5, _poDeskGenerateTransVO
						.getStrItemCat());
				dao.setFuncOutValue(funcIndex, 1);

				dao.executeFunction(funcIndex);
				
			//dao.f
			strPONo = dao.getFuncString(funcIndex);
			potmpno[nTmpI]=strPONo;
			if(nTmpI==0)
				combinedpono=strPONo;
			else
				combinedpono=combinedpono+","+strPONo;
			
			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval","1");
			dao.setProcInValue(nProcIndex, "pono",strPONo);
			dao.setProcInValue(nProcIndex, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "item_cat",_poDeskGenerateTransVO.getStrItemCat());
			dao.setProcInValue(nProcIndex, "po_type_id",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProcIndex, "currency_id",_poDeskGenerateTransVO.getStrDCurrencyName());
			else
				dao.setProcInValue(nProcIndex, "currency_id","100");
			
			dao.setProcInValue(nProcIndex, "pur_source",_poDeskGenerateTransVO.getStrDPurchaseSource());
			dao.setProcInValue(nProcIndex, "store_id",_poDeskGenerateTransVO.getStrStoreId());
			dao.setProcInValue(nProcIndex, "supplier",_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]);
			dao.setProcInValue(nProcIndex, "delevery_location",_poDeskGenerateTransVO.getStrDDeliveryLocation());
			dao.setProcInValue(nProcIndex, "tender_no",_poDeskGenerateTransVO.getStrDLstSupplierInterface()[nTmpI]);
			dao.setProcInValue(nProcIndex, "tender_date","0");
			dao.setProcInValue(nProcIndex, "quotation_no","0");
			dao.setProcInValue(nProcIndex, "quotation_date","0");
			dao.setProcInValue(nProcIndex, "fin_start_date",mmsConfigUtil.getStrFinancialStartDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProcIndex, "fin_end_date",mmsConfigUtil.getStrFinancialEndDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProcIndex, "po_remarks",_poDeskGenerateTransVO.getStrDRemarks());
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProcIndex, "currency_value",_poDeskGenerateTransVO.getStrDCurrencyValue());
			else
				dao.setProcInValue(nProcIndex, "currency_value","1");
			
			dao.setProcInValue(nProcIndex, "seat_id",_poDeskGenerateTransVO.getStrSeatId());
			dao.setProcInValue(nProcIndex, "tax","0");//_poDeskGenerateTransVO.getStrDOverAllTax());//0
			dao.setProcInValue(nProcIndex, "net_amount",_poDeskGenerateTransVO.getSupptotamt()[nTmpI]);//_poDeskGenerateTransVO.getStrDNetAmount());//0
			dao.setProcInValue(nProcIndex, "schedule_no","0");
			dao.setProcInValue(nProcIndex, "verified_by",_poDeskGenerateTransVO.getStrVerifiedBy());
			dao.setProcInValue(nProcIndex, "verified_date",_poDeskGenerateTransVO.getStrVerifiedDate());
			
			/* Setting Default Value Start*/
			
			dao.setProcInValue(nProcIndex, "ipAddr","0");
			
			dao.setProcInValue(nProcIndex, "po_prefix",_poDeskGenerateTransVO.getStrDPORefNo());
			dao.setProcInValue(nProcIndex, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
			/* Setting Default Value End */
			
			dao.setProcOutValue_new(nProcIndex, "err",1);        
			
			dao.execute(nProcIndex,1);
			
			
			for(int x = 0 ; x<_poDeskGenerateTransVO.getStrDRequestNo().length;x++)
			{
					nProc1Index = dao.setProcedure(strProcName1);
					
					dao.setProcInValue(nProc1Index, "modeval", "1");
					dao.setProcInValue(nProc1Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc1Index, "pono",strPONo);
					dao.setProcInValue(nProc1Index, "req_no",_poDeskGenerateTransVO.getStrDRequestNo()[x]);
					dao.setProcInValue(nProc1Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc1Index, "req_date","0");
					dao.setProcInValue(nProc1Index, "req_period","0");
					dao.setProcInValue(nProc1Index, "req_type_id",_poDeskGenerateTransVO.getStrDRequestNo()[x].substring(2,4));
					dao.setProcInValue(nProc1Index, "raising_store",_poDeskGenerateTransVO.getStrDRaisingStore()[x]);
					dao.setProcInValue(nProc1Index, "puk","0");
					dao.setProcInValue(nProc1Index, "emp_id","0");
					dao.setProcOutValue_new(nProc1Index, "err", 1);
	
					dao.execute(nProc1Index,1);
				}
			
			for (int i = 0; i < _poDeskGenerateTransVO.getStrHiddenValue().length; i++) {
				if(_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[0].equals(_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]))
				{
					nProc2Index = dao.setProcedure(strProcName2);
					dao.setProcInValue(nProc2Index, "modeval", "1");
					dao.setProcInValue(nProc2Index, "pono",strPONo);
					
					dao.setProcInValue(nProc2Index, "store_id", _poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc2Index, "item_id",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[6]);
					dao.setProcInValue(nProc2Index, "item_brand_id",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[7]);
					dao.setProcInValue(nProc2Index, "schedule_no", "1");
					dao.setProcInValue(nProc2Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc2Index, "supplier",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[0]);
					dao.setProcInValue(nProc2Index, "groupid",_poDeskGenerateTransVO.getStrGroupId().replace("[","").replace("]", "").replace('"', ' ').split(",")[i].trim());
					dao.setProcInValue(nProc2Index, "subgroup_id","0");
					dao.setProcInValue(nProc2Index, "manuf_id","0");
					dao.setProcInValue(nProc2Index, "rate",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[3]);
					dao.setProcInValue(nProc2Index, "rate_unit",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[8]);
					dao.setProcInValue(nProc2Index, "order_qty",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[2]);
					dao.setProcInValue(nProc2Index, "order_qty_unit",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[8]);
					dao.setProcInValue(nProc2Index, "accepted_qty", "0");
					dao.setProcInValue(nProc2Index, "accepted_qty_unit", "0");
					dao.setProcInValue(nProc2Index, "rejected_qty", "0");
					dao.setProcInValue(nProc2Index, "rejected_qty_unit", "0");
					dao.setProcInValue(nProc2Index, "breakage_qty", "0");
					dao.setProcInValue(nProc2Index, "breakage_qty_unit", "0");
					dao.setProcInValue(nProc2Index, "warrenty_req","0");
					dao.setProcInValue(nProc2Index, "installation_req","0");
					dao.setProcInValue(nProc2Index, "remarks",_poDeskGenerateTransVO.getStrDRemarks());
					dao.setProcInValue(nProc2Index, "item_tax",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[9]);
					
					
					/* Setting Default Value Start*/
					
					dao.setProcInValue(nProc2Index, "return_qty", "0");
					dao.setProcInValue(nProc2Index, "return_qty_unit", "0");
					dao.setProcInValue(nProc2Index, "recieved_qty", "0");
					dao.setProcInValue(nProc2Index, "recieved_qty_unit", "0");
					dao.setProcInValue(nProc2Index, "req_no", "0");
					dao.setProcInValue(nProc2Index, "challanNo", "0");
					dao.setProcInValue(nProc2Index, "raising_store", _poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[15]); //used as pack size);
					dao.setProcInValue(nProc2Index, "po_type", _poDeskGenerateTransVO.getStrPOTypeId());
					//dao.setProcInValue(nProc2Index, "delivery_loc", "-",33);
					dao.setProcInValue(nProc2Index, "item_make","0");
					dao.setProcInValue(nProc2Index, "itemName", "");
					
					dao.setProcInValue(nProc2Index, "po_date",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[1]);
					/* Setting Default Value End */
					dao.setProcInValue(nProc2Index, "delivery_loc",_poDeskGenerateTransVO.getStrDDeliveryLocation());
					dao.setProcOutValue_new(nProc2Index, "err", 1);
	
					dao.execute(nProc2Index,1);
					
					tmpvalue[i]=Double.parseDouble(_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[2])*Double.parseDouble(_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[3]);
				}
			}
			
			if(_poDeskGenerateTransVO.getStrDComponentId()!=null){
				for(int i=(nTmpI)*((_poDeskGenerateTransVO.getStrDComponentId().length)/(_poDeskGenerateTransVO.getStrDLstSupplierId().length)) , stopNTmp =( (_poDeskGenerateTransVO.getStrDComponentId().length)/(_poDeskGenerateTransVO.getStrDLstSupplierId().length))*(nTmpI+1); i<stopNTmp; i++){
					nProc3Index = dao.setProcedure(strProcName3);
					
					dao.setProcInValue(nProc3Index, "modeval", "1");
					dao.setProcInValue(nProc3Index, "pono", strPONo);
					dao.setProcInValue(nProc3Index, "store_id", _poDeskGenerateTransVO.getStrStoreId());
					if(_poDeskGenerateTransVO.getStrDComponentValue()[i].length() >3999){
						dao.setProcInValue(nProc3Index, "comp_value1", _poDeskGenerateTransVO.getStrDComponentValue()[i].substring(0,3999));
						dao.setProcInValue(nProc3Index, "comp_value2", _poDeskGenerateTransVO.getStrDComponentValue()[i].substring(4000));
					}else{
						dao.setProcInValue(nProc3Index, "comp_value1", _poDeskGenerateTransVO.getStrDComponentValue()[i]);
						dao.setProcInValue(nProc3Index, "comp_value2", " ");
					}
					dao.setProcInValue(nProc3Index, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc3Index, "comp_id",_poDeskGenerateTransVO.getStrDComponentId()[i]);
					/*for(int i = 0 ; i< tmpPONo.length;i++)
					{
						if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0] == tmpPONo[i].replace("^","#").split("#")[1])
							dao.setProcInValue(nProc3Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],2);
					}*/
					
					//dao.setProcInValue(nProc3Index, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
					dao.setProcOutValue_new(nProc3Index, "err", 1);
		
					dao.execute(nProc3Index,1);
				}
			}
			
			//for (int i = 0; nTmpI < _poDeskGenerateTransVO.getStrDLstSupplierId().length; nTmpI++) {
			nProc4Index = dao.setProcedure(strProcName4);
			dao.setProcInValue(nProc4Index, "modeval","1");
			/*for(int i = 0 ; i< tmpPONo.length;i++)
			{
				if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0].equals(tmpPONo[i].replace("^","#").split("#")[1]))
					dao.setProcInValue(nProc4Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],2);
			}*/
			dao.setProcInValue(nProc4Index, "pono",strPONo);
			dao.setProcInValue(nProc4Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
			dao.setProcInValue(nProc4Index, "item_cat",_poDeskGenerateTransVO.getStrItemCat());
			dao.setProcInValue(nProc4Index, "po_type_id",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProc4Index, "currency_id",_poDeskGenerateTransVO.getStrDCurrencyName());
			else
				dao.setProcInValue(nProc4Index, "currency_id","100",6);
			
			dao.setProcInValue(nProc4Index, "pur_source",_poDeskGenerateTransVO.getStrDPurchaseSource());
			dao.setProcInValue(nProc4Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());
			dao.setProcInValue(nProc4Index, "supplier",_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]);
			dao.setProcInValue(nProc4Index, "delevery_location",_poDeskGenerateTransVO.getStrDDeliveryLocation());
			dao.setProcInValue(nProc4Index, "tender_no",_poDeskGenerateTransVO.getStrDTenderNo());
			dao.setProcInValue(nProc4Index, "tender_date",_poDeskGenerateTransVO.getStrDTenderDate());
			dao.setProcInValue(nProc4Index, "quotation_no",_poDeskGenerateTransVO.getStrDQuotationNo());
			dao.setProcInValue(nProc4Index, "quotation_date",_poDeskGenerateTransVO.getStrDQuotationDate());
			dao.setProcInValue(nProc4Index, "net_advance",_poDeskGenerateTransVO.getStrDLstSupplierInterface()[nTmpI]);
			dao.setProcInValue(nProc4Index, "po_status","0");
			dao.setProcInValue(nProc4Index, "fin_start_date",mmsConfigUtil.getStrFinancialStartDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProc4Index, "fin_end_date",mmsConfigUtil.getStrFinancialEndDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProc4Index, "net_penelty","0");
			dao.setProcInValue(nProc4Index, "po_remarks",_poDeskGenerateTransVO.getStrDRemarks());
			dao.setProcInValue(nProc4Index, "cancel_flag","0");
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProc4Index, "currency_value",_poDeskGenerateTransVO.getStrDCurrencyValue());
			else
				dao.setProcInValue(nProc4Index, "currency_value","1");
			dao.setProcInValue(nProc4Index, "waivoff","0");
			dao.setProcInValue(nProc4Index, "advance_adjusted","0");
			dao.setProcInValue(nProc4Index, "po_prefix","0");
			dao.setProcInValue(nProc4Index, "seat_id",_poDeskGenerateTransVO.getStrSeatId());
			dao.setProcInValue(nProc4Index, "paid_bill_amt","0");
			dao.setProcInValue(nProc4Index, "tax",_poDeskGenerateTransVO.getStrDOverAllTax());
			dao.setProcInValue(nProc4Index, "net_amount",_poDeskGenerateTransVO.getSupptotamt()[nTmpI]);
			dao.setProcInValue(nProc4Index, "issueNo","0");
			dao.setProcInValue(nProc4Index, "reqTypeId",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			dao.setProcInValue(nProc4Index, "verified_by",_poDeskGenerateTransVO.getStrVerifiedBy());
			dao.setProcInValue(nProc4Index, "verified_date",_poDeskGenerateTransVO.getStrVerifiedDate());
			dao.setProcInValue(nProc4Index, "po_ref_no",_poDeskGenerateTransVO.getStrDPORefNo());
			dao.setProcInValue(nProc4Index, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
			dao.setProcInValue(nProc4Index, "dcomments",_poDeskGenerateTransVO.getStrDComments());
			dao.setProcInValue(nProc4Index, "dnotes",_poDeskGenerateTransVO.getStrDNotes());
			dao.setProcOutValue_new(nProc4Index, "err",1);        
			dao.execute(nProc4Index,1);
			
			
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24")){
				//for (int nTmpI = 0; nTmpI < _poDeskGenerateTransVO.getStrDLstSupplierId().length; nTmpI++) {
				nProc5Index = dao.setProcedure(strProcName5);
				dao.setProcInValue(nProc5Index, "modeval","1");
				/*for(int i = 0 ; i< tmpPONo.length;i++)
				{
					if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0].equals(tmpPONo[i].replace("^","#").split("#")[1]))
						dao.setProcInValue(nProc5Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],2);
				}*/
				dao.setProcInValue(nProc5Index, "pono",strPONo);
				dao.setProcInValue(nProc5Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());
				dao.setProcInValue(nProc5Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
				dao.setProcInValue(nProc5Index, "supplier",_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]);
				dao.setProcInValue(nProc5Index, "agent_id",_poDeskGenerateTransVO.getStrDAgentName());
				dao.setProcInValue(nProc5Index, "ca_id",_poDeskGenerateTransVO.getStrDCAName());
				dao.setProcInValue(nProc5Index, "currency",_poDeskGenerateTransVO.getStrDCurrencyName());
				dao.setProcInValue(nProc5Index, "iac_charge",_poDeskGenerateTransVO.getStrDIACCharge());
				dao.setProcInValue(nProc5Index, "insurance_charge",_poDeskGenerateTransVO.getStrDInsuranceCharge());
				dao.setProcInValue(nProc5Index, "dumurrages_by",_poDeskGenerateTransVO.getStrDDemurrageBy());
				dao.setProcInValue(nProc5Index, "remarks",_poDeskGenerateTransVO.getStrDRemarks());
				dao.setProcInValue(nProc5Index, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
				dao.setProcOutValue_new(nProc5Index, "err",1);
				
				dao.execute(nProc5Index,1);
				}
			
			//for (int nTmpI = 0; nTmpI < _poDeskGenerateTransVO.getStrDLstSupplierId().length; nTmpI++) {
			nProc6Index = dao.setProcedure(strProcName6);
			dao.setProcInValue(nProc6Index, "modeval","1");
			dao.setProcInValue(nProc6Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());			
			/*for(int i = 0 ; i< tmpPONo.length;i++)
			{
				if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0].equals(tmpPONo[i].replace("^","#").split("#")[1]))
					dao.setProcInValue(nProc6Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],3);
			}*/
			
			
			dao.setProcInValue(nProc6Index, "pono",strPONo);
			dao.setProcInValue(nProc6Index, "schedule_no","1");
			dao.setProcInValue(nProc6Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
			dao.setProcInValue(nProc6Index, "schedule_date","");
			dao.setProcInValue(nProc6Index, "delivery_date",_poDeskGenerateTransVO.getStrDExpectedDeliveryDate()[nTmpI]);
			dao.setProcInValue(nProc6Index, "schedule_status","");
			dao.setProcInValue(nProc6Index, "penelty","");
			dao.setProcInValue(nProc6Index, "cancel_date","");
			dao.setProcInValue(nProc6Index, "cancel_by","");
			dao.setProcInValue(nProc6Index, "cancel_remarks","");
			dao.setProcInValue(nProc6Index, "delivery_loc", _poDeskGenerateTransVO.getStrDDeliveryLocation());
			dao.setProcOutValue_new(nProc6Index, "err",1);
			
			dao.execute(nProc6Index,1);
			
			for (int i = 0; i < _poDeskGenerateTransVO.getStrHiddenValue().length; i++) {
				if(_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[0].equals(_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]))
				{
					nProc7Index = dao.setProcedure(strProcName7);
					dao.setProcInValue(nProc7Index, "modeval", "1");
					/*for(int i = 0 ; i< tmpPONo.length;i++)
					{
						if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0].equals(tmpPONo[i].replace("^","#").split("#")[1]))
							dao.setProcInValue(nProc7Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],2);
					}*/
					dao.setProcInValue(nProc7Index, "pono", strPONo);
					dao.setProcInValue(nProc7Index, "store_id", _poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc7Index, "req_no","0");
					dao.setProcInValue(nProc7Index, "raising_store_id",_poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc7Index, "item_id", _poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[6]);
					dao.setProcInValue(nProc7Index, "itembrand_id",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[7]);
					dao.setProcInValue(nProc7Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc7Index, "order_qty",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[2]);
					dao.setProcInValue(nProc7Index, "orderqty_unitid",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[8]);
					dao.setProcOutValue_new(nProc7Index, "err", 1);
	
					dao.execute(nProc7Index,1);
				}
			}
			
			if( mmsConfigUtil.getStrFMSIntegration() != null && mmsConfigUtil.getStrFMSIntegration().equals("1"))
			{
				for (int i = 0; i < _poDeskGenerateTransVO.getStrHiddenValue().length; i++) {
					
					if(_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[0].equals(_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]))
					{ 
					//tmpvalue=Double.parseDouble(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[4].split("\\(")[0])*Double.parseDouble(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[4].split("\\(")[2])*(Double.parseDouble(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[9])/100);
					nProc13Index = dao.setProcedure(strProcName13);
					dao.setProcInValue(nProc13Index, "modeval","1");
					dao.setProcInValue(nProc13Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc13Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc13Index, "store",_poDeskGenerateTransVO.getStrStoreName());
					dao.setProcInValue(nProc13Index, "pono",potmpno[nTmpI]);
					dao.setProcInValue(nProc13Index, "podate",_poDeskGenerateTransVO.getStrPODate());
					dao.setProcInValue(nProc13Index, "suppid",_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]);
					dao.setProcInValue(nProc13Index, "supp","");
					dao.setProcInValue(nProc13Index, "amt",Double.toString(tmpvalue[i]));
					dao.setProcInValue(nProc13Index, "seatid",_poDeskGenerateTransVO.getStrSeatId());	
					dao.setProcInValue(nProc13Index, "itembrandid",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[7]);
					dao.setProcInValue(nProc13Index, "itemname","");
					dao.setProcInValue(nProc13Index, "rate",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[3]);
					dao.setProcInValue(nProc13Index, "itemqty",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[2]);
					dao.setProcInValue(nProc13Index, "strrequestpono",potmpno[nTmpI]);
					dao.setProcInValue(nProc13Index, "sectionid","12");
					dao.setProcInValue(nProc13Index, "tax",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[9]);
					dao.setProcOutValue_new(nProc13Index, "err",1);        
					dao.execute(nProc13Index,1);
					}	
				}
			}
			
			synchronized (dao) 
			{
				//if(nTmpI == (_poDeskGenerateTransVO.getStrDLstSupplierId().length-1) )
				//	dao.fire_without_commit(0, 1);
				//else
					dao.fire_without_commit(1, 0);
				//flag = true;
			}
//			if(flag)
//			{
//				//PODeskGenerateTransDAO.updateCurrStock(_poDeskGenerateTransVO,strPONo);
//			}
			}
			
			for (int x = 0; x < _poDeskGenerateTransVO.getStrDRequestNo().length; x++)//Agenda No Loop To Update Process Qty
			{			
				for (int i = 0; i < _poDeskGenerateTransVO.getStrHiddenValue().length; i++) //Item Id Loop
				{
						nProc8Index = dao.setProcedure(strProcName8);
						dao.setProcInValue(nProc8Index, "modeval", "5");
						dao.setProcInValue(nProc8Index, "pono", strPONo);
						dao.setProcInValue(nProc8Index, "store_id", "0");
						dao.setProcInValue(nProc8Index, "item_id", _poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[6]);
						dao.setProcInValue(nProc8Index, "item_brand_id",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[7]);
						dao.setProcInValue(nProc8Index, "schedule_no", "0");
						dao.setProcInValue(nProc8Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
						dao.setProcInValue(nProc8Index, "supplier", "0");
						dao.setProcInValue(nProc8Index, "groupid", "0");
						dao.setProcInValue(nProc8Index, "subgroup_id", "0");
						dao.setProcInValue(nProc8Index, "manuf_id", "0");
						dao.setProcInValue(nProc8Index, "rate", "0");
						dao.setProcInValue(nProc8Index, "rate_unit", "0");
						dao.setProcInValue(nProc8Index, "order_qty",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[2]);
						dao.setProcInValue(nProc8Index, "order_qty_unit", _poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[8]);
						dao.setProcInValue(nProc8Index, "accepted_qty", "0");
						dao.setProcInValue(nProc8Index, "accepted_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "rejected_qty", "0");
						dao.setProcInValue(nProc8Index, "rejected_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "breakage_qty", "0");
						dao.setProcInValue(nProc8Index, "breakage_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "warrenty_req", "0");
						dao.setProcInValue(nProc8Index, "installation_req", "0");
						dao.setProcInValue(nProc8Index, "remarks", "");
						dao.setProcInValue(nProc8Index, "item_tax", "0");
						dao.setProcInValue(nProc8Index, "return_qty", "0");
						dao.setProcInValue(nProc8Index, "return_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "recieved_qty", "0");
						dao.setProcInValue(nProc8Index, "recieved_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "req_no",_poDeskGenerateTransVO.getStrDRequestNo()[x]);
						dao.setProcInValue(nProc8Index, "challanNo", "0");
						dao.setProcInValue(nProc8Index, "raising_store",_poDeskGenerateTransVO.getStrDRaisingStore()[x]);
						dao.setProcInValue(nProc8Index, "po_type",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
						dao.setProcInValue(nProc8Index, "item_make", "1");
						dao.setProcInValue(nProc8Index, "itemName", "");
						dao.setProcInValue(nProc8Index, "po_date",_poDeskGenerateTransVO.getStrPODate());
						dao.setProcInValue(nProc8Index, "delivery_loc",_poDeskGenerateTransVO.getStrDDeliveryLocation());
						dao.setProcOutValue_new(nProc8Index, "err", 1);
						dao.execute(nProc8Index,1);
					}
				}
					
			
			for (int x = 0; x < _poDeskGenerateTransVO.getStrDRequestNo().length; x++)//Agenda No Loop To Update Agenda Status
			{	
				nProc9Index = dao.setProcedure(strProcName9);
				dao.setProcInValue(nProc9Index, "modeval", "6");
				dao.setProcInValue(nProc9Index, "pono", "0");
				dao.setProcInValue(nProc9Index, "store_id", "0");
				dao.setProcInValue(nProc9Index, "item_id", "0");
				dao.setProcInValue(nProc9Index, "item_brand_id", "0");
				dao.setProcInValue(nProc9Index, "schedule_no", "0");
				dao.setProcInValue(nProc9Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
				dao.setProcInValue(nProc9Index, "supplier", "0");
				dao.setProcInValue(nProc9Index, "groupid", "0");
				dao.setProcInValue(nProc9Index, "subgroup_id", "0");
				dao.setProcInValue(nProc9Index, "manuf_id", "0");
				dao.setProcInValue(nProc9Index, "rate", "0");
				dao.setProcInValue(nProc9Index, "rate_unit", "0");
				dao.setProcInValue(nProc9Index, "order_qty", "0");
				dao.setProcInValue(nProc9Index, "order_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "accepted_qty", "0");
				dao.setProcInValue(nProc9Index, "accepted_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "rejected_qty", "0");
				dao.setProcInValue(nProc9Index, "rejected_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "breakage_qty", "0");
				dao.setProcInValue(nProc9Index, "breakage_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "warrenty_req", "0");
				dao.setProcInValue(nProc9Index, "installation_req", "0");
				dao.setProcInValue(nProc9Index, "remarks", "");
				dao.setProcInValue(nProc9Index, "item_tax", "0");
				dao.setProcInValue(nProc9Index, "return_qty", "0");
				dao.setProcInValue(nProc9Index, "return_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "recieved_qty", "0");
				dao.setProcInValue(nProc9Index, "recieved_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "req_no",_poDeskGenerateTransVO.getStrDRequestNo()[x]);
				dao.setProcInValue(nProc9Index, "challanNo", "0");
				dao.setProcInValue(nProc9Index, "raising_store",_poDeskGenerateTransVO.getStrDRaisingStore()[x]);
				dao.setProcInValue(nProc9Index, "po_type",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
				dao.setProcInValue(nProc9Index, "item_make", "1");
				dao.setProcInValue(nProc9Index, "itemName", "");
				dao.setProcInValue(nProc9Index, "po_date",_poDeskGenerateTransVO.getStrPODate());
				dao.setProcInValue(nProc9Index, "delivery_loc",_poDeskGenerateTransVO.getStrDDeliveryLocation());
				dao.setProcOutValue_new(nProc9Index, "err", 1);
				dao.execute(nProc9Index,1);
			}
			
			
					
			nProc12Index = dao.setProcedure(strProcName12);
			dao.setProcInValue(nProc12Index, "modeval","4");
			/*for(int i = 0 ; i< tmpPONo.length;i++)
			{
				if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0].equals(tmpPONo[i].replace("^","#").split("#")[1]))
					dao.setProcInValue(nProc4Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],2);
			}*/
			dao.setProcInValue(nProc12Index, "pono",combinedpono);
			dao.setProcInValue(nProc12Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
			dao.setProcInValue(nProc12Index, "item_cat",_poDeskGenerateTransVO.getStrItemCat());
			dao.setProcInValue(nProc12Index, "po_type_id",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProc12Index, "currency_id",_poDeskGenerateTransVO.getStrDCurrencyName());
			else
				dao.setProcInValue(nProc12Index, "currency_id","100",6);
			
			dao.setProcInValue(nProc12Index, "pur_source",_poDeskGenerateTransVO.getStrDPurchaseSource());
			dao.setProcInValue(nProc12Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());
			dao.setProcInValue(nProc12Index, "supplier","");
			dao.setProcInValue(nProc12Index, "delevery_location",_poDeskGenerateTransVO.getStrDDeliveryLocation());
			dao.setProcInValue(nProc12Index, "tender_no",_poDeskGenerateTransVO.getStrDTenderNo());
			dao.setProcInValue(nProc12Index, "tender_date",_poDeskGenerateTransVO.getStrDTenderDate());
			dao.setProcInValue(nProc12Index, "quotation_no",_poDeskGenerateTransVO.getStrDQuotationNo());
			dao.setProcInValue(nProc12Index, "quotation_date",_poDeskGenerateTransVO.getStrDQuotationDate());
			dao.setProcInValue(nProc12Index, "net_advance","0");
			dao.setProcInValue(nProc12Index, "po_status","0");
			dao.setProcInValue(nProc12Index, "fin_start_date",mmsConfigUtil.getStrFinancialStartDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProc12Index, "fin_end_date",mmsConfigUtil.getStrFinancialEndDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProc12Index, "net_penelty","0");
			dao.setProcInValue(nProc12Index, "po_remarks",_poDeskGenerateTransVO.getStrDRemarks());
			dao.setProcInValue(nProc12Index, "cancel_flag","0");
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProc12Index, "currency_value",_poDeskGenerateTransVO.getStrDCurrencyValue());
			else
				dao.setProcInValue(nProc12Index, "currency_value","1");
			dao.setProcInValue(nProc12Index, "waivoff","0");
			dao.setProcInValue(nProc12Index, "advance_adjusted","0");
			dao.setProcInValue(nProc12Index, "po_prefix","0");
			dao.setProcInValue(nProc12Index, "seat_id",_poDeskGenerateTransVO.getStrSeatId());
			dao.setProcInValue(nProc12Index, "paid_bill_amt","0");
			dao.setProcInValue(nProc12Index, "tax",_poDeskGenerateTransVO.getStrDOverAllTax());
			dao.setProcInValue(nProc12Index, "net_amount",_poDeskGenerateTransVO.getStrDNetAmount());
			dao.setProcInValue(nProc12Index, "issueNo","0");
			dao.setProcInValue(nProc12Index, "reqTypeId",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			dao.setProcInValue(nProc12Index, "verified_by",_poDeskGenerateTransVO.getStrVerifiedBy());
			dao.setProcInValue(nProc12Index, "verified_date",_poDeskGenerateTransVO.getStrVerifiedDate());
			dao.setProcInValue(nProc12Index, "po_ref_no",_poDeskGenerateTransVO.getStrDPORefNo());
			dao.setProcInValue(nProc12Index, "po_date",_poDeskGenerateTransVO.getStrPODate()+"@"+_poDeskGenerateTransVO.getStrPODate());
			dao.setProcInValue(nProc12Index, "dcomments",_poDeskGenerateTransVO.getStrDComments());
			dao.setProcInValue(nProc12Index, "dnotes",_poDeskGenerateTransVO.getStrDNotes());
			dao.setProcOutValue_new(nProc12Index, "err",1);        
			dao.execute(nProc12Index,1);
			
			
					
					synchronized (dao) 
					{
						//if(nTmpI == (_poDeskGenerateTransVO.getStrDLstSupplierId().length-1) )
						_poDeskGenerateTransVO.setStrMsgType("2");
							dao.fire_without_commit(0, 1);
						//else
							//dao.fire_without_commit(1, 0);
						//flag = true;
					}
					
			if (strErr != null && !strErr.equals(""))
				throw new Exception(strErr);
			else
			{
				/*if(!_poDeskGenerateTransVO.getStrItemCat().equals("21"))
				{
					SMSHttpsNICPostClient sms=new SMSHttpsNICPostClient();
					for(int i=0;i<_poDeskGenerateTransVO.getStrDLstSupplierId().length;i++)
				
					{
						sms.sendTextSMSThroughNICSMSGateway("", "", "", "", _poDeskGenerateTransVO.getStrDPhoneEmail()[i].replace("^", "#").split("#")[0], "Po placed with PO No : "+ potmpno[i]);
						sms.sendEmail(_poDeskGenerateTransVO.getStrDPhoneEmail()[i].replace("^", "#").split("#")[1],"PO Placed","Po placed with PO No : "+ potmpno[i]);
					}
				}*/
			}
			_poDeskGenerateTransVO.setStrPoNo(strPONo);	
			_poDeskGenerateTransVO.setStrMsgType("2");

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.insert() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void INSERTMODIFYDRAFT(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strProcName  = "{call PKG_MMS_DML.dml_hstt_po_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";	//26+ 2(Added by Adil for PO Prefix and PO Date)= 28 Variable
		String strProcName1 = "{call PKG_MMS_DML.Dml_hstt_po_req_Dtl(?,?,?,?,?,?,?,?,?,?,?,?)}";
		String strProcName2 = "{call PKG_MMS_DML.Dml_hstt_po_Item_Dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";	//35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		String strProcName3 = "{call PKG_MMS_DML.dml_hstt_potype_component_mst(?,?,?,?,?,?,?,?)}";
		String strProcName4 = "{call PKG_MMS_DML.dml_sstt_po_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //34+ 2+2(Added by Adil for PO Prefix and PO Date)=36 variable
		String strProcName5 = "{call PKG_MMS_DML.dml_hstt_foreignnpo_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";
		String strProcName6 = "{call PKG_MMS_DML.dml_hstt_po_schedule_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}";
		String strProcName7 = "{call PKG_MMS_DML.dml_hstt_po_req_item_dtl(?,?,?,?,?,?,?,?,?,?,?)}";
		String strProcName8 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		String strProcName9 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		//String strProcName10 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		//String strProcName11 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		String strProcName12 = "{call PKG_MMS_DML.dml_sstt_po_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //34+ 2(Added by Adil for PO Prefix and PO Date)=36 variable
		String strProcName13 = "{call PKG_MMS_DML.DML_FIN_CONCURRENCE_DTL(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;
		int nProc1Index = 0;
		int nProc2Index = 0;
		int nProc3Index = 0;
		int nProc4Index = 0;
		int nProc5Index = 0;
		int nProc6Index = 0;
		int nProc7Index = 0;
		int nProc8Index = 0;
		int nProc9Index = 0;
		//int nProc10Index = 0;
		//int nProc11Index = 0;
		int nProc12Index = 0,nProc13Index = 0;
		int funcIndex=0;
		String strErr = "";
		String strPONo = "";
		String combinedpono="";
		double[] tmpvalue= new double[_poDeskGenerateTransVO.getStrHiddenValue().length];
		String[] potmpno = new String[_poDeskGenerateTransVO.getStrDLstSupplierId().length];
		//double taxamt=0.0 ;
		//String[] tmpPONo=new String[_poDeskGenerateTransVO.getStrDLstSupplierId().length];
		MmsConfigUtil mmsConfigUtil = null;
		//boolean flag = false;
		try {
			mmsConfigUtil = new MmsConfigUtil(_poDeskGenerateTransVO.getStrHospitalCode());
			
			dao = new HisDAO("MMS","transactions.PODeskGenerateTransDAO.insert()");
			
			Map mp=new HashMap();

			for (int nTmpI = 0; nTmpI < _poDeskGenerateTransVO.getStrDLstSupplierId().length; nTmpI++) 
			{
			
				funcIndex = dao.setFunction("{? = call MMS_MST.generate_poNo(?,?,?,?)}");

				dao.setFuncInValue(funcIndex, 2, _poDeskGenerateTransVO
						.getStrHospitalCode());
				dao.setFuncInValue(funcIndex, 3, _poDeskGenerateTransVO
						.getStrStoreId());
				dao.setFuncInValue(funcIndex, 4, _poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
				dao.setFuncInValue(funcIndex, 5, _poDeskGenerateTransVO
						.getStrItemCat());
				dao.setFuncOutValue(funcIndex, 1);

				dao.executeFunction(funcIndex);
				
			//dao.f
			strPONo = dao.getFuncString(funcIndex);
			potmpno[nTmpI]=strPONo;
			if(nTmpI==0)
				combinedpono=strPONo;
			else
				combinedpono=combinedpono+","+strPONo;
			
			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval","1");
			dao.setProcInValue(nProcIndex, "pono",strPONo);
			dao.setProcInValue(nProcIndex, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "item_cat",_poDeskGenerateTransVO.getStrItemCat());
			dao.setProcInValue(nProcIndex, "po_type_id",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProcIndex, "currency_id",_poDeskGenerateTransVO.getStrDCurrencyName());
			else
				dao.setProcInValue(nProcIndex, "currency_id","100");
			
			dao.setProcInValue(nProcIndex, "pur_source",_poDeskGenerateTransVO.getStrDPurchaseSource());
			dao.setProcInValue(nProcIndex, "store_id",_poDeskGenerateTransVO.getStrStoreId());
			dao.setProcInValue(nProcIndex, "supplier",_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]);
			dao.setProcInValue(nProcIndex, "delevery_location",_poDeskGenerateTransVO.getStrDDeliveryLocation());
			dao.setProcInValue(nProcIndex, "tender_no","0");
			dao.setProcInValue(nProcIndex, "tender_date","0");
			dao.setProcInValue(nProcIndex, "quotation_no","0");
			dao.setProcInValue(nProcIndex, "quotation_date","0");
			dao.setProcInValue(nProcIndex, "fin_start_date",mmsConfigUtil.getStrFinancialStartDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProcIndex, "fin_end_date",mmsConfigUtil.getStrFinancialEndDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProcIndex, "po_remarks",_poDeskGenerateTransVO.getStrDRemarks());
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProcIndex, "currency_value",_poDeskGenerateTransVO.getStrDCurrencyValue());
			else
				dao.setProcInValue(nProcIndex, "currency_value","1");
			
			dao.setProcInValue(nProcIndex, "seat_id",_poDeskGenerateTransVO.getStrSeatId());
			dao.setProcInValue(nProcIndex, "tax","0");//_poDeskGenerateTransVO.getStrDOverAllTax());//0
			dao.setProcInValue(nProcIndex, "net_amount",_poDeskGenerateTransVO.getSupptotamt()[nTmpI]);//_poDeskGenerateTransVO.getStrDNetAmount());//0
			dao.setProcInValue(nProcIndex, "schedule_no","0");
			dao.setProcInValue(nProcIndex, "verified_by",_poDeskGenerateTransVO.getStrVerifiedBy());
			dao.setProcInValue(nProcIndex, "verified_date",_poDeskGenerateTransVO.getStrVerifiedDate());
			
			/* Setting Default Value Start*/
			
			dao.setProcInValue(nProcIndex, "ipAddr","0");
			
			dao.setProcInValue(nProcIndex, "po_prefix",_poDeskGenerateTransVO.getStrDPORefNo());
			dao.setProcInValue(nProcIndex, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
			/* Setting Default Value End */
			
			dao.setProcOutValue_new(nProcIndex, "err",1);        
			
			dao.execute(nProcIndex,1);
			
			
			for(int x = 0 ; x<_poDeskGenerateTransVO.getStrDRequestNo().length;x++)
			{
					nProc1Index = dao.setProcedure(strProcName1);
					
					dao.setProcInValue(nProc1Index, "modeval", "1");
					dao.setProcInValue(nProc1Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc1Index, "pono",strPONo);
					dao.setProcInValue(nProc1Index, "req_no",_poDeskGenerateTransVO.getStrDRequestNo()[x]);
					dao.setProcInValue(nProc1Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc1Index, "req_date","0");
					dao.setProcInValue(nProc1Index, "req_period","0");
					dao.setProcInValue(nProc1Index, "req_type_id",_poDeskGenerateTransVO.getStrDRequestNo()[x].substring(2,4));
					dao.setProcInValue(nProc1Index, "raising_store",_poDeskGenerateTransVO.getStrDRaisingStore()[x]);
					dao.setProcInValue(nProc1Index, "puk","0");
					dao.setProcInValue(nProc1Index, "emp_id","0");
					dao.setProcOutValue_new(nProc1Index, "err", 1);
	
					dao.execute(nProc1Index,1);
				}
			
			for (int i = 0; i < _poDeskGenerateTransVO.getStrHiddenValue().length; i++) {
				if(_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[0].equals(_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]))
				{
					nProc2Index = dao.setProcedure(strProcName2);
					dao.setProcInValue(nProc2Index, "modeval", "1");
					dao.setProcInValue(nProc2Index, "pono",strPONo);
					
					dao.setProcInValue(nProc2Index, "store_id", _poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc2Index, "item_id",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[6]);
					dao.setProcInValue(nProc2Index, "item_brand_id",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[7]);
					dao.setProcInValue(nProc2Index, "schedule_no", "1");
					dao.setProcInValue(nProc2Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc2Index, "supplier",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[0]);
					dao.setProcInValue(nProc2Index, "groupid",_poDeskGenerateTransVO.getStrGroupId().replace("[","").replace("]", "").replace('"', ' ').split(",")[i].trim());
					dao.setProcInValue(nProc2Index, "subgroup_id","0");
					dao.setProcInValue(nProc2Index, "manuf_id","0");
					dao.setProcInValue(nProc2Index, "rate",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[3]);
					dao.setProcInValue(nProc2Index, "rate_unit",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[8]);
					dao.setProcInValue(nProc2Index, "order_qty",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[2]);
					dao.setProcInValue(nProc2Index, "order_qty_unit",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[8]);
					dao.setProcInValue(nProc2Index, "accepted_qty", "0");
					dao.setProcInValue(nProc2Index, "accepted_qty_unit", "0");
					dao.setProcInValue(nProc2Index, "rejected_qty", "0");
					dao.setProcInValue(nProc2Index, "rejected_qty_unit", "0");
					dao.setProcInValue(nProc2Index, "breakage_qty", "0");
					dao.setProcInValue(nProc2Index, "breakage_qty_unit", "0");
					dao.setProcInValue(nProc2Index, "warrenty_req","0");
					dao.setProcInValue(nProc2Index, "installation_req","0");
					dao.setProcInValue(nProc2Index, "remarks",_poDeskGenerateTransVO.getStrDRemarks());
					dao.setProcInValue(nProc2Index, "item_tax",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[9]);
					
					
					/* Setting Default Value Start*/
					
					dao.setProcInValue(nProc2Index, "return_qty", "0");
					dao.setProcInValue(nProc2Index, "return_qty_unit", "0");
					dao.setProcInValue(nProc2Index, "recieved_qty", "0");
					dao.setProcInValue(nProc2Index, "recieved_qty_unit", "0");
					dao.setProcInValue(nProc2Index, "req_no", "0");
					dao.setProcInValue(nProc2Index, "challanNo", "0");
					dao.setProcInValue(nProc2Index, "raising_store", _poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[14]); //used as pack size);
					dao.setProcInValue(nProc2Index, "po_type", _poDeskGenerateTransVO.getStrPOTypeId());
					//dao.setProcInValue(nProc2Index, "delivery_loc", "-",33);
					dao.setProcInValue(nProc2Index, "item_make","0");
					dao.setProcInValue(nProc2Index, "itemName", "");
					
					dao.setProcInValue(nProc2Index, "po_date",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[1]);
					/* Setting Default Value End */
					dao.setProcInValue(nProc2Index, "delivery_loc",_poDeskGenerateTransVO.getStrDDeliveryLocation());
					dao.setProcOutValue_new(nProc2Index, "err", 1);
	
					dao.execute(nProc2Index,1);
					
					tmpvalue[i]=Double.parseDouble(_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[2])*Double.parseDouble(_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[3]);
				}
			}
			
			if(_poDeskGenerateTransVO.getStrDComponentId()!=null){
				for(int i=(nTmpI)*((_poDeskGenerateTransVO.getStrDComponentId().length)/(_poDeskGenerateTransVO.getStrDLstSupplierId().length)) , stopNTmp =( (_poDeskGenerateTransVO.getStrDComponentId().length)/(_poDeskGenerateTransVO.getStrDLstSupplierId().length))*(nTmpI+1); i<stopNTmp; i++){
					nProc3Index = dao.setProcedure(strProcName3);
					
					dao.setProcInValue(nProc3Index, "modeval", "1");
					dao.setProcInValue(nProc3Index, "pono", strPONo);
					dao.setProcInValue(nProc3Index, "store_id", _poDeskGenerateTransVO.getStrStoreId());
					if(_poDeskGenerateTransVO.getStrDComponentValue()[i].length() >3999){
						dao.setProcInValue(nProc3Index, "comp_value1", _poDeskGenerateTransVO.getStrDComponentValue()[i].substring(0,3999));
						dao.setProcInValue(nProc3Index, "comp_value2", _poDeskGenerateTransVO.getStrDComponentValue()[i].substring(4000));
					}else{
						dao.setProcInValue(nProc3Index, "comp_value1", _poDeskGenerateTransVO.getStrDComponentValue()[i]);
						dao.setProcInValue(nProc3Index, "comp_value2", " ");
					}
					dao.setProcInValue(nProc3Index, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc3Index, "comp_id",_poDeskGenerateTransVO.getStrDComponentId()[i]);
					/*for(int i = 0 ; i< tmpPONo.length;i++)
					{
						if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0] == tmpPONo[i].replace("^","#").split("#")[1])
							dao.setProcInValue(nProc3Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],2);
					}*/
					
					//dao.setProcInValue(nProc3Index, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
					dao.setProcOutValue_new(nProc3Index, "err", 1);
		
					dao.execute(nProc3Index,1);
				}
			}
			
			//for (int i = 0; nTmpI < _poDeskGenerateTransVO.getStrDLstSupplierId().length; nTmpI++) {
			nProc4Index = dao.setProcedure(strProcName4);
			dao.setProcInValue(nProc4Index, "modeval","1");
			/*for(int i = 0 ; i< tmpPONo.length;i++)
			{
				if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0].equals(tmpPONo[i].replace("^","#").split("#")[1]))
					dao.setProcInValue(nProc4Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],2);
			}*/
			dao.setProcInValue(nProc4Index, "pono",strPONo);
			dao.setProcInValue(nProc4Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
			dao.setProcInValue(nProc4Index, "item_cat",_poDeskGenerateTransVO.getStrItemCat());
			dao.setProcInValue(nProc4Index, "po_type_id",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProc4Index, "currency_id",_poDeskGenerateTransVO.getStrDCurrencyName());
			else
				dao.setProcInValue(nProc4Index, "currency_id","100",6);
			
			dao.setProcInValue(nProc4Index, "pur_source",_poDeskGenerateTransVO.getStrDPurchaseSource());
			dao.setProcInValue(nProc4Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());
			dao.setProcInValue(nProc4Index, "supplier",_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]);
			dao.setProcInValue(nProc4Index, "delevery_location",_poDeskGenerateTransVO.getStrDDeliveryLocation());
			dao.setProcInValue(nProc4Index, "tender_no",_poDeskGenerateTransVO.getStrDTenderNo());
			dao.setProcInValue(nProc4Index, "tender_date",_poDeskGenerateTransVO.getStrDTenderDate());
			dao.setProcInValue(nProc4Index, "quotation_no",_poDeskGenerateTransVO.getStrDQuotationNo());
			dao.setProcInValue(nProc4Index, "quotation_date",_poDeskGenerateTransVO.getStrDQuotationDate());
			dao.setProcInValue(nProc4Index, "net_advance","0");
			dao.setProcInValue(nProc4Index, "po_status","0");
			dao.setProcInValue(nProc4Index, "fin_start_date",mmsConfigUtil.getStrFinancialStartDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProc4Index, "fin_end_date",mmsConfigUtil.getStrFinancialEndDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProc4Index, "net_penelty","0");
			dao.setProcInValue(nProc4Index, "po_remarks",_poDeskGenerateTransVO.getStrDRemarks());
			dao.setProcInValue(nProc4Index, "cancel_flag","0");
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProc4Index, "currency_value",_poDeskGenerateTransVO.getStrDCurrencyValue());
			else
				dao.setProcInValue(nProc4Index, "currency_value","1");
			dao.setProcInValue(nProc4Index, "waivoff","0");
			dao.setProcInValue(nProc4Index, "advance_adjusted","0");
			dao.setProcInValue(nProc4Index, "po_prefix","0");
			dao.setProcInValue(nProc4Index, "seat_id",_poDeskGenerateTransVO.getStrSeatId());
			dao.setProcInValue(nProc4Index, "paid_bill_amt","0");
			dao.setProcInValue(nProc4Index, "tax",_poDeskGenerateTransVO.getStrDOverAllTax());
			dao.setProcInValue(nProc4Index, "net_amount",_poDeskGenerateTransVO.getSupptotamt()[nTmpI]);
			dao.setProcInValue(nProc4Index, "issueNo","0");
			dao.setProcInValue(nProc4Index, "reqTypeId",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			dao.setProcInValue(nProc4Index, "verified_by",_poDeskGenerateTransVO.getStrVerifiedBy());
			dao.setProcInValue(nProc4Index, "verified_date",_poDeskGenerateTransVO.getStrVerifiedDate());
			dao.setProcInValue(nProc4Index, "po_ref_no",_poDeskGenerateTransVO.getStrDPORefNo());
			dao.setProcInValue(nProc4Index, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
			dao.setProcInValue(nProc4Index, "dcomments",_poDeskGenerateTransVO.getStrDComments());
			dao.setProcInValue(nProc4Index, "dnotes",_poDeskGenerateTransVO.getStrDNotes());
			dao.setProcOutValue_new(nProc4Index, "err",1);        
			dao.execute(nProc4Index,1);
			
			
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24")){
				//for (int nTmpI = 0; nTmpI < _poDeskGenerateTransVO.getStrDLstSupplierId().length; nTmpI++) {
				nProc5Index = dao.setProcedure(strProcName5);
				dao.setProcInValue(nProc5Index, "modeval","1");
				/*for(int i = 0 ; i< tmpPONo.length;i++)
				{
					if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0].equals(tmpPONo[i].replace("^","#").split("#")[1]))
						dao.setProcInValue(nProc5Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],2);
				}*/
				dao.setProcInValue(nProc5Index, "pono",strPONo);
				dao.setProcInValue(nProc5Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());
				dao.setProcInValue(nProc5Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
				dao.setProcInValue(nProc5Index, "supplier",_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]);
				dao.setProcInValue(nProc5Index, "agent_id",_poDeskGenerateTransVO.getStrDAgentName());
				dao.setProcInValue(nProc5Index, "ca_id",_poDeskGenerateTransVO.getStrDCAName());
				dao.setProcInValue(nProc5Index, "currency",_poDeskGenerateTransVO.getStrDCurrencyName());
				dao.setProcInValue(nProc5Index, "iac_charge",_poDeskGenerateTransVO.getStrDIACCharge());
				dao.setProcInValue(nProc5Index, "insurance_charge",_poDeskGenerateTransVO.getStrDInsuranceCharge());
				dao.setProcInValue(nProc5Index, "dumurrages_by",_poDeskGenerateTransVO.getStrDDemurrageBy());
				dao.setProcInValue(nProc5Index, "remarks",_poDeskGenerateTransVO.getStrDRemarks());
				dao.setProcInValue(nProc5Index, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
				dao.setProcOutValue_new(nProc5Index, "err",1);
				
				dao.execute(nProc5Index,1);
				}
			
			//for (int nTmpI = 0; nTmpI < _poDeskGenerateTransVO.getStrDLstSupplierId().length; nTmpI++) {
			nProc6Index = dao.setProcedure(strProcName6);
			dao.setProcInValue(nProc6Index, "modeval","1");
			dao.setProcInValue(nProc6Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());			
			/*for(int i = 0 ; i< tmpPONo.length;i++)
			{
				if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0].equals(tmpPONo[i].replace("^","#").split("#")[1]))
					dao.setProcInValue(nProc6Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],3);
			}*/
			
			
			dao.setProcInValue(nProc6Index, "pono",strPONo);
			dao.setProcInValue(nProc6Index, "schedule_no","1");
			dao.setProcInValue(nProc6Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
			dao.setProcInValue(nProc6Index, "schedule_date","");
			dao.setProcInValue(nProc6Index, "delivery_date",_poDeskGenerateTransVO.getStrDExpectedDeliveryDate()[nTmpI]);
			dao.setProcInValue(nProc6Index, "schedule_status","");
			dao.setProcInValue(nProc6Index, "penelty","");
			dao.setProcInValue(nProc6Index, "cancel_date","");
			dao.setProcInValue(nProc6Index, "cancel_by","");
			dao.setProcInValue(nProc6Index, "cancel_remarks","");
			dao.setProcInValue(nProc6Index, "delivery_loc", _poDeskGenerateTransVO.getStrDDeliveryLocation());
			dao.setProcOutValue_new(nProc6Index, "err",1);
			
			dao.execute(nProc6Index,1);
			
			for (int i = 0; i < _poDeskGenerateTransVO.getStrHiddenValue().length; i++) {
				if(_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[0].equals(_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]))
				{
					nProc7Index = dao.setProcedure(strProcName7);
					dao.setProcInValue(nProc7Index, "modeval", "1");
					/*for(int i = 0 ; i< tmpPONo.length;i++)
					{
						if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0].equals(tmpPONo[i].replace("^","#").split("#")[1]))
							dao.setProcInValue(nProc7Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],2);
					}*/
					dao.setProcInValue(nProc7Index, "pono", strPONo);
					dao.setProcInValue(nProc7Index, "store_id", _poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc7Index, "req_no","0");
					dao.setProcInValue(nProc7Index, "raising_store_id",_poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc7Index, "item_id", _poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[6]);
					dao.setProcInValue(nProc7Index, "itembrand_id",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[7]);
					dao.setProcInValue(nProc7Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc7Index, "order_qty",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[2]);
					dao.setProcInValue(nProc7Index, "orderqty_unitid",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[8]);
					dao.setProcOutValue_new(nProc7Index, "err", 1);
	
					dao.execute(nProc7Index,1);
				}
			}
			
			if( mmsConfigUtil.getStrFMSIntegration() != null && mmsConfigUtil.getStrFMSIntegration().equals("1"))
			{
				for (int i = 0; i < _poDeskGenerateTransVO.getStrHiddenValue().length; i++) {
					
					if(_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[0].equals(_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]))
					{ 
					//tmpvalue=Double.parseDouble(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[4].split("\\(")[0])*Double.parseDouble(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[4].split("\\(")[2])*(Double.parseDouble(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[9])/100);
					nProc13Index = dao.setProcedure(strProcName13);
					dao.setProcInValue(nProc13Index, "modeval","1");
					dao.setProcInValue(nProc13Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc13Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc13Index, "store",_poDeskGenerateTransVO.getStrStoreName());
					dao.setProcInValue(nProc13Index, "pono",potmpno[nTmpI]);
					dao.setProcInValue(nProc13Index, "podate",_poDeskGenerateTransVO.getStrPODate());
					dao.setProcInValue(nProc13Index, "suppid",_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]);
					dao.setProcInValue(nProc13Index, "supp","");
					dao.setProcInValue(nProc13Index, "amt",Double.toString(tmpvalue[i]));
					dao.setProcInValue(nProc13Index, "seatid",_poDeskGenerateTransVO.getStrSeatId());	
					dao.setProcInValue(nProc13Index, "itembrandid",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[7]);
					dao.setProcInValue(nProc13Index, "itemname","");
					dao.setProcInValue(nProc13Index, "rate",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[3]);
					dao.setProcInValue(nProc13Index, "itemqty",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[2]);
					dao.setProcInValue(nProc13Index, "strrequestpono",potmpno[nTmpI]);
					dao.setProcInValue(nProc13Index, "sectionid","12");
					dao.setProcInValue(nProc13Index, "tax",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[9]);
					dao.setProcOutValue_new(nProc13Index, "err",1);        
					dao.execute(nProc13Index,1);
					}	
				}
			}
			
			synchronized (dao) 
			{
				//if(nTmpI == (_poDeskGenerateTransVO.getStrDLstSupplierId().length-1) )
				//	dao.fire_without_commit(0, 1);
				//else
					dao.fire_without_commit(1, 0);
				//flag = true;
			}
//			if(flag)
//			{
//				//PODeskGenerateTransDAO.updateCurrStock(_poDeskGenerateTransVO,strPONo);
//			}
			}
			
			for (int x = 0; x < _poDeskGenerateTransVO.getStrDRequestNo().length; x++)//Agenda No Loop To Update Process Qty
			{			
				for (int i = 0; i < _poDeskGenerateTransVO.getStrHiddenValue().length; i++) //Item Id Loop
				{
						nProc8Index = dao.setProcedure(strProcName8);
						dao.setProcInValue(nProc8Index, "modeval", "5");
						dao.setProcInValue(nProc8Index, "pono", strPONo);
						dao.setProcInValue(nProc8Index, "store_id", "0");
						dao.setProcInValue(nProc8Index, "item_id", _poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[6]);
						dao.setProcInValue(nProc8Index, "item_brand_id",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[7]);
						dao.setProcInValue(nProc8Index, "schedule_no", "0");
						dao.setProcInValue(nProc8Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
						dao.setProcInValue(nProc8Index, "supplier", "0");
						dao.setProcInValue(nProc8Index, "groupid", "0");
						dao.setProcInValue(nProc8Index, "subgroup_id", "0");
						dao.setProcInValue(nProc8Index, "manuf_id", "0");
						dao.setProcInValue(nProc8Index, "rate", "0");
						dao.setProcInValue(nProc8Index, "rate_unit", "0");
						dao.setProcInValue(nProc8Index, "order_qty",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[2]);
						dao.setProcInValue(nProc8Index, "order_qty_unit", _poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[8]);
						dao.setProcInValue(nProc8Index, "accepted_qty", "0");
						dao.setProcInValue(nProc8Index, "accepted_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "rejected_qty", "0");
						dao.setProcInValue(nProc8Index, "rejected_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "breakage_qty", "0");
						dao.setProcInValue(nProc8Index, "breakage_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "warrenty_req", "0");
						dao.setProcInValue(nProc8Index, "installation_req", "0");
						dao.setProcInValue(nProc8Index, "remarks", "");
						dao.setProcInValue(nProc8Index, "item_tax", "0");
						dao.setProcInValue(nProc8Index, "return_qty", "0");
						dao.setProcInValue(nProc8Index, "return_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "recieved_qty", "0");
						dao.setProcInValue(nProc8Index, "recieved_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "req_no",_poDeskGenerateTransVO.getStrDRequestNo()[x]);
						dao.setProcInValue(nProc8Index, "challanNo", "0");
						dao.setProcInValue(nProc8Index, "raising_store",_poDeskGenerateTransVO.getStrDRaisingStore()[x]);
						dao.setProcInValue(nProc8Index, "po_type",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
						dao.setProcInValue(nProc8Index, "item_make", "1");
						dao.setProcInValue(nProc8Index, "itemName", "");
						dao.setProcInValue(nProc8Index, "po_date",_poDeskGenerateTransVO.getStrPODate());
						dao.setProcInValue(nProc8Index, "delivery_loc",_poDeskGenerateTransVO.getStrDDeliveryLocation());
						dao.setProcOutValue_new(nProc8Index, "err", 1);
						dao.execute(nProc8Index,1);
					}
				}
					
			
			for (int x = 0; x < _poDeskGenerateTransVO.getStrDRequestNo().length; x++)//Agenda No Loop To Update Agenda Status
			{	
				nProc9Index = dao.setProcedure(strProcName9);
				dao.setProcInValue(nProc9Index, "modeval", "6");
				dao.setProcInValue(nProc9Index, "pono", "0");
				dao.setProcInValue(nProc9Index, "store_id", "0");
				dao.setProcInValue(nProc9Index, "item_id", "0");
				dao.setProcInValue(nProc9Index, "item_brand_id", "0");
				dao.setProcInValue(nProc9Index, "schedule_no", "0");
				dao.setProcInValue(nProc9Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
				dao.setProcInValue(nProc9Index, "supplier", "0");
				dao.setProcInValue(nProc9Index, "groupid", "0");
				dao.setProcInValue(nProc9Index, "subgroup_id", "0");
				dao.setProcInValue(nProc9Index, "manuf_id", "0");
				dao.setProcInValue(nProc9Index, "rate", "0");
				dao.setProcInValue(nProc9Index, "rate_unit", "0");
				dao.setProcInValue(nProc9Index, "order_qty", "0");
				dao.setProcInValue(nProc9Index, "order_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "accepted_qty", "0");
				dao.setProcInValue(nProc9Index, "accepted_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "rejected_qty", "0");
				dao.setProcInValue(nProc9Index, "rejected_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "breakage_qty", "0");
				dao.setProcInValue(nProc9Index, "breakage_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "warrenty_req", "0");
				dao.setProcInValue(nProc9Index, "installation_req", "0");
				dao.setProcInValue(nProc9Index, "remarks", "");
				dao.setProcInValue(nProc9Index, "item_tax", "0");
				dao.setProcInValue(nProc9Index, "return_qty", "0");
				dao.setProcInValue(nProc9Index, "return_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "recieved_qty", "0");
				dao.setProcInValue(nProc9Index, "recieved_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "req_no",_poDeskGenerateTransVO.getStrDRequestNo()[x]);
				dao.setProcInValue(nProc9Index, "challanNo", "0");
				dao.setProcInValue(nProc9Index, "raising_store",_poDeskGenerateTransVO.getStrDRaisingStore()[x]);
				dao.setProcInValue(nProc9Index, "po_type",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
				dao.setProcInValue(nProc9Index, "item_make", "1");
				dao.setProcInValue(nProc9Index, "itemName", "");
				dao.setProcInValue(nProc9Index, "po_date",_poDeskGenerateTransVO.getStrPODate());
				dao.setProcInValue(nProc9Index, "delivery_loc",_poDeskGenerateTransVO.getStrDDeliveryLocation());
				dao.setProcOutValue_new(nProc9Index, "err", 1);
				dao.execute(nProc9Index,1);
			}
			
			
					
			nProc12Index = dao.setProcedure(strProcName12);
			dao.setProcInValue(nProc12Index, "modeval","4");
			/*for(int i = 0 ; i< tmpPONo.length;i++)
			{
				if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0].equals(tmpPONo[i].replace("^","#").split("#")[1]))
					dao.setProcInValue(nProc4Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],2);
			}*/
			dao.setProcInValue(nProc12Index, "pono",combinedpono);
			dao.setProcInValue(nProc12Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
			dao.setProcInValue(nProc12Index, "item_cat",_poDeskGenerateTransVO.getStrItemCat());
			dao.setProcInValue(nProc12Index, "po_type_id",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProc12Index, "currency_id",_poDeskGenerateTransVO.getStrDCurrencyName());
			else
				dao.setProcInValue(nProc12Index, "currency_id","100",6);
			
			dao.setProcInValue(nProc12Index, "pur_source",_poDeskGenerateTransVO.getStrDPurchaseSource());
			dao.setProcInValue(nProc12Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());
			dao.setProcInValue(nProc12Index, "supplier","");
			dao.setProcInValue(nProc12Index, "delevery_location",_poDeskGenerateTransVO.getStrDDeliveryLocation());
			dao.setProcInValue(nProc12Index, "tender_no",_poDeskGenerateTransVO.getStrDTenderNo());
			dao.setProcInValue(nProc12Index, "tender_date",_poDeskGenerateTransVO.getStrDTenderDate());
			dao.setProcInValue(nProc12Index, "quotation_no",_poDeskGenerateTransVO.getStrDQuotationNo());
			dao.setProcInValue(nProc12Index, "quotation_date",_poDeskGenerateTransVO.getStrDQuotationDate());
			dao.setProcInValue(nProc12Index, "net_advance","0");
			dao.setProcInValue(nProc12Index, "po_status","0");
			dao.setProcInValue(nProc12Index, "fin_start_date",mmsConfigUtil.getStrFinancialStartDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProc12Index, "fin_end_date",mmsConfigUtil.getStrFinancialEndDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProc12Index, "net_penelty","0");
			dao.setProcInValue(nProc12Index, "po_remarks",_poDeskGenerateTransVO.getStrDRemarks());
			dao.setProcInValue(nProc12Index, "cancel_flag","0");
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProc12Index, "currency_value",_poDeskGenerateTransVO.getStrDCurrencyValue());
			else
				dao.setProcInValue(nProc12Index, "currency_value","1");
			dao.setProcInValue(nProc12Index, "waivoff","0");
			dao.setProcInValue(nProc12Index, "advance_adjusted","0");
			dao.setProcInValue(nProc12Index, "po_prefix","0");
			dao.setProcInValue(nProc12Index, "seat_id",_poDeskGenerateTransVO.getStrSeatId());
			dao.setProcInValue(nProc12Index, "paid_bill_amt","0");
			dao.setProcInValue(nProc12Index, "tax",_poDeskGenerateTransVO.getStrDOverAllTax());
			dao.setProcInValue(nProc12Index, "net_amount",_poDeskGenerateTransVO.getStrDNetAmount());
			dao.setProcInValue(nProc12Index, "issueNo","0");
			dao.setProcInValue(nProc12Index, "reqTypeId",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			dao.setProcInValue(nProc12Index, "verified_by",_poDeskGenerateTransVO.getStrVerifiedBy());
			dao.setProcInValue(nProc12Index, "verified_date",_poDeskGenerateTransVO.getStrVerifiedDate());
			dao.setProcInValue(nProc12Index, "po_ref_no",_poDeskGenerateTransVO.getStrDPORefNo());
			dao.setProcInValue(nProc12Index, "po_date",_poDeskGenerateTransVO.getStrPODate()+"@"+_poDeskGenerateTransVO.getStrPODate());
			dao.setProcInValue(nProc12Index, "dcomments",_poDeskGenerateTransVO.getStrDComments());
			dao.setProcInValue(nProc12Index, "dnotes",_poDeskGenerateTransVO.getStrDNotes());
			dao.setProcOutValue_new(nProc12Index, "err",1);        
			dao.execute(nProc12Index,1);
			
			
					
					synchronized (dao) 
					{
						//if(nTmpI == (_poDeskGenerateTransVO.getStrDLstSupplierId().length-1) )
						_poDeskGenerateTransVO.setStrMsgType("2");
							dao.fire_without_commit(0, 1);
						//else
							//dao.fire_without_commit(1, 0);
						//flag = true;
					}
					
			if (strErr != null && !strErr.equals(""))
				throw new Exception(strErr);
			else
			{
				/*if(!_poDeskGenerateTransVO.getStrItemCat().equals("21"))
				{
					SMSHttpsNICPostClient sms=new SMSHttpsNICPostClient();
					for(int i=0;i<_poDeskGenerateTransVO.getStrDLstSupplierId().length;i++)
				
					{
						sms.sendTextSMSThroughNICSMSGateway("", "", "", "", _poDeskGenerateTransVO.getStrDPhoneEmail()[i].replace("^", "#").split("#")[0], "Po placed with PO No : "+ potmpno[i]);
						sms.sendEmail(_poDeskGenerateTransVO.getStrDPhoneEmail()[i].replace("^", "#").split("#")[1],"PO Placed","Po placed with PO No : "+ potmpno[i]);
					}
				}*/
			}
			_poDeskGenerateTransVO.setStrPoNo(strPONo);	
			_poDeskGenerateTransVO.setStrMsgType("2");

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.insert() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void insert(PODeskGenerateTransVO _poDeskGenerateTransVO) 
	{
		System.out.println("----------- PODeskGenerateTransDAO . INSERT -----------");
		
		String strProcName  = "{call PKG_MMS_DML.dml_hstt_po_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";	//26+ 2(Added by Adil for PO Prefix and PO Date)= 28 Variable
		String strProcName1 = "{call PKG_MMS_DML.Dml_hstt_po_req_Dtl(?,?,?,?,?,?,?,?,?,?,?,?)}";
		String strProcName2 = "{call PKG_MMS_DML.Dml_hstt_po_Item_Dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";	//35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		String strProcName3 = "{call PKG_MMS_DML.dml_hstt_potype_component_mst(?,?,?,?,?,?,?,?)}";
		String strProcName4 = "{call PKG_MMS_DML.dml_sstt_po_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //34+ 2(Added by Adil for PO Prefix and PO Date)=36 variable
		String strProcName5 = "{call PKG_MMS_DML.dml_hstt_foreignnpo_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";
		String strProcName6 = "{call PKG_MMS_DML.dml_hstt_po_schedule_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}";
		String strProcName7 = "{call PKG_MMS_DML.dml_hstt_po_req_item_dtl(?,?,?,?,?,?,?,?,?,?,?)}";
		String strProcName8 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		String strProcName9 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		String strProcName10 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		String strProcName11 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; //35+ 2(Added by Adil for PO Prefix and PO Date)= 37 Variable
		HisDAO dao = null;

		int nProcIndex = 0;
		int nProc1Index = 0;
		int nProc2Index = 0;
		int nProc3Index = 0;
		int nProc4Index = 0;
		int nProc5Index = 0;
		int nProc6Index = 0;
		int nProc7Index = 0;
		int nProc8Index = 0;
		int nProc9Index = 0;
		int nProc10Index = 0;
		int nProc11Index = 0;
		int funcIndex=0;
		String strErr = "";
		String strPONo = "";
		String[] potmpno = new String[_poDeskGenerateTransVO.getStrDLstSupplierId().length];;
		//Double a ;
		//String[] tmpPONo=new String[_poDeskGenerateTransVO.getStrDLstSupplierId().length];
		MmsConfigUtil mmsConfigUtil = null;
		//boolean flag = false;
		try {
			mmsConfigUtil = new MmsConfigUtil(_poDeskGenerateTransVO.getStrHospitalCode());
			
			dao = new HisDAO("MMS","transactions.PODeskGenerateTransDAO.insert()");
			
			Map mp=new HashMap();

			for (int nTmpI = 0; nTmpI < _poDeskGenerateTransVO.getStrDLstSupplierId().length; nTmpI++) 
			{
				funcIndex = dao.setFunction("{? = call MMS_MST.generate_poNo(?,?,?,?)}");

				dao.setFuncInValue(funcIndex, 2, _poDeskGenerateTransVO
						.getStrHospitalCode());
				dao.setFuncInValue(funcIndex, 3, _poDeskGenerateTransVO
						.getStrStoreId());
				dao.setFuncInValue(funcIndex, 4, _poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
				dao.setFuncInValue(funcIndex, 5, _poDeskGenerateTransVO
						.getStrItemCat());
				dao.setFuncOutValue(funcIndex, 1);

				dao.executeFunction(funcIndex);
				
			//dao.f
			strPONo = dao.getFuncString(funcIndex);
			
			System.out.println("strPONo ----------->"+strPONo);
			
			potmpno[nTmpI]=strPONo;
			
			System.out.println("------ strProcName -----[ Mode 1 ]------"+strProcName);
			
			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval","1");
			dao.setProcInValue(nProcIndex, "pono",strPONo);
			dao.setProcInValue(nProcIndex, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "item_cat",_poDeskGenerateTransVO.getStrItemCat());
			dao.setProcInValue(nProcIndex, "po_type_id",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProcIndex, "currency_id",_poDeskGenerateTransVO.getStrDCurrencyName());
			else
				dao.setProcInValue(nProcIndex, "currency_id","100");
			
			dao.setProcInValue(nProcIndex, "pur_source",_poDeskGenerateTransVO.getStrDPurchaseSource());
			dao.setProcInValue(nProcIndex, "store_id",_poDeskGenerateTransVO.getStrStoreId());
			dao.setProcInValue(nProcIndex, "supplier",_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]);
			dao.setProcInValue(nProcIndex, "delevery_location",_poDeskGenerateTransVO.getStrDDeliveryLocation());
			dao.setProcInValue(nProcIndex, "tender_no",_poDeskGenerateTransVO.getStrDLstSupplierInterface()[nTmpI]);
			dao.setProcInValue(nProcIndex, "tender_date","0");
			dao.setProcInValue(nProcIndex, "quotation_no","0");
			dao.setProcInValue(nProcIndex, "quotation_date","0");
			dao.setProcInValue(nProcIndex, "fin_start_date",mmsConfigUtil.getStrFinancialStartDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProcIndex, "fin_end_date",mmsConfigUtil.getStrFinancialEndDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProcIndex, "po_remarks",_poDeskGenerateTransVO.getStrDRemarks());
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProcIndex, "currency_value",_poDeskGenerateTransVO.getStrDCurrencyValue());
			else
				dao.setProcInValue(nProcIndex, "currency_value","1");
			
			dao.setProcInValue(nProcIndex, "seat_id",_poDeskGenerateTransVO.getStrSeatId());
			dao.setProcInValue(nProcIndex, "tax","0");//_poDeskGenerateTransVO.getStrDOverAllTax());//0
			dao.setProcInValue(nProcIndex, "net_amount","0");//_poDeskGenerateTransVO.getStrDNetAmount());//0
			dao.setProcInValue(nProcIndex, "schedule_no","0");
			dao.setProcInValue(nProcIndex, "verified_by",_poDeskGenerateTransVO.getStrVerifiedBy());
			dao.setProcInValue(nProcIndex, "verified_date",_poDeskGenerateTransVO.getStrVerifiedDate());
			
			/* Setting Default Value Start*/
			
			dao.setProcInValue(nProcIndex, "ipAddr","0");
			
			dao.setProcInValue(nProcIndex, "po_prefix",_poDeskGenerateTransVO.getStrDPORefNo());
			dao.setProcInValue(nProcIndex, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
			/* Setting Default Value End */
			
			dao.setProcOutValue_new(nProcIndex, "err",1);        
			
			dao.execute(nProcIndex,1);
			
			System.out.println("------ strProcName1 -----[ Mode 1 ]------"+strProcName1);
		
			for(int x = 0 ; x<_poDeskGenerateTransVO.getStrDRequestNo().length;x++)
			{
				   
				
					nProc1Index = dao.setProcedure(strProcName1);
					
					dao.setProcInValue(nProc1Index, "modeval", "1");
					dao.setProcInValue(nProc1Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc1Index, "pono",strPONo);
					dao.setProcInValue(nProc1Index, "req_no",_poDeskGenerateTransVO.getStrDRequestNo()[x]);
					dao.setProcInValue(nProc1Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc1Index, "req_date","0");
					dao.setProcInValue(nProc1Index, "req_period","0");
					dao.setProcInValue(nProc1Index, "req_type_id",_poDeskGenerateTransVO.getStrDRequestNo()[x].substring(2,4));
					dao.setProcInValue(nProc1Index, "raising_store",_poDeskGenerateTransVO.getStrDRaisingStore()[x]);
					dao.setProcInValue(nProc1Index, "puk","0");
					dao.setProcInValue(nProc1Index, "emp_id","0");
					dao.setProcOutValue_new(nProc1Index, "err", 1);
	
					dao.execute(nProc1Index,1);
				}
			
			
			System.out.println("------ strProcName2 -----[ Mode 1 ]------"+strProcName2);
			

			for (int i = 0; i < _poDeskGenerateTransVO.getStrHiddenValue().length; i++) 
			{
				if(_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[0].equals(_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]))
				{
					System.out.println("------ Hidden Value ------"+_poDeskGenerateTransVO.getStrHiddenValue()[i]);
					System.out.println("Hidden_Val -> supp_id [0] ^ PO_Date [1] ^ Order Qty [2] ^ Rate [3] ^ Rate Wuth Tax [4] ^ PO_Value[5] ^ ItemId [6] ^ Barnd_ID[7] ^ Order_Qty_unit [8] ^ TAX [9] ^ TEMP_PO_NO [10] ^  Delivery Days [11] ^ Rate Contract Id [12]^ MRP [13] ^ PACK_SIZE [14] ^ Delivery Date [15] ");
					nProc2Index = dao.setProcedure(strProcName2);
					dao.setProcInValue(nProc2Index, "modeval", 			"1");					
					dao.setProcInValue(nProc2Index, "pono",				strPONo);					
					dao.setProcInValue(nProc2Index, "store_id", 		_poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc2Index, "item_id",			_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[6]);
					dao.setProcInValue(nProc2Index, "item_brand_id",	_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[7]);
					dao.setProcInValue(nProc2Index, "schedule_no", 		"1");
					dao.setProcInValue(nProc2Index, "hosp_code",		_poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc2Index, "supplier",			_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[0]);
					dao.setProcInValue(nProc2Index, "groupid",			_poDeskGenerateTransVO.getStrGroupId().replace("[","").replace("]", "").replace('"', ' ').split(",")[i].trim());
					dao.setProcInValue(nProc2Index, "subgroup_id",		"0");
					dao.setProcInValue(nProc2Index, "manuf_id",			"0");
					dao.setProcInValue(nProc2Index, "rate",				_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[3]);
					dao.setProcInValue(nProc2Index, "rate_unit",		_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[8]);
					dao.setProcInValue(nProc2Index, "order_qty",		_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[2]);
					dao.setProcInValue(nProc2Index, "order_qty_unit",	_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[8]);
					dao.setProcInValue(nProc2Index, "accepted_qty", 	"0");
					dao.setProcInValue(nProc2Index, "accepted_qty_unit","0");
					dao.setProcInValue(nProc2Index, "rejected_qty", 	"0");
					dao.setProcInValue(nProc2Index, "rejected_qty_unit","0");
					dao.setProcInValue(nProc2Index, "breakage_qty", 	"0");
					dao.setProcInValue(nProc2Index, "breakage_qty_unit","0");
					dao.setProcInValue(nProc2Index, "warrenty_req",		"0");
					dao.setProcInValue(nProc2Index, "installation_req",	"0");
					dao.setProcInValue(nProc2Index, "remarks",			_poDeskGenerateTransVO.getStrDRemarks());
					dao.setProcInValue(nProc2Index, "item_tax",			_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[9]);
					
					
					/* Setting Default Value Start*/
					
					dao.setProcInValue(nProc2Index, "return_qty", 		"0");
					dao.setProcInValue(nProc2Index, "return_qty_unit", 	"0");
					dao.setProcInValue(nProc2Index, "recieved_qty", 	"0");
					dao.setProcInValue(nProc2Index, "recieved_qty_unit","0");
					dao.setProcInValue(nProc2Index, "req_no", 			"0");
					dao.setProcInValue(nProc2Index, "challanNo", 		"0");
					dao.setProcInValue(nProc2Index, "raising_store",	_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[15]);
					dao.setProcInValue(nProc2Index, "po_type", 			_poDeskGenerateTransVO.getStrPOTypeId());
					//dao.setProcInValue(nProc2Index, "delivery_loc", "-",33);
					dao.setProcInValue(nProc2Index, "item_make",		_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[13]); //used as mrp
					dao.setProcInValue(nProc2Index, "itemName", 		_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#")); // PASS HIDDEN VALUE HERE
					
					dao.setProcInValue(nProc2Index, "po_date",			_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[1]);
					/* Setting Default Value End */
					dao.setProcInValue(nProc2Index, "delivery_loc",		_poDeskGenerateTransVO.getStrDDeliveryLocation());
					dao.setProcOutValue_new(nProc2Index, "err", 		1);
	
					dao.execute(nProc2Index,1);
				}
			}
			
			if(_poDeskGenerateTransVO.getStrDComponentId()!=null)
			{
				System.out.println("------ strProcName3 -----[ Mode 1 ]------"+strProcName3);
				
				for(int i=(nTmpI)*((_poDeskGenerateTransVO.getStrDComponentId().length)/(_poDeskGenerateTransVO.getStrDLstSupplierId().length)) , stopNTmp =( (_poDeskGenerateTransVO.getStrDComponentId().length)/(_poDeskGenerateTransVO.getStrDLstSupplierId().length))*(nTmpI+1); i<stopNTmp; i++)
				{
					nProc3Index = dao.setProcedure(strProcName3);
					
					dao.setProcInValue(nProc3Index, "modeval", "1");
					dao.setProcInValue(nProc3Index, "pono", strPONo);
					dao.setProcInValue(nProc3Index, "store_id", _poDeskGenerateTransVO.getStrStoreId());
					if(_poDeskGenerateTransVO.getStrDComponentValue()[i].length() >3999){
						dao.setProcInValue(nProc3Index, "comp_value1", _poDeskGenerateTransVO.getStrDComponentValue()[i].substring(0,3999));
						dao.setProcInValue(nProc3Index, "comp_value2", _poDeskGenerateTransVO.getStrDComponentValue()[i].substring(4000));
					}else{
						dao.setProcInValue(nProc3Index, "comp_value1", _poDeskGenerateTransVO.getStrDComponentValue()[i]);
						dao.setProcInValue(nProc3Index, "comp_value2", " ");
					}
					dao.setProcInValue(nProc3Index, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc3Index, "comp_id",_poDeskGenerateTransVO.getStrDComponentId()[i]);
					/*for(int i = 0 ; i< tmpPONo.length;i++)
					{
						if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0] == tmpPONo[i].replace("^","#").split("#")[1])
							dao.setProcInValue(nProc3Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],2);
					}*/
					
					//dao.setProcInValue(nProc3Index, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
					dao.setProcOutValue_new(nProc3Index, "err", 1);
		
					dao.execute(nProc3Index,1);
				}
			}
			
			//for (int i = 0; nTmpI < _poDeskGenerateTransVO.getStrDLstSupplierId().length; nTmpI++) {
			System.out.println("------ strProcName4 -----[ Mode 1 ]------"+strProcName4);
			
			nProc4Index = dao.setProcedure(strProcName4);
			dao.setProcInValue(nProc4Index, "modeval","1");
			/*for(int i = 0 ; i< tmpPONo.length;i++)
			{
				if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0].equals(tmpPONo[i].replace("^","#").split("#")[1]))
					dao.setProcInValue(nProc4Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],2);
			}*/
			dao.setProcInValue(nProc4Index, "pono",strPONo);
			dao.setProcInValue(nProc4Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
			dao.setProcInValue(nProc4Index, "item_cat",_poDeskGenerateTransVO.getStrItemCat());
			dao.setProcInValue(nProc4Index, "po_type_id",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProc4Index, "currency_id",_poDeskGenerateTransVO.getStrDCurrencyName());
			else
				dao.setProcInValue(nProc4Index, "currency_id","100",6);
			
			dao.setProcInValue(nProc4Index, "pur_source",_poDeskGenerateTransVO.getStrDPurchaseSource());
			dao.setProcInValue(nProc4Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());
			dao.setProcInValue(nProc4Index, "supplier",_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]);
			dao.setProcInValue(nProc4Index, "delevery_location",_poDeskGenerateTransVO.getStrDDeliveryLocation());
			dao.setProcInValue(nProc4Index, "tender_no",_poDeskGenerateTransVO.getStrDTenderNo());
			dao.setProcInValue(nProc4Index, "tender_date",_poDeskGenerateTransVO.getStrDTenderDate());
			dao.setProcInValue(nProc4Index, "quotation_no",_poDeskGenerateTransVO.getStrDQuotationNo());
			dao.setProcInValue(nProc4Index, "quotation_date",_poDeskGenerateTransVO.getStrDQuotationDate());
			dao.setProcInValue(nProc4Index, "net_advance",_poDeskGenerateTransVO.getStrDLstSupplierInterface()[nTmpI]);
			dao.setProcInValue(nProc4Index, "po_status","1");
			dao.setProcInValue(nProc4Index, "fin_start_date",mmsConfigUtil.getStrFinancialStartDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProc4Index, "fin_end_date",mmsConfigUtil.getStrFinancialEndDate(_poDeskGenerateTransVO
					.getStrStoreId(), _poDeskGenerateTransVO
					.getStrHospitalCode()));
			dao.setProcInValue(nProc4Index, "net_penelty","0");
			dao.setProcInValue(nProc4Index, "po_remarks",_poDeskGenerateTransVO.getStrDRemarks());
			dao.setProcInValue(nProc4Index, "cancel_flag","0");
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
				dao.setProcInValue(nProc4Index, "currency_value",_poDeskGenerateTransVO.getStrDCurrencyValue());
			else
				dao.setProcInValue(nProc4Index, "currency_value","1");
			dao.setProcInValue(nProc4Index, "waivoff","0");
			dao.setProcInValue(nProc4Index, "advance_adjusted","0");
			dao.setProcInValue(nProc4Index, "po_prefix","0");
			dao.setProcInValue(nProc4Index, "seat_id",_poDeskGenerateTransVO.getStrSeatId());
			dao.setProcInValue(nProc4Index, "paid_bill_amt","0");
			dao.setProcInValue(nProc4Index, "tax",_poDeskGenerateTransVO.getStrDOverAllTax());
			dao.setProcInValue(nProc4Index, "net_amount",_poDeskGenerateTransVO.getStrDNetAmount());
			dao.setProcInValue(nProc4Index, "issueNo","0");
			dao.setProcInValue(nProc4Index, "reqTypeId",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			dao.setProcInValue(nProc4Index, "verified_by",_poDeskGenerateTransVO.getStrVerifiedBy());
			dao.setProcInValue(nProc4Index, "verified_date",_poDeskGenerateTransVO.getStrVerifiedDate());
			dao.setProcInValue(nProc4Index, "po_ref_no",_poDeskGenerateTransVO.getStrDPORefNo());
			dao.setProcInValue(nProc4Index, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
			dao.setProcInValue(nProc4Index, "dcomments","-");
			dao.setProcInValue(nProc4Index, "dnotes","-");
			dao.setProcOutValue_new(nProc4Index, "err",1);        
			dao.execute(nProc4Index,1);
			
			
			if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("24"))
			{
				System.out.println("------ strProcName5 -----[ Mode 1 ]------"+strProcName5);
				
				//for (int nTmpI = 0; nTmpI < _poDeskGenerateTransVO.getStrDLstSupplierId().length; nTmpI++) {
				nProc5Index = dao.setProcedure(strProcName5);
				dao.setProcInValue(nProc5Index, "modeval","1");
				/*for(int i = 0 ; i< tmpPONo.length;i++)
				{
					if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0].equals(tmpPONo[i].replace("^","#").split("#")[1]))
						dao.setProcInValue(nProc5Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],2);
				}*/
				dao.setProcInValue(nProc5Index, "pono",strPONo);
				dao.setProcInValue(nProc5Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());
				dao.setProcInValue(nProc5Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
				dao.setProcInValue(nProc5Index, "supplier",_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]);
				dao.setProcInValue(nProc5Index, "agent_id",_poDeskGenerateTransVO.getStrDAgentName());
				dao.setProcInValue(nProc5Index, "ca_id",_poDeskGenerateTransVO.getStrDCAName());
				dao.setProcInValue(nProc5Index, "currency",_poDeskGenerateTransVO.getStrDCurrencyName());
				dao.setProcInValue(nProc5Index, "iac_charge",_poDeskGenerateTransVO.getStrDIACCharge());
				dao.setProcInValue(nProc5Index, "insurance_charge",_poDeskGenerateTransVO.getStrDInsuranceCharge());
				dao.setProcInValue(nProc5Index, "dumurrages_by",_poDeskGenerateTransVO.getStrDDemurrageBy());
				dao.setProcInValue(nProc5Index, "remarks",_poDeskGenerateTransVO.getStrDRemarks());
				dao.setProcInValue(nProc5Index, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
				dao.setProcOutValue_new(nProc5Index, "err",1);
				
				dao.execute(nProc5Index,1);
				}
			
			System.out.println("------ strProcName6 -----[ Mode 1 ]------"+strProcName6);
			
			nProc6Index = dao.setProcedure(strProcName6);
			dao.setProcInValue(nProc6Index, "modeval","1");
			dao.setProcInValue(nProc6Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());				
			dao.setProcInValue(nProc6Index, "pono",strPONo);
			dao.setProcInValue(nProc6Index, "schedule_no","1");
			dao.setProcInValue(nProc6Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
			dao.setProcInValue(nProc6Index, "schedule_date","");
			dao.setProcInValue(nProc6Index, "delivery_date",_poDeskGenerateTransVO.getStrDExpectedDeliveryDate()[nTmpI]);
			dao.setProcInValue(nProc6Index, "schedule_status","");
			dao.setProcInValue(nProc6Index, "penelty","");
			dao.setProcInValue(nProc6Index, "cancel_date","");
			dao.setProcInValue(nProc6Index, "cancel_by","");
			dao.setProcInValue(nProc6Index, "cancel_remarks","");
			dao.setProcInValue(nProc6Index, "delivery_loc", _poDeskGenerateTransVO.getStrDDeliveryLocation());
			dao.setProcOutValue_new(nProc6Index, "err",1);
			
			dao.execute(nProc6Index,1);
			
			System.out.println("------ strProcName7 -----[ Mode 1 ]------"+strProcName7);
			
			for (int i = 0; i < _poDeskGenerateTransVO.getStrHiddenValue().length; i++) 
			{
				if(_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[0].equals(_poDeskGenerateTransVO.getStrDLstSupplierId()[nTmpI]))
				{
					nProc7Index = dao.setProcedure(strProcName7);
					dao.setProcInValue(nProc7Index, "modeval", "1");
					/*for(int i = 0 ; i< tmpPONo.length;i++)
					{
						if(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].replace("^","#").split("#")[0].equals(tmpPONo[i].replace("^","#").split("#")[1]))
							dao.setProcInValue(nProc7Index, "pono", tmpPONo[i].replace("^","#").split("#")[0],2);
					}*/
					dao.setProcInValue(nProc7Index, "pono", strPONo);
					dao.setProcInValue(nProc7Index, "store_id", _poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc7Index, "req_no","0");
					dao.setProcInValue(nProc7Index, "raising_store_id",_poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc7Index, "item_id", _poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[6]);
					dao.setProcInValue(nProc7Index, "itembrand_id",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[7]);
					dao.setProcInValue(nProc7Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc7Index, "order_qty",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[2]);
					dao.setProcInValue(nProc7Index, "orderqty_unitid",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[8]);
					dao.setProcOutValue_new(nProc7Index, "err", 1);
	
					dao.execute(nProc7Index,1);
				}
			}
			
			 
			
			synchronized (dao) 
			{
				//if(nTmpI == (_poDeskGenerateTransVO.getStrDLstSupplierId().length-1) )
				//	dao.fire_without_commit(0, 1);
				//else
					dao.fire_without_commit(1, 0);
				//flag = true;
			}
//			if(flag)
//			{
//				//PODeskGenerateTransDAO.updateCurrStock(_poDeskGenerateTransVO,strPONo);
//			}
			}
			System.out.println("------ strProcName8 -----[ Mode 8 ]------"+strProcName8);
			
			for (int x = 0; x < _poDeskGenerateTransVO.getStrDRequestNo().length; x++)//Agenda No Loop To Update Process Qty
			{			
				for (int i = 0; i < _poDeskGenerateTransVO.getStrHiddenValue().length; i++) //Item Id Loop
				{
						nProc8Index = dao.setProcedure(strProcName8);
						dao.setProcInValue(nProc8Index, "modeval", "5");
						dao.setProcInValue(nProc8Index, "pono",strPONo);
						dao.setProcInValue(nProc8Index, "store_id", "0");
						dao.setProcInValue(nProc8Index, "item_id", _poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[6]);
						dao.setProcInValue(nProc8Index, "item_brand_id",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[7]);
						dao.setProcInValue(nProc8Index, "schedule_no", "0");
						dao.setProcInValue(nProc8Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
						dao.setProcInValue(nProc8Index, "supplier", "0");
						dao.setProcInValue(nProc8Index, "groupid", "0");
						dao.setProcInValue(nProc8Index, "subgroup_id", "0");
						dao.setProcInValue(nProc8Index, "manuf_id", "0");
						dao.setProcInValue(nProc8Index, "rate", "0");
						dao.setProcInValue(nProc8Index, "rate_unit", "0");
						dao.setProcInValue(nProc8Index, "order_qty",_poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[2]);
						dao.setProcInValue(nProc8Index, "order_qty_unit", _poDeskGenerateTransVO.getStrHiddenValue()[i].replace("^","#").split("#")[8]);
						dao.setProcInValue(nProc8Index, "accepted_qty", "0");
						dao.setProcInValue(nProc8Index, "accepted_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "rejected_qty", "0");
						dao.setProcInValue(nProc8Index, "rejected_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "breakage_qty", "0");
						dao.setProcInValue(nProc8Index, "breakage_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "warrenty_req", "0");
						dao.setProcInValue(nProc8Index, "installation_req", "0");
						dao.setProcInValue(nProc8Index, "remarks", "");
						dao.setProcInValue(nProc8Index, "item_tax", "0");
						dao.setProcInValue(nProc8Index, "return_qty", "0");
						dao.setProcInValue(nProc8Index, "return_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "recieved_qty", "0");
						dao.setProcInValue(nProc8Index, "recieved_qty_unit", "0");
						dao.setProcInValue(nProc8Index, "req_no",_poDeskGenerateTransVO.getStrDRequestNo()[x]);
						dao.setProcInValue(nProc8Index, "challanNo", "0");
						dao.setProcInValue(nProc8Index, "raising_store",_poDeskGenerateTransVO.getStrDRaisingStore()[x]);
						dao.setProcInValue(nProc8Index, "po_type",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
						dao.setProcInValue(nProc8Index, "item_make", "1");
						dao.setProcInValue(nProc8Index, "itemName", "");
						dao.setProcInValue(nProc8Index, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
						dao.setProcInValue(nProc8Index, "delivery_loc",_poDeskGenerateTransVO.getStrDDeliveryLocation());
						dao.setProcOutValue_new(nProc8Index, "err", 1);
						dao.execute(nProc8Index,1);
					}
				}
					
			System.out.println("------ strProcName9 -----[ Mode  6 ]------"+strProcName9);
			
			for (int x = 0; x < _poDeskGenerateTransVO.getStrDRequestNo().length; x++)//Agenda No Loop To Update Agenda Status
			{	
				nProc9Index = dao.setProcedure(strProcName9);
				dao.setProcInValue(nProc9Index, "modeval", "6");
				dao.setProcInValue(nProc9Index, "pono", "0");
				dao.setProcInValue(nProc9Index, "store_id", "0");
				dao.setProcInValue(nProc9Index, "item_id", "0");
				dao.setProcInValue(nProc9Index, "item_brand_id", "0");
				dao.setProcInValue(nProc9Index, "schedule_no", "0");
				dao.setProcInValue(nProc9Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
				dao.setProcInValue(nProc9Index, "supplier", "0");
				dao.setProcInValue(nProc9Index, "groupid", "0");
				dao.setProcInValue(nProc9Index, "subgroup_id", "0");
				dao.setProcInValue(nProc9Index, "manuf_id", "0");
				dao.setProcInValue(nProc9Index, "rate", "0");
				dao.setProcInValue(nProc9Index, "rate_unit", "0");
				dao.setProcInValue(nProc9Index, "order_qty", "0");
				dao.setProcInValue(nProc9Index, "order_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "accepted_qty", "0");
				dao.setProcInValue(nProc9Index, "accepted_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "rejected_qty", "0");
				dao.setProcInValue(nProc9Index, "rejected_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "breakage_qty", "0");
				dao.setProcInValue(nProc9Index, "breakage_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "warrenty_req", "0");
				dao.setProcInValue(nProc9Index, "installation_req", "0");
				dao.setProcInValue(nProc9Index, "remarks", "");
				dao.setProcInValue(nProc9Index, "item_tax", "0");
				dao.setProcInValue(nProc9Index, "return_qty", "0");
				dao.setProcInValue(nProc9Index, "return_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "recieved_qty", "0");
				dao.setProcInValue(nProc9Index, "recieved_qty_unit", "0");
				dao.setProcInValue(nProc9Index, "req_no",_poDeskGenerateTransVO.getStrDRequestNo()[x]);
				dao.setProcInValue(nProc9Index, "challanNo", "0");
				dao.setProcInValue(nProc9Index, "raising_store",_poDeskGenerateTransVO.getStrDRaisingStore()[x]);
				dao.setProcInValue(nProc9Index, "po_type",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
				dao.setProcInValue(nProc9Index, "item_make", "1");
				dao.setProcInValue(nProc9Index, "itemName", "");
				dao.setProcInValue(nProc9Index, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
				dao.setProcInValue(nProc9Index, "delivery_loc",_poDeskGenerateTransVO.getStrDDeliveryLocation());
				dao.setProcOutValue_new(nProc9Index, "err", 1);
				dao.execute(nProc9Index,1);
			}
			
			System.out.println("------ strProcName11 -----[ Mode  9 ]------"+strProcName11);
			
					nProc11Index = dao.setProcedure(strProcName11);
					dao.setProcInValue(nProc11Index, "modeval", "9");
					dao.setProcInValue(nProc11Index, "pono", _poDeskGenerateTransVO.getStrHiddenValue()[0].replace("^","#").split("#")[10]);
					dao.setProcInValue(nProc11Index, "store_id",_poDeskGenerateTransVO.getStrStoreId());
					dao.setProcInValue(nProc11Index, "item_id","0");
					dao.setProcInValue(nProc11Index, "item_brand_id","0");
					dao.setProcInValue(nProc11Index, "schedule_no", "0");
					dao.setProcInValue(nProc11Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode());
					dao.setProcInValue(nProc11Index, "supplier","0");
					dao.setProcInValue(nProc11Index, "groupid","0");
					dao.setProcInValue(nProc11Index, "subgroup_id","0");
					dao.setProcInValue(nProc11Index, "manuf_id","0");  //temporarily used to pass seat_id
					dao.setProcInValue(nProc11Index, "rate","0");
					dao.setProcInValue(nProc11Index, "rate_unit","0");
					dao.setProcInValue(nProc11Index, "order_qty", "0");
					dao.setProcInValue(nProc11Index, "order_qty_unit", "0");
					dao.setProcInValue(nProc11Index, "accepted_qty", "0");
					dao.setProcInValue(nProc11Index, "accepted_qty_unit", "0");
					dao.setProcInValue(nProc11Index, "rejected_qty", "0");
					dao.setProcInValue(nProc11Index, "rejected_qty_unit", "0");
					dao.setProcInValue(nProc11Index, "breakage_qty", "0");
					dao.setProcInValue(nProc11Index, "breakage_qty_unit", "0");
					dao.setProcInValue(nProc11Index, "warrenty_req","0");
					dao.setProcInValue(nProc11Index, "installation_req","0");
					dao.setProcInValue(nProc11Index, "remarks","0");
					dao.setProcInValue(nProc11Index, "item_tax","0");
					dao.setProcInValue(nProc11Index, "return_qty", "0");
					dao.setProcInValue(nProc11Index, "return_qty_unit", "0");
					dao.setProcInValue(nProc11Index, "recieved_qty", "0");
					dao.setProcInValue(nProc11Index, "recieved_qty_unit", "0");
					dao.setProcInValue(nProc11Index, "req_no", "0");
					dao.setProcInValue(nProc11Index, "challanNo", "0");
					dao.setProcInValue(nProc11Index, "raising_store", "0");
					dao.setProcInValue(nProc11Index, "po_type", "0");
					dao.setProcInValue(nProc11Index, "item_make","0");  //temporarily used to pass itemCatNo
					dao.setProcInValue(nProc11Index, "itemName", "");
					dao.setProcInValue(nProc11Index, "po_date",_poDeskGenerateTransVO.getStrDPORefDate());
					dao.setProcInValue(nProc11Index, "delivery_loc",_poDeskGenerateTransVO.getStrDDeliveryLocation());
					dao.setProcOutValue_new(nProc11Index, "err", 1);
					dao.execute(nProc11Index,1);
					
					
					synchronized (dao) 
					{
						//if(nTmpI == (_poDeskGenerateTransVO.getStrDLstSupplierId().length-1) )
						_poDeskGenerateTransVO.setStrMsgType("2");
							dao.fire_without_commit(0, 1);
						//else
							//dao.fire_without_commit(1, 0);
						//flag = true;
					}
					
			if (strErr != null && !strErr.equals(""))
				throw new Exception(strErr);
			else
			{
				/*
				if(!_poDeskGenerateTransVO.getStrItemCat().equals("21"))
				{
					SMSHttpsNICPostClient sms=new SMSHttpsNICPostClient();
					for(int i=0;i<_poDeskGenerateTransVO.getStrDLstSupplierId().length;i++)
				
					{
						sms.sendTextSMSThroughNICSMSGateway("", "", "", "", _poDeskGenerateTransVO.getStrDPhoneEmail()[i].replace("^", "#").split("#")[0], "Po placed with PO No : "+ potmpno[i]);
						sms.sendEmail(_poDeskGenerateTransVO.getStrDPhoneEmail()[i].replace("^", "#").split("#")[1],"PO Placed","Po placed with PO No : "+ potmpno[i]);
					}
				}
				*/
			}
			_poDeskGenerateTransVO.setStrPoNo(strPONo);	
			_poDeskGenerateTransVO.setStrMsgType("2");

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.insert() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	public static void updateCurrStock(PODeskGenerateTransVO vo,String strPONo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nProcIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try 
		{
			dao = new HisDAO("mms", "PODeskGenerateTransDAO");
			strproc_name = "{call PKG_MMS_DML.dml_update_po_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	//not found in(ggs/phdm DB)					
			nProcIndex = dao.setProcedure(strproc_name);						
			dao.setProcInValue(nProcIndex, "modeval","1");
			dao.setProcInValue(nProcIndex, "pono",strPONo);
			dao.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "item_cat",vo.getStrItemCat());
			dao.setProcInValue(nProcIndex, "po_type_id",vo.getStrPOTypeId().substring(0,2));
			dao.setProcInValue(nProcIndex, "pur_source",vo.getStrDPurchaseSource());
			dao.setProcInValue(nProcIndex, "store_id",vo.getStrStoreId());
			dao.setProcInValue(nProcIndex, "supplier",vo.getStrSupplierId().replace("^", "#").split("#")[0]);
			dao.setProcInValue(nProcIndex, "delevery_location",vo.getStrDDeliveryLocation());
			dao.setProcInValue(nProcIndex, "tender_no",vo.getStrDTenderNo());
			dao.setProcInValue(nProcIndex, "tender_date",vo.getStrDTenderDate());
			dao.setProcInValue(nProcIndex, "quotation_no",vo.getStrDQuotationNo());
			dao.setProcInValue(nProcIndex, "quotation_date",vo.getStrDQuotationDate());
			dao.setProcInValue(nProcIndex, "fin_start_date","");
			dao.setProcInValue(nProcIndex, "fin_end_date","");
			dao.setProcInValue(nProcIndex, "po_remarks",vo.getStrDRemarks());
			dao.setProcInValue(nProcIndex, "currency_value","1");
			dao.setProcInValue(nProcIndex, "currency_id","100");
			dao.setProcInValue(nProcIndex, "seat_id",vo.getStrSeatId());
			dao.setProcInValue(nProcIndex, "tax",vo.getStrIndianImportedFlg());
			dao.setProcInValue(nProcIndex, "net_amount",vo.getStrDNetAmount());
			dao.setProcInValue(nProcIndex, "verified_by",vo.getStrVerifiedBy());
			dao.setProcInValue(nProcIndex, "verified_date",vo.getStrVerifiedDate());			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "schedule_no","0");
			dao.setProcInValue(nProcIndex, "ipAddr","");
			/* Setting Default Value End */			
			dao.executeProcedure(nProcIndex);
			strerr = dao.getString(nProcIndex, "err");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("PODeskGenerateTransDAO.updateCurrStock() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public synchronized static void approvedPO(PODeskGenerateTransVO _poDeskGenerateTransVO) 
	{
		String strProcName1 = "{call PKG_MMS_DML.Update_PO_Approval(?,?,?,?,?,?,?,?,?,?,?,?)}";// 7 // Variables
		HisDAO dao = null;
		int nProcIndex = 0;
		int nProcIndex1 = 0;
        int  scheduleNo = 1; 
		String strErr = "";
		String strPONo = "";
		boolean flag = false;	
		try 
		{
			dao = new HisDAO("MMS",	"transactions.PODeskGenerateTransDAO.insert()");
			
			for(int i=0;i<_poDeskGenerateTransVO.getStrQrderQty().length;i++)
			{
				//System.out.println("_poDeskGenerateTransVO.getStrQrderQty()[0]"+_poDeskGenerateTransVO.getStrQrderQty()[i]);
				nProcIndex1 = dao.setProcedure(strProcName1);
				dao.setProcInValue(nProcIndex1, "modeval", "1",1); // 1
				dao.setProcInValue(nProcIndex1, "pono", _poDeskGenerateTransVO.getStrPONo(),2); // 2
				dao.setProcInValue(nProcIndex1, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode(),3); // 3		
				dao.setProcInValue(nProcIndex1,  "po_store_id",_poDeskGenerateTransVO.getStrStoreId(),6);// 4
				dao.setProcInValue(nProcIndex1, "verified_by",_poDeskGenerateTransVO.getStrVerifiedBy(),4);// 5
				dao.setProcInValue(nProcIndex1, "verified_date",_poDeskGenerateTransVO.getStrVerifiedDate(),5);// 6
				dao.setProcInValue(nProcIndex1, "OrderQty",_poDeskGenerateTransVO.getStrQrderQty()[i] ,7);// 6
				dao.setProcInValue(nProcIndex1, "POValue",_poDeskGenerateTransVO.getStrTotalPOCost(),8);// 6
				if(_poDeskGenerateTransVO.getStrApprovalType().equals("1"))
				
				dao.setProcInValue(nProcIndex1, "isReject","0",9);// 6 // Approval
				else
				dao.setProcInValue(nProcIndex1, "isReject","1",9);// 6	 //Rejection
				
				dao.setProcInValue(nProcIndex1, "itemid",_poDeskGenerateTransVO.getStrPOHiddenVal()[i].replace("^","#").split("#")[0] ,10);// 6
				dao.setProcInValue(nProcIndex1, "brandid",_poDeskGenerateTransVO.getStrPOHiddenVal()[i].replace("^","#").split("#")[1],11);// 6
				dao.setProcOutValue(nProcIndex1, "err", 1,12); // 7
				dao.executeProcedureByPosition(nProcIndex1);
			}
			//dao.fire();
			flag = true;

			if (strErr != null && !strErr.equals(""))
			{	
			    flag = false;
				throw new Exception(strErr);
			}				
			if(flag)
			{
				_poDeskGenerateTransVO.setStrMobileMsgMode("2");
				//PODeskGenerateTransDAO.getMobileMsgDtl(_poDeskGenerateTransVO);
			}

		}
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.approvedPO() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		}
		finally
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getDWHList(PODeskGenerateTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_req_list_for_po(?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("mms", "ListOfConsigneeRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			 
			//System.out.println(voObj.getStrMode());
			//System.out.println("modeval"+voObj.getStrMode());
			//System.out.println("hosp_code"+ voObj.getStrHospitalCode());
			//System.out.println("store_id"+ voObj.getStrStoreId());
			//System.out.println("item_id"+ voObj.getStrItemId());
			//System.out.println("brandId"+ voObj.getStrItemBrandIds());
			//System.out.println("po_type_id"+ voObj.getStrPOTypeId().substring(0,2));
			//System.out.println("supp_id"+voObj.getStrSupplierId());
			//System.out.println("finStartDate"+voObj.getStrFinancialStartDate());
			//System.out.println("finEndDate"+voObj.getStrFinancialToDate());
			
			
			
			
			
			
			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode(),1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "item_id", voObj.getStrItemId(),4);
			daoObj.setProcInValue(nProcIndex, "brandId", voObj.getStrItemBrandIds(),5);
			daoObj.setProcInValue(nProcIndex, "po_type_id", voObj.getStrPOTypeId().substring(0,2),6);
			daoObj.setProcInValue(nProcIndex, "supp_id", voObj.getStrSupplierId(),7);
			daoObj.setProcInValue(nProcIndex, "finStartDate", voObj.getStrFinancialStartDate(),8);
			daoObj.setProcInValue(nProcIndex, "finEndDate", voObj.getStrFinancialToDate(),9);
			daoObj.setProcOutValue(nProcIndex, "err", 1,10);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,11);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
               //    //System.out.println("Here size ws is ::"+ws.size());
				if (ws != null && ws.size() > 0) {
					voObj.setWbsReqListPO(ws);
				}

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			e.printStackTrace();
			voObj.setStrMsgString("ListOfConsigneeRptDAO.getDWHList() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	/*
	 * This Function is used to get Item Category Name by Passing 2 variable a)
	 * Hospital Code b) Item Category
	 */

	public static void getcallingItemCat(PODeskGenerateTransVO vo) {

		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		// Split the Value

		try {
			dao = new HisDAO("MMSModule", "IndentDeskCondemnationReqTransDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_itemcat_dtl(?,?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrItemCatNo());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);

			if (retVal != null) {
				vo.setStrItemCatName(retVal);
			} else {
				retVal = "-----";
				vo.setStrItemCatName(retVal);
			}

		} catch (Exception e) {
			vo.setStrMsgString("IndentDeskCondemnationReqTransDAO.callingItemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/*
	 * This Function is used to get Item Category Name by Passing 2 variable a)
	 * Hospital Code b) Item Category
	 */

	public static void getcallingPOType(PODeskGenerateTransVO vo) {

		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		// Split the Value

		try {
			dao = new HisDAO("MMSModule", "IndentDeskCondemnationReqTransDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_indenttype_name(?,?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrPOTypeId().substring(0,2));
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);

			if (retVal != null) {
				vo.setStrPOType(retVal);
			} else {
				retVal = "-----";
				vo.setStrPOType(retVal);
			}

		} catch (Exception e) {
			vo.setStrMsgString("IndentDeskCondemnationReqTransDAO.callingItemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getSupplierWiseCompiledData(PODeskGenerateTransVO _poDeskGenerateTransVO) 
	{
		
		System.out.println("----------- PODeskGenerateTransDAO.getSupplierWiseCompiledData  -----------");
	
		String strProcName  = "{call PKG_MMS_DML.dml_tmp_po_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?)}";	
		String strProcName1  = "{call PKG_MMS_VIEW.proc_tmp_po_dtl(?,?,?,?,?)}";
		WebRowSet ws = null;
		// NULL::character varying,po_status character varying DEFAULT NULL::character varying, OUT err character varying) IS
		HisDAO dao = null;

		int nProcIndex = 0;
		int nProc1Index = 0;
		
		String strErr = "";
		String strPONo = "";
		boolean flag = false;
		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.insert()");

			strPONo = getTmpPONo(_poDeskGenerateTransVO);
			
			System.out.println("----------- PKG_MMS_DML.dml_tmp_po_dtl---[ Mode 1 ]--INSERT INTO hstt_po_supp_wise_temp_dtl--");
			
			for(int i=0;i<_poDeskGenerateTransVO.getStrSupplierId().split(",").length;i++)
			{
				////System.out.println("_poDeskGenerateTransVO.getStrSupplierId().split(,)[i]"+_poDeskGenerateTransVO.getStrSupplierId().split(",")[i]);
				if(_poDeskGenerateTransVO.getStrSupplierId().split(",")[i] != null && !_poDeskGenerateTransVO.getStrSupplierId().split(",")[i].equals("null") && !(_poDeskGenerateTransVO.getStrSupplierId().split(",")[i].equalsIgnoreCase("[null")))
				{
					nProcIndex = dao.setProcedure(strProcName);
					
					dao.setProcInValue(nProcIndex, "modeval","1",1);
					dao.setProcInValue(nProcIndex, "pono",strPONo,2);
					dao.setProcInValue(nProcIndex, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode(),3);
					dao.setProcInValue(nProcIndex, "item_cat",_poDeskGenerateTransVO.getStrItemCat(),4);
					dao.setProcInValue(nProcIndex, "item_id",_poDeskGenerateTransVO.getStrSupplierId().split(",")[i].replace("^", "#").split("#")[1].replace("[", "").replace('"', ' ').replace("]", "").trim(),5);
					dao.setProcInValue(nProcIndex, "brand_id",_poDeskGenerateTransVO.getStrSupplierId().split(",")[i].replace("^", "#").split("#")[2].replace("[", "").replace('"', ' ').replace("]", "").trim(),6);
					dao.setProcInValue(nProcIndex, "tot_po_qty",_poDeskGenerateTransVO.getStrSupplierId().split(",")[i].replace("^", "#").split("#")[3].replace("[", "").replace('"', ' ').replace("]", "").trim(),7);
					dao.setProcInValue(nProcIndex, "po_type",_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2),8);
					dao.setProcInValue(nProcIndex, "store_id",_poDeskGenerateTransVO.getStrStoreId(),9);
					dao.setProcInValue(nProcIndex, "supplier",_poDeskGenerateTransVO.getStrSupplierId().split(",")[i].replace("^", "#").split("#")[0].replace("[", "").replace('"', ' ').replace("]", "").trim(),10);
					dao.setProcInValue(nProcIndex, "po_qty",_poDeskGenerateTransVO.getStrDOrderQty()[i].replace("^", "#").split("#")[0].replace("[", "").replace('"', ' ').replace("]", "").trim(),11);
					dao.setProcInValue(nProcIndex, "po_qty_unit",_poDeskGenerateTransVO.getStrDOrderQtyUnitId()[i].replace("^", "#").split("#")[0].replace("[", "").replace('"', ' ').replace("]", "").trim(),12);
					dao.setProcInValue(nProcIndex, "rate",_poDeskGenerateTransVO.getStrDRate()[i].replace("^", "#").split("#")[0].replace("[", "").replace('"', ' ').replace("]", "").trim(),13);
					dao.setProcInValue(nProcIndex, "tot_rate",_poDeskGenerateTransVO.getStrRateUnitValues().split(",")[i].replace("^", "#").split("#")[0].replace("[", "").replace('"', ' ').replace("]", "").trim(),14);
					dao.setProcInValue(nProcIndex, "po_status","0",15);
					dao.setProcInValue(nProcIndex, "tax",_poDeskGenerateTransVO.getStrDTax()[i].replace("^", "#").split("#")[0].replace("[", "").replace('"', ' ').replace("]", "").trim(),16);
					dao.setProcInValue(nProcIndex, "fromdt","",17);
					dao.setProcInValue(nProcIndex, "todt","",18);
					if(_poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("22"))
							dao.setProcInValue(nProcIndex, "mrp",_poDeskGenerateTransVO.getStrDMRP()[i].replace("[", "").replace('"', ' ').replace("]", "").trim(),19);
					else
							dao.setProcInValue(nProcIndex, "mrp","0",19);
					dao.setProcInValue(nProcIndex, "pack",_poDeskGenerateTransVO.getStrDPackSize()[i].replace("[", "").replace('"', ' ').replace("]", "").trim(),20);
					dao.setProcOutValue(nProcIndex, "err",1,21);        
					
					dao.execute(nProcIndex,1);
				}
			}
			synchronized (dao) 
			{
				dao.fire();
				flag = true;
			}
			if(flag)
			{
				System.out.println("------------------- PKG_MMS_VIEW.proc_tmp_po_dtl -[ Mode - 1 ]----------------------");
				
				nProc1Index = dao.setProcedure(strProcName1);

				dao.setProcInValue(nProc1Index, "modeval","1",1);
				dao.setProcInValue(nProc1Index, "pono",strPONo,2);
				dao.setProcInValue(nProc1Index, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode(),3);
				dao.setProcOutValue(nProc1Index, "err",1,4); 
				dao.setProcOutValue(nProc1Index, "resultset",2,5); 
				
				dao.executeProcedureByPosition(nProc1Index);
				
				strErr = dao.getString(nProc1Index, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = dao.getWebRowSet(nProc1Index, "resultset");
	               //    //System.out.println("Here size ws is ::"+ws.size());
					if (ws != null && ws.size() > 0) {
						_poDeskGenerateTransVO.setWbTmpPoDtl(ws);
						_poDeskGenerateTransVO.setTmpPONO(strPONo);
					}

				} else {
					throw new Exception(strErr);
				}
			}

			if (strErr != null && !strErr.equals(""))
				throw new Exception(strErr);

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getSupplierWiseCompiledData() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getOtherData(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strProcName  = "{call PKG_MMS_VIEW.proc_other_details_bulk_po(?,?,?,?,?, ?,?,?,?,?)}";	
		WebRowSet ws = null;
		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";
		try {
			dao = new HisDAO("MMS",	"transactions.PODeskGenerateTransDAO.getotherdata()");
					nProcIndex = dao.setProcedure(strProcName);
					dao.setProcInValue(nProcIndex, "modeval","1",1);
					dao.setProcInValue(nProcIndex, "storeid",_poDeskGenerateTransVO.getStrStoreId(),2);
					dao.setProcInValue(nProcIndex, "hosp_code",_poDeskGenerateTransVO.getStrHospitalCode(),3);
					dao.setProcInValue(nProcIndex, "cat",_poDeskGenerateTransVO.getStrItemCat(),4);
					dao.setProcInValue(nProcIndex, "brandid",_poDeskGenerateTransVO.getStrItemBrandIds().replace("[", "").replace('"', ' ').replace("]", "").trim(),5);
					dao.setProcInValue(nProcIndex, "fromdate",_poDeskGenerateTransVO.getStrFromDate(),6);
					dao.setProcInValue(nProcIndex, "todate",_poDeskGenerateTransVO.getStrToDate(),7);
					dao.setProcInValue(nProcIndex, "tmppo",_poDeskGenerateTransVO.getTmpPONO(),8);
					dao.setProcOutValue(nProcIndex, "err",1,9);        
					dao.setProcOutValue(nProcIndex, "resultset",2,10);  
					dao.executeProcedureByPosition(nProcIndex);
					strErr = dao.getString(nProcIndex, "err");
					if (strErr == null)
						strErr = "";
				if (strErr.equals("")) {
					ws = dao.getWebRowSet(nProcIndex, "resultset");
	               //    //System.out.println("Here size ws is ::"+ws.size());
				//	if (ws != null && ws.size() > 0) {
						_poDeskGenerateTransVO.setWbOtherDtl(ws);
					//}

				} else {
					throw new Exception(strErr);
				}

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getSupplierWiseCompiledData() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static String getTmpPONo(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strProcName = "{? = call MMS_MST.generate_tmp_pono(?,?,?)}";
		HisDAO dao = null;

		int funcIndex = 0;
		String strPONo = "";

		try 
		{
			
			System.out.println("----------- PODeskGenerateTransDAO . getTmpPONo -----[ MMS_MST.generate_tmp_pono ]------");
			
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getTmpPONo()");

			funcIndex = dao.setFunction(strProcName);

			dao.setFuncInValue(funcIndex, 2, _poDeskGenerateTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3, _poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			dao.setFuncInValue(funcIndex, 4, _poDeskGenerateTransVO.getStrItemCat());
			dao.setFuncOutValue(funcIndex, 1);

			dao.executeFunction(funcIndex);
			strPONo = dao.getFuncString(funcIndex);

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getTmpPONo() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return strPONo;
	}
	
	public static void indentDetail(
			PODeskGenerateTransVO _poDeskGenerateTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_indent_item_dtls(?,?,?,? ,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.wbIndentItemDetail()");
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskGenerateTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "indentno", _poDeskGenerateTransVO.getStrRequestId(),3);
			dao.setProcInValue(nProcIndex, "frmstoreid", _poDeskGenerateTransVO.getStrStoreId(),4);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			if (strErr == null || strErr.equals("")) {
				_poDeskGenerateTransVO.setWbIndentItemDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.getRequestItemDetails() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	
	public static void finalsave(PODeskGenerateTransVO _poDeskGenerateTransVO) 
	{
		
		int nProcIdx = 0;
		HisDAO dao = null;		
		String strErr = "";
		String[] tmpPo=new String[_poDeskGenerateTransVO.getStrDPhoneEmail().length];
		int j=0,k=0;
		String tmppono="0";
		try 
		{	
			System.out.println("-- PODeskGenerateTransDAO.finalsave --- PKG_MMS_DML.dml_draft_po_save--[ Mode - 1 ]---");
			
			dao = new HisDAO("MMS","transactions.PODeskGenerateTransDAO.finalsave()");			
			String strProc = "{call PKG_MMS_DML.dml_draft_po_save(?,?,?,?,?  ,?,?,?,?)}";
			for (int nTmpI = 0; nTmpI < _poDeskGenerateTransVO.getStrDitemBrandId().length; nTmpI++) 
			{
				
				nProcIdx = dao.setProcedure(strProc);
				dao.setProcInValue(nProcIdx, "modval",		"1",1);
				dao.setProcInValue(nProcIdx, "hosp_code",	_poDeskGenerateTransVO.getStrHospitalCode(),2);
				dao.setProcInValue(nProcIdx, "storeid",		_poDeskGenerateTransVO.getStrStoreId(),3);
				dao.setProcInValue(nProcIdx, "pono",		_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].split("#")[6],4);
				dao.setProcInValue(nProcIdx, "brandid",		_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].split("#")[1],5);
				dao.setProcInValue(nProcIdx, "qty",			_poDeskGenerateTransVO.getStrDOrderQty()[nTmpI],6);
				if(!tmppono.equals(_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].split("#")[6]))
				{
					dao.setProcInValue(nProcIdx, "notes",	_poDeskGenerateTransVO.getStrDFinalNotes()[k++],7);
				}
				else
				{
					dao.setProcInValue(nProcIdx, "notes",	_poDeskGenerateTransVO.getStrDFinalNotes()[k-1],7);
				}	
				dao.setProcInValue(nProcIdx,  "seatId",		_poDeskGenerateTransVO.getStrSeatId(),8);
				dao.setProcOutValue(nProcIdx, "err",		1,9);        
				
				dao.execute(nProcIdx,1);
				tmppono = _poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].split("#")[6];
				
				if(j==0)
					tmpPo[j]=_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].split("#")[6];
				else
					if(tmpPo[j-1] != _poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].split("#")[6])
						tmpPo[j]=_poDeskGenerateTransVO.getStrHiddenValue()[nTmpI].split("#")[6];
				
				j++;
			}
			
			synchronized (dao) 
			{
				_poDeskGenerateTransVO.setStrMsgType("2");
				String[] unique = new HashSet<String>(Arrays.asList(tmpPo)).toArray(new String[0]);
				_poDeskGenerateTransVO.setStrPONoDisplay(Arrays.toString(unique).replaceAll("[\\[.\\].\\s+]", ""));
					dao.fire();
			}			
			if (strErr != null && !strErr.equals(""))
				throw new Exception(strErr);
			
		} catch (Exception _Err) {
			_Err.printStackTrace();
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransDAO.finalsave() --> "
							+ _Err.getMessage());
			_poDeskGenerateTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
}
