package mms.transactions.controller.data;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import org.codehaus.jettison.json.JSONObject;

import billing.BillConfigUtil;
import hisglobal.ReportUtil;
import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.GlobalVO;
import hisglobal.tools.hlp.PatientDtlBO;
import hisglobal.tools.hlp.PatientDtlHLP;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.transactions.bo.IssueDeskPrintTransBO;
import mms.transactions.bo.IssueDeskPrintTransBO;
import mms.transactions.controller.fb.IssueDeskPrintTransFB;
import mms.transactions.controller.fb.IssueDeskPrintTransFB;
import mms.transactions.controller.fb.MessageObjects;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.controller.hlp.IssueDeskPrintTransHLP;
import mms.transactions.controller.hlp.IssueDeskPrintTransHLP;
import mms.transactions.dao.IssueDeskPrintTransDAO;
import mms.transactions.vo.IssueDeskPrintTransVO;
import mms.transactions.vo.IssueDeskPrintTransVO;

public class IssueDeskPrintTransDATA 
{
	
	
	/**
	 * 
	 * @param formBean	the IssueDeskPrintTransFB
	 * @param request	the HttpServletRequest
	 */
	public static void getList_HLP(IssueDeskPrintTransFB formBean,	HttpServletRequest request,HttpServletResponse response) 
	{
		// Creating Object for BO & VO.
		IssueDeskPrintTransVO vo = null;
		IssueDeskPrintTransBO bo = null;		
		String strDataTable="";	
		HisUtil util = null;			
		try
		{
			    vo = new IssueDeskPrintTransVO();
			    bo = new IssueDeskPrintTransBO();
			    util = new HisUtil("MMS Transactions", "getList_HLP");
								
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
				
				if(request.getParameter("storeId")!=null)
				{	
					vo.setStrStoreId(request.getParameter("storeId"));
				}
				if(request.getParameter("catgId")!=null)
				{
					vo.setStrItemCategNo(request.getParameter("catgId"));
				}
				else
				{
					vo.setStrItemCategNo("10");
				}
				if(request.getParameter("statusId")!=null)
				{
					vo.setStrStatusCode(request.getParameter("statusId"));
				}
				if(request.getParameter("reqTypeId")!=null)
				{
					vo.setStrRequestTypeId(request.getParameter("reqTypeId"));
				}
				
				System.out.println("------vo.setStrRequestTypeId------"+vo.getStrRequestTypeId());
				
//				qif(vo.getStrRequestTypeId().equals("17"))
//				{	
//					vo.setStrItemCategNo("3");
//					bo.getListPageData(vo);
//					strDataTable	=	DATA_TABLE_HLP(vo.getStrDataTableWs(),vo);
//				}else {
//					vo.setStrItemCategNo("2");
//					bo.getListPageData(vo);
//					strDataTable	=	DATA_TABLE_HLP1(vo.getStrDataTableWs(),vo);
//				}      
				
				bo.getListPageData(vo);	 // pkg_ot_view.proc_pac_finalization_list [ Mode - 1]				                        
				
				strDataTable	=	DATA_TABLE_HLP(vo.getStrDataTableWs(),vo);
				//System.out.println("------TABLE_HLP------"+strDataTable);
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strDataTable);
		}
		catch (Exception e) 
		{

			e.printStackTrace();
			String msgStr =  e.getMessage();
			HisException eObj = new HisException("OT", "getDataTableOnSelection()", msgStr);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;

		} finally {
				vo = null;
				bo = null;
				
			}		
	}
	
	
	public static ArrayList<MessageObjects> getHLP_JSON(IssueDeskPrintTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		IssueDeskPrintTransBO bo = null;
		IssueDeskPrintTransVO vo = null;
		ArrayList<MessageObjects> messageData = new ArrayList<MessageObjects>();
		try
		{
		    vo = new IssueDeskPrintTransVO();
		    bo = new IssueDeskPrintTransBO();		  
							
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
			
			if(request.getParameter("storeId")!=null)
			{	
				vo.setStrStoreId(request.getParameter("storeId"));
			}
			if(request.getParameter("catgId")!=null)
			{
				vo.setStrItemCategNo(request.getParameter("catgId"));
			}
			else
			{
				vo.setStrItemCategNo("10");
			}
			if(request.getParameter("statusId")!=null)
			{
				vo.setStrStatusCode(request.getParameter("statusId"));
			}
			if(request.getParameter("reqTypeId")!=null)
			{
				vo.setStrRequestTypeId(request.getParameter("reqTypeId"));
			}
			
			
												
			bo.getListPageData(vo);	 // pkg_ot_view.proc_pac_finalization_list [ Mode - 1]		
			
			
			/*
            1. P_KEY
            2. Issue No
            3. Indent No
            4. Issue Date 
            5. Req Store Name
            6. CR_NO
            7. PAT_NAME
            8. Catg Name
            9. Urgent Flag 
        */ 
			
			
		
		while (vo.getStrDataTableWs().next()) 
		{
								
			String Chk_ID 			= vo.getStrDataTableWs().getString(1);
			String issueNo			= vo.getStrDataTableWs().getString(2);
			String indentNo     	= vo.getStrDataTableWs().getString(3);
			String issueDate 		= vo.getStrDataTableWs().getString(4);
			String reqStoreName    	= vo.getStrDataTableWs().getString(5);
			String crNO         	= vo.getStrDataTableWs().getString(6);
			String patientName     	= vo.getStrDataTableWs().getString(7);					
	
						
				/*
                1. P_KEY
                2. Req No
                3. Req Date
                4. Req Store Name 
                5. CR No
                6. Pat_Name
                7. Catg
                8. Urgent Flag 
	       */ 
			
			//System.out.println("Chk_ID->>"+Chk_ID);
				
				MessageObjects messageObject = new MessageObjects();
				messageObject.setChk_ID(Chk_ID);
				messageObject.setIssueNo(issueNo);
				messageObject.setIndentNo(indentNo);
				messageObject.setIssueDate(issueDate);
				messageObject.setReqStoreName(reqStoreName);
				messageObject.setCrNO(crNO);
				messageObject.setPatientName(patientName);				
				messageData.add(messageObject);
		

		}
			
		
	}
		catch (Exception e) 
		{
			e.printStackTrace();
			
		
			response.getWriter().print(vo.getStrMsgString());

		

		} finally {
			bo = null;
			vo = null;
		}
		return messageData;
	}
	
	
	
	/**
	 * 
	 * @param formBean	the IssueDeskPrintTransFB
	 * @param request	the HttpServletRequest
	 */
	public static void getListPageCombo(IssueDeskPrintTransFB formBean,	HttpServletRequest request,HttpServletResponse response) 
	{
		// Creating Object for BO & VO.
		IssueDeskPrintTransVO vo = null;
		IssueDeskPrintTransBO bo = null;
		String strDataTable="";	
		
		HisUtil util = null;			
		try
		{
			    vo = new IssueDeskPrintTransVO();
			    bo = new IssueDeskPrintTransBO();
			    util = new HisUtil("MMS Transactions", "getDepartmentCombo");
								
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
				
																	
				bo.getListPageCombo(vo);	// pkg_mms_view.proc_hstt_store_mst  [ Mode- 12 ] , pkg_mms_view2.proc_lstpage_requesttype_dtl  [ Mode- 1 ]
				
				String strStoreCombo = "";
				
				if (vo.getStrStoreWs() != null && vo.getStrStoreWs().size() > 0) 
				{
					strStoreCombo = util.getOptionValue(vo.getStrStoreWs(), "10201100", "", true);
				} 
				else 
				{
					strStoreCombo = "<option value='0'>All Store</option>";
				}
							
				
				String strReqTypeCombo = "";
				
				if (vo.getStrRequestTypeWs() != null && vo.getStrRequestTypeWs().size() > 0) 
				{
					strReqTypeCombo = util.getOptionValue(vo.getStrRequestTypeWs(), "", "", true);
				} 
				else 
				{
					strReqTypeCombo = "<option value='0'>Select Value</option>";
				}			
				
				formBean.setStrStoreCombo(strStoreCombo);
				formBean.setStrReqTypeCombo(strReqTypeCombo);
				               
				
		}
		catch (Exception e) 
		{
			

			e.printStackTrace();
			String msgStr =  e.getMessage();
			HisException eObj = new HisException("Billing", "getListPageCombo()", msgStr);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;

		} 
		finally 
		{
				vo = null;
				bo = null;
				
		}		
	}
	
	/**
	 * To get Pending Day End Details HLP
	 * 
	 * @param wrsData_p
	 * @param strWithOrWithoutRadioButton
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	private static String DATA_TABLE_HLP(WebRowSet wrsData_p , IssueDeskPrintTransVO vo)	throws SQLException,Exception
	{
		StringBuffer sbHeader = new StringBuffer(100);
		StringBuffer sbBody = new StringBuffer(100);
		int index=1;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		
		
		//System.out.println("Status_Code--[ HLP ]->>"+vo.getStrStatusCode());
		
		if (wrsData_p != null && wrsData_p.size() > 0) 
		{		
			
			
			if((vo.getStrStatusCode().equals("0") || vo.getStrStatusCode().equals("1")) && vo.getStrRequestTypeId().equals("35"))   // New Request
			{
				System.out.println("P_KEY--[ New Request ]-->>hstnum_tostore_id @ "
						+ "sstnum_item_cat_no @ "
						+ "hstnum_req_no @ "
						+ "To_char (hstdt_req_date, ''DD-Mon-yyyy '') @ "
						+ "hstnum_store_id @ "
						+ "hrgnum_puk @ "
						+ "gnum_hospital_code @ "
						+ "hstnum_bs_refno  @ "
						+ "hstnum_urgent_flag");
				
				
				sbBody   = new StringBuffer(1000);
				
				/*
				 * Header Row:
				 */
				sbBody.append("<table id='example' class='cell-border compact stripe' style='width:100%'>");
				sbBody.append("<thead>");
				sbBody.append("<tr>");		
				sbBody.append("<th align='center'>Indent No</th>");	
				sbBody.append("<th align='center'>Indent Date</th>");		
				sbBody.append("<th align='center'>Raising Store</th>");
				sbBody.append("<th align='center'>CR No</th>");	
				sbBody.append("<th align='center'>Patient Name</th>");				
				sbBody.append("<th align='center'>Action</th>");
				sbBody.append("</tr>");
				sbBody.append("</thead>");
				
				
				
				sbBody.append("<tbody>");				
				/*
	                1. P_KEY
	                2. Req No
	                3. Req Date
	                4. Req Store Name 
	                5. CR No
	                6. Pat_Name
	                7. Catg
	                8. Urgent Flag 
		       */ 
				while (wrsData_p.next()) 
				{
										
					String Chk_ID 			= wrsData_p.getString(1);
					String indentNo			= wrsData_p.getString(2);
					String indentDate   	= wrsData_p.getString(3);
					String storeName 		= wrsData_p.getString(4);
					String crNO         	= wrsData_p.getString(5);
					String patientName  	= wrsData_p.getString(6);
					String catgName     	= wrsData_p.getString(7);					
			
					/*
					 * Table Body
					 */
					
					 
					
					sbBody.append("<tr>");					
					sbBody.append("<td align='center'>" + indentNo + "</td>");
					sbBody.append("<td align='center'>" + indentDate+ "</td>");
					sbBody.append("<td align='center'>" + storeName + "</td>");
					sbBody.append("<td align='center'>" + crNO+ "</td>");
					sbBody.append("<td align='center'>" + patientName+ "</td>");
					//sbBody.append("<td>" + catgName+ "</td>");
					sbBody.append("<td><input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+index+"' value='"+Chk_ID+"'><button type='button' id='bId"+index+"' onclick='getViewCNT(\""+index+"\");' class='btn pmd-btn-fab pmd-ripple-effect btn-info pmd-btn-raised' data-placement='top' data-toggle='tooltip' title='VIEW'><i class='material-icons pmd-sm' aria-hidden='true'></i>VIEW</button></td>");
					
				
					sbBody.append("</tr>"); 

					index++;
					
				}
				sbBody.append("</tbody>");
				sbBody.append("</table>");
					
			}
			if(vo.getStrStatusCode().equals("4") && vo.getStrRequestTypeId().equals("35"))  // Processed 
			{
				
				System.out.println("P_KEY--[Processed]-->>hstnum_store_id @ "
						+ "hstnum_issue_no @ "
						+ "hrgnum_puk @ "
						+ "pistr_emp_no @ "
						+ "sstnum_item_cat_no @  "
						+ "To_char(hstdt_issue_date, ''DD-Mon-yyyy'') @ "
						+ "hstnum_req_no @ "
						+ "To_char(hstdt_req_date, ''DD-Mon-yyyy'') @"
						+ "gnum_hospital_code");	
				
			
				sbBody   = new StringBuffer(500);		
				
				/*
				 * Header Row:
				 */
				sbBody.append("<table id='example'  class='cell-border compact stripe' style='width:100%'>");
				sbBody.append("<thead>");
				sbBody.append("<tr>");
				sbBody.append("<th align='center'>Issue No</th>");
				sbBody.append("<th align='center'>Issue Date</th>");	
				sbBody.append("<th align='center'>Req No</th>");			
				sbBody.append("<th align='center'>Raising Store</th>");			
				sbBody.append("<th align='center'>[ CR No ] Patient Name</th>");
				sbBody.append("<th align='center'>Action</th>");
				sbBody.append("</tr>");
				sbBody.append("</thead>");
				
				
				sbBody.append("<tbody>");
				
						
				/*
	                1. P_KEY
	                2. Issue No
	                3. Indent No
	                4. Issue Date 
	                5. Req Store Name
	                6. CR_NO
	                7. PAT_NAME
	                8. Catg Name
	                9. Urgent Flag 
	            */ 
				
				while (wrsData_p.next()) 
				{
										
					String Chk_ID 			= wrsData_p.getString(1);
					String issueNo			= wrsData_p.getString(2);
					String indentNo     	= wrsData_p.getString(3);
					String issueDate 		= wrsData_p.getString(4);
					String reqStoreName    	= wrsData_p.getString(5);
					String crNO         	= wrsData_p.getString(6);
					String patientName     	= wrsData_p.getString(7);					
			
					/*
					 * Table Body
					 */
					
					
					
					sbBody.append("<tr>");					
					sbBody.append("<td align='center'>" + issueNo +"</td>");
					sbBody.append("<td align='center'>" + issueDate+"</td>");
					sbBody.append("<td align='center'>" + indentNo + "</td>");
					sbBody.append("<td align='center'>" + reqStoreName + "</td>");					
					sbBody.append("<td align='center'> [ " + crNO+" ] "+patientName+"</td>");					
					sbBody.append("<td align='center'><input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+index+"' value='"+Chk_ID+"'><button type='button' id='bId"+index+"' onclick='getViewCNT(\""+index+"\");' class='btn pmd-btn-fab pmd-ripple-effect btn-info pmd-btn-raised' data-placement='top' data-toggle='tooltip' title='VIEW'><i class='material-icons pmd-sm' aria-hidden='true'></i>VIEW</button></td>");
				
					index++;
					sbBody.append("</tr>"); 
					
				}
				
				sbBody.append("</tbody>");
				sbBody.append("</table>");
			}
			if((vo.getStrStatusCode().equals("1") || vo.getStrStatusCode().equals("4") ) && vo.getStrRequestTypeId().equals("17"))  // Processed 
			{
				sbBody   = new StringBuffer(500);		
				
				/*
				 * Header Row:
				 */
				sbBody.append("<table id='example'  class='cell-border compact stripe' style='width:100%'>");
				sbBody.append("<thead>");
				sbBody.append("<tr>");
				sbBody.append("<th align='center'>Indent No</th>");
				sbBody.append("<th align='center'>Indent Date</th>");	
				sbBody.append("<th align='center'>Issuing Store</th>");			
				sbBody.append("<th align='center'>Status</th>");
				sbBody.append("<th align='center'>Action</th>");
				sbBody.append("</tr>");
				sbBody.append("</thead>");
				
				
				sbBody.append("<tbody>");
				
						
				/*
	                1. P_KEY
	                2. Issue No
	                3. Indent No
	                4. Issue Date 
	                5. Req Store Name
	                6. CR_NO
	                7. PAT_NAME
	                8. Catg Name
	                9. Urgent Flag 
	            */ 
				
				// HSTNUM_REQ_NO   @  HSTNUM_STORE_ID   @  SSTNUM_REQTYPE_ID  @  A.SSTNUM_ITEM_CAT_NO  @  A.HSTNUM_URGENT_FLAG  @  HSTSTR_INDENT_PERIOD  @ HSTNUM_TOSTORE_ID
				
				while (wrsData_p.next()) 
				{
										
					String Chk_ID 			= wrsData_p.getString(1);
					String IndentNo  		= wrsData_p.getString(2);
					String IndentDate		= wrsData_p.getString(3);
					String IssuingStore     = wrsData_p.getString(4);
					String Status	 		= wrsData_p.getString(5);										
			
					/*
					 * Table Body
					 */
					
					sbBody.append("<tr>");					
					sbBody.append("<td align='center'>" + IndentNo +"</td>");
					sbBody.append("<td align='center'>" + IndentDate+"</td>");
					sbBody.append("<td align='center'>" + IssuingStore + "</td>");
					sbBody.append("<td align='center'>" + Status + "</td>");	
					sbBody.append("<td align='center'><input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+index+"' value='"+Chk_ID+"'><button type='button' id='bId"+index+"' onclick='getViewCNT(\""+index+"\");' class='btn pmd-btn-fab pmd-ripple-effect btn-info pmd-btn-raised' data-placement='top' data-toggle='tooltip' title='VIEW'><i class='material-icons pmd-sm' aria-hidden='true'></i>VIEW</button></td>");
					sbBody.append("</tr>"); 
					
				}
				
				sbBody.append("</tbody>");
				sbBody.append("</table>");
			}
			
			
		} 
		else 
		{
			
			sbBody   = new StringBuffer(500);
			
			/*
			 * Header Row:
			 */
			if(vo.getStrRequestTypeId().equals("35")) 
			{
				sbBody.append("<table id='example'  class='cell-border compact stripe' style='width:100%'>");
				sbBody.append("<thead>");
				sbBody.append("<tr>");
				sbBody.append("<th align='center'>Indent No</th>");
				sbBody.append("<th align='center'>Indent Date</th>");	
				sbBody.append("<th align='center'>Issuing Store</th>");			
				sbBody.append("<th align='center'>Status</th>");
				sbBody.append("<th align='center'>Action</th>");
				sbBody.append("</tr>");
				sbBody.append("</thead>");				
				sbBody.append("<tbody>");		
				sbBody.append("<tr>");	
				sbBody.append("<td style='align:center;'> </td>");
				sbBody.append("<td style='align:center;'> No Data </td>");
				sbBody.append("<td style='align:center;'> Found  </td>");
				sbBody.append("<td style='align:center;'>  </td>");
				sbBody.append("<td style='align:center;'>  </td>");			
				sbBody.append("</tr>");
				sbBody.append("</tbody>");
				sbBody.append("</table>");
			}
			else
			{
				
			}	
			
			
		}
		//sbHeader.append("</tbody>");
		
		//return sbHeader.toString() + sbBody.toString();
		return sbBody.toString();
	}
	
	
	
	
	public static void getPatientIndentVoucher(	HttpServletRequest request,	HttpServletResponse response, IssueDeskPrintTransFB formBean) 
	{

		IssueDeskPrintTransBO bo = null;
		IssueDeskPrintTransVO vo = null;		
		String strmsgText = "";		
		String strRaisingReqTypeId="";		
		String strHospitalCode="";			
		try 
		{
			
			    System.out.println("-------------  IssueDeskPrintTransDATA . getPatientIndentVoucher  --------------");
			
				bo = new IssueDeskPrintTransBO();
				vo = new IssueDeskPrintTransVO();
				strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				
				String strMode = (String) request.getParameter("strMode");
				String strToStoreId = (String) request.getParameter("strStoreId");
				String strRaisingStoreId = (String) request.getParameter("strRaisingStoreId");
				String strIssueNo = (String) request.getParameter("strIssueNo");
				String strIndentNo = (String) request.getParameter("strIndentNo");
				String crNo = (String) request.getParameter("crNo")==null?"0":(String) request.getParameter("crNo");
								
				vo.setStrStoreId(strToStoreId);
				vo.setStrHospitalCode(strHospitalCode);
				vo.setStrRaisingStoreId(strRaisingStoreId);
				vo.setStrLpRequestNo(strIndentNo);
				vo.setStrRequestDate(formBean.getStrRequestDate());
				vo.setStrRaisingReqTypeId(strRaisingReqTypeId);			
				vo.setStrCrNo(crNo);						
										
				System.out.println("getStrRaisingReqTypeId-------->"+vo.getStrRaisingReqTypeId());	
				System.out.println("getStrCrNo-------->"+vo.getStrCrNo());	
				System.out.println("getStrRequestDate-------->"+vo.getStrRequestDate());	
				System.out.println("getStrLpRequestNo-------->"+vo.getStrLpRequestNo());	
				System.out.println("getStrRaisingStoreId-------->"+vo.getStrRaisingStoreId());	
				System.out.println("getStrStoreId-------->"+vo.getStrStoreId());	
				System.out.println("getStrItemCategNo-------->"+vo.getStrItemCategNo());	
			
		
			
				bo.getIndentRequestDetail(vo);
			
				
	            String strSearchItemInitView = IssueDeskPrintTransHLP.getIssueDtlsInitView(formBean,vo);
				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strSearchItemInitView);
						
						
			
			
			System.out.println("-------------  IssueDeskPrintTransDATA . getInitDetailForIssuePage  ------- END -------");
			 
			//formBean.setStrBillPaidCat(billConfig.getStrPaidCategory());
			
		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "Issue Desk.IssueDeskPrintTransDATA.getInitDetailForIssuePage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueDeskPrintTransDATA->getIndentDetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	
	
	
	
	public static void getPatientIndentView(IssueDeskPrintTransFB formBean,
			HttpServletRequest request) 
	{

		IssueDeskPrintTransBO bo = null;
		IssueDeskPrintTransVO vo = null;
		String strPatientDtl="";
		String strmsgText = "";
		String strRequestTypeId="";
		String strRaisingReqTypeId="";
		String strIssueItemId="";
		String strRequestDtl="";
		String strChk="";
		String temp[]=null;
		String hosCode="";
		String strRequestItemDtl="";
		String strStoreId="";
		MmsConfigUtil mmsConfig=null;
		String strCostReq="";
		StringBuffer buff=null;
		BillConfigUtil billConfig=null;
		try 
		{
			
			    System.out.println("-------------  IssueDeskPrintTransDATA . getInitDetailForIssuePage  --------------");
			
				bo = new IssueDeskPrintTransBO();
				vo = new IssueDeskPrintTransVO();
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
								
				strChk=request.getParameter("chk");
				
				
				 
			    System.out.println("strChk-----------"+strChk);
			    /*
			    hstnum_tostore_id @ "
				+ "sstnum_item_cat_no @ "
				+ "hstnum_req_no @ "
				+ "To_char (hstdt_req_date, ''DD-Mon-yyyy '') @ "
				+ "hstnum_store_id @ "
				+ "hrgnum_puk @ "
				+ "gnum_hospital_code @ "
				+ "hstnum_bs_refno  @ "
				+ "hstnum_urgent_flag
				*/
			

				temp=strChk.split("\\@");
//				formBean.setStrItemCategNo(temp[1]);
//				formBean.setStrLpRequestNo(temp[2]);
//				formBean.setStrRequestDate(temp[3]);
//				formBean.setStrRaisingStoreId(temp[4]);
//				formBean.setStrCrNo(temp[5]);
//				formBean.setStrUrgentFlg(temp[8]);
				
				formBean.setStrItemCategNo(temp[0]);
				formBean.setStrLpRequestNo(temp[1]);
				formBean.setStrRequestDate(temp[2]);
				formBean.setStrRaisingStoreId(temp[3]);
				formBean.setStrCrNo(temp[4]);
				formBean.setStrUrgentFlg(temp[7]);
				
				//formBean.setStrUrgentFlg(temp[7].split("\\$")[1]);
				formBean.setStrStoreId(strStoreId);
				//strRequestTypeId="35";

				System.out.println("------------- PatientDtlHLP.patientWithAdmissionDtl  --------------");
				
				
						
				System.out.println("<------------- pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ]   ------------->");		
				System.out.println("<------------- pkg_ipd_view.PROC_HIPT_PATADMISSION_DTL [ Mode - 1 ] ------------->");		
						
				strPatientDtl=PatientDtlHLP.patientWithAdmissionDtlNEW(formBean.getStrCrNo(), hosCode, true);

			    formBean.setStrPatientDtl(strPatientDtl);
			
			 vo = (IssueDeskPrintTransVO) TransferObjectFactory.populateData("mms.transactions.vo.IssueDeskPrintTransVO",formBean);	
			
			 vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			 vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
			
			System.out.println("getStrRaisingReqTypeId-------->"+vo.getStrRaisingReqTypeId());	
			System.out.println("getStrCrNo-------->"+vo.getStrCrNo());	
			System.out.println("getStrRequestDate-------->"+vo.getStrRequestDate());	
			System.out.println("getStrLpRequestNo-------->"+vo.getStrLpRequestNo());	
			System.out.println("getStrRaisingStoreId-------->"+vo.getStrRaisingStoreId());	
			System.out.println("getStrStoreId-------->"+vo.getStrStoreId());	
			System.out.println("getStrItemCategNo-------->"+vo.getStrItemCategNo());	
			
			/*
			 *  RaisingReqTypeId - 32 - Issue To Patient OPD
			 *                   - 35 - Issue To Patient IPD
			 * */
			
			bo.getIndentRequestDetail(vo);
		
			formBean.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
			WebRowSet wb = vo.getPatAccountDtl();
			if(wb!=null)
			{
				if(wb.size()!=0) 
				{
					
					while(wb.next()){
						formBean.setStrPatAccountNo(wb.getString(1));
						formBean.setStrPatAccountBal(wb.getString(2));
					}
				}
			}
			else
			{
				
			}
			formBean.setStrHospitalCode(hosCode);
						
			System.out.println("------------- IssueDeskPrintTransHLP.initViewForIssueAddPage  --------------");
			
			strRequestDtl=IssueDeskPrintTransHLP.initViewForIssueAddPage(formBean);
			
			formBean.setStrRequestDtl(strRequestDtl);
			
			formBean.setStrDiagDtl(patientDiagDtl(formBean.getStrCrNo(),hosCode));
					
			System.out.println("------------- IssueDeskPrintTransHLP.getItemDetails  --------------");			
							
			strRequestItemDtl=IssueDeskPrintTransHLP.getItemDetails(vo);
			
			System.out.println("------strRequestItemDtl-------"+strRequestItemDtl);
			
			formBean.setStrIndentItemDetails(strRequestItemDtl);
						
			formBean.setStrChk(strChk);
			
			formBean.setStrRequestTypeId(strRequestTypeId);
			
			formBean.setStrStoreId(strStoreId);
											
			
			System.out.println("-------------  IssueDeskPrintTransDATA . getInitDetailForIssuePage  ------- END -------");
			 
			//formBean.setStrBillPaidCat(billConfig.getStrPaidCategory());
			
		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "Issue Desk.IssueDeskPrintTransDATA.getInitDetailForIssuePage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueDeskPrintTransDATA->getIndentDetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	
	public static void getInitDetailForIssuePage(IssueDeskPrintTransFB formBean,
			HttpServletRequest request) 
	{

		IssueDeskPrintTransBO bo = null;
		IssueDeskPrintTransVO vo = null;
		String strPatientDtl="";
		String strmsgText = "";
		String strRequestTypeId="";
		String strRaisingReqTypeId="";
		String strIssueItemId="";
		String strRequestDtl="";
		String strChk="";
		String temp[]=null;
		String hosCode="";
		String strRequestItemDtl="";
		String strStoreId="";
		MmsConfigUtil mmsConfig=null;
		String strCostReq="";
		StringBuffer buff=null;
		BillConfigUtil billConfig=null;
		try {
			
			System.out.println("-------------  IssueDeskPrintTransDATA . getInitDetailForIssuePage  --------------");
			
				bo = new IssueDeskPrintTransBO();
				vo = new IssueDeskPrintTransVO();
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				mmsConfig=new MmsConfigUtil(hosCode);
				billConfig=new BillConfigUtil(hosCode);
				strCostReq=mmsConfig.getStrCostReq();
				if (request.getParameter("combo") != null	&& request.getParameter("combo").length() > 0) 
			 	{
					formBean.setCombo(request.getParameterValues("combo"));
					strRaisingReqTypeId=request.getParameterValues("combo")[1];
					strStoreId=request.getParameterValues("combo")[0];
					formBean.setStrRaisingReqTypeId(strRaisingReqTypeId);
			 	}
			 strChk=request.getParameter("chk");
			 if (request.getParameter("comboValue") != null	&& request.getParameter("comboValue").length() > 0) 
			 {
				 formBean.setComboValue(request.getParameterValues("comboValue")[0]);
				 formBean.setStrStoreName(formBean.getComboValue());
			 }
			 
			 System.out.println("strChk-----------"+strChk);
			/**
			 * This is used set variables during request type equal to patient
			 */

				temp=strChk.replace('@', '#').split("#");
				formBean.setStrItemCategNo(temp[0]);
				formBean.setStrLpRequestNo(temp[1]);
				formBean.setStrRequestDate(temp[2]);
				formBean.setStrRaisingStoreId(temp[3]);
				formBean.setStrCrNo(temp[4]);
				formBean.setStrBSReqNo(temp[6].replace('$', '#').split("#")[0]);
				formBean.setStrPoNo("0");
				formBean.setStrPoStoreId("0");
				formBean.setStrUrgentFlg(temp[7]);
				formBean.setStrStoreId(strStoreId);
				strRequestTypeId="35";

				System.out.println("------------- PatientDtlHLP.patientWithAdmissionDtl  --------------");
				
				
						
				System.out.println("<------------- pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ]   ------------->");		
				System.out.println("<------------- pkg_ipd_view.PROC_HIPT_PATADMISSION_DTL [ Mode - 1 ] ------------->");		
						
				strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(formBean.getStrCrNo(), hosCode, true);

			    formBean.setStrPatientDtl(strPatientDtl);
			
			
			
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrRaisingStoreId(formBean.getStrRaisingStoreId());
			vo.setStrLpRequestNo(formBean.getStrLpRequestNo());
			vo.setStrRequestDate(formBean.getStrRequestDate());
			vo.setStrRaisingReqTypeId(strRaisingReqTypeId);
			vo.setStrPoStoreId(formBean.getStrPoStoreId());
			vo.setStrPoNo(formBean.getStrPoNo());
			vo.setStrCrNo(formBean.getStrCrNo());
			vo.setStrUrgentFlg(formBean.getStrUrgentFlg());
			vo.setStrFinStartDate(mmsConfig.getStrFinancialStartDate(strStoreId, hosCode));
			vo.setStrFinEndDate(mmsConfig.getStrFinancialEndDate(strStoreId, hosCode));
			vo.setStrBSReqNo(formBean.getStrBSReqNo());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemCategNo(formBean.getStrItemCategNo());
			if(formBean.getStrBSReqNo().equals("0"))
				bo.getLPRequestDetail(vo);
			else
				bo.getLPRequestDetail_new(vo);
			
			
			formBean.setStrDeptName(vo.getStrDeptName());
			formBean.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
			WebRowSet wb = vo.getPatAccountDtl();
			if(wb!=null)
			{
				if(wb.size()!=0) 
				{
					
					while(wb.next()){
						formBean.setStrPatAccountNo(wb.getString(1));
						formBean.setStrPatAccountBal(wb.getString(2));
					}
				}
			}
			else
			{
				
			}
			formBean.setStrHospitalCode(hosCode);
			
			System.out.println("------------- IssueDeskPrintTransHLP.initViewForIssueAddPage  --------------");
			
			strRequestDtl=IssueDeskPrintTransHLP.initViewForIssueAddPage(formBean);
			
			formBean.setStrDiagDtl(patientDiagDtl(formBean.getStrCrNo(),hosCode));
			
			
			
			formBean.setStrRequestDtl(strRequestDtl);
			//System.out.println("mmsConfig.getStrSCMIntegration"+mmsConfig.getStrSCMIntegration().equals("1"));
			//System.out.println("vo.getStrLpRequestNo"+vo.getStrLpRequestNo().substring(0,2).equals("10"));
			
			System.out.println("------------- IssueDeskPrintTransHLP.getItemDetails  --------------");
			
			strRequestItemDtl=IssueDeskPrintTransHLP.getItemDetails(vo.getRequestItemDtlWS());
			
			formBean.setStrRequestItemDtl(strRequestItemDtl);
			System.out.println("formBean.setStrRequestItemDtl---->"+formBean.getStrRequestItemDtl());
			
			System.out.println("------------- IssueDeskPrintTransHLP.getIssueItemDetails  --------------");
			
			strIssueItemId=IssueDeskPrintTransHLP.getIssueItemDetails(vo.getIssueItemDtlWS(),strCostReq,strStoreId,hosCode,vo.getStrRaisingStoreId(),vo.getStrBSReqNo(),vo);
			
				
				
			
			
			formBean.setStrIssueItemId(strIssueItemId);
			
			System.out.println("formBean.getStrIssueItemId---->"+formBean.getStrIssueItemId());
			
			formBean.setStrChk(strChk);
			
			formBean.setStrRequestTypeId(strRequestTypeId);
			
			formBean.setStrStoreId(strStoreId);
			
			formBean.setCombo(request.getParameterValues("combo"));
			
			formBean.setStrSCMIntegration(mmsConfig.getStrSCMIntegration());
			
			System.out.println("-------------  IssueDeskPrintTransDATA . getInitDetailForIssuePage  ------- END -------");
			 
			//formBean.setStrBillPaidCat(billConfig.getStrPaidCategory());
			
		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "Issue Desk.IssueDeskPrintTransDATA.getInitDetailForIssuePage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueDeskPrintTransDATA->getIndentDetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	
	public static void indent_ViewDataBS(IssueDeskPrintTransFB formBean,HttpServletRequest request) 
	{
		IssueDeskPrintTransBO bo = null;
		IssueDeskPrintTransVO vo = null;
		String strmsgText = "";
		String str1 ="";
		String str2 ="";
		String str3 ="";
		//Change Request
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strChk;		
		String temp[]=null;
		try 
		{
			bo = new IssueDeskPrintTransBO();
			vo = new IssueDeskPrintTransVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
			
	       			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			strChk=request.getParameter("chk");
			
			
			 
		    System.out.println("strChk-----------"+strChk);
		    /*
		    HSTNUM_REQ_NO 
           || '@' || HSTNUM_STORE_ID  
           || '@' || SSTNUM_REQTYPE_ID 
           || '@' || A.SSTNUM_ITEM_CAT_NO 
           || '@' || A.HSTNUM_URGENT_FLAG 
           || '@' || HSTSTR_INDENT_PERIOD
           || '@' ||HSTNUM_TOSTORE_ID 
           
			*/		

			temp=strChk.split("\\@");
			
			
			vo.setStrReqNo(temp[0]);
			vo.setStrReqTypeId(temp[2]);
			vo.setStrStoreId(temp[1]);
			vo.setStrToStoreId(temp[6]);					
			
         	bo.viewData(vo);        	
				
			str1 =   IssueDeskPrintTransHLP.getIndent_ItemDetailsBS(vo);						
			
			str3  =  IssueDeskPrintTransHLP.getIndent_DetailsBS(vo);
			
			formBean.setStrSetItemDetails(str1);
			formBean.setStrIndentDetails(str3);
			formBean.setStrChk(strChk);
			if(vo.getStrHospitalCode().equals("21917")) // 21917
			{	
				
				formBean.setStrRequestName("EXTERNAL INDENT SLIP");			
			}
			else
			{										
				formBean.setStrRequestName("External / NA Certificate");
			}
			
			
			 System.out.println("Item Dtl-----------"+str1);
			 System.out.println("Indent Dtl-----------"+str3);
			
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IssueDeskPrintTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueDeskPrintTransDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	
	public static void getInitDetailForReturnViewPage(IssueDeskPrintTransFB formBean,
			HttpServletRequest request) {

		IssueDeskPrintTransBO bo = null;
		IssueDeskPrintTransVO vo = null;
		String strPatientDtl="";
		String strPatientDtlNew="";
		String strmsgText = "";
		String strRequestTypeId="";
		String strRaisingReqTypeId="";
		
		String strRequestDtl="";
		String strRequestDtlNew="";
		String strChk="";
		String temp[]=null;
		String hosCode="";
		String status;
		
		String strStoreId="";
		try {
			System.out.println("-------------  IssueDeskPrintTransDATA . getInitDetailForReturnViewPage  ------- START -------");
			
			    bo = new IssueDeskPrintTransBO();
				vo = new IssueDeskPrintTransVO();
				
				 hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
				 
				 System.out.println("P_KEY--->>hstnum_store_id @ "
							+ "hstnum_issue_no @ "
							+ "hrgnum_puk @ "
							+ "pistr_emp_no @ "
							+ "sstnum_item_cat_no @  "
							+ "To_char(hstdt_issue_date, ''DD-Mon-yyyy'') @ "
							+ "hstnum_req_no @ "
							+ "To_char(hstdt_req_date, ''DD-Mon-yyyy'') @"
							+ "gnum_hospital_code");	
				
				  
				    strChk  =  request.getParameter("chk");
				    				
				
				    strRequestTypeId = formBean.getStrRequestTypeId();
					
					temp  =  strChk.split("\\@");
					formBean.setStrItemCategNo(temp[4]);
					formBean.setStrIssueNo(temp[1]);
					formBean.setStrIssueStoreId(temp[0]);
					formBean.setStrCrNo(temp[2]);
					formBean.setStrIssueDate(temp[5]);
					formBean.setStrLpRequestNo(temp[6]);
					formBean.setStrRequestDate(temp[7]);
					strRaisingReqTypeId="13";
				
				
				
				if(strRaisingReqTypeId.equals("35")|| strRaisingReqTypeId.equals("12") || strRaisingReqTypeId.equals("13")||strRequestTypeId.equals("32"))
				{
					 System.out.println("------------- PatientDtlHLP.patientWithAdmissionDtlView  --------------");
					 System.out.println("-------------  pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ] -----------");
					 System.out.println("-------------  pkg_ipd_view.PROC_HIPT_PATADMISSION_DTL [ Mode - 1 ] -----------");
					strPatientDtl=PatientDtlHLP.patientWithAdmissionDtlView(formBean.getStrCrNo(), hosCode, true);
				}
				formBean.setStrPatientDtl(strPatientDtl);
				if(strRaisingReqTypeId.equals("35")|| strRaisingReqTypeId.equals("12") || strRaisingReqTypeId.equals("13")||strRequestTypeId.equals("32"))
				{
					 System.out.println("------------- PatientDtlHLP.patientWithAdmissionDtlViewNew  --------------");
					 System.out.println("-------------  pkg_simple_view.PROC_HRGT_PATIENT_DTL  ---[ Mode - 1 ]-----------");
					 System.out.println("-------------  pkg_ipd_view.PROC_HIPT_PATADMISSION_DTL [ Mode - 1 ] -----------");
					strPatientDtlNew=PatientDtlHLP.patientWithAdmissionDtlView(formBean.getStrCrNo(), hosCode, true);
				}				
				formBean.setStrPatientDtlNew(strPatientDtlNew);
				
				 vo = (IssueDeskPrintTransVO) TransferObjectFactory.populateData("mms.transactions.vo.IssueDeskPrintTransVO",formBean);	
					
				 vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				 vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());		
				
				
				bo.getIssueItemDetailview(vo);
				formBean.setStrDeptName(vo.getStrDeptName());
			    formBean.setStrRequestTypeId(strRequestTypeId);
			    System.out.println("------------- IssueDeskPrintTransHLP.getIssuedItemDetailsForReturnViewNew  --------------");
			    
				strRequestDtl=IssueDeskPrintTransHLP.getIssuedItemDetailsForReturnViewNew(vo.getIssuedItemDtlWS(),vo.getStrHospitalCode());
				formBean.setStrRequestDtlNew(strRequestDtl);
				
				 System.out.println("------------- IssueDeskPrintTransHLP.getIssuedItemDetailsForReturnView  --------------");
				 
				// System.out.println("------------- vo.getIssuedItemDtlWS().size() ---------"+vo.getIssuedItemDtlWS().size());
				
				 vo.getIssuedItemDtlWS().beforeFirst();
			
			  strRequestDtlNew=IssueDeskPrintTransHLP.getIssuedItemDetailsForReturnView(vo.getIssuedItemDtlWS(),vo.getStrHospitalCode());
			  formBean.setStrRequestDtl(strRequestDtlNew);
			  
			  System.out.println("-------------  IssueDeskPrintTransDATA . getInitDetailForReturnViewPage  ------- END -------");
			 
			
						 
			
		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "Issue Desk.IssueDeskPrintTransDATA.getInitDetailForReturnViewPage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueDeskPrintTransDATA->getInitDetailForReturnViewPage()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	
	public static void insertData(IssueDeskPrintTransFB formBean,
			HttpServletRequest request){
		
		IssueDeskPrintTransBO bo = null;
		IssueDeskPrintTransVO vo = null;
		MmsConfigUtil mcu=null;
		
		String temp[]=null;
		//String strItemIdArray[] = null;
		String strmsgText="";
		String strDescription="";
		String[] values = null;
		String UCreq="";
		
		try{
			
			mcu=new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			bo= new IssueDeskPrintTransBO();
			
			System.out.println("---------IssueDeskPrintTransDATA.insertData---------");
			vo = (IssueDeskPrintTransVO) TransferObjectFactory.populateData("mms.transactions.vo.IssueDeskPrintTransVO",formBean);
			UCreq=formBean.getStrUCReq();
			if(formBean.getStrRaisingReqTypeId().equals("12") || formBean.getStrRaisingReqTypeId().equals("13") ||  formBean.getStrRaisingReqTypeId().equals("35"))
			{
				////System.out.println("check1");
				if(formBean.getStrAdmissionDtlHidVal()!=null){
					
					////System.out.println(formBean.getStrAdmissionDtlHidVal());
					
					
					temp=formBean.getStrAdmissionDtlHidVal().replace('^', '#').split("#");
					//IPD
					if(temp.length>1){
						vo.setStrAdmissionNo(temp[0]);
						vo.setStrEpisodeCode(temp[1]);
						vo.setStrVisitNo(temp[2]);
						vo.setStrDeptCode(temp[5].substring(0, 3));
						vo.setStrDeptUnitCode(temp[16]);
						vo.setStrWardCode(temp[6]);
						vo.setStrVisitType("0"); 
						vo.setStrTreatmentCat(temp[9]);
						
					}else{
						
						vo.setStrAdmissionNo("0");
						vo.setStrEpisodeCode("0");
						vo.setStrVisitNo("0");
						vo.setStrDeptCode("0");
						vo.setStrDeptUnitCode("0");
						vo.setStrWardCode("0");
						vo.setStrVisitType("1"); 
						vo.setStrTreatmentCat("0");
					}
				}
				else
				{
					vo.setStrAdmissionNo("0");
					vo.setStrEpisodeCode("0");
					vo.setStrVisitNo("0");
					vo.setStrDeptCode("0");
					vo.setStrDeptUnitCode("0");
					vo.setStrWardCode("0");
					vo.setStrVisitType("1");       //OPD
					vo.setStrTreatmentCat("0");
				}
				
			}
			else{
			
				vo.setStrAdmissionNo("0");
				vo.setStrEpisodeCode("0");
				vo.setStrVisitNo("0");
				vo.setStrDeptCode("0");
				vo.setStrDeptUnitCode("0");
				vo.setStrWardCode("0");
				vo.setStrVisitType("1"); 
				vo.setStrCrNo("0");
				vo.setStrTreatmentCat("0");
			}
			System.out.println("-RequestTypeId()--[31- Issue To Store  , 35 - Issue To Pateint IPD , 32 - Issue To Patient Direct ]-------"+formBean.getStrRequestTypeId());
			
			if(formBean.getStrRequestTypeId().equals("35")){
				strDescription="Issue To IPD Patient: CRNO"+formBean.getStrCrNo();
		
			}else if(formBean.getStrRequestTypeId().equals("36")){
				strDescription="Issue To Employee: C.R.No. "+formBean.getStrCrNo()+
				" EmpNo: "+formBean.getStrEmpNo();
			}
			else{
				strDescription="Issue To Department: DeptName ";
			}
			 vo.setStrCrNo(formBean.getStrCrNo());
			vo.setStrDescription(strDescription);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStockDtlsId(formBean.getStockDtlsId());
			
			vo.setStrUrgentFlg(formBean.getStrUrgentFlg().replace("$","#").split("#")[0]);
			
			System.out.println("----2-----IssueDeskPrintTransDATA.insertData---------");
			
			////System.out.println("strStockDtlsChk ::::::::::::::::::: "+formBean.getStrStockDtlsChk().length);
			bo.insertData(vo);
			
			
			if(vo.getStrMsgType().equals("1")){
				formBean.setStrFlag("0");
				
				throw new Exception(vo.getStrMsgString());
			}else{
				formBean.setStrFlag("1");
				if(vo.getStrBSReqNo() != null && !vo.getStrBSReqNo().equals("0"))
					formBean.setStrMsg("LP Indent raised successfully with indent no :"+vo.getStrBSReqNo());
			}
			if(vo.getStrIssueNo() != null || !vo.getStrIssueNo().equals(""))
				formBean.setStrIssueNo(vo.getStrIssueNo());
			
			formBean.setStrUCReq(UCreq);
		}
		catch(Exception _err)
		{
			_err.printStackTrace();
			strmsgText = "Issue Desk.IssueDeskPrintTransDATA.insertData(vo) --> "+ _err.getMessage();
			//System.out.println(strmsgText);
			HisException eObj = new HisException("mms","IssueDeskPrintTransDATA->getIndentDetails()", strmsgText);
			if(strmsgText.contains("Patient Account Balance Going To Be Insufficient.Please Deposit Part Payment!!"))
				formBean.setStrErr("Patient Account Balance Going To Be Insufficient.Please Deposit Part Payment!!");
			else		
				formBean.setStrErr("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		}
	}
	

	
	public static String patientDiagDtl(String strCrNo,String strHospitalCode)
	{
		IssueDeskPrintTransVO vo = new IssueDeskPrintTransVO();	
		IssueDeskPrintTransBO bo = new IssueDeskPrintTransBO();
			StringBuffer sb = new StringBuffer("");
			vo.setStrCrNo(strCrNo);
			vo.setStrHospitalCode(strHospitalCode);
			
			WebRowSet ws = null;
			
			sb.append("");
			
			try 
			{
				bo.getPatientDiagDetails(vo);
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
				
				System.out.println("-------------  IssueDeskPrintTransDATA . patientDiagDtl  ------- START -------");
			
				ws = vo.getDiagEmpWs();
				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				sb.append("<tr><td width='50%' class='LABEL' ><div align='center'>Diagnosis Name(Code)</div></td>");
				sb.append("<td width='50%' class='LABEL' ><div align='center'>Treatment Consultant</div></td></tr> ");
				if (ws != null && ws.size() > 0) 
				{
					
					while (ws.next()) 
					{
						String diagName = ws.getString(1);
						String diagCode = ws.getString(2);
						String empName = ws.getString(3);
						String empcode = ws.getString(4);
								
						if (diagName == null)
							diagName = "----";
//						if (diagCode == null)
//							diagCode = "----";
						if (empName == null)
							empName = "----";
						if (empcode == null)
							empcode = "----";
						
						
						
						sb.append("<tr><td width='50%' class='CONTROL'><div align='center'>"+diagName+"(<b>"+diagCode+"</b>)</div>");
						sb.append("</td>");
						sb.append("<td width='50%' class='CONTROL'><div align='center'>");
						sb.append(empName);
						sb.append("<input type='hidden' name='strDiagCode' value='"+ diagCode + "'><input type='hidden' name='strEmpCode' value='"+ empcode + "'></div></td>");
						sb.append("</tr>");
//						sb.append("<tr><td width='25%' class='LABEL'>Diagnosis Code</td>");
//						sb.append("<td width='25%' class='CONTROL'> ");
//						sb.append(diagCode);
//						sb.append("</td></tr>");
						
					}
					
				}
				else
				{
					sb.append("<tr><td width='50%' class='CONTROL'><div align='center'>"+"-"+"("+"-"+")</div>");
					sb.append("</td>");
					sb.append("<td width='50%' class='CONTROL'><div align='center'>");
					sb.append("-");
					sb.append("<input type='hidden' name='strDiagCode' value='"+ "-" + "'><input type='hidden' name='strEmpCode' value='"+ "0" + "'></div></td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
				
				System.out.println("-------------  IssueDeskPrintTransDATA . patientDiagDtl  ------- END -------");
			} 
			catch (Exception e) 
			{
				try {
					throw new Exception("IssueDeskPrintTransDATA-->diagDtl-->"	+ e.getMessage());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} 
			finally 
			{
				if (ws != null) 
				{
					try {
						ws.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ws = null;
				}
			}
	return sb.toString();
	}
	
	public static void showReport(IssueDeskPrintTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();

		String reportFormat = "pdf";
		String strReqNo = "";
		String combo[] = null;
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = "";
			String[] strChk = request.getParameterValues("chk");
			

			for (int i = 0, stopI = strChk.length; i < stopI; i++) {
				String[] strtemp = strChk[i].replace("@", "#").split("#");
				if (i == 0) {
					strReqNo = strReqNo + strtemp[1];

				} else {
					strReqNo = strReqNo + "," + strtemp[1];

				}
			}

			combo = request.getParameterValues("combo");
			String[] strTemp = combo[0].split("\\^");
			String strStoreId = strTemp[0];
	
				//System.out.println("report_id"+ strReportId);
				//System.out.println("hospCode"+ strHospitalCode);
				//System.out.println("storeId"+ strStoreId);
				//System.out.println("issueNo"+ strReqNo);
				String reportPath = "/mms/reports/issue_patient_mmsrpt.rptdesign";
				String strReportName = "UTILITY CERTIFICATE";

				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("issueNo", strReqNo);

				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);


		} catch (Exception e) {

			e.printStackTrace();

		}
	}



	
	public static String getInitPatDtl(GlobalVO vo)
	{
		GlobalVO voObj = (GlobalVO) vo;
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer(""); 
		IssueDeskPrintTransVO _IssueDeskPrintTransVO = new IssueDeskPrintTransVO();
		WebRowSet ws = null;  
		WebRowSet ws2 = null;  
		try 
			{ 
			
			System.out.println("-------------  IssueDeskPrintTransDATA . getInitPatDtl  ------- START -------");
			
				_IssueDeskPrintTransVO.setStrCrNo(voObj.getStrValue1());
				_IssueDeskPrintTransVO.setStrHospitalCode(voObj.getStrValue2());
				IssueDeskPrintTransDAO.getPatientAccountDetailsNew(_IssueDeskPrintTransVO);  //getPatientAccountDetails(_IssueDeskPrintTransVO)
				ws2 = _IssueDeskPrintTransVO.getPatAccountDtl();
				
				boObj.getPatientDetails(voObj);
				
				if (voObj.getStrMsgType().equals("1")) 
				{
					throw new Exception(voObj.getStrMsgString());
				}
	
				ws = voObj.getGblWs1(); 
				if (ws != null && ws.size() > 0) 
				{
					if (ws.next()) 
					{
						String strAgeAndSex = ws.getString(2);
						String strPatientName = ws.getString(3);
						String strFatherOrHusbandName = ws.getString(4);
						String strSpouseName = ws.getString(5);
						String strReligion = ws.getString(6);
						String strCategoryName = ws.getString(7);
						String strCategoryCode = ws.getString(8); 
						String strAddress = ws.getString(9);
						String strMlcNo = ws.getString(10);
						String strHiddenValue = ws.getString(11); 
						String catGrp = ws.getString(13);
						String visitType = ws.getString(15).split("\\^")[0];
						String episodeCode = ws.getString(15).split("\\^")[1];
						if (strHiddenValue == null)
							strHiddenValue = "----";
						String[] id = strHiddenValue.split("\\^");
						String strEmailId = ws.getString(16);

						if (strAgeAndSex == null)
							strAgeAndSex = "----";
						if (strPatientName == null)
							strPatientName = "----";
						if (strFatherOrHusbandName == null)
							strFatherOrHusbandName = "----";
						if (strSpouseName == null)
							strSpouseName = "----";
						if (strReligion == null)
							strReligion = "----";
						if (strCategoryName == null)
							strCategoryName = "----";
						if (strCategoryCode == null)
							strCategoryCode = "----";
						if (strAddress == null)
							strAddress = "----";					
						if (strMlcNo == null)
							strMlcNo = "-----";
						JSONObject json = new JSONObject();
						json.put("strAgeAndSex", strAgeAndSex);
						json.put("strPatientName", strPatientName);
						json.put("strFatherOrHusbandName", strFatherOrHusbandName);
						json.put("strSpouseName", strSpouseName);
						json.put("strReligion", strReligion);
						json.put("strCategoryName", strCategoryName);
						json.put("strCategoryCode", strCategoryCode);
						json.put("strAddress", strAddress);
						json.put("strMlcNo", strMlcNo);
						json.put("strHiddenValue", strHiddenValue);
						json.put("catGrp", catGrp);
						json.put("visitType", visitType);
						json.put("episodeCode", episodeCode);
						json.put("strEmailId", strEmailId);
						
						if(ws2!=null)
						{
							if(ws2.size()!=0) 
							{
								
								while(ws2.next()){ 
									json.put("setStrPatAccountNo", ws2.getString(1));
									json.put("setStrPatAccountBal", ws2.getString(2));
								}
							}
						}
						return json.toString();
						
					}
				}
				System.out.println("-------------  IssueDeskPrintTransDATA . getInitPatDtl  ------- END -------");
			}
		catch(Exception e){
			
		}
		return "";
	}
	public static String getInitPatAdmDtl(GlobalVO vo)
	{
		GlobalVO voObj = (GlobalVO) vo;
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer(""); 
		WebRowSet ws = null;  
		try 
			{
			System.out.println("-------------  IssueDeskPrintTransDATA . getInitPatAdmDtl  ------- START -------");
			System.out.println("-------------  pkg_ipd_view.PROC_HIPT_PATADMISSION_DTL  ------- [ Mode - 1] -------");
			
			
				boObj.getAdmissionDetails(voObj);
				
				if (voObj.getStrMsgType().equals("1")) 
				{
					throw new Exception(voObj.getStrMsgString());
				}
				
				
	
				ws = voObj.getGblWs1(); 
				if (ws != null && ws.size() > 0) 
				{
					if (ws.next()) 
					{
						String strDeptName = ws.getString(1);
						String strUnitName = ws.getString(2);
						String strWardName = ws.getString(3);
						String strRoomName = ws.getString(4);
						String strBedName = ws.getString(5);
						String strTreatmentCategoryName = ws.getString(6);
						String strConsultantName = ws.getString(7);
						String strNewBornBabyFlag = ws.getString(8);
						String strHiddenValue = ws.getString(9);//strHiddenValue=ADMNO^EPCODE^VISITNO^ADMDATETIME^ADMADVNO^DEPTCODE^WARDCODE^ROOMCODE^BEDCODE^TREATCATCODE^ISNEWBORN^MOTHERADMNO^MLCNO^OCCUPID^BEDALLOCDATETIME^LENGTHOFSTAY
						if (strHiddenValue == null)
							strHiddenValue = ""; 
						String strTemp[] = strHiddenValue.replace("^", "#").split("#"); 
						String strAdmissionNo = strTemp[0];
						String strEpisodeCode = strTemp[1];
						String strAdmissionDate = strTemp[3];
						String strMotherAdmNo="";
						String strMLCNo = ""; 
						if(strTemp.length>=12)
						{
							strMotherAdmNo = strTemp[11];
							strMLCNo = strTemp[12];
						}
						if (strDeptName == null)
							strDeptName = "";
						if (strUnitName == null)
							strUnitName = "";
						if (strWardName == null)
							strWardName = "";
						if (strRoomName == null)
							strRoomName = "";
						if (strBedName == null)
							strBedName = "";
						if (strTreatmentCategoryName == null)
							strTreatmentCategoryName = "";
						if (strConsultantName == null)
							strConsultantName = "";
						if (strNewBornBabyFlag == null)
							strNewBornBabyFlag = "";					
						if (strAdmissionNo == null)
							strAdmissionNo = "";
						if (strEpisodeCode == null)
							strEpisodeCode = "";
						if (strAdmissionDate == null)
							strAdmissionDate = "";
						if (strMotherAdmNo == null)
							strMotherAdmNo = "";
						if (strMLCNo == null)
							strMLCNo = "";
						
						JSONObject json = new JSONObject();
						json.put("strDeptName", strDeptName); 
						json.put("strUnitName", strUnitName); 
						json.put("strWardName", strWardName); 
						json.put("strBedName", strBedName); 
						json.put("strTreatmentCategoryName", strTreatmentCategoryName); 
						json.put("strConsultantName", strConsultantName); 
						json.put("strNewBornBabyFlag", strNewBornBabyFlag); 
						json.put("strHiddenValue", strHiddenValue); 
						json.put("strAdmissionNo", strAdmissionNo); 
						json.put("strEpisodeCode", strEpisodeCode); 
						json.put("strAdmissionDate", strAdmissionDate); 
						json.put("strMotherAdmNo", strMotherAdmNo); 
						json.put("strMLCNo", strMLCNo); 
						 
						return json.toString();
						
					}
				}
			}
		catch(Exception e){
			
		}
		return "";
	}

	public static String getInitPatDiaDtl(GlobalVO vo)
	{
		GlobalVO voObj = (GlobalVO) vo; 
		IssueDeskPrintTransVO vo1 = new IssueDeskPrintTransVO();	
		vo1.setStrCrNo(voObj.getStrValue1());
		vo1.setStrHospitalCode(voObj.getStrValue2());
		IssueDeskPrintTransBO bo = new IssueDeskPrintTransBO();  
		WebRowSet ws = null;  
		try 
			{ 
				
				if (voObj.getStrMsgType().equals("1")) 
				{
					throw new Exception(voObj.getStrMsgString());
				}

				ws = vo1.getDiagEmpWs();
				if (ws != null && ws.size() > 0) 
				{
					if (ws.next()) 
					{
						String diagName = ws.getString(1);
						String diagCode = ws.getString(2);
						String empName = ws.getString(3);
						String empcode = ws.getString(4);
								
						if (diagName == null)
							diagName = "----";
//						if (diagCode == null)
//							diagCode = "----";
						if (empName == null)
							empName = "----";
						if (empcode == null)
							empcode = "----";
						
						
						JSONObject json = new JSONObject();
						json.put("diagName", diagName);  
						json.put("diagCode", diagCode);  
						json.put("empName", empName);  
						json.put("empcode", empcode);  
						 
						return json.toString();
						
					}
				}
			}
		catch(Exception e){
			
		}
		return "";
	}
	
	
	 
	
}