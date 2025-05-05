package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;


import mms.transactions.bo.SolutionDeskBO;

import mms.transactions.controller.action.Download;

import mms.transactions.controller.fb.SolutionDeskFB;

import mms.transactions.controller.hlp.SolutionDeskTransHLP;


import mms.transactions.vo.SolutionDeskVO;


public class SolutionDeskDATA {
	
	

	public static void initialAdd(SolutionDeskFB formBean,
			HttpServletRequest request) {

		SolutionDeskBO bo = null;
		SolutionDeskVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String SubGroupCmb = "";
		
		String ItemCmb = "";
		String strTemp = "";

		try {
			bo = new SolutionDeskBO();
			vo = new SolutionDeskVO();
			

			hisutil = new HisUtil("mms", "HelpDeskDATA");
			
			
			if (!formBean.getComboValue().equals("")) 
			{
				String strCmbNames = formBean.getComboValue();
				String[] temp = strCmbNames.replace("^", "#").split("#");
				formBean.setStrStoreName(temp[0]);
				formBean.setStrGroupName(temp[1]);
			

			}

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			String strStoreId = formBean.getCombo()[0];
			String MenuId = formBean.getCombo()[1]; //menu ID
			String strpriority=formBean.getStrpriority();
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);
			
			vo.setStrCtDate(ctDate);

			//vo.setStrItemCategoryNo("10");

			formBean.setStrGroupId(MenuId);
			//formBean.setStrDefaultCurrencyCode(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			
			//bo.initialAdd(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} 
		catch (Exception e) 
		{
           
			strmsgText = "HelpDeskDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"HelpDeskDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	
	
	



	
	/**
	 * to insert the data
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void insert(SolutionDeskFB formBean) 
	{
		String strmsgText = "";
		SolutionDeskBO bo = null;
		SolutionDeskVO vo = null;

		MmsConfigUtil mmsUtil = null;

		try 
		{
			bo = new SolutionDeskBO();
			////System.out.println("getStrsubmitby :"+formBean.getStrsubmitby());
			vo = (SolutionDeskVO) TransferObjectFactory.populateData("mms.transactions.vo.SolutionDeskVO", formBean);
			////System.out.println("getStrsubmitby :"+formBean.getStrsubmitby());
			mmsUtil = new MmsConfigUtil(formBean.getStrHospitalCode());

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			            
			//vo.setStrInHandQuantityUnitID(formBean.getStrInHandQuantityUnitID().replace("^", "#").split("#")[0]);
			//vo.setStrUnitRateID(formBean.getStrUnitRateID().replace("^", "#").split("#")[0]);
			//vo.setStrUnitSaleID(formBean.getStrUnitSaleID().replace("^", "#").split("#")[0]);
			//vo.setStrItemCategoryNo("10");
			//String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = formBean.getStrSeatId();

			String strStoreId = formBean.getCombo()[0];
			String MenuId = formBean.getCombo()[1]; //menu ID
			String strpriority=formBean.getStrpriority();

			//if (formBean.getStrBatchNo().trim().equals("0")|| formBean.getStrBatchNo().trim().length() < 1) 
			//{
				//vo.setStrBatchNo(mmsUtil.getStrBatchNo());
			//}
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);
			vo.setStrGroupId(MenuId);
			vo.setStrpriority(strpriority);
			vo.setStrprobsub(formBean.getStrprobsub());
			vo.setStrprobdesc(formBean.getStrprobdesc());
			vo.setStrsubmitby(formBean.getStrsubmitby());
			vo.setStrstatusid("1");
			////System.out.println("status :"+formBean.getCombo()[2]);
			////System.out.println("seatid :"+seatid);
			////System.out.println("strStoreId :"+strStoreId);
			////System.out.println("MenuId :"+MenuId);
			////System.out.println("strpriority :"+strpriority);
			////System.out.println("prob sub :"+formBean.getStrprobsub());
			////System.out.println("prob desc :"+formBean.getStrprobdesc());
			////System.out.println("getStrsubmitby :"+formBean.getStrsubmitby());
			
			

			//vo.setStrStockStatus(formBean.getStrStockStatus());
			////System.out.println("Stock Status==>"+formBean.getStrStockStatus());

			bo.insert(vo);
			
			if (vo.getStrMsgType().equals("5"))
			{
				formBean.setStrErr(vo.getStrMsgString());
				
			}
			else
			{	
				if (vo.getStrMsgType().equals("1"))
				{
					formBean.setStrErr(vo.getStrMsgString());
					
					throw new Exception(vo.getStrMsgString());
				}
				else
				{	
			       formBean.setStrMsg("Problem Has Been Taken Into Our Records " +
			       		               "We will Resolve As Soon As Possible");
				}   
			}  
			//vo.setStrHospitalCode(hosCode);
			
			//vo.setStrCtDate(ctDate);

		} catch (Exception e) {

			strmsgText = "HelpDeskDATA.insert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"HelpDeskDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {

			bo = null;
			vo = null;
			mmsUtil = null;

		}
	}

	
	
	public static void getViewInitialVal(SolutionDeskFB formBean,
			HttpServletRequest request) {
		SolutionDeskBO bo = null;
		SolutionDeskVO vo = null;
		String strmsgText = "";
		String str1 = "";
		String str2 = "";
		String str3 = "";
		String strChk = "";
		String path = "";
		String[] strActive = null;
		String[] strAcknowledge = null;

		try {
			bo = new SolutionDeskBO();
			vo = new SolutionDeskVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			path = "/mms" + request.getParameter("cnt_page") + ".cnt";

			if (request.getParameter("cnt_page") == null) {

				path = request.getParameter("strPath");
			}
           ////System.out.println("Path "+path);
			formBean.setStrPath(path.trim());

			//String comboVal = request.getParameterValues("combo")[0];
			//formBean.setStrComboVal(comboVal);

			//if (comboVal.equals("0")) { // Active
				// //System.out.println("inif");
				strChk = request.getParameter("chk");
				strActive = strChk.replace('@', '#').split("#");
				////System.out.println("VIEWStoreId "+strActive[1]);
				////System.out.println("VIEWTransaction "+strActive[0]);
				
			    vo.setStrStoreId(strActive[1]);
				vo.setStrTransNo(strActive[0]);
				//vo.setStrReqTypeId(strActive[2]);
				vo.setStrHospitalCode(hosCode);
				//vo.setStrRemarks(formBean.getStrRemarks());
				 
				bo.getAcknowledgeVal(vo);

				WebRowSet ws = vo.getStrAcknowledgeDtlWs();
				
				//WebRowSet ws1 = vo.getStrItemDtlWs();

				//ws.beforeFirst();
				str1 = SolutionDeskTransHLP.getAcknowledgeDetails(ws);
				//ws1.beforeFirst();
				//str2 = AcknowledgeTransHLP.getItemDetails(ws1);

				formBean.setStrAcknowledgeDetails(str1);
				formBean.setSolStrID(ws.getString(1));
				////System.out.println("SolStrIDDATA:"+formBean.getSolStrID());
				
				//formBean.setStrItemDetails(str2);

			//} 
		/*else 
				if (comboVal.equals("1")) { // Acknowledge

				// //System.out.println("inelse");
				strChk = request.getParameter("chk");
				strAcknowledge = strChk.replace('@', '#').split("#");
				vo.setStrStoreId(strAcknowledge[1]);
				vo.setStrTransNo(strAcknowledge[0]);
				//vo.setStrReqTypeId(strAcknowledge[2]);
				vo.setStrHospitalCode(hosCode);
				//vo.setStrRemarks(formBean.getStrRemarks());

				//bo.getAcknowledgeVal1(vo);

				WebRowSet ws = vo.getStrAcknowledgeDtlWs();
				WebRowSet ws1 = vo.getStrItemDtlWs();
				WebRowSet ws2 = vo.getStrAckDtlWs();

				ws.beforeFirst();
				str1 = AcknowledgeTransHLP.getAcknowledgeDetails(ws);
				ws1.beforeFirst();
				str2 = AcknowledgeTransHLP.getItemDetails(ws1);
				ws2.beforeFirst();
				str3 = AcknowledgeTransHLP.getAckDtls(ws2);

				formBean.setStrAcknowledgeDetails(str1);
				formBean.setStrItemDetails(str2);
				formBean.setStrAckDtls(str3);
				// //System.out.println("str3--"+str3);
			} */

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "HelpDeskDATA.getViewInitialVal(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"HelpDeskDATA->getAcknowledgeVal()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}
	
	public static void SolInsert(SolutionDeskFB formBean,
			HttpServletRequest request) {
		SolutionDeskBO bo = null;
		SolutionDeskVO vo = null;
		String strmsgText = "";
		String str1 = "";
		String str2 = "";
		String str3 = "";
		String strChk = "";
		String path = "";
		String[] strActive = null;
		String[] strAcknowledge = null;

		try {
			////System.out.println("DATA Class entered");
			bo = new SolutionDeskBO();
			vo = new SolutionDeskVO();
			
			String seatid = request.getSession().getAttribute("SEATID").toString();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			path = "/mms" + request.getParameter("cnt_page") + ".cnt";

			if (request.getParameter("cnt_page") == null) {

				path = request.getParameter("strPath");
			}
          // //System.out.println("Path "+path);
			formBean.setStrPath(path.trim());

		
			  
				String sol=formBean.getStrprobsol();
				String remarks=formBean.getStrremarks();
				
				
				vo.setStrHospitalCode(hosCode);
				String comboVal = request.getParameterValues("combo")[1];

				

					strChk = formBean.getChk()[0];

					strActive = strChk.replace('@', '#').split("#");

		
				vo.setStrStoreId(strActive[0]);
				vo.setStrTransNo(strActive[1]);
				vo.setStrHiddenValue(formBean.getStrHiddenValue());
				
				String strAckDtl = formBean.getStrHidVal();
				String[] temp = strAckDtl.replace('^', '#').split("#");
				////System.out.println("Approved DATA:"+formBean.getStrApproved());
				////System.out.println("Rejected  DATA:"+formBean.getStrRejected());
				////System.out.println("temp[1]:"+temp[1]);
				////System.out.println("temp[12]:"+temp[6]);
				String EntrSolFlg=formBean.getStrApproved();
				String RejectFlg=formBean.getStrRejected();
				if(EntrSolFlg.equals("1"))
				{
				  vo.setStrMode("1");
				  ////System.out.println("APPROVED MODE");
				}
				if(RejectFlg.equals("2"))
				{
					vo.setStrMode("2");
					////System.out.println("REJECTED MODE");
				}
				vo.setSolStrid(temp[6]);
				vo.setSolTransid(temp[1]);
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrprobsol(sol);
				vo.setStrremarks(remarks);
				vo.setStrsubmitby(formBean.getStrsubmitby());
				vo.setStrSeatId(seatid);

				bo.insert(vo);

				

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			else
			{	
		       formBean.setStrMsg("Thank You For Resolving the Problem");
			}   

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "SolDeskDATA.SolInsert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SolDeskDATA->SolInsert()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}
	
	
	public static void DownloadFile(SolutionDeskFB formBean,
			HttpServletRequest request,HttpServletResponse response) {
		
		SolutionDeskBO bo = null;
		SolutionDeskVO vo = null;
		Download dl=null;
		String strmsgText = "";
		String str1 = "";
		String str2 = "";
		String str3 = "";
		String strChk = "";
		String path = "";
		String[] strActive = null;
		//String[] strAcknowledge = null;

		try {
			
			bo = new SolutionDeskBO();
			vo = new SolutionDeskVO();
			dl = new Download();
			
			//String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					//.toString();

		//	path = "/mms" + request.getParameter("cnt_page") + ".cnt";

		//	if (request.getParameter("cnt_page") == null) {

			//	path = request.getParameter("strPath");
			//}
         // //System.out.println("Path "+path);
		//	formBean.setStrPath(path.trim());

			//String comboVal = request.getParameterValues("combo")[0];
			//formBean.setStrComboVal(comboVal);

			//if (comboVal.equals("0")) { // Active
				// //System.out.println("inif");
				//strChk = request.getParameter("chk");
			//	strActive = strChk.replace('@', '#').split("#");
			//	//System.out.println("StoreId "+strActive[0]);
				////System.out.println("Transaction "+strActive[1]);
				//vo.setStrStoreId(strActive[1]);
				//vo.setStrTransNo(strActive[0]);
				//vo.setStrReqTypeId(strActive[2]);
				//vo.setStrHospitalCode(hosCode);
				//vo.setStrRemarks(formBean.getStrRemarks());

				//bo.getAcknowledgeVal(vo);

				//WebRowSet ws = vo.getStrAcknowledgeDtlWs();
				//WebRowSet ws1 = vo.getStrItemDtlWs();

				//ws.beforeFirst();
				//str1 = HelpDeskTransHLP.getAcknowledgeDetails(ws);
				//ws1.beforeFirst();
				//str2 = AcknowledgeTransHLP.getItemDetails(ws1);

				//formBean.setStrAcknowledgeDetails(str1);
				//formBean.setStrItemDetails(str2);
			
			////System.out.println("DATA CLASS ENTERED");
			//String stros=dl.getClientSystemOsType(request);
			////System.out.println("OS TYPE"+stros);
			
			//vo.setStrStoreId(request.getParameter("hiddenValue").split("\\^")[1]);
			//vo.setStrTransNo(request.getParameter("hiddenValue").split("\\^")[0]);
			//bo.getFileName(vo);
			String StrFile = request.getParameter("hiddenValue").split("\\^")[7];
			String strFileName = StrFile.replace("@$@$", "%");
			////System.out.println("strFileName ::"+strFileName);
			if(strFileName!=null)
			{
			dl.doDownload(request,response,strFileName);
			
			}
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "SolDeskDATA.getViewInitialVal(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SolDeskDATA->DownloadFile()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}
	
	public static void getViewSolVal(SolutionDeskFB formBean,
			HttpServletRequest request) {
		SolutionDeskBO bo = null;
		SolutionDeskVO vo = null;
		String strmsgText = "";
		String str1 = "";
		String str2 = "";
		String str3 = "";
		String strChk = "";
		String path = "";
		String[] strActive = null;
		String[] strAcknowledge = null;

		try {
			bo = new SolutionDeskBO();
			vo = new SolutionDeskVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			path = "/mms" + request.getParameter("cnt_page") + ".cnt";

			if (request.getParameter("cnt_page") == null) {

				path = request.getParameter("strPath");
			}
           ////System.out.println("Path "+path);
			formBean.setStrPath(path.trim());

			//String comboVal = request.getParameterValues("combo")[0];
			//formBean.setStrComboVal(comboVal);

			//if (comboVal.equals("0")) { // Active
				// //System.out.println("inif");
				strChk = request.getParameter("chk");
				strActive = strChk.replace('@', '#').split("#");
				////System.out.println("StoreId "+strActive[0]);
				////System.out.println("Transaction "+strActive[1]);
				vo.setStrStoreId(strActive[1]);
				vo.setStrTransNo(strActive[0]);
				//vo.setStrReqTypeId(strActive[2]);
				vo.setStrHospitalCode(hosCode);
				//vo.setStrRemarks(formBean.getStrRemarks());

				bo.getSolViewVal(vo);

				WebRowSet ws = vo.getStrSolViewWs();
				//WebRowSet ws1 = vo.getStrItemDtlWs();

				//ws.beforeFirst();
				str1 = SolutionDeskTransHLP.getSolViewDtl(ws);
				//ws1.beforeFirst();
				//str2 = AcknowledgeTransHLP.getItemDetails(ws1);

				formBean.setStrAcknowledgeDetails(str1);
				//formBean.setStrItemDetails(str2);

			//} 
		/*else 
				if (comboVal.equals("1")) { // Acknowledge

				// //System.out.println("inelse");
				strChk = request.getParameter("chk");
				strAcknowledge = strChk.replace('@', '#').split("#");
				vo.setStrStoreId(strAcknowledge[1]);
				vo.setStrTransNo(strAcknowledge[0]);
				//vo.setStrReqTypeId(strAcknowledge[2]);
				vo.setStrHospitalCode(hosCode);
				//vo.setStrRemarks(formBean.getStrRemarks());

				//bo.getAcknowledgeVal1(vo);

				WebRowSet ws = vo.getStrAcknowledgeDtlWs();
				WebRowSet ws1 = vo.getStrItemDtlWs();
				WebRowSet ws2 = vo.getStrAckDtlWs();

				ws.beforeFirst();
				str1 = AcknowledgeTransHLP.getAcknowledgeDetails(ws);
				ws1.beforeFirst();
				str2 = AcknowledgeTransHLP.getItemDetails(ws1);
				ws2.beforeFirst();
				str3 = AcknowledgeTransHLP.getAckDtls(ws2);

				formBean.setStrAcknowledgeDetails(str1);
				formBean.setStrItemDetails(str2);
				formBean.setStrAckDtls(str3);
				// //System.out.println("str3--"+str3);
			} */

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "HelpDeskDATA.getViewInitialVal(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"HelpDeskDATA->getAcknowledgeVal()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}
	
}
