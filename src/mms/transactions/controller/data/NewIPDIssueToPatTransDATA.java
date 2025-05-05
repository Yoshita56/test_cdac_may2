package mms.transactions.controller.data;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import billing.BillConfigUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import ipd.IpdConfigUtil;
import mms.MmsConfigUtil;
import mms.patDtl.PatientDtlHLP;
import mms.patDtl.PatientDtlHLPNew;
import mms.transactions.bo.NewIPDIssueToPatTransBO;
import mms.transactions.controller.fb.NewIPDIssueToPatTransFB;
import mms.transactions.controller.hlp.NewIPDIssueToPatTransHLP;
import mms.transactions.vo.NewIPDIssueToPatTransVO;

public class NewIPDIssueToPatTransDATA {

//  private String   contents;
//   private String   rptContents;	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param fb
	 * @param request
	 */
	
	public static int printLine = 0;
	public static void getViewDtl(NewIPDIssueToPatTransFB fb,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   NewIPDIssueToPatTransVO vo = null;
		   NewIPDIssueToPatTransBO bo = null;
		   HisUtil util = null;
		   String strResult = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new NewIPDIssueToPatTransVO();
			   	bo=new NewIPDIssueToPatTransBO();
			   	util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
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
			    
			       strResult = NewIPDIssueToPatTransHLP.getIssuedDetail(vo.getStrIssueDetailWs());

			    if(strResult!= null && !strResult.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "IssueToPatientBSODATA->getViewDtl()", vo.getStrMsgString());
					       String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueToPatientBSODATA->getViewDtl()", strmsgText);
				fb.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//fb.setStrMsgType("1");
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
			HttpServletResponse response, NewIPDIssueToPatTransFB formBean) 
	{

		String strSearchItemInitView = "";
		//boolean printFlag = false;
		
		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;
		String strMode = "";
		String strStoreId = "";
		String strIssueNo = "";

		try {

			    strMode = (String) request.getParameter("strMode");
			 strStoreId = (String) request.getParameter("strStoreId");
			 strIssueNo = (String) request.getParameter("strIssueNo");			
			         bo = new NewIPDIssueToPatTransBO();
			         vo = new NewIPDIssueToPatTransVO();
			
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
			
			strSearchItemInitView = NewIPDIssueToPatTransHLP.getIssueDtlsInitView(formBean);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);

		} 
		catch (Exception e)
		{
			e.printStackTrace();
			 
			 String strmsgText = "IssueToPatientBSODATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA.issueDtlsInit(vo) --> ", strmsgText);
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
			HttpServletResponse response, NewIPDIssueToPatTransFB formBean) 
	{

		String strSearchItemInitView = "";

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;
		String strMode = "";
		String strStoreId = "";
		String strIssueNo = "";

		try {

			    strMode = (String) request.getParameter("strMode");
			 strStoreId = (String) request.getParameter("strStoreId");
			 strIssueNo = (String) request.getParameter("strIssueNo");			
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
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
			    strSearchItemInitView = NewIPDIssueToPatTransHLP.getIssueDtlsInitView(formBean);

			    response.setHeader("Cache-Control", "no-cache");
			    response.getWriter().print(strSearchItemInitView);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			 
			 String strmsgText = "IssueToPatientBSODATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;
			  
		}finally {

			bo = null;
			vo = null;
		}

	}
	public static void getStoreDtls(NewIPDIssueToPatTransFB formBean, HttpServletRequest request) 
	{
		NewIPDIssueToPatTransBO       bo = null;
		NewIPDIssueToPatTransVO       vo = null;
		HisUtil          util = null;
		String    strStoreVal = "";
		String 	strCatVal="";
		String     strmsgText = null;
		ResourceBundle resObj = null;
		SimpleDateFormat  sdf = null;
		Calendar           c1 = null;
		
		try 
		{
			               bo = new NewIPDIssueToPatTransBO();
			               vo = new NewIPDIssueToPatTransVO();
			             util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");			
			              sdf = new SimpleDateFormat("dd-MMM-yyyy");
		                   c1 = Calendar.getInstance();	    
		    c1.add(Calendar.DATE,0);   // or  Calendar.DAY_OF_MONTH which is a synonym
		    //System.out.println("Date + 1 days is : " + sdf.format(c1.getTime()));			
			
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
			System.out.println(" ----XX--- formBean.getStrStoreId()-- "+formBean.getStrStoreId());
			vo.getStrStoreWs().beforeFirst();
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
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getStoreDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getStoreDtls()", strmsgText);
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
	
	public static void getStoreDtlsView(NewIPDIssueToPatTransFB formBean, HttpServletRequest request) {

		NewIPDIssueToPatTransBO bo       = null;
		NewIPDIssueToPatTransVO vo       = null;
		HisUtil util          = null;
		String strStoreVal    = "";
		String strmsgText     = null;
		ResourceBundle resObj = null;
		SimpleDateFormat  sdf = null;
		Calendar           c1 = null;
		String strConfCatCode = "";
		
		try 
		{
			               bo = new NewIPDIssueToPatTransBO();
			               vo = new NewIPDIssueToPatTransVO();
			             util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");			
			              sdf = new SimpleDateFormat("dd-MMM-yyyy");
			              
		    c1 = Calendar.getInstance();	    
		    c1.add(Calendar.DATE,-1);   // or  Calendar.DAY_OF_MONTH which is a synonym
		    //System.out.println("Date + 1 days is : " + sdf.format(c1.getTime()));			
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
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getStoreDtlsView --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getStoreDtlsView()", strmsgText);
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
	
	public static void getGroupDetails(NewIPDIssueToPatTransFB formBean, HttpServletRequest request) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;

		HisUtil util = null;
		String strGroupVal = "";
		String strmsgText = null;
		
		try {
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrItemCat(formBean.getItemCategory());
			
			bo.getStoreGroupDtls(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
			
			strGroupVal = util.getOptionValue(vo.getStrGroupWs(), "0",
					"0^Select Value", false);
						
			formBean.setStrGroupValues(strGroupVal);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getGroupDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getGroupDetails()", strmsgText);
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
	
	public static void getItemCatDtls(NewIPDIssueToPatTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new NewIPDIssueToPatTransBO();
			voObj = new NewIPDIssueToPatTransVO();
			
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
			util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
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
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getItemCatDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getItemCatDtls()", strmsgText);
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
	
	public static void GET_PAT_ACC_STATUS(NewIPDIssueToPatTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String temp = "";
		try {

			bo = new NewIPDIssueToPatTransBO();
			voObj = new NewIPDIssueToPatTransVO();
			
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
			strmsgText = "mms.transactions.IssueToPatientBSODATA.GET_PAT_ACC_STATUS --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->GET_PAT_ACC_STATUS()", strmsgText);
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
	public static int getissuetopatientcount(NewIPDIssueToPatTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		int temp =0;
		try {

			bo = new NewIPDIssueToPatTransBO();
			voObj = new NewIPDIssueToPatTransVO();
			
			voObj.setStrStoreId(formBean.getStrStoreId());
			voObj.setStrItemCat(formBean.getItemCategory());
			voObj.setStrCrNo(formBean.getStrCrNo());
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			
			bo.issueTopatientCount(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
			

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
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getItemCatDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getItemCatDtls()", strmsgText);
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
	
	public static void getCancelPatientDetails(NewIPDIssueToPatTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response)
	{

		NewIPDIssueToPatTransBO          bo = null;
		NewIPDIssueToPatTransVO          vo = null;
		MmsConfigUtil        mcu = null;
	
		String        strmsgText = null;
		String strPatientDetails = "";
		String      strIssueMode = "";
		ResourceBundle    resObj = null;
		
		try 
		{
						    bo = new NewIPDIssueToPatTransBO();
						    vo = new NewIPDIssueToPatTransVO();
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
		 strPatientDetails = NewIPDIssueToPatTransHLP.getPatientDtl(formBean);
		formBean.setStrPatientDetails(strPatientDetails);
		
		if (vo.getStrMsgType().equals("1")) 
		{
			throw new Exception(vo.getStrMsgString());
		}
				
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getCancelPatientDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getPatientDetails()", strmsgText);
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
	public static void getPatientDetails(NewIPDIssueToPatTransFB formBean, HttpServletRequest request, 
						HttpServletResponse response) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		ResourceBundle resObj =  null;
		
		try 
		{
			System.out.println("------------- IssueToPatientBSODATA . getPatientDetails ---------------");
			
			     bo = new NewIPDIssueToPatTransBO();
			     vo = new NewIPDIssueToPatTransVO();
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
			
			
			System.out.println("------A------- mms.patDtl.PatientDtlHLP.patientWithAdmissionDtl ---------------"+vo.getStrInvalidCrFlag());
			 
			String strPatientDetails = PatientDtlHLP.patientWithAdmissionDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode(), true);
			
			System.out.println("------B------- PatientDtlHLP.patientTreatmentDtl ---------------");
			//added by shefali on 26-Aug-2014 for patient treatment detail in issue to patient
			String strPatientTreatmentDtl =  PatientDtlHLP.patientTreatmentDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode());
			
			
			System.out.println("------C------- mms.patDtl.PatientDtlHLP.patientTreatmentDtl_BS ---------------");
			
			//System.out.println("------------- pkg_simple_view.PROC_HRGT_PATIENT_TREATMENT_DTL ---------------");			
						
			//String strPatientTreatmentDtl_BS =  PatientDtlHLP.patientTreatmentDtl_BS(formBean.getStrCrNo(), formBean.getStrHospitalCode());
			//added by shalini on 03-feb-2016 to fetch patient diagnosis details
			
			System.out.println("------D------- IssueToPatientBSODATA.patientDiagDtl ---------------");
			
			String strPatientDiagDetails = patientDiagDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode());
			
			
			
			
			formBean.setStrPatientDetails(strPatientDetails);
			formBean.setStrPatientTreatmentDtl(strPatientTreatmentDtl);
			//formBean.setStrPatientTreatmentDtl_BS(strPatientTreatmentDtl_BS);
			formBean.setStrPatientDiagDetails(strPatientDiagDetails);
			bo.getLFAccountDetail(vo);
			
			
			
			System.out.println("------------- IssueToPatientBSODATA . getPatientDetails ------- END --------");
			
			formBean.setStrDoseFrqFlg("0");
		
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
					
		} catch (Exception e) 
		{
			e.printStackTrace();
			
			System.out.println("---e.getMessage()-----"+e.getMessage());
			
			
			if(e.getMessage().equals("PatientDtlHLP-->patientWithAdmissionDtl-->PatientDtlHLP-->patientDtl-->Invalid CR. No."))
			{
				System.out.println("--A-IN OUT-----");
				
				formBean.setStrErrMsg("Invalid CR. No./ Data Not Found");
				formBean.setStrInvalidCrFlag("1");	
					
			}			
			else if(e.getMessage().equals("LF No. not Exists/closed!"))
			{
				formBean.setStrErrMsg("Invalid LF. No./Data Not Found");
				formBean.setStrInvalidLFFlag("1");
			}
			else if(e.getMessage().equals("Invalid CR. No."))
			{
				formBean.setStrErrMsg("Invalid CR. No. [ "+formBean.getStrCrNo()+" ]");
				formBean.setStrInvalidLFFlag("1");
			}
			else{
				strmsgText = "mms.transactions.IssueToPatientBSODATA.getPatientDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueToPatientBSODATA->getPatientDetails()", strmsgText);
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
public static void getPatientDetails_BS(NewIPDIssueToPatTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		ResourceBundle resObj =  null;
		
		try 
		{
			
			 System.out.println(" ------- NewIPDIssueToPatTrans.getPatientDetails_BS  ------- ");
			 
		    bo = new NewIPDIssueToPatTransBO();
		    vo = new NewIPDIssueToPatTransVO();
		   mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		  util = new HisUtil("","");
		//System.out.println("Cr No Flag:::::"+mcu.getStrWithOutCrNoFlg());
		//System.out.println("Default Cr No Flag:::::"+mcu.getStrCrNoDefault());
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
		//HLP Method	
		//if(formBean.getStrLFNo()!=null && formBean.getStrLFNo()!="")
		 if(false)
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
		{
			 vo.setStrPuk( formBean.getStrCrNo());
			 bo.getLFAccountDetail(vo);
				formBean.setStrLFAccountNo(vo.getStrLFAccountNo()); 
				formBean.setStrLFAccountOpenDate(vo.getStrLFAccountOpenDate());
				formBean.setStrLFDepositedAmount(vo.getStrLFDepositedAmount());
				formBean.setStrLFBalanceAmount(vo.getStrLFBalanceAmount());
				formBean.setStrLFAccountStatus(vo.getStrLFAccountStatus());
			 
			//strCrNo
		}
		String strPatientDetails = PatientDtlHLP.patientWithAdmissionDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode(), true);
		
		//added by shefali on 26-Aug-2014 for patient treatment detail in issue to patient
		String strPatientTreatmentDtl =  PatientDtlHLP.patientTreatmentDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode());
		
		//added by shalini on 03-feb-2016 to fetch patient diagnosis details
		
		String strPatientDiagDetails = patientDiagDtl_BS(formBean.getStrCrNo(), formBean.getStrHospitalCode());
		
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
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getPatientDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getPatientDetails()", strmsgText);
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


	
	public static void getOnlineReqDtl(NewIPDIssueToPatTransFB formBean, HttpServletRequest request, HttpServletResponse response) 
	{

			NewIPDIssueToPatTransBO bo = null;
			NewIPDIssueToPatTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
		
		try 
		{
			 System.out.println(" ------- NewIPDIssueToPatTrans.getOnlineReqDtl  ------- ");
			 
				bo = new NewIPDIssueToPatTransBO();
				vo = new NewIPDIssueToPatTransVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				String strIssueMode = mcu.getStrIssueMode();
				formBean.setStrIssueMode(strIssueMode);
				
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrCrNumber(formBean.getCrNo());
				
				String strOnlineIssueReqDays = mcu.getStrOnlineIssueDetailsInDays();
				vo.setStrOnlineIssueReqDays(strOnlineIssueReqDays);
				
				bo.getRequestDtls(vo);
									
				String strReqValues = NewIPDIssueToPatTransHLP.getRequestDtls(vo.getStrRequestWs());
				formBean.setStrReqValues(strReqValues);
				formBean.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
		if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
				strmsgText = "mms.transactions.IssueToPatientBSODATA.getOnlineReqDtl --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueToPatientBSODATA->getOnlineReqDtl()", strmsgText);
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
	
	public static void getItemDetails(NewIPDIssueToPatTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response ) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		String strItemDetails ="";
		
		try {
			
			 System.out.println(" ------- NewIPDIssueToPatTrans.getItemDetails  ------- ");
			 
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			String strIssueMode = mcu.getStrIssueMode();
			formBean.setStrIssueMode(strIssueMode);
						
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrRequestNo(request.getParameter("reqNo"));
			vo.setStrCrNumber(request.getParameter("crNo"));
			vo.setStrStoreId(request.getParameter("strId"));		
			
			bo.getItemDetails(vo);
			
			strItemDetails = NewIPDIssueToPatTransHLP.getItemDetails(vo.getStrHospitalCode(),vo.getStrItemDetailWs());
			
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemDetails);	
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getItemDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getItemDetails()", strmsgText);
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
	
	
	
	public static void getIssueDetails(NewIPDIssueToPatTransFB formBean, HttpServletRequest request, HttpServletResponse response)
		{
			
			NewIPDIssueToPatTransBO bo = null;
			NewIPDIssueToPatTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			WebRowSet ws = null;
			try {
				 System.out.println(" ------- NewIPDIssueToPatTrans.getIssueDetails  ------- ");
				 
				bo = new NewIPDIssueToPatTransBO();
				vo = new NewIPDIssueToPatTransVO();
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
				bo.getIssueDetail(vo); //Pkg_Mms_View.Proc_Issue_Details Mode 1 
				  
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
			String strIssueDetails = NewIPDIssueToPatTransHLP.getIssueDetailsBS(ws,vo);
				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strIssueDetails);
				
			} catch (Exception e) {
				strmsgText = "mms.transactions.IssueToPatientBSODATA.getIssueDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueToPatientBSODATA->getIssueDetails()", strmsgText);
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
	
	public static void getRequestDetails(NewIPDIssueToPatTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		WebRowSet ws = null;
		MmsConfigUtil mcu = null;
		
		try {
			 System.out.println(" ------- NewIPDIssueToPatTrans.getRequestDetails  ------- ");
			 
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
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
			
			String strRequestDetails=NewIPDIssueToPatTransHLP.getRequestDetails(ws);
			
			////System.out.println("strRequestDetails---------->"+strRequestDetails);
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strRequestDetails);
						
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getRequestDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getRequestDetails()", strmsgText);
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
	
	public static void getFrequencyDetails(NewIPDIssueToPatTransFB formBean, HttpServletRequest request) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;

		HisUtil util = null;
		String strFrequencyVal = "";
		String strmsgText = null;
		
		try {
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
			util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
						
			bo.getFrequencyDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
			
			strFrequencyVal = util.getOptionValue(vo.getStrFrequencyWs(), "0",
					"0^Select Value", false);
						
			formBean.setStrFrequencyValues(strFrequencyVal);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getFrequencyDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getFrequencyDetails()", strmsgText);
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
	
	public static void getDoseDetails(NewIPDIssueToPatTransFB formBean, HttpServletRequest request) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;

		HisUtil util = null;
		String strDosageVal = "";
		String strmsgText = null;
		
		try {
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
			util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
						
			bo.getDoseDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
			
			strDosageVal = util.getOptionValue(vo.getStrDosageWs(), "0",
					"0^Select Value", false);
			formBean.setStrDosageValues(strDosageVal);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getDoseDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getDoseDetails()", strmsgText);
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
	
	public static void getDeptDetails(NewIPDIssueToPatTransFB formBean, HttpServletRequest request) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;

		HisUtil util = null;
		String strDeptVal = "";
		String strmsgText = null;
		
		try {
			 System.out.println(" ------- NewIPDIssueToPatTrans.getDeptDetails  ------- ");
			 
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
			util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getDeptDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
			
			strDeptVal = util.getOptionValue(vo.getStrDepartmentWs(), "",
					"0^Select Value", false);
						
			formBean.setStrDeptValues(strDeptVal);
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getDeptDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getDeptDetails()", strmsgText);
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
	
	public static void getUnitDetails(NewIPDIssueToPatTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			vo.setStrDeptCode(request.getParameter("deptCode"));
			
			
			bo.getUnitDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
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
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getUnitDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getUnitDetails()", strmsgText);
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
	
	public static void getUnitDetails1(NewIPDIssueToPatTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
				vo.setStrDeptCode("134");
				
			
			
			
			bo.getUnitDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
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
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getUnitDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getUnitDetails()", strmsgText);
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
	public static void getPrescribedBy(NewIPDIssueToPatTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrUnitCode(request.getParameter("unitCode"));
//	System.out.println("vo.getStrUnitCode"+vo.getStrUnitCode());		
			bo.getPrescribedBy(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
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
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getPrescribedBy --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getPrescribedBy()", strmsgText);
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
	
	
	public static void insert(NewIPDIssueToPatTransFB formBean, HttpServletRequest request) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		String[] temp = null;
		String[] strtemp = null;
		
		MmsConfigUtil mcu = null;
		
		int debugPoint = 0;
				
		try {
			 System.out.println(" ------- NewIPDIssueToPatTrans.insert  ------- ");
			 
			debugPoint = 1;
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
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
			strmsgText = "mms.transactions.IssueToPatientBSODATA.insertWithoutCrNo()--> "+e.getMessage() + String.valueOf(" :: Debug Point = " + debugPoint);
			//HisException eObj = new HisException("mms","IssueToPatientBSODATA->insertWithoutCrNo()",strmsgText,request);
			
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
	
	public static void insertipd(NewIPDIssueToPatTransFB formBean, HttpServletRequest request) {

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		String[] temp = null;
		String[] strtemp = null;
		
		MmsConfigUtil mcu = null;
		
		int debugPoint = 0;
				
		try {
			 System.out.println(" ------- NewIPDIssueToPatTrans.insertipd  ------- ");
			 
			debugPoint = 1;
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
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
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientBSODATA.insertWithoutCrNo()--> "+e.getMessage() + String.valueOf(" :: Debug Point = " + debugPoint);
			//HisException eObj = new HisException("mms","IssueToPatientBSODATA->insertWithoutCrNo()",strmsgText,request);
			
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
	

	public static void insertCancel(NewIPDIssueToPatTransFB formBean, HttpServletRequest request) 
	{

		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;		
			
		try 
		{
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();			
			
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrCrNum(formBean.getStrCrNo());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIssueNo(formBean.getStrIssueNo());			
			
//			System.out.println("Hosp Code==>"+formBean.getStrHospitalCode());
//			System.out.println("Seat ID==>"+formBean.getStrSeatId());
//			System.out.println("Remarks==>"+formBean.getStrRemarks());
//			System.out.println("Issue No==>"+formBean.getStrIssueNo());
			
			/*
			 * for(int i=0; i<formBean.getStrIssueChkIndex().length; i++) {
			 * if(formBean.getStrIssueChkIndex()[i].equals("1")) {
			 * System.out.println("Item Brand ID==>"+formBean.getStrItemBrandId()[i]);
			 * System.out.println("Batch No==>"+formBean.getStrBatchNo()[i]); }
			 * 
			 * }
			 */
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientBSODATA.insertCancel --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->insert()", strmsgText);
		    	
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

	
	public static void getMmsConfigFlags(NewIPDIssueToPatTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) 
	{
//		NewIPDIssueToPatTransBO bo = null;
//		NewIPDIssueToPatTransVO vo = null;
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

	public static void getGenderCombo(NewIPDIssueToPatTransFB formBean,HttpServletRequest request) 
	{
		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;

		HisUtil util = null;
		String strPatientGenderCodeCmbValues = "";
		String strmsgText = null;
		
		try {
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
			util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getGenderCombo(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
			
			strPatientGenderCodeCmbValues = util.getOptionValue(vo.getStrGenderWs(), "",	"", false);
						
			formBean.setStrPatientGenderCodeCmbValues(strPatientGenderCodeCmbValues);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getDeptDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",	"IssueToPatientBSODATA->getGenderCombo()", strmsgText);
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
		NewIPDIssueToPatTransBO bo = new NewIPDIssueToPatTransBO();
		NewIPDIssueToPatTransVO vo	= new NewIPDIssueToPatTransVO();
		HisUtil util =  new HisUtil("MMS Transactions", "IssueToPatientBSODATA");	;
			StringBuffer sb = new StringBuffer("");
			vo.setStrCrNo(strCrNo);
			vo.setStrHospitalCode(strHospitalCode);
			
			WebRowSet ws = null;
			String diagName;
			
			sb.append("");
			
			try 
			{
				 System.out.println(" ------- NewIPDIssueToPatTrans.patientDiagDtl  ------- ");
				 
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
		NewIPDIssueToPatTransBO bo = new NewIPDIssueToPatTransBO();
		NewIPDIssueToPatTransVO vo	= new NewIPDIssueToPatTransVO();
		HisUtil util =  new HisUtil("MMS Transactions", "IssueToPatientBSODATA");	;
			StringBuffer sb = new StringBuffer("");
			vo.setStrCrNo(strCrNo);
			vo.setStrHospitalCode(strHospitalCode);
			
			WebRowSet ws = null;
			String diagName;
			
			sb.append("");
			
			try 
			{
				 System.out.println(" ------- NewIPDIssueToPatTrans.patientDiagDtl_BS  ------- ");
				 
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
					sb.append("<div class='col-sm-2' align='right'><label>Diagnosis Name(Code)</label></div>");
					//sb.append("</div>");
					sb.append("<div class='col-sm-2'><select name ='strDiagCode'  class='form-control' onchange='' name=strDiagName >"+ diagName +"</select></div>");
					sb.append("<div class='col-sm-6' align='right'><label>Treatment Consultant</label></div> ");
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


	
	public static void getOnlineTreatmentDtl(NewIPDIssueToPatTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{
	
			NewIPDIssueToPatTransBO bo = null;
			NewIPDIssueToPatTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
		
		try 
		{
			 System.out.println(" ------- NewIPDIssueToPatTrans.getOnlineTreatmentDtl  ------- ");
				bo = new NewIPDIssueToPatTransBO();
				vo = new NewIPDIssueToPatTransVO();
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
				String strReqValues = NewIPDIssueToPatTransHLP.getOnlineTreatmentDtls(vo.getOnlineTreatmentDtlsWs() , formBean);
				formBean.setStrOnlineTreatment(strReqValues);
				
				
				
				formBean.setStrRowCount(String.valueOf(rowcount));
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strReqValues + "##" + String.valueOf(rowcount)+"##");
				
		if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
				e.printStackTrace();
				strmsgText = "mms.transactions.IssueToPatientBSODATA.getOnlineReqDtl --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueToPatientBSODATA->getOnlineReqDtl()", strmsgText);
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
		public static void getBilledItemDtls(NewIPDIssueToPatTransFB fb,HttpServletRequest request,HttpServletResponse response)
		{
			 /* Declaring Variables */
		      String strmsgText = "";
			   NewIPDIssueToPatTransVO vo = null;
			   NewIPDIssueToPatTransBO bo = null;
			   HisUtil util = null;
			   String strResult = "";
			   try
			   {
				   System.out.println(" ------- NewIPDIssueToPatTrans.getBilledItemDtls  ------- ");
				   
				    /* Creating Object */   	
				    vo=new NewIPDIssueToPatTransVO();
				   	bo=new NewIPDIssueToPatTransBO();
				   	util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
				   	/* Value set in Value Object */
				   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				   	vo.setStrStoreId(request.getParameter("strStoreId"));
				   	vo.setStrIssueNo(request.getParameter("strIssueNo"));
				   	//vo.setStrItemCategoryNo(request.getParameter("itemCatNo"));
				   //System.out.println("Flag==>"+request.getParameter("strFlagVal"));
				//   	vo.setStrFlagVal(request.getParameter("strFlagVal"));
				   /*	if(request.getParameter("strFlagVal").equals("1"))
				   	{
				   		vo.setStrFromDate(util.getASDate("dd-MMM-yyyy"));
					   	vo.setStrToDate(util.getASDate("dd-MMM-yyyy"));
				   	}
				   	else
				   	{
				   		vo.setStrFromDate(request.getParameter("fromDate"));
					   	vo.setStrToDate(request.getParameter("ToDate"));
				   	}*/
		           
		           /* Calling BO method */
				    bo.getBilledItemDtls(vo);
				    
				       strResult = NewIPDIssueToPatTransHLP.getBilledItemDtls(vo);
		
				    if(strResult!= null && !strResult.equals(""))
				    	
					{	
					 	response.setHeader("Cache-Control", "no-cache");
					 	response.getWriter().print(strResult);
					 		 
					}
					else
					{
					    HisException eObj = new HisException("MMS", "IssueToPatientBSODATA->getViewDtl()", vo.getStrMsgString());
						       String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
						response.getWriter().print(str);
			    	 }
				   
				   
			   }catch(Exception _err){
				   strmsgText = _err.getMessage();
					HisException eObj = new HisException("MMS", "IssueToPatientBSODATA->getViewDtl()", strmsgText);
					fb.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
					//fb.setStrMsgType("1");
					eObj = null;
			   }
			   finally 
			   {
				    util = null;
					  bo = null;
					  vo = null;
				}
			   
		}

		
	public static void deleteIssueDtls(NewIPDIssueToPatTransFB fb,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	      String strmsgText = "";
		   NewIPDIssueToPatTransVO vo = null;
		   NewIPDIssueToPatTransBO bo = null;
		   HisUtil util = null;
		   String strResult = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new NewIPDIssueToPatTransVO();
			   	bo=new NewIPDIssueToPatTransBO();
			   	util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreId(request.getParameter("strStoreId"));
			   	vo.setStrIssueNo(request.getParameter("strIssueNo"));
			   	//vo.setStrItemCategoryNo(request.getParameter("itemCatNo"));
			   //System.out.println("Flag==>"+request.getParameter("strFlagVal"));
			//   	vo.setStrFlagVal(request.getParameter("strFlagVal"));
			   /*	if(request.getParameter("strFlagVal").equals("1"))
			   	{
			   		vo.setStrFromDate(util.getASDate("dd-MMM-yyyy"));
				   	vo.setStrToDate(util.getASDate("dd-MMM-yyyy"));
			   	}
			   	else
			   	{
			   		vo.setStrFromDate(request.getParameter("fromDate"));
				   	vo.setStrToDate(request.getParameter("ToDate"));
			   	}*/
	           
	           /* Calling BO method */
			    bo.deleteIssueDtls(vo);
			    
			   
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueToPatientBSODATA->getViewDtl()", strmsgText);
				fb.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//fb.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}
	
	
	public static void getTariffDtl(NewIPDIssueToPatTransFB fb,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	      String strmsgText = "";
		   NewIPDIssueToPatTransVO vo = null;
		   NewIPDIssueToPatTransBO bo = null;
		   HisUtil util = null;
		   String strResult="" ;
		   int i=0;
		   try
		   {
			   System.out.println(" ------- NewIPDIssueToPatTrans.getTariffDtl  ------- ");
			   
			    /* Creating Object */   	
			    vo=new NewIPDIssueToPatTransVO();
			   	bo=new NewIPDIssueToPatTransBO();
			   	util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
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
				/*
				 * if(strResult != "") response.getWriter().print(strResult); else
				 * response.getWriter().print(strResult);
				 */
			    
				/* else
				{
				    HisException eObj = new HisException("MMS", "IssueToPatientBSODATA->getTariffDtl()", vo.getStrMsgString());
					       String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 } */
			   
			   
		   }catch(Exception _err){
			   _err.printStackTrace();
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueToPatientBSODATA->getTariffDtl()", strmsgText);
				fb.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//fb.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}
	
	
	public static void getAlreadyIssueDrug(NewIPDIssueToPatTransFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
	
	
		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
	
	try 
	{
		System.out.println(" ------- NewIPDIssueToPatTrans.getAlreadyIssueDrug  ------- ");
		
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			String strIssueMode = mcu.getStrIssueMode();
			formBean.setStrIssueMode(strIssueMode);
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			//vo.setStrCrNumber(formBean.getStrCrNo());
			vo.setTariff(request.getParameter("itemTmp"));
			//formBean.setStrStoreId(request.getParameter("storeId"));
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
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getOnlineReqDtl --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getOnlineReqDtl()", strmsgText);
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
	
	public static void getDiirecIssueInitData(NewIPDIssueToPatTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		   NewIPDIssueToPatTransVO vo = null;
		   NewIPDIssueToPatTransBO bo = null;
		   HisUtil util = null;
		   String strCatVal=null;
		   String strStoreVal=null;
		   String strPayModeVal=null;
		   String strAdmDtl=null;
		 
		
		     try
		   {
		    	 
		    	    System.out.println(" ------- NewIPDIssueToPatTrans.getDiirecIssueInitData  ------- ");
		    	 	vo=new NewIPDIssueToPatTransVO();
				   	bo=new NewIPDIssueToPatTransBO();
				   	util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
				   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				   	
				   	vo.setStrHospitalCode(formBean.getStrHospitalCode());
					vo.setStrSeatId(formBean.getStrSeatId());
					vo.setStrCrNo(formBean.getStrCrNo());
					vo.setStrStoreId(request.getParameter("strId"));
					vo.setStrCrNo(request.getParameter("crNo"));
					vo.setStrCrNum(request.getParameter("crNo"));
					vo.setStrCrNumber(request.getParameter("crNo"));
					
					System.out.println(" ------- PatientDtlHLPNew.admissionAccDtl  ------- ");
					
					strAdmDtl=PatientDtlHLPNew.admissionAccDtl(formBean.getStrCrNo(), vo.getStrHospitalCode());
					
				
					if(strAdmDtl.trim().equals(""))
						formBean.setStrPatStatus("1");
					else
						formBean.setStrPatStatus("2");
						
					formBean.setStrAdmDtl(strAdmDtl);		
					
					
					
	                /********************* Drug Name Combo For Add ************************/	
					System.out.println(" ------- pkg_mms_view.Proc_Itembrand_Detail [ Mode - 8 ]  ------- ");
					bo.getItemBrandList(vo);   // pkg_mms_view.Proc_Itembrand_Detail [ Mode - 8 ]
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
					
					formBean.setStrStoreId(request.getParameter("strId"));
					formBean.setStrCrNo(request.getParameter("crNo"));				
					formBean.setStrCrNumber(request.getParameter("crNo"));
				   	
				 
			   
			   
			   
		   }catch(Exception _err){
				HisException eObj = new HisException("MMS", "IssueToPatientBSODATA->getTariffDtl()", _err.getMessage());
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
	
	public static void getReqType(NewIPDIssueToPatTransFB fb, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	    String strmsgText = "";
		   NewIPDIssueToPatTransVO vo = null;
		   NewIPDIssueToPatTransBO bo = null;
		   HisUtil util = null;
		   String temp="";
	
		   try
		   {
			    /* Creating Object */   	
			    vo=new NewIPDIssueToPatTransVO();
			   	bo=new NewIPDIssueToPatTransBO();
			   	
			   	util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
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
				HisException eObj = new HisException("MMS", "IssueToPatientBSODATA->getReqType()", strmsgText);
				fb.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//fb.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
		
	}
	
	public static void insertDirectIssue(NewIPDIssueToPatTransFB formBean, HttpServletRequest request) {
	
		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;
	
		HisUtil util = null;
		String strmsgText = null;
		String[] temp = null;
		String[] strtemp = null;
		
		MmsConfigUtil mcu = null;
		HisUtil hisUtil = null;
		int debugPoint = 0;
		IpdConfigUtil ipdC=new IpdConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
		try 
		{
			System.out.println("----  NewIPDIssueToPatTransDATA.insertDirectIssue  ---");
			debugPoint = 1;
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			hisUtil = new HisUtil("MMS", "DirectPharmacy");
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			
			//System.out.println("in issue mode 1 in data");
			vo.setStrReqQty(formBean.getStrReqQty());
			vo.setStrUnitName(formBean.getStrUnitName());
			vo.setItemParamValue(formBean.getItemParamValue());		
			vo.setItemUserValue(formBean.getItemUserValue());
			vo.setStrReqEmpNo("0");
			vo.setStrReqPatCatCode("0");
			vo.setStrReqAdmNo("0");
			vo.setStrReqWardCode("0");
			vo.setStrPatientType("18");
			vo.setStrReqType(formBean.getStrRequestType());
			
			debugPoint = 2;
			
			//vo.setStrPrescribedBy(formBean.getStrPrescribedBy());
		    //vo.setStrReqPrescribedBy(formBean.getStrPrescribedBy());
			vo.setStrPrescribedBy("0");
		    vo.setStrReqPrescribedBy("0");
			vo.setStrPatientName(formBean.getStrPatientName());
			vo.setStrPatientId((formBean.getCrNo()!=null && !formBean.getCrNo().equals("0")) ?formBean.getCrNo() : "0");
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			debugPoint = 3;
			
			vo.setStrStoreId(formBean.getStrId());		
			vo.setStrItemCat("10");
			vo.setStrCatgoryCode(formBean.getStrItemCat());
			vo.setStrIssueMode("0");
			vo.setStrReceiveBy(formBean.getStrReceiveBy());
			vo.setStrPuk(formBean.getCrNo());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrCostFinal(formBean.getStrCostFinal());
			vo.setStrApproxAmt(formBean.getStrApproxAmt());
			vo.setStrEpisodeCode(formBean.getStrOffLineEpisode());
			
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
			vo.setStrDrugIssueDate(formBean.getStrCtDate());
			
			vo.setStrPayModeVal(formBean.getStrPayMode());
			vo.setStrPayDtlVal(formBean.getStrPayDtl());	
			vo.setStrNetCost(formBean.getStrNetCost());
			
			
			vo.setStrOutOfStockFlag(formBean.getStrOutOfStockFlag());
			
			debugPoint = 6;
			
			vo.setStrDeptCode(formBean.getStrDeptCode());
			vo.setStrAdmissionDtlHidVal(formBean.getStrAdmissionDtlHidVal());
			
			bo.getdeptname(vo);
			formBean.setStrDeptName(vo.getStrDeptName());
			
			/*
			 *  For Testing Purpose Only
			 * 
			String paramVal[] = null;
			String userValue[] = null;
			String itemValue = "";
			
			int length = vo.getItemParamValue().length;	
			
			for(int k=0;k<length;k++)
			{	
				debugPoint = 3;
					if(vo.getStrQtyText()[k] != null && vo.getStrQtyText()[k].length() > 0 && !vo.getStrQtyText()[k].equals("0"))
					{	
						itemValue = vo.getItemParamValue()[k];
	
						paramVal = vo.getItemParamValue()[k].split("#");
						userValue = vo.getItemUserValue()[k].replace('^', '#').split("#");
	
						System.out.println("Qty --"+k+"---"+vo.getStrQtyText()[k]);
						
						System.out.println("Param_Value---"+k+"--"+vo.getItemParamValue()[k]);
						
						System.out.println("issue no---" + vo.getStrIssueNumber());
						System.out.println("getStrStoreId---" + vo.getStrStoreId());
						System.out.println("Item_Id---" + userValue[0]);
						System.out.println("Brand_Id---" + userValue[1]);
						System.out.println("Batch_No---" + userValue[15]);
						System.out.println("Req_Qty--" + k + "--" + vo.getStrQtyText()[k]);
						System.out.println("manuf_date---" + userValue[17]);
						System.out.println("expiry_date---" + userValue[16]);
						System.out.println("getStrPuk---" + vo.getStrPuk());
						System.out.println("getStrSeatId---" + vo.getStrSeatId());
						System.out.println("getStrHospitalCode---" + vo.getStrHospitalCode());
						 
						
					}	
				
			}
			*/
			if(formBean.getStrPatStatus().equals("1"))
			{	
				System.out.println("-getStrPatStatus-----"+formBean.getStrPatStatus()+"--- DIRECT_ISSUE  ---");
				
				bo.directIssue(vo);
			}
			else
			{
				System.out.println("-getStrPatStatus-----"+formBean.getStrPatStatus()+"--- ISSUE_IPD  [ Method Used ]---");
				
				bo.insertipd(vo);
			}
			debugPoint = 7;			
			
			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());
			else 
			{
					formBean.setStrNormalMsg("Drug Successfully Dispensing For Cr No [ "+vo.getStrPuk()+" ] ");
					formBean.setStrIssueNum(vo.getStrIssueNumber());	
					formBean.setStrIssueNo(vo.getStrIssueNumber());				
					formBean.setStrAdmissionDtlHidVal(vo.getStrAdmissionDtlHidVal());				
					formBean.setStrDeptName(vo.getStrDeptName());
					formBean.setStrPatientDtlHidVal(vo.getStrPatientDtlHidVal());
					formBean.setStrStoreId(vo.getStrStoreId());
					formBean.setStrItemCat(vo.getStrItemCat());				
					formBean.setCrNo(vo.getStrPuk());
					formBean.setStrId(vo.getStrStoreId());
					
					
					
					/* vo.getStrPatientDtlHidVal()
		              HRGDT_DOB || ''^'' ||GNUM_GENDER_CODE ||''^''||HGNUM_PAT_STATUS_CODE || ''^''||
			          HGNUM_PATIENT_CAT_CODE || ''^'' ||HRGNUM_IS_MLC    ||''^''||HRGNUM_ISNEWBORN      || ''^''|| HRGNUM_ID_NO
					*/
					
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			//strmsgText = "mms.transactions.IssueToPatientBSODATA.insertWithoutCrNo()--> "+e.getMessage() + String.valueOf(" :: Debug Point = " + debugPoint);
			
			System.out.println("------"+e.getMessage().split("\\@@")[1]);
			System.out.println("------"+e.getMessage().split("\\@@")[2]);
			if(e.getMessage().split("\\@@")[2].equals("999"))
			{
				formBean.setStrErrMsg(e.getMessage().split("\\@@")[1]);
			}
			else
			{
				HisException eObj = new HisException("mms","NewIPDIssueToPatientDATA->insertWithoutCrNo()",e.getMessage());
				formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() +"-"+e.getMessage()+"],Contact System Administrator! ");
			}
				
			
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

	public static void REPEAT_ISSUE_INSERT(NewIPDIssueToPatTransFB formBean, HttpServletRequest request) {
	
		NewIPDIssueToPatTransBO 		bo = null;
		NewIPDIssueToPatTransVO 		vo = null;	
		HisUtil 		  util = null;
		String 	    strmsgText = null;
		String[]          temp = null;
		String[]       strtemp = null;		
		MmsConfigUtil      mcu = null;
		HisUtil        hisUtil = null;
		int         debugPoint = 0;
		IpdConfigUtil     ipdC = new IpdConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
		try 
		{
			
			System.out.println("---- IssueToPatientBSODATA.REPEAT_ISSUE_INSERT ----");
			
			debugPoint = 1;
			bo = new NewIPDIssueToPatTransBO();
			vo = new NewIPDIssueToPatTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			hisUtil = new HisUtil("MMS", "DirectPharmacy");
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			
			//System.out.println("in issue mode 1 in data");
			
			vo.setStrReqQty(formBean.getStrReqQty());
			vo.setStrUnitName(formBean.getStrUnitName());
			vo.setItemParamValue(formBean.getItemParamValue());  //  HSTNUM_ITEM_ID ^ HSTNUM_ITEMBRAND_ID			
			vo.setStrBatch(formBean.getStrBatch());
			vo.setStrSalePrice(formBean.getStrSalePrice());
			vo.setStrExpDate(formBean.getStrExpDate());
			vo.setStrAvlQty(formBean.getStrAvlQty());   
			    
			
			vo.setStrReqEmpNo("0");
			vo.setStrReqPatCatCode("0");
			vo.setStrReqAdmNo("0");
			vo.setStrReqWardCode("0");
			vo.setStrPatientType("18");
			vo.setStrReqType(formBean.getStrRequestType());
			
			debugPoint = 2;
			
			//vo.setStrPrescribedBy(formBean.getStrPrescribedBy());
		    //vo.setStrReqPrescribedBy(formBean.getStrPrescribedBy());
			vo.setStrPrescribedBy("0");
		    vo.setStrReqPrescribedBy("0");
			vo.setStrPatientName(formBean.getStrPatientName());
			vo.setStrPatientId((formBean.getCrNo()!=null && !formBean.getCrNo().equals("0")) ?formBean.getCrNo() : "0");
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			debugPoint = 3;
			
			vo.setStrStoreId(formBean.getStrId());		
			vo.setStrItemCat(formBean.getItemCategory());
			vo.setStrCatgoryCode(formBean.getItemCategory());
			
			System.out.println("----getStrStoreId---"+formBean.getStrId());
			System.out.println("----getStrItemCat---"+formBean.getItemCategory());
			System.out.println("----getCrNo---"+formBean.getCrNo());
			
			vo.setStrIssueMode("0");
			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , formBean.getStrHospitalCode()));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , formBean.getStrHospitalCode()));
			vo.setStrReceiveBy(formBean.getStrReceiveBy());
			vo.setStrPuk(formBean.getCrNo());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrCostFinal(formBean.getStrCostFinal());
			vo.setStrApproxAmt(formBean.getStrApproxAmt());
			vo.setStrEpisodeCode(formBean.getStrOffLineEpisode());
			
			debugPoint = 4;
			
			
			vo.setStrReqTypeId("32");
			
			debugPoint = 5;
			
			vo.setStrQtyText(formBean.getStrReqQty());
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
			
			
			vo.setStrOutOfStockFlag(formBean.getStrOutOfStockFlag());
			
			debugPoint = 6;
			
			vo.setStrDeptCode(formBean.getStrDeptCode());
			vo.setStrAdmissionDtlHidVal(formBean.getStrAdmissionDtlHidVal());
			
						
			bo.REPEAT_ISSUE_INSERT(vo);
			
			debugPoint = 7;			
			
			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());
			else 
			{
					formBean.setStrNormalMsg("Drug Successfully Dispensing For Cr No [ "+vo.getStrPuk()+" ] ");
					formBean.setStrIssueNum(vo.getStrIssueNumber());	
					formBean.setStrIssueNo(vo.getStrIssueNumber());				
					formBean.setStrAdmissionDtlHidVal(vo.getStrAdmissionDtlHidVal());				
					formBean.setStrDeptName(vo.getStrDeptName());
					formBean.setStrPatientDtlHidVal(vo.getStrPatientDtlHidVal());
					formBean.setStrStoreId(vo.getStrStoreId());
					formBean.setStrItemCat(vo.getStrItemCat());				
					formBean.setCrNo(vo.getStrPuk());
					
					
					/* vo.getStrPatientDtlHidVal()
		              HRGDT_DOB || ''^'' ||GNUM_GENDER_CODE ||''^''||HGNUM_PAT_STATUS_CODE || ''^''||
			          HGNUM_PATIENT_CAT_CODE || ''^'' ||HRGNUM_IS_MLC    ||''^''||HRGNUM_ISNEWBORN      || ''^''|| HRGNUM_ID_NO
					*/
					
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientBSODATA.insertWithoutCrNo()--> "+e.getMessage() + String.valueOf(" :: Debug Point = " + debugPoint);
			//HisException eObj = new HisException("mms","IssueToPatientBSODATA->insertWithoutCrNo()",strmsgText,request);
			
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

public static void getEpisodeDtl(NewIPDIssueToPatTransFB fb, HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	
	NewIPDIssueToPatTransBO bo = null;
	NewIPDIssueToPatTransVO voObj = null;
	HisUtil util = null;

	try
	{

		bo = new NewIPDIssueToPatTransBO();
		voObj = new NewIPDIssueToPatTransVO();

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

		util = new HisUtil("MMS Transactions", "IssueToPatientBSODATA");
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
		new HisException("Billing", "IssueToPatientBSODATA->getEpisodeDetails()", strmsgText);

	} finally
	{

		bo = null;

		voObj = null;

		util = null;
	}
	
}

public static void getPresFormDtl(NewIPDIssueToPatTransFB fb, HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	NewIPDIssueToPatTransBO bo = null;
	NewIPDIssueToPatTransVO voObj = null;
	HisUtil util = null;

	try
	{

		bo = new NewIPDIssueToPatTransBO();
		voObj = new NewIPDIssueToPatTransVO();

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
	public static void afterIssueSave(NewIPDIssueToPatTransFB fb,HttpServletRequest request)
	{
	
		NewIPDIssueToPatTransBO bo = null;
		NewIPDIssueToPatTransVO vo = null;
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
			System.out.println("************** NewIPDIssueToPatTransDATA --> afterIssueSave()  **********CHK****"+request.getParameter("chk"));
			
				bo = new NewIPDIssueToPatTransBO();
				vo = new NewIPDIssueToPatTransVO();
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
				
				System.out.println("************** NewIPDIssueToPatTransDATA --> afterIssueSave() --> PatientDtlHLP.patientWithAdmissionDtl **************");
	
				strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(fb.getStrCrNo(), hosCode, true);
				
				System.out.println("*************************************************");
	
			   vo.setStrPatientDtl(strPatientDtl);
			
			
			
			
			vo.setStrHospitalCode(hosCode);			
			bo.getImgHeader(vo);
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
			 
			String strAfterSaveVoucher = NewIPDIssueToPatTransHLP.getAfterSaveVoucher(vo,"1");	
			
			fb.setStrAfterSaveVoucher(strAfterSaveVoucher);
			
			System.out.println("---strAfterSaveVoucher  ----"+strAfterSaveVoucher);
			
			
		} catch (Exception e) {
	
			e.printStackTrace();
			strmsgText = "Issue Desk.NewIPDIssueToPatTransDATA.getInitDetailForIssuePage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"NewIPDIssueToPatTransDATA->getIndentDetails()", strmsgText);
			fb.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
	
			eObj = null;
		} finally {
			bo = null;
			vo = null;
	
		}
	
	}
	
		public static void getIssuePopUp(NewIPDIssueToPatTransFB formBean, HttpServletRequest request, HttpServletResponse response) {
		
		NewIPDIssueToPatTransBO bo    = null;
		NewIPDIssueToPatTransVO vo    = null;			
		
		String strmsgText  = null;			
		String strStoreId  = "";
		String strIssueNo  = "";
		String strHospCode = "";
		String strPopUp    = "";
		String strCrNo     = "";
		String strPatientDtl = "";
		String hosCode ="";
		String viewMode ="0";
		String strAfterSaveVoucher = "";
		try 
		{
			 System.out.println(" ------- NewIPDIssueToPatTrans.getIssuePopUp  ------- ");
			 
			   bo = new NewIPDIssueToPatTransBO();
			   vo = new NewIPDIssueToPatTransVO();							
			   strHospCode = formBean.getStrHospitalCode();
			   strStoreId = request.getParameter("strId");
			   strIssueNo = request.getParameter("issueNo");
			   strCrNo    = request.getParameter("strCrNo");
			   viewMode   = request.getParameter("viewMode");
			   hosCode    = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			   
			   vo.setStrHospitalCode(hosCode);
			   vo.setStrStoreId(strStoreId);
			   vo.setStrIssueNumber(strIssueNo);
			   vo.setStrPuk(strCrNo);
			  			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}				
		
			
			System.out.println("************** NewIPDIssueToPatTransDATA --> afterIssueSave() --> mms.patDtl.PatientDtlHLP.patientWithAdmissionDtl **************");

			strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(strCrNo, hosCode, true);
			
			System.out.println("*************************************************");

		    vo.setStrPatientDtl(strPatientDtl);
		    
		    vo.setStrHospitalCode(hosCode);			
		    bo.getImgHeader(vo);
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
			
		    System.out.println("---  NewIPDIssueToPatTransHLP.getIssueDtlsInitView  ----");
		    if(viewMode.equals("0"))
		    {		 
		        strAfterSaveVoucher = NewIPDIssueToPatTransHLP.getAfterSaveVoucher(vo,"2");
		    }
		    else
		    {
		    	strAfterSaveVoucher = NewIPDIssueToPatTransHLP.getAfterSaveVoucher(vo,"1");
		    }
		
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strAfterSaveVoucher);	
						
		} catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientBSODATA.getIssuePopUp --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSODATA->getIssuePopUp()", strmsgText);
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
		
		public static void initViewPageDtl(NewIPDIssueToPatTransFB formBean,HttpServletRequest request)
		{
			 /* Declaring Variables */
		       String strmsgText = "";
		       
				NewIPDIssueToPatTransBO bo    = null;
				NewIPDIssueToPatTransVO vo    = null;	
				
			   HisUtil hisUtil;
			   try
			   {
				    /* Create Object */
				    hisUtil = new HisUtil("MMS", "IssueToPatientBSODATA");
				         vo = new NewIPDIssueToPatTransVO();
				   	     bo = new NewIPDIssueToPatTransBO();
				   	
				   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				   	/* Calling BO method */
				   	bo.initForViewPage(vo);
				   
				   	formBean.setStrStoreName(vo.getStrStoreName());
				   	formBean.setStrFromDate(hisUtil.getASDate("dd-MMM-yyyy"));
				   	formBean.setStrToDate(hisUtil.getASDate("dd-MMM-yyyy"));
				   	formBean.setStrItemCatgCombo(vo.getStrItemCategoryCmb());
				   
				   
			   }catch(Exception _err){
				   strmsgText = _err.getMessage();
					HisException eObj = new HisException("MMS", "IssueToPatientBSODATA->initViewPageDtl()", strmsgText);
					formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
					formBean.setStrMsgType("1");
					eObj = null;
			   }
			   
		}
		
		
		public static void getViewDtlNEW(NewIPDIssueToPatTransFB formBean,HttpServletRequest request,HttpServletResponse response)
		{
			 /* Declaring Variables */
		       String strmsgText = "";
		       NewIPDIssueToPatTransBO bo    = null;
				NewIPDIssueToPatTransVO vo    = null;
			   try
			   {
				    /* Creating Object */   	
				    vo=new NewIPDIssueToPatTransVO();
				   	bo=new NewIPDIssueToPatTransBO();
				   	/* Value set in Value Object */
				   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				   	vo.setStrStoreName(request.getParameter("storeId"));
				   	vo.setStrCrNo(request.getParameter("itemCatNo"));
				   	vo.setStrFromDate(request.getParameter("fromDate"));
				   	vo.setStrToDate(request.getParameter("ToDate"));
				   	
	                /* Calling BO method */
				    bo.getCRViewDtl(vo); // Pkg_Mms_View.proc_OffLine_IssueNo_dtl MOde 4 
				    
				    String strResult = NewIPDIssueToPatTransHLP.getIssuedDetailNEW(vo.getIssueNoDtlWs());

				    if(strResult!= null && !strResult.equals(""))
					{	
					 	response.setHeader("Cache-Control", "no-cache");
					 	response.getWriter().print(strResult);
					 		 
					}
					else
					{
					    HisException eObj = new HisException("MMS", "IssueToPatientBSODATA->getViewDtl()", vo.getStrMsgString());
						String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
						response.getWriter().print(str);
			    	 }
				   
				   
			   }catch(Exception _err){
				   strmsgText = _err.getMessage();
					HisException eObj = new HisException("MMS", "IssueToPatientBSODATA->getViewDtl()", strmsgText);
					formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
					formBean.setStrMsgType("1");
					eObj = null;
			   }
			   
		}
		
		public static boolean patientDetailNEW(NewIPDIssueToPatTransFB formBean,HttpServletRequest request)
		{

			boolean fRes = true;
			
			    NewIPDIssueToPatTransBO bo    = null;
				NewIPDIssueToPatTransVO vo    = null;
			
				HisUtil hisutil = null;
				String strmsgText = null;
				String strPatientDetailhlp = "",strPrevIssueDrugList="";
						
					try 
					{
						System.out.println("------------ IssueToPatientBSODATA .patientDetailNEW  ------------");
						
						bo = new NewIPDIssueToPatTransBO();
						vo = new NewIPDIssueToPatTransVO();														
						
						formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());						
						vo.setStrHospitalCode(formBean.getStrHospitalCode());
						vo.setStrSeatId(formBean.getStrSeatId());	
						
						vo.setStrIssueNo(formBean.getStrCrNo());
						vo.setStrCrNo(formBean.getStrCrNo());
						vo.setStrCrNum(formBean.getStrCrNo());
						vo.setStrStoreId(formBean.getStrStoreId());
						vo.setStrItemCat(formBean.getStrItemCat());
						
						System.out.println(" vo.getStrIssueNo()----- "+vo.getStrIssueNo());
					    System.out.println(" vo.getStrCrNo()----- "+vo.getStrCrNo());
					    System.out.println(" vo.getStrStoreId()----- "+vo.getStrStoreId());                
					    System.out.println(" vo.getStrItemCat() ----- "+vo.getStrItemCat());
						
						try
						{
							System.out.println("------------ PatientDtlHLP .patientWithAdmissionDtlNEW  ------------");
							
							strPatientDetailhlp = PatientDtlHLP.patientWithAdmissionDtlNEW(formBean.getStrCrNo(), formBean.getStrHospitalCode(), true);
							
						 }
						catch(Exception e)
						{							
								throw new Exception("Invalid C.R. No.");
								
						 }
						
						System.out.println("--strPatientDetailhlp----"+strPatientDetailhlp);
							
						formBean.setStrPatientDetail(strPatientDetailhlp);
						
						
						
						recommendedBy(formBean,request);	
						
						
						if (vo.getStrMsgType().equals("1")) {
							throw new Exception(vo.getStrMsgString());
						}
						
						bo.getItem_ALL_LIST(vo);

						if (vo.getStrMsgType().equals("1")) {
							throw new Exception(vo.getStrMsgString());
						}

						else {
			                  
							System.out.println("------------ NewIPDIssueToPatTransDATA . getIssueDetailsNEW -> NewIPDIssueToPatTransHLP.getItem_ALL_LIST()----------");
							
													
							strPrevIssueDrugList = NewIPDIssueToPatTransHLP.patientRepeatTreatmentDtlfrmIPD(vo.getItemDetailsWS(),vo);
																                 
							//System.out.println("---"+strHlp);
						
							try 
							{
							         formBean.setStrPrevIssueDrugList(strPrevIssueDrugList);

							} catch (Exception e) {
								
								e.printStackTrace();
							}
						}
						
						if (vo.getStrMsgType().equals("1")) {
							throw new Exception(vo.getStrMsgString());
						}
						
						
					} 
					catch (Exception e) 
					{
						
				         if(e.getMessage().contains("C.R."))
				         {				         		
			         		 formBean.setStrErrMsg("Invalid CR. No.");			         		
			         	 }
				         else
				         {
			         		
			         		strmsgText = "ReturnFromTransDATA.patientDetail(vo) --> "+ e.getMessage();
			         		HisException eObj = new HisException("mms","ReturnFromTransDATA->patientDetail()", strmsgText);			         		
					        formBean.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID()	+ "],Contact System Administrator! ");			         		
			         		eObj = null;
			         	}
			        
			        	
			         
			         fRes = false;
			         
					 
					} finally {
						
						if (bo != null)bo = null;
						if (vo != null)vo = null;
						if (hisutil != null)hisutil = null;
					}
					
					return fRes;
			}
		
		/**
		 * This function is used to set initial parameters required to display on main page 
		 * @param formBean
		 */
		public static void recommendedBy(NewIPDIssueToPatTransFB formBean,HttpServletRequest request) 
		{
			NewIPDIssueToPatTransBO bo    = null;
			NewIPDIssueToPatTransVO vo    = null;
			HisUtil hisutil = null;
			String strRecommendCmb = "";
			
			
			
			try 
			{
				System.out.println("------------ NewIPDIssueToPatTransDATA .recommendedBy  ------------");
				
				vo = new NewIPDIssueToPatTransVO();
				bo = new NewIPDIssueToPatTransBO();
				
				hisutil = new HisUtil("mms", "ReturnFromTransDATA");
				String ctDate = hisutil.getASDate("dd-MMM-yyyy");
				formBean.setStrCtDate(ctDate);
						
				String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				String seatid = request.getSession().getAttribute("SEATID").toString();

				String strMode = request.getParameter("strMode");
							
				formBean.setStrMode(strMode);
				formBean.setStrHospitalCode(hosCode);
				formBean.setStrSeatId(seatid);
									
				vo.setStrHospitalCode(hosCode);
				vo.setStrSeatId(seatid);
							
				bo.getRecommendName(vo);
				
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}

				
				if(vo.getRecommendNameWS()!= null && vo.getRecommendNameWS().size() > 0)
				{				
				    strRecommendCmb = hisutil.getOptionValue(vo.getRecommendNameWS(),"0", "0^Select Value", true);
				}
				else
				{
					strRecommendCmb = "<option value='0'>Select Value</option>";
				}
				formBean.setStrRecommendNameCombo(strRecommendCmb);
							
			} catch (Exception e) {
			
				String strmsgText = e.getMessage();
				HisException eObj = new HisException("mms", "ReturnFromTransDATA->recommendedBy()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
			}
			finally {
				if(vo != null) vo = null;
				if(formBean != null) formBean = null;
			}
		}

}