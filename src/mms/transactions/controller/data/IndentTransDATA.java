package mms.transactions.controller.data;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.transactions.bo.IndentTransBO;
import mms.transactions.controller.fb.IndentTransFB;
import mms.transactions.vo.IndentTransVO;

public class IndentTransDATA 
{
	
	
	/**
	 * 
	 * @param formBean	the IndentTransFB
	 * @param request	the HttpServletRequest
	 */
	public static void getListPageCombo(IndentTransFB formBean,	HttpServletRequest request,HttpServletResponse response) 
	{
		// Creating Object for BO & VO.
		IndentTransVO vo = null;
		IndentTransBO bo = null;
	
		HisUtil util = null;			
		try
		{
			System.out.println("-------------IndentTransDATA . getListPageCombo ------------------");
			    vo = new IndentTransVO();
			    bo = new IndentTransBO();
			    util = new HisUtil("MMS Transactions", "getDepartmentCombo");
								
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
				
																	
				bo.getListPageCombo(vo);	// pkg_mms_view.proc_hstt_store_mst  [ Mode- 12 ] 
				                            // pkg_mms_view2.proc_lstpage_requesttype_dtl  [ Mode- 1 ]
				                            // proc_lstpage_catgcombo_dtl [ Mode - 1]
				
				String strStoreCombo = "";
				
				if (vo.getStrStoreWs() != null && vo.getStrStoreWs().size() > 0) 
				{
					strStoreCombo = util.getOptionValue(vo.getStrStoreWs(), "", "", true);
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
				
				String strCatgCombo = "";
				
				if (vo.getStrCatgWs() != null && vo.getStrCatgWs().size() > 0) 
				{
					strCatgCombo = util.getOptionValue(vo.getStrCatgWs(), "", "", true);
				} 
				else 
				{
					strCatgCombo = "<option value='0'>Select Value</option>";
				}			
				
				formBean.setStrStoreCombo(strStoreCombo);
				formBean.setStrReqTypeCombo(strReqTypeCombo);
				formBean.setStrCatgCombo(strCatgCombo);
				
				formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				               
				System.out.println("-------------IndentTransDATA . getListPageCombo ---------END---------");
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
	
	public static void ItemCatgoryCombo(HttpServletRequest request, HttpServletResponse response,IndentTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";		
		   IndentTransVO vo = null;
		   IndentTransBO bo = null;
		   HisUtil   util = null;
		try
		{  
			     vo = new IndentTransVO();
		         bo = new IndentTransBO();
		       util = new HisUtil("transaction", "IndentTransDATA");		   
			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
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


			bo.getCatgCombo(vo);
			
			String strCatgCombo = "";
			
			if (vo.getStrCatgWs() != null && vo.getStrCatgWs().size() > 0) 
			{
				strCatgCombo = util.getOptionValue(vo.getStrCatgWs(), "", "", true);
			} 
			else 
			{
				strCatgCombo = "<option value='0'>Select Value</option>";
			}			

			
			response.setHeader("Cache-Control", "no-cache");		 	
		 	response.getWriter().print(strCatgCombo);
			 		 
			
			
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "IndentTransDATA->ItemCatgoryCombo()", strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} 
		finally 
		{
    		if (vo != null)
				vo = null;
			if(util != null) util = null;
			if (bo != null)
				bo = null;
		}
    
	}
	
	public static void ReqTypeCombo(HttpServletRequest request, HttpServletResponse response,IndentTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";		
		   IndentTransVO vo = null;
		   IndentTransBO bo = null;
		   HisUtil   util = null;
		try
		{  
			     vo = new IndentTransVO();
		         bo = new IndentTransBO();
		         util = new HisUtil("transaction", "IndentTransDATA");		   
			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
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


			bo.getRequestTypeCombo(vo);
			
			String strReqTypeCombo = "";
			
			if (vo.getStrRequestTypeWs() != null && vo.getStrRequestTypeWs().size() > 0) 
			{
				strReqTypeCombo = util.getOptionValue(vo.getStrRequestTypeWs(), "", "", true);
			} 
			else 
			{
				strReqTypeCombo = "<option value='0'>Select Value</option>";
			}		
			
			response.setHeader("Cache-Control", "no-cache");		 	
		 	response.getWriter().print(strReqTypeCombo);
			 		 
			
			
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "IndentTransDATA->ItemCatgoryCombo()", strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} 
		finally 
		{
    		if (vo != null)
				vo = null;
			if(util != null) util = null;
			if (bo != null)
				bo = null;
		}
    
	}
	
	/**
	 * 
	 * @param formBean	the IndentTransFB
	 * @param request	the HttpServletRequest
	 */
	public static void getList_HLP(IndentTransFB formBean,	HttpServletRequest request,HttpServletResponse response) 
	{
		// Creating Object for BO & VO.
		IndentTransVO vo = null;
		IndentTransBO bo = null;		
		String strDataTable="";	
		HisUtil util = null;			
		try
		{
			    vo = new IndentTransVO();
			    bo = new IndentTransBO();
			    util = new HisUtil("MMS Transactions", "getList_HLP");
								
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
				
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
				
				strDataTable	=	DATA_TABLE_HLP(vo.getStrDataTableWs(),vo);
				System.out.println("------TABLE_HLP------"+strDataTable);
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
	
	/**
	 * To get Pending Day End Details HLP
	 * 
	 * @param wrsData_p
	 * @param strWithOrWithoutRadioButton
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	private static String DATA_TABLE_HLP(WebRowSet wrsData_p , IndentTransVO vo)	throws SQLException,Exception
	{		
		StringBuffer sbBody = new StringBuffer(20);
		int index=1;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		
		
		
		
		if (wrsData_p != null && wrsData_p.size() > 0) 
		{		
			
			if(vo.getStrRequestTypeId().equals("13"))   
			{
			
				System.out.println("Size--------A----------->>"+wrsData_p.size() );
				System.out.println("getStrRequestTypeId---->>"+vo.getStrRequestTypeId() );
				
				sbBody   = new StringBuffer(500);		
				
				/*
				 * Header Row:
				 */
				sbBody.append("<table id='example'  class='cell-border compact stripe' style='width:100%'>");
				sbBody.append("<thead>");
				sbBody.append("<tr>");
				sbBody.append("<th align='center'>[ CR No ] Patient Name</th>");				
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
		                 [ 
		                   HSTNUM_REQ_NO        @ 
					       HSTNUM_STORE_ID      @ 
					       SSTNUM_REQTYPE_ID    @ 
					       SSTNUM_ITEM_CAT_NO   @ 
					       HSTNUM_URGENT_FLAG   @ 
					       HSTSTR_INDENT_PERIOD @ 
					       HSTNUM_TOSTORE_ID
					      ] 
	                2. Issue No
	                3. Indent No
	                4. Issue Date 
	                5. Req Store Name
	                6. CR_NO
	                7. PAT_NAME
	                8. Catg Name
	                
	            */ 
				
				while (wrsData_p.next()) 
				{
										
					String Chk_ID 			= wrsData_p.getString(1);
					String crNo 			= wrsData_p.getString(2);
					String patientName     	= wrsData_p.getString(3);
					String indentNo 		= wrsData_p.getString(4);
					String indentDate    	= wrsData_p.getString(5);
					String toStoreName     	= wrsData_p.getString(6);
					String Status       	= wrsData_p.getString(7);					
					String urgentFlg       	= wrsData_p.getString(8);
			
					/*
					 * Table Body
					 */						
					
					sbBody.append("<tr>");	
					sbBody.append("<td align='center'> [ " + crNo+" ] "+patientName+"</td>");
					sbBody.append("<td align='center'>" + indentNo +"</td>");
					sbBody.append("<td align='center'>" + indentDate+"</td>");
					sbBody.append("<td align='center'>" + toStoreName + "</td>");
					sbBody.append("<td align='center'>" + Status + "</td>");
					sbBody.append("<td align='center'><input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+index+"' value='"+Chk_ID+"'>");
					//sbBody.append("<button type='button' id='bId1"+index+"' onclick='getViewCNT(\""+index+"\");' class='btn pmd-btn-fab pmd-ripple-effect btn-info pmd-btn-raised' data-placement='top' data-toggle='tooltip' title='Generate Indent'><i class='material-icons pmd-sm' aria-hidden='true'></i>GEN</button>");
					sbBody.append("<button type='button' id='bId2"+index+"' onclick='getViewCNT(\""+index+"\");' class='btn pmd-btn-fab pmd-ripple-effect btn-info pmd-btn-raised' data-placement='top' data-toggle='tooltip' title='Cancel Indent'><i class='material-icons pmd-sm' aria-hidden='true'></i>CAN</button>");
					sbBody.append("<button type='button' id='bId3"+index+"' onclick='getViewCNT(\""+index+"\");' class='btn pmd-btn-fab pmd-ripple-effect btn-info pmd-btn-raised' data-placement='top' data-toggle='tooltip' title='Return Indent'><i class='material-icons pmd-sm' aria-hidden='true'></i>RET</button>");
					sbBody.append("<button type='button' id='bId4"+index+"' onclick='getViewCNT(\""+index+"\");' class='btn pmd-btn-fab pmd-ripple-effect btn-info pmd-btn-raised' data-placement='top' data-toggle='tooltip' title='View Indent'><i class='material-icons pmd-sm' aria-hidden='true'></i>VIEW</button>");
					sbBody.append("</td>");
				
					index++;
					sbBody.append("</tr>"); 
					
				}
				
				sbBody.append("</tbody>");
				sbBody.append("</table>");
			}
		    else
			{
								
		    	System.out.println("Size--------B----------->>"+wrsData_p.size() );
				System.out.println("getStrRequestTypeId---->>"+vo.getStrRequestTypeId() );
				
				sbBody   = new StringBuffer(1000);
				
				/*
				 * Header Row:
				 */
				sbBody.append("<table id='example' class='cell-border compact stripe' style='width:100%'>");
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
		                 [ 
		                   HSTNUM_REQ_NO        @ 
					       HSTNUM_STORE_ID      @ 
					       SSTNUM_REQTYPE_ID    @ 
					       SSTNUM_ITEM_CAT_NO   @ 
					       HSTNUM_URGENT_FLAG   @ 
					       HSTSTR_INDENT_PERIOD @ 
					       HSTNUM_TOSTORE_ID
					      ] 
	                2. Req No
	                3. Req Date
	                4. To Store Name 
	                5. INDENT_STATUS
	                6. Pat_Name
	                7. Urgent Flag 
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
					sbBody.append("<td align='center'><input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+index+"' value='"+Chk_ID+"'>");
					//sbBody.append("<button type='button' id='bId1"+index+"' onclick='getViewCNT(\""+index+"\");' class='btn pmd-btn-fab pmd-ripple-effect btn-info pmd-btn-raised' data-placement='top' data-toggle='tooltip' title='Generate Indent'><i class='material-icons pmd-sm' aria-hidden='true'></i>GEN</button>");
					sbBody.append("<button type='button' id='bId2"+index+"' onclick='getViewCNT(\""+index+"\");' class='btn pmd-btn-fab pmd-ripple-effect btn-info pmd-btn-raised' data-placement='top' data-toggle='tooltip' title='Cancel Indent'><i class='material-icons pmd-sm' aria-hidden='true'></i>CAN</button>");
					sbBody.append("<button type='button' id='bId3"+index+"' onclick='getViewCNT(\""+index+"\");' class='btn pmd-btn-fab pmd-ripple-effect btn-info pmd-btn-raised' data-placement='top' data-toggle='tooltip' title='Return Indent'><i class='material-icons pmd-sm' aria-hidden='true'></i>RET</button>");
					sbBody.append("<button type='button' id='bId4"+index+"' onclick='getViewCNT(\""+index+"\");' class='btn pmd-btn-fab pmd-ripple-effect btn-info pmd-btn-raised' data-placement='top' data-toggle='tooltip' title='View Indent'><i class='material-icons pmd-sm' aria-hidden='true'></i>VIEW</button>");
					sbBody.append("</td>");
					
				
					sbBody.append("</tr>"); 

					index++;
					
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
			sbBody.append("<td style='align:center;'>  </td>");
			sbBody.append("<td style='align:center;'>  No Data </td>");
			sbBody.append("<td style='align:center;'>  Found </td>");
			sbBody.append("<td style='align:center;'>  </td>");
			sbBody.append("<td style='align:center;'>  </td>");
			sbBody.append("</tr>");
			sbBody.append("</tbody>");
			sbBody.append("</table>");
			
			
		}
		//sbHeader.append("</tbody>");
		
		//return sbHeader.toString() + sbBody.toString();
		return sbBody.toString();
	}
	
	/**
	 * This function is used to invoke Bo's update method to update data
	 * 
	 * @param request
	 * @param formBean
	 */
	public static boolean CancelRecord(HttpServletRequest request, IndentTransFB formBean) {
		IndentTransBO bo = null;
		IndentTransVO vo = null;
		boolean retValue = true;
		//String tempChk[] = null;
		String strChk = "";
		
		try {
			            bo = new IndentTransBO();
			            vo = new IndentTransVO();			
			        strChk = formBean.getStrChk();						
			String[] temp  = strChk.split("\\^");
			String[] temp1 = temp[0].split("\\@");

//			//System.out.println("Req No-->>"+temp1[0]);
//			//System.out.println("Store Id-->>"+temp1[1]);
//			//System.out.println("Req Type Id-->>"+temp1[2]);
//			//System.out.println("Catg No-->>"+temp1[3]);
//			//System.out.println("Urgent Falg-->>"+temp1[4]);
//		    //System.out.println("Indent Period-->>"+strIndentPeriod);
//			//System.out.println("Reson-->>>"+temp[1]);
			formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());			
			vo.setStrItemCatgNo(temp1[3]);
			vo.setStrReqNo(temp1[0]);
			vo.setStrStoreId(temp1[1]);
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrRequestTypeId(temp1[2]);
			vo.setStrHospCode(formBean.getStrHospCode());
			vo.setStrCancelReson(temp[1]);
			// Calling BO Method
			bo.CANCEL(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}
			else
			{
				formBean.setStrMsg("Record is successfully updated");

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			retValue = false;
			String strmsgText = "Item Master.IndentTransDATA.update(vo) --> "
				+ e.getMessage();
			HisException eObj = new HisException("MMS","IndentTransDATA->update()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

}
