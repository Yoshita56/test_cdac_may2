package mms.transactions.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.transactions.bo.ReturnAndCondemnationRegisterTransBO;
import mms.transactions.controller.fb.ReturnAndCondemnationRegisterTransFB;
import mms.transactions.controller.hlp.ReturnAndCondemnationRegisterTransHLP;
import mms.transactions.vo.ReturnAndCondemnationRegisterTransVO;

public class ReturnAndCondemnationRegisterTransDATA 
{
	public static void initialPage(ReturnAndCondemnationRegisterTransFB formBean,HttpServletRequest request) {
		ReturnAndCondemnationRegisterTransVO vo=null;
		ReturnAndCondemnationRegisterTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String cmb = "",strCondemnationTypeCmbOptions="",strCatName="";
		
			
		try {
			vo = new ReturnAndCondemnationRegisterTransVO();
			bo = new ReturnAndCondemnationRegisterTransBO();
			
			hisutil = new HisUtil("mms", "ReturnAndCondemnationRegisterTransDATA");
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
			
			
			if (vo.getWsCondemnationTypeDtl()!= null && vo.getWsCondemnationTypeDtl().size() > 0) 
			{			
				strCondemnationTypeCmbOptions = hisutil.getOptionValue(vo.getWsCondemnationTypeDtl(), "", "", true);
			}
			else 
			{
				strCondemnationTypeCmbOptions = "<option value='0'>Select Value</option>";
			}
			
			//System.out.println(strCondemnationTypeCmbOptions);
			
			formBean.setStrCondemnationTypeCmbOptions(strCondemnationTypeCmbOptions);
			//System.out.println("cmb>>>>>>>>>"+cmb);
			formBean.setStrStoreName(cmb);	
			//System.out.println("formBean.setStrStoreName"+formBean.getStrStoreName());
												
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ReturnAndCondemnationRegisterTransDATA->initialPage()", strmsgText);
			formBean.setStrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	
	
	public static void getReturnOrCondemnDrugListHlp(ReturnAndCondemnationRegisterTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReturnAndCondemnationRegisterTransBO bo = null;
		ReturnAndCondemnationRegisterTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;

		try {
			bo = new ReturnAndCondemnationRegisterTransBO();
			vo = new ReturnAndCondemnationRegisterTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrActionId(request.getParameter("strActionsId"));
			vo.setStrItemCatNo(request.getParameter("strcatno"));
			vo.setStrSupplierId(request.getParameter("strsupplierno"));
			//System.out.println("request.getParameter"+request.getParameter("strsupplierno"));
			// BO Method
			bo.getReturnOrCondemnDrugListHlp(vo);  // pkg_mms_view.proc_Ret_And_Condemn_Register [ Mode - 1]

			String strNOSQDrugDtl = ReturnAndCondemnationRegisterTransHLP.getReturnOrCondemnDrugListHlp(vo);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strNOSQDrugDtl);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReturnAndCondemnationRegisterTransDATA.getNOSQDrugListHLP() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReturnAndCondemnationRegisterTransDATA->getNOSQDrugListHLP()", strmsgText);
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

	
	
	public static void getReturnOrCondemnDrugListHlpNEW(ReturnAndCondemnationRegisterTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReturnAndCondemnationRegisterTransBO bo = null;
		ReturnAndCondemnationRegisterTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;

		try {
			bo = new ReturnAndCondemnationRegisterTransBO();
			vo = new ReturnAndCondemnationRegisterTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrActionId(request.getParameter("strActionsId"));
			vo.setStrItemCatNo(request.getParameter("strcatno"));
			vo.setStrSupplierId(request.getParameter("strsupplierno"));
			//System.out.println("request.getParameter"+request.getParameter("strsupplierno"));
			// BO Method
			bo.getReturnOrCondemnDrugListHlp(vo);

			String strNOSQDrugDtl = ReturnAndCondemnationRegisterTransHLP.getReturnOrCondemnDrugListHlp(vo);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strNOSQDrugDtl);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReturnAndCondemnationRegisterTransDATA.getNOSQDrugListHLP() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReturnAndCondemnationRegisterTransDATA->getNOSQDrugListHLP()", strmsgText);
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

	
	
	public static void GETCATCMB(ReturnAndCondemnationRegisterTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReturnAndCondemnationRegisterTransBO bo = null;
		ReturnAndCondemnationRegisterTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null ,strItemVal;

		try {
			bo = new ReturnAndCondemnationRegisterTransBO();
			vo = new ReturnAndCondemnationRegisterTransVO();

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
				//response.getWriter().print(strItemVal);			    	
			}	

			//String strNOSQDrugDtl = ReturnAndCondemnationRegisterTransHLP.getReturnOrCondemnDrugListHlp(vo);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemVal);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReturnAndCondemnationRegisterTransDATA.getNOSQDrugListHLP() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReturnAndCondemnationRegisterTransDATA->getNOSQDrugListHLP()", strmsgText);
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
	
	public static void getsuppliernamecmb(ReturnAndCondemnationRegisterTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReturnAndCondemnationRegisterTransBO bo = null;
		ReturnAndCondemnationRegisterTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null ,strItemVal;

		try {
			bo = new ReturnAndCondemnationRegisterTransBO();
			vo = new ReturnAndCondemnationRegisterTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrItemCatNo(request.getParameter("catcode"));
			
			// BO Method
			bo.getsuppliername(vo);
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{				
				util = new HisUtil("MMS","IssueDetailRptData");
				strItemVal=util.getOptionValue(vo.getSupplierWS(), "0","0^Select Value", false);
				//response.getWriter().print(strItemVal);			    	
			}	

			//String strNOSQDrugDtl = ReturnAndCondemnationRegisterTransHLP.getReturnOrCondemnDrugListHlp(vo);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemVal);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReturnAndCondemnationRegisterTransDATA.getNOSQDrugListHLP() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReturnAndCondemnationRegisterTransDATA->getNOSQDrugListHLP()", strmsgText);
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
	public static String toCSV(String[] array) {
	    String result = "";
	
	    if (array.length > 0) {
	        StringBuilder sb = new StringBuilder();
	
	        for (String s : array) {
	            sb.append(s).append(",");
	        }
	
	        result = sb.deleteCharAt(sb.length() - 1).toString();
	    }
	    return result;
	}
	public static void insert( ReturnAndCondemnationRegisterTransFB formBean, HttpServletRequest request) 
	{
		 ReturnAndCondemnationRegisterTransVO vo = null;
		 ReturnAndCondemnationRegisterTransBO bo = null;
		 String strmsgText = null;
		try 
		{
			 bo = new  ReturnAndCondemnationRegisterTransBO();
			 vo = new ReturnAndCondemnationRegisterTransVO();
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
						
			vo = ( ReturnAndCondemnationRegisterTransVO) TransferObjectFactory.populateData("mms.transactions.vo.ReturnAndCondemnationRegisterTransVO",	formBean);
            // Calling BO method
			bo.insert(vo);
			 StringBuilder sb = new StringBuilder();
			String strHiddenItemDtl=null;
			for(int i=0; i< formBean.getStrNosqDrugs().length;i++)
			{
			strHiddenItemDtl = formBean.getStrNosqDrugs()[i]; // set all hidden dtl in itembrand id field
			if(formBean.getStrNosqDrugs().length==1)
			sb.append(strHiddenItemDtl);
			else
			 sb.append(strHiddenItemDtl).append("@@@");	
			}
			if(formBean.getStrActionId().equalsIgnoreCase("1"))
			{
				formBean.setStrTmpStoreId(formBean.getStrStoreId());
				formBean.setStrTmpItemcatId(formBean.getStrcatno());
				formBean.setStrTmpSupplierId(formBean.getStrsupplierno());
				formBean.setStrTmpitembrandId(sb.toString());
			}
				
			formBean.setStrMsgType(vo.getStrMsgType());
			if (vo.getStrMsgType().equals("1"))
			{	
				throw new Exception(vo.getStrMsgString());
			}
			else
			{	
				//if(formBean.getStrActionsId().equalsIgnoreCase("1")) //||formBean.getStrActionsId().equalsIgnoreCase("2")
			//	{
				formBean.setStrsaveflag("1");
				formBean.setStrVoucherFlag("1");//To open voucher
				//}
				strmsgText = "Record Saved Successfully!";
				formBean.setStrMsg(strmsgText);
				
				formBean.setStrTmpStoreId(vo.getStrStoreId());
			}
		}
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			HisException hisException = new HisException("Material Management System"," ReturnAndCondemnationRegisterTransDATA.insert()---->", _Err.getMessage());
			formBean.setStrErr("Error####Application Error [ERROR ID : "+ hisException.getErrorID()+ "], Contact System Administrator! ");
			hisException = null;
		}
	}


	public static void voucherPrint(ReturnAndCondemnationRegisterTransFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   ReturnAndCondemnationRegisterTransVO vo = null;
		   ReturnAndCondemnationRegisterTransBO bo = null;
		   String strResult = "A";
		   try{
			   	
			    vo=new ReturnAndCondemnationRegisterTransVO();
			   	bo=new ReturnAndCondemnationRegisterTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreId(request.getParameter("storeId"));
			   	vo.setStrcatno(request.getParameter("itemcatno"));
				vo.setStrSupplierId(request.getParameter("supplierid"));
				StringBuilder brandid = new StringBuilder();
				StringBuilder batchno = new StringBuilder();
				StringBuilder orderno = new StringBuilder();
				String temp=request.getParameter("itembrandid").toString();
				String[] temp1=temp.split("@@@");
				int len=temp1.length;
				for(int i=0 ;i<len;i++)
				{
					brandid.append(temp1[i].split("\\^")[1]).append(",");
					batchno.append("'"+temp1[i].split("\\^")[2]).append("',");
					orderno.append(temp1[i].split("\\^")[4]).append(",");
				}
			    //System.out.println("batchno===>>"+batchno.toString());
				////System.out.println("batch no=="+batchno.deleteCharAt(batchno.length()-1).toString());
				////System.out.println("order no"+orderno.deleteCharAt(orderno.length()-1).toString());
				////System.out.println("brand id=="+brandid.deleteCharAt(brandid.length()-1).toString());
				
				vo.setStrHiddenValue(request.getParameter("strHidVal"));
			   	/*if(len==1)
			   	{
			   		vo.setStrItemBrandId(brandid.toString());
				   	vo.setStrBatchNo(batchno.toString().toUpperCase());
				   	vo.setStrOrderNo(orderno.toString());
			   		
			   	}else
			   	{*/
			   		vo.setStrItemBrandId(brandid.deleteCharAt(brandid.length()-1).toString());
				   	vo.setStrBatchNo(batchno.deleteCharAt(batchno.length()-1).toString().toUpperCase());
				   	vo.setStrOrderNo(orderno.deleteCharAt(orderno.length()-1).toString());
			   		
			   //	}
			   	

			   	bo.getVoucherDtl(vo);
			   
			    strResult=ReturnAndCondemnationRegisterTransHLP.getvoucherPrintDetails(vo);
			    if(strResult!= null)
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	
				 	response.getWriter().print(strResult);
				 		 
				}
				 else
				 {
				    HisException eObj = new HisException("MMS", "ReturnAndCondemnationRegisterTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "ReturnAndCondemnationRegisterTransDATA->getViewDtl()", strmsgText);
				formBean.setStrErr("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				formBean.setStrMsgType("1");
				eObj = null;
		   }
		
	}
	
	
}

