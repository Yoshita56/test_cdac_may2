package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.PatientDtlHLP;
import hisglobal.utility.HisUtil;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;



//import billing.transactions.LFNoTransDAO;
import mms.MmsConfigUtil;
import mms.transactions.bo.IssueTransBO;

import mms.transactions.controller.fb.IssueTransFB;
import mms.transactions.controller.hlp.IssueTransHLP;
import mms.transactions.vo.IssueTransVO;


public class IssueTransDATA 
{

 //   private String   contents;
 //   private String   rptContents;	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _IssueTransFB
	 * @param request
	 */
	public static void getViewDtl(IssueTransFB _IssueTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   IssueTransVO vo = null;
		   IssueTransBO bo = null;
		   HisUtil util = null;
		   String strResult = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new IssueTransVO();
			   	bo=new IssueTransBO();
			   	util = new HisUtil("MMS Transactions", "IssueTransDATA");
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrItemCategoryNo(request.getParameter("itemCatNo"));
			   	vo.setStrCrNo(request.getParameter("crNo"));
			   ////System.out.println("Flag==>"+request.getParameter("strFlagVal"));
			   	vo.setStrFlagVal(request.getParameter("strFlagVal"));
			   	if(request.getParameter("strFlagVal").equals("1"))
			   	{
			   		vo.setStrFromDate(util.getASDate("dd-MMM-yyyy"));
				   	vo.setStrToDate(util.getASDate("dd-MMM-yyyy"));
			   	}
			   	else
			   	{
			   		vo.setStrFromDate(request.getParameter("fromDate"));
				   	vo.setStrToDate(request.getParameter("ToDate"));
			   	}
                
                /* Calling BO method */
			    bo.setViewPageDtl(vo);
			    
			       strResult = IssueTransHLP.getIssuedDetail(vo.getStrIssueDetailWs());

			    if(strResult!= null && !strResult.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "IssueTransDATA->getViewDtl()", vo.getStrMsgString());
					       String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueTransDATA->getViewDtl()", strmsgText);
				_IssueTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_IssueTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}
	
