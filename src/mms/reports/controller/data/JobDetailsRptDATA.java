package mms.reports.controller.data;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.JobDetailsRptBO;
import mms.reports.controller.fb.JobDetailsRptFB;
import mms.reports.controller.hlp.JobDetailsRptHLP;
import mms.reports.vo.JobDetailsRptVO;

public class JobDetailsRptDATA {

	public static void getViewDtl(JobDetailsRptFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
		   JobDetailsRptVO vo = null;
		   JobDetailsRptBO bo = null;
		   HisUtil hisutil = null;
		   try{
			    String strResult="";
			    vo=new JobDetailsRptVO();
			   	bo=new JobDetailsRptBO();
			   	hisutil = new HisUtil("MMS","JobDetailsRptDATA");
			   	String seatid = request.getSession().getAttribute("SEATID").toString();
			   				
			  
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
			   	vo.setStrSeatId(seatid);
			   	vo.setStrTypeId(request.getParameter("strTypeId"));
			   	vo.setStrTypeName(request.getParameter("strTypeName"));
				
				bo.setViewPageDtl(vo);  // pkg_mms_view2.issue_stock_report [ Mode - 1 ]
				strResult=JobDetailsRptHLP.getTransferDetails(vo,request,formBean);
				System.out.println("--strResult---"+strResult);
				if(vo.getWsViewDtl()!= null){
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult); 		 
				}
				 else{
				    HisException eObj = new HisException("MMS", "JobDetailsRptDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "JobDetailsRptDATA->getViewDtl()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//formBean.setStrMsgType("1");
				eObj = null;
		   }	   
	}
}
