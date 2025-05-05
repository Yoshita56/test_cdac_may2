/**
 * 
 */
package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.MmsConfigUtil;
import mms.transactions.vo.LocalPurchaseNewTransVO;

/**
 * @author user
 *
 */
public class LocalPurchaseNewTransDAO {
	
	public static void getFinancialYear(LocalPurchaseNewTransVO vo) 
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
	public static void save(LocalPurchaseNewTransVO vo)
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
		try
		{							
			daoObj=new HisDAO("Local Purchase","LocalPurchaseNewTransDAO"); 
			funcIndex = daoObj.setFunction("{? = call MMS_MST.generate_lp_no1(?,?,?,?)}");

			daoObj.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex, 3, vo.getStrStoreId());
			daoObj.setFuncInValue(funcIndex, 4, "22");
			daoObj.setFuncInValue(funcIndex, 5, vo.getStrItemCategoryNo());
			daoObj.setFuncOutValue(funcIndex, 1);

			daoObj.executeFunction(funcIndex);
			
			lpno = daoObj.getFuncString(funcIndex);
			vo.setStrLPNo(lpno);
			mcu=new MmsConfigUtil(vo.getStrHospitalCode());
			
			   System.out.println("-------------Pkg_Mms_dml.dml_hstt_lp_dtl [ Mode - 6 ]------------");
			if(vo.getStrItemCategoryNo().equals("10"))
			{
			    System.out.println("-------------Pkg_Mms_dml.dml_stock_update_new_lp [ Mode - 1 ]------------");
			}
			else
			{
				System.out.println("-------------Pkg_Mms_dml.dml_new_recitem_stock_update_dtl [ Mode - 1 ]------------");
			}
			