	/**
	 * Issue dtls init.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 */
	public static void issueDtlsInit(HttpServletRequest request,
			HttpServletResponse response, IssueTransFB formBean) 
	{

		String strSearchItemInitView = "";
		//boolean printFlag = false;
		
		IssueTransBO bo = null;
		IssueTransVO vo = null;
		String strMode = "";
		String strStoreId = "";
		String strIssueNo = "";

		try {

			    strMode = (String) request.getParameter("strMode");
			 strStoreId = (String) request.getParameter("strStoreId");
			 strIssueNo = (String) request.getParameter("strIssueNo");			
			         bo = new IssueTransBO();
			         vo = new IssueTransVO();
			
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString()); 
			formBean.setStrStoreId(strStoreId);
			formBean.setStrMode(strMode);
			formBean.setStrIssueNo(strIssueNo);
			/*
			formBean.setStrCrNo(request.getParameter("crNo"));
			formBean.setStrIssueNo(request.getParameter("strIssueNo"));
			formBean.setStrPrescribedBy(request.getParameter("prescribedBy"));		

			
			vo.setStrCrNum(request.getParameter("crNo"));
			vo.setStrIssueNo(request.getParameter("strIssueNo"));
			vo.setStrPrescribedBy(request.getParameter("prescribedBy"));
			*/
			
			vo.setStrMode(formBean.getStrMode());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrIssueNo(formBean.getStrIssueNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrIssueNo(formBean.getStrIssueNo());
			/*
			formBean.setStrIssueNo(strIssueNo);
			formBean.setStrIssueDate(vo.getStrIssueDate());
			formBean.setStrIssueTo(vo.getStrIssueTo());
			formBean.setStrItemCategoryId(vo.getStrItemCategoryNo());
			formBean.setWsIssueDetails(vo.getWsIssueDetails());
			*/
			
			bo.getIssueDtlsInitDtls(vo);

			if (vo.getStrMsgType().equals("1")) 
				throw new Exception(vo.getStrMsgString());
			
 			formBean.setWsIssueDetails(vo.getWsIssueDetails());
				
			if(formBean.getWsIssueDetails().next() && formBean.getWsIssueDetails().size() > 0)
			{
				/*
				  (Which Call in Case of Off-Line Issue Voucher)
				  1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued By Doctor ^ Date ^ Cr No ^ Hindi Text ^ Registration No 
				  2.Drug Name
				  3.Batch No 
				  4.Exp Date
				  5.Issue Qty
				 */	
				////System.out.println("Hidden Val==>"+formBean.getWsIssueDetails().getString(1));
				   formBean.setStrHospitalName(formBean.getWsIssueDetails().getString(1).split("\\^")[0]);
				   formBean.setStrStoreName(formBean.getWsIssueDetails().getString(1).split("\\^")[1]);	
				   formBean.setStrPatientName(formBean.getWsIssueDetails().getString(1).split("\\^")[2]);
				   formBean.setStrIssueNo(formBean.getWsIssueDetails().getString(1).split("\\^")[3]);
				   formBean.setStrPrescribedBy(formBean.getWsIssueDetails().getString(1).split("\\^")[4]);
				   formBean.setStrIssueDate(formBean.getWsIssueDetails().getString(1).split("\\^")[5]);
				   formBean.setStrCrNo(formBean.getWsIssueDetails().getString(1).split("\\^")[6]);	
				   formBean.setStrHindiText(formBean.getWsIssueDetails().getString(1).split("\\^")[7]);
				   formBean.setStrRegNo(formBean.getWsIssueDetails().getString(1).split("\\^")[8]);	
				   formBean.setStrMode("1");	
				   formBean.setStrLFAccountNo((formBean.getWsIssueDetails().getString(8)==null) ? "" : formBean.getWsIssueDetails().getString(8));
				   formBean.setStrLocDL(formBean.getWsIssueDetails().getString(9));
				   formBean.getWsIssueDetails().beforeFirst();
			}
			
			strSearchItemInitView = IssueTransHLP.getIssueDtlsInitView(formBean);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);

		} 
		catch (Exception e)
		{
			e.printStackTrace();
			 
			 String strmsgText = "IssueTransDATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;
			  
		}finally {

			bo = null;
			vo = null;
		}
	}
	
	
	/**
	 * Issue dtls init.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 */
	public static void issueDtlsInitOne(HttpServletRequest request,
			HttpServletResponse response, IssueTransFB formBean) 
	{

		String strSearchItemInitView = "";

		IssueTransBO bo = null;
		IssueTransVO vo = null;
		String strMode = "";
		String strStoreId = "";
		String strIssueNo = "";

		try {

			    strMode = (String) request.getParameter("strMode");
			 strStoreId = (String) request.getParameter("strStoreId");
			 strIssueNo = (String) request.getParameter("strIssueNo");			
			bo = new IssueTransBO();
			vo = new IssueTransVO();
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString()); 
			formBean.setStrStoreId(strStoreId);
			formBean.setStrMode(strMode);
			formBean.setStrIssueNo(strIssueNo);
			formBean.setStrCrNo(request.getParameter("crNo"));
			formBean.setStrIssueNo(request.getParameter("strIssueNo"));
			

			
			vo.setStrCrNum(request.getParameter("crNo"));
			vo.setStrIssueNo(request.getParameter("strIssueNo"));			
			vo.setStrMode(formBean.getStrMode());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrIssueNo(formBean.getStrIssueNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			
			formBean.setStrIssueNo(strIssueNo);
			formBean.setStrIssueDate(vo.getStrIssueDate());
			formBean.setStrIssueTo(vo.getStrIssueTo());
			formBean.setStrItemCategoryId(vo.getStrItemCategoryNo());
			formBean.setWsIssueDetails(vo.getWsIssueDetails());
            // Calling BO method
			bo.getIssueDtlsInitDtls(vo);

			if (vo.getStrMsgType().equals("1")) 
			{

				throw new Exception(vo.getStrMsgString());
			}
 			    formBean.setWsIssueDetails(vo.getWsIssueDetails());
				
				while(formBean.getWsIssueDetails().next())
				{
					/*
					  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
					  1.Issue No
					  2.Issue Date
					  3.Issue To 
					  4.Issue By
					  5.Generic Name
					  6.Brand Name
					  7.Batch No
					  8.Expiry date
					  9.Issue rate
					  10.Issue Qty
					  11.Store Id
					  12.Item Id
					  13.Item Brand ID
					  14.Batch No
					  15.Expiry Date
					  16.Issue Rate
					  17.Issue Rate Unit Id
					  18.Issue Rate Base Unit Id
					  19.Issue Qty
					  20.Issue Qty Unit Id
					  21.Issue Qty Base Value
					  22.Item Sl No
					  23.Item SL No
					  24,Category Code
					  25.Issue Qty
					  26.Remarks
					  27.Final remarks
					  28.Received By
					  29.Cost
					  30.Total Avl Budget
					  31.Indent No
					  32.Indent Date
					  33.Purchase Rate e.g 101 No.
					  34.Cost With Purchae Rate 
					  35.CR No
					  36.Issue By
					  37.Order By
					  38.Hospital Name
					 */
					   formBean.setStrStoreName(formBean.getWsIssueDetails().getString(4));
					   formBean.setStrFinalRemarks(formBean.getWsIssueDetails().getString(27));
					   formBean.setStrItemWiseCost(formBean.getWsIssueDetails().getString(29));					   
					   formBean.setStrIssueNo(formBean.getWsIssueDetails().getString(1));
					   formBean.setStrIssueDate(formBean.getWsIssueDetails().getString(2));
					   formBean.setStrPatientName(formBean.getWsIssueDetails().getString(3));
					   formBean.setStrCrNo(formBean.getWsIssueDetails().getString(35));
					   formBean.setStrIssueBy(formBean.getWsIssueDetails().getString(36));
					   formBean.setStrPrescribedBy(formBean.getWsIssueDetails().getString(37));
					   formBean.setStrHospitalName(formBean.getWsIssueDetails().getString(38));
					   formBean.setStrMode(strMode);
//					   //System.out.println("Store Name:::"+formBean.getWsIssueDetails().getString(4));
//					   //System.out.println("setStrFinalRemarks:::"+formBean.getWsIssueDetails().getString(27));
//					   //System.out.println("setStrItemWiseCost::"+formBean.getWsIssueDetails().getString(29));
//					   //System.out.println("setStrIssueNo::::"+formBean.getWsIssueDetails().getString(1));
//					   //System.out.println("setStrIssueDate:::"+formBean.getWsIssueDetails().getString(2));
//					   //System.out.println("setStrPatientName:::"+formBean.getWsIssueDetails().getString(3));
//					   //System.out.println("setStrCrNo:::"+formBean.getWsIssueDetails().getString(35));
								
				}
				
				formBean.getWsIssueDetails().beforeFirst();
			    strSearchItemInitView = IssueTransHLP.getIssueDtlsInitView(formBean);

			    response.setHeader("Cache-Control", "no-cache");
			    response.getWriter().print(strSearchItemInitView);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			 
			 String strmsgText = "IssueTransDATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;
			  
		}finally {

			bo = null;
			vo = null;
		}

	}
	public static void getStoreDtls(IssueTransFB formBean, HttpServletRequest request) 
	{
		IssueTransBO       bo = null;
		IssueTransVO       vo = null;
		HisUtil          util = null;
		String    strStoreVal = "";
		String 	strCatVal="";
		String     strmsgText = null;
		ResourceBundle resObj = null;
		SimpleDateFormat  sdf = null;
		Calendar           c1 = null;
		
		try 
		{
			               bo = new IssueTransBO();
			               vo = new IssueTransVO();
			             util = new HisUtil("MMS Transactions", "IssueTransDATA");			
			              sdf = new SimpleDateFormat("dd-MMM-yyyy");
		                   c1 = Calendar.getInstance();	    
		    c1.add(Calendar.DATE,0);   // or  Calendar.DAY_OF_MONTH which is a synonym
		    ////System.out.println("Date + 1 days is : " + sdf.format(c1.getTime()));			
			
			//String strCtDate = util.getASDate("dd-MMM-yyyy");
			
			String strConfCatCode = MmsConfigUtil.STAFF_CAT_CODE;
			formBean.setStrConfCatCode(strConfCatCode);
			vo.setStrConfCatCode(strConfCatCode);
			formBean.setStrCtDate(sdf.format(c1.getTime()));
			
			if(request.getParameter("mode") != null){
				
				String strMode = request.getParameter("mode");
				formBean.setStrMode(strMode);
				
			}
			
			vo.setStrMode(formBean.getStrMode());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			// Calling Bo Method
			bo.getStoreDtls(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			if(vo.getStrStoreWs()!=null && vo.getStrStoreWs().size()>0)
			{
				while(vo.getStrStoreWs().next())
				{					
					vo.setStrStoreId(vo.getStrStoreWs().getString(1));
				}
			}
			
			vo.getStrStoreWs().beforeFirst();
		
			if(vo.getStrStoreWs()!=null && vo.getStrStoreWs().size()>0)
			{
				
				strStoreVal = util.getOptionValue(vo.getStrStoreWs(),"","0^Select Value", false);
			}
			else
			{
				strStoreVal = "<option value='0'>Select Value</option>";
			}						
			formBean.setStrStoreValues(strStoreVal);			
			vo.setStrReqTypeId("32");			
			bo.getItemCatDtls(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		
			if(vo.getStrItemCatWs()!=null && vo.getStrItemCatWs().size()>0)
			{
				strCatVal = util.getOptionValue(vo.getStrItemCatWs(),"","", false);
			}
			else
			{
				strCatVal = "<option value='0'>Select Value</option>";
			}
						
			formBean.setStrCatValues(strCatVal);	
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueTransDATA.getStoreDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getStoreDtls()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
			
			resObj = null;
			sdf = null;
			c1 = null;
		}
	}
	
	public static void getStoreDtlsView(IssueTransFB formBean, HttpServletRequest request) {

		IssueTransBO bo       = null;
		IssueTransVO vo       = null;
		HisUtil util          = null;
		String strStoreVal    = "";
		String strmsgText     = null;
		ResourceBundle resObj = null;
		SimpleDateFormat  sdf = null;
		Calendar           c1 = null;
		String strConfCatCode = "";
		
		try 
		{
			               bo = new IssueTransBO();
			               vo = new IssueTransVO();
			             util = new HisUtil("MMS Transactions", "IssueTransDATA");			
			              sdf = new SimpleDateFormat("dd-MMM-yyyy");
			              
		    c1 = Calendar.getInstance();	    
		    c1.add(Calendar.DATE,-1);   // or  Calendar.DAY_OF_MONTH which is a synonym
		    ////System.out.println("Date + 1 days is : " + sdf.format(c1.getTime()));			
			//String strCtDate = util.getASDate("dd-MMM-yyyy");			
			   strConfCatCode = MmsConfigUtil.STAFF_CAT_CODE;
			formBean.setStrConfCatCode(strConfCatCode);
			vo.setStrConfCatCode(strConfCatCode);
			formBean.setStrCtDate(sdf.format(c1.getTime()));
			
			if(request.getParameter("mode") != null)
			{
				
				String strMode = request.getParameter("mode");
				formBean.setStrMode(strMode);
				
			}
			
			vo.setStrMode(formBean.getStrMode());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			// Calling Bo Method
			bo.getStoreDtlsView(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		
			if(vo.getStrStoreWs()!=null && vo.getStrStoreWs().size()>0)
			{
				/*
				if(vo.getStrStoreWs().next())
				{
					vo.setStrStoreId(vo.getStrStoreWs().getString(1));
					vo.getStrStoreWs().beforeFirst();
				}
				*/
				strStoreVal = util.getOptionValue(vo.getStrStoreWs(), "0","0^Select Value", false);
			}
			else
			{
				strStoreVal = "<option value='0'>Select Value</option>";
			}
						
			formBean.setStrStoreValues(strStoreVal);
			// Calling Bo Method
			
			/*
			bo.getPatinetTypeCmb(vo);
	       
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		
			if(vo.getStrPatientTypeWs()!=null && vo.getStrPatientTypeWs().size()>0)
			{				
				strStoreVal = util.getOptionValue(vo.getStrPatientTypeWs(), "","", false);
			}
			else
			{
				strStoreVal = "<option value='0'>Select Value</option>";
			}
						
			formBean.setStrPatientTypeCmbValues(strStoreVal);
			*/
			
			resObj = mms.qryHandler_mms.res;
			if(resObj == null) 
			{
				resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = resObj;
			}
			
			formBean.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));
			
			
			String strModeVal = request.getParameter("modeVal");
			if(strModeVal!=null && strModeVal.equals("0")){
				vo.setStrReqTypeId("32");
				
			}else if(strModeVal!=null && strModeVal.equals("1")){
				vo.setStrReqTypeId("33");
				
			}else if(strModeVal!=null && strModeVal.equals("2")){
				
				vo.setStrReqTypeId("32");
				
			}
			else
				vo.setStrReqTypeId("32");
			
			// Calling Bo Method
			
			
			bo.getItemCatDtls1(vo);
			

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());

			}
			String temp = "";

			if (vo.getStrItemCatWs().size() != 0) {
				
				temp = util.getOptionValue(vo.getStrItemCatWs(), "", "0^Select Value",false);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			formBean.setStrCatValues(temp);
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueTransDATA.getStoreDtlsView --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getStoreDtlsView()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
			
			resObj = null;
			sdf = null;
			c1 = null;
		}
	}
	
	public static void getGroupDetails(IssueTransFB formBean, HttpServletRequest request) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strGroupVal = "";
		String strmsgText = null;
		
		try {
			bo = new IssueTransBO();
			vo = new IssueTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrItemCat(formBean.getItemCategory());
			
			bo.getStoreGroupDtls(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueTransDATA");
			
			strGroupVal = util.getOptionValue(vo.getStrGroupWs(), "0",
					"0^Select Value", false);
						
			formBean.setStrGroupValues(strGroupVal);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueTransDATA.getGroupDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getGroupDetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	public static void getItemCatDtls(IssueTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IssueTransBO bo = null;
		IssueTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new IssueTransBO();
			voObj = new IssueTransVO();
			
			String strStoreId = request.getParameter("storeId");
			String strModeVal = request.getParameter("modeVal");
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			if(strModeVal.equals("0")){
				voObj.setStrReqTypeId("32");
				
			}else if(strModeVal.equals("1")){
				voObj.setStrReqTypeId("33");
				
			}else if(strModeVal.equals("2")){
				
					voObj.setStrReqTypeId("32");
				
			}
			
			bo.getItemCatDtls(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueTransDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrItemCatWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrItemCatWs(), "10", "0^Select Value",
						true);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueTransDATA.getItemCatDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getItemCatDtls()", strmsgText);
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
	public static int getissuetopatientcount(IssueTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IssueTransBO bo = null;
		IssueTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		int temp =0;
		try {

			bo = new IssueTransBO();
			voObj = new IssueTransVO();
			
			voObj.setStrStoreId(formBean.getStrId());
			voObj.setStrItemCat(formBean.getItemCategory());
			voObj.setStrCrNo(formBean.getStrCrNo());
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			
			bo.issueTopatientCount(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueTransDATA");
			

			if (voObj.getWsissuetopatcount().size() != 0) {
				WebRowSet wb=voObj.getWsissuetopatcount();
				 while(wb.next())
				 {
					 temp=Integer.parseInt(wb.getString(1));
				 }

			}else{
				
				temp=0;
			}

			

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueTransDATA.getItemCatDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getItemCatDtls()", strmsgText);
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
		return temp;
	}
	
	public static void getCancelPatientDetails(IssueTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response)
	{

		IssueTransBO          bo = null;
		IssueTransVO          vo = null;
		MmsConfigUtil        mcu = null;
	
		String        strmsgText = null;
		String strPatientDetails = "";
		String      strIssueMode = "";
		ResourceBundle    resObj = null;
		
		try 
		{
						    bo = new IssueTransBO();
						    vo = new IssueTransVO();
						   mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
						   
						   resObj = mms.qryHandler_mms.res;
							if(resObj == null) 
							{
								resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
								mms.qryHandler_mms.res = resObj;
							}
							
		          strIssueMode = mcu.getStrIssueMode();
		formBean.setStrIssueMode(strIssueMode);		
		formBean.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));		
		vo.setStrHospitalCode(formBean.getStrHospitalCode());
		vo.setStrSeatId(formBean.getStrSeatId());
		////System.out.println("Issue No=[getCancelPatientDetails()]=>"+formBean.getStrIssueNo());		
		vo.setStrIssueNo(formBean.getStrIssueNo());
		// Calling BO Method
		bo.getCancelIssueDtls(vo);
		while(vo.getWsCancelIssueDtl().next())
		{			
			formBean.setStrIssueDate(vo.getWsCancelIssueDtl().getString(7).split("\\^")[0]);
			formBean.setStrPatientName(vo.getWsCancelIssueDtl().getString(7).split("\\^")[1]);
			formBean.setStrPatientAgeUnit(vo.getWsCancelIssueDtl().getString(7).split("\\^")[2]);
			formBean.setStrCrNo(vo.getWsCancelIssueDtl().getString(7).split("\\^")[3]);
			formBean.setStrDDCName(vo.getWsCancelIssueDtl().getString(7).split("\\^")[4]);
			formBean.setStrItemCatgName(vo.getWsCancelIssueDtl().getString(7).split("\\^")[5]);
		}
		vo.getWsCancelIssueDtl().beforeFirst();
		
		formBean.setWsCancelIssueDtl(vo.getWsCancelIssueDtl());
		// HLP Method
		 strPatientDetails = IssueTransHLP.getPatientDtl(formBean);
		formBean.setStrPatientDetails(strPatientDetails);
		
		if (vo.getStrMsgType().equals("1")) 
		{
			throw new Exception(vo.getStrMsgString());
		}
				
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueTransDATA.getCancelPatientDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getPatientDetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
		
			eObj = null;	
		} 
	    finally 
	    {
		
		if (bo != null)
			bo = null;
		if (vo != null)
			vo = null;
	    }
		
    }
	public static void getPatientDetails(IssueTransFB formBean, HttpServletRequest request, 
						HttpServletResponse response) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		ResourceBundle resObj =  null;
		
		try 
		{
			System.out.println("<------------- IssueTransDATA.getPatientDetails() ------------->");
			
			     bo = new IssueTransBO();
			     vo = new IssueTransVO();
			    mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   util = new HisUtil("","");		
			   resObj = mms.qryHandler_mms.res;
				if(resObj == null) 
				{
					resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
					mms.qryHandler_mms.res = resObj;
				}
				
			formBean.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			String strIssueMode = mcu.getStrIssueMode();
			formBean.setStrIssueMode("0");  // Please Check			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			// HLP Method	
			  
			//if(formBean.getStrLFNo()!=null && formBean.getStrLFNo()!="")
/*			  if(false)
			{
				
				vo.setStrLFNo(formBean.getStrLFNo());
				
				bo.getLFAccountDetail(vo);
				
				formBean.setStrCrNo(vo.getStrCrNo());
				if(vo.getStrCrNo() == null || vo.getStrCrNo() =="")
				{
					throw new Exception("LF No. not Exists/closed!");
				}
				else
				{
					
					formBean.setCrNo(formBean.getStrCrNo());
					formBean.setStrLFAccountNo(vo.getStrLFAccountNo()); 
					formBean.setStrLFAccountOpenDate(vo.getStrLFAccountOpenDate());
					formBean.setStrLFDepositedAmount(vo.getStrLFDepositedAmount());
					formBean.setStrLFBalanceAmount(vo.getStrLFBalanceAmount());
					formBean.setStrLFAccountStatus(vo.getStrLFAccountStatus());
				}
			}*/
			
			//else
			//{
				 vo.setStrPuk( formBean.getStrCrNo());
				 bo.getLFAccountDetail(vo);
				 	formBean.setStrLFAccountNo(vo.getStrLFAccountNo()); 
					formBean.setStrLFAccountOpenDate(vo.getStrLFAccountOpenDate());
					formBean.setStrLFDepositedAmount(vo.getStrLFDepositedAmount());
					formBean.setStrLFBalanceAmount(vo.getStrLFBalanceAmount());
					formBean.setStrLFAccountStatus(vo.getStrLFAccountStatus());
				 
				//strCrNo
			//}
			  
			System.out.println("<------------- PatientDtlHLP.patientWithAdmissionDtl() ------------->");
			
			String strPatientDetails = PatientDtlHLP.patientWithAdmissionDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode(), true);
			
			System.out.println("<------------- PatientDtlHLP.patientTreatmentDtl() ------------->");
			
			//added by shefali on 26-Aug-2014 for patient treatment detail in issue to patient
			String strPatientTreatmentDtl =  PatientDtlHLP.patientTreatmentDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode());
			
			//added by shalini on 03-feb-2016 to fetch patient diagnosis details
			
			System.out.println("<------------- PatientDtlHLP.patientDiagDtl() ------------->");
			
			String strPatientDiagDetails = patientDiagDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode());
			
			formBean.setStrPatientDetails(strPatientDetails);
			formBean.setStrPatientTreatmentDtl(strPatientTreatmentDtl);
			formBean.setStrPatientDiagDetails(strPatientDiagDetails);
			bo.getLFAccountDetail(vo);

			formBean.setStrDoseFrqFlg("0");
		
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			if(e.getMessage().equals("PatientDtlHLP-->"+
					"patientWithAdmissionDtl-->PatientDtlHLP-->patientDtl-->Invalid CR. No.")){
					formBean.setStrErrMsg("Invalid CR. No./Data Not Found");
					formBean.setStrInvalidCrFlag("1");
					
					
			}
			else if(e.getMessage().equals("LF No. not Exists/closed!"))
			{
				formBean.setStrErrMsg("Invalid LF. No./Data Not Found");
				formBean.setStrInvalidLFFlag("1");
			}
			else{
				strmsgText = "mms.transactions.IssueTransDATA.getPatientDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueTransDATA->getPatientDetails()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");
	
				eObj = null;
			}
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
			
			if (mcu != null)
				mcu = null;
			
			if (resObj != null)
				resObj = null;
			
		}
	}
	
	/*
	 * To get PatientDetails new BS page added by swapnil
	 */
