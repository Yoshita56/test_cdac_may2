package mms.transactions.controller.data;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import org.codehaus.jettison.json.JSONObject;

import billing.BillConfigUtil;
import hisglobal.ReportUtil;
import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.GlobalVO;
import hisglobal.tools.hlp.PatientDtlBO;
import hisglobal.tools.hlp.PatientDtlHLP;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.MmsConfigUtil;
import mms.transactions.bo.LPIssueDeskTransBO;
import mms.transactions.controller.fb.LPIssueDeskTransFB;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.controller.hlp.LPIssueDeskTransHLP;
import mms.transactions.dao.LPIssueDeskTransDAO;
import mms.transactions.vo.LPIssueDeskTransVO;


public class LPIssueDeskTransDATA {
	public static void getInitDetailForIssuePage(LPIssueDeskTransFB _LPIssueDeskTransFB,
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
		String strCostReq="";
		StringBuffer buff=null;
		BillConfigUtil billConfig=null;
		try {
			
			System.out.println("-------------  LPIssueDeskTransDATA . getInitDetailForIssuePage  --------------");
			
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
			 }
			 
			 System.out.println("strChk-----------"+strChk);
			/**
			 * This is used set variables during request type equal to patient
			 */

				 temp=strChk.replace('@', '#').split("#");
				_LPIssueDeskTransFB.setStrItemCategNo(temp[0]);
				_LPIssueDeskTransFB.setStrLpRequestNo(temp[1]);
				_LPIssueDeskTransFB.setStrRequestDate(temp[2]);
				_LPIssueDeskTransFB.setStrRaisingStoreId(temp[3]);
				_LPIssueDeskTransFB.setStrCrNo(temp[4]);
				_LPIssueDeskTransFB.setStrBSReqNo(temp[6].replace('$', '#').split("#")[0]);
				_LPIssueDeskTransFB.setStrPoNo("0");
				_LPIssueDeskTransFB.setStrPoStoreId("0");
				_LPIssueDeskTransFB.setStrUrgentFlg(temp[7]);
				_LPIssueDeskTransFB.setStrStoreId(strStoreId);
				strRequestTypeId="35";

				System.out.println("------------- PatientDtlHLP.patientWithAdmissionDtl  --------------");
				
				
						
				System.out.println("<------------- pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ]   ------------->");		
				System.out.println("<------------- pkg_ipd_view.PROC_HIPT_PATADMISSION_DTL [ Mode - 1 ] ------------->");		
						
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
			vo.setStrBSReqNo(_LPIssueDeskTransFB.getStrBSReqNo());
			vo.setStrStoreId(_LPIssueDeskTransFB.getStrStoreId());
			vo.setStrItemCategNo(_LPIssueDeskTransFB.getStrItemCategNo());
			
			System.out.println("----_LPIssueDeskTransFB.getStrRaisingStoreId()-----"+_LPIssueDeskTransFB.getStrRaisingStoreId());
			System.out.println("----_LPIssueDeskTransFB.getStrBSReqNo()------------"+_LPIssueDeskTransFB.getStrBSReqNo());
			
			if(_LPIssueDeskTransFB.getStrBSReqNo().equals("0"))
				bo.getLPRequestDetail(vo);
			else
				bo.getLPRequestDetail_new(vo);
			
			
			_LPIssueDeskTransFB.setStrDeptName(vo.getStrDeptName());
			
			System.out.println("---Raising _Store --- DEPT_NAME-----"+vo.getStrDeptName());
			System.out.println("---Raising _Store _ NAME------------"+vo.getStrRaisingStoreName());
			
			_LPIssueDeskTransFB.setStrRaisingStoreName(vo.getStrRaisingStoreName()+"("+vo.getStrDeptName()+")");
			
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
			
			System.out.println("------------- LPIssueDeskTransHLP.initViewForIssueAddPage  --------------");
			
			strRequestDtl=LPIssueDeskTransHLP.initViewForIssueAddPage(_LPIssueDeskTransFB);
			
			_LPIssueDeskTransFB.setStrDiagDtl(patientDiagDtl(_LPIssueDeskTransFB.getStrCrNo(),hosCode));
			
			
			
			_LPIssueDeskTransFB.setStrRequestDtl(strRequestDtl);
			//System.out.println("mmsConfig.getStrSCMIntegration"+mmsConfig.getStrSCMIntegration().equals("1"));
			//System.out.println("vo.getStrLpRequestNo"+vo.getStrLpRequestNo().substring(0,2).equals("10"));
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
				System.out.println("------------- LPIssueDeskTransHLP.getItemDetails  --------------");
				
				strRequestItemDtl=LPIssueDeskTransHLP.getItemDetails(vo.getRequestItemDtlWS());
				
				_LPIssueDeskTransFB.setStrRequestItemDtl(strRequestItemDtl);
				System.out.println("_LPIssueDeskTransFB.setStrRequestItemDtl---->"+_LPIssueDeskTransFB.getStrRequestItemDtl());
				
				System.out.println("------------- LPIssueDeskTransHLP.getIssueItemDetails  --------------");
				
				strIssueItemId=LPIssueDeskTransHLP.getIssueItemDetails(vo.getIssueItemDtlWS(),strCostReq,strStoreId,hosCode,vo.getStrRaisingStoreId(),vo.getStrBSReqNo(),vo);
			
				
				
			}
			
			_LPIssueDeskTransFB.setStrIssueItemId(strIssueItemId);
			
			//System.out.println("_LPIssueDeskTransFB.getStrIssueItemId---->"+_LPIssueDeskTransFB.getStrIssueItemId());
			
			_LPIssueDeskTransFB.setStrChk(strChk);
			
			_LPIssueDeskTransFB.setStrRequestTypeId(strRequestTypeId);
			
			_LPIssueDeskTransFB.setStrStoreId(strStoreId);
			
			_LPIssueDeskTransFB.setCombo(request.getParameterValues("combo"));
			
			_LPIssueDeskTransFB.setStrSCMIntegration(mmsConfig.getStrSCMIntegration());
			
			//System.out.println("Table in DATA---->"+vo.getStrRemarks());
			
			_LPIssueDeskTransFB.setStrAppRemarks(vo.getStrRemarks());
			
			System.out.println("-------------  LPIssueDeskTransDATA . getInitDetailForIssuePage  ------- END -------");
			 
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

	public static void getInitDetailForReturnPage(LPIssueDeskTransFB _LPIssueDeskTransFB,
			HttpServletRequest request) {

		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
		String strPatientDtl="";
		String strmsgText = "";
		String strRequestTypeId="";
		String strRaisingReqTypeId="";
		
		String strRequestDtl="";
		String strRequestDtlNew="";
		String strChk="";
		String temp[]=null;
		String hosCode="";
		HisUtil hisutil=null;
		String cmbVal="";
		String strStoreId="";
		MmsConfigUtil mmsConfig=null;
		String strCostReq="";
		try {
			
			System.out.println("-------------  LPIssueDeskTransDATA . getInitDetailForReturnPage  ------- START -------");
			
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
					 _LPIssueDeskTransFB.setStrItemCategNo(temp[2]);
						_LPIssueDeskTransFB.setStrIssueNo(temp[1]);
						_LPIssueDeskTransFB.setStrIssueStoreId(temp[0]);
						_LPIssueDeskTransFB.setStrIssueDate(temp[3]);
						_LPIssueDeskTransFB.setStrStoreName(temp[4]);
					strRequestTypeId="46";
				}
				
				if(strRaisingReqTypeId.equals("35")|| strRaisingReqTypeId.equals("12") || strRaisingReqTypeId.equals("32"))
				{
					System.out.println("------------- PatientDtlHLP.patientWithAdmissionDtlReturn  --------------");
					System.out.println("-------------  pkg_simple_view.PROC_HRGT_PATIENT_DTL  ---[ Mode - 1 ]-----------");
					 
					strPatientDtl=PatientDtlHLP.patientWithAdmissionDtlReturn(_LPIssueDeskTransFB.getStrCrNo(), hosCode, true);
				}
				_LPIssueDeskTransFB.setStrPatientDtl(strPatientDtl);
							
				vo.setStrCrNo(_LPIssueDeskTransFB.getStrCrNo());
				vo.setStrIssueNo(_LPIssueDeskTransFB.getStrIssueNo());
				vo.setStrIssueStoreId(_LPIssueDeskTransFB.getStrIssueStoreId());
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrRaisingReqTypeId(strRaisingReqTypeId);
				vo.setStrRaisingStoreId(_LPIssueDeskTransFB.getStrIssueStoreId());
				bo.getIssueItemDetail(vo);
				
				
				System.out.println("------------- LPIssueDeskTransHLP.getIssuedItemDetails  --------------");
				System.out.println("------------- LPIssueDeskTransHLP.getIssuedItemDetailsNew  --------------");
				strRequestDtl=LPIssueDeskTransHLP.getIssuedItemDetails(vo.getIssuedItemDtlWS(),vo.getStrHospitalCode(),strCostReq);
				strRequestDtlNew=LPIssueDeskTransHLP.getIssuedItemDetailsNew(vo.getIssuedItemDtlWS(),vo.getStrHospitalCode(),strCostReq);
				
				_LPIssueDeskTransFB.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
				_LPIssueDeskTransFB.setStrDeptName(vo.getStrDeptName());
				_LPIssueDeskTransFB.setStrRequestTypeId(strRequestTypeId);
				_LPIssueDeskTransFB.setStrStoreId(strStoreId);
				_LPIssueDeskTransFB.setStrRequestDtl(strRequestDtl);
				_LPIssueDeskTransFB.setStrRequestDtlNew(strRequestDtlNew);
				_LPIssueDeskTransFB.setStrChk(strChk);
				if (vo.getApprovedBy() != null
						&& vo.getApprovedBy().size() > 0) {
					cmbVal = hisutil.getOptionValue(vo.getApprovedBy(), 
							"0", "0^Select Value", true);
				} else {
					cmbVal = "<option value='0'>Select Value</option>";
				}
			_LPIssueDeskTransFB.setStrRecommendByVal(cmbVal);
			
			System.out.println("-------------  LPIssueDeskTransDATA . getInitDetailForReturnPage  ------- END -------");
						 
			
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
	
	public static void getInitDetailForReturnViewPage(LPIssueDeskTransFB _LPIssueDeskTransFB,
			HttpServletRequest request) {

		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
		String strPatientDtl="";
		String strPatientDtlNew="";
		String strmsgText = "";
		String strRequestTypeId="";
		String strRaisingReqTypeId="";
		
		String strRequestDtl="";
		String strRequestDtlNew="";
		String strChk="";
		String temp[]=null;
		String hosCode="";
		String status;
		
		String strStoreId="";
		try {
			System.out.println("-------------  LPIssueDeskTransDATA . getInitDetailForReturnViewPage  ------- START -------");
			
			    bo = new LPIssueDeskTransBO();
				vo = new LPIssueDeskTransVO();
				
				 hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
				
				   _LPIssueDeskTransFB.setCombo(request.getParameterValues("combo"));
				  _LPIssueDeskTransFB.setComboValue(request.getParameterValues("comboValue")[0]);
				  _LPIssueDeskTransFB.setStrStoreName(_LPIssueDeskTransFB.getComboValue());
				  strRequestTypeId=request.getParameterValues("combo")[1];
				   strStoreId=request.getParameterValues("combo")[0];
				   status=request.getParameterValues("combo")[2];
				  _LPIssueDeskTransFB.setStrRaisingReqTypeId(strRaisingReqTypeId);
				  strChk=request.getParameter("chk");
				  _LPIssueDeskTransFB.setStrStoreId(strStoreId);
				
				
				/**
				 * This is used set variables during request type equal to patient
				 */
				if(strRequestTypeId.equals("35")){
					
					 temp=strChk.replace('@', '#').split("#");
					_LPIssueDeskTransFB.setStrItemCategNo(temp[4]);
					_LPIssueDeskTransFB.setStrIssueNo(temp[1]);
					_LPIssueDeskTransFB.setStrIssueStoreId(strStoreId);
					_LPIssueDeskTransFB.setStrCrNo(temp[2]);
					_LPIssueDeskTransFB.setStrIssueDate(temp[5]);
					_LPIssueDeskTransFB.setStrLpRequestNo(temp[6]);
					_LPIssueDeskTransFB.setStrRequestDate(temp[7]);
					strRaisingReqTypeId="13";
				}
				else
					if(strRequestTypeId.equals("32")){
						
						 temp=strChk.replace('@', '#').split("#");
						_LPIssueDeskTransFB.setStrItemCategNo(temp[4]);
						_LPIssueDeskTransFB.setStrIssueNo(temp[1]);
						_LPIssueDeskTransFB.setStrIssueStoreId(temp[0]);
						_LPIssueDeskTransFB.setStrCrNo(temp[2]);
						_LPIssueDeskTransFB.setStrIssueDate(temp[5]);
						
						
					}
				/**
				 * This is used set variables during request type equal to employee
				 */
				else if(strRaisingReqTypeId.equals("12")){
					
					temp=strChk.replace('@', '#').split("#");
					
					_LPIssueDeskTransFB.setStrItemCategNo(temp[4]);
					_LPIssueDeskTransFB.setStrIssueNo(temp[1]);
					_LPIssueDeskTransFB.setStrIssueStoreId(temp[0]);
					_LPIssueDeskTransFB.setStrCrNo(temp[2]);
					_LPIssueDeskTransFB.setStrIssueDate(temp[5]);
					_LPIssueDeskTransFB.setStrEmpNo(temp[3]);
					
					
					strRequestTypeId="36";
				}
				/**
				 * This is used set variables during request type equal to department
				 */
				else
				{
					 temp=strChk.replace('@', '#').split("#");
					 _LPIssueDeskTransFB.setStrItemCategNo(temp[0]);
					_LPIssueDeskTransFB.setStrLpRequestNo(temp[1]);
					_LPIssueDeskTransFB.setStrRequestDate(temp[2]);
					_LPIssueDeskTransFB.setStrIssueStoreId(temp[3]);
					_LPIssueDeskTransFB.setStrStoreId(strStoreId);
					
					strRequestTypeId="37";
				}
				
				
				
				if(strRaisingReqTypeId.equals("35")|| strRaisingReqTypeId.equals("12") || strRaisingReqTypeId.equals("13")||strRequestTypeId.equals("32"))
				{
					 System.out.println("------------- PatientDtlHLP.patientWithAdmissionDtlView  --------------");
					 System.out.println("-------------  pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ] -----------");
					 System.out.println("-------------  pkg_ipd_view.PROC_HIPT_PATADMISSION_DTL [ Mode - 1 ] -----------");
					strPatientDtl=PatientDtlHLP.patientWithAdmissionDtlView(_LPIssueDeskTransFB.getStrCrNo(), hosCode, true);
				}
				_LPIssueDeskTransFB.setStrPatientDtl(strPatientDtl);
				if(strRaisingReqTypeId.equals("35")|| strRaisingReqTypeId.equals("12") || strRaisingReqTypeId.equals("13")||strRequestTypeId.equals("32"))
				{
					 System.out.println("------------- PatientDtlHLP.patientWithAdmissionDtlViewNew  --------------");
					 System.out.println("-------------  pkg_simple_view.PROC_HRGT_PATIENT_DTL  ---[ Mode - 1 ]-----------");
					 System.out.println("-------------  pkg_ipd_view.PROC_HIPT_PATADMISSION_DTL [ Mode - 1 ] -----------");
					strPatientDtlNew=PatientDtlHLP.patientWithAdmissionDtlView(_LPIssueDeskTransFB.getStrCrNo(), hosCode, true);
				}
				
				_LPIssueDeskTransFB.setStrPatientDtlNew(strPatientDtlNew);
				
				vo.setStrIssueNo(_LPIssueDeskTransFB.getStrIssueNo());
				vo.setStrIssueStoreId(_LPIssueDeskTransFB.getStrIssueStoreId());
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrRaisingReqTypeId(strRaisingReqTypeId);
				vo.setStrRaisingStoreId(_LPIssueDeskTransFB.getStrIssueStoreId());
				if(status.equals("2"))
					vo.setStrRequestTypeId(strRequestTypeId);
				
				
				bo.getIssueItemDetailview(vo);
				_LPIssueDeskTransFB.setStrDeptName(vo.getStrDeptName());
			    _LPIssueDeskTransFB.setStrRequestTypeId(strRequestTypeId);
			    System.out.println("------------- LPIssueDeskTransHLP.getIssuedItemDetailsForReturnViewNew  --------------");
			    
				strRequestDtl=LPIssueDeskTransHLP.getIssuedItemDetailsForReturnViewNew(vo.getIssuedItemDtlWS(),vo.getStrHospitalCode());
				_LPIssueDeskTransFB.setStrRequestDtlNew(strRequestDtl);
				
				 System.out.println("------------- LPIssueDeskTransHLP.getIssuedItemDetailsForReturnView  --------------");
				 
				// System.out.println("------------- vo.getIssuedItemDtlWS().size() ---------"+vo.getIssuedItemDtlWS().size());
				
				 vo.getIssuedItemDtlWS().beforeFirst();
			
			  strRequestDtlNew=LPIssueDeskTransHLP.getIssuedItemDetailsForReturnView(vo.getIssuedItemDtlWS(),vo.getStrHospitalCode());
			  _LPIssueDeskTransFB.setStrRequestDtl(strRequestDtlNew);
			  
			  System.out.println("-------------  LPIssueDeskTransDATA . getInitDetailForReturnViewPage  ------- END -------");
			 
			
						 
			
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
		
		try{
			
			mcu=new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			bo= new LPIssueDeskTransBO();
			
			System.out.println("---------LPIssueDeskTransDATA.insertData---------");
			vo = (LPIssueDeskTransVO) TransferObjectFactory.populateData("mms.transactions.vo.LPIssueDeskTransVO",_LPIssueDeskTransFB);
			UCreq=_LPIssueDeskTransFB.getStrUCReq();
			if(_LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("12") || _LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("13") ||  _LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("35"))
			{
				////System.out.println("check1");
				if(_LPIssueDeskTransFB.getStrAdmissionDtlHidVal()!=null){
					
					////System.out.println(_LPIssueDeskTransFB.getStrAdmissionDtlHidVal());
					
					
					temp=_LPIssueDeskTransFB.getStrAdmissionDtlHidVal().replace('^', '#').split("#");
					//IPD
					if(temp.length>1){
						vo.setStrAdmissionNo(temp[0]);
						vo.setStrEpisodeCode(temp[1]);
						vo.setStrVisitNo(temp[2]);
						vo.setStrDeptCode(temp[5].substring(0, 3));
						vo.setStrDeptUnitCode(temp[16]);
						vo.setStrWardCode(temp[6]);
						vo.setStrVisitType("0"); 
						vo.setStrTreatmentCat(temp[9]);
						
					}else{
						
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
			System.out.println("-RequestTypeId()--[31- Issue To Store  , 35 - Issue To Pateint IPD , 32 - Issue To Patient Direct ]-------"+_LPIssueDeskTransFB.getStrRequestTypeId());
			
			if(_LPIssueDeskTransFB.getStrRequestTypeId().equals("35")){
				strDescription="Issue To IPD Patient: CRNO"+_LPIssueDeskTransFB.getStrCrNo();
		
			}else if(_LPIssueDeskTransFB.getStrRequestTypeId().equals("36")){
				strDescription="Issue To Employee: C.R.No. "+_LPIssueDeskTransFB.getStrCrNo()+
				" EmpNo: "+_LPIssueDeskTransFB.getStrEmpNo();
			}
			else{
				strDescription="Issue To Department: DeptName ";
			}
			 vo.setStrCrNo(_LPIssueDeskTransFB.getStrCrNo());
			vo.setStrDescription(strDescription);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStockDtlsId(_LPIssueDeskTransFB.getStockDtlsId());
			
			vo.setStrUrgentFlg(_LPIssueDeskTransFB.getStrUrgentFlg().replace("$","#").split("#")[0]);
			
			System.out.println("----2-----LPIssueDeskTransDATA.insertData---------");
			
			////System.out.println("strStockDtlsChk ::::::::::::::::::: "+_LPIssueDeskTransFB.getStrStockDtlsChk().length);
			bo.insertData(vo);
			
			
			if(vo.getStrMsgType().equals("1")){
				_LPIssueDeskTransFB.setStrFlag("0");
				
				throw new Exception(vo.getStrMsgString());
			}else{
				_LPIssueDeskTransFB.setStrFlag("1");
				if(vo.getStrBSReqNo() != null && !vo.getStrBSReqNo().equals("0"))
					_LPIssueDeskTransFB.setStrMsg("LP Indent raised successfully with indent no :"+vo.getStrBSReqNo());
			}
			if(vo.getStrIssueNo() != null || !vo.getStrIssueNo().equals(""))
				_LPIssueDeskTransFB.setStrIssueNo(vo.getStrIssueNo());
			
			_LPIssueDeskTransFB.setStrUCReq(UCreq);
		}
		catch(Exception _err)
		{
			_err.printStackTrace();
			strmsgText = "Issue Desk.LPIssueDeskTransDATA.insertData(vo) --> "+ _err.getMessage();
			//System.out.println(strmsgText);
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
			System.out.println("-------------  LPIssueDeskTransDATA . insertReturn  ------- START -------");
			
			mcu=new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			bo= new LPIssueDeskTransBO();
			vo = (LPIssueDeskTransVO) TransferObjectFactory.populateData("mms.transactions.vo.LPIssueDeskTransVO",_LPIssueDeskTransFB);
		if(_LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("12") || _LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("13")  || _LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("35") || _LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("32")){
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
			
			if(_LPIssueDeskTransFB.getStrRequestTypeId().equals("44")){
				strDescription="Return From Patient: CRNO"+_LPIssueDeskTransFB.getStrCrNo();
		
			}else if(_LPIssueDeskTransFB.getStrRequestTypeId().equals("45")){
				strDescription="Return From Employee: C.R.No. "+_LPIssueDeskTransFB.getStrCrNo()+" EmpNo: "+_LPIssueDeskTransFB.getStrEmpNo();
			}
			else{
				strDescription="Reurn From  Department: DeptName ";
			}
			 
			vo.setStrDescription(strDescription);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			bo.insertRet(vo);
			if(vo.getStrMsgType().equals("1")){
				_LPIssueDeskTransFB.setStrFlag("0");
				
				throw new Exception(vo.getStrMsgString());
			}else{
				_LPIssueDeskTransFB.setStrFlag("1");
			}
			_LPIssueDeskTransFB.setStrReturnNo(vo.getStrReturnNo());
			
			System.out.println("-------------  LPIssueDeskTransDATA . insertReturn  ------- END -------");
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
				
				System.out.println("-------------  LPIssueDeskTransDATA . patientDiagDtl  ------- START -------");
			
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
				
				System.out.println("-------------  LPIssueDeskTransDATA . patientDiagDtl  ------- END -------");
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
	
				//System.out.println("report_id"+ strReportId);
				//System.out.println("hospCode"+ strHospitalCode);
				//System.out.println("storeId"+ strStoreId);
				//System.out.println("issueNo"+ strReqNo);
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



	
	public static String getInitPatDtl(GlobalVO vo)
	{
		GlobalVO voObj = (GlobalVO) vo;
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer(""); 
		LPIssueDeskTransVO _LPIssueDeskTransVO = new LPIssueDeskTransVO();
		WebRowSet ws = null;  
		WebRowSet ws2 = null;  
		try 
			{ 
			
			System.out.println("-------------  LPIssueDeskTransDATA . getInitPatDtl  ------- START -------");
			
				_LPIssueDeskTransVO.setStrCrNo(voObj.getStrValue1());
				_LPIssueDeskTransVO.setStrHospitalCode(voObj.getStrValue2());
				LPIssueDeskTransDAO.getPatientAccountDetailsNew(_LPIssueDeskTransVO);  //getPatientAccountDetails(_LPIssueDeskTransVO)
				ws2 = _LPIssueDeskTransVO.getPatAccountDtl();
				
				boObj.getPatientDetails(voObj);
				
				if (voObj.getStrMsgType().equals("1")) 
				{
					throw new Exception(voObj.getStrMsgString());
				}
	
				ws = voObj.getGblWs1(); 
				if (ws != null && ws.size() > 0) 
				{
					if (ws.next()) 
					{
						String strAgeAndSex = ws.getString(2);
						String strPatientName = ws.getString(3);
						String strFatherOrHusbandName = ws.getString(4);
						String strSpouseName = ws.getString(5);
						String strReligion = ws.getString(6);
						String strCategoryName = ws.getString(7);
						String strCategoryCode = ws.getString(8); 
						String strAddress = ws.getString(9);
						String strMlcNo = ws.getString(10);
						String strHiddenValue = ws.getString(11); 
						String catGrp = ws.getString(13);
						String visitType = ws.getString(15).split("\\^")[0];
						String episodeCode = ws.getString(15).split("\\^")[1];
						if (strHiddenValue == null)
							strHiddenValue = "----";
						String[] id = strHiddenValue.split("\\^");
						String strEmailId = ws.getString(16);

						if (strAgeAndSex == null)
							strAgeAndSex = "----";
						if (strPatientName == null)
							strPatientName = "----";
						if (strFatherOrHusbandName == null)
							strFatherOrHusbandName = "----";
						if (strSpouseName == null)
							strSpouseName = "----";
						if (strReligion == null)
							strReligion = "----";
						if (strCategoryName == null)
							strCategoryName = "----";
						if (strCategoryCode == null)
							strCategoryCode = "----";
						if (strAddress == null)
							strAddress = "----";					
						if (strMlcNo == null)
							strMlcNo = "-----";
						JSONObject json = new JSONObject();
						json.put("strAgeAndSex", strAgeAndSex);
						json.put("strPatientName", strPatientName);
						json.put("strFatherOrHusbandName", strFatherOrHusbandName);
						json.put("strSpouseName", strSpouseName);
						json.put("strReligion", strReligion);
						json.put("strCategoryName", strCategoryName);
						json.put("strCategoryCode", strCategoryCode);
						json.put("strAddress", strAddress);
						json.put("strMlcNo", strMlcNo);
						json.put("strHiddenValue", strHiddenValue);
						json.put("catGrp", catGrp);
						json.put("visitType", visitType);
						json.put("episodeCode", episodeCode);
						json.put("strEmailId", strEmailId);
						
						if(ws2!=null)
						{
							if(ws2.size()!=0) 
							{
								
								while(ws2.next()){ 
									json.put("setStrPatAccountNo", ws2.getString(1));
									json.put("setStrPatAccountBal", ws2.getString(2));
								}
							}
						}
						return json.toString();
						
					}
				}
				System.out.println("-------------  LPIssueDeskTransDATA . getInitPatDtl  ------- END -------");
			}
		catch(Exception e){
			
		}
		return "";
	}
	public static String getInitPatAdmDtl(GlobalVO vo)
	{
		GlobalVO voObj = (GlobalVO) vo;
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer(""); 
		WebRowSet ws = null;  
		try 
			{
			System.out.println("-------------  LPIssueDeskTransDATA . getInitPatAdmDtl  ------- START -------");
			System.out.println("-------------  pkg_ipd_view.PROC_HIPT_PATADMISSION_DTL  ------- [ Mode - 1] -------");
			
			
				boObj.getAdmissionDetails(voObj);
				
				if (voObj.getStrMsgType().equals("1")) 
				{
					throw new Exception(voObj.getStrMsgString());
				}
				
				
	
				ws = voObj.getGblWs1(); 
				if (ws != null && ws.size() > 0) 
				{
					if (ws.next()) 
					{
						String strDeptName = ws.getString(1);
						String strUnitName = ws.getString(2);
						String strWardName = ws.getString(3);
						String strRoomName = ws.getString(4);
						String strBedName = ws.getString(5);
						String strTreatmentCategoryName = ws.getString(6);
						String strConsultantName = ws.getString(7);
						String strNewBornBabyFlag = ws.getString(8);
						String strHiddenValue = ws.getString(9);//strHiddenValue=ADMNO^EPCODE^VISITNO^ADMDATETIME^ADMADVNO^DEPTCODE^WARDCODE^ROOMCODE^BEDCODE^TREATCATCODE^ISNEWBORN^MOTHERADMNO^MLCNO^OCCUPID^BEDALLOCDATETIME^LENGTHOFSTAY
						if (strHiddenValue == null)
							strHiddenValue = ""; 
						String strTemp[] = strHiddenValue.replace("^", "#").split("#"); 
						String strAdmissionNo = strTemp[0];
						String strEpisodeCode = strTemp[1];
						String strAdmissionDate = strTemp[3];
						String strMotherAdmNo="";
						String strMLCNo = ""; 
						if(strTemp.length>=12)
						{
							strMotherAdmNo = strTemp[11];
							strMLCNo = strTemp[12];
						}
						if (strDeptName == null)
							strDeptName = "";
						if (strUnitName == null)
							strUnitName = "";
						if (strWardName == null)
							strWardName = "";
						if (strRoomName == null)
							strRoomName = "";
						if (strBedName == null)
							strBedName = "";
						if (strTreatmentCategoryName == null)
							strTreatmentCategoryName = "";
						if (strConsultantName == null)
							strConsultantName = "";
						if (strNewBornBabyFlag == null)
							strNewBornBabyFlag = "";					
						if (strAdmissionNo == null)
							strAdmissionNo = "";
						if (strEpisodeCode == null)
							strEpisodeCode = "";
						if (strAdmissionDate == null)
							strAdmissionDate = "";
						if (strMotherAdmNo == null)
							strMotherAdmNo = "";
						if (strMLCNo == null)
							strMLCNo = "";
						
						JSONObject json = new JSONObject();
						json.put("strDeptName", strDeptName); 
						json.put("strUnitName", strUnitName); 
						json.put("strWardName", strWardName); 
						json.put("strBedName", strBedName); 
						json.put("strTreatmentCategoryName", strTreatmentCategoryName); 
						json.put("strConsultantName", strConsultantName); 
						json.put("strNewBornBabyFlag", strNewBornBabyFlag); 
						json.put("strHiddenValue", strHiddenValue); 
						json.put("strAdmissionNo", strAdmissionNo); 
						json.put("strEpisodeCode", strEpisodeCode); 
						json.put("strAdmissionDate", strAdmissionDate); 
						json.put("strMotherAdmNo", strMotherAdmNo); 
						json.put("strMLCNo", strMLCNo); 
						 
						return json.toString();
						
					}
				}
			}
		catch(Exception e){
			
		}
		return "";
	}

	public static String getInitPatDiaDtl(GlobalVO vo)
	{
		GlobalVO voObj = (GlobalVO) vo; 
		LPIssueDeskTransVO vo1 = new LPIssueDeskTransVO();	
		vo1.setStrCrNo(voObj.getStrValue1());
		vo1.setStrHospitalCode(voObj.getStrValue2());
		LPIssueDeskTransBO bo = new LPIssueDeskTransBO();  
		WebRowSet ws = null;  
		try 
			{ 
				
				if (voObj.getStrMsgType().equals("1")) 
				{
					throw new Exception(voObj.getStrMsgString());
				}

				ws = vo1.getDiagEmpWs();
				if (ws != null && ws.size() > 0) 
				{
					if (ws.next()) 
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
						
						
						JSONObject json = new JSONObject();
						json.put("diagName", diagName);  
						json.put("diagCode", diagCode);  
						json.put("empName", empName);  
						json.put("empcode", empcode);  
						 
						return json.toString();
						
					}
				}
			}
		catch(Exception e){
			
		}
		return "";
	}
	
	
	public static String saveNewIssuePage(LPIssueDeskTransFB _LPIssueDeskTransFB)
	{  		
		
		MmsConfigUtil mcu=null;
		LPIssueDeskTransBO bo=null;
		String strmsgText="";
	////System.out.println("jsonObjArr.length():::>>>"+jsonObjArr.length());
		try 
			{ 
			
			System.out.println("-------------  LPIssueDeskTransDATA . saveNewIssuePage  ------- START -------");
			
			bo =new LPIssueDeskTransBO();
			/*for(int i=0;i<jsonObjArr.length();i++)
			{*/
				//JSONObject jsonObj = new JSONObject(jsonObjArr.getString(i));
//				_LPIssueDeskTransFB.setStrChk(jsonObj.getString("chk"));
//				_LPIssueDeskTransFB.setStrCrNo(jsonObj.getString("crNo"));
//				_LPIssueDeskTransFB.setStrDeptName(jsonObj.getString("ward"));
//				_LPIssueDeskTransFB.setStrBSIndent(jsonObj.getString("indentNo"));
//				_LPIssueDeskTransFB.setStrItemDtls(jsonObj.getString("medicine"));
//				_LPIssueDeskTransFB.setStrItemDtls(jsonObj.getString("batchNo"));
//				_LPIssueDeskTransFB.setStrChk(jsonObj.getString("issueQty"));
//				_LPIssueDeskTransFB.setStrChk(jsonObj.getString("lpQty"));
//				_LPIssueDeskTransFB.setStrChk(jsonObj.getString("ratePerUnit"));
//				_LPIssueDeskTransFB.setStrFinalCost(jsonObj.getString("cost"));
//				_LPIssueDeskTransFB.setStrChk(jsonObj.getString("strChk"));
//				_LPIssueDeskTransFB.setStrHospitalCode(jsonObj.getString("hospCode"));
//				_LPIssueDeskTransFB.setStrSeatId(jsonObj.getString("seatId"));
//				_LPIssueDeskTransFB.setStrRequestTypeId(jsonObj.getString("strRequestTypeId"));
//				_LPIssueDeskTransFB.setStrStoreId(jsonObj.getString("strStoreId"));
//				_LPIssueDeskTransFB.setStrRequestDate(jsonObj.getString("strRequestDate"));
//				_LPIssueDeskTransFB.setStrLpRequestNo(jsonObj.getString("strLpRequestNo"));
//				_LPIssueDeskTransFB.setStrItemCategNo(jsonObj.getString("strItemCategNo"));
//				_LPIssueDeskTransFB.setStrRaisingReqTypeId(jsonObj.getString("strRaisingReqTypeId"));
//				_LPIssueDeskTransFB.setStrRaisingStoreId(jsonObj.getString("strRaisingStoreId"));
//				_LPIssueDeskTransFB.setStrStoreName(jsonObj.getString("strStoreName"));
//				_LPIssueDeskTransFB.setStrBillPaidCat(jsonObj.getString("strBillPaidCat"));
//				_LPIssueDeskTransFB.setStrSCMIntegrationflg(jsonObj.getString("strSCMIntegrationflg"));
//				_LPIssueDeskTransFB.setStrRemarks(jsonObj.getString("strRemarks"));  
				String [] strParamVal = {""};
				String [] BSQuantity = {""};
				String [] strIssueQuantity = {""};
				BSQuantity[0] = "0";
				strIssueQuantity[0] = "2";
				//strParamVal[0]="strItemId@strItemBrandId@strIssueQty@strIssueUnitId@0@strBatchSlNo@strRate@strManuFactDate@strExpiryDate@strItemCost";
				//strParamVal[0]="10000016@10100032@2@6301@9@bedr444@2.93@NA@ACETAMIDE 250 TAB";
				//strParamVal[0]=jsonObj.getString("medicineId")+"@"+jsonObj.getString("medicineBrandId")+"@"+jsonObj.getString("issueQty")+"@6301@"+jsonObj.getString("batchNo")+"@"+jsonObj.getString("ratePerUnit")+"@ @ @"+jsonObj.getString("cost");
//				_LPIssueDeskTransFB.setStrItemParamValue(strParamVal);
				
				LPIssueDeskTransVO _LPIssueDeskTransVO = new LPIssueDeskTransVO();
				_LPIssueDeskTransVO.setStrIssueQuantity(_LPIssueDeskTransFB.getIssueQty()); 
				_LPIssueDeskTransVO.setStrBSQuantity(_LPIssueDeskTransFB.getLpQty());
				_LPIssueDeskTransVO.setStrItemParamValue(strParamVal);
				_LPIssueDeskTransVO.setStrHospitalCode(_LPIssueDeskTransFB.getStrHospitalCode());
				_LPIssueDeskTransVO.setStrStoreId(_LPIssueDeskTransFB.getStrStoreId());
				_LPIssueDeskTransVO.setStrRemarks(_LPIssueDeskTransFB.getStrRemarks());
				_LPIssueDeskTransVO.setStrDescription(_LPIssueDeskTransFB.getStrRemarks());
				_LPIssueDeskTransVO.setStrTreatmentCat(_LPIssueDeskTransFB.getStrAdmissionDtlHidVal().split("\\^")[9]);
				_LPIssueDeskTransVO.setStrBSReqNo(""); 
				_LPIssueDeskTransVO.setStrBSIndent("");
				_LPIssueDeskTransVO.setStrUrgentFlg("");
				_LPIssueDeskTransVO.setStrDeptCode(_LPIssueDeskTransFB.getStrAdmissionDtlHidVal().split("\\^")[5]);
				_LPIssueDeskTransVO.setStrDeptUnitCode(_LPIssueDeskTransFB.getStrAdmissionDtlHidVal().split("\\^")[16]);
				_LPIssueDeskTransVO.setStrWardCode(_LPIssueDeskTransFB.getStrAdmissionDtlHidVal().split("\\^")[6]);
				_LPIssueDeskTransVO.setStrEpisodeCode(_LPIssueDeskTransFB.getStrAdmissionDtlHidVal().split("\\^")[1]);
				_LPIssueDeskTransVO.setStrVisitNo(_LPIssueDeskTransFB.getStrAdmissionDtlHidVal().split("\\^")[2]);
				_LPIssueDeskTransVO.setStrVisitType("0");
				_LPIssueDeskTransVO.setStrItemCategNo("10");
				_LPIssueDeskTransVO.setStrLpRequestNo("0");
				_LPIssueDeskTransVO.setStrRequestTypeId(_LPIssueDeskTransFB.getStrRequestTypeId());
				_LPIssueDeskTransVO.setStrRequestDate("");
				_LPIssueDeskTransVO.setStrRaisingStoreId(_LPIssueDeskTransFB.getStrStoreId());
				_LPIssueDeskTransVO.setStrFinalCost("0");
				_LPIssueDeskTransVO.setStrCrNo(_LPIssueDeskTransFB.getStrCrNo());
				_LPIssueDeskTransVO.setStrAdmissionNo(_LPIssueDeskTransFB.getStrAdmissionDtlHidVal().split("\\^")[0]);
				_LPIssueDeskTransVO.setStrEmpNo(""); 
				_LPIssueDeskTransVO.setStrSeatId(_LPIssueDeskTransFB.getStrSeatId());
				_LPIssueDeskTransVO.setStrReceivedby(_LPIssueDeskTransFB.getStrReceivedby());
				_LPIssueDeskTransVO.setStrPoNo("");
				_LPIssueDeskTransVO.setStrPoStoreId(_LPIssueDeskTransFB.getStrStoreId()); 
				_LPIssueDeskTransVO.setStrItemIdNew(_LPIssueDeskTransFB.getStrNewItemId());
				_LPIssueDeskTransVO.setStrBSIndent("1");
				_LPIssueDeskTransVO.setStrBSReqNo("0");
				_LPIssueDeskTransVO.setStrItembrandIdNew(_LPIssueDeskTransFB.getStrNewBrandId());
				_LPIssueDeskTransVO.setStrBatchNoNew(_LPIssueDeskTransFB.getBatchNo());
				_LPIssueDeskTransVO.setStrRateNew(_LPIssueDeskTransFB.getRatePerUnit());
				mcu=new MmsConfigUtil(_LPIssueDeskTransFB.getStrHospitalCode());  
				 _LPIssueDeskTransVO.setStrFinStartDate(mcu.getStrFinancialStartDate(_LPIssueDeskTransVO.getStrStoreId() , _LPIssueDeskTransVO.getStrHospitalCode()));
				 _LPIssueDeskTransVO.setStrFinEndDate(mcu.getStrFinancialEndDate(_LPIssueDeskTransVO.getStrStoreId() , _LPIssueDeskTransVO.getStrHospitalCode()));
				
				 bo.insertDataNew(_LPIssueDeskTransVO);
			//}
				 if(_LPIssueDeskTransVO.getStrMsgType().equals("1")){
						_LPIssueDeskTransFB.setStrFlag("0");
						
						throw new Exception(_LPIssueDeskTransVO.getStrMsgString());
					}else{
						_LPIssueDeskTransFB.setStrFlag("1");
						_LPIssueDeskTransFB.setStrIssueNo(_LPIssueDeskTransVO.getStrIssueNo());
							//if(_LPIssueDeskTransVO.getStrBSReqNo() != null && !_LPIssueDeskTransVO.getStrBSReqNo().equals("0"))
						_LPIssueDeskTransFB.setStrMsg("Data Saved successfully");
					}
				 
				 
			}
		catch(Exception e){
			e.printStackTrace();
			
			strmsgText = "Issue Desk.LPIssueDeskTransDATA.saveNewIssuePage(vo) --> "
				+ e.getMessage();
		HisException eObj = new HisException("mms",
				"LPIssueDeskTransDATA->getIndentDetails()", strmsgText);
		_LPIssueDeskTransFB.setStrErr("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		}
		return "";
	} 
	
	
	public static void indentAppPrint(HttpServletRequest request,HttpServletResponse response,LPIssueDeskTransFB formBean) 
	{
		LPIssueDeskTransBO bo = null;
		LPIssueDeskTransVO vo = null;
		String strmsgText = "";
		String str1 ="";
		String str2 ="";
		String str3 ="";
		String str4 ="";		
		StringBuffer sb = new StringBuffer("");
		String finalPrint = "";
		String temp[]=null;
		try 
		{
			bo = new LPIssueDeskTransBO();
			vo = new LPIssueDeskTransVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();				 
			String seatId  = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);	
			
			String strChk       = (String) request.getParameter("strChk");
			String strReqTypeId = (String) request.getParameter("strReqTypeId");
			String strStoreId   = (String) request.getParameter("strStoreId");
			
		 System.out.println("strChk-----------"+strChk);
		/**
		 * This is used set variables during request type equal to patient
		 */

			 temp=strChk.replace('@', '#').split("#");
			 formBean.setStrItemCategNo(temp[0]);
			 formBean.setStrLpRequestNo(temp[1]);
			 formBean.setStrRequestDate(temp[2]);
			 formBean.setStrRaisingStoreId(temp[3]);
			 formBean.setStrCrNo(temp[4]);
			 formBean.setStrBSReqNo(temp[6].replace('$', '#').split("#")[0]);
			 formBean.setStrPoNo("0");
			 formBean.setStrPoStoreId("0");
			 formBean.setStrUrgentFlg(temp[7]);
			 
			 
			 
			 vo.setStrItemCategNo(temp[0]);
			 vo.setStrLpRequestNo(temp[1]);
			 vo.setStrRequestDate(temp[2]);
			 vo.setStrRaisingStoreId(temp[3]);
			 vo.setStrCrNo(temp[4]);
			 vo.setStrBSReqNo(temp[6].replace('$', '#').split("#")[0]);
			 vo.setStrPoNo("0");
			 vo.setStrPoStoreId("0");
			 vo.setStrUrgentFlg(temp[7]);
			 vo.setStrStoreId(strStoreId);			 
			 vo.setStrRequestTypeId("13");
								
					
			
			System.out.println("----- LPIssueDeskTransDATA . indentAppPrint ----Req_type---"+vo.getStrRequestTypeId());
			
			String strTableWidth = "825";
			
			vo.setStrTableWidth(strTableWidth);

			
			bo.viewData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}			  
				
			str1 = LPIssueDeskTransHLP.getItemDetailsView1Print(vo);			  
			  
			//String strFrmStoreId,String strHospCode,String strToStoreId,String strItemCatgCode,String strReqTypeId,String strReqNo
			str2  =  ApprovalDtlHLP.getApprovalDtlPrint(vo.getStrRaisingStoreId(), vo.getStrHospitalCode(), vo.getStrStoreId(), temp[0], vo.getStrRequestTypeId(), vo.getStrLpRequestNo());
			
			
			str3 = LPIssueDeskTransHLP.getIndentDetailsViewPrint(vo);
				   
				
			
			
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(hosCode);
			
            //sb.append("<style>@media screen and (orientation: potrait) { #toolbar {position: fixed; width: 2.65em; height: 100%; } p { margin-left: 2em;} li + li {margin-top: .5em;}}</style>");
			
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			//sb.append("<tr><td width='8%'><div><img src='/HBIMS/hisglobal/images/logo.png' width='100' style='margin-left: 100%;float: left;'></div></td> ");
			sb.append("<tr><td align='center'><div><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td> ");
            //sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");

			//sb.append(hospitalVO.getHospitalName());
			//sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
//			sb.append("<tr> ");
//			sb.append("<td width='8%'>&nbsp;</td> ");
//			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
//			sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
//
//			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
//			sb.append("</tr> ");
			sb.append("</table> ");
			
			sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='"+strTableWidth+"'>");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData1();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup(),cancelToDesk();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			
			sb.append(str3+""+str1+""+str2);
			
			finalPrint = sb.toString();
										
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(finalPrint);
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "LPIssueDeskTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LPIssueDeskTransDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			sb = null;
		}

	}
	
}
