/**
 * 
 */
package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.AttachFileGlobal;
import mms.MmsConfigUtil;
import mms.transactions.bo.QualityCheckControlTransBO;
import mms.transactions.controller.fb.QualityCheckControlTransFB;
import mms.transactions.controller.hlp.QualityCheckControlTransHLP;
import mms.transactions.vo.QualityCheckControlTransVO;

import org.apache.struts.upload.FormFile;

/**
 * Developer : Tanvi Sappal
 * Date : 04/Jun/2009
 * Version : 1.0
 *
 */
public class QualityCheckControlTransDATA {
	
	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	public static void initialAdd(QualityCheckControlTransFB formBean,HttpServletRequest request) {
		QualityCheckControlTransVO vo=null;
		QualityCheckControlTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String cmb = "";
		
			
		try {
			vo = new QualityCheckControlTransVO();
			bo = new QualityCheckControlTransBO();
			
			hisutil = new HisUtil("mms", "QualityCheckControlTransDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
						
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrReSendFlg(formBean.getStrResendFlag());
			
			// Calling BO Method	
			bo.initialAdd(vo);			
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			if (vo.getStoreNameComboWS() != null && vo.getStoreNameComboWS().size() > 0) 
			{			
			    if(vo.getStoreNameComboWS().next())
			    {
			    	vo.setStrStoreId(vo.getStoreNameComboWS().getString(1));
			    	vo.getStoreNameComboWS().beforeFirst();
			    }
				cmb = hisutil.getOptionValue(vo.getStoreNameComboWS(), "", "", true);
			}
			else 
			{
				cmb = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrStoreNameCmb(cmb);
			
			// Calling Item Category Combo
			bo.getItemCatNo(vo);			
			
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			String strCmb="";
			if(vo.getItemCategoryComboWS()!=null && vo.getItemCategoryComboWS().size() > 0)
			{		
				if(vo.getItemCategoryComboWS().next())
				{
					vo.setStrItemCategoryNo(vo.getItemCategoryComboWS().getString(1));
					vo.getItemCategoryComboWS().beforeFirst();
				}
				strCmb = hisutil.getOptionValue(vo.getItemCategoryComboWS(),"", "", false);
			}
			else 
			{
				strCmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrItemCatNoCmb(strCmb);
			
			String strGroupNameValues="";
			
			if(!vo.getStrItemCategoryNo().equals("0") && !vo.getStrItemCategoryNo().equals(""))
				//Calling BO Method
				bo.getGroupName(vo);
			    bo.getCommitteeName(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getGroupComboWS()!=null && vo.getGroupComboWS().size() > 0){			
				strGroupNameValues = hisutil.getOptionValue(vo.getGroupComboWS(),"", "0^All", true);
			}else {
				strGroupNameValues = "<option value='0'>All</option>";
			}			
				
			formBean.setStrGroupNameCmb(strGroupNameValues);
			
			bo.getDrugList(vo);
			
			String cmbstr = "";
			
			if (vo.getWsDrugNameCombo() != null	&& vo.getWsDrugNameCombo().size() > 0)
			{

				cmbstr = hisutil.getOptionValue(vo.getWsDrugNameCombo(),"", "0^Select Value", false);

			} else {

				cmbstr = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrItemNameCmb(cmbstr);
			
            hisutil= new HisUtil("MMS Transactions", "QualityCkeckControlTransDATA");
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getCommitteTypeWS() != null && vo.getCommitteTypeWS().size() > 0) 
			{			
			     cmb = hisutil.getOptionValue(vo.getCommitteTypeWS(),"", "0^Select Value", true);
			}
			else 
			{
				 cmb = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrCommitteeTypeCmb(cmb);	
			formBean.setStrLabNameCombo(vo.getStrLabNameCombo());
			
												
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "QualityCheckControlTransDATA->initialAdd()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	public static void getDrugNameCmb(QualityCheckControlTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{

		String strmsgText = "";
		QualityCheckControlTransBO bo = null;
		QualityCheckControlTransVO vo = null;
		HisUtil hisutil = null;
		try {

			vo = new QualityCheckControlTransVO();
			bo = new QualityCheckControlTransBO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			String   strStoreId = (String) request.getParameter("storeId");
			String strReSendFlg = (String) request.getParameter("resenFlg");

			vo.setStrStoreId(strStoreId);
			vo.setStrHospitalCode(strHospitalCode);
            vo.setStrReSendFlg(strReSendFlg);
            
            
			bo.getDrugNameCmb(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "SampleSentTransDATA");

			String cmbstr = "";

			if (vo.getWsDrugNameCombo() != null	&& vo.getWsDrugNameCombo().size() > 0)
			{

				cmbstr = hisutil.getOptionValue(vo.getWsDrugNameCombo(),"", "0^Select Value", false);

			} else {

				cmbstr = "<option value='0'>Select Value</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"QualityCheckControlTransDATA->getCategoryCmb()", strmsgText);
			try {

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}
	}
	
	
	
	/**
	 * This function is used to display Item Category Name on the basis of store Name: 
	 * @param formBean
	 */
	public static void itemCatNo(QualityCheckControlTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		QualityCheckControlTransVO vo=null;
		QualityCheckControlTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String storeID = "";
		String strCmb = "";
		
			
		try {
			hisutil = new HisUtil("MMS","QualityCheckControlTransDATA");
			vo = new QualityCheckControlTransVO();
			bo = new QualityCheckControlTransBO();
							
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			storeID = (String) request.getParameter("storeid");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrStoreId(storeID);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(formBean.getStrStoreId());
				
			bo.getItemCatNo(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getItemCategoryComboWS()!=null
					&& vo.getItemCategoryComboWS().size() > 0){		
			/*	while(vo.getItemCategoryComboWS().next())
				{
				////System.out.println("vo.getItemCategoryComboWS().getString(1)"+vo.getItemCategoryComboWS().getString(1));
				////System.out.println("vo.getItemCategoryComboWS().getString(2)"+vo.getItemCategoryComboWS().getString(2));
			
				}*/
				strCmb = hisutil.getOptionValue(vo.getItemCategoryComboWS(),"", "", false);
			}else {
				strCmb = "<option value='0'>Select Value</option>";
			}
		
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "QualityCheckControlTransDATA->itemCatNo()", strmsgText);
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
	public static void groupName(QualityCheckControlTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		QualityCheckControlTransVO vo=null;
		QualityCheckControlTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNO = "";
		String strCmb = "";
		String cmb ="";
		
			
		try {
			hisutil = new HisUtil("MMS","QualityCheckControlTransDATA");
			vo = new QualityCheckControlTransVO();
			bo = new QualityCheckControlTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			itemCatNO = (String) request.getParameter("itemCatNo");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrItemCategoryNo(itemCatNO);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
				
			bo.getGroupName(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getGroupComboWS()!=null
					&& vo.getGroupComboWS().size() > 0){			
				strCmb = hisutil.getOptionValue(vo.getGroupComboWS(),
					"", "0^Select Value", true);
			}else {
				strCmb = "<option value='0'>Select Value</option>";
			}
			
			if (vo.getCommitteTypeWS() != null
					&& vo.getCommitteTypeWS().size() > 0) {			
			     cmb = hisutil.getOptionValue(vo.getCommitteTypeWS(),
					   "", "0^Select Value", true);
			}
			else {
				cmb = "<option value='0'>Select Value</option>";
			}
		
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strCmb+"^"+cmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "QualityCheckControlTransDATA->groupName()", strmsgText);
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
	public static void subGroupName(QualityCheckControlTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		QualityCheckControlTransVO vo=null;
		QualityCheckControlTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String groupId = "";
		String strSubGrpCmb = "";
		
				
			
		try {
			hisutil = new HisUtil("MMS","QualityCheckControlTransDATA");
			vo = new QualityCheckControlTransVO();
			bo = new QualityCheckControlTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			groupId = (String) request.getParameter("groupId");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrGroupId(groupId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrGroupId(formBean.getStrGroupId());
				
			bo.getSubGroupName(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			
			if(vo.getSubGroupCmboWS()!=null
					&& vo.getSubGroupCmboWS().size() > 0){			
				strSubGrpCmb = hisutil.getOptionValue(vo.getSubGroupCmboWS(),
					"", "0^Select Value", true);
			}else {
				strSubGrpCmb = "<option value='0'>All</option>";
			}
				
			

			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strSubGrpCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "QualityCheckControlTransDATA->subGroupName()", strmsgText);
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
	public static void genItemName(QualityCheckControlTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		QualityCheckControlTransVO vo=null;
		QualityCheckControlTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		//String storeID = "";
		String itemCatNO = "";
		String groupId = "";
		String subGrpId = "";
		String strGenItemCmb = "";	
			
		try {
			hisutil = new HisUtil("MMS","QualityCheckControlTransDATA");
			vo = new QualityCheckControlTransVO();
			bo = new QualityCheckControlTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			//storeID = (String) request.getParameter("storeid");
			itemCatNO = (String) request.getParameter("itemCatNo");
			groupId = (String) request.getParameter("groupId");
			subGrpId = (String) request.getParameter("subgrpid");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			//formBean.setStrStoreId(storeID);
			formBean.setStrItemCategoryNo(itemCatNO);
			formBean.setStrGroupId(groupId);
			formBean.setStrSubGroupId(subGrpId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			//vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());
				
						
			bo.getGenItemName(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getGenericItemNameComboWS()!=null
					&& vo.getGenericItemNameComboWS().size() > 0){			
				strGenItemCmb = hisutil.getOptionValue(vo.getGenericItemNameComboWS(),
					"", "0^Select Value", true);
			}else {
				strGenItemCmb = "<option value='0'>All</option>";
			}
			
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strGenItemCmb);	
				
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "QualityCheckControlTransDATA->genItemName()", strmsgText);
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
	public static void itemName(QualityCheckControlTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		QualityCheckControlTransVO vo=null;
		QualityCheckControlTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String storeID = "";
		String groupId = "";
		String stItemCmb = "";
		String itemCatNO = "";
		String subGrpId = "";
		String genItemID = "";
		
			
		try {
			hisutil = new HisUtil("MMS","QualityCheckControlTransDATA");
			vo = new QualityCheckControlTransVO();
			bo = new QualityCheckControlTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			storeID = (String) request.getParameter("storeid");
			itemCatNO = (String) request.getParameter("itemCatNo");
			groupId = (String) request.getParameter("groupId");
			subGrpId = (String) request.getParameter("subgrpid");
			genItemID = (String) request.getParameter("genitemid");
			
			String[] temp = genItemID.replace("^", "#").split("#");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrStoreId(storeID);
			formBean.setStrItemCategoryNo(itemCatNO);
			formBean.setStrGroupId(groupId);
			formBean.setStrSubGroupId(subGrpId);
			formBean.setStrGenericItemId(temp[0]);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());
			vo.setStrGenericItemId(formBean.getStrGenericItemId());
				
			bo.getItemName(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getItemBrandNameComboWS()!=null
					&& vo.getItemBrandNameComboWS().size() > 0){			
				stItemCmb = hisutil.getOptionValue(vo.getItemBrandNameComboWS(),
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
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "QualityCheckControlTransDATA->itemName()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	
	public static void getDrugBatchCmb(QualityCheckControlTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		String strmsgText = "";
		QualityCheckControlTransBO bo = null;
		QualityCheckControlTransVO vo = null;
		HisUtil hisutil = null;
		try {

			vo = new QualityCheckControlTransVO();
			bo = new QualityCheckControlTransBO();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();

			String strDrugBrandId = (String) request.getParameter("strDrugBrandId");
			String strReSendFlg = (String) request.getParameter("resenFlg");
			String strStoreId = (String) request.getParameter("storeId");

			vo.setStrStoreId(strStoreId);
			
			vo.setStrHospitalCode(strHospitalCode);
            vo.setStrReSendFlg(strReSendFlg);
			vo.setStrItemBrandId(strDrugBrandId);
			vo.setStrHospitalCode(strHospitalCode);

			bo.getDrugBatchCmb(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "ItemInventoryTransDATA");

			String cmbstr = "";

			if (vo.getBatchNoSerialNoComboWS() != null	&& vo.getBatchNoSerialNoComboWS().size() > 0)
			{

				cmbstr = hisutil.getOptionValue(vo.getBatchNoSerialNoComboWS(),"", "0^Select Value", false);

			} else {

				cmbstr = "<option value='0'>Select Value</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"QualityCheckControlTransDATA->getDrugBatchCmb()", strmsgText);
			try {

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}
	}
	
	/**
	 * This function is used to display Batch No on the basis of Item Name: 
	 * @param formBean
	 */
	public static void batchNo(QualityCheckControlTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		QualityCheckControlTransVO vo=null;
		QualityCheckControlTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemID = "";
		String itemCatNO = "";
		String storeID = "";
		String genItemID = "";
		String strCmb = "";
		//String strUnitCmb = "";
		String strSerialCmb = "";
		String[] temp = null;
		String[] strTemp = null;
		
			
		try {
			hisutil = new HisUtil("MMS","QualityCheckControlTransDATA");
			vo = new QualityCheckControlTransVO();
			bo = new QualityCheckControlTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			storeID = (String) request.getParameter("storeid");
			itemCatNO = (String) request.getParameter("itemCatNo");
			genItemID = (String) request.getParameter("genitemId");
			
			strTemp = genItemID.replace('^', '#').split("#");
					
			itemID = (String) request.getParameter("itemId");
			
			temp = itemID.replace('^', '#').split("#");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrItemBrandId(temp[0]);
			formBean.setStrIsConsumable(temp[1]);
			formBean.setStrGenericItemId(strTemp[0]);
			formBean.setStrItemCategoryNo(itemCatNO);
			formBean.setStrStockStatusCode("10");
			formBean.setStrStoreId(storeID);
			
			
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemBrandId(formBean.getStrItemBrandId());
			vo.setStrStockStatusCode(formBean.getStrStockStatusCode());
			vo.setStrGenericItemId(formBean.getStrGenericItemId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrStoreId(formBean.getStrStoreId());
		
			
			vo.setStrIsBatchNo(strTemp[1]);
			vo.setStrIsSlNo(strTemp[2]);
			
			bo.getBatcNo(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			
			if(vo.getStrItemCategoryNo().equals("10")){
				
				if(vo.getBatchNoSerialNoComboWS()!=null
						&& vo.getBatchNoSerialNoComboWS().size() > 0){			
					strCmb = hisutil.getOptionValue(vo.getBatchNoSerialNoComboWS(),
						"0", "0^Select Value", false);
				}else {
					strCmb = "<option value='0'>Select Value</option>";
				}
		         ////System.out.println("strCmb:::"+strCmb);
			  response.setHeader("Cache-Control", "no-cache");
			  response.getWriter().print(strCmb);
			  
			}else{
				
				if(vo.getStrIsBatchNo().equals("1")){
					
					if(vo.getBatchNoSerialNoComboWS()!=null
							&& vo.getBatchNoSerialNoComboWS().size() > 0){			
						strCmb = hisutil.getOptionValue(vo.getBatchNoSerialNoComboWS(),
							"0", "0^Select Value", false);
					}else {
						strCmb = "<option value='0'>Select Value</option>";
					}
					
				}
				
				if(vo.getStrIsSlNo().equals("1")){
					if(vo.getItemSlNoWS()!=null
							&& vo.getItemSlNoWS().size() > 0){			
						strSerialCmb = hisutil.getOptionValue(vo.getItemSlNoWS(),
							"0", "0^Select Value", false);
					}else {
						strSerialCmb = "<option value='0'>Select Value</option>";
					}
				}
				
				  response.setHeader("Cache-Control", "no-cache");
				  response.getWriter().print(strCmb+"@"+strSerialCmb);
				
			
			}					
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "QualityCheckControlTransDATA->groupName()", strmsgText);
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
		public static void unitName(QualityCheckControlTransFB formBean,HttpServletRequest request,
				HttpServletResponse response) {
			QualityCheckControlTransVO vo=null;
			QualityCheckControlTransBO bo= null;
			HisUtil hisutil = null;
			String hosCode = "";
			String seatid = "";
			String itemID = "";
			String strUnitCmb = "";
			String[] temp = null;
			
				
			try {
				hisutil = new HisUtil("MMS","QualityCheckControlTransDATA");
				vo = new QualityCheckControlTransVO();
				bo = new QualityCheckControlTransBO();
				vo.setStrModuleId(MmsConfigUtil.MODULE_ID);
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				seatid = request.getSession().getAttribute("SEATID").toString();
				
				
				itemID = (String) request.getParameter("itemId");
				
				//temp = itemID.replace('^', '#').split("#");
				
				formBean.setStrSeatId(seatid);
				formBean.setStrHospitalCode(hosCode);
				//formBean.setStrItemBrandId(temp[0]);
				//formBean.setStrIsConsumable(temp[1]);
				//formBean.setStrConsumedQtyUnitId(temp[3]);//Inventory Unit Id
				////System.out.println("Inventory Unit ID==>"+temp[3]);		
				
				vo.setStrHospitalCode(hosCode);
				vo.setStrSeatId(seatid);
				vo.setStrItemId(itemID);
				
				/*if(temp.length==4){
					formBean.setStrConsumedQtyUnitId(temp[3]);//Inventory Unit Id
				}else{
					formBean.setStrConsumedQtyUnitId("1");
				}*/
				//vo.setStrConsumedQtyUnitId(formBean.getStrConsumedQtyUnitId());
				
				bo.getUnitName(vo);
				
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}

				
				if(vo.getUnitNameWS()!=null
						&& vo.getUnitNameWS().size() > 0){			
					strUnitCmb = hisutil.getOptionValue(vo.getUnitNameWS(),
						vo.getStrUnitRateID(), "", false);
				}else {
					strUnitCmb = "<option value='0'>Select Value</option>";
				}
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strUnitCmb);
				
									
			} catch (Exception e) {
				e.printStackTrace();
				String strmsgText = e.getMessage();
				HisException eObj = new HisException("mms", "QualityCheckControlTransDATA->unitName()", strmsgText);
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
	 * This function is used to set Committee Name required to display on main page 
	 * @param formBean
	 */
	public static void committeeName(QualityCheckControlTransFB formBean,HttpServletRequest request) {
		QualityCheckControlTransVO vo=null;
		QualityCheckControlTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String cmb = "";
		
			
		try {
			vo = new QualityCheckControlTransVO();
			bo = new QualityCheckControlTransBO();
							
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
				
			bo.getCommitteeName(vo);
			
			hisutil= new HisUtil("MMS Transactions", "QualityCkeckControlTransDATA");
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getCommitteTypeWS() != null
					&& vo.getCommitteTypeWS().size() > 0) {			
			     cmb = hisutil.getOptionValue(vo.getCommitteTypeWS(),
					   "", "0^Select Value", true);
			}
			else {
				cmb = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrCommitteeTypeCmb(cmb);			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "QualityCheckControlTransDATA->committeeName()", strmsgText);
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
	 * This function is used to get Member Detail on the basis of Committee Name.
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getMemberDtl(QualityCheckControlTransFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
		String strmsgText = "";
		QualityCheckControlTransVO vo=null;
		QualityCheckControlTransBO bo= null;
		String result="";
		try
		{
			
			vo=new QualityCheckControlTransVO();
			bo=new QualityCheckControlTransBO();
			
			vo.setStrCommitteeTypeId(request.getParameter("committeType"));
			vo.setStrItemCategoryNo(request.getParameter("itemCategNo"));
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			bo.getMemberDetails(vo);
			
			formBean.setCommitteMemberWS(vo.getCommitteMemberWS());
			
			result=QualityCheckControlTransHLP.createMemberDetails(formBean);
			
			if(vo.getStrMsgType().equals("1")){
				throw new Exception(vo.getStrMsgString());
			}
			
			response.getWriter().print(result);
			
		}
		catch(Exception e)
		{
			strmsgText = "SampleRegisterTransDATA.getMemberDtl() --> "
				+ e.getMessage();
			HisException eObj = new HisException("IPD", "QualityCheckControlTransDATA->getMemberDtl()", strmsgText);
		    String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
		    try
		    {
		    	response.getWriter().print(response1);
		    	eObj=null;
		    }
		    catch(Exception e1)
		    {
		    	
		    }

		}
	}
	
	/**
	 * This function invoke TransferObjectFactory.populateData() to transfer the values of all attributes of form bean into vo and the invoke bo insert method
	 * @param formBean
	 */
	public static void insert(QualityCheckControlTransFB formBean,HttpServletRequest request)
	{
		QualityCheckControlTransVO vo=null;
		QualityCheckControlTransBO bo= null;
		MmsConfigUtil mcu = null;
		String temp1[] = null;
		String temp[] = null;
		HisUtil hisutil=null;
		AttachFileGlobal fs=null;
		String strFileName="";
		String strCurrentDate="";
		String strFileExt="";
		try
			{
			  bo = new QualityCheckControlTransBO();
			  vo = new QualityCheckControlTransVO();
			  mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  hisutil=new HisUtil("mms", "QualityCheckControlTransDATA");
			  fs=new AttachFileGlobal();
			  
			  strCurrentDate = hisutil.getASDate("dd-MMM-yyyy");
				
				String strFinancialStartYear = mcu.getStrFinancialStartDate(formBean.getStrStoreId() , request.getSession().getAttribute("HOSPITAL_CODE").toString());
				String  strFinancialEndYear = mcu.getStrFinancialEndDate(formBean.getStrStoreId() , request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				
				/* Compatibility Code End */
				formBean.setStrFinancialStartYear(strFinancialStartYear);
				formBean.setStrFinancialEndYear(strFinancialEndYear);
			  formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			  formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  
			  
			  FormFile myFile = formBean.getStrLocation();
			  
			  formBean.setStrStockStatusCode("10");
			  formBean.setStrItemCategoryNo("10");
			  String strDescription = "Through QC Detail (Offline) >> HQ Name : "+formBean.getStrStoreName()+" To Lab Name:"+formBean.getStrLabName();
			  formBean.setStrDescription(strDescription);
			  formBean.setStrRequestType("73");
  
			  
			  vo = (QualityCheckControlTransVO) TransferObjectFactory.populateData("mms.transactions.vo.QualityCheckControlTransVO", formBean);
			  		
			   myFile = formBean.getStrLocation();
			 
				vo.setStrFileName(strFileName);
				vo.setStrReceiveDate(formBean.getStrReceiveDate());
			    vo.setStrReceiveDate(formBean.getStrReceiveDate());
				strFileExt=myFile.getFileName();
				temp=strFileExt.replace('.', '#').split("#");
				strFileExt=temp[temp.length-1];
				 strFileName=vo.getStrStoreId()+"_"+formBean.getStrGenericItemId()+"_"+vo.getStrHospitalCode()+"_"+strCurrentDate+"."+strFileExt;
				 vo.setStrFileName(strFileName);
				 
			  bo.insert(vo);
			  if(vo.getStrMsgType().equals("1"))
			  {
				  if(vo.getStrMsgString().split("\\##")[2].equals("999"))
				    {
	    				////System.out.println("In Insufficent Drug:::"+vo.getStrMsgString().split("\\##")[1]);
					    formBean.setStrErrorMsg(vo.getStrMsgString().split("\\##")[1]);
				    }
					else
					{
						formBean.setStrErrorMsg(vo.getStrMsgString());
					    throw new Exception(vo.getStrMsgString());
					}	
			  }
			  else{
				  formBean.setStrNoramalMsg("Record saved successfully");
			//	  filePath=mcu.getStrCommitteeFilePath();
				  //fs.saveFile(myFile.getFileData(), strFileName); 
			  }
			 
			 
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				String strmsgText = e.getMessage();
				HisException eObj = new HisException("Mms Transaction", "QualityCheckControlTransDATA","Quality Check Control.QualityCheckControlTransDATA->insert()" + strmsgText);
				formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
			}
			finally {
				if (vo != null) vo = null;
				if(formBean != null) formBean = null;
			}
		}

	public static void getStoreName(QualityCheckControlTransFB formBean,HttpServletRequest request) {
		QualityCheckControlTransVO vo=null;
		QualityCheckControlTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String cmb = "";
		
			
		try {
			vo = new QualityCheckControlTransVO();
			bo = new QualityCheckControlTransBO();
			
			hisutil = new HisUtil("mms", "QualityCheckControlTransDATA");
			
						
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
				
			bo.getStoreName(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if (vo.getStoreNameWS() != null && vo.getStoreNameWS().size() > 0) 
			{			
				if(vo.getStoreNameWS().next())
				{
					vo.setStrStoreId(vo.getStoreNameWS().getString(1));
					vo.getStoreNameWS().beforeFirst();
				}
				cmb = hisutil.getOptionValue(vo.getStoreNameWS(),"", "", true);
			}
			else {
				cmb = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrStoreCmb(cmb);
			
			bo.getItemCategory(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			String strCmb="";
			if(vo.getItemCategoryWS()!=null
					&& vo.getItemCategoryWS().size() > 0){		
				strCmb = hisutil.getOptionValue(vo.getItemCategoryWS(),"", "", false);
			}else {
				strCmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrItemCatNoCmb(strCmb);
			
			
					
												
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "QualityCheckControlTransDATA->getStoreName()", strmsgText);
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
	 * This function is used to set iItem Category No required to display on View page 
	 * @param formBean
	 */
	public static void getitemCategory(QualityCheckControlTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		QualityCheckControlTransVO vo=null;
		QualityCheckControlTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String strItemCmb = "";
		
			
		try {
			vo = new QualityCheckControlTransVO();
			bo = new QualityCheckControlTransBO();
			hisutil = new HisUtil("mms", "QualityCheckControlTransDATA");
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			String strStoreId = (String) request.getParameter("storeid");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrStoreId(strStoreId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(formBean.getStrStoreId());
				
			bo.getItemCategory(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			
			if(vo.getItemCategoryWS()!=null
					&& vo.getItemCategoryWS().size() > 0){		
				strItemCmb = hisutil.getOptionValue(vo.getItemCategoryWS(),"", "", false);
			}else {
				strItemCmb = "<option value='0'>Select Value</option>";
			}
			
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemCmb);
					
				}catch(Exception e){
					
				}
			
												
		} catch (Exception e) {
		e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "QualityCheckControlTransDATA->getitemCategory()", strmsgText);
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
	 * This function is used to set exist value required to display on view page 
	 * @param formBean
	 */
	public static void goView(QualityCheckControlTransFB formBean,HttpServletRequest request) {
		QualityCheckControlTransVO vo=null;
		QualityCheckControlTransBO bo= null;
	
		String hosCode = "";
		
		MmsConfigUtil mcu = null;
		
			
		try {
			////System.out.println("Inside DATA Class");
			vo = new QualityCheckControlTransVO();
			bo = new QualityCheckControlTransBO();
	
			
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			formBean.setStrHospitalCode(hosCode);
			 ////System.out.println("formBean.getStrStoreId()"+formBean.getStrStoreId());
			formBean.setStrFinStartDate(mcu.getStrFinancialStartDate(formBean.getStrStoreId() , formBean.getStrHospitalCode()));
		    formBean.setStrFinEndDate(mcu.getStrFinancialEndDate(formBean.getStrStoreId() , formBean.getStrHospitalCode()));
			
		   
		   
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrHospitalCode(hosCode);
			vo.setStrFinStartDate(formBean.getStrFinStartDate());
			vo.setStrFinEndDate(formBean.getStrFinEndDate());
			vo.setStrFromDate(formBean.getStrFromDate());
			vo.setStrToDate(formBean.getStrToDate());
			
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
				
			bo.goView(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			vo.getQualityViewWS().beforeFirst();
			////System.out.println("getQualityViewWS-->"+vo.getQualityViewWS());
			String strHlp = QualityCheckControlTransHLP.getViewSampleSentDetails(vo);
			
			formBean.setStrQualityViewDetails(strHlp);
			
			////System.out.println("strHlp-->"+strHlp);
			
		} catch (Exception e) {
		e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "QualityCheckControlTransDATA->goView()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
		
		
		}
	}
	
}
