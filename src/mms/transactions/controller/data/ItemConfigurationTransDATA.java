package mms.transactions.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.transactions.bo.ItemConfigurationTransBO;
import mms.transactions.bo.ItemConfigurationTransBO;
import mms.transactions.controller.fb.ItemConfigurationTransFB;
import mms.transactions.controller.fb.ItemConfigurationTransFB;
import mms.transactions.controller.hlp.ItemConfigurationTransHLP;
import mms.transactions.vo.ItemConfigurationTransVO;
import mms.transactions.vo.ItemConfigurationTransVO;

public class ItemConfigurationTransDATA {
	
	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	public static void initialAdd(ItemConfigurationTransFB formBean,HttpServletRequest request) {
		ItemConfigurationTransVO vo=null;
		ItemConfigurationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String strStoreName ,strItemCmb;
		
			
		try {
			vo = new ItemConfigurationTransVO();
			bo = new ItemConfigurationTransBO();
			
			hisutil = new HisUtil("mms", "ItemConfigurationTransDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
						
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			
				vo.setStrItemCategoryNo("1");
			bo.initialAdd(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if (vo.getStrStoreWs() != null	&& vo.getStrStoreWs().size() > 0) {			
				strStoreName = hisutil.getOptionValue(vo.getStrStoreWs(),"0", "0^All", true);
			}
			else {
				strStoreName = "<option value='0'>Select Value</option>";
			}
			formBean.setStrStoreValues(strStoreName);
			
			
			
			// Calling BO Method
			bo.getItemName(vo);	 // Pkg_Mms_View.proc_itembrand_list [ Mode -  7 ]			

			while(vo.getItemWS().next())
			{
				vo.setStrGenItemId(vo.getItemWS().getString(1));
			}
			vo.getItemWS().beforeFirst();
			
			if(vo.getItemWS()!=null && vo.getItemWS().size() > 0)
			{			
				strItemCmb = hisutil.getOptionValue(vo.getItemWS(),"", "0^All", true);
			}
			else 
			{
				strItemCmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrItemCmb(strItemCmb);
			formBean.setStrItemBrandCombo(strItemCmb);
			formBean.setStrItemCategoryNo("1");
			
												
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ItemConfigurationTransDATA->initialAdd()", strmsgText);
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
	public static void genItemName(ItemConfigurationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		ItemConfigurationTransVO vo=null;
		ItemConfigurationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNO = "";
		String groupId = "";
		String subGrpId = "";
		String strGenItemCmb = "";	
			
		try {
			hisutil = new HisUtil("MMS","ItemConfigurationTransDATA");
			vo = new ItemConfigurationTransVO();
			bo = new ItemConfigurationTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
						
			itemCatNO = (String) request.getParameter("itemCatNo");
			groupId = (String) request.getParameter("groupId");
			subGrpId = (String) request.getParameter("subgrpid");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrItemCategoryNo(itemCatNO);
			formBean.setStrGroupId(groupId);
			formBean.setStrSubGroupId(subGrpId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());
				
						
			bo.getGenItemName(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getGenItemWS()!=null
					&& vo.getGenItemWS().size() > 0){			
				strGenItemCmb = hisutil.getOptionValue(vo.getGenItemWS(),
					"", "", true);
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
			HisException eObj = new HisException("mms", "ItemConfigurationTransDATA->genItemName()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

		     } catch (Exception e1) {
				
			}
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
	public static void itemName(ItemConfigurationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		ItemConfigurationTransVO vo=null;
		ItemConfigurationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String groupId = "";
		String stItemCmb = "";
		String itemCatNO = "";
		String subGrpId = "";
		String genItemID = "";
		String storeId="";
			
		try {
			hisutil = new HisUtil("MMS","ItemConfigurationTransDATA");
			vo = new ItemConfigurationTransVO();
			bo = new ItemConfigurationTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			itemCatNO = (String) request.getParameter("itemCatNo");
			//genItemID = (String) request.getParameter("genitemid");
			//groupId =(String) request.getParameter("groupId");
			//subGrpId =(String) request.getParameter("subgrpid");
			
			storeId=(String) request.getParameter("storeId");
			
			String temp[] = genItemID.replace('^', '#').split("#");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			formBean.setStrItemCategoryNo(itemCatNO);
			formBean.setStrStoreId(storeId);
			//formBean.setStrGroupId(groupId);
			//formBean.setStrSubGroupId(subGrpId);
			//formBean.setStrGenItemId(temp[0]);
			formBean.setStrIsSachet("0");
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrStoreId(storeId);
			vo.setStrGroupId("0");
			vo.setStrSubGroupId("0");
			vo.setStrGenItemId("0");
				
			bo.getItemName(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getItemWS()!=null	&& vo.getItemWS().size() > 0){			
				stItemCmb = hisutil.getOptionValue(vo.getItemWS(),"", "", true);
			}else {
				stItemCmb = "<option value='0'>All</option>";
			}			
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(stItemCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ItemConfigurationTransDATA->itemName()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

		     } catch (Exception e1) {
				
			}
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	

	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	public static void searchStockDtl(ItemConfigurationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		ItemConfigurationTransVO vo=null;
		ItemConfigurationTransBO bo= null;
	
		String hosCode = "";
		String seatid = "";
		String genItemID = "";
		String ItemID = "";
		String itemCatNO = "";
		String batchNo = "";
		String itemslno = "";
		String storeId="";
		
		
			
		try {
			vo = new ItemConfigurationTransVO();
			bo = new ItemConfigurationTransBO();
			
	
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			
			itemCatNO = (String) request.getParameter("itemCatNo");
			ItemID = (String) request.getParameter("itemId");
			storeId = (String) request.getParameter("storeid");
						
			formBean.setStrItemCategoryNo(itemCatNO);
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrStockStatusCode("0");
			formBean.setStrStoreId(storeId);		
			formBean.setStrItemId(ItemID);			
			formBean.setStrReservedFlag("1");
			formBean.setStrReqTypeId("34");			
			vo.setStrReservedFlag(formBean.getStrReservedFlag());
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);			
			vo.setStrItemId(formBean.getStrItemId());		
			vo.setStrReqTypeId(formBean.getStrReqTypeId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrStoreId(storeId);				
			bo.searchStockDtl(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			

			 String strHlp1 = ItemConfigurationTransHLP.getItemDtls(vo,vo.getStockDetailsWS());				
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strHlp1);				
			

			
		} catch (Exception e) {
		e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ItemConfigurationTransDATA->searchStockDtl()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

		     } catch (Exception e1) {
				
			}
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
	
	
		}
	}
	
	public static void getStoreList(ItemConfigurationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		ItemConfigurationTransVO vo=null;
		ItemConfigurationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String strCatId = "";
		String itemCatCmb = "";
		String strStoreName ,strItemCmb;
				
			
		try {
			hisutil = new HisUtil("MMS","ItemConfigurationTransDATA");
			vo = new ItemConfigurationTransVO();
			bo = new ItemConfigurationTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			strCatId = formBean.getStrItemCategoryNo();
			
			
			
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCategoryNo(strCatId);
				
			bo.initialAdd(vo);			
			

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if (vo.getStrStoreWs() != null	&& vo.getStrStoreWs().size() > 0) {			
				strStoreName = hisutil.getOptionValue(vo.getStrStoreWs(),"0", "0^All", true);
			}
			else {
				strStoreName = "<option value='0'>Select Value</option>";
			}
			formBean.setStrStoreValues(strStoreName);
			
			
			
			// Calling BO Method
			bo.getItemName(vo);				

			while(vo.getItemWS().next())
			{
				vo.setStrGenItemId(vo.getItemWS().getString(1));
			}
			vo.getItemWS().beforeFirst();
			
			if(vo.getItemWS()!=null && vo.getItemWS().size() > 0)
			{			
				strItemCmb = hisutil.getOptionValue(vo.getItemWS(),"", "0^All", true);
			}
			else 
			{
				strItemCmb = "<option value='0'>Select Value</option>";
			}
			//formBean.setStrItemCmb(strItemCmb);
			
			// response.setHeader("Cache-Control", "no-cache");
			//  response.getWriter().print(strStoreName+"@"+strItemCmb);
				formBean.setStrItemBrandCombo(strItemCmb);
				formBean.setStrItemCategoryNo(strCatId);
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ItemConfigurationTransDATA->subGroupName()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

		     } catch (Exception e1) {
				
			}
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	
	/**This method is used to insert the Miscellaneous Consumptions in database for this activity this function call
	 * the insertMissConsumpRecord()method which is define in ItemConfigurationTransBO java file.
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void SAVE(
			ItemConfigurationTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ItemConfigurationTransBO bo = null;
		ItemConfigurationTransVO vo = null;		
	
		String strmsgText = "";

		try {
			bo = new ItemConfigurationTransBO();

			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());		
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());				
						
			vo = (ItemConfigurationTransVO) TransferObjectFactory.populateData("mms.transactions.vo.ItemConfigurationTransVO", formBean);
			
						
			
			bo.SAVE(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				
				
					formBean.setStrErrorMsg(vo.getStrMsgString());
				    throw new Exception(vo.getStrMsgString());
					
			}

			else {
				formBean.setStrNoramalMsg("Data Updated Successfully !!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "ItemConfigurationTransDATA.SAVE(vo) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","ItemConfigurationTransDATA->SAVE()",strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			
		}

	}
}
