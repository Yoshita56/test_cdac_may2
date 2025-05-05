package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;
import mms.AttachFileGlobal;
import mms.MmsConfigUtil;
import org.apache.struts.upload.FormFile;

import mms.MmsConfigUtil;

import mms.transactions.bo.HelpDeskBO;

import mms.transactions.controller.fb.HelpDeskFB;
import mms.transactions.controller.hlp.HelpDeskTransHLP;

import mms.transactions.vo.HelpDeskVO;
import mms.transactions.controller.action.Download;

//import org.apache.struts.action.ActionForm;
//import org.apache.struts.action.ActionMapping;



//to download files imported 
//import java.io.*;
//import java.net.*;

/* @author 

* Developer : Brahmam Veluguri( TO CONTINUE AND CORRECTIONS)
* Version : 1.0 Date : 02/Jul/2012
* 
*/


public class HelpDeskDATA  {
	
public static void initialAdd(HelpDeskFB formBean,
			HttpServletRequest request) {

		HelpDeskBO bo = null;
		HelpDeskVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String SubGroupCmb = "";
		
		String ItemCmb = "";
		String strTemp = "";

		try {
			bo = new HelpDeskBO();
			vo = new HelpDeskVO();
			

			hisutil = new HisUtil("mms", "HelpDeskDATA");
			
			
			if (!formBean.getComboValue().equals("")) 
			{
				String strCmbNames = formBean.getComboValue();
				String[] temp = strCmbNames.replace("^", "#").split("#");
				formBean.setStrStoreName(temp[0]);
				formBean.setStrGroupName(temp[1]);
				formBean.setStrMenuName(temp[2]);
			////System.out.println("Menu Name" +temp[2]);

			}

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			String strStoreId = formBean.getCombo()[0];
			String IssueRegarding = formBean.getCombo()[1]; //Issue Regarding
			String MenuName = formBean.getCombo()[2]; // Menu Name
			String strpriority=formBean.getStrpriority();
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);
			
			vo.setStrCtDate(ctDate);

			//vo.setStrItemCategoryNo("10");

			formBean.setStrGroupId(IssueRegarding);
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

	public static void insert(HelpDeskFB formBean) 
	{
		String strmsgText = "";
		HelpDeskBO bo = null;
		HelpDeskVO vo = null;
		String strCurrentDate="";
		MmsConfigUtil mcu = null;
		AttachFileGlobal fs=null;
		String strFileExt="";
		
		String strFileName="";
		HisUtil hisutil=null;
		
		
		String temp[]=null;

		MmsConfigUtil mmsUtil = null;

		try 
		{
			////System.out.println("DATA Class Entered");
			bo = new HelpDeskBO();
			
			vo = (HelpDeskVO) TransferObjectFactory.populateData("mms.transactions.vo.HelpDeskVO", formBean);
			
			mmsUtil = new MmsConfigUtil(formBean.getStrHospitalCode());
			hisutil=new HisUtil("mms", "HelpDeskDATA");
			
			strCurrentDate = hisutil.getASDate("dd-MMM-yyyy HH-mm-SS");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			
			String seatid = formBean.getStrSeatId();
			

			String strStoreId = formBean.getCombo()[0];
			String Dept = formBean.getCombo()[1]; //Dept ID
			String MenuId=formBean.getCombo()[2];//Menu Id
			String strpriority=formBean.getStrpriority();

			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);
			vo.setStrGroupId(Dept);
			vo.setStrMenuId(MenuId);
			vo.setStrpriority(strpriority);
			vo.setStrprobsub(formBean.getStrprobsub());
			vo.setStrprobdesc(formBean.getStrprobdesc());
			vo.setStrsubmitby(formBean.getStrsubmitby());
			vo.setStrstatusid("1");
			
			FormFile myFile = formBean.getStrLocation();
			
			if(myFile.getFileData().length>0 && myFile.getFileData()!=null)
			{
				mcu = new MmsConfigUtil(formBean.getStrHospitalCode());
				fs=new AttachFileGlobal();
			vo.setStrFileNo(formBean.getStrFileNo());
			vo.setStrPageNo(formBean.getStrPageNo());
			
		     strFileExt = myFile.getFileName();
		     
		     temp=strFileExt.replace('.', '#').split("#");
		     strFileExt = temp[temp.length-1];
		     String probsub=vo.getStrprobsub().replace("/", "@@@");
		     String probsub1=probsub.replace("#", "@@@@@");
		     strFileName =vo.getStrStoreId()+"_"+probsub1+"_"+vo.getStrHospitalCode()+"_"+strCurrentDate+"."+strFileExt;
		     vo.setStrFileName(strFileName);
			}
			////System.out.println("status :"+formBean.getCombo()[3]);
			////System.out.println("seatid :"+seatid);
			////System.out.println("strStoreId :"+strStoreId);
			////System.out.println("Dept :"+Dept);
			////System.out.println("MenuId :"+MenuId);
			////System.out.println("strpriority :"+strpriority);
			////System.out.println("prob sub :"+formBean.getStrprobsub());
			////System.out.println("prob desc :"+formBean.getStrprobdesc());
			////System.out.println("getStrsubmitby :"+formBean.getStrsubmitby());
			
			
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
			       
			       if(myFile.getFileData().length>0 && myFile.getFileData()!=null)
			       {
			    String  filePath=mcu.getStrCommitteeFilePath();
			   //  //System.out.println("path" +mmsUtil.getStrCommitteeFilePath() );  
			    //String filePath="C:/FileUpload";
					  fs.saveFile(myFile.getFileData(), strFileName); 
			       }
				}   
			}  
			

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

	
	
	public static void getViewInitialVal(HelpDeskFB formBean,
			HttpServletRequest request) {
		HelpDeskBO bo = null;
		HelpDeskVO vo = null;
		String strmsgText = "";
		String str1 = "";
		String str2 = "";
		String str3 = "";
		String strChk = "";
		String path = "";
		String[] strActive = null;
		String[] strAcknowledge = null;

		try {
			bo = new HelpDeskBO();
			vo = new HelpDeskVO();
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

				bo.getAcknowledgeVal(vo);

				WebRowSet ws = vo.getStrAcknowledgeDtlWs();
				//WebRowSet ws1 = vo.getStrItemDtlWs();

				//ws.beforeFirst();
				str1 = HelpDeskTransHLP.getAcknowledgeDetails(ws);
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
	
	public static void DownloadFile(HelpDeskFB formBean,
			HttpServletRequest request,HttpServletResponse response) {
		
		HelpDeskBO bo = null;
		HelpDeskVO vo = null;
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
			
			bo = new HelpDeskBO();
			vo = new HelpDeskVO();
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
			
			String strFileName = request.getParameter("hiddenValue").split("\\^")[0].replace("@$@$", "%");
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

