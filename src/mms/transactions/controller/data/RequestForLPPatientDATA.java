package mms.transactions.controller.data;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import billing.BillConfigUtil;
import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.PatientDtlHLP;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.transactions.bo.RequestForLPPatientBO;
import mms.transactions.controller.fb.RequestForLPPatientFB;
import mms.transactions.controller.hlp.RequestForLPPatientHLP;
import mms.transactions.dao.RequestForLPPatientDAO;
import mms.transactions.vo.RequestForLPPatientVO;

public class RequestForLPPatientDATA 
{
	
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Issue To Patient Transaciton ADD Page 
	 * @param formBean
	 * @param request
	 */
	public static void GetData_NEW(RequestForLPPatientFB formBean,HttpServletRequest request) 
	{
		RequestForLPPatientBO bo = null;
		RequestForLPPatientVO vo = null;
		String strmsgText = "";
		HisUtil util = null;
		String[] combo = null;
		String  strStoreId ="";
		String  strStoreTypeId="";
		String  strReqType = "";
		String  strItemCategoryNo ="";
		String strCostRequired="";	
		String path="";
		String scmInt="";
		String chkValue="";
		
		String strStoreName="";
		String strCatgName="";
		String strReqName="";
		String strCrNo="0";
		try 
		{
			
			System.out.println("<<------ RequestForLPPatientDATA . GetData_NEW  ------>>");
			 
			bo = new RequestForLPPatientBO();
			vo = new RequestForLPPatientVO();
			util = new HisUtil("RequestForLPPatientDATA", "RequestForLPPatientDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;	
			
			/*Here We get Path of Parent Controller*/
	       
			path = "/mms"+request.getParameter("cnt_page")+".cnt";
	        if(request.getParameter("cnt_page") == null)
			{
			   path = request.getParameter("strPath");
			}
	        strCostRequired="0";
	        scmInt="0";
	        
	        if(request.getParameter("chk") != null)
			{
	        	chkValue 	= request.getParameter("chk");
	        	strStoreName= request.getParameter("strStoreName");
	    		strCatgName	= request.getParameter("strCatgName");
	    		strReqName	= request.getParameter("strReqName");	    			    			    		
	    		System.out.println("chkValue  ------>>"+chkValue);
	    		System.out.println("strStoreName  ------>>"+strStoreName);
	    		System.out.println("strCatgName  ------>>"+strCatgName);
	    		System.out.println("strReqName  ------>>"+strReqName);
			}
	        else
	        {
	        	HisException eObj = new HisException("mms",	"RequestForLPPatientDATA->GetData()", strmsgText);
	        	formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "] Require Value Not Avaliable ,Contact System Administrator! ");
	        }
	        
	        // storeId+"@"+catgId+"@"+reqTypeId+"@"+CrNo
								
			strStoreId 		  = chkValue.split("\\@")[0];   // Store Id			
			strItemCategoryNo = chkValue.split("\\@")[1];  	// Item category		
			strReqType 		  = chkValue.split("\\@")[2];   // Request Type ID
			strCrNo           = chkValue.split("\\@")[3];   // Cr No
			
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrCtDate(strCtDate);
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId("0");
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setStrReqType(strReqType);
			vo.setStrBillInt("0");
			vo.setStrCrNo(strCrNo);		
			
			bo.GetData(vo);
			 if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}else{
						formBean.setStrItemCatg(vo.getStrItemCatg());
						formBean.setStrReqDate(strCtDate);
						formBean.setStrTmpItemCatg(strItemCategoryNo);
						formBean.setStrStoreTypeId(vo.getStrStoreTypeId());
						formBean.setStrTmpReqType(vo.getStrReqType());
						formBean.setStrItemCatgCombo(vo.getStrItemCatgCombo());
						formBean.setStrGroupIdForItemSearch(vo.getStrGroupIdForItemSearch());
						formBean.setStrTmpStoreName(strStoreId);
						formBean.setStrStoreName(vo.getStrStoreName());
						formBean.setStrToStoreCombo(vo.getStrToStoreCombo());
						formBean.setStrGrantTypeCombo(vo.getStrGrantTypeCombo());
						formBean.setStrRecmndByCombo(vo.getStrRecmndByCombo());
						formBean.setStrCostRequired(strCostRequired);
						formBean.setStrBillInt("0");
						formBean.setStrSCMIntegration("0");
						formBean.setStrBillPaidCat("");
						if(vo.getStrReqType().equals("86"))
							formBean.setStrReqTypeName("Indent for Buy and Supply (patient wise)");
						else
							formBean.setStrReqTypeName("Indent for issue(patient wise)");
				}
		  }
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "RequestForLPPatientDATA.GetData_NEW(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RequestForLPPatientDATA->GetData_NEW()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Indent Transaciton ADD Page 
	 * @param formBean
	 * @param request
	 */
	public static void GetData_NEW_TWO(RequestForLPPatientFB formBean,HttpServletRequest request) 
	{
		RequestForLPPatientBO bo = null;
		RequestForLPPatientVO vo = null;
		String strmsgText = "";
		String strCatCode ="";
		HisUtil util = null;
		String chkValue="";
		
		String strStoreName="";
		String strCatgName="";
		String strReqName="";
		String strCrNo="0";
		String  strStoreId ="";
		String  strStoreTypeId="";
		String  strReqType = "";
		String  strItemCategoryNo ="";
		try 
		{
			System.out.println("<<------ RequestForLPPatientDATA . GetData_NEW_TWO  ------>>");
			
			bo = new RequestForLPPatientBO();
			vo = new RequestForLPPatientVO();
			
			/* Here we get Category Code from Configuration File */
			strCatCode = MmsConfigUtil.STAFF_CAT_CODE;
			
			util = new HisUtil("RequestForLPPatientDATA", "RequestForLPPatientDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
			if(request.getParameter("chk") != null)
			{
	        	chkValue 	= request.getParameter("chk");
	        	strStoreName= request.getParameter("strStoreName");
	    		strCatgName	= request.getParameter("strCatgName");
	    		strReqName	= request.getParameter("strReqName");	    			    			    		
	    		System.out.println("chkValue  ------>>"+chkValue);
	    		System.out.println("strStoreName  ------>>"+strStoreName);
	    		System.out.println("strCatgName  ------>>"+strCatgName);
	    		System.out.println("strReqName  ------>>"+strReqName);
			}
	        else
	        {
	        	HisException eObj = new HisException("mms",	"RequestForLPPatientDATA->GetData()", strmsgText);
	        	formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "] Require Value Not Avaliable ,Contact System Administrator! ");
	        }
	        
	        // storeId+"@"+catgId+"@"+reqTypeId+"@"+CrNo
								
			strStoreId 		  = chkValue.split("\\@")[0];   // Store Id			
			strItemCategoryNo = chkValue.split("\\@")[1];  	// Item category		
			strReqType 		  = chkValue.split("\\@")[2];   // Request Type ID
			strCrNo           = chkValue.split("\\@")[3];   // Cr No
			
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrCtDate(strCtDate);
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId("0");
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setStrReqType(strReqType);
			vo.setStrBillInt("0");
			vo.setStrCrNo(strCrNo);		
			
			bo.GetData(vo);
            bo.getPatientTreatmentDetailfrmIpd(vo);
            bo.getUnitCombo(vo);
            
            
            //System.out.println("Patient Department Details---->>"+vo.getStrPatientDepartmentDtls());
            
            if(hosCode.equals("23921"))  // AIIMS Bhopal Production
            {
            	if(vo.getStrPatientDepartmentDtls().split("\\$")[0].equals("1"))
            	{
            		formBean.setStrErr(vo.getStrPatientDepartmentDtls().split("\\$")[1]);
            	}
            	if(vo.getStrPatientDepartmentDtls().split("\\$")[0].equals("2") )
            	{
            		formBean.setStrMsg(vo.getStrPatientDepartmentDtls().split("\\$")[1]);
            	}
            	if(vo.getStrPatientDepartmentDtls().split("\\$")[0].equals("4") || vo.getStrPatientDepartmentDtls().split("\\$")[0].equals("3"))
            	{
            		formBean.setStrErr(vo.getStrPatientDepartmentDtls().split("\\$")[1]);
            	}            	
            }            
            formBean.setStrPatAccountNo(vo.getStrPatAccountNo());
            formBean.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
            formBean.setStrBalanceAmount(vo.getStrBalanceAmount());
            
            System.out.println("<<------ PatientDtlHLP.patientWithAdmissionDtlRequestForLP  ------>>");
            
			String dummy1 = PatientDtlHLP.patientWithAdmissionDtlRequestForLP(formBean.getStrCrNo(),formBean.getStrHospitalCode(),formBean.getStrBalanceAmount(),formBean.getStrPatAccountNo(),true,vo.getPatType());
			
			System.out.println("<<------ PatientDtlHLP.patientTreatmentDtlfrmIPD  ------>>");
			
			String dummy2 = PatientDtlHLP.patientTreatmentDtlfrmIPD(vo.getTreatmentDetailWs(),formBean.getStrHospitalCode());//added by shalini to set treatment detail
			
			//String dummy3 = patientDiagDtl(formBean.getStrCrNo(),formBean.getStrHospitalCode());
			
			formBean.setStrPatientDemDtl(dummy1);
			//formBean.setStrPatientDiagDtl(dummy3);
			formBean.setStrReqDate(strCtDate);
			formBean.setStrGoFlg("1");
			formBean.setStrGroupIdForItemSearch(vo.getStrGroupIdForItemSearch());
			formBean.setStrTmpStoreName(strStoreId);
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrToStoreCombo(vo.getStrToStoreCombo());
			formBean.setStrGrantTypeCombo(vo.getStrGrantTypeCombo());
			formBean.setStrRecmndByCombo(vo.getStrRecmndByCombo());
			
			
			 if(dummy2 != null && !dummy2.equals(""))
			 {	 
			  formBean.setStrPatientTreatmentDtl(dummy2);
			 }
			 else
			 {	 
			  formBean.setStrPatientTreatmentDtl("");
			 }
			 
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
		}
		  catch (Exception e) 
		  {
			e.printStackTrace();
            strmsgText = "RequestForLPPatientDATA.GetData_NEW_TWO(vo) --> "+ e.getMessage();
            HisException eObj = new HisException("mms","RequestForLPPatientDATA->GetData_NEW_TWO()", strmsgText);
            String str = "PatientDtlHLP-->patientWithAdmissionDtl-->PatientDtlHLP-->patientDtl-->Invalid CR. No.";
            if(str.trim().equals(e.getMessage().trim()))
            {
            	formBean.setStrErr("Invalid CR. No.!!! ");
            }
            else
            { 	
			 formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
            } 

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Issue To Patient Transaciton ADD Page 
	 * @param formBean
	 * @param request
	 */
	public static void GetData(RequestForLPPatientFB formBean,HttpServletRequest request) 
	{
		RequestForLPPatientBO bo = null;
		RequestForLPPatientVO vo = null;
		String strmsgText = "";
		HisUtil util = null;
		String[] combo = null;
		String  strStoreId ="";
		String  strStoreTypeId="";
		String  strReqType = "";
		String  strItemCategoryNo ="";
		String strCostRequired="";
		MmsConfigUtil mmsConfig=null;
		BillConfigUtil billConfigUtil=null;
		String path="";
		String scmInt="";
		try 
		{
			
			System.out.println("<<------ RequestForLPPatientDATA . GetData  ------>>");
			 
			bo = new RequestForLPPatientBO();
			vo = new RequestForLPPatientVO();
			util = new HisUtil("RequestForLPPatientDATA", "RequestForLPPatientDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;	
			mmsConfig=new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			/*Here We get Path of Parent Controller*/
	       
			path = "/mms"+request.getParameter("cnt_page")+".cnt";
	        if(request.getParameter("cnt_page") == null)
			{
			   path = request.getParameter("strPath");
			}
	        strCostRequired=mmsConfig.getStrCostReq();
	        scmInt=mmsConfig.getStrSCMIntegration();
	        
	        //formBean.setStrPath(path.trim());			
			combo = request.getParameterValues("combo");
			
			String[] strTemp =  combo[0].split("\\^");
								
			strStoreId = strTemp[0];       // Store Id
			strStoreTypeId = strTemp[1];   // Store Type ID
			strItemCategoryNo = combo[1];  // Item category
			String[] strTemp1 =combo[2].split("\\^"); 
			
			strReqType =strTemp1[1];    // Request Type ID
			
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrCtDate(strCtDate);
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setStrReqType(strReqType);
			vo.setStrBillInt(mmsConfig.getStrBillingIntegration());
			vo.setStrCrNo(formBean.getStrCrNo());
			billConfigUtil = new BillConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			//String strCategoryCode = billConfigUtil.getStrPaidCategory()==""?BillConfigUtil.NORMAL_CATEGORY:billConfigUtil.getStrPaidCategory();
			
			bo.GetData(vo);
			 if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}else{
						formBean.setStrItemCatg(vo.getStrItemCatg());
						formBean.setStrReqDate(strCtDate);
						formBean.setStrTmpItemCatg(strItemCategoryNo);
						formBean.setStrStoreTypeId(vo.getStrStoreTypeId());
						formBean.setStrTmpReqType(vo.getStrReqType());
						formBean.setStrItemCatgCombo(vo.getStrItemCatgCombo());
						formBean.setStrGroupIdForItemSearch(vo.getStrGroupIdForItemSearch());
						formBean.setStrTmpStoreName(strStoreId);
						formBean.setStrStoreName(vo.getStrStoreName());
						formBean.setStrToStoreCombo(vo.getStrToStoreCombo());
						formBean.setStrGrantTypeCombo(vo.getStrGrantTypeCombo());
						formBean.setStrRecmndByCombo(vo.getStrRecmndByCombo());
						formBean.setStrCostRequired(strCostRequired);
						formBean.setStrBillInt(mmsConfig.getStrBillingIntegration());
						formBean.setStrSCMIntegration(mmsConfig.getStrSCMIntegration());
						formBean.setStrBillPaidCat("");
						if(vo.getStrReqType().equals("86"))
							formBean.setStrReqTypeName("Indent for Buy and Supply (patient wise)");
						else
							formBean.setStrReqTypeName("Indent for issue(patient wise)");
				}
		  }
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "RequestForLPPatientDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RequestForLPPatientDATA->GetData()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Indent Transaciton ADD Page 
	 * @param formBean
	 * @param request
	 */
	public static void GetData1(RequestForLPPatientFB formBean,HttpServletRequest request) 
	{
		RequestForLPPatientBO bo = null;
		RequestForLPPatientVO vo = null;
		String strmsgText = "";
		String strCatCode ="";
		HisUtil util = null;
		try 
		{
			System.out.println("<<------ RequestForLPPatientDATA . GetData1  ------>>");
			
			bo = new RequestForLPPatientBO();
			vo = new RequestForLPPatientVO();
			
			/* Here we get Category Code from Configuration File */
			strCatCode = MmsConfigUtil.STAFF_CAT_CODE;
			
			util = new HisUtil("RequestForLPPatientDATA", "RequestForLPPatientDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
            String hosCode    = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId     = request.getSession().getAttribute("SEATID").toString();
			String strStoreId = request.getParameter("strTmpStoreName");
			String strItemCat = request.getParameter("strTmpItemCatg");
			String CrNo       = request.getParameter("strCrNo");
			String strReqType = request.getParameter("strTmpReqType");
 		    String Path       = request.getParameter("strPath");
			
 		    formBean.setStrConfigCatCode(strCatCode);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			formBean.setStrPath(Path);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrStoreId(strStoreId);
			vo.setStrCrNo(CrNo);
			vo.setStrItemCategoryNo(strItemCat);
			vo.setStrReqType(strReqType);
			vo.setPatType(formBean.getPatType());
			
			bo.GetData(vo);
            bo.getPatientTreatmentDetailfrmIpd(vo);
            bo.getUnitCombo(vo);
            
            
            //System.out.println("Patient Department Details---->>"+vo.getStrPatientDepartmentDtls());
            
            if(hosCode.equals("23921"))  // AIIMS Bhopal Production
            {
            	if(vo.getStrPatientDepartmentDtls().split("\\$")[0].equals("1"))
            	{
            		formBean.setStrErr(vo.getStrPatientDepartmentDtls().split("\\$")[1]);
            	}
            	if(vo.getStrPatientDepartmentDtls().split("\\$")[0].equals("2") )
            	{
            		formBean.setStrMsg(vo.getStrPatientDepartmentDtls().split("\\$")[1]);
            	}
            	if(vo.getStrPatientDepartmentDtls().split("\\$")[0].equals("4") || vo.getStrPatientDepartmentDtls().split("\\$")[0].equals("3"))
            	{
            		formBean.setStrErr(vo.getStrPatientDepartmentDtls().split("\\$")[1]);
            	}            	
            }            
            formBean.setStrPatAccountNo(vo.getStrPatAccountNo());
            formBean.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
            formBean.setStrBalanceAmount(vo.getStrBalanceAmount());
            
            System.out.println("<<------ PatientDtlHLP.patientWithAdmissionDtlRequestForLP  ------>>");
            
			String dummy1 = PatientDtlHLP.patientWithAdmissionDtlRequestForLP(formBean.getStrCrNo(),formBean.getStrHospitalCode(),formBean.getStrBalanceAmount(),formBean.getStrPatAccountNo(),true,vo.getPatType());
			
			System.out.println("<<------ hisglobal.tools.hlp.PatientDtlHLP.patientTreatmentDtlfrmIPD  ------>>");
			
			String dummy2 = PatientDtlHLP.patientTreatmentDtlfrmIPD(vo.getTreatmentDetailWs(),formBean.getStrHospitalCode());//added by shalini to set treatment detail
			
			//String dummy3 = patientDiagDtl(formBean.getStrCrNo(),formBean.getStrHospitalCode());
			
			formBean.setStrPatientDemDtl(dummy1);
			//formBean.setStrPatientDiagDtl(dummy3);
			formBean.setStrReqDate(strCtDate);
			formBean.setStrGoFlg("1");
			formBean.setStrGroupIdForItemSearch(vo.getStrGroupIdForItemSearch());
			formBean.setStrTmpStoreName(strStoreId);
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrToStoreCombo(vo.getStrToStoreCombo());
			formBean.setStrGrantTypeCombo(vo.getStrGrantTypeCombo());
			formBean.setStrRecmndByCombo(vo.getStrRecmndByCombo());
			
			
			 if(dummy2 != null && !dummy2.equals(""))
			 {	 
			  formBean.setStrPatientTreatmentDtl(dummy2);
			 }
			 else
			 {	 
			  formBean.setStrPatientTreatmentDtl("");
			 }
			 
			 System.out.println("<<------ CR_NO  ------>>"+CrNo);
			 
			 formBean.setStrCrNo(CrNo);
			 
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
		}
		  catch (Exception e) 
		  {
			e.printStackTrace();
            strmsgText = "RequestForLPPatientDATA.GetData1(vo) --> "+ e.getMessage();
            HisException eObj = new HisException("mms","RequestForLPPatientDATA->GetData1()", strmsgText);
            String str = "PatientDtlHLP-->patientWithAdmissionDtl-->PatientDtlHLP-->patientDtl-->Invalid CR. No.";
            if(str.trim().equals(e.getMessage().trim()))
            {
            	formBean.setStrErr("Invalid CR. No.!!! ");
            }
            else
            { 	
			 formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
            } 

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Indent Transaciton ADD Page 
	 * @param formBean
	 * @param request
	 */
	public static void GetData1_OLD(RequestForLPPatientFB formBean,HttpServletRequest request) 
	{
		RequestForLPPatientBO bo = null;
		RequestForLPPatientVO vo = null;
		String strmsgText = "";
		String strCatCode ="";
		HisUtil util = null;
		try 
		{
			System.out.println("<<------ RequestForLPPatientDATA .   ------>>");
			
			bo = new RequestForLPPatientBO();
			vo = new RequestForLPPatientVO();
			
			/* Here we get Category Code from Configuration File */
			strCatCode = MmsConfigUtil.STAFF_CAT_CODE;
			
			util = new HisUtil("RequestForLPPatientDATA", "RequestForLPPatientDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
            String hosCode    = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId     = request.getSession().getAttribute("SEATID").toString();
			String strStoreId = request.getParameter("strTmpStoreName");
			String strItemCat = request.getParameter("strTmpItemCatg");
			String CrNo       = request.getParameter("strCrNo");
			String strReqType = request.getParameter("strTmpReqType");
 		    String Path       = request.getParameter("strPath");
			
 		    formBean.setStrConfigCatCode(strCatCode);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			formBean.setStrPath(Path);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrStoreId(strStoreId);
			vo.setStrCrNo(CrNo);
			vo.setStrItemCategoryNo(strItemCat);
			vo.setStrReqType(strReqType);
			vo.setPatType(formBean.getPatType());
			
			bo.GetData(vo);
            bo.getPatientTreatmentDetailfrmIpd(vo);
            bo.getUnitCombo(vo);
            
            
            //System.out.println("Patient Department Details---->>"+vo.getStrPatientDepartmentDtls());
            
            if(hosCode.equals("23921"))  // AIIMS Bhopal Production
            {
            	if(vo.getStrPatientDepartmentDtls().split("\\$")[0].equals("1"))
            	{
            		formBean.setStrErr(vo.getStrPatientDepartmentDtls().split("\\$")[1]);
            	}
            	if(vo.getStrPatientDepartmentDtls().split("\\$")[0].equals("2") )
            	{
            		formBean.setStrMsg(vo.getStrPatientDepartmentDtls().split("\\$")[1]);
            	}
            	if(vo.getStrPatientDepartmentDtls().split("\\$")[0].equals("4") || vo.getStrPatientDepartmentDtls().split("\\$")[0].equals("3"))
            	{
            		formBean.setStrErr(vo.getStrPatientDepartmentDtls().split("\\$")[1]);
            	}            	
            }            
            formBean.setStrPatAccountNo(vo.getStrPatAccountNo());
            formBean.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
            formBean.setStrBalanceAmount(vo.getStrBalanceAmount());
            
            System.out.println("<<------ PatientDtlHLP.patientWithAdmissionDtlRequestForLP  ------>>");
            
			String dummy1 = PatientDtlHLP.patientWithAdmissionDtlRequestForLP_OLD(formBean.getStrCrNo(),formBean.getStrHospitalCode(),formBean.getStrBalanceAmount(),formBean.getStrPatAccountNo(),true,vo.getPatType());
			
			System.out.println("<<------ hisglobal.tools.hlp.PatientDtlHLP.patientTreatmentDtlfrmIPD  ------>>");
			
			String dummy2 = PatientDtlHLP.patientTreatmentDtlfrmIPD(vo.getTreatmentDetailWs(),formBean.getStrHospitalCode());//added by shalini to set treatment detail
			
			//String dummy3 = patientDiagDtl(formBean.getStrCrNo(),formBean.getStrHospitalCode());
			
			formBean.setStrPatientDemDtl(dummy1);
			//formBean.setStrPatientDiagDtl(dummy3);
			formBean.setStrReqDate(strCtDate);
			formBean.setStrGoFlg("1");
			formBean.setStrGroupIdForItemSearch(vo.getStrGroupIdForItemSearch());
			formBean.setStrTmpStoreName(strStoreId);
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrToStoreCombo(vo.getStrToStoreCombo());
			formBean.setStrGrantTypeCombo(vo.getStrGrantTypeCombo());
			formBean.setStrRecmndByCombo(vo.getStrRecmndByCombo());
			
			
			 if(dummy2 != null && !dummy2.equals(""))
			 {	 
			  formBean.setStrPatientTreatmentDtl(dummy2);
			 }
			 else
			 {	 
			  formBean.setStrPatientTreatmentDtl("");
			 }
			 
			 System.out.println("<<------ CR_NO  ------>>"+CrNo);
			 
			 formBean.setStrCrNo(CrNo);
			 
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
		}
		  catch (Exception e) 
		  {
			e.printStackTrace();
            strmsgText = "RequestForLPPatientDATA.GetData1(vo) --> "+ e.getMessage();
            HisException eObj = new HisException("mms","RequestForLPPatientDATA->GetData1()", strmsgText);
            String str = "PatientDtlHLP-->patientWithAdmissionDtl-->PatientDtlHLP-->patientDtl-->Invalid CR. No.";
            if(str.trim().equals(e.getMessage().trim()))
            {
            	formBean.setStrErr("Invalid CR. No.!!! ");
            }
            else
            { 	
			 formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
            } 

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	/**
	 * Method is Used to Insert Data in DataBase Table 
	 * Breakage Item Detail Transaction 
	 * @param formBean
	 * @param request
	 */

	public static boolean INSERT(RequestForLPPatientFB formBean,HttpServletRequest request) 
	{
		RequestForLPPatientBO bo = null;
		RequestForLPPatientVO vo = null;
		String strmsgText = "";
		MmsConfigUtil mcu = null;
	//	String[] tmp = null; 
		String[] temp1 = null;
	    String strFinancialStartYear = "";

	    String strFinancialEndYear = "";
	    boolean retValue = true;
		try 
		{
			System.out.println("<<------ RequestForLPPatientDATA.INSERT        ------>>");
			
			bo = new RequestForLPPatientBO();
			vo = new RequestForLPPatientVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
	         
	    	String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			
			String strReqType        = request.getParameter("strTmpReqType");
			String strPath           = request.getParameter("strPath");
			String strStoreId        = request.getParameter("strTmpStoreName");
			String strStoreTypeId    = request.getParameter("strStoreTypeId");
			String strItemCategoryNo = request.getParameter("strTmpItemCatg");
				
		    strFinancialStartYear = mcu.getStrFinancialStartDate(strStoreId,request.getSession().getAttribute("HOSPITAL_CODE").toString());
	        strFinancialEndYear = mcu.getStrFinancialEndDate(strStoreId,request.getSession().getAttribute("HOSPITAL_CODE").toString());
	        formBean.setStrPath(strPath);
			vo.setStrEmpNo("0");
			if(formBean.getStrAdmissionDtlHidVal()!=null || !formBean.getStrAdmissionDtlHidVal().equals(""))
			{
			   temp1 = formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#");
			   vo.setStrAdmnNo(temp1[0].trim());
			   
			}   
			else  
			{
				vo.setStrAdmnNo("0");
			}
//			//System.out.println("Length-->>>"+l);
//			//System.out.println("Diag nosis Type-->"+formBean.getStrDiagnosisType());
//			//System.out.println("Cr No-->>"+formBean.getStrCrNo());
//			//System.out.println("Is strIsNormal-->"+formBean.getStrIsNormal());
//			//System.out.println("Is Urgent-->"+formBean.getStrIsUrgent());
//			//System.out.println("Grant Type-->"+formBean.getStrGrantType());
			if(formBean.getStrIsNormal().equals("0"))
			{
				vo.setStrUrgentFlg("1");
			}	
			else
			{
				vo.setStrUrgentFlg("0");
	
	        }	
			//vo.setStrApproxAmt(formBean.getStrApproxAmt());   // Commented By Amit 18/11/2010 11.39 AM  
			vo.setStrApproxAmt("0");
			vo.setStrCrNo(formBean.getStrCrNo());
			vo.setStrGrantType(formBean.getStrGrantType());
			
			System.out.println("<<------ strReqType ------>>"+strReqType);
			
			vo.setStrDiagnosisType(formBean.getStrDiagnosisType());
			vo.setStrProvisionDiagnosis(formBean.getStrProvisionDiagnosis());
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setStrReqType(strReqType);
			vo.setItemParamValue(formBean.getItemParamValue());
			vo.setStrUnitName(formBean.getStrUnitName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrReqQty(formBean.getStrReqQty());
			vo.setStrFinancialEndYear(strFinancialEndYear);
			vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrToStoreCombo(formBean.getStrToStoreCombo());
			vo.setStrBalanceAmount(formBean.getStrBalanceAmount());
			vo.setStrEmpCode(formBean.getStrEmpCode());
			vo.setStrDiagCode(formBean.getStrDiagCode());
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrBSReqNo(formBean.getStrBSReqNo());
			vo.setStrIsUtilityIndent(formBean.getStrIsUtilityIndent());
			
			bo.INSERT(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				retValue = false;
				formBean.setStrCrNo("");
				throw new Exception(vo.getStrMsgString());
			}
			else if(vo.getStrMsgType().equals("5"))
			{
				formBean.setStrMsg("Amount Balance is Low.Indent can not be raised");
			}
	    	else 
			{
	    		formBean.setStrMsg("Indent No [ "+vo.getStrIndentNo()+"] Successfully Raised For Cr.No. ["+vo.getStrCrNo()+"]!!");
			}
			
		}
		  catch (Exception e) 
		  {
			  retValue = false;
			  formBean.setStrCrNo("");
	        e.printStackTrace(); 
			strmsgText = "RequestForLPPatientDATA.INSERT(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RequestForLPPatientDATA->INSERT()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
      return retValue;
	}
	
	/**
	 * 
	 * @param response
	 */
	public static void initHosiptalDiagnosis(HttpServletResponse response,
			RequestForLPPatientFB formBean) {

		RequestForLPPatientVO vo = new RequestForLPPatientVO();
		RequestForLPPatientBO bo = new RequestForLPPatientBO();

		bo.setHospitalDiagnosis(vo);

		HisUtil util = new HisUtil("Admission Advice Trans",
				"RequestForLPPatientDATA");

		try {

			String strHospitalDiagnosis = util.getOptionValue(vo
					.getHospitalDiagnosisWs(), "0", "0^Select Value", false);
			if (vo.getStrMsgType().equals("0")) {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strHospitalDiagnosis);
			} else {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("IPD",
					"RequestForLPPatientDATA->initHosiptalDiagnosis()",
					strmsgText);
			formBean.setStrMsgString("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}
	/**
	 * 
	 * @param response
	 *//*
	public static void initIcdDiagnosis(HttpServletResponse response,
			RequestForLPPatientFB formBean) {

		RequestForLPPatientVO vo = new RequestForLPPatientVO();
		RequestForLPPatientBO bo = new RequestForLPPatientBO();

		bo.setIcdDiagnosis(vo);

		HisUtil util = new HisUtil("Admission Advice Trans",
				"RequestForLPPatientDATA");

		try {

			String strIcdDiagnosis = util.getOptionValue(vo
					.getIcd10DiagnosisWs(), "0", "0^Select Value", false);
			if (vo.getStrMsgType().equals("0")) {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strIcdDiagnosis);
			} else {
				throw new Exception(vo.getStrMsgString());
			}
		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("IPD",
					"RequestForLPPatientDATA->initIcdDiagnosis()", strmsgText);
			formBean.setStrMsgString("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}*/
	
	/**
	 * 
	 * @param response
	 */
	public static void initIcdDiagnosis(HttpServletRequest _Request,HttpServletResponse _Response,
			RequestForLPPatientFB _FormBean) {

		RequestForLPPatientVO vo = new RequestForLPPatientVO();
		RequestForLPPatientBO bo = new RequestForLPPatientBO();
		HisUtil util=null;
		try {
			vo.setStrSearchMode(_FormBean.getStrSearchMode());
			vo.setStrSearchString(_FormBean.getStrSearchString());
			bo.setIcdDiagnosis(vo);
			/*String strHospDiagValues = "";
			boolean fFirst = true;
			while(vo.getHospitalDiagnosisWs().next()){
				if(fFirst){
					strHospDiagValues =  vo.getHospitalDiagnosisWs().getString(2)+"/ "+vo.getHospitalDiagnosisWs().getString(1);
					fFirst=false;
				}else
					strHospDiagValues +=  "^"+vo.getHospitalDiagnosisWs().getString(2)+"/ "+vo.getHospitalDiagnosisWs().getString(1);
			}
			fFirst = true;
			vo.getHospitalDiagnosisWs().beforeFirst();
			while(vo.getHospitalDiagnosisWs().next()){
				if(fFirst){
					strHospDiagValues += "#"+ vo.getHospitalDiagnosisWs().getString(1)+"/ "+vo.getHospitalDiagnosisWs().getString(2);
					fFirst=false;
				}else
					strHospDiagValues +=  "^"+vo.getHospitalDiagnosisWs().getString(1)+"/ "+vo.getHospitalDiagnosisWs().getString(2);
			}
			_FormBean.setStrHospDiagValues(strHospDiagValues);*/
			if (!vo.getStrMsgType().equals("0")) 
			{
				throw new Exception(vo.getStrMsgString());
			}			
				util = new HisUtil("ADT" , "AdmissionAdviceTransDATA.initHosiptalDiagnosis");			
				String strICDValues = util.getDropDown(vo.getIcd10DiagnosisWs(), 1, 5, true);
				_Response.setHeader("Cache-Control", "no-cache");
					_Response.getWriter().print(strICDValues);

		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("IPD",
					"AdmissionAdviceTransDATA->initHosiptalDiagnosis()",
					strmsgText);
			_FormBean.setStrMsgString("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}
	
	public static void placeRegularIndent(RequestForLPPatientFB formBean,HttpServletRequest request) 
	{
		RequestForLPPatientBO bo = null;
		RequestForLPPatientVO vo = null;
		String strmsgText = "";
		String str1 ="";
		String str2 ="";
		String str3 ="";
		//Change Request
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;	
		HisUtil            util = null;
		MmsConfigUtil mmsConfig = null;
		String tmpreqno;
		
		try 
		{
			bo = new RequestForLPPatientBO();
			vo = new RequestForLPPatientVO();
            //System.out.println("In the PlaceRegularIndent");
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
				 mmsConfig = new MmsConfigUtil(hosCode);
	          util = new HisUtil("MMSModule", "RequestForLPPatientDATA");
			
	        
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			String strChk = formBean.getStrChk();
			//161114110003@12401108@11@16@0@10@12401107$1
		//System.out.println("strChk-"+strChk);
			String[] temp  = strChk.split("\\^");
			String[] temp1 = temp[0].split("\\@");
			String[] temp2 = temp1[6].split("\\$");
	//		String strIndentPeriod = temp2[0];

			//System.out.println("Req No-->>"+temp1[0]);
		  	//System.out.println("Store Id-->>"+temp1[1]);
		  	//System.out.println("Req Type Id-->>"+temp1[2]);
		
			vo.setStrIndentNo(temp1[0]);
			vo.setStrReqType(temp1[2]);
			vo.setStrStoreId(temp1[1]);
			vo.setStrToStore(temp2[0]);
			tmpreqno = temp1[0];
			//Change Request
            strCurrentDate  = util.getASDate("dd-MM-yyyy");

			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 )
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
							
			strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
			
			strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			formBean.setStrStoreId(temp1[1]);
			
         	bo.PLACEREGULARINDENT(vo);
         	RequestForLPPatientDAO.GetRecommendByCombo(vo);
         	
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
				str1=RequestForLPPatientHLP.getItemDetails1(vo);
			formBean.setStrSetItemDetails(str1);
			formBean.setStrReqDate(strCurrentDate);
			if(temp1[2].equals("86"))
			{
			formBean.setStrReqType("13");
			formBean.setStrTmpReqType("13");
			formBean.setStrReqTypeName("Indent for Issue (Patient Wise)");
			}
			else
			{
				formBean.setStrReqType("17");
				formBean.setStrTmpReqType("17");
				formBean.setStrReqTypeName("Indent for Issue (Dept. Wise)");
			}
			vo.getStrItemDetailsWs().beforeFirst();
			vo.getStrItemDetailsWs().next();
			formBean.setStrItemCategoryNo(temp1[3]);
			formBean.setStrItemCatg(vo.getStrItemDetailsWs().getString(22));
			formBean.setStrStoreName(vo.getStrItemDetailsWs().getString(20));
			formBean.setStrStoreId(temp1[1]);
			formBean.setStrToStore(vo.getStrToStore());
			formBean.setStrToStoreName(vo.getStrItemDetailsWs().getString(21));
			formBean.setStrPatientDtlHidVal(vo.getStrItemDetailsWs().getString(23));
			formBean.setStrRecmndByCombo(vo.getStrRecmndByCombo());
			formBean.setStrTmpStoreName(temp1[1]);
			formBean.setStrTmpItemCatg(temp1[3]);
			formBean.setStrStoreTypeId("999");
			formBean.setStrToStoreCombo(vo.getStrToStore());
			
			String path = "/mms"+request.getParameter("cnt_page")+".cnt";
	        if(request.getParameter("cnt_page") == null)
			{
			   path = request.getParameter("strPath");
			   
			}
	        
	        formBean.setStrPath(path.trim());			
	        formBean.setStrReqQty(vo.getStrReqQty());
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "RequestForLPPatientDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RequestForLPPatientDATA->placeregluarindent()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}



public static String patientDiagDtl(String strCrNo,String strHospitalCode)
{
	RequestForLPPatientVO vo = new RequestForLPPatientVO();	
	RequestForLPPatientBO bo = new RequestForLPPatientBO();
		StringBuffer sb = new StringBuffer("");
		vo.setStrCrNo(strCrNo);
		vo.setStrHospitalCode(strHospitalCode);
		
		WebRowSet ws = null;
		
		sb.append("");
		
		try 
		{
			bo.getPatientDiagDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		
			ws = vo.getDiagEmpWs();
			sb.append("<table class=\"TABLEWIDTH\" cellspacing=\"1px\" align=\"center\">");
			sb.append("<thead><tr><th ><div align='center'>Diagnosis Name(Code)</div></th>");
			sb.append("<th ><div align='center'>Treatment Consultant</div></th></tr></thead><tbody> ");
			if (ws != null && ws.size() > 0) 
			{
				
				while (ws.next()) 
				{
					String diagName = ws.getString(1);
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
					
					
					
					sb.append("<tr><td><div align='center'>"+diagName+"(<b>"+diagCode+"</b>)</div>");
					sb.append("</td>");
					sb.append("<td><div align='center'>");
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
				sb.append("<tr><td><div align='center'>"+"-"+"("+"-"+")</div>");
				sb.append("</td>");
				sb.append("<td><div align='center'>");
				sb.append("-");
				sb.append("<input type='hidden' name='strDiagCode' value='"+ "-" + "'><input type='hidden' name='strEmpCode' value='"+ "0" + "'></div></td>");
				sb.append("</tr>");
			}
			sb.append("</tbody></table>");
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

}
