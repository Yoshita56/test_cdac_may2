package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.bo.SupplierReturnModifyTransBO;
import mms.transactions.controller.fb.SupplierReturnModifyTransFB;
import mms.transactions.controller.hlp.SupplierReturnModifyTransHLP;
import mms.transactions.vo.SupplierReturnModifyTransVO;

public class SupplierReturnModifyTransDATA {
	
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
	
	public static void getData(SupplierReturnModifyTransFB formBean, 
						HttpServletRequest request) {

		SupplierReturnModifyTransBO bo = null;
		SupplierReturnModifyTransVO voObj = null;
		String strmsgText = null;
		WebRowSet ws=null;
		HisUtil util = null;
		try {
			bo = new SupplierReturnModifyTransBO();
			voObj = new SupplierReturnModifyTransVO();
			String strStoreName=request.getParameter("comboValue");
			String strChk=request.getParameter("chk");
			if(strChk!=null)
			{
			    formBean.setStrChk(strChk);
			    voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			    String strComboValues[] = request.getParameterValues("combo");
			    formBean.setStrStoreName(strStoreName);
				//("strStoreId->"+strComboValues[0]);
			//	("StrChk->"+strChk);
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
				formBean.setStrDeliveryDate(strTemp1[11]);
				formBean.setStrReturnFlag(strTemp1[9]);
				if(strTemp1[9].trim().equals("1"))
					 formBean.setStrReturnTypeName("Rejected");
				if(strTemp1[9].trim().equals("2"))
					 formBean.setStrReturnTypeName("Breakage");
				if(strTemp1[9].trim().equals("3"))
					 formBean.setStrReturnTypeName("Excess");
				if(strTemp1[9].trim().equals("4"))
					 formBean.setStrReturnTypeName("LP Return");
				if(strTemp1[9].trim().equals("1") || strTemp1[9].trim().equals("2"))
				{
				   formBean.setStrReturnType("<option value = '1'>Replacement</option><option value = '2'>Return</option>");
				}
				else
				{
				   formBean.setStrReturnType("<option value = '2'>Return</option>");	
				}
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
				if(formBean.getStrReturnFlag().trim().equals("1") ||formBean.getStrReturnFlag().trim().equals("2"))
				{
				   formBean.setStrReturnType("<option value = '1'>Replacement</option><option value = '2'>Return</option>");
				}
				else
				{
				   formBean.setStrReturnType("<option value = '2'>Return</option>");	
				}
			}
			//voObj = (SupplierReturnModifyTransVO) TransferObjectFactory.populateData("mms.transactions.vo.SupplierReturnModifyTransVO",formBean);
		
			bo.getItemAndPODetails(voObj);
			if (voObj.getStrMsgType().equals("1")) {

				throw new Exception(voObj.getStrMsgString());

			}
			ws=voObj.getStrPODetailsWs();
			while(ws.next())
			{
			   formBean.setStrPOStoreName(ws.getString(8));
			   formBean.setStrPODate(ws.getString(2));
			   formBean.setStrPOType(ws.getString(4));
			   formBean.setStrSupplierName(ws.getString(6));
			}   
			String strItemDtls=SupplierReturnModifyTransHLP.getItemDetails(voObj);
			formBean.setStrItemDtls(strItemDtls);
			formBean.setStrGroupName(voObj.getStrGroupName());
			formBean.setStrRemarks(voObj.getStrRemarks());
			formBean.setStrTotalReturnCost(voObj.getStrTotalReturnCost());
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
		
		}
		catch (Exception e) 
		{
			strmsgText = "mms.transactions.SupplierReturnModifyTransDATA.getData -->"
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierReturnModifyTransDATA->getData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} 
		finally 
		{
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
	
	public static void insert(SupplierReturnModifyTransFB formBean, HttpServletRequest request,
				HttpServletResponse response) {
		
			SupplierReturnModifyTransBO bo = null;
			SupplierReturnModifyTransVO voObj = null;
			String strmsgText = null;
			HisUtil util = null;
			
			MmsConfigUtil mmsConfig = null;
		
		try {
			bo = new SupplierReturnModifyTransBO();
			voObj = new SupplierReturnModifyTransVO();
			mmsConfig = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			//voObj = (SupplierReturnModifyTransVO)TransferObjectFactory.populateData("mms.transactions.vo.SupplierReturnModifyTransVO",formBean);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrStoreId(formBean.getStrStoreId());
			voObj.setStrItemCategoryNoH(formBean.getStrItemCategoryNoH());
			voObj.setStrReqNo(formBean.getStrReqNo());
			voObj.setStrRemarks(formBean.getStrRemarks());
			voObj.setStrReturnType(formBean.getStrReturnType());
			
			voObj.setStrFinancialStartYear(mmsConfig.getStrFinancialStartDate(voObj.getStrStoreId(),voObj.getStrHospitalCode()));
			voObj.setStrFinancialEndYear(mmsConfig.getStrFinancialEndDate(voObj.getStrStoreId(),voObj.getStrHospitalCode()));
			
			if(formBean.getStrReturnType().trim().equals("1"))
			   voObj.setStrDeliveryDate(formBean.getStrDeliveryDate());
			else
			   voObj.setStrDeliveryDate("");	
			bo.insert(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}
			else
			{
				formBean.setStrNormalMsg("Return Request Details Updated Successfully");
				
				if(voObj.getStrReturnType().trim().equals("1"))
					 formBean.setStrReturnReason("Replacement");
				if(voObj.getStrReturnType().trim().equals("2"))
					 formBean.setStrReturnReason("Return");
			}
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.SupplierReturnModifyTransDATA.insert --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierReturnModifyTransDATA->insert()", strmsgText);
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
