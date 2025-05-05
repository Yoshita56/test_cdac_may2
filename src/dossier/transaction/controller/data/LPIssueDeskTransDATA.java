package dossier.transaction.controller.data;


import hisglobal.ReportUtil;
import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.PatientDtlHLP;
import hisglobal.utility.HisUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import billing.BillConfigUtil;
import dossier.transaction.bo.LPIssueDeskTransBO;
import dossier.transaction.controller.fb.LPIssueDeskTransFB;
import dossier.transaction.controller.hlp.LPIssueDeskTransHLP;
import dossier.transaction.vo.LPIssueDeskTransVO;


public class LPIssueDeskTransDATA 
{
	public static void getInitDetailForIssuePage(LPIssueDeskTransFB _LPIssueDeskTransFB,HttpServletRequest request)
	{

		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
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
			System.out.println("************** LPIssueDeskTransDATA --> getInitDetailForIssuePage()  **********CHK****"+request.getParameter("chk"));
			
				bo = new LPIssueDeskTransBO();
				vo = new LPIssueDeskTransVO();
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				mmsConfig=new MmsConfigUtil(hosCode);
				billConfig=new BillConfigUtil(hosCode);
				strCostReq=mmsConfig.getStrCostReq();
				if (request.getParameter("combo") != null	&& request.getParameter("combo").length() > 0) 
			 	{
					_LPIssueDeskTransFB.setCombo(request.getParameterValues("combo"));
					strRaisingReqTypeId=request.getParameterValues("combo")[1];
					strStoreId=request.getParameterValues("combo")[0];
					_LPIssueDeskTransFB.setStrRaisingReqTypeId(strRaisingReqTypeId);
					
			 	}
			 strChk=request.getParameter("chk");
			 if (request.getParameter("comboValue") != null	&& request.getParameter("comboValue").length() > 0) 
			 {
				 _LPIssueDeskTransFB.setComboValue(request.getParameterValues("comboValue")[0]);
				 _LPIssueDeskTransFB.setStrStoreName(_LPIssueDeskTransFB.getComboValue());
				 _LPIssueDeskTransFB.setStrPatientType((strChk.split("\\@")[17]).split("\\$")[0]);
				 vo.setStrPatientType((strChk.split("\\@")[17]).split("\\$")[0]);
			 }
			/**
			 * This is used set variables during request type equal to patient
			 */
//			if(strRaisingReqTypeId.equals("13")){
				temp=strChk.replace('@', '#').split("#");
				
				/*
			    hnum_dossier_req_id||'@'||gnum_hospital_code||'@'||hrgnum_puk||'@'||hnum_req_mode
			    ||'@'||  hnum_ref_req_id||'@'||hnum_servicetype_id||'@'||hnum_service_id||'@'||hstr_service_name
			    ||'@'||  hnum_dossier_id||'@'||hnum_dossier_status||'@'||hstr_entry_remark||'@'||hstr_post_remark||'@'||   hnum_cancel_reason_id
			    ||'@'|| hstr_cancel_remark||'@'|| gnum_isvalid||'@'|| gdt_entry_date||'@'||  hnum_tostore_id  ||'@'|| nvl(A.hstnum_patient_type,0) 
			    ||'@'||  dossier_mst.get_dossier_sort_name(hnum_dossier_id::numeric, gnum_hospital_code::numeric, hnum_servicetype_id::numeric) 
			*/
				/* System.out.println("<<------------------------->> ");
				 System.out.println("hnum_dossier_req_id  	-->> "+temp[0]);
				 System.out.println("gnum_hospital_code  	-->> "+temp[1]);
				 System.out.println("hrgnum_puk  			-->> "+temp[2]);
				 System.out.println("hnum_req_mode  		-->> "+temp[3]);
				 System.out.println("hnum_ref_req_id  		-->> "+temp[4]);
				 System.out.println("hnum_servicetype_id  	-->> "+temp[5]);
				 System.out.println("hnum_service_id  		-->> "+temp[6]);
				 System.out.println("hstr_service_name  	-->> "+temp[7]);
				 System.out.println("hnum_dossier_id  		-->> "+temp[8]);
				 System.out.println("hnum_dossier_status  	-->> "+temp[9]);				 
				 System.out.println("hstr_entry_remark  	-->> "+temp[10]);
				 System.out.println("hstr_post_remark  	    -->> "+temp[11]);
				 System.out.println("hnum_cancel_reason_id  -->> "+temp[12]);				 
				 System.out.println("hstr_cancel_remark  	-->> "+temp[13]);
				 System.out.println("gnum_isvalid  			-->> "+temp[14]);
				 System.out.println("gdt_entry_date  		-->> "+temp[15]);
				 System.out.println("hnum_tostore_id  		-->> "+temp[16]);
				 System.out.println("hnum_tostore_id  		-->> "+temp[17]);
				 System.out.println("get_dossier_sort_name  -->> "+(temp[18]).split("\\$")[0]);			 
				
				 System.out.println("<<------------------------->> ");*/
							
				_LPIssueDeskTransFB.setStrLpRequestNo(temp[0]);
				_LPIssueDeskTransFB.setStrRequestDate(temp[15]);				
				_LPIssueDeskTransFB.setStrCrNo(temp[2]);
				_LPIssueDeskTransFB.setStrBSReqNo(temp[0]);
				_LPIssueDeskTransFB.setStrPoNo("0");
				_LPIssueDeskTransFB.setStrPoStoreId("0");
				_LPIssueDeskTransFB.setStrUrgentFlg("0");
				_LPIssueDeskTransFB.setStrStoreId(strStoreId);
				_LPIssueDeskTransFB.setStrDossierShortName(temp[18].split("\\$")[0]);
				strRequestTypeId="98";
				
				System.out.println("************** LPIssueDeskTransDATA --> getInitDetailForIssuePage() --> PatientDtlHLP.patientWithAdmissionDtl **************");

				strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(_LPIssueDeskTransFB.getStrCrNo(), hosCode, true);
				
				System.out.println("*************************************************");

			   _LPIssueDeskTransFB.setStrPatientDtl(strPatientDtl);
			
			
			
			vo.setStrIssueNo("0");
			vo.setStrHospitalCode(hosCode);
			vo.setStrRaisingStoreId(_LPIssueDeskTransFB.getStrRaisingStoreId());
			vo.setStrLpRequestNo(_LPIssueDeskTransFB.getStrLpRequestNo());
			vo.setStrRequestDate(_LPIssueDeskTransFB.getStrRequestDate());
			vo.setStrRaisingReqTypeId(strRaisingReqTypeId);
			vo.setStrPoStoreId(_LPIssueDeskTransFB.getStrPoStoreId());
			vo.setStrPoNo(_LPIssueDeskTransFB.getStrPoNo());
			vo.setStrCrNo(_LPIssueDeskTransFB.getStrCrNo());
			vo.setStrUrgentFlg(_LPIssueDeskTransFB.getStrUrgentFlg());
			vo.setStrFinStartDate(mmsConfig.getStrFinancialStartDate(strStoreId, hosCode));
			vo.setStrFinEndDate(mmsConfig.getStrFinancialEndDate(strStoreId, hosCode));
			vo.setStrBSReqNo("0");
			vo.setStrStoreId(_LPIssueDeskTransFB.getStrStoreId());
			vo.setStrPatientType(_LPIssueDeskTransFB.getStrPatientType());
			//if(_LPIssueDeskTransFB.getStrBSReqNo().equals("0"))
			System.out.println("************** LPIssueDeskTransDATA --> getInitDetailForIssuePage() --> pkg_dossier_view.proc_hstt_lp_req_item_dtl      [ Mode - 1 ] **************");
			System.out.println("************** LPIssueDeskTransDATA --> getInitDetailForIssuePage() --> pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl [ Mode - 1 ] **************");
			System.out.println("************** LPIssueDeskTransDATA --> getInitDetailForIssuePage() --> PKG_MMS_VIEW.proc_hstt_pat_account_dtl          [ Mode - 1 ] **************");
				bo.getLPRequestDetail(vo);  // pkg_dossier_view.proc_hstt_lp_req_item_dtl      [ Mode - 1 ]    
				                            // pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl [ Mode - 1 ]  Get Item Details
				                            // PKG_MMS_VIEW.proc_hstt_pat_account_dtl          [ Mode - 1 ]
			/*else
				bo.getLPRequestDetail_new(vo);
			*/
			
			_LPIssueDeskTransFB.setStrDeptName(vo.getStrDeptName());
			_LPIssueDeskTransFB.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
			WebRowSet wb = vo.getPatAccountDtl();
			if(wb!=null)
			{
				if(wb.size()!=0) 
				{
					
					while(wb.next()){
						_LPIssueDeskTransFB.setStrPatAccountNo(wb.getString(1));
						_LPIssueDeskTransFB.setStrPatAccountBal(wb.getString(2));
					}
				}
			}
			else
			{
				
			}
			_LPIssueDeskTransFB.setStrHospitalCode(hosCode);
			System.out.println("************** LPIssueDeskTransDATA --> getInitDetailForIssuePage() --> PatientDtlHLP.initViewForIssueAddPage **************");

			strRequestDtl=LPIssueDeskTransHLP.initViewForIssueAddPage(_LPIssueDeskTransFB);
			
			//_LPIssueDeskTransFB.setStrDiagDtl(patientDiagDtl(_LPIssueDeskTransFB.getStrCrNo(),hosCode));
			
			
			
			_LPIssueDeskTransFB.setStrRequestDtl(strRequestDtl);
			
			System.out.println("getInitDetailForIssuePage -- >> mmsConfig.getStrSCMIntegration -- >> "+mmsConfig.getStrSCMIntegration().equals("1"));
			System.out.println("getInitDetailForIssuePage -- >> vo.getStrLpRequestNo -- >>"+vo.getStrLpRequestNo().substring(0,2).equals("10"));
			
			
			if(mmsConfig.getStrSCMIntegration().equals("1") && vo.getStrLpRequestNo().substring(0,2).equals("11"))
			{
				buff=new StringBuffer();
				buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				buff.append("<tr>");
				buff.append("<td class='multiControl'>Integration with e-Aushadhi is yes. So,issue can't be processed</td></tr></table>");
				
				strIssueItemId = buff.toString();
			}
			else
			{
				System.out.println("************** LPIssueDeskTransDATA --> getInitDetailForIssuePage() --> PatientDtlHLP.getItemDetails **************");
				strRequestItemDtl=LPIssueDeskTransHLP.getItemDetails(vo.getRequestItemDtlWS());
				
				_LPIssueDeskTransFB.setStrRequestItemDtl(strRequestItemDtl);
				
				System.out.println("************** LPIssueDeskTransDATA --> getInitDetailForIssuePage() --> PatientDtlHLP.getIssueItemDetails  pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl [ Mode - 1 ]  Get Item Details **************");
				strIssueItemId=LPIssueDeskTransHLP.getIssueItemDetails(vo.getIssueItemDtlWS(),strCostReq,strStoreId,hosCode,vo.getStrRaisingStoreId(),vo.getStrBSReqNo(),vo);
			
				
			}
			_LPIssueDeskTransFB.setStrPatAccountNo(_LPIssueDeskTransFB.getStrBillingHiddenValue().split("\\^")[0]);
			_LPIssueDeskTransFB.setStrIssueItemId(strIssueItemId);
			
			_LPIssueDeskTransFB.setStrChk(strChk);
			
			_LPIssueDeskTransFB.setStrRequestTypeId(strRequestTypeId);
			
			_LPIssueDeskTransFB.setStrStoreId(strStoreId);
			
			_LPIssueDeskTransFB.setCombo(request.getParameterValues("combo"));
			
			_LPIssueDeskTransFB.setStrSCMIntegration(mmsConfig.getStrSCMIntegration());
			 
			//_LPIssueDeskTransFB.setStrBillPaidCat(billConfig.getStrPaidCategory());
			
		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "Issue Desk.LPIssueDeskTransDATA.getInitDetailForIssuePage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LPIssueDeskTransDATA->getIndentDetails()", strmsgText);
			_LPIssueDeskTransFB.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	
	public static void afterIssueSave(LPIssueDeskTransFB _LPIssueDeskTransFB,HttpServletRequest request)
	{

		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
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
			System.out.println("************** LPIssueDeskTransDATA --> afterIssueSave()  **********CHK****"+request.getParameter("chk"));
			
				bo = new LPIssueDeskTransBO();
				vo = new LPIssueDeskTransVO();
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				mmsConfig=new MmsConfigUtil(hosCode);
				billConfig=new BillConfigUtil(hosCode);
				strCostReq=mmsConfig.getStrCostReq();
				if (request.getParameter("combo") != null	&& request.getParameter("combo").length() > 0) 
			 	{
					_LPIssueDeskTransFB.setCombo(request.getParameterValues("combo"));
					strRaisingReqTypeId=request.getParameterValues("combo")[1];
					strStoreId=request.getParameterValues("combo")[0];
					_LPIssueDeskTransFB.setStrRaisingReqTypeId(strRaisingReqTypeId);
					
			 	}
			 strChk=request.getParameter("chk");
			 if (request.getParameter("comboValue") != null	&& request.getParameter("comboValue").length() > 0) 
			 {
				 _LPIssueDeskTransFB.setComboValue(request.getParameterValues("comboValue")[0]);
				 _LPIssueDeskTransFB.setStrStoreName(_LPIssueDeskTransFB.getComboValue());
				 _LPIssueDeskTransFB.setStrPatientType((strChk.split("\\@")[17]).split("\\$")[0]);
				 vo.setStrPatientType((strChk.split("\\@")[17]).split("\\$")[0]);
			 }
			/**
			 * This is used set variables during request type equal to patient
			 */
//			if(strRaisingReqTypeId.equals("13")){
				temp=strChk.replace('@', '#').split("#");
				
				/*
			    hnum_dossier_req_id||'@'||gnum_hospital_code||'@'||hrgnum_puk||'@'||hnum_req_mode
			    ||'@'||  hnum_ref_req_id||'@'||hnum_servicetype_id||'@'||hnum_service_id||'@'||hstr_service_name
			    ||'@'||  hnum_dossier_id||'@'||hnum_dossier_status||'@'||hstr_entry_remark||'@'||hstr_post_remark||'@'||   hnum_cancel_reason_id
			    ||'@'|| hstr_cancel_remark||'@'|| gnum_isvalid||'@'|| gdt_entry_date||'@'||  hnum_tostore_id  ||'@'|| nvl(A.hstnum_patient_type,0) 
			    ||'@'||  dossier_mst.get_dossier_sort_name(hnum_dossier_id::numeric, gnum_hospital_code::numeric, hnum_servicetype_id::numeric) 
			*/
				/* System.out.println("<<------------------------->> ");
				 System.out.println("hnum_dossier_req_id  	-->> "+temp[0]);
				 System.out.println("gnum_hospital_code  	-->> "+temp[1]);
				 System.out.println("hrgnum_puk  			-->> "+temp[2]);
				 System.out.println("hnum_req_mode  		-->> "+temp[3]);
				 System.out.println("hnum_ref_req_id  		-->> "+temp[4]);
				 System.out.println("hnum_servicetype_id  	-->> "+temp[5]);
				 System.out.println("hnum_service_id  		-->> "+temp[6]);
				 System.out.println("hstr_service_name  	-->> "+temp[7]);
				 System.out.println("hnum_dossier_id  		-->> "+temp[8]);
				 System.out.println("hnum_dossier_status  	-->> "+temp[9]);				 
				 System.out.println("hstr_entry_remark  	-->> "+temp[10]);
				 System.out.println("hstr_post_remark  	    -->> "+temp[11]);
				 System.out.println("hnum_cancel_reason_id  -->> "+temp[12]);				 
				 System.out.println("hstr_cancel_remark  	-->> "+temp[13]);
				 System.out.println("gnum_isvalid  			-->> "+temp[14]);
				 System.out.println("gdt_entry_date  		-->> "+temp[15]);
				 System.out.println("hnum_tostore_id  		-->> "+temp[16]);
				 System.out.println("hnum_tostore_id  		-->> "+temp[17]);
				 System.out.println("get_dossier_sort_name  -->> "+(temp[18]).split("\\$")[0]);			 
				
				 System.out.println("<<------------------------->> ");*/
							
				_LPIssueDeskTransFB.setStrLpRequestNo(temp[0]);
				_LPIssueDeskTransFB.setStrRequestDate(temp[15]);				
				_LPIssueDeskTransFB.setStrCrNo(temp[2]);
				_LPIssueDeskTransFB.setStrBSReqNo(temp[0]);
				_LPIssueDeskTransFB.setStrPoNo("0");
				_LPIssueDeskTransFB.setStrPoStoreId("0");
				_LPIssueDeskTransFB.setStrUrgentFlg("0");
				_LPIssueDeskTransFB.setStrStoreId(strStoreId);
				_LPIssueDeskTransFB.setStrDossierShortName(temp[18].split("\\$")[0]);
				strRequestTypeId="98";
				
				System.out.println("************** LPIssueDeskTransDATA --> afterIssueSave() --> PatientDtlHLP.patientWithAdmissionDtl **************");

				strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(_LPIssueDeskTransFB.getStrCrNo(), hosCode, true);
				
				System.out.println("*************************************************");

			   _LPIssueDeskTransFB.setStrPatientDtl(strPatientDtl);
			
			
			
			vo.setStrIssueNo("0");
			vo.setStrHospitalCode(hosCode);
			vo.setStrRaisingStoreId(_LPIssueDeskTransFB.getStrRaisingStoreId());
			vo.setStrLpRequestNo(_LPIssueDeskTransFB.getStrLpRequestNo());
			vo.setStrRequestDate(_LPIssueDeskTransFB.getStrRequestDate());
			vo.setStrRaisingReqTypeId(strRaisingReqTypeId);
			vo.setStrPoStoreId(_LPIssueDeskTransFB.getStrPoStoreId());
			vo.setStrPoNo(_LPIssueDeskTransFB.getStrPoNo());
			vo.setStrCrNo(_LPIssueDeskTransFB.getStrCrNo());
			vo.setStrUrgentFlg(_LPIssueDeskTransFB.getStrUrgentFlg());
			vo.setStrFinStartDate(mmsConfig.getStrFinancialStartDate(strStoreId, hosCode));
			vo.setStrFinEndDate(mmsConfig.getStrFinancialEndDate(strStoreId, hosCode));
			vo.setStrBSReqNo("0");
			vo.setStrStoreId(_LPIssueDeskTransFB.getStrStoreId());
			vo.setStrPatientType(_LPIssueDeskTransFB.getStrPatientType());
			//if(_LPIssueDeskTransFB.getStrBSReqNo().equals("0"))
			System.out.println("**************  --> pkg_dossier_view.proc_hstt_lp_req_item_dtl      [ Mode - 1 ] **************");
			System.out.println("**************  --> pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl [ Mode - 1 ] **************");
			System.out.println("**************  --> PKG_MMS_VIEW.proc_hstt_pat_account_dtl          [ Mode - 1 ] **************");
			bo.getLPRequestDetail(vo);  // pkg_dossier_view.proc_hstt_lp_req_item_dtl      [ Mode - 1 ]    
				                            // pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl [ Mode - 1 ]  Get Item Details
				                            // PKG_MMS_VIEW.proc_hstt_pat_account_dtl          [ Mode - 1 ]
			/*else
				bo.getLPRequestDetail_new(vo);
			*/
			
			_LPIssueDeskTransFB.setStrDeptName(vo.getStrDeptName());
			_LPIssueDeskTransFB.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
			WebRowSet wb = vo.getPatAccountDtl();
			if(wb!=null)
			{
				if(wb.size()!=0) 
				{
					
					while(wb.next()){
						_LPIssueDeskTransFB.setStrPatAccountNo(wb.getString(1));
						_LPIssueDeskTransFB.setStrPatAccountBal(wb.getString(2));
					}
				}
			}
			else
			{
				
			}
			_LPIssueDeskTransFB.setStrHospitalCode(hosCode);
			System.out.println("************** LPIssueDeskTransDATA --> afterIssueSave() --> PatientDtlHLP.initViewForIssueAddPage **************");

			strRequestDtl=LPIssueDeskTransHLP.initViewForIssueAddPage(_LPIssueDeskTransFB);
			
			//_LPIssueDeskTransFB.setStrDiagDtl(patientDiagDtl(_LPIssueDeskTransFB.getStrCrNo(),hosCode));
			
			
			
			_LPIssueDeskTransFB.setStrRequestDtl(strRequestDtl);
			
			
			_LPIssueDeskTransFB.setStrPatAccountNo(_LPIssueDeskTransFB.getStrBillingHiddenValue().split("\\^")[0]);
			_LPIssueDeskTransFB.setStrIssueItemId(strIssueItemId);
			
			_LPIssueDeskTransFB.setStrChk(strChk);
			
			_LPIssueDeskTransFB.setStrRequestTypeId(strRequestTypeId);
			
			_LPIssueDeskTransFB.setStrStoreId(strStoreId);
			
			_LPIssueDeskTransFB.setCombo(request.getParameterValues("combo"));
			
			_LPIssueDeskTransFB.setStrSCMIntegration(mmsConfig.getStrSCMIntegration());			 
			
			
		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "Issue Desk.LPIssueDeskTransDATA.getInitDetailForIssuePage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LPIssueDeskTransDATA->getIndentDetails()", strmsgText);
			_LPIssueDeskTransFB.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	public static void getInitDetailForReturnPage(LPIssueDeskTransFB _LPIssueDeskTransFB,
			HttpServletRequest request) {

		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
		String strPatientDtl="";
		String strmsgText = "";
		String strRequestTypeId="";
		String strRaisingReqTypeId="";
		
		String strRequestDtl="";
		String strChk="";
		String temp[]=null;
		String hosCode="";
		HisUtil hisutil=null;
		String cmbVal="";
		String strStoreId="";
		MmsConfigUtil mmsConfig=null;
		String strCostReq="";
		try 
		{
			
			    System.out.println("<<<------------LPIssueDeskTransDATA . getInitDetailForReturnPage -- [ add_Dossier_ReturnDtlTrans.jsp ]----------->>>");
			
				bo = new LPIssueDeskTransBO();
				vo = new LPIssueDeskTransVO();
				hisutil = new HisUtil("MMS","LPIssueDeskTransDATA");
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				mmsConfig=new MmsConfigUtil(hosCode);
				strCostReq=mmsConfig.getStrCostReq();
				
				if (request.getParameter("combo") != null	&& request.getParameter("combo").length() > 0) 
			 	{
					_LPIssueDeskTransFB.setCombo(request.getParameterValues("combo"));
					 strRaisingReqTypeId=request.getParameterValues("combo")[1];
					 strStoreId=request.getParameterValues("combo")[0];
					_LPIssueDeskTransFB.setStrRaisingReqTypeId(strRaisingReqTypeId);
			 	}
				/*
				        A.hrgnum_puk          - 0
				||'@'|| a.hstnum_issue_no     - 1
				||'@'|| hnum_dossier_req_id   - 2                      --  Return Request No  In [  hgdt_dossier_return_dtl & hgdt_dossier_return_item_dtl ]
				||'@'|| A.gnum_hospital_code  - 3
				||'@'|| A.hrgnum_puk          - 4
				||'@'|| hnum_req_mode         - 5  
				||'@'|| hstdt_issue_date      - 6 
				||'@'|| hnum_ref_req_id       - 7
				||'@'|| hnum_servicetype_id   - 8
				||'@'|| hnum_service_id       - 9
				||'@'|| hstr_service_name     - 10
				||'@'|| hnum_dossier_id       - 11
				||'@'|| hnum_dossier_status   - 12
				||'@'|| hstr_entry_remark     - 13
				||'@'|| hstr_post_remark      - 14 
				||'@'|| hnum_cancel_reason_id - 15
				||'@'|| hstr_cancel_remark    - 16   
				||'@'|| A.gnum_isvalid        - 17
				||'@'|| to_char(A.gdt_entry_date ,'DD-MON-YYYY') - 18
				||'@'|| mms_mst.get_store_dtl(1::numeric, a.gnum_hospital_code::numeric, hnum_tostore_id::numeric) - 19 
				||'@'|| dossier_mst.get_dossier_sort_name(hnum_dossier_id::numeric, a.gnum_hospital_code::numeric, hnum_service_id::numeric) - 20 
				||'@'|| hstnum_req_no         - 21 
				||'@'|| A.hstnum_patient_type - 22
				
				*/
				
				 System.out.println("strChk-------->>>"+strChk);
				
				 strChk=request.getParameter("chk");
				 
				 if (request.getParameter("comboValue") != null	&& request.getParameter("comboValue").length() > 0) 
				 {
					 _LPIssueDeskTransFB.setComboValue(request.getParameterValues("comboValue")[0]);
					 _LPIssueDeskTransFB.setStrStoreName(_LPIssueDeskTransFB.getComboValue());
				 }
				
				/**
				 * This is used set variables during request type equal to patient
				 */
				if(strRaisingReqTypeId.equals("35") || strRaisingReqTypeId.equals("32")){//Patient
					
					temp=strChk.replace('@', '#').split("#");
					_LPIssueDeskTransFB.setStrItemCategNo(temp[4]);
					_LPIssueDeskTransFB.setStrIssueNo(temp[1]);
					_LPIssueDeskTransFB.setStrIssueStoreId(temp[0]);
					_LPIssueDeskTransFB.setStrCrNo(temp[2]);
					_LPIssueDeskTransFB.setStrIssueDate(temp[5]);
					strRequestTypeId="44";
				}
				/**
				 * This is used set variables during request type equal to employee
				 */
				else if(strRaisingReqTypeId.equals("12")){//Staff
					
					temp=strChk.replace('@', '#').split("#");
					
					_LPIssueDeskTransFB.setStrItemCategNo(temp[4]);
					_LPIssueDeskTransFB.setStrIssueNo(temp[1]);
					_LPIssueDeskTransFB.setStrIssueStoreId(temp[0]);
					_LPIssueDeskTransFB.setStrCrNo(temp[2]);
					_LPIssueDeskTransFB.setStrIssueDate(temp[5]);
					_LPIssueDeskTransFB.setStrEmpNo(temp[3]);
					
					
					strRequestTypeId="45";
				}
				/**
				 * This is used set variables during request type equal to department
				 */
				else//Dept
				{
					     temp=strChk.replace('@', '#').split("#");
					    
					    _LPIssueDeskTransFB.setStrItemCategNo("97");
						_LPIssueDeskTransFB.setStrIssueNo(temp[1]);
						_LPIssueDeskTransFB.setStrIssueStoreId(strStoreId);
						_LPIssueDeskTransFB.setStrIssueDate(temp[6]);
						_LPIssueDeskTransFB.setStrStoreName(temp[4]);
						_LPIssueDeskTransFB.setStrCrNo(temp[0]);
						_LPIssueDeskTransFB.setStrStoreName(temp[19]);
						_LPIssueDeskTransFB.setStrDossierShortName(temp[20]);
						_LPIssueDeskTransFB.setStrReturnReqNo(temp[2]);	
						_LPIssueDeskTransFB.setStrDossierReturnReqNo(temp[2]);
						_LPIssueDeskTransFB.setStrPatientType(temp[22].split("\\$")[0]);
						_LPIssueDeskTransFB.setStrGstrReqNo(temp[21]);
						
					    strRequestTypeId="97";
				}				
				
				if(strRaisingReqTypeId.equals("35")|| strRaisingReqTypeId.equals("12") || strRaisingReqTypeId.equals("32") || strRequestTypeId.equalsIgnoreCase("97"))
				{
					strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(_LPIssueDeskTransFB.getStrCrNo(), hosCode, true);
				}
				_LPIssueDeskTransFB.setStrPatientDtl(strPatientDtl);
							
				System.out.println("_LPIssueDeskTransFB.getStrIssueNo()---------------->>>"+_LPIssueDeskTransFB.getStrIssueNo());
				System.out.println("_LPIssueDeskTransFB.getStrIssueStoreId()----------->>>"+_LPIssueDeskTransFB.getStrIssueStoreId());
				System.out.println("_LPIssueDeskTransFB.getStrReturnReqNo()------------>>>"+_LPIssueDeskTransFB.getStrReturnReqNo());				
				
				vo.setStrIssueNo(_LPIssueDeskTransFB.getStrIssueNo());
				vo.setStrIssueStoreId(_LPIssueDeskTransFB.getStrIssueStoreId());
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrRaisingReqTypeId(strRaisingReqTypeId);
				vo.setStrRaisingStoreId(_LPIssueDeskTransFB.getStrIssueStoreId());
				vo.setStrReturnReqNo(_LPIssueDeskTransFB.getStrReturnReqNo());
				
				System.out.println("<<<--------------pkg_dossier_view.Proc_patemp_issue_item_dtl [ Mode - 6 ]---------------->>>");
				
				bo.getIssueItemDetailForReturn(vo);
								
				System.out.println("<<<--------------LPIssueDeskTransDATA --> LPIssueDeskTransHLP.getIssuedItemDetails() ---------------->>>");
				
				strRequestDtl=LPIssueDeskTransHLP.getIssuedItemDetails(vo.getIssuedItemDtlWS(),vo.getStrHospitalCode(),strCostReq,vo);
				
				_LPIssueDeskTransFB.setStrDeptName(vo.getStrDeptName());
				_LPIssueDeskTransFB.setStrRequestTypeId(strRequestTypeId);
				_LPIssueDeskTransFB.setStrStoreId(strStoreId);
				_LPIssueDeskTransFB.setStrRequestDtl(strRequestDtl);
				_LPIssueDeskTransFB.setStrChk(strChk);
				_LPIssueDeskTransFB.setStrSettlementFlag(vo.getStrSettlementFlag());
				
				if (vo.getApprovedBy() != null && vo.getApprovedBy().size() > 0) 
				{
					cmbVal = hisutil.getOptionValue(vo.getApprovedBy(),"0", "0^Select Value", true);
				} 
				else 
				{
					cmbVal = "<option value='0'>Select Value</option>";
				}
			    
				_LPIssueDeskTransFB.setStrRecommendByVal(cmbVal);	
				
				
						
			    System.out.println("<<<--------------LPIssueDeskTransDATA . END---------------->>>");
						 
			
		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "Issue Desk.LPIssueDeskTransDATA.getInitDetailForReturnPage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LPIssueDeskTransDATA->getInitDetailForReturnPage()", strmsgText);
			_LPIssueDeskTransFB.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	
	public static void getInitDetailForReturnViewPage(LPIssueDeskTransFB _LPIssueDeskTransFB,
			HttpServletRequest request) {

		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
		String strPatientDtl="";
		String strmsgText = "";
		String strRequestTypeId="";
		String strRaisingReqTypeId="";
		
		String strRequestDtl="";
		String strChk="";
		String temp[]=null;
		String hosCode="";
		HisUtil hisutil=null;
		String cmbVal="";
		String strStoreId="";
		MmsConfigUtil mmsConfig=null;
		String strCostReq="";
		try {
			
			System.out.println("<<<--------------LPIssueDeskTransDATA . getInitDetailForReturnViewPage------------>>>");
			
				bo = new LPIssueDeskTransBO();
				vo = new LPIssueDeskTransVO();
				hisutil = new HisUtil("MMS","LPIssueDeskTransDATA");
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				mmsConfig=new MmsConfigUtil(hosCode);
				strCostReq=mmsConfig.getStrCostReq();
				
				if (request.getParameter("combo") != null	&& request.getParameter("combo").length() > 0) 
			 	{
					_LPIssueDeskTransFB.setCombo(request.getParameterValues("combo"));
					 strRaisingReqTypeId=request.getParameterValues("combo")[1];
					 strStoreId=request.getParameterValues("combo")[0];
					_LPIssueDeskTransFB.setStrRaisingReqTypeId(strRaisingReqTypeId);
			 	}
				strChk=request.getParameter("chk");
				 if (request.getParameter("comboValue") != null	&& request.getParameter("comboValue").length() > 0) 
				 {
					 _LPIssueDeskTransFB.setComboValue(request.getParameterValues("comboValue")[0]);
					 _LPIssueDeskTransFB.setStrStoreName(_LPIssueDeskTransFB.getComboValue());
				 }
				
				/**
				 * This is used set variables during request type equal to patient
				 */
				if(strRaisingReqTypeId.equals("35") || strRaisingReqTypeId.equals("32")){//Patient
					
					temp=strChk.replace('@', '#').split("#");
					_LPIssueDeskTransFB.setStrItemCategNo(temp[4]);
					_LPIssueDeskTransFB.setStrIssueNo(temp[1]);
					_LPIssueDeskTransFB.setStrIssueStoreId(temp[0]);
					_LPIssueDeskTransFB.setStrCrNo(temp[2]);
					_LPIssueDeskTransFB.setStrIssueDate(temp[5]);
					strRequestTypeId="44";
				}
				/**
				 * This is used set variables during request type equal to employee
				 */
				else if(strRaisingReqTypeId.equals("12")){//Staff
					
					temp=strChk.replace('@', '#').split("#");
					
					_LPIssueDeskTransFB.setStrItemCategNo(temp[4]);
					_LPIssueDeskTransFB.setStrIssueNo(temp[1]);
					_LPIssueDeskTransFB.setStrIssueStoreId(temp[0]);
					_LPIssueDeskTransFB.setStrCrNo(temp[2]);
					_LPIssueDeskTransFB.setStrIssueDate(temp[5]);
					_LPIssueDeskTransFB.setStrEmpNo(temp[3]);
					
					
					strRequestTypeId="45";
				}
				/**
				 * This is used set variables during request type equal to department
				 */
				else//Dept
				{
					 temp=strChk.replace('@', '#').split("#");
					 _LPIssueDeskTransFB.setStrItemCategNo("97");
						_LPIssueDeskTransFB.setStrIssueNo(temp[1]);
						_LPIssueDeskTransFB.setStrLpRequestNo(temp[2]);
						_LPIssueDeskTransFB.setStrIssueStoreId(strStoreId);
						_LPIssueDeskTransFB.setStrIssueDate(temp[6]);
						//_LPIssueDeskTransFB.setStrStoreName(temp[4]);
						_LPIssueDeskTransFB.setStrCrNo(temp[0]);
						//_LPIssueDeskTransFB.setStrStoreName(temp[19]);
						//_LPIssueDeskTransFB.setStrser
						_LPIssueDeskTransFB.setPrintReq("1");
					strRequestTypeId="97";
				}
				
				if(strRaisingReqTypeId.equals("35")|| strRaisingReqTypeId.equals("12") || strRaisingReqTypeId.equals("32") || strRequestTypeId.equalsIgnoreCase("97"))
				{
					strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(_LPIssueDeskTransFB.getStrCrNo(), hosCode, true);
				}
				_LPIssueDeskTransFB.setStrPatientDtl(strPatientDtl);
							
				
				vo.setStrIssueNo(_LPIssueDeskTransFB.getStrIssueNo());
				vo.setStrIssueStoreId(_LPIssueDeskTransFB.getStrIssueStoreId());
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrRaisingReqTypeId(strRaisingReqTypeId);
				vo.setStrRaisingStoreId(_LPIssueDeskTransFB.getStrIssueStoreId());
								
				bo.getIssueItemDetailview(vo); //  pkg_mms_view.Proc_patemp_issue_item_dtl [ Mode - 3 ,4 ]			
				
				bo.getReturnNoDtls(vo);
				
				_LPIssueDeskTransFB.setStrReturnNo(vo.getStrReturnNo());
				
				System.out.println("<<<--------------LPIssueDeskTransDATA -- LPIssueDeskTransHLP.getIssuedItemDetailsForReturnView()------------>>>");
				
				strRequestDtl=LPIssueDeskTransHLP.getIssuedItemDetailsForReturnView(vo.getIssuedItemDtlWS(),vo.getStrHospitalCode(),strCostReq);
						
				_LPIssueDeskTransFB.setStrDeptName(vo.getStrDeptName());
				_LPIssueDeskTransFB.setStrRequestTypeId(strRequestTypeId);
				_LPIssueDeskTransFB.setStrStoreId(strStoreId);
				_LPIssueDeskTransFB.setStrRequestDtl(strRequestDtl);
				_LPIssueDeskTransFB.setStrChk(strChk);
				if (vo.getApprovedBy() != null
						&& vo.getApprovedBy().size() > 0) {
					cmbVal = hisutil.getOptionValue(vo.getApprovedBy(), 
							"0", "0^Select Value", true);
				} else {
					cmbVal = "<option value='0'>Select Value</option>";
				}
			_LPIssueDeskTransFB.setStrRecommendByVal(cmbVal);
			
			System.out.println("<<<--------------LPIssueDeskTransDATA . END------------>>>");
			
						 
			
		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "Issue Desk.LPIssueDeskTransDATA.getInitDetailForReturnViewPage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LPIssueDeskTransDATA->getInitDetailForReturnViewPage()", strmsgText);
			_LPIssueDeskTransFB.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	
	public static void insertData(LPIssueDeskTransFB _LPIssueDeskTransFB,
			HttpServletRequest request){
		
		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
		MmsConfigUtil mcu=null;
		
		String temp[]=null;
		//String strItemIdArray[] = null;
		String strmsgText="";
		String strDescription="";
		String[] values = null;
		String UCreq="";		
		try
		{
			
			mcu=new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			bo= new LPIssueDeskTransBO();
			
			vo = (LPIssueDeskTransVO) TransferObjectFactory.populateData("dossier.transaction.vo.LPIssueDeskTransVO",_LPIssueDeskTransFB);
		
			UCreq=_LPIssueDeskTransFB.getStrUCReq();
			
			if(_LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("12") || _LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("13") || 
						_LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("35") || _LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("98") )
			{
				
				if(_LPIssueDeskTransFB.getStrAdmissionDtlHidVal()!=null)
				{
					
					temp=_LPIssueDeskTransFB.getStrAdmissionDtlHidVal().replace('^', '#').split("#");
					//IPD
					if(temp.length>1)
					{
						vo.setStrAdmissionNo(temp[0]);
						vo.setStrEpisodeCode(temp[1]);
						vo.setStrVisitNo(temp[2]);
						vo.setStrDeptCode(temp[5].substring(0, 3));
						vo.setStrDeptUnitCode(temp[16]);
						vo.setStrWardCode(temp[6]);
						vo.setStrVisitType("0"); 
						vo.setStrTreatmentCat(temp[9]);
						vo.setStrBSIndent("0");
						
					}
					else
					{
						
						vo.setStrAdmissionNo("0");
						vo.setStrEpisodeCode("0");
						vo.setStrVisitNo("0");
						vo.setStrDeptCode("0");
						vo.setStrDeptUnitCode("0");
						vo.setStrWardCode("0");
						vo.setStrVisitType("1"); 
						vo.setStrTreatmentCat("0");
					}
				}
				else
				{
					vo.setStrAdmissionNo("0");
					vo.setStrEpisodeCode("0");
					vo.setStrVisitNo("0");
					vo.setStrDeptCode("0");
					vo.setStrDeptUnitCode("0");
					vo.setStrWardCode("0");
					vo.setStrVisitType("1");       //OPD
					vo.setStrTreatmentCat("0");
				}
				
			}
			else
			{
			
				vo.setStrAdmissionNo("0");
				vo.setStrEpisodeCode("0");
				vo.setStrVisitNo("0");
				vo.setStrDeptCode("0");
				vo.setStrDeptUnitCode("0");
				vo.setStrWardCode("0");
				vo.setStrVisitType("1"); 
				vo.setStrCrNo("0");
				vo.setStrTreatmentCat("0");
			}
			
			
			strDescription=_LPIssueDeskTransFB.getStrCrNo();
			
			//System.out.println("----Req_Type-"+_LPIssueDeskTransFB.getStrRequestTypeId()+"-------strDescription----"+strDescription);
			vo.setStrCrNo(_LPIssueDeskTransFB.getStrCrNo());
			vo.setStrDescription(strDescription);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStockDtlsId(_LPIssueDeskTransFB.getStockDtlsId());
			vo.setStrUrgentFlg(_LPIssueDeskTransFB.getStrUrgentFlg().replace("$","#").split("#")[0]);
			vo.setStrPatientType(_LPIssueDeskTransFB.getStrPatientType());
			vo.setStrDossierShortName(_LPIssueDeskTransFB.getStrDossierShortName());
			
			
			bo.insertData(vo);
			
			
			if(vo.getStrMsgType().equals("1")){
				_LPIssueDeskTransFB.setStrFlag("0");
				
				throw new Exception(vo.getStrMsgString());
			}else{
				_LPIssueDeskTransFB.setStrFlag("0");
				if(vo.getStrBSReqNo() != null && !vo.getStrBSReqNo().equals("0"))
				{
					_LPIssueDeskTransFB.setStrMsg("Dossier Save Successfully With Issue No :"+vo.getStrBSReqNo()+" For  C.R.No.("+_LPIssueDeskTransFB.getStrCrNo()+")");
					//System.out.println("vo.getStrIssueNo------->>"+vo.getStrIssueNo());
					//System.out.println("vo.getStrBSReqNo------->>"+vo.getStrBSReqNo());
					
					_LPIssueDeskTransFB.setStrIssueNo(vo.getStrBSReqNo());
					_LPIssueDeskTransFB.setStrBSReqNo(vo.getStrBSReqNo());
					
					//System.out.println("_LPIssueDeskTransFB.getStrIssueNo------->>"+_LPIssueDeskTransFB.getStrIssueNo());
					//System.out.println("_LPIssueDeskTransFB.getStrBSReqNo------->>"+_LPIssueDeskTransFB.getStrBSReqNo());
					
										
					_LPIssueDeskTransFB.setPrintReq("1");
				}
				else
				{
					_LPIssueDeskTransFB.setStrIssueNo(vo.getStrIssueNo());
					_LPIssueDeskTransFB.setStrBSReqNo(vo.getStrIssueNo());
					_LPIssueDeskTransFB.setPrintReq("1");
				}
					
			}			
			_LPIssueDeskTransFB.setStrUCReq(UCreq);
		}
		catch(Exception _err)
		{
			_err.printStackTrace();
			strmsgText = "Issue Desk.LPIssueDeskTransDATA.insertData(vo) --> "+ _err.getMessage();
			
			HisException eObj = new HisException("mms","LPIssueDeskTransDATA->getIndentDetails()", strmsgText);
			if(strmsgText.contains("Patient Account Balance Going To Be Insufficient.Please Deposit Part Payment!!"))
				_LPIssueDeskTransFB.setStrErr("Patient Account Balance Going To Be Insufficient.Please Deposit Part Payment!!");
			else		
				_LPIssueDeskTransFB.setStrErr("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		}
	}
	public static void insertReturn(LPIssueDeskTransFB _LPIssueDeskTransFB,
			HttpServletRequest request){
		
		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
		MmsConfigUtil mcu=null;
		String temp[]=null;
		String strmsgText="";
		String strDescription="";
		try{
			mcu=new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			bo= new LPIssueDeskTransBO();
			
			 System.out.println("strChk-------->>>"+_LPIssueDeskTransFB.getStrChk());
			
			
			vo = (LPIssueDeskTransVO) TransferObjectFactory.populateData("dossier.transaction.vo.LPIssueDeskTransVO",_LPIssueDeskTransFB);
			_LPIssueDeskTransFB.setStrRaisingReqTypeId("98");
		if(_LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("12") || _LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("13")  || _LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("35") || _LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("98")){
				if(_LPIssueDeskTransFB.getStrAdmissionDtlHidVal()!=null){
					temp=_LPIssueDeskTransFB.getStrAdmissionDtlHidVal().replace('^', '#').split("#");
					if(temp.length>1){
						vo.setStrAdmissionNo(temp[0]);
						vo.setStrEpisodeCode(temp[1]);
						vo.setStrVisitNo(temp[2]);
						vo.setStrDeptCode(temp[5].substring(0, 3));
						vo.setStrDeptUnitCode(temp[5]);
						vo.setStrWardCode(temp[6]);
						vo.setStrVisitType("0");//IPD
						vo.setStrTreatmentCat(temp[9]);
					}
					else{
						vo.setStrAdmissionNo("0");
						vo.setStrEpisodeCode("0");
						vo.setStrVisitNo("0");
						vo.setStrDeptCode("0");
						vo.setStrDeptUnitCode("0");
						vo.setStrWardCode("0");
						vo.setStrVisitType("1");
						vo.setStrTreatmentCat("0");
					}
				}
				else
				{
					vo.setStrAdmissionNo("0");
					vo.setStrEpisodeCode("0");
					vo.setStrVisitNo("0");
					vo.setStrDeptCode("0");
					vo.setStrDeptUnitCode("0");
					vo.setStrWardCode("0");
					vo.setStrVisitType("1");       //OPD
					vo.setStrTreatmentCat("0");
				}
			}
			else{
					vo.setStrAdmissionNo("0");
					vo.setStrEpisodeCode("0");
					vo.setStrVisitNo("0");
					vo.setStrDeptCode("0");
					vo.setStrDeptUnitCode("0");
					vo.setStrWardCode("0");
					vo.setStrVisitType("1"); 
					vo.setStrCrNo("0");
					vo.setStrTreatmentCat("0");
			}
		
		   System.out.println("------------- LPIssueDeskTransDATA.insertReturn -----------------");
		   System.out.println("_LPIssueDeskTransFB.getStrRequestTypeId() ------------------"+_LPIssueDeskTransFB.getStrRequestTypeId());
		   System.out.println("_LPIssueDeskTransFB.getStrDossierReturnReqNo()--- Dossier  Return Request No-----"+_LPIssueDeskTransFB.getStrDossierReturnReqNo());
		   System.out.println("vo.getStrDossierReturnReqNo()----- Dossier  Return Request No--------------------"+vo.getStrDossierReturnReqNo());
			
			
			strDescription=_LPIssueDeskTransFB.getStrCrNo();
			
			
			System.out.println("strDescription----------"+strDescription);
			 
			vo.setStrDescription(strDescription);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrGstrReqNo(_LPIssueDeskTransFB.getStrGstrReqNo());
			bo.insertRet(vo);
			if(vo.getStrMsgType().equals("1")){
				_LPIssueDeskTransFB.setStrFlag("0");
				
				throw new Exception(vo.getStrMsgString());
			}else{
				_LPIssueDeskTransFB.setStrFlag("1");
			}
			_LPIssueDeskTransFB.setStrReturnNo(vo.getStrReturnNo());
			_LPIssueDeskTransFB.setStrMsg("Data Save successfully ");
			_LPIssueDeskTransFB.setPrintReq("1");
		}
		catch(Exception _err){
	    
			_err.printStackTrace();
	    strmsgText = "Issue Desk.LPIssueDeskTransDATA.insertData(vo) --> "
				+ _err.getMessage();
		HisException eObj = new HisException("mms",
				"LPIssueDeskTransDATA->getIndentDetails()", strmsgText);
		_LPIssueDeskTransFB.setStrErr("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		}
	}

	/**
	 * This method will get the POPUP info according to the selected Bill No. to
	 * generate a PopUp in HLP
	 * 
	 * @param request
	 * @param response
	 */
	/*public static void getPopUp(HttpServletRequest request,
			HttpServletResponse response, LPIssueDeskTransFB formBean) {
		String strPopUpDtls = null;
		String index = "";
		String strmsgText = null;

		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
		HisUtil hisutil = null;
		String strReqParam = "";
		String[] temp = null;
		String strItemCategoryNo = "";
		String strItemBrand = "";
		String strItemId = "";
		String strHospitalCode = "";
		String strStoreId = "";
		try 
		{
			
			bo = new LPIssueDeskTransBO();
			vo = new LPIssueDeskTransVO();
			
			strHospitalCode = request.getSession()
					.getAttribute("HOSPITAL_CODE").toString();
			strReqParam = (String) request.getParameter("hiddenVal");
			
			temp = strReqParam.replace("^", "#").split("#");
			strItemId = temp[0];
			strItemBrand = temp[1];
			strItemCategoryNo = temp[2];
			strStoreId = temp[3];

//			System.out.println("data strItemId"+strItemId);
//			System.out.println("data strItemBrand"+strItemBrand);
//			System.out.println("data strItemCategoryNo"+strItemCategoryNo);
//			System.out.println("data strHospitalCode"+strHospitalCode);
//			System.out.println("data strStoreId"+strStoreId);
			
			vo.setStrItemId(strItemId);
			vo.setStrItemBrand(strItemBrand);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrStoreId(strStoreId);

			index = (String) request.getParameter("index");
			bo.getPopUpInfo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				strPopUpDtls = LPIssueDeskTransHLP.getPopUpInfo(vo.getPopupWS(),
						index);
               
				if (strPopUpDtls.equals("ERROR")) {

					HisException eObj = new HisException("MMS",
							"LPIssueDeskTransDATA->getPopUp()", strmsgText);
					strmsgText = "ERROR####Application Error [ERROR ID : "
							+ eObj.getErrorID()
							+ "],Contact System Administrator! ";
					eObj = null;
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().write(strmsgText);
					throw new Exception(vo.getStrMsgString());
				} else {
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().write(strPopUpDtls);

				}
			}

		} catch (Exception e) {
			strmsgText = "dossier.transaction.LPIssueDeskTransDATA.getPopUp(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"LPIssueDeskTransDATA->getPopUp()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;

		} finally {
			if (vo != null)
				vo = null;
			if (bo != null)
				bo = null;
			if (hisutil != null)
				hisutil = null;
		}

	}

	
	 * This method calls when we again click on a hyperlink In this method first
	 * we set the parameter value on VO and then use in HLP to show again same
	 * pop up. This parameter(popupData) is already set by the value of flag i
	 * in JS file(AJAX Function) and flag i is already set by the link info when
	 * a link is clicked first time
	 * 
	 * @param request
	 * @param response
	
	public static void getPopUpData(HttpServletRequest request,
			HttpServletResponse response, LPIssueDeskTransFB formBean) {

		String strPopUpDtls = null;
		String strmsgText = null;
		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
		HisUtil hisutil = null;
		System.out.println("Inside Data getPoPUpData--2");
		try {
			
			bo = new LPIssueDeskTransBO();
			vo = new LPIssueDeskTransVO();
			//System.out.println("PoppUp Data-->>>>>"+(String) request.getParameter("popupData"));
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrPopUpData((String) request.getParameter("popupData"));
            
			 strPopUpDtls = LPIssueDeskTransHLP.getPopUpData(vo.getStrPopUpData());

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().write(strPopUpDtls);

			}

		} catch (Exception e) {
			strmsgText = "dossier.transaction.LPIssueDeskTransDATA.getPopUpData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"LPIssueDeskTransDATA->getPopUpData()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;

		} finally {
			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
		}

	}*/

	public static String patientDiagDtl(String strCrNo,String strHospitalCode)
	{
		LPIssueDeskTransVO vo = new LPIssueDeskTransVO();	
		LPIssueDeskTransBO bo = new LPIssueDeskTransBO();
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
				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				sb.append("<tr><td width='50%' class='LABEL' ><div align='center'>Diagnosis Name(Code)</div></td>");
				sb.append("<td width='50%' class='LABEL' ><div align='center'>Treatment Consultant</div></td></tr> ");
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
					sb.append("<tr><td width='50%' class='CONTROL'><div align='center'>"+"-"+"("+"-"+")</div>");
					sb.append("</td>");
					sb.append("<td width='50%' class='CONTROL'><div align='center'>");
					sb.append("-");
					sb.append("<input type='hidden' name='strDiagCode' value='"+ "-" + "'><input type='hidden' name='strEmpCode' value='"+ "0" + "'></div></td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
			} 
			catch (Exception e) 
			{
				try {
					throw new Exception("LPIssueDeskTransDATA-->diagDtl-->"	+ e.getMessage());
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
	
	public static void showReport(LPIssueDeskTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();

		String reportFormat = "pdf";
		String strReqNo = "";
		String combo[] = null;
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = "";
			String[] strChk = request.getParameterValues("chk");
			

			for (int i = 0, stopI = strChk.length; i < stopI; i++) {
				String[] strtemp = strChk[i].replace("@", "#").split("#");
				if (i == 0) {
					strReqNo = strReqNo + strtemp[1];

				} else {
					strReqNo = strReqNo + "," + strtemp[1];

				}
			}

			combo = request.getParameterValues("combo");
			String[] strTemp = combo[0].split("\\^");
			String strStoreId = strTemp[0];
	
				System.out.println("report_id"+ strReportId);
				System.out.println("hospCode"+ strHospitalCode);
				System.out.println("storeId"+ strStoreId);
				System.out.println("issueNo"+ strReqNo);
				String reportPath = "/mms/reports/issue_patient_mmsrpt.rptdesign";
				String strReportName = "UTILITY CERTIFICATE";

				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("issueNo", strReqNo);

				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);


		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	
	public static void issueDtlsInit(HttpServletRequest request,
			HttpServletResponse response, LPIssueDeskTransFB formBean) 
	{

		String strSearchItemInitView = "";
		//boolean printFlag = false;
		
		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
		String strMode = "";
		String strStoreId = "";
		String strIssueNo = "";

		try {

			    strMode = (String) request.getParameter("strMode");
			 strStoreId = (String) request.getParameter("strStoreId");
			 strIssueNo = (String) request.getParameter("strIssueNo");			
			         bo = new LPIssueDeskTransBO();
			         vo = new LPIssueDeskTransVO();
			
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString()); 
			formBean.setStrStoreId(strStoreId);
			formBean.setStrMode(strMode);
			formBean.setStrIssueNo(strIssueNo);
			
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
			System.out.println("-----------------LPIssueDeskTransDATA.issueDtlsInit()---------strMode ["+strMode+"]--------");
			
			System.out.println("---LPIssueDeskTransDATA.issueDtlsInit()--pkg_dossier_view.Proc_Emp_Issue_Detail [ Mode - 4 ]----");
			
			bo.getIssueDtlsInitDtls(vo);  // pkg_dossier_view.Proc_Emp_Issue_Detail [ Mode - 4 ]
			if(strMode.equals("4"))
			{
				System.out.println("---LPIssueDeskTransDATA.issueDtlsInit()--pkg_dossier_view.Proc_Emp_Issue_Detail [ Mode - 5 ]----");
				bo.getIssueDtlsInitDtlsExtraItems(vo); // pkg_dossier_view.Proc_Emp_Issue_Detail [ Mode - 5]
			}

			if (vo.getStrMsgType().equals("1")) 
				throw new Exception(vo.getStrMsgString());
			
 			formBean.setWsIssueDetails(vo.getWsIssueDetails());
 			
 			System.out.println("-WsIssueDetails --Size in HLP ----"+formBean.getWsIssueDetails().size());
 			
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
				   vo.setStrIssueNo(formBean.getWsIssueDetails().getString(11));

				   if(strMode.equals("4"))
				   {
					    System.out.println("---LPIssueDeskTransDATA.issueDtlsInit()--pkg_dossier_view.Proc_Emp_Issue_Detai [ Mode - 5 ]----");
						bo.getIssueDtlsInitDtlsExtraItems(vo);
				   }
				   else
				   {
					   formBean.setStrBSReqNo(formBean.getWsIssueDetails().getString(23));
				   }   
				   formBean.setWsExtraIssueDetails(vo.getWsExtraIssueDetails());
					if (vo.getStrMsgType().equals("1")) 
						throw new Exception(vo.getStrMsgString());
				 //  formBean.setStrPrescribedBy("");
				   formBean.setStrIssueDate(formBean.getWsIssueDetails().getString(12));
				   formBean.setStrCrNo(formBean.getWsIssueDetails().getString(13)+"("+formBean.getWsIssueDetails().getString(19)+")");	
				   //formBean.setStrServiceName(formBean.getWsIssueDetails().getString(8));
				   formBean.setStrDossierName(formBean.getWsIssueDetails().getString(9));
				   formBean.setStrDeptName(formBean.getWsIssueDetails().getString(17));
				   formBean.setStrServiceName(formBean.getWsIssueDetails().getString(18)+"("+formBean.getWsIssueDetails().getString(8)+")");
				  
				   //formBean.setStrHindiText("");
				   //formBean.setStrRegNo("");	
				   //formBean.setStrMode("1");	
				   //formBean.setStrLFAccountNo("");
				   //formBean.setStrLocDL("");
				   
				   formBean.getWsIssueDetails().beforeFirst();
			}
			
			 System.out.println("---  LPIssueDeskTransHLP.getIssueDtlsInitView  ----");
			 
			strSearchItemInitView = LPIssueDeskTransHLP.getIssueDtlsInitView(formBean);
			
			System.out.println("---  END  ----");

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
	
	public static void settelmentVoucher(HttpServletRequest request,
			HttpServletResponse response, LPIssueDeskTransFB formBean) 
	{

		String strSearchItemInitView = "";
		//boolean printFlag = false;
		
		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
		String strMode = "";
		String strStoreId = "";
		String strIssueNo = "";

		try {

			    strMode = (String) request.getParameter("strMode");
			 strStoreId = (String) request.getParameter("strStoreId");
			 strIssueNo = (String) request.getParameter("strIssueNo");			
			         bo = new LPIssueDeskTransBO();
			         vo = new LPIssueDeskTransVO();
			
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString()); 
			formBean.setStrStoreId(strStoreId);
			formBean.setStrMode(strMode);
			formBean.setStrIssueNo(strIssueNo);
			
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
			System.out.println("-----------------LPIssueDeskTransDATA.settelmentVoucher()---------strMode ["+strMode+"]--------");
			
			System.out.println("---LPIssueDeskTransDATA.issueDtlsInit()--pkg_dossier_view.Proc_Emp_Issue_Detail [ Mode - 4 ]----");
			
			bo.getIssueDtlsInitDtls(vo);  // pkg_dossier_view.Proc_Emp_Issue_Detail [ Mode - 4 ]
			if(strMode.equals("4"))
			{
				System.out.println("---LPIssueDeskTransDATA.issueDtlsInit()--pkg_dossier_view.Proc_Emp_Issue_Detail [ Mode - 5 ]----");
				bo.getIssueDtlsInitDtlsExtraItems(vo); // pkg_dossier_view.Proc_Emp_Issue_Detail [ Mode - 5]
			}

			if (vo.getStrMsgType().equals("1")) 
				throw new Exception(vo.getStrMsgString());
			
 			formBean.setWsIssueDetails(vo.getWsIssueDetails());
 			
 			System.out.println("-WsIssueDetails --Size in HLP ----"+formBean.getWsIssueDetails().size());
 			
			if(formBean.getWsIssueDetails().next() && formBean.getWsIssueDetails().size() > 0)
			{
				/*
				   1.Drug Name
				   2.Brand_Id
				   3 0
				   4.Rate
				   5.Qty
				   6.Cost
				   7.CATG_NAME
				   8.SERVICE_TYPE
				   9.SERVICE_NAME
				   10.PAT_NAME
				   11.ISSUE_NO
				   12.ISSUE_DATE
				   13.PUK_NO
				   14.STORE_NAME
				   15.BATCH
				   16.REMARKS
				   17.DEPT_NAME
				   18.SERVICE
				   19.PAT_STATUS
				   20.USER_NAME
				   21.SETTELMENT_FLAG
				   22.EXP_DATE
				   23.hnum_dossier_req_id
				   24.extra_item_flg
				   25. ' - ' 
				   26.gdt_finalized_date ^ Settel_By_User_Name
				 */	
				//System.out.println("Hidden Val==>"+formBean.getWsIssueDetails().getString(1));
				   formBean.setStrHospitalName(formBean.getWsIssueDetails().getString(1).split("\\^")[0]);
				   formBean.setStrStoreName(formBean.getWsIssueDetails().getString(14));	
				   formBean.setStrPatientName(formBean.getWsIssueDetails().getString(10));
				   formBean.setStrIssueNo(formBean.getWsIssueDetails().getString(11));
				   vo.setStrIssueNo(formBean.getWsIssueDetails().getString(11));

				   if(strMode.equals("4"))
				   {
					    System.out.println("---LPIssueDeskTransDATA.issueDtlsInit()--pkg_dossier_view.Proc_Emp_Issue_Detai [ Mode - 5 ]----");
						bo.getIssueDtlsInitDtlsExtraItems(vo);
				   }
				   else
				   {
					   formBean.setStrBSReqNo(formBean.getWsIssueDetails().getString(23));
				   }   
				   formBean.setWsExtraIssueDetails(vo.getWsExtraIssueDetails());
					if (vo.getStrMsgType().equals("1")) 
						throw new Exception(vo.getStrMsgString());
				
				   formBean.setStrIssueDate(formBean.getWsIssueDetails().getString(12));
				   formBean.setStrCrNo(formBean.getWsIssueDetails().getString(13)+"("+formBean.getWsIssueDetails().getString(19)+")");					
				   formBean.setStrDossierName(formBean.getWsIssueDetails().getString(9));
				   formBean.setStrDeptName(formBean.getWsIssueDetails().getString(17));
				   formBean.setStrServiceName(formBean.getWsIssueDetails().getString(18)+"("+formBean.getWsIssueDetails().getString(8)+")");
				  
				   formBean.setStrSettlementFlag(formBean.getWsIssueDetails().getString(21));
				   
				   formBean.setStrSetteledByName(formBean.getWsIssueDetails().getString(26).split("\\^")[1]);
				   formBean.setStrSetteledOnDate(formBean.getWsIssueDetails().getString(26).split("\\^")[0]);
				   
				   formBean.getWsIssueDetails().beforeFirst();
			}
			
			 System.out.println("---  LPIssueDeskTransHLP.settelmentVoucher()  ----");
			 
			strSearchItemInitView = LPIssueDeskTransHLP.settelmentVoucher(formBean);
			
			System.out.println("---  END  ----");

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
	
	public static void returnNewItem(HttpServletRequest request,
			HttpServletResponse response, LPIssueDeskTransFB formBean) 
	{

		String strSearchItemInitView = "";
		//boolean printFlag = false;
		
		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
		String strMode = "";
		String strStoreId = "";
		String strIssueNo = "";
		String strReturnNo = "";

		try {
			
			//var url="LPIssueDeskTransCNT.cnt?hmode="+mode+"&strIssueNo="+ issueNo+"&strStoreId="+storeId+"&strMode=4&returnNo="+transferNo;

			    strMode  = (String) request.getParameter("strMode");
			 strStoreId  = (String) request.getParameter("strStoreId");
			 strIssueNo  = (String) request.getParameter("strIssueNo");	
			 strReturnNo = (String) request.getParameter("returnNo");
			         bo = new LPIssueDeskTransBO();
			         vo = new LPIssueDeskTransVO();
			
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString()); 
			formBean.setStrStoreId(strStoreId);
			formBean.setStrMode(strMode);
			formBean.setStrIssueNo(strIssueNo);
			
			vo.setStrMode(formBean.getStrMode());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrIssueNo(formBean.getStrIssueNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrReturnNo(strReturnNo);
			
			
			System.out.println("-----------------LPIssueDeskTransDATA.returnNewItem()---------strMode ["+strMode+"]--------");
			
			System.out.println("Store Id--------"+vo.getStrStoreId());
			System.out.println("Issue No--------"+vo.getStrIssueNo());
			System.out.println("Return No--------"+vo.getStrReturnNo());
			
			System.out.println("---LPIssueDeskTransDATA.issueDtlsInit()--pkg_dossier_view.Proc_Emp_Issue_Detail [ Mode - 4 ]----");
			
			bo.getIssueDtlsListTwo(vo);  // pkg_dossier_view.Proc_Emp_Issue_Detail [ Mode - 4 ]
			if(strMode.equals("4"))
			{
				System.out.println("---LPIssueDeskTransDATA.issueDtlsInit()--pkg_dossier_view.Proc_Emp_Issue_Detail [ Mode - 5 ]----");
				bo.getIssueDtlsInitDtlsExtraItems(vo); // pkg_dossier_view.Proc_Emp_Issue_Detail [ Mode - 5]
			}

			if (vo.getStrMsgType().equals("1")) 
				throw new Exception(vo.getStrMsgString());
			
 			formBean.setWsIssueDetails(vo.getWsIssueDetails());
 			
			if(formBean.getWsIssueDetails().next() && formBean.getWsIssueDetails().size() > 0)
			{
				System.out.println("DATA . Size of Return--------"+formBean.getWsIssueDetails().size());
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
				   vo.setStrIssueNo(formBean.getWsIssueDetails().getString(11));

				   if(strMode.equals("4"))
				   {
					    System.out.println("---LPIssueDeskTransDATA.issueDtlsInit()--pkg_dossier_view.Proc_Emp_Issue_Detai [ Mode - 5 ]----");
						bo.getIssueDtlsInitDtlsExtraItems(vo);
				   }
				   else
				   {
					   formBean.setStrBSReqNo(formBean.getWsIssueDetails().getString(23));
				   }   
				   formBean.setWsExtraIssueDetails(vo.getWsExtraIssueDetails());
					if (vo.getStrMsgType().equals("1")) 
						throw new Exception(vo.getStrMsgString());
				 //  formBean.setStrPrescribedBy("");
				   formBean.setStrIssueDate(formBean.getWsIssueDetails().getString(12));
				   formBean.setStrCrNo(formBean.getWsIssueDetails().getString(13)+"("+formBean.getWsIssueDetails().getString(19)+")");	
				   //formBean.setStrServiceName(formBean.getWsIssueDetails().getString(8));
				   formBean.setStrDossierName(formBean.getWsIssueDetails().getString(9));
				   formBean.setStrDeptName(formBean.getWsIssueDetails().getString(17));
				   formBean.setStrServiceName(formBean.getWsIssueDetails().getString(18)+"("+formBean.getWsIssueDetails().getString(8)+")");
				  
				   formBean.getWsIssueDetails().beforeFirst();
				   
				   strSearchItemInitView = LPIssueDeskTransHLP.getIssueDtlsInitView(formBean);
			}
			else
			{
				System.out.println("Extra Item . Size of --------"+vo.getWsExtraIssueDetails().size());
				System.out.println("Dtj . Size of --------"+vo.getBrandDtlWs().size());
				formBean.setWsExtraIssueDetails(vo.getWsExtraIssueDetails());
				
				 /*
			       1.Issue No
			       2.Issue Date
			       3.Req No
			       4.Req Date
			       5.Patient Name
			       6.Issuing Store Name
			       7.DeptName_Unit Name
			       8.CR No
			      */		
				while(vo.getBrandDtlWs().next())
				{
					formBean.setStrIssueNo(vo.getBrandDtlWs().getString(1));
					formBean.setStrIssueDate(vo.getBrandDtlWs().getString(2));
					formBean.setStrReqStatusName(vo.getBrandDtlWs().getString(3));
					formBean.setStrRequestDate(vo.getBrandDtlWs().getString(4));
					formBean.setStrPatientName(vo.getBrandDtlWs().getString(5));
					formBean.setStrStoreName(vo.getBrandDtlWs().getString(6));	
					formBean.setStrDeptName(vo.getBrandDtlWs().getString(7));
					formBean.setStrCrNo(vo.getBrandDtlWs().getString(5)+"("+vo.getBrandDtlWs().getString(8)+")");
				}
				System.out.println(" --- LPIssueDeskTransHLP.getAddItemView ----");
				strSearchItemInitView = LPIssueDeskTransHLP.getAddItemView(formBean);
			}
			
			

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
	
	public static void getInitDetailForViewPage(LPIssueDeskTransFB _LPIssueDeskTransFB,
			HttpServletRequest request) {

		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
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
		String strCostReq="",dossierReqStatus="";
		StringBuffer buff=null;
		BillConfigUtil billConfig=null;
		String RaisingStoreId="RaisingStoreI";
		try 
		{
			
				bo = new LPIssueDeskTransBO();
				vo = new LPIssueDeskTransVO();
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				mmsConfig=new MmsConfigUtil(hosCode);
				billConfig=new BillConfigUtil(hosCode);
				strCostReq=mmsConfig.getStrCostReq();
				/*
				 hnum_dossier_req_id   @ gnum_hospital_code   @ hrgnum_puk        @ hnum_req_mode @  
				 hnum_ref_req_id       @ hnum_servicetype_id  @ hnum_service_id   @ hstr_service_name @  
				 hnum_dossier_id       @ hnum_dossier_status  @ hstr_entry_remark @ hstr_post_remark @   
				 hnum_cancel_reason_id @  hstr_cancel_remark  @ gnum_isvalid      @  gdt_entry_date @  
				 gnum_seat_id          @  nvl(hstnum_patient_type,0)
				*/
				
				System.out.println("<<<--------------LPIssueDeskTransCNT . ISSUEVIEW . LPIssueDeskTransDATA . getInitDetailForViewPage()---------------->>>");
				
				
				
				 if (request.getParameter("combo") != null	&& request.getParameter("combo").length() > 0) 
			 	 {
					
					System.out.println("dossier status 1 - New , 4 - Processed  -->> "+request.getParameterValues("combo")[2]);
					
					_LPIssueDeskTransFB.setCombo(request.getParameterValues("combo"));
					strRaisingReqTypeId = request.getParameterValues("combo")[1];
					strStoreId          = request.getParameterValues("combo")[0];
					dossierReqStatus    = request.getParameterValues("combo")[2];
					_LPIssueDeskTransFB.setStrRaisingReqTypeId(strRaisingReqTypeId);
					
			 	 }
				 strChk=request.getParameter("chk");
				 
				 System.out.println("strChk  -->> "+strChk);
				 if (request.getParameter("comboValue") != null	&& request.getParameter("comboValue").length() > 0) 
				 {
					 _LPIssueDeskTransFB.setComboValue(request.getParameterValues("comboValue")[0]);
					 _LPIssueDeskTransFB.setStrStoreName(_LPIssueDeskTransFB.getComboValue());
					 _LPIssueDeskTransFB.setStrPatientType((strChk.split("\\@")[17]).split("\\$")[0]);
					 vo.setStrPatientType((strChk.split("\\@")[17]).split("\\$")[0]);
				 }
			/**
			 * This is used set variables during request type equal to patient
			 */
//			if(strRaisingReqTypeId.equals("13")){
				temp=strChk.replace('@', '#').split("#");
				//_LPIssueDeskTransFB.setStrItemCategNo(temp[0]);
				_LPIssueDeskTransFB.setStrLpRequestNo(temp[0]);
				_LPIssueDeskTransFB.setStrRequestDate(temp[14]);
				//_LPIssueDeskTransFB.setStrRaisingStoreId(temp[3]);
				_LPIssueDeskTransFB.setStrCrNo(temp[2]);
				_LPIssueDeskTransFB.setStrBSReqNo(temp[0]);
				_LPIssueDeskTransFB.setStrPoNo("0");
				_LPIssueDeskTransFB.setStrPoStoreId("0");
				_LPIssueDeskTransFB.setStrUrgentFlg("0");
				_LPIssueDeskTransFB.setStrStoreId(strStoreId);
				_LPIssueDeskTransFB.setStrDossierStatusFlag(temp[9]);
				//_LPIssueDeskTransFB.setStrDossierShortName(temp[18].split("\\$")[0]);
				strRequestTypeId="98";
				_LPIssueDeskTransFB.setPrintReq("1");

				strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(_LPIssueDeskTransFB.getStrCrNo(), hosCode, true);

			   _LPIssueDeskTransFB.setStrPatientDtl(strPatientDtl);
			
			
			
			
				vo.setStrHospitalCode(hosCode);
				vo.setStrRaisingStoreId(_LPIssueDeskTransFB.getStrRaisingStoreId());
				vo.setStrLpRequestNo(_LPIssueDeskTransFB.getStrLpRequestNo());
				vo.setStrRequestDate(_LPIssueDeskTransFB.getStrRequestDate());
				vo.setStrRaisingReqTypeId(strRaisingReqTypeId);
				vo.setStrPoStoreId(_LPIssueDeskTransFB.getStrPoStoreId());
				vo.setStrPoNo(_LPIssueDeskTransFB.getStrPoNo());
				vo.setStrCrNo(_LPIssueDeskTransFB.getStrCrNo());
				vo.setStrUrgentFlg(_LPIssueDeskTransFB.getStrUrgentFlg());
				vo.setStrFinStartDate(mmsConfig.getStrFinancialStartDate(strStoreId, hosCode));
				vo.setStrFinEndDate(mmsConfig.getStrFinancialEndDate(strStoreId, hosCode));
				vo.setStrBSReqNo("0");
				vo.setStrStoreId(_LPIssueDeskTransFB.getStrStoreId());
				vo.setStrPatientType(_LPIssueDeskTransFB.getStrPatientType());
				vo.setStrDossierStatusFlag(_LPIssueDeskTransFB.getStrDossierStatusFlag());
				vo.setDossierReqStatus(dossierReqStatus);
			
			    System.out.println("dossier status flag -->> "+vo.getStrDossierStatusFlag());
			 
			    System.out.println("<<<--------------LPIssueDeskTransDATA . pkg_dossier_view.proc_hstt_lp_req_item_dtl [ Mode - 1 ]-------->>>");
			    System.out.println("<<<--------------LPIssueDeskTransDATA . pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl [ Mode -1 & 2 (Patient Type 1 - Mode 1) ]---------------->>>");
			    System.out.println("<<<--------------LPIssueDeskTransDATA . PKG_MMS_VIEW.proc_hstt_pat_account_dtl [ Mode - 1 ]---------------->>>");
			    System.out.println("<<<--------------LPIssueDeskTransDATA . MMS_MST.get_store_dtl [ Mode - 1 ]---------------->>>");
			
				bo.getLPRequestDetail(vo);  // pkg_dossier_view.proc_hstt_lp_req_item_dtl [ Mode - 1 ] , pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl [ Mode -3 ]
				                            // PKG_MMS_VIEW.proc_hstt_pat_account_dtl [ Mode - 1 ]  , MMS_MST.get_store_dtl [ Mode - 1 ]
				
				bo.getIssueNoDtls(vo);
			
			   _LPIssueDeskTransFB.setStrIssueNo(vo.getStrIssueNo());
			   _LPIssueDeskTransFB.setStrDeptName(vo.getStrDeptName());
			   
			   _LPIssueDeskTransFB.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
				WebRowSet wb = vo.getPatAccountDtl();
				if(wb!=null)
				{
					if(wb.size()!=0) 
					{
						
						while(wb.next()){
							_LPIssueDeskTransFB.setStrPatAccountNo(wb.getString(1));
							_LPIssueDeskTransFB.setStrPatAccountBal(wb.getString(2));
						}
					}
				}
				else
				{
					
				}
				_LPIssueDeskTransFB.setStrHospitalCode(hosCode);
				
				System.out.println("--------------LPIssueDeskTransHLP.initViewForIssueAddPage  ---- -->> ");
				strRequestDtl=LPIssueDeskTransHLP.initViewForIssueAddPage(_LPIssueDeskTransFB);					
				_LPIssueDeskTransFB.setStrRequestDtl(strRequestDtl);
				
			
			System.out.println("mmsConfig.getStrSCMIntegration----------"+mmsConfig.getStrSCMIntegration().equals("1"));
			System.out.println("vo.getStrLpRequestNo--------------------"+vo.getStrLpRequestNo().substring(0,2).equals("10"));
			
			if(mmsConfig.getStrSCMIntegration().equals("1") && vo.getStrLpRequestNo().substring(0,2).equals("11"))
			{
				buff=new StringBuffer();
				buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				buff.append("<tr>");
				buff.append("<td class='multiControl'>Integration with e-Aushadhi is yes. So, dossier issue can't be processed</td></tr></table>");
				
				strIssueItemId = buff.toString();
			}
			else
			{
				System.out.println("--------------LPIssueDeskTransDATA . LPIssueDeskTransHLP.getItemDetails ---- Size-->> "+vo.getRequestItemDtlWS().size());
				
				strRequestItemDtl=LPIssueDeskTransHLP.getItemDetails(vo.getRequestItemDtlWS());
				
				_LPIssueDeskTransFB.setStrRequestItemDtl(strRequestItemDtl);
				
				System.out.println("--------------LPIssueDeskTransDATA . LPIssueDeskTransHLP.getIssueItemDetailsForIssueView --Issue Item Dtl -- Size-->> "+vo.getIssueItemDtlWS().size());
				
				strIssueItemId=LPIssueDeskTransHLP.getIssueItemDetailsForIssueView(vo.getIssueItemDtlWS(),strCostReq,strStoreId,hosCode,vo.getStrRaisingStoreId(),vo.getStrBSReqNo(),vo);
			
				
			}
			_LPIssueDeskTransFB.setStrPatAccountNo(_LPIssueDeskTransFB.getStrBillingHiddenValue().split("\\^")[0]);
			_LPIssueDeskTransFB.setStrIssueItemId(strIssueItemId);
			
			System.out.println("--------------LPIssueDeskTransDATA ---- strChk-->> "+strChk);
			
			_LPIssueDeskTransFB.setStrChk(strChk);
			
			_LPIssueDeskTransFB.setStrRequestTypeId(strRequestTypeId);
			
			_LPIssueDeskTransFB.setStrStoreId(strStoreId);
			
			_LPIssueDeskTransFB.setCombo(request.getParameterValues("combo"));
			
			_LPIssueDeskTransFB.setStrSCMIntegration(mmsConfig.getStrSCMIntegration());
			
			System.out.println("------------------------------   LPIssueDeskTransDATA ------END --------------------------- ");
			 
			//_LPIssueDeskTransFB.setStrBillPaidCat(billConfig.getStrPaidCategory());
			
			
		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "Issue Desk.LPIssueDeskTransDATA.getInitDetailForIssuePage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LPIssueDeskTransDATA->getIndentDetails()", strmsgText);
			_LPIssueDeskTransFB.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	
	public static void getSettelmentViewPage(LPIssueDeskTransFB _LPIssueDeskTransFB,
			HttpServletRequest request) {

		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
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
		String strCostReq="",dossierReqStatus="";
		StringBuffer buff=null;
		BillConfigUtil billConfig=null;
		String RaisingStoreId="RaisingStoreI";
		try 
		{
			
				bo = new LPIssueDeskTransBO();
				vo = new LPIssueDeskTransVO();
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				mmsConfig=new MmsConfigUtil(hosCode);
				billConfig=new BillConfigUtil(hosCode);
				strCostReq=mmsConfig.getStrCostReq();
				/*
				     hnum_dossier_req_id     @ gnum_hospital_code  @ hrgnum_puk                @ hnum_req_mode        @ hnum_ref_req_id
              		  @ hnum_servicetype_id  @ hnum_service_id     @ hstr_service_name         @ hnum_dossier_id      @ hnum_dossier_status
              		  @ hstr_entry_remark    @ hstr_post_remark    @ hnum_cancel_reason_id     @ hstr_cancel_remark   @ gnum_isvalid
              		  @ gdt_entry_date       @ hnum_tostore_id        @ nvl(A.hstnum_patient_type,0) 
              		  @  dossier_mst.get_dossier_sort_name(hnum_dossier_id::numeric, gnum_hospital_code::numeric, hnum_servicetype_id::numeric)
				*/
				
				  System.out.println("<<<-------------- LPIssueDeskTransDATA . getSettelmentViewPage() ---------------->>>");
				
				  strChk=request.getParameter("chk");
				  
				  System.out.println("strChk  -->> "+strChk);
				
				 if (request.getParameter("combo") != null	&& request.getParameter("combo").length() > 0) 
			 	 {
					
					System.out.println("dossier status 1 - New , 4 - Processed , 5 Dossier Setteled -->> "+request.getParameterValues("combo")[2]);
					
					_LPIssueDeskTransFB.setCombo(request.getParameterValues("combo"));
					strRaisingReqTypeId = request.getParameterValues("combo")[1];
					//strStoreId          = request.getParameterValues("combo")[0];
					dossierReqStatus    = request.getParameterValues("combo")[2];
					_LPIssueDeskTransFB.setStrRaisingReqTypeId(strRaisingReqTypeId);
					
			 	 }
				
				 
				
				 if (request.getParameter("comboValue") != null	&& request.getParameter("comboValue").length() > 0) 
				 {
					 _LPIssueDeskTransFB.setComboValue(request.getParameterValues("comboValue")[0]);
					 _LPIssueDeskTransFB.setStrStoreName(_LPIssueDeskTransFB.getComboValue());
					 _LPIssueDeskTransFB.setStrPatientType((strChk.split("\\@")[17]).split("\\$")[0]);
					 vo.setStrPatientType((strChk.split("\\@")[17]).split("\\$")[0]);
				 }
			/**
			 * This is used set variables during request type equal to patient
			 */

				temp=strChk.replace('@', '#').split("#");
				
				/*
			     A.hrgnum_puk||'@'|| hstnum_issue_no||'@'|| hnum_dossier_req_id||'@'||A.gnum_hospital_code
			     ||'@'|| A.hrgnum_puk||'@'||hnum_req_mode||'@'|| to_char(hstdt_issue_date ,'DD-MON-YYYY') || '@' ||  hnum_ref_req_id
			     ||'@'||  hnum_servicetype_id||'@'||hnum_service_id||'@'||hstr_service_name||'@'||  hnum_dossier_id||'@'||hnum_dossier_status
			     ||'@'|| hstr_entry_remark||'@'||hstr_post_remark||'@'||   hnum_cancel_reason_id||'@'|| hstr_cancel_remark||'@'|| A.gnum_isvalid
			     ||'@'|| A.gdt_entry_date||'@'||  hnum_tostore_id  ||'@'|| nvl(A.hstnum_patient_type,0)
			*/
				 System.out.println("<<------------------------->> ");
				 System.out.println("hrgnum_puk  			-->> "+temp[0]);
				 System.out.println("hstnum_issue_no  		-->> "+temp[1]);
				 System.out.println("hnum_dossier_req_id  	-->> "+temp[2]);
				 System.out.println("hrgnum_puk  			-->> "+temp[3]);
				 System.out.println("hnum_req_mode  		-->> "+temp[4]);
				 System.out.println("hstdt_issue_date  		-->> "+temp[5]);
				 System.out.println("hnum_ref_req_id  		-->> "+temp[6]);
				 System.out.println("hnum_servicetype_id  	-->> "+temp[7]);
				 System.out.println("hnum_service_id  		-->> "+temp[8]);
				 System.out.println("hstr_service_name  	-->> "+temp[9]);				 
				 System.out.println("hnum_dossier_id  		-->> "+temp[10]);
				 System.out.println("hnum_dossier_status  	-->> "+temp[11]);
				 System.out.println("hstr_entry_remark  	-->> "+temp[12]);				 
				 System.out.println("hstr_post_remark  		-->> "+temp[13]);
				 System.out.println("hnum_cancel_reason_id  -->> "+temp[14]);
				 System.out.println("hstr_cancel_remark  	-->> "+temp[15]);
				 System.out.println("gnum_isvalid  			-->> "+temp[16]);
				 System.out.println("gdt_entry_date  		-->> "+temp[17]);				 
				 System.out.println("hnum_tostore_id  		-->> "+temp[19]);
				 System.out.println("hstnum_patient_type  	-->> "+(temp[20]).split("\\$")[0]);
				 System.out.println("<<------------------------->> ");
				
				_LPIssueDeskTransFB.setStrIssueNo(temp[1]);	
				_LPIssueDeskTransFB.setStrLpRequestNo(temp[2]);  // hnum_dossier_req_id
				_LPIssueDeskTransFB.setStrRequestDate(temp[5]);			
				_LPIssueDeskTransFB.setStrCrNo(temp[0]);
				_LPIssueDeskTransFB.setStrBSReqNo(temp[0]);
				_LPIssueDeskTransFB.setStrPoNo("0");
				_LPIssueDeskTransFB.setStrPoStoreId("0");
				_LPIssueDeskTransFB.setStrUrgentFlg("0");
				_LPIssueDeskTransFB.setStrStoreId(temp[19]);
				_LPIssueDeskTransFB.setStrDossierStatusFlag(temp[11]);
				_LPIssueDeskTransFB.setStrPatientType((temp[20]).split("\\$")[0]);				
				_LPIssueDeskTransFB.setPrintReq("1");
				
				strStoreId          = temp[19];				
				
				System.out.println("<<<-------------- LPIssueDeskTransDATA . getSettelmentViewPage() . PatientDtlHLP.patientWithAdmissionDtl---------------->>>");
				
				strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(_LPIssueDeskTransFB.getStrCrNo(), hosCode, true);
			   _LPIssueDeskTransFB.setStrPatientDtl(strPatientDtl);		
			
				vo.setStrHospitalCode(hosCode);
				vo.setStrIssueNo(_LPIssueDeskTransFB.getStrIssueNo());
				vo.setStrRaisingStoreId(_LPIssueDeskTransFB.getStrRaisingStoreId());
				vo.setStrLpRequestNo(_LPIssueDeskTransFB.getStrLpRequestNo());
				vo.setStrRequestDate(_LPIssueDeskTransFB.getStrRequestDate());
				vo.setStrRaisingReqTypeId("98");
				vo.setStrPoStoreId(_LPIssueDeskTransFB.getStrPoStoreId());
				vo.setStrPoNo(_LPIssueDeskTransFB.getStrPoNo());
				vo.setStrCrNo(_LPIssueDeskTransFB.getStrCrNo());
				vo.setStrUrgentFlg(_LPIssueDeskTransFB.getStrUrgentFlg());
				vo.setStrFinStartDate(mmsConfig.getStrFinancialStartDate(temp[19], hosCode));
				vo.setStrFinEndDate(mmsConfig.getStrFinancialEndDate(temp[19], hosCode));
				vo.setStrBSReqNo("0");
				vo.setStrStoreId(_LPIssueDeskTransFB.getStrStoreId());
				vo.setStrPatientType(_LPIssueDeskTransFB.getStrPatientType());
				vo.setStrDossierStatusFlag(_LPIssueDeskTransFB.getStrDossierStatusFlag());
				vo.setDossierReqStatus(dossierReqStatus);
			
			    System.out.println("dossier status flag -->> "+vo.getStrDossierStatusFlag());
			 
			    System.out.println("<<<--------------LPIssueDeskTransDATA . pkg_dossier_view.proc_hstt_lp_req_item_dtl [ Mode - 1 ]-------->>>");
			    System.out.println("<<<--------------LPIssueDeskTransDATA . pkg_dossier_view.Proc_Emp_Issue_Detail     [ Mode - 3 ]------------->>>");
			    System.out.println("<<<--------------LPIssueDeskTransDATA . PKG_MMS_VIEW.proc_hstt_pat_account_dtl     [ Mode - 1 ]---------------->>>");
			    System.out.println("<<<--------------LPIssueDeskTransDATA . MMS_MST.get_store_dtl                      [ Mode - 1 ]---------------->>>");
			
			    vo.setStrMode("3"); 
				bo.getAfterSettelmentRequestDetail(vo); 
				
				bo.getIssueNoDtls(vo);
			
			   _LPIssueDeskTransFB.setStrIssueNo(vo.getStrIssueNo());
			   _LPIssueDeskTransFB.setStrDeptName(vo.getStrDeptName());
			   
			   _LPIssueDeskTransFB.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
				WebRowSet wb = vo.getPatAccountDtl();
				if(wb!=null)
				{
					if(wb.size()!=0) 
					{
						
						while(wb.next()){
							_LPIssueDeskTransFB.setStrPatAccountNo(wb.getString(1));
							_LPIssueDeskTransFB.setStrPatAccountBal(wb.getString(2));
						}
					}
				}
				else
				{
					
				}
				_LPIssueDeskTransFB.setStrHospitalCode(hosCode);
				
				System.out.println("--------------LPIssueDeskTransHLP.initViewForIssueAddPage  ---- -->> ");
				strRequestDtl=LPIssueDeskTransHLP.initViewForIssueAddPage(_LPIssueDeskTransFB);					
				_LPIssueDeskTransFB.setStrRequestDtl(strRequestDtl);
				
			
			System.out.println("mmsConfig.getStrSCMIntegration----------"+mmsConfig.getStrSCMIntegration().equals("1"));
			System.out.println("vo.getStrLpRequestNo--------------------"+vo.getStrLpRequestNo().substring(0,2).equals("10"));
			
			if(mmsConfig.getStrSCMIntegration().equals("1") && vo.getStrLpRequestNo().substring(0,2).equals("11"))
			{
				buff=new StringBuffer();
				buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				buff.append("<tr>");
				buff.append("<td class='multiControl'>Integration with e-Aushadhi is yes. So, dossier issue can't be processed</td></tr></table>");
				
				strIssueItemId = buff.toString();
			}
			else
			{
				//System.out.println("--------------LPIssueDeskTransDATA . LPIssueDeskTransHLP.getItemDetails ------>>");
				
				//strRequestItemDtl=LPIssueDeskTransHLP.getItemDetails(vo.getRequestItemDtlWS());
				
				//_LPIssueDeskTransFB.setStrRequestItemDtl(strRequestItemDtl);
				
				System.out.println("--------------LPIssueDeskTransDATA . LPIssueDeskTransHLP.getIssueItemDetailsForSettelmentView --Issue Item Dtl ------->> ");
				
				//strIssueItemId=LPIssueDeskTransHLP.getIssueItemDetailsForIssueView(vo.getWsIssueDetails(),strCostReq,strStoreId,hosCode,vo.getStrRaisingStoreId(),vo.getStrBSReqNo(),vo);
				
				strIssueItemId=LPIssueDeskTransHLP.getIssueItemDetailsForSettelmentView(vo.getWsIssueDetails(),strCostReq,strStoreId,hosCode,vo.getStrRaisingStoreId(),vo.getStrBSReqNo(),vo);
				
			
				
			}
			_LPIssueDeskTransFB.setStrPatAccountNo(_LPIssueDeskTransFB.getStrBillingHiddenValue().split("\\^")[0]);
			_LPIssueDeskTransFB.setStrIssueItemId(strIssueItemId);
			
			//System.out.println("--------------LPIssueDeskTransDATA ---- strChk-->> "+strChk);
			
			_LPIssueDeskTransFB.setStrChk(strChk);
			
			_LPIssueDeskTransFB.setStrRequestTypeId(strRequestTypeId);
			
			_LPIssueDeskTransFB.setStrStoreId(strStoreId);
			
			_LPIssueDeskTransFB.setCombo(request.getParameterValues("combo"));
			
			_LPIssueDeskTransFB.setStrSCMIntegration(mmsConfig.getStrSCMIntegration());
			
			System.out.println("------------------------------   LPIssueDeskTransDATA ------END --------------------------- ");
			 
			//_LPIssueDeskTransFB.setStrBillPaidCat(billConfig.getStrPaidCategory());
			
			
		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "Issue Desk.LPIssueDeskTransDATA.getInitDetailForIssuePage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LPIssueDeskTransDATA->getIndentDetails()", strmsgText);
			_LPIssueDeskTransFB.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	
		
}
