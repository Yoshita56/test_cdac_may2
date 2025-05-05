package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.AcknowledgeTransBO;
import mms.transactions.controller.fb.AcknowledgeTransFB;
import mms.transactions.controller.hlp.AcknowledgeTransHLP;
import mms.transactions.vo.AcknowledgeTransVO;

public class AcknowledgeTransBSDATA 
{

	public static void getInitialVal(AcknowledgeTransFB formBean,HttpServletRequest request) 
	{
		AcknowledgeTransBO bo = null;
		AcknowledgeTransVO vo = null;
		String strmsgText = "";
		String str1 = "";
		String str2 = "";
		String[] strChk = null;
		String path = "";
		String[] strActive = null;

		try {
			bo = new AcknowledgeTransBO();
			vo = new AcknowledgeTransVO();
			if (request.getParameter("cnt_page") != null) {
				path = "/mms" + request.getParameter("cnt_page") + ".cnt";
			} else {
				path = formBean.getStrPath();
			}

			if (request.getParameter("cnt_page") == null) {

				path = request.getParameter("strPath");
			}

			formBean.setStrPath(path.trim());

			String comboVal = request.getParameterValues("combo")[1];

			formBean.setStrComboVal(comboVal);

			if (comboVal.equals("0")) {

				strChk = request.getParameterValues("chk");
				strActive = strChk[0].replace('@', '#').split("#");

			}

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(strActive[0]);
			vo.setStrTransNo(strActive[1]);
			vo.setStrReqTypeId(strActive[2]);

			bo.getAcknowledgeVal(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
            formBean.setStrViewMode("0");
			WebRowSet ws = vo.getStrAcknowledgeDtlWs();
			formBean.setStrItemDtlWs(vo.getStrItemDtlWs());
            while(ws.next())
            {
               formBean.setStrRequestType(ws.getString(12));	
            }				
			ws.beforeFirst();
			str1 = AcknowledgeTransHLP.getAcknowledgeDetails(ws);
			
			str2 = AcknowledgeTransHLP.getItemDetails(formBean);

			formBean.setStrAcknowledgeDetails(str1);
			formBean.setStrItemDetails(str2);
			formBean.setChk(strChk);

			formBean.setCombo(request.getParameterValues("combo"));
			
			formBean.setStrStoreId(vo.getStrStoreId());
			formBean.setStrTransNo(vo.getStrTransNo());
			formBean.setStrReqTypeId(vo.getStrReqTypeId());

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "AcknowledgeTransDATA.getInitialVal(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AcknowledgeTransDATA->getAcknowledgeVal()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	public static void getInitialVal1(AcknowledgeTransFB formBean,HttpServletRequest request) 
	{
		AcknowledgeTransBO bo = null;
		AcknowledgeTransVO vo = null;
		String strmsgText = "";
		String str1 = "";
		String str2 = "";
		String[] strChk = null;
		String path = "";
		String[] strActive = null;

		try {
			bo = new AcknowledgeTransBO();
			vo = new AcknowledgeTransVO();
			if (request.getParameter("cnt_page") != null) {
				path = "/mms" + request.getParameter("cnt_page") + ".cnt";
			} else {
				path = formBean.getStrPath();
			}

			if (request.getParameter("cnt_page") == null) {

				path = request.getParameter("strPath");
			}

			formBean.setStrPath(path.trim());

			String comboVal = request.getParameterValues("combo")[1];

			formBean.setStrComboVal(comboVal);

			if (comboVal.equals("0")) {

				strChk = request.getParameterValues("chk");
				strActive = strChk[0].replace('@', '#').split("#");

			}

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(strActive[0]);
			vo.setStrTransNo(strActive[1]);
			vo.setStrReqTypeId(strActive[2]);
			//System.out.println("In the getInitialVal1");
			bo.getAcknowledgeVal_voucher(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
            formBean.setStrViewMode("0");
			WebRowSet ws = vo.getStrAcknowledgeDtlWs();
			formBean.setStrItemDtlWs(vo.getStrItemDtlWs());
			//System.out.println("ws size ::"+ws.size());
            while(ws.next())
            {//System.out.println("In the loop");
               formBean.setStrRequestType(ws.getString(12));	
            }				
			if(ws.size() > 0)
            ws.beforeFirst();
			//System.out.println("before HLP");
			str1 = AcknowledgeTransHLP.getAcknowledgeDetails(ws);
			//System.out.println("After HLP");
			str2 = AcknowledgeTransHLP.getItemDetails(formBean);
        
			formBean.setStrAcknowledgeDetails(str1);
			formBean.setStrItemDetails(str2);
			formBean.setChk(strChk);
			
			formBean.setCombo(request.getParameterValues("combo"));
			
			formBean.setStrStoreId(vo.getStrStoreId());
			formBean.setStrTransNo(vo.getStrTransNo());
			formBean.setStrReqTypeId(vo.getStrReqTypeId());
			
			
			formBean.setStrWarningMsg("Data Acknowledge Successfully!!!");

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "AcknowledgeTransDATA.getInitialVal1(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AcknowledgeTransDATA->getInitialVal1()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	public static void getViewInitialVal(AcknowledgeTransFB formBean,
			HttpServletRequest request) {
		AcknowledgeTransBO bo = null;
		AcknowledgeTransVO vo = null;
		String strmsgText = "";
		String str1 = "";
		String str2 = "";
		String str3 = "";
		String strChk = "";
		String path = "";
		String[] strActive = null;
		String[] strAcknowledge = null;
		

		try {
			bo = new AcknowledgeTransBO();
			vo = new AcknowledgeTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			path = "/mms" + request.getParameter("cnt_page") + ".cnt";

			if (request.getParameter("cnt_page") == null) {

				path = request.getParameter("strPath");
			}

			formBean.setStrPath(path.trim());

			String comboVal = request.getParameterValues("combo")[1];
			formBean.setStrComboVal(comboVal);
			formBean.setStrViewMode("1");            
			if (comboVal.equals("0")) 
			{ // Active
				// //System.out.println("inif");
				strChk = request.getParameter("chk");
				strActive = strChk.replace('@', '#').split("#");
				vo.setStrStoreId(strActive[0]);
				vo.setStrTransNo(strActive[1]);
				vo.setStrReqTypeId(strActive[2]);
				vo.setStrHospitalCode(hosCode);
				vo.setStrRemarks(formBean.getStrRemarks());
                // Calling BO method
				bo.getAcknowledgeVal(vo);

				WebRowSet ws = vo.getStrAcknowledgeDtlWs();
				formBean.setStrItemDtlWs(vo.getStrItemDtlWs());
                while(ws.next())
                {
                   formBean.setStrRequestType(ws.getString(12));	
                }				
				ws.beforeFirst();
				str1 = AcknowledgeTransHLP.getAcknowledgeDetails(ws);
				
				str2 = AcknowledgeTransHLP.getViewItemDetails(formBean);

				formBean.setStrAcknowledgeDetails(str1);
				formBean.setStrItemDetails(str2);

			} 
			else if (comboVal.equals("1")) 
			{ // Acknowledge

				// //System.out.println("inelse");
				strChk = request.getParameter("chk");
				strAcknowledge = strChk.replace('@', '#').split("#");
				vo.setStrStoreId(strAcknowledge[0]);
				vo.setStrTransNo(strAcknowledge[1]);
				vo.setStrReqTypeId(strAcknowledge[2]);
				vo.setStrHospitalCode(hosCode);
				vo.setStrRemarks(formBean.getStrRemarks());

				bo.getAcknowledgeVal1(vo);

				WebRowSet ws = vo.getStrAcknowledgeDtlWs();
				formBean.setStrItemDtlWs(vo.getStrItemDtlWs());
                while(ws.next())
                {
                   formBean.setStrRequestType(ws.getString(12));	
                }				
				ws.beforeFirst();
				str1 = AcknowledgeTransHLP.getAcknowledgeDetails(ws);
				
				str2 = AcknowledgeTransHLP.getViewItemDetails(formBean);
				
				WebRowSet ws2 = vo.getStrAckDtlWs();			
				ws2.beforeFirst();
				str3 = AcknowledgeTransHLP.getAckDtls(ws2);

				formBean.setStrAcknowledgeDetails(str1);
				formBean.setStrItemDetails(str2);
				formBean.setStrAckDtls(str3);
				// //System.out.println("str3--"+str3);
			}

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			////System.out.println("Trans No:::::==>"+vo.getStrTransNo());
			formBean.setStrStoreId(vo.getStrStoreId());
			formBean.setStrTransNo(vo.getStrTransNo());
			formBean.setStrReqTypeId(vo.getStrReqTypeId());
			
			   formBean.setStrAckStatus("1");

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "AcknowledgeTransDATA.getViewInitialVal(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AcknowledgeTransDATA->getAcknowledgeVal()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}

	/**
	 * This function used to set initial parameters for view Page.
	 * @param _BreakageItemDtlTransFB
	 * @param request
	 */
	public static void getTransferDtl(AcknowledgeTransFB _AcknowledgeTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   AcknowledgeTransVO vo = null;
		   AcknowledgeTransBO bo = null;
		   String strResult = "A";
		   try{
			   	
			    vo=new AcknowledgeTransVO();
			   	bo=new AcknowledgeTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreId(request.getParameter("storeId"));
			   	vo.setStrTransNo(request.getParameter("transferNo"));
			   	//vo.setStrTransferDate(request.getParameter("transferDate"));
			   	
			   	bo.getTransferDtl(vo);
			   
			    strResult=AcknowledgeTransHLP.getTransferDetails(vo.getTransferDtlWs(),request.getParameter("dwhName"));
			    if(strResult!= null)
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	
				 	response.getWriter().print(strResult);
				 		 
				}
				 else
				 {
				    HisException eObj = new HisException("MMS", "AcknowledgeTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "AcknowledgeTransDATA->getViewDtl()", strmsgText);
				_AcknowledgeTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_AcknowledgeTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	public static boolean insertRecord(AcknowledgeTransFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		AcknowledgeTransVO vo = null;
		AcknowledgeTransBO bo = null;
		String strMsg = "";
		String strChk = "";
		String[] strActive = null;
		String strAckDtl = "";
		String[] temp = null;
		boolean retValue = true;

		HisUtil hisutil = null;

		try {
			hisutil = new HisUtil("MMS Transactions", "AcknowledgeTransDATA");

			bo = new AcknowledgeTransBO();
			vo = new AcknowledgeTransVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrRemarks(formBean.getStrRemarks());

			String comboVal = request.getParameterValues("combo")[1];

			if (comboVal.equals("0")) {

				strChk = formBean.getChk()[0];

				strActive = strChk.replace('@', '#').split("#");

			}
			////System.out.println("strChk" + strChk);
			vo.setStrStoreId(strActive[0]);
			vo.setStrTransNo(strActive[1]);
			vo.setStrAckDate(hisutil.getASDate("dd-MMM-yyyy"));
			vo.setStrReqTypeId(strActive[2]);

			// from item details hlp

			vo.setStrHiddenValue(formBean.getStrHiddenValue());

			// from acknowledge hlp
			strAckDtl = formBean.getStrHidVal();
			temp = strAckDtl.replace('^', '#').split("#");

			vo.setStrStrId(temp[0]);
			vo.setStrToStrId(temp[1]);
			vo.setStrItemCatNo(temp[2]);
			vo.setStrToStrName(temp[3]);
			vo.setStrReceivedQty(formBean.getStrReceivedQty());
//			for(int i=0;i<formBean.getStrHiddenValue().length;i++)
//			{
//				//System.out.println("Bkg Qty==>"+formBean.getStrBkgQty()[i]);
//				//System.out.println("Rece Qty==>"+formBean.getStrReceivedQty()[i]);
//			}
			
            // Calling BO Method
			bo.insertRecord(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}
			else 
			{
				strMsg = "Record Saved Successfully!";
				formBean.setStrNormalMsg(strMsg);
				
				/*
				 * ackStatus '0' => No Report will be generated.
				 * ackStatus '1' => Report will be generated. (e.g. in case of Issue Request)
				 * Condemnation Request(Consumable) 	==> 16
				 * Return Request 						==> 18
				 * Condemnation Request(Non-Consumable) ==> 19
				 */
				
				if (vo.getStrReqTypeId().equals("18")) {

					formBean.setStrReturnStatus("1");
					formBean.setStrReqTypeId("18");

				} 
				else{
					formBean.setStrReturnStatus("0");
				}
				
				if (vo.getStrReqTypeId().equals("16")
						|| vo.getStrReqTypeId().equals("18")
						|| vo.getStrReqTypeId().equals("19")) {

					formBean.setStrAckStatus("0");

				} else {
					formBean.setStrAckStatus("1");
					formBean.setStrTransNo(vo.getStrTransNo());
					formBean.setStrStoreId(vo.getStrStoreId());
					formBean.setStrItemDetails("");
					formBean.setStrRequestMode("1");

				}

			}

		} catch (Exception e) {
			//e.printStackTrace();
			retValue = false;
			strmsgText = "Acknowledge Transaction.AcknowledgeTransDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AcknowledgeTransDATA->insertRecord()", strmsgText);
			
			if ((e.getMessage()).contains("999"))
			{
				formBean.setStrErrMsg("Your session expired !! Please Login Again");
			}
			else
			{
				formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
			}

			eObj = null;

		} finally {

			vo = null;
			bo = null;
		}
		return retValue;
	}

}
