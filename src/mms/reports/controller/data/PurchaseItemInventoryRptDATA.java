package mms.reports.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.PurchaseItemInventoryRptBO;
import mms.reports.controller.fb.PurchaseItemInventoryRptFB;
import mms.reports.controller.hlp.PurchaseItemInventoryRptHLP;
import mms.reports.vo.PurchaseItemInventoryRptVO;

public class PurchaseItemInventoryRptDATA {
	
	public static void initDetails(PurchaseItemInventoryRptFB formBean, HttpServletRequest request)
	{

		PurchaseItemInventoryRptBO bo = null;
		PurchaseItemInventoryRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strItemCombo="";
		
		try {

			bo = new PurchaseItemInventoryRptBO();
			voObj = new PurchaseItemInventoryRptVO();
			
				
			String strItemCatNo = request.getParameter("itemcat");
			
			if (strItemCatNo == null)
				strItemCatNo = "10";
			
			voObj.setStrItemCatNo(strItemCatNo);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrMode("1");
			
			bo.getItemName(voObj);
			
			
			util = new HisUtil("MMS", "PurchaseItemInventoryRptDATA");
			strItemCombo= util.getOptionValue(voObj.getStrItemNameWs(),"0","0^All", false);
			
			//System.out.println("strItemCombo------"+strItemCombo);
			
			
			formBean.setStrItemCombo(strItemCombo);
			
			bo.getSupplierList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseItemInventoryRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrSupplierWs().size() != 0) 
			{
			
				
			   temp = util.getOptionValue(voObj.getStrSupplierWs(), "0", "0^All", false);
			

			}else{
				
				temp = "<option value='0'>All</option>";
			}

			//System.out.println("temp------"+temp); 
			formBean.setStrSupplierCmb(temp);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PurchaseItemInventoryRptDATA.getSupplierList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseItemInventoryRptDATA->getSupplierList()", strmsgText);
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
	
	
	public static void getStoreList(PurchaseItemInventoryRptFB formBean, HttpServletRequest request) {

		PurchaseItemInventoryRptBO bo = null;
		PurchaseItemInventoryRptVO vo = null;

		HisUtil util = null;
		String strStoreVal = "";
		String strmsgText = null;
		
		try {
			bo = new PurchaseItemInventoryRptBO();
			vo = new PurchaseItemInventoryRptVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getStoreList(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseItemInventoryRptDATA");
			
			strStoreVal = util.getOptionValue(vo.getStrStoreWs(), "0", "0^Select Value", false);
						
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PurchaseItemInventoryRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseItemInventoryRptDATA->getStoreList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	public static void getItemCatList(PurchaseItemInventoryRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PurchaseItemInventoryRptBO bo = null;
		PurchaseItemInventoryRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PurchaseItemInventoryRptBO();
			voObj = new PurchaseItemInventoryRptVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseItemInventoryRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrItemCatWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^All",
						true);

			}else{
				
				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PurchaseItemInventoryRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseItemInventoryRptDATA->getItemCatList()", strmsgText);
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
	
	public static void getPOTypeList(PurchaseItemInventoryRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PurchaseItemInventoryRptBO bo = null;
		PurchaseItemInventoryRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PurchaseItemInventoryRptBO();
			voObj = new PurchaseItemInventoryRptVO();
			
			String strStoreId = request.getParameter("storeId");
			String strItemCatNo = request.getParameter("itemcat");
			
			if (strStoreId == null)
				strStoreId = "0";
			if (strItemCatNo == null)
				strItemCatNo = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrItemCatNo(strItemCatNo);
			voObj.setStrReqFor("2");
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getPOTypeList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseItemInventoryRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrPOTypeWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrPOTypeWs(), "0", "0^All",
						true);

			}else{
				
				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PurchaseItemInventoryRptDATA.getPOTypeList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseItemInventoryRptDATA->getPOTypeList()", strmsgText);
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
	
	public static void getSupplierList(PurchaseItemInventoryRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PurchaseItemInventoryRptBO bo = null;
		PurchaseItemInventoryRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PurchaseItemInventoryRptBO();
			voObj = new PurchaseItemInventoryRptVO();
			
			
			String strItemCatNo = request.getParameter("itemcat");
			
			if (strItemCatNo == null)
				strItemCatNo = "0";
			
			voObj.setStrItemCatNo(strItemCatNo);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getSupplierList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseItemInventoryRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrSupplierWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrSupplierWs(), "0", "0^All",
						true);

			}else{
				
				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PurchaseItemInventoryRptDATA.getSupplierList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseItemInventoryRptDATA->getSupplierList()", strmsgText);
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
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void showReport(PurchaseItemInventoryRptFB formBean,HttpServletRequest request, HttpServletResponse response)
	{
		PurchaseItemInventoryRptBO bo = null;
		PurchaseItemInventoryRptVO voObj = null;		
		try 
		{

			bo = new PurchaseItemInventoryRptBO();
			voObj = new PurchaseItemInventoryRptVO();
			
			voObj = (PurchaseItemInventoryRptVO) TransferObjectFactory.populateData("mms.reports.vo.PurchaseItemInventoryRptVO", formBean);
			
			bo.getReportDtl(voObj);
			   
			String strResult=PurchaseItemInventoryRptHLP.getReportDetails(formBean,voObj);
			
				if(voObj.getReportDtlWs()!= null)
				{	
					formBean.setPrintReportDetails(strResult);
				 		 
				}
				
			      	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}