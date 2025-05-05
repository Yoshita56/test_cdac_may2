package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.reports.bo.DailyActivityRptBO;
import mms.reports.controller.fb.DailyActivityRptFB;
import mms.reports.controller.hlp.DailyActivityRptHLP;
import mms.reports.vo.DailyActivityRptVO;

public class DailyActivityRptDATA {
	
	public static void getInitializedValues(DailyActivityRptFB dailyActivityRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		DailyActivityRptBO bo = null;
		DailyActivityRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		
				
		String strHospitalCode,strDwhTypeVal,strSupplierVal;
		String strStoreVal = "";
		try {

			bo = new DailyActivityRptBO();
			voObj = new DailyActivityRptVO();
			
			//String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			dailyActivityRptFB_p.setStrHospitalCode(strHospitalCode);
			dailyActivityRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","DailyActivityRptDATA");
			
					
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 ){
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
				
			
			//strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 
			
			voObj.setStrSeatId(dailyActivityRptFB_p.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			
			
			voObj.setStrMode("5");
			
			
			
			bo.getInitializedValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
		    strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^Select Value", false);	
			
			
			dailyActivityRptFB_p.setStrStoreValues(strStoreVal);
			
			strSupplierVal = hisutil.getOptionValue(voObj.getStrManufactureComboWS(), "0", "0^Select Value", false);
			dailyActivityRptFB_p.setStrManufactureCombo(strSupplierVal);
						
			hisutil = new HisUtil("MMS Transactions", "DailyActivityRptDATA");
			// For setting the financial year 
			dailyActivityRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			dailyActivityRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			dailyActivityRptFB_p.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.DailyActivityRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"DailyActivityRptDATA->getInitializedValues()", strMsgText);
			dailyActivityRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (hisutil != null)
				hisutil = null;
		}
	}
	
	
	 public static void getIssueDetails(DailyActivityRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				DailyActivityRptBO bo = null;
				DailyActivityRptVO vo = null;
				
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new DailyActivityRptBO();
					vo = new DailyActivityRptVO();
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrStoreId(request.getParameter("StoreId"));
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					
					bo.getIssueDetails(vo);
					
					System.out.println("---SIZE-->>"+vo.getStrIssueDtlWs().getFetchSize());
					
					String strItemDetails = DailyActivityRptHLP.getIssueDetails(vo.getStrIssueDtlWs());
					
					System.out.println("----->>"+strItemDetails);
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					strmsgText = "mms.transactions.IssueTransDATA.getIssueDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getIssueDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	 
	 
	 public static void getActivityPrint(DailyActivityRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				DailyActivityRptBO bo = null;
				DailyActivityRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new DailyActivityRptBO();
					vo = new DailyActivityRptVO();
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrStoreId(request.getParameter("StoreId"));
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrStoreName(request.getParameter("StoreName"));					
					
					bo.getIssueDetails(vo);
					
					String strItemDetails = DailyActivityRptHLP.getDailyActivityPrint(vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getIssueDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getIssueDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	 
	 public static void getRecieveVoucherDetails(DailyActivityRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				DailyActivityRptBO bo = null;
				DailyActivityRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new DailyActivityRptBO();
					vo = new DailyActivityRptVO();
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					
					if(request.getParameter("StoreId").equals("1"))
					{	
						vo.setStrStoreId(request.getParameter("hiddenVal").split("\\^")[3]);
					}
					else
					{
						
						vo.setStrStoreId(request.getParameter("StoreId"));
					}
			
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrReceiveVoucherHiddenVal(request.getParameter("hiddenVal"));
					/* Value Pass in Web Row Set
			    	   1. Issue Count
			    	   2. Receive Count
		               3. DWH Name
		               4. Store ID
		               5. Sample Sent Count
		             
		           	 */ 
					
					bo.getRecieveVoucherDetailsPoUp(vo);
					
					String strItemDetails = DailyActivityRptHLP.getRecieveVoucherDtlPopUpOne(vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getRecieveVoucherDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getRecieveVoucherDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	 
	 
	 
	 public static void getSampleSendDetails(DailyActivityRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				DailyActivityRptBO bo = null;
				DailyActivityRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new DailyActivityRptBO();
					vo = new DailyActivityRptVO();
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					
					if(request.getParameter("StoreId").equals("1"))
					{	
						vo.setStrStoreId(request.getParameter("hiddenVal").split("\\^")[3]);
					}
					else
					{
						
						vo.setStrStoreId(request.getParameter("StoreId"));
					}
			
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setSampleSendHiddenVal(request.getParameter("hiddenVal"));
					/* Value Pass in Web Row Set
			    	   1. Issue Count
			    	   2. Receive Count
		               3. DWH Name
		               4. Store ID
		               5. Sample Sent Count
		             
		           	 */ 
					
					bo.getSampleSendDetailsPoUp(vo);
					
					String strItemDetails = DailyActivityRptHLP.getSampleSendDtlPopUpOne(vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.DailyActivityRptDATA.getSampleSendDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"DailyActivityRptDATA->getSampleSendDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	 
	 
	 public static void getSampleSendItemBatchDtl(DailyActivityRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				DailyActivityRptBO bo = null;
				DailyActivityRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new DailyActivityRptBO();
					vo = new DailyActivityRptVO();
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					
					////System.out.println("Store ID: "+request.getParameter("hiddenVal").split("\\^")[8]);
						vo.setStrStoreId(request.getParameter("hiddenVal").split("\\^")[8]);
					
			
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setSampleSendItemBatchHiddenVal(request.getParameter("hiddenVal"));
					/* Value Pass in Web Row Set
			    	    1.Store Id,
				        2.Drug Name,
				        3.Drug Brand ID,
						4.Issued Count,
						5.Issued Qty
						
						++++++++++++++++++++++++++++++++++++++++++++
				    	6. Issue Count
				    	7. Receive Count
			            8. DWH Name
			            9. Store ID
			            10.Sample Sent Count
		             
		           	 */ 
					////System.out.println("Store ID: "+request.getParameter("hiddenVal").split("\\^")[8]);
					////System.out.println("Data Class Entered ");
					
					bo.getSampleSendItemBatchDetailsPoUp(vo);
					
					String strItemDetails = DailyActivityRptHLP.getSampleSendDtlPopUpTwo(vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.DailyActivityRptDATA.getSampleSendItemBatchDtl --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"DailyActivityRptDATA->getSampleSendItemBatchDtl()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	 
	 
	 
	 
	 
	 
	 
	 
	 public static void getIssueVoucherDetails(DailyActivityRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				DailyActivityRptBO bo = null;
				DailyActivityRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new DailyActivityRptBO();
					vo = new DailyActivityRptVO();
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					if(request.getParameter("StoreId").equals("1"))
					{	
						vo.setStrStoreId(request.getParameter("hiddenVal").split("\\^")[3]);
					}
					else
					{
						
						vo.setStrStoreId(request.getParameter("StoreId"));
					}
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrIssueVoucherHiddenVal(request.getParameter("hiddenVal"));
					vo.setStrStoreName(request.getParameter("hiddenVal").split("\\^")[2]);
					/* Value Pass in Web Row Set
			    	   1. Issue Count
			    	   2. Receive Count
		               3. DWH Name
		               4. Store ID
		             
		           	 */ 					
					bo.getIssueVoucherDetailsPoUp(vo);
					
					String strItemDetails = DailyActivityRptHLP.getIssueVoucherDtlPopUpOne(vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getIssueVoucherDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getIssueVoucherDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	 
	 public static void getIssueNoDetails(DailyActivityRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				DailyActivityRptBO bo = null;
				DailyActivityRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new DailyActivityRptBO();
					vo = new DailyActivityRptVO();
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrIssueVoucherHiddenVal(request.getParameter("hiddenVal"));
					
					vo.setStrStoreId(request.getParameter("hiddenVal").split("\\^")[4]);
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrReqStoreID(request.getParameter("hiddenVal").split("\\^")[6]);
					vo.setStrIssueNumber(request.getParameter("hiddenVal").split("\\^")[0]);
					vo.setStrIssueVoucherHiddenVal(request.getParameter("hiddenVal"));
					vo.setStrStoreName(request.getParameter("hiddenVal").split("\\^")[5]);
					vo.setStrReqStoreName(request.getParameter("hiddenVal").split("\\^")[7]);
					/*
					1.HSTNUM_ISSUE_NO,
					2.ISSUE_DATE,
					3.INDENT_NO,
					4.ISSUED_VALUE,
					5.STORE_ID,
					6.STORE_NAME,
					7.HSTNUM_REQ_STOREID,
					8.REQ_STORE
					9.ISSUE_TO(Institution Name),
					10.HSTNUM_REQ_STOREID
					11.COUNT(HSTNUM_ISSUE_NO),
					12.HSTNUM_STORE_ID,
					13.STORE_NAME
			    	14. Issue Count
			    	15. Receive Count
		            16. DWH Name
		            17. Store ID
					*/
					
					bo.getIssueNoDetailsPopUp(vo);
					
					String strItemDetails = DailyActivityRptHLP.getIssueNoDetailsPopUp(vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getIssueNoDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getIssueNoDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	
	
	 public static void getInstituteIssueDetails(DailyActivityRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				DailyActivityRptBO bo = null;
				DailyActivityRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new DailyActivityRptBO();
					vo = new DailyActivityRptVO();
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrIssueVoucherHiddenVal(request.getParameter("hiddenVal"));
					
					vo.setStrStoreId(request.getParameter("hiddenVal").split("\\^")[3]);
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrReqStoreID(request.getParameter("hiddenVal").split("\\^")[1]);
					vo.setStrIssueVoucherHiddenVal(request.getParameter("hiddenVal"));
					vo.setStrStoreName(request.getParameter("hiddenVal").split("\\^")[4]);
					/*
					1.ISSUE_TO(Institution Name),
					2.HSTNUM_REQ_STOREID
					3.COUNT(HSTNUM_ISSUE_NO),
					4.HSTNUM_STORE_ID,
					5.STORE_NAME
					
			    	6. Issue Count
			    	7. Receive Count
		            8. DWH Name
		            9. Store ID
					*/
					
					bo.getInstituteIssueDetailsPopUp(vo);
					
					String strItemDetails = DailyActivityRptHLP.getInstituteIssueDetailsPopUp(vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getInstituteIssueDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getInstituteIssueDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	
	 
	 public static void getChallanDetails(DailyActivityRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				DailyActivityRptBO bo = null;
				DailyActivityRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new DailyActivityRptBO();
					vo = new DailyActivityRptVO();
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrIssueVoucherHiddenVal(request.getParameter("hiddenVal"));
					////System.out.println("hidden val:"+request.getParameter("hiddenVal"));
					vo.setStrStoreId(request.getParameter("hiddenVal").split("\\^")[10]);
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrReceiveVoucherHiddenVal(request.getParameter("hiddenVal"));
					
				
					/*
					1.Supplier Name,
					2.Supplier Id,
					3.PO With Ref No,
					4.PO Date,
					5.PO No
					6.Supplied Value
					7.Received Count
					++++++++++++++++++++++++++++++++++++++++++++
			    	8. Issue Count
			    	9. Receive Count
		            10. DWH Name
		            11. Store ID
		            12.Sample Sent Count
					*/
					
					bo.getPOChallanDetailyPopUp(vo);
					
					String strItemDetails = DailyActivityRptHLP.getPOChallanDetails(vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					strmsgText = "mms.transactions.IssueTransDATA.getChallanDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getChallanDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	
	 
		 
	 public static void getChallanItemDetails(DailyActivityRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				DailyActivityRptBO bo = null;
				DailyActivityRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new DailyActivityRptBO();
					vo = new DailyActivityRptVO();
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					////System.out.println("hidden val:"+request.getParameter("hiddenVal"));
					vo.setStrIssueVoucherHiddenVal(request.getParameter("hiddenVal"));					
					vo.setStrStoreId(request.getParameter("hiddenVal").split("\\^")[17]);
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrReceiveVoucherHiddenVal(request.getParameter("hiddenVal"));
					////System.out.println("Challan Item Hidden Value==>"+request.getParameter("hiddenVal"));
					 /*
					1.Recipt No(Challan)
					2.Challan No
					3.Challan Date
					4.Received Date
					5.No Packet
					6.Supplied Value(SUM)
					+++++++++++++++++++++++++++  
					7.Supplier Name,
					8.Supplier Id,
					9.PO With Ref No,
					10.PO Date,
					11.PO No
					12.Supplied Value
					13.Received Count
					++++++++++++++++++++++++++++++++++++++++++++
			    	14. Issue Count
			    	15. Receive Count
		            16. DWH Name
		            17. Store ID
		            18.Sample Sent Count
					*/		
					
					bo.getChallanItemDetailyPopUp(vo);
					
					String strItemDetails = DailyActivityRptHLP.getChallanItemDetails(vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getChallanItemDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getChallanItemDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	 
	 
	 public static void getIssueItemDtl(DailyActivityRptFB formBean,HttpServletRequest request, HttpServletResponse response) 
	 {

				DailyActivityRptBO bo = null;
				DailyActivityRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new DailyActivityRptBO();
					vo = new DailyActivityRptVO();
																				
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrStoreId(request.getParameter("StoreId"));
				    vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					
					bo.getIssueItemDetails(vo);
					
					String strItemDetails = DailyActivityRptHLP.getIssuedNoDetails(vo.getStrIssueItemDtlWs());
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getItemDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getItemDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}

	 
	 
	 public static void getIssueAndReceivedDtl(DailyActivityRptFB formBean,HttpServletRequest request, HttpServletResponse response) 
	 {

				DailyActivityRptBO bo = null;
				DailyActivityRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new DailyActivityRptBO();
					vo = new DailyActivityRptVO();
																				
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrStoreId(request.getParameter("StoreId"));
				  	vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					
					bo.getReceivedDetails(vo);
					
					String strItemDetails = DailyActivityRptHLP.getReceiveDetails(vo.getStrReceivedItemDtlWs());
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getItemDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getItemDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}

	
	

/*	
	public static void getStoreList(DailyActivityRptFB dailyActivityRptFB_p,HttpServletRequest request, HttpServletResponse response) 
	{

		DailyActivityRptBO bo = null;
		DailyActivityRptVO voObj = null;
		String strmsgText = null;
		String strHospitalCode, strStoreVal = "";
		String strDwhTypeVal;

		HisUtil util = null;
		try {

			bo = new DailyActivityRptBO();
			voObj = new DailyActivityRptVO();
			
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			dailyActivityRptFB_p.setStrHospitalCode(strHospitalCode);
			dailyActivityRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			voObj.setStrHospitalCode(strHospitalCode);
			voObj.setStrSeatId(dailyActivityRptFB_p.getStrSeatId());
			dailyActivityRptFB_p.setStrDrugWarehouseTypeId(request.getParameter("dwhTypeId"));
			
			
			voObj.setStrDrugWarehouseTypeId(dailyActivityRptFB_p.getStrDrugWarehouseTypeId());
			
				
			
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("DWH", "DailyActivityRptDATA");
			
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^Select Value", false);
						
		
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strStoreVal);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.DailyActivityRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DailyActivityRptDATA->getStoreList()", strmsgText);
			dailyActivityRptFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}
	*/
	
	

	public static void showReport(DailyActivityRptFB dailyActivityRptFB_p,HttpServletRequest request, HttpServletResponse response) {
		
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strProcRelatedValue = request.getParameter("strProcRelatedValue");
			
			String strIssueCount = strProcRelatedValue.split("\\^")[0];
			String	strReceiveCount = strProcRelatedValue.split("\\^")[1];
			
			String	strDwhName = strProcRelatedValue.split("\\^")[2];
						 
			
			String strStoreID =dailyActivityRptFB_p.getStrStoreId(); 
		
			
			
			dailyActivityRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			dailyActivityRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strHospitalCode = dailyActivityRptFB_p.getStrHospitalCode();
			String strReportId = dailyActivityRptFB_p.getStrReportId();
		
		
/*			String strStartYear = dailyActivityRptFB_p.getStrStartFinancialYear();
			String strEndYear = dailyActivityRptFB_p.getStrEndFinancialYearTemp();
*/			
			
			String strFromDate = dailyActivityRptFB_p.getStrFromDate();
			String strToDate = dailyActivityRptFB_p.getStrToDate();
			
			String strUserRemarks = dailyActivityRptFB_p.getStrUserRemarks();
			
			reportFormat = dailyActivityRptFB_p.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if(dailyActivityRptFB_p.getStrIsFooter()==null)
				dailyActivityRptFB_p.setStrIsFooter("0");
			
			if (dailyActivityRptFB_p.getStrIsFooter().equals("1"))
			{
				footerVisible = false;
				
			}
		
			
			String strReportName = "Daily Activity Report";
	
							
				String reportPath = "/mms/reports/dwh_dailyActivity_rpt.rptdesign";
			
//			String reportPath = "/mms/reports/dwh_drugWarehouseWiseSupplierDeliveryDetail_rpt.rptdesign";
				
				
				params.put("mode", "1");
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("issueCount", strIssueCount);
				params.put("receiveCount", strReceiveCount);
				params.put("dwhName", strDwhName);
				
				
				params.put("storeid", strStoreID);	
			
				
				
				params.put("supplierId", "0");
				params.put("pono", "0");
				
		/*	//System.out.println("strIssueDate:"+strIssueDate);
			//System.out.println("strIndentNo:"+strIndentNo);
			//System.out.println("strIndentDate:"+strIndentDate);
			//System.out.println("strListOfInst:"+strListOfInst);
			//System.out.println("strTotalValue:"+strTotalValue);
			//System.out.println("strStoreID:"+strStoreID);
			//System.out.println("strIssueNo:"+strIssueNo);
			
			//System.out.println("strHospitalCode:"+strHospitalCode);
			
			//System.out.println("dailyActivityRptFB_p.getStrStoreName():"+dailyActivityRptFB_p.getStrStoreName());
			//System.out.println("sdf.format(sdf.parse(strFromDate)):"+sdf.format(sdf.parse(strFromDate)));
			//System.out.println("sdf.format(sdf.parse(strToDate)):"+sdf.format(sdf.parse(strToDate)));*/
				
				params.put("storeName", dailyActivityRptFB_p.getStrStoreName());
				
				
				params.put("hospCode", strHospitalCode);
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
											
				ts.displayReport(request, response, reportPath, reportFormat,params,strStoreID);
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}
}