			for(i=1;i<vo.getStrSearchDrug().length;i++)
			{
				String strProcName = "{call Pkg_Mms_dml.dml_hstt_lp_dtl(?,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";  //33 variables
				nProcIndex = daoObj.setProcedure(strProcName);
				System.out.println("vo.getStrItemCategoryNo()----------------------->"+vo.getStrItemCategoryNo());
				System.out.println("vo.getStrBrandId()[1]----------------------->"+vo.getStrBrandId()[1]);
				
				System.out.println("------------------------ DATE _ DTL ----------------------------");				
				System.out.println("vo.getStrInvoiceNo()----------invno------------->"+vo.getStrInvoiceNo());			
				System.out.println("vo.getStrPoDate()-------------dcno---------->"+vo.getStrDCNo());
				System.out.println("vo.getStrPoDate()----------------------->"+vo.getStrPoDate());				
				System.out.println("vo.getStrInvoiceDate()--------[ CHALLAN DATE  ]------invdate--------->"+vo.getStrInvoiceDate());
				System.out.println("vo.getStrChallanDate()--------[ PASS INV Date ]------challan_date--------->"+vo.getStrChallanDate());
				System.out.println("----------------------------------------------------");
				
				/*
					if(vo.getStrItemCategoryNo().equals("10"))
						daoObj.setProcInValue(nProcIndex, "modval", "1",1);
					else
						daoObj.setProcInValue(nProcIndex, "modval", "2",1);
						*/
				    daoObj.setProcInValue(nProcIndex, "modval",         "6",1);
				    daoObj.setProcInValue(nProcIndex, "store_id",		vo.getStrStoreId(),2);
					daoObj.setProcInValue(nProcIndex, "item_id",		"0",3);
					daoObj.setProcInValue(nProcIndex, "itembrand_id",	vo.getStrBrandId()[i],4);
					daoObj.setProcInValue(nProcIndex, "batchsl_no",		vo.getStrbatchno()[i],5);
					daoObj.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode(),6);
					daoObj.setProcInValue(nProcIndex, "item_cat_code", 	vo.getStrItemCategoryNo(),7);
					daoObj.setProcInValue(nProcIndex, "group_id",		vo.getStrManufacturer(),8);  // Pass ManufactreId Here 
					daoObj.setProcInValue(nProcIndex, "subgroup_id",	(vo.getStrExpDeliveryDate() == null || vo.getStrExpDeliveryDate().equals(""))?vo.getStrInvoiceDate():vo.getStrExpDeliveryDate(),9); // Pass Expected Delivery Date
					daoObj.setProcInValue(nProcIndex, "supplier_id",	vo.getStrSupplier(),10);
					daoObj.setProcInValue(nProcIndex, "qty",			vo.getStrTotalQty()[i],11);
					daoObj.setProcInValue(nProcIndex, "qty_unitid","0",	12);
					daoObj.setProcInValue(nProcIndex, "expdate",		(vo.getStrExpDate()[i] == null || vo.getStrExpDate()[i].equals(""))?vo.getStrExpDate()[i]:vo.getStrExpDate()[i],13);
					daoObj.setProcInValue(nProcIndex, "mfgdate",		(vo.getStrMfgDate()[i] == null || vo.getStrMfgDate()[i].equals(""))?vo.getStrMfgDate()[i]:vo.getStrMfgDate()[i],14);
					daoObj.setProcInValue(nProcIndex, "rate", 			(vo.getStrPurRate()[i] == null || vo.getStrPurRate()[i].equals(""))?"0":vo.getStrPurRate()[i],15);
					daoObj.setProcInValue(nProcIndex, "rate_unitid",	(vo.getStrModelId() == null || vo.getStrModelId().equals(""))?"0":vo.getStrModelId(),16);    // Pass Mode Id if Selected
					daoObj.setProcInValue(nProcIndex, "saleprice",		(vo.getStrCosttoPat()[i] == null || vo.getStrCosttoPat()[i].equals(""))?"0":vo.getStrCosttoPat()[i],17);
					daoObj.setProcInValue(nProcIndex, "saleprice_unitid","0",18);
					daoObj.setProcInValue(nProcIndex, "seat_id", 		vo.getStrSeatId(),19);
					daoObj.setProcInValue(nProcIndex, "invno", 			vo.getStrInvoiceNo(),20);
					daoObj.setProcInValue(nProcIndex, "invdate", 		vo.getStrInvoiceDate(),21); 
					daoObj.setProcInValue(nProcIndex, "remarks",		(vo.getStrRemarks() == null || vo.getStrRemarks().equals(""))?"-":vo.getStrRemarks(),22); 
					daoObj.setProcInValue(nProcIndex, "dcno",			vo.getStrDCNo(),23); 
					daoObj.setProcInValue(nProcIndex, "challan_date",	vo.getStrChallanDate(),24); 
					daoObj.setProcInValue(nProcIndex, "adm_chg",		"0",25); 
					daoObj.setProcInValue(nProcIndex, "tax",			vo.getStrGST()[i],26); 

//					daoObj.setProcInValue(nProcIndex, "strMRP",			vo.getStrMRP(),26); 
					
					daoObj.setProcInValue(nProcIndex, "packsize","0",27); 
					
					/*
					 * Instead of Pack no. we pass Po Date on 01-08-2023
					 */
					
					daoObj.setProcInValue(nProcIndex, "packno",vo.getStrPoDate(),28); 
					

					daoObj.setProcInValue(nProcIndex, "transno",		lpno,29); 
					
					daoObj.setProcInValue(nProcIndex, "pono",			vo.getStrLpoNo(),30); 
					daoObj.setProcInValue(nProcIndex, "strUcChk",		vo.getStrUcChk(),31); 					
					daoObj.setProcInValue(nProcIndex, "strInstituteId",vo.getStrInstituteCombo(),32); 					
					daoObj.setProcOutValue(nProcIndex, "err",1,33); 
					daoObj.execute(nProcIndex,1);
			
