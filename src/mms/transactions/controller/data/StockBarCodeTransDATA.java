package mms.transactions.controller.data;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hisglobal.ReportUtil;
import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.transactions.bo.StockBarCodeTransBO;
import mms.transactions.controller.fb.StockBarCodeTransFB;
import mms.transactions.controller.hlp.StockBarCodeTransHLP;
import mms.transactions.vo.StockBarCodeTransVO;

public class StockBarCodeTransDATA {

	public static void initialGenAdd(StockBarCodeTransFB formBean,HttpServletRequest request) {
		StockBarCodeTransVO vo = null;
		StockBarCodeTransBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate;


		try {
			vo = new StockBarCodeTransVO();
			bo = new StockBarCodeTransBO();
			
			hisutil = new HisUtil("mms", "LocalPurchaseMRN_DATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
		
			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);

			bo.initialGenAdd(vo);
			
//-------------------------------------Store Name--------------------------------------------
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			String temp = "";
			
			if (vo.getWsStoreNameCombo() != null && vo.getWsStoreNameCombo().size() > 0) {
				if(vo.getWsStoreNameCombo().next())
				{
					vo.setStrStoreId(vo.getWsStoreNameCombo().getString(1));
					vo.getWsStoreNameCombo().beforeFirst();
				}
				temp = hisutil.getOptionValue(vo.getWsStoreNameCombo(), "","", false, false);

			} else {
				temp = "<option value='0'>Select Value</option>";
			}

			formBean.setStrStoreNameCombo(temp);
			bo.getCategoryList(vo);
//			System.out.println("Store Name------------>"+formBean.getStrStoreNameCombo());
			
//-----------------------------------Item Category----------------------------------------------	
			
			
			if (vo.getStrMsgType().equals("1")) { 
				throw new Exception(vo.getStrMsgString());
			}
			String temp2 = "";

			if (vo.getWsItemCategoryCombo() != null	&& vo.getWsItemCategoryCombo().size() > 0) 
			{
				temp2 = hisutil.getOptionValue(vo.getWsItemCategoryCombo(),"0", "0^Select Value", false);

			} else {

				temp2 = "<option value='0'>Select Value</option>";
			}
			formBean.setStrItemCategoryCombo(temp2);
//			System.out.println("Item Category------------>"+formBean.getStrItemCategoryCombo());
			
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);	
			
		} catch (Exception e) {

			e.printStackTrace();
			
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",	"ReceiveFromThirdPartyTransDATA->initialGenAdd()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			
			hisutil = null;
	
		}
	}
	
	public static void lpitemName(StockBarCodeTransFB formBean,HttpServletRequest request, HttpServletResponse response) {
		StockBarCodeTransVO vo=null;
		StockBarCodeTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCat = "";
		String strGrpCmb = "";	
		try {
			hisutil = new HisUtil("MMS","LocalPurchaseMRN_DATA");
			vo = new StockBarCodeTransVO();
			bo = new StockBarCodeTransBO();
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			itemCat = (String) request.getParameter("itemCat");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setlpItemvalue(itemCat);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setlpItemvalue(itemCat);	
			vo.setStrItemCategoryId(itemCat);
			vo.setStrStoreId((String) request.getParameter("strStoreId"));
			
			bo.lpitemName(vo);	
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			String temp1 = "";
			if (vo.getWslpItemName() != null	&& vo.getWslpItemName().size() > 0){
				temp1 = hisutil.getOptionValue(vo.getWslpItemName(), "0",	"0^All", true);
			} 
			else {
				temp1 = "<option value='0'>All</option>";
			}

			formBean.setlpItemName(temp1);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp1);
									
		} catch (Exception e) {
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ItemWiseConsumptionRptDATA->groupName()", strmsgText);
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
	
	public static void getItemBatch(StockBarCodeTransFB formBean,HttpServletRequest request, HttpServletResponse response) {
		StockBarCodeTransVO vo=null;
		StockBarCodeTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCat = "";
		String strGrpCmb = "";	
		try {
			hisutil = new HisUtil("MMS","LocalPurchaseMRN_DATA");
			vo = new StockBarCodeTransVO();
			bo = new StockBarCodeTransBO();
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			itemCat = (String) request.getParameter("itemCat");
			
		
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setlpItemvalue(itemCat);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setlpItemvalue(itemCat);	
			vo.setStrItemCategoryId(itemCat);
			vo.setStrStoreId((String) request.getParameter("strStoreId"));
			vo.setStrItemBrandId((String) request.getParameter("strItemId"));
			
			bo.getItemBatch(vo);	
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			String temp1 = "";
			if (vo.getStrExistingBatchComboWS() != null	&& vo.getStrExistingBatchComboWS().size() > 0){
				temp1 = hisutil.getOptionValue(vo.getStrExistingBatchComboWS(), "0",	"0^All", true);
			} 
			else {
				temp1 = "<option value='0'>All</option>";
			}

			formBean.setlpItemName(temp1);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp1);
									
		} catch (Exception e) {
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ItemWiseConsumptionRptDATA->getItemBatch()", strmsgText);
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
	
	public static void getViewDtl(StockBarCodeTransFB fb,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
		   StockBarCodeTransVO vo = null;
		   StockBarCodeTransBO bo = null;
		   ReportUtil ts = new ReportUtil();		
		   String reportFormat = "html";
		   String strReportName = "Issue Details";
		   Map<String, Object> params = new HashMap<String, Object>();
		   try
		   {
			    String strResult="";
			    vo=new StockBarCodeTransVO();
			   	bo=new StockBarCodeTransBO();
			   	HttpSession session = request.getSession(true);  

			   				   
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());	
			   	
			   	System.out.println("-getStrStoreId---"+fb.getStrStoreId());
			   	System.out.println("--getStrCategoryId---"+fb.getStrItemCategoryId());
				System.out.println("--getStrCategoryName---"+fb.getStrCategoryName());
				System.out.println("--getStrItemId---"+fb.getStrItemId());
				System.out.println("--getStrGeneType---"+fb.getStrGeneType());
				System.out.println("--getStrBatchNo---"+fb.getStrBatchNo());
				System.out.println("--getStrSizeId---"+fb.getStrSizeId());
				
				/*
				
				vo.setStrStoreId(fb.getStrStoreId());	 	
			   	vo.setStrItemCategoryId(fb.getStrItemCategoryId());					
				vo.setStrStoreName(fb.getStrStoreName());
				vo.setStrCategoryName(fb.getStrCategoryName()); 				
				vo.setStrItemBrandId(fb.getStrItemId());			
				vo.setStrGeneType(fb.getStrGeneType());
				vo.setStrBatchNo(fb.getStrBatchNo());	
				vo.setStrSizeId(fb.getStrSizeId());
				*/
			   	
			   	
			   	vo.setStrStoreId(request.getParameter("storeId"));	 	
			   	vo.setStrItemCategoryId(request.getParameter("strCategoryId"));					
				vo.setStrStoreName(request.getParameter("storeName"));
				vo.setStrCategoryName(request.getParameter("strCategoryName")); 				
				vo.setStrItemBrandId(request.getParameter("strItemId"));			
				vo.setStrGeneType(request.getParameter("strGeneType"));
				vo.setStrBatchNo(request.getParameter("strBatchNo"));	
				vo.setStrSizeId(request.getParameter("strSizeId"));
				
				
												
				//bo.getImgHeader(vo);
				bo.setViewPageDtl(vo);  // PKG_MMS_VIEW2.proc_storewise_brand_list [ Mode - 2 ]
				//strResult=StockBarCodeTransHLP.getTransferDetails(vo,request);
				//if(vo.getStrGeneType().equals("1"))
				//{
				    strResult=StockBarCodeTransHLP.getBarCodeGeneration(vo,request);
				//}
				//else
				//{
				//	strResult=StockBarCodeTransHLP.getBarCodeSave(vo,request);
				//}	
				    System.out.println("--strResult---"+strResult);
				
				    session.setAttribute("sampleNoLabelBarCodeString", strResult);

				
		   }
		   catch(Exception _err)
		   {
			   _err.printStackTrace();
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "StockBarCodeTransDATA->getViewDtl()", strmsgText);
				fb.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//fb.setStrMsgType("1");
				eObj = null;
		   }	   
	}
	
	public static void insert( StockBarCodeTransFB formBean, HttpServletRequest request) 
	{
		 StockBarCodeTransVO vo = null;
		 StockBarCodeTransBO bo = null;
		 String strmsgText = null;
		try 
		{
			 bo = new  StockBarCodeTransBO();
			 vo = new StockBarCodeTransVO();
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
						
			vo = ( StockBarCodeTransVO) TransferObjectFactory.populateData("mms.transactions.vo.StockBarCodeTransVO",formBean);
												
            // Calling BO method
			
			bo.insert(vo);
			//formBean.setStrMsgType(vo.getStrMsgType());
			if (vo.getStrMsgType().equals("1"))
			{	
				throw new Exception(vo.getStrMsgString());
			}
			else if(vo.getStrMsgType().equals("2"))
			{
				strmsgText="Record Does Not Exists";
				formBean.setStrNormalMsg(strmsgText);
				
			}
			else
			{	
				strmsgText = "Bar Code Saved Successfully For [ "+vo.getStrBItemName()+" ] ";	
				formBean.setStrNormalMsg(strmsgText);
			}
		}
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			HisException hisException = new HisException("Material Management System"," StockBarCodeTransDATA.insert()---->", _Err.getMessage());
			formBean.setStrErrMsg("Error####Application Error [ERROR ID : "+ hisException.getErrorID()+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
}
