/**
 * 
 */
package mms.transactions.controller.data;


import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import javax.sql.rowset.WebRowSet;


import mms.transactions.bo.SupplierReturnDeskBO;
import mms.transactions.controller.fb.SupplierReturnDeskFB;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.controller.hlp.SupplierReturnDeskHLP;
import mms.transactions.vo.SupplierReturnDeskVO;

/**
 * @author pankaj
 * 
 */
public class SupplierReturnDeskDATA {

	public static  String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
	  public static  String DATE_FORMAT_NOW = "dd-MMM-yyyy";
	    
	  public static  String now(String frmt)
	    {
	      HisUtil util=null;
	      String a="";
	      util=new HisUtil("transaction","SupplierReturn");
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
	
	public static void getData(SupplierReturnDeskFB formBean, 
						HttpServletRequest request) {

		SupplierReturnDeskBO bo = null;
		SupplierReturnDeskVO voObj = null;
		String strmsgText = null;
		WebRowSet ws=null;
		HisUtil util = null;
		try {
			bo = new SupplierReturnDeskBO();
			voObj = new SupplierReturnDeskVO();
			String strStoreName=request.getParameter("comboValue");
			String strChk=request.getParameter("chk");
			if(strChk!=null)
			{
			    formBean.setStrChk(strChk);
			    voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			    String strComboValues[] = request.getParameterValues("combo");
			    formBean.setStrStoreName(strStoreName);
				//("strStoreId->"+strComboValues[0]);
				//("StrChk->"+strChk);
				formBean.setStrStoreId(strComboValues[0]);
				voObj.setStrStoreId(strComboValues[0]);
				String strTemp1[]= strChk.replace("@", "#").split("#");
				formBean.setStrItemCategoryNoH(strTemp1[6]);
				voObj.setStrItemCategoryNoH(strTemp1[6]);
				formBean.setStrReqDate(strTemp1[2]);
				formBean.setStrItemCategoryNameH(strTemp1[3]);
				formBean.setStrReqNo(strTemp1[1]);
				voObj.setStrReqNo(strTemp1[1]);
				formBean.setStrOnlineFlag(strTemp1[5]);
				formBean.setStrPONo(strTemp1[7]);
				voObj.setStrPONo(strTemp1[7]);
				formBean.setStrPOStoreId(strTemp1[8]);
				voObj.setStrPOStoreId(strTemp1[8]);
				
				formBean.setStrDeliveryDate(strTemp1[11].replace('$', '#').split("#")[0]);
				formBean.setStrReturnFlag(strTemp1[9]);
				if(strTemp1[9].trim().equals("1"))
					 formBean.setStrReturnTypeName("Rejected");
				if(strTemp1[9].trim().equals("2"))
					 formBean.setStrReturnTypeName("Breakage");
				if(strTemp1[9].trim().equals("3"))
					 formBean.setStrReturnTypeName("Excess");
				if(strTemp1[9].trim().equals("4"))
					 formBean.setStrReturnTypeName("LP Return");
				
				formBean.setStrReturnType(strTemp1[10]);
				formBean.setStrRetType(strTemp1[10]);
				if(strTemp1[10].trim().equals("1"))
					 formBean.setStrReturnReason("Replacement");
				if(strTemp1[10].trim().equals("2"))
					 formBean.setStrReturnReason("Return");
				
				formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
			} 	
			else
			{
				voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				voObj.setStrStoreId(formBean.getStrStoreId());
				voObj.setStrItemCategoryNoH(formBean.getStrItemCategoryNoH());
				voObj.setStrReqNo(formBean.getStrReqNo());
				voObj.setStrPONo(formBean.getStrPONo());
				voObj.setStrPOStoreId(formBean.getStrPOStoreId());
			}
			//voObj = (SupplierReturnDeskVO) TransferObjectFactory.populateData("mms.transactions.vo.SupplierReturnDeskVO",formBean);
		
			bo.getItemAndPODetails(voObj);
			if (voObj.getStrMsgType().equals("1")) {

				throw new Exception(voObj.getStrMsgString());

			}
			ws=voObj.getStrPODetailsWs();
			//("po WS->"+ws.size());
			//("Item Dtl ws->"+voObj.getStrItemDetailsWS().size());
			while(ws.next())
			{
			   formBean.setStrPOStoreName(ws.getString(8));
			   formBean.setStrPODate(ws.getString(2));
			   formBean.setStrPOType(ws.getString(4));
			   formBean.setStrSupplierName(ws.getString(6));
			}   
			String strItemDtls=SupplierReturnDeskHLP.getItemDetails(voObj);
			String strApprovalDtls=ApprovalDtlHLP.getApprovalDtl(voObj.getStrStoreId(), voObj.getStrHospitalCode(), "0", voObj.getStrItemCategoryNoH(), "47", voObj.getStrReqNo());
			formBean.setStrItemDtls(strItemDtls);
			formBean.setStrApprovalDetails(strApprovalDtls);
			formBean.setStrGroupName(voObj.getStrGroupName());
			formBean.setStrRemarks(voObj.getStrRemarks());
			formBean.setStrTotalReturnCost(voObj.getStrTotalReturnCost());
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
		
		} catch (Exception e) {
			strmsgText = "mms.transactions.SupplierReturnDeskDATA.getData --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierReturnDeskDATA->getData()", strmsgText);
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
