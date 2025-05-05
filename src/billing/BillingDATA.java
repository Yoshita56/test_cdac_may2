package billing;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.UserVO;

public class BillingDATA {

	public static void initTariffChargeDetails(HttpServletRequest request, HttpServletResponse response,BillingFB formBean)
	{		
		try
		{		
			BillingVO voObj = new BillingVO();
			BillingBO bo = new BillingBO();
					
			formBean.setChargeTypeId(request.getParameter("chargeTypeId"));
			formBean.setCategoryCode(request.getParameter("categoryCode"));
			formBean.setWardCode(request.getParameter("wardCode"));
			//System.out.println("request.getParameter"+request.getParameter("wardCode"));
			formBean.setGroupId(request.getParameter("groupId"));
			formBean.setSearchText(request.getParameter("searchText"));
			formBean.setStrSearchType(request.getParameter("searchType"));
			formBean.setPkgflag(request.getParameter("pkgFlag"));
			voObj.setStrValue1(formBean.getChargeTypeId());
			voObj.setStrValue2(formBean.getCategoryCode());
			voObj.setStrValue3(formBean.getWardCode().replace("^", "#").split("#")[0]);
			voObj.setStrValue4(formBean.getGroupId());
			voObj.setStrValue5(formBean.getSearchText());
			voObj.setStrValue6(formBean.getHospitalCode());
			voObj.setStrValue7(formBean.getPkgflag());
			voObj.setStrValue8(formBean.getStrSearchType());
			
			bo.getChargeTariffDetails(voObj);
			
			if(voObj.getStrMsgType().equals("0"))
			{
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				if(formBean.getStrMode().equals("0"))
				{
					val = HLPbilling.getTariffChargeView(formBean.getStrResultWs());
				}
				else
				{
					val = HLPbilling.getTariffCodeChargeView(formBean.getStrResultWs());
				}
			
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
			}
			else
			{
				throw new Exception(voObj.getStrMsgString());
			}
		
		}
		catch(Exception e)
		{
	     	new HisException("Billing","hisglobal.BillingDATA.initTariffChargeDetails()-->",e.getMessage());
			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing", "IpdBillManagementTransDATA->initPatientDtl()", msgStr);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
		    eObj = null;
		}
	}
	
