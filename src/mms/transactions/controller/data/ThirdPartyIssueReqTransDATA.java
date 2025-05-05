package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.ThirdPartyIssueReqTransBO;
import mms.transactions.controller.fb.ThirdPartyIssueReqTransFB;
import mms.transactions.vo.ThirdPartyIssueReqTransVO;

public class ThirdPartyIssueReqTransDATA {

	  public static  String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
	  public static  String DATE_FORMAT_NOW = "dd-MMM-yyyy";
	    
	  public static  String now(String frmt)
	    {
	      HisUtil util=null;
	      String a="";
	      util=new HisUtil("transaction","PatientLeaveHLP");
	      try{
	       a= util.getASDate(frmt);
	      }
	      catch(Exception e){
	    	
	      }
	      /*Calendar cal = Calendar.getInstance();
	      SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	      return sdf.format(cal.getTime());*/
	      return a;
	    }
	/**
	 * This method is used to set all the values which are required to populate
	 * the Third Party List.
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void getThirdPartyCmb(ThirdPartyIssueReqTransFB formBean,
			HttpServletRequest request) {

		ThirdPartyIssueReqTransBO bo = null;
		ThirdPartyIssueReqTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strThirdPartyVal = "";
		try {
			bo = new ThirdPartyIssueReqTransBO();
			voObj = new ThirdPartyIssueReqTransVO();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			/* This Object is Used to get Re-Order Level Color from hisProperties File  */
			
			ResourceBundle resObj = mms.qryHandler_mms.res;
			if(resObj == null) 
			{
				resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = resObj;
			}
			
			formBean.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));
			formBean.setStrThirdPartyFlag(resObj.getString("THIRD_PARTY"));
			bo.getThirdPartyCmb(voObj);

			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}

			util = new HisUtil("MMS Transaction", "ThirdPartyIssueReqTransDATA");
			
			if(voObj.getStrInstituteWs()!=null)
			{
				//strReceivedByOptionVal=hisutil.getOptionValue(vo.getRecievedByWS(),"0", "Select Value", true);
				//strReceivedByOptionVal=strReceivedByOptionVal+"<option value='1'>Other</option>";
				
				strThirdPartyVal = util.getOptionValue(voObj.getStrInstituteWs(),"0", "0^Select Value", false);
				strThirdPartyVal = strThirdPartyVal+"<option value='1'>Other</option>";
			}
			else
			{
				strThirdPartyVal="<option value='0'>Select Value</option>";
			}
			
			
            //("Third Party Flg:::"+resObj.getString("THIRD_PARTY"));
			formBean.setStrInstituteValues(strThirdPartyVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			formBean.setStrThirdPartyFlag(resObj.getString("THIRD_PARTY"));

		} catch (Exception e) {
			strmsgText = "mms.transactions.ThirdPartyIssueReqTransDATA.getThirdPartyCmb --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ThirdPartyIssueReqTransDATA->getThirdPartyCmb()", strmsgText);
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

	/**
	 * This method is used to set all the values which are required to populate
	 * the Item Category List.
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void getGroupCmb(ThirdPartyIssueReqTransFB formBean,
			HttpServletRequest request) {

		ThirdPartyIssueReqTransBO bo = null;
		ThirdPartyIssueReqTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strGroupVal = "";
		try {
			bo = new ThirdPartyIssueReqTransBO();
			voObj = new ThirdPartyIssueReqTransVO();
			String cmbVal = request.getParameter("comboValue");
			
			ResourceBundle resObj = mms.qryHandler_mms.res;
			if(resObj == null) 
			{
				resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = resObj;
			}
			
			formBean.setComboValue(cmbVal);
			//("cmbVal->" + cmbVal);
			String strComboValues[] = request.getParameterValues("combo");
			formBean.setStrStoreName(cmbVal.replace('^', '#').split("#")[0]);
			formBean.setStrItemCatValues(cmbVal.replace('^', '#').split("#")[1]);
			//("strStoreName->" + strComboValues[0]);
			formBean.setStrStoreId(strComboValues[0]);
			formBean.setStrItemCatNo(strComboValues[1]);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrStoreId(formBean.getStrStoreId());
			voObj.setStrItemCatNo(formBean.getStrItemCatNo());
			
			bo.getGroupCmb(voObj);
			if (voObj.getStrMsgType().equals("1")) {

				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transaction", "ThirdPartyIssueReqTransDATA");

			strGroupVal = util.getOptionValue(voObj.getStrGroupWs(), "0",
					"0^Select Value", false);
		
			formBean.setStrGroupValues(strGroupVal);
			formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
			formBean.setStrThirdPartyFlag(resObj.getString("THIRD_PARTY"));

		} catch (Exception e) {
			strmsgText = "mms.transactions.ThirdPartyIssueReqTransDATA.getGroupCmb --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ThirdPartyIssueReqTransDATA->getGroupCmb()",
					strmsgText);
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

	/**
	 * This method is used to set all the values which are required to populate
	 * the Group List.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */

