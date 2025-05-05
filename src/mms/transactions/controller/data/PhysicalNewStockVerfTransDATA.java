package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.vo.InvoiceDetailRptVO;
import mms.transactions.bo.PhysicalNewStockVerfTransBO;
import mms.transactions.controller.fb.PhysicalNewStockVerfTransFB;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.controller.hlp.PhysicalNewStockVerfTransHLP;
import mms.transactions.vo.PhysicalNewStockVerfTransVO;

public class PhysicalNewStockVerfTransDATA {

	/**
	 * 
	 * @param _PhysicalNewStockVerfTransFB 
	 * @param request the request
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void GetData(PhysicalNewStockVerfTransFB fb, HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		/* Declaring Variable */
		PhysicalNewStockVerfTransBO bo = null;
		PhysicalNewStockVerfTransVO vo = null;
		String hosCode = "";		
		String seatId = "";
		String strPhyStockRequestDtls = "", strmsgText="";
		HisUtil hisutil = null;
		HisUtil util = null;
		String strItemVal=null;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		try
		{
		
			bo = new PhysicalNewStockVerfTransBO();
			vo = new PhysicalNewStockVerfTransVO();
			
			hisutil = new HisUtil("MMSModule", "PhysicalNewStockVerfTransDATA");
			strCurrentDate = hisutil.getASDate("dd-MM-yyyy");
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId = request.getSession().getAttribute("SEATID").toString();
			
			strCurrentMonth = Integer.parseInt(strCurrentDate.split("\\-")[1]);
			
			if (strCurrentMonth >= 4) {
				CURRENT_YEAR = Integer.parseInt(strCurrentDate.split("\\-")[2]);
			} else {
				CURRENT_YEAR = Integer.parseInt(strCurrentDate.split("\\-")[2]) - 1;
			}
            String strCurrFY = CURRENT_YEAR + "-" + (CURRENT_YEAR + 1);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			//System.out.println("vo.getStrCatcode()"+fb.getStrCatcode());
			//System.out.println("vo.getStrCatcode().equalsIgnoreCase(null)"+fb.getStrCatcode()!="null");
			if(fb.getStrCatcode()!="null")
			vo.setStrCatcode("0");
			else
				vo.setStrCatcode(fb.getStrCatcode());
			bo.GetData(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}				
			if(vo.getStrPhyDetails().split("\\^").length > 4 && vo.getStrPhyDetails().split("\\^")[4].equals("1"))
			{    
				strPhyStockRequestDtls = PhysicalNewStockVerfTransHLP.getPrevPhyStockDtls(vo.getPrevPhyStockReqHlpWS(),request);
				fb.setStrPhyStockRequestDtls(strPhyStockRequestDtls);
			}			
			fb.setStrPhyDetails(vo.getStrPhyDetails());
			fb.setStrStoreName(vo.getStrStoreName());
			


			
			
			
			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrStoreId(vo.getStrStoreId());
			vo.setStrMode("2");
			bo.getItemCateg(vo);
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{				
				util = new HisUtil("MMS","IssueDetailRptData");
				strItemVal=util.getOptionValue(vo.getItemCategWS(), "0","0^Select Value", false);
				fb.setStrCatName(strItemVal);		    	
			}	
			
			
			
			
			
			
			fb.setStrHospitalCode(hosCode);
			fb.setStrSeatId(seatId);

			fb.setStrCurrentDate(hisutil.getASDate("dd-MMM-yyyy"));
			fb.setStrCurrFY(strCurrFY);
			

		} catch (Exception e) {			
			e.printStackTrace();
			strmsgText = "PhysicalNewStockVerfTransDATA.GetData(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS", "PhysicalNewStockVerfTransDATA->GetData()", strmsgText);
			fb.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;			
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	/**
	 * GRPNAMECOMBO(request,response,formBean) -- > This Method generate the Ajax Response for Group Name Combo on the basis of Store Id.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void NEWDRUGDTLS(HttpServletRequest request, HttpServletResponse response, PhysicalNewStockVerfTransFB formBean) throws IOException, ServletException {
		/* Declaring Variables */
		
