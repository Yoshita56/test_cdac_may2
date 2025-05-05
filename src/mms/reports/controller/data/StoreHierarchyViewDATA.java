package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.StoreHierarchyViewBO;
import mms.reports.controller.fb.StoreHierarchyViewFB;
import mms.reports.controller.hlp.StoreHierarchyViewHLP;

import mms.reports.vo.StoreHierarchyViewVO;

public class StoreHierarchyViewDATA {


	public static void setInitDtl(StoreHierarchyViewFB formBean,
			HttpServletRequest request,HttpServletResponse response) {

		StoreHierarchyViewVO vo = null;
		StoreHierarchyViewBO bo = null;
		
		String strCurrentDate = "";
		String strStoreVal = "";
		
		HisUtil util = null;

		try {
			System.out.println("---------ReturnItemListingRptDATA_NEW.setInitDtl---------");

			bo = new StoreHierarchyViewBO();
			vo = new StoreHierarchyViewVO();
			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			bo.getInitDtl(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}else {
				util = new HisUtil("Issue Listing Report", "ItemListingRptData");
				strCurrentDate = util.getASDate("dd-MMM-yyyy");
				formBean.setStrCurrentDate(strCurrentDate);
				
				if (vo.getStrWS() != null && vo.getStrWS().size() > 0) {
					strStoreVal = util.getOptionValue(vo.getStrWS(), "0","0^Select Value", false);
				} 
				else {
					strStoreVal = util.getOptionValue(vo.getStrWS(), "0","-1^Select Value", false);
				}
				formBean.setStrStoreCmb(strStoreVal);
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS",
					"IssueDetailRptData->setInitDtl()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {

		}

	}

	public static void showReportNew(StoreHierarchyViewFB formBean, HttpServletRequest request, HttpServletResponse response) {
	    String strmsgText = "";
	    StoreHierarchyViewVO vo = null;
	    StoreHierarchyViewBO bo = null;
	    ReportUtil ts = new ReportUtil();
	    try {

	        vo = new StoreHierarchyViewVO();
	        bo = new StoreHierarchyViewBO();
	        

	        vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
	        vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

	        vo.setStrStoreId(request.getParameter("storeId"));

	        bo.setViewPageDtl(vo);

	        String strResult = StoreHierarchyViewHLP.getReturnReqDtls(vo);
	        System.out.println("-----strResult------"+strResult);
	        response.setContentType("text/plain");
	        response.getWriter().print(strResult);
	        
	    } catch (Exception _err) {
	        strmsgText = _err.getMessage();
	        HisException eObj = new HisException("MMS", "ReturnItemListingRptData_NEW->getViewDtl()", strmsgText);
	        formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");

	        eObj = null;
	    }
	}

	

}
		