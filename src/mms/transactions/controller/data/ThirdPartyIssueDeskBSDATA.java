package mms.transactions.controller.data;


import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.global.bo.MmsBO;
import mms.global.controller.MmsFB;
import mms.global.controller.MmsHLP;
import mms.global.vo.MmsVO;
import mms.transactions.bo.ThirdPartyIssueDeskBO;
import mms.transactions.controller.fb.ThirdPartyIssueDeskFB;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.controller.hlp.ThirdPartyIssueDeskBSHLP;
import mms.transactions.controller.hlp.ThirdPartyIssueDeskHLP;
import mms.transactions.vo.ThirdPartyIssueDeskVO;

public class ThirdPartyIssueDeskBSDATA {
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
				String strItemDtls=ThirdPartyIssueDeskBSHLP.getItemDetails(voObj);
				
				String strApprovalDtls=ApprovalDtlHLP.getApprovalDtlBS(voObj.getStrStoreId(), voObj.getStrHospitalCode(), "0", voObj.getStrItemCatNo(), "65", voObj.getStrReqNo());
				formBean.setStrItemDtls(strItemDtls);
				//formBean.setStrApprovalDtls(strApprovalDtls);
				
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
		
		public static void issueDtlsInit(HttpServletRequest request,
				HttpServletResponse response, ThirdPartyIssueDeskFB formBean) {

			String strSearchItemInitView = "";

			ThirdPartyIssueDeskBO bo = null;
			ThirdPartyIssueDeskVO vo = null;

			try {

				String strMode = (String) request.getParameter("strMode");
				String strFromStoreId = (String) request.getParameter("strStoreId");
				String strIssueNo = (String) request.getParameter("strIssueNo");
				String strIndentNo = (String) request.getParameter("strIndentNo");
				String crNo = (String) request.getParameter("crNo")==null?"0":(String) request.getParameter("crNo");
				
				
				String strIndentDate = (String) request
						.getParameter("strIndentDate");
				bo = new ThirdPartyIssueDeskBO();
				vo = new ThirdPartyIssueDeskVO();

				formBean.setStrHospitalCode(request.getSession()
						.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

				formBean.setStrFromStoreId(strFromStoreId);
				formBean.setStrModeVal(strMode);
				formBean.setStrIssueNo(strIssueNo);

				vo.setStrModeVal(formBean.getStrModeVal());
				vo.setStrFromStoreId(formBean.getStrFromStoreId());
				vo.setStrIssueNo(formBean.getStrIssueNo());
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
								
				System.out.println("-----------ThirdPartyIssueDeskBSDATA . ISSUEDTLSINIT [ After Save Issue Voucher - "+formBean.getStrModeVal()+"]--------------");
				
				bo.getIssueDtlsInitDtls(vo);

				if (vo.getStrMsgType().equals("1")) {

					throw new Exception(vo.getStrMsgString());
				}
				formBean.setStrIssueNo(strIssueNo);
				formBean.setStrIssueDate(vo.getStrIssueDate());
				formBean.setStrIssueTo(vo.getStrIssueTo());

				formBean.setStrSlNoflg(vo.getStrSlNoflg());
				
				System.out.println("-----------ThirdPartyIssueDeskHLP.getIssueDtlsInitView--------------");
				
				strSearchItemInitView = ThirdPartyIssueDeskHLP.getIssueDtlsInitView(vo,formBean);
				
				
				//System.out.println("strSearchItemInitView" + strSearchItemInitView);
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strSearchItemInitView);
				
				System.out.println("----------- Issue Voucher END --------------");
				
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
		
}