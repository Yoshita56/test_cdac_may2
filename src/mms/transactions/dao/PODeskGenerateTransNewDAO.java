/**
 * 
 */
package mms.transactions.dao;

import java.util.Calendar;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.vo.PODeskGenerateTransNewVO;
import mms.transactions.vo.RequestForLPPatientVO;

/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskGenerateTransNewDAO {

	public static void getPODetails(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Po_Details(?,?,?,?,?,?)}"; // 6
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS","transactions.PODeskGenerateTransNewDAO.getPODetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "4",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "pono", _PODeskGenerateTransNewVO.getStrPONo(),3);
			dao.setProcInValue(nProcIndex, "storeId", _PODeskGenerateTransNewVO.getStrStoreId(),4);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				wsResult.next();
				_PODeskGenerateTransNewVO.setStrPODate(wsResult.getString(1));
				_PODeskGenerateTransNewVO.setStrSupplierName(wsResult.getString(2));
				_PODeskGenerateTransNewVO.setStrPOType(wsResult.getString(3));
				_PODeskGenerateTransNewVO.setStrSupplierId(wsResult.getString(7));
				_PODeskGenerateTransNewVO.setStrPOTypeId(wsResult.getString(8));
				_PODeskGenerateTransNewVO.setStrItemCat(wsResult.getString(11));
				_PODeskGenerateTransNewVO.setStrItemCatName(wsResult.getString(12));
				_PODeskGenerateTransNewVO.setStrTotalPOCost(wsResult.getString(6));
				// //System.out.println("Qu No:::"+wsResult.getString(24));
				// PO_DATE ^ SUPP NAME ^ PO TYPE ^ CURRENCY CODE ^ NET ADVANCE ^
				// PO NET AMOUNT ^ SUPPLIER ID ^ PO Type ^ Currency Id ^
				// Currency Value ^ Item Catg No ^ Catg Name ^ Purchase Source
				// ID ^ Purchase Source Name ^ Currency Id ^ Currency Value ^
				// Advance Amt ^ PO Prefix With PO No ^ Delivery Date ^ PO
				// PreFix ^ TAX ^ Tender No ^ Tender Date ^ Qutation No ^
				// Qutation Date ^ PO Date ^ Verify Date ^ Verify By ^ (29)
				// Financial Start Date ^ (30) Financial End Date
				_PODeskGenerateTransNewVO.setStrPOHiddenValue(wsResult
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
						+ wsResult.getString(31)
						+ "^"
						+ wsResult.getString(32)
						+ "^"
						+ wsResult.getString(33)
						+ "^"
						+ wsResult.getString(34)
						+ "^"
						+ wsResult.getString(35));
			
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.getPODetails() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void getPOItemDetails(
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Po_Details(?,?,?,?,?,?)}"; // 6
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.getPODetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "5",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "pono", _PODeskGenerateTransNewVO.getStrPONo(),3);
			dao.setProcInValue(nProcIndex, "storeId", _PODeskGenerateTransNewVO.getStrStoreId(),4);
			dao.setProcOutValue(nProcIndex, "err", 1,4);
			dao.setProcOutValue(nProcIndex, "resultset", 2,5);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				wsResult.next();
				_PODeskGenerateTransNewVO.setStrItemId(wsResult.getString(1));
				_PODeskGenerateTransNewVO
						.setStrItemBrandIds(wsResult.getString(2));
				_PODeskGenerateTransNewVO.setStrItemRate(wsResult.getString(3));
				_PODeskGenerateTransNewVO.setStrItemRateUnitId(wsResult
						.getString(4));
				_PODeskGenerateTransNewVO.setStrItemManufacturerId(wsResult
						.getString(5));
				_PODeskGenerateTransNewVO.setStrDemandYear(wsResult.getString(6));
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.getPODetails() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		String strproc_name = "{call pkg_mms_view.proc_item_category_list(?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS","transactions.PODeskGenerateTransNewDAO.setItemCatValues()");
			dao = new HisDAO("MMS","transactions.PODeskGenerateTransNewDAO.setItemCatValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex, "store_id", _PODeskGenerateTransNewVO.getStrStoreId(),2);
			dao.setProcInValue(nProcIndex, "reqType", "0",4); // Default Value
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_PODeskGenerateTransNewVO.setStrItemCatValues(util.getOptionValue(
						wsResult, "0", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.setItemCatValues() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
	public static void getPOPrefixCmb(
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		String strproc_name = "{call pkg_mms_view.proc_POPrefix_list(?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransNewDAO.setPOPrefixCmb()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.getPOPrefixCmb()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))

				_PODeskGenerateTransNewVO
						.setStrPoRefrenceNoCmb(util.getOptionValue(wsResult,
								"0", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.setPOPrefixCmb() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		String strproc_name = "{call pkg_mms_view.proc_POPrefix_list(?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransNewDAO.setPOPrefixCmb()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.getPOPrefixCmb()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
			{
				String strPrefix = _PODeskGenerateTransNewVO.getStrPoRefrenceNo();
								
				int intStrLen = strPrefix.length();
				int intEndIndex = strPrefix.lastIndexOf("/");
				strPrefix = strPrefix.substring(0,intEndIndex);
				
				intStrLen = strPrefix.length();
				intEndIndex = strPrefix.lastIndexOf("/");
				strPrefix = strPrefix.substring(0,intEndIndex);
				
				//System.out.println("strPrefix = "+strPrefix);
				//System.out.println("intIndex = "+intEndIndex);
				
				_PODeskGenerateTransNewVO
						.setStrPoRefrenceNoCmb(util.getOptionValue(wsResult,
								strPrefix,
								"0^Select Value", false,true));
			}
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.setPOPrefixCmb() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Sstt_indenttype_Dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransNewDAO.setItemCatValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.setItemCatValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "req_for", "1",3);
			dao.setProcInValue(nProcIndex, "item_cat", _PODeskGenerateTransNewVO.getStrItemCat(),4);
			dao.setProcInValue(nProcIndex, "store_id", _PODeskGenerateTransNewVO.getStrStoreId(),5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_PODeskGenerateTransNewVO.setStrPOTypeValues(util.getOptionValue(
						wsResult, "", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.setPOTypeValues() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {

		String strproc_name = "{call pkg_mms_view.Proc_Supplier_List(?,?,?,?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransNewDAO.setSupplierValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.setSupplierValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			 //System.out.println("Contract Type:::"+_PODeskGenerateTransNewVO.getStrContractType());
			if (!_PODeskGenerateTransNewVO.getStrContractType().equals(""))
				dao.setProcInValue(nProcIndex, "modeval", "7",1);
			else
			dao.setProcInValue(nProcIndex, "modeval", "5",1);
		
			/*//System.out.println("modeval"+"5");
			//System.out.println("catCode"+_PODeskGenerateTransNewVO.getStrItemCat());
			//System.out.println("branditem_id"+ "0");// default value
			//System.out.println("contractType"+_PODeskGenerateTransNewVO.getStrContractType());
			//System.out.println("hosp_code"+ _PODeskGenerateTransNewVO.getStrHospitalCode());
			*/
			
			
			dao.setProcInValue(nProcIndex, "catCode", _PODeskGenerateTransNewVO.getStrItemCat(),2);
			dao.setProcInValue(nProcIndex, "branditem_id", "0",3);// default value
			dao.setProcInValue(nProcIndex, "contractType",_PODeskGenerateTransNewVO.getStrContractType(),4);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
		//System.out.println("Size is==>"+wsResult.size());
			_PODeskGenerateTransNewVO.setStrHlpSize(wsResult.size());

			if (strErr == null || strErr.equals(""))
				_PODeskGenerateTransNewVO.setStrSupplierValues(util
						.getOptionValue(wsResult, "", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.setSupplierValues() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {

		String strproc_name = "{call pkg_mms_view.Proc_sstt_purchase_source_mst(?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransNewDAO.setPurchaseSourceValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.setPurchaseSourceValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_PODeskGenerateTransNewVO.setStrPurchaseSourceValues(util
						.getOptionValue(wsResult, _PODeskGenerateTransNewVO
								.getStrPurchaseSourceId(), "0^Select Value",
								false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.setPurchaseSourceValues() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {

		String strproc_name = "{call pkg_mms_view.proc_item_list_for_po(?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?)}"; // 10
																								// Variables

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;
		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransNewDAO.getPOItemList()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.getPOItemList()");

			nProcIndex = dao.setProcedure(strproc_name);
			// //System.out.println("Hosp
			// Code:::"+_PODeskGenerateTransNewVO.getStrHospitalCode());
			// //System.out.println("catCode:::"+_PODeskGenerateTransNewVO.getStrItemCat());
			// //System.out.println("po_store_id:::"+_PODeskGenerateTransNewVO.getStrStoreId());
			// //System.out.println("startDate:::"+_PODeskGenerateTransNewVO.getStrFinancialStartDate());
			// //System.out.println("endDate:::"+_PODeskGenerateTransNewVO.getStrFinancialToDate());

			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "catCode", _PODeskGenerateTransNewVO.getStrPONo(),3);
			dao.setProcInValue(nProcIndex, "po_store_id",_PODeskGenerateTransNewVO.getStrStoreId(),4);
			dao.setProcInValue(nProcIndex, "startDate", _PODeskGenerateTransNewVO.getStrFinancialStartDate(),5);
			dao.setProcInValue(nProcIndex, "endDate", _PODeskGenerateTransNewVO.getStrFinancialToDate(),6);

			dao.setProcInValue(nProcIndex, "suppId", "0",7);
			dao.setProcInValue(nProcIndex, "poRefDate", "0",8);

			dao.setProcOutValue(nProcIndex, "err", 1,9);
			dao.setProcOutValue(nProcIndex, "resultset", 2,10);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_PODeskGenerateTransNewVO.setStrPOItemCmb(util.getOptionValue(
						wsResult, "0", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.getPOItemList() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void getPOItemList(
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {

		String strproc_name = "{call pkg_mms_view.proc_item_list_for_po(?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?)}"; // 10
																								// Variables

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wsResult = null;
		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransNewDAO.getPOItemList()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.getPOItemList()");

			nProcIndex = dao.setProcedure(strproc_name);
			//System.out.println("Hosp Code:::"+ _PODeskGenerateTransNewVO.getStrHospitalCode());
			//System.out.println("catCode:::"	+ _PODeskGenerateTransNewVO.getStrItemCat());
			//System.out.println("po_store_id:::"	+ _PODeskGenerateTransNewVO.getStrStoreId());
			//System.out.println("startDate:::"+ _PODeskGenerateTransNewVO.getStrFinancialStartDate());
			//System.out.println("endDate:::"	+ _PODeskGenerateTransNewVO.getStrFinancialToDate());
			//System.out.println("Supplier ID==>"	+ _PODeskGenerateTransNewVO.getStrSupplierId());
			//System.out.println("PO ref Date==>"	+ _PODeskGenerateTransNewVO.getStrPORefrenceDate());
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "catCode", _PODeskGenerateTransNewVO.getStrItemCat(),3);
			dao.setProcInValue(nProcIndex, "po_store_id",_PODeskGenerateTransNewVO.getStrStoreId(),4);
			dao.setProcInValue(nProcIndex, "startDate", _PODeskGenerateTransNewVO.getStrFinancialStartDate(),5);
			dao.setProcInValue(nProcIndex, "endDate", _PODeskGenerateTransNewVO.getStrFinancialToDate(),6);

			dao.setProcInValue(nProcIndex, "suppId", _PODeskGenerateTransNewVO	.getStrSupplierId(),7);
			dao.setProcInValue(nProcIndex, "poRefDate", _PODeskGenerateTransNewVO.getStrPORefrenceDate(),8);

			dao.setProcOutValue(nProcIndex, "err", 1,9);
			dao.setProcOutValue(nProcIndex, "resultset", 2,10);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_PODeskGenerateTransNewVO.setStrPOItemCmb(util.getOptionValue(
						wsResult, "0", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.getPOItemList() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}
	
	public static void getPOItemListWithoutRC(
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {

		String strproc_name = "{call pkg_mms_view.proc_item_list_for_po(?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?)}"; // 10
																								// Variables

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wsResult = null;
		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransNewDAO.getPOItemList()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.getPOItemList()");

			nProcIndex = dao.setProcedure(strproc_name);
			//System.out.println("Hosp Code:::"+ _PODeskGenerateTransNewVO.getStrHospitalCode());
			//System.out.println("catCode:::"	+ _PODeskGenerateTransNewVO.getStrItemCat());
			//System.out.println("po_store_id:::"	+ _PODeskGenerateTransNewVO.getStrStoreId());
			//System.out.println("startDate:::"+ _PODeskGenerateTransNewVO.getStrFinancialStartDate());
			//System.out.println("endDate:::"	+ _PODeskGenerateTransNewVO.getStrFinancialToDate());
			//System.out.println("Supplier ID==>"	+ _PODeskGenerateTransNewVO.getStrSupplierId());
			//System.out.println("PO ref Date==>"	+ _PODeskGenerateTransNewVO.getStrPORefrenceDate());
			if(_PODeskGenerateTransNewVO.getStrPOTypeId().replace("^", "#").split("#")[1].equals("10"))
				dao.setProcInValue(nProcIndex, "modeval", "3",1);
			else
				dao.setProcInValue(nProcIndex, "modeval", "4",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "catCode", _PODeskGenerateTransNewVO.getStrItemCat(),3);
			dao.setProcInValue(nProcIndex, "po_store_id",_PODeskGenerateTransNewVO.getStrStoreId(),4);
			dao.setProcInValue(nProcIndex, "startDate", _PODeskGenerateTransNewVO.getStrFinancialStartDate(),5);
			dao.setProcInValue(nProcIndex, "endDate", _PODeskGenerateTransNewVO.getStrFinancialToDate(),6);

			dao.setProcInValue(nProcIndex, "suppId", _PODeskGenerateTransNewVO	.getStrSupplierId(),7);
			dao.setProcInValue(nProcIndex, "poRefDate", _PODeskGenerateTransNewVO.getStrPORefrenceDate(),8);

			dao.setProcOutValue(nProcIndex, "err", 1,9);
			dao.setProcOutValue(nProcIndex, "resultset", 2,10);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_PODeskGenerateTransNewVO.setStrPOItemCmb(util.getOptionValue(
						wsResult, "0", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.getPOItemList() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {

		String strproc_name = "{call pkg_mms_view.proc_hstt_store_mst(?,?,?,?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransNewDAO.setDeliveryLocationValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.setDeliveryLocationValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seatid", _PODeskGenerateTransNewVO
					.getStrSeatId(),3);

			/* Setting Default Value Start */
			dao.setProcInValue(nProcIndex, "storeid", "0",4);
			dao.setProcInValue(nProcIndex, "storetype_id", "0",5);
			/* Setting Default Value End */

			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_PODeskGenerateTransNewVO.setStrDeliveryLocationValues(util
						.getOptionValue(wsResult, "", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.setDeliveryLocationValues() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {

		String strproc_name = "{call pkg_mms_view.Proc_Supplier_List(?,?,?,?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransNewDAO.setAgentNameValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.setAgentNameValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "8",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "catCode", _PODeskGenerateTransNewVO
					.getStrItemCat(),3);

			/* Setting Default Value Start */
			dao.setProcInValue(nProcIndex, "branditem_id", "0",4);
			dao.setProcInValue(nProcIndex, "contractType", "0",5);
			/* Setting Default Value End */

			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_PODeskGenerateTransNewVO.setStrAgentNameValues(util
						.getOptionValue(wsResult, "", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.setAgentNameValues() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {

		String strproc_name = "{call pkg_mms_view.proc_currency_list(?,?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransNewDAO.setCurrencyValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.setCurrencyValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "isDefault", "0",3); // Default value
			dao.setProcOutValue(nProcIndex, "err", 1,4);
			dao.setProcOutValue(nProcIndex, "resultset", 2,5);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_PODeskGenerateTransNewVO.setStrCurrencyValues(util
						.getOptionValue(wsResult, "", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.setCurrencyValues() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		String strproc_name = "{call PKG_MMS_VIEW.Proc_Hstt_Agenda_Dtl(?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.getRequestDetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modval", "4",1);
			dao.setProcInValue(nProcIndex, "store_id", _PODeskGenerateTransNewVO
					.getStrStoreId(),2);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO
					.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex, "agenda_no", "0",4); // Default value
			dao.setProcInValue(nProcIndex, "item_cat", _PODeskGenerateTransNewVO
					.getStrItemCat(),5);
			dao.setProcInValue(nProcIndex, "po_type", _PODeskGenerateTransNewVO
					.getStrPOTypeId(),6);
			dao.setProcInValue(nProcIndex, "grant_type", _PODeskGenerateTransNewVO
					.getStrPOGrantType(),7);

			

			dao.setProcOutValue(nProcIndex, "err", 1,8);
			dao.setProcOutValue(nProcIndex, "resultset", 2,9);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				_PODeskGenerateTransNewVO.setWbRequestDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.getRequestDetails() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void getComponentDetail(
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		String strproc_name = "{call PKG_MMS_VIEW.PROC_HSTT_POTYPE_COMPONENT_MST(?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.getComponentDetail()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "po_type", _PODeskGenerateTransNewVO
					.getStrPOTypeId(),3);
			dao.setProcInValue(nProcIndex, "item_cat", _PODeskGenerateTransNewVO
					.getStrItemCat(),4);

			
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
					strComponentValue[nTmpI] = (wsResult.getString(3).equals(
							".") ? "" : wsResult.getString(3))
							+ " "
							+ (wsResult.getString(4).equals(".") ? ""
									: wsResult.getString(4));
				}

			} else
				throw new Exception(strErr);
			_PODeskGenerateTransNewVO.setStrComponentID(strComponentID);
			_PODeskGenerateTransNewVO.setStrComponentName(strComponentName);
			_PODeskGenerateTransNewVO.setStrComponentValue(strComponentValue);

		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.getComponentDetail() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void getRequestItemDetails(
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		String strproc_name = "{call pkg_mms_view.proc_po_item_dtl(?,?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.getRequestItemDetails()");
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);

			// //System.out.println(":: Inside PO Desk DAO getRequestItemDetails()
			// ::");
			// //System.out.println("Req
			// no:::"+_PODeskGenerateTransNewVO.getStrRequestId());
			// //System.out.println("Item
			// Catg:::"+_PODeskGenerateTransNewVO.getStrItemCat());
			// //System.out.println("Supplier
			// ID:::"+_PODeskGenerateTransNewVO.getStrSupplierId());
			// //System.out.println("Contract
			// Type:::"+_PODeskGenerateTransNewVO.getStrContractType());
			// //System.out.println("Po_Type:::"+_PODeskGenerateTransNewVO.getStrPOTypeId());
			// //System.out.println("Store_Id:::"+_PODeskGenerateTransNewVO.getStrStoreId());

			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "req_no", _PODeskGenerateTransNewVO
					.getStrRequestId(),3);
			dao.setProcInValue(nProcIndex, "supplier_id",
					_PODeskGenerateTransNewVO.getStrSupplierId(),4);
			dao.setProcInValue(nProcIndex, "store_id", _PODeskGenerateTransNewVO
					.getStrStoreId(),5);
			dao.setProcInValue(nProcIndex, "item_cat", _PODeskGenerateTransNewVO
					.getStrItemCat(),6);
			dao.setProcInValue(nProcIndex, "contract_type", "10",7);
			dao.setProcInValue(nProcIndex, "po_type", _PODeskGenerateTransNewVO
					.getStrPOTypeId(),8);
			
			dao.setProcOutValue(nProcIndex, "err", 1,9);
			dao.setProcOutValue(nProcIndex, "resultset", 2,10);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			if (strErr == null || strErr.equals("")) {
				_PODeskGenerateTransNewVO.setWbRequestItemDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.getRequestItemDetails() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void setUnitValues(PODeskGenerateTransNewVO vo) {
		String strFuncName = "";
		String strProcName = "";

		int nFuncIndex = 0;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strUnitRate = "";
		HisUtil util = null;

		try {

			daoObj = new HisDAO("SampleSentTrans", "SampleSentTransDAO");
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransNewDAO.setUnitValues()");
			strFuncName = "{? = call mms_mst.get_inventory_unitid(?, ?, ?, ?)}";
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, "1");
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrItemId());
			daoObj.setFuncOutValue(nFuncIndex, 3);
			daoObj.executeFuncForNumeric(nFuncIndex);
			strUnitRate = daoObj.getFuncNumeric(nFuncIndex);

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", strUnitRate,2);
			daoObj.setProcInValue(nProcIndex, "module_id", "",3);
			if(strUnitRate.length() == 4)
				daoObj.setProcInValue(nProcIndex, "modeval", "5",4);
			else
				daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			//daoObj.setProcInValue(nProcIndex, "modeval", "5",4);			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))

				vo.setStrRateUnitValues(util.getOptionValue(ws, "0", "0^Select", false, false));
			else
				throw new Exception(strErr);
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SampleSentTrans.setUnitValues() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void setUnitValues1(
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		String strproc_name = "{call pkg_mms_view.proc_gblt_unit_mst(?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransNewDAO.setUnitValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.setUnitValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),1);
			dao.setProcInValue(nProcIndex, "unit_id", "6301",2);
			dao.setProcInValue(nProcIndex, "module_id", "63",3); 
			dao.setProcInValue(nProcIndex, "modeval", "1",4);			
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			// //System.out.println("in
			// CMB:::::"+_PODeskGenerateTransNewVO.getStrMatchUnitCmb());

			if (strErr == null || strErr.equals(""))

				_PODeskGenerateTransNewVO
						.setStrRateUnitValues(util.getOptionValue(wsResult,
								"0",
								"0^Select", false, false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.setUnitValues() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		String strproc_name = "{call pkg_mms_view.proc_supplier_list(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskGenerateTransNewDAO.setManufacturerValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.setManufacturerValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "catCode", _PODeskGenerateTransNewVO.getStrItemCat(),2);
			dao.setProcInValue(nProcIndex, "branditem_id", "0",3);
			dao.setProcInValue(nProcIndex, "contractType", "0",4);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			//System.out.println("**************************");
			
			//System.out.println("modeval"+ "2");
			//System.out.println("catCode"+ _PODeskGenerateTransNewVO.getStrItemCat());
			//System.out.println("hosp_code"+ _PODeskGenerateTransNewVO.getStrHospitalCode());
			

			dao.executeProcedureByPosition(nProcIndex);
			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
 //System.out.println("ws.size ************>>"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				_PODeskGenerateTransNewVO.setStrManufacturerValues(util
						.getOptionValue(wsResult, _PODeskGenerateTransNewVO
								.getStrItemManufacturerId(), "0^Select Value",
								false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.setManufacturerValues() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Indent_Item_Dtls(?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.getIndentPopupDetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "indentno", _PODeskGenerateTransNewVO
					.getStrIndentNo(),3);
			dao.setProcInValue(nProcIndex, "frmstoreid", _PODeskGenerateTransNewVO
					.getStrStoreId(),4);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				_PODeskGenerateTransNewVO.setWbRequestDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.getIndentPopupDetails() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static String getIsForeign(
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		String strProcName = "{? = call MMS_MST.get_IsForeign_Flg(?,?)}";
		HisDAO dao = null;

		int funcIndex = 0;
		String strIsFoeignFlg = "";

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.getPONo()");

			funcIndex = dao.setFunction(strProcName);
			dao.setFuncInValue(funcIndex, 2, _PODeskGenerateTransNewVO
					.getStrSupplierId().split("\\^")[0]);
			dao.setFuncInValue(funcIndex, 3, _PODeskGenerateTransNewVO
					.getStrHospitalCode());

			dao.setFuncOutValue(funcIndex, 1);

			dao.executeFunction(funcIndex);
			strIsFoeignFlg = dao.getFuncString(funcIndex);

			_PODeskGenerateTransNewVO.setStrIsForeignFlg(strIsFoeignFlg);

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.getIsForeign() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return strIsFoeignFlg;
	}

	public static String getPONo(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) 
	{
		String strProcName = "{? = call MMS_MST.generate_poNo(?,?,?,?)}";
		HisDAO dao = null;

		int funcIndex = 0;
		String strPONo = "";

		try 
		{
			dao = new HisDAO("MMS","transactions.PODeskGenerateTransNewDAO.getPONo()");

			funcIndex = dao.setFunction(strProcName);

			dao.setFuncInValue(funcIndex, 2, _PODeskGenerateTransNewVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3, _PODeskGenerateTransNewVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 4, _PODeskGenerateTransNewVO.getStrPOTypeId().split("\\^")[0]);
			dao.setFuncInValue(funcIndex, 5, _PODeskGenerateTransNewVO.getStrItemCat());
			dao.setFuncOutValue(funcIndex, 1);

			dao.executeFunction(funcIndex);
			strPONo = dao.getFuncString(funcIndex);
		} 
		catch (Exception _Err) 
		{
			_PODeskGenerateTransNewVO.setStrMsgString("PODeskGenerateTransNewDAO.getPONo() --> "+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
		}
		return strPONo;
	}

	public static void getItemPopupData(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) 
	{
		String strProcName = "{? = call MMS_MST.Get_item_property (?,?,?,?,?)}";
		HisDAO dao = null;

		int funcIndex = 0;
		String strItemPopupData = "";

		try 
		{
			dao = new HisDAO("MMS","transactions.PODeskGenerateTransNewDAO.getItemPopupData()");

			funcIndex = dao.setFunction(strProcName);

			dao.setFuncInValue(funcIndex, 2, "5");
			dao.setFuncInValue(funcIndex, 3, _PODeskGenerateTransNewVO.getStrItemId());
			dao.setFuncInValue(funcIndex, 4, _PODeskGenerateTransNewVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 5, "0");
			dao.setFuncInValue(funcIndex, 6, "0");

			dao.setFuncOutValue(funcIndex, 1);

			dao.executeFunction(funcIndex);
			strItemPopupData = dao.getFuncString(funcIndex);

			_PODeskGenerateTransNewVO.setStrItemPopupData(strItemPopupData);
		} 
		catch (Exception _Err) 
		{
			_PODeskGenerateTransNewVO.setStrMsgString("PODeskGenerateTransNewDAO.getItemPopupData() --> "+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * This function is used to set details in approved By Combo.
	 * 
	 * @param _PODeskGenerateTransNewVO
	 */
	public static void getApprovedByCombo(
			PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {

		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
			daoObj = new HisDAO("MMSModule", "PODeskGenerateTransNewDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			// Set Value
			daoObj.setProcInValue(nProcIndex, "modeVal", "1",1);
			daoObj.setProcInValue(nProcIndex, "storeId", _PODeskGenerateTransNewVO
					.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					_PODeskGenerateTransNewVO.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);
			// Execute Procedure
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				_PODeskGenerateTransNewVO.setWbApprovedBy(ws);
			}
		} catch (Exception _err) {
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.getApprovedByCombo() --> "
							+ _err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
		}
	}

	public synchronized static void insert(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		String strProcName = "{call PKG_MMS_DML.dml_hstt_po_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 27
																															// Variables
		String strProcName1 = "{call PKG_MMS_DML.Dml_hstt_po_req_Dtl(?,?,?,?,?,?,?,?,?,?,?,?)}";
		String strProcName2 = "{call PKG_MMS_DML.Dml_hstt_po_Item_Dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?)}";	// 37 variable
		String strProcName3 = "{call PKG_MMS_DML.dml_hstt_potype_component_mst(?,?,?,?,?,?,?,?)}";
		String strProcName4 = "{call PKG_MMS_DML.dml_sstt_po_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?, ?,?,?)}"; // 34
																																			// Variables
		String strProcName5 = "{call PKG_MMS_DML.dml_hstt_foreignnpo_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		String strProcName6 = "{call PKG_MMS_DML.dml_hstt_po_schedule_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		String strProcName7 = "{call PKG_MMS_DML.dml_hstt_po_req_item_dtl(?,?,?,?,?,?,?,?,?,?,?)}";
		String strProcName8 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?)}";	// 37 variable
		String strProcName9 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?)}";	// 37 variable
		String strProcName10 = "{call PKG_MMS_DML.dml_update_po_schedule_dtl (?,?,?,?,?,?,?)}"; // 7
																								// Variables
		String strProcName11 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?)}";	// 37 variable
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
		String strErr = "";
		String strPONo = "";
		MmsConfigUtil mmsConfigUtil = null;
		try {
			mmsConfigUtil = new MmsConfigUtil(_PODeskGenerateTransNewVO.getStrHospitalCode());
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransNewDAO.insert()");

			strPONo = getPONo(_PODeskGenerateTransNewVO);

			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "pono", strPONo,2);
			dao.setProcInValue(nProcIndex, "hosp_code", _PODeskGenerateTransNewVO
					.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex, "item_cat", _PODeskGenerateTransNewVO
					.getStrItemCat(),4);
			dao.setProcInValue(nProcIndex, "po_type_id", _PODeskGenerateTransNewVO
					.getStrPOTypeId(),5);
			dao.setProcInValue(nProcIndex, "pur_source", _PODeskGenerateTransNewVO
					.getStrDPurchaseSource(),6);
			dao.setProcInValue(nProcIndex, "store_id", _PODeskGenerateTransNewVO
					.getStrStoreId(),7);
			dao.setProcInValue(nProcIndex, "supplier", _PODeskGenerateTransNewVO
					.getStrSupplierId().replace("^", "#").split("#")[0],8);
			dao.setProcInValue(nProcIndex, "po_Date", _PODeskGenerateTransNewVO
					.getStrPORefrenceDate(),9);
			dao.setProcInValue(nProcIndex, "tender_no", _PODeskGenerateTransNewVO
					.getStrDTenderNo(),10);
			dao.setProcInValue(nProcIndex, "tender_date",
					_PODeskGenerateTransNewVO.getStrDTenderDate(),11);
			dao.setProcInValue(nProcIndex, "quotation_no",
					_PODeskGenerateTransNewVO.getStrDQuotationNo(),12);
			dao.setProcInValue(nProcIndex, "quotation_date",
					_PODeskGenerateTransNewVO.getStrDQuotationDate(),13);
			dao.setProcInValue(nProcIndex, "fin_start_date", mmsConfigUtil
					.getStrFinancialStartDate(_PODeskGenerateTransNewVO
							.getStrStoreId(), _PODeskGenerateTransNewVO
							.getStrHospitalCode()),14);
			dao.setProcInValue(nProcIndex, "fin_end_date", mmsConfigUtil
					.getStrFinancialEndDate(_PODeskGenerateTransNewVO
							.getStrStoreId(), _PODeskGenerateTransNewVO
							.getStrHospitalCode()),15);
			dao.setProcInValue(nProcIndex, "po_remarks", _PODeskGenerateTransNewVO
					.getStrDRemarks(),16);
			if (_PODeskGenerateTransNewVO.getStrPOTypeId().equals("24")) {
				dao.setProcInValue(nProcIndex, "currency_value",
						_PODeskGenerateTransNewVO.getStrDCurrencyValue(),17);
				dao.setProcInValue(nProcIndex, "currency_id",
						_PODeskGenerateTransNewVO.getStrDCurrencyName(),18);
			} else {

				dao.setProcInValue(nProcIndex, "currency_value", "1",19);
				dao.setProcInValue(nProcIndex, "currency_id", "100",20);
			}
			dao.setProcInValue(nProcIndex, "seat_id", _PODeskGenerateTransNewVO
					.getStrSeatId(),21);
			dao.setProcInValue(nProcIndex, "tax", _PODeskGenerateTransNewVO
					.getStrDOverAllTax(),22);
			dao.setProcInValue(nProcIndex, "net_amount", _PODeskGenerateTransNewVO
					.getStrTotalPOCost(),23);
			dao.setProcInValue(nProcIndex, "verified_by",
					_PODeskGenerateTransNewVO.getStrVerifiedBy(),24);
			dao.setProcInValue(nProcIndex, "verified_date",
					_PODeskGenerateTransNewVO.getStrVerifiedDate(),25);

			/* Setting Default Value Start */
			dao.setProcInValue(nProcIndex, "schedule_no", "0",26);
			dao.setProcInValue(nProcIndex, "ipAddr", "",27);
			dao.setProcInValue(nProcIndex, "po_prefix", _PODeskGenerateTransNewVO
					.getStrPoRefrenceNo(),28);
			/* Setting Default Value End */

			dao.setProcOutValue(nProcIndex, "err", 1,29);

			dao.execute(nProcIndex, 1);

			nProc1Index = dao.setProcedure(strProcName1);

			for (int nTmpI = 0; nTmpI < _PODeskGenerateTransNewVO.getStrCheckBox().length; nTmpI++) {
				dao.setProcInValue(nProc1Index, "modeval", "1",1);
				dao.setProcInValue(nProc1Index, "store_id",
						_PODeskGenerateTransNewVO.getStrStoreId(),2);
				dao.setProcInValue(nProc1Index, "pono", strPONo,3);
				dao.setProcInValue(nProc1Index, "req_no",
						_PODeskGenerateTransNewVO.getStrDRequestNo()[nTmpI],4);
				dao.setProcInValue(nProc1Index, "hosp_code",
						_PODeskGenerateTransNewVO.getStrHospitalCode(),5);
				dao.setProcInValue(nProc1Index, "req_date",
						_PODeskGenerateTransNewVO.getStrDRequestDate()[nTmpI],6);
				dao.setProcInValue(nProc1Index, "req_period",
						_PODeskGenerateTransNewVO.getStrDRequestPeriod()[nTmpI],7);
				dao.setProcInValue(nProc1Index, "req_type_id",
						_PODeskGenerateTransNewVO.getStrDRequestType()[nTmpI],8);
				dao.setProcInValue(nProc1Index, "raising_store_id",
						_PODeskGenerateTransNewVO.getStrDRaisingStore()[nTmpI],9);
				dao.setProcInValue(nProc1Index, "puk", _PODeskGenerateTransNewVO
						.getStrDCRNo()[nTmpI],10);
				dao.setProcInValue(nProc1Index, "emp_id", "0",11);
				dao.setProcOutValue(nProc1Index, "err", 1,12);

				dao.execute(nProc1Index, 1);
			}

			nProc2Index = dao.setProcedure(strProcName2);

			for (int nTmpI = 0; nTmpI < _PODeskGenerateTransNewVO.getStrDitemId().length; nTmpI++) {
				dao.setProcInValue(nProc2Index, "modeval", "1",1);
				dao.setProcInValue(nProc2Index, "pono", strPONo,2);
				dao.setProcInValue(nProc2Index, "store_id",
						_PODeskGenerateTransNewVO.getStrStoreId(),3);
				dao.setProcInValue(nProc2Index, "item_id",
						_PODeskGenerateTransNewVO.getStrDitemId()[nTmpI],4);
				dao.setProcInValue(nProc2Index, "item_brand_id",
						_PODeskGenerateTransNewVO.getStrDitemBrandId()[nTmpI],5);
				dao.setProcInValue(nProc2Index, "schedule_no", "1",6);
				dao.setProcInValue(nProc2Index, "hosp_code",
						_PODeskGenerateTransNewVO.getStrHospitalCode(),7);
				dao.setProcInValue(nProc2Index, "supplier",
						_PODeskGenerateTransNewVO.getStrSupplierId().replace("^",
								"#").split("#")[0],8);
				dao.setProcInValue(nProc2Index, "groupid",
						_PODeskGenerateTransNewVO.getStrDGroupId()[nTmpI],9);
				dao.setProcInValue(nProc2Index, "subgroup_id",
						_PODeskGenerateTransNewVO.getStrDSubGroupId()[nTmpI],10);
				dao.setProcInValue(nProc2Index, "manuf_id",
						_PODeskGenerateTransNewVO.getStrDManufacturerId()[nTmpI],11);
				dao.setProcInValue(nProc2Index, "rate", _PODeskGenerateTransNewVO
						.getStrDRate()[nTmpI],12);
				dao.setProcInValue(nProc2Index, "rate_unit",
						_PODeskGenerateTransNewVO.getStrDRateUnitId()[nTmpI]
								.replace("^", "#").split("#")[0],13);
				dao.setProcInValue(nProc2Index, "order_qty",
						_PODeskGenerateTransNewVO.getStrDOrderQty()[nTmpI],14);
				dao.setProcInValue(nProc2Index, "order_qty_unit",
						_PODeskGenerateTransNewVO.getStrDOrderQtyUnitId()[nTmpI]
								.replace("^", "#").split("#")[0],15);
				dao
						.setProcInValue(nProc2Index, "warrenty_req",
								_PODeskGenerateTransNewVO
										.getStrDWarrantyRequired()[nTmpI],16);
				dao
						.setProcInValue(nProc2Index, "installation_req",
								_PODeskGenerateTransNewVO
										.getStrDInstallationRequired()[nTmpI],17);
				dao.setProcInValue(nProc2Index, "remarks",
						_PODeskGenerateTransNewVO.getStrDRemarks(),18);
				dao.setProcInValue(nProc2Index, "item_tax",
						_PODeskGenerateTransNewVO.getStrDTax()[nTmpI],19);
				dao.setProcInValue(nProc2Index, "item_make",
						_PODeskGenerateTransNewVO.getStrMake()[nTmpI],20);

				/* Setting Default Value Start */
				dao.setProcInValue(nProc2Index, "accepted_qty", "0",21);
				dao.setProcInValue(nProc2Index, "accepted_qty_unit", "0",22);
				dao.setProcInValue(nProc2Index, "rejected_qty", "0",23);
				dao.setProcInValue(nProc2Index, "rejected_qty_unit", "0",24);
				dao.setProcInValue(nProc2Index, "breakage_qty", "0",25);
				dao.setProcInValue(nProc2Index, "breakage_qty_unit", "0",26);
				dao.setProcInValue(nProc2Index, "return_qty", "0",27);
				dao.setProcInValue(nProc2Index, "return_qty_unit", "0",28);
				dao.setProcInValue(nProc2Index, "recieved_qty", "0",29);
				dao.setProcInValue(nProc2Index, "recieved_qty_unit", "0",30);
				dao.setProcInValue(nProc2Index, "req_no", "0",31);
				dao.setProcInValue(nProc2Index, "challanNo", "0",32);
				dao.setProcInValue(nProc2Index, "raising_store", "0",33);
				dao.setProcInValue(nProc2Index, "po_type", "0",34);
				dao.setProcInValue(nProc2Index, "delivery_loc", _PODeskGenerateTransNewVO.getStrDDeliveryLocation(),35);
				dao.setProcInValue(nProc2Index, "itemName", "",35);
				/* Setting Default Value End */

				dao.setProcOutValue(nProc2Index, "err", 1,36);

				dao.execute(nProc2Index, 1);
			}

			if (_PODeskGenerateTransNewVO.getStrDComponentId() != null) {
				for (int nTmpI = 0, stopNTmp = _PODeskGenerateTransNewVO
						.getStrDComponentId().length; nTmpI < stopNTmp; nTmpI++) {
					nProc3Index = dao.setProcedure(strProcName3);

					dao.setProcInValue(nProc3Index, "modeval", "1",1);
					if (_PODeskGenerateTransNewVO.getStrDComponentValue()[nTmpI]
							.length() > 3999) {
						dao
								.setProcInValue(nProc3Index, "comp_value1",
										_PODeskGenerateTransNewVO
												.getStrDComponentValue()[nTmpI]
												.substring(0, 3999),2);
						dao
								.setProcInValue(nProc3Index, "comp_value2",
										_PODeskGenerateTransNewVO
												.getStrDComponentValue()[nTmpI]
												.substring(4000),3);
					} else {
						dao
								.setProcInValue(nProc3Index, "comp_value1",
										_PODeskGenerateTransNewVO
												.getStrDComponentValue()[nTmpI],2);
						dao.setProcInValue(nProc3Index, "comp_value2", " ",3);
					}
					dao.setProcInValue(nProc3Index, "hosp_code",
							_PODeskGenerateTransNewVO.getStrHospitalCode(),4);
					dao.setProcInValue(nProc3Index, "comp_id",
							_PODeskGenerateTransNewVO.getStrDComponentId()[nTmpI],5);
					dao.setProcInValue(nProc3Index, "pono", strPONo,6);
					dao.setProcInValue(nProc3Index, "store_id",
							_PODeskGenerateTransNewVO.getStrStoreId(),7);
					dao.setProcOutValue(nProc3Index, "err", 1,8);

					dao.execute(nProc3Index, 1);
				}
			}

			nProc4Index = dao.setProcedure(strProcName4);
			dao.setProcInValue(nProc4Index, "modeval", "1",1); // 1
			dao.setProcInValue(nProc4Index, "pono", strPONo,2); // 2
			dao.setProcInValue(nProc4Index, "hosp_code", _PODeskGenerateTransNewVO
					.getStrHospitalCode(),3); // 3
			dao.setProcInValue(nProc4Index, "item_cat", _PODeskGenerateTransNewVO
					.getStrItemCat(),4); // 4
			dao.setProcInValue(nProc4Index, "po_type_id",
					_PODeskGenerateTransNewVO.getStrPOTypeId(),5); // 5
			dao.setProcInValue(nProc4Index, "pur_source",
					_PODeskGenerateTransNewVO.getStrDPurchaseSource(),6);// 6
			dao.setProcInValue(nProc4Index, "store_id", _PODeskGenerateTransNewVO
					.getStrStoreId(),7);// 7
			dao.setProcInValue(nProc4Index, "supplier", _PODeskGenerateTransNewVO
					.getStrSupplierId().replace("^", "#").split("#")[0],8);// 8
			dao.setProcInValue(nProc4Index, "po_Date", _PODeskGenerateTransNewVO
					.getStrPORefrenceDate(),9);// 9
			dao.setProcInValue(nProc4Index, "tender_no", _PODeskGenerateTransNewVO
					.getStrDTenderNo(),10);// 10
			dao.setProcInValue(nProc4Index, "tender_date",
					_PODeskGenerateTransNewVO.getStrDTenderDate(),11);// 11
			dao.setProcInValue(nProc4Index, "quotation_no",
					_PODeskGenerateTransNewVO.getStrDQuotationNo(),12);// 12
			dao.setProcInValue(nProc4Index, "quotation_date",
					_PODeskGenerateTransNewVO.getStrDQuotationDate(),13); // 13
			dao.setProcInValue(nProc4Index, "po_status", "1",14);// 14
			if (_PODeskGenerateTransNewVO.getStrPOTypeId().equals("24")) {
				dao.setProcInValue(nProc4Index, "currency_value",
						_PODeskGenerateTransNewVO.getStrDCurrencyValue(),15);// 15
				dao.setProcInValue(nProc4Index, "currency_id",
						_PODeskGenerateTransNewVO.getStrDCurrencyName(),16);// 16
			} else {
				dao.setProcInValue(nProc4Index, "currency_value", "1",15);// 15
				dao.setProcInValue(nProc4Index, "currency_id", "100",16);// 16
			}
			dao.setProcInValue(nProc4Index, "fin_start_date", mmsConfigUtil
					.getStrFinancialStartDate(_PODeskGenerateTransNewVO
							.getStrStoreId(), _PODeskGenerateTransNewVO
							.getStrHospitalCode()),17);// 17
			dao.setProcInValue(nProc4Index, "fin_end_date", mmsConfigUtil
					.getStrFinancialEndDate(_PODeskGenerateTransNewVO
							.getStrStoreId(), _PODeskGenerateTransNewVO
							.getStrHospitalCode()),18);// 18
			dao.setProcInValue(nProc4Index, "po_remarks",
					_PODeskGenerateTransNewVO.getStrDRemarks(),19);// 19
			dao.setProcInValue(nProc4Index, "seat_id", _PODeskGenerateTransNewVO
					.getStrSeatId(),20);// 20
			dao.setProcInValue(nProc4Index, "tax", _PODeskGenerateTransNewVO
					.getStrDOverAllTax(),21);// 21
			dao.setProcInValue(nProc4Index, "reqTypeId", _PODeskGenerateTransNewVO
					.getStrPOTypeId(),22);// 22
			dao.setProcInValue(nProc4Index, "net_amount",
					_PODeskGenerateTransNewVO.getStrTotalPOCost(),23);// 23
			dao.setProcInValue(nProc4Index, "verified_by",
					_PODeskGenerateTransNewVO.getStrVerifiedBy(),24);// 24
			dao.setProcInValue(nProc4Index, "verified_date",
					_PODeskGenerateTransNewVO.getStrVerifiedDate(),25);// 25

			/* Setting Default Value Start */
			dao.setProcInValue(nProc4Index, "net_advance", "0",26);// 26
			dao.setProcInValue(nProc4Index, "net_penelty", "0",27);// 27
			dao.setProcInValue(nProc4Index, "cancel_flag", "0",28);// 28
			dao.setProcInValue(nProc4Index, "waivoff", "0",29);// 29
			dao.setProcInValue(nProc4Index, "advance_adjusted", "0",30);// 30
			dao.setProcInValue(nProc4Index, "po_prefix", _PODeskGenerateTransNewVO
					.getStrPoRefrenceNo(),31);// 31

			dao.setProcInValue(nProc4Index, "paid_bill_amt", "0",32);// 32
			dao.setProcInValue(nProc4Index, "issueNo", "0",33);// 33
			/* Setting Default Value End */
			dao.setProcInValue(nProc4Index, "dcomments","-");
			dao.setProcOutValue(nProc4Index, "err", 1,34); // 34

			dao.execute(nProc4Index, 1);

			if (_PODeskGenerateTransNewVO.getStrPOTypeId().equals("24")) {
				nProc5Index = dao.setProcedure(strProcName5);
				dao.setProcInValue(nProc5Index, "modeval", "1",1);
				dao.setProcInValue(nProc5Index, "pono", strPONo,2);
				dao.setProcInValue(nProc5Index, "store_id",
						_PODeskGenerateTransNewVO.getStrStoreId());
				dao.setProcInValue(nProc5Index, "hosp_code",
						_PODeskGenerateTransNewVO.getStrHospitalCode(),3);
				dao.setProcInValue(nProc5Index, "supplier",
						_PODeskGenerateTransNewVO.getStrSupplierId().replace("^",
								"#").split("#")[0],4);
				dao.setProcInValue(nProc5Index, "agent_id",
						_PODeskGenerateTransNewVO.getStrDAgentName(),5);
				dao.setProcInValue(nProc5Index, "ca_id", _PODeskGenerateTransNewVO
						.getStrDCAName(),6);
				dao.setProcInValue(nProc5Index, "currency",
						_PODeskGenerateTransNewVO.getStrDCurrencyName(),7);
				dao.setProcInValue(nProc5Index, "iac_charge",
						_PODeskGenerateTransNewVO.getStrDIACCharge(),8);
				dao.setProcInValue(nProc5Index, "insurance_charge",
						_PODeskGenerateTransNewVO.getStrDInsuranceCharge(),9);
				dao.setProcInValue(nProc5Index, "dumurrages_by",
						_PODeskGenerateTransNewVO.getStrDDemurrageBy(),10);
				dao.setProcInValue(nProc5Index, "remarks",
						_PODeskGenerateTransNewVO.getStrDRemarks(),11);
				dao.setProcOutValue(nProc5Index, "err", 1,12);

				dao.execute(nProc5Index, 1);
			}

			nProc6Index = dao.setProcedure(strProcName6);
			dao.setProcInValue(nProc6Index, "modeval", "1",1);
			dao.setProcInValue(nProc6Index, "store_id", _PODeskGenerateTransNewVO
					.getStrStoreId(),2);
			dao.setProcInValue(nProc6Index, "pono", strPONo,3);
			dao.setProcInValue(nProc6Index, "schedule_no", "1",4);
			dao.setProcInValue(nProc6Index, "hosp_code", _PODeskGenerateTransNewVO
					.getStrHospitalCode(),5);
			if (!_PODeskGenerateTransNewVO.getStrIsForeignFlg().equals("5")) {
				// //System.out.println("_PODeskGenerateTransNewVO.getStrDDeliveryDate()"+_PODeskGenerateTransNewVO.getStrDDeliveryDate());
				// if(_PODeskGenerateTransNewVO.getStrDatePikerFlag().equals("1"))
				// {
				dao.setProcInValue(nProc6Index, "delivery_date",
						_PODeskGenerateTransNewVO.getStrDDeliveryDate(),6);
				// }
				// else
				// {
				// dao.setProcInValue(nProc6Index,
				// "delivery_date",_PODeskGenerateTransNewVO.getStrCalDeliveryDate());

				// }
			} else {

			}
			// //System.out.println("Cal Deleviry
			// Date:::"+_PODeskGenerateTransNewVO.getStrCalDeliveryDate());

			/* Setting Default Value Start */
			dao.setProcInValue(nProc6Index, "schedule_date", "",6);
			dao.setProcInValue(nProc6Index, "schedule_status", "",7);
			dao.setProcInValue(nProc6Index, "penelty", "",8);
			dao.setProcInValue(nProc6Index, "cancel_date", "",9);
			dao.setProcInValue(nProc6Index, "cancel_by", "",10);
			dao.setProcInValue(nProc6Index, "cancel_remarks", "",11);
			/* Setting Default Value End */

			dao.setProcOutValue(nProc6Index, "err", 1,12);

			dao.execute(nProc6Index, 1);
			for (int nTmpI = 0; nTmpI < _PODeskGenerateTransNewVO.getStrDitemId().length; nTmpI++) {
				nProc7Index = dao.setProcedure(strProcName7);
				dao.setProcInValue(nProc7Index, "modeval", "1",1);
				dao.setProcInValue(nProc7Index, "pono", strPONo,2);
				dao.setProcInValue(nProc7Index, "store_id",
						_PODeskGenerateTransNewVO.getStrStoreId(),3);
				dao.setProcInValue(nProc7Index, "req_no",
						_PODeskGenerateTransNewVO.getStrTmpReqNo()[nTmpI],4);
				dao.setProcInValue(nProc7Index, "raising_store_id",
						_PODeskGenerateTransNewVO.getStrTmpRaisingStore()[nTmpI],5);
				dao.setProcInValue(nProc7Index, "item_id",
						_PODeskGenerateTransNewVO.getStrDitemId()[nTmpI],6);
				dao.setProcInValue(nProc7Index, "itembrand_id",
						_PODeskGenerateTransNewVO.getStrDitemBrandId()[nTmpI],7);
				dao.setProcInValue(nProc7Index, "hosp_code",
						_PODeskGenerateTransNewVO.getStrHospitalCode(),8);
				dao.setProcInValue(nProc7Index, "order_qty",
						_PODeskGenerateTransNewVO.getStrDOrderQty()[nTmpI],9);
				dao.setProcInValue(nProc7Index, "orderqty_unitid",
						_PODeskGenerateTransNewVO.getStrDOrderQtyUnitId()[nTmpI]
								.replace("^", "#").split("#")[0],10);
				dao.setProcOutValue(nProc7Index, "err", 1,11);

				dao.execute(nProc7Index, 1);
			}

			for (int nTmpI = 0; nTmpI < _PODeskGenerateTransNewVO.getStrDitemId().length; nTmpI++) {
				nProc8Index = dao.setProcedure(strProcName8);
				dao.setProcInValue(nProc8Index, "modeval", "5",1);
				dao.setProcInValue(nProc8Index, "raising_store",
						_PODeskGenerateTransNewVO.getStrTmpRaisingStore()[nTmpI],2);
				dao.setProcInValue(nProc8Index, "req_no",
						_PODeskGenerateTransNewVO.getStrTmpReqNo()[nTmpI],3);
				dao.setProcInValue(nProc8Index, "item_id",
						_PODeskGenerateTransNewVO.getStrDitemId()[nTmpI],4);
				dao.setProcInValue(nProc8Index, "item_brand_id",
						_PODeskGenerateTransNewVO.getStrDitemBrandId()[nTmpI],5);
				dao.setProcInValue(nProc8Index, "hosp_code",
						_PODeskGenerateTransNewVO.getStrHospitalCode(),6);
				dao.setProcInValue(nProc8Index, "order_qty",
						_PODeskGenerateTransNewVO.getStrDOrderQty()[nTmpI],7);
				dao.setProcInValue(nProc8Index, "order_qty_unit",
						_PODeskGenerateTransNewVO.getStrDOrderQtyUnitId()[nTmpI]
								.replace("^", "#").split("#")[0],8);
				dao.setProcInValue(nProc8Index, "po_type",
						_PODeskGenerateTransNewVO.getStrPOTypeId(),9);

				/* Setting Default Value Start */
				dao.setProcInValue(nProc8Index, "pono", "0",10);
				dao.setProcInValue(nProc8Index, "store_id", "0",11);
				dao.setProcInValue(nProc8Index, "schedule_no", "0",12);
				dao.setProcInValue(nProc8Index, "supplier", "0",13);
				dao.setProcInValue(nProc8Index, "groupid", "0",14);
				dao.setProcInValue(nProc8Index, "subgroup_id", "0",15);
				dao.setProcInValue(nProc8Index, "manuf_id", "0",16);
				dao.setProcInValue(nProc8Index, "rate", "0",17);
				dao.setProcInValue(nProc8Index, "rate_unit", "0",18);
				dao.setProcInValue(nProc8Index, "accepted_qty", "0",19);
				dao.setProcInValue(nProc8Index, "accepted_qty_unit", "0",20);
				dao.setProcInValue(nProc8Index, "rejected_qty", "0",21);
				dao.setProcInValue(nProc8Index, "rejected_qty_unit", "0",22);
				dao.setProcInValue(nProc8Index, "breakage_qty", "0",23);
				dao.setProcInValue(nProc8Index, "breakage_qty_unit", "0",24);
				dao.setProcInValue(nProc8Index, "warrenty_req", "0",25);
				dao.setProcInValue(nProc8Index, "installation_req", "0",26);
				dao.setProcInValue(nProc8Index, "remarks", "",27);
				dao.setProcInValue(nProc8Index, "item_tax", "0",28);
				dao.setProcInValue(nProc8Index, "return_qty", "0",29);
				dao.setProcInValue(nProc8Index, "return_qty_unit", "0",30);
				dao.setProcInValue(nProc8Index, "recieved_qty", "0",31);
				dao.setProcInValue(nProc8Index, "recieved_qty_unit", "0",32);
				dao.setProcInValue(nProc8Index, "challanNo", "0",33);
				dao.setProcInValue(nProc8Index, "item_make", "1",34);
				dao.setProcInValue(nProc8Index, "delivery_loc", _PODeskGenerateTransNewVO.getStrDDeliveryLocation(),35);
				dao.setProcInValue(nProc8Index, "itemName", "",36);
				/* Setting Default Value End */

				dao.setProcOutValue(nProc8Index, "err", 1,37);

				dao.execute(nProc8Index, 1);
			}

			for (int nTmpI = 0; nTmpI < _PODeskGenerateTransNewVO.getStrDitemId().length; nTmpI++) {
				nProc9Index = dao.setProcedure(strProcName9);
				dao.setProcInValue(nProc9Index, "modeval", "6",1);
				dao.setProcInValue(nProc9Index, "raising_store",
						_PODeskGenerateTransNewVO.getStrTmpRaisingStore()[nTmpI],2);
				dao.setProcInValue(nProc9Index, "req_no",
						_PODeskGenerateTransNewVO.getStrTmpReqNo()[nTmpI],3);
				dao.setProcInValue(nProc9Index, "hosp_code",
						_PODeskGenerateTransNewVO.getStrHospitalCode(),4);
				dao.setProcInValue(nProc9Index, "po_type",
						_PODeskGenerateTransNewVO.getStrPOTypeId(),5);

				// //System.out.println("Store ID:::(PO Generate
				// Insert)==>"+_PODeskGenerateTransNewVO.getStrTmpRaisingStore()[nTmpI]);
				// //System.out.println("Req No:::(PO Generate
				// Insert)==>"+_PODeskGenerateTransNewVO.getStrTmpReqNo()[nTmpI]);
				// //System.out.println("Po Type:::(PO Generate
				// Insert)==>"+_PODeskGenerateTransNewVO.getStrPOTypeId());

				/* Setting Default Value Start */
				dao.setProcInValue(nProc9Index, "pono", "0",6);
				dao.setProcInValue(nProc9Index, "store_id", "0",7);
				dao.setProcInValue(nProc9Index, "item_id", "0",8);
				dao.setProcInValue(nProc9Index, "item_brand_id", "0",9);
				dao.setProcInValue(nProc9Index, "schedule_no", "0",10);
				dao.setProcInValue(nProc9Index, "supplier", "0",11);
				dao.setProcInValue(nProc9Index, "groupid", "0",12);
				dao.setProcInValue(nProc9Index, "subgroup_id", "0",13);
				dao.setProcInValue(nProc9Index, "manuf_id", "0",14);
				dao.setProcInValue(nProc9Index, "rate", "0",15);
				dao.setProcInValue(nProc9Index, "rate_unit", "0",16);
				dao.setProcInValue(nProc9Index, "order_qty", "0",17);
				dao.setProcInValue(nProc9Index, "order_qty_unit", "0",18);
				dao.setProcInValue(nProc9Index, "accepted_qty", "0",19);
				dao.setProcInValue(nProc9Index, "accepted_qty_unit", "0",20);
				dao.setProcInValue(nProc9Index, "rejected_qty", "0",21);
				dao.setProcInValue(nProc9Index, "rejected_qty_unit", "0",22);
				dao.setProcInValue(nProc9Index, "breakage_qty", "0",23);
				dao.setProcInValue(nProc9Index, "breakage_qty_unit", "0",24);
				dao.setProcInValue(nProc9Index, "warrenty_req", "0",25);
				dao.setProcInValue(nProc9Index, "installation_req", "0",26);
				dao.setProcInValue(nProc9Index, "remarks", "",27);
				dao.setProcInValue(nProc9Index, "item_tax", "0",28);
				dao.setProcInValue(nProc9Index, "return_qty", "0",29);
				dao.setProcInValue(nProc9Index, "return_qty_unit", "0",30);
				dao.setProcInValue(nProc9Index, "recieved_qty", "0",31);
				dao.setProcInValue(nProc9Index, "recieved_qty_unit", "0",32);
				dao.setProcInValue(nProc9Index, "challanNo", "0",33);
				dao.setProcInValue(nProc9Index, "item_make", "1",34);
				dao.setProcInValue(nProc9Index, "delivery_loc", _PODeskGenerateTransNewVO.getStrDDeliveryLocation(),35);
				dao.setProcInValue(nProc9Index, "itemName", "",36);
				/* Setting Default Value End */

				dao.setProcOutValue(nProc9Index, "err", 1,37);

				dao.execute(nProc9Index, 1);
			}

			/**
			 * Procedure Used To Update Delivery Location in
			 * HSTT_PO_SCHEDULE_DTL
			 */
			nProc10Index = dao.setProcedure(strProcName10); // Total 7 Variable
			dao.setProcInValue(nProc10Index, "modeval", "1",1);
			dao.setProcInValue(nProc10Index, "store_id", _PODeskGenerateTransNewVO
					.getStrStoreId(),2);
			dao.setProcInValue(nProc10Index, "pono", strPONo,3);
			dao.setProcInValue(nProc10Index, "schedule_no", "1",4);
			dao.setProcInValue(nProc10Index, "hosp_code",
					_PODeskGenerateTransNewVO.getStrHospitalCode(),5);
			dao.setProcInValue(nProc10Index, "delivery_location",
					_PODeskGenerateTransNewVO.getStrDDeliveryLocation(),6);
			// //System.out.println("Delivery
			// Location:::"+_PODeskGenerateTransNewVO.getStrDDeliveryLocation());
			/* Setting Default Value End */

			dao.setProcOutValue(nProc10Index, "err", 1,7);

			dao.execute(nProc10Index, 1);

			for (int nTmpI = 0; nTmpI < _PODeskGenerateTransNewVO.getStrDitemId().length; nTmpI++) {
				nProc11Index = dao.setProcedure(strProcName11);
				if (_PODeskGenerateTransNewVO.getStrDOrderQty()[nTmpI]
						.equals(_PODeskGenerateTransNewVO.getStrTmpBalQty()[nTmpI])) {
					dao.setProcInValue(nProc11Index, "modeval", "7",8);
					// //System.out.println("In Mode 7");
				} else {
					dao.setProcInValue(nProc11Index, "modeval", "8",8);
					// //System.out.println("In Mode 8");
				}
				dao.setProcInValue(nProc11Index, "raising_store",
						_PODeskGenerateTransNewVO.getStrTmpRaisingStore()[nTmpI],9);
				dao.setProcInValue(nProc11Index, "req_no",
						_PODeskGenerateTransNewVO.getStrTmpReqNo()[nTmpI],10);
				dao.setProcInValue(nProc11Index, "hosp_code",
						_PODeskGenerateTransNewVO.getStrHospitalCode(),11);
				dao.setProcInValue(nProc11Index, "po_type",
						_PODeskGenerateTransNewVO.getStrPOTypeId(),12);

				// //System.out.println("Store ID:::(PO Generate
				// Insert)==>"+_PODeskGenerateTransNewVO.getStrTmpRaisingStore()[nTmpI]);
				// //System.out.println("Req No:::(PO Generate
				// Insert)==>"+_PODeskGenerateTransNewVO.getStrTmpReqNo()[nTmpI]);
				// //System.out.println("Po Type:::(PO Generate
				// Insert)==>"+_PODeskGenerateTransNewVO.getStrPOTypeId());

				/* Setting Default Value Start */
				dao.setProcInValue(nProc11Index, "pono", "0",13);
				dao.setProcInValue(nProc11Index, "store_id", "0",14);
				dao.setProcInValue(nProc11Index, "item_id", "0",15);
				dao.setProcInValue(nProc11Index, "item_brand_id", "0",16);
				dao.setProcInValue(nProc11Index, "schedule_no", "0",17);
				dao.setProcInValue(nProc11Index, "supplier", "0",18);
				dao.setProcInValue(nProc11Index, "groupid", "0",19);
				dao.setProcInValue(nProc11Index, "subgroup_id", "0",20);
				dao.setProcInValue(nProc11Index, "manuf_id", "0",21);
				dao.setProcInValue(nProc11Index, "rate", "0",22);
				dao.setProcInValue(nProc11Index, "rate_unit", "0",23);
				dao.setProcInValue(nProc11Index, "order_qty", "0",24);
				dao.setProcInValue(nProc11Index, "order_qty_unit", "0",25);
				dao.setProcInValue(nProc11Index, "accepted_qty", "0",26);
				dao.setProcInValue(nProc11Index, "accepted_qty_unit", "0",27);
				dao.setProcInValue(nProc11Index, "rejected_qty", "0",28);
				dao.setProcInValue(nProc11Index, "rejected_qty_unit", "0",29);
				dao.setProcInValue(nProc11Index, "breakage_qty", "0",30);
				dao.setProcInValue(nProc11Index, "breakage_qty_unit", "0",31);
				dao.setProcInValue(nProc11Index, "warrenty_req", "0",32);
				dao.setProcInValue(nProc11Index, "installation_req", "0",33);
				dao.setProcInValue(nProc11Index, "remarks", "",34);
				dao.setProcInValue(nProc11Index, "item_tax", "0",35);
				dao.setProcInValue(nProc11Index, "return_qty", "0",36);
				dao.setProcInValue(nProc11Index, "return_qty_unit", "0",37);
				dao.setProcInValue(nProc11Index, "recieved_qty", "0",38);
				dao.setProcInValue(nProc11Index, "recieved_qty_unit", "0",39);
				dao.setProcInValue(nProc11Index, "challanNo", "0",40);
				dao.setProcInValue(nProc11Index, "item_make", "1",41);
				dao.setProcInValue(nProc11Index, "delivery_loc", _PODeskGenerateTransNewVO.getStrDDeliveryLocation(),42);
				dao.setProcInValue(nProc11Index, "itemName", "",43);
				/* Setting Default Value End */

				dao.setProcOutValue(nProc11Index, "err", 1,44);

				dao.execute(nProc11Index, 1);

			}

			dao.fire();

			if (strErr != null && !strErr.equals(""))
				throw new Exception(strErr);

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.insert() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public synchronized static void insertNewPO(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) 
	{
		String strProcName = "{call PKG_MMS_DML.dml_po_item_dtl_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 46
		String strProcName1 = "{call PKG_MMS_DML.dml_po_dtl_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 25
		String strProcName3 = "{call PKG_MMS_DML.dml_hstt_potype_component_mst(?,?,?,?,?,?,?,?)}"; // 8
		
		boolean flag = false;																								// Variables

		HisDAO dao = null;
		int nProcIndex = 0;
		int nProcIndex1 = 0;
		int nProc3Index = 0;
		String strErr = "";
		String strPONo = "";

		try 
		{
			dao = new HisDAO("MMS","transactions.PODeskGenerateTransNewDAO.insert()");
			_PODeskGenerateTransNewVO.setStrPOTypeId(_PODeskGenerateTransNewVO.getStrPOTypeId().split("\\^")[0]);

			strPONo = getPONo(_PODeskGenerateTransNewVO);
			_PODeskGenerateTransNewVO.setStrPONo(strPONo);
			// //System.out.println("Po No:::"+strPONo);
			// //System.out.println("Period
			// Value:::"+_PODeskGenerateTransNewVO.getStrPOFinancialDtl());
			// //System.out.println("po_store_id:::"+_PODeskGenerateTransNewVO.getStrStoreId());
			// //System.out.println("po_type_id::::"+_PODeskGenerateTransNewVO.getStrComboPOTypeId().split("\\^")[0]);
			// //System.out.println("del_store_id::::"+_PODeskGenerateTransNewVO.getStrDDeliveryLocation());
			// //System.out.println("supplier_id:::"+_PODeskGenerateTransNewVO.getStrSupplierId().split("\\^")[0]);
			// //System.out.println("po_date::::"+_PODeskGenerateTransNewVO.getStrComboPOTypeId().split("\\^")[0]);
			// //System.out.println("delivery_days::::"+_PODeskGenerateTransNewVO.getStrDDeliveryDays());
			// //System.out.println("item_id:::"+_PODeskGenerateTransNewVO.getStrPOItemID().split("\\^")[2]);
			// //System.out.println("item_brand_id:::"+_PODeskGenerateTransNewVO.getStrPOItemID().split("\\^")[0]);
			// //System.out.println("rate::::"+_PODeskGenerateTransNewVO.getStrItemRate());
			// //System.out.println("rateUnitId::::"+_PODeskGenerateTransNewVO.getStrItemRateUnitId().split("\\^")[0]);
			// //System.out.println("itemMake:::"+_PODeskGenerateTransNewVO.getStrItemMake());
			// //System.out.println("rateTax:::"+_PODeskGenerateTransNewVO.getStrItemRateTax());

			String strFinancialStartDate = "01-Apr"+ "-"+_PODeskGenerateTransNewVO.getStrPOFinancialDtl().split("\\-")[0].trim();
			String strFinancialEndDate = "31-Mar"+ "-"+ _PODeskGenerateTransNewVO.getStrPOFinancialDtl().split("\\-")[1].trim();
			

			for (int nTmpI = 0; nTmpI < _PODeskGenerateTransNewVO.getStrQrderQty().length; nTmpI++) 
			{
				
				if (!_PODeskGenerateTransNewVO.getStrQrderQty()[nTmpI].equals("0")) 
				{
					nProcIndex = dao.setProcedure(strProcName);
					dao.setProcInValue(nProcIndex, "modeval", "1",1); // 1
					dao.setProcInValue(nProcIndex, "pono", strPONo,2);// 2
					dao.setProcInValue(nProcIndex, "po_store_id",	_PODeskGenerateTransNewVO.getStrStoreId(),3);// 3
					dao.setProcInValue(nProcIndex, "scheduleNo", ""	+ (nTmpI + 1),4);// 4
					dao.setProcInValue(nProcIndex, "hosp_code",	_PODeskGenerateTransNewVO.getStrHospitalCode(),5);// 5
					dao.setProcInValue(nProcIndex, "item_cat",	_PODeskGenerateTransNewVO.getStrItemCat(),6);// 6
					dao.setProcInValue(nProcIndex, "po_type_id",_PODeskGenerateTransNewVO.getStrPOTypeId().split("\\^")[0],7);// 7
					dao.setProcInValue(nProcIndex, "del_store_id",_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[8],8);// 8
					// //System.out.println("Delivery
					// Location:::"+_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[8]);
					dao.setProcInValue(nProcIndex, "supplier_id",_PODeskGenerateTransNewVO.getStrSupplierId().split("\\^")[0],9);// 9
					dao.setProcInValue(nProcIndex, "po_date",_PODeskGenerateTransNewVO.getStrPORefrenceDate(),10);// 10
					dao.setProcInValue(nProcIndex, "delivery_date",	_PODeskGenerateTransNewVO.getStrDDeliveryDays(),11);// 11
					dao.setProcInValue(nProcIndex, "item_id",_PODeskGenerateTransNewVO.getStrPOItemID().split("\\^")[2],12);// 12
					dao.setProcInValue(nProcIndex, "itemBrand_id",_PODeskGenerateTransNewVO.getStrPOItemID().split("\\^")[0],13);// 13
					dao.setProcInValue(nProcIndex, "orderQty",_PODeskGenerateTransNewVO.getStrQrderQty()[nTmpI],14);// 14
					dao.setProcInValue(nProcIndex, "rate",	_PODeskGenerateTransNewVO.getStrItemRate(),15);// 15
					dao.setProcInValue(nProcIndex, "rateUnitId",_PODeskGenerateTransNewVO.getStrItemRateUnitId().split("\\^")[0],16);// 16
					dao.setProcInValue(nProcIndex, "itemMake",_PODeskGenerateTransNewVO.getStrItemMake(),17);// 17
					dao.setProcInValue(nProcIndex, "rateTax",_PODeskGenerateTransNewVO.getStrItemRateTax(),18);// 18
					dao.setProcInValue(nProcIndex, "manufId",_PODeskGenerateTransNewVO.getStrItemManufacturerId(),19);// 19
					dao.setProcInValue(nProcIndex, "fin_start_date",strFinancialStartDate.trim(),20);// 20
					dao.setProcInValue(nProcIndex, "fin_end_date",strFinancialEndDate.trim(),21);// 21
					dao.setProcInValue(nProcIndex, "po_remarks",_PODeskGenerateTransNewVO.getStrDRemarks(),22);// 22
					dao.setProcInValue(nProcIndex, "seat_id",_PODeskGenerateTransNewVO.getStrSeatId(),23);// 23
					
					 // Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) + Order Qty(7) +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
					////System.out.println("Value==>"+_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI]);
					dao.setProcInValue(nProcIndex, "totDemandedQty",_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[1],24);// 24
					dao.setProcInValue(nProcIndex, "totOrderedQty",(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[2]).split("\\#")[0],25);// 25
					dao.setProcInValue(nProcIndex, "totSuppQty",(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[2]).split("\\#")[1],26);// 26
					dao.setProcInValue(nProcIndex, "totIssuedQty",_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[3],27);// 27
					dao.setProcInValue(nProcIndex, "totPipelineQty",_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[10],28);// 28
					dao.setProcInValue(nProcIndex, "totInHandQty",(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[4]).split("\\#")[0],29);// 29
					dao.setProcInValue(nProcIndex, "totQuarQty",(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[4]).split("\\#")[1],30);// 30
					dao.setProcInValue(nProcIndex, "totSubStrInHandQty",_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[9],31);// 31
					dao.setProcInValue(nProcIndex, "reorderQty","0",32);// 32
					dao.setProcInValue(nProcIndex, "schorderqty1","0",33);// 33
					dao.setProcInValue(nProcIndex, "schorderqty2","0",34);// 34
					dao.setProcInValue(nProcIndex, "schorderqty3","0",35);// 35
					dao.setProcInValue(nProcIndex, "schorderqty4","0",36);// 36
					dao.setProcInValue(nProcIndex, "schaccqty1","0",37);// 37
					dao.setProcInValue(nProcIndex, "schaccqty2","0",38);// 38
					dao.setProcInValue(nProcIndex, "schaccqty3","0",39);// 39
					dao.setProcInValue(nProcIndex, "schaccqty4","0",40);// 40
					dao.setProcInValue(nProcIndex, "schrejqty1","0",41);// 41
					dao.setProcInValue(nProcIndex, "schrejqty2","0",42);// 42
					dao.setProcInValue(nProcIndex, "schrejqty3","0",43);// 43
					dao.setProcInValue(nProcIndex, "schrejqty4","0",44);// 44
					dao.setProcInValue(nProcIndex, "verifyby",_PODeskGenerateTransNewVO.getStrVerifiedBy(),45);// 45
					
					dao.setProcOutValue(nProcIndex, "err", 1,46);// 46
					dao.execute(nProcIndex, 1);
					
				}
			}

			nProcIndex1 = dao.setProcedure(strProcName1);
			dao.setProcInValue(nProcIndex1, "modeval", "1",1); // 1
			dao.setProcInValue(nProcIndex1, "pono", strPONo,2); // 2
			dao.setProcInValue(nProcIndex1, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),3); // 3
			dao.setProcInValue(nProcIndex1, "item_cat", _PODeskGenerateTransNewVO.getStrItemCat(),4); // 4
			dao.setProcInValue(nProcIndex1, "po_type_id",_PODeskGenerateTransNewVO.getStrPOTypeId().split("\\^")[0],5); // 5s
			if (_PODeskGenerateTransNewVO.getStrPOTypeId().split("\\^")[0].equals("24")) 
			{
				dao.setProcInValue(nProcIndex1, "currency_value",_PODeskGenerateTransNewVO.getStrDCurrencyValue(),18);// 6
				dao.setProcInValue(nProcIndex1, "currency_id",_PODeskGenerateTransNewVO.getStrDCurrencyName(),6);// 7
			} 
			else 
			{
				dao.setProcInValue(nProcIndex1, "currency_value", "1",18);// 6
				dao.setProcInValue(nProcIndex1, "currency_id", "100",6);// 7
			}
			dao.setProcInValue(nProcIndex1, "pur_source",_PODeskGenerateTransNewVO.getStrDPurchaseSource(),7);// 8
			dao.setProcInValue(nProcIndex1, "store_id", _PODeskGenerateTransNewVO.getStrStoreId(),8);// 9
			dao.setProcInValue(nProcIndex1, "supplier", _PODeskGenerateTransNewVO.getStrSupplierId().split("\\^")[0],9);// 10
			dao.setProcInValue(nProcIndex1, "po_Date", _PODeskGenerateTransNewVO.getStrPORefrenceDate(),10);// 11
			dao.setProcInValue(nProcIndex1, "tender_no", _PODeskGenerateTransNewVO.getStrDTenderNo(),11);// 12
			dao.setProcInValue(nProcIndex1, "tender_date",_PODeskGenerateTransNewVO.getStrDTenderDate(),12);// 13
			dao.setProcInValue(nProcIndex1, "quotation_no",_PODeskGenerateTransNewVO.getStrDQuotationNo(),13);// 14
			dao.setProcInValue(nProcIndex1, "quotation_date",_PODeskGenerateTransNewVO.getStrDQuotationDate(),14); // 15
			dao.setProcInValue(nProcIndex1, "fin_start_date",strFinancialStartDate.trim(),15);// 16
			dao.setProcInValue(nProcIndex1, "fin_end_date", strFinancialEndDate.trim(),16);// 17
			dao.setProcInValue(nProcIndex1, "po_remarks",_PODeskGenerateTransNewVO.getStrDRemarks(),17);// 18
			dao.setProcInValue(nProcIndex1, "seat_id", _PODeskGenerateTransNewVO.getStrSeatId(),19);// 19
			dao.setProcInValue(nProcIndex1, "tax", _PODeskGenerateTransNewVO.getStrDOverAllTax(),20);// 20
			dao.setProcInValue(nProcIndex1, "verified_by",_PODeskGenerateTransNewVO.getStrVerifiedBy(),21);// 21
			dao.setProcInValue(nProcIndex1, "verified_date",_PODeskGenerateTransNewVO.getStrVerifiedDate(),22);// 22
			dao.setProcInValue(nProcIndex1, "ipaddr", "0",23);// 23
			dao.setProcInValue(nProcIndex1, "po_prefix", _PODeskGenerateTransNewVO.getStrPoRefrenceNo(),24);// 24
			dao.setProcInValue(nProcIndex1, "new_po_date","0",25);// 24
			dao.setProcOutValue(nProcIndex1, "err", 1,26); // 25

			dao.execute(nProcIndex1, 1);

			if (_PODeskGenerateTransNewVO.getStrDComponentId() != null) 
			{
				for (int nTmpI = 0, stopNTmp = _PODeskGenerateTransNewVO.getStrDComponentId().length; nTmpI < stopNTmp; nTmpI++) 
				{
					nProc3Index = dao.setProcedure(strProcName3);

					dao.setProcInValue(nProc3Index, "modeval", "1",1);
					dao.setProcInValue(nProc3Index, "pono", strPONo,2);
					dao.setProcInValue(nProc3Index, "store_id",	_PODeskGenerateTransNewVO.getStrStoreId(),3);
					if (_PODeskGenerateTransNewVO.getStrDComponentValue()[nTmpI].length() > 3999) 
					{
						dao.setProcInValue(nProc3Index, "comp_value1",_PODeskGenerateTransNewVO.getStrDComponentValue()[nTmpI].substring(0, 3999),4);
						dao.setProcInValue(nProc3Index, "comp_value2",_PODeskGenerateTransNewVO.getStrDComponentValue()[nTmpI].substring(4000),5);
					} 
					else 
					{
						dao.setProcInValue(nProc3Index, "comp_value1",_PODeskGenerateTransNewVO.getStrDComponentValue()[nTmpI],4);
						dao.setProcInValue(nProc3Index, "comp_value2", "0",5);
					}
					dao.setProcInValue(nProc3Index, "hosp_code",_PODeskGenerateTransNewVO.getStrHospitalCode(),6);
					dao.setProcInValue(nProc3Index, "comp_id",_PODeskGenerateTransNewVO.getStrDComponentId()[nTmpI],7);
					
					
					dao.setProcOutValue(nProc3Index, "err", 1,8);

					dao.execute(nProc3Index, 1);
				}
			}

			dao.fire();
			flag = true;

			if (strErr != null && !strErr.equals(""))
			{	
			    flag = false;
				throw new Exception(strErr);
			}				
			if(flag)
			{
				_PODeskGenerateTransNewVO.setStrMobileMsgMode("1");
				//PODeskGenerateTransNewDAO.getMobileMsgDtl(_PODeskGenerateTransNewVO);				
			}
		} 
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			_PODeskGenerateTransNewVO.setStrMsgString("PODeskGenerateTransNewDAO.insert() --> "+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
	
	
	public static void getMobileMsgDtl(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) 
	{
		String strProcName = "{? = call MMS_MST.MOB_SMS_MSG(?,?,?,?)}";
		HisDAO dao = null;
		int funcIndex = 0;
		String strReturnMsg = "";
		try 
		{
			dao = new HisDAO("MMS","transactions.PODeskGenerateTransNewDAO.getMobileMsgDtl()");

			funcIndex = dao.setFunction(strProcName);
			dao.setFuncInValue(funcIndex, 2, _PODeskGenerateTransNewVO.getStrMobileMsgMode());
			dao.setFuncInValue(funcIndex, 3, _PODeskGenerateTransNewVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, _PODeskGenerateTransNewVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 5, _PODeskGenerateTransNewVO.getStrPONo());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strReturnMsg = dao.getFuncString(funcIndex);
			////System.out.println("strReturnMsg==>"+strReturnMsg);
			if(!strReturnMsg.split("\\^")[0].equals("")||!strReturnMsg.split("\\^")[0].equals("0"))
			{
				
				_PODeskGenerateTransNewVO.setStrMobileNoList(strReturnMsg.split("\\^")[0]);
				_PODeskGenerateTransNewVO.setStrMobileMsg(strReturnMsg.split("\\^")[1]);
				_PODeskGenerateTransNewVO.setStrMobileUserName((strReturnMsg.split("\\^")[2]).split("\\@")[0]);
				_PODeskGenerateTransNewVO.setStrMobilePwd((strReturnMsg.split("\\^")[2]).split("\\@")[1]);
				_PODeskGenerateTransNewVO.setStrMobileSenderId((strReturnMsg.split("\\^")[2]).split("\\@")[2]);
			}

		} 
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			_PODeskGenerateTransNewVO.setStrMsgString("PODeskGenerateTransNewDAO.getMobileMsgDtl() --> "+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
	
	

	public synchronized static void updateNewPO(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) 
	{
		String strProcName = "{call PKG_MMS_DML.dml_po_item_dtl_new(?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,   ?,?,?,?,?,?,?,?,?,?,   ?,?,?,?,?,?,?,?,?,?,   ?,?,?,?,?,?)}";// 46 Variables
		String strProcName1 = "{call PKG_MMS_DML.dml_po_dtl_new(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 25
		
		
		HisDAO dao = null;
		int nProcIndex = 0;
		int nProcIndex1 = 0;
        int  scheduleNo = 1; 
		String strErr = "";
		String strPONo = "";
		boolean flag = false;	
		try 
		{
			dao = new HisDAO("MMS",	"transactions.PODeskGenerateTransNewDAO.insert()");

			// (1)PO_DATE ^ (2)SUPP NAME ^ (3)PO TYPE ^ (4)CURRENCY CODE ^(5)
			// NET ADVANCE
			// ^ (6)PO NET AMOUNT ^(7) SUPPLIER ID ^(8) PO Type ^ (9)Currency Id
			// ^(10) Currency Value ^(11) Item Catg No
			// ^ (12)Catg Name ^ (13)Purchase Source ID ^ (14)Purchase Source
			// Name ^ (15)Currency Id ^(16) Currency Value
			// ^ (17)Advance Amt ^ (18)PO Prefix With PO No ^ (19)Delivery Date
			// ^ (20)PO PreFix ^ (21)TAX
			// ^ (22)Tender No ^ (23)Tender Date ^ (24)Qutation No ^
			// (25)Qutation Date ^ (26) PO Date ^ (27) Verify Date ^ (28) Verify
			// BY
			// ^ (29) Financial Start Date ^ (30) Financial End Date
			// //System.out.println("PO
			// No:::"+_PODeskGenerateTransNewVO.getStrPONo());
			// //System.out.println("po_store_id:::"+_PODeskGenerateTransNewVO.getStrStoreId());
			// //System.out.println("po_type_id::::"+_PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[2]);
			// //System.out.println("supplier_id:::"+_PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[6]);
			// //System.out.println("po_date::::"+_PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[0]);
			// //System.out.println("delivery_days::::"+_PODeskGenerateTransNewVO.getStrDDeliveryDays());
			// //System.out.println("item_id:::"+_PODeskGenerateTransNewVO.getStrPOItemID().split("\\@")[1]);
			// //System.out.println("item_brand_id:::"+_PODeskGenerateTransNewVO.getStrPOItemID().split("\\@")[0]);
			// //System.out.println("rate::::"+_PODeskGenerateTransNewVO.getStrItemRate());
			// //System.out.println("rateUnitId::::"+_PODeskGenerateTransNewVO.getStrItemRateUnitId().split("\\^")[0]);
			// //System.out.println("itemMake:::"+_PODeskGenerateTransNewVO.getStrItemMake());
			// //System.out.println("rateTax:::"+_PODeskGenerateTransNewVO.getStrItemRateTax());
			// //System.out.println("Fin Start
			// Date::::"+_PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[28].trim());
			// //System.out.println("Fin End
			// Date::::"+_PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[29].trim());

			String strFinancialStartDate = _PODeskGenerateTransNewVO
					.getStrPOHiddenValue().split("\\^")[28].trim();
			String strFinancialEndDate = _PODeskGenerateTransNewVO
					.getStrPOHiddenValue().split("\\^")[29].trim();
			nProcIndex = dao.setProcedure(strProcName);

			for (int nTmpI = 0; nTmpI < _PODeskGenerateTransNewVO.getStrQrderQty().length; nTmpI++) 
			{
				if (!_PODeskGenerateTransNewVO.getStrQrderQty()[nTmpI].equals("0")) 
				{
					dao.setProcInValue(nProcIndex, "modeval", "2",1); // 1
					dao.setProcInValue(nProcIndex, "pono",_PODeskGenerateTransNewVO.getStrPONo(),2);// 2
					dao.setProcInValue(nProcIndex, "po_store_id",_PODeskGenerateTransNewVO.getStrStoreId(),3);// 3
					dao.setProcInValue(nProcIndex, "scheduleNo", ""	+ scheduleNo++,4);// 4
					dao.setProcInValue(nProcIndex, "hosp_code",	_PODeskGenerateTransNewVO.getStrHospitalCode(),5);// 5
					dao.setProcInValue(nProcIndex, "item_cat",_PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[10],6);// 6
					dao.setProcInValue(nProcIndex, "po_type_id",_PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[7],7);// 7
					dao.setProcInValue(nProcIndex, "del_store_id",_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[8],8);// 8
					dao.setProcInValue(nProcIndex, "supplier_id",_PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[6],9);// 9
					dao.setProcInValue(nProcIndex, "po_date",_PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[0],10);// 10
					dao.setProcInValue(nProcIndex, "delivery_date",_PODeskGenerateTransNewVO.getStrDDeliveryDays(),11);// 11
					dao.setProcInValue(nProcIndex, "item_id",_PODeskGenerateTransNewVO.getStrPOItemID().split("\\@")[1],12);// 12
					dao.setProcInValue(nProcIndex, "itemBrand_id",_PODeskGenerateTransNewVO.getStrPOItemID().split("\\@")[0],13);// 13
					dao.setProcInValue(nProcIndex, "orderQty",_PODeskGenerateTransNewVO.getStrQrderQty()[nTmpI],14);// 14
					dao.setProcInValue(nProcIndex, "rate",_PODeskGenerateTransNewVO.getStrItemRate(),15);// 15
					dao.setProcInValue(nProcIndex, "rateUnitId",_PODeskGenerateTransNewVO.getStrItemRateUnitId().split("\\^")[0],16);// 16
					dao.setProcInValue(nProcIndex, "itemMake",_PODeskGenerateTransNewVO.getStrItemMake(),17);// 17
					dao.setProcInValue(nProcIndex, "rateTax",_PODeskGenerateTransNewVO.getStrItemRateTax(),18);// 18
					dao.setProcInValue(nProcIndex, "manufId",_PODeskGenerateTransNewVO.getStrItemManufacturerId(),19);// 19
					dao.setProcInValue(nProcIndex, "fin_start_date",strFinancialStartDate.trim(),20);// 20
					dao.setProcInValue(nProcIndex, "fin_end_date",strFinancialEndDate.trim(),21);// 21
					dao.setProcInValue(nProcIndex, "po_remarks",_PODeskGenerateTransNewVO.getStrDRemarks(),22);// 22
					dao.setProcInValue(nProcIndex, "seat_id",_PODeskGenerateTransNewVO.getStrSeatId(),23);// 23
					
			        // Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) +[Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [I] +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
	        	    //                                                                                                                                         [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [II]
	        	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [III]
	        	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [IV]
					////System.out.println("Value==>"+_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI]);
					dao.setProcInValue(nProcIndex, "totDemandedQty",_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[1],24);// 24
					dao.setProcInValue(nProcIndex, "totOrderedQty",(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[2]).split("\\#")[0],25);// 25
					dao.setProcInValue(nProcIndex, "totSuppQty",(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[2]).split("\\#")[1],26);// 26
					dao.setProcInValue(nProcIndex, "totIssuedQty",_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[3],27);// 27
					dao.setProcInValue(nProcIndex, "totPipelineQty",_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[10],28);// 28
					dao.setProcInValue(nProcIndex, "totInHandQty",(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[4]).split("\\#")[0],29);// 29
					dao.setProcInValue(nProcIndex, "totQuarQty",(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[4]).split("\\#")[1],30);// 30
					dao.setProcInValue(nProcIndex, "totSubStrInHandQty",_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[9],31);// 31
					dao.setProcInValue(nProcIndex, "reorderQty",_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[5],32);// 32
					
//					//System.out.println("schOrderQty1==>"+_PODeskGenerateTransNewVO.getStrScheduleOne()[nTmpI]);
//					//System.out.println("schOrderQty2==>"+_PODeskGenerateTransNewVO.getStrScheduleTwo()[nTmpI]);
//					//System.out.println("schOrderQty3==>"+_PODeskGenerateTransNewVO.getStrScheduleThree()[nTmpI]);
//					//System.out.println("schOrderQty4==>"+_PODeskGenerateTransNewVO.getStrScheduleFour()[nTmpI]);
					
					
					dao.setProcInValue(nProcIndex, "schOrderQty1","0",33);//_PODeskGenerateTransNewVO.getStrScheduleOne()[nTmpI],33);// 33
					dao.setProcInValue(nProcIndex, "schOrderQty2","0",34);//_PODeskGenerateTransNewVO.getStrScheduleTwo()[nTmpI],34);// 34
					dao.setProcInValue(nProcIndex, "schOrderQty3","0",35);//_PODeskGenerateTransNewVO.getStrScheduleThree()[nTmpI],35);// 35
					dao.setProcInValue(nProcIndex, "schOrderQty4","0",36);//_PODeskGenerateTransNewVO.getStrScheduleFour()[nTmpI],36);// 36
			        ////System.out.println("SOP==>"+_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI]);
					
//					//System.out.println("schAccQty1==>"+(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[2]);
//					//System.out.println("schAccQty2==>"+(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[6]);
//					//System.out.println("schAccQty3==>"+(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[10]);
//					//System.out.println("schAccQty4==>"+(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[14]);
					
					
					dao.setProcInValue(nProcIndex, "schAccQty1","0",37);//(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[2],37);// 37
					dao.setProcInValue(nProcIndex, "schAccQty2","0",38);//(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[6],38);// 38
					dao.setProcInValue(nProcIndex, "schAccQty3","0",39);//(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[10],39);// 39
					dao.setProcInValue(nProcIndex, "schAccQty4","0",40);//(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[14],40);// 40

//					//System.out.println("schRejQty1==>"+(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[3]);
//					//System.out.println("schRejQty2==>"+(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[7]);
//					//System.out.println("schRejQty3==>"+(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[11]);
//					//System.out.println("schRejQty4==>"+(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[15]);
					
					dao.setProcInValue(nProcIndex, "schRejQty1","0",41);//(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[3],41);// 41
					dao.setProcInValue(nProcIndex, "schRejQty2","0",42);//(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[7],42);// 42
					dao.setProcInValue(nProcIndex, "schRejQty3","0",43);//(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[11],43);// 43
					dao.setProcInValue(nProcIndex, "schRejQty4","0",44);//(_PODeskGenerateTransNewVO.getStrPODetailsHidValue()[nTmpI].split("\\^")[6]).split("\\#")[15],44);// 44
					
					dao.setProcInValue(nProcIndex, "verifyBy",_PODeskGenerateTransNewVO.getStrVerifiedBy(),45);// 45
                    
					
					dao.setProcOutValue(nProcIndex, "err", 1,46);// 46
					dao.execute(nProcIndex, 1);
				}
			}

			// (1)PO_DATE ^ (2)SUPP NAME ^ (3)PO TYPE ^ (4)CURRENCY CODE ^(5)
			// NET ADVANCE
			// ^ (6)PO NET AMOUNT ^(7) SUPPLIER ID ^(8) PO Type ^ (9)Currency Id
			// ^(10) Currency Value ^(11) Item Catg No
			// ^ (12)Catg Name ^ (13)Purchase Source ID ^ (14)Purchase Source
			// Name ^ (15)Currency Id ^(16) Currency Value
			// ^ (17)Advance Amt ^ (18)PO Prefix With PO No ^ (19)Delivery Date
			// ^ (20)PO PreFix ^ (21)TAX
			// ^ (22)Tender No ^ (23)Tender Date ^ (24)Qutation No ^
			// (25)Qutation Date ^ (26) PO Date ^ (27) Verify Date ^ (28) Verify
			// BY
			// ^ (29) Financial Start Date ^ (30) Financial End Date

			nProcIndex1 = dao.setProcedure(strProcName1);

			dao.setProcInValue(nProcIndex1, "modeval", "2",1); // 1
			dao.setProcInValue(nProcIndex1, "pono", _PODeskGenerateTransNewVO.getStrPONo(),2); // 2
			dao.setProcInValue(nProcIndex1, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),3); // 3
			dao.setProcInValue(nProcIndex1, "item_cat", _PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[10],4); // 4
			dao.setProcInValue(nProcIndex1, "po_type_id",_PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[7],5); // 5
			dao.setProcInValue(nProcIndex1, "currency_value", "1",18);// 6
			dao.setProcInValue(nProcIndex1, "currency_id", "100",6);// 7
			dao.setProcInValue(nProcIndex1, "pur_source",_PODeskGenerateTransNewVO.getStrDPurchaseSource(),7);// 8
			dao.setProcInValue(nProcIndex1, "store_id", _PODeskGenerateTransNewVO.getStrStoreId(),8);// 9
			dao.setProcInValue(nProcIndex1, "supplier", _PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[6],9);// 10
			dao.setProcInValue(nProcIndex1, "po_Date", _PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[0],10);// 11
			dao.setProcInValue(nProcIndex1, "tender_no", _PODeskGenerateTransNewVO.getStrDTenderNo(),11);// 12
			dao.setProcInValue(nProcIndex1, "tender_date",_PODeskGenerateTransNewVO.getStrDTenderDate(),12);// 13
			dao.setProcInValue(nProcIndex1, "quotation_no",_PODeskGenerateTransNewVO.getStrDQuotationNo(),13);// 14
			dao.setProcInValue(nProcIndex1, "quotation_date",_PODeskGenerateTransNewVO.getStrDQuotationDate(),14); // 15
			dao.setProcInValue(nProcIndex1, "fin_start_date",strFinancialStartDate.trim(),15);// 16
			dao.setProcInValue(nProcIndex1, "fin_end_date", strFinancialEndDate.trim(),16);// 17
			dao.setProcInValue(nProcIndex1, "po_remarks",_PODeskGenerateTransNewVO.getStrDRemarks(),17);// 18
			dao.setProcInValue(nProcIndex1, "seat_id", _PODeskGenerateTransNewVO.getStrSeatId(),19);// 19
			dao.setProcInValue(nProcIndex1, "tax", _PODeskGenerateTransNewVO.getStrDOverAllTax(),20);// 20
			dao.setProcInValue(nProcIndex1, "verified_by",_PODeskGenerateTransNewVO.getStrVerifiedBy(),21);// 21
			dao.setProcInValue(nProcIndex1, "verified_date",_PODeskGenerateTransNewVO.getStrVerifiedDate(),22);// 22
			dao.setProcInValue(nProcIndex1, "ipaddr", "0",23);// 23
			dao.setProcInValue(nProcIndex1, "po_prefix", _PODeskGenerateTransNewVO.getStrPoRefrenceNo(),24);// 24
			dao.setProcInValue(nProcIndex1, "new_po_date", _PODeskGenerateTransNewVO.getStrPORefrenceDate(),25);// 24
			dao.setProcOutValue(nProcIndex1, "err", 1,26); // 25

			dao.execute(nProcIndex1, 1);

			dao.fire();
			flag = true;

			if (strErr != null && !strErr.equals(""))
			{	
			    flag = false;
				throw new Exception(strErr);
			}				
			if(flag)
			{
				_PODeskGenerateTransNewVO.setStrMobileMsgMode("2");
				//PODeskGenerateTransNewDAO.getMobileMsgDtl(_PODeskGenerateTransNewVO);
			}

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.updateNewPO() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getDWHList(PODeskGenerateTransNewVO voObj) {

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
			//System.out.println("po_type_id"+ voObj.getStrPOTypeId());
			//System.out.println("supp_id"+voObj.getStrSupplierId());
			//System.out.println("finStartDate"+voObj.getStrFinancialStartDate());
			//System.out.println("finEndDate"+voObj.getStrFinancialToDate());
			
			
			
			
			
			
			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode(),1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "item_id", voObj.getStrItemId(),4);
			daoObj.setProcInValue(nProcIndex, "brandId", voObj.getStrItemBrandIds(),5);
			daoObj.setProcInValue(nProcIndex, "po_type_id", voObj.getStrPOTypeId(),6);
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
	
	public synchronized static void approvedPO(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) 
	{
		String strProcName1 = "{call PKG_MMS_DML.Update_PO_Approval(?,?,?,?,?,?,?,?,?)}";// 7 // Variables
		HisDAO dao = null;
		int nProcIndex = 0;
		int nProcIndex1 = 0;
        int  scheduleNo = 1; 
		String strErr = "";
		String strPONo = "";
		boolean flag = false;	
		try 
		{
			dao = new HisDAO("MMS",	"transactions.PODeskGenerateTransNewDAO.insert()");
			//System.out.println("_PODeskGenerateTransNewVO.getStrQrderQty()[0]"+_PODeskGenerateTransNewVO.getStrQrderQty()[0]);
			nProcIndex1 = dao.setProcedure(strProcName1);
			dao.setProcInValue(nProcIndex1, "modeval", "1",1); // 1
			dao.setProcInValue(nProcIndex1, "pono", _PODeskGenerateTransNewVO.getStrPONo(),2); // 2
			dao.setProcInValue(nProcIndex1, "hosp_code", _PODeskGenerateTransNewVO.getStrHospitalCode(),3); // 3		
			dao.setProcInValue(nProcIndex,  "po_store_id",_PODeskGenerateTransNewVO.getStrStoreId(),6);// 4
			dao.setProcInValue(nProcIndex1, "verified_by",_PODeskGenerateTransNewVO.getStrVerifiedBy(),4);// 5
			dao.setProcInValue(nProcIndex1, "verified_date",_PODeskGenerateTransNewVO.getStrVerifiedDate(),5);// 6
			dao.setProcInValue(nProcIndex1, "OrderQty",_PODeskGenerateTransNewVO.getStrQrderQty()[0] ,7);// 6
			dao.setProcInValue(nProcIndex1, "POValue",_PODeskGenerateTransNewVO.getStrTotalPOCost(),8);// 6
//			if(_PODeskGenerateTransNewVO.getStrApprovalType().equals("1"))
//			
//			dao.setProcInValue(nProcIndex1, "isReject","0",9);// 6 // Approval
//			else
//			dao.setProcInValue(nProcIndex1, "isReject","1",9);// 6	 //Rejection
				
			dao.setProcOutValue(nProcIndex1, "err", 1,9); // 7
			dao.executeProcedureByPosition(nProcIndex1);
			//dao.fire();
			flag = true;

			if (strErr != null && !strErr.equals(""))
			{	
			    flag = false;
				throw new Exception(strErr);
			}				
			if(flag)
			{
				_PODeskGenerateTransNewVO.setStrMobileMsgMode("2");
				//PODeskGenerateTransNewDAO.getMobileMsgDtl(_PODeskGenerateTransNewVO);
			}

		}
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewDAO.approvedPO() --> "
							+ _Err.getMessage());
			_PODeskGenerateTransNewVO.setStrMsgType("1");
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
	
	/*
	 * This Function is used to get Item Category Name by Passing 2 variable a)
	 * Hospital Code b) Item Category
	 */

	public static void getcallingItemCat(PODeskGenerateTransNewVO vo) {

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

	public static void getcallingPOType(PODeskGenerateTransNewVO vo) {

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
	

}
