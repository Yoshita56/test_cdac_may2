package dossier.transaction.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.PatientDtlHLP;
import hisglobal.utility.HisUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.dao.RequestForLPPatientDAO;
import dossier.transaction.bo.DossierRequisitionBO;
import dossier.transaction.controller.fb.DossierRequisitionFB;
import dossier.transaction.controller.hlp.DossierRequisitionHLP;
import dossier.transaction.dao.DossierRequisitionDAO;
import dossier.transaction.vo.DossierRequisitionVO;

public class DossierRequisitionDATA {
	


	 //   private String   contents;
	 //   private String   rptContents;	
		/**
		 * This function used to set initial parameters for view Page.
		 * @param _DossierRequisitionFB
		 * @param request
		 */
		public static void getViewDtl(DossierRequisitionFB _DossierRequisitionFB,HttpServletRequest request,HttpServletResponse response)
		{
			 /* Declaring Variables */
		       String strmsgText = "";
		       DossierRequisitionVO vo = null;
		       DossierRequisitionBO bo = null;
			   HisUtil util = null;
			   String strResult = "";
			   try
			   {
				    /* Creating Object */   	
				    vo=new DossierRequisitionVO();
				   	bo=new DossierRequisitionBO();
				   	util = new HisUtil("MMS Transactions", "IssueTransDATA");
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
				    
				       strResult = DossierRequisitionHLP.getIssuedDetail(vo.getStrIssueDetailWs());

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
					_DossierRequisitionFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
					//_DossierRequisitionFB.setStrMsgType("1");
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
				HttpServletResponse response, DossierRequisitionFB formBean) 
		{

			String strSearchItemInitView = "";
			//boolean printFlag = false;
			
			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;
			String strMode = "";
			String strStoreId = "";
			String strIssueNo = "";

			try {

				    strMode = (String) request.getParameter("strMode");
				 strStoreId = (String) request.getParameter("strStoreId");
				 strIssueNo = (String) request.getParameter("strIssueNo");			
				         bo = new DossierRequisitionBO();
				         vo = new DossierRequisitionVO();
				
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
				
				System.out.println("-----------------------DossierRequisitionDATA . issueDtlsInit()---pkg_dossier_view.Proc_Emp_Issue_Detail--Mode--->>"+formBean.getStrMode()+"---------------");
				
				vo.setStrMode(formBean.getStrMode());
				if(strMode.equals("6"))
					vo.setStrStoreId(formBean.getStrIssueNo().split("@")[2]);
				else
					vo.setStrStoreId(formBean.getStrStoreId());
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrIssueNo(formBean.getStrIssueNo().split("@")[0]);
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
					   formBean.setStrStoreName(formBean.getWsIssueDetails().getString(14));	
					   formBean.setStrPatientName(formBean.getWsIssueDetails().getString(10));
					   formBean.setStrIssueNo(formBean.getWsIssueDetails().getString(11));
					   formBean.setStrPrescribedBy("");
					   formBean.setStrIssueDate(formBean.getWsIssueDetails().getString(12));
					   formBean.setStrCrNo(formBean.getWsIssueDetails().getString(13));	
					   formBean.setStrHindiText("");
					   formBean.setStrRegNo("");	
					   //formBean.setStrMode("1");	
					   formBean.setStrLFAccountNo("");
					   formBean.setStrLocDL("");
					   formBean.setStrDossierName(formBean.getWsIssueDetails().getString(9));
					   formBean.setStrServiceName(formBean.getWsIssueDetails().getString(8));
					   formBean.setStrDepartment(formBean.getWsIssueDetails().getString(17));
					   formBean.setStrServiceName(formBean.getWsIssueDetails().getString(18)+"("+formBean.getWsIssueDetails().getString(8) +")");
					   formBean.setStrCrNo(formBean.getWsIssueDetails().getString(13)+"("+formBean.getWsIssueDetails().getString(19) +")");
					   formBean.setStrPatientType(formBean.getWsIssueDetails().getString(20));
					   if(strMode.equals("6"))
						   formBean.setStrFinalFlag(formBean.getWsIssueDetails().getString(21));
					   formBean.setStrHindiText(formBean.getWsIssueDetails().getString(22));
					   formBean.getWsIssueDetails().beforeFirst();
				}
				
				System.out.println("-----------------------DossierRequisitionDATA . issueDtlsInit()---DossierRequisitionHLP.getIssueDtlsInitView-------------");
				
				strSearchItemInitView = DossierRequisitionHLP.getIssueDtlsInitView(formBean);

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
				HttpServletResponse response, DossierRequisitionFB formBean) 
		{

			String strSearchItemInitView = "";

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;
			String strMode = "";
			String strStoreId = "";
			String strIssueNo = "";

			try {

				    strMode = (String) request.getParameter("strMode");
				 strStoreId = (String) request.getParameter("strStoreId");
				 strIssueNo = (String) request.getParameter("strIssueNo");			
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();
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
//						   System.out.println("Store Name:::"+formBean.getWsIssueDetails().getString(4));
//						   System.out.println("setStrFinalRemarks:::"+formBean.getWsIssueDetails().getString(27));
//						   System.out.println("setStrItemWiseCost::"+formBean.getWsIssueDetails().getString(29));
//						   System.out.println("setStrIssueNo::::"+formBean.getWsIssueDetails().getString(1));
//						   System.out.println("setStrIssueDate:::"+formBean.getWsIssueDetails().getString(2));
//						   System.out.println("setStrPatientName:::"+formBean.getWsIssueDetails().getString(3));
//						   System.out.println("setStrCrNo:::"+formBean.getWsIssueDetails().getString(35));
									
					}
					
					formBean.getWsIssueDetails().beforeFirst();
				    strSearchItemInitView = DossierRequisitionHLP.getIssueDtlsInitView(formBean);

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
		public static void getStoreDtls(DossierRequisitionFB formBean, HttpServletRequest request) 
		{
			DossierRequisitionBO       bo = null;
			DossierRequisitionVO       vo = null;
			HisUtil          util = null;
			String    strStoreVal = "";
			String 	strCatVal="";
			String     strmsgText = null;
			ResourceBundle resObj = null;
			SimpleDateFormat  sdf = null;
			Calendar           c1 = null;
			
			try 
			{
				               bo = new DossierRequisitionBO();
				               vo = new DossierRequisitionVO();
				             util = new HisUtil("MMS Transactions", "IssueTransDATA");			
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
					strStoreVal = util.getOptionValue(vo.getStrStoreWs(),formBean.getStrStoreId(),"0^Select Value", false);
				}
				else
				{
					strStoreVal = "<option value='0'>Select Value</option>";
				}
							
				formBean.setStrStoreValues(strStoreVal);			
				resObj = mms.qryHandler_mms.res;
				if(resObj == null) 
				{
					resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
					mms.qryHandler_mms.res = resObj;
				}
				formBean.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));
				
				String path = "/mms"+request.getParameter("cnt_page")+".cnt";
				
				if(request.getParameter("cnt_page") == null)
				{
					
					path = request.getParameter("strPath");
				}
				if(path != null && path != "")
					formBean.setStrPath(path.trim());
				else
					formBean.setStrPath("/mms/transactions/LPIssueDeskTransCNT.cnt");
				
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
				vo.setStrStoreId(formBean.getStrStoreId().replace("^","#").split("#")[0]);
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
		
		public static void getStoreDtlsView(DossierRequisitionFB formBean, HttpServletRequest request) {

			DossierRequisitionBO bo       = null;
			DossierRequisitionVO vo       = null;
			HisUtil util          = null;
			String strStoreVal    = "";
			String strmsgText     = null;
			ResourceBundle resObj = null;
			SimpleDateFormat  sdf = null;
			Calendar           c1 = null;
			String strConfCatCode = "";
			
			try 
			{
				               bo = new DossierRequisitionBO();
				               vo = new DossierRequisitionVO();
				             util = new HisUtil("MMS Transactions", "IssueTransDATA");			
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
		
		public static void getGroupDetails(DossierRequisitionFB formBean, HttpServletRequest request) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;

			HisUtil util = null;
			String strGroupVal = "";
			String strmsgText = null;
			
			try {
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();
				
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
		
		public static void getItemCatDtls(DossierRequisitionFB formBean,
				HttpServletRequest request, HttpServletResponse response) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO voObj = null;
			String strmsgText = null;
			HisUtil util = null;
			try {

				bo = new DossierRequisitionBO();
				voObj = new DossierRequisitionVO();
				
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
		public static int getissuetopatientcount(DossierRequisitionFB formBean,
				HttpServletRequest request, HttpServletResponse response) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO voObj = null;
			String strmsgText = null;
			HisUtil util = null;
			int temp =0;
			try {

				bo = new DossierRequisitionBO();
				voObj = new DossierRequisitionVO();
				
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
		
		public static void getCancelPatientDetails(DossierRequisitionFB formBean, HttpServletRequest request, 
				HttpServletResponse response)
		{

			DossierRequisitionBO          bo = null;
			DossierRequisitionVO          vo = null;
			MmsConfigUtil        mcu = null;
		
			String        strmsgText = null;
			String strPatientDetails = "";
			String      strIssueMode = "";
			ResourceBundle    resObj = null;
			
			try 
			{
							    bo = new DossierRequisitionBO();
							    vo = new DossierRequisitionVO();
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
			 strPatientDetails = DossierRequisitionHLP.getPatientDtl(formBean);
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
		public static void getPatientDetails(DossierRequisitionFB formBean, HttpServletRequest request, 
							HttpServletResponse response) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			ResourceBundle resObj =  null;
			
			try 
			{
				System.out.println("--------------- DossierRequisitionDATA.getPatientDetails() -----------------");
				     bo = new DossierRequisitionBO();
				     vo = new DossierRequisitionVO();
				    mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				   util = new HisUtil("","");									
				formBean.setStrReOrderFlgColor("LIGHTYELLOW");
				formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));			
				formBean.setStrIssueMode("0");  // Please Check			
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				
				// HLP Method	
				 System.out.println("formBean.getStrCrNo()>>DATA::>"+formBean.getStrCrNo());
				//if(formBean.getStrLFNo()!=null && formBean.getStrLFNo()!="")
				/*
				if(false)
				{
					System.out.println("Issue To PAtient  12");
					vo.setStrLFNo(formBean.getStrLFNo());
					System.out.println("formBean.getStrCrNo()  ::  ::"+formBean.getStrCrNo());
					bo.getLFAccountDetail(vo);
					System.out.println("vo.getStrCrNo()::"+vo.getStrCrNo());
					formBean.setStrCrNo(vo.getStrCrNo());
					if(vo.getStrCrNo() == null || vo.getStrCrNo() =="")
					{
						throw new Exception("LF No. not Exists/closed!");
					}
					else
					{
						System.out.println("Issue To PAtient  13");
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
				*/
					    vo.setStrPuk( formBean.getStrCrNo());					
					    bo.getLFAccountDetail(vo);  // pkg_bill_view.proc_HBLT_PAT_LF_ACCOUNT_DTL  [ Mode = 1]
					    System.out.println("--------- pkg_bill_view.proc_HBLT_PAT_LF_ACCOUNT_DTL  [ Mode = 1]");
					 
						formBean.setStrLFAccountNo(vo.getStrLFAccountNo()); 
						formBean.setStrLFAccountOpenDate(vo.getStrLFAccountOpenDate());
						formBean.setStrLFDepositedAmount(vo.getStrLFDepositedAmount());
						formBean.setStrLFBalanceAmount(vo.getStrLFBalanceAmount());
						formBean.setStrLFAccountStatus(vo.getStrLFAccountStatus());
					 
					//strCrNo
				/*}*/
				 DossierRequisitionDAO.getPatientAccountBalance(vo); //1.bill_mst.get_pat_accountdetails_limit 2 .PKG_MMS_VIEW.proc_hstt_pat_account_dtl[ Mode = 1]
				
				System.out.println("--------- bill_mst.get_pat_accountdetails_limit()");
				 
				System.out.println("--------- PKG_MMS_VIEW.proc_hstt_pat_account_dtl  [ Mode = 1]");
				
				System.out.println("Final CR NO ::::"  +formBean.getStrCrNo());
				
				String strPatientDetails = PatientDtlHLP.patientWithAdmissionDtlRequestForLP(formBean.getStrCrNo(),formBean.getStrHospitalCode(),vo.getStrBillingHiddenValue().split("\\^")[1],vo.getStrPatAccountNo(),true,formBean.getStrPatientType());
				
				System.out.println("--------- HLP 1--strPatientDetails---");
				//System.out.println("strPatientDetails"+strPatientDetails);
				
				//added by shefali on 26-Aug-2014 for patient treatment detail in issue to patient
				String strPatientTreatmentDtl =  PatientDtlHLP.patientTreatmentDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode());
				
				System.out.println("--------- HLP 2--strPatientTreatmentDtl---");
				//added by shalini on 03-feb-2016 to fetch patient diagnosis details
				
				String strPatientDiagDetails = patientDiagDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode());
				
				System.out.println("--------- HLP 3--strPatientDiagDetails---");
				
				formBean.setStrPatientDetails(strPatientDetails);
				formBean.setStrPatientTreatmentDtl(strPatientTreatmentDtl);
				formBean.setStrPatientDiagDetails(strPatientDiagDetails);
				
				bo.getLFAccountDetail(vo);  //  pkg_bill_view.proc_HBLT_PAT_LF_ACCOUNT_DTL [Mode - 1]
				
				System.out.println("--------- pkg_bill_view.proc_HBLT_PAT_LF_ACCOUNT_DTL [ Mode = 1]");			
				
				formBean.setStrDoseFrqFlg("0");
			
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
						
			} catch (Exception e) {
				e.printStackTrace();
				if(e.getMessage().equals("PatientDtlHLP-->patientWithAdmissionDtl-->PatientDtlHLP-->patientDtl-->Invalid CR. No.")){
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
		
		
		
		
		public static void getOnlineReqDtl(DossierRequisitionFB formBean, HttpServletRequest request, HttpServletResponse response) 
		{

				DossierRequisitionBO bo = null;
				DossierRequisitionVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
			
			try 
			{
					bo = new DossierRequisitionBO();
					vo = new DossierRequisitionVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					
					String strIssueMode = mcu.getStrIssueMode();
					formBean.setStrIssueMode(strIssueMode);
					
					vo.setStrHospitalCode(formBean.getStrHospitalCode());
					vo.setStrSeatId(formBean.getStrSeatId());
					vo.setStrCrNumber(formBean.getCrNo());
					
					String strOnlineIssueReqDays = mcu.getStrOnlineIssueDetailsInDays();
					vo.setStrOnlineIssueReqDays(strOnlineIssueReqDays);
					
					bo.getRequestDtls(vo);
										
					String strReqValues = DossierRequisitionHLP.getRequestDtls(vo.getStrRequestWs());
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
		
		public static void getItemDetails(DossierRequisitionFB formBean, HttpServletRequest request, 
				HttpServletResponse response ) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			String strItemDetails ="";
			
			try {
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				String strIssueMode = mcu.getStrIssueMode();
				formBean.setStrIssueMode(strIssueMode);
							
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrRequestNo(request.getParameter("reqNo"));
				vo.setStrCrNumber(request.getParameter("crNo"));
				vo.setStrStoreId(request.getParameter("strId"));		
				
				bo.getItemDetails(vo);
				
				strItemDetails = DossierRequisitionHLP.getItemDetails(vo.getStrHospitalCode(),vo.getStrItemDetailWs());
				
				
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
		
		public static void getIssuePopUp(DossierRequisitionFB formBean, HttpServletRequest request, 
							HttpServletResponse response) {
				
				DossierRequisitionBO bo    = null;
				DossierRequisitionVO vo    = null;			
				
				String strmsgText  = null;			
				String strStoreId  = "";
				String strIssueNo  = "";
				String strHospCode = "";
				String strPopUp    = "";			
				try 
				{
					            bo = new DossierRequisitionBO();
					            vo = new DossierRequisitionVO();							
					   strHospCode = formBean.getStrHospitalCode();
					    strStoreId = request.getParameter("strId");
					    strIssueNo = request.getParameter("issueNo");
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}				
					      strPopUp = DossierRequisitionHLP.getIssuePopUp(strHospCode,strStoreId,strIssueNo);
					      //System.out.println("strPopUp ::"+strPopUp);
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
		
		public static void getIssueDetails(DossierRequisitionFB formBean, HttpServletRequest request, HttpServletResponse response)
			{
				
				DossierRequisitionBO bo = null;
				DossierRequisitionVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				WebRowSet ws = null;
				try {
					bo = new DossierRequisitionBO();
					vo = new DossierRequisitionVO();
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
					//System.out.println("ws.size()"+ws.size());
				/*	while(ws.next())
					{
						System.out.println("ws.strings()"+ws.getString(1));
						System.out.println("ws.strings()"+ws.getString(2));
					//	System.out.println("ws.strings()"+ws.getString(3));
						
					}*/
				String strIssueDetails = DossierRequisitionHLP.getIssueDetails(ws);
					
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
		
		public static void getRequestDetails(DossierRequisitionFB formBean, HttpServletRequest request, HttpServletResponse response) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;

			HisUtil util = null;
			String strmsgText = null;
			WebRowSet ws = null;
			MmsConfigUtil mcu = null;
			
			try {
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();
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
				
				String strRequestDetails=DossierRequisitionHLP.getRequestDetails(ws);
				
				////System.out.println("strRequestDetails---------->"+strRequestDetails);
				
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
		
		public static void getFrequencyDetails(DossierRequisitionFB formBean, HttpServletRequest request) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;

			HisUtil util = null;
			String strFrequencyVal = "";
			String strmsgText = null;
			
			try {
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();
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
		
		public static void getDoseDetails(DossierRequisitionFB formBean, HttpServletRequest request) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;

			HisUtil util = null;
			String strDosageVal = "" ,strDrugNameCmb="";
			String strmsgText = null;
			
			try {
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();
				util = new HisUtil("MMS Transactions", "IssueTransDATA");
				formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
							
				bo.getDoseDetails(vo);
				bo.getStoreNameDetails(vo);
				if (vo.getStrMsgType().equals("1")) {

					throw new Exception(vo.getStrMsgString());

				}
				util = new HisUtil("MMS Transactions", "IssueTransDATA");
				
				strDosageVal = util.getOptionValue(vo.getStrDosageWs(), "0",
						"0^Select Value", false);
				formBean.setStrDosageValues(strDosageVal);
				
				
				
				if (vo.getStrMsgType().equals("1")) {

					throw new Exception(vo.getStrMsgString());

				}
				util = new HisUtil("MMS Transactions", "IssueTransDATA");
				
				strDrugNameCmb = util.getOptionValue(vo.getStrToStoreWs(), "0",
						"0^Select Value", false);
				formBean.setStrDosageValues(strDosageVal);
				formBean.setStrToStoreNameValues(strDrugNameCmb);
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
		
		public static void getDeptDetails(DossierRequisitionFB formBean, HttpServletRequest request) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;

			HisUtil util = null;
			String strDeptVal = "";
			String strmsgText = null;
			
			try {
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();
				util = new HisUtil("MMS Transactions", "IssueTransDATA");

				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrSericeType(formBean.getStrSericeType());
				bo.getDeptDetails(vo);
		
				if (vo.getStrMsgType().equals("1")) {

					throw new Exception(vo.getStrMsgString());

				}
				util = new HisUtil("MMS Transactions", "IssueTransDATA");
				
				strDeptVal = util.getOptionValue(vo.getStrDepartmentWs(), "",
						"0^Select Value", false);
							
				formBean.setStrDepartmentValues(strDeptVal);
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
		
		public static void getUnitDetails(DossierRequisitionFB formBean, HttpServletRequest request, HttpServletResponse response) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;

			HisUtil util = null;
			String strmsgText = null;
			
			try {
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();
				
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
	 //System.out.println("temp"+temp);
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
		
		public static void getUnitDetails1(DossierRequisitionFB formBean, HttpServletRequest request, HttpServletResponse response) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;

			HisUtil util = null;
			String strmsgText = null;
			
			try {
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();
				
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
	// System.out.println("temp"+temp);
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
		public static void getPrescribedBy(DossierRequisitionFB formBean, HttpServletRequest request, HttpServletResponse response) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;

			HisUtil util = null;
			String strmsgText = null;
			
			try {
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();

				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrUnitCode(request.getParameter("unitCode"));
//		System.out.println("vo.getStrUnitCode"+vo.getStrUnitCode());		
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
		
		
		public static void insert(DossierRequisitionFB formBean, HttpServletRequest request) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;

			HisUtil util = null;
			String strmsgText = null;
			String[] temp = null;
			String[] strtemp = null;
			
			MmsConfigUtil mcu = null;
			
			int debugPoint = 0;
					
			try {
				debugPoint = 1;
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();
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
			    //System.out.println(formBean.getStrPrescribedBy());
				vo.setStrPatientName(formBean.getStrPatientName());
				vo.setStrPatientId((formBean.getCrNo()!=null && !formBean.getCrNo().equals("0")) ?formBean.getCrNo() : "0");
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				
				debugPoint = 3;
				
				vo.setStrStoreId(formBean.getStrId().split("\\^")[0]);
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
				System.out.println("CRNO------"+formBean.getCrNo());
				System.out.println("StrCRNO---"+formBean.getStrCrNo());
				
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
					//System.out.println("vo.setStrPuk(I)"+vo.getStrPuk());
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
				
				System.out.println("vo.getStrLFAccountNo() DATA before insert::"+vo.getStrLFAccountNo());
				
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
		
		public static void insertipd(DossierRequisitionFB formBean, HttpServletRequest request) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;

			HisUtil util = null;
			String strmsgText = null;
			String[] temp = null;
			String[] strtemp = null;
			
			MmsConfigUtil mcu = null;
			
			int debugPoint = 0;
					
			try {
				debugPoint = 1;
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();
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
			    System.out.println(formBean.getStrPrescribedBy());
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
				System.out.println("CRNO"+formBean.getCrNo());
				System.out.println("StrCRNO"+formBean.getStrCrNo());
				
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
					System.out.println("vo.setStrPuk(I)"+vo.getStrPuk());
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
				System.out.println("vo.getStrLFAccountNo() DATA before insert::"+vo.getStrLFAccountNo());
				
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
		public static void inserttemp(DossierRequisitionFB formBean, HttpServletRequest request) {

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;

			HisUtil util = null;
			String strmsgText = null;
			String[] temp = null;
			String[] strtemp = null;
			
			MmsConfigUtil mcu = null;
			
			int debugPoint = 0;
					
			try {
				debugPoint = 1;
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();
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
				vo.setStrEpisodeCode(formBean.getStrEpisodeCode());
				
				debugPoint = 2;
				
				vo.setStrPrescribedBy(formBean.getStrPrescribedBy());
			    vo.setStrReqPrescribedBy(formBean.getStrPrescribedBy());
			    System.out.println(formBean.getStrPrescribedBy());
				vo.setStrPatientName(formBean.getStrPatientName());
				vo.setStrPatientId((formBean.getCrNo()!=null && !formBean.getCrNo().equals("0")) ?formBean.getCrNo() : "0");
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				
				debugPoint = 3;
				
				vo.setStrStoreId(formBean.getStrId().split("\\^")[0]);
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
				System.out.println("CRNO"+formBean.getCrNo());
				System.out.println("StrCRNO"+formBean.getStrCrNo());
				
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
				vo.setStrEmpCode(formBean.getStrEmpCode());
				vo.setStrDiagCode(formBean.getStrDiagCode());
				
				debugPoint = 6;
				if(formBean.getStrLFNo()==null ||formBean.getStrLFNo()=="")
				{
					System.out.println("vo.setStrPuk(I)"+vo.getStrPuk());
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
				
				System.out.println("vo.getStrLFAccountNo() DATA before insert::"+vo.getStrLFAccountNo());
				vo.setStrCatgoryCode(formBean.getStrCatgoryCode());
				vo.setStrDeptCode(formBean.getStrDeptCode());
				bo.inserttemp(vo);
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

		public static void insertCancel(DossierRequisitionFB formBean, HttpServletRequest request) 
		{

			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;
			HisUtil util = null;
			String strmsgText = null;		
				
			try 
			{
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();			
				
				formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
				formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
				
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrCrNum(formBean.getStrCrNo());
				vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
				vo.setStrStoreId(formBean.getStrStoreId());
				vo.setStrRemarks(formBean.getStrRemarks());
				vo.setStrIssueNo(formBean.getStrIssueNo());			
				
//				System.out.println("Hosp Code==>"+formBean.getStrHospitalCode());
//				System.out.println("Seat ID==>"+formBean.getStrSeatId());
//				System.out.println("Remarks==>"+formBean.getStrRemarks());
//				System.out.println("Issue No==>"+formBean.getStrIssueNo());
				
				for(int i=0; i<formBean.getStrIssueChkIndex().length; i++)
				{
					if(formBean.getStrIssueChkIndex()[i].equals("1"))
					{
						//System.out.println("Item Brand ID==>"+formBean.getStrItemBrandId()[i]);
						//System.out.println("Batch No==>"+formBean.getStrBatchNo()[i]);
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

		
		public static void getMmsConfigFlags(DossierRequisitionFB formBean, HttpServletRequest request, 
				HttpServletResponse response) 
		{
//			DossierRequisitionBO bo = null;
//			DossierRequisitionVO vo = null;
			MmsConfigUtil mcu = null;
//			HisUtil util = null;
//			String strmsgText = null;
			
				
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
//				    System.out.println("mcu.getStrWithOutCrNoFlg()==>"+mcu.getStrWithOutCrNoFlg());
//				    System.out.println("mcu.getStrCrNoDefault()==>"+mcu.getStrCrNoDefault());
//				    System.out.println("mcu.getStrDoseFrqFlg()==>"+mcu.getStrDoseFrqFlg());
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

		public static void getGenderCombo(DossierRequisitionFB formBean,HttpServletRequest request) 
		{
			DossierRequisitionBO bo = null;
			DossierRequisitionVO vo = null;

			HisUtil util = null;
			String strPatientGenderCodeCmbValues = "";
			String strmsgText = null;
			
			try {
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();
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
		
		public static void insertWithoutCrNo(DossierRequisitionFB formBean, HttpServletRequest request) 
		{
			int debugPoint = 1;
			DossierRequisitionBO bo  			  = null;
			DossierRequisitionVO vo				  = null;
			int chkLength     			  = 0;
			//HisUtil util      			  = null;
			String strmsgText 			  = "";
		/*	String[] temp     			  = null;
			String[] temp1    			  = null;
			String[] temp2    			  = null;
			String[] strtemp  			  = null;
			String[] strtemp1 			  = null;
			String[] values   			  = null;
			String[] strHidDivId          = null;*/
			String strAvlQtyArray[]       = null;
			String strAvlQtyUnitIdArray[] = null;
			String strItemIdArray[]       = null;
			String strItemNameArray[]     = null;
			String strBrandIdArray[]      = null;
			String strGroupIdArray[]      = null;
			String strSubGroupIdArray[]   = null;
			String strInhandQtyUnitId[]   = null;
			String strInhandQtyArray[]    = null;
		/*	String strIssueQtyBaseVal[]   = null;
			String strIssueUnitId[]       = null;
			String strCostFinal[]         = null;*/
			String strConsumeableArray[]  = null;
			String strBatchNo[]           = null;
			String strExpiryDate[]        = null;
			String strDose[]              = null;
			String strFrequency []        = null;
			String strDays[]              = null;
			String strReqQty[]            = null;
		//	String strQtyText[]           = null;		
			String strRate[]              = null;
			String strRateUnitId[]        = null;		
			String strStockStatusCode[]   = null;
			String strItemSlNo[]          = null;
			String strManufDate[]         = null;
			//MmsConfigUtil mcu             = null;
			String[] strItemUserValue     = null;
			//String[] strItemParamValue    = null;
			
			String  userValue = "";
			//String paramValue = "";
			debugPoint = 2;
			
			try 
			{
				bo 						  = new DossierRequisitionBO();
				debugPoint = 3;
				vo                   	  = new DossierRequisitionVO();
				debugPoint = 4;
				//mcu                       = new MmsConfigUtil();
				if(formBean.getItemParamValue() == null || formBean.getItemUserValue() == null)
				{
					throw new Exception("1##Please login Again !! Your session expired !!##103");
				}
				
				chkLength 		          = formBean.getItemParamValue().length;			
			//	strHidDivId 	          = new String[chkLength];
				strAvlQtyArray	          = new String[chkLength];
				strAvlQtyUnitIdArray      = new String[chkLength];
				strBrandIdArray 	      = new String[chkLength];
				strItemIdArray 		      = new String[chkLength];
				strGroupIdArray 	      = new String[chkLength];
				strSubGroupIdArray 	      = new String[chkLength];
				strInhandQtyUnitId 	      = new String[chkLength];
				strInhandQtyArray 	      = new String[chkLength];
		//		strIssueQtyBaseVal        = new String[chkLength];
		//		strIssueUnitId 		      = new String[chkLength];
		//		strCostFinal 		      = new String[chkLength];
				strDose 			      = new String[chkLength];
				strFrequency              = new String[chkLength];
				strDays                   = new String[chkLength];
				strReqQty 			      = new String[chkLength];
				strConsumeableArray       = new String[chkLength];
				strBatchNo 			      = new String[chkLength];
			//	strQtyText 			      = new String[chkLength]; 
				strRate 			      = new String[chkLength]; 
				strRateUnitId 		      = new String[chkLength]; 
				strItemNameArray          = new String[chkLength];
				strExpiryDate             = new String[chkLength];
				strStockStatusCode        = new String[chkLength];
				strItemSlNo               = new String[chkLength];
				strManufDate              = new String[chkLength];
				
				debugPoint = 5;
				for(int i = 0; i < chkLength; i++)
				{
				        strItemNameArray[i] = formBean.getItemParamValue()[i].split("\\^")[0];
					              userValue = formBean.getItemUserValue()[i];
					       strItemUserValue = userValue.split("\\^");			    
					      strItemIdArray[i] = strItemUserValue[0];				
					     strBrandIdArray[i] = strItemUserValue[1];					
					     strGroupIdArray[i] = strItemUserValue[2];				
					  strSubGroupIdArray[i] = strItemUserValue[3];				
					 strConsumeableArray[i] = strItemUserValue[4];
	 				   strInhandQtyArray[i] = strItemUserValue[7];
					  strInhandQtyUnitId[i] = strItemUserValue[8];				
					            strRate [i] = strItemUserValue[9];
					      strRateUnitId [i] = strItemUserValue[10];				
							  strBatchNo[i] = strItemUserValue[15];
						   strExpiryDate[i] = strItemUserValue[16];
							strManufDate[i] = strItemUserValue[17];				
					  strStockStatusCode[i] = strItemUserValue[32];
					         strItemSlNo[i] = strItemUserValue[18];
					
				}
				
				debugPoint = 6;			
				vo.setStrItemNameArray(strItemNameArray);
				vo.setStrStoreId(formBean.getStrStoreId().split("\\^")[0]);
				vo.setStrHospitalName(formBean.getStrStoreId().split("\\^")[1]);
				vo.setStrItemIdArray(strItemIdArray);
				vo.setStrBrandIdArray(strBrandIdArray);
				vo.setStrGroupIdArray(strGroupIdArray);
				vo.setStrSubGroupIdArray(strSubGroupIdArray);
				vo.setStrInhandQtyUnitId(strInhandQtyUnitId);
				vo.setStrInhandQtyArray(strInhandQtyArray);
				vo.setStrBatchNo(strBatchNo);
				vo.setStrExpiryDate(strExpiryDate);
				vo.setStrRate(strRate);
				vo.setStrRateUnitId(strRateUnitId);
				vo.setStrStockStatusCode(strStockStatusCode);
				vo.setStrItemSlNo(strItemSlNo);
				vo.setStrManufDate(strManufDate);			
				vo.setStrItemCat(formBean.getStrItemCat());
				//vo.setStrItemCat("10");
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());			
				vo.setStrOrderBy(formBean.getStrReceiveBy());// Patient Name			
				//Request Details
				vo.setStrReqDeptCode(formBean.getStrDeptCode());
				vo.setStrReqUnitCode(formBean.getStrUnitCode());	
				//System.out.println("In DATA::::"+formBean.getStrPrescribedBy());
				vo.setStrReqPrescribedBy(formBean.getStrPrescribedBy());
				vo.setStrReqPrescriptionDate(formBean.getStrPrescriptionDate());
				vo.setStrReqPrescribedFor(formBean.getStrPrescribedFor());
				vo.setStrReqPrescriptionFrom(formBean.getStrPrescriptionFrom());		
				vo.setItemParamValue(formBean.getItemParamValue());		
				vo.setStrIssueMode(formBean.getStrIssueMode());
				//vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
				//vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
				vo.setStrRequestNo("0");
				vo.setStrPuk("0");
				vo.setStrAdmNo("0");
				vo.setStrRemarks(formBean.getStrRemarks());
				vo.setStrReceiveBy(formBean.getStrReceiveBy());
				vo.setStrApproxAmt("0");			
				// Patient Details
				vo.setStrPatientId(formBean.getStrPatientId());
				//vo.setStrPatientType(formBean.getStrPatientType());
				vo.setStrPatientType("18");   // Poor
				//vo.setStrPatientName(formBean.getStrPatientName());   Check It
				vo.setStrFirstName(formBean.getStrFirstName());
				vo.setStrMiddleName(formBean.getStrMiddleName());
				vo.setStrLastName(formBean.getStrLastName());
				vo.setStrPatientAge(formBean.getStrPatientAge());
				vo.setStrPatientAgeUnit(formBean.getStrPatientAgeUnit());
				//vo.setStrPatientFatherName(formBean.getStrPatientFatherName());
				vo.setStrPatientFatherName("NA");
				vo.setStrPatientGenderCode(formBean.getStrPatientGenderCode());
				//vo.setStrPatientAddress(formBean.getStrPatientAddress());	
				vo.setStrPatientAddress("NA");
				
				debugPoint = 7;
				
				if(formBean.getStrMode().equals("0"))
				{
					vo.setStrReqTypeId("32");
					vo.setStrEmpNo("0");				
				}
				else if(formBean.getStrMode().equals("1"))
				{
					vo.setStrReqTypeId("33");				
				}
				else if(formBean.getStrMode().equals("2"))
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
				
				debugPoint = 8;
				
				vo.setStrIssueQty(formBean.getStrQtyText());
				vo.setStrAvlQtyArray(strAvlQtyArray);
				vo.setStrAvlQtyUnitIdArray(strAvlQtyUnitIdArray);
				vo.setStrReqWardCode("0");
				// Item Details
				strDose=formBean.getStrDose();
				strFrequency=formBean.getStrFrequency();
				strDays=formBean.getStrDays();
				strReqQty=formBean.getStrReqQty();					
				vo.setStrFrequency(strFrequency);					
				vo.setStrDose(strDose);
				vo.setStrDays(strDays);
				vo.setStrReqQty(strReqQty);
				
				debugPoint = 9;
				
//				for(int i = 0; i < chkLength; i++)
//				{
//				System.out.println("strBrandIdArray[i]"+strBrandIdArray[i]);
//				System.out.println("strItemIdArray[i]"+strItemIdArray[i]);
//				System.out.println("strGroupIdArray[i]"+strGroupIdArray[i]);
//				System.out.println("strSubGroupIdArray[i]"+strSubGroupIdArray[i]);
//				System.out.println("strConsumeableArray[i]"+strConsumeableArray[i]);
//				System.out.println("strInhandQtyArray[i]"+strInhandQtyArray[i]);
//				System.out.println("strInhandQtyUnitId[i]"+strInhandQtyUnitId[i]);
//				System.out.println("strBatchNo[i]"+strBatchNo[i]);
//				System.out.println("vo.getStrStockStatusCode"+vo.getStrStockStatusCode()[i]);
//				System.out.println("vo.getStrItemSlNo"+vo.getStrItemSlNo()[i]);
//			    System.out.println("Pres Qty==>"+formBean.getStrPrescQty()[i]);
//				}
//				for(int j=0;j<formBean.getStrNotInListDrugName().length;j++)
//				{
//					System.out.println("Not in Drug List Name==>"+formBean.getStrNotInListDrugName()[j]);
//					System.out.println("Not in Drug List Qty==>"+formBean.getStrNotInListDrugQty()[j]);
//				}			
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrDrugIssueDate(formBean.getStrDrugIssueDate());			
				//System.out.println("Issue Daet=DATA=>"+formBean.getStrDrugIssueDate());
				//System.out.println("Out Of Stoc Flag=DATA=>"+formBean.getStrOutOfStockFlag());
				//System.out.println("DDC Name==>"+formBean.getStoreName());
				vo.setStrStoreName(formBean.getStoreName());
				vo.setStrOutOfStockFlag(formBean.getStrOutOfStockFlag());
				//Calling BO Method
				debugPoint = 10;
				
				bo.insertWithoutCrNo(vo);			
				
				debugPoint = 11;
				
				if (vo.getStrMsgType().equals("1"))
					throw new Exception(vo.getStrMsgString());
				else 
				{	
						formBean.setStrNormalMsg("Data Saved Successfully");
						formBean.setStrVisitDtl("1");
						formBean.setStrIssuingStoreId(vo.getStrStoreId());
						formBean.setStrIssueNo(vo.getStrIssueNumber());
						//formBean.setStrPrescribedBy(vo.getStrReqPrescribedBy());
						//formBean.setStrCrNo(vo.getStrCrNum());
						formBean.setStrIssueNum(vo.getStrIssueNumber());
						formBean.setStrVocherHLPString(vo.getStrVocherHLPString());
						// Calling BO Method This is For Dot Matrix Printing Printing
						/*bo.getIssueDtlsInitDtls(vo);

						if (vo.getStrMsgType().equals("1")) 
						{

							throw new Exception(vo.getStrMsgString());
						}
			 			    formBean.setWsIssueDetails(vo.getWsIssueDetails());
							
							while(formBean.getWsIssueDetails().next())
							{
								
								  (Which Call in Case of Off-Line Issue Voucher)
								  1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued By Doctor ^ Date ^ Cr No ^ Hindi Text  ^ Registration Number
								  2.Drug Name
								  3.Batch No 
								  4.Exp Date
								  5.Issue Qty
								 	
								   //System.out.println("Hidden Val==>"+formBean.getWsIssueDetails().getString(1));
								   formBean.setStrHospitalName(formBean.getWsIssueDetails().getString(1).split("\\^")[0]);
								   formBean.setStrStoreName(formBean.getWsIssueDetails().getString(1).split("\\^")[1]);	
								   formBean.setStrPatientName(formBean.getWsIssueDetails().getString(1).split("\\^")[2]);
								   formBean.setStrIssueNo(formBean.getWsIssueDetails().getString(1).split("\\^")[3]);
								   formBean.setStrPrescribedBy(formBean.getWsIssueDetails().getString(1).split("\\^")[4]);
								   formBean.setStrIssueDate(formBean.getWsIssueDetails().getString(1).split("\\^")[5]);
								   formBean.setStrCrNo(formBean.getWsIssueDetails().getString(1).split("\\^")[6]);	
								   formBean.setStrHindiText(formBean.getWsIssueDetails().getString(1).split("\\^")[7]);	
								  						
							}
							formBean.getWsIssueDetails().beforeFirst();
							//String str = DossierRequisitionHLP.getIssueRptForDotMatrix(formBean);
							//HisPrinter  hisprinter = new HisPrinter();
							//hisprinter.printFile(str, "DWH", request);
							//System.out.println("Dot Matrix PrintStr==>"+str);
	*/						
						
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				strmsgText = "mms.transactions.IssueTransDATA.insertWithoutCrNo()--> "+e.getMessage() + String.valueOf(" :: Debug Point = " + debugPoint);
			//	HisException eObj = new HisException("mms","IssueTransDATA->insertWithoutCrNo()",strmsgText + " :: User Value = " + userValue,request);
				
				if(e.getMessage().contains("##") && (e.getMessage().split("\\##")[2].equals("999") || e.getMessage().split("\\##")[2].equals("103")))
					formBean.setStrErrMsg(e.getMessage().split("\\##")[1]);
				else
					//formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
				
				formBean.setStrIssueNo("0");
			    formBean.setStrIssueNum("0");
			    
				//eObj = null;
			} 
			finally 
			{

				if (bo != null)
					bo = null;
				if (vo != null)
					vo = null;
			}
		 }		


	public static String patientDiagDtl(String strCrNo,String strHospitalCode)
	{
		DossierRequisitionBO bo = new DossierRequisitionBO();
		DossierRequisitionVO vo	= new DossierRequisitionVO();
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
				
				System.out.println("--------- PKG_MMS_VIEW.proc_diag_emp_view  [ Mode = 1]");
				
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
//						if (diagCode == null)
//							diagCode = "----";
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
//						sb.append("<tr><td width='25%' class='LABEL'>Diagnosis Code</td>");
//						sb.append("<td width='25%' class='CONTROL'> ");
//						sb.append(diagCode);
//						sb.append("</td></tr>");
						
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

	public static void getBilledItemDtls(DossierRequisitionFB _DossierRequisitionFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   DossierRequisitionVO vo = null;
		   DossierRequisitionBO bo = null;
		   HisUtil util = null;
		   String strResult = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new DossierRequisitionVO();
			   	bo=new DossierRequisitionBO();
			   	util = new HisUtil("MMS Transactions", "IssueTransDATA");
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
			    
			       strResult = DossierRequisitionHLP.getBilledItemDtls(vo);

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
				_DossierRequisitionFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_DossierRequisitionFB.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}

	public static void save(DossierRequisitionFB _DossierRequisitionFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   DossierRequisitionVO vo = null;
		   DossierRequisitionBO bo = null;
		   HisUtil util = null;
		   String strResult = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new DossierRequisitionVO();
			   	bo=new DossierRequisitionBO();
			   	util = new HisUtil("MMS Transactions", "IssueTransDATA");
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreId(_DossierRequisitionFB.getStrStoreId());
			   	vo.setStrIssueNo(_DossierRequisitionFB.getStrHiddenIssueNo());
			   	vo.setStrCrNo(_DossierRequisitionFB.getCrNo());
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
			    bo.save(vo);		
			    _DossierRequisitionFB.setStoreId(vo.getStrStoreId());
			    if(vo.getStrMsgType().equals("1"))
			    {
			    //_DossierRequisitionFB.setStrNormalMsg("In-Sufficent Stock Available In Store");
			    _DossierRequisitionFB.setStrErrMsg("In-Sufficent Stock Available In Store");
			    //_DossierRequisitionFB.setStrWarningMsg("In-Sufficent Stock Available In Store");
			    //_DossierRequisitionFB.setStrstockflg("1");
			    }else{
			    	//_DossierRequisitionFB.setStrstockflg("2");
			    }
			   
		   }catch(Exception _err){
			   _err.printStackTrace();
			   _DossierRequisitionFB.setStrNormalMsg("Data Saved Successfully");
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueTransDATA->getViewDtl()", strmsgText);
				_DossierRequisitionFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_DossierRequisitionFB.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}


	public static void deleteIssueDtls(DossierRequisitionFB _DossierRequisitionFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   DossierRequisitionVO vo = null;
		   DossierRequisitionBO bo = null;
		   HisUtil util = null;
		   String strResult = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new DossierRequisitionVO();
			   	bo=new DossierRequisitionBO();
			   	util = new HisUtil("MMS Transactions", "IssueTransDATA");
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
				HisException eObj = new HisException("MMS", "IssueTransDATA->getViewDtl()", strmsgText);
				_DossierRequisitionFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_DossierRequisitionFB.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}


	public static void getTariffDtl(DossierRequisitionFB _DossierRequisitionFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   DossierRequisitionVO vo = null;
		   DossierRequisitionBO bo = null;
		   HisUtil util = null;
		   String strResult="" ;
		   int i=0;
		   try
		   {
			    /* Creating Object */   	
			    vo=new DossierRequisitionVO();
			   	bo=new DossierRequisitionBO();
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
				_DossierRequisitionFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_DossierRequisitionFB.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}
	public static void getItemCatValues(DossierRequisitionFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DossierRequisitionBO bo = null;
		DossierRequisitionVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DossierRequisitionBO();
			voObj = new DossierRequisitionVO();
			
			String strStoreId = formBean.getStrId();
			String strModeVal = "5";//request.getParameter("modeVal");
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

			//response.setHeader("Cache-Control", "no-cache");
			//response.getWriter().print(temp);
			formBean.setStrItemCatValues(temp);

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
	
	
	public static void getDossierValues(DossierRequisitionFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DossierRequisitionBO bo = null;
		DossierRequisitionVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DossierRequisitionBO();
			voObj = new DossierRequisitionVO();
			
			String strStoreId = formBean.getStrId();
			String strModeVal = "5";//request.getParameter("modeVal");
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			/*if(strModeVal.equals("0")){
				voObj.setStrReqTypeId("32");
				
			}else if(strModeVal.equals("1")){
				voObj.setStrReqTypeId("33");
				
			}else if(strModeVal.equals("2")){
				
					voObj.setStrReqTypeId("32");
				
			}*/
			
			bo.getDossierDtls(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("Dosssier Transaction", "DossierReqitionDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrDosageWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrDosageWs(), "", "0^Select Value",
						true);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			//response.setHeader("Cache-Control", "no-cache");
			//response.getWriter().print(temp);
			formBean.setStrDossiercatValues(temp);

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
	
	public static void geDeptValues(DossierRequisitionFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DossierRequisitionBO bo = null;
		DossierRequisitionVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DossierRequisitionBO();
			voObj = new DossierRequisitionVO();
			
			String strStoreId = formBean.getStrId();
			String strModeVal = "5";//request.getParameter("modeVal");
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			/*if(strModeVal.equals("0")){
				voObj.setStrReqTypeId("32");
				
			}else if(strModeVal.equals("1")){
				voObj.setStrReqTypeId("33");
				
			}else if(strModeVal.equals("2")){
				
					voObj.setStrReqTypeId("32");
				
			}*/
			
			bo.getDossierDtls(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("Dosssier Transaction", "DossierReqitionDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrDosageWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrDosageWs(), "", "0^Select Value",
						true);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			//response.setHeader("Cache-Control", "no-cache");
			//response.getWriter().print(temp);
			formBean.setStrDossiercatValues(temp);

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

	public static void getOnlineTreatmentDtl(DossierRequisitionFB formBean, HttpServletRequest request, HttpServletResponse response) 
	{

		DossierRequisitionBO bo = null;
		DossierRequisitionVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
		
		try 
		{
				bo = new DossierRequisitionBO();
				vo = new DossierRequisitionVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				String strIssueMode = mcu.getStrIssueMode();
				formBean.setStrIssueMode(strIssueMode);
				
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrCrNumber(formBean.getStrCrNo());
				vo.setStrStoreId(formBean.getStrStoreId());
				vo.setStrCrNo(formBean.getStrCrNo());
				String strOnlineIssueReqDays = mcu.getStrOnlineIssueDetailsInDays();
				vo.setStrOnlineIssueReqDays(strOnlineIssueReqDays);
				
				bo.getTreamentDtls(vo);
				int  rowcount=vo.getOnlineTreatmentDtlsWs().size();		
				String strReqValues = DossierRequisitionHLP.getOnlineTreatmentDtls(vo.getOnlineTreatmentDtlsWs() , formBean);
				formBean.setStrOnlineTreatment(strReqValues);
				//System.out.println("String.valueOf(vo.getOnlineTreatmentDtlsWs().size())"+rowcount);
				formBean.setStrRowCount(String.valueOf(rowcount));
				
		if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
				e.printStackTrace();
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
	
	public static void getDossierItemDetails(DossierRequisitionFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DossierRequisitionBO bo = null;
		DossierRequisitionVO voObj = null;
		DossierRequisitionHLP hlp=null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DossierRequisitionBO();
			voObj = new DossierRequisitionVO();
			hlp= new DossierRequisitionHLP();
			
			System.out.println("--------------DossierRequisitionDATA.getDossierItemDetails()---------pkg_dossier_view.proc_dossier_item_list [ Mode = 1 ]---------");
			
			
			System.out.println("dossiercode::::"+request.getParameter("dossiercode"));
			
			String strStoreId = formBean.getStrId();
			String strModeVal = "5";//request.getParameter("modeVal");
			if (strStoreId == null)
				strStoreId = "0";
			voObj.setStrDossiercat(request.getParameter("dossiercode").toString());
			voObj.setStrStoreId(request.getParameter("storeId").toString());
			//voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			/*if(strModeVal.equals("0")){
				voObj.setStrReqTypeId("32");
				
			}else if(strModeVal.equals("1")){
				voObj.setStrReqTypeId("33");
				
			}else if(strModeVal.equals("2")){
				
					voObj.setStrReqTypeId("32");
				
			}*/
			
			bo.getDossierItemDetails(voObj);  // pkg_dossier_view.proc_dossier_item_list [ Mode = 1 ]
			String hlpString=hlp.getOnlineTreatmentDtls(voObj.getStrDossierItemDtlsWs(), formBean);
			//System.out.println("hlpString"+hlpString);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(hlpString);
			//formBean.setStrDossiercatValues(temp);

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
	public static void getDossierItemDetailsopd(DossierRequisitionFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DossierRequisitionBO bo = null;
		DossierRequisitionVO voObj = null;
		DossierRequisitionHLP hlp=null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DossierRequisitionBO();
			voObj = new DossierRequisitionVO();
			hlp= new DossierRequisitionHLP();
			System.out.println("dossiercode::::"+request.getParameter("dossiercode"));
			
			String strStoreId = formBean.getStrId();
			String strModeVal = "5";//request.getParameter("modeVal");
			if (strStoreId == null)
				strStoreId = "0";
			voObj.setStrDossiercat(request.getParameter("dossiercode").toString());
			voObj.setStrStoreId(request.getParameter("storeId").toString());
			//voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			/*if(strModeVal.equals("0")){
				voObj.setStrReqTypeId("32");
				
			}else if(strModeVal.equals("1")){
				voObj.setStrReqTypeId("33");
				
			}else if(strModeVal.equals("2")){
				
					voObj.setStrReqTypeId("32");
				
			}*/
			
			bo.getDossierItemDetails(voObj);
			String hlpString=hlp.getOnlineTreatmentDtlsopd(voObj.getStrDossierItemDtlsWs(), formBean);
			//System.out.println("hlpString"+hlpString);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(hlpString);
			//formBean.setStrDossiercatValues(temp);

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
	
	public static void getServiceDetails(DossierRequisitionFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DossierRequisitionBO bo = null;
		DossierRequisitionVO voObj = null;
		DossierRequisitionHLP hlp=null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DossierRequisitionBO();
			voObj = new DossierRequisitionVO();
			//hlp= new DossierRequisitionHLP();
			//System.out.println("deptcode::::"+request.getParameter("deptcode"));
			
			String strStoreId = formBean.getStrId();
			String strModeVal = "5";//request.getParameter("modeVal");
			if (strStoreId == null)
				strStoreId = "0";
			voObj.setStrDepartment(request.getParameter("deptcode").toString());
			voObj.setStrSericeType(request.getParameter("ServiceId").toString());
			//voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			/*if(strModeVal.equals("0")){
				voObj.setStrReqTypeId("32");
				
			}else if(strModeVal.equals("1")){
				voObj.setStrReqTypeId("33");
				
			}else if(strModeVal.equals("2")){
				
					voObj.setStrReqTypeId("32");
				
			}*/
			
			bo.getServiceDetails(voObj);
			
			util = new HisUtil("Dosssier Transaction", "DossierReqitionDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrServiceWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrServiceWs(), "", "0^Select Value",
						true);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}
			
			
			//util = new HisUtil("Dosssier Transaction", "DossierReqitionDATA");
			String temp1 = "<option value='0'>Select Value</option>";

			if (voObj.getStrToStoreWs().size() != 0) {
				
				temp1 = util.getOptionValue(voObj.getStrToStoreWs(), "", "0^Select Value",
						true);

			}else{
				
				temp1 = "<option value='0'>Select Value</option>";
			}
			
			
			
			//String hlpString=hlp.getOnlineTreatmentDtls(voObj.getStrDossierItemDtlsWs(), formBean);
			//System.out.println("hlpString"+temp);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp+"###"+temp1);
			//formBean.setStrDossiercatValues(temp);

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
	
	public static void getDossierDetails(DossierRequisitionFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DossierRequisitionBO bo = null;
		DossierRequisitionVO voObj = null;
		DossierRequisitionHLP hlp=null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DossierRequisitionBO();
			voObj = new DossierRequisitionVO();
			//hlp= new DossierRequisitionHLP();
			System.out.println("deptcode::::"+request.getParameter("deptcode"));
			
			/*String strStoreId = formBean.getStrId();
			String strModeVal = "5";//request.getParameter("modeVal");
			if (strStoreId == null)
				strStoreId = "0";*/
			voObj.setStrService(request.getParameter("ServiceId").toString());
			voObj.setStrDepartment(request.getParameter("deptcode").toString());
			
			//voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			/*if(strModeVal.equals("0")){
				voObj.setStrReqTypeId("32");
				
			}else if(strModeVal.equals("1")){
				voObj.setStrReqTypeId("33");
				
			}else if(strModeVal.equals("2")){
				
					voObj.setStrReqTypeId("32");
				
			}*/
			
			bo.getDossierDtls(voObj);
			
			util = new HisUtil("Dosssier Transaction", "DossierReqitionDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrDosageWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrDosageWs(), "", "0^Select Value",
						true);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}
			
			//String hlpString=hlp.getOnlineTreatmentDtls(voObj.getStrDossierItemDtlsWs(), formBean);
			//System.out.println("hlpString"+temp);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
			//formBean.setStrDossiercatValues(temp);

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
	
	public static void INSERT(DossierRequisitionFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DossierRequisitionBO bo = null;
		DossierRequisitionVO voObj = null;
		DossierRequisitionHLP hlp=null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DossierRequisitionBO();
			voObj = new DossierRequisitionVO();
			hlp= new DossierRequisitionHLP();
			
			System.out.println("<<<--------------On Go Click INITVALGO---------------->>>");
			
			System.out.println("dossiercode::::"+request.getParameter("dossiercode"));
			
			String strStoreId = formBean.getStrId();
			String strModeVal = "5";//request.getParameter("modeVal");
			if (strStoreId == null)
				strStoreId = "0";
			//voObj.setStrDossiercat(request.getParameter("dossiercode").toString());
			//voObj.setStrStoreId(strStoreId);
			//voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			/*if(strModeVal.equals("0")){
				voObj.setStrReqTypeId("32");
				
			}else if(strModeVal.equals("1")){
				voObj.setStrReqTypeId("33");
				
			}else if(strModeVal.equals("2")){
				
					voObj.setStrReqTypeId("32");
				
			}*/
			voObj.setStrDossierHlpHidden(formBean.getStrDossierHlpHidden());
			voObj.setStrSericeType(formBean.getStrSericeType());
			voObj.setStrCrNo(formBean.getStrCrNo());
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			voObj.setStrSeatId(request.getSession().getAttribute("SEATID").toString()); //request.getSession().getAttribute("SEAT_ID").toString());
			voObj.setStrDossiercat(formBean.getStrDossiercat());
			voObj.setStrRemarks(formBean.getStrRemarks());
			
			voObj.setItemParamValue(formBean.getItemParamValue());
			
			voObj.setStrQtyText(formBean.getStrQtyText1());
			
			voObj.setStrQtyText1(formBean.getStrQtyText2());
			
			
			voObj.setStrDepartment(formBean.getStrDepartment());
			voObj.setStrService(formBean.getStrService());
			voObj.setIsBroughtByPatient(formBean.getIsBroughtByPatient());
			voObj.setIsBroughtByPatient1(formBean.getIsBroughtByPatient1());
			voObj.setStrToStoreName(formBean.getStrToStoreName());
			voObj.setStrStoreId(formBean.getStrStoreName());
			voObj.setStrAdmissionDtlHidVal(formBean.getStrAdmissionDtlHidVal());
			bo.INSERT(voObj);
			//String hlpString=hlp.getOnlineTreatmentDtls(voObj.getStrDossierItemDtlsWs(), formBean);
		//	System.out.println("hlpString"+hlpString);
			if (voObj.getStrMsgType().equals("1"))
				throw new Exception(voObj.getStrMsgString());
			else 
			{
					formBean.setStrNormalMsg("Data Saved Successfully");
					formBean.setStrIssueNum(voObj.getStrIssueNumber());
					formBean.setStrVisitDtl("1");
					formBean.setStrId(formBean.getStrToStoreName());
					//formBean.setStoreId(formBean.getStrStoreName());
					
			}
			//formBean.setStrDossiercatValues(temp);

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
	
	
	
	public static void INSERTOT(DossierRequisitionFB formBean,HttpServletRequest request, HttpServletResponse response) {

		DossierRequisitionBO bo = null;
		DossierRequisitionVO voObj = null;
		DossierRequisitionHLP hlp=null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DossierRequisitionBO();
			voObj = new DossierRequisitionVO();
			hlp= new DossierRequisitionHLP();
			
			System.out.println("<<<--------------INSERTTOT---------------->>>");
			
			System.out.println("dossiercode::::"+request.getParameter("dossiercode"));
			
			String strStoreId = formBean.getStrId();
			String strModeVal = "5";//request.getParameter("modeVal");
			if (strStoreId == null)
				strStoreId = "0";
			//voObj.setStrDossiercat(request.getParameter("dossiercode").toString());
			//voObj.setStrStoreId(strStoreId);
			//voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			/*if(strModeVal.equals("0")){
				voObj.setStrReqTypeId("32");
				
			}else if(strModeVal.equals("1")){
				voObj.setStrReqTypeId("33");
				
			}else if(strModeVal.equals("2")){
				
					voObj.setStrReqTypeId("32");
				
			}*/
			System.out.println("---------------------------------------------------------------");
			System.out.println("Length::::"+formBean.getStrDossierHlpHidden().length);
			//System.out.println("vo.getItemParamValue()-----"+formBean.getItemParamValue().length);
			if(formBean.getStrDossierHlpHidden() !=null && formBean.getStrDossierHlpHidden().length > 0)
			{
				for(int i=0 ;i<formBean.getStrDossierHlpHidden().length ;i++)
				{
					if(Double.parseDouble(formBean.getStrQtyText2()[i]) > 0)
					{
						String temp1 =formBean.getStrDossierHlpHidden()[i];
						String temp2 =temp1.replace("^", "#");
						String temp[]= temp2.split("#");
						//System.out.println("temp::::::======>"+temp[23]);
						System.out.println("formBean.getStrDossierHlpHidden()["+i+"]::::::======>"+formBean.getStrDossierHlpHidden()[i]);
						System.out.println("formBean.getStrQtyText2()["+i+"]::::::======>"+formBean.getStrQtyText2()[i]);
					}
				}
			}
			if(formBean.getItemParamValue() !=null)
			{				
				System.out.println("vo.getItemParamValue()-----"+formBean.getItemParamValue().length);
			   int  length = formBean.getItemParamValue().length;	
               
				for(int k=0;k<length;k++)
				{
					if(formBean.getStrQtyText1()[k] != null && formBean.getStrQtyText1()[k].length() > 0 && !formBean.getStrQtyText1()[k].equals("0"))
					{
						
						System.out.println("<<<--------------Enter Drug Finder Drugs---------------->>>");
						System.out.println("formBean.getStrQtyText1()-----"+formBean.getStrQtyText1()[k]);
						System.out.println("formBean.getItemParamValue()-----"+formBean.getItemParamValue()[k]);
					}
				}
			}
			System.out.println("---------------------------------------------------------------");
			voObj.setStrDossierHlpHidden(formBean.getStrDossierHlpHidden());
			voObj.setStrSericeType(formBean.getStrSericeType());
			voObj.setStrCrNo(formBean.getStrCrNo());
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			voObj.setStrSeatId(request.getSession().getAttribute("SEATID").toString()); //request.getSession().getAttribute("SEAT_ID").toString());
			voObj.setStrDossiercat(formBean.getStrDossiercat());
			voObj.setStrRemarks(formBean.getStrRemarks());
			
			voObj.setItemParamValue(formBean.getItemParamValue());			
			voObj.setStrQtyText(formBean.getStrQtyText1());			
			voObj.setStrQtyText1(formBean.getStrQtyText2());			
			voObj.setStrDepartment(formBean.getDepartmentCode());
			voObj.setStrService(formBean.getRaisedOperation());
			voObj.setIsBroughtByPatient(formBean.getIsBroughtByPatient());
			voObj.setIsBroughtByPatient1(formBean.getIsBroughtByPatient1());
			voObj.setStrToStoreName(formBean.getStrToStoreName());
			voObj.setStrStoreId(formBean.getStrStoreName());
			voObj.setStrAdmissionDtlHidVal(formBean.getStrAdmissionDtlHidVal());
			voObj.setOtReqNo(formBean.getOtReqNo());
			voObj.setRaisedOperation(formBean.getRaisedOperation());
			voObj.setDepartmentCode(formBean.getDepartmentCode());
			
			bo.INSERTOT(voObj);
			 
			 
			 String dossierStatusString=DossierRequisitionDAO.getDossierStatusString(voObj);
			 
			 dossierStatusString = "Dossier Saved Successfully.#"+dossierStatusString;
			 
			 response.setHeader("Cache-Control", "no-cache");
		        response.setHeader("Pragma", "no-cache");
		        PrintWriter writer = response.getWriter();
		        writer.print(dossierStatusString);
		        writer.flush();
		        writer.close();

			
		//	request.getSession().setAttribute("RKS",voObj); //Vo is set into session
			
			
			//String hlpString=hlp.getOnlineTreatmentDtls(voObj.getStrDossierItemDtlsWs(), formBean);
		//	System.out.println("hlpString"+hlpString);
			if (voObj.getStrMsgType().equals("1"))
				throw new Exception(voObj.getStrMsgString());
			else 
			{
					formBean.setStrNormalMsg("Data Saved Successfully");
					formBean.setStrIssueNum(voObj.getStrIssueNumber());
					formBean.setStrVisitDtl("1");
					formBean.setStrId(formBean.getStrToStoreName());
					//formBean.setStoreId(formBean.getStrStoreName());
					
			}
			//formBean.setStrDossiercatValues(temp);

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
	
	
	
	
	public static void INSERTOPD(DossierRequisitionFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DossierRequisitionBO bo = null;
		DossierRequisitionVO voObj = null;
		DossierRequisitionHLP hlp=null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DossierRequisitionBO();
			voObj = new DossierRequisitionVO();
			hlp= new DossierRequisitionHLP();
			
			System.out.println("<<<--------------INSERTOPD---------------->>>");
			System.out.println("dossiercode::::"+request.getParameter("dossiercode"));
			
			String strStoreId = formBean.getStrId();
			String strModeVal = "5";//request.getParameter("modeVal");
			if (strStoreId == null)
				strStoreId = "0";
			//voObj.setStrDossiercat(request.getParameter("dossiercode").toString());
			//voObj.setStrStoreId(strStoreId);
			//voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			/*if(strModeVal.equals("0")){
				voObj.setStrReqTypeId("32");
				
			}else if(strModeVal.equals("1")){
				voObj.setStrReqTypeId("33");
				
			}else if(strModeVal.equals("2")){
				
					voObj.setStrReqTypeId("32");
				
			}*/
			voObj.setStrDossierHlpHidden(formBean.getStrDossierHlpHidden());
			voObj.setStrSericeType(formBean.getStrSericeType());
			voObj.setStrCrNo(formBean.getStrCrNo());
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			voObj.setStrSeatId(request.getSession().getAttribute("SEATID").toString()); //request.getSession().getAttribute("SEAT_ID").toString());
			voObj.setStrDossiercat(formBean.getStrDossiercat());
			voObj.setStrRemarks(formBean.getStrRemarks());
			
			voObj.setItemParamValue(formBean.getItemParamValue());
			
			voObj.setStrQtyText(formBean.getStrQtyText1());
			
			voObj.setStrQtyText1(formBean.getStrQtyText2());
			
			
			voObj.setStrDepartment(formBean.getStrDepartment());
			voObj.setStrService(formBean.getStrService());
			voObj.setIsBroughtByPatient(formBean.getIsBroughtByPatient());
			voObj.setIsBroughtByPatient1(formBean.getIsBroughtByPatient1());
			voObj.setStrToStoreName(formBean.getStrToStoreName());
			voObj.setStrStoreId(formBean.getStrStoreName());
			voObj.setStrAdmissionDtlHidVal(formBean.getStrAdmissionDtlHidVal());
			voObj.setStrAvalqty(formBean.getStrAvalqty());
			voObj.setStrRateDefault(formBean.getStrRateDefault());
			voObj.setStrItemBatchRate(formBean.getStrItemBatchRate());
			
			voObj.setStrPatientDtlHidVal(formBean.getStrPatientDtlHidVal());
			//vo.getStrPatientDtlHidVal()
			bo.INSERTOPD(voObj);
			//String hlpString=hlp.getOnlineTreatmentDtls(voObj.getStrDossierItemDtlsWs(), formBean);
		//	System.out.println("hlpString"+hlpString);
			if (voObj.getStrMsgType().equals("1"))
				throw new Exception(voObj.getStrMsgString());
			else 
			{
					formBean.setStrNormalMsg("Data Saved Successfully");
					formBean.setStrIssueNum(voObj.getStrIssueNumber());
					formBean.setStrVisitDtl("1");
					formBean.setStrId(formBean.getStrToStoreName());
					//formBean.setStoreId(formBean.getStrStoreName());
					
			}
			//formBean.setStrDossiercatValues(temp);

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
	
	
	//Added By Ranjit for Dossier OT Integration 
	
	  public static void getOperationName(DossierRequisitionFB formBean,
				HttpServletRequest request, HttpServletResponse response){
		  
		     DossierRequisitionVO voObj =new DossierRequisitionVO (); 
		
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			
			//voObj.setAllOperationCodes(formBean.getAllOperationCodes());
			voObj.setDepartmentCode(formBean.getDepartmentCode());
			
			voObj.setOtReqNo(formBean.getOtReqNo());
		
			Map operatonMap=DossierRequisitionDAO.getOperationName(voObj);
			
			request.getSession().setAttribute("OTOPERATIONNAMELIST", operatonMap);
			
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
					}
					
			}
	  
	  
	  
	  
		// Added By Ranjit for Dossier OT Integration
	  public static void getDossierStatusString(DossierRequisitionFB formBean,HttpServletRequest request, HttpServletResponse response){
		  
		  DossierRequisitionVO voObj =new DossierRequisitionVO (); 
		  

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			
			//voObj.setAllOperationCodes(formBean.getAllOperationCodes());
			voObj.setDepartmentCode(formBean.getDepartmentCode());
			
			voObj.setOtReqNo(formBean.getOtReqNo());
		
			String dossierStatusString=DossierRequisitionDAO.getDossierStatusString(voObj);
			formBean.setDossierStatusString(dossierStatusString);
			
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
					}
					
			}
	  
	
		// Added By Ranjit for Dossier OT Integration
	  public static void getOTDossierId(DossierRequisitionFB formBean,
				HttpServletRequest request, HttpServletResponse response){
		  
		  DossierRequisitionVO voObj =new DossierRequisitionVO (); 
		  
		 // voObj.setStrStoreId(request.getParameter("storeId").toString());
			//voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			
			voObj.setAllOperationCodes(formBean.getAllOperationCodes());
			voObj.setDepartmentCode(formBean.getDepartmentCode());
			voObj.setRaisedOperation(formBean.getRaisedOperation());
			voObj.setOtReqNo(formBean.getOtReqNo());
		
			
			Map raiseddossierMap=DossierRequisitionDAO.getRaisedOTDossier(voObj);
			Map dossierMap=DossierRequisitionDAO.getOTDossierId(voObj);
			
			//request.getSession().setAttribute("OTDossierMap", dossierMap);
			
			 Iterator<Map.Entry<String, String>> itr = dossierMap.entrySet().iterator(); 
	          String responseString="";
		        while(itr.hasNext())
		        { 
		             Map.Entry<String, String> entry = itr.next(); 
		             System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue()); 
		             
		             if(raiseddossierMap.containsKey(entry.getKey())){
		            	 responseString=responseString+"<input type='radio' value="+entry.getKey()+" disabled  name='strDossiercat' id='strDossiercat' onchange='getDossierItemDtls()'  >"+entry.getValue();
		            	 
		             }else{
		            	 responseString=responseString+"<input type='radio' value="+entry.getKey()+"  name='strDossiercat' id='strDossiercat' onchange='getDossierItemDtls()'  >"+entry.getValue();	 
		             }
		             
		             
		        } 
		        
		        
		        response.setHeader("Cache-Control", "no-cache");
	             response.setHeader("Pragma", "no-cache");
	             PrintWriter writer;
				try {
					writer = response.getWriter();
					
					System.out.println("responseString=="+responseString);
			
	             writer.print(responseString);
	             writer.flush();
	             writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
					}
					
			}
	  
	  
		// Added By Ranjit for Dossier OT Integration  
  public static void rejectDossier(DossierRequisitionFB formBean,HttpServletRequest request, HttpServletResponse response){
		  
		  DossierRequisitionVO voObj =new DossierRequisitionVO (); 
		  
		  try {
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			
			//voObj.setAllOperationCodes(formBean.getAllOperationCodes());
			voObj.setDepartmentCode(formBean.getDepartmentCode());
			
			voObj.setOtReqNo(formBean.getOtReqNo());
			voObj.setRaisedOperation(formBean.getRaisedOperation());
			voObj.setStrDossiercat(formBean.getStrDossiercat());
		
			DossierRequisitionDAO.rejectDossier(voObj);
			String dossierStatusString=DossierRequisitionDAO.getDossierStatusString(voObj);
			
			  response.setHeader("Cache-Control", "no-cache");
	             response.setHeader("Pragma", "no-cache");
	             PrintWriter writer;
				
					writer = response.getWriter();
					
					System.out.println("responseString=="+dossierStatusString);
			
	             writer.print(dossierStatusString);
	             writer.flush();
	             writer.close();
			
				}catch(Exception e){
					e.printStackTrace();
				}
			
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
					}
					
			}
  
  
	// Added By Ranjit for Dossier OT Integration
  public static void ajaxGetDossierStatusString(DossierRequisitionFB formBean,HttpServletRequest request, HttpServletResponse response){
	  
	  DossierRequisitionVO voObj =new DossierRequisitionVO (); 
	  
	  try {
		voObj.setStrHospitalCode(formBean.getStrHospitalCode());
		
		//voObj.setAllOperationCodes(formBean.getAllOperationCodes());
		voObj.setDepartmentCode(formBean.getDepartmentCode());
		
		voObj.setOtReqNo(formBean.getOtReqNo());
		voObj.setRaisedOperation(formBean.getRaisedOperation());
		voObj.setStrDossiercat(formBean.getStrDossiercat());
	
		String dossierStatusString=DossierRequisitionDAO.ajaxGetDossierStatusString(voObj);
		
		  response.setHeader("Cache-Control", "no-cache");
             response.setHeader("Pragma", "no-cache");
             PrintWriter writer;
			
				writer = response.getWriter();
				
				System.out.println("responseString=="+dossierStatusString);
		
             writer.print(dossierStatusString);
             writer.flush();
             writer.close();
		
			}catch(Exception e){
				e.printStackTrace();
			}
		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
				}
				
		}
	  
	

}
