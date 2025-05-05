/**
 * 
 */
package mms.transactions.dao;

import java.text.DecimalFormat;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.MmsConfigUtil;
import mms.transactions.vo.LocalPurchaseNewTransVO;
import mms.transactions.vo.SupplierReceiptVO;

/**
 * @author user
 *
 */
public class SupplierReceiptDAO {
	
	
	public static void getFinancialYear(SupplierReceiptVO vo) 
	{

		HisDAO dao = null;

		try 
		{

			dao = new HisDAO("mms", "LocalPurchaseNewTransDAO");

			String strFuncName = "{? = call mms_mst.get_financial_year_window(?::numeric)}";
			//FUNCTION get_groupNameAndId_dtl (modeval NUMBER, hosp_code NUMBER, itemId NUMBER)
			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");		
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);

			 String strCurrentFYYear = dao.getFuncString(nFuncIndex);
			 
			 System.out.println("strCurrentFYYear---->"+strCurrentFYYear);
			 
			 vo.setStrCurrentFYYear(strCurrentFYYear);
		

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("LocalPurchaseNewTransDAO.getGroupId() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void save(SupplierReceiptVO vo)
	{
		//String strProcName = "{call Pkg_Mms_dml.dml_hstt_lp_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?,?)}";  //30 variables ///////check this 
		HisDAO daoObj=null;
		int funcIndex=0;
		String lpno;	
		String strProcName1 ="";
		int nProcIndex = 0 , nProcIndex1 = 0;
		String strErr = "";
		WebRowSet ws = null;
		
		MmsConfigUtil mcu;
		//String ucNo;
		//String billtariff="",billrate="",billqty="";
	//	String item="";
		int i;
		//double netpo=0.0;
		//String[] hid=new String[vo.getStrSearchDrug().length];
		//String[] reqno=new String[1];
		//String[] storeid=new String[1];
		//String[] em=new String[1];
		String formattedRate = "0";
        String formattedRateWthTax = "0";
		try
		{		
			daoObj=new HisDAO("Local Purchase","LocalPurchaseNewTransDAO"); 
			funcIndex = daoObj.setFunction("{? = call MMS_MST.generate_lp_no1(?,?,?,?)}");

			daoObj.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex, 3, vo.getStrStoreId());
			daoObj.setFuncInValue(funcIndex, 4, "22");
			daoObj.setFuncInValue(funcIndex, 5, "10");
			daoObj.setFuncOutValue(funcIndex, 1);

			daoObj.executeFunction(funcIndex);
			
			lpno = daoObj.getFuncString(funcIndex);
			vo.setStrLPNo(lpno);
			mcu=new MmsConfigUtil(vo.getStrHospitalCode());
			
			for(i=1;i<vo.getStrSearchDrug().length;i++)
			{
				
				System.out.println("-----PoDate------"+vo.getStrPoDate());
				System.out.println("-----StrInvoiceDate------"+vo.getStrInvoiceDate());
				
				String strProcName = "{call Pkg_Mms_dml.dml_hstt_lp_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}";  //34 variables
				nProcIndex = daoObj.setProcedure(strProcName);
				
				
				    System.out.println("vo.getStrItemCategoryNo()----------------------->"+vo.getStrItemCategoryNo());
				    System.out.println("vo.getStrBrandId()[1]----------------------->"+vo.getStrBrandId()[1]);
				    System.out.println("vo.getStrMfgDate()[i]----------------------->"+vo.getStrMfgDate()[i]);
				    System.out.println("vo.getStrExpDate()[i]----------------------->"+vo.getStrExpDate()[i]); 
				    System.out.println("vo.getStrPurRate1()[i]----------------------->"+vo.getStrPurRate1()[i]); 
				    System.out.println("vo.getStrTotalQty()[i]----------------------->"+vo.getStrTotalQty()[i]); 
				    System.out.println("vo.getStarMRP()["+i+"]----------------------->"+vo.getStarMRP()[i]); 
				    
				    
				    System.out.println("-------lpno--------"+lpno);
				    
				    if(Double.parseDouble(vo.getStrPurRate1()[i]) >0 )
				    {	
				    	
					/*
					 * if (Double.parseDouble(strTotalQty[i]) != 0) { rate =
					 * Double.parseDouble(strPurRate1[i]) / Double.parseDouble(strTotalQty[i]); }
					 * else { throw new ArithmeticException("Total Quantity cannot be zero."); }
					 */

					    double rate = Double.parseDouble(vo.getStrPurRate1()[i]) / Double.parseDouble(vo.getStrTotalQty()[i]);
					    
					    double ratewthTax = rate + (rate* (Double.parseDouble(vo.getStrGST()[i])/100));
					    
					    System.out.println("ratewthTax------------A----------->"+(rate* (Double.parseDouble(vo.getStrGST()[i])/100)));
					    System.out.println("ratewthTax------------B----------->"+ratewthTax);
					    
				        DecimalFormat df = new DecimalFormat("########.######");			       
				        formattedRate = df.format(rate);
				        formattedRateWthTax = df.format(ratewthTax);
				        
				        System.out.println("rate----------------------->"+formattedRate); 
				        System.out.println("ratewthTax----------------------->"+formattedRateWthTax);
				    }
				    else
				    {
				    	    formattedRate = "0";
					        formattedRateWthTax = "0";
				    }

					daoObj.setProcInValue(nProcIndex, "modval", 		"3",1);
					
					daoObj.setProcInValue(nProcIndex, "store_id",		vo.getStrStoreId(),2);
					daoObj.setProcInValue(nProcIndex, "item_id",		vo.getStarMRP()[i],3);
					daoObj.setProcInValue(nProcIndex, "itembrand_id",	vo.getStrBrandId()[i],4);
					daoObj.setProcInValue(nProcIndex, "batchsl_no",		vo.getStrbatchno()[i],5);
					daoObj.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode(),6);
					daoObj.setProcInValue(nProcIndex, "item_cat_code", 	vo.getStrItemCategoryNo(),7);
					daoObj.setProcInValue(nProcIndex, "group_id",		vo.getStrManufacturer(),8);  // Pass ManufactreId Here 
					daoObj.setProcInValue(nProcIndex, "subgroup_id",	(vo.getStrExpDeliveryDate() == null || vo.getStrExpDeliveryDate().equals(""))?vo.getStrInvoiceDate():vo.getStrExpDeliveryDate(),9); // Pass Expected Delivery Date
					daoObj.setProcInValue(nProcIndex, "supplier_id",	vo.getStrSupplier(),10);
					daoObj.setProcInValue(nProcIndex, "qty",			vo.getStrTotalQty()[i],11);
					daoObj.setProcInValue(nProcIndex, "qty_unitid",		"0",	12);
					daoObj.setProcInValue(nProcIndex, "expdate",		(vo.getStrExpDate()[i] == null || vo.getStrExpDate()[i].equals(""))?vo.getStrExpDate()[i]:vo.getStrExpDate()[i],13);
					daoObj.setProcInValue(nProcIndex, "mfgdate",		(vo.getStrMfgDate()[i] == null || vo.getStrMfgDate()[i].equals(""))?vo.getStrMfgDate()[i]:vo.getStrMfgDate()[i],14);
					//daoObj.setProcInValue(nProcIndex, "rate", 			(vo.getStrPurRate()[i] == null || vo.getStrPurRate()[i].equals(""))?"0":vo.getStrPurRate()[i],15);
					daoObj.setProcInValue(nProcIndex, "rate", 			formattedRate,15);
					daoObj.setProcInValue(nProcIndex, "rate_unitid",	"0",16);
					//daoObj.setProcInValue(nProcIndex, "saleprice",		(vo.getStrCosttoPat()[i] == null || vo.getStrCosttoPat()[i].equals(""))?"0":vo.getStrCosttoPat()[i],17);
					daoObj.setProcInValue(nProcIndex, "saleprice",		formattedRateWthTax,17);
					daoObj.setProcInValue(nProcIndex, "saleprice_unitid","0",18);
					daoObj.setProcInValue(nProcIndex, "seat_id", 		vo.getStrSeatId(),19);
					daoObj.setProcInValue(nProcIndex, "invno", 			vo.getStrInvoiceNo(),20);
					daoObj.setProcInValue(nProcIndex, "invdate", 		vo.getStrInvoiceDate(),21); 
					daoObj.setProcInValue(nProcIndex, "remarks",		(vo.getStrRemarks() == null || vo.getStrRemarks().equals(""))?"-":vo.getStrRemarks(),22); 
					daoObj.setProcInValue(nProcIndex, "dcno",			vo.getStrDCNo(),23); 
					daoObj.setProcInValue(nProcIndex, "challan_date",	vo.getStrChallanDate(),24); 
					daoObj.setProcInValue(nProcIndex, "adm_chg",		vo.getStrAdmchg()[i],25); 
					daoObj.setProcInValue(nProcIndex, "tax",			vo.getStrGST()[i],26); 

//					daoObj.setProcInValue(nProcIndex, "strMRP",			vo.getStrMRP(),26); 
					
					daoObj.setProcInValue(nProcIndex, "packsize",		"0",27); 
					
					/*
					 * Instead of Pack no. we pass Po Date on 01-08-2023
					 */
					
					daoObj.setProcInValue(nProcIndex, "packno",			vo.getStrPoDate(),28); 
					

					daoObj.setProcInValue(nProcIndex, "transno",		lpno,29); 
					
					daoObj.setProcInValue(nProcIndex, "pono",			vo.getStrLpoNo(),30); 
					daoObj.setProcInValue(nProcIndex, "strUcChk",		vo.getStrUcChk(),31); 					
					daoObj.setProcInValue(nProcIndex, "strInstituteId",	vo.getStrInstituteCombo(),32); 
					daoObj.setProcInValue(nProcIndex, "mrp", vo.getStarMRP() != null ? vo.getStarMRP()[i] : formattedRateWthTax,33);
					daoObj.setProcOutValue(nProcIndex, "err",1,34); 
					daoObj.execute(nProcIndex,1);
			
			}
				daoObj.fire();
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			if (strErr.equals("")) {
				vo.setStrMsgType("0");
							}
							else {
								throw new Exception(strErr);
							}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("SupplierReceiptDAO.stockDetails() --> "
					+ e.getMessage());
			
			vo.setStrMsgType("1");
		}
		
		
	}
	/**
	 * for getting  Supplier List on page from HSTT_Supplier_MST
	 * 
	 * @param vo
	 * @throws Exception
	 */
	
	
	
	
//	public static void getInstituteList(SupplierReceiptVO vo) {
//
//		String strproc_name = "";
//		HisDAO dao = null;
//		int nprocIndex = 0;
//		String strerr = "";
//		WebRowSet wb = null;
//
//		try {
//			dao = new HisDAO("mms", "LocalPurchaseMRN_DAO");
//			strproc_name = "{call PKG_MMS_VIEW.proc_institute_list(?,?,?,?)}"; //4
//			nprocIndex = dao.setProcedure(strproc_name);
//
//			dao.setProcInValue(nprocIndex, "modeval", "1",1);
//			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
//			dao.setProcOutValue(nprocIndex, "err", 1,3);
//			dao.setProcOutValue(nprocIndex, "resultset", 2,4);
//			dao.executeProcedureByPosition(nprocIndex);
//			strerr = dao.getString(nprocIndex, "err");
//			if (strerr == null)
//				strerr = "";
//			wb = dao.getWebRowSet(nprocIndex, "resultset");
//			if (strerr.equals("")) {
//
//				vo.setInstituteListWs(wb);
//
//			} else {
//				throw new Exception(strerr);
//			}
//		} catch (Exception e) {
//			vo
//					.setStrMsgString("LocalPurchaseNewTransDAO.getInstituteList() --> "
//							+ e.getMessage());
//			vo.setStrMsgType("1");
//		} finally {
//			if (dao != null) {
//				dao.free();
//				dao = null;
//			}
//		}
//	}
//	
	
	
	//------------------------------------insitute Dao-------------------------------------------------//
	public static void getInstituteList1(SupplierReceiptVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strproc_name = "{call PKG_MMS_VIEW.proc_institute_list(?,?,?,?)}"; //4
		int nprocIndex = 0;
	
		String strErr = "";

		try {

			dao = new HisDAO("MMS Transactions","LocalPurchaseNewTransDAO");

			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nprocIndex, "err", 1,3);
			dao.setProcOutValue(nprocIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nprocIndex);
			strErr = dao.getString(nprocIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = dao.getWebRowSet(nprocIndex, "resultset");
		
				vo.setStrSupplierWs1(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("LocalPurchaseNewTransDAO.getItemCatDtls() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}
	//-------------------------------------------------------END-------------------------------------------------
	
	
	
	
	
	
	public static void getSupplierList(SupplierReceiptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_supplier_list(?,?,?,?,? ,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","LocalPurchaseNewTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "20",1);
			daoObj.setProcInValue(nProcIndex, "catcode", voObj.getStrReqTypeId(),2);
			daoObj.setProcInValue(nProcIndex, "branditem_id", "0",3);
			daoObj.setProcInValue(nProcIndex, "contracttype", "12",4);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),5);
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrSupplierWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("LocalPurchaseNewTransDAO.getItemCatDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	/**
	 * for getting  Supplier List on page from HSTT_Supplier_MST
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getItemList(SupplierReceiptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_itembrand_list(?,?,?,?,? ,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","LocalPurchaseNewTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
            if(!voObj.getStrReqTypeId().equals("0"))
            {
            	daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
            }
            else
            {	
			    daoObj.setProcInValue(nProcIndex, "modeval", "8",1);
            }
				daoObj.setProcInValue(nProcIndex, "catcode", voObj.getStrReqTypeId(),2);
				daoObj.setProcInValue(nProcIndex, "branditem_id", "0",3);
				daoObj.setProcInValue(nProcIndex, "grpid", "0",4);
				daoObj.setProcInValue(nProcIndex, "subgrpid", "0",5);
				daoObj.setProcInValue(nProcIndex, "setflag", "0",6);
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),7);
				daoObj.setProcOutValue(nProcIndex, "err", 1,8);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);
	
				daoObj.executeProcedureByPosition(nProcIndex);
		
				strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setItemWS(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("LocalPurchaseNewTransDAO.getItemCatDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getPrintDetails(SupplierReceiptVO vo) {
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		System.out.println("---------SupplierReceiptDAO.getPrintDetails---[ PKG_MMS_VIEW.proc_hstt_Supplier_Receipt_dtl Mode - 1]-------");
		
		try {
			dao = new HisDAO("mms", "LocalPurchaseNewTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_hstt_Supplier_Receipt_dtl(?,?,?,?,? ,?)}";
			nprocIndex = dao.setProcedure(strproc_name);			
			
			dao.setProcInValue(nprocIndex, "modval", "1",1);
			dao.setProcInValue(nprocIndex, "strId", vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "lpno", vo.getStrLPNo(),3);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),4);	
			dao.setProcOutValue(nprocIndex, "err", 1,5);
			dao.setProcOutValue(nprocIndex, "resultset", 2,6);
			
			dao.executeProcedureByPosition(nprocIndex);
			
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {
				ws = dao.getWebRowSet(nprocIndex, "resultset");		
				vo.setWsPrint(ws);							
			} else {
				throw new Exception(strerr);
			}	

		} catch (Exception e) {
			vo.setStrMsgString("LocalPurchaseNewTransDAO.getPrintDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
}
