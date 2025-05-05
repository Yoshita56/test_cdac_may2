package mms.reports.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.patDtl.PatientDtlHLP;
import mms.reports.bo.ReturnAgainstIssuedRPTBO;
import mms.reports.controller.fb.ReturnAgainstIssuedRPTFB;
import mms.reports.controller.hlp.ReturnAgainstIssuedRPTHLP;
import mms.reports.vo.ReturnAgainstIssuedRPTVO;

public class ReturnAgainstIssuedRPTDATA {

	public static void initialGenAdd(ReturnAgainstIssuedRPTFB formBean,HttpServletRequest request) {
		ReturnAgainstIssuedRPTVO vo = null;
		ReturnAgainstIssuedRPTBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate;


		try {
			vo = new ReturnAgainstIssuedRPTVO();
			bo = new ReturnAgainstIssuedRPTBO();
			
			hisutil = new HisUtil("mms", "LocalPurchaseMRN_DATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
		
			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);

			bo.initialGenAdd(vo);
			
		if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			String temp = "";
			
			if (vo.getWsStoreNameCombo() != null && vo.getWsStoreNameCombo().size() > 0) {
				if(vo.getWsStoreNameCombo().next())
				{
					vo.setStrStoreId(vo.getWsStoreNameCombo().getString(1));
					vo.getWsStoreNameCombo().beforeFirst();
				}
				temp = hisutil.getOptionValue(vo.getWsStoreNameCombo(), "0","0^All", false, false);

			} else {
				temp = "<option value='0'>All</option>";
			}

			formBean.setStrStoreNameCombo(temp); 
			
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);	
			
		} catch (Exception e) {

			e.printStackTrace();
			
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",	"ReceiveFromThirdPartyTransDATA->initialGenAdd()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			
			hisutil = null;
	
		}
	}
	
	
	public static void getReturnAndIssueDtl(ReturnAgainstIssuedRPTFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
	       ReturnAgainstIssuedRPTVO vo = null;
	       ReturnAgainstIssuedRPTBO bo = null;
		   try
		   {
			    vo=new ReturnAgainstIssuedRPTVO();
			   	bo=new ReturnAgainstIssuedRPTBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("StoreName"));
			   	vo.setStrCrNo(request.getParameter("CrNo"));
			   	vo.setStrFromDate(request.getParameter("FromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
                
			   	bo.getIssuedDtl(vo); // Pkg_Mms_View.proc_OffLine_IssueNo_dtl-MODE 4
			    
			    String strIssueDtl = ReturnAgainstIssuedRPTHLP.getIssuedDetail(vo.getIssueNoDtlWs());
			   	
			    bo.getReturnDtl(vo); // Pkg_Mms_View.proc_OffLine_IssueNo_dtl-MODE 2 
			    
			    String strReturnDtl = ReturnAgainstIssuedRPTHLP.getReturnDetail(vo.getReturnNoDtlWs());
			    
			    if(strIssueDtl!= null && !strIssueDtl.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strIssueDtl+"$"+strReturnDtl);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "ReturnFromTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "ReturnFromTransDATA->getViewDtl()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//formBean.setStrMsgType("1");
				eObj = null;
		   }
	}
	
	
	public static void getReturnVoucherDtl(ReturnAgainstIssuedRPTFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{

		String strSearchItemInitView = "",strPatientDtl="";

		ReturnAgainstIssuedRPTBO bo = null;
		ReturnAgainstIssuedRPTVO vo = null;
		
		try 
		{

			String strMode = (String) request.getParameter("strMode");
			String strFromStoreId = (String) request.getParameter("strStoreId");
			String strReturnNo = (String) request.getParameter("strReturnNo");
			String strCrNo = (String) request.getParameter("crNo")==null?"0":(String) request.getParameter("crNo");			
			String strReturnDate = (String) request.getParameter("strReturnDate");
			
			bo = new ReturnAgainstIssuedRPTBO();
			vo = new ReturnAgainstIssuedRPTVO();

			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			System.out.println("---- ReturnAgainstIssuedRPTDATA . getReturnVoucherDtl --[ pkg_mms_view.proc_issue_detail ]--");
			System.out.println("----------------------------------");
			System.out.println("--strMode        ----"+strMode);
			System.out.println("--strFromStoreId ----"+strFromStoreId);
			System.out.println("--strReturnNo     ----"+strReturnNo);
			System.out.println("--strReturnDate     ----"+strReturnDate);
			System.out.println("--crNo           ----"+strCrNo);
			System.out.println("----------------------------------");
			
			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrReturnNo(strReturnNo);
			formBean.setStrCrno(strCrNo);


			vo.setStrModeVal(formBean.getStrModeVal());
			
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrReturnNo(formBean.getStrReturnNo());
			vo.setStrReturnDate(formBean.getStrReturnDate());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrStoreId(formBean.getStrFromStoreId());
			vo.setStrCrNo(strCrNo);
			
			System.out.println("************** ReturnAgainstIssuedRPTDATA --> getReturnVoucherDtl() --> PatientDtlHLP.patientWithAdmissionDtl **************");
			
			strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(strCrNo, formBean.getStrHospitalCode(), true);
			
			System.out.println("*************************************************");

		    vo.setStrPatientDtl(strPatientDtl);
		    
		    vo.setStrHospitalCode(formBean.getStrHospitalCode());	    
			bo.getReturnVoucherDtls(vo); // pkg_mms_view.proc_issue_detail [ Mode - 6 ]
			
			/*
            1. Return No
            2. Return Date
            3. Patient Name ( Cr No ) @ issue By
            4. Store Name
            5. Generic Name
            6. Brand Name
            7. Batch No
            8. Expiry Date 
            9. Rate Wth Unit
           10. Issue Qty wth Unit
           11. Store Id
           12. Item Id
           13. Brand Id
           14. Batch No
           15. Exp Date
           16. Rate Per Unit
           17. Unit Id
           18. Rate Base Value
           19. NVL
           20. Req Unit Id
           21. Qty Base Value
           22. SL No
           23. Sl No
           24. Catg Code
           25. Rec by
           26. Remarks
           27.Loc @ Dl No
           28.CR No   
         */
			

			if (vo.getStrMsgType().equals("1"))
			{

				throw new Exception(vo.getStrMsgString());
			}
			
			while (vo.getWsIssueDetails().next()) 
			{
				
				vo.setStrIssueDate(vo.getWsIssueDetails().getString(2));
				vo.setStrNameWthCRNo(vo.getWsIssueDetails().getString(3).split("\\@")[0]);
 				vo.setStrStoreName(vo.getWsIssueDetails().getString(4));
 				vo.setStrUserName(vo.getWsIssueDetails().getString(3).split("\\@")[1]);
			}
			vo.getWsIssueDetails().beforeFirst();	
			
			if (vo.getStrMsgType().equals("1")) 
				throw new Exception(vo.getStrMsgString());			
 			 			
 			System.out.println("-WsIssueDetails --Size in HLP ----"+vo.getWsIssueDetails().size());
 			
 			vo.getWsIssueDetails().beforeFirst();
 			
 			String strAfterSaveVoucher = ReturnAgainstIssuedRPTHLP.getReturnVoucher(vo,"1");
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strAfterSaveVoucher);
			System.out.println("---- ReturnFromTransDATA . issueDtlsInitNEW --[ END ]--");
			
		} catch (Exception e) {
			e.printStackTrace();

			String strmsgText = "MmsDATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}
	

	public static void getIssueVoucherDtl(ReturnAgainstIssuedRPTFB formBean, HttpServletRequest request, HttpServletResponse response) {
		
		ReturnAgainstIssuedRPTBO bo    = null;
		ReturnAgainstIssuedRPTVO vo    = null;			
		
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
			 System.out.println(" ------- ReturnAgainstIssuedRPTDATA.getIssueVoucherDtl  ------- ");
			 
			   bo = new ReturnAgainstIssuedRPTBO();
			   vo = new ReturnAgainstIssuedRPTVO();	
			   
			   
			   strHospCode = formBean.getStrHospitalCode();
			   strStoreId = request.getParameter("strId");
			   strIssueNo = request.getParameter("strIssueNo");
			   strCrNo    = request.getParameter("strCrNo");
			   viewMode   = request.getParameter("viewMode");
			   hosCode    = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			   
			   vo.setStrHospitalCode(hosCode);
			   vo.setStrStoreId(strStoreId);
			   vo.setStrIssueNo(strIssueNo);
			   vo.setStrPuk(strCrNo);
			  			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}				
		
			
			System.out.println("************** ReturnAgainstIssuedRPTDATA --> getIssueVoucherDtl() --> mms.patDtl.PatientDtlHLP.patientWithAdmissionDtl **************");

			strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(strCrNo, hosCode, true);
			
			System.out.println("*************************************************");

		    vo.setStrPatientDtl(strPatientDtl);
		    
		    vo.setStrHospitalCode(hosCode);		
		    bo.getIssueVoucherDtls(vo);  // pkg_mms_view.Proc_Emp_Issue_Detail [ Mode - 3 ]
		
		    if (vo.getStrMsgType().equals("1")) 
			throw new Exception(vo.getStrMsgString());
		
			 			
			System.out.println("-WsIssueDetails --Size in HLP ----"+vo.getWsIssueDetails().size());
			
			while(vo.getWsIssueDetails().next())
			{
				vo.setStrIssueDate(vo.getWsIssueDetails().getString(2));
				vo.setStrStoreName(vo.getWsIssueDetails().getString(4));
				
			}
			vo.getWsIssueDetails().beforeFirst();
			
		    if(viewMode.equals("0"))
		    {		 
		        strAfterSaveVoucher = ReturnAgainstIssuedRPTHLP.getIssueVoucher(vo,"2");
		    }
		    else
		    {
		    	strAfterSaveVoucher = ReturnAgainstIssuedRPTHLP.getIssueVoucher(vo,"1");
		    }
		
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strAfterSaveVoucher);	
						
		} catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.ReturnAgainstIssuedRPTDATA.getIssueVoucherDtl --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReturnAgainstIssuedRPTDATA->getIssueVoucherDtl()", strmsgText);
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
		



}
