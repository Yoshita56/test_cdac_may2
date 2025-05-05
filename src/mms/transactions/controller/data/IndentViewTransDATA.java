package mms.transactions.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.MmsConfigUtil;
import mms.transactions.bo.IndentViewTransBO;
import mms.transactions.controller.fb.IndentViewTransFB;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.controller.hlp.IndentViewTransHLP;
import mms.transactions.vo.IndentViewTransVO;

public class IndentViewTransDATA {
	
	/**
	 * Method is Used to get the Data for view Page of
	 * Indent Desk 
	 * @param formBean
	 * @param request
	 */
	public static void viewData(IndentViewTransFB formBean,HttpServletRequest request) 
	{
		IndentViewTransBO bo = null;
		IndentViewTransVO vo = null;
		String strmsgText = "";
		String str1 ="";
		String str2 ="";
		String str3 ="";
		//Change Request
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;	
		HisUtil            util = null;
		MmsConfigUtil mmsConfig = null;

		
		try 
		{
			bo = new IndentViewTransBO();
			vo = new IndentViewTransVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
				 mmsConfig = new MmsConfigUtil(hosCode);
	          util = new HisUtil("MMSModule", "IndentViewTransDATA");
	          
	          
	          System.out.println("<<----------IndentViewTransDATA.viewData()-------------->>");
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			String strChk = formBean.getStrChk();
			
//			//System.out.println("strChk-"+strChk);
			String[] temp  = strChk.split("\\^");
			String[] temp1 = temp[0].split("\\@");
			String[] temp2 = temp1[6].split("\\$");
	//		String strIndentPeriod = temp2[0];

    //		//System.out.println("Req No-->>"+temp1[0]);
    //  	//System.out.println("Store Id-->>"+temp1[1]);
    //		//System.out.println("Req Type Id-->>"+temp1[2]);
		
			vo.setStrReqNo(temp1[0]);
			vo.setStrReqTypeId(temp1[2]);
			vo.setStrStoreId(temp1[1]);
			vo.setStrToStoreId(temp2[0]);
			
			//Change Request
            strCurrentDate  = util.getASDate("dd-MM-yyyy");

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
			
			
         	bo.viewData(vo);
         	
         	//Change Request
			
			if(mmsConfig.getStrBudgetFlg().equals("1"))
			{
				formBean.setStrAvalaibleBudget(vo.getStrAvalaibleBudget());
				formBean.setStrAvalaibleBudgetDtl(vo.getStrAvalaibleBudgetDtl());	
			}
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			if(temp1[2].equals("12") || temp1[2].equals("13") || temp1[2].equals("14") || temp1[2].equals("10"))
			{
				 System.out.println("<<---------- IndentViewTransHLP.getItemDetails1  -------------->>");
				 
				str1=IndentViewTransHLP.getItemDetails1(vo);
			}
			else
			{
				 System.out.println("<<---------- IndentViewTransHLP.getItemDetails  -------------->>");
				str1=IndentViewTransHLP.getItemDetails(vo);
			}	
			
			////System.out.println("Req Type:::"+temp1[2]);
			str2  =  ApprovalDtlHLP.getApprovalDtl(vo.getStrStoreId(), vo.getStrHospitalCode(), vo.getStrToStoreId(), temp1[3], vo.getStrReqTypeId(), vo.getStrReqNo());
			str3  =  IndentViewTransHLP.getIndentDetails(vo);
			formBean.setStrSetItemDetails(str1);
			formBean.setStrSetApprovedDetails(str2);
			formBean.setStrIndentDetails(str3);
			
			formBean.setStrReqTypeId(vo.getStrReqTypeId());
			formBean.setStrRequestName(vo.getStrIndentName());
			if(temp1[2].equals("11")|| temp1[2].equals("86"))
			{
				formBean.setStrBudgetRequired("0");
			}
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IndentViewTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentViewTransDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	public static void viewDataBS(IndentViewTransFB formBean,HttpServletRequest request) 
	{
		IndentViewTransBO bo = null;
		IndentViewTransVO vo = null;
		String strmsgText = "";
		String str1 ="";
		String str2 ="";
		String str3 ="";
		//Change Request
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;	
		HisUtil            util = null;
		MmsConfigUtil mmsConfig = null;

		
		try 
		{
			bo = new IndentViewTransBO();
			vo = new IndentViewTransVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
				 mmsConfig = new MmsConfigUtil(hosCode);
	          util = new HisUtil("MMSModule", "IndentViewTransDATA");
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			String strChk = formBean.getStrChk();
			
//			//System.out.println("strChk-"+strChk);
			String[] temp  = strChk.split("\\^");
			String[] temp1 = temp[0].split("\\@");
			String[] temp2 = temp1[6].split("\\$");
	//		String strIndentPeriod = temp2[0];

    //		//System.out.println("Req No-->>"+temp1[0]);
    //  	//System.out.println("Store Id-->>"+temp1[1]);
    //		//System.out.println("Req Type Id-->>"+temp1[2]);
		
			vo.setStrReqNo(temp1[0]);
			vo.setStrReqTypeId(temp1[2]);
			vo.setStrStoreId(temp1[1]);
			vo.setStrToStoreId(temp2[0]);
			
			//Change Request
            strCurrentDate  = util.getASDate("dd-MM-yyyy");

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
			
			
         	bo.viewData(vo);
         	
         	//Change Request
			
			if(mmsConfig.getStrBudgetFlg().equals("1"))
			{
				formBean.setStrAvalaibleBudget(vo.getStrAvalaibleBudget());
				formBean.setStrAvalaibleBudgetDtl(vo.getStrAvalaibleBudgetDtl());	
			}
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			if(temp1[2].equals("12") || temp1[2].equals("13") || temp1[2].equals("14") || temp1[2].equals("10"))
			{
				str1=IndentViewTransHLP.getItemDetailsBS1(vo);
			}
			else
			{
				
				str1=IndentViewTransHLP.getItemDetailsBS(vo);
			}	
			
			////System.out.println("Req Type:::"+temp1[2]);
			str2  =  ApprovalDtlHLP.getApprovalDtlBS(vo.getStrStoreId(), vo.getStrHospitalCode(), vo.getStrToStoreId(), temp1[3], vo.getStrReqTypeId(), vo.getStrReqNo());
			str3  =  IndentViewTransHLP.getIndentDetailsBS(vo);
			formBean.setStrSetItemDetails(str1);
			if(!vo.getStrReqTypeId().equals("23"))
			{	
			formBean.setStrSetApprovedDetails(str2);
			}
			formBean.setStrIndentDetails(str3);
			formBean.setStrRequestName(vo.getStrIndentName());
			if(temp1[2].equals("11")|| temp1[2].equals("86"))
			{
				formBean.setStrBudgetRequired("0");
			}
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IndentViewTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentViewTransDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	public static void indentPrint(HttpServletRequest request,HttpServletResponse response,IndentViewTransFB formBean) 
	{
		IndentViewTransBO bo = null;
		IndentViewTransVO vo = null;
		String strmsgText = "";
		String str1 ="";
		String str2 ="";
		String str3 ="";
		//Change Request
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;	
		HisUtil            util = null;
		
		StringBuffer sb = new StringBuffer("");
		String finalPrint ="";

		
		try 
		{
			bo = new IndentViewTransBO();
			vo = new IndentViewTransVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
				
	          util = new HisUtil("MMSModule", "IndentViewTransDATA");
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			String strChk = formBean.getStrChk();
			
			System.out.println("strChk-"+strChk);
			String[] temp  = strChk.split("\\^");
			String[] temp1 = temp[0].split("\\@");
			String[] temp2 = temp1[6].split("\\$");
	//		String strIndentPeriod = temp2[0];

    //		//System.out.println("Req No-->>"+temp1[0]);
    //  	//System.out.println("Store Id-->>"+temp1[1]);
    //		//System.out.println("Req Type Id-->>"+temp1[2]);

			System.out.println("temp-"+temp); //[230280624105342@10201236@23@10@0@0@10201100$1]
			System.out.println("temp1-"+temp1); //[230280624105342, 10201236, 23, 10, 0, 0, 10201100$1]
			System.out.println("temp2-"+temp2); //[10201100, 1]

			
			
			vo.setStrReqNo(temp1[0]);
			vo.setStrReqTypeId(temp1[2]);
			vo.setStrStoreId(temp1[1]);
			vo.setStrToStoreId(temp2[0]);
			
			//Change Request
            strCurrentDate  = util.getASDate("dd-MM-yyyy");

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
			
            String strTableWidth = "825";
									
			bo.getImgHeader(vo);
         	bo.viewData(vo);
         	
         	//Change Request
			
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			System.out.println("Req Type:::"+temp1[2]);
			
			if(temp1[2].equals("12") || temp1[2].equals("13") || temp1[2].equals("14") || temp1[2].equals("10"))
			{
				str1=IndentViewTransHLP.getItemDetails1Print(vo);
			}
			else
			{
				
				str1=IndentViewTransHLP.getItemDetailsPrint(vo);
			}	
			
			
			str2  =  ApprovalDtlHLP.getApprovalDtlPrint(vo.getStrStoreId(), vo.getStrHospitalCode(), vo.getStrToStoreId(), temp1[3], vo.getStrReqTypeId(), vo.getStrReqNo());
			
			System.out.println("--------- IndentViewTransDATA.indentPrint ------ START ------");
			
			str3  =  IndentViewTransHLP.getIndentDetailsPrint(vo);
			
			System.out.println("--------- IndentViewTransDATA.indentPrint ------- END -----");
			formBean.setStrSetItemDetails(str1);
			if(!vo.getStrReqTypeId().equals("23"))
			{	
			formBean.setStrSetApprovedDetails(str2);
			}
			formBean.setStrIndentDetails(str3);
			formBean.setStrRequestName(vo.getStrIndentName());
			if(temp1[2].equals("11")|| temp1[2].equals("86"))
			{
				formBean.setStrBudgetRequired("0");
			}
						
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(hosCode);
			
            //sb.append("<style>@media screen and (orientation: potrait) { #toolbar {position: fixed; width: 2.65em; height: 100%; } p { margin-left: 2em;} li + li {margin-top: .5em;}}</style>");
			
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			/*sb.append("<tr><td><div style='text-align: center;'><img src='/INVMGM/hisglobal/images/aiims_header.png'"
					+ "></div></td> ");
			sb.append("</tr> ");
			sb.append("</td>");
			sb.append("</tr> ");*/
			
			sb.append("<tr> "
			+ " <td><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
			//+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td></tr>"
			);			
			sb.append("</table> ");				
			
			sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='"+strTableWidth+"'>");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup(),cancelToDesk();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			
			sb.append(str3+""+str1+""+str2);
			
			finalPrint = sb.toString();
										
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(finalPrint);
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IndentViewTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentViewTransDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	public static void modifyData(IndentViewTransFB formBean,HttpServletRequest request) 
	{
		IndentViewTransBO bo = null;
		IndentViewTransVO vo = null;
		String strmsgText = "";
		String str1 ="";
		String str2 ="";
		String str3 ="";
		//Change Request
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;	
		HisUtil            util = null;
		MmsConfigUtil mmsConfig = null;

		
		try 
		{
			bo = new IndentViewTransBO();
			vo = new IndentViewTransVO();
            //System.out.println("In the modify");
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
				 mmsConfig = new MmsConfigUtil(hosCode);
	          util = new HisUtil("MMSModule", "IndentViewTransDATA");
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			String strChk = formBean.getStrChk();
			//161114110003@12401108@11@16@0@10@12401107$1
		//System.out.println("strChk-"+strChk);
			String[] temp  = strChk.split("\\^");
			String[] temp1 = temp[0].split("\\@");
			String[] temp2 = temp1[6].split("\\$");
	//		String strIndentPeriod = temp2[0];

	//System.out.println("Req No-->>"+temp1[0]);
  	//System.out.println("Store Id-->>"+temp1[1]);
  	//System.out.println("Req Type Id-->>"+temp1[2]);
		
			vo.setStrReqNo(temp1[0]);
			vo.setStrReqTypeId(temp1[2]);
			vo.setStrStoreId(temp1[1]);
			vo.setStrToStoreId(temp2[0]);
			
			//Change Request
            strCurrentDate  = util.getASDate("dd-MM-yyyy");

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
			formBean.setStrRaisingStore(temp1[1]);
			
         	bo.ModifyData(vo);
         	
         	//Change Request
			
			if(mmsConfig.getStrBudgetFlg().equals("1"))
			{
				formBean.setStrAvalaibleBudget(vo.getStrAvalaibleBudget());
				formBean.setStrAvalaibleBudgetDtl(vo.getStrAvalaibleBudgetDtl());	
			}
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			if(temp1[2].equals("12") || temp1[2].equals("13") || temp1[2].equals("14") || temp1[2].equals("10"))
			{
				str1=IndentViewTransHLP.getItemDetails1(vo);
			}
			else
			{
				
				str1=IndentViewTransHLP.getItemDetailsModify(vo);
			}	
			
		    //System.out.println("Req Type:::"+temp1[2]);
			str2  =  ApprovalDtlHLP.getApprovalDtl(vo.getStrStoreId(), vo.getStrHospitalCode(), vo.getStrToStoreId(), temp1[3], vo.getStrReqTypeId(), vo.getStrReqNo());
			str3  =  IndentViewTransHLP.getIndentDetailsModify(vo);
			//System.out.println(str2);
			formBean.setStrSetItemDetails(str1);
			formBean.setStrSetApprovedDetails(str2);
			formBean.setStrIndentDetails(str3);
			formBean.setStrRequestName(vo.getStrIndentName());
			if(temp1[2].equals("11")|| temp1[2].equals("86"))
			{
				formBean.setStrBudgetRequired("0");
			}
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IndentViewTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentViewTransDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	public static void  INSERT(IndentViewTransFB formBean,HttpServletRequest request) 
	{
		IndentViewTransBO bo = null;
		IndentViewTransVO vo = null;
		String strmsgText = "";
		String str1 ="";
		String str2 ="";
		String str3 ="";
		//Change Request
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;	
		HisUtil            util = null;
		MmsConfigUtil mmsConfig = null;

		
		try 
		{
			bo = new IndentViewTransBO();
			vo = new IndentViewTransVO();
            //System.out.println("In the modify");
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
				 mmsConfig = new MmsConfigUtil(hosCode);
	          util = new HisUtil("MMSModule", "IndentViewTransDATA");
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			String strChk = formBean.getStrChk();
			
			//System.out.println("strChk-"+strChk);
		/*	String[] temp  = strChk.split("\\^");
			String[] temp1 = temp[0].split("\\@");
			String[] temp2 = temp1[6].split("\\$");*/
	//		String strIndentPeriod = temp2[0];

 	//System.out.println("Req No-->>"+vo.getStrReqNo());
    //  	//System.out.println("Store Id-->>"+temp1[1]);
    //		//System.out.println("Req Type Id-->>"+temp1[2]);
		
			/*vo.setStrReqNo(temp1[0]);
			vo.setStrReqTypeId(temp1[2]);
			vo.setStrStoreId(temp1[1]);
			vo.setStrToStoreId(temp2[0]);
		     vo.setStrReqQty(formBean.getStrReqQty());*/
		    // Calling BO Method		
 	  vo.setStrIndentNo(formBean.getStrIndentNo());
 	  vo.setStrRaisingStore(formBean.getStrRaisingStore());
 	  vo.setStrReqQty(formBean.getStrReqQty());
 	  vo.setStrIndentTypeId(formBean.getStrIndentTypeId());
 	  vo.setStrItemBrandIds(formBean.getStrItemBrandIds());
 	  ////System.out.println("formBean.getStrModifedQty()"+formBean.getStrModifedQty());
 	 ////System.out.println("formBean.getStrItemBrandIds()"+formBean.getStrItemBrandIds());
 	  vo.setStrModifedQty(formBean.getStrModifedQty());
			bo.INSERT(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				
				throw new Exception(vo.getStrMsgString());
			}
	    	else 
			{
	    		formBean.setStrMsg("Indent Modified !!");
			}
			
		}
		  catch (Exception e) 
		  {
			  
	        e.printStackTrace(); 
			strmsgText = "BreakgeItemDtlTransDATA.INSERT(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BreakgeItemDtlTransDATA->INSERT()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	

	}

}
