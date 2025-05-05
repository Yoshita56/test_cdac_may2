/**
 * 
 */
package mms.transactions.controller.data;

import java.util.HashMap;
import java.util.Map;

import hisglobal.ReportUtil;
import hisglobal.backutil.HelperMethods;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.UtilityGenerationTransBO;
import mms.transactions.controller.fb.IndentPrintTransFB;
import mms.transactions.controller.fb.UtilityGenerationTransFB;
import mms.transactions.controller.hlp.UtilityGenerationTransHLP;
import mms.transactions.vo.UtilityGenerationTransVO;

/**
 * @author user
 *
 */
public class UtilityGenerationTransDATA {
	
	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	public static void initialAdd(UtilityGenerationTransFB formBean,HttpServletRequest request) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String strStoreName ,strItemCmb;
		String[] strTemp=null,combo=null;
			
		try {
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
			
			hisutil = new HisUtil("mms", "UtilityGenerationTransDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			combo = request.getParameterValues("combo");
		       strTemp =  combo[0].split("\\^");
		       formBean.setStrStoreId(strTemp[0]);
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemCategoryNo("1");
			formBean.setStrItemCategoryNo("1");
			
												
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->initialAdd()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	public static void getPatDtl(UtilityGenerationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
	
		String hosCode = "";
		String seatid = "";
		try {
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
			
	
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
						
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrPuk(formBean.getStrPuk());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrCtDate(formBean.getStrCtDate());
			vo.setStrUtilNo(formBean.getStrUtilNo());
			vo.setStrCmbIndentNo(formBean.getStrCmbIndentNo());
			formBean.setStrIndentDtl1("");
			formBean.setStrUtilityDtl1("");
			vo.setStrStoreId(formBean.getStrStoreId());
			bo.getPatDtl(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
				 String strHlp1 = UtilityGenerationTransHLP.createStockDetails1(vo,vo.getStockDetailsWS());
				 formBean.setStrPatDetails(strHlp1);
					formBean.setStrUtilityDtl1("");
					formBean.setStrIndentDtl1("");
				 if(strHlp1 != "")
					 formBean.setStrPatDetails1(strHlp1.substring(0,50));
				 
				 formBean.setStrBalanceAmount(vo.getStrBalanceAmount());
				 formBean.setStrPatAccountNo(vo.getStrPatAccountNo());
			
		} catch (Exception e) {
		e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->searchStockDtl()", strmsgText);
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
	
	
	public static void getUtilityNo(UtilityGenerationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
		String temp = "";
		String hosCode = "";
		String seatid = "";
		HisUtil util = new HisUtil("mms", "UtilityGenerationTransDATA");
		try {
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
			
	
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
						
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrPuk(formBean.getStrPuk());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrCtDate(formBean.getStrCtDate());
			bo.getUtilityNo(vo);			
			temp=util.getOptionValue(vo.getUtilityNoWS(), "0","0^Select Value",false);
			vo.setStrUtilNo(temp);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
				 String strHlp1 = UtilityGenerationTransHLP.createUtilityNo(vo,vo.getUtilityNoWS());
				 formBean.setStrUtilityDtl(strHlp1);
				 if(strHlp1 != "")
					 formBean.setStrUtilityDtl1(strHlp1.substring(0,50));
			
		} catch (Exception e) {
		e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->searchStockDtl()", strmsgText);
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
	
	public static void getIndentNo(UtilityGenerationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
		String temp = "";
		String hosCode = "";
		String seatid = "";
		HisUtil util = new HisUtil("mms", "UtilityGenerationTransDATA");
		try {
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
			
	
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
						
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrPuk(formBean.getStrPuk());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrCtDate(formBean.getStrCtDate());
			bo.getIndentNo(vo);			
			temp=util.getOptionValue(vo.getIndentNoWS(), "0","0^Select Value",false);
			vo.setStrCmbIndentNo(temp);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
				 String strHlp1 = UtilityGenerationTransHLP.createIndentNo(vo,vo.getIndentNoWS());
				 formBean.setStrIndentDtl(strHlp1);
				 if(strHlp1 != "")
					 formBean.setStrIndentDtl1(strHlp1.substring(0,50));
			
		} catch (Exception e) {
		e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->searchStockDtl()", strmsgText);
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
	
	public static void save(UtilityGenerationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
	
		String hosCode = "";
		String seatid = "";
		try {
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
			
	
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
						
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			HelperMethods.populate(vo,formBean);
			bo.save(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			/*else
			{
				String strPrintHLP=UtilityGenerationTransHLP.getPrintDtl(vo);
				formBean.setStrPrintDtls(strPrintHLP);
				formBean.setStrPrintFlag("1");
			}
			*/
			
		} catch (Exception e) {
			
		e.printStackTrace();
			String strmsgText = e.getMessage();
			if(strmsgText.contains("Patient Account Balance Going To Be Insufficient.Please Deposit Part Payment!!"))
				formBean.setStrErrorMsg("Patient Account Balance Going To Be Insufficient.Please Deposit Part Payment!!");
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->searchStockDtl()", strmsgText);
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
	
	public static void modifysave(UtilityGenerationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
	
		String hosCode = "";
		String seatid = "";
		try {
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
			
	
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
						
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			HelperMethods.populate(vo,formBean);
			bo.save(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			else
			{
				String strPrintHLP=UtilityGenerationTransHLP.getPrintDtl(vo);
				formBean.setStrPrintDtls(strPrintHLP);
				formBean.setStrPrintFlag("1");
			}
			
			
		} catch (Exception e) {
		e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->searchStockDtl()", strmsgText);
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
	
	/**
	 * This function is used to display Item Category Name on the basis of Store Id
	 *  
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getItemCat(UtilityGenerationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String strStoreId = "";
		String itemCatCmb = "";
		
				
			
		try {
			hisutil = new HisUtil("MMS","UtilityGenerationTransDATA");
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			strStoreId = (String) request.getParameter("storeId");
			
			
			
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);
				
			bo.itemCategoryName(vo);			
			

			if (vo.getItemCategoryWS() != null && vo.getItemCategoryWS().size() > 0) 
			{			
				//vo.getItemCategoryWS().next(); 
				//String tmp = vo.getItemCategoryWS().getString(1);
				//String tmp1 = vo.getItemCategoryWS().getString(1) +"^"+vo.getItemCategoryWS().getString(2);
				//vo.getItemCategoryWS().beforeFirst();
				itemCatCmb = hisutil.getOptionValue(vo.getItemCategoryWS(), "0", "0^Select Value",true);
			}
			else {
				itemCatCmb = "<option value='0'>All</option>";
			}
			
				
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(itemCatCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->subGroupName()", strmsgText);
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
	 * This function is used to display Group Name on the basis of ItemCategory Name: 
	 * @param formBean
	 */
	public static void groupName(UtilityGenerationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNO = "";
		String strGrpCmb = "";
		
			
		try {
			hisutil = new HisUtil("MMS","UtilityGenerationTransDATA");
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
		
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
			
			if(vo.getGroupWS()!=null
					&& vo.getGroupWS().size() > 0){			
				strGrpCmb = hisutil.getOptionValue(vo.getGroupWS(),"","", true);
			}else {
				strGrpCmb = "<option value='0'>Select Value</option>";
			}
			
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strGrpCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->groupName()", strmsgText);
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
	 * This function is used to display SubGroup Name on the basis of Group Name: 
	 * @param formBean
	 */
	public static void subGroupName(UtilityGenerationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String groupId = "";
		String strSubGrpCmb = "";
		
				
			
		try {
			hisutil = new HisUtil("MMS","UtilityGenerationTransDATA");
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
		
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
			
			
			if(vo.getSubGroupWS()!=null
					&& vo.getSubGroupWS().size() > 0){			
				strSubGrpCmb = hisutil.getOptionValue(vo.getSubGroupWS(),
					"", "", true);
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
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->subGroupName()", strmsgText);
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
	 * This function is used to display GenItem Name on the basis of StoreId,ItemCtNo,GrpId,SubGrpId: 
	 * @param formBean
	 */
	public static void genItemName(UtilityGenerationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNO = "";
		String groupId = "";
		String subGrpId = "";
		String strGenItemCmb = "";	
			
		try {
			hisutil = new HisUtil("MMS","UtilityGenerationTransDATA");
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
		
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
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->genItemName()", strmsgText);
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
	public static void itemName(UtilityGenerationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
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
			hisutil = new HisUtil("MMS","UtilityGenerationTransDATA");
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
		
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
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->itemName()", strmsgText);
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
	 * This function is used to display Batch No on the basis of Item Name: 
	 * @param formBean
	 */
	public static void batchSerialNo(UtilityGenerationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String genItemID = "";
		String strBatchCmb = "";
		String strSerialCmb = "";
		String itemCatNO = "";
		String itemId = "";
		String[] temp = null;
		
			
		try {
			hisutil = new HisUtil("MMS","UtilityGenerationTransDATA");
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			itemCatNO = (String) request.getParameter("itemCatNo");
			genItemID = (String) request.getParameter("genitemId");
			itemId = (String) request.getParameter("itemId");
			temp = genItemID.replace('^', '#').split("#");
			
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrGenItemId(temp[0]); 
			formBean.setStrItemCategoryNo(itemCatNO);
			//formBean.setStrItemId(itemId);
			
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrGenItemId(formBean.getStrGenItemId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			//vo.setStrItemId(itemId)[0];
			
			
			vo.setStrIsBatchNo(temp[1]);
			vo.setStrIsSlNo(temp[2]);
			
			bo.getBatchSerialNo(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			
			if(vo.getStrItemCategoryNo().equals("10"))
			{
				if(vo.getBatchNoWS()!=null	&& vo.getBatchNoWS().size() > 0)
				{			
					strBatchCmb = hisutil.getOptionValue(vo.getBatchNoWS(),	"0", "0^All", false);
				}
				else 
				{
					strBatchCmb = "<option value='0'>All</option>";
				}
		
			  response.setHeader("Cache-Control", "no-cache");
			  response.getWriter().print(strBatchCmb);
			}
			else
			{
				
				if(vo.getStrIsBatchNo().equals("1"))
				{
					if(vo.getBatchNoWS()!=null && vo.getBatchNoWS().size() > 0){			
						strBatchCmb = hisutil.getOptionValue(vo.getBatchNoWS(),	"0", "0^Select Value", false);
					}
					else 
					{
						strBatchCmb = "<option value='0'>Select Value</option>";
					}
					
				}
				
				if(vo.getStrIsSlNo().equals("1"))
				{
					if(vo.getItemSlNoWS()!=null	&& vo.getItemSlNoWS().size() > 0)
					{			
						strSerialCmb = hisutil.getOptionValue(vo.getItemSlNoWS(), "0", "0^Select Value", false);
					}
					else
					{
						strSerialCmb = "<option value='0'>Select Value</option>";
					}
				}
					/*//System.out.println("strBatchCmb in else part-->"+strBatchCmb);
					//System.out.println("strSerialCmb in else part-->"+strSerialCmb);*/
					
				  response.setHeader("Cache-Control", "no-cache");
				  response.getWriter().print(strBatchCmb+"^"+strSerialCmb);
				}
			
				
								
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->batchSerialNo()", strmsgText);
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
	public static void searchStockDtl(UtilityGenerationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
	
		String hosCode = "";
		String seatid = "";
		String genItemID = "";
		String ItemID = "";
		String itemCatNO = "";
		String batchNo = "";
		String itemslno = "";
		String storeId="";
		
		
			
		try {
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
			
	
			
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
		
			//formBean.setStrItemId(ItemID);
			
			formBean.setStrReservedFlag("1");
			
//			if(formBean.getStrItemCategoryNo().equals("10")){
//				formBean.setStrItemSlNo("0");
//			}else{
//				formBean.setStrItemSlNo(itemslno);
//			}
			formBean.setStrReqTypeId("34");
			
			vo.setStrReservedFlag(formBean.getStrReservedFlag());
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			//vo.setStrGenItemId(formBean.getStrGenItemId());
			//vo.setStrItemId(formBean.getStrItemId());
		//	vo.setStrBatchNo(formBean.getStrBatchNo());
		//	vo.setStrItemSlNo(formBean.getStrItemSlNo());
			vo.setStrReqTypeId(formBean.getStrReqTypeId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			//vo.setStrBatchNo(batchNo);
		//	vo.setStrItemSlNo(itemslno);
			vo.setStrStoreId(storeId);
				
			bo.searchStockDtl(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			

			
			if(vo.getStrItemCategoryNo().equals("1"))
			{
				 String strHlp1 = UtilityGenerationTransHLP.createStockDetails1(vo,vo.getStockDetailsWS());
				
				 response.setHeader("Cache-Control", "no-cache");
				  response.getWriter().print(strHlp1);
				  ////System.out.println("strHlp1-->"+strHlp1);
			}
			else
			{
				
				StringBuffer br = new StringBuffer();
				
				String strHlp1 = UtilityGenerationTransHLP.createStockDetails(vo,vo.getStockDetailsWS());
				br.append(strHlp1);
				/*if(vo.getEmplyeeStockDetailsWS().size()>0)
				{	
				String strHlp2 = UtilityGenerationTransHLP.createEmployeeStockDetails(vo,vo.getEmplyeeStockDetailsWS());
				br.append(strHlp2);
				}*/
				response.setHeader("Cache-Control", "no-cache");
				  response.getWriter().print(br.toString());
				  ////System.out.println("strHlp1-->"+br.toString());
				}
			
		} catch (Exception e) {
		e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->searchStockDtl()", strmsgText);
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
	
	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	/*public static void searchEmpStockDtl(UtilityGenerationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String genItemID = "";
		String ItemID = "";
		String batchNo = "";
		String itemslno = "";
			
		try {
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
			
			hisutil = new HisUtil("mms", "UtilityGenerationTransDATA");
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			genItemID = (String) request.getParameter("genitemId");
			ItemID = (String) request.getParameter("itemId");
			batchNo = (String) request.getParameter("batchno");
			itemslno = (String) request.getParameter("itemslno");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrGenItemId(genItemID);
			formBean.setStrItemId(ItemID);
			formBean.setStrBatchNo(batchNo);
			formBean.setStrItemSlNo(itemslno);
			formBean.setStrReqTypeId("34");
			formBean.setStrStoreId("0");
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrGenItemId(formBean.getStrGenItemId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrBatchNo(formBean.getStrBatchNo());
			vo.setStrItemSlNo(formBean.getStrItemSlNo());
			vo.setStrReqTypeId(formBean.getStrReqTypeId());
			
				
			bo.searchEmpStockDtl(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			String strHlp = UtilityGenerationTransHLP.createEmployeeStockDetails(vo.getEmplyeeStockDetailsWS());
			
			response.setHeader("Cache-Control", "no-cache");
			  response.getWriter().print(strHlp);
												
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->initialAdd()", strmsgText);
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
	}*/
	
	public static void getStoreList(UtilityGenerationTransFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		UtilityGenerationTransVO vo=null;
		UtilityGenerationTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String strCatId = "";
		String itemCatCmb = "";
		String strStoreName ,strItemCmb;
				
			
		try {
			hisutil = new HisUtil("MMS","UtilityGenerationTransDATA");
			vo = new UtilityGenerationTransVO();
			bo = new UtilityGenerationTransBO();
		
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
			HisException eObj = new HisException("mms", "UtilityGenerationTransDATA->subGroupName()", strmsgText);
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
	
	public static void showReport(UtilityGenerationTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();

		String reportFormat = "pdf";
		String strUtilityNo = "";
		String combo[] = null;
		MmsConfigUtil mmsConfig = null;
 //System.out.println("IN a data");
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			 mmsConfig = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String[] strChk = request.getParameterValues("chk");
			

			for (int i = 0, stopI = strChk.length; i < stopI; i++) {
				String[] strtemp = strChk[i].replace("@", "#").split("#");
				if (i == 0) {
					strUtilityNo = strUtilityNo + strtemp[0];

				} else {
					strUtilityNo = strUtilityNo + "," + strtemp[0];

				}
				
				
			}

			combo = request.getParameterValues("combo");

			String[] strTemp = combo[0].split("\\^");
			//String[] strTemp1 = combo[2].split("\\^");
			String strStoreId = strTemp[0];
			//String strReqTypeId = strTemp1[1];

	 //System.out.println("chk value----1--->"+strChk);
		 //System.out.println("strStoreId----2----->"+strStoreId);
		 ////System.out.println("strReqTypeId--3------->"+strReqTypeId);
		 //System.out.println("strUtilityNo------4--->"+strUtilityNo);


				String reportPath = "/mms/reports/utilityGeneration_mmsrpt.rptdesign";
				String strReportName = "UTILITY CERTIFICATE";

				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("utilityNo", strUtilityNo);


			ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);


		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
