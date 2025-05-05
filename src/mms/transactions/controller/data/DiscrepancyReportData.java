package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.bo.DiscrepancyReportGlobalBO;
import mms.transactions.controller.hlp.DiscrepancyReportHLP;
import mms.transactions.vo.DiscrepancyReportGlobalVO;


public class DiscrepancyReportData {

	public static void getBatchWiseDtl(HttpServletRequest request,HttpServletResponse response)
	{
		 String strmsgText = "";
		 DiscrepancyReportGlobalBO bo = null;
		 DiscrepancyReportGlobalVO vo = null;
		String result="";
		try
		{
			
			vo=new DiscrepancyReportGlobalVO();
			bo=new DiscrepancyReportGlobalBO();
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrItemIdBatchWise(request.getParameter("itemId"));
			vo.setStrItemIdBrandBatchWise(request.getParameter("itemBrandId"));
			vo.setStrStoreId(request.getParameter("strId"));
			vo.setStrStockNo(request.getParameter("stockNo"));
			bo.getBatchWiseDtl(vo);
			result=DiscrepancyReportHLP.getBatchWiseDtl(vo.getBatchWiseWS());
		//	//System.out.println("result"+result);
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			response.getWriter().print(result);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			strmsgText = "DiscrepancyReportData.getBatchWiseDtl() --> "
				+ e.getMessage();
			HisException eObj = new HisException("IPD", "DiscrepancyReportData->getBatchWiseDtl()", strmsgText);
		    String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
		    try
		    {
		    	response.getWriter().print(response1);
		    	eObj=null;
		    }
		    catch(Exception e1)
		    {
		    	
		    }

		}
	}
	
	public static void getNonDiscrepancyReport(
			HttpServletRequest request,HttpServletResponse response){
				String result="";
	//		String strmsgText="";
			DiscrepancyReportGlobalVO vo = null;
			
			try{
				  vo=new DiscrepancyReportGlobalVO();
				  vo.setStrStoreId(request.getParameter("storeId"));
				  vo.setStrStockNo(request.getParameter("stockNo"));
				  vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				  vo.setStrGroupId(request.getParameter("groupId"));
				  result=DiscrepancyReportHLP.getNonDiscrepancyReport(vo.getStrHospitalCode(), vo.getStrStoreId(), vo.getStrStockNo(), vo.getStrGroupId());
				  response.getWriter().print(result);
				
			}catch(Exception e){
					e.printStackTrace();
			String	strmsgText = "mms.transactions.DiscrepancyReportData.getNonDiscrepancyReport --> "
						+ e.getMessage();
			
			  new HisException("IPD", "DiscrepancyReportData->getNonDiscrepancyReport()", strmsgText);
			
			}
			
					
		
	}
	
}