		String strRes = null, strmsgText="";
		PhysicalNewStockVerfTransVO vo = null;
		PhysicalNewStockVerfTransBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate;
		try 
		{
			vo = new PhysicalNewStockVerfTransVO();
			bo = new PhysicalNewStockVerfTransBO();
			hisutil = new HisUtil("transaction", "PhysicalNewStockVerfTransDATA");	
			strCurrentDate = hisutil.getASDate("dd-MMM-yyyy");			
			vo.setStrCurrentDate(strCurrentDate);
			vo.setStrStoreId(request.getParameter("storeId"));
			//System.out.println("storeId"+request.getParameter("storeId"));
			vo.setStrItemCatNo(request.getParameter("catId"));
			//System.out.println("request.getParameter(catno)"+request.getParameter("catId"));
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			/* Call BO TariffCombo Method */
			bo.NEWDRUGDTLS(vo);
			/* Group Id for Item Search Combo */
			if (vo.getStrGroupIdForItemSearch() != null) 
			{
				response.setContentType("text/html;charset=UTF-8");
				response.setHeader("Cache-Control", "no-cache");
				strRes = PhysicalNewStockVerfTransHLP.getAddNewDrugHlp(vo,request);
				response.getWriter().print(strRes);

			} 
			else 
			{
				HisException eObj = new HisException("eAushadhi", "PhysicalNewStockVerfTransDATA->NEWDRUGDTLS()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			strmsgText = "PhysicalNewStockVerfTransDATA.NEWDRUGDTLS(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS", "PhysicalNewStockVerfTransDATA->NEWDRUGDTLS()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;		
			
		} finally {
			if (vo != null) {
				vo = null;
			}
			if (hisutil != null) {
				hisutil = null;
			}
			if (bo != null) {
				bo = null;
			}
		}

	}
	
	/**
	 * GRPNAMECOMBO(request,response,formBean) -- > This Method generate the Ajax Response for Group Name Combo on the basis of Store Id.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void REQUESTDETAILS(HttpServletRequest request, HttpServletResponse response, PhysicalNewStockVerfTransFB formBean) throws IOException, ServletException {
		/* Declaring Variables */
		
		String strRes = null;
		PhysicalNewStockVerfTransVO vo = null;
		PhysicalNewStockVerfTransBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate, strmsgText="";
		try 
		{
			vo = new PhysicalNewStockVerfTransVO();
			bo = new PhysicalNewStockVerfTransBO();
			hisutil = new HisUtil("transaction", "PhysicalNewStockVerfTransDATA");	
			strCurrentDate = hisutil.getASDate("dd-MM-yyyy");
			vo.setStrCurrentDate(strCurrentDate);
			/* 1.HSTNUM_STORE_ID 2.HSTNUM_LSTPHYSTOCK_DATE 3.PHY_TOLRENCE_LIMIT 4.Finacial Year 5.HSTNUM_PHYSTOCK_FLAG */			
			vo.setStrStoreId(request.getParameter("storeId").split("\\^")[0]);
			vo.setStrTolranceLimit(request.getParameter("storeId").split("\\^")[2]);
			vo.setStrPhyStockFlag(request.getParameter("storeId").split("\\^")[4]);
			vo.setStrPhysicalStockNo("0");
			vo.setStrItemCatNo("10");
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrMode("2");
			//System.out.println("formBean.getStrCatcode()"+request.getParameter("catId"));
			String itemcatcode=(String)request.getParameter("catId");
			vo.setStrCatcode(itemcatcode);
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			/* Call BO TariffCombo Method */
			bo.CombineProc(vo); // PKG_MMS_VIEW.proc_phystock_detail [Mode =3]
			/* Group Id for Item Search Combo */
			if(vo.getUnitlityProcWS().size()>0)
			{
				response.setContentType("text/html;charset=UTF-8");
				response.setHeader("Cache-Control", "no-cache");
				strRes = PhysicalNewStockVerfTransHLP.getPrevPhyStockDtls(vo.getUnitlityProcWS(),request);
				response.getWriter().print(strRes);
			}	
			else 
			{
				//HisException eObj = new HisException("eAushadhi", "PhysicalNewStockVerfTransDATA->GETGROUPDRUG()", vo.getStrMsgString());
				String str = " Data not Found ";
				response.getWriter().print(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "PhysicalNewStockVerfTransDATA.GETGROUPDRUG(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS", "PhysicalNewStockVerfTransDATA->GETGROUPDRUG()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;				
		} finally {
			if (vo != null) {
				vo = null;
			}
			if (hisutil != null) {
				hisutil = null;
			}
			if (bo != null) {
				bo = null;
			}
		}


	}
	
	/**
	 * GRPNAMECOMBO(request,response,formBean) -- > This Method generate the Ajax Response for Group Name Combo on the basis of Store Id.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void VERIFIEDITEMHLP(HttpServletRequest request, HttpServletResponse response, PhysicalNewStockVerfTransFB formBean) throws IOException, ServletException {
		/* Declaring Variables */
		
		String strRes = null;
		PhysicalNewStockVerfTransVO vo = null;
		PhysicalNewStockVerfTransBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate, strmsgText="";
		try 
		{
			vo = new PhysicalNewStockVerfTransVO();
			bo = new PhysicalNewStockVerfTransBO();
			hisutil = new HisUtil("transaction", "PhysicalNewStockVerfTransDATA");	
			strCurrentDate = hisutil.getASDate("dd-MM-yyyy");
			vo.setStrCurrentDate(strCurrentDate);
			/* 1.HSTNUM_STORE_ID 2.HSTNUM_LSTPHYSTOCK_DATE 3.PHY_TOLRENCE_LIMIT 4.Finacial Year 5.HSTNUM_PHYSTOCK_FLAG */			
			vo.setStrStoreId(request.getParameter("storeId").split("\\^")[0]);
			vo.setStrTolranceLimit(request.getParameter("storeId").split("\\^")[2]);
			vo.setStrPhyStockFlag(request.getParameter("storeId").split("\\^")[4]);
			vo.setStrPhysicalStockNo("0");
			vo.setStrItemCatNo("10");
			vo.setStrCatcode(request.getParameter("catId"));
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrMode("3");
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			/* Call BO TariffCombo Method */
			bo.CombineProc(vo); // PKG_MMS_VIEW.proc_phystock_detail [Mode =3]
			/* Group Id for Item Search Combo */
			if (vo.getUnitlityProcWS()!= null) 
			{
				response.setContentType("text/html;charset=UTF-8");
				response.setHeader("Cache-Control", "no-cache");
				strRes = PhysicalNewStockVerfTransHLP.getPhyStockVerifiedItemDtls(vo.getUnitlityProcWS(),"1",request.getParameter("storeId"),request);
				response.getWriter().print(strRes);

			} 
			else 
			{
				HisException eObj = new HisException("eAushadhi", "PhysicalNewStockVerfTransDATA->GETGROUPDRUG()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "PhysicalNewStockVerfTransDATA.VERIFIEDITEMHLP(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS", "PhysicalNewStockVerfTransDATA->VERIFIEDITEMHLP()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null) {
				vo = null;
			}
			if (hisutil != null) {
				hisutil = null;
			}
			if (bo != null) {
				bo = null;
			}
		}


	}
	
	/**
	 * GRPNAMECOMBO(request,response,formBean) -- > This Method generate the Ajax Response for Group Name Combo on the basis of Store Id.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void GETGROUPDRUG(HttpServletRequest request, HttpServletResponse response, PhysicalNewStockVerfTransFB formBean) throws IOException, ServletException {
		/* Declaring Variables */
		
		String strRes = null;
		PhysicalNewStockVerfTransVO vo = null;
		PhysicalNewStockVerfTransBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate, strmsgText="";
		try 
		{
			vo = new PhysicalNewStockVerfTransVO();
			bo = new PhysicalNewStockVerfTransBO();
			hisutil = new HisUtil("transaction", "PhysicalNewStockVerfTransDATA");	
			strCurrentDate = hisutil.getASDate("dd-MM-yyyy");
			vo.setStrCurrentDate(strCurrentDate);
			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrGroupId(request.getParameter("strGroupId"));
			vo.setStrItemCatNo(request.getParameter("itemCatNo"));
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			/* Call BO TariffCombo Method */
			bo.getGroupDrug(vo); // pkg_mms_view.proc_item_detail [Mode =1]
			/* Group Id for Item Search Combo */
			if (vo.getStrGroupIdForItemSearch() != null) 
			{
				response.setContentType("text/html;charset=UTF-8");
				response.setHeader("Cache-Control", "no-cache");
				strRes = vo.getStrDrugNameCombo();
				response.getWriter().print(strRes);

			} 
			else 
			{
				HisException eObj = new HisException("eAushadhi", "PhysicalNewStockVerfTransDATA->GETGROUPDRUG()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "PhysicalNewStockVerfTransDATA.GETGROUPDRUG(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS", "PhysicalNewStockVerfTransDATA->GETGROUPDRUG()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null) {
				vo = null;
			}
			if (hisutil != null) {
				hisutil = null;
			}
			if (bo != null) {
				bo = null;
			}
		}

	}
	
	/**
	 * GRPNAMECOMBO(request,response,formBean) -- > This Method generate the Ajax Response for Group Name Combo on the basis of Store Id.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void UPDATERECORD(HttpServletRequest request, HttpServletResponse response, PhysicalNewStockVerfTransFB formBean) throws IOException, ServletException {
		/* Declaring Variables */
		
		String strRes = null;
		PhysicalNewStockVerfTransVO vo = null;
		PhysicalNewStockVerfTransBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate, strmsgText="";
		try 
		{
			vo = new PhysicalNewStockVerfTransVO();
			bo = new PhysicalNewStockVerfTransBO();
			hisutil = new HisUtil("transaction", "PhysicalNewStockVerfTransDATA");	
			strCurrentDate = hisutil.getASDate("dd-MM-yyyy");
			vo.setStrCurrentDate(strCurrentDate);
			/* 1.HSTNUM_STORE_ID 2.HSTNUM_LSTPHYSTOCK_DATE 3.PHY_TOLRENCE_LIMIT 4.Finacial Year 5.HSTNUM_PHYSTOCK_FLAG */			
			vo.setStrStoreId(request.getParameter("storeId").split("\\^")[0]);
			vo.setStrTolranceLimit(request.getParameter("storeId").split("\\^")[2]);
			vo.setStrPhyStockFlag(request.getParameter("storeId").split("\\^")[4]);
			/* 1.HSTNUM_PHYSTOCK_NO 2.REQ_DATE 3.STATUS  4.HSTNUM_STATUS 5.MODIFY_CANCEL_FLAG */	
			vo.setStrPhysicalStockNo(request.getParameter("reqDtl").split("\\$")[0]);
			vo.setStrItemCatNo("10");
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrMode("4");
			//System.out.println("vo.getStrCatcode()"+request.getParameter("catId"));
			vo.setStrCatcode(request.getParameter("catId"));
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			/* Call BO TariffCombo Method */
			bo.CombineProc(vo); // PKG_MMS_VIEW.proc_phystock_detail [Mode =4]
			/* Group Id for Item Search Combo */
			if (vo.getUnitlityProcWS()!= null) 
			{
				response.setContentType("text/html;charset=UTF-8");
				response.setHeader("Cache-Control", "no-cache");
				strRes = PhysicalNewStockVerfTransHLP.getPhyStockVerifiedItemDtls(vo.getUnitlityProcWS(),"2",request.getParameter("storeId"),request);
				
				response.getWriter().print(strRes);

			} 
			else 
			{
				HisException eObj = new HisException("eAushadhi", "PhysicalNewStockVerfTransDATA->GETGROUPDRUG()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "PhysicalNewStockVerfTransDATA.UPDATERECORD(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS", "PhysicalNewStockVerfTransDATA->UPDATERECORD()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null) {
				vo = null;
			}
			if (hisutil != null) {
				hisutil = null;
			}
			if (bo != null) {
				bo = null;
			}
		}

	}
	
	/**
	 * GRPNAMECOMBO(request,response,formBean) -- > This Method generate the Ajax Response for Group Name Combo on the basis of Store Id.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void CANCELRECORD(HttpServletRequest request, HttpServletResponse response, PhysicalNewStockVerfTransFB formBean) throws IOException, ServletException {
		/* Declaring Variables */
		
		String strRes = null;
		PhysicalNewStockVerfTransVO vo = null;
		PhysicalNewStockVerfTransBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate, strmsgText="";
		try 
		{
			vo = new PhysicalNewStockVerfTransVO();
			bo = new PhysicalNewStockVerfTransBO();
			hisutil = new HisUtil("transaction", "PhysicalNewStockVerfTransDATA");	
			strCurrentDate = hisutil.getASDate("dd-MM-yyyy");
			vo.setStrCurrentDate(strCurrentDate);
			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrGroupId(request.getParameter("strGroupId"));
			vo.setStrItemCatNo("10");
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			/* Call BO TariffCombo Method */
			bo.getGroupDrug(vo); // pkg_mms_view.proc_item_detail [Mode =1]
			/* Group Id for Item Search Combo */
			if (vo.getStrGroupIdForItemSearch() != null) 
			{
				response.setContentType("text/html;charset=UTF-8");
				response.setHeader("Cache-Control", "no-cache");
				strRes = vo.getStrDrugNameCombo();
				response.getWriter().print(strRes);

			} 
			else 
			{
				HisException eObj = new HisException("eAushadhi", "PhysicalNewStockVerfTransDATA->GETGROUPDRUG()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "PhysicalNewStockVerfTransDATA.CANCELRECORD(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS", "PhysicalNewStockVerfTransDATA->CANCELRECORD()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null) {
				vo = null;
			}
			if (hisutil != null) {
				hisutil = null;
			}
			if (bo != null) {
				bo = null;
			}
		}

	}
	
	
	

	/**
	 * GRPNAMECOMBO(request,response,formBean) -- > This Method generate the Ajax Response for Group Name Combo on the basis of Store Id.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void STOCKUPDATE(HttpServletRequest request, HttpServletResponse response, PhysicalNewStockVerfTransFB formBean) throws IOException, ServletException {
		/* Declaring Variables */
		
		String strRes = null;
		PhysicalNewStockVerfTransVO vo = null;
		PhysicalNewStockVerfTransBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate, strmsgText="";
		try 
		{
			vo = new PhysicalNewStockVerfTransVO();
			bo = new PhysicalNewStockVerfTransBO();
			hisutil = new HisUtil("transaction", "PhysicalNewStockVerfTransDATA");	
			strCurrentDate = hisutil.getASDate("dd-MM-yyyy");
			vo.setStrCurrentDate(strCurrentDate);
			/* 1.HSTNUM_STORE_ID 2.HSTNUM_LSTPHYSTOCK_DATE 3.PHY_TOLRENCE_LIMIT 4.Finacial Year 5.HSTNUM_PHYSTOCK_FLAG */			
			vo.setStrStoreId(request.getParameter("storeId").split("\\^")[0]);
			vo.setStrTolranceLimit(request.getParameter("storeId").split("\\^")[2]);
			vo.setStrPhyStockFlag(request.getParameter("storeId").split("\\^")[4]);
			/* 1.HSTNUM_PHYSTOCK_NO 2.REQ_DATE 3.STATUS  4.HSTNUM_STATUS 5.MODIFY_CANCEL_FLAG */	
			vo.setStrPhysicalStockNo(request.getParameter("reqDtl").split("\\$")[0]);
			vo.setStrItemCatNo("10");
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrMode("4");
			//System.out.println("request.getParametercat code"+request.getParameter("catId"));
			vo.setStrCatcode(request.getParameter("catId"));
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			/* Call BO TariffCombo Method */
			bo.CombineProc(vo); // PKG_MMS_VIEW.proc_phystock_detail [Mode =4]
			/* Group Id for Item Search Combo */
			if (vo.getUnitlityProcWS()!= null) 
			{
				response.setContentType("text/html;charset=UTF-8");
				response.setHeader("Cache-Control", "no-cache");
				strRes = PhysicalNewStockVerfTransHLP.getPhyStkVerfItemDtlsForSaveView(vo.getUnitlityProcWS(),"2",request.getParameter("storeId"),request);
				
				response.getWriter().print(strRes);

			} 
			else 
			{
				HisException eObj = new HisException("eAushadhi", "PhysicalNewStockVerfTransDATA->GETGROUPDRUG()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "PhysicalNewStockVerfTransDATA.STOCKUPDATE(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS", "PhysicalNewStockVerfTransDATA->STOCKUPDATE()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null) {
				vo = null;
			}
			if (hisutil != null) {
				hisutil = null;
			}
			if (bo != null) {
				bo = null;
			}
		}
	}

	

	/**
	 * Method is Used to Insert Data in DataBase Table HSTT_BREAKAGE_DTL & HSTT_BREAKAGE_ITEM_DTL Breakage Item Detail Transaction.
	 * 
	 * @param fb the _ breakage item dtl trans fb
	 * @param request the request
	 * @throws ServletException 
	 * @throws IOException 
	 */

	public static void TOBEVERIFY(PhysicalNewStockVerfTransFB fb, HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		/* Declaring Variable */
		PhysicalNewStockVerfTransBO bo = null;
		PhysicalNewStockVerfTransVO vo = null;
			
		String hosCode = "";
		String seatid = "", strmsgText="";
		try {
			/* Creating Object */
			bo = new PhysicalNewStockVerfTransBO();
			vo = new PhysicalNewStockVerfTransVO();

			
			
			vo =(PhysicalNewStockVerfTransVO) TransferObjectFactory.populateData("mms.transactions.vo.PhysicalNewStockVerfTransVO",fb);
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			//System.out.println("fb.getStrHiddenValue()"+fb.getStrHiddenValue());
			vo.setStrHiddenValue(fb.getStrHiddenValue());
			// CALLING BO
			if(vo.getStrVerifiedPageFlg().equals("1"))
			{
			   bo.TOBEVERIFY(vo); // PKG_MMS_DML.dml_challan_qty_modify_dtl[ Mode = 3,2,1 ]
			}			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			else 
			{
				if (vo.getStrMsgType().equals("1")) 
				{
					if (vo.getStrMsgString().contains("##")) 
					{
						if (vo.getStrMsgString().split("\\##")[2].equals("998")) 
						{
							fb.setStrErr(vo.getStrMsgString().split("\\##")[1]);
						}
					} 
					else 
					{
						fb.setStrErr(vo.getStrMsgString());
						throw new Exception(vo.getStrMsgString());
					}
				} 
				else 
				{					
					fb.setStrStoreId(vo.getStrStoreName());
					fb.setStrMsgSaved("To Be Verify Physical Stock No Request No [ "+vo.getStrPhyStockNo()+" ] for Store ["+vo.getStrStoreNameText()+"] ,Generated Successfully");
			    }
			}

			
			

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "PhysicalNewStockVerfTransDATA.TOBEVERIFY(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS", "PhysicalNewStockVerfTransDATA->TOBEVERIFY()", strmsgText);
			fb.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			
			vo = null;
		}

	}
	
	/**
	 * Method is Used to Insert Data in DataBase Table HSTT_BREAKAGE_DTL & HSTT_BREAKAGE_ITEM_DTL Breakage Item Detail Transaction.
	 * 
	 * @param fb the _ breakage item dtl trans fb
	 * @param request the request
	 * @throws ServletException 
	 * @throws IOException 
	 */

	public static void MODIFY(PhysicalNewStockVerfTransFB fb, HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		/* Declaring Variable */
		PhysicalNewStockVerfTransBO bo = null;
		PhysicalNewStockVerfTransVO vo = null;
			
		String hosCode = "";
		String seatid = "", strmsgText="";
		try {
			/* Creating Object */
			bo = new PhysicalNewStockVerfTransBO();
			vo = new PhysicalNewStockVerfTransVO();

			
			
			vo =(PhysicalNewStockVerfTransVO) TransferObjectFactory.populateData("mms.transactions.vo.PhysicalNewStockVerfTransVO",fb);
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrCatcode(fb.getStrCategorycode());
			// CALLING BO			
			bo.MODIFY(vo); // PKG_MMS_DML.dml_challan_qty_modify_dtl[ Mode = 3,2,1 ]
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			else 
			{
				if (vo.getStrMsgType().equals("1")) 
				{
					if (vo.getStrMsgString().contains("##")) 
					{
						if (vo.getStrMsgString().split("\\##")[2].equals("998")) 
						{
							fb.setStrErr(vo.getStrMsgString().split("\\##")[1]);
						}
					} 
					else 
					{
						fb.setStrErr(vo.getStrMsgString());
						throw new Exception(vo.getStrMsgString());
					}
				} 
				else 
				{
					
					fb.setStrStoreId(vo.getStrStoreName());
					fb.setStrMsgSaved("Physical Stock Request No [ "+vo.getStrPhyStockNo()+" ] for Store ["+vo.getStrStoreNameText()+"], Modify Successfully");
			     }
			}

			
			

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "PhysicalNewStockVerfTransDATA.MODIFY(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS", "PhysicalNewStockVerfTransDATA->MODIFY()", strmsgText);
			fb.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;			
			vo = null;
		}

	}
	
	/**
	 * Method is Used to Insert Data in DataBase Table HSTT_BREAKAGE_DTL & HSTT_BREAKAGE_ITEM_DTL Breakage Item Detail Transaction.
	 * 
	 * @param fb the _ breakage item dtl trans fb
	 * @param request the request
	 * @throws ServletException 
	 * @throws IOException 
	 */

	public static void STOCKUPDATECANCEL(PhysicalNewStockVerfTransFB fb, HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		/* Declaring Variable */
		PhysicalNewStockVerfTransBO bo = null;
		PhysicalNewStockVerfTransVO vo = null;
			
		String hosCode = "";
		String seatid = "", strmsgText="";
		try {
			/* Creating Object */
			bo = new PhysicalNewStockVerfTransBO();
			vo = new PhysicalNewStockVerfTransVO();

			
			
			vo =(PhysicalNewStockVerfTransVO) TransferObjectFactory.populateData("mms.transactions.vo.PhysicalNewStockVerfTransVO",fb);
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			
			// CALLING BO			
			bo.STOCKUPDATECANCEL(vo); // PKG_MMS_DML.dml_challan_qty_modify_dtl[ Mode = 3,2,1 ]
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			else 
			{
				if (vo.getStrMsgType().equals("1")) 
				{
					if (vo.getStrMsgString().contains("##")) 
					{
						if (vo.getStrMsgString().split("\\##")[2].equals("998")) 
						{
							fb.setStrErr(vo.getStrMsgString().split("\\##")[1]);
						}
					} 
					else 
					{
						fb.setStrErr(vo.getStrMsgString());
						throw new Exception(vo.getStrMsgString());
					}
				} 
				else 
				{					
					fb.setStrStoreId(vo.getStrStoreName());
					fb.setStrMsgSaved("Physical Stock Request No [ "+vo.getStrPhyStockNo()+" ] for Store ["+vo.getStrStoreNameText()+"] Modify Successfully");
			     }
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "PhysicalNewStockVerfTransDATA.STOCKUPDATECANCEL(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS", "PhysicalNewStockVerfTransDATA->STOCKUPDATECANCEL()", strmsgText);
			fb.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			
			vo = null;
		}

	}

	public static void DELETEITEM(HttpServletRequest request, HttpServletResponse response, PhysicalNewStockVerfTransFB formBean) throws IOException, ServletException {
		/* Declaring Variables */
		
		String strRes = null;
		PhysicalNewStockVerfTransVO vo = null;
		PhysicalNewStockVerfTransBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate, strmsgText="";
		try 
		{
			vo = new PhysicalNewStockVerfTransVO();
			bo = new PhysicalNewStockVerfTransBO();
			hisutil = new HisUtil("transaction", "PhysicalNewStockVerfTransDATA");	
			strCurrentDate = hisutil.getASDate("dd-MM-yyyy");
			vo.setStrCurrentDate(strCurrentDate);
			/* 1.HSTNUM_STORE_ID 2.HSTNUM_LSTPHYSTOCK_DATE 3.PHY_TOLRENCE_LIMIT 4.Finacial Year 5.HSTNUM_PHYSTOCK_FLAG */			
			vo.setStrStoreId(request.getParameter("storeId").split("\\^")[0]);
			vo.setStrStoreName(request.getParameter("storeId"));
			vo.setStrTolranceLimit(request.getParameter("storeId").split("\\^")[2]);
			vo.setStrPhyStockFlag(request.getParameter("storeId").split("\\^")[4]);
			/* 1.HSTNUM_PHYSTOCK_NO 2.REQ_DATE 3.STATUS  4.HSTNUM_STATUS 5.MODIFY_CANCEL_FLAG */
			vo.setStrCatcode(request.getParameter("catId"));
			vo.setStrPhysicalStockNo(request.getParameter("reqDtl").split("\\$")[0]);
			vo.setStrPKey(request.getParameter("pKey"));						
			vo.setStrItemCatNo("10");
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrMode("4");
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			/* Call BO TariffCombo Method */
			bo.DeleteRecord(vo); // PKG_MMS_VIEW.proc_phystock_detail [Mode =4]
		
			
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}			 
			else 
			{
				response.setContentType("text/html;charset=UTF-8");
				response.setHeader("Cache-Control", "no-cache");
				strRes = "Drug Successfully Deleted $$"+request.getParameter("index");				
				response.getWriter().print(strRes);
			}
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "PhysicalNewStockVerfTransDATA.DELETEITEM(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS", "PhysicalNewStockVerfTransDATA->DELETEITEM()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null) {
				vo = null;
			}
			if (hisutil != null) {
				hisutil = null;
			}
			if (bo != null) {
				bo = null;
			}
		}
	}
	
	public static void viewData(PhysicalNewStockVerfTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PhysicalNewStockVerfTransBO bo = null;
		PhysicalNewStockVerfTransVO vo = null;
		String str1 = "";
		String str2 = "";
		String str3 = "", strmsgText="";
		
		try 
		{
			bo = new PhysicalNewStockVerfTransBO();
			vo = new PhysicalNewStockVerfTransVO();
			
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);

			String strChk = formBean.getStrChk();
  	 /* PK->>    Level Type     --0 
		       @ Store Id       --1
		       @ To Store Id    --2
		       @ Catg           --3 
		       @ Req No         --4
		       @ Req Type       --5
		       @ Req Status     --6
		       @ User Id        --7
		       @ User Level     --8
		       @ c.app_flag     --9
		       @ c.re_app_flag  --10
		       @ c.approval_no  --11*/
			String[] temp = strChk.split("\\@");
			String strLevelType 	= temp[0];
			String strStoreId 		= temp[1];
			String strToStoreId 	= temp[2];
			String strItemCatg 		= temp[3];
			String strReqNo 		= temp[4];
			String strReqTypeId 	= temp[5];
			String strReqStatus 	= temp[6];
			String strUserId 		= temp[7];
			String strUserLevel 	= temp[8];

			vo.setStrReqStatus(strReqStatus);
			vo.setStrUserLevel(strUserLevel);
			vo.setStrUserId(strUserId);
			vo.setStrLevelType(strLevelType);
			vo.setStrReqNo(strReqNo);
			vo.setStrPhysicalStockNo(strReqNo);
			vo.setStrReqTypeId(strReqTypeId);
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCatgNo(strItemCatg);
			vo.setStrToStoreId(strToStoreId);
			formBean.setStrLevelType(strLevelType);
			
            vo.setStrMode("4");
			bo.viewData(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}		
			
			str1 = PhysicalNewStockVerfTransHLP.physicalApprovalHLP(vo.getUnitlityProcWS(),"1",vo.getStrTolranceLimit());	
				
			//str2 = ApprovalDtlHLP.getApprovalDtlNew(vo.getStrStoreId(), vo.getStrHospitalCode(), temp[6].split("\\$")[0], vo.getStrReqNo(),request);
			
			formBean.setStrSetApprovedDetails(str2);

			str3 = PhysicalNewStockVerfTransHLP.getIndentDetails(vo,request);	
			
			formBean.setStrDiscItemDetails(str1.split("\\@")[0]);
			formBean.setStrNonDiscItemDetails(str1.split("\\@")[1]);
			formBean.setStrIndentDetails(str3);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "PhysicalNewStockVerfTransDATA.viewData(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS", "PhysicalNewStockVerfTransDATA->viewData()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;			
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	public static boolean insertForApproval(PhysicalNewStockVerfTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PhysicalNewStockVerfTransBO bo = null;
		PhysicalNewStockVerfTransVO vo = null;
		String strmsgText="";
		
		boolean retValue = true;
		try 
		{
			bo = new PhysicalNewStockVerfTransBO();
			vo = new PhysicalNewStockVerfTransVO();
			
			vo =(PhysicalNewStockVerfTransVO) TransferObjectFactory.populateData("mms.transactions.vo.PhysicalNewStockVerfTransVO",formBean);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			String strChk = formBean.getStrChk();
	 	 /* PK->>    Level Type     --0 
			       @ Store Id       --1
			       @ To Store Id    --2
			       @ Catg           --3 
			       @ Req No         --4
			       @ Req Type       --5
			       @ Req Status     --6
			       @ User Id        --7
			       @ User Level     --8
			       @ c.app_flag     --9
			       @ c.re_app_flag  --10
			       @ c.approval_no  --11
			       @ c.Request Date --12 */
			String[] temp = strChk.split("\\@");
			String strLevelType = temp[0];
			String strStoreId = temp[1];
			String strToStoreId = temp[2];
			String strItemCatg = temp[3];
			String strReqNo = temp[4];
			String strReqTypeId = temp[5];
			String strReqStatus = temp[6];
			String strUserId = temp[7];
			String strUserLevel = temp[8];
			String[] temp1 = temp[12].split("\\$");
			vo.setStrRequestDate(temp1[0]);
			
			vo.setStrApprovalNo(temp[11]);
			
			vo.setStrIPAdd(request.getSession().getAttribute("IP_ADDR").toString());
			vo.setStrReqStatus(strReqStatus);
			vo.setStrUserLevel(strUserLevel);
			vo.setStrUserId(strUserId);
			vo.setStrLevelType(strLevelType);
			vo.setStrReqNo(strReqNo);
			vo.setStrPhysicalStockNo(strReqNo);
			vo.setStrReqTypeId(strReqTypeId);
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCatgNo(strItemCatg);
			vo.setStrToStoreId(strToStoreId);
			formBean.setStrLevelType(strLevelType);			
           
			bo.insertForApproval(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}		
			else
			{   String strStatus ="";
				if(vo.getStrReApprovalFlag().equals("0"))
				{	
					strStatus  = "Approved";				    
				}
				else
				{
					strStatus = "Re-Approved";
				}
				formBean.setStrErrMsg("Physical Stock No [ "+strReqNo+"  " + strStatus+"]  Successfully");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "PhysicalNewStockVerfTransDATA.insertForApproval(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS", "PhysicalNewStockVerfTransDATA->insertForApproval()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;

	}
	public static void setItemCategComboDtl(PhysicalNewStockVerfTransFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		PhysicalNewStockVerfTransVO vo=null;
		PhysicalNewStockVerfTransBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strItemVal="";
		
		try 
		{
			bo = new PhysicalNewStockVerfTransBO();
			vo = new PhysicalNewStockVerfTransVO();
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrStoreId(request.getParameter("storeId"));
				//vo.setStrStoreId(request.getParameter("storeId"));
				//System.out.println("request."+request.getParameter("storeId"));
				//if(vo.getStrStoreId().equals("0"))
				//	vo.setStrMode("1");
				//else
						vo.setStrMode("2");
		
				bo.getItemCateg(vo);
				
				if(vo.getStrMsgType().equals("1"))
				{
					throw new Exception(vo.getStrMsgString());
				}
				else
				{				
					util = new HisUtil("MMS","IssueDetailRptData");
					strItemVal=util.getOptionValue(vo.getItemCategWS(), "0","0^Select Value", false);
					response.getWriter().print(strItemVal);			    	
				}	
		} 
		catch (Exception e) 
		{
				e.printStackTrace();
				strmsgText = "IssueDetailRptData.setItemCategComboDtl() --> "+ e.getMessage();
				HisException eObj = new HisException("IPD", "IssueDetailRptData->setItemCategComboDtl()", strmsgText);
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
	
	

}