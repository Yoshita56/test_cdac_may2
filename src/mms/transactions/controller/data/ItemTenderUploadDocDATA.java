package mms.transactions.controller.data;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.UserVO;
import mms.AttachFileGlobal;
import mms.transactions.bo.ItemTenderUploadDocBO;
import mms.transactions.controller.fb.ItemTenderUploadDocFB;
import mms.transactions.vo.ItemTenderUploadDocVO;

public class ItemTenderUploadDocDATA {

	public static void getInitializedValues(ItemTenderUploadDocFB formBean, HttpServletRequest request_p, HttpServletResponse response) {
		ItemTenderUploadDocBO bo = null;
		ItemTenderUploadDocVO vo = null;
		HisUtil hisutil = null;
		String strStoreVal = "";
		String strMsgText = null;
		String strCurrentDate;
		try	{
			bo = new ItemTenderUploadDocBO();
			vo = new ItemTenderUploadDocVO();
			hisutil = new HisUtil("MMS","ItemTenderUploadDocDATA");
			formBean.setStrHospitalCode(request_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			bo.getInitializedValues(vo);
			
			if (vo.getStrMsgType().equals("1"))	{

				throw new Exception(vo.getStrMsgString());
			}
			hisutil = new HisUtil("MMS Transactions", "ItemTenderUploadDocDATA");
			if(vo.getWrsDrugWareHouseNameCmb()!=null && vo.getWrsDrugWareHouseNameCmb().size()>0)	{
				if(vo.getStrDrugWareHouseTypeId()!=null && !vo.getStrDrugWareHouseTypeId().equals("")){
					strStoreVal = hisutil.getOptionValue(vo.getWrsDrugWareHouseNameCmb(), vo.getStrDrugWareHouseTypeId(),"0^Select Value", false);
				}
				else	{
					strStoreVal = hisutil.getOptionValue(vo.getWrsDrugWareHouseNameCmb(), "","0^Select Value", false);
				}
				
			}
			else	{
				strStoreVal = "<option value='0'>Select Value</option>";
			}				
			formBean.setStrDrugWareHouseNameCmb(strStoreVal);
		} 
		catch (Exception e) {
			e.printStackTrace();
			strMsgText = "mms.transactions.ItemTenderUploadDocDATA.getDrugWareHouseNameCombo --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",	"UpdateStockStatusTransDATA->getDrugWareHouseNameCombo()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
		}
	}
	public static void getITEMNameValues(ItemTenderUploadDocFB ItemTenderUploadDocFB_p,	HttpServletRequest request_p, HttpServletResponse response) {

		ItemTenderUploadDocBO bo = null;
		ItemTenderUploadDocVO voObj = null;
		String strMsgText = null;
		HisUtil hisutil = null;
		String strStockStatusCmb=null;
		
		String strHospitalCode;
		
		try {

			bo = new ItemTenderUploadDocBO();
			voObj = new ItemTenderUploadDocVO();
			
			strHospitalCode=request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			ItemTenderUploadDocFB_p.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
			hisutil = new HisUtil("DWH","UpdateStockStatusTransDATA");
					  
			voObj.setStrMode("1");
			
			voObj.setStrGenericItemId(request_p.getParameter("strGenericItemId"));	 
			
			bo.getITEMNameValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			if (voObj.getStrStockStatusWs() != null && voObj.getStrStockStatusWs().size() > 0) 
			{
				strStockStatusCmb = hisutil.getOptionValue(voObj.getStrStockStatusWs(),	"0", "0^Select Value",	true);

			} else {
				strStockStatusCmb = "<option value='0'>Select Value</option>";

			}
			System.out.println("--strStockStatusCmb---"+strStockStatusCmb);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStockStatusCmb);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.report.UpdateStockStatusTransDATA.getDrugNameValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"UpdateStockStatusTransDATA->getDrugNameValues()", strMsgText);
			ItemTenderUploadDocFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (hisutil != null)
				hisutil = null;
		}
	}
	
	public static void getFtpProperties(ItemTenderUploadDocFB formBean, HttpServletRequest request_p)
	{
		ItemTenderUploadDocBO bo=null;
		ItemTenderUploadDocVO vo = null;		
		String strmsgText="";
		HisUtil util = null;
		
		try {
			
			util = new HisUtil("bmed", "getFtpProperties");						
			bo   = new ItemTenderUploadDocBO();		
            vo   = new ItemTenderUploadDocVO();
            
			bo.getFtpProperties(vo);

			   WebRowSet ws = vo.getWrsFTPDtls();
			   if (ws != null && ws.size() > 0) {
					if (ws.next()) {
							System.out.println(ws.getString(1));
							System.out.println(ws.getString(2));        							
							System.out.println(ws.getString(3));
						
						   formBean.setStrFtpConnectionUri(ws.getString(1));
						   formBean.setStrFtpUsername(ws.getString(2));
						   formBean.setStrFtpPassword(ws.getString(3));
						   formBean.setStrFtpRptconnection(ws.getString(5));
						   formBean.setStrFtpdestpath(ws.getString(4));
						   formBean.setStrFtpPort(ws.getString(8));
					}
			   }
			   
		  
		   
		   
		}
		catch(Exception _err){
	    
			_err.printStackTrace();
	    strmsgText = "Issue Desk.OTAdviceTransDATA.getPatientVisitDtls_PAC_CRNO(vo) ------> "
				+ _err.getMessage();
		HisException eObj = new HisException("mms",
				"OTAdviceTransDATA->getIndentDetails()", strmsgText);
		formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		}
	}


	public static void saveData(ItemTenderUploadDocFB ItemTenderUploadDocFB, HttpServletRequest request_p) {
		String strErrMsg;
		String strSeatId_p;
		String strHospitalCode_p;
		UserVO userVo = null;
		String strFileExt;
		ItemTenderUploadDocVO ItemTenderUploadDocVO =null;
		String strFileId="0";
		String[] temp = null;
		HisUtil hisutil = null;
		String strFtpFolderName ="";
		String strCurrentDate;
		AttachFileGlobal fs=null;
		String strFileName =null;
		try {					     
			                    
				HisUtil his=new HisUtil(" ", " ");
				fs=new AttachFileGlobal();
				hisutil = new HisUtil("MMS", "ItemTenderUploadDocDATA");
				ItemTenderUploadDocVO = new ItemTenderUploadDocVO();
				
				strHospitalCode_p = userVo.getHospitalCode();
				strSeatId_p = userVo.getSeatId();
				
				ItemTenderUploadDocVO.setFTPPath(ItemTenderUploadDocFB.getFTPPath());
				
				ItemTenderUploadDocVO.setStrItemBrandId(ItemTenderUploadDocVO.getFTPPath().split("\\_")[1]);
				ItemTenderUploadDocVO.setStrItemId(ItemTenderUploadDocVO.getFTPPath().split("\\_")[0]);
				
				ItemTenderUploadDocVO.setStrUploadFileName3(request_p.getParameter("strUploadname1"));
				ItemTenderUploadDocVO.setStrUploadFileName4(request_p.getParameter("strUploadname2"));
				 
				System.out.println(ItemTenderUploadDocVO.getStrItemBrandId());
				System.out.println(ItemTenderUploadDocVO.getStrItemId());
				
				System.out.println("---ItemTenderUploadDocVO.setStrUploadFileId3----"+ItemTenderUploadDocVO.getStrUploadFileName3());
				System.out.println("---ItemTenderUploadDocVO.setStrUploadFileId4----"+ItemTenderUploadDocVO.getStrUploadFileName4());
				
				ItemTenderUploadDocBO.saveItemWarrantyDetails(ItemTenderUploadDocVO);
			   
			   if (ItemTenderUploadDocVO.getStrMsgType().equals("0")) {
				   ItemTenderUploadDocFB.setStrNormalMsg("Data Saved Successfully");
			   }

		}
		catch (Exception e) {
			e.printStackTrace();
			     strErrMsg = "ItemWarrantyDtlsTransDATA.saveData() ----> "	+ e.getMessage();
		 HisException eObj = new HisException("BMED", "ItemWarrantyDtlsDATA",strErrMsg);
		ItemTenderUploadDocFB.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
		eObj = null;
		}
		
	}
	
	public static void getwarranty_sl_no(ItemTenderUploadDocFB FB, HttpServletRequest request_p,HttpServletResponse response_p) {
		String strErrMsg;
		ItemTenderUploadDocBO BO=null;
		String strHospitalCode_p;
		UserVO userVo = null;
		ItemTenderUploadDocVO VO;
		try
		{
			  	   VO = new ItemTenderUploadDocVO();
			  	 
			       BO = new ItemTenderUploadDocBO();
			      
				   strHospitalCode_p = userVo.getHospitalCode();
				   VO.setStrHospitalCode(strHospitalCode_p);
				   
				   System.out.println("<--------strHospitalCode_p--------->"+VO.getStrHospitalCode());
				    
				   BO.getwarranty_sl_no(VO);

				   
			} catch (Exception e) {
				e.printStackTrace();
				strErrMsg = "ItemTenderUploadDocDATA.getwarranty_sl_no() --> "
						+ e.getMessage();
				HisException eObj = new HisException("BMED", "ItemTenderUploadDocDATA",
						strErrMsg);
				FB.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");
	
				eObj = null;
			}
	
        }
	
}
