/**
 * 
 */
package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.IndentForImportItemsBO;
import mms.transactions.controller.fb.IndentForImportItemsFB;
import mms.transactions.vo.IndentForImportItemsVO;

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 27/Apr/2009
 * Modification : By Amit Kumar 25/May/2009
 * 
 */
public class IndentForImportItemsDATA {

	/**
	 * To get values of GROUP NAME COMBO BY STORE TYPE ID
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void getInitialValues(IndentForImportItemsFB formBean,
			HttpServletRequest request) {

		IndentForImportItemsBO bo = null;
		IndentForImportItemsVO vo = null;
		String         strmsgText = "";
		String            hosCode = "";
		String         strStoreId = "";
		String     strStoreTypeId = "";
		String  strItemCategoryNo = "";

		String        strGrantCmb = "";
		String        strGroupCmb = "";
		String     strCurrencyCmb = "";
		String     strSupplierCmb = "";
		String      strPurposeCmb = "";
		String         strReqDate = "";
		String            combo[] = null;
	//	String             seatId = "";
        String               path = "";
		HisUtil           hisUtil = null;
		String[]          strTemp = null; 
		String[]         strTemp1 = null;
		String         strReqType = "";
		try {
			               bo = new IndentForImportItemsBO();
			               vo = new IndentForImportItemsVO();
			          hisUtil = new HisUtil("MMS", "IndentForImportItemsDATA");
                        combo = request.getParameterValues("combo");
			          strTemp =  combo[0].split("\\^");
			       strStoreId = strTemp[0];   // Store Id
			   strStoreTypeId = strTemp[1];   // Store Type ID
			strItemCategoryNo = combo[1];     // Item category
			          hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString(); 
             //         seatId  = request.getSession().getAttribute("SEATID").toString();
			       strReqDate = hisUtil.getASDate("dd-MM-yyyy");
			
			//formBean.setStrItemCategoryNo("3");

			      
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			
			formBean.setStrStoreId(strStoreId);
			formBean.setStrItemCategoryNo(strItemCategoryNo);
			
            
			           
	        combo = request.getParameterValues("combo");
	        
            /*Here We get Path of Parent Controller*/
			if(request.getParameter("cnt_page") == null)
			{
				   path = request.getParameter("strPath");
			}
			else
			{
				   path = "/mms"+request.getParameter("cnt_page")+".cnt";
			}	
			
			   strTemp1 = combo[2].split("\\^"); 
			
			 strReqType = strTemp1[1];    // Request Type ID
			 
			vo.setStrReqType(strReqType);
			formBean.setStrReqType(strReqType);		
			
