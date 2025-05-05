package mms.transactions.controller.data;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import billing.BillConfigUtil;
import billing.PrintHLP;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.utility.SMSSender.SMSHttpPostClientNew;
import ipd.IpdConfigUtil;
import mms.MmsConfigUtil;
import mms.patDtl.PatientDtlHLP;
import mms.patDtl.PatientDtlHLPNew;
import mms.transactions.bo.IssueToPatOPDTransBO;
import mms.transactions.controller.fb.IssueToPatOPDTransFB;
import mms.transactions.controller.hlp.IssueToPatOPDTransHLP;
import mms.transactions.vo.IssueToPatOPDTransVO;


public class IssueToPatOPDTransDATA {

//  private String   contents;
//   private String   rptContents;	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _IssueToPatOPDTransFB
	 * @param request
	 */
	
	public static int printLine = 0;
	public static void getViewDtl(IssueToPatOPDTransFB _IssueToPatOPDTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   IssueToPatOPDTransVO vo = null;
		   IssueToPatOPDTransBO bo = null;
		   HisUtil util = null;
		   String strResult = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new IssueToPatOPDTransVO();
			   	bo=new IssueToPatOPDTransBO();
			   	util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrItemCategoryNo(request.getParameter("itemCatNo"));
			   	vo.setStrCrNo(request.getParameter("crNo"));
			   //System.out.println("Flag==>"+request.getParameter("strFlagVal"));
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
			    
			       strResult = IssueToPatOPDTransHLP.getIssuedDetail(vo.getStrIssueDetailWs());

			    if(strResult!= null && !strResult.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "IssueToPatientBSDATA->getViewDtl()", vo.getStrMsgString());
					       String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueToPatientBSDATA->getViewDtl()", strmsgText);
				_IssueToPatOPDTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_IssueToPatOPDTransFB.setStrMsgType("1");
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
			HttpServletResponse response, IssueToPatOPDTransFB formBean) 
	{

		String strSearchItemInitView = "";
		//boolean printFlag = false;
		
		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;
		String strMode = "";
		String strStoreId = "";
		String strIssueNo = "";

		try {

			    strMode = (String) request.getParameter("strMode");
			 strStoreId = (String) request.getParameter("strStoreId");
			 strIssueNo = (String) request.getParameter("strIssueNo");			
			         bo = new IssueToPatOPDTransBO();
			         vo = new IssueToPatOPDTransVO();
			
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
				//System.out.println("Hidden Val==>"+formBean.getWsIssueDetails().getString(1));
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
			
			strSearchItemInitView = IssueToPatOPDTransHLP.getIssueDtlsInitView(formBean);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);

		} 
		catch (Exception e)
		{
			e.printStackTrace();
			 
			 String strmsgText = "IssueToPatientBSDATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA.issueDtlsInit(vo) --> ", strmsgText);
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
			HttpServletResponse response, IssueToPatOPDTransFB formBean) 
	{

		String strSearchItemInitView = "";

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;
		String strMode = "";
		String strStoreId = "";
		String strIssueNo = "";

		try {

			    strMode = (String) request.getParameter("strMode");
			 strStoreId = (String) request.getParameter("strStoreId");
			 strIssueNo = (String) request.getParameter("strIssueNo");			
			bo = new IssueToPatOPDTransBO();
			vo = new IssueToPatOPDTransVO();
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
//					   System.out.println("Store Name:::"+formBean.getWsIssueDetails().getString(4));
//					   System.out.println("setStrFinalRemarks:::"+formBean.getWsIssueDetails().getString(27));
//					   System.out.println("setStrItemWiseCost::"+formBean.getWsIssueDetails().getString(29));
//					   System.out.println("setStrIssueNo::::"+formBean.getWsIssueDetails().getString(1));
//					   System.out.println("setStrIssueDate:::"+formBean.getWsIssueDetails().getString(2));
//					   System.out.println("setStrPatientName:::"+formBean.getWsIssueDetails().getString(3));
//					   System.out.println("setStrCrNo:::"+formBean.getWsIssueDetails().getString(35));
								
				}
				
				formBean.getWsIssueDetails().beforeFirst();
			    strSearchItemInitView = IssueToPatOPDTransHLP.getIssueDtlsInitView(formBean);

			    response.setHeader("Cache-Control", "no-cache");
			    response.getWriter().print(strSearchItemInitView);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			 
			 String strmsgText = "IssueToPatientBSDATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;
			  
		}finally {

			bo = null;
			vo = null;
		}

	}
	
	public static void getStoreDtls(IssueToPatOPDTransFB formBean, HttpServletRequest request) 
	{
		IssueToPatOPDTransBO       bo = null;
		IssueToPatOPDTransVO       vo = null;
		
		HisUtil          util = null;
		
		String    strStoreVal = "";
		String 	strCatVal="";
		String     strmsgText = null;
		ResourceBundle resObj = null;
		SimpleDateFormat  sdf = null;
		Calendar           c1 = null;
		
		try 
		{
			               bo = new IssueToPatOPDTransBO();
			               vo = new IssueToPatOPDTransVO();
			             util = new HisUtil("MMS Transactions", "IssueToPatTransDATA");			
			              sdf = new SimpleDateFormat("dd-MMM-yyyy");
		                   c1 = Calendar.getInstance();	    
		    c1.add(Calendar.DATE,0);   // or  Calendar.DAY_OF_MONTH which is a synonym
		    //System.out.println("Date + 1 days is : " + sdf.format(c1.getTime()));			
			
			//String strCtDate = util.getASDate("dd-MMM-yyyy");
			
			String strConfCatCode = MmsConfigUtil.STAFF_CAT_CODE;
			formBean.setStrConfCatCode(strConfCatCode);
			vo.setStrConfCatCode(strConfCatCode);
			formBean.setStrCtDate(sdf.format(c1.getTime()));
			
			System.out.println("------------------STRMODE------------------"+request.getParameter("mode"));
			
			if(request.getParameter("mode") != null){
				String strMode = request.getParameter("mode");
				formBean.setStrMode(strMode);
				System.out.println("------------------STRMODE------------------"+strMode);
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
			
			System.out.println(" ----XX--- formBean.getStrStoreId()-- "+formBean.getStrStoreId());
			if(vo.getStrStoreWs()!=null && vo.getStrStoreWs().size()>0)
			{
				if((formBean.getStrStoreId()==null||formBean.getStrStoreId().equals("")))
				{
					strStoreVal = util.getOptionValue(vo.getStrStoreWs(),"","", false);
				}
				else
				{	
				    strStoreVal = util.getOptionValue(vo.getStrStoreWs(),formBean.getStrStoreId(),"0^Select Value", false);
				}
				
				//strStoreVal = util.getOptionValue(vo.getStrStoreWs(),formBean.getStrStoreId(),"0^Select Value", false);
			}
			else
			{
				strStoreVal = "<option value='0'>Select Value</option>";
			}
			
						
			formBean.setStrStoreValues(strStoreVal);			
			
			vo.setStrReqTypeId("32");
			
			
			strCatVal = "<option value='0'>Select Value</option>";
			
			formBean.setStrCatValues(strCatVal);	
			formBean.setStrOfflineOPDFlag(vo.getStrOfflineOPDFlag());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getStoreDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getStoreDtls()", strmsgText);
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
	public static void getStoreDtlsView(IssueToPatOPDTransFB formBean, HttpServletRequest request) {

		IssueToPatOPDTransBO bo       = null;
		IssueToPatOPDTransVO vo       = null;
		HisUtil util          = null;
		String strStoreVal    = "";
	
		String strmsgText     = null;
		/* C OUT RJ47
		 * ResourceBundle resObj = null; SimpleDateFormat sdf = null; Calendar c1 =
		 * null; String strConfCatCode = "";
		 */
		
		try 
		{
           bo = new IssueToPatOPDTransBO();
           vo = new IssueToPatOPDTransVO();
         util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");	
         
			
			
			if(request.getParameter("mode") != null)
			{
				String strMode = request.getParameter("mode");
				formBean.setStrMode(strMode);
			}
			
			vo.setStrMode(formBean.getStrMode());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			// Calling Bo Method
			
			/* ==For View Page== */
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
				strStoreVal = util.getOptionValue(vo.getStrStoreWs(), "","", false);
			}
			else
			{
				strStoreVal = "<option value='0'>Select Value</option>";
			}
						
			formBean.setStrStoreValues(strStoreVal);            			
			// Calling Bo Method
			
			/* ==For View Page== */
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
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getStoreDtlsView --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getStoreDtlsView()", strmsgText);
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
			/*C OUT RJ47
			 * resObj = null; sdf = null; c1 = null;
			 */
		}
	}
	
	public static void getGroupDetails(IssueToPatOPDTransFB formBean, HttpServletRequest request) {

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;

		HisUtil util = null;
		String strGroupVal = "";
		String strmsgText = null;
		
		try {
			bo = new IssueToPatOPDTransBO();
			vo = new IssueToPatOPDTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrItemCat(formBean.getItemCategory());
			
			bo.getStoreGroupDtls(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			
			strGroupVal = util.getOptionValue(vo.getStrGroupWs(), "0",
					"0^Select Value", false);
						
			formBean.setStrGroupValues(strGroupVal);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getGroupDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getGroupDetails()", strmsgText);
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
	
	public static void getItemCatDtls(IssueToPatOPDTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new IssueToPatOPDTransBO();
			voObj = new IssueToPatOPDTransVO();
			
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
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrItemCatWs().size() != 0) {
				
				//temp = util.getOptionValue(voObj.getStrItemCatWs(), "10", "0^Select Value",true);
				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^Select Value",true);


			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getItemCatDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getItemCatDtls()", strmsgText);
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
	
	public static void GET_PAT_ACC_STATUS(IssueToPatOPDTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String temp = "";
		try {

			bo = new IssueToPatOPDTransBO();
			voObj = new IssueToPatOPDTransVO();
			
			String strStoreId = request.getParameter("strId");
			String strCrNo    = request.getParameter("crNo");
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrCrNo(strCrNo);
						
			bo.GET_PAT_ACC_STATUS(voObj);

			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());

			}
			if(voObj.getStrAccDtl().next() && voObj.getStrAccDtl().size() > 0)
			{
				/*
	                0 -  Ac Balance
	                1 -  Patient Catg Code
	                2 -  ADMISSION_DATE
	                3 -  DISCHARGE_DATE
	                4 -  PATACCOUNT_STATUS in Text
	                5 -  HBLNUM_PATACCOUNT_STATUS 
	                6 -  GETCATGRP
	                7 -  HBLNUM_ACCOUNT_TYPE
	                8 -  hblnum_finalbill_flag
	            */
				 temp = voObj.getStrAccDtl().getString(1);
				
			}
			else
			{
				temp = "0@0@0@0@0@0@0@0@0@0";
			}
			
						
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatOPDTransDATA.GET_PAT_ACC_STATUS --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatOPDTransDATA->GET_PAT_ACC_STATUS()", strmsgText);
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
	public static int getissuetopatientcount(IssueToPatOPDTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		int temp =0;
		try {

			bo = new IssueToPatOPDTransBO();
			voObj = new IssueToPatOPDTransVO();
			
			voObj.setStrStoreId(formBean.getStrStoreId());
			voObj.setStrItemCat(formBean.getItemCategory());
			voObj.setStrCrNo(formBean.getStrCrNo());
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			
			bo.issueTopatientCount(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			

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
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getItemCatDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getItemCatDtls()", strmsgText);
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
	
	public static void getCancelPatientDetails(IssueToPatOPDTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response)
	{

		IssueToPatOPDTransBO          bo = null;
		IssueToPatOPDTransVO          vo = null;
		MmsConfigUtil        mcu = null;
	
		String        strmsgText = null;
		String strPatientDetails = "";
		String      strIssueMode = "";
		ResourceBundle    resObj = null;
		
		try 
		{
						    bo = new IssueToPatOPDTransBO();
						    vo = new IssueToPatOPDTransVO();
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
		//System.out.println("Issue No=[getCancelPatientDetails()]=>"+formBean.getStrIssueNo());		
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
		 strPatientDetails = IssueToPatOPDTransHLP.getPatientDtl(formBean);
		formBean.setStrPatientDetails(strPatientDetails);
		
		if (vo.getStrMsgType().equals("1")) 
		{
			throw new Exception(vo.getStrMsgString());
		}
				
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getCancelPatientDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getPatientDetails()", strmsgText);
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
	public static void getPatientDetails(IssueToPatOPDTransFB formBean, HttpServletRequest request, 
						HttpServletResponse response) {

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		ResourceBundle resObj =  null;
		
		try 
		{
			System.out.println("------------- IssueToPatOPDTransDATA . getPatientDetails ---------------");
			
			     bo = new IssueToPatOPDTransBO();
			     vo = new IssueToPatOPDTransVO();
			    mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   util = new HisUtil("","");
			
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			String strIssueMode = mcu.getStrIssueMode();
			formBean.setStrIssueMode("0");  // Please Check			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			vo.setStrCrNo(formBean.getStrCrNo());
			
			bo.getPatientAddmissionFlag(vo);
			
			formBean.setStrInvalidCrFlag(vo.getStrInvalidCrFlag());
			
			if(formBean.getStrInvalidCrFlag().equals("2")) 
			{
				throw new Exception("Invalid CR No");
			}
			
			System.out.println("------A------- getPatientCRStatus ---------------"+vo.getStrInvalidCrFlag());
			 
			String strPatientDetails = PatientDtlHLP.patientWithAdmissionDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode(), true);
			
			System.out.println("------B------- mms.patDtl.PatientDtlHLP.patientTreatmentDtl_OPD ---------------");	
		
			//String strPatientTreatmentDtl =  PatientDtlHLP.patientTreatmentDtl_Selection(formBean.getStrCrNo(), formBean.getStrHospitalCode());
		
			String strPatientTreatmentDtl =  PatientDtlHLP.patientTreatmentDtl_OPD(formBean.getStrCrNo(), formBean.getStrHospitalCode());
			
			//System.out.println("strPatientTreatmentDtl--------------"+strPatientTreatmentDtl);

			System.out.println("------D------- IssueToPatOPDTransDATA.patientDiagDtl ---------------");
			
			String strPatientDiagDetails = patientDiagDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode());			
			
			formBean.setStrPatientDetails(strPatientDetails);
			formBean.setStrPatientTreatmentDtl(strPatientTreatmentDtl);
			//formBean.setStrPatientTreatmentDtl_BS(strPatientTreatmentDtl_BS);
			formBean.setStrPatientDiagDetails(strPatientDiagDetails);
			bo.getLFAccountDetail(vo);
			
			
			
			System.out.println("------------- IssueToPatOPDTransDATA . getPatientDetails ------- END --------");
			
			formBean.setStrDoseFrqFlg("0");
		
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
					
		} catch (Exception e) 
		{
			e.printStackTrace();
			
			System.out.println("---e.getMessage()-----"+e.getMessage());
			
			
			if(e.getMessage().equals("Invalid CR No"))
			{
				System.out.println("--A-IN OUT-----");
				
				formBean.setStrErrMsg("Invalid CR. No./ Data Not Found");
				formBean.setStrInvalidCrFlag(vo.getStrInvalidCrFlag());	
				formBean.setStrCrNo(formBean.getStrHospitalCode());
					
			}			
			else if(e.getMessage().equals("Invalid CR. No."))
			{
				formBean.setStrErrMsg("Invalid CR. No. [ "+formBean.getStrCrNo()+" ]");
				formBean.setStrInvalidLFFlag("1");
			}
			else
			{
				strmsgText = "mms.transactions.IssueToPatientBSDATA.getPatientDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueToPatientBSDATA->getPatientDetails()", strmsgText);
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
	
	public static void getPatientStatus(IssueToPatOPDTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) 
	{

			IssueToPatOPDTransBO bo = null;
			IssueToPatOPDTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			ResourceBundle resObj =  null;
			
			try 
			{
			System.out.println("------------- IssueToPatOPDTransDATA . getPatientDetails ---------------");
			
			     bo = new IssueToPatOPDTransBO();
			     vo = new IssueToPatOPDTransVO();
			    mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   util = new HisUtil("","");
			
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			String strIssueMode = mcu.getStrIssueMode();
			formBean.setStrIssueMode("0");  // Please Check			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			vo.setStrCrNo(formBean.getStrCrNo());
			
			bo.getPatientCRStatus(vo);
			
			formBean.setStrInvalidCrFlag(vo.getStrInvalidCrFlag());
			
					
			
			System.out.println("------------- IssueToPatOPDTransDATA . getPatientStatus ------- END --------");
			
			formBean.setStrDoseFrqFlg("0");
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
					
			}
			catch (Exception e) 
			{
			e.printStackTrace();
			
			System.out.println("---e.getMessage()-----"+e.getMessage());
			
				strmsgText = "mms.transactions.IssueToPatientBSDATA.getPatientDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueToPatientBSDATA->getPatientDetails()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");
			
				eObj = null;
			
			}
			/*
			catch (Exception e) 
			{
			e.printStackTrace();
			
			System.out.println("---e.getMessage()-----"+e.getMessage());
			
			
			if(e.getMessage().equals("Invalid CR No"))
			{
				System.out.println("--A-IN OUT-----");
				
				formBean.setStrErrMsg("Invalid CR. No. [ "+formBean.getStrCrNo()+" ]");
				formBean.setStrInvalidCrFlag(vo.getStrInvalidCrFlag());	
				formBean.setStrCrNo(formBean.getStrHospitalCode());
					
			}			
			else if(e.getMessage().equals("Invalid CR. No."))
			{
				formBean.setStrErrMsg("Invalid CR. No. [ "+formBean.getStrCrNo()+" ]");
				formBean.setStrInvalidLFFlag("1");
			}
			else
			{
				strmsgText = "mms.transactions.IssueToPatientBSDATA.getPatientDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueToPatientBSDATA->getPatientDetails()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");
			
				eObj = null;
			}
			}*/
			 finally {
			
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
	
	


	
	public static void getOnlineReqDtl(IssueToPatOPDTransFB formBean, HttpServletRequest request, HttpServletResponse response) 
	{

			IssueToPatOPDTransBO bo = null;
			IssueToPatOPDTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
		
		try 
		{
			 System.out.println(" ------- IssueToPatientTransBSDATA.getOnlineReqDtl  ------- ");
			 
				bo = new IssueToPatOPDTransBO();
				vo = new IssueToPatOPDTransVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				String strIssueMode = mcu.getStrIssueMode();
				formBean.setStrIssueMode(strIssueMode);
				
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrCrNumber(formBean.getCrNo());
				
				String strOnlineIssueReqDays = mcu.getStrOnlineIssueDetailsInDays();
				vo.setStrOnlineIssueReqDays(strOnlineIssueReqDays);
				
				bo.getRequestDtls(vo);
									
				String strReqValues = IssueToPatOPDTransHLP.getRequestDtls(vo.getStrRequestWs());
				formBean.setStrReqValues(strReqValues);
				formBean.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
		if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
				strmsgText = "mms.transactions.IssueToPatientBSDATA.getOnlineReqDtl --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueToPatientBSDATA->getOnlineReqDtl()", strmsgText);
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
	
	public static void getItemDetails(IssueToPatOPDTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response ) {

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		String strItemDetails ="";
		
		try {
			
			 System.out.println(" ------- IssueToPatientTransBSDATA.getItemDetails  ------- ");
			 
			bo = new IssueToPatOPDTransBO();
			vo = new IssueToPatOPDTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			String strIssueMode = mcu.getStrIssueMode();
			formBean.setStrIssueMode(strIssueMode);
						
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrRequestNo(request.getParameter("reqNo"));
			vo.setStrCrNumber(request.getParameter("crNo"));
			vo.setStrStoreId(request.getParameter("strId"));		
			
			bo.getItemDetails(vo);
			
			strItemDetails = IssueToPatOPDTransHLP.getItemDetails(vo.getStrHospitalCode(),vo.getStrItemDetailWs());
			
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemDetails);	
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getItemDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getItemDetails()", strmsgText);
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
	
	public static void getIssuePopUp(IssueToPatOPDTransFB formBean, HttpServletRequest request, 
						HttpServletResponse response) {
			
			IssueToPatOPDTransBO bo    = null;
			IssueToPatOPDTransVO vo    = null;			
			
			String strmsgText  = null;			
			String strStoreId  = "";
			String strIssueNo  = "";
			String strHospCode = "";
			String strPopUp    = "";
			String strCrNo    = "";
			try 
			{
				 System.out.println(" ------- IssueToPatOPDTransDATA.getIssuePopUp  ------- ");
				 
				   bo = new IssueToPatOPDTransBO();
				   vo = new IssueToPatOPDTransVO();							
				   strHospCode = formBean.getStrHospitalCode();
				   strStoreId = formBean.getStrStoreId();
				   strIssueNo = formBean.getStrIssueNum();
				   strCrNo   = formBean.getStrCrNo();
				   
				 System.out.println(" strHospCode-----------------------"+strHospCode);
				 System.out.println(" strStoreId-----------------------"+strStoreId);
				 System.out.println(" strIssueNo-----------------------"+strIssueNo);

				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
				/*
				strPopUp = IssueToPatOPDTransHLP.getIssuePopUpBS(strHospCode,strStoreId,strIssueNo,strCrNo);
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strPopUp);	
				*/
				System.out.println(" ------- IssueToPatOPDTransHLP.getIssuePopUpForDotMatrix  ------- ");
				IssueToPatOPDTransHLP.getIssuePopUpForDotMatrix(strHospCode,strStoreId,strIssueNo,strCrNo,request);												
				String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
				formBean.setStrPrintBill(fileName);
				request.setAttribute("filePath", fileName);
				formBean.setIsOpenPopUp("1");
				
							
			} catch (Exception e) {
				strmsgText = "mms.transactions.IssueToPatientBSDATA.getIssuePopUp --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueToPatientBSDATA->getIssuePopUp()", strmsgText);
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
	
	public static void getIssuePopUp_ORG(IssueToPatOPDTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) {

		IssueToPatOPDTransBO bo    = null;
		IssueToPatOPDTransVO vo    = null;			
		
		String strmsgText  = null;			
		String strStoreId  = "";
		String strIssueNo  = "";
		String strHospCode = "";
		String strPopUp    = "";
		String strCrNo    = "";
		try 
		{
			 System.out.println(" ------- IssueToPatientTransBSDATA.getIssuePopUp  ------- ");
			 
			   bo = new IssueToPatOPDTransBO();
			   vo = new IssueToPatOPDTransVO();							
			   strHospCode = formBean.getStrHospitalCode();
			   strStoreId = request.getParameter("strId");
			   strIssueNo = request.getParameter("issueNo");
			   strCrNo   = request.getParameter("strCrNo");
			   
			 System.out.println(" strHospCode-----------------------"+strHospCode);
			 System.out.println(" strStoreId-----------------------"+strStoreId);
			 System.out.println(" strIssueNo-----------------------"+strIssueNo);
		
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			/*
			strPopUp = IssueToPatOPDTransHLP.getIssuePopUpBS(strHospCode,strStoreId,strIssueNo,strCrNo);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strPopUp);	
			*/
			
			IssueToPatOPDTransHLP.getIssuePopUpForDotMatrix(strHospCode,strStoreId,strIssueNo,strCrNo,request);												
			String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
			formBean.setStrPrintBill(fileName);
			request.setAttribute("filePath", fileName);
			formBean.setIsOpenPopUp("1");
			
						
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getIssuePopUp --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getIssuePopUp()", strmsgText);
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
	
	public static void getIssueDetails(IssueToPatOPDTransFB formBean, HttpServletRequest request, HttpServletResponse response)
		{
			
			IssueToPatOPDTransBO bo = null;
			IssueToPatOPDTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			WebRowSet ws = null;
			try {
				 System.out.println(" ------- IssueToPatientTransBSDATA.getIssueDetails  ------- ");
				 
				bo = new IssueToPatOPDTransBO();
				vo = new IssueToPatOPDTransVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				
				vo.setStrStoreId(request.getParameter("strId"));
				//vo.setStrCatCode(request.getParameter("itemCategory"));
				
				vo.setStrCrNum(request.getParameter("crNo"));
				//System.out.println(">>>>>>>>>>>>>>>>>>"+request.getParameter("crNo"));

				vo.setStrFromDate(request.getParameter("fromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
				
				vo.setStrIssueNo(request.getParameter("strIssueNo"));
				vo.setStrPrescribedBy(request.getParameter("prescribedBy"));				
				vo.setStrPatStaffDays(mcu.getStrLastIssuePatientStaffInDays());		
				
				
			   	
				// Calling BO Method --issue no issue date & store id 
				bo.getIssueDetail(vo);
				  
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				
				ws = vo.getStrIssueDetailWs(); 
			/*	while(ws.next())
				{
					System.out.println("ws.strings()"+ws.getString(1));
					System.out.println("ws.strings()"+ws.getString(2));
				//	System.out.println("ws.strings()"+ws.getString(3));
					
				}*/
			
				/* replace HLP method  getIssueDetailsBS >> getPreviousIssueDetails*/
			String strIssueDetails = IssueToPatOPDTransHLP.getPreviousIssueDetails(vo,ws);
				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strIssueDetails);
				
			} catch (Exception e) {
				strmsgText = "mms.transactions.IssueToPatientBSDATA.getIssueDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueToPatientBSDATA->getIssueDetails()", strmsgText);
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
	
	public static void getRequestDetails(IssueToPatOPDTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		WebRowSet ws = null;
		MmsConfigUtil mcu = null;
		
		try {
			 System.out.println(" ------- IssueToPatientTransBSDATA.getRequestDetails  ------- ");
			 
			bo = new IssueToPatOPDTransBO();
			vo = new IssueToPatOPDTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrRequestNo(request.getParameter("reqNo"));
			vo.setStrCrNumber(request.getParameter("crNo"));
			
			String strOnlineIssueReqDays = mcu.getStrOnlineIssueDetailsInDays();
			vo.setStrOnlineIssueReqDays(strOnlineIssueReqDays);
			
		//	//System.out.println("1-----"+vo.getStrOnlineIssueReqDays());
		//	//System.out.println("2-----"+vo.getStrRequestNo());
		//	//System.out.println("3----"+vo.getStrCrNumber());
			
			bo.getRequestDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
			ws = vo.getStrRequestDetailWs();
			
			String strRequestDetails=IssueToPatOPDTransHLP.getRequestDetails(ws);
			
			////System.out.println("strRequestDetails---------->"+strRequestDetails);
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strRequestDetails);
						
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getRequestDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getRequestDetails()", strmsgText);
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
	
	public static void getFrequencyDetails(IssueToPatOPDTransFB formBean, HttpServletRequest request) {

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;

		HisUtil util = null;
		String strFrequencyVal = "";
		String strmsgText = null;
		
		try {
			bo = new IssueToPatOPDTransBO();
			vo = new IssueToPatOPDTransVO();
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
						
			bo.getFrequencyDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			
			strFrequencyVal = util.getOptionValue(vo.getStrFrequencyWs(), "0",
					"0^Select Value", false);
						
			formBean.setStrFrequencyValues(strFrequencyVal);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getFrequencyDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getFrequencyDetails()", strmsgText);
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
	
	public static void getDoseDetails(IssueToPatOPDTransFB formBean, HttpServletRequest request) {

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;

		HisUtil util = null;
		String strDosageVal = "";
		String strmsgText = null;
		
		try {
			bo = new IssueToPatOPDTransBO();
			vo = new IssueToPatOPDTransVO();
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
						
			bo.getDoseDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			
			strDosageVal = util.getOptionValue(vo.getStrDosageWs(), "0",
					"0^Select Value", false);
			formBean.setStrDosageValues(strDosageVal);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getDoseDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getDoseDetails()", strmsgText);
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
	
	public static void getDeptDetails(IssueToPatOPDTransFB formBean, HttpServletRequest request) {

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;

		HisUtil util = null;
		String strDeptVal = "";
		String strmsgText = null;
		
		try {
			 System.out.println(" ------- IssueToPatientTransBSDATA.getDeptDetails  ------- ");
			 
			bo = new IssueToPatOPDTransBO();
			vo = new IssueToPatOPDTransVO();
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getDeptDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			
			strDeptVal = util.getOptionValue(vo.getStrDepartmentWs(), "",
					"0^Select Value", false);
						
			formBean.setStrDeptValues(strDeptVal);
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getDeptDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getDeptDetails()", strmsgText);
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
	
	public static void getUnitDetails(IssueToPatOPDTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new IssueToPatOPDTransBO();
			vo = new IssueToPatOPDTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			vo.setStrDeptCode(request.getParameter("deptCode"));
			
			
			bo.getUnitDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
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
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getUnitDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getUnitDetails()", strmsgText);
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
	
	public static void getUnitDetails1(IssueToPatOPDTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new IssueToPatOPDTransBO();
			vo = new IssueToPatOPDTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
				vo.setStrDeptCode("134");
				
			
			
			
			bo.getUnitDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
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
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getUnitDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getUnitDetails()", strmsgText);
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
	public static void getPrescribedBy(IssueToPatOPDTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new IssueToPatOPDTransBO();
			vo = new IssueToPatOPDTransVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrUnitCode(request.getParameter("unitCode"));
//	System.out.println("vo.getStrUnitCode"+vo.getStrUnitCode());		
			bo.getPrescribedBy(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
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
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getPrescribedBy --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getPrescribedBy()", strmsgText);
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
	
	
	public static void insert(IssueToPatOPDTransFB formBean, HttpServletRequest request) {

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		String[] temp = null;
		String[] strtemp = null;
		
		MmsConfigUtil mcu = null;
		
		int debugPoint = 0;
				
		try {
			 System.out.println(" ------- IssueToPatientTransBSDATA.insert  ------- ");
			 
			debugPoint = 1;
			bo = new IssueToPatOPDTransBO();
			vo = new IssueToPatOPDTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			
			//System.out.println("in issue mode 1 in data");
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
			
			vo.setStrStoreId(formBean.getStrStoreId());
			//vo.setStrItemCat("10");		
			vo.setStrItemCat(formBean.getItemCategory());		//		
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
			
			
			vo.setStrVisitType(formBean.getStrVisitType());
			bo.insert(vo);
			debugPoint = 7;			
			
			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());
			else 
			{
					formBean.setStrNormalMsg("Data Saved Successfully");
					formBean.setStrIssueNum(vo.getStrIssueNumber());
					formBean.setStrVisitDtl("1");
					
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientBSDATA.insertWithoutCrNo()--> "+e.getMessage() + String.valueOf(" :: Debug Point = " + debugPoint);
			//HisException eObj = new HisException("mms","IssueToPatientBSDATA->insertWithoutCrNo()",strmsgText,request);
			
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
	


	public static void insertCancel(IssueToPatOPDTransFB formBean, HttpServletRequest request) 
	{

		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;		
			
		try 
		{
			bo = new IssueToPatOPDTransBO();
			vo = new IssueToPatOPDTransVO();			
			
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrCrNum(formBean.getStrCrNo());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIssueNo(formBean.getStrIssueNo());			

			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientBSDATA.insertCancel --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->insert()", strmsgText);
		    	
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

	
	public static void getMmsConfigFlags(IssueToPatOPDTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) 
	{
//		IssueToPatOPDTransBO bo = null;
//		IssueToPatOPDTransVO vo = null;
		MmsConfigUtil mcu = null;
//		HisUtil util = null;
//		String strmsgText = null;
		
			
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
//			    System.out.println("mcu.getStrWithOutCrNoFlg()==>"+mcu.getStrWithOutCrNoFlg());
//			    System.out.println("mcu.getStrCrNoDefault()==>"+mcu.getStrCrNoDefault());
//			    System.out.println("mcu.getStrDoseFrqFlg()==>"+mcu.getStrDoseFrqFlg());
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

	public static void getGenderCombo(IssueToPatOPDTransFB formBean,HttpServletRequest request) 
	{
		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;

		HisUtil util = null;
		String strPatientGenderCodeCmbValues = "";
		String strmsgText = null;
		
		try {
			bo = new IssueToPatOPDTransBO();
			vo = new IssueToPatOPDTransVO();
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getGenderCombo(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			
			strPatientGenderCodeCmbValues = util.getOptionValue(vo.getStrGenderWs(), "",	"", false);
						
			formBean.setStrPatientGenderCodeCmbValues(strPatientGenderCodeCmbValues);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getDeptDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",	"IssueToPatientBSDATA->getGenderCombo()", strmsgText);
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
		IssueToPatOPDTransBO bo = new IssueToPatOPDTransBO();
		IssueToPatOPDTransVO vo	= new IssueToPatOPDTransVO();
		HisUtil util =  new HisUtil("MMS Transactions", "IssueToPatientBSDATA");	;
			StringBuffer sb = new StringBuffer("");
			vo.setStrCrNo(strCrNo);
			vo.setStrHospitalCode(strHospitalCode);
			
			WebRowSet ws = null;
			String diagName;
			
			sb.append("");
			
			try 
			{
				 System.out.println(" ------- IssueToPatientTransBSDATA.patientDiagDtl  ------- ");
				 
				bo.getPatientDiagDetails(vo);
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
			
				ws = vo.getDiagEmpWs();
				
				sb.append("<table class='table'>");
				sb.append("<thead>");
				sb.append("<tr>");							
				sb.append("<th align='center' style='width:50%;text-align: center !important;'><b>Diagnosis Name(Code)</b></th>");			
				sb.append("<th align='center' style='width:50%;text-align: center !important;'><b>Treatment Consultant</b></th>");
				sb.append("</tr>");
				sb.append("</thead>");			
			
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
						if (empName == null)
							empName = "----";
						if (empcode == null)
							empcode = "----";
						
						sb.append("<tbody>");	
						sb.append("<tr>");
						sb.append("<td   style='width:50%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;'>");
						sb.append(diagName+"(<b>"+diagCode+")");
						sb.append("</td>");
						
						sb.append("<td   style='width:50%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;'>");
						sb.append(empName);
						sb.append("<input type='hidden' name='strDiagCode' value='"+ diagCode + "'><input type='hidden' name='strEmpCode' value='"+ empcode + "'></div>");
						sb.append("</td>");												
					}
					
				}
				else
				{
					bo.getIcdList(vo);
					diagName = util.getOptionValue(vo.getDiagMstWs(), "0^Select Value", "Select Value", false);
					String empName = util.getOptionValue(vo.getEmpWs(), "0^Select Value", "Select Value", false);
					
					sb.append("<tbody>");	
					sb.append("<tr>");
					
					sb.append("<td style='width:50%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;'><div align='center'><select name ='strDiagCode'  class='comboMax' onchange='' name=strDiagName >"+ diagName +"</select></div>");
					sb.append("</td>");
					sb.append("<td style='width:50%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;'><div align='center'><select name='strEmpCode' class='comboMax' onchange='' name=strDiagName >"+ empName +"</select></div>");
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
					try 
					{
						ws.close();
					} 
					catch (SQLException e) 
					{
					    e.printStackTrace();
					}
					ws = null;
				}
			}
	       return sb.toString();
	}


	
	
	
	public static void getOnlineTreatmentDtl(IssueToPatOPDTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{
	
			IssueToPatOPDTransBO bo = null;
			IssueToPatOPDTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
		
		try 
		{
			 System.out.println(" ------- IssueToPatientTransBSDATA.getOnlineTreatmentDtl  ------- ");
				bo = new IssueToPatOPDTransBO();
				vo = new IssueToPatOPDTransVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				String strIssueMode = mcu.getStrIssueMode();
				formBean.setStrIssueMode(strIssueMode);
				
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				//vo.setStrCrNumber(formBean.getStrCrNo());
				
				formBean.setStrStoreId(request.getParameter("storeId"));
				formBean.setStrCrNo(request.getParameter("strCrNum"));
				formBean.setStrEpisodeCode(request.getParameter("episodeDtl"));
				formBean.setStrDeptCode(request.getParameter("deptID"));
				formBean.setStrUnitCode(request.getParameter("strDeptUnit"));
				
				String strOnlineIssueReqDays = mcu.getStrOnlineIssueDetailsInDays();
				vo.setStrOnlineIssueReqDays(strOnlineIssueReqDays);
				
				bo.getTreamentDtls(formBean,vo);
				int  rowcount=vo.getOnlineTreatmentDtlsWs().size();		
				String strReqValues = IssueToPatOPDTransHLP.getOnlineTreatmentDtls(vo.getOnlineTreatmentDtlsWs() , formBean);
				formBean.setStrOnlineTreatment(strReqValues);
				
				
				
				formBean.setStrRowCount(String.valueOf(rowcount));
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strReqValues + "##" + String.valueOf(rowcount)+"##");
				
		if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
				e.printStackTrace();
				strmsgText = "mms.transactions.IssueToPatientBSDATA.getOnlineReqDtl --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueToPatientBSDATA->getOnlineReqDtl()", strmsgText);
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
	
	public static void getBilledItemDtls(IssueToPatOPDTransFB _IssueToPatOPDTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	      String strmsgText = "";
		   IssueToPatOPDTransVO vo = null;
		   IssueToPatOPDTransBO bo = null;
		   HisUtil util = null;
		   String strResult = "";
		   try
		   {
			   System.out.println(" ------- IssueToPatientTransBSDATA.getBilledItemDtls  ------- ");
			   
			    /* Creating Object */   	
			    vo=new IssueToPatOPDTransVO();
			   	bo=new IssueToPatOPDTransBO();
			   	util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreId(request.getParameter("strStoreId"));
			   	vo.setStrIssueNo(request.getParameter("strIssueNo"));
			   
	           /* Calling BO method */
			    bo.getBilledItemDtls(vo);
			    
			       strResult = IssueToPatOPDTransHLP.getBilledItemDtls(vo);
	
			    if(strResult!= null && !strResult.equals(""))
			    	
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "IssueToPatientBSDATA->getViewDtl()", vo.getStrMsgString());
					       String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueToPatientBSDATA->getViewDtl()", strmsgText);
				_IssueToPatOPDTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_IssueToPatOPDTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}

	public static void save(IssueToPatOPDTransFB _IssueToPatOPDTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	      String strmsgText = "";
		   IssueToPatOPDTransVO vo = null;
		   IssueToPatOPDTransBO bo = null;
		   HisUtil util = null;
		   String strResult = "";
		   try
		   {
			   System.out.println(" ------- IssueToPatientTransBSDATA.save  ------- ");
			   
			    /* Creating Object */   	
			    vo=new IssueToPatOPDTransVO();
			   	bo=new IssueToPatOPDTransBO();
			   	util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreId(_IssueToPatOPDTransFB.getStrStoreId());
			   	vo.setStrIssueNo(_IssueToPatOPDTransFB.getStrHiddenIssueNo());
			   	vo.setStrCrNo(_IssueToPatOPDTransFB.getCrNo());
			   
	           /* Calling BO method */
			    bo.save(vo);		
			    _IssueToPatOPDTransFB.setStoreId(vo.getStrStoreId());
			    if(vo.getStrMsgType().equals("1"))
			    {
			   
			      _IssueToPatOPDTransFB.setStrErrMsg("In-Sufficent Stock Available In Store");
			   
			    }
			    else
			    {
			    
			    }
			   
		   }catch(Exception _err){
			   _err.printStackTrace();
			   _IssueToPatOPDTransFB.setStrNormalMsg("Data Saved Successfully");
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueToPatientBSDATA->getViewDtl()", strmsgText);
				_IssueToPatOPDTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_IssueToPatOPDTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}


	public static void deleteIssueDtls(IssueToPatOPDTransFB _IssueToPatOPDTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	      String strmsgText = "";
		   IssueToPatOPDTransVO vo = null;
		   IssueToPatOPDTransBO bo = null;
		   HisUtil util = null;
		   String strResult = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new IssueToPatOPDTransVO();
			   	bo=new IssueToPatOPDTransBO();
			   	util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreId(request.getParameter("strStoreId"));
			   	vo.setStrIssueNo(request.getParameter("strIssueNo"));
			   	
	           
	           /* Calling BO method */
			    bo.deleteIssueDtls(vo);
			    
			   
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueToPatientBSDATA->getViewDtl()", strmsgText);
				_IssueToPatOPDTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_IssueToPatOPDTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}


	public static void getTariffDtl(IssueToPatOPDTransFB _IssueToPatOPDTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	      String strmsgText = "";
		   IssueToPatOPDTransVO vo = null;
		   IssueToPatOPDTransBO bo = null;
		   HisUtil util = null;
		   String strResult="" ;
		   int i=0;
		   try
		   {
			   System.out.println(" ------- IssueToPatientTransBSDATA.getTariffDtl  ------- ");
			   
			    /* Creating Object */   	
			    vo=new IssueToPatOPDTransVO();
			   	bo=new IssueToPatOPDTransBO();
			   	util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setTariff(request.getParameter("itemTmp"));
		
			    bo.getTariffDtls(vo);
			    
			    if(vo.getStrTariffDtl().size() > 0)
			    {
			    	while(vo.getStrTariffDtl().next())
			    	{
			    		if(vo.getStrTariffDtl().getString(2).equals("0"))     //Tariff Count is 0 i.e. Tariff not mapped
			    		{
			    			if(i==0)
			    				strResult = vo.getStrTariffDtl().getString(1) ;
			    			else
			    				strResult += "," + vo.getStrTariffDtl().getString(1);
			    			i++;
			    		}
			    	}
			    }
	
			    response.setHeader("Cache-Control", "no-cache");
			    response.getWriter().print(strResult);  // if strResult is zero blank will be set
						   
			   
		   }catch(Exception _err){
			   _err.printStackTrace();
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueToPatientBSDATA->getTariffDtl()", strmsgText);
				_IssueToPatOPDTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_IssueToPatOPDTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}


	public static void getAlreadyIssueDrug(IssueToPatOPDTransFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
	
	
		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
	
	try 
	{
		System.out.println(" ------- IssueToPatientTransBSDATA.getAlreadyIssueDrug  ------- ");
		
			bo = new IssueToPatOPDTransBO();
			vo = new IssueToPatOPDTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			String strIssueMode = mcu.getStrIssueMode();
			formBean.setStrIssueMode(strIssueMode);
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			//vo.setStrCrNumber(formBean.getStrCrNo());
			vo.setTariff(request.getParameter("itemTmp"));
			vo.setStrStoreId(request.getParameter("storeId"));
			formBean.setStrCrNo(request.getParameter("strCrNum"));
			formBean.setStrEpisodeCode(request.getParameter("episodeDtl"));
			//formBean.setStrDeptCode(request.getParameter("deptID"));
			//formBean.setStrUnitCode(request.getParameter("strDeptUnit"));
			
			String strOnlineIssueReqDays = mcu.getStrOnlineIssueDetailsInDays();
			vo.setStrOnlineIssueReqDays(strOnlineIssueReqDays);
			
			bo.getAlreadyIssueDrug(formBean, vo);		
			
			StringBuffer sb=new StringBuffer();
			if(vo.getAlreadyIssueDrug().size()>0) {
				while (vo.getAlreadyIssueDrug().next()) {
					sb.append(vo.getAlreadyIssueDrug().getString(2) +"\n");
					
				}
			}
		//	formBean.setStrRowCount(String.valueOf(rowcount));
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(sb.toString());
			
	if (vo.getStrMsgType().equals("1")) {
			throw new Exception(vo.getStrMsgString());
		}
			
	} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientBSDATA.getOnlineReqDtl --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->getOnlineReqDtl()", strmsgText);
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

  public static void getDiirecIssueInitData(IssueToPatOPDTransFB formBean, HttpServletRequest request,HttpServletResponse response) 
  {
	// TODO Auto-generated method stub
	
	   IssueToPatOPDTransVO vo = null;
	   IssueToPatOPDTransBO bo = null;
	   HisUtil util = null;
	   String strCatVal=null;
	   String strStoreVal=null;
	   String strPayModeVal=null;
	   String strAdmDtl=null;
	   String strIssueByCombo=null;
	   try
	   {
	    	 
	    	    System.out.println(" ------- IssueToPatOPDTransDATA.getDiirecIssueInitData  ------- ");
	    	 	vo=new IssueToPatOPDTransVO();
			   	bo=new IssueToPatOPDTransBO();
			   	util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	
			   	vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrCrNo(formBean.getStrCrNo());
								
				vo.setStrStoreId(formBean.getStrStoreId());
				
				// Calling Bo Method
				bo.getStoreDtlsBS(vo);
				//bo.getAccDtl(vo);
				System.out.println(" ------- PatientDtlHLPNew.admissionAccDtl  ------- ");
				
				strAdmDtl=PatientDtlHLPNew.admissionAccDtl(formBean.getStrCrNo(), vo.getStrHospitalCode());
				
			
				if(strAdmDtl.trim().equals(""))
					formBean.setStrPatStatus("1");
				else
					formBean.setStrPatStatus("2");
					
				formBean.setStrAdmDtl(strAdmDtl);
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
			
				if(vo.getStrStoreWs()!=null && vo.getStrStoreWs().size()>0)
				{
					strStoreVal = util.getOptionValue(vo.getStrStoreWs(),formBean.getStrStoreId(),"0^Select Value", false);
				}
				else
				{
					strStoreVal = "<option value='0'>Select Value</option>";
				}
							
				formBean.setStrStoreValues(strStoreVal);	
				
				if(vo.getStrPrescFormValues()!=null && vo.getStrPrescFormValues().size()>0)
				{
					strIssueByCombo = util.getOptionValue(vo.getStrPrescFormValues(),"","0^Select Value", false);
				}
				else
				{
					strIssueByCombo = "<option value='0'>Select Value</option>";
				}
				
		
				bo.getItemCatDtls(vo);
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
			
				if(vo.getStrItemCatWs()!=null && vo.getStrItemCatWs().size()>0)
				{
					strCatVal = util.getOptionValue(vo.getStrItemCatWs(),"","0^Select Value", false);
				}
				else
				{
					strCatVal = "<option value='0'>Select Value</option>";
				}
				
							
				formBean.setStrCatValues(strCatVal);
				
				formBean.setStrIssueByCombo(strIssueByCombo);
				
				/********************* Drug Name Combo For Add ************************/
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
			
				String strItemNameValues = "";
				
				if (vo.getStrBrandItemListWs()!= null && vo.getStrBrandItemListWs().size() > 0) 
				{				   
					strItemNameValues = util.getOptionValue(vo.getStrBrandItemListWs(), "", "", true);
				}
				else 
				{
					strItemNameValues = "<option value='0'>Select Value</option>";
				}
				
				//System.out.println("strItemNameValues---->"+strItemNameValues);	
				
				formBean.setStrItemNameValues(strItemNameValues);				
								
				System.out.println(" ------- getPayMode ------- ");
				bo.getPayMode(vo);
				strPayModeVal = util.getOptionValue(vo.getStrPayMode(),"","", false);
				
				formBean.setStrPayModeValues(strPayModeVal);
			   	
			 
		   
		   
		   
	   }catch(Exception _err){
			HisException eObj = new HisException("MMS", "IssueToPatientBSDATA->getTariffDtl()", _err.getMessage());
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
	   }
	   finally 
	   {
		   	  util = null;
			  bo = null;
			  vo = null;
		}
	
}

public static void getReqType(IssueToPatOPDTransFB fb, HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	
    String strmsgText = "";
	   IssueToPatOPDTransVO vo = null;
	   IssueToPatOPDTransBO bo = null;
	   HisUtil util = null;
	   String temp="";

	   try
	   {
		    /* Creating Object */   	
		    vo=new IssueToPatOPDTransVO();
		   	bo=new IssueToPatOPDTransBO();
		   	
		   	util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
		   	/* Value set in Value Object */
		   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		   	vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrItemCat("10");
			
			System.out.println(" request.getParameter(strStoreId)----- "+request.getParameter("storeId"));		       
		   
		        
					
		    bo.getReqType(vo);
		    
		
		    temp=util.getOptionValue(vo.getStrReqTypeWs(),"32^10","0^Select Value", false);

			 	response.setHeader("Cache-Control", "no-cache");
			 	response.getWriter().print(temp);
			 		 
			
		
		   
		   
	   }catch(Exception _err){
		   strmsgText = _err.getMessage();
			HisException eObj = new HisException("MMS", "IssueToPatientBSDATA->getReqType()", strmsgText);
			fb.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			//_IssueToPatOPDTransFB.setStrMsgType("1");
			eObj = null;
	   }
	   finally 
	   {
		    util = null;
			  bo = null;
			  vo = null;
		}
	   
	
}

public static void DIRECTISSUE_OFFLINE(IssueToPatOPDTransFB formBean, HttpServletRequest request) 
{

	IssueToPatOPDTransBO bo = null;
	IssueToPatOPDTransVO vo = null;

	HisUtil util = null;
	String strmsgText = null;
	String[] temp = null;
	String[] strtemp = null;
	
	String[] patDtl = null;
	String[] patAdmissionDtl = null;
	
	MmsConfigUtil mcu = null;
	HisUtil hisUtil = null;
	int debugPoint = 0;
	IpdConfigUtil ipdC=new IpdConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
	try 
	{
		debugPoint = 1;
		bo = new IssueToPatOPDTransBO();
		vo = new IssueToPatOPDTransVO();
		
		mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		hisUtil = new HisUtil("MMS", "DirectPharmacy");
		
		formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
		formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
		
		//System.out.println("in issue mode 1 in data");
		vo.setStrReqQty(formBean.getStrReqQty());
		vo.setStrUnitName(formBean.getStrUnitName());
		vo.setItemParamValue(formBean.getItemParamValue());
		vo.setStrReqEmpNo("0");
		vo.setStrReqPatCatCode("0");
		vo.setStrReqAdmNo("0");
		vo.setStrReqWardCode("0");
		vo.setStrPatientType("18");
		vo.setStrReqType(formBean.getStrRequestType());
		
		debugPoint = 2;
		
		vo.setStrPrescribedBy("0");
	    vo.setStrReqPrescribedBy("0");
		vo.setStrPatientName(formBean.getStrPatientName());
		vo.setStrPatientId((formBean.getCrNo()!=null && !formBean.getCrNo().equals("0")) ?formBean.getCrNo() : "0");
		vo.setStrHospitalCode(formBean.getStrHospitalCode());
		vo.setStrSeatId(formBean.getStrSeatId());
		
		debugPoint = 3;
		
		vo.setStrStoreId(formBean.getStrStoreId());		
		//vo.setStrItemCat(formBean.getStrItemCat());
		//vo.setStrCatgoryCode(formBean.getStrItemCat());
		vo.setStrIssueMode("0");
		vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
		vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
		vo.setStrReceiveBy(formBean.getStrReceiveBy());
		vo.setStrPuk(formBean.getCrNo());
		vo.setStrRemarks(formBean.getStrRemarks());
		vo.setStrCostFinal(formBean.getStrCostFinal());
		vo.setStrApproxAmt(formBean.getStrApproxAmt());
		//vo.setStrEpisodeCode(formBean.getStrOffLineEpisode());
		
		debugPoint = 4;
				
		vo.setStrReqTypeId("32");
		
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
		
		vo.setStrPayModeVal(formBean.getStrPayMode());
		vo.setStrPayDtlVal(formBean.getStrPayDtl());	
		vo.setStrNetCost(formBean.getStrNetCost());
		vo.setItemCalcValue(formBean.getItemCalcValue());
		vo.setItemParamValue(formBean.getItemParamValue());
		vo.setItemUserValue(formBean.getItemUserValue());
		
		vo.setStrOutOfStockFlag("0");
		
		debugPoint = 6;
		
		vo.setStrDeptCode("0");
		vo.setStrAdmissionDtlHidVal(formBean.getStrAdmissionDtlHidVal());
		
		
		
		bo.getOPDPatientDtls(vo);
		
		/*
		 * 
		  String[] temp = = vo.getStrOPDDetails().split("\\$");
		   1 
		     $'||v_patient_status_code||'$'||v_HGNUM_PATIENT_CAT_CODE
		  ||'$'||v_hrgnum_episode_code||'$'||v_hrgnum_visit_no
		  ||'$'||v_gnum_dept_code  ||'$'||v_gnum_deptunit_code
		  ||'$'||v_hipnum_admno||'$'||AHIS_FUNCTION.getDeptName(v_gnum_dept_code,hosp_code) ||'$'|| Patient Mobile No;
		  
		   '2 $'||v_patient_status_code||'$'||v_reg_cat_code||'$'||'IPD Patient Cr No ['||crno||'] Not Allowed !!';
		   
		  */
		temp = vo.getStrOPDDetails().split("\\$");
		
		formBean.setStrDeptName(temp[8]);
		formBean.setStrPatMobileNo(temp[9]);
		
		//vo.setStrOPDDetails
		
		if (temp[0].equals("2"))
		{	
			throw new Exception(temp[3]);
		}		
		
		//vo = ( IssueToPatOPDTransVO) TransferObjectFactory.populateData("mms.transactions.vo.IssueToPatOPDTransVO",	formBean);
		
		
		bo.DIRECTISSUE_OFFLINE(vo);		
		
		debugPoint = 7;			
		
		if (vo.getStrMsgType().equals("1"))
			throw new Exception(vo.getStrMsgString());
		else 
		{
				formBean.setStrNormalMsg("Drug Successfully Dispensing To CrNo [ "+vo.getStrPuk()+" ] ");
				formBean.setStrIssueNum(vo.getStrIssueNumber());
				formBean.setStrVisitDtl("1");				
				formBean.setStrStoreId(vo.getStrStoreId());		
				formBean.setStrItemCat("10");
				formBean.setStrCatgoryCode("10");
				formBean.setStrIssueMode("0");				
				formBean.setStrCrNo(vo.getStrPuk());				
				formBean.setStrCostFinal(vo.getStrCostFinal());
				formBean.setStrApproxAmt(vo.getStrApproxAmt());
				formBean.setStrPayDtl(vo.getStrPayDtlVal());				
				formBean.setStrAdmissionDtlHidVal(vo.getStrAdmissionDtlHidVal());				
				formBean.setStrDeptName(temp[8]);
				formBean.setStrPatientDtlHidVal(vo.getStrPatientDtlHidVal());
				formBean.setStrPatientHiddenValue1(vo.getStrPatientHiddenValue1());
				/*
				System.out.println("---------------------------------------------------------------");
				System.out.println("getStrAdmissionDtlHidVal----"+formBean.getStrAdmissionDtlHidVal());
				System.out.println("getStrPatientHiddenValue1----"+formBean.getStrPatientHiddenValue1());
				System.out.println("getStrPatientDtlHidVal----"+formBean.getStrPatientDtlHidVal());
				System.out.println("getStrDrugIssueDate----"+formBean.getStrDrugIssueDate());
				System.out.println("getStrDeptName----"+formBean.getStrDeptName());
				System.out.println("getStrDeptNametemp[8]----"+temp[8]);
				System.out.println("getStrPatMobileNo----"+formBean.getStrPatMobileNo());
				System.out.println("---------------------------------------------------------------");
				*/
				
				patDtl          = formBean.getStrPatientDtlHidVal().split("\\^");
				patAdmissionDtl = formBean.getStrAdmissionDtlHidVal().split("\\^");
				
				/* vo.getStrPatientDtlHidVal()
				 getStrPatientDtlHidVal----08-jun-1987^F^1^11^0^0^^Anshul^Ramesh^NA^36 Yr/Female^0^0^9891925158^0^All India Institute of Medical Sciences, Mangalagiri^0^08-JUN-2022 12:13:26^^NO^37913^- 
				*/				
				
				String smsOrgMsg1 = "Dear "+patDtl[7]+","+vo.getItemParamValue().length+" number of items are issued successfully on "+hisUtil.getASDate("dd-MMM-yyyy")+" to CR Number:"+formBean.getStrCrNo()+". In case above item has not been requested ,kindly inform EHS Pharmacy immediately. AIIMS Jodhpur";

				String smsOrgMsg = "Dear "+patDtl[7]+","+formBean.getStrDeptName()+" prescribed "+vo.getItemParamValue().length+" medicine/item/s are issued successfully on "+hisUtil.getASDate("dd-MMM-yyyy")+" at - with CR Number:"+formBean.getStrCrNo()+". In case above medicine/item/s has not been requested by you; kindly inform EHS Pharmacy immediately.-AIIMS Jodhpur.";
				System.out.println("SMS_MSG--To--"+formBean.getStrPatMobileNo()+"--"+smsOrgMsg);
				
				String strBillNo=vo.getStrBillNo();
				//String strBillNo="0";
				Map tariffPrintMap=null;
								
				String patMobileNo=formBean.getStrPatMobileNo();
			//	String smsMsg1=formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[7]+"^"+formBean.getStrOfflineTotalRecAmount()+"^"+formBean.getStrBillNo()+"/1";
				
				 String templateid = "34";
				 /*
				 if(patMobileNo!=null && !patMobileNo.equals(""))
					
					new Thread( new Runnable() {
				           public void run(){

				        	   SMSHttpPostClientNew.sendSMS (patMobileNo,smsOrgMsg,templateid,formBean.getStrHospitalCode());

				          return; // to stop the thread
				                          }
				         }).start();
				        */ 
				
				if(formBean.getStrPatStatus().equals("1")) 
				{
				
					System.out.println("PatStatus------[ PrintHLP.OPD_SERVICES ]-------"+strBillNo+"----------------->  1");
					PrintHLP.OPD_SERVICES(strBillNo, "5", vo.getStrHospitalCode(), "1", request, tariffPrintMap, "0", 0, "0", "");
					
					/*
					 * public static boolean OPD_SERVICES(String strBillNo, String
					 * strBServiceId,String strHospitalCode, String strReceiptNo ,
					 * HttpServletRequest request , Map tariffPrintMap , String strIsDirectMode,int
					 * isDuplicateBill,String isCreditBill,String printCopyType )
					 */
					
					//PrintHLP.OPD_SERVICES(strBillNo, "5", vo.getStrHospitalCode(), "1", request, tariffPrintMap, "1", 0, "0", "");
					
					String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
					formBean.setStrPrintBill(fileName);
					request.setAttribute("filePath", fileName);
					formBean.setIsOpenPopUp("1");

				}
				else 
				{
					System.out.println("PatStatus--------------"+strBillNo+"----------------->  2");
					String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
					formBean.setStrPrintBill(fileName);
					request.setAttribute("filePath", fileName);
					formBean.setIsOpenPopUp("2");

				}
				
				
		}
		
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
		strmsgText = "mms.transactions.IssueToPatientBSDATA.insertWithoutCrNo()--> "+e.getMessage() + String.valueOf(" :: Debug Point = " + debugPoint);
		
		if(e.getMessage().contains("##") && (e.getMessage().split("\\##")[2].equals("999") || e.getMessage().split("\\##")[2].equals("103")))
			formBean.setStrErrMsg(e.getMessage().split("\\##")[1]);
		else	
		formBean.setStrIssueNo("0");
	    formBean.setStrIssueNum("0");
	  
		
	} finally {

		if (bo != null)
			bo = null;
		if (vo != null)
			vo = null;
		if (util != null)
			util = null;
	}
}


public static void insertDirectIssue(IssueToPatOPDTransFB formBean, HttpServletRequest request) 
{

	IssueToPatOPDTransBO bo = null;
	IssueToPatOPDTransVO vo = null;

	HisUtil util = null;
	String strmsgText = null;
	String[] temp = null;
	String[] strtemp = null;
	
	MmsConfigUtil mcu = null;
	HisUtil hisUtil = null;
	int debugPoint = 0;
	IpdConfigUtil ipdC=new IpdConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
	try {
		debugPoint = 1;
		bo = new IssueToPatOPDTransBO();
		vo = new IssueToPatOPDTransVO();
		mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		hisUtil = new HisUtil("MMS", "DirectPharmacy");
		formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
		formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
		
		//System.out.println("in issue mode 1 in data");
		vo.setStrReqQty(formBean.getStrReqQty());
		vo.setStrUnitName(formBean.getStrUnitName());
		vo.setItemParamValue(formBean.getItemParamValue());
		vo.setStrReqEmpNo("0");
		vo.setStrReqPatCatCode("0");
		vo.setStrReqAdmNo("0");
		vo.setStrReqWardCode("0");
		vo.setStrPatientType("18");
		vo.setStrReqType(formBean.getStrRequestType());
		
		debugPoint = 2;
		
		vo.setStrPrescribedBy("0");
	    vo.setStrReqPrescribedBy("0");
		vo.setStrPatientName(formBean.getStrPatientName());
		vo.setStrPatientId((formBean.getCrNo()!=null && !formBean.getCrNo().equals("0")) ?formBean.getCrNo() : "0");
		vo.setStrHospitalCode(formBean.getStrHospitalCode());
		vo.setStrSeatId(formBean.getStrSeatId());
		
		debugPoint = 3;
		
		vo.setStrStoreId(formBean.getStrStoreId());		
		//vo.setStrItemCat(formBean.getStrItemCat());
		//vo.setStrCatgoryCode(formBean.getStrItemCat());
		vo.setStrIssueMode("0");
		vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
		vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
		vo.setStrReceiveBy(formBean.getStrReceiveBy());
		vo.setStrPuk(formBean.getCrNo());
		vo.setStrRemarks(formBean.getStrRemarks());
		vo.setStrCostFinal(formBean.getStrCostFinal());
		vo.setStrApproxAmt(formBean.getStrApproxAmt());
		//vo.setStrEpisodeCode(formBean.getStrOffLineEpisode());
		
		debugPoint = 4;
				
		vo.setStrReqTypeId("32");
		
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
		
		vo.setStrPayModeVal(formBean.getStrPayMode());
		vo.setStrPayDtlVal(formBean.getStrPayDtl());	
		vo.setStrNetCost(formBean.getStrNetCost());
		
		
		vo.setStrOutOfStockFlag("0");
		
		debugPoint = 6;
		
		vo.setStrDeptCode("0");
		vo.setStrAdmissionDtlHidVal(formBean.getStrAdmissionDtlHidVal());
		bo.getdeptname(vo);
		formBean.setStrDeptName(vo.getStrDeptName());
		
		bo.insertDirectIssue(vo);		
		
		debugPoint = 7;			
		
		if (vo.getStrMsgType().equals("1"))
			throw new Exception(vo.getStrMsgString());
		else 
		{
				formBean.setStrNormalMsg("Drug Successfully Dispensing To CrNo [ "+vo.getStrPuk()+" ] ");
				formBean.setStrIssueNum(vo.getStrIssueNumber());
				formBean.setStrVisitDtl("1");				
				formBean.setStrStoreId(vo.getStrStoreId());		
				formBean.setStrItemCat("10");
				formBean.setStrCatgoryCode("10");
				formBean.setStrIssueMode("0");				
				formBean.setStrCrNo(vo.getStrPuk());				
				formBean.setStrCostFinal(vo.getStrCostFinal());
				formBean.setStrApproxAmt(vo.getStrApproxAmt());
				formBean.setStrPayDtl(vo.getStrPayDtlVal());
				
				
				String strBillNo=vo.getStrBillNo();
				Map tariffPrintMap=null;
				
				
				
				if(formBean.getStrPatStatus().equals("1")) 
				{
				
					PrintHLP.OPD_SERVICES(strBillNo, "5", vo.getStrHospitalCode(), "1", request, tariffPrintMap, "0", 0, "0", "");
					
					String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
					formBean.setStrPrintBill(fileName);
					request.setAttribute("filePath", fileName);
					formBean.setIsOpenPopUp("1");

				}
				else 
				{
					String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
					formBean.setStrPrintBill(fileName);
					request.setAttribute("filePath", fileName);
					formBean.setIsOpenPopUp("2");

				}
				
				
		}
		
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
		strmsgText = "mms.transactions.IssueToPatientBSDATA.insertWithoutCrNo()--> "+e.getMessage() + String.valueOf(" :: Debug Point = " + debugPoint);
		
		if(e.getMessage().contains("##") && (e.getMessage().split("\\##")[2].equals("999") || e.getMessage().split("\\##")[2].equals("103")))
			formBean.setStrErrMsg(e.getMessage().split("\\##")[1]);
		else	
		formBean.setStrIssueNo("0");
	    formBean.setStrIssueNum("0");
	  
		
	} finally {

		if (bo != null)
			bo = null;
		if (vo != null)
			vo = null;
		if (util != null)
			util = null;
	}
}


public static void getEpisodeDtl(IssueToPatOPDTransFB fb, HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	
	IssueToPatOPDTransBO bo = null;
	IssueToPatOPDTransVO voObj = null;
	HisUtil util = null;

	try
	{

		bo = new IssueToPatOPDTransBO();
		voObj = new IssueToPatOPDTransVO();

		String strCrNo = request.getParameter("crNo");
		String strDeptCode = request.getParameter("deptCode");
		String strUnitCode = request.getParameter("unit");


		if (strCrNo == null)
			strCrNo = "0";
		if (strDeptCode == null)
			strDeptCode = "0";

		voObj.setStrCrNo(strCrNo);
		voObj.setStrDeptCode(strDeptCode);
		voObj.setStrUnitCode(strUnitCode);
		voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		bo.getEpisodeDetails(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{
			throw new Exception(voObj.getStrMsgString());

		}

		util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
		String temp = "<option value='0'>Select Value</option>";
		

		if (voObj.getStrOffLineEpisodeValues().size() != 0)
		{

			temp = util.getOptionValue(voObj.getStrOffLineEpisodeValues(),"", "", true);

	

		}

		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().print(temp);

	} catch (Exception e)
	{
		String strmsgText = e.getMessage();
		new HisException("Billing", "IssueToPatientBSDATA->getEpisodeDetails()", strmsgText);

	} finally
	{

		bo = null;

		voObj = null;

		util = null;
	}
	
}

public static void getPresFormDtl(IssueToPatOPDTransFB fb, HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	IssueToPatOPDTransBO bo = null;
	IssueToPatOPDTransVO voObj = null;
	HisUtil util = null;

	try
	{

		bo = new IssueToPatOPDTransBO();
		voObj = new IssueToPatOPDTransVO();

		String strCrNo = request.getParameter("crNo");
		String episodeCode = request.getParameter("episodeCode");


	

		voObj.setStrCrNo(strCrNo);
		voObj.setStrEpisodeCode(episodeCode.replace("^", "#").split("#")[0]);

		voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		bo.getPresFormDetails(voObj);;

		if (voObj.getStrMsgType().equals("1"))
		{
			throw new Exception(voObj.getStrMsgString());

		}
			String precForm="0";
		if (voObj.getStrPrescFormValues().size() != 0)
		{
			while(voObj.getStrPrescFormValues().next()) {
				precForm=voObj.getStrPrescFormValues().getString(1);
			}
		}

	
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().print(precForm);

	} catch (Exception e)
	{
		String strmsgText = e.getMessage();
		new HisException("Billing", "CashCollectionOfflineTransBSDATA->getPresFormDtl()", strmsgText);

	} finally
	{
	bo = null;
		voObj = null;
		util = null;
	}
}

	public static void afterIssueSave(IssueToPatOPDTransFB fb,HttpServletRequest request)
	{
	
		IssueToPatOPDTransBO bo = null;
		IssueToPatOPDTransVO vo = null;
		String strPatientDtl="";
		String strmsgText = "";
		String strRequestTypeId="";
		String strRaisingReqTypeId="";
		String strIssueItemId="";
		String strRequestDtl="";
		String strChk="";
		String temp[]=null;
		String hosCode="";
		String strRequestItemDtl="";
		String strStoreId="";
		MmsConfigUtil mmsConfig=null;
		String strCostReq="";
		StringBuffer buff=null;
		BillConfigUtil billConfig=null;
		String RaisingStoreId="RaisingStoreI";
		try 
		{
			System.out.println("************** IssueToPatOPDTransDATA --> afterIssueSave()  **********CHK****"+request.getParameter("chk"));
			
				bo = new IssueToPatOPDTransBO();
				vo = new IssueToPatOPDTransVO();
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();		
							
				vo.setStrIssueNumber(fb.getStrIssueNum());	
				vo.setStrIssueNumber(fb.getStrIssueNo());
				vo.setStrAdmissionDtlHidVal(fb.getStrAdmissionDtlHidVal());				
				vo.setStrDeptName(fb.getStrDeptName());
				vo.setStrPatientDtlHidVal(fb.getStrPatientDtlHidVal());
				vo.setStrStoreId(fb.getStrStoreId());
				vo.setStrItemCat(fb.getStrItemCat());				
				vo.setStrPuk(fb.getStrCrNo());
				
				System.out.println("-Issue No ----"+vo.getStrIssueNumber());
				System.out.println("-Issue No ----"+fb.getStrIssueNo());
				System.out.println("-Admn_Dtl ----"+vo.getStrAdmissionDtlHidVal());
				System.out.println("-Dept Name ----"+vo.getStrDeptName());
				System.out.println("-Pat Dtl----"+vo.getStrPatientDtlHidVal());
				System.out.println("-Store Id ----"+vo.getStrStoreId());
				System.out.println("-Catg ----"+vo.getStrItemCat());
				System.out.println("-Cr No ----"+vo.getStrPuk());
				
				
				
				/* vo.getStrPatientDtlHidVal()
	              HRGDT_DOB || ''^'' ||GNUM_GENDER_CODE ||''^''||HGNUM_PAT_STATUS_CODE || ''^''||
		          HGNUM_PATIENT_CAT_CODE || ''^'' ||HRGNUM_IS_MLC    ||''^''||HRGNUM_ISNEWBORN      || ''^''|| HRGNUM_ID_NO
				*/
				
								
				strRequestTypeId="32";
				
				System.out.println("************** IssueToPatOPDTransDATA --> afterIssueSave() --> PatientDtlHLP.patientWithAdmissionDtl **************");
	
				strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(fb.getStrCrNo(), hosCode, true);
				
				System.out.println("*************************************************");
	
			   vo.setStrPatientDtl(strPatientDtl);
			   vo.setStrHospitalCode(hosCode);	
			   bo.getIssueDtlsInitDtls(vo);  // pkg_mms_view.Proc_Emp_Issue_Detail [ Mode - 3 ]
			
			if (vo.getStrMsgType().equals("1")) 
				throw new Exception(vo.getStrMsgString());
			
				 			
				System.out.println("-WsIssueDetails --Size in HLP ----"+vo.getWsIssueDetails().size());
				
				while(vo.getWsIssueDetails().next())
				{
					vo.setStrIssueDate(vo.getWsIssueDetails().getString(2));
					vo.setStrStoreName(vo.getWsIssueDetails().getString(4));
					
				}
				vo.getWsIssueDetails().beforeFirst();
				
			System.out.println("---  LPIssueDeskTransHLP.getIssueDtlsInitView  ----");
			 
			String strAfterSaveVoucher = IssueToPatOPDTransHLP.getAfterSaveVoucher(vo,"1");	
			
			fb.setStrAfterSaveVoucher(strAfterSaveVoucher);
			
			System.out.println("---strAfterSaveVoucher  ----"+strAfterSaveVoucher);
			
			
		} catch (Exception e) {
	
			e.printStackTrace();
			strmsgText = "Issue Desk.IssueToPatOPDTransDATA.getInitDetailForIssuePage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatOPDTransDATA->getIndentDetails()", strmsgText);
			fb.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
	
			eObj = null;
		} finally {
			bo = null;
			vo = null;
	
		}
	
	}


}