public static void getPatientDetails_BS(IssueTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) {

IssueTransBO bo = null;
IssueTransVO vo = null;
MmsConfigUtil mcu = null;
HisUtil util = null;
String strmsgText = null;
ResourceBundle resObj =  null;

try 
{

     bo = new IssueTransBO();
     vo = new IssueTransVO();
    mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
   util = new HisUtil("","");
////System.out.println("Cr No Flag:::::"+mcu.getStrWithOutCrNoFlg());
////System.out.println("Default Cr No Flag:::::"+mcu.getStrCrNoDefault());
   resObj = mms.qryHandler_mms.res;
	if(resObj == null) 
	{
		resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
		mms.qryHandler_mms.res = resObj;
	}
	
formBean.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));
formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
String strIssueMode = mcu.getStrIssueMode();
formBean.setStrIssueMode("0");  // Please Check			
vo.setStrHospitalCode(formBean.getStrHospitalCode());
vo.setStrSeatId(formBean.getStrSeatId());

// HLP Method	
  
//if(formBean.getStrLFNo()!=null && formBean.getStrLFNo()!="")
 /* if(false)
{
	vo.setStrLFNo(formBean.getStrLFNo());
	bo.getLFAccountDetail(vo);
	formBean.setStrCrNo(vo.getStrCrNo());
	if(vo.getStrCrNo() == null || vo.getStrCrNo() =="")
	{
		throw new Exception("LF No. not Exists/closed!");
	}
	else
	{
		formBean.setCrNo(formBean.getStrCrNo());
		formBean.setStrLFAccountNo(vo.getStrLFAccountNo()); 
		formBean.setStrLFAccountOpenDate(vo.getStrLFAccountOpenDate());
		formBean.setStrLFDepositedAmount(vo.getStrLFDepositedAmount());
		formBean.setStrLFBalanceAmount(vo.getStrLFBalanceAmount());
		formBean.setStrLFAccountStatus(vo.getStrLFAccountStatus());
	}
}

else
{*/
	 vo.setStrPuk( formBean.getStrCrNo());
	 bo.getLFAccountDetail(vo);
	 	formBean.setStrLFAccountNo(vo.getStrLFAccountNo()); 
		formBean.setStrLFAccountOpenDate(vo.getStrLFAccountOpenDate());
		formBean.setStrLFDepositedAmount(vo.getStrLFDepositedAmount());
		formBean.setStrLFBalanceAmount(vo.getStrLFBalanceAmount());
		formBean.setStrLFAccountStatus(vo.getStrLFAccountStatus());
	 
	//strCrNo
