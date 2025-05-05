package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.bo.QcDetailOnlineTransBO;
import mms.transactions.controller.fb.QcDetailOnlineTransFB;
import mms.transactions.controller.hlp.QcDetailOnlineTransHLP;
import mms.transactions.vo.QcDetailOnlineTransVO;

/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 11-Jan-2012
 * Modification Date: 
 *  
*/
public class QcDetailOnlineTransDATA
{
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Breakage Item Details Transaction 
	 * @param formBean
	 * @param request
	 */
	public static void GetData(QcDetailOnlineTransFB qcDetailOnlineTransFB_p,HttpServletRequest request) 
	{
		/* Declaring Variable */
		
		
		String strmsgText = "";
		String    hosCode = "";
		HisUtil   hisUtil = null;
	    String     seatId = "";
	    QcDetailOnlineTransBO bo = null;
		QcDetailOnlineTransVO vo = null;
		String strLabNameVal="";
		HisUtil hisutil = null;
			
		
		try 
		{
			/* Creating Object */
			
					     bo = new QcDetailOnlineTransBO();
					     vo = new QcDetailOnlineTransVO();
					hisUtil = new HisUtil("MMS", "QcDetailOnlineTransDATA");

			
            /* Getting Value from Session */ 
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId  = request.getSession().getAttribute("SEATID").toString();
			hisutil = new HisUtil("DWH","BudgetDetailRptDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			qcDetailOnlineTransFB_p.setStrCtDate(ctDate);
			
			
			
			vo.setStrStoreId(qcDetailOnlineTransFB_p.getStrStoreName()); // Store Id			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrIssueNo("0");	
			vo.setStrIndentNo("0");
			vo.setStrItemCategoryNo(qcDetailOnlineTransFB_p.getStrItemCatgCombo());
			/* Calling QcDetailOnlineTransBO method  */
			bo.GetData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			 qcDetailOnlineTransFB_p.setStrStoreName(vo.getStrStoreName());
			 qcDetailOnlineTransFB_p.setStrIndentPeriodCombo(vo.getStrIndentPeriodCombo());	 
			 qcDetailOnlineTransFB_p.setStrHospitalCode(hosCode);
			 qcDetailOnlineTransFB_p.setStrSeatId(seatId);
			 qcDetailOnlineTransFB_p.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 qcDetailOnlineTransFB_p.setStrItemCatgCombo(vo.getStrItemCategoryCmb());
			
			    hisutil = new HisUtil("MMS Transactions", "UpdateStockStatusTransDATA");
				
				if(vo.getStrWrsLabName()!=null && vo.getStrWrsLabName().size()>0)
				{
					
					strLabNameVal = hisutil.getOptionValue(vo.getStrWrsLabName(), "0","0^Select Value", false);
				}
				
				else
				{
					strLabNameVal = "<option value='0'>Select Value</option>";
				}
			 
			 
			 qcDetailOnlineTransFB_p.setStrLabName(strLabNameVal);
			 
			
			 			 
		}
		  catch (Exception e) 
		  {
           e.printStackTrace();
			strmsgText = "QcDetailOnlineTransDATA.GetData(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("MMS",	"QcDetailOnlineTransDATA->GetData()", strmsgText);
			qcDetailOnlineTransFB_p.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	
	
	/**
	 * (request,response,formBean) -- >
	 * This Method generate the Ajax Response for Item Category Combo 
	 * on the basis of Store Id
	 * @param request
	 * @param response
	 * @param form
	 */	
	public static void getLabNameCombo(HttpServletRequest request, HttpServletResponse response,QcDetailOnlineTransFB qcDetailOnlineTransFB_p) 
	{
		   /* Declaring Variables */
		   String     seatId;
		   String strLabNameVal;
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   QcDetailOnlineTransVO vo = null;
		   QcDetailOnlineTransBO bo = null;
		   HisUtil hisutil = null;
		try
		{  
			     vo = new QcDetailOnlineTransVO();
		         bo = new QcDetailOnlineTransBO();
		    hisutil = new HisUtil("transaction", "QcDetailOnlineTransDATA");
		   
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			seatId  = request.getSession().getAttribute("SEATID").toString();
			
			vo.setStrStoreId(request.getParameter("storeId")); // Store Id		
			vo.setStrItemCategoryNo(request.getParameter("categoryNo")); // Store Id			
	       	vo.setStrSeatId(seatId);
			/* Call BO Indenting Store Combo Method */
			bo.getLabNameCombo(vo);
		    /* Indent Store Combo */
			
			 hisutil = new HisUtil("MMS Transactions", "UpdateStockStatusTransDATA");
				
				if(vo.getStrWrsLabName()!=null && vo.getStrWrsLabName().size()>0)
				{
					
					strLabNameVal = hisutil.getOptionValue(vo.getStrWrsLabName(), "0","0^Select Value", false);
				}
				
				else
				{
					strLabNameVal = "<option value='0'>Select Value</option>";
				}
							
				
			 	response.setHeader("Cache-Control", "no-cache");
			 	response.getWriter().print(strLabNameVal);
			
			
	    }
		catch (Exception e)
		{
			
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "QcDetailOnlineTransDATA->IndentingStoreCombo()", strmsgText);
			qcDetailOnlineTransFB_p.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			qcDetailOnlineTransFB_p.setStrMsgType("1");
			eObj = null;
		} 
		finally 
		{
    		if (vo != null)
				vo = null;
			if(hisutil != null) hisutil = null;
			if (bo != null)
				bo = null;
		}
    
	}
	
	
	 public static void printSampleLabelView(QcDetailOnlineTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	 {

				QcDetailOnlineTransBO bo = null;
				QcDetailOnlineTransVO vo = null;
				//MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new QcDetailOnlineTransBO();
					vo = new QcDetailOnlineTransVO();
					//mcu = new MmsConfigUtil();
																	
				
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					
					////System.out.println("request.getParameter(strHiddenDtl)==>"+request.getParameter("strHiddenDtl"));
					String strSampleSentLabel = QcDetailOnlineTransHLP.getPrintSampleSentLabel(request.getParameter("strHiddenDtl"));					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strSampleSentLabel);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.printSampleLabel() --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getItemDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	 
	 
	 public static void printSampleLabelViewPrint(QcDetailOnlineTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	 {

				QcDetailOnlineTransBO bo = null;
				QcDetailOnlineTransVO vo = null;
				//MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new QcDetailOnlineTransBO();
					vo = new QcDetailOnlineTransVO();
					//mcu = new MmsConfigUtil();
																	
				
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					
					////System.out.println("request.getParameter(strSampleSentPrintHiddenDtl)==>"+request.getParameter("strSampleSentPrintHiddenDtl"));
					String strSampleSentLabel = QcDetailOnlineTransHLP.getPrintSampleSentLabelView(request.getParameter("strSampleSentPrintHiddenDtl"));					
					////System.out.println("strSampleSentLabel==>"+strSampleSentLabel);
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strSampleSentLabel);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.printSampleLabelViewPrint() --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->printSampleLabelViewPrint()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	
	
	/**
	 * ApprovedVerifyCombo(request,response,formBean) -- >
	 * This Method generate the Ajax Response for ApprovedVerifyCombo Combo 
	 * on the basis of Store Id
	 * @param request
	 * @param response
	 * @param form
	 */	
	public static void ApprovedVerifyCombo(HttpServletRequest request, HttpServletResponse response,QcDetailOnlineTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   QcDetailOnlineTransVO vo = null;
		   QcDetailOnlineTransBO bo = null;
		   HisUtil   hisutil = null;
		try
		{  
			     vo = new QcDetailOnlineTransVO();
		         bo = new QcDetailOnlineTransBO();
		    hisutil = new HisUtil("transaction", "QcDetailOnlineTransDATA");
		     strChk = request.getParameter("modName");
		    String[] temp = strChk.split("\\^");
		    vo.setStrStoreId(temp[0]);
		    vo.setStrIndentingStoreID(temp[1]);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO Approve & Verify COMBO Method */
			bo.ApprovedVerifyCombo(vo);
		    /* ItemCategory Combo */
			
			if(vo.getStrApprovedBy()!= null || vo.getStrVerifiedByValues()!=null )
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	//strRes = vo.getStrApprovedBy()+"@"+vo.getStrVerifiedByValues();
			 	strRes = vo.getStrVerifiedByValues();
			 	response.getWriter().print(strRes);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "QcDetailOnlineTransDATA->IndentingStoreCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "QcDetailOnlineTransDATA->IndentingStoreCombo()", strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} 
		finally 
		{
    		if (vo != null)
				vo = null;
			if(hisutil != null) hisutil = null;
			if (bo != null)
				bo = null;
		}
    
	}
	
	
	public static void getCurrentStockDtls(QcDetailOnlineTransFB qcDetailOnlineTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		QcDetailOnlineTransBO qcDetailOnlineTransBO = null;
		QcDetailOnlineTransVO qcDetailOnlineTransVO = null;
		

		String strCurrentDetailsTable;
		String strMsgText = "";
		String	strHospitalCode;
		String strFinancialYear;
		HisUtil hisutil=null;
		try {
			qcDetailOnlineTransBO = new QcDetailOnlineTransBO();
			qcDetailOnlineTransVO = new QcDetailOnlineTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","QcDetailOnlineTransDATA");


			qcDetailOnlineTransVO.setStrHospitalCode(strHospitalCode);
			qcDetailOnlineTransVO.setStrItemCategoryNo(request_p.getParameter("categoryCode"));
			
			qcDetailOnlineTransVO.setStrStoreId(request_p.getParameter("storeId"));
			qcDetailOnlineTransVO.setStrLabId(request_p.getParameter("labNo")); // Drug Id
			
			qcDetailOnlineTransVO.setStrSeatId(qcDetailOnlineTransFB_p.getStrSeatId());
			qcDetailOnlineTransVO.setStrHospitalCode(strHospitalCode);
			
			
			qcDetailOnlineTransVO.setStrMode("3");
			
			
			//Calling BO
			qcDetailOnlineTransBO.getSampleSentDtl(qcDetailOnlineTransVO);

			if (qcDetailOnlineTransVO.getStrMsgType().equals("1")) 
			{
				throw new Exception(qcDetailOnlineTransVO.getStrMsgString());
			}
		
			
					
			strCurrentDetailsTable	=	QcDetailOnlineTransHLP.getViewSampleSentDetails(qcDetailOnlineTransVO);
			
			
		
			
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strCurrentDetailsTable);
			
		} 
		catch (Exception e) 
		{
			strMsgText = "QcDetailOnlineTransDATA.getCurrentStockDtls(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","QcDetailOnlineTransDATA->QcDetailOnlineTransDATA()", strMsgText);
			qcDetailOnlineTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			qcDetailOnlineTransBO = null;
			qcDetailOnlineTransVO = null;
		}
	}
	
	
	public static void GET_SAMPLESENT_DTLS_WITHSEARCHSTRING(QcDetailOnlineTransFB qcDetailOnlineTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		QcDetailOnlineTransBO qcDetailOnlineTransBO = null;
		QcDetailOnlineTransVO qcDetailOnlineTransVO = null;
		

		String strCurrentDetailsTable;
		String strMsgText = "";
		String	strHospitalCode;
		try {
			qcDetailOnlineTransBO = new QcDetailOnlineTransBO();
			qcDetailOnlineTransVO = new QcDetailOnlineTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			           
			qcDetailOnlineTransVO.setStrHospitalCode(strHospitalCode);
			qcDetailOnlineTransVO.setStrItemCategoryNo(request_p.getParameter("categoryNo"));			
			qcDetailOnlineTransVO.setStrStoreId(request_p.getParameter("storeId"));
			qcDetailOnlineTransVO.setStrLabId(request_p.getParameter("labId")); // Drug Id
            qcDetailOnlineTransVO.setStrSearchType(request_p.getParameter("searchType"));
            qcDetailOnlineTransVO.setStrSearchString(request_p.getParameter("searchStrintg"));
			//qcDetailOnlineTransVO.setStrSeatId(qcDetailOnlineTransFB_p.getStrSeatId());
			qcDetailOnlineTransVO.setStrHospitalCode(strHospitalCode);	
//			
//			//System.out.println("Store ID==>"+request_p.getParameter("storeId"));
//			//System.out.println("Lab No==>"+request_p.getParameter("labId"));
//			//System.out.println("Search type==>"+request_p.getParameter("searchType"));
//			//System.out.println("Catg==>"+request_p.getParameter("categoryNo"));
//			//System.out.println("Search String==>"+request_p.getParameter("searchStrintg"));
			
			qcDetailOnlineTransVO.setStrMode("1");			
			//Calling BO
			qcDetailOnlineTransBO.getSampleSentDtl_WithSearch(qcDetailOnlineTransVO);

			if (qcDetailOnlineTransVO.getStrMsgType().equals("1")) 
			{
				throw new Exception(qcDetailOnlineTransVO.getStrMsgString());
			}
			strCurrentDetailsTable	=	QcDetailOnlineTransHLP.getViewSampleSentDetails(qcDetailOnlineTransVO);
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strCurrentDetailsTable);
			
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
			strMsgText = "QcDetailOnlineTransDATA.GET_SAMPLESENT_DTLS_WITHSEARCHSTRING(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","QcDetailOnlineTransDATA->GET_SAMPLESENT_DTLS_WITHSEARCHSTRING()", strMsgText);
			qcDetailOnlineTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			qcDetailOnlineTransBO = null;
			qcDetailOnlineTransVO = null;
		}
	}
	
	
	
	
	/**
	 * ItemCatgoryCombo(request,response,formBean) -- >
	 * This Method generate the Ajax Response for Item Category Combo 
	 * on the basis of Store Id
	 * @param request
	 * @param response
	 * @param form
	 */	
	public static void ItemCatgoryCombo(HttpServletRequest request, HttpServletResponse response,QcDetailOnlineTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   QcDetailOnlineTransVO vo = null;
		   QcDetailOnlineTransBO bo = null;
		   HisUtil   hisutil = null;
		try
		{  
			     vo = new QcDetailOnlineTransVO();
		         bo = new QcDetailOnlineTransBO();
		    hisutil = new HisUtil("transaction", "QcDetailOnlineTransDATA");

			vo.setStrStoreId(request.getParameter("storeId")); // Store Id			

		    
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO ITEMCATEGORYCOMBO Method */
			bo.ItemCatgoryCombo(vo);
		    /* ItemCategory Combo */
			
			if(vo.getStrItemCategoryCmb()!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = vo.getStrItemCategoryCmb();
			 	response.getWriter().print(strRes);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "QcDetailOnlineTransDATA->ItemCatgoryCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "QcDetailOnlineTransDATA->ItemCatgoryCombo()", strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} 
		finally 
		{
    		if (vo != null)
				vo = null;
			if(hisutil != null) hisutil = null;
			if (bo != null)
				bo = null;
		}
    
	}
	/**
	 * ApprovedByCombo(request,response,formBean) -- >
	 * This Method generate the Ajax Response for Approved By Combo 
	 * on the basis of Store Id
	 * @param request
	 * @param response
	 * @param form
	 */
	public static void ApprovedByCombo(HttpServletRequest request,
			HttpServletResponse response, QcDetailOnlineTransFB formBean) {
		   /* Declaring Variables */
	       String strmsgText = "";
		   String strChk = null;
		   String strRes = null;
		   QcDetailOnlineTransVO vo = null;
		   QcDetailOnlineTransBO bo = null;
		   HisUtil   hisutil = null;
		try
		{  
		    vo = new QcDetailOnlineTransVO();
	        bo = new QcDetailOnlineTransBO();
		    hisutil = new HisUtil("transaction", "QcDetailOnlineTransDATA");
		    strChk = request.getParameter("modName");
		    vo.setStrStoreId(strChk);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO APPROVEDBYCOMBO Method */
			bo.ApprovedByCombo(vo);
		    /* ApprovedBy Combo */
			
			if(vo.getStrApprovedBy()!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = vo.getStrApprovedBy();
			 	response.getWriter().print(strRes);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "QcDetailOnlineTransDATA->ApprovedByCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "QcDetailOnlineTransDATA->ApprovedByCombo()", strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} 
		finally 
		{
 		if (vo != null)
				vo = null;
			if(hisutil != null) hisutil = null;
			if (bo != null)
				bo = null;
		}
		
	}
	/**
	 * This function used to set initial parameters for view Page.
	 * @param issueSampleForQcCheckTransFB
	 * @param request
	 */
	public static void initViewPageDtl(QcDetailOnlineTransFB issueSampleForQcCheckTransFB,HttpServletRequest request)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   QcDetailOnlineTransVO vo = null;
		   QcDetailOnlineTransBO bo = null;
		   HisUtil hisUtil;
		   String strLabNameVal = "";
		   try
		   {
			    /* Create Object */
			    hisUtil = new HisUtil("MMS", "QcDetailOnlineTransDATA");
			         vo = new QcDetailOnlineTransVO();
			   	     bo = new QcDetailOnlineTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	/* Calling BO method */
			   	bo.initForViewPage(vo);
			   
			   	issueSampleForQcCheckTransFB.setStrStoreName(vo.getStrStoreName());
			   	issueSampleForQcCheckTransFB.setStrFromDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	issueSampleForQcCheckTransFB.setStrToDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	issueSampleForQcCheckTransFB.setStrItemCatgCombo(vo.getStrItemCategoryCmb());
			  	   	
			   	hisUtil = new HisUtil("MMS Transactions", "QcDetailOnlineTransDATA");
				
				if(vo.getStrWrsLabName()!=null && vo.getStrWrsLabName().size()>0)
				{
					
					strLabNameVal = hisUtil.getOptionValue(vo.getStrWrsLabName(), "0","0^Select Value", false);
				}
				
				else
				{
					strLabNameVal = "<option value='0'>Select Value</option>";
				}			 
				issueSampleForQcCheckTransFB.setStrLabName(strLabNameVal);
			   
		   }
		   catch(Exception _err)
		   {
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "QcDetailOnlineTransDATA->initViewPageDtl()", strmsgText);
				issueSampleForQcCheckTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				issueSampleForQcCheckTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	
	
	
	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param issueSampleForQcCheckTransFB
	 * @param request
	 */
	public static void getViewQcOnlineDetail(QcDetailOnlineTransFB issueSampleForQcCheckTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   QcDetailOnlineTransVO vo = null;
		   QcDetailOnlineTransBO bo = null;
		   try
		   {
			    /* Creating Object */   	
			    vo=new QcDetailOnlineTransVO();
			   	bo=new QcDetailOnlineTransBO();
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrItemCategoryCmb(request.getParameter("itemCatNo"));
			   	vo.setStrFromDate(request.getParameter("fromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
			   	vo.setStrLabId((request.getParameter("labId")==null || request.getParameter("labId").equals("") ) ? "0" : request.getParameter("labId").split("\\^")[0]);
                
                /* Calling BO method */
			    bo.getViewQcOnlineDetail(vo);
			    
			    String strResult = QcDetailOnlineTransHLP.getQcOnlineDetail(vo);

			    if(strResult!= null && !strResult.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "QcDetailOnlineTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "QcDetailOnlineTransDATA->getViewDtl()", strmsgText);
				issueSampleForQcCheckTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				issueSampleForQcCheckTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	/**
	 * This method will get the POPUP info according to the selected Issue No. to
	 * generate a PopUp in HLP
	 * @param QcDetailOnlineTransFB
	 * @param request
	 * @param response
	 */
	public static void getPopUp(HttpServletRequest request,
			HttpServletResponse response, QcDetailOnlineTransFB formBean) 
	{
		/* Declaring variables*/
		String strPopUpDtls = null;
		String        index = "";
		String   strmsgText = null;

		QcDetailOnlineTransBO bo = null;
		QcDetailOnlineTransVO vo = null;
		HisUtil   hisutil = null;
		String strIssueNo = "";
		

		try 
		{
			/* Creating Object */
			bo = new QcDetailOnlineTransBO();
			vo = new QcDetailOnlineTransVO();
		
			strIssueNo = (String) request.getParameter("hiddenVal");
			     index = (String) request.getParameter("index");
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		   	vo.setStrStoreName(request.getParameter("storeId"));
		   	vo.setStrItemCategoryCmb(request.getParameter("itemCatNo"));
		   	vo.setStrFromDate(request.getParameter("fromDate"));
		   	vo.setStrToDate(request.getParameter("ToDate"));
            vo.setStrIssueNo(strIssueNo);
			// Calling BO Method
			bo.getPopUpInfo(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			} 
			else 
			{				
				strPopUpDtls = QcDetailOnlineTransHLP.getPopUpInfo(vo.getPopUpWS(),	index,strIssueNo);
				if (strPopUpDtls.equals("ERROR")) 
				{

					HisException eObj = new HisException("MMS",
							"QcDetailOnlineTransDATA->getPopUp()", strmsgText);
					strmsgText = "ERROR####Application Error [ERROR ID : "
							+ eObj.getErrorID()
							+ "],Contact System Administrator! ";
					eObj = null;
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().write(strmsgText);
					throw new Exception(vo.getStrMsgString());
				}
				else 
				{
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().write(strPopUpDtls);

				}
			}

		}
		catch (Exception e) 
		{
			// //e.printStackTrace();
			strmsgText = "MMS.transactions.QcDetailOnlineTransDATA.getPopUp(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"QcDetailOnlineTransDATA->getPopUp()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;

		} finally {
			if (vo != null)
				vo = null;
			if (bo != null)
				bo = null;
			if (hisutil != null)
				hisutil = null;
		}

	}
	/**
	 * Method is Used to Insert Data in DataBase Table 
	 * Breakage Item Detail Transaction 
	 * @param formBean
	 * @param request
	 */

	public static boolean  insertIssueSampleForQcCheck(QcDetailOnlineTransFB formBean,HttpServletRequest request) 
	{
        // Declaring Variables 
		boolean retValue = true;
		String strmsgText = "";
		MmsConfigUtil mcu = null;
		HisUtil hisutil=null;
		String strFinancialStartDate;
		String strFinancialEndDate;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		QcDetailOnlineTransBO bo = null;
		QcDetailOnlineTransVO vo = null;
		String strFinancialStartYear = "";
		String strFinancialEndYear   = "";
		
		try 
		{
			 // Creating Object
								 bo = new QcDetailOnlineTransBO();
								 vo = new QcDetailOnlineTransVO();
								mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
						    hisutil = new HisUtil("Store Transaction","QcDetailOnlineTransDATA");
			
			  strFinancialStartYear = mcu.getStrFinancialStartDate(formBean.getStrStoreName() , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  strFinancialEndYear   = mcu.getStrFinancialEndDate(formBean.getStrStoreName() , request.getSession().getAttribute("HOSPITAL_CODE").toString());

			        String hosCode  = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			        String seatid   = request.getSession().getAttribute("SEATID").toString();
			        String ipAddr   = request.getSession().getAttribute("IP_ADDR").toString();
			        vo.setStrIpAddress(ipAddr);
			
			/*****Here We found either Budget Funcanality is Allow or Not******/
			/* If Avalaible then New Cost Column will be Added */
			/*formBean.setStrBudgetFlg(mcu.getStrBudgetFlg());
			
			if(!mcu.getStrDemandActivePrd().equals("0"))
			{	
			 formBean.setStrIsDemandActiveFlag("1");
			}
			vo.setStrBudgetFlg(mcu.getStrBudgetFlg());*/
			/*******************************************************************/
								
			       strCurrentDate  = hisutil.getASDate("dd-MM-yyyy");
			       vo.setStrCurrentDate(strCurrentDate);
						
			       strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 )
			{
				      CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				      CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
							
			 strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
			
			   strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			  
			vo.setStrFinancialEndDate(strFinancialEndDate);
			vo.setStrFinancialStartDate(strFinancialStartDate);
			
			/** Here We Set Item Related Details **/
			vo.setStrIssueQty(formBean.getStrIssueQty());
			vo.setStrReqQty(formBean.getStrReqQty());
			vo.setItemParamValue(formBean.getItemParamValue());
			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrFinancialEndYear(strFinancialEndYear);
			vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrAprovedRemarks(formBean.getStrAprovedRemarks());
	
			vo.setStrStoreName(formBean.getStrStoreName());	// Here We pass Store Id of DDW(District Drug Warehouse)
			vo.setStrItemCategoryCmb(formBean.getStrItemCatgCombo());
			vo.setStrIndentingStoreID(formBean.getStrIndentingStoreID());// Here by Indenting Store we mean HQ Name 	

			vo.setStrIsReIssue( (formBean.getStrReIssueChk()==null || formBean.getStrReIssueChk().equals("") ) ? "0" : formBean.getStrReIssueChk()); 
			vo.setStrIssueDate( formBean.getStrIssueDate()); 

			vo.setStrRemarks(formBean.getStrRemarks());
			
			vo.setStrIssuingStoreId(formBean.getStrTmpIssuingStoreId());
			vo.setStrRaisingStoreId(formBean.getStrTmpRaisingStoreId());
			vo.setStrUnitName(formBean.getStrUnitName());
			
	        // Calling BO method
			bo.insertIssueSampleForQcCheck(vo);
           		
				
				if (vo.getStrMsgType().equals("1"))
				{
					  formBean.setStrErr(vo.getStrMsgString());
					  throw new Exception(vo.getStrMsgString());
					
				}
				else
				{	
			        formBean.setStrMsg("Data Has been Successfully Saved");
					formBean.setStrTmpStoreNo(vo.getStrStoreName());
				}   
			 
			
			
		
		}
		catch (Exception e) 
		  {
	        e.printStackTrace(); 
	        retValue = false;
			strmsgText = "QcDetailOnlineTransDATA.insertIssueSampleForQcCheck(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"QcDetailOnlineTransDATA->InsertOffLineforNewDemand()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			mcu = null;
		}
    return retValue;
	}
	
	
	
	/**
	 * Method is Used to Insert Data in DataBase Table 
	 * QC Detail Transaction 
	 * @param formBean
	 * @param request
	 */

	public static boolean  saveQCDetail(QcDetailOnlineTransFB formBean,HttpServletRequest request) 
	{
        // Declaring Variables 
		boolean retValue = true;
		String strmsgText = "";
		MmsConfigUtil mcu = null;
		HisUtil hisutil=null;
		String strFinancialStartDate;
		String strFinancialEndDate;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		QcDetailOnlineTransBO bo = null;
		QcDetailOnlineTransVO vo = null;
		String strFinancialStartYear = "";
		String strFinancialEndYear   = "";
		
		try 
		{
			 // Creating Object
								 bo = new QcDetailOnlineTransBO();
								 vo = new QcDetailOnlineTransVO();
								mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
						    hisutil = new HisUtil("Store Transaction","QcDetailOnlineTransDATA");
			
			  strFinancialStartYear = mcu.getStrFinancialStartDate(formBean.getStrStoreName() , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  strFinancialEndYear   = mcu.getStrFinancialEndDate(formBean.getStrStoreName() , request.getSession().getAttribute("HOSPITAL_CODE").toString());

			        String hosCode  = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			        String seatid   = request.getSession().getAttribute("SEATID").toString();
			        //String ipAddr   = request.getSession().getAttribute("IP_ADDR").toString();
			        //vo.setStrIpAddress(ipAddr);
			
			
			/*******************************************************************/
								
			       strCurrentDate  = hisutil.getASDate("dd-MM-yyyy");
			       vo.setStrCurrentDate(strCurrentDate);
						
			       strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			//commented by adil
			if(strCurrentMonth>=4 )
			{
				      CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				      CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
							
			 strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
			
			   strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			  
			vo.setStrFinancialEndDate(strFinancialEndDate);
			vo.setStrFinancialStartDate(strFinancialStartDate);
			/** Here We Set QC & Refence Related Details **/
			vo.setStrStoreName(formBean.getStrStoreName());
			vo.setStrItemCategoryCmb(formBean.getStrItemCatgCombo());
			vo.setStrLabId(formBean.getStrLabId());
			vo.setStrQcStatus(formBean.getStrQcStatus());
			vo.setStrLabInchargeName(formBean.getStrLabInchargeName());
			vo.setStrRemarksLab(formBean.getStrRemarksLab());
			vo.setStrFileNo(formBean.getStrFileNo());
			vo.setStrFileName(formBean.getStrFileName());
			vo.setStrPageNo(formBean.getStrPageNo());
			vo.setStrRemarks(formBean.getStrRemarks()) ;
			vo.setStrChkFlag(formBean.getStrChkFlag());
			vo.setStrCheckHiddenValues(formBean.getStrCheckHiddenValues());
			vo.setStrReportNumber(formBean.getStrReportNumber());
			vo.setStrReportDate(formBean.getStrReportDate());
			vo.setStrCTRNumber(formBean.getStrCTRNumber());
			vo.setStrReceiveDate(formBean.getStrReceiveDate());
			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
	
			bo.saveQcDetail(vo);
			
			if (vo.getStrMsgType().equals("1"))
			{
				  formBean.setStrErr(vo.getStrMsgString());
				  throw new Exception(vo.getStrMsgString());					
			}
			else
			{
				
				 /* This Method is global method used to Send SMS Here we pass
				  * Mobile e.g 9891925159,9856577577,84848485458
				  * Msg in String format "SMS Alert...."
				  * Mode 1 = Single SMS
				  * Mode 2 = Bulk SMS
				  * Mode 3 = Send Schedule SMS
				  * */
//				//System.out.println("QC Mobile No List==>"+vo.getStrMobileNoList());
//				//System.out.println("Mobile Msg==>"+vo.getStrMobileMsg());
//				//System.out.println("User Name==>"+vo.getStrMobileUserName());
//				//System.out.println("Pwd ==>"+vo.getStrMobilePwd());
				String mode = "2";
				String mobileNos = vo.getStrMobileNoList();
				String message   = vo.getStrMobileMsg();
				String username  = vo.getStrMobileUserName();
				String pwd       = vo.getStrMobilePwd();
				String senderId  = vo.getStrMobileSenderId();	
				String scheduledTime = "";  
				if(!vo.getStrMobileUserName().equals("0"))
				{	
				//  HisUtil.SendSMS(username,pwd,senderId,mode,mobileNos,message,scheduledTime);
				}  
				
				
				formBean.setStrMsg("Data Has been Successfully Saved");
				formBean.setStrLabSendNumber(formBean.getStrTmpPrintValues().split("\\^")[19]);
				formBean.setStrCheckHiddenValues(vo.getStrCheckHiddenValues());
				formBean.setStrPrintValues(vo.getStrCheckHiddenValues());
				formBean.setStrTmpCtrNo(vo.getStrCTRNumber());
			}
			
			
		
		}
		catch (Exception e) 
		  {
	        e.printStackTrace(); 
	        retValue = false;
			strmsgText = "QcDetailOnlineTransDATA.insertIssueSampleForQcCheck(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"QcDetailOnlineTransDATA->InsertOffLineforNewDemand()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			mcu = null;
		}
    return retValue;
	}
	
	

}