	public static void initTariffChargeDetails1(HttpServletRequest request, HttpServletResponse response,BillingFB formBean)
	{		
		try
		{		
			BillingVO voObj = new BillingVO();
			BillingBO bo = new BillingBO();
					
			formBean.setChargeTypeId(request.getParameter("chargeTypeId"));
			formBean.setCategoryCode(request.getParameter("categoryCode"));
			formBean.setWardCode(request.getParameter("wardCode"));
			formBean.setGroupId(request.getParameter("groupId"));
			formBean.setSearchText(request.getParameter("searchText"));
			formBean.setStrSearchType(request.getParameter("searchType"));
			formBean.setPkgflag(request.getParameter("pkgFlag"));
			voObj.setStrValue1(formBean.getChargeTypeId());
			voObj.setStrValue2(formBean.getCategoryCode());
			voObj.setStrValue3(formBean.getWardCode().replace("^", "#").split("#")[0]);
			voObj.setStrValue4(formBean.getGroupId());
			voObj.setStrValue5(formBean.getSearchText());
			voObj.setStrValue6(formBean.getHospitalCode());
			voObj.setStrValue7(formBean.getPkgflag());
			voObj.setStrValue8(formBean.getStrSearchType());
			
			bo.getChargeTariffDetails1(voObj);
			
			if(voObj.getStrMsgType().equals("0"))
			{
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				if(formBean.getStrMode().equals("0"))
				{
					val = HLPbilling.getTariffChargeView(formBean.getStrResultWs());
				}
				else
				{
					val = HLPbilling.getTariffCodeChargeView1(formBean.getStrResultWs());
				}
			
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
			}
			else
			{
				throw new Exception(voObj.getStrMsgString());
			}
		
		}
		catch(Exception e)
		{
	     	new HisException("Billing","hisglobal.BillingDATA.initTariffChargeDetails()-->",e.getMessage());
			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing", "IpdBillManagementTransDATA->initPatientDtl()", msgStr);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
		    eObj = null;
		}
	}
	public static void initTariffChargeDetails2(HttpServletRequest request, HttpServletResponse response,BillingFB formBean)
	{		
		try
		{		
			BillingVO voObj = new BillingVO();
			BillingBO bo = new BillingBO();
					
			formBean.setChargeTypeId(request.getParameter("chargeTypeId"));
			formBean.setCategoryCode(request.getParameter("categoryCode"));
			formBean.setWardCode(request.getParameter("wardCode"));
			formBean.setGroupId(request.getParameter("groupId"));
			formBean.setSearchText(request.getParameter("searchText"));
			formBean.setStrSearchType(request.getParameter("searchType"));
			formBean.setPkgflag(request.getParameter("pkgFlag"));
			voObj.setStrValue1(formBean.getChargeTypeId());
			voObj.setStrValue2(formBean.getCategoryCode());
			voObj.setStrValue3(formBean.getWardCode().replace("^", "#").split("#")[0]);
			voObj.setStrValue4(formBean.getGroupId());
			voObj.setStrValue5(formBean.getSearchText());
			voObj.setStrValue6(formBean.getHospitalCode());
			voObj.setStrValue7(formBean.getPkgflag());
			voObj.setStrValue8(formBean.getStrSearchType());
			
			bo.getChargeTariffDetails2(voObj);
			
			if(voObj.getStrMsgType().equals("0"))
			{
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				if(formBean.getStrMode().equals("0"))
				{
					val = HLPbilling.getTariffChargeView(formBean.getStrResultWs());
				}
				else
				{
					val = HLPbilling.getTariffCodeChargeView2(formBean.getStrResultWs());
				}
			
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
			}
			else
			{
				throw new Exception(voObj.getStrMsgString());
			}
		
		}
		catch(Exception e)
		{
	     	new HisException("Billing","hisglobal.BillingDATA.initTariffChargeDetails()-->",e.getMessage());
			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing", "IpdBillManagementTransDATA->initPatientDtl()", msgStr);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
		    eObj = null;
		}
	}
	public static void initTariffChargeDetails3(HttpServletRequest request, HttpServletResponse response,BillingFB formBean)
	{		
		try
		{		
			BillingVO voObj = new BillingVO();
			BillingBO bo = new BillingBO();
					
			formBean.setChargeTypeId(request.getParameter("chargeTypeId"));
			formBean.setCategoryCode(request.getParameter("categoryCode"));
			formBean.setWardCode(request.getParameter("wardCode"));
			formBean.setGroupId(request.getParameter("groupId"));
			formBean.setSearchText(request.getParameter("searchText"));
			formBean.setStrSearchType(request.getParameter("searchType"));
			formBean.setPkgflag(request.getParameter("pkgFlag"));
			voObj.setStrValue1(formBean.getChargeTypeId());
			voObj.setStrValue2(formBean.getCategoryCode());
			voObj.setStrValue3(formBean.getWardCode().replace("^", "#").split("#")[0]);
			voObj.setStrValue4(formBean.getGroupId());
			voObj.setStrValue5(formBean.getSearchText());
			voObj.setStrValue6(formBean.getHospitalCode());
			voObj.setStrValue7(formBean.getPkgflag());
			voObj.setStrValue8(formBean.getStrSearchType());
			
			bo.getChargeTariffDetails2(voObj);
			
			if(voObj.getStrMsgType().equals("0"))
			{
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				if(formBean.getStrMode().equals("0"))
				{
					val = HLPbilling.getTariffChargeView(formBean.getStrResultWs());
				}
				else
				{
					val = HLPbilling.getTariffCodeChargeView3(formBean.getStrResultWs());
				}
			
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
			}
			else
			{
				throw new Exception(voObj.getStrMsgString());
			}
		
		}
		catch(Exception e)
		{
	     	new HisException("Billing","hisglobal.BillingDATA.initTariffChargeDetails()-->",e.getMessage());
			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing", "IpdBillManagementTransDATA->initPatientDtl()", msgStr);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
		    eObj = null;
		}
	}
	public static void strTariffNameCombo(HttpServletRequest request, HttpServletResponse response,BillingFB formBean)
	{		
		try
		{		
			BillingVO voObj = new BillingVO();
			BillingBO bo = new BillingBO();
			String strTariffNameCombo="";
			HisUtil util = null;
			formBean.setHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString()+"##"+request.getParameter("groupId"));
			bo.getStrTariffNameCombo(voObj);
			
			if (voObj.getStrMsgType().equals("1")) {

				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("Billing","strTariffNameCombo");
			strTariffNameCombo = util.getOptionValue(voObj.getStrTariffWs(), "","", false);	
			//System.out.println(strTariffNameCombo);
			formBean.setStrTariffNameCombo(strTariffNameCombo);
			
			
		
		}
		catch(Exception e)
		{
	     	new HisException("Billing","hisglobal.BillingDATA.strTariffNameCombo()-->",e.getMessage());
			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing", "IpdBillManagementTransDATA->strTariffNameCombo()", msgStr);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
		    eObj = null;
		}
	}
	public static void getReceiptDetailsListing(HttpServletRequest request,HttpServletResponse response, BillingFB formBean) 
	{
		BillingVO voObj = null;
		BillingBO bo = null;
		BillConfigUtil bcu = null;
		try 
		{			
			UserVO userVO=null;

			voObj = new BillingVO();
			bo = new BillingBO();
			bcu = new BillConfigUtil(userVO.getHospitalCode());
			
			String strSearchString = request.getParameter("searchString");
			String strSearchType = request.getParameter("searchType");
			String strFromRow = request.getParameter("fromRow");
			String strRowPerPage = request.getParameter("rowPerPage");
			String strCtBlockSet = request.getParameter("ctBlockSet");
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = "0";
			if(bcu.getGeneralRefundAgainstRefundRequest().equals("1"))
			{
				strSeatId = request.getSession().getAttribute("SEATID").toString();
			} 
			
			if(strSearchString.contains("^"))
			{
				strSearchString = strSearchString.replace('^', '%');
			}
					
			voObj.setStrValue2(strSearchString);
			voObj.setStrValue3(strSearchType);
			voObj.setStrValue4(strFromRow);
						
			int nToRow = Integer.parseInt(strFromRow) + Integer.parseInt(strRowPerPage) * 10;
			
			voObj.setStrValue5(String.valueOf(nToRow));
			voObj.setStrValue6(strRowPerPage);
			voObj.setStrValue7(strCtBlockSet);
			voObj.setStrValue8(strHospitalCode);
			voObj.setStrValue10(strSeatId);
			
			bo.getReceiptDetailsListing(voObj);
			
			if (voObj.getStrMsgType().equals("0"))
			{
				formBean.setStrResultWs(voObj.getGblWs1());
				
				String val = HLPbilling.getReceiptListingView(voObj);
			    String[] TestData = val.replace("####", "#") .split("#");
			    response.setHeader("Cache-Control", "no-cache");
			    if(TestData[0].equals("ERROR"))
			    {
			       throw new Exception(TestData[1]);
				}	
			    else
			    {	
			        response.getWriter().print(TestData[0]);
			    }  
			} 
			else 
			{
            	throw new Exception(voObj.getStrMsgString());

			}
			
			
		}
		catch (Exception e) 
		{

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try 
			{
				HisException eObj = new HisException("Global Billing File", "hisglobal.BillingDATA.getPatientListingDtls()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			}
			catch (IOException e1) 
			{
				
			}

		} 
		finally {

				bo = null;
				voObj = null;
				bcu = null;
		}
	}
	public static void getPatientListingDtls(HttpServletRequest request,
			HttpServletResponse response, BillingFB formBean) {

		BillingVO voObj = null;
		BillingBO bo = null;
		BillConfigUtil bcu = null;
		try {

			voObj = new BillingVO();
			bo = new BillingBO();
			
			
			String strPatListType = request.getParameter("patListType");
			String strSearchString = request.getParameter("searchString");
			String strSearchType = request.getParameter("searchType");
			String strFromRow = request.getParameter("fromRow");
			String strRowPerPage = request.getParameter("rowPerPage");
			String strCtBlockSet = request.getParameter("ctBlockSet");
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			bcu = new BillConfigUtil(strHospitalCode);
			String strSeatId = "0";
			if(bcu.getGeneralRefundAgainstRefundRequest().equals("1")){
				strSeatId = request.getSession().getAttribute("SEATID").toString();
			} 
			
			
			String strDeptCode = request.getParameter("deptCode");
			
			if(strSearchString.contains("^")){
				strSearchString = strSearchString.replace('^', '%');
			}
					
			voObj.setStrValue1(strPatListType);
			voObj.setStrValue2(strSearchString);
			voObj.setStrValue3(strSearchType);
			voObj.setStrValue4(strFromRow);
						
			int nToRow = Integer.parseInt(strFromRow) + Integer.parseInt(strRowPerPage) * 10;
			
			voObj.setStrValue5(String.valueOf(nToRow));
			voObj.setStrValue6(strRowPerPage);
			voObj.setStrValue7(strCtBlockSet);
			voObj.setStrValue8(strHospitalCode);
			voObj.setStrValue9(strDeptCode);
			voObj.setStrValue10(strSeatId);
			
			bo.getPatientListingDtl(voObj);
			
			if (voObj.getStrMsgType().equals("0"))
			{
				formBean.setStrResultWs(voObj.getGblWs1());

		//		String val = HLPbilling.getPatientListingView(voObj);

		//		response.setHeader("Cache-Control", "no-cache");

		//		response.getWriter().print(val);
						
				String val = HLPbilling.getPatientListingView(voObj);
			    String[] TestData = val.replace("####", "#") .split("#");
			    response.setHeader("Cache-Control", "no-cache");
			    if(TestData[0].equals("ERROR"))
			    {
			       throw new Exception(TestData[1]);
				}	
			    else
			    {	
			        response.getWriter().print(TestData[0]);
			    }  
				

			} 
			else 
			{

				throw new Exception(voObj.getStrMsgString());

			}
			
			
		}
		catch (Exception e) 
		{

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try 
			{
				HisException eObj = new HisException("Global Billing File", "hisglobal.BillingDATA.getPatientListingDtls()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			}
			catch (IOException e1) 
			{
				//System.out.println("Inside IInd Else::::"+e1.getMessage());
			}

		} 
		finally {

				bo = null;
				voObj = null;
				bcu = null;
		}
	}
	
	public static void getPatientListingDtls_BS(HttpServletRequest request,
			HttpServletResponse response, BillingFB formBean) {

		BillingVO voObj = null;
		BillingBO bo = null;
		BillConfigUtil bcu = null;
		try {

			voObj = new BillingVO();
			bo = new BillingBO();
			
			
			String strPatListType = request.getParameter("patListType");
			String strSearchString = request.getParameter("searchString");
			String strSearchType = request.getParameter("searchType");
			String strFromRow = request.getParameter("fromRow");
			String strRowPerPage = request.getParameter("rowPerPage");
			String strCtBlockSet = request.getParameter("ctBlockSet");
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			bcu = new BillConfigUtil(strHospitalCode);
			String strSeatId = "0";
			if(bcu.getGeneralRefundAgainstRefundRequest().equals("1")){
				strSeatId = request.getSession().getAttribute("SEATID").toString();
			} 
			
			
			String strDeptCode = request.getParameter("deptCode");
			
			if(strSearchString.contains("^")){
				strSearchString = strSearchString.replace('^', '%');
			}
					
			voObj.setStrValue1(strPatListType);
			voObj.setStrValue2(strSearchString);
			voObj.setStrValue3(strSearchType);
			voObj.setStrValue4(strFromRow);
						
			int nToRow = Integer.parseInt(strFromRow) + Integer.parseInt(strRowPerPage) * 10;
			
			voObj.setStrValue5(String.valueOf(nToRow));
			voObj.setStrValue6(strRowPerPage);
			voObj.setStrValue7(strCtBlockSet);
			voObj.setStrValue8(strHospitalCode);
			voObj.setStrValue9(strDeptCode);
			voObj.setStrValue10(strSeatId);
			
			bo.getPatientListingDtl(voObj);
			
			if (voObj.getStrMsgType().equals("0"))
			{
				formBean.setStrResultWs(voObj.getGblWs1());

		//		String val = HLPbilling.getPatientListingView(voObj);

		//		response.setHeader("Cache-Control", "no-cache");

		//		response.getWriter().print(val);
						
				String val = HLPbilling.getPatientListingView_BS(voObj);
			    String[] TestData = val.replace("####", "#") .split("#");
			    response.setHeader("Cache-Control", "no-cache");
			    if(TestData[0].equals("ERROR"))
			    {
			       throw new Exception(TestData[1]);
				}	
			    else
			    {	
			        response.getWriter().print(TestData[0]);
			    }  
				

			} 
			else 
			{

				throw new Exception(voObj.getStrMsgString());

			}
			
			
		}
		catch (Exception e) 
		{

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try 
			{
				HisException eObj = new HisException("Global Billing File", "hisglobal.BillingDATA.getPatientListingDtls()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			}
			catch (IOException e1) 
			{
				//System.out.println("Inside IInd Else::::"+e1.getMessage());
			}

		} 
		finally {

				bo = null;
				voObj = null;
				bcu = null;
		}
	}
	public static void getCashCollectionDetail(HttpServletRequest request,HttpServletResponse response, BillingFB formBean) {
		// TODO Auto-generated method stub
		BillingVO voObj = null;
		BillingBO bo = null;
		BillConfigUtil bcu = null;
		try {

			voObj = new BillingVO();
			bo = new BillingBO();
			
			HttpSession session=request.getSession();
			
			String strHospitalCode = session.getAttribute("HOSPITAL_CODE").toString();
			bcu = new BillConfigUtil(strHospitalCode);
			String strSeatId = session.getAttribute("SEATID").toString();
			
			
					
			voObj.setStrValue1(strHospitalCode);
			voObj.setStrValue2(strSeatId);
		
			
			bo.getCashCollectionDetail(voObj);
			
			if (voObj.getStrMsgType().equals("0"))
			{
				formBean.setStrResultWs(voObj.getGblWs1());

						
				HLPbilling.getCashCollectionDetailView(voObj,request);
			      
				

			} 
			else 
			{

				throw new Exception(voObj.getStrMsgString());

			}
			
			
		}
		catch (Exception e) 
		{

			String strmsgText = e.getMessage();
			response.setHeader("Cache-Control", "no-cache");
			try 
			{
				HisException eObj = new HisException("Global Billing File", "hisglobal.BillingDATA.getCashCollectionDetail()", strmsgText);
				String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
				response.getWriter().print(response1);
				eObj = null;
			}
			catch (IOException e1) 
			{
				//System.out.println("Inside IInd Else::::"+e1.getMessage());
			}

		} 
		finally {

				bo = null;
				voObj = null;
				bcu = null;
		}
	}
	
	public static void initPackageDtls(HttpServletRequest request, HttpServletResponse response,BillingFB formBean)
	{		
		try
		{		
			BillingVO voObj = new BillingVO();
			BillingBO bo = new BillingBO();
					
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			voObj.setStrHospitalCode(strHospitalCode);
			voObj.setStrPackageId(request.getParameter("strPackageId"));
			voObj.setStrCrNo(request.getParameter("strCrNo"));
			voObj.setStrAccNo(request.getParameter("strAccNo"));
			
			bo.getPackageDetails(voObj);
			
			if(voObj.getStrMsgType().equals("0"))
			{
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
			
					val = HLPbilling.getPackageDetails(voObj.getPackagews());
			
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
			}
			else
			{
				throw new Exception(voObj.getStrMsgString());
			}
		
		}
		catch(Exception e)
		{
	     	new HisException("Billing","hisglobal.BillingDATA.initTariffChargeDetails()-->",e.getMessage());
			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing", "IpdBillManagementTransDATA->initPatientDtl()", msgStr);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
		    eObj = null;
		}
	}

	
}
