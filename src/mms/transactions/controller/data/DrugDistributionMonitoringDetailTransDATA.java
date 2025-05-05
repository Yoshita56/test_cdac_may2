package mms.transactions.controller.data;

import java.sql.SQLException;
import java.util.ResourceBundle;

import hisglobal.exceptions.HisException;

import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.bo.DrugDistributionMonitoringDetailTransBO;
import mms.transactions.controller.fb.DrugDistributionMonitoringDetailTransFB;
import mms.transactions.vo.DrugDistributionMonitoringDetailTransVO;


public class DrugDistributionMonitoringDetailTransDATA {
	
	public static void getInitialValues(DrugDistributionMonitoringDetailTransFB formBean, HttpServletRequest request) {

		DrugDistributionMonitoringDetailTransBO bo = null;
		DrugDistributionMonitoringDetailTransVO vo = null;

		HisUtil hisutil = null;
		
		String strmsgText = null;
		String strDepartment,strUnitVal;
		ResourceBundle resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
		
		try 
		{
			
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());			
			
			formBean.setStrSDFFlgColor("Pink");//(mmscofigutil.getStrSDFColor());
			
			bo = new DrugDistributionMonitoringDetailTransBO();
			vo = new DrugDistributionMonitoringDetailTransVO();
			hisutil = new HisUtil("MMS", "DrugDistributionMonitoringDetailTransDATA"); 
			String strConfCatCode = MmsConfigUtil.STAFF_CAT_CODE;
			formBean.setStrConfCatCode(strConfCatCode);
			formBean.setStrCurrentDate(hisutil.getASDate("dd-MMM-yyyy"));
			
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getDepartmentValues(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			else
			{
				if(vo.getDepartmentWS()!=null){
					strDepartment=hisutil.getOptionValue(vo.getDepartmentWS(),
							"0", "0^All", true);
				}else{
					strDepartment="<option value='0'>Select Value</option>";
				}
			}
			
			vo.setStrMode("2");
			bo.getUnitDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			else
			{
				if(vo.getStrUnitWs()!=null)
				{
					strUnitVal=hisutil.getOptionValue(vo.getStrUnitWs(),"0", "0^All", true);
				}
				else
				{
					strUnitVal="<option value='0'>Select Value</option>";
				}
			}
			
			
			
			formBean.setStrDeptValues(strDepartment);
			formBean.setStrUnitValues(strUnitVal);
			
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.DrugDistributionMonitoringDetailTransDATA.getStoreDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugDistributionMonitoringDetailTransDATA->getStoreDtls()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
		}
	}
	
