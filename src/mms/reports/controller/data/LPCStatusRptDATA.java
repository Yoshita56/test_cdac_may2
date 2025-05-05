package mms.reports.controller.data;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.LPCStatusRptBO;
import mms.reports.controller.fb.LPCStatusRptFB;
import mms.reports.controller.hlp.LPCStatusRptHLP;
import mms.reports.vo.LPCStatusRptVO;

public class LPCStatusRptDATA {

	public static void getViewDtl(LPCStatusRptFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
		   LPCStatusRptVO vo = null;
		   LPCStatusRptBO bo = null;
		   ReportUtil ts = new ReportUtil();		
		   String reportFormat = "html";
		   String strReportName = "Issue Details";
		   Map<String, Object> params = new HashMap<String, Object>();
		   String strCurrentDate="";
		   HisUtil hisutil = null;
		   try{
			    String strResult="";
			    vo=new LPCStatusRptVO();
			   	bo=new LPCStatusRptBO();
			   	hisutil = new HisUtil("MMS","LPCStatusRptDATA");
			   	String seatid = request.getSession().getAttribute("SEATID").toString();
			   				
			  
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
			   	vo.setStrSeatId(seatid);
			   	vo.setStrCategoryId(request.getParameter("strCategoryId"));
			   	vo.setStrCategoryName(request.getParameter("strCategoryName"));
				
				bo.setViewPageDtl(vo);  // pkg_mms_view2.issue_stock_report [ Mode - 1 ]
				strResult=LPCStatusRptHLP.getTransferDetails(vo,request,formBean);
				System.out.println("--strResult---"+strResult);
				if(vo.getWsViewDtl()!= null){
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult); 		 
				}
				 else{
				    HisException eObj = new HisException("MMS", "LPCStatusRptDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "LPCStatusRptDATA->getViewDtl()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//formBean.setStrMsgType("1");
				eObj = null;
		   }	   
	}
}
