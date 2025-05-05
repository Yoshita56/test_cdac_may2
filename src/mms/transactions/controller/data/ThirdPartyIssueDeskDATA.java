package mms.transactions.controller.data;


import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import mms.transactions.bo.ThirdPartyIssueDeskBO;
import mms.transactions.controller.fb.ThirdPartyIssueDeskFB;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.controller.hlp.ThirdPartyIssueDeskHLP;
import mms.transactions.vo.ThirdPartyIssueDeskVO;

public class ThirdPartyIssueDeskDATA {
	 public static  String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
	  public static  String DATE_FORMAT_NOW = "dd-MMM-yyyy";
	    
	  public static  String now(String frmt)
	    {
	      HisUtil util=null;
	      String a="";
	      util=new HisUtil("transaction","ThirdPartyIssueDeskDATA");
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
		 * This method is used to set all the values which
		 * are required to populate the Item Category List.
		 * @param formBean
		 * @param request
		 */
		
		public static void getData(ThirdPartyIssueDeskFB formBean, 
							HttpServletRequest request) {

			ThirdPartyIssueDeskBO bo = null;
			ThirdPartyIssueDeskVO voObj = null;
			String strmsgText = null;
			HisUtil util = null;
			try {
				bo = new ThirdPartyIssueDeskBO();
				voObj = new ThirdPartyIssueDeskVO();
				
				ResourceBundle resObj = mms.qryHandler_mms.res;
				if(resObj == null) 
				{
					resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
					mms.qryHandler_mms.res = resObj;
				}
				
				String cmbVal=request.getParameter("comboValue");
				String strChk=request.getParameter("chk");
				String strComboValues[] = request.getParameterValues("combo");
				formBean.setStrStoreName(cmbVal.replace('^', '#').split("#")[0]);
				formBean.setStrStoreId(strComboValues[0]);
				formBean.setStrItemCatNo(strComboValues[1]);
				String strTemp1[]= strChk.replace('@', '#').split("#");
				formBean.setStrItemCatValues(strTemp1[3]);
				formBean.setStrInstituteValues(strTemp1[4]);
				formBean.setStrReqNo(strTemp1[1]);
				formBean.setStrHospitalCode(strTemp1[0]);
				formBean.setStrCurrentDate(now(DATE_FORMAT_NOWwt));
				//voObj = (ThirdPartyIssueDeskVO)TransferObjectFactory.populateData("mms.transactions.vo.ThirdPartyIssueDeskVO",formBean);
				voObj.setStrStoreId(formBean.getStrStoreId());
				voObj.setStrReqNo(formBean.getStrReqNo());
				voObj.setStrHospitalCode(strTemp1[0]);
				voObj.setStrItemCatNo(formBean.getStrItemCatNo());
//				("StrItemCatValues->"+voObj.getStrItemCatValues());
//				("StrInstituteValues->"+voObj.getStrInstituteValues());
//				("StrReqNo->"+voObj.getStrReqNo());
//				("StrHospitalCode->"+voObj.getStrHospitalCode());
//				("StrCurrentDate->"+voObj.getStrCurrentDate());
				bo.getItemDetails(voObj);
				String strItemDtls=ThirdPartyIssueDeskHLP.getItemDetails(voObj);
				
				String strApprovalDtls=ApprovalDtlHLP.getApprovalDtl(voObj.getStrStoreId(), voObj.getStrHospitalCode(), "0", voObj.getStrItemCatNo(), "65", voObj.getStrReqNo());
				formBean.setStrItemDtls(strItemDtls);
				formBean.setStrApprovalDtls(strApprovalDtls);
				
				formBean.setStrGroupName(voObj.getStrGroupName());
				formBean.setStrRemarks(voObj.getStrRemarks());
				formBean.setStrThirdPartyFlag(resObj.getString("THIRD_PARTY"));
				formBean.setStrItemCatNo(voObj.getStrItemCatNo());
				formBean.setStrReqNo(voObj.getStrReqNo());
				
				
				if (voObj.getStrMsgType().equals("1")) {

					throw new Exception(voObj.getStrMsgString());

				}
			
			} catch (Exception e) {
				strmsgText = "mms.transactions.ThirdPartyIssueDeskDATA.getData --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"ThirdPartyIssueDeskDATA->getData()", strmsgText);
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