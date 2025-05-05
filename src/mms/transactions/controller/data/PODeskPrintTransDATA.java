package mms.transactions.controller.data;

import hisglobal.ReportUtil;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.transactions.controller.fb.PODeskPrintTransFB;
import mms.transactions.controller.hlp.PODeskPrintTransNEWHLP;

public class PODeskPrintTransDATA {
	
	private static final String pathFileName = "hisglobal.hisconfig.hisReport";
	private static String storagePath = "";
	
	
	public static void PRINT_NEW(PODeskPrintTransFB formBean,HttpServletRequest request, HttpServletResponse response)
	{

		
		PODeskPrintTransNEWHLP hlp = null;
		String strPoHlp = null;
		HisUtil util = null;	

		System.out.println("-------- PODeskPrintTransDATA.PRINT_NEW ---------");
		
	
		try 
		{
			
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			
			String[] Temp = request.getParameterValues("combo");
			String    str = request.getParameter("comboValue");
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId     = formBean.getStrReportId();
								
			String strChk = request.getParameter("chk");
			String[] strtemp = strChk.replace("@", "#").split("#");
			
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));	
			
			/*
			 * [ 0 ] - HSTNUM_STORE_ID 
			 * [ 1 ] - HSTNUM_PO_NO 
			 * [ 2 ] - GNUM_HOSPITAL_CODE 
			 * [ 3 ] - SSTNUM_POTYPE_ID 
			 * [ 4 ] - SSTNUM_ITEM_CAT_NO 
			 * [ 5 ] - TOTSCHED
			 * [ 6 ] -  'FC'  
			 * 
			 * */
			
			String strPOStoreId = strtemp[0];
			String strPONO = strtemp[1];
			String strPOTypeId = strtemp[3];
			String strCatgCode = strtemp[4];			
			
			System.out.println("****************************");
			System.out.println("--strStoreId----"+strPOStoreId);
			System.out.println("--strPONo----"+strPONO);
			System.out.println("--strPOTypeId----"+strPOTypeId);
			System.out.println("--strItemCatId----"+strCatgCode);
			System.out.println("****************************");
				
			formBean.setStrPONO(strPONO);
			formBean.setStrPOStoreId(strPOStoreId);
			formBean.setStrPOTypeId(strPOTypeId);
			formBean.setStrCatgCode(strCatgCode);
								
			hlp = new PODeskPrintTransNEWHLP();			
		
			response.setContentType("text/html;charset=UTF-8");
			
			System.out.println("--P.O. DTLS ------ pkg_mms_view2.proc_po_details_print [ Mode - 1 ]---------");
			System.out.println("--getComponentDetailPrint ------ PKG_MMS_VIEW.PROC_HSTT_POTYPE_COMPONENT_MST [ Mode - 2 ]---------");
			System.out.println("--getCopyToDetailPrint ------ PKG_MMS_VIEW.PROC_HSTT_POTYPE_COMPONENT_MST [ Mode - 3 ]---------");
			
			getPODetails(formBean);               // pkg_mms_view2.proc_po_details_print [ Mode - 1 ]   formBean.getWbPODtls()
			getComponentDetailPrint(formBean);    // PKG_MMS_VIEW.PROC_HSTT_POTYPE_COMPONENT_MST [ Mode - 2 ]
			getCopyToDetailPrint(formBean);       // PKG_MMS_VIEW.PROC_HSTT_POTYPE_COMPONENT_MST [ Mode - 3 ]
			/*
            if(formBean.getStrHospitalCode().equals("37913"))
            {	
            	System.out.println("-------- hlp.getPoHlp---------"+formBean.getStrHospitalCode());
            	strPoHlp = hlp.getPoHlp(formBean, request);
            	            	
            }
            else
            {   if(formBean.getStrHospitalCode().equals("21917"))
	            {	
            	   */
	            	if(formBean.getStrPOTypeId().equals("22"))
	        		{
	            		System.out.println("-------- Bhuv_ [ L.P. ]---------"+formBean.getStrHospitalCode());
		            	strPoHlp = hlp.get_BHUV_Local_PoHlp(formBean, request);
	        		}
	            	else
	            	{
	            		System.out.println("-------- Bhuv_ [ P.O.]---------"+formBean.getStrHospitalCode());
		            	strPoHlp = hlp.getPoHlp_otherHosp(formBean, request);
	            	}
	            	