					if(vo.getStrItemCategoryNo().equals("10"))
					{
						strProcName1 = "{call PKG_MMS_DML.dml_stock_update_new_lp(?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,? ,?)}"; // 24+1 Variable, 1 var added to save purchase rate
	
						nProcIndex1 = daoObj.setProcedure(strProcName1);
						
						daoObj.setProcInValue(nProcIndex1, "modval",		"1",1); // 1
						daoObj.setProcInValue(nProcIndex1, "strId",			vo.getStrStoreId(),2); // 1
						daoObj.setProcInValue(nProcIndex1,"brandId",		vo.getStrBrandId()[i],3);// 2
						daoObj.setProcInValue(nProcIndex1, "v_batchNo",		vo.getStrbatchno()[i],4); // 3
						daoObj.setProcInValue(nProcIndex1, "expDate",		vo.getStrExpDate()[i],5); // 4
						daoObj.setProcInValue(nProcIndex1, "mfgDate",		vo.getStrMfgDate()[i],6); // 5
						daoObj.setProcInValue(nProcIndex1, "manufId",		vo.getStrSupplier(),7); // 6
						daoObj.setProcInValue(nProcIndex1, "activeQty",		vo.getStrTotalQty()[i],8); // 7
						daoObj.setProcInValue(nProcIndex1, "inactiveQty",	"0",9); // 8
						daoObj.setProcInValue(nProcIndex1, "quartineQty",	(vo.getStrModelId() == null || vo.getStrModelId().equals(""))?"0":vo.getStrModelId(),10); // 9
						daoObj.setProcInValue(nProcIndex1, "seatId",		vo.getStrSeatId(),11); // 10
						daoObj.setProcInValue(nProcIndex1, "rate",			vo.getStrCosttoPat()[i],12); // 12
						daoObj.setProcInValue(nProcIndex1, "rateUnitId",	"6303",13); // 13
						daoObj.setProcInValue(nProcIndex1, "tenderNo",		"0",14); // 15
						daoObj.setProcInValue(nProcIndex1, "poNo",			lpno,15); // 16
						daoObj.setProcInValue(nProcIndex1, "hosp_code",		vo.getStrHospitalCode(),16); // 17
						daoObj.setProcInValue(nProcIndex1, "supplierId",	vo.getStrSupplier(),17); // 18
						daoObj.setProcInValue(nProcIndex1, "prgid",			"0",18); // 17
						daoObj.setProcInValue(nProcIndex1, "existingbatch",	"0",19); // 18
						daoObj.setProcInValue(nProcIndex1, "existstockstatus", "10",20); // 19	
						daoObj.setProcInValue(nProcIndex1, "dcno", 			vo.getStrDCNo(),21);
						daoObj.setProcInValue(nProcIndex1, "invoiceno", 	vo.getStrInvoiceNo(),22);
						daoObj.setProcInValue(nProcIndex1, "invoicedate", 	vo.getStrInvoiceDate(),23);
						daoObj.setProcInValue(nProcIndex1, "purrate",		vo.getStrPurRate()[i],24); // 23
						daoObj.setProcInValue(nProcIndex1, "handlingcharges",vo.getStrAdmchg()[i],25); // 11
						daoObj.setProcInValue(nProcIndex1, "purtax",		vo.getStrGST()[i],26); // 11
						daoObj.setProcInValue(nProcIndex1, "flag","0",27); // 11  added to chk whether data inserted offline ie from inventory process.
						
						daoObj.setProcInValue(nProcIndex1, "packsize","0",28);
						daoObj.setProcInValue(nProcIndex1, "packno","0",29);
						
						daoObj.setProcInValue(nProcIndex1, "invFlag","0",30);
						daoObj.setProcOutValue(nProcIndex1, "err", 1,31); // 18
						daoObj.execute(nProcIndex1, 1);
			        }
					else
					{
						//System.out.println("vo.getStrItemCategoryNo()"+vo.getStrItemCategoryNo());
						strProcName1 = "{call PKG_MMS_DML.dml_new_recitem_stock_update_dtl(?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}";
						nProcIndex1 = daoObj.setProcedure(strProcName1);
						daoObj.setProcInValue(nProcIndex1, "modval",		"1",1); // 1
						daoObj.setProcInValue(nProcIndex1, "strId",			vo.getStrStoreId(),2); // 1
						daoObj.setProcInValue(nProcIndex1, "brandId",		vo.getStrBrandId()[i],3);// 2
						daoObj.setProcInValue(nProcIndex1, "v_batchNo",		vo.getStrbatchno()[i],4); // 3
						daoObj.setProcInValue(nProcIndex1, "expDate",		vo.getStrExpDate()[i],5); // 4
						daoObj.setProcInValue(nProcIndex1, "mfgDate",		vo.getStrMfgDate()[i],6); // 5
						daoObj.setProcInValue(nProcIndex1, "manufId",		vo.getStrSupplier(),7); // 6
						daoObj.setProcInValue(nProcIndex1, "activeQty",		vo.getStrTotalQty()[i],8); // 7
						daoObj.setProcInValue(nProcIndex1, "inactiveQty",	"0",9); // 8
						daoObj.setProcInValue(nProcIndex1, "quartineQty",	(vo.getStrModelId() == null || vo.getStrModelId().equals(""))?"0":vo.getStrModelId(),10); // 9
						daoObj.setProcInValue(nProcIndex1, "seatId",		vo.getStrSeatId(),11); // 10
						daoObj.setProcInValue(nProcIndex1, "rate",			vo.getStrCosttoPat()[i],12); // 11
						daoObj.setProcInValue(nProcIndex1, "rateUnitId",	"6303",13); // 12
						daoObj.setProcInValue(nProcIndex1, "tenderNo",		"0",14); // 13
						daoObj.setProcInValue(nProcIndex1, "poNo",			lpno,15); // 14
						daoObj.setProcInValue(nProcIndex1, "hosp_code",		vo.getStrHospitalCode(),16); // 15
						daoObj.setProcInValue(nProcIndex1, "supplierId",	vo.getStrSupplier(),17); // 16
						daoObj.setProcInValue(nProcIndex1, "prgid",			"0",18); // 17
						daoObj.setProcInValue(nProcIndex1, "existingbatch",	"0",19); // 18
						daoObj.setProcInValue(nProcIndex1, "existstockstatus", "10",20); // 19
						daoObj.setProcInValue(nProcIndex1, "item_cat_no",	vo.getStrItemCategoryNo() ,21); // 20
						daoObj.setProcInValue(nProcIndex1, "dcno", 			vo.getStrDCNo(),22);
						daoObj.setProcInValue(nProcIndex1, "invoiceno", 	vo.getStrInvoiceNo(),23);
						daoObj.setProcInValue(nProcIndex1, "invoicedate", 	vo.getStrInvoiceDate(),24);
						daoObj.setProcInValue(nProcIndex1, "purrate",		vo.getStrPurWidTax()[i],25); // 11
						daoObj.setProcInValue(nProcIndex1, "handlingcharges",vo.getStrAdmchg()[i],26); // 11
						daoObj.setProcInValue(nProcIndex1, "tax",			vo.getStrGST()[i],27); // 11
						daoObj.setProcInValue(nProcIndex1, "invFlag",		"0",28);
						daoObj.setProcOutValue(nProcIndex1, "err", 1,29);
						daoObj.execute(nProcIndex1, 1);
					}
					
			}		
			
			daoObj.fire();			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			if (strErr.equals("")) 
			{
			    vo.setStrMsgType("0");
			}
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("LocalPurchaseNewTransDAO.stockDetails() --> "
					+ e.getMessage());
			
			vo.setStrMsgType("1");
		}
		
		
	}
	
	
	//------------------------------------insitute Dao-------------------------------------------------//
	public static void getInstituteList1(LocalPurchaseNewTransVO vo) {

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

	public static void getSupplierList(LocalPurchaseNewTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_supplier_list(?,?,?,?,? ,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","LocalPurchaseNewTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
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
	 * @param vo
	 * @throws Exception
	 */
	public static void getModelCombo(LocalPurchaseNewTransVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Mms_View2.proc_item_model_list(?,?,?,?,? ,?,?)}";  // 7
		int nProcIndex = 0;	
		String strErr = "";
		try 
		{
		
			daoObj = new HisDAO("MMS Transactions","LocalPurchaseNewTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", 	"1",1);
			daoObj.setProcInValue(nProcIndex, "brand_id", 	"0",2);
			daoObj.setProcInValue(nProcIndex, "cat_no", 	voObj.getStrReqTypeId(),3);
			daoObj.setProcInValue(nProcIndex, "group_id", 	"0",4);
			daoObj.setProcInValue(nProcIndex, "hosp_code", 	voObj.getStrHospitalCode(),5);
			daoObj.setProcOutValue(nProcIndex, "err", 		1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);
			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrModelWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			voObj.setStrMsgString("LocalPurchaseNewTransDAO.getModelCombo() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} 
		finally 
		{
			if (daoObj != null) 
			{
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
	public static void getItemList(LocalPurchaseNewTransVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_itembrand_list(?,?,?,?,? ,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try 
		{

			daoObj = new HisDAO("MMS Transactions","LocalPurchaseNewTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "9",1);
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
	
	
	/**
	 * for getting  Supplier List on page from HSTT_Supplier_MST
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getModelItemList(LocalPurchaseNewTransVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_itembrand_list(?,?,?,?,? ,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try 
		{

			daoObj = new HisDAO("MMS Transactions","LocalPurchaseNewTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", 		"10",1);
			daoObj.setProcInValue(nProcIndex, "catcode", 		voObj.getStrItemCategoryNo(),2);
			daoObj.setProcInValue(nProcIndex, "branditem_id", 	"0",3);
			daoObj.setProcInValue(nProcIndex, "grpid", 			"0",4);
			daoObj.setProcInValue(nProcIndex, "subgrpid", 		"0",5);
			daoObj.setProcInValue(nProcIndex, "setflag", 		voObj.getStrModelId(),6);
			daoObj.setProcInValue(nProcIndex, "hosp_code", 		voObj.getStrHospitalCode(),7);
			daoObj.setProcOutValue(nProcIndex, "err", 			1,8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 	2,9);
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
	public static void getPrintDetails_OLD(LocalPurchaseNewTransVO vo) {
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		System.out.println("-------------------LocalPurchaseNewTransDAO.getPrintDetails--------------------");
		
		try {
			dao = new HisDAO("mms", "LocalPurchaseNewTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.PROC_HSTT_LP_DTL(?,?,?,?,? ,?)}";
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
	
    public static void getPrintDetails(LocalPurchaseNewTransVO vo) 
    {
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		System.out.println("-------------------AckSuppReceiptDAO.getPrintDetails------[PKG_MMS_VIEW.proc_hstt_Supplier_Receipt_dtl Mode - 2 ]--------------");
		
		try {
			dao = new HisDAO("mms", "AckSuppReceiptDAO");
			strproc_name = "{call PKG_MMS_VIEW2.proc_hstt_Supplier_Receipt_dtl(?,?,?,?,? ,?)}";
			nprocIndex = dao.setProcedure(strproc_name);			
			/*
			System.out.println("vo.getStrStoreId()------>"+vo.getStrStoreId());
			System.out.println("vo.getStrLpoNo()------>"+vo.getStrLpoNo());
			System.out.println("vo.getStrHospitalCode()------>"+vo.getStrHospitalCode());
			*/
			
			dao.setProcInValue(nprocIndex, "modval", 		"2",1);
			dao.setProcInValue(nprocIndex, "strId", 		vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "lpno", 			vo.getStrLPNo(),3);
			dao.setProcInValue(nprocIndex, "hosp_code", 	vo.getStrHospitalCode(),4);	
			dao.setProcOutValue(nprocIndex, "err", 			1,5);
			dao.setProcOutValue(nprocIndex, "resultset", 	2,6);
			
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
			vo.setStrMsgString("AckSuppReceiptDAO.getPrintDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getImageHeader(LocalPurchaseNewTransVO vo)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("DWH","New_Report_For_AcknowledgeDAO");
			
			strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			
			strLogoName = dao.getFuncString(nFuncIndex);
			vo.setStrLogoName(strLogoName);

		} catch (Exception e) {
			
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("LocalPurchaseNewTransDAO.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}
	
}
