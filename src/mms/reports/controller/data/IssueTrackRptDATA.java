package mms.reports.controller.data;

import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.reports.bo.IssueTrackRptBO;
import mms.reports.controller.fb.IssueTrackRptFB;
import mms.reports.controller.hlp.IssueTrackRptHLP;
import mms.reports.vo.IssueTrackRptVO;

public class IssueTrackRptDATA {
	
	//store list
	public static void setInitializedValues(IssueTrackRptFB formBean,	HttpServletRequest request, HttpServletResponse response) {

		IssueTrackRptBO bo = null;
		IssueTrackRptVO voObj = null;
		
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		
		String strCurrentFinancialYear;
		String strNextFinancialYear;
		String strHospitalCode,strStoreVal,strDwhTypeVal,strDistrictStoreVal;
		
		try 
		{
			System.out.println("---------IssueTrackRptDATA.setInitializedValues---------");

			bo = new IssueTrackRptBO();
			voObj = new IssueTrackRptVO();
			
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			formBean.setStrHospitalCode(strHospitalCode);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","IssueTrackRptDATA");
					
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			if(strCurrentMonth>=4 ){
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
			
			strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 
			
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			
			voObj.setStrMode("1");
			
			bo.getInitializedValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			System.out.println("---voObj.getStrStoreWs()--------"+voObj.getStrStoreWs().size());
			
		    strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^Select Value", false);	
		    //strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);	

			formBean.setStrStoreValues(strStoreVal);
						
						
			hisutil = new HisUtil("MMS Transactions", "IssueTrackRptDATA");
			
			// For setting the financial year 
			formBean.setStrStartFinancialYear(""+CURRENT_YEAR);
			formBean.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.BreakageAndLostDrugDetailsRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"BreakageAndLostDrugDetailsRptDATA->getInitializedValues()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	//issue track report
	public static void showReportNew(IssueTrackRptFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
	       IssueTrackRptVO vo = null;
	       IssueTrackRptBO bo = null;
		   ReportUtil ts = new ReportUtil();	
		   Stack<String> stc;
		
		   try 
			{	
			   
			   String strResult="";
			    vo=new IssueTrackRptVO();
			   	bo=new IssueTrackRptBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	stc= new Stack<String> ();
			   	vo.setStrStoreId(request.getParameter("strStoreId"));
				vo.setStrStoreName(request.getParameter("storeName"));
				vo.setBackPages(formBean.getBackPages());
			   	vo.setStrStartDate((String) request.getParameter("strFromDate"));
				vo.setStrEndDate((String) request.getParameter("strToDate"));
				vo.setStrMode("1");
				
				formBean.setStrStartDate((String) request.getParameter("strFromDate"));
				formBean.setStrEndDate((String) request.getParameter("strToDate"));
				formBean.setStrCmodeId((String) request.getParameter("strCmodeId"));
				formBean.setStrStoreName(request.getParameter("storeName"));
				
				bo.setViewPageDtl(vo);
				

				 strResult=IssueTrackRptHLP.getIssueTrackDetails(vo);
				 //stc.push(strResult);
				 
				 formBean.setBackPages(stc);
				 //request.setAttribute("vo", vo);
				response.getWriter().print(strResult);

		   }catch(Exception _err){
			   
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueTrackRptDATA->showReportNew()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_LocalPurchaseMRN_FB.setStrMsgType("1");
				eObj = null;
		   }	   
	}
	
	//voucher print
	public static void indentPrint(IssueTrackRptFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		IssueTrackRptBO bo = null;
		IssueTrackRptVO vo = null;
		
		String strmsgText = "";
	
		String str3 ="";
		
		
		HisUtil            util = null;
		
		StringBuffer sb = new StringBuffer("");
		String finalPrint ="";
		String strSearchItemInitView = "";
		Stack<String> stc = null;
		try 
		{
			bo = new IssueTrackRptBO();
			vo = new IssueTrackRptVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
				
	          util = new HisUtil("MMSModule", "IssueTrackRptDATA");
	          stc= new Stack<String>();
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);

	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
		 	vo.setStrStoreId(request.getParameter("strStoreId"));
			vo.setStrStoreName(request.getParameter("storeName"));
		   	vo.setStrStartDate((String) request.getParameter("strFromDate"));
			vo.setStrEndDate((String) request.getParameter("strToDate"));
			vo.setStrReqStoreId((String) request.getParameter("strReqStoreId"));
			vo.setStrCmodeId((String) request.getParameter("strCmodeId"));
			vo.setStrMode("1");
			
			System.out.println("vo.getStrCmodeId--"+vo.getStrCmodeId());
			
         	bo.viewData(vo);
         	
         	
         	formBean.setStrStartDate((String) request.getParameter("strFromDate"));
			formBean.setStrEndDate((String) request.getParameter("strToDate"));
			formBean.setStrCmodeId((String) request.getParameter("strCmodeId"));
			formBean.setStrStoreName(request.getParameter("storeName"));
         	//Change Request
			
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			str3  =  IssueTrackRptHLP.getIndentDetailsPrint(vo);			
			stc.push(str3);
			//formBean.setIssueDtlHlp(str3);
			formBean.setBackPages(stc);
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(hosCode);
			
			//strSearchItemInitView=	IssueTrackRptHLP.getIssueDtlsInit(formBean,vo);
			
			finalPrint = sb.toString();
			//request.setAttribute("vo", vo);
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(str3);
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "LPReportsTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LPReportsTransDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	
	public static void getIssueDetail(IssueTrackRptFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		IssueTrackRptBO bo = null;
		IssueTrackRptVO vo = null;
		
		String strmsgText = "";
	
		String str3 ="";
		
		
		HisUtil util = null;
		
		StringBuffer sb = new StringBuffer("");
		String finalPrint ="";
		String strSearchItemInitView = "";
		Stack<String> stc = null;

		try 
		{
			bo = new IssueTrackRptBO();
			vo = new IssueTrackRptVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
				
	        util = new HisUtil("MMSModule", "IssueTrackRptDATA");
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
			stc=formBean.getBackPages();
//			if(formBean.getIssueDtlHlp().length()>0) {
//				stc.push(formBean.getIssueDtlHlp());
//			}
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
		 	vo.setStrStoreId(request.getParameter("strStoreId"));
			vo.setStrIssueNo(request.getParameter("issueNo"));
			vo.setStrIndentNo(request.getParameter("indentNo"));
			vo.setStrStoreName(request.getParameter("storeName"));
		   	vo.setStrStartDate((String) request.getParameter("strFromDate"));
			vo.setStrEndDate((String) request.getParameter("strToDate"));
			vo.setStrReqStoreId((String) request.getParameter("strReqStoreId"));
			vo.setStrCmodeId((String) request.getParameter("strCmodeId"));
			vo.setStrIssuedBy((String) request.getParameter("issueBy"));
			vo.setStrReceivedBy((String) request.getParameter("receiveBy"));
			
			vo.setStrMode("1");
			
			
			//System.out.println("getIssueDetail -- stc.size ----" + formBean.getBackPages().size());

         	bo.getIssueDetail(vo);
         	
         	//Change Request
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			str3  =  IssueTrackRptHLP.getIssuedItemDetail(vo.getStrItemCategoryId(), vo.getStrHospitalCode(), vo
					.getItemDetailsWS(), vo.getStrStoreId(),vo.getStrIssueNo(),vo);			
			stc.push(str3);
			//formBean.setIssueDtlHlp(str3);
			formBean.setBackPages(stc);
			//System.out.println("stack ----" + formBean.getBackPages().size());
			
			//formBean.setBackPages(vo.getBackPages());
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(hosCode);
			
			//strSearchItemInitView=	IssueTrackRptHLP.getIssueDtlsInit(formBean,vo);
			
			finalPrint = sb.toString();
			
										
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(str3);
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IssueTrackRptDATA.getIssueDetail(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTrackRptDATA->getIssueDetail()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	public static void getIssueDtlForSubStore(IssueTrackRptFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		IssueTrackRptBO bo = null;
		IssueTrackRptVO vo = null;
		
		String strmsgText = "";
	
		String str3 ="";
		
		
		HisUtil util = null;
		
		StringBuffer sb = new StringBuffer("");
		String finalPrint ="";
		String strSearchItemInitView = "";
		Stack<String> stc = null;

		try 
		{
			bo = new IssueTrackRptBO();
			vo = new IssueTrackRptVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
				
	        util = new HisUtil("MMSModule", "IssueTrackRptDATA");
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
			stc=formBean.getBackPages();
//			if(formBean.getIssueDtlHlp().length()>0) {
//				stc.push(formBean.getIssueDtlHlp());
//			}
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
		 	vo.setStrStoreId(request.getParameter("strStoreId"));
		 	vo.setStrReqStoreId(request.getParameter("strReqStoreId"));
			vo.setStrIssueNo(request.getParameter("issueNo"));
			vo.setStrIndentNo(request.getParameter("indentNo"));
			vo.setStrStoreName(request.getParameter("storeName"));
		   	vo.setStrStartDate((String) request.getParameter("strFromDate"));
			vo.setStrEndDate((String) request.getParameter("strToDate"));
			//vo.setStrReqStoreId((String) request.getParameter("strReqStoreId"));
			vo.setStrCmodeId((String) request.getParameter("strCmodeId"));
			vo.setStrIssuedBy((String) request.getParameter("issueBy"));
			vo.setStrReceivedBy((String) request.getParameter("receiveBy"));
			vo.setStrCategoryCode((String) request.getParameter("catgCode"));
			vo.setStrBatchNo((String) request.getParameter("batchNo"));
			vo.setStrItemBrandId((String) request.getParameter("itemBrandId"));
			vo.setStrItemId((String) request.getParameter("itemId"));
			vo.setStrRaisingStoreName((String) request.getParameter("reqStoreName"));
			vo.setStrItemName((String) request.getParameter("itemName"));
			vo.setStrMode("1");
			
			//System.out.println("getIssueDetail -- stc.size ----" + formBean.getBackPages().size());

         	bo.getIssueDtlForSubStore(vo);
         	
         	//Change Request
			
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			String str = IssueTrackRptHLP.getItemCurrStockDtl(vo);
			str3  =  IssueTrackRptHLP.getIssueDtlForSubStore(vo,str);			
			stc.push(str3);
			formBean.setBackPages(stc);
			//System.out.println("stack ----" + formBean.getBackPages().size());
			
			//formBean.setBackPages(vo.getBackPages());
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(hosCode);
			
			//strSearchItemInitView=	IssueTrackRptHLP.getIssueDtlsInit(formBean,vo);
			
			finalPrint = sb.toString();
			
										
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(str3);
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IssueTrackRptDATA.getIssueDetail(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTrackRptDATA->getIssueDetail()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	public static void undo(IssueTrackRptFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		IssueTrackRptBO bo = null;
		IssueTrackRptVO vo = null;
		
		String strmsgText = "";
	
		String str3 ="";
		
		
		HisUtil            util = null;
		
		StringBuffer sb = new StringBuffer("");
		String finalPrint ="";
		String strSearchItemInitView = "";
		Stack<String> stc;
		try 
		{
			bo = new IssueTrackRptBO();
			vo = new IssueTrackRptVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
				
	          util = new HisUtil("MMSModule", "IssueTrackRptDATA");
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			stc=formBean.getBackPages();
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			String previousPage = "Previous pages are not available.";
			//stc.pop();
			if(!stc.empty()) {
				previousPage=stc.peek();
			}
//			if(stc.size()==1) {
//				formBean.setIssueDtlHlp(stc.peek());
//			}
			formBean.setBackPages(stc);
		 	System.out.println("undo ----" + formBean.getBackPages().size());
		 	response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(previousPage);
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IssueTrackRptDATA.getIssueDetail(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTrackRptDATA->getIssueDetail()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
}
