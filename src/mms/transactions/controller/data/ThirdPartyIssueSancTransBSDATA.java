package mms.transactions.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.transactions.bo.ThirdPartyIssueSancTransBO;
import mms.transactions.controller.fb.ThirdPartyIssueSancTransFB;
import mms.transactions.controller.hlp.ThirdPartyIssueSancTransBSHLP;
import mms.transactions.controller.hlp.ThirdPartyIssueSancTransHLP;
import mms.transactions.vo.ThirdPartyIssueSancTransVO;

public class ThirdPartyIssueSancTransBSDATA {
	
	public static  String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
	  public static  String DATE_FORMAT_NOW = "dd-MMM-yyyy";
	    
	  public static  String now(String frmt)
	    {
	      HisUtil util=null;
	      String a="";
	      util=new HisUtil("transaction","ThirdPartyIssue");
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
	
	public static void getData(ThirdPartyIssueSancTransFB formBean, 
						HttpServletRequest request) {

		ThirdPartyIssueSancTransBO bo = null;
		ThirdPartyIssueSancTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {
			bo = new ThirdPartyIssueSancTransBO();
			voObj = new ThirdPartyIssueSancTransVO();
			String cmbVal=request.getParameter("comboValue");
			String strChk=request.getParameter("chk");
			if(strChk!=null)
			{
			    formBean.setStrChk(strChk);
			    String strComboValues[] = request.getParameterValues("combo");
			    formBean.setStrStoreName(cmbVal.replace('^', '#').split("#")[0]);
				//("strStoreId->"+strComboValues[0]);
				//("StrChk->"+strChk);
				formBean.setStrStoreId(strComboValues[0]);
				formBean.setStrItemCatNo(strComboValues[1]);
				String strTemp1[]= strChk.replace("@", "#").split("#");
				formBean.setStrItemCatValues(strTemp1[3]);
				formBean.setStrInstituteValues(strTemp1[4]);
				formBean.setStrReqDate(strTemp1[2]);
				formBean.setStrReqNo(strTemp1[1]);
				formBean.setStrCurrentDate(now(DATE_FORMAT_NOWwt));
			} 	
			voObj = (ThirdPartyIssueSancTransVO)TransferObjectFactory.populateData("mms.transactions.vo.ThirdPartyIssueSancTransVO",formBean);
			bo.getItemDetails(voObj);
			String strItemDtls=ThirdPartyIssueSancTransBSHLP.getItemDetails(voObj);
			formBean.setStrItemDtls(strItemDtls);
			formBean.setStrGroupName(voObj.getStrGroupName());
			if (voObj.getStrMsgType().equals("1")) {

				throw new Exception(voObj.getStrMsgString());

			}
		
		} catch (Exception e) {
			strmsgText = "mms.transactions.ThirdPartyIssueSancTransDATA.getData --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ThirdPartyIssueSancTransDATA->getItemCategoryCmb()", strmsgText);
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
	 * This method is used to set all the values
	 * for inserting the details.
	 * @param formBean
	 * @param request
	 * @param response
	 */
	
	public static void insert(ThirdPartyIssueSancTransFB formBean, HttpServletRequest request,
				HttpServletResponse response) {
		
			ThirdPartyIssueSancTransBO bo = null;
			ThirdPartyIssueSancTransVO voObj = null;
			String strmsgText = null;
			HisUtil util = null;
			
			MmsConfigUtil mmsConfig = null;
		
		try {
			bo = new ThirdPartyIssueSancTransBO();
			voObj = new ThirdPartyIssueSancTransVO();
			mmsConfig = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			voObj = (ThirdPartyIssueSancTransVO)TransferObjectFactory.populateData("mms.transactions.vo.ThirdPartyIssueSancTransVO",formBean);
			
			
			voObj.setStrFinancialStartYear(mmsConfig.getStrFinancialStartDate(voObj.getStrStoreId() , voObj.getStrHospitalCode()));
			voObj.setStrFinancialEndYear(mmsConfig.getStrFinancialEndDate(voObj.getStrStoreId() , voObj.getStrHospitalCode()));
			
			bo.insert(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
				formBean.setMode("0");
				if(voObj.getStrMsgString().split("\\##")[2].equals("999"))
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
				formBean.setMode("1");
				formBean.setStrNormalMsg("Data Updated Successfully");
			}
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.ThirdPartyIssueSancTransDATA.insert --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ThirdPartyIssueSancTransDATA->insert()", strmsgText);
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
