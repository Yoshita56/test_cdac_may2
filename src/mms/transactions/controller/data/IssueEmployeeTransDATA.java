package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.bo.IssueEmployeeTransBO;
import mms.transactions.controller.fb.IssueEmployeeTransFB;
import mms.transactions.controller.hlp.IssueEmployeeTransHLP;
import mms.transactions.vo.IssueEmployeeTransVO;

public class IssueEmployeeTransDATA {
	
	public static void getStoreDtls(IssueEmployeeTransFB formBean, HttpServletRequest request) {

		IssueEmployeeTransBO bo = null;
		IssueEmployeeTransVO vo = null;

		HisUtil util = null;
		String strStoreVal = "";
		String strmsgText = null;
		String strStoreComboId="";
		String strCategoryValues="";
		
		try {
			bo = new IssueEmployeeTransBO();
			vo = new IssueEmployeeTransVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			util = new HisUtil("MMS Transactions", "IssueEmployeeTransDATA");
			
			bo.getStoreDtls(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			/* Changed By Niharika Srivastava on 21-sep-2010*/
			
			if(vo.getStrStoreWs()!= null
					&& vo.getStrStoreWs().size() > 0){
				if(vo.getStrStoreWs().next())
				{
				vo.setStrStoreId(vo.getStrStoreWs().getString(1));
				formBean.setStrStoreId(vo.getStrStoreWs().getString(1));
				vo.getStrStoreWs().beforeFirst();
				}
			
			strStoreVal = util.getOptionValue(vo.getStrStoreWs(), "",
					"", false);
						
			formBean.setStrStoreValues(strStoreVal);
			
			}
			if(!formBean.getStrStoreId().equals(""))
				strStoreComboId = formBean.getStrStoreId();
			else
					strStoreComboId = request.getParameter("storeComboId");
			vo.setStrStoreId(strStoreComboId);
			
			if (strStoreComboId.equals("0")) 
			{
				strCategoryValues = "<option value='0'>Select Value</option>";
			} 
			else 
			{
				vo.setStrReqTypeId("34");
				bo.getItemCatDtls(vo);

				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());

				}
				if (vo.getStrItemCatWs().size() != 0) {
					
					strCategoryValues = util.getOptionValue(vo.getStrItemCatWs(), "0", "0^Select Value",
							true);

				}else{
					
					strCategoryValues = "<option value='0'>Select Value</option>";
				}
				formBean.setItemCatValues(strCategoryValues);
				
			}
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueEmployeeTransDATA.getStoreDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueEmployeeTransDATA->getStoreDtls()", strmsgText);
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
	
	public static void getItemCatDtls(IssueEmployeeTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IssueEmployeeTransBO bo = null;
		IssueEmployeeTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new IssueEmployeeTransBO();
			voObj = new IssueEmployeeTransVO();
			
			String strStoreId = request.getParameter("storeId");
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrReqTypeId("34");
					
			bo.getItemCatDtls(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueEmployeeTransDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrItemCatWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^Select Value",
						true);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueEmployeeTransDATA.getItemCatDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueEmployeeTransDATA->getItemCatDtls()", strmsgText);
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
	
	public static void getEmployeeDetails(IssueEmployeeTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) {

			IssueEmployeeTransBO bo = null;
			IssueEmployeeTransVO vo = null;
			HisUtil util = null;
			String strmsgText = null;
		
			try {
				bo = new IssueEmployeeTransBO();
				vo = new IssueEmployeeTransVO();
			
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrEmployeeNo(formBean.getStrEmployeeNo());
				
				////System.out.println("HospCode----"+vo.getStrHospitalCode());
				////System.out.println("EmpNo----"+vo.getStrEmployeeNo());
				
				bo.getEmployeeDtl(vo);
				
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}else{
				
				if(vo.getStrChkEmpExist().equals("0")){
					
					
					formBean.setStrChkEmpExist(vo.getStrChkEmpExist());
					formBean.setStrErrMsg("Invalid Employee No. / Data Not Found!!");
				}
				else{
					
					formBean.setStrErrMsg("");
					formBean.setStrChkEmpExist(vo.getStrChkEmpExist());
					String strPatientDetails = IssueEmployeeTransHLP.getEmployeeDtl(vo.getStrEmployeeWs(),formBean);
					formBean.setStrPatientDetails(strPatientDetails);
					////System.out.println("strPatientDetails--------->"+strPatientDetails);
					
					}
				}	
						
			} catch (Exception e) {
				e.printStackTrace();
				strmsgText = "mms.transactions.IssueEmployeeTransDATA.getEmployeeDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueEmployeeTransDATA->getEmployeeDetails()", strmsgText);
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
	
	
	public static void getPrescribedBy(IssueEmployeeTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		IssueEmployeeTransBO bo = null;
		IssueEmployeeTransVO vo = null;
		String strConsultantVal ="";

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new IssueEmployeeTransBO();
			vo = new IssueEmployeeTransVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getPrescribedBy(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueEmployeeTransDATA");
			
			strConsultantVal = util.getOptionValue(vo.getStrConsultantWs(), "0",
					"0^Select Value", false);
						
			formBean.setStrConsultantValues(strConsultantVal);
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueEmployeeTransDATA.getPrescribedBy --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueEmployeeTransDATA->getPrescribedBy()", strmsgText);
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
	
	public static void getGroupDetails(IssueEmployeeTransFB formBean, HttpServletRequest request) {

		IssueEmployeeTransBO bo = null;
		IssueEmployeeTransVO vo = null;

		HisUtil util = null;
		String strGroupVal = "";
		String strmsgText = null;
		
		try {
			bo = new IssueEmployeeTransBO();
			vo = new IssueEmployeeTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrItemCat(formBean.getItemCategory());
			
			bo.getStoreGroupDtls(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueEmployeeTransDATA");
			
			strGroupVal = util.getOptionValue(vo.getStrGroupWs(), "0",
					"0^Select Value", false);
						
			formBean.setStrGroupValues(strGroupVal);
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueEmployeeTransDATA.getGroupDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueEmployeeTransDATA->getGroupDetails()", strmsgText);
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
	
	public static void getIssueDetails(IssueEmployeeTransFB formBean, HttpServletRequest request, HttpServletResponse response)
	{
		
		IssueEmployeeTransBO bo = null;
		IssueEmployeeTransVO vo = null;
		
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		WebRowSet ws = null;
		try {
			bo = new IssueEmployeeTransBO();
			vo = new IssueEmployeeTransVO();
			mcu = new MmsConfigUtil(formBean.getStrHospitalCode());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			
			
			vo.setStrStoreId(request.getParameter("strId"));
			vo.setStrCatCode(request.getParameter("itemCategory"));
			vo.setStrEmployeeNo(request.getParameter("empNo"));
			vo.setStrEmployeeDays(mcu.getStrLastIssueEmployeeInDays());
			
			bo.getIssueDetail(vo);
			  
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
			ws = vo.getStrIssueDetailWs();
			
			String strIssueDetails = IssueEmployeeTransHLP.getIssueDetails(ws);
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strIssueDetails);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueEmployeeTransDATA.getIssueDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueEmployeeTransDATA->getIssueDetails()", strmsgText);
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
	
	public static void getIssuePopUp(IssueEmployeeTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) {

		IssueEmployeeTransBO bo = null;
		IssueEmployeeTransVO vo = null;
		
		HisUtil util = null;
		String strmsgText = null;
		
		String strStoreId = "";
		String strIssueNo = "";
		String strHospCode = "";
		
		try {
			bo = new IssueEmployeeTransBO();
			vo = new IssueEmployeeTransVO();
						
			strHospCode = formBean.getStrHospitalCode();
			strStoreId = request.getParameter("strId");
			strIssueNo = request.getParameter("issueNo");
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			
			String strPopUp = IssueEmployeeTransHLP.getIssuePopUp(strHospCode,strStoreId,strIssueNo);
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strPopUp);	
						
		} catch (Exception e) {
			strmsgText = "mms.transactions.IssueEmployeeTransDATA.getIssuePopUp --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueEmployeeTransDATA->getIssuePopUp()", strmsgText);
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

	public static void insert(IssueEmployeeTransFB formBean, HttpServletRequest request) {

		IssueEmployeeTransBO bo = null;
		IssueEmployeeTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		
		MmsConfigUtil mcu = null;
		
		try {
			bo = new IssueEmployeeTransBO();
			vo = new IssueEmployeeTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			
			vo.setStrReqQty(formBean.getStrReqQty());
			vo.setStrUnitName(formBean.getStrUnitName());
			
			vo.setStrPrescribedBy(formBean.getStrPrescribedBy());
			vo.setStrPrescriptionDate(formBean.getStrPrescriptionDate());
			
			
		
		
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrStoreId(formBean.getStrId());
			vo.setStrItemCat(formBean.getItemCategory());
		
			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrReceiveBy(formBean.getStrReceiveBy());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setItemParamValue(formBean.getItemParamValue());
			vo.setStrReqTypeId("34");
			vo.setStrDeptId(formBean.getStrDeptId());
			vo.setStrCtDate(formBean.getStrCtDate());
			vo.setStrEmployeeNo(formBean.getEmpNo());
			vo.setStrCostFinal(formBean.getStrCostFinal());
			vo.setStrApproxAmt(formBean.getStrApproxAmt());
			
			bo.insert(vo);
			
			formBean.setStrIssueNum(vo.getStrIssueNumber());
			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
				} 
			else {
					formBean.setStrNormalMsg("Data Saved Successfully");
					formBean.setStrErrMsg("");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueEmployeeTransDATA.insert --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueEmployeeTransDATA->insert()", strmsgText);
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
	
	
}
