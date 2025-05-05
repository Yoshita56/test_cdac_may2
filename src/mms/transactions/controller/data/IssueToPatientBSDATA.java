/**
 * 
 */
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
import mms.MmsConfigUtil;
import mms.patDtl.PatientDtlHLP;
import mms.patDtl.PatientDtlHLPNew;
import mms.transactions.bo.IssueTransBO;
import mms.transactions.controller.fb.IssueTransFB;
import mms.transactions.controller.hlp.IssueTransHLP;
import mms.transactions.vo.IssueTransVO;

/**
 * Developer : Anshul Jindal (To Continue) Version : 1.0 Date : 02/Apr/2009
 * 
 */
/**
 * @author Balasubramaniam M
 * @version 1.0
 * @since 01/Apr/2009
 * 
 */

public class IssueToPatientBSDATA 
{
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _IssueTransFB
	 * @param request
	 */
	
	public static int printLine = 0;
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
			    
			       strResult = IssueTransHLP.getIssuedDetail(vo.getStrIssueDetailWs());

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
			
			strSearchItemInitView = IssueTransHLP.getIssueDtlsInitView(formBean);

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
//					   System.out.println("Store Name:::"+formBean.getWsIssueDetails().getString(4));
//					   System.out.println("setStrFinalRemarks:::"+formBean.getWsIssueDetails().getString(27));
//					   System.out.println("setStrItemWiseCost::"+formBean.getWsIssueDetails().getString(29));
//					   System.out.println("setStrIssueNo::::"+formBean.getWsIssueDetails().getString(1));
//					   System.out.println("setStrIssueDate:::"+formBean.getWsIssueDetails().getString(2));
//					   System.out.println("setStrPatientName:::"+formBean.getWsIssueDetails().getString(3));
//					   System.out.println("setStrCrNo:::"+formBean.getWsIssueDetails().getString(35));
								
				}
				
				formBean.getWsIssueDetails().beforeFirst();
			    strSearchItemInitView = IssueTransHLP.getIssueDtlsInitView(formBean);

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
			             util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");			
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
	
	public static void afterIssueSave(IssueTransFB fb,HttpServletRequest request)
	{
	
		IssueTransBO bo = null;
		IssueTransVO vo = null;
		String strPatientDtl="";
		String strmsgText = "";		
		String hosCode="";		
		
		try 
		{
			     System.out.println("************** IssueTransDATA --> afterIssueSave()  **********CHK****"+request.getParameter("chk"));
			
				bo = new IssueTransBO();
				vo = new IssueTransVO();
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();		
							
				System.out.println("-getStrIssueNumber ----"+fb.getStrIssueNumber());
				System.out.println("-getStrIssueNo     ----"+fb.getStrIssueNo()); 
				
				vo.setStrIssueNumber(fb.getStrIssueNumber());	
				
				vo.setStrAdmissionDtlHidVal(fb.getStrAdmissionDtlHidVal());				
				vo.setStrDeptName(fb.getStrDeptName());
				vo.setStrPatientDtlHidVal(fb.getStrPatientDtlHidVal());
				vo.setStrStoreId(fb.getStrStoreId());
				vo.setStrItemCat(fb.getStrItemCat());				
				vo.setStrPuk(fb.getStrCrNo());
				
				System.out.println("-Issue No ----"+vo.getStrIssueNumber());
			
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
				
								
				String strRequestTypeId="35";
				
				System.out.println("************** IssueTransDATA --> afterIssueSave() --> PatientDtlHLP.patientWithAdmissionDtl **************");
	
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
				 
				String strAfterSaveVoucher = IssueTransHLP.getAfterSaveVoucher(vo,"1");	
				
				fb.setStrAfterSaveVoucher(strAfterSaveVoucher);
			
			System.out.println("---strAfterSaveVoucher  ----"+strAfterSaveVoucher);
			
			
		} catch (Exception e) {
	
			e.printStackTrace();
			strmsgText = "Issue Desk.IssueTransDATA.getInitDetailForIssuePage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueTransDATA->getIndentDetails()", strmsgText);
			fb.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
	
			eObj = null;
		} finally {
			bo = null;
			vo = null;
	
		}
	
	}
	
	

	 public static void NEW_IPD_ISSUE(IssueTransFB formBean, HttpServletRequest request) 
	 {

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		String[] temp = null;
		String[] strtemp = null;
		
		MmsConfigUtil mcu = null;

		int debugPoint = 0;
		int chkLength = 0;
		
		String strItemIdArray[] = null;
		String strBrandIdArray[] = null;
		String strReservedFlagArray[] = null;
		String stockDtlsId[] = null; // StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No
		String strStochStatusCodeArray[] = null;
		String strGroupIdArray[] = null;
		String strSubGroupIdArray[] = null;
		String strAvlQtyArray[] = null;
		String strAvlQtyUnitIdArray[] = null;
		String strConsumableFlagArray[] = null;
		String strTotalBatch[]          = null;
		
		String[] values = null;
			
		
		try 
		{
			
			System.out.println(" ------- IssueToPatientTransBSDATA.NEW_IPD_ISSUE  ------- ");
			debugPoint = 1;
			bo = new IssueTransBO();
			vo = new IssueTransVO();
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			
					  chkLength  	= formBean.getStrItemDetailsChk().length;		
			strBrandIdArray 	 	= new String[chkLength];
			strItemIdArray 		 	= new String[chkLength];
			strBrandIdArray 	 	= new String[chkLength];
			strReservedFlagArray 	= new String[chkLength];
			stockDtlsId 		 	= new String[chkLength]; // from userHiddenFld=
													// StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No
			strStochStatusCodeArray = new String[chkLength];
			strGroupIdArray 		= new String[chkLength];
			strSubGroupIdArray 		= new String[chkLength];
			strAvlQtyArray 			= new String[chkLength];
			strAvlQtyUnitIdArray 	= new String[chkLength];
			strConsumableFlagArray 	= new String[chkLength];
			strTotalBatch           = new String[chkLength];
			
			
			for (int i = 0; i < chkLength; i++) 
			{

				                   values = formBean.getStrItemDetailsChk()[i].replace("^", "#").split("#");
				        strItemIdArray[i] = values[0];
				       strBrandIdArray[i] = values[1];
				  strReservedFlagArray[i] = values[2];
				       strGroupIdArray[i] = values[3];
				    strSubGroupIdArray[i] = values[4];
				strConsumableFlagArray[i] = values[5];
							  stockDtlsId = formBean.getStockDtlsId();			
				                   values = formBean.getStrAvlQty()[i].replace("^", "#").split("#"); 
				                     temp = formBean.getStrAvlQty()[i].replace("@", "#").split("#");			
				        strAvlQtyArray[i] = temp[0];
				  strAvlQtyUnitIdArray[i] = temp[1];
				  
				         strTotalBatch[i] = formBean.getStrTotalBatch()[i];
		
			}
			
			/*      Single Batch Details        */
			vo.setStrSingleExpiry(formBean.getStrSingleExpiry());
			vo.setStrSingleBatch(formBean.getStrSingleBatch());
			vo.setStrSingleStockRate(formBean.getStrSingleStockRate());
			vo.setStrSingleMfgDate(formBean.getStrSingleMfgDate());		
			vo.setStrStockRate(formBean.getStrStockRate());
			vo.setStrStockQty(formBean.getStrStockQty());
			vo.setStrItemDetailsChk(formBean.getStrItemDetailsChk());
			vo.setStockDtlsId(stockDtlsId);
			vo.setStrItemIdArray(strItemIdArray); 
			vo.setStrBrandIdArray(strBrandIdArray); 
			vo.setStrReservedFlagArray(strReservedFlagArray); 
			vo.setStrStochStatusCodeArray(strStochStatusCodeArray); 
			vo.setStrGroupIdArray(strGroupIdArray); 
			vo.setStrSubGroupIdArray(strSubGroupIdArray); 
			vo.setStrAvlQtyArray(strAvlQtyArray); 
			vo.setStrAvlQtyUnitIdArray(strAvlQtyUnitIdArray); 	
			vo.setStrIssueQtyArray(formBean.getStrIssueQty()); // 19
			vo.setStrTotalBatch(strTotalBatch);
			
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
			
			vo.setStrPrescribedBy(formBean.getStrPrescribedBy());
		    vo.setStrReqPrescribedBy(formBean.getStrPrescribedBy());
			vo.setStrPatientName(formBean.getStrPatientName());
			vo.setStrPatientId((formBean.getCrNo()!=null && !formBean.getCrNo().equals("0")) ?formBean.getCrNo() : "0");
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			
			debugPoint = 3;
			
			vo.setStrStoreId(formBean.getStrStoreId());		
			vo.setStrItemCat(formBean.getStrItemCat());
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
			vo.setStrDrugIssueDate(util.getASDate("dd-MMM-yyyy"));
			
			vo.setStrPayModeVal(formBean.getStrPayMode());
			vo.setStrPayDtlVal(formBean.getStrPayDtl());	
			vo.setStrNetCost(formBean.getStrNetCost());
			
			vo.setStrOutOfStockFlag(formBean.getStrOutOfStockFlag());
			
			debugPoint = 6;
			
			vo.setStrAdmissionDtlHidVal(formBean.getStrAdmissionDtlHidVal());
			
			vo.setStrDeptCode(formBean.getStrAdmissionDtlHidVal().split("\\^")[5]);
			
			vo.setStrCheckBatchExists(formBean.getStrCheckBatchExists());
				
			/*
			0	   NVL(HIPNUM_ADMNO, '0') 
			1	^  NVL(HRGNUM_EPISODE_CODE, '0') 
		    2	^  NVL(HRGNUM_VISIT_NO,'0') 
			3	^  NVL(TO_CHAR(HIPDT_ADMDATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ')
			4	^  NVL(HIPNUM_ADM_ADVNO,'0') 
			5	^  NVL(GNUM_DEPT_CODE,'000')
			6	^  NVL(HIPNUM_WARD_CODE,'0') 
			7	^  NVL(HIPNUM_ROOM_CODE,'0') 
			8	^  NVL(HIPNUM_BED_CODE,'0')
			9	^  NVL(HIPNUM_TREAT_CATEG_CODE,'0')  
		   10	^  NVL(HIPNUM_ISNEWBORN,'0') 
		   11	^  NVL(HIPNUM_MOTHADMNO,'0') 
		   12	^  NVL(HRGNUM_MLC_NO,'0')
		   13	^  NVL(HIPNUM_OCCUP_ID,'0') 
		   14	^  NVL(TO_CHAR(HIPDT_BEDALLOC_DATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ') 
		   15	^  NVL(HIPNUM_LENGTHOFSTAY,'0'))
		   16	^  NVL(GNUM_DEPTUNIT_CODE,'00000')
		   17	^  hblnum_pataccount_status
			*/		  
			
			bo.getdeptname(vo);		
			formBean.setStrDeptName(vo.getStrDeptName());
			vo.setStrDeptName(vo.getStrDeptName());
			/*
			System.out.println("------------------------------ NEW_IPD_ISSUE -------------------------------------");
			System.out.println("-getStrDeptName-----"+vo.getStrDeptName());
			System.out.println("-getStrRequestType-----"+formBean.getStrRequestType());
			System.out.println("-getStrPrescribedBy-----"+formBean.getStrPrescribedBy());
			System.out.println("-getStrPrescribedBy-----"+formBean.getStrPrescribedBy());
			System.out.println("-getStrPatientName-----"+formBean.getStrPatientName());
			System.out.println("-getCrNo-----"+formBean.getCrNo());		
			System.out.println("-getStrStoreId-----"+formBean.getStrStoreId());
			System.out.println("-getStrItemCat-----"+formBean.getStrItemCat());
			System.out.println("-getStrReceiveBy-----"+formBean.getStrReceiveBy());
			System.out.println("-getStrRemarks-----"+formBean.getStrRemarks());
			System.out.println("-getStrCostFinal-----"+formBean.getStrCostFinal());		
			System.out.println("-getStrOffLineEpisode-----"+formBean.getStrOffLineEpisode());
			System.out.println("-getStrApproxAmt-----"+formBean.getStrApproxAmt());		
			System.out.println("-getStrQtyText-----"+formBean.getStrQtyText());
			System.out.println("-getStrDose-----"+formBean.getStrDose());
			System.out.println("-getStrDays-----"+formBean.getStrDays());
			System.out.println("-getStrFrequency-----"+formBean.getStrFrequency());
			System.out.println("-getStrPatientHiddenValue1-----"+formBean.getStrPatientHiddenValue1());
			System.out.println("-getStrPatientDtlHidVal-----"+formBean.getStrPatientDtlHidVal());
			System.out.println("-getStrDrugIssueDate-----"+formBean.getStrDrugIssueDate());
			System.out.println("-getStrPayMode-----"+formBean.getStrPayMode());
			System.out.println("-getStrPayDtl-----"+formBean.getStrPayDtl());
			System.out.println("-getStrNetCost-----"+formBean.getStrNetCost());		
			System.out.println("-getStrDeptCode-----"+formBean.getStrDeptCode());
			System.out.println("-getStrAdmissionDtlHidVal-----"+vo.getStrAdmissionDtlHidVal());
			System.out.println("-getStrPatStatus-----"+formBean.getStrPatStatus()+"--- ISSUE_IPD  ---");
			System.out.println("-------------------------------------------------------------------");	
			*/
			
					
			bo.new_ipd_issue(vo);
			
			debugPoint = 7;			
			
			if (vo.getStrMsgType().equals("1"))
			{	
				throw new Exception(vo.getStrMsgString());
			}
			else 
			{
				    
					formBean.setStrNormalMsg("Drug Successfully Dispensing To CR ["+formBean.getStrCrNo()+"]");
					formBean.setStrIssueNum(vo.getStrIssueNumber());
					formBean.setStrIssueNumber(vo.getStrIssueNumber());
					formBean.setStrVisitDtl("1");				
					formBean.setStrStoreId(vo.getStrStoreId());		
					formBean.setStrItemCat("10");
					formBean.setStrCatgoryCode("10");
					formBean.setStrCrNo(vo.getStrPuk());	
					
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientBSDATA.insertWithoutCrNo()--> "+e.getMessage() + String.valueOf(" :: Debug Point = " + debugPoint);
			
			if(e.getMessage().contains("##") && (e.getMessage().split("\\##")[2].equals("999") || e.getMessage().split("\\##")[2].equals("103")))
				formBean.setStrErrMsg(e.getMessage().split("\\##")[1]);		
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
			             util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");			
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
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
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
	
	public static void GET_PAT_ACC_STATUS(IssueTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{

		IssueTransBO bo = null;
		IssueTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String temp = "";
		try {

			bo = new IssueTransBO();
			voObj = new IssueTransVO();
			
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
			strmsgText = "mms.transactions.IssueToPatientBSDATA.GET_PAT_ACC_STATUS --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueToPatientBSDATA->GET_PAT_ACC_STATUS()", strmsgText);
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
			System.out.println("------------- IssueToPatientBSDATA . getPatientDetails ---------------");
			
			     bo = new IssueTransBO();
			     vo = new IssueTransVO();
			    mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   util = new HisUtil("","");
			
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			String strIssueMode = mcu.getStrIssueMode();
			formBean.setStrIssueMode("0");  // Please Check	
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrItemCat(formBean.getItemCategory());			
			vo.setStrCrNo(formBean.getStrCrNo());
			vo.setStrStoreId(formBean.getStrStoreId());
			
			bo.getPatientAddmissionFlag(vo);		
			
			//System.out.println("Store Id --->>>>"+vo.getStrStoreId());
			
			formBean.setStrInvalidCrFlag(vo.getStrInvalidCrFlag());
			
			bo.getPatientTreatmentDetailfrmIpd(vo);
			
			System.out.println("------A-------IssueToPatientBSDATA .  mms.patDtl.PatientDtlHLP.patientWithAdmissionDtl ---------------"+vo.getStrInvalidCrFlag());
			 
			String strPatientDetails = PatientDtlHLP.patientWithAdmissionDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode(), true);
						
			/*
			 *  Commented  By Amit Kumar For Treatment Details
			 *  On Date 11-Aug-2023
			 *  Same As Indent For Issue Patient 
			 * */	
			//  PKG_MMS_VIEW2.PROC_HRGT_PATIENT_TREATMENT_DTL --[ Mode - 1 ]
			String strPatientTreatmentDtl =  PatientDtlHLP.patientTreatmentDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode());
			
			System.out.println("------B------- IssueToPatientBSDATA .  mms.patDtl.PatientDtlHLP.patientTreatmentDtl_BS ---------------");
			
			//System.out.println("------------- pkg_simple_view.PROC_HRGT_PATIENT_TREATMENT_DTL ---------------");			
						
			//String strPatientTreatmentDtl_BS =  PatientDtlHLP.patientTreatmentDtl_BS(formBean.getStrCrNo(), formBean.getStrHospitalCode());
			//added by shalini on 03-feb-2016 to fetch patient diagnosis details
			
			System.out.println("------C------- IssueToPatientBSDATA.patientDiagDtl ---------------");
			
			String strPatientDiagDetails = patientDiagDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode());
			/*
			 *  Added By Amit Kumar For Treatment Details
			 *  On Date 11-Aug-2023
			 *  Same As Indent For Issue Patient 
			 * */			
			System.out.println("------D------- IssueToPatientBSDATA .  mms.patDtl.PatientDtlHLP.patientTreatmentDtlfrmIPD ---------------");
			
			//System.out.println("-Size------"+vo.getTreatmentDetailWs().size());
			
			// String strIpdIssueDrugHLP = PatientDtlHLP.(vo.getTreatmentDtlHLPWs(),formBean);
			
			String strIpdIssueDrugHLP =  IssueTransHLP.getItemDetails_Drug(vo.getStrItemCat(), vo.getStrHospitalCode(), vo.getTreatmentDtlHLPWs(), "0","0",vo.getStrStoreId());
			/*
			if(dummy2 != null && !dummy2.equals(""))
			{	 
			  formBean.setStrPatientTreatmentDtl(dummy2);
			}
			else
			{	 
			  formBean.setStrPatientTreatmentDtl("");
			}
			*/
						
			
			formBean.setStrPatientDetails(strPatientDetails);
			formBean.setStrPatientTreatmentDtl(strPatientTreatmentDtl);
			//formBean.setStrPatientTreatmentDtl_BS(strPatientTreatmentDtl_BS);
			
			formBean.setStrIpdIssueDrugHLP(strIpdIssueDrugHLP);
			
			formBean.setStrPatientDiagDetails(strPatientDiagDetails);
						
			System.out.println("------------- IssueToPatientBSDATA . getPatientDetails ------- END --------");
			
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
	
	
	/**
	 * Stock item dtls init.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 */
	public static void stockItemDtlsInit(HttpServletRequest request,HttpServletResponse response, IssueTransFB formBean) 
	{
	
		String strSearchItemInitView = "";
		IssueTransBO bo = null;
		IssueTransVO vo = null;
		String                 strMode = "";
		String          strStockStatus = "";
		String         strGenricItemId = "";
		String               strItemId = "";
		String             strIssueQty = "";
		String       strIssueQtyInBase = "";
		String          strFromStoreId = "";
		String         strItemCategory = "";
		String   	   strReservedFlag = "";
		String            strHiddenVal = "";
		String             strUnitName = "";
		try 
		{
			                 strMode = (String) request.getParameter("strMode").split("\\^")[0];  // This is Combination of [ Mode ^ Budget Flag ^ Index ] 
			          strStockStatus = (String) request.getParameter("strStockStatus");
			         strGenricItemId = (String) request.getParameter("strGenItemId");
			               strItemId = (String) request.getParameter("strItemId");
			             strIssueQty = (String) request.getParameter("strIssueQty");
			       strIssueQtyInBase = (String) request.getParameter("strIssueQtyInBase");
			          strFromStoreId = (String) request.getParameter("strStoreId");
			         strItemCategory = (String) request.getParameter("strCatCode");
			   	     strReservedFlag = (String) request.getParameter("strReservedFlag");
			            strHiddenVal = (String) request.getParameter("strHiddenFieldVal");			
			             strUnitName = (String) request.getParameter("strUnitName"); 		
			                      bo = new IssueTransBO();
			                      vo = new IssueTransVO();
			                      
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString()); 
			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrItemCategoryId(strItemCategory);
			formBean.setStrStockStatus(strStockStatus);
			formBean.setStrGenricItemId(strGenricItemId);
			formBean.setStrItemId(strItemId);
			formBean.setStrIndentIssueQty(strIssueQty);
			formBean.setStrIssueQtyInBase(strIssueQtyInBase);
			formBean.setStrReservedFlag(strReservedFlag);
			formBean.setStrHiddenVal(strHiddenVal);
			
			
			vo.setStrModeVal(strMode);
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrStockStatus(formBean.getStrStockStatus());
			vo.setStrGenricItemId(formBean.getStrGenricItemId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrIndentIssueQty(formBean.getStrIndentIssueQty());
			vo.setStrIssueQtyInBase(formBean.getStrIssueQtyInBase());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrReservedFlag(formBean.getStrReservedFlag());
			
			 System.out.println("-----IssueToPatientBSDATA.stockItemDtlsInit ------");
		
			// Calling BO Method
			bo.getStockItemDtlsInitDtls(vo);
	
			if (vo.getStrMsgType().equals("1")) {
	
				throw new Exception(vo.getStrMsgString());
			}
			
			formBean.setStrItemName(vo.getStrItemName());
			formBean.setWsStockDetails(vo.getWsStockDetails());
			formBean.setStrRateUnit(vo.getStrRateUnit());
			formBean.setStrRateInBaseValue(vo.getStrRateInBaseValue());
			//formBean.setStrParentIndex(strParentIndex);
			// "1^0^"+index 
			// This Variable is used to set Budget Avalaible or Not Flag
			formBean.setUsrArg((String) request.getParameter("strMode").split("\\^")[1]);
			// This Variable is Used To Set Index
			formBean.setStrIndex((String) request.getParameter("strMode").split("\\^")[2]);
			
			strSearchItemInitView = IssueTransHLP.getStockItemDtlsInitView(formBean);
			
			//System.out.println("-strSearchItemInitView-----"+strSearchItemInitView);
	
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		}
		catch (Exception e) 
		{
		     e.printStackTrace();	 
			 String strmsgText = "IssueToPatientBSDATA.stockItemDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("IssueDeskTrans",
					"IssueToPatientBSDATA.stockItemDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;
			  
		} finally {
	
			bo = null;
			vo = null;
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
			
			 System.out.println(" ------- IssueToPatientTransBSDATA.getPatientDetails_BS  ------- ");
			 
		    bo = new IssueTransBO();
		    vo = new IssueTransVO();
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


	
	public static void GET_PAT_LIST(IssueTransFB formBean, HttpServletRequest request, HttpServletResponse response) 
	{

			IssueTransBO bo = null;
			IssueTransVO vo = null;
			
			HisUtil util = null;
			String strmsgText = null;
		
		try 
		{
			    System.out.println(" ------- IssueToPatientTransBSDATA.GET_PAT_LIST  ------- ");
			 
				bo = new IssueTransBO();
				vo = new IssueTransVO();
				
				
			
				String strCrNo        = request.getParameter("strCrNo");
				String strDeptCode    = request.getParameter("strDeptCode");
				if (strCrNo == null)
					strCrNo = "0";
				if (strDeptCode == null)
					strDeptCode = "0";
				
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());			
				vo.setStrCrNo(strCrNo);	
				vo.setStrDeptCode(strDeptCode);
				  /*
		          1. P_KEY [ A.HRGNUM_EPISODE_CODE || '^' || A.HRGNUM_VISIT_NO||'^'||A.HRGNUM_PUK ]
		          2. PAT_NAME [ CR_NO ]
		          3. DEPT_NAME
		          4. DEPT_UNIT_NAME
		          5. PRES BY
		          6. PRES_DATE
		          7. DEPT NAME @ DEPT UNIT NAME @ WARD NAME @ ROOM NAME @ BED NAME
		        */
				
				bo.getFrontPageOnlineRequestDtls(vo);  // Pkg_Mms_View.Proc_Issue_Request_Dtls [ Mode - 2 ]
									
				String strReqValues = IssueTransHLP.GET_PAT_LIST_HLP(vo.getStrRequestWs());
				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strReqValues);	
				
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				
		} catch (Exception e) {
				strmsgText = "mms.transactions.IssueToPatientBSDATA.GET_PAT_LIST --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueToPatientBSDATA->GET_PAT_LIST()", strmsgText);
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
	
	public static void getOnlineReqDtl(IssueTransFB formBean, HttpServletRequest request, HttpServletResponse response) 
	{

			IssueTransBO bo = null;
			IssueTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
		
		try 
		{
			 System.out.println(" ------- IssueToPatientTransBSDATA.getOnlineReqDtl  ------- ");
			 
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
									
				String strReqValues = IssueTransHLP.getRequestDtls(vo.getStrRequestWs());
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
	
	
	public static void getItemDetails(IssueTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response ) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		String strItemDetails ="";
		
		try {
			
			 System.out.println(" ------- IssueToPatientTransBSDATA.getItemDetails  ------- ");
			 
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
	
	
public static void getIssuePopUp(IssueTransFB formBean, HttpServletRequest request, HttpServletResponse response) {
		
		IssueTransBO bo    = null;
		IssueTransVO vo    = null;			
		
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
			 System.out.println(" ------- IssueTrans.getIssuePopUp  ------- ");
			 
			   bo = new IssueTransBO();
			   vo = new IssueTransVO();	
			   
			   strStoreId = request.getParameter("storeId");
			   strIssueNo = request.getParameter("issueNo");
			   strCrNo    = request.getParameter("strCrNo");
			   viewMode   = request.getParameter("strMode");  // 3 - Voucher After Save  , 1- View Page Voucher
			   hosCode    = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			   			  	   
			   vo.setStrHospitalCode(hosCode);
			   vo.setStrStoreId(strStoreId);
			   vo.setStrIssueNumber(strIssueNo);
			   vo.setStrIssueNo(strIssueNo);
			   vo.setStrPuk(strCrNo);
			  
			   System.out.println(" ------- getStrHospitalCode  ------- "+vo.getStrHospitalCode());
			   System.out.println(" ------- setStrStoreId  ------- "+vo.getStrStoreId());
			   System.out.println(" ------- setStrIssueNumber  ------- "+vo.getStrIssueNumber());
			   System.out.println(" ------- setStrIssueNo  ------- "+vo.getStrIssueNo());
			   System.out.println(" ------- setStrPuk  ------- "+vo.getStrPuk());
			   System.out.println(" ------- viewMode  ------- "+viewMode);
			   
			  			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}				
		
			
			System.out.println("************** IssueTransDATA --> afterIssueSave() --> mms.patDtl.PatientDtlHLP.patientWithAdmissionDtl **************");

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
			
		    System.out.println("---  IssueTransHLP.getIssueDtlsInitView  ----");
		    if(viewMode.equals("3"))  // Voucher After Save
		    {		 
		        strAfterSaveVoucher = IssueTransHLP.getAfterSaveVoucher(vo,"3");
		    }
		    else
		    {  
		    	//  Voucher In View Page
		    	strAfterSaveVoucher = IssueTransHLP.getAfterSaveVoucher(vo,"1");
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
	

	public static void getIssuePopUp_OLD(IssueTransFB formBean, HttpServletRequest request, 
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
				 System.out.println(" ------- IssueToPatientTransBSDATA.getIssuePopUp  ------- ");
				 
				   bo = new IssueTransBO();
				   vo = new IssueTransVO();							
				   strHospCode = formBean.getStrHospitalCode();
				   strStoreId = request.getParameter("strId");
				   strIssueNo = request.getParameter("issueNo");
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}				
				strPopUp = IssueTransHLP.getIssuePopUpBS(strHospCode,strStoreId,strIssueNo);
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strPopUp);	
							
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
	
	public static void getIssueDetails(IssueTransFB formBean, HttpServletRequest request, HttpServletResponse response)
		{
			
			IssueTransBO bo = null;
			IssueTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			WebRowSet ws = null;
			try {
				 System.out.println(" ------- IssueToPatientTransBSDATA.getIssueDetails  ------- ");
				 
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
					System.out.println("ws.strings()"+ws.getString(1));
					System.out.println("ws.strings()"+ws.getString(2));
				//	System.out.println("ws.strings()"+ws.getString(3));
					
				}*/
			String strIssueDetails = IssueTransHLP.getIssueDetailsBS(ws);
				
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
	
	public static void getRequestDetails(IssueTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		WebRowSet ws = null;
		MmsConfigUtil mcu = null;
		
		try {
			 System.out.println(" ------- IssueToPatientTransBSDATA.getRequestDetails  ------- ");
			 
			bo = new IssueTransBO();
			vo = new IssueTransVO();
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
			
			String strRequestDetails=IssueTransHLP.getRequestDetails(ws);
			
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
	
	public static void getFrequencyDetails(IssueTransFB formBean, HttpServletRequest request) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strFrequencyVal = "";
		String strmsgText = null;
		
		try {
			bo = new IssueTransBO();
			vo = new IssueTransVO();
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
	
	public static void getDoseDetails(IssueTransFB formBean, HttpServletRequest request) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strDosageVal = "";
		String strmsgText = null;
		
		try {
			bo = new IssueTransBO();
			vo = new IssueTransVO();
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
	
	public static void getDeptDetails(IssueTransFB formBean, HttpServletRequest request) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strDeptVal = "";
		String strmsgText = null;
		
		try {
			 System.out.println(" ------- IssueToPatientTransBSDATA.getDeptDetails  ------- ");
			 
			bo = new IssueTransBO();
			vo = new IssueTransVO();
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getDeptDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			
			strDeptVal = util.getOptionValue(vo.getStrDepartmentWs(), "","0^ALL", false);
						
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
	
	
	public static void insertipd(IssueTransFB formBean, HttpServletRequest request) {

		IssueTransBO bo = null;
		IssueTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		String[] temp = null;
		String[] strtemp = null;
		
		MmsConfigUtil mcu = null;
		
		int debugPoint = 0;
				
		try {
			 System.out.println(" ------- IssueToPatientTransBSDATA.insertipd  ------- ");
			 
			debugPoint = 1;
			bo = new IssueTransBO();
			vo = new IssueTransVO();
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

	
	public static void getMmsConfigFlags(IssueTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) 
	{
//		IssueTransBO bo = null;
//		IssueTransVO vo = null;
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
	IssueTransBO bo = new IssueTransBO();
	IssueTransVO vo	= new IssueTransVO();
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
	HisUtil util =  new HisUtil("MMS Transactions", "IssueToPatientBSDATA");	;
		StringBuffer sb = new StringBuffer("");
		vo.setStrCrNo(strCrNo);
		vo.setStrHospitalCode(strHospitalCode);
		
		WebRowSet ws = null;
		String diagName;
		
		sb.append("");
		
		try 
		{
			 System.out.println(" ------- IssueToPatientTransBSDATA.patientDiagDtl_BS  ------- ");
			 
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



public static void getOnlineTreatmentDtl(IssueTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
{

		IssueTransBO bo = null;
		IssueTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
	
	try 
	{
		 System.out.println(" ------- IssueToPatientTransBSDATA.getOnlineTreatmentDtl  ------- ");
			bo = new IssueTransBO();
			vo = new IssueTransVO();
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
			String strReqValues = IssueTransHLP.getOnlineTreatmentDtls(vo.getOnlineTreatmentDtlsWs() , formBean);
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
		   System.out.println(" ------- IssueToPatientTransBSDATA.getBilledItemDtls  ------- ");
		   
		    /* Creating Object */   	
		    vo=new IssueTransVO();
		   	bo=new IssueTransBO();
		   	util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
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
		    
		       strResult = IssueTransHLP.getBilledItemDtls(vo);

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
		   	util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
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
			HisException eObj = new HisException("MMS", "IssueToPatientBSDATA->getViewDtl()", strmsgText);
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
		   System.out.println(" ------- IssueToPatientTransBSDATA.getTariffDtl  ------- ");
		   
		    /* Creating Object */   	
		    vo=new IssueTransVO();
		   	bo=new IssueTransBO();
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
			/*
			 * if(strResult != "") response.getWriter().print(strResult); else
			 * response.getWriter().print(strResult);
			 */
		    
			/* else
			{
			    HisException eObj = new HisException("MMS", "IssueToPatientBSDATA->getTariffDtl()", vo.getStrMsgString());
				       String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 } */
		   
		   
	   }catch(Exception _err){
		   _err.printStackTrace();
		   strmsgText = _err.getMessage();
			HisException eObj = new HisException("MMS", "IssueToPatientBSDATA->getTariffDtl()", strmsgText);
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


	public static void getAlreadyIssueDrug(IssueTransFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
	
	
		IssueTransBO bo = null;
		IssueTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
	
	try 
	{
		System.out.println(" ------- IssueToPatientTransBSDATA.getAlreadyIssueDrug  ------- ");
		
			bo = new IssueTransBO();
			vo = new IssueTransVO();
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

 public static void getDiirecIssueInitData(IssueTransFB formBean, HttpServletRequest request,HttpServletResponse response) 
 {
	// TODO Auto-generated method stub
	
	   IssueTransVO vo = null;
	   IssueTransBO bo = null;
	   HisUtil util = null;
	   String strCatVal=null;
	   String strStoreVal=null;
	   String strPayModeVal=null;
	   String strAdmDtl=null;
	 
	
	     try
	   {
	    	 
	    	    System.out.println(" ------- IssueToPatientTransBSDATA.getDiirecIssueInitData  ------- ");
	    	 	vo=new IssueTransVO();
			   	bo=new IssueTransBO();
			   	util = new HisUtil("MMS Transactions", "IssueToPatientBSDATA");
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	
			   	vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrCrNo(formBean.getStrCrNo());
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

 public static void getReqType(IssueTransFB fb, HttpServletRequest request, HttpServletResponse response) 
 {
	// TODO Auto-generated method stub
	
    String strmsgText = "";
	   IssueTransVO vo = null;
	   IssueTransBO bo = null;
	   HisUtil util = null;
	   String temp="";

	   try
	   {
		    /* Creating Object */   	
		    vo=new IssueTransVO();
		   	bo=new IssueTransBO();
		   	
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

 
 

public static void getEpisodeDtl(IssueTransFB fb, HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	
	IssueTransBO bo = null;
	IssueTransVO voObj = null;
	HisUtil util = null;

	try
	{

		bo = new IssueTransBO();
		voObj = new IssueTransVO();

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

public static void getPresFormDtl(IssueTransFB fb, HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	IssueTransBO bo = null;
	IssueTransVO voObj = null;
	HisUtil util = null;

	try
	{

		bo = new IssueTransBO();
		voObj = new IssueTransVO();

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



	/**
	 * Stock item dtls init.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 */
	public static void getNALIst(HttpServletRequest request,HttpServletResponse response, IssueTransFB formBean) 
	{
	
		String strSearchItemInitView 	= "";
		IssueTransBO 			  bo	= null;
		IssueTransVO 		      vo    = null;
		String                 strCrNo  = "";
		String               storeName  = "";
		String             itemCatName  = "";
		String         strHiddenPatDtl  = "";
		String   strAdmissionDtlHidVal  = "";
		String       strIssueQtyInBase  = "";
		String          strFromStoreId  = "";
		String         strItemCategory  = "";
		HisUtil                   util  = null;	
		try 
		{
			
			 
			 
			         			strCrNo = (String) request.getParameter("crNo");			                
			         	 strFromStoreId = (String) request.getParameter("strStoreId");
			         	strItemCategory = (String) request.getParameter("strCatCode");
			                  storeName = (String) request.getParameter("storeName");
			                itemCatName = (String) request.getParameter("itemCatName");			
			            strHiddenPatDtl = (String) request.getParameter("strHiddenPatDtl"); 	
			      strAdmissionDtlHidVal = (String) request.getParameter("strAdmissionDtlHidVal"); 	
			         
			                         bo = new IssueTransBO();
			                         vo = new IssueTransVO();
			                       util = new HisUtil("MMS Reports", "getNALIst");               
         	formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID")); 
						
			vo.setStrStoreId(strFromStoreId);
			vo.setStrItemCategoryNo(strItemCategory);
			vo.setStrCrNo(strCrNo);			
			vo.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			vo.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			vo.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));	
			
			vo.setStrHiddenPatDtl(strHiddenPatDtl);
			/*
			 * Amika Soni Kumar^
			 * HARISH SONI/Suman Koni^
			 * General^
			 * 24 Yr/F^
			 * HN4543,Venue2 24,Noida,Gautam Buddha Nagar,Uttar Pradesh-230230^
			 * All India Institute of Medical Sciences, Mangalagiri^
			 * null^
			 * 9829234234
			 * */
			vo.setStrAdmissionDtlHidVal(strAdmissionDtlHidVal);
			/*
			   ADMNO^
			   EPCODE^
			   VISITNO^
			   ADMDATETIME^
			   ADMADVNO^
			   DEPTCODE^
			   WARDCODE^
			   ROOMCODE^
			   BEDCODE^
			   TREATCATCODE^
			   ISNEWBORN^
			   MOTHERADMNO^
			   MLCNO^
			   OCCUPID^
			   BEDALLOCDATETIME^
			   LENGTHOFSTAY
			*/									
			
			System.out.println("-----IssueToPatientBSDATA.getNALIst ---PKG_MMS_VIEW2.PROC_HRGT_PATIENT_TREATMENT_DTL-[ Mode - 5 ]--");
			
			
			
			String strRequestTypeId="32";
			
			System.out.println("************** IssueTransDATA --> afterIssueSave() --> PatientDtlHLP.patientWithAdmissionDtl **************");

			String strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(strCrNo, vo.getStrHospitalCode(), true);
			
			System.out.println("*************************************************");

		    vo.setStrPatientDtl(strPatientDtl);
		
			// Calling BO Method
			bo.getNALIst(vo);  // PKG_MMS_VIEW2.PROC_HRGT_PATIENT_TREATMENT_DTL-[ Mode - 5 ]
	
			if (vo.getStrMsgType().equals("1")) {
	
				throw new Exception(vo.getStrMsgString());
			}
						
			strSearchItemInitView = IssueTransHLP.getIPDNAList(vo);
			
			//System.out.println("-strSearchItemInitView-----"+strSearchItemInitView);
	
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		}
		catch (Exception e) 
		{
		     e.printStackTrace();	 
			 String strmsgText = "IssueToPatientBSDATA.getNALIst(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("IssueDeskTrans",
					"IssueToPatientBSDATA.getNALIst(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;
			  
		} finally {
	
			bo = null;
			vo = null;
		}
	
	}
	
	
	
	public static void initViewPageDtl(IssueTransFB formBean,HttpServletRequest request)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
	       
			IssueTransBO bo    = null;
			IssueTransVO vo    = null;	
			
		   HisUtil hisUtil;
		   try
		   {
			    /* Create Object */
			    hisUtil = new HisUtil("MMS", "IssueToPatientBSODATA");
			         vo = new IssueTransVO();
			   	     bo = new IssueTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	/* Calling BO method */
			   	bo.initForViewPage(vo);
			   
			   	formBean.setStrStoreName(vo.getStrStoreName());
			   	formBean.setStrFromDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	formBean.setStrToDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	formBean.setStrItemCatgCombo(vo.getStrItemCategoryCmb());
			   	
			   	formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueToPatientBSODATA->initViewPageDtl()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				
				eObj = null;
		   }
		   
	}
	
	public static void getViewDtlNEW(IssueTransFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
	       IssueTransBO bo    = null;
			IssueTransVO vo    = null;
		   try
		   {
			    /* Creating Object */   	
			    vo=new IssueTransVO();
			   	bo=new IssueTransBO();
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrCrNo(request.getParameter("itemCatNo"));
			   	vo.setStrFromDate(request.getParameter("fromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
			   	
                /* Calling BO method */
			    bo.getCRViewDtl(vo); // Pkg_Mms_View.proc_OffLine_IssueNo_dtl MOde 4 
			    
			    String strResult = IssueTransHLP.getIssuedDetailNEW(vo.getIssueNoDtlWs());

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
			
				eObj = null;
		   }
		   
	}

	
	
	
	

}
