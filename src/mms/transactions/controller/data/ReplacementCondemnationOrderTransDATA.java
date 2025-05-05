package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.bo.ReplacementCondemnationOrderTransBO;
import mms.transactions.controller.fb.ReplacementCondemnationOrderTransFB;
import mms.transactions.controller.hlp.ReplacementCondemnationOrderTransHLP;
import mms.transactions.vo.ReplacementCondemnationOrderTransVO;

public class ReplacementCondemnationOrderTransDATA 
{
	public static void initialPage(ReplacementCondemnationOrderTransFB formBean,HttpServletRequest request) {
		ReplacementCondemnationOrderTransVO vo=null;
		ReplacementCondemnationOrderTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String cmb = "",cmb1 = "",strCatName="";
		
			
		try {
			vo = new ReplacementCondemnationOrderTransVO();
			bo = new ReplacementCondemnationOrderTransBO();
			
			hisutil = new HisUtil("mms", "ReplacementCondemnationOrderTransDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
						
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
						
			// Calling BO Method	
			bo.initialPage(vo);			
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			if (vo.getWbsStoreNameCombo()!= null && vo.getWbsStoreNameCombo().size() > 0) 
			{			
			    if(vo.getWbsStoreNameCombo().next())
			    {
			    	vo.setStrStoreId(vo.getWbsStoreNameCombo().getString(1));			    	
			    }
			    vo.getWbsStoreNameCombo().beforeFirst();
				cmb = hisutil.getOptionValue(vo.getWbsStoreNameCombo(), "", "", true);
			}
			else 
			{
				cmb = "<option value='0'>Select Value</option>";
			}			
		
			formBean.setStrStoreName(cmb);	
			
			// BO Method
			bo.getcatcmb(vo);
			
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{				
				
				strCatName=hisutil.getOptionValue(vo.getItemCategWS(), "0","0^Select Value", false);
				    	
			}	
			
			formBean.setStrCatName(strCatName);
												
		} 
		catch (Exception e) 
		{
		    e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ReplacementCondemnationOrderTransDATA->initialPage()", strmsgText);
			formBean.setStrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	
	public static void getPendingOrderDtl(ReplacementCondemnationOrderTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReplacementCondemnationOrderTransBO bo = null;
		ReplacementCondemnationOrderTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null,cmb1="",cmb2="",cmb3="";
		

		try {
			bo = new ReplacementCondemnationOrderTransBO();
			vo = new ReplacementCondemnationOrderTransVO();
			util = new HisUtil("mms", "ReplacementCondemnationOrderTransDATA");

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrItemCatNo(request.getParameter("catcode"));
			vo.setStrSupplierId(request.getParameter("suppliercode"));
			//System.out.println("request.getParameter('actionId')>>>>>>"+request.getParameter("actionId"));
			vo.setStrActionsId(request.getParameter("actionId"));
			//System.out.println("vo.setStrActionsId>>>>>>"+vo.getStrActionsId());
			// BO Method
			bo.getPendingOrderDtl(vo);
			
            bo.approvedByCmb(vo);
			
			if (vo.getWbApprovedBy()!= null && vo.getWbApprovedBy().size() > 0) 
			{				   
				cmb1 = util.getOptionValue(vo.getWbApprovedBy(), "", "", true);
				cmb1=cmb1+"<option value='1'>Other</option>";
			}
			else 
			{
				cmb1 = "<option value='0'>Select Value</option>";
			}
			if (vo.getWbItemName()!= null && vo.getWbItemName().size() > 0) 
			{				   
				cmb2 = util.getOptionValue(vo.getWbItemName(), "0^Select Value", "", true);
			}
			else 
			{
				cmb2 = "<option value='0'>Select Value</option>";
			}
			
			if (vo.getWbCommitteType()!= null && vo.getWbCommitteType().size() > 0) 
			{				   
				cmb3 = util.getOptionValue(vo.getWbCommitteType(), "0^Select Value", "0^Select Value", true);
			}
			else 
			{
				cmb3 = "<option value='0'>Select Value</option>";
			}
			////System.out.println(cmb2);
			String strPendingOrderDtl = ReplacementCondemnationOrderTransHLP.getPendingOrderHLP(vo);            
			response.setHeader("Cache-Control", "no-cache");
			//response.getWriter().print(strPendingOrderDtl+"$"+vo.getStrActionsId()+"$"+cmb1+"$"+cmb2+"$"+cmb3);
			
			response.getWriter().print(strPendingOrderDtl+"$"+vo.getStrActionsId()+"$"+cmb3+"$"+cmb2+"$"+cmb3);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReplacementCondemnationOrderTransDATA.getPendingOrderDtl() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReplacementCondemnationOrderTransDATA->getPendingOrderDtl()", strmsgText);
			formBean.setStrMsg("Application Error [ERROR ID : "
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

	public static void getPendingOrderDtlNEW(ReplacementCondemnationOrderTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReplacementCondemnationOrderTransBO bo = null;
		ReplacementCondemnationOrderTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null,cmb1="",cmb2="",cmb3="";
		

		try {
			bo = new ReplacementCondemnationOrderTransBO();
			vo = new ReplacementCondemnationOrderTransVO();
			util = new HisUtil("mms", "ReplacementCondemnationOrderTransDATA");

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrItemCatNo(request.getParameter("catcode"));
			vo.setStrSupplierId(request.getParameter("suppliercode"));
			//System.out.println("request.getParameter('actionId')>>>>>>"+request.getParameter("actionId"));
			vo.setStrActionsId(request.getParameter("actionId"));
			//System.out.println("vo.setStrActionsId>>>>>>"+vo.getStrActionsId());
			// BO Method
			bo.getPendingOrderDtl(vo);
			
            bo.approvedByCmb(vo);
			
			if (vo.getWbApprovedBy()!= null && vo.getWbApprovedBy().size() > 0) 
			{				   
				cmb1 = util.getOptionValue(vo.getWbApprovedBy(), "", "", true);
				cmb1=cmb1+"<option value='1'>Other</option>";
			}
			else 
			{
				cmb1 = "<option value='0'>Select Value</option>";
			}
			if (vo.getWbItemName()!= null && vo.getWbItemName().size() > 0) 
			{				   
				cmb2 = util.getOptionValue(vo.getWbItemName(), "0^Select Value", "", true);
			}
			else 
			{
				cmb2 = "<option value='0'>Select Value</option>";
			}
			
			if (vo.getWbCommitteType()!= null && vo.getWbCommitteType().size() > 0) 
			{				   
				cmb3 = util.getOptionValue(vo.getWbCommitteType(), "0^Select Value", "0^Select Value", true);
			}
			else 
			{
				cmb3 = "<option value='0'>Select Value</option>";
			}
			////System.out.println(cmb2);
			String strPendingOrderDtl = ReplacementCondemnationOrderTransHLP.getPendingOrderHLPNEW(vo);            
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strPendingOrderDtl+"$"+vo.getStrActionsId()+"$"+cmb1+"$"+cmb2+"$"+cmb3);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReplacementCondemnationOrderTransDATA.getPendingOrderDtl() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReplacementCondemnationOrderTransDATA->getPendingOrderDtl()", strmsgText);
			formBean.setStrMsg("Application Error [ERROR ID : "
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

	
	public static void getNOSQDrugListHLP(ReplacementCondemnationOrderTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReplacementCondemnationOrderTransBO bo = null;
		ReplacementCondemnationOrderTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;

		try {
			bo = new ReplacementCondemnationOrderTransBO();
			vo = new ReplacementCondemnationOrderTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			
			// BO Method
			bo.getNOSQDrugListHLP(vo);

			String strNOSQDrugDtl = ReplacementCondemnationOrderTransHLP.getNOSQDrugListHLP(vo);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strNOSQDrugDtl);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReplacementCondemnationOrderTransDATA.getNOSQDrugListHLP() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReplacementCondemnationOrderTransDATA->getNOSQDrugListHLP()", strmsgText);
			formBean.setStrMsg("Application Error [ERROR ID : "
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
	
	public static void getExpiryRejectedDrugList(ReplacementCondemnationOrderTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReplacementCondemnationOrderTransBO bo = null;
		ReplacementCondemnationOrderTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;

		try {
			bo = new ReplacementCondemnationOrderTransBO();
			vo = new ReplacementCondemnationOrderTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrItemCatNo(request.getParameter("catcode"));
			vo.setStrSupplierId(request.getParameter("suppliercode"));
			vo.setStrActionsId(request.getParameter("strActionsId"));
			//System.out.println("supplierid ====="+request.getParameter("suppliercode"));
			// BO Method
			bo.getExpiryRejectedDrugList(vo);

			String strExpiryDrugDtl   =  ReplacementCondemnationOrderTransHLP.getExpiryDrugListHLP(vo);
			String strsuggestedDrugDtl   = ReplacementCondemnationOrderTransHLP.getSuggestedExpiryList(vo);
			////System.out.println("strsuggestedDrugDtl"+strsuggestedDrugDtl);
		//	String strRejectedDrugDtl = ReplacementCondemnationOrderTransHLP.getRejectedDrugListHLP(vo);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strExpiryDrugDtl+"$"+strsuggestedDrugDtl);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReplacementCondemnationOrderTransDATA.getExpiryRejectedDrugList() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReplacementCondemnationOrderTransDATA->getNOSQDrugListHLP()", strmsgText);
			formBean.setStrMsg("Application Error [ERROR ID : "
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

	
	public static void getExpiryRejectedDrugListNEW(ReplacementCondemnationOrderTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReplacementCondemnationOrderTransBO bo = null;
		ReplacementCondemnationOrderTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;

		try {
			bo = new ReplacementCondemnationOrderTransBO();
			vo = new ReplacementCondemnationOrderTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrItemCatNo(request.getParameter("catcode"));
			vo.setStrSupplierId(request.getParameter("suppliercode"));
			vo.setStrActionsId(request.getParameter("strActionsId"));
			//System.out.println("supplierid ====="+request.getParameter("suppliercode"));
			// BO Method
			bo.getExpiryRejectedDrugList(vo);

			String strExpiryDrugDtl   =  ReplacementCondemnationOrderTransHLP.getExpiryDrugListHLPNEW(vo);
			String strsuggestedDrugDtl   = ReplacementCondemnationOrderTransHLP.getSuggestedExpiryListNEW(vo);
			////System.out.println("strsuggestedDrugDtl"+strsuggestedDrugDtl);
		//	String strRejectedDrugDtl = ReplacementCondemnationOrderTransHLP.getRejectedDrugListHLP(vo);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strExpiryDrugDtl+"$"+strsuggestedDrugDtl);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReplacementCondemnationOrderTransDATA.getExpiryRejectedDrugList() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReplacementCondemnationOrderTransDATA->getNOSQDrugListHLP()", strmsgText);
			formBean.setStrMsg("Application Error [ERROR ID : "
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

	
	public static void getregularindentdruglist(ReplacementCondemnationOrderTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReplacementCondemnationOrderTransBO bo = null;
		ReplacementCondemnationOrderTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;

		try {
			bo = new ReplacementCondemnationOrderTransBO();
			vo = new ReplacementCondemnationOrderTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			
			// BO Method
		//	bo.getregularindentdruglist(vo);

			String strIndentedDrugDtl   = ReplacementCondemnationOrderTransHLP.getregularindentdruglistHLP(vo);
		//	String strRejectedDrugDtl = ReplacementCondemnationOrderTransHLP.getRejectedDrugListHLP(vo);

			response.setHeader("Cache-Control", "no-cache");
			//System.out.println("strIndentedDrugDtl--->>>>>>"+strIndentedDrugDtl);
			response.getWriter().print(strIndentedDrugDtl);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReplacementCondemnationOrderTransDATA.getExpiryRejectedDrugList() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReplacementCondemnationOrderTransDATA->getNOSQDrugListHLP()", strmsgText);
			formBean.setStrMsg("Application Error [ERROR ID : "
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
			
	public static void getAvailableStockDtls(ReplacementCondemnationOrderTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReplacementCondemnationOrderTransBO bo = null;
		ReplacementCondemnationOrderTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;

		try {
			bo = new ReplacementCondemnationOrderTransBO();
			vo = new ReplacementCondemnationOrderTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strStoreId = (String) request.getParameter("strStoreId"); 
			String strItemBrandId = (String) request.getParameter("strItemBrandId");
			String strBatchNo = (String) request.getParameter("strBatchNo");
			String index =  (String) request.getParameter("index"); 			
			vo.setStrStoreId(strStoreId);
			vo.setStrItemBrandId(strItemBrandId);
			vo.setStrBatchNo(strBatchNo);
			
			
			// BO Method
			bo.getAvailableStockDtls(vo);

			String strStockPopUpDtls = ReplacementCondemnationOrderTransHLP.getPopUpInfo(vo,index);
			////System.out.println("strStockPopUpDtls: "+strStockPopUpDtls);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStockPopUpDtls+"$$"+index);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReplacementCondemnationOrderTransDATA.getAvailableStockDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReplacementCondemnationOrderTransDATA->getAvailableStockDtls()", strmsgText);
			formBean.setStrMsg("Application Error [ERROR ID : "
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
	
	public static void getOrderScheduleDtl(ReplacementCondemnationOrderTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReplacementCondemnationOrderTransBO bo = null;
		ReplacementCondemnationOrderTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;

		try {
			bo = new ReplacementCondemnationOrderTransBO();
			vo = new ReplacementCondemnationOrderTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrHiddenItemDtl(request.getParameter("strHiddenItemDtl"));
			
			// BO Method
			bo.getOrderScheduleDtl(vo);
			
			formBean.setWsOrderScheduleDtl(vo.getWsOrderScheduleDtl());
			String strOrderSchDtl = ReplacementCondemnationOrderTransHLP.getOrderScheduleDtlTWO(formBean, vo);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strOrderSchDtl);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReplacementCondemnationOrderTransDATA.getOrderScheduleDtl() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReplacementCondemnationOrderTransDATA->getOrderScheduleDtl()", strmsgText);
			formBean.setStrMsg("Application Error [ERROR ID : "
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
	public static void getcatcmb(ReplacementCondemnationOrderTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReplacementCondemnationOrderTransBO bo = null;
		ReplacementCondemnationOrderTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;
		String strItemVal=null;

		try {
			bo = new ReplacementCondemnationOrderTransBO();
			vo = new ReplacementCondemnationOrderTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrStoreId(request.getParameter("storeId"));
			
			// BO Method
			bo.getcatcmb(vo);
			
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{				
				util = new HisUtil("MMS","IssueDetailRptData");
				strItemVal=util.getOptionValue(vo.getItemCategWS(), "0","0^Select Value", false);
				response.getWriter().print(strItemVal);			    	
			}	
			

			response.setHeader("Cache-Control", "no-cache");
			//response.getWriter().print(strOrderSchDtl);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReplacementCondemnationOrderTransDATA.getOrderScheduleDtl() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReplacementCondemnationOrderTransDATA->getOrderScheduleDtl()", strmsgText);
			formBean.setStrMsg("Application Error [ERROR ID : "
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
	
	public static void getsuppliercmb(ReplacementCondemnationOrderTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReplacementCondemnationOrderTransBO bo = null;
		ReplacementCondemnationOrderTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;
		String strItemVal=null;

		try {
			bo = new ReplacementCondemnationOrderTransBO();
			vo = new ReplacementCondemnationOrderTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrItemCatNo(request.getParameter("catcode"));
			// BO Method
			bo.getsuppliercmb(vo);
			
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{				
				util = new HisUtil("MMS","IssueDetailRptData");
				strItemVal=util.getOptionValue(vo.getSupplierWS(), "0","0^Select Value", false);
				response.getWriter().print(strItemVal);			    	
			}	
			

			response.setHeader("Cache-Control", "no-cache");
			//response.getWriter().print(strOrderSchDtl);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReplacementCondemnationOrderTransDATA.getOrderScheduleDtl() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReplacementCondemnationOrderTransDATA->getOrderScheduleDtl()", strmsgText);
			formBean.setStrMsg("Application Error [ERROR ID : "
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
	public static void insert( ReplacementCondemnationOrderTransFB formBean, HttpServletRequest request) 
	{
		 ReplacementCondemnationOrderTransVO vo = null;
		 ReplacementCondemnationOrderTransBO bo = null;
		 String strmsgText = null;
		try 
		{
			 bo = new  ReplacementCondemnationOrderTransBO();
			 vo = new ReplacementCondemnationOrderTransVO();
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
						
			vo = ( ReplacementCondemnationOrderTransVO) TransferObjectFactory.populateData("mms.transactions.vo.ReplacementCondemnationOrderTransVO",	formBean);
            // Calling BO method
			//System.out.println("vo.setStrActionsId>>>Insert::>>>"+vo.getStrActionsId());
			bo.insert(vo);
			formBean.setStrMsgType(vo.getStrMsgType());
			if (vo.getStrMsgType().equals("1"))
			{	
				throw new Exception(vo.getStrMsgString());
			}
			else if(vo.getStrMsgType().equals("2"))
			{
				strmsgText="PO Does Not Exists";
				formBean.setStrMsg(strmsgText);
			}
			else
			{	
				strmsgText = "Record Saved Successfully!";
				formBean.setStrMsg(strmsgText);
			}
		}
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			HisException hisException = new HisException("Material Management System"," ReplacementCondemnationOrderTransDATA.insert()---->", _Err.getMessage());
			formBean.setStrErr("Error####Application Error [ERROR ID : "+ hisException.getErrorID()+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void CANCELORDER( ReplacementCondemnationOrderTransFB formBean, HttpServletRequest request) 
	{
		 ReplacementCondemnationOrderTransVO vo = null;
		 ReplacementCondemnationOrderTransBO bo = null;
		 String strmsgText = null;
		try 
		{
			 bo = new  ReplacementCondemnationOrderTransBO();
			 vo = new ReplacementCondemnationOrderTransVO();
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
						
			vo = ( ReplacementCondemnationOrderTransVO) TransferObjectFactory.populateData("mms.transactions.vo.ReplacementCondemnationOrderTransVO",	formBean);
            // Calling BO method
			//System.out.println("vo.setStrActionsId>>>Insert::>>>"+vo.getStrActionsId());
			bo.CANCELORDER(vo);
			formBean.setStrMsgType(vo.getStrMsgType());
			if (vo.getStrMsgType().equals("1"))
			{	
				throw new Exception(vo.getStrMsgString());
			}
			else if(vo.getStrMsgType().equals("2"))
			{
				strmsgText="PO Does Not Exists";
				formBean.setStrMsg(strmsgText);
			}
			else
			{	
				strmsgText = "Record Saved Successfully!";
				formBean.setStrMsg(strmsgText);
			}
		}
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			HisException hisException = new HisException("Material Management System"," ReplacementCondemnationOrderTransDATA.insert()---->", _Err.getMessage());
			formBean.setStrErr("Error####Application Error [ERROR ID : "+ hisException.getErrorID()+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
}