	            /*	            	
	            }
                else
                {
            	   System.out.println("-------- hlp.getPoHlp_otherHosp---------"+formBean.getStrHospitalCode());
            	   strPoHlp = hlp.getPoHlp_otherHosp(formBean, request);
                }
            }
            */
			
			
			//System.out.println("----- O/P HLP ------------>"+strPoHlp);
			

			formBean.setStrPoHlp(strPoHlp);
				
					
				
								
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	public static void PRINT_NEW_DRAFT(PODeskPrintTransFB formBean,HttpServletRequest request, HttpServletResponse response)
	{

		
		PODeskPrintTransNEWHLP hlp = null;
		String strPoHlp = null;
		HisUtil util = null;	

		System.out.println("-------- PODeskPrintTransDATA.PRINT_NEW_DRAFT ---------");
		
	
		try 
		{
			
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			
			String[] Temp = request.getParameterValues("combo");
			String    str = request.getParameter("comboValue");
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId     = formBean.getStrReportId();
								
			String strChk = request.getParameter("chk");
			String[] strtemp = strChk.replace("@", "#").split("#");
			
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));	
			
			/*
			 * [ 0 ] - HSTNUM_STORE_ID 
			 * [ 1 ] - HSTNUM_PO_NO 
			 * [ 2 ] - GNUM_HOSPITAL_CODE 
			 * [ 3 ] - SSTNUM_POTYPE_ID 
			 * [ 4 ] - SSTNUM_ITEM_CAT_NO 
			 * [ 5 ] - TOTSCHED
			 * [ 6 ] -  'FC'  
			 * 
			 * */
			
			String strPOStoreId = strtemp[0];
			String strPONO = strtemp[1];
			String strPOTypeId = strtemp[3];
			String strCatgCode = strtemp[4];			
			
			System.out.println("****************************");
			System.out.println("--strStoreId----"+strPOStoreId);
			System.out.println("--strPONo----"+strPONO);
			System.out.println("--strPOTypeId----"+strPOTypeId);
			System.out.println("--strItemCatId----"+strCatgCode);
			System.out.println("****************************");
				
			formBean.setStrPONO(strPONO);
			formBean.setStrPOStoreId(strPOStoreId);
			formBean.setStrPOTypeId(strPOTypeId);
			formBean.setStrCatgCode(strCatgCode);
								
			hlp = new PODeskPrintTransNEWHLP();			
		
			response.setContentType("text/html;charset=UTF-8");
			
			System.out.println("--P.O. DTLS ------ pkg_mms_view2.proc_po_details_print [ Mode - 1 ]---------");
			System.out.println("--getComponentDetailPrint ------ PKG_MMS_VIEW.PROC_HSTT_POTYPE_COMPONENT_MST [ Mode - 2 ]---------");
			System.out.println("--getCopyToDetailPrint ------ PKG_MMS_VIEW.PROC_HSTT_POTYPE_COMPONENT_MST [ Mode - 3 ]---------");
			
			getPODetails(formBean);               // pkg_mms_view2.proc_po_details_print [ Mode - 1 ]   formBean.getWbPODtls()
			getComponentDetailPrint(formBean);    // PKG_MMS_VIEW.PROC_HSTT_POTYPE_COMPONENT_MST [ Mode - 2 ]
			getCopyToDetailPrint(formBean);       // PKG_MMS_VIEW.PROC_HSTT_POTYPE_COMPONENT_MST [ Mode - 3 ]
			