//}

String strPatientDetails = PatientDtlHLP.patientWithAdmissionDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode(), true);
String strPatientDetails1 = PatientDtlHLP.patientWithAdmissionDtlNEW(formBean.getStrCrNo(), formBean.getStrHospitalCode(), true);

//added by shefali on 26-Aug-2014 for patient treatment detail in issue to patient
String strPatientTreatmentDtl =  PatientDtlHLP.patientTreatmentDtl_BS(formBean.getStrCrNo(), formBean.getStrHospitalCode());

//added by shalini on 03-feb-2016 to fetch patient diagnosis details

String strPatientDiagDetails = patientDiagDtl_BS(formBean.getStrCrNo(), formBean.getStrHospitalCode());

formBean.setStrPatientDetails(strPatientDetails);
formBean.setStrPatientDetailsNew(strPatientDetails1);
formBean.setStrPatientTreatmentDtl(strPatientTreatmentDtl);
formBean.setStrPatientDiagDetails(strPatientDiagDetails);
bo.getLFAccountDetail(vo);

formBean.setStrDoseFrqFlg("0");

if (vo.getStrMsgType().equals("1")) {
	throw new Exception(vo.getStrMsgString());
}
		
} catch (Exception e) {
e.printStackTrace();
if(e.getMessage().equals("PatientDtlHLP-->"+
		"patientWithAdmissionDtl-->PatientDtlHLP-->patientDtl-->Invalid CR. No.")){
		formBean.setStrErrMsg("Invalid CR. No./Data Not Found");
		formBean.setStrInvalidCrFlag("1");
		
		
}
else if(e.getMessage().equals("LF No. not Exists/closed!"))
{
	formBean.setStrErrMsg("Invalid LF. No./Data Not Found");
	formBean.setStrInvalidLFFlag("1");
}
else{
	strmsgText = "mms.transactions.IssueTransDATA.getPatientDetails --> "
			+ e.getMessage();
	HisException eObj = new HisException("mms",
			"IssueTransDATA->getPatientDetails()", strmsgText);
	formBean.setStrErrMsg("Application Error [ERROR ID : "
			+ eObj.getErrorID() + "],Contact System Administrator! ");

	eObj = null;
}
} finally {

if (bo != null)
	bo = null;
if (vo != null)
	vo = null;
if (util != null)
	util = null;

if (mcu != null)
	mcu = null;

if (resObj != null)
	resObj = null;

}
}


	
	public static void getOnlineReqDtl(IssueTransFB formBean, HttpServletRequest request, HttpServletResponse response) 
	{

			IssueTransBO bo = null;
			IssueTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
		
		try 
		{
			    System.out.println("<------------- IssueTransDATA.getOnlineReqDtl() ------------->");
				bo = new IssueTransBO();
				vo = new IssueTransVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				String strIssueMode = mcu.getStrIssueMode();
				formBean.setStrIssueMode(strIssueMode);
				
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrCrNumber(formBean.getCrNo());
				
				String strOnlineIssueReqDays = mcu.getStrOnlineIssueDetailsInDays();
				vo.setStrOnlineIssueReqDays(strOnlineIssueReqDays);
				
				bo.getRequestDtls(vo);
									
				System.out.println("<------------- IssueTransHLP.getRequestDtls() ------------->"); 
				
				String strReqValues = IssueTransHLP.getRequestDtls(vo.getStrRequestWs());
				formBean.setStrReqValues(strReqValues);
				formBean.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
		if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
				strmsgText = "mms.transactions.IssueTransDATA.getOnlineReqDtl --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueTransDATA->getOnlineReqDtl()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");
				
				eObj = null;
		} finally {
		
				if (bo != null)
					bo = null;
				if (vo != null)
					vo = null;
				if (util != null)
					util = null;
				}
		}
	
	public static void getItemDetails(IssueTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response ) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		String strItemDetails ="";
		
		try {
			bo = new IssueTransBO();
			vo = new IssueTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			String strIssueMode = mcu.getStrIssueMode();
			formBean.setStrIssueMode(strIssueMode);
						
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrRequestNo(request.getParameter("reqNo"));
			vo.setStrCrNumber(request.getParameter("crNo"));
			vo.setStrStoreId(request.getParameter("strId"));		
			
			bo.getItemDetails(vo);
			
			strItemDetails = IssueTransHLP.getItemDetails(vo.getStrHospitalCode(),vo.getStrItemDetailWs());
			
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemDetails);	
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueTransDATA.getItemDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getItemDetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
			
			eObj = null;
		} finally {
		
			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
			}
		}
	
	public static void getIssuePopUp(IssueTransFB formBean, HttpServletRequest request, 
						HttpServletResponse response) {
			
			IssueTransBO bo    = null;
			IssueTransVO vo    = null;			
			
			String strmsgText  = null;			
			String strStoreId  = "";
			String strIssueNo  = "";
			String strHospCode = "";
			String strPopUp    = "";			
			try 
			{
				            bo = new IssueTransBO();
				            vo = new IssueTransVO();							
				   strHospCode = formBean.getStrHospitalCode();
				    strStoreId = request.getParameter("strId");
				    strIssueNo = request.getParameter("issueNo");
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}				
				      strPopUp = IssueTransHLP.getIssuePopUp(strHospCode,strStoreId,strIssueNo);
				      
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strPopUp);	
							
			} catch (Exception e) {
				strmsgText = "mms.transactions.IssueTransDATA.getIssuePopUp --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueTransDATA->getIssuePopUp()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");
			
				eObj = null;
			} finally {
			
				if (bo != null)
					bo = null;
				if (vo != null)
					vo = null;
				
			}
		}
	
	public static void getIssueDetails(IssueTransFB formBean, HttpServletRequest request, HttpServletResponse response)
		{
			
			IssueTransBO bo = null;
			IssueTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			WebRowSet ws = null;
			try {
				bo = new IssueTransBO();
				vo = new IssueTransVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				
				vo.setStrStoreId(request.getParameter("strId"));
				vo.setStrCatCode(request.getParameter("itemCategory"));
				vo.setStrCrNum(request.getParameter("crNo"));
				vo.setStrIssueNo(request.getParameter("strIssueNo"));
				vo.setStrPrescribedBy(request.getParameter("prescribedBy"));				
				vo.setStrPatStaffDays(mcu.getStrLastIssuePatientStaffInDays());			
				// Calling BO Method
				bo.getIssueDetail(vo);
				  
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				
				ws = vo.getStrIssueDetailWs();
				
			/*	while(ws.next())
				{
					//System.out.println("ws.strings()"+ws.getString(1));
					//System.out.println("ws.strings()"+ws.getString(2));
				//	//System.out.println("ws.strings()"+ws.getString(3));
					
				}*/
			String strIssueDetails = IssueTransHLP.getIssueDetails(ws);
				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strIssueDetails);
				
			} catch (Exception e) {
				strmsgText = "mms.transactions.IssueTransDATA.getIssueDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueTransDATA->getIssueDetails()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");
			
				eObj = null;
			} finally {
			
				if (bo != null)
					bo = null;
				if (vo != null)
					vo = null;
				if (util != null)
					util = null;
			}
	  }
	
	public static void getRequestDetails(IssueTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		WebRowSet ws = null;
		MmsConfigUtil mcu = null;
		
		try {
			bo = new IssueTransBO();
			vo = new IssueTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrRequestNo(request.getParameter("reqNo"));
			vo.setStrCrNumber(request.getParameter("crNo"));
			
			String strOnlineIssueReqDays = mcu.getStrOnlineIssueDetailsInDays();
			vo.setStrOnlineIssueReqDays(strOnlineIssueReqDays);
			
		//	////System.out.println("1-----"+vo.getStrOnlineIssueReqDays());
		//	////System.out.println("2-----"+vo.getStrRequestNo());
		//	////System.out.println("3----"+vo.getStrCrNumber());
			
			bo.getRequestDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
			ws = vo.getStrRequestDetailWs();
			
			String strRequestDetails=IssueTransHLP.getRequestDetails(ws);
			
			//////System.out.println("strRequestDetails---------->"+strRequestDetails);
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strRequestDetails);
						
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueTransDATA.getRequestDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getRequestDetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	public static void getFrequencyDetails(IssueTransFB formBean, HttpServletRequest request) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strFrequencyVal = "";
		String strmsgText = null;
		
		try {
			bo = new IssueTransBO();
			vo = new IssueTransVO();
			util = new HisUtil("MMS Transactions", "IssueTransDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
						
			bo.getFrequencyDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueTransDATA");
			
			strFrequencyVal = util.getOptionValue(vo.getStrFrequencyWs(), "0",
					"0^Select Value", false);
						
			formBean.setStrFrequencyValues(strFrequencyVal);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueTransDATA.getFrequencyDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getFrequencyDetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	public static void getDoseDetails(IssueTransFB formBean, HttpServletRequest request) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strDosageVal = "";
		String strmsgText = null;
		
		try {
			bo = new IssueTransBO();
			vo = new IssueTransVO();
			util = new HisUtil("MMS Transactions", "IssueTransDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
						
			bo.getDoseDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueTransDATA");
			
			strDosageVal = util.getOptionValue(vo.getStrDosageWs(), "0",
					"0^Select Value", false);
			formBean.setStrDosageValues(strDosageVal);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueTransDATA.getDoseDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getDoseDetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	public static void getDeptDetails(IssueTransFB formBean, HttpServletRequest request) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strDeptVal = "";
		String strmsgText = null;
		
		try 
		{
			bo = new IssueTransBO();
			vo = new IssueTransVO();
			util = new HisUtil("MMS Transactions", "IssueTransDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getDeptDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueTransDATA");
			
			strDeptVal = util.getOptionValue(vo.getStrDepartmentWs(), "",
					"0^Select Value", false);
						
			formBean.setStrDeptValues(strDeptVal);
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueTransDATA.getDeptDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getDeptDetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	public static void getUnitDetails(IssueTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new IssueTransBO();
			vo = new IssueTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			vo.setStrDeptCode(request.getParameter("deptCode"));
			
			
			bo.getUnitDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueTransDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (vo.getStrUnitWs().size() != 0) {
				
				temp = util.getOptionValue(vo.getStrUnitWs(), "", "0^select Value",
						true);

			}else{
				
				temp = "<option value='0'>SelectValue</option>";
			}
 
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueTransDATA.getUnitDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getUnitDetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	public static void getUnitDetails1(IssueTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new IssueTransBO();
			vo = new IssueTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
				vo.setStrDeptCode("134");
				
			
			
			
			bo.getUnitDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueTransDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (vo.getStrUnitWs().size() != 0) {
				
				temp = util.getOptionValue(vo.getStrUnitWs(), "13411", "",
						true);

			}else{
				
				temp = "<option value='0'>SelectValue</option>";
			}
 
 		formBean.setStrUnitValues(temp);
			//response.setHeader("Cache-Control", "no-cache");
			//response.getWriter().print(temp);
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueTransDATA.getUnitDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getUnitDetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	public static void getPrescribedBy(IssueTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new IssueTransBO();
			vo = new IssueTransVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrUnitCode(request.getParameter("unitCode"));
//	//System.out.println("vo.getStrUnitCode"+vo.getStrUnitCode());		
			bo.getPrescribedBy(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueTransDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (vo.getStrConsultantWs().size() != 0) {
				
				temp = util.getOptionValue(vo.getStrConsultantWs(), "0", "0^Select Value",
						true);

			}else{
				
				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueTransDATA.getPrescribedBy --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getPrescribedBy()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	
	public static void insertipd(IssueTransFB formBean, HttpServletRequest request) 
	{

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		String[] temp = null;
		String[] strtemp = null;
		
		MmsConfigUtil mcu = null;
		
		int debugPoint = 0;
				
		try 
		{
			System.out.println("---------------------IssueTransDATA.insertipd---------------------");
			debugPoint = 1;
			bo = new IssueTransBO();
			vo = new IssueTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			
			////System.out.println("in issue mode 1 in data");
			vo.setStrReqQty(formBean.getStrReqQty());
			vo.setStrUnitName(formBean.getStrUnitName());
			vo.setItemParamValue(formBean.getItemParamValue());
			vo.setStrReqEmpNo("0");
			vo.setStrReqPatCatCode("0");
			vo.setStrReqAdmNo("0");
			vo.setStrReqWardCode("0");
			vo.setStrPatientType("18");
			
			debugPoint = 2;
			
			vo.setStrPrescribedBy(formBean.getStrPrescribedBy());
		    vo.setStrReqPrescribedBy(formBean.getStrPrescribedBy());
			vo.setStrPatientName(formBean.getStrPatientName());
			vo.setStrPatientId((formBean.getCrNo()!=null && !formBean.getCrNo().equals("0")) ?formBean.getCrNo() : "0");
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			debugPoint = 3;
			
			vo.setStrStoreId(formBean.getStrId().split("\\^")[0]);
			//vo.setStrItemCat("10");
			vo.setStrItemCat(formBean.getItemCategory());				
			vo.setStrIssueMode("0");
			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrReceiveBy(formBean.getStrReceiveBy());
			vo.setStrPuk(formBean.getCrNo());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrCostFinal(formBean.getStrCostFinal());
			vo.setStrApproxAmt(formBean.getStrApproxAmt());

			
			debugPoint = 4;
			
			if(formBean.getStrMode().equals("0"))
			{
				vo.setStrReqTypeId("32");
				
				
			}else if(formBean.getStrMode().equals("1"))
			{
				vo.setStrReqTypeId("33");
				
				
			}else if(formBean.getStrMode().equals("2"))
			{
				if(formBean.getStrConfCatCode().equals(vo.getStrReqPatCatCode()))
				{
					vo.setStrReqTypeId("33");
					
				}
				else
				{
					vo.setStrReqTypeId("32");
					
				}
			}
			
			debugPoint = 5;
			
			vo.setStrQtyText(formBean.getStrQtyText());
			vo.setStrDose(formBean.getStrDose());
			vo.setStrDays(formBean.getStrDays());
			vo.setStrFrequency(formBean.getStrFrequency());
			vo.setStrPatientHiddenValue1(formBean.getStrPatientHiddenValue1());
			vo.setStrPatientDtlHidVal(formBean.getStrPatientDtlHidVal());
			vo.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			vo.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			vo.setStrDrugIssueDate(formBean.getStrDrugIssueDate());
			
			vo.setStrOutOfStockFlag(formBean.getStrOutOfStockFlag());
			
			debugPoint = 6;
			if(formBean.getStrLFNo()==null ||formBean.getStrLFNo()=="")
			{
				bo.getLFAccountDetail(vo);
				
			//	formBean.setCrNo(vo.getStrCrNo());
				formBean.setStrLFAccountNo(vo.getStrLFAccountNo()); 
				formBean.setStrLFAccountOpenDate(vo.getStrLFAccountOpenDate());
				formBean.setStrLFDepositedAmount(vo.getStrLFDepositedAmount());
				formBean.setStrLFBalanceAmount(vo.getStrLFBalanceAmount());
				formBean.setStrLFAccountStatus(vo.getStrLFAccountStatus());
			}	
			// Calling BO Method
			if(vo.getStrLFAccountNo()!=null && vo.getStrLFAccountNo()!="" )
			{
				vo.setStrMode("2");
			}
			vo.setStrDeptCode(formBean.getStrDeptCode());
			vo.setStrAdmissionDtlHidVal(formBean.getStrAdmissionDtlHidVal());
			
			bo.insertipd(vo);
			debugPoint = 7;			
			
			
			
			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());
			else 
			{
					formBean.setStrNormalMsg("Data Saved Successfully");
					formBean.setStrIssueNum(vo.getStrIssueNumber());
					formBean.setStrVisitDtl("1");
					
			}
			
			System.out.println("---------------------IssueTransDATA.insertipd--------------END-------");
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueTransDATA.insertWithoutCrNo()--> "+e.getMessage() + String.valueOf(" :: Debug Point = " + debugPoint);
			//HisException eObj = new HisException("mms","IssueTransDATA->insertWithoutCrNo()",strmsgText,request);
			
			if(e.getMessage().contains("##") && (e.getMessage().split("\\##")[2].equals("999") || e.getMessage().split("\\##")[2].equals("103")))
				formBean.setStrErrMsg(e.getMessage().split("\\##")[1]);
			else
			//	formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
			
			formBean.setStrIssueNo("0");
		    formBean.setStrIssueNum("0");
		    
			//eObj = null;
			
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	public static void insertCancel(IssueTransFB formBean, HttpServletRequest request) 
	{

		IssueTransBO bo = null;
		IssueTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;		
			
		try 
		{
			bo = new IssueTransBO();
			vo = new IssueTransVO();			
			
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrCrNum(formBean.getStrCrNo());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIssueNo(formBean.getStrIssueNo());			
			
//			//System.out.println("Hosp Code==>"+formBean.getStrHospitalCode());
//			//System.out.println("Seat ID==>"+formBean.getStrSeatId());
//			//System.out.println("Remarks==>"+formBean.getStrRemarks());
//			//System.out.println("Issue No==>"+formBean.getStrIssueNo());
			
			for(int i=0; i<formBean.getStrIssueChkIndex().length; i++)
			{
				if(formBean.getStrIssueChkIndex()[i].equals("1"))
				{
					
				}
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueTransDATA.insertCancel --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->insert()", strmsgText);
		    	
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
		    

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}

	
	public static void getMmsConfigFlags(IssueTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) 
	{
//		IssueTransBO bo = null;
//		IssueTransVO vo = null;
		MmsConfigUtil mcu = null;
//		HisUtil util = null;
//		String strmsgText = null;
		
			
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
//			    //System.out.println("mcu.getStrWithOutCrNoFlg()==>"+mcu.getStrWithOutCrNoFlg());
//			    //System.out.println("mcu.getStrCrNoDefault()==>"+mcu.getStrCrNoDefault());
//			    //System.out.println("mcu.getStrDoseFrqFlg()==>"+mcu.getStrDoseFrqFlg());
	//		
				/*
				formBean.setStrWithOutCrNoFlg(mcu.getStrWithOutCrNoFlg());
				formBean.setStrCrNoDefault(mcu.getStrCrNoDefault());
				formBean.setStrDoseFrqFlg(mcu.getStrDoseFrqFlg());
				*/
				
				formBean.setStrWithOutCrNoFlg("1");
				formBean.setStrCrNoDefault("1");
				formBean.setStrDoseFrqFlg("0");

	}

	public static void getGenderCombo(IssueTransFB formBean,HttpServletRequest request) 
	{
		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strPatientGenderCodeCmbValues = "";
		String strmsgText = null;
		
		try {
			bo = new IssueTransBO();
			vo = new IssueTransVO();
			util = new HisUtil("MMS Transactions", "IssueTransDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getGenderCombo(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueTransDATA");
			
			strPatientGenderCodeCmbValues = util.getOptionValue(vo.getStrGenderWs(), "",	"", false);
						
			formBean.setStrPatientGenderCodeCmbValues(strPatientGenderCodeCmbValues);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueTransDATA.getDeptDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",	"IssueTransDATA->getGenderCombo()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	

public static String patientDiagDtl(String strCrNo,String strHospitalCode)
{
	IssueTransBO bo = new IssueTransBO();
	IssueTransVO vo	= new IssueTransVO();
	HisUtil util =  new HisUtil("MMS Transactions", "IssueTransDATA");	;
		StringBuffer sb = new StringBuffer("");
		vo.setStrCrNo(strCrNo);
		vo.setStrHospitalCode(strHospitalCode);
		
		WebRowSet ws = null;
		String diagName;
		
		sb.append("");
		
		try 
		{
			System.out.println("<------------- PKG_MMS_VIEW.proc_diag_emp_view [ Mode - 1 ] ------------->");
			
			bo.getPatientDiagDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		
			ws = vo.getDiagEmpWs();
			sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
			sb.append("<tr><td width='50%' class='LABEL' ><div align='center'>Diagnosis Name(Code)</div></td>");
			sb.append("<td width='50%' class='LABEL' ><div align='center'>Treatment Consultant</div></td></tr> ");
			if (ws != null && ws.size() > 0) 
			{
				
				while (ws.next()) 
				{
					diagName = ws.getString(1);
					String diagCode = ws.getString(2);
					String empName = ws.getString(3);
					String empcode = ws.getString(4);
							
					if (diagName == null)
						diagName = "----";
//					if (diagCode == null)
//						diagCode = "----";
					if (empName == null)
						empName = "----";
					if (empcode == null)
						empcode = "----";
					
					
					
					sb.append("<tr><td width='50%' class='CONTROL'><div align='center'>"+diagName+"(<b>"+diagCode+"</b>)</div>");
					sb.append("</td>");
					sb.append("<td width='50%' class='CONTROL'><div align='center'>");
					sb.append(empName);
					sb.append("<input type='hidden' name='strDiagCode' value='"+ diagCode + "'><input type='hidden' name='strEmpCode' value='"+ empcode + "'></div></td>");
					sb.append("</tr>");
//					sb.append("<tr><td width='25%' class='LABEL'>Diagnosis Code</td>");
//					sb.append("<td width='25%' class='CONTROL'> ");
//					sb.append(diagCode);
//					sb.append("</td></tr>");
					
				}
				
			}
			else
			{
				bo.getIcdList(vo);
				diagName = util.getOptionValue(vo.getDiagMstWs(), "0^Select Value", "Select Value", false);
				String empName = util.getOptionValue(vo.getEmpWs(), "0^Select Value", "Select Value", false);
				
				sb.append("<tr><td width='50%' class='CONTROL'><div align='center'><select name ='strDiagCode'  class='comboMax' onchange='' name=strDiagName >"+ diagName +"</select></div>");
				sb.append("</td>");
				sb.append("<td width='50%' class='CONTROL'><div align='center'><select name='strEmpCode' class='comboMax' onchange='' name=strDiagName >"+ empName +"</select></div>");
				sb.append("</td>");
				sb.append("</tr>");
			}
			sb.append("</table>");
		} 
		catch (Exception e) 
		{
			try {
				throw new Exception("RequestforLPPAtientDATA-->patientDtl-->"	+ e.getMessage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		finally 
		{
			if (ws != null) 
			{
				try {
					ws.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ws = null;
			}
		}
return sb.toString();
}


public static String patientDiagDtl_BS(String strCrNo,String strHospitalCode)
{
	IssueTransBO bo = new IssueTransBO();
	IssueTransVO vo	= new IssueTransVO();
	HisUtil util =  new HisUtil("MMS Transactions", "IssueTransDATA");	;
		StringBuffer sb = new StringBuffer("");
		vo.setStrCrNo(strCrNo);
		vo.setStrHospitalCode(strHospitalCode);
		
		WebRowSet ws = null;
		String diagName;
		
		sb.append("");
		
		try 
		{
			bo.getPatientDiagDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		
			ws = vo.getDiagEmpWs();
			
			if (ws != null && ws.size() > 0) 
			{
				
				while (ws.next()) 
				{
					diagName = ws.getString(1);
					String diagCode = ws.getString(2);
					String empName = ws.getString(3);
					String empcode = ws.getString(4);
							
					if (diagName == null)
						diagName = "----";
//					if (diagCode == null)
//						diagCode = "----";
					if (empName == null)
						empName = "----";
					if (empcode == null)
						empcode = "----";
					
					sb.append("<div class='row'>");
					sb.append("<div class='col-sm-6'>"+diagName+"(<b>"+diagCode+"</b>)</div>");
					sb.append("<div class='col-sm-6'>");
					sb.append(empName);
					sb.append("<input type='hidden' name='strDiagCode' value='"+ diagCode + "'><input type='hidden' name='strEmpCode' value='"+ empcode + "'></div></td>");
					sb.append("</div>");
//					sb.append("<tr><td width='25%' class='LABEL'>Diagnosis Code</td>");
//					sb.append("<td width='25%' class='CONTROL'> ");
//					sb.append(diagCode);
//					sb.append("</td></tr>");
					sb.append("</div>");
					
				}
				
			}
			else
			{
				bo.getIcdList(vo);
				diagName = util.getOptionValue(vo.getDiagMstWs(), "0^Select Value", "Select Value", false);
				String empName = util.getOptionValue(vo.getEmpWs(), "0^Select Value", "Select Value", false);
				sb.append("<div class='row mt-1' >");
				//sb.append("<div class='row'>");
				sb.append("<div class='col-sm-2'></div>");
				sb.append("<div class='col-sm-2'><label>Diagnosis Name(Code)</label></div>");
				//sb.append("</div>");
				sb.append("<div class='col-sm-4'><select name ='strDiagCode'  class='form-control' onchange='' name=strDiagName >"+ diagName +"</select></div>");
				sb.append("<div class='col-sm-2'><label>Treatment Consultant</label></div> ");
				sb.append("<div class='col-sm-2'><select name='strEmpCode' class='form-control' onchange='' name=strDiagName >"+ empName +"</select></div>");
				sb.append("</div>");

			}
			
		} 
		catch (Exception e) 
		{
			try {
				throw new Exception("RequestforLPPAtientDATA-->patientDtl-->"	+ e.getMessage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		finally 
		{
			if (ws != null) 
			{
				try {
					ws.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ws = null;
			}
		}
return sb.toString();
}


public static void getBilledItemDtls(IssueTransFB _IssueTransFB,HttpServletRequest request,HttpServletResponse response)
{
	 /* Declaring Variables */
       String strmsgText = "";
	   IssueTransVO vo = null;
	   IssueTransBO bo = null;
	   HisUtil util = null;
	   String strResult = "";
	   try
	   {
		    /* Creating Object */   	
		    vo=new IssueTransVO();
		   	bo=new IssueTransBO();
		   	util = new HisUtil("MMS Transactions", "IssueTransDATA");
		   	/* Value set in Value Object */
		   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		   	vo.setStrStoreId(request.getParameter("strStoreId"));
		   	vo.setStrIssueNo(request.getParameter("strIssueNo"));
		              
            /* Calling BO method */
		    bo.getBilledItemDtls(vo);
		    
		       strResult = IssueTransHLP.getBilledItemDtls(vo);

		    if(strResult!= null && !strResult.equals(""))
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	response.getWriter().print(strResult);
			 		 
			}
			else
			{
			    HisException eObj = new HisException("MMS", "IssueTransDATA->getViewDtl()", vo.getStrMsgString());
				       String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
		   
		   
	   }catch(Exception _err){
		   strmsgText = _err.getMessage();
			HisException eObj = new HisException("MMS", "IssueTransDATA->getViewDtl()", strmsgText);
			_IssueTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			//_IssueTransFB.setStrMsgType("1");
			eObj = null;
	   }
	   finally 
	   {
		    util = null;
			  bo = null;
			  vo = null;
		}
	   
}
public static void deleteIssueDtls(IssueTransFB _IssueTransFB,HttpServletRequest request,HttpServletResponse response)
{
	 /* Declaring Variables */
       String strmsgText = "";
	   IssueTransVO vo = null;
	   IssueTransBO bo = null;
	   HisUtil util = null;
	   String strResult = "";
	   try
	   {
		    /* Creating Object */   	
		    vo=new IssueTransVO();
		   	bo=new IssueTransBO();
		   	util = new HisUtil("MMS Transactions", "IssueTransDATA");
		   	/* Value set in Value Object */
		   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		   	vo.setStrStoreId(request.getParameter("strStoreId"));
		   	vo.setStrIssueNo(request.getParameter("strIssueNo"));
		  
            /* Calling BO method */
		    bo.deleteIssueDtls(vo);
		    
		   
		   
		   
	   }catch(Exception _err){
		   strmsgText = _err.getMessage();
			HisException eObj = new HisException("MMS", "IssueTransDATA->getViewDtl()", strmsgText);
			_IssueTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			//_IssueTransFB.setStrMsgType("1");
			eObj = null;
	   }
	   finally 
	   {
		    util = null;
			  bo = null;
			  vo = null;
		}
	   
}


public static void getTariffDtl(IssueTransFB _IssueTransFB,HttpServletRequest request,HttpServletResponse response)
{
	 /* Declaring Variables */
       String strmsgText = "";
	   IssueTransVO vo = null;
	   IssueTransBO bo = null;
	   HisUtil util = null;
	   String strResult="" ;
	   int i=0;
	   try
	   {
		    /* Creating Object */   	
		    vo=new IssueTransVO();
		   	bo=new IssueTransBO();
		   	util = new HisUtil("MMS Transactions", "IssueTransDATA");
		   	/* Value set in Value Object */
		   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		   	vo.setTariff(request.getParameter("itemTmp"));
	
		    bo.getTariffDtls(vo);
		    
		    if(vo.getStrTariffDtl().size() > 0)
		    {
		    	while(vo.getStrTariffDtl().next())
		    	{
		    		if(vo.getStrTariffDtl().getString(2).equals("0"))
		    		{
		    			if(i==0)
		    				strResult = vo.getStrTariffDtl().getString(1) ;
		    			else
		    				strResult += "," + vo.getStrTariffDtl().getString(1);
		    			i++;
		    		}
		    	}
		    }

		    if(strResult != "")
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	response.getWriter().print(strResult);
			 		 
			}
			else
			{
			    HisException eObj = new HisException("MMS", "IssueTransDATA->getTariffDtl()", vo.getStrMsgString());
				       String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
		   
		   
	   }catch(Exception _err){
		   strmsgText = _err.getMessage();
			HisException eObj = new HisException("MMS", "IssueTransDATA->getTariffDtl()", strmsgText);
			_IssueTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			//_IssueTransFB.setStrMsgType("1");
			eObj = null;
	   }
	   finally 
	   {
		    util = null;
			  bo = null;
			  vo = null;
		}
	   
}

}