	public static void getUnitValues(DrugDistributionMonitoringDetailTransFB formBean, HttpServletRequest request,HttpServletResponse response) {

		DrugDistributionMonitoringDetailTransBO bo = null;
		DrugDistributionMonitoringDetailTransVO vo = null;

		HisUtil hisutil = null;
		
		String strmsgText = null;
		String strUnitVal,strDeptId;
		try 
		{
			bo = new DrugDistributionMonitoringDetailTransBO();
			vo = new DrugDistributionMonitoringDetailTransVO();
			hisutil = new HisUtil("MMS", "DrugDistributionMonitoringDetailTransDATA"); 
		
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			strDeptId= request.getParameter("deptId");
			vo.setStrDeptCode(strDeptId);
			
			if(strDeptId!=null && !strDeptId.equals("0") )
			{
				vo.setStrMode("1");	
			}
			else
			{
				vo.setStrMode("2");
			}
			
			bo.getUnitDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			else
			{
				if(vo.getStrUnitWs()!=null && vo.getStrUnitWs().size() > 0)
				{
					strUnitVal=hisutil.getOptionValue(vo.getStrUnitWs(),"0", "0^All", true);
				}
				else
				{
					strUnitVal="<option value='0'>All</option>";
				}
			}
			
				
			  response.setHeader("Cache-Control", "no-cache");
			  response.getWriter().print(strUnitVal);
				
		
		} catch (Exception e) {
		  //e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("bmed", "ComplaintEscalationMstDATA->getEmpInfo()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

		     } catch (Exception e1) {
				
			}
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			
		}
	}
	
	/**
	 * 
	 * @param drugDistributionMonitoringDetailTransFB_p
	 * @param request_p
	 * @param response
	 */
	public static void searchPatientDtls(DrugDistributionMonitoringDetailTransFB drugDistributionMonitoringDetailTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		DrugDistributionMonitoringDetailTransBO drugDistributionMonitoringDetailTransBO = null;
		DrugDistributionMonitoringDetailTransVO drugDistributionMonitoringDetailTransVO = null;
		

		String strPatientDetailsTable;
		String strMsgText = "";
		String	strHospitalCode,strSeatId;
		
		HisUtil hisutil=null;
		String strCrNo,strPatientName,strDeptCode,strUnitCode,strFromDate,strToDate;
		try {
			drugDistributionMonitoringDetailTransBO = new DrugDistributionMonitoringDetailTransBO();
			drugDistributionMonitoringDetailTransVO = new DrugDistributionMonitoringDetailTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","DrugDistributionMonitoringDetailTransDATA");

			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = request_p.getSession().getAttribute("SEATID").toString();
			
			drugDistributionMonitoringDetailTransVO.setStrHospitalCode(strHospitalCode);
			
			strCrNo =	(request_p.getParameter("crNo")==null || request_p.getParameter("crNo").equals("")) ? "0" : request_p.getParameter("crNo") ;
			strPatientName =	(request_p.getParameter("patientName")==null) ? "" : request_p.getParameter("patientName") ;
			strDeptCode =	request_p.getParameter("deptId");
			strUnitCode =	request_p.getParameter("unitId");
			strFromDate =	request_p.getParameter("fromDate");
			strToDate =	request_p.getParameter("toDate");
			
			drugDistributionMonitoringDetailTransVO.setStrCrNumber(strCrNo);			
			drugDistributionMonitoringDetailTransVO.setStrPatientName(strPatientName);
			drugDistributionMonitoringDetailTransVO.setStrDeptCode(strDeptCode);
			drugDistributionMonitoringDetailTransVO.setStrUnitCode(strUnitCode);
			drugDistributionMonitoringDetailTransVO.setStrFromDate(strFromDate);
			drugDistributionMonitoringDetailTransVO.setStrToDate(strToDate);
			drugDistributionMonitoringDetailTransVO.setStrHospitalCode(strHospitalCode);
			drugDistributionMonitoringDetailTransVO.setStrSeatId(strSeatId);
			drugDistributionMonitoringDetailTransVO.setStrIssueNo("0");
			drugDistributionMonitoringDetailTransVO.setStrMode("1");
			
			//Calling BO
			drugDistributionMonitoringDetailTransBO.viewPatientDetailsRecord(drugDistributionMonitoringDetailTransVO);
			
			
			
			
			if (drugDistributionMonitoringDetailTransVO.getStrMsgType().equals("1")) {
				throw new Exception(drugDistributionMonitoringDetailTransVO.getStrMsgString());
			}
			
			strPatientDetailsTable	=	getPatientDetailsTable(drugDistributionMonitoringDetailTransVO.getWrsData());
			
			
		//	drugDistributionMonitoringDetailTransFB_p.setStrBudgetDetailsTable(strBudgetDetailsTable);
			
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strPatientDetailsTable);
			
		} 
		catch (Exception e) 
		{
			strMsgText = "DrugDistributionMonitoringDetailTransDATA.searchPatientDtls(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","DrugDistributionMonitoringDetailTransDATA->searchPatientDtls()", strMsgText);
			drugDistributionMonitoringDetailTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			drugDistributionMonitoringDetailTransBO = null;
			drugDistributionMonitoringDetailTransVO = null;
		}
	}
	
	
	
	/**
	 * 
	 * @param drugDistributionMonitoringDetailTransFB_p
	 * @param request_p
	 * @param response
	 */
	public static void getIssuedDtls(DrugDistributionMonitoringDetailTransFB drugDistributionMonitoringDetailTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		DrugDistributionMonitoringDetailTransBO drugDistributionMonitoringDetailTransBO = null;
		DrugDistributionMonitoringDetailTransVO drugDistributionMonitoringDetailTransVO = null;
		

		String strIssuedDtls;
		String strMsgText = "";
		String	strHospitalCode,strSeatId;
		String strFirstIssuedDate="";
		HisUtil hisutil=null;
		String strCrNo,strPatientName,strDeptCode,strUnitCode,strFromDate,strToDate;
		try {
			drugDistributionMonitoringDetailTransBO = new DrugDistributionMonitoringDetailTransBO();
			drugDistributionMonitoringDetailTransVO = new DrugDistributionMonitoringDetailTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","DrugDistributionMonitoringDetailTransDATA");

			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = request_p.getSession().getAttribute("SEATID").toString();
			
			drugDistributionMonitoringDetailTransVO.setStrHospitalCode(strHospitalCode);
			
			strCrNo =	(request_p.getParameter("crNo")==null || request_p.getParameter("crNo").equals("")) ? "0" : request_p.getParameter("crNo") ;
			
			strDeptCode =	(request_p.getParameter("deptId")==null || request_p.getParameter("deptId").equals("")) ? "0" : request_p.getParameter("deptId") ;
			
			strUnitCode =	(request_p.getParameter("unitId")==null || request_p.getParameter("unitId").equals("")) ? "0" : request_p.getParameter("unitId") ;
			
			strFromDate =	request_p.getParameter("fromDate");
			strToDate =	request_p.getParameter("toDate");
			
			drugDistributionMonitoringDetailTransVO.setStrCrNumber(strCrNo);			
			drugDistributionMonitoringDetailTransVO.setStrPatientName("");
			drugDistributionMonitoringDetailTransVO.setStrDeptCode(strDeptCode);
			drugDistributionMonitoringDetailTransVO.setStrUnitCode(strUnitCode);
			drugDistributionMonitoringDetailTransVO.setStrFromDate(strFromDate);
			drugDistributionMonitoringDetailTransVO.setStrToDate(strToDate);
			drugDistributionMonitoringDetailTransVO.setStrHospitalCode(strHospitalCode);
			drugDistributionMonitoringDetailTransVO.setStrSeatId(strSeatId);
			drugDistributionMonitoringDetailTransVO.setStrIssueNo("0");
			drugDistributionMonitoringDetailTransVO.setStrMode("2");
			
			//Calling BO
			drugDistributionMonitoringDetailTransBO.viewPatientDetailsRecord(drugDistributionMonitoringDetailTransVO);
			
			
			
			
			if (drugDistributionMonitoringDetailTransVO.getStrMsgType().equals("1")) {
				throw new Exception(drugDistributionMonitoringDetailTransVO.getStrMsgString());
			}
			else
			{
				if(drugDistributionMonitoringDetailTransVO.getWrsData()!=null)
				{
					if(drugDistributionMonitoringDetailTransVO.getWrsData().next())
					{
						strFirstIssuedDate = drugDistributionMonitoringDetailTransVO.getWrsData().getString(1);
					}
					drugDistributionMonitoringDetailTransVO.getWrsData().beforeFirst();
					strIssuedDtls=hisutil.getOptionValue(drugDistributionMonitoringDetailTransVO.getWrsData(),	strFirstIssuedDate, "0^Select Value", true);
				}else{
					strIssuedDtls="<option value='0'>Select Value</option>";
				}
			}
					
			
			
		//	drugDistributionMonitoringDetailTransFB_p.setStrBudgetDetailsTable(strBudgetDetailsTable);
			
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strIssuedDtls);
			
		} 
		catch (Exception e) 
		{
			strMsgText = "DrugDistributionMonitoringDetailTransDATA.searchPatientDtls(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","DrugDistributionMonitoringDetailTransDATA->searchPatientDtls()", strMsgText);
			drugDistributionMonitoringDetailTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			drugDistributionMonitoringDetailTransBO = null;
			drugDistributionMonitoringDetailTransVO = null;
		}
	}
	
	
	/**
	 * 
	 * @param drugDistributionMonitoringDetailTransFB_p
	 * @param request_p
	 * @param response
	 */
	/*public static void getPrescribedDtls(DrugDistributionMonitoringDetailTransFB drugDistributionMonitoringDetailTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		DrugDistributionMonitoringDetailTransBO drugDistributionMonitoringDetailTransBO = null;
		DrugDistributionMonitoringDetailTransVO drugDistributionMonitoringDetailTransVO = null;
		

		String strPrescribedDtls;
		String strMsgText = "";
		String	strHospitalCode,strSeatId;
		String strFirstPrescribedDate="";
		
		HisUtil hisutil=null;
		String strCrNo,strPatientName,strDeptCode,strUnitCode,strFromDate,strToDate;
		try {
			drugDistributionMonitoringDetailTransBO = new DrugDistributionMonitoringDetailTransBO();
			drugDistributionMonitoringDetailTransVO = new DrugDistributionMonitoringDetailTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","DrugDistributionMonitoringDetailTransDATA");

			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = request_p.getSession().getAttribute("SEATID").toString();
			
			drugDistributionMonitoringDetailTransVO.setStrHospitalCode(strHospitalCode);
			
			strCrNo =	(request_p.getParameter("crNo")==null || request_p.getParameter("crNo").equals("")) ? "0" : request_p.getParameter("crNo") ;
			
			strDeptCode =	(request_p.getParameter("deptId")==null || request_p.getParameter("deptId").equals("")) ? "0" : request_p.getParameter("deptId") ;
			
			strUnitCode =	(request_p.getParameter("unitId")==null || request_p.getParameter("unitId").equals("")) ? "0" : request_p.getParameter("unitId") ;
			
			strFromDate =	request_p.getParameter("fromDate");
			strToDate =	request_p.getParameter("toDate");
			
			drugDistributionMonitoringDetailTransVO.setStrCrNumber(strCrNo);			
			drugDistributionMonitoringDetailTransVO.setStrPatientName("");
			drugDistributionMonitoringDetailTransVO.setStrDeptCode(strDeptCode);
			drugDistributionMonitoringDetailTransVO.setStrUnitCode(strUnitCode);
			drugDistributionMonitoringDetailTransVO.setStrFromDate(strFromDate);
			drugDistributionMonitoringDetailTransVO.setStrToDate(strToDate);
			drugDistributionMonitoringDetailTransVO.setStrHospitalCode(strHospitalCode);
			drugDistributionMonitoringDetailTransVO.setStrSeatId(strSeatId);
			drugDistributionMonitoringDetailTransVO.setStrIssueNo("0");
			drugDistributionMonitoringDetailTransVO.setStrMode("4");
			
			//Calling BO
			drugDistributionMonitoringDetailTransBO.viewPatientDetailsRecord(drugDistributionMonitoringDetailTransVO);
			
			
			
			
			if (drugDistributionMonitoringDetailTransVO.getStrMsgType().equals("1")) {
				throw new Exception(drugDistributionMonitoringDetailTransVO.getStrMsgString());
			}
			else
			{
				if(drugDistributionMonitoringDetailTransVO.getWrsData()!=null)
				{
					if(drugDistributionMonitoringDetailTransVO.getWrsData().next())
					{
						strFirstPrescribedDate = drugDistributionMonitoringDetailTransVO.getWrsData().getString(1);
					}
					drugDistributionMonitoringDetailTransVO.getWrsData().beforeFirst();
					strPrescribedDtls=hisutil.getOptionValue(drugDistributionMonitoringDetailTransVO.getWrsData(),	strFirstPrescribedDate, "0^Select Value", true);
				}else{
					strPrescribedDtls="<option value='0'>Select Value</option>";
				}
			}
					
			
			
		//	drugDistributionMonitoringDetailTransFB_p.setStrBudgetDetailsTable(strBudgetDetailsTable);
			
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strPrescribedDtls);
			
		} 
		catch (Exception e) 
		{
			strMsgText = "DrugDistributionMonitoringDetailTransDATA.searchPatientDtls(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","DrugDistributionMonitoringDetailTransDATA->searchPatientDtls()", strMsgText);
			drugDistributionMonitoringDetailTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			drugDistributionMonitoringDetailTransBO = null;
			drugDistributionMonitoringDetailTransVO = null;
		}
	}
	
	/**
	 * 
	 * @param drugDistributionMonitoringDetailTransFB_p
	 * @param request_p
	 * @param response
	 */
	public static void getIssuedDrugDtls(DrugDistributionMonitoringDetailTransFB drugDistributionMonitoringDetailTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		DrugDistributionMonitoringDetailTransBO drugDistributionMonitoringDetailTransBO = null;
		DrugDistributionMonitoringDetailTransVO drugDistributionMonitoringDetailTransVO = null;
		

		String strPrescribedDtls,strIssuedDrugsDetails;
		String strMsgText = "";
		String	strHospitalCode,strSeatId;
		String strFirstPrescribedDate="";
		
		
		
		
		HisUtil hisutil=null;
		String strCrNo,strPatientName,strDeptCode,strUnitCode,strFromDate,strToDate,strIssueNo;
		try {
			
			
			drugDistributionMonitoringDetailTransBO = new DrugDistributionMonitoringDetailTransBO();
			drugDistributionMonitoringDetailTransVO = new DrugDistributionMonitoringDetailTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","DrugDistributionMonitoringDetailTransDATA");

			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = request_p.getSession().getAttribute("SEATID").toString();
			
			drugDistributionMonitoringDetailTransVO.setStrHospitalCode(strHospitalCode);
			
			strIssueNo =	(request_p.getParameter("issueNo")==null || request_p.getParameter("issueNo").equals("")) ? "0" : request_p.getParameter("issueNo") ;

			
			strCrNo =	(request_p.getParameter("crNo")==null || request_p.getParameter("crNo").equals("")) ? "0" : request_p.getParameter("crNo") ;
			
			strDeptCode =	(request_p.getParameter("deptId")==null || request_p.getParameter("deptId").equals("")) ? "0" : request_p.getParameter("deptId") ;
			
			strUnitCode =	(request_p.getParameter("unitId")==null || request_p.getParameter("unitId").equals("")) ? "0" : request_p.getParameter("unitId") ;
			
			strFromDate =	(request_p.getParameter("fromDate")==null || request_p.getParameter("fromDate").equals("")) ? "0" : request_p.getParameter("fromDate") ;
			strToDate =	(request_p.getParameter("toDate")==null || request_p.getParameter("toDate").equals("")) ? "0" : request_p.getParameter("toDate") ;
			
			drugDistributionMonitoringDetailTransVO.setStrCrNumber(strCrNo);			
			drugDistributionMonitoringDetailTransVO.setStrPatientName("");
			drugDistributionMonitoringDetailTransVO.setStrDeptCode(strDeptCode);
			drugDistributionMonitoringDetailTransVO.setStrUnitCode(strUnitCode);
			drugDistributionMonitoringDetailTransVO.setStrFromDate(strFromDate);
			drugDistributionMonitoringDetailTransVO.setStrToDate(strToDate);
			drugDistributionMonitoringDetailTransVO.setStrHospitalCode(strHospitalCode);
			drugDistributionMonitoringDetailTransVO.setStrIssueNo(strIssueNo);
			
			drugDistributionMonitoringDetailTransVO.setStrSeatId(strSeatId);
			drugDistributionMonitoringDetailTransVO.setStrMode("3");
			
			//Calling BO
			drugDistributionMonitoringDetailTransBO.viewPatientDetailsRecord(drugDistributionMonitoringDetailTransVO);
			
			
			
			
			if (drugDistributionMonitoringDetailTransVO.getStrMsgType().equals("1")) {
				throw new Exception(drugDistributionMonitoringDetailTransVO.getStrMsgString());
			}
			
					
			strIssuedDrugsDetails	=	getIssuedDrugsDetailsTable(drugDistributionMonitoringDetailTransVO.getWrsData());
			
		//	drugDistributionMonitoringDetailTransFB_p.setStrBudgetDetailsTable(strBudgetDetailsTable);
			
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strIssuedDrugsDetails);
			
		} 
		catch (Exception e) 
		{
			strMsgText = "DrugDistributionMonitoringDetailTransDATA.searchPatientDtls(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","DrugDistributionMonitoringDetailTransDATA->searchPatientDtls()", strMsgText);
			drugDistributionMonitoringDetailTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			drugDistributionMonitoringDetailTransBO = null;
			drugDistributionMonitoringDetailTransVO = null;
		}
	}
	
	
	/**
     * This Method is used to get Scan Flag to find Out Whether 
     * Scan document is present in database or not  
     * @param formBean
     * @param request
     * @param response
     */
	public static void getScanFlag(DrugDistributionMonitoringDetailTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{
		DrugDistributionMonitoringDetailTransBO bo = null;
		DrugDistributionMonitoringDetailTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DrugDistributionMonitoringDetailTransBO();
			voObj = new DrugDistributionMonitoringDetailTransVO();
			
			String        strCrNo = request.getParameter("crNo");
			String strEpisodeCode = request.getParameter("strEpisodeCode");
			if (strCrNo == null)
				strCrNo = "0";
			
			voObj.setStrCrNum(strCrNo);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrEpisodeCode(strEpisodeCode);
			
			/*//System.out.println("strCrNo"+strCrNo);
			//System.out.println("formBean.getStrHospitalCode()"+formBean.getStrHospitalCode());
			//System.out.println("strEpisodeCode"+strEpisodeCode);*/
						
			bo.getScanFlag(voObj);

			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());

			}
			String temp = voObj.getStrDocFlg();
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.DrugDistributionMonitoringDetailTransDATA.getItemCatDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugDistributionMonitoringDetailTransDATA->getItemCatDtls()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
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
	
	
	/**
	 * To get Entered Dependent Details HLP
	 * 
	 * @param wrsData_p  the WebRowSet
	 */
	private static String getPatientDetailsTable(WebRowSet wrsData_p)	throws SQLException {
		
		StringBuffer sbTable = new StringBuffer(100);
		StringBuffer sbHeader = new StringBuffer(100);
		StringBuffer sbBody = new StringBuffer(100);
		int nWidth=25;
		int nColspan=5;
		
		sbTable.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
		sbTable.append("<tr>"+	"<td class=\"TITLE\" colspan=\"4\" >Patient Details</td>" + "</tr>");
		sbTable.append("</table>");
		
		/*
		 * Header Row:
		 */

		sbHeader.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
		
		
		sbHeader.append("<td width=\""	+ 15	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Select </td>");
		sbHeader.append("<td width=\""	+ 5	+ "%\" class=\"LABEL\" style=\"text-align: right;\">S No.</td>");
		sbHeader.append("<td width=\""	+ 30	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Patient Name</td>");
		sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Issue Date</td>");
		sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Department Name</td>");
		sbHeader.append("</tr>");

		if (wrsData_p != null && wrsData_p.size() > 0) {		
			/* Result Index */
				//  PAT_NAME(CR NO)
				//  ISSUE_DATE
				//  DEPT_NAME(Unit Code)
				//  HRGNUM_PUK
				//  GNUM_DEPT_CODE
				//  HGNUM_DEPTUNITCODE
			
		
			
			while (wrsData_p.next()) {

				
				String strRownum = wrsData_p.getString("rownm");
				String strPatientName = wrsData_p.getString("PAT_NAME");
				String strIssueDate = wrsData_p.getString("ISSUE_DATE");
				String strDeptName = wrsData_p.getString("DEPT_NAME");
				String strCrNo = wrsData_p.getString("HRGNUM_PUK");
				String strDeptId = wrsData_p.getString("GNUM_DEPT_CODE");
				String strUnitId = wrsData_p.getString("HGNUM_DEPTUNITCODE");
				
             			
				if (strRownum == null) {
					strRownum = "---";
				}
				if (strPatientName == null) {
					strPatientName = "---";
				}
				if (strIssueDate == null) {
					strIssueDate = "---";
				}
				if (strDeptName == null) {
					strDeptName = "---";
				}
				if (strCrNo == null) {
					strCrNo = "0";
				}
				if (strDeptId == null) {
					strDeptId = "0";
				}
				if (strUnitId == null) {
					strUnitId = "0";
				}
				
				String strHiddenVal = strCrNo + "^" +	strDeptId	+ "^" +	strUnitId;
				
				/*
				 * Table Body
				 */

				sbBody.append("<tr>");
						
				sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + "<input type='radio' name='strPatientDtls' onclick='getIssuedDtls();' value = '"+strHiddenVal+"' >" + "</td>");
				sbBody.append("<td class=\"CONTROL\" style=\"text-align: right;\">" + strRownum + "</td>");
				sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strPatientName + "</td>");
				sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strIssueDate + "</td>");
				sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strDeptName + "<input type='hidden' name='strVisitNo' /><input type='hidden' name='strEpisodeCode' value='0'/></td>");
				
				
				sbBody.append("</tr>");
			}
			sbBody.append("</table>");

		} 
		else 
		{
			sbBody.append("<tr>");
			sbBody.append("<td colspan=\""	+ nColspan	+ "\" class=\"CONTROL\" style=\"text-align: center; color: red;\">No Data Found!</td>");
			sbBody.append("</tr></table>");
		}

		return sbTable.toString() + sbHeader.toString() + sbBody.toString();
	}

	

	
	/**
	 * To get Entered Dependent Details HLP
	 * 
	 * @param wrsData_p  the WebRowSet
	 */
	private static String getIssuedDrugsDetailsTable(WebRowSet wrsData_p)	throws SQLException {
		
		StringBuffer sbTable = new StringBuffer(100);
		StringBuffer sbHeader = new StringBuffer(100);
		StringBuffer sbBody = new StringBuffer(100);
		int nWidth=25;
		int nColspan=4;
		
		sbTable.append("<table width='100%' align='center'  border=\"0\" cellspacing =\"1px\" >"+"<tr>");
		sbTable.append("<tr>"+	"<td class=\"TITLE\" colspan=\"4\"  >Issued Drug Details</td>" + "</tr>");
		sbTable.append("</table>");
		
		/*
		 * Header Row:
		 */

		sbHeader.append("<table width='100%' border=\"0\" cellspacing =\"1px\" >"+"<tr>");
		
		
		sbHeader.append("<td width=\""	+ "10"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">S. No. </td>");
		sbHeader.append("<td width=\""	+ "35"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Generic Name</td>");
		sbHeader.append("<td width=\""	+ "35"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Drug Name</td>");
		sbHeader.append("<td width=\""	+ "20"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Issued Qty</td>");
		sbHeader.append("</tr>");

		if (wrsData_p != null && wrsData_p.size() > 0) {		
			/* Result Index */
				//  GENERIC_ITEM_NAME
				//  ITEM_NAME
				//  ISSUE_QTY
				//	SDF_FLAG(For Spl Drugs)
				
			
		int slNo=0,index=0;
			
			while (wrsData_p.next()) {

				slNo++;
				
				String strGenericItemName = wrsData_p.getString("GENERIC_ITEM_NAME");
				String strItemDate = wrsData_p.getString("ITEM_NAME");
				String strIssueQty = wrsData_p.getString("ISSUE_QTY");
				String strSdfFlag = wrsData_p.getString("SDF_FLAG"); // Returns Yes/No 
				
             			
				
				if (strGenericItemName == null) {
					strGenericItemName = "---";
				}
				if (strItemDate == null) {
					strItemDate = "---";
				}
				if (strIssueQty == null) {
					strIssueQty = "---";
				}
				if(strSdfFlag == null) {
				   strSdfFlag = "No";
				}
			
				
				
				
				/*
				 * Table Body
				 */

				sbBody.append("<tr>");
						
				sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\" name='tdId' id='tdId1"+index+"' >" + slNo + "</td>");
				sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\" name='tdId' id='tdId2"+index+"'>" + strGenericItemName + "</td>");
				sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\" name='tdId' id='tdId3"+index+"'>" + strItemDate + "</td>");
				sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\" name='tdId' id='tdId4"+index+"'>" + strIssueQty + "</td>");
				
				sbBody.append("<input type='hidden' name ='strSDFFlag' value='"+ strSdfFlag + "'>");
				
				
				sbBody.append("</tr>");
				
				index++;
			}
			sbBody.append("</table>");

		} 
		else 
		{
			sbBody.append("<tr>");
			sbBody.append("<td colspan=\""	+ nColspan	+ "\" class=\"CONTROL\" style=\"text-align: center; color: red;\">No Data Found!</td>");
			sbBody.append("</tr></table>");
		}

		return sbTable.toString() + sbHeader.toString() + sbBody.toString();
	}

	public static void getEpisodeVisitPopup(
			DrugDistributionMonitoringDetailTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
		
		DrugDistributionMonitoringDetailTransBO bo = null;
		DrugDistributionMonitoringDetailTransVO voObj = null;
		String strmsgText = null;
		String strEpisodeVisitCmb="";
		HisUtil hisutil = null;
		try {

			hisutil = new HisUtil("MMS","ItemLocationTransDATA");
			bo = new DrugDistributionMonitoringDetailTransBO();
			voObj = new DrugDistributionMonitoringDetailTransVO();
			
			String strVisitNo = request.getParameter("strEpisodeCode");
			
			if (strVisitNo == null)
				strVisitNo = "0";
			
			voObj.setStrCrNum(formBean.getStrCrNo()==null|| formBean.getStrCrNo().equals("")?"0":formBean.getStrCrNo());
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			//voObj.setStrEpisodeCode(strEpisodeCode);
			voObj.setStrDeptUnitCode(formBean.getStrUnitCode());
			
			formBean.setStrVisitNo(strVisitNo);
			/*//System.out.println("strCrNo"+strCrNo);
			//System.out.println("formBean.getStrHospitalCode()"+formBean.getStrHospitalCode());
			//System.out.println("strEpisodeCode"+strEpisodeCode);*/
						
			bo.getEpisodeVisitCmb(voObj);

			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());

			}
			
			if(voObj.getWrsEpisodeVisit()!=null && voObj.getWrsEpisodeVisit().size() > 0){			
				strEpisodeVisitCmb = hisutil.getOptionValue(voObj.getWrsEpisodeVisit(),
						strVisitNo, "", true);
			}else {
				strEpisodeVisitCmb = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrVisitValues(strEpisodeVisitCmb);
			
			//response.setHeader("Cache-Control", "no-cache");
			//response.getWriter().print(strEpisodeVisitCmb);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.DrugDistributionMonitoringDetailTransDATA.getEpisodeVisitCmb --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugDistributionMonitoringDetailTransDATA->getEpisodeVisitCmb()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (hisutil != null)
				hisutil = null;
		}
		
	}

}	
	