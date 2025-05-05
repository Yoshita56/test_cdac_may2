package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.DrugQualityStatusRptBO;
import mms.reports.controller.fb.ConsumptionValueSummaryRptFB;
import mms.reports.controller.fb.DrugQualityStatusRptFB;
import mms.reports.vo.DrugQualityStatusRptVO;
import mms.transactions.bo.QualityCheckControlTransBO;
import mms.transactions.controller.fb.QualityCheckControlTransFB;
import mms.transactions.vo.QualityCheckControlTransVO;

public class DrugQualityStatusRptDATA 
{
	/**
	
	 * Method is Used to Populate the Data for Save Page of
	 * Breakage Item Details Transaction 
	 * @param formBean
	 * @param request
	 */
	public static void getInitializedValues(DrugQualityStatusRptFB _DrugQualityStatusRptFB,HttpServletRequest request) 
	{
		/* Declaring Variable */
		DrugQualityStatusRptBO bo = null;
		DrugQualityStatusRptVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		HisUtil hisUtil=null;
		String seatId = "";
		String strGroupNameCmb;
		
		try 
		{
			/* Creating Object */
			
			bo = new DrugQualityStatusRptBO();
			vo = new DrugQualityStatusRptVO();
			hisUtil=new HisUtil("MMSModule", "DrugQualityStatusRptDATA");
		
	        /* Getting Value from Session */ 
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId  = request.getSession().getAttribute("SEATID").toString();
						
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrItemCategoryNo("10");
			
			/* Calling SampleSentTransBO method  */
			
			bo.getGroupName(vo);
			
			_DrugQualityStatusRptFB.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 
			if (vo.getGroupIdWS() != null && vo.getGroupIdWS().size() > 0) 
			{			
				strGroupNameCmb = hisUtil.getOptionValue(vo.getGroupIdWS(), "", "0^All", true);
			}
			else 
			{
				strGroupNameCmb = "<option value='0'>Select Value</option>";
			}
			_DrugQualityStatusRptFB.setStrGroupNameCmb(strGroupNameCmb);
			
			bo.getDrugName(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			
			String cmbstr = "";

			if (vo.getItemIdWS() != null	&& vo.getItemIdWS().size() > 0)
			{

				cmbstr = hisUtil.getOptionValue(vo.getItemIdWS(),"", "0^All", false);

			} else {

				cmbstr = "<option value='0'>All</option>";
			}
			_DrugQualityStatusRptFB.setStrDrugNameCmb(cmbstr);
		}
		  catch (Exception e) 
		  {
	       
			strmsgText = "DrugQualityStatusRptFBDATA.initSampleSent(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms","DrugQualityStatusRptDATA->initSampleSent()", strmsgText);
			_DrugQualityStatusRptFB.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
	
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

  }
	public static void getDrugNameCmb(DrugQualityStatusRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{

		String strmsgText = "";
		DrugQualityStatusRptBO bo = null;
		DrugQualityStatusRptVO vo = null;
		HisUtil hisutil = null;
		try {

			vo = new DrugQualityStatusRptVO();
			bo = new DrugQualityStatusRptBO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			String   strGroupId = (String) request.getParameter("groupId");
			
			
			vo.setStrHospitalCode(strHospitalCode);
            vo.setStrGroupId(strGroupId);
            
            
			bo.getDrugName(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "SampleSentTransDATA");

			String cmbstr = "";

			if (vo.getItemIdWS() != null	&& vo.getItemIdWS().size() > 0)
			{

				cmbstr = hisutil.getOptionValue(vo.getItemIdWS(),"", "0^All", false);

			} else {

				cmbstr = "<option value='0'>All</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"QualityCheckControlTransDATA->getCategoryCmb()", strmsgText);
			try {

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}
	}
	
	public static void showReport(DrugQualityStatusRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{
		ReportUtil ts = new ReportUtil();
		String reportFormat = "html";
		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strGroupId = formBean.getStrGroupId();
			String strCatCode = "10";
			String strUserRemarks = formBean.getStrUserRemarks();
			//String[] strStoreList = formBean.getStrStoreName();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			
			////System.out.println("strStoreId-"+strStoreId);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
		
			
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			String strReportName = "Drug Quality Status";
			
			String reportPath = "/mms/reports/drugQualityStatus_mms_rpt.rptdesign";
				
			/*	 //System.out.println("report_Name :::"+ strReportName);
				//System.out.println("report_Footer_Visible :::"+ footerVisible);
				//System.out.println("mode :::"+ "1");
				//System.out.println("hospCode :::"+ strHospitalCode);
				//System.out.println("catCode :::"+ strCatCode);
				//System.out.println("groupId :::"+ formBean.getStrGroupId());
				//System.out.println("itemBrandId :::"+ formBean.getStrItemBrandId());
				//System.out.println("storeId :::"+ formBean.getStrQcStatus());
				//System.out.println("itemBrandName :::"+ formBean.getStrItemBrandName());				
				//System.out.println("fromDate :::"+ strFromDate);
				//System.out.println("toDate :::"+ strToDate);
				//System.out.println("user_remarks :::"+ strUserRemarks);
				
			*/
			
				//params.put("report_id", ");
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("mode", "1");
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("groupId", formBean.getStrGroupId());
				params.put("itemBrandId", formBean.getStrItemBrandId());
				params.put("storeId", formBean.getStrQcStatus()); //storeId = QC Status Value ( 0 for All, 1 for Pass, 2 for Fail, 3 for Under Testing)
				params.put("itemBrandName", formBean.getStrItemBrandName());				
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				params.put("user_remarks", strUserRemarks);
					
				ts.displayReport(request, response, reportPath, reportFormat,
						params,"0");
			
		      	
		} catch (Exception e) {

			//e.printStackTrace();

		}
	}
	
	

}