            if(formBean.getStrHospitalCode().equals("37913"))
            {	
            	System.out.println("-------- hlp.getPoHlp---------"+formBean.getStrHospitalCode());
            	strPoHlp = hlp.getPoHlp(formBean, request);
            	            	
            }
            else
            {   if(formBean.getStrHospitalCode().equals("21917"))
	            {	
            	  
	            	if(formBean.getStrPOTypeId().equals("22"))
	        		{
	            		System.out.println("-------- Bhuv_ [ L.P. ]---------"+formBean.getStrHospitalCode());
		            	strPoHlp = hlp.get_BHUV_Local_PoHlp(formBean, request);
	        		}
	            	else
	            	{
	            		System.out.println("-------- Bhuv_ [ P.O.]---------"+formBean.getStrHospitalCode());
		            	strPoHlp = hlp.getPoHlp_otherHosp(formBean, request);
	            	}
	            	
	                        	
	            }
                else
                {
            	   System.out.println("-------- hlp.getPoHlp_otherHosp---------"+formBean.getStrHospitalCode());
            	   strPoHlp = hlp.getPoHlp_otherHosp(formBean, request);
                }
            }
            
			
			
			//System.out.println("----- O/P HLP ------------>"+strPoHlp);
			

			formBean.setStrPoHlp(strPoHlp);
				
					
				
								
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	
	public static void getPODetails(PODeskPrintTransFB formBean) 
	{
		String strproc_name = "{call pkg_mms_view2.proc_po_details_print(?,?,?,?,?,  ?,?,?)}"; // 8
		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wsResult = null;

		try 
		{
			dao = new HisDAO("MMS", "transactions.PODeskGenerateTransDAO.getPODetails()");
		
			
			nProcIndex = dao.setProcedure(strproc_name);
			System.out.println("PO_STATUS--{ 1- Pending , 3- In Process ,  2 - Close  }--"+formBean.getStrPOStatus());
			if(formBean.getStrPOStatus().equals("1") && !formBean.getStrPOTypeId().equals("22"))
			{
				System.out.println("------- pkg_mms_view2.proc_po_details_print [ Mode - 2 ]-------");
				dao.setProcInValue(nProcIndex, "modeval", "2");
			}
			else
			{
				System.out.println("------- pkg_mms_view2.proc_po_details_print [ Mode - 1 ]-------");
			    dao.setProcInValue(nProcIndex, "modeval", "1");
			}
			dao.setProcInValue(nProcIndex, "hosp_code", formBean.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "pono", formBean.getStrPONO());
			dao.setProcInValue(nProcIndex, "poTypeId", formBean.getStrPOTypeId());
			dao.setProcInValue(nProcIndex, "catgid", formBean.getStrCatgCode());
			dao.setProcInValue(nProcIndex, "storeId", formBean.getStrPOStoreId());
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) 
			{
				
				/*
                1.PO_WTH_DATE
                2.SUPP_NAME
                3.PO_TYPE
                4.CATG
                5.PO_REMARKS
                6.PO_ENTER_BY_USER_NAME
                7.PO_GEN_BY_STORE_NAME
                8.PURCHASE_SOURCE
                9.RATE_CONTRACT_ID
               10.RAT_COTRACT_QTY
               11.ITEM_NAME
               12.ITEM_CODE_NO
               13.RATE_WITHOUT_TAX
               14.ITEM_ORDER_QTY
               15.ITEM_COST_WITHOUT_TAX
               16.RATE_WITH_TAX
               17.ITEM_COST_WITH_TAX
               18.ITEM_TAX
               19.DELIVERY_DATE
               20.PACK_SIZE
               21.ENTER_BY_USER_NAME/DATE
               22.     
               [ 0]INITCAP(F.HSTSTR_SUPPLIER_NAME) - 
		       [ 1]INITCAP(F.hststr_contact_person)  - 
		       [ 2]INITCAP(F.hststr_address)  - 
		       [ 3]INITCAP(F.hststr_city_name)  - 
		       [ 4]INITCAP(F.hststr_pincode)  - 
		       [ 5]INITCAP(F.hststr_phone1)  - 
		       [ 6]INITCAP(F.hststr_email1)  -              
		       [ 7]INITCAP(F.hststr_faxno1)  - 
		       [ 8]INITCAP(F.hststr_website)  - 
		       [ 9]INITCAP(F.gnum_countrycode)  - 
		       [10]INITCAP(F.gnum_statecode)
               23.P_KEY - B.HSTNUM_ITEMBRAND_ID||'$'||B.HSTNUM_SUPPLIER_ID||'$'||A.SSTNUM_POTYPE_ID||'$'||A.SSTNUM_ITEM_CAT_NO||'$'||A.HSTNUM_PO_NO||'$'||A.HSTNUM_STORE_ID

              */
				
				formBean.setWbPODtls(wsResult);
				
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			formBean.setStrMsgString("PODeskGenerateTransDAO.getPODetails() --> " + e.getMessage());
			formBean.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	
	public static void getComponentDetailPrint(PODeskPrintTransFB formBean) 
	{
		String strproc_name = "{call PKG_MMS_VIEW.PROC_HSTT_POTYPE_COMPONENT_MST(?,?,?,?,?  ,?)}"; 
		HisDAO dao = null;

		int nProcIndex = 0;
		String[] compArr = null;

		String strErr = "";
		WebRowSet wsResult = null;

		try 
		{
			    dao = new HisDAO("MMS", "transactions.PODeskGenerateTransDAO.getComponentDetail()");

			    nProcIndex = dao.setProcedure(strproc_name);
			    /*
			    	formBean.setStrPONO(strPONO);
					formBean.setStrPOStoreId(strPOStoreId);
					formBean.setStrPOTypeId(strPOTypeId);
					formBean.setStrCatgCode(strCatgCode);
				*/
			    
				dao.setProcInValue(nProcIndex, "modeval",    "2");
				dao.setProcInValue(nProcIndex, "hosp_code",  formBean.getStrHospitalCode());
				dao.setProcInValue(nProcIndex, "po_type",    formBean.getStrPOTypeId());
				dao.setProcInValue(nProcIndex, "item_cat",   formBean.getStrPOStoreId());
				//dao.setProcInValue(nProcIndex, "compTypeId", formBean.getStrPONO()); 			
				dao.setProcOutValue(nProcIndex, "err",       1);
				dao.setProcOutValue(nProcIndex, "resultset", 2);
				dao.executeProcedure(nProcIndex);

			    strErr = dao.getString(nProcIndex, "err");

			if (strErr == null) 
			{
				strErr = "";
			}
			wsResult = dao.getWebRowSet(nProcIndex, "resultset");					
			formBean.setWbPOComponentDtls(wsResult);
			

		} catch (Exception e) {
			e.printStackTrace();
			formBean.setStrMsgString("PODeskGenerateTransDAO.getComponentDetail() --> " + e.getMessage());
			formBean.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			//wsResult = null;
		}
	}
	
	public static void getCopyToDetailPrint(PODeskPrintTransFB formBean) 
	{
		String strproc_name = "{call PKG_MMS_VIEW.PROC_HSTT_POTYPE_COMPONENT_MST(?,?,?,?,?  ,?)}"; 
		HisDAO dao = null;

		int nProcIndex = 0;
		String[] compArr = null;

		String strErr = "";
		WebRowSet wsResult = null;

		try 
		{
			    dao = new HisDAO("MMS", "transactions.PODeskGenerateTransDAO.getCopyToDetailPrint()");

			    nProcIndex = dao.setProcedure(strproc_name);
			    /*
			    	formBean.setStrPONO(strPONO);
					formBean.setStrPOStoreId(strPOStoreId);
					formBean.setStrPOTypeId(strPOTypeId);
					formBean.setStrCatgCode(strCatgCode);
				*/
				dao.setProcInValue(nProcIndex, "modeval",    "3");
				dao.setProcInValue(nProcIndex, "hosp_code",  formBean.getStrHospitalCode());
				dao.setProcInValue(nProcIndex, "po_type",    formBean.getStrPOTypeId());
				dao.setProcInValue(nProcIndex, "item_cat",   formBean.getStrPOStoreId());
				//dao.setProcInValue(nProcIndex, "compTypeId", formBean.getStrPONO()); 			
				dao.setProcOutValue(nProcIndex, "err",       1);
				dao.setProcOutValue(nProcIndex, "resultset", 2);
				dao.executeProcedure(nProcIndex);

			    strErr = dao.getString(nProcIndex, "err");

			if (strErr == null) 
			{
				strErr = "";
			}
			wsResult = dao.getWebRowSet(nProcIndex, "resultset");					
			formBean.setWbCopyToDtlsDtls(wsResult);
			

		} catch (Exception e) {
			e.printStackTrace();
			formBean.setStrMsgString("PODeskGenerateTransDAO.getCopyToDetailPrint() --> " + e.getMessage());
			formBean.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			//wsResult = null;
		}
	}

	
	public static void showReport(PODeskPrintTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "pdf";

		System.out.println("-------- PODeskPrintTransDATA.showReport ---------");
		
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String[] Temp = request.getParameterValues("combo");
			String str = request.getParameter("comboValue");
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
								
			String strChk = request.getParameter("chk");
			String[] strtemp = strChk.replace("@", "#").split("#");
			
			/*
			 * [ 0 ] - HSTNUM_STORE_ID 
			 * [ 1 ] - HSTNUM_PO_NO 
			 * [ 2 ] - GNUM_HOSPITAL_CODE 
			 * [ 3 ] - SSTNUM_POTYPE_ID 
			 * [ 4 ] - SSTNUM_ITEM_CAT_NO 
			 * [ 5 ] - TOTSCHED
			 * [ 6 ] -  'FC'  
			 * 
			 * */
			
			String strStoreId = strtemp[0];
			String strPONo = strtemp[1];
			String strPOTypeId = strtemp[3];
			String strItemCatId = strtemp[4];			
			
		
			params.put("report_Header1", getStoragePath("PO_REPORT_HEADER1"));			
			params.put("po_report_Address", getStoragePath("PO_REPORT_ADDRESS"));
			params.put("po_report_Contact", getStoragePath("PO_REPORT_CONTACT"));			
			params.put("po_report_sub_Header", getStoragePath("PO_REPORT_SUB_HEADER"));
					
				
			
			// in case of local (with grant type)	
			if(strPOTypeId.equals("25") || strPOTypeId.equals("26") ||
					strPOTypeId.equals("27"))
			{
				
				System.out.println("----[25,26,27]---- /mms/reports/po_localcont_mmsrpt1.rptdesign ---------");
				
				String reportPath = "/mms/reports/po_localcont_mmsrpt1.rptdesign";
				String strReportName = "Purchase Order(Local & Contigency With Grant)";
				
				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("poNo", strPONo);
				params.put("poTypeId", strPOTypeId);
				params.put("itemCategory", strItemCatId);	
				params.put("po_Header", getStoragePath("PO_HEADER"));
				
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strHospitalCode);
				
			// in case of local	
			}else if(strPOTypeId.equals("21") )
			{
				
				
				System.out.println("strPONo------->"+strPONo);
				System.out.println("strPOTypeId------->"+strPOTypeId);				
				System.out.println("PO_REPORT_HEADER1------->"+getStoragePath("PO_REPORT_HEADER1"));
				System.out.println("PO_REPORT_ADDRESS------->"+getStoragePath("PO_REPORT_ADDRESS"));
				System.out.println("PO_REPORT_SUB_HEADER------->"+getStoragePath("PO_REPORT_SUB_HEADER"));
				System.out.println("PO_HEADER------->"+getStoragePath("PO_HEADER"));
				System.out.println("Temp[3]------->"+Temp[3]);
				if(Temp[3].equals("1"))
				{
					
					System.out.println("--A--[21]---- /mms/reports/po_bulkpurchase_mmsrpt.rptdesign ---------");
				
					//String reportPath = "/mms/reports/po_localpur_mmsrpt.rptdesign";
					String reportPath = "/mms/reports/po_bulkpurchase_mmsrpt.rptdesign";
					String strReportName = "Draft Purchase Order";
									
					params.put("report_Name", strReportName);
					params.put("report_id", strReportId);
					params.put("hospCode", strHospitalCode);
					params.put("storeId", strStoreId);
					params.put("poNo", strPONo);
					params.put("poTypeId", strPOTypeId);
					params.put("itemCategory", strItemCatId);
					params.put("po_Header", getStoragePath("PO_HEADER"));
					params.put("stampPaperAmt", "0");
					params.put("contractValue", "0");
					params.put("storeName", str);
					
					ts.displayReport(request, response, reportPath, "html",params,strHospitalCode);
				}
				else
				{ 
					System.out.println("--B--[21]---- /mms/reports/po_bulkpurchase_mmsrpt_new1.rptdesign ---------");
					
					//String reportPath = "/mms/reports/po_localpur_mmsrpt.rptdesign";
					String reportPath = "/mms/reports/po_bulkpurchase_mmsrpt_new1.rptdesign";
					String strReportName = "Purchase Order";
					
					params.put("report_Name", strReportName);
					params.put("report_id", strReportId);
					params.put("hospCode", strHospitalCode);
					params.put("storeId", strStoreId);
					params.put("poNo", strPONo);
					params.put("poTypeId", strPOTypeId);
					params.put("itemCategory", strItemCatId);
					params.put("po_Header", getStoragePath("PO_HEADER"));
					params.put("stampPaperAmt", "0");
					params.put("contractValue", "0");
					params.put("storeName", str);
					
					ts.displayReport(request, response, reportPath, "html",params,strHospitalCode);//(request, response, reportPath, reportFormat,params,strHospitalCode,strPONo);
				}
				
			// in case of annual purchase
			}else if(strPOTypeId.equals("22") ){
				
				System.out.println("----[22]---- /mms/reports/po_bulkpurchase_mmsrpt_new2.rptdesign ---------");
				
			//	String reportPath = "/mms/reports/po_annualpurchase_mmsrpt_new.rptdesign";
				String reportPath = "/mms/reports/po_bulkpurchase_mmsrpt_new2.rptdesign";
				String strReportName = "Local PO";
				
				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("poNo", strPONo);
				params.put("poTypeId", strPOTypeId);
				params.put("itemCategory", strItemCatId);
				params.put("po_Header", getStoragePath("PO_HEADER1"));
				params.put("stampPaperAmt", "0");
				params.put("contractValue", "0");
				params.put("storeName", str);
				/*ts.displayReportWithName(request, response, reportPath, reportFormat,
						params,strHospitalCode,strPONo);*/
				ts.displayReport(request, response, reportPath, "html",params,strHospitalCode);//(request, response, reportPath, reportFormat,params,strHospitalCode,strPONo);
			
			}else if(strPOTypeId.equals("24")){
			////System.out.println("callinfg this");
				
				System.out.println("----[24]---- /mms/reports/po_imported_mmsrpt.rptdesign ---------");
				
				String reportPath = "/mms/reports/po_imported_mmsrpt.rptdesign";
				String strReportName = "Purchase Order(Annual Purchase)";
				
				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("poNo", strPONo);
				params.put("poTypeId", strPOTypeId);
				params.put("itemCategory", strItemCatId);
				params.put("po_Header", getStoragePath("PO_HEADER1"));
				
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strHospitalCode);
			
			}else if(strPOTypeId.equals("23")){
			////System.out.println("callinfg this");
				
				System.out.println("----[23]---- /mms/reports/po_contigency_mmsrpt.rptdesign ---------");
				
				String reportPath = "/mms/reports/po_contigency_mmsrpt.rptdesign";
				String strReportName = "Purchase Order(Annual Purchase)";
				
				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("poNo", strPONo);
				params.put("poTypeId", strPOTypeId);
				params.put("itemCategory", strItemCatId);
				params.put("po_Header", getStoragePath("PO_HEADER1"));
				
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strHospitalCode);
			
			}
			else if(strPOTypeId.equals("87")){
				
				System.out.println("----[87]---- /mms/reports/po_bspurchase_mmsrpt_new.rptdesign ---------");
				
				String reportPath = "/mms/reports/po_bspurchase_mmsrpt_new.rptdesign";
				String strReportName = "LIST OF MEDICINES APPROVED & TO BE PURCHASED";
				
				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("poNo", strPONo);
				params.put("poTypeId", strPOTypeId);
				params.put("itemCategory", strItemCatId);
				params.put("po_Header", getStoragePath("PO_HEADER1"));
				params.put("stampPaperAmt", "0");
				params.put("contractValue", "0");
				params.put("storeName", str);
				ts.displayReportWithName(request, response, reportPath, reportFormat,
						params,strHospitalCode,strPONo);
			
			}
						
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	
	public static String getStoragePath(String key) {

		ResourceBundle rsBundle = ResourceBundle.getBundle(pathFileName);
		storagePath = rsBundle.getString(key);
		return storagePath;
	}
}