/*	public static void getGroupCmb(ThirdPartyIssueReqTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ThirdPartyIssueReqTransBO bo = null;
		ThirdPartyIssueReqTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		try {
			bo = new ThirdPartyIssueReqTransBO();
			voObj = new ThirdPartyIssueReqTransVO();

			String strItemCatNo = request.getParameter("itemCatNo");

			voObj.setStrItemCatNo(strItemCatNo);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getGroupCmb(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
			util = new HisUtil("MMS Transaction", "Third Party Issue");
			String strGroupName = "<option value='0'>Select Value</option>";

			if (voObj.getStrGroupWs().size() != 0) {
				strGroupName = util.getOptionValue(voObj.getStrGroupWs(), "0",
						"0^Select Value", true);
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strGroupName);

		} catch (Exception e) {
			strmsgText = "mms.transactions.ThirdPartyIssueReqTransDATA.getGroupCmb --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ThirdPartyIssueReqTransDATA->getGroupCmb()", strmsgText);
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

	}*/

	/**
	 * This method is used to set all the values for inserting the details.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void insert(ThirdPartyIssueReqTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{

		ThirdPartyIssueReqTransBO bo = null;
		ThirdPartyIssueReqTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		MmsConfigUtil mmsConfig = null;
		try 
		{
			       bo = new ThirdPartyIssueReqTransBO();
			    voObj = new ThirdPartyIssueReqTransVO();
			mmsConfig = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			    voObj = (ThirdPartyIssueReqTransVO) TransferObjectFactory.populateData("mms.transactions.vo.ThirdPartyIssueReqTransVO",formBean);
			voObj.setItemParamValue(formBean.getItemParamValue()); // Hidden Field
			//("itemParamVal->"+formBean.getItemParamValue()[0]);
			voObj.setStrFinancialStartYear(mmsConfig.getStrFinancialStartDate(voObj.getStrStoreId() , voObj.getStrHospitalCode()));
			voObj.setStrFinancialEndYear(mmsConfig.getStrFinancialEndDate(voObj.getStrStoreId() , voObj.getStrHospitalCode()));
			/*
			 * voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			 * voObj.setStrSeatId(formBean.getStrSeatId());
			 * voObj.setStrQty(formBean.getStrQty());
			 * voObj.setStrUnitName(formBean.getStrUnitName());
			 * voObj.setStrRemarks(formBean.getStrRemarks());
			 * voObj.setStrStoreId(formBean.getStrStoreId());
			 * voObj.setStrStoreTypeId(formBean.getStrStoreTypeId());
			 * voObj.setStrInstituteCode(formBean.getStrInstituteCode());
			 */
			//("Institue Code:::::"+formBean.getStrInstituteCode());
			
			bo.insert(voObj);

			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			} 
			else 
			{
				formBean.setStrNormalMsg("Data Inserted Successfully");
				 formBean.setStrReqNo("0");
			}
			util = new HisUtil("MMS Transaction", "Third Party Issue");

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.ThirdPartyIssueReqTransDATA.insert --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ThirdPartyIssueReqTransDATA->insert()", strmsgText);
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

	
	/**
	 * This method is used to set all the values for inserting the details.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void insertNew(ThirdPartyIssueReqTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{

		ThirdPartyIssueReqTransBO bo = null;
		ThirdPartyIssueReqTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		MmsConfigUtil mmsConfig = null;
		try 
		{
			       bo = new ThirdPartyIssueReqTransBO();
			    voObj = new ThirdPartyIssueReqTransVO();
			mmsConfig = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			    voObj = (ThirdPartyIssueReqTransVO) TransferObjectFactory.populateData("mms.transactions.vo.ThirdPartyIssueReqTransVO",formBean);
			voObj.setItemParamValue(formBean.getItemParamValue()); // Hidden Field
			voObj.setStrFinancialStartYear(mmsConfig.getStrFinancialStartDate(voObj.getStrStoreId() , voObj.getStrHospitalCode()));
			voObj.setStrFinancialEndYear(mmsConfig.getStrFinancialEndDate(voObj.getStrStoreId() , voObj.getStrHospitalCode()));			
			
			bo.insertNew(voObj);

			if (voObj.getStrMsgType().equals("1")) 
			{	
				
				if(voObj.getStrMsgString().split("\\##")[1].equals("InSufficent Stock available in Drug Warehouse!!"))
			    {
				  formBean.setStrErrMsg(voObj.getStrMsgString().split("\\##")[1]);
			    }
				else
				{
				  formBean.setStrErrMsg(voObj.getStrMsgString());
				  throw new Exception(voObj.getStrMsgString());
				}	
			} 
			else 
			{
			    formBean.setStrReqNo(voObj.getStrReqNo());
			    formBean.setStrStoreId(voObj.getStrStoreId());
				formBean.setStrNormalMsg("Data Inserted Successfully");
			}
			util = new HisUtil("MMS Transaction", "Third Party Issue");

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.ThirdPartyIssueReqTransDATA.insertNew() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ThirdPartyIssueReqTransDATA->insertNew()", strmsgText);
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
	/**
	 * This method is used to set all the values for inserting the details.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	
	public static void CANCEL_REQUEST(ThirdPartyIssueReqTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ThirdPartyIssueReqTransBO bo = null;
		ThirdPartyIssueReqTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String temp[]=null;
		String temp1[]=null;
		try {
			bo = new ThirdPartyIssueReqTransBO();
			voObj = new ThirdPartyIssueReqTransVO();

			String strStoreName = request.getParameter("comboValue");
			/* <TEST STRING> 
			 strChk->108@165090001@03-JUN-09@Drug@AIIMS@@sa$1#asd
             temp[0]->108@165090001@03-JUN-09@Drug@AIIMS@@sa$1
			 */
			String strChk = request.getParameter("chk");
			//("strChk->" + strChk);
			temp=strChk.split("#");
			formBean.setStrRemarks(temp[1]);
			//("temp[0]->" + temp[0]);
			temp1=temp[0].replace('@', '#').split("#");
			formBean.setStrReqNo(temp1[1]);
			
			String strComboValues[] = request.getParameterValues("combo");
			formBean.setStrStoreName(strStoreName);
			//("strStoreId->" + strComboValues[0]);
			//("Remarks->" + temp[1]);
			//("ReqNo->" + temp1[1]);
			formBean.setStrStoreId(strComboValues[0]);
			formBean.setStrItemCatNo(strComboValues[1]);
			voObj = (ThirdPartyIssueReqTransVO) TransferObjectFactory.populateData("mms.transactions.vo.ThirdPartyIssueReqTransVO",formBean);
			/*
			 * voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			 * voObj.setStrSeatId(formBean.getStrSeatId());
			 * voObj.setStrQty(formBean.getStrQty());
			 * voObj.setStrUnitName(formBean.getStrUnitName());
			 * voObj.setStrRemarks(formBean.getStrRemarks());
			 * voObj.setStrStoreId(formBean.getStrStoreId());
			 * voObj.setStrStoreTypeId(formBean.getStrStoreTypeId());
			 * voObj.setStrInstituteCode(formBean.getStrInstituteCode());
			 */
			bo.CANCEL_REQUEST(voObj);
			//("AfterInsertIn DATA->"+voObj.getStrMsgType());
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			} else {
				formBean.setStrNormalMsg("Data Updated Successfully");
			}
			//(formBean.getStrNormalMsg());
		} catch (Exception e) {
			e.printStackTrace();
			//("ERROR");
			strmsgText = "mms.transactions.ThirdPartyIssueReqTransDATA.CANCEL_REQUEST --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ThirdPartyIssueReqTransDATA->CANCEL_REQUEST()", strmsgText);
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

}
