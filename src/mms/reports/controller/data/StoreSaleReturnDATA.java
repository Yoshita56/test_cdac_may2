package mms.reports.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.reports.bo.StoreSaleReturnBO;
import mms.reports.controller.fb.StoreSaleReturnFB;
import mms.reports.controller.hlp.StoreSaleReturnHLP;
import mms.reports.vo.StoreSaleReturnVO;

public class StoreSaleReturnDATA {
	
	//store list
	public static void setInitializedValues(StoreSaleReturnFB formBean,	HttpServletRequest request, HttpServletResponse response) {

		StoreSaleReturnBO bo = null;
		StoreSaleReturnVO voObj = null;
		
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

			bo = new StoreSaleReturnBO();
			voObj = new StoreSaleReturnVO();
			
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
			
//		    strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^Select Value", false);	
		    strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);	

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
	public static void showReportNew(StoreSaleReturnFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
	       StoreSaleReturnVO vo = null;
	       StoreSaleReturnBO bo = null;
		   ReportUtil ts = new ReportUtil();		
		
		   try 
			{	
			   String strResult="";
			    vo=new StoreSaleReturnVO();
			   	bo=new StoreSaleReturnBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   			   	
			   	vo.setStrStoreId(request.getParameter("strStoreId"));
				vo.setStrStoreName(request.getParameter("storeName"));
				vo.setBtnchk(request.getParameter("btnchk"));
				
				
				vo.setStrMode("1");
				
				if(vo.getBtnchk().equals("1")) {
					
					vo.setStrStartDate((String) request.getParameter("strFromDate"));
					vo.setStrEndDate((String) request.getParameter("strToDate"));
					bo.setViewPageDtl(vo);
					strResult=StoreSaleReturnHLP.getIssueTrackDetails(vo);
					
				}else {
					
					vo.setStrStartDate((String) request.getParameter("Ydate"));
					System.out.println("----vo.setStrStartDate-----"+vo.getStrStartDate());
					System.out.println("----vo.getStrStoreId-------"+vo.getStrStoreId());
					bo.setYearWiseViewDtl(vo);
					strResult=StoreSaleReturnHLP.getYearWiseIssueTrackDtl(vo);
					
				}
				response.getWriter().print(strResult);
		   }catch(Exception _err){
			   
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->showReportNew()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_LocalPurchaseMRN_FB.setStrMsgType("1");
				eObj = null;
		   }	   
	}
	
	//voucher print
	public static void indentPrint(StoreSaleReturnFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		StoreSaleReturnBO bo = null;
		StoreSaleReturnVO vo = null;
		
		String strmsgText = "";
	
		String str3 ="";
		
		
		HisUtil            util = null;
		
		StringBuffer sb = new StringBuffer("");
		String finalPrint ="";
		String strSearchItemInitView = "";

		try 
		{
			bo = new StoreSaleReturnBO();
			vo = new StoreSaleReturnVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
				
	          util = new HisUtil("MMSModule", "IssueTrackRptDATA");
			
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
			
            System.out.println("-------------strLogoName--------------"+vo.getStrLogoName());

         	bo.viewData(vo);
         	
         	//Change Request
			
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

//			str3  =  StoreSaleReturnHLP.getIndentDetailsPrint(vo);			
			
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(hosCode);
			
			//strSearchItemInitView=	StoreSaleReturnHLP.getIssueDtlsInit(formBean,vo);
			
			finalPrint = sb.toString();
										
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
}