			bo.getInitialValues(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			else {
				// GRANT COMBO
				if (vo.getWSGrantTypeNameCmb().size() == 0 || vo.getWSGrantTypeNameCmb() == null) 
				{
					strGrantCmb = "<option value='0'>Select Value</option>";
				} 
				else 
				{
					strGrantCmb = hisUtil.getOptionValue(vo.getWSGrantTypeNameCmb(), "-1", "0^Select Value",true);
				}

				// GROUP COMBO
				if (vo.getWSGroupNameCmb().size() == 0 || vo.getWSGroupNameCmb() == null)
				{
					strGroupCmb = "<option value='0'>Select Value</option>";
				} 
				else 
				{
					strGroupCmb = hisUtil.getOptionValue(vo.getWSGroupNameCmb(), "0","0^Select Value", true);
				}
				
				// CURRENCY COMBO
				if (vo.getWSCurrencyNameCmb().size() == 0|| vo.getWSCurrencyNameCmb() == null) 
				{
					strCurrencyCmb = "<option value='0'>Select Value</option>";
				}
				else 
				{
					strCurrencyCmb = hisUtil.getOptionValue(vo.getWSCurrencyNameCmb(), "0", "0^Select Value",true);
				}

				// SUPPLIER COMBO
				if (vo.getWSSupplierNameCmb().size() == 0|| vo.getWSSupplierNameCmb() == null) 
				{
					strSupplierCmb = "<option value='0'>Select Value</option>";
				} 
				else 
				{
					strSupplierCmb = hisUtil.getOptionValue(vo.getWSSupplierNameCmb(), "0", "0^Select Value",true);
				}

				// PURPOSE COMBO
				if (vo.getWSPurposeCmb().size() == 0|| vo.getWSPurposeCmb() == null) 
				{
					strPurposeCmb = "<option value='0'>Select Value</option>";
				} 
				else 
				{
					strPurposeCmb = hisUtil.getOptionValue(vo.getWSPurposeCmb(), "0","0^Select Value",true);
				}

			}
			formBean.setStrToStoreCombo(vo.getStrToStoreCombo());
			formBean.setStrGrantTypeNameCmb(strGrantCmb);
			formBean.setStrGroupNameCmb(strGroupCmb);
			formBean.setStrCurrencyNameCmb(strCurrencyCmb);
			formBean.setStrSupplierNameCmb(strSupplierCmb);
			formBean.setStrItemCategory(vo.getStrItemCategory());
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrPurposeCmb(strPurposeCmb);
			formBean.setStrReqDate(strReqDate);
			formBean.setStrPath(path.trim());

		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "IndentForImportItemsDATA.getInitialValues(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentForImportItemsDATA->getInitialValues()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}

	/**
	 * To get SUBGROUP AND ITEM NAME COMBO IN THE BASIS OF SELECTED GROUP
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getSubGroupItemCombo(IndentForImportItemsFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IndentForImportItemsBO bo = null;
		IndentForImportItemsVO vo = null;
		String         strmsgText = "";
		String            hosCode = "";
		String         strStoreId = "";
		String         strGroupId = "";
		String      strCategoryNo = "";
		String     strSubGroupCmb = "";
		String     strItemNameCmb = "";
		String      strSubGroupId = "";
		HisUtil           hisUtil = null;

		try {

			           bo = new IndentForImportItemsBO();
			           vo = new IndentForImportItemsVO();
			      hisUtil = new HisUtil("MMS", "IndentForImportItemsDATA");

			      hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString(); 
			   strGroupId = request.getParameter("groupId");
			   strStoreId = request.getParameter("storeId");
			strCategoryNo = request.getParameter("catNo");
			strSubGroupId = request.getParameter("subgroupId");

			
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(strStoreId);
			vo.setStrGroupId(strGroupId);
			vo.setStrItemCategoryNo(strCategoryNo);
			vo.setStrSubGroupId(strSubGroupId);

			/* Calling Bo Method */
			bo.getSubGroupCombo(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			/* Calling Bo Method */
			bo.getItemCombo(vo);
			

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			else 
			{

				/* Sub Group Combo */
				strSubGroupCmb = hisUtil.getOptionValue(vo.getWSSubGroupNameCmb(), "0", "0^Select Value", true);
				/* Item Name Combo */
				strItemNameCmb = hisUtil.getOptionValue(vo.getWSItemNameCmb(),"0", "0^Select Value", true);

				try 
				{
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(
							strSubGroupCmb + "##" + strItemNameCmb);

				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "IndentForImportItemsDATA.getSubGroupItemCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentForImportItemsDATA->getSubGroupItemCombo()",
					strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisUtil = null;
		}
	}

	/**
	 * To get ITEM COMBO IN THE BASIS OF SELECTED SUBGROUP
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getItemCombo(IndentForImportItemsFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IndentForImportItemsBO bo = null;
		IndentForImportItemsVO vo = null;
		String         strmsgText = "";
		String            hosCode = "";
		String         strStoreId = "";
		String         strGroupId = "";
		String      strCategoryNo = "";
		String     strItemNameCmb = "";
		String      strSubGroupId = "";
		HisUtil           hisUtil = null;

		try {

			           bo = new IndentForImportItemsBO();
			           vo = new IndentForImportItemsVO();
			      hisUtil = new HisUtil("MMS", "IndentForImportItemsDATA");
			      hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			   strGroupId = request.getParameter("groupId");
			   strStoreId = request.getParameter("storeId");
			strCategoryNo = request.getParameter("catNo");
			strSubGroupId = request.getParameter("subgroupId");

			////System.out.println("groupId-" + strGroupId);

			////System.out.println("DATA strstoreId" + strStoreId);

			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(strStoreId);
			vo.setStrGroupId(strGroupId);
			vo.setStrItemCategoryNo(strCategoryNo);
			vo.setStrSubGroupId(strSubGroupId);

			bo.getItemCombo(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			else 
			{
				if (vo.getWSItemNameCmb().size() == 0 || vo.getWSItemNameCmb() == null) 
				{
					strItemNameCmb = "<option value='0'>Select Value</option><option value='1'>Dummy</option>";// should delete dummy it is for testing if no items
				} 
				else 
				{
					strItemNameCmb = hisUtil.getOptionValue(vo.getWSItemNameCmb(), "0", "0^Select Value", true);
				}

				try 
				{
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemNameCmb);

				}
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "IndentForImportItemsDATA.getItemCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentForImportItemsDATA->getItemCombo()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisUtil = null;
		}
	}

	/**
	 * To get BRAND NAME COMBO IN THE BASIS OF SELECTED ITEM
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getBrandCombo(IndentForImportItemsFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IndentForImportItemsBO bo = null;
		IndentForImportItemsVO vo = null;
		String         strmsgText = "";
		String            hosCode = "";
		String          strItemId = "";
		String    strBrandNameCmb = "";
		HisUtil           hisUtil = null;

		try {

			       bo = new IndentForImportItemsBO();
			       vo = new IndentForImportItemsVO();
			  hisUtil = new HisUtil("MMS", "IndentForImportItemsDATA");
			  hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strItemId = request.getParameter("itemId");
             
			vo.setStrHospitalCode(hosCode);
			vo.setStrItemId(strItemId);
			vo.setStrGroupId(request.getParameter("groupId"));
			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrSubGroupId(request.getParameter("subgroupId"));
            vo.setStrItemCategoryNo(request.getParameter("catNo"));
            
            /* Calling BO Method */
            bo.getBrandCombo(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			else 
			{
				if (vo.getWSBrandNameCmb().size() == 0 || vo.getWSBrandNameCmb() == null) 
				{
					strBrandNameCmb = "<option value='0'>Select Value</option>";
				} 
				else 
				{
					strBrandNameCmb = hisUtil.getOptionValue(vo.getWSBrandNameCmb(), "0", "0^Select Value", true);
				}

				try 
				{
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strBrandNameCmb);

				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} 
		catch (Exception e) 
		{

		//	e.printStackTrace();
			strmsgText = "IndentForImportItemsDATA.getBrandCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentForImportItemsDATA->getBrandCombo()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisUtil = null;
		}
	}

	/**
	 * To get SUPPLIER ADDRESS IN THE BASIS OF SELECTED SUPPLIER
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getSupplierAddress(IndentForImportItemsFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IndentForImportItemsBO bo = null;
		IndentForImportItemsVO vo = null;
		String         strmsgText = "";
		String            hosCode = "";
		String      strSupplierId = "";

		try {

			           bo = new IndentForImportItemsBO();
			           vo = new IndentForImportItemsVO();
			      hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSupplierId = request.getParameter("supplierId");

			vo.setStrHospitalCode(hosCode);
			vo.setStrSupplierId(strSupplierId);

			bo.getSupplierAddress(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			else 
			{

				try 
				{
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(vo.getStrSupplierAddress());

				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (Exception e) {

			//e.printStackTrace();
			strmsgText = "IndentForImportItemsDATA.getSupplierAddress(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentForImportItemsDATA->getSupplierAddress()",
					strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}
	}

	/**
	 * To get STOCK DETAILS AND UNIT COMBO ON THE BASIS OF SELECTED ITEM AND
	 * BRAND
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getStockDtls(IndentForImportItemsFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IndentForImportItemsBO bo = null;
		IndentForImportItemsVO vo = null;
		String         strmsgText = "";
		String            hosCode = "";
		String          strItemId = "";
		String         strBrandId = "";
		String         strStoreId = "";
		String           strCatNo = "";
		String         strUnitCmb = "";
		
		String[]             temp = null;
		String[]            temp2 = null;
		String   strExistingStock = "";
		String            strPoNo = "";
		String          strPODate = "";
		String            strRate = "";
		String    strRateUnitName = "";
	//	String      strRateUnitId = "";
		String    strSuuplierName = "";
		String       strRecevDate = "";
	//	String          strSuppId = "";
		String   strConsumableQty = "";
	//	String     strQtyUnitName = "";
	//	String       strQtyUnitId = "";
		String                res = "";
		HisUtil           hisUtil = null;
		String[]            temp1 = null;

		try {

			        bo = new IndentForImportItemsBO();
			        vo = new IndentForImportItemsVO();
			   hisUtil = new HisUtil("MMS", "IndentForImportItemsDATA");
			   hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			 strItemId = request.getParameter("itemId");
			strStoreId = request.getParameter("storeId");
			  strCatNo = request.getParameter("catNo");
			strBrandId = request.getParameter("brandId");
		
					
			vo.setStrHospitalCode(hosCode);
			vo.setStrItemId(strItemId);
			vo.setStrStoreId(strStoreId);
			vo.setStrBrandId(strBrandId);
			vo.setStrItemCategoryNo(strCatNo);

			bo.getStockDtls(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			else
			{    
//				 //System.out.println("Stock Dtl:::"+vo.getStrStockDtl());
				 temp = vo.getStrStockDtl().replace("^", "#").split("#");  
//				 //System.out.println("temp[1]::::"+temp[1]);
				temp1 = temp[1].replace("@", "#").split("#");
				temp2 = vo.getStrRemaingStockDtl().replace("^", "#").split("#");
			    
//				//System.out.println("Rasing Stock::::"+vo.getStrRemaingStockDtl());
				formBean.setStrInhandQty(temp1[0]);
				formBean.setStrInhandQtyUnit(temp1[1]);
				
				vo.setStrInhandQty(temp1[0]);
				vo.setStrInhandQtyUnit(temp1[1]);
				vo.setStrItemUnitId(temp2[11]);
					
			//Value Come Like(1321342314^17-Jun-2009^2^Each^6301^Caplet India^17-Jun-2009^1100003^0^/^)	
//		  		 //System.out.println("strExistingStock"+temp[0]);
//				 //System.out.println("strPoNo->"+temp2[0]);
//				 //System.out.println("strPODate->"+temp2[1]);
//				 //System.out.println("strRate->"+temp2[2]);
//				 //System.out.println("strRateUnitName->"+temp2[3]);
//				 //System.out.println("strRateUnitId->"+temp2[4]);
//				 //System.out.println("strSuuplierName->"+temp2[5]);
//				 //System.out.println("strRecevDate->"+temp2[6]);
//				 //System.out.println("strSuppId->"+temp2[7]);
//				 //System.out.println("strConsumableQty->"+temp2[8]);
//				 //System.out.println("strQtyUnitName->"+temp2[9]);
//				 //System.out.println("strQtyUnitId->"+temp2[10]);
//				 //System.out.println("UnitId To Get Unit Combo->"+temp2[11]);
				
				 strExistingStock = temp[0];
				
				          strPoNo = temp2[0];
				
				        strPODate = temp2[1];
				
				          strRate = temp2[2];
				
				  strRateUnitName = temp2[3];
			
			//	    strRateUnitId = temp2[4];
				
				  strSuuplierName = temp2[5];
				
				     strRecevDate = temp2[6];
				     
			//	        strSuppId = temp2[7];
				        
				 strConsumableQty = temp2[8];
				 
			//	   strQtyUnitName = temp2[9];
				   
 			//	     strQtyUnitId = temp2[10];
				
				
				
			}
			bo.getUnitCmb(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			else 
			{
				if (vo.getWSApproxRateUnitCmb().size() == 0|| vo.getWSApproxRateUnitCmb() == null) 
				{
					strUnitCmb = "<option value='0'>Select Value</option>";
				} 
				else 
				{
					strUnitCmb = hisUtil.getOptionValue(vo.getWSApproxRateUnitCmb(), "0", "0^Select Value",true);
				}
			}
			 
			 res =   strExistingStock + "#"	+ strConsumableQty + "#" + strPoNo + "#"  
			       + strPODate        + "#" + strRate +"/"+ strRateUnitName    + "#" + strRecevDate + "#"
			       + strSuuplierName  + "#" + strUnitCmb       +"#"+vo.getStrStockDtl()+ "#" +vo.getStrRemaingStockDtl();
			 
				try 
				{
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(res);

				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "IndentForImportItemsDATA.getStockDtls(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentForImportItemsDATA->getStockDtls()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}
	}

	/**
	 * This method is CALL ON save button
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static boolean  insertDetails(IndentForImportItemsFB formBean,
			HttpServletRequest request) {

		IndentForImportItemsBO bo = null;
		IndentForImportItemsVO vo = null;
		String         strmsgText = "";
		MmsConfigUtil         mcu = null;
	//	HisUtil              util = null;
		String            strPath = "";
    //    String[]             temp = null;
    //    String[]            temp1 = null;
	//	String[]            temp2 = null;
		boolean          retValue = true;
	//	String          strCtDate = "";
		String         strReqType = "";
		String         strStoreId = "";
		String     strStoreTypeId = "";
		String  strItemCategoryNo = "";
       
		try 
		{
			      mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
        //         util = new HisUtil("","");
	//		strCtDate = util.getASDate("dd-MMM-yyyy");
		   	       bo = new IndentForImportItemsBO();
		   	       vo = new IndentForImportItemsVO();
				   		   	
		   

			vo = (IndentForImportItemsVO) TransferObjectFactory.populateData(
					"mms.transactions.vo.IndentForImportItemsVO", formBean);

			        strReqType = request.getParameter("strReqType");
			           strPath = request.getParameter("strPath");
			        strStoreId = request.getParameter("strStoreId");
			    strStoreTypeId = request.getParameter("strStoreTypeId");
			 strItemCategoryNo = request.getParameter("strItemCategoryNo");
			//		      temp = formBean.getStrHiddenStockDtl().replace("^", "#").split("#");  
			//             temp1 = temp[1].replace("@", "#").split("#");
			 //            temp2 = formBean.getStrHiddenStockPosition().replace("^", "#").split("#");

			vo.setStrPath(strPath);
			vo.setStrFinancialStartYear(mcu.getStrFinancialStartDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString()));
			vo.setStrFinancialEndYear(mcu.getStrFinancialEndDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString()));
			vo.setStrGrantTypeCode(formBean.getStrGrantTypeCode());
			
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrBrandId(formBean.getStrBrandId());

			vo.setStrCurrencyId(formBean.getStrCurrencyId());
			vo.setStrApproxRate(formBean.getStrApproxRate());
			vo.setStrApproxRateUnitId(formBean.getStrApproxRateUnitId());
			vo.setStrQunatityReq(formBean.getStrQunatityReq());

			vo.setStrQtyUnitName(formBean.getStrQtyUnitName());
			vo.setStrSupplierId(formBean.getStrSupplierId());
			vo.setStrQuotationJustification(formBean.getStrQuotationJustification());
			vo.setStrWarrantyPeriod(formBean.getStrWarrantyPeriod());

			vo.setStrIsIntallationReq(formBean.getStrIsIntallationReq());
			vo.setStrInstalationApproxCharges(formBean.getStrInstalationApproxCharges());
			vo.setStrOtherPurpose(formBean.getStrOtherPurpose());
			vo.setStrJustification(formBean.getStrJustification());
			
			vo.setStrIsUrgent(formBean.getStrIsUrgent());
			vo.setStrPInvoiceRecvd(formBean.getStrPInvoiceRecvd());
			vo.setStrIsLowestQuotation(formBean.getStrIsLowestQuotation());
			vo.setStrToStoreCombo(formBean.getStrToStoreCombo());	
			
			vo.setStrReqType(strReqType);
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
	        vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
	        vo.setStrHiddenStockPosition(formBean.getStrHiddenStockPosition()); 
			vo.setStrHiddenStockDtl(formBean.getStrHiddenStockDtl());
			
			formBean.setStrPath(vo.getStrPath());
		
			// Calling Bo Insert Method
			bo.insert(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				retValue = false;
			    throw new Exception(vo.getStrMsgString());
			}
			else
			{
				
				formBean.setStrNormalMsg("Data Saved Successfully");
			}

		}
		catch (Exception e)
		{
			retValue = false;
           	e.printStackTrace();
			
						
			strmsgText = "IndentForImportItemsDATA.insertDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentForImportItemsDATA->getInitialValues()", strmsgText);
			formBean.setStrPath(strPath);
			
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
             
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}
		return retValue;
	}

}
