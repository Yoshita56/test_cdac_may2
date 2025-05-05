package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.InstallationTransBO;
import mms.transactions.controller.fb.InstallationTransFB;
import mms.transactions.controller.hlp.InstallationTransHLP;
import mms.transactions.vo.InstallationTransVO;

public class InstallationTransDATA {
	
	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	public static void initialAdd(InstallationTransFB formBean,HttpServletRequest request) {
		InstallationTransVO vo=null;
		InstallationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String cmb = "";
		String strCategoryValues = "";
		String strStoreComboId = "";
		String strGroupNameValues = "";
		
			
		try {
			hisutil = new HisUtil("MMS","InstallationTransDATA");
			vo = new InstallationTransVO();
			bo = new InstallationTransBO();
						
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			
				
			bo.initialAdd(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			/* Changed By Niharika Srivastava on 21-sep-2010*/
			
			if (vo.getStrStoreComboWs() != null
					&& vo.getStrStoreComboWs().size() > 0) {
				if(vo.getStrStoreComboWs().next())
				{
				vo.setStrStoreId(vo.getStrStoreComboWs().getString(1));
				formBean.setStrStoreId(vo.getStrStoreComboWs().getString(1));
				vo.getStrStoreComboWs().beforeFirst();
				}
			     cmb = hisutil.getOptionValue(vo.getStrStoreComboWs(),
					   "", "", true);
			}
			else {
				cmb = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrStoreValues(cmb);
			
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
				bo.getItemCatCmb(vo);
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				if (vo.getStrItemCatComboWs() != null && vo.getStrItemCatComboWs().size() > 0) 
				{
					if(vo.getStrItemCatComboWs().next())
					{
						vo.setStrItemCatNo(vo.getStrItemCatComboWs().getString(1));
						formBean.setStrItemCatNo(vo.getStrItemCatComboWs().getString(1));
						vo.getStrItemCatComboWs().beforeFirst();
					}
					strCategoryValues = hisutil.getOptionValue(vo.getStrItemCatComboWs(), "", "",true);
				} 
				else 
				{
					strCategoryValues = "<option value='0'>Select Value</option>";
					vo.setStrItemCatNo("0");
					formBean.setStrItemCatNo("0");
				}
				formBean.setStrCategoryValues(strCategoryValues);	
				
				if(!vo.getStrItemCatNo().equals("0") && !vo.getStrItemCatNo().equals(""))
				bo.getGroupCmb(vo);
				if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
				}
				if (vo.getStrGroupComboWs() != null && vo.getStrGroupComboWs().size() > 0) 
				{
					if(vo.getStrGroupComboWs().next())
					{
						vo.setStrGroupId(vo.getStrGroupComboWs().getString(1));
						formBean.setStrGroupId(vo.getStrGroupComboWs().getString(1));
						vo.getStrGroupComboWs().beforeFirst();
					}
					strGroupNameValues = hisutil.getOptionValue(vo.getStrGroupComboWs(), "0","0^Select Value", true);
					} 
				else 
				{
						strGroupNameValues = "<option value='0'>Select Value</option>";
						vo.setStrGroupId("0");
						formBean.setStrGroupId("0");
				}
				formBean.setStrGroupNameValues(strGroupNameValues);
		} 
		}catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "InstallationTransDATA->initialAdd()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	/**
	 * This function is used to display Item Category Name on the basis of store Name: 
	 * @param formBean
	 */
	public static void getItemCatCmb(InstallationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		InstallationTransVO vo=null;
		InstallationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String storeId = "";
		String strCmb = "";
		
			
		try {
			hisutil = new HisUtil("MMS","InstallationTransDATA");
			vo = new InstallationTransVO();
			bo = new InstallationTransBO();
							
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			storeId = (String) request.getParameter("storeid");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrStoreId(storeId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(formBean.getStrStoreId());
				
			bo.getItemCatCmb(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getStrItemCatComboWs()!=null
					&& vo.getStrItemCatComboWs().size() > 0){		
			
				strCmb = hisutil.getOptionValue(vo.getStrItemCatComboWs(),
					"0", "", false);
			}else {
				strCmb = "<option value='0'>Select Value</option>";
			}
		
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "InstallationTransDATA->getItemCatCmb()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	/**
	 * This function is used to display Group Name on the basis of ItemCategory Name: 
	 * @param formBean
	 */
	public static void getGroupCmb(InstallationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		InstallationTransVO vo=null;
		InstallationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatId = "";
		String itemCatNo = "";
		String strCmb = "";
		
			
		try {
			hisutil = new HisUtil("MMS","InstallationTransDATA");
			vo = new InstallationTransVO();
			bo = new InstallationTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId = request.getSession().getAttribute("SEATID").toString();
			itemCatNo = (String) request.getParameter("itemCatNo");
			
			formBean.setStrSeatId(seatId);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrItemCatNo(itemCatNo);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrItemCatNo(formBean.getStrItemCatNo());
				
			bo.getGroupCmb(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getStrGroupComboWs()!=null
					&& vo.getStrGroupComboWs().size() > 0){			
				strCmb = hisutil.getOptionValue(vo.getStrGroupComboWs(),
					"", "0^Select Value", true);
			}else {
				strCmb = "<option value='0'>Select Value</option>";
			}
						
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "InstallationTransDATA->getGroupCmb()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	/**
	 * This function is used to display SubGroup Name on the basis of Group Name: 
	 * @param formBean
	 */
	public static void getSubGroupCmb(InstallationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		InstallationTransVO vo=null;
		InstallationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String groupId = "";
		String strSubGrpCmb = "";
		
		try {
			hisutil = new HisUtil("MMS","InstallationTransDATA");
			vo = new InstallationTransVO();
			bo = new InstallationTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			groupId = (String) request.getParameter("groupId");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrGroupId(groupId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrGroupId(formBean.getStrGroupId());
				
			bo.getSubGroupCmb(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			
			if(vo.getStrSubGroupComboWs()!=null
					&& vo.getStrSubGroupComboWs().size() > 0){			
				strSubGrpCmb = hisutil.getOptionValue(vo.getStrSubGroupComboWs(),
					"", "0^Select Value", true);
			}else {
				strSubGrpCmb = "<option value='0'>Select Value</option>";
			}
				
			

			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strSubGrpCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "InstallationTransDATA->getSubGroupCmb()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	/**
	 * This function is used to display GenItem Name on the basis of StoreId,ItemCtNo,GrpId,SubGrpId: 
	 * @param formBean
	 */
	public static void getGenItemCmb(InstallationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		InstallationTransVO vo=null;
		InstallationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNo = "";
		String groupId = "";
		String subGrpId = "";
		String strGenItemCmb = "";	
			
		try {
			hisutil = new HisUtil("MMS","InstallationTransDATA");
			vo = new InstallationTransVO();
			bo = new InstallationTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			itemCatNo = (String) request.getParameter("itemCatNo");
			groupId = (String) request.getParameter("groupId");
			subGrpId = (String) request.getParameter("subgrpid");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrItemCatNo(itemCatNo);
			formBean.setStrGroupId(groupId);
			formBean.setStrSubGroupId(subGrpId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatNo(formBean.getStrItemCatNo());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());
				
						
			bo.getGenItemCmb(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getStrGenItemComboWs()!=null
					&& vo.getStrGenItemComboWs().size() > 0){			
				strGenItemCmb = hisutil.getOptionValue(vo.getStrGenItemComboWs(),
					"", "0^Select Value", true);
			}else {
				strGenItemCmb = "<option value='0'>Select Value</option>";
			}
			
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strGenItemCmb);	
				
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "InstallationTransDATA->getGenItemCmb()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	/**
	 * This function is used to display Item Name on the basis of StoreId,ItemCatNo,GroupId,SubGrpId,GenItemId: 
	 * @param formBean
	 */
	public static void getItemCmb(InstallationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		InstallationTransVO vo=null;
		InstallationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String storeId = "";
		String groupId = "";
		String stItemCmb = "";
		String itemCatNo = "";
		String subGrpId = "";
		String genItemId = "";
		
			
		try {
			hisutil = new HisUtil("MMS","InstallationTransDATA");
			vo = new InstallationTransVO();
			bo = new InstallationTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			storeId = (String) request.getParameter("storeid");
			itemCatNo = (String) request.getParameter("itemCatNo");
			groupId = (String) request.getParameter("groupId");
			subGrpId = (String) request.getParameter("subgrpid");
			genItemId = (String) request.getParameter("genitemid");
			
			String[] temp = genItemId.replace("^", "#").split("#");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrStoreId(storeId);
			formBean.setStrItemCatNo(itemCatNo);
			formBean.setStrGroupId(groupId);
			formBean.setStrSubGroupId(subGrpId);
			formBean.setStrGenericItemId(temp[0]);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemCatNo(formBean.getStrItemCatNo());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());
			vo.setStrGenItemId(formBean.getStrGenericItemId());
				
			bo.getItemCmb(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getStrItemComboWs()!=null
					&& vo.getStrItemComboWs().size() > 0){			
				stItemCmb = hisutil.getOptionValue(vo.getStrItemComboWs(),
					"", "0^Select Value", true);
			}else {
				stItemCmb = "<option value='0'>Select Value</option>";
			}			
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(stItemCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "InstallationTransDATA->getItemCmb()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	
	/**
	 * This function is used to display Batch No on the basis of Item Name: 
	 * @param formBean
	 */
	public static void getBatchSerialNo(InstallationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		InstallationTransVO vo=null;
		InstallationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemId = "";
		String itemCatNo = "";
		String storeId = "";
		String genItemId = "";
		String strBatchCmb = "";
		String strSerialCmb = "";
		String[] temp = null;
		String[] strTemp = null;
		
			
		try {
			hisutil = new HisUtil("MMS","InstallationTransDATA");
			vo = new InstallationTransVO();
			bo = new InstallationTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			storeId = (String) request.getParameter("storeid");
			itemCatNo= (String) request.getParameter("itemCatNo");
			genItemId = (String) request.getParameter("genitemId");
			itemId = (String) request.getParameter("itemId");
			
			strTemp = genItemId.replace('^', '#').split("#");
			temp = itemId.replace('^', '#').split("#");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrItemBrandId(temp[0]);
			formBean.setStrIsConsumable(temp[1]);
			formBean.setStrGenericItemId(strTemp[0]);
			formBean.setStrItemCatNo(itemCatNo);
			formBean.setStrStockStatusCode("14");
			formBean.setStrStoreId(storeId);
			
			
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemBrandId(formBean.getStrItemBrandId());
			vo.setStrStockStatusCode(formBean.getStrStockStatusCode());
			vo.setStrGenItemId(formBean.getStrGenericItemId());
			vo.setStrItemCatNo(formBean.getStrItemCatNo());
			vo.setStrStoreId(formBean.getStrStoreId());
		
			
			vo.setStrIsBatchNoReq(strTemp[1]);
			vo.setStrIsSerialNoReq(strTemp[2]);
			
			bo.getBatchSerialNo(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			
			if(vo.getStrItemCatNo().equals("10")){
				
				if(vo.getStrBatchSlNoComboWs()!=null
						&& vo.getStrBatchSlNoComboWs().size() > 0){			
					strBatchCmb = hisutil.getOptionValue(vo.getStrBatchSlNoComboWs(),
						"0", "0^Select Value", false);
				}else {
					strBatchCmb = "<option value='0'>Select Value</option>";
				}
		
			  response.setHeader("Cache-Control", "no-cache");
			  response.getWriter().print(strBatchCmb);
			  
			}else{
				
				if(vo.getStrIsBatchNoReq().equals("1")){
					
					if(vo.getStrBatchSlNoComboWs()!=null
							&& vo.getStrBatchSlNoComboWs().size() > 0){			
						strBatchCmb = hisutil.getOptionValue(vo.getStrBatchSlNoComboWs(),
							"0", "0^Select Value", false);
					}else {
						strBatchCmb = "<option value='0'>Select Value</option>";
					}
					
				}
				
				if(vo.getStrIsSerialNoReq().equals("1")){
					if(vo.getStrItemSlNoComboWs()!=null
							&& vo.getStrItemSlNoComboWs().size() > 0){			
						strSerialCmb = hisutil.getOptionValue(vo.getStrItemSlNoComboWs(),
							"0", "0^Select Value", false);
					}else {
						strSerialCmb = "<option value='0'>Select Value</option>";
					}
				}
				
				  response.setHeader("Cache-Control", "no-cache");
				  response.getWriter().print(strBatchCmb+"@"+strSerialCmb);
				
			
			}					
		} catch (Exception e) {
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "InstallationTransDATA->getBatchSerialNo()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	/**
	 * This function invoke TransferObjectFactory.populateData() to transfer the values of all attributes of form bean into vo and the invoke bo insert method
	 * @param formBean
	 */
	public static void insert(InstallationTransFB formBean,HttpServletRequest request)
	{
		InstallationTransVO vo=null;
		InstallationTransBO bo= null;
		MmsConfigUtil mcu = null;
		String temp1[] = null;
		try
			{
			  bo = new InstallationTransBO();
			  
			  formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			  formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  
			  mcu = new MmsConfigUtil(formBean.getStrHospitalCode());
			  
			  formBean.setStrStockStatusCode("14");
			  
			  String GenItemId[] = formBean.getStrGenericItemId().replace("^", "#").split("#");
			  
			  formBean.setStrGenericItemId(GenItemId[0]);
			  
			  String temp[] = formBean.getStrItemBrandId().replace("^", "#").split("#");
			  
			  formBean.setStrItemBrandId(temp[0]);
			  formBean.setStrIsConsumable(temp[1]);
			 
			  if(formBean.getStrBatchNo().equals("0"))
			  {
				  temp1 = formBean.getStrItemSlNo().replace("^", "#").split("#");
			  }else{
				  temp1 = formBean.getStrBatchNo().replace("^", "#").split("#");
			  }

			  formBean.setStrBatchNo(temp1[0]);
			  formBean.setStrItemSlNo(temp1[1]);
			  
			  formBean.setStrInhandQty(temp1[7]);
			  formBean.setStrInhandQtyUnitId(temp1[8]);
			  
			  formBean.setStrPONo(temp1[3]);
			  formBean.setStrPODate(temp1[4]);
			  formBean.setStrSupplierId(temp1[6]);
			  
			  formBean.setStrIsValid("1");
			//  formBean.setStrReservedFlag("1");
			//  formBean.setStrRequestType("66");
			  
			//  String strTemp[] = formBean.getStrConsumedQtyUnitId().replace("^", "#").split("#");
						  
			  formBean.setStrFinStartDate(mcu.getStrFinancialStartDate(formBean.getStrStoreId() , formBean.getStrHospitalCode()));
			  formBean.setStrFinEndDate(mcu.getStrFinancialEndDate(formBean.getStrStoreId() , formBean.getStrHospitalCode()));
			  
			  vo = (InstallationTransVO) TransferObjectFactory.
						populateData("mms.transactions.vo.InstallationTransVO", formBean);
			  
			  
			  bo.insert(vo);
			  if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
			  }
			  else{
				  formBean.setStrNormalMsg("Record saved successfully");
			  }			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				String strmsgText = e.getMessage();
				HisException eObj = new HisException("Mms Transaction", "InstallationTransDATA","Quality Check Control.InstallationTransDATA->insert()" + strmsgText);
				formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
			}
			finally {
				if (vo != null) vo = null;
				if(formBean != null) formBean = null;
			}
		}
	
	/**
	 * This function is used to set exist value required to display on view page 
	 * @param formBean
	 */
	public static void goView(InstallationTransFB formBean,HttpServletRequest request) {
		InstallationTransVO vo=null;
		InstallationTransBO bo= null;
	
		String hosCode = "";
		
		MmsConfigUtil mcu = null;
		
			
		try {
			vo = new InstallationTransVO();
			bo = new InstallationTransBO();
	
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			mcu     = new MmsConfigUtil(hosCode);
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrFinStartDate(mcu.getStrFinancialStartDate(formBean.getStrStoreId() , formBean.getStrHospitalCode()));
		    formBean.setStrFinEndDate(mcu.getStrFinancialEndDate(formBean.getStrStoreId() , formBean.getStrHospitalCode()));
			
		   
		   
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrFinStartDate(formBean.getStrFinStartDate());
			vo.setStrFinEndDate(formBean.getStrFinEndDate());
			
			vo.setStrItemCatNo(formBean.getStrItemCatNo());
				
			bo.goView(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			vo.getStrInstallationDtlWs().beforeFirst();

			String strHlp = InstallationTransHLP.getInstallationDetails(vo.getStrInstallationDtlWs(), formBean.getStrFinStartDate() , formBean.getStrFinEndDate());
			
			formBean.setStrInstallationViewDetails(strHlp);
			
			////System.out.println("strHlp-->"+strHlp);
			
		} catch (Exception e) {
		e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "InstallationTransDATA->goView()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
		
		
		}
	}
}
