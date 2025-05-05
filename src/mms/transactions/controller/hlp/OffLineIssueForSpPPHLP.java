package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.bo.IssueDeskTransBO;
import mms.transactions.bo.OffLineIssueForSpPPBO;
import mms.transactions.controller.fb.OffLineIssueForSpPPFB;
import mms.transactions.vo.IssueDeskTransVO;
import mms.transactions.vo.OffLineIssueForSpPPVO;

public class OffLineIssueForSpPPHLP {
	static int i = 0;
	/**
	 * This method is used to show issued item Details on VIEW PAGE2
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getIssuedDetail(WebRowSet wb)throws SQLException 
	{
		StringBuffer br = new StringBuffer();

	    String strIssueDate = "";
		String strIssueNo = "";
		String strIndentingStore = "";
		String strIndentNo = "";
		String strIndentDate = "";

		int i = 0;

		try 
		{
			br.append("<table class='table table-striped'>");
			br.append("<tr>");
			br.append("<td class='' colspan='2'>");
			br.append("<div id='' style='font-family: Arial, Helvetica, sans-serif;font-size:26px;'>&nbsp;Issue Details</div>");
			br.append("</td></tr></table>");
			
			br.append("<table class='table table-striped'>");
			br.append("<thead class='thead-dark' align='center' >" );	
			br.append("<tr>");
			br.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Issue Date</td>");
			br.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Issue No</td>");
			br.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Indenting Store</td>");
			br.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Indent No</td>");
			br.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Indent Date</td>");
			br.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>#</td>");
			br.append("</tr>");
			br.append("</thead> ");	

			
			if (wb.size() != 0) 
			{
			
				while (wb.next()) 
				{
					strIssueDate      = wb.getString(2);
					strIssueNo        = wb.getString(1);
					strIndentingStore = wb.getString(3);
					strIndentNo       = wb.getString(4);
					strIndentDate     = wb.getString(5);
					
					br.append("<input type='hidden' name='strHlpIssueNo' id='strHlpIssueNo" +i+ "' value=" + strIssueNo + " />");
					br.append("<input type='hidden' name='strHlpIndentNo' id='strHlpIndentNo" +i+ "' value=" + strIndentNo + " />");
					br.append("<input type='hidden' name='strHlpIndentDate' id='strHlpIndentDate" +i+ "' value=" + strIndentDate + " />");
					
					br.append("<tr>");	
					br.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;' >"  + strIssueDate + "</td>");
					br.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>");
					br.append("<input type='hidden' name='flag' id='flag" +i+ "' value=" + "0" + " />");
					br.append("<div class='popup' id='IssueItempopup' style='display: none'></div>");
					
					br.append("<a style='cursor:pointer;color:blue;font-family: Engravers MT, Helvetica,sans-serif;font-size:13px;' title='Issue No Item Details' onClick='showPopUp(this,\""+ i + "\");'>" + strIssueNo + "</a></td>");
					br.append("</td>");
					br.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strIndentingStore + "</td>");
					br.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>"	+ strIndentNo + "</td>");
					br.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strIndentDate + "</td>");
					br.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;' ><img src='../../hisglobal/images/search_icon1.gif' onclick='generateIssueReportFunc(this,\""+ i + "\");' style='cursor: pointer;' title='Print Issue Item Details'></td>");

					br.append("</tr>");
					i++;
				}

				br.append("</table> ");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td colspan='5' style='font-weight:350 !important ;font-size: 16px !important;'><div id='id' align='center' style='color:red;'>No Record found</div></td>");
				br.append("</tr>");
				br.append("</table> ");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();
	}


	
	public static String getIssuedDetailNEW(WebRowSet wb)throws SQLException 
	{
		StringBuffer br = new StringBuffer();

	    String strIssueDate = "";
		String strIssueNo = "";
		String strIndentingStore = "";
		String strIndentNo = "";
		String strIndentDate = "";

		int i = 0;

		try 
		{
			br.append("<div class='row mx-1'>");
			br.append("<div class='legendHeader'><i class='fas fa-file-alt' style='font-size: 26px;'></i>&nbsp; Issue Details</div>");

//			br.append("<table class='table table-striped'>"); 
//			br.append("<tr>");
//			br.append("<td colspan='2'>");
//			br.append("</td></tr></table>");
			br.append("</div>");
			
			br.append("<div class='row'>");
			br.append("<div class='col-sm-12'>");
			br.append("<table class='table table-striped'>");
			br.append("<thead class='thead-dark' align='center'>" );	

			br.append("<tr>");
			br.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Issue Date</td>");
			br.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Issue No</td>");
			br.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Indenting Store</td>");
			br.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Indent No</td>");
			br.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Indent Date</td>");
			br.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>#</td>");
			br.append("</tr>");
			br.append("<thead>");
			if (wb.size() != 0) 
			{
			
				while (wb.next()) 
				{
					strIssueDate      = wb.getString(2);
					strIssueNo        = wb.getString(1);
					strIndentingStore = wb.getString(3);
					strIndentNo       = wb.getString(4);
					strIndentDate     = wb.getString(5);
					
					br.append("<input type='hidden' name='strHlpIssueNo' id='strHlpIssueNo" +i+ "' value=" + strIssueNo + " />");
					br.append("<input type='hidden' name='strHlpIndentNo' id='strHlpIndentNo" +i+ "' value=" + strIndentNo + " />");
					br.append("<input type='hidden' name='strHlpIndentDate' id='strHlpIndentDate" +i+ "' value=" + strIndentDate + " />");
					
					br.append("<tr>");	
					br.append("<td scope='col' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"  + strIssueDate + "</td>");
					br.append("<td align='center' CLASS='' >");
					br.append("<input type='hidden' name='flag' id='flag" +i+ "' value=" + "0" + " />");
					br.append("<div class='popup' id='IssueItempopup' style='display: none'></div>");
					
					br.append("<a style='align:center; cursor:pointer;font-weight:350 !important ;font-size: 16px !important;' title='Issue No Item Details' onClick='showPopUp(this,\""+ i + "\");'>" + strIssueNo + "</a></td>");
					br.append("</td>");
					br.append("<td scope='col' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"	+ strIndentingStore + "</td>");
					br.append("<td scope='col' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"	+ strIndentNo + "</td>");
					br.append("<td scope='col' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"	+ strIndentDate + "</td>");
					br.append("<td scope='col' align='center' style='font-weight:350 !important ;font-size: 16px !important;'><img src='../../hisglobal/images/search_icon1.gif' onclick='generateIssueReportFunc(this,\""+ i + "\");' style='cursor: pointer;' title='Print Issue Item Details'></td>");

					br.append("</tr>");
					i++;
				}

				br.append("</table> ");
				br.append("</div>");
				br.append("</div>");
			} else {
				br.append("<div class='row'>");
				br.append("<div class='col-sm-12'>");
				br.append("<table class='table' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td colspan='5' style='font-weight:350 !important ;font-size: 16px !important;'><div id='id' align='center' style='color:red;'>No Record found</div></td>");
				br.append("</tr>");
				br.append("</table> ");
				br.append("</div>");
				
				br.append("</div>");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();
	}

	
	public static String getPendingDemands(WebRowSet ws) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 5;
		final int PAGE_PER_BLOCK = 5;
		String strUrgentFlg,strLastIssueDate;
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		try
	    {
	    	/* Value Pass in Web Row Set
	    	   1. C.HSTNUM_REQ_NO 
	    	   2. C.HSTNUM_STORE_ID , 
               3. C.GNUM_HOSPITAL_CODE,
               4. count_urgent 
               5. c.URGENT_FLG 
               6. C.HSTNUM_REQ_NO 
               7. C.REQ_DATE 
               8. C.RAISING_STORE 
               9. C.CATEGORY 
               10.C.LST_ISSUE_DATE  
	    	 */    	
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		 	br.append("<tr><td colspan='1' width='5%' class='TITLE'>");
			br.append("<div id='plusPrevTechEntryDtlId' align='center' style='display:block;'>");
			br.append("<img src='../../hisglobal/images/plus.gif' style='cursor: pointer; '"); 
			br.append("onClick=view1('plusPrevTechEntryDtlId','minusPrevTechEntryDtlId','prevTechEntryDtlId');>");
			br.append("</div>");
			br.append("<div id='minusPrevTechEntryDtlId' style='display:none;' align='center'>");
			br.append("<img src='../../hisglobal/images/minus.gif' style='cursor: pointer; '"); 
			br.append("onClick=view2('plusPrevTechEntryDtlId','minusPrevTechEntryDtlId','prevTechEntryDtlId');>");
			br.append("</div></td><td colspan='3' width='95%' class='TITLE'>Pending Demand Details</td></tr></table>");	
			
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
			 int actualFetchRecord = ws.size();
		
	         if(totalFetchRecord != actualFetchRecord)
			 {
				totalFetchRecord = actualFetchRecord;
				totalRecordsToManipulate = actualFetchRecord;
			 }
			 int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
			 int reminder = totalRecordsToManipulate % REC_PER_PAGE;
			 if (reminder > 0)
				totalLayer = totalLayer + 1;
			 
			    br.append("<input type='hidden' name='TotalLayer'  value='"+totalLayer+"'>");
			    br.append("<input type='hidden' name='RecordShowOnPage'  value='"+REC_PER_PAGE+"'>");
			    br.append("<div id='prevTechEntryDtlId' style='display:none;'>");
			 br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
			 br.append("<tr>");
			 br.append("<td class='LABEL'>");
			 		 
			 
			 for (int i = 1; i <= totalLayer; i++)
			 {
				br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			br.append("</td></tr>");
			br.append("</table>");			
			
				
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				//br.append("<tr class='TITLE'>");
				//br.append("<td colspan='4'></td></tr>");
				br.append("<tr>");
				
				br.append("<td CLASS='multiLabel' colspan='1' width='5%'></td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Indenting Store</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Indent Date</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Indent No.</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Indent Status</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Last Issue Date</td>");
				br.append("</tr>");
				br.append("</table>");
		    for (int i = 1; i <= totalLayer; i++) 
		    {
			 if (i <= totalLayer) 
			 {
				 
				if (i == 1) 
				{
					br.append("<div id='DivId" +i+ "' style='display:block'>");
				} 
				else
				{
					br.append("<div id='DivId" +i+ "' style='display:none'>");
				}
				
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next())
					{
						
						/* Value Pass in Web Row Set
				    	   1. C.HSTNUM_REQ_NO 
				    	   2. C.HSTNUM_STORE_ID , 
			               3. C.GNUM_HOSPITAL_CODE,
			               4. count_urgent 
			               5. c.URGENT_FLG 
			               6. C.HSTNUM_REQ_NO 
			               7. C.REQ_DATE 
			               8. C.RAISING_STORE 
			               9. C.CATEGORY 
			               10.C.LST_ISSUE_DATE  
				    	 */ 
						
						if(ws.getString(5)==null ||ws.getString(5).equals(""))
						{
							strUrgentFlg = "---";
						}
						else
						{
							strUrgentFlg = ws.getString(5);
						}
						if(ws.getString(10)==null||ws.getString(10).equals(""))
						{
							strLastIssueDate = "---";
						}
						else
						{
							strLastIssueDate =ws.getString(10);
						}
						String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(3)+"^"+strUrgentFlg+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+strLastIssueDate;	
						//System.out.println("strCheckHidValue:::::"+strCheckHidValue);
						br.append("<tr>");
						br.append("<input type='hidden' name='demandFlg'  value='1'>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
						br.append("<td class='multiControl' colspan='1' width='5%'>");
						br.append("<input type='checkbox' name='checkid' id='checkid"+count+"' value='0' onClick='chkBoxClick(this,\""+count+"\");'> </td>");
						
						
						br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(8)+"</td>");
						br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(7)+"</td>");
						br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(1)+"</td>");
						br.append("<td class='multiControl' colspan='1' width='20%'>"+strUrgentFlg+"</td>");
						br.append("<td class='multiControl' colspan='1' width='15%'>"+strLastIssueDate+"</td>");
						
						br.append("</tr>");
						count++ ;
					}else{
						break;
					}
				}
					br.append("</table>");
					br.append("</div>");

			} 
			else 
			{
				br.append("<div id='DivId" + i+ "' style='display:none'>");
				
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
					
					/* Value Pass in Web Row Set
			    	   1. C.HSTNUM_REQ_NO 
			    	   2. C.HSTNUM_STORE_ID , 
		               3. C.GNUM_HOSPITAL_CODE,
		               4. count_urgent 
		               5. c.URGENT_FLG 
		               6. C.HSTNUM_REQ_NO 
		               7. C.REQ_DATE 
		               8. C.RAISING_STORE 
		               9. C.CATEGORY 
		               10.C.LST_ISSUE_DATE  
			    	 */ 
					
					if(ws.getString(5)==null ||ws.getString(5).equals(""))
					{
						strUrgentFlg = "---";
					}
					else
					{
						strUrgentFlg = ws.getString(5);
					}
					if(ws.getString(10)==null||ws.getString(10).equals(""))
					{
						strLastIssueDate = "---";
					}
					else
					{
						strLastIssueDate =ws.getString(10);
					}
					
					String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(3)+"^"+strUrgentFlg+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+strLastIssueDate;		

					
					br.append("<tr>");
					br.append("<input type='hidden' name='demandFlg'  value='1'>");
					br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
					br.append("<td class='multiControl' colspan='1' width='5%'>");
					br.append("<input type='checkbox' name='checkid' id='checkid"+count+"' value='0' onClick='chkBoxClick(this,\""+count+"\");'> </td>");
					
					
					br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(8)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(7)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(1)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='20%'>"+strUrgentFlg+"</td>");
					br.append("<td class='multiControl' colspan='1' width='15%'>"+strLastIssueDate+"</td>");
					
					br.append("</tr>");
					count++ ;
				}
				br.append("</table>");
				br.append("</div>");
				}
		   	}
			  br.append("</div>");
			}
			else
			{
				 
				 br.append("<div id='prevTechEntryDtlId' style='display:none;'>");
				 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				 br.append("<tr>");
				 br.append("<td CLASS='multiLabel' colspan='1' width='5%'></td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Indenting Store</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Indent Date</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Indent No.</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Indent Status</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Last Issue Date</td>");
				 
				 br.append("</tr>");
				 br.append("<input type='hidden' name='demandFlg'  value='0'>");
	           	 br.append("<tr>");  
	           	 br.append("<td class='multiControl' colspan='6'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	 br.append("</table>");
	           	 br.append("</div>");
					
			   }
			} 
	     }
		
	catch (Exception e) {	
		 
			throw new Exception("OffLineIssueForSpPPHLP.getPendingDemands()->"+e.getMessage());
		}
		return br.toString();
	}
	
	/**
	 * This method is used to show item Details on view PAGE
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getViewItemDetailsTwo(String strItemCategoryNo,String strHospitalCode, WebRowSet wb, String strStoreId,WebRowSet pendingDemandDtlWs,String strAvlBudget,String strBudgetFlag)throws SQLException 
	{
		StringBuffer br = new StringBuffer();
		String strRaisingStoreID="";

		try 
		{
			
			
			if(pendingDemandDtlWs.size()!= 0)
			{	
				while (pendingDemandDtlWs.next()) 
				{
					/*
					vo.setStrIndentNo(ws.getString(1));
					vo.setStrIndentDate(ws.getString(2));
					vo.setStrIndentType(ws.getString(3));
					vo.setStrItemCategory(ws.getString(4));
					vo.setStrRaisingStoreId(ws.getString(5));
					vo.setStrRaisingStoreName(ws.getString(6));
					vo.setStrItemCategoryNo(ws.getString(7));
					vo.setStrReqStatusName(ws.getString(8));
					Indent Period Value
					*/
					strRaisingStoreID = pendingDemandDtlWs.getString(5);
					br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px' border='0'>");
					br.append("<tr class='TITLE'>");
					br.append("<td colspan='4'>Existing Demand Issue Details</td></tr>");
					br.append("<tr>");
					br.append("<td width='25%' class='LABEL'>Indent Type</td>");
					br.append("<td width='25%' class='CONTROL'>Routine</td>");
					br.append("<td width='25%' class='LABEL'>Indent Status</td>");
					br.append("<td width='25%' class='CONTROL'>"+pendingDemandDtlWs.getString(8)+"</td>");
					br.append("</tr>");
					br.append("<tr>");
					br.append("<td width='25%' class='LABEL'>Indent Period</td>");
					br.append("<td width='25%' class='CONTROL'>"+pendingDemandDtlWs.getString(9)+"</td>");
					br.append("<td class='LABEL' width='25%'>Indent No.</td>");
					br.append("<td width='25%' class='CONTROL'>"+pendingDemandDtlWs.getString(1)+"</td>");
					br.append("<tr>");
					br.append("<td width='25%' class='LABEL'>Indent Date</td>");
				 	br.append("<td width='25%' class='CONTROL' >"+ pendingDemandDtlWs.getString(2) + "</td>");
				 	if(strBudgetFlag.equals("1"))
					{
					br.append("<td width='25%' class='LABEL'>Budget Avalaible</td>");
					br.append("<td width='25%' class='CONTROL' style='color:blue;'><a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='avlBudgetDtl(this);' TITLE='Click Here Get Budget Details' >"+strAvlBudget+"</a></td>");
					}
				 	else
				 	{
				 		br.append("<td width='25%' class='CONTROL'></td>");
						br.append("<td width='25%' class='CONTROL'></td>");

				 	}	
					br.append("</tr>");
					br.append("</table>");
				}
			}
			else
			{
				strRaisingStoreID = "0";
			}
			
			

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();
	}
	
	
		
	/**
	 * This method is used to show item Details on view PAGE
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getViewItemDetails(String strItemCategoryNo,String strHospitalCode, WebRowSet wb, String strStoreId,WebRowSet pendingDemandDtlWs,String strAvlBudget,String strBudgetFlag)throws SQLException 
	{
		StringBuffer br = new StringBuffer();
		OffLineIssueForSpPPBO bo = null;
		OffLineIssueForSpPPVO vo = null;
		HisUtil hisutil = null;

		String strUnitComboValues = "";

		String strHiddenId = ""; // item id^brand
		// id^strItemCategory^strStoreId
		//String strItemName = "";
		String strBrandName = "";
		String strAvlQty = "";
		String strBalQty = "";
		String strSancUnitId = "";
		String strUnitName = "";
		String strRaisingStoreID="";
		String strBatchNo="";

		String[] temp = null; 
		int i = 0;

		try 
		{
			hisutil = new HisUtil("mms", "IssueDeskTransHLP");
			bo = new OffLineIssueForSpPPBO();
			vo = new OffLineIssueForSpPPVO();

			
			if(pendingDemandDtlWs.size()!= 0)
			{	
				while (pendingDemandDtlWs.next()) 
				{
					/*
					vo.setStrIndentNo(ws.getString(1));
					vo.setStrIndentDate(ws.getString(2));
					vo.setStrIndentType(ws.getString(3));
					vo.setStrItemCategory(ws.getString(4));
					vo.setStrRaisingStoreId(ws.getString(5));
					vo.setStrRaisingStoreName(ws.getString(6));
					vo.setStrItemCategoryNo(ws.getString(7));
					vo.setStrReqStatusName(ws.getString(8));
					Indent Period Value
					*/
					strRaisingStoreID = pendingDemandDtlWs.getString(5);
					br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px' border='0'>");
					br.append("<tr>");
					br.append("<td width='25%' class='LABEL'>Indent Type</td>");
					br.append("<td width='25%' class='CONTROL'>Routine</td>");
					br.append("<td width='25%' class='LABEL'>Indent Status</td>");
					br.append("<td width='25%' class='CONTROL'>"+pendingDemandDtlWs.getString(8)+"</td>");
					br.append("</tr>");
					br.append("<tr>");
					br.append("<td width='25%' class='LABEL'>Indent Period</td>");
					br.append("<td width='25%' class='CONTROL'>"+pendingDemandDtlWs.getString(9)+"</td>");
					br.append("<td class='LABEL' width='25%'>Indent No.</td>");
					br.append("<td width='25%' class='CONTROL'>"+pendingDemandDtlWs.getString(1)+"</td>");
					br.append("<tr>");
					br.append("<td width='25%' class='LABEL'>Indent Date</td>");
				 	br.append("<td width='25%' class='CONTROL' >"+ pendingDemandDtlWs.getString(2) + "</td>");
				 	if(strBudgetFlag.equals("1"))
					{
					br.append("<td width='25%' class='LABEL'>Budget Avalaible</td>");
					br.append("<td width='25%' class='CONTROL' style='color:blue;'><a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='avlBudgetDtl(this);' TITLE='Click Here Get Budget Details' >"+strAvlBudget+"</a></td>");
					}
				 	else
				 	{
				 		br.append("<td width='25%' class='CONTROL'></td>");
						br.append("<td width='25%' class='CONTROL'></td>");

				 	}	
					br.append("</tr>");
					br.append("</table>");
				}
			}
			else
			{
				strRaisingStoreID = "0";
			}
			
			
			
			vo.setStrIndentingStoreID(strRaisingStoreID);
			vo.setStrHospitalCode(strHospitalCode);
			if (wb.size() != 0) 
			{
				 if(strBudgetFlag.equals("1"))
				 {	
						br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px' border='0'>");
						br.append("<tr>");
						br.append("<td class='multiLabel' width='28%'>Drug Name</td>");
						br.append("<td class='multiLabel' width='10%'>Avl. Qty.</td>");
						br.append("<td class='multiLabel' width='10%'>Balance Qty.</td>");
						br.append("<td class='multiLabel' width='12%'>Issue Qty</td>");
						br.append("<td class='multiLabel' width='10%'>Unit</td>");
						br.append("<td class='multiLabel' width='10%'>Batch</td>");
						br.append("<td class='multiLabel' width='12%'>Cost</td>");
						
						br.append("</tr>");
				 }
				 else
				 {
					    br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px' border='0'>");
						br.append("<tr>");
						br.append("<td class='multiLabel' width='32%'>Drug Name</td>");
						br.append("<td class='multiLabel' width='10%'>Avl. Qty.</td>");
						br.append("<td class='multiLabel' width='10%'>Balance Qty.</td>");
						br.append("<td class='multiLabel' width='14%'>Issue Qty</td>");
						br.append("<td class='multiLabel' width='12%'>Unit</td>");
						br.append("<td class='multiLabel' width='14%'>Batch</td>");						
						br.append("</tr>");
					 
				 }	 
				
				while (wb.next()) 
				{
					
				 if(strBudgetFlag.equals("1"))
				 {		
					
					strHiddenId = wb.getString(1); // item id^brand id
		//			strItemName = wb.getString(2);
					strBrandName = wb.getString(3);
					strAvlQty = wb.getString(4);
					//System.out.println("strAvlQty"+strAvlQty);
					temp = strAvlQty.replace("@", "#").split("#");
					temp = temp[0].replace("^", "#").split("#");
					strBalQty = wb.getString(5);
					strSancUnitId = wb.getString(6);
					strUnitName = wb.getString(7);
								
					
					
					
					br.append("<input type='hidden' name='strUnitName' id='strUnitName" + i+ "' value='"+strUnitName+"'>");
					br.append("<input type='hidden' name='strReqQty'   id='strReqQty" + i+ "' value='"+strBalQty+"'>");
					br.append("<input type='hidden' name='strAvlQty'   id='strAvlQty" + i+ "' value='"+temp[0]+"'>");
					br.append("<input type='hidden' name='strRate'     id='strRate" + i+ "' value='"+wb.getString(12)+"'>");
										
                    /*
                      1. Hidden value ::: HSTNUM_ITEM_ID||'^'||HSTNUM_ITEMBRAND_ID||'^'||
                                          HSTNUM_RESERVED_FLAG||'^'||  HSTNUM_GROUP_ID||'^'||
                                          HSTNUM_SUBGROUP_ID||'^'||HSTNUM_CONSUMABLE_FLAG
                      2. Item Name
                      3. Item Brand Name
                      4. Avl Qty.
                      5. Bal Qty.
                      6. Sanc Qty
                      7. Snac Qty Unit
                      8. Snc - Issue 
                      9. Req Qty / Sanc Qty
                     10. Re-Order Flag
                     11. Unit Id
                     12. Rate
                     13. Batch No
                     */
					
					
					vo.setStrSancUnitId(strSancUnitId);

					bo.getUnitCombo(vo);
					

					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}

					if (vo.getUnitComboWS() != null	&& vo.getUnitComboWS().size() > 0) 
					{
						strUnitComboValues = hisutil.getOptionValue(vo.getUnitComboWS(), wb.getString(11), "0^Select", true);
					} 
					else 
					{
						strUnitComboValues = "<option value='0'>Select</option>";
					}
					
					if(wb.getString(13).equals("-1"))
					{
						strBatchNo = "---";
					}
					else
					{
						strBatchNo = wb.getString(13);
					}

					/*
					 * br.append("<TR>"); br .append(" <input type='hidden'
					 * name='strItemDetailsChk' id='strItemDetailsChk" + i + "'
					 * onclick='ClickCheckBox(this,\"" + i + "\");' value= '" +
					 * strHiddenId + "^" + strItemCategoryNo + "^" + strStoreId + "' />
					 * "); br.append(" <input type='hidden' name='flag'
					 * id='flag"+i+"' value=" + "0" + " >");
					 */

					br.append("<TD WIDTH='28%' CLASS='multiControl'  style='color:blue;'>"+strBrandName+"</TD>");

					br.append("<TD WIDTH='10%' CLASS='multiControl' >"+ temp[0] + "</TD>");
					br.append("<TD WIDTH='10%' CLASS='multiControl' >"+ strBalQty + " " + strUnitName + "</TD>");
					br.append("<TD WIDTH='12%' CLASS='multiControl' ><input type='text' class='txtFldMin' name='strPendIssueQty' id='strPendIssueQty" + i+ "'  value=" + "0" + "  onkeyup='return issueQtyValidationTwo(\""+i+"\");' onkeypress='return validateData(event,7);' onblur='setDefaultValue(this);' ></TD>");
					br.append("<TD WIDTH='10%' CLASS='multiControl' >");
					br.append("<select name='strPendUnit' id='strPendUnit"+i+ "' class='comboMin'>"+strUnitComboValues+"</select>");
					br.append("<TD WIDTH='10%' CLASS='multiControl' >"+ strBatchNo + "</TD>");
					br.append("<TD WIDTH='12%' CLASS='multiControl' ><input type='text' disabled='disabled' class='txtFldMin' name='strPendQtyCost' id='strPendQtyCost" + i+ "'  value=" + "0.00" + "></TD>");
					
					br.append("</TR>");
					i++;
				  }
				  else
				  {
					  
						strHiddenId = wb.getString(1); // item id^brand id
						//			strItemName = wb.getString(2);
									strBrandName = wb.getString(3);
									strAvlQty = wb.getString(4);
									//System.out.println("strAvlQty"+strAvlQty);
									temp = strAvlQty.replace("@", "#").split("#");
									temp = temp[0].replace("^", "#").split("#");
									strBalQty     = wb.getString(5);
									strSancUnitId = wb.getString(6);
									strUnitName   = wb.getString(7);						
									
									
				                    /*
				                      1. Hidden value ::: HSTNUM_ITEM_ID||'^'||HSTNUM_ITEMBRAND_ID||'^'||
				                                          HSTNUM_RESERVED_FLAG||'^'||  HSTNUM_GROUP_ID||'^'||
				                                          HSTNUM_SUBGROUP_ID||'^'||HSTNUM_CONSUMABLE_FLAG
				                      2. Item Name
				                      3. Item Brand Name
				                      4. Avl Qty.
				                      5. Bal Qty.
				                      6. Sanc Qty
				                      7. Snac Qty Unit
				                      8. Snc - Issue 
				                      9. Req Qty / Sanc Qty
				                     10. Re-Order Flag
				                     11. Unit Id
				                     12. Rate
				                     13. Batch No
				                     */
									
									
									vo.setStrSancUnitId(strSancUnitId);

									bo.getUnitCombo(vo);
									

									if (vo.getStrMsgType().equals("1")) 
									{
										throw new Exception(vo.getStrMsgString());
									}

									if (vo.getUnitComboWS() != null	&& vo.getUnitComboWS().size() > 0) 
									{
										strUnitComboValues = hisutil.getOptionValue(vo.getUnitComboWS(), wb.getString(11), "0^Select", true);
									} 
									else 
									{
										strUnitComboValues = "<option value='0'>Select</option>";
									}
									
									if(wb.getString(13).equals("-1"))
									{
										strBatchNo = "---";
									}
									else
									{
										strBatchNo = wb.getString(13);
									}
								

									br.append("<TD WIDTH='32%' CLASS='multiControl'  style='color:blue;'>"+strBrandName+"</TD>");

									br.append("<TD WIDTH='10%' CLASS='multiControl' >"+ temp[0] + "</TD>");
									br.append("<TD WIDTH='10%' CLASS='multiControl' >"+ strBalQty + " " + strUnitName + "</TD>");
									br.append("<TD WIDTH='14%' CLASS='multiControl' ><input type='text' class='txtFldMin' name='strPendIssueQty' id='strPendIssueQty" + i+ "'  value=" + "0" + " ></TD>");
									br.append("<TD WIDTH='12%' CLASS='multiControl' >");
									br.append("<select name='strPendUnit' id='strPendUnit"+i+ "' class='comboMin'>"+strUnitComboValues+"</select>");
									br.append("<TD WIDTH='14%' CLASS='multiControl' >"+ strBatchNo + "</TD>");
									br.append("<input type='hidden' disabled='disabled' class='txtFldMin' name='strPendQtyCost' id='strPendQtyCost" + i+ "'  value=" + "0.00" + ">");
									
									br.append("</TR>");
									i++;
					  
				  } 
				}

				br.append("</table> ");
				if(strBudgetFlag.equals("1"))
				{
					br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
					br.append("<tr> ");
					br.append("<td width='90%' class='LABEL'>Total Cost(Rs):</td> ");
					br.append("<td width='13%' class='CONTROL' style='color: red; font-weight: bold'> ");
					br.append("<input type='text' name='strTotalPendCostDivId' class='txtFldNormal'  value='0.00'  disabled='disabled' id='strTotalPendCostDivId' >");
					br.append("<input type='hidden' name='strApproxPendAmt' value='0.00'></td> ");
					br.append("</tr> ");
					br.append("</table> ");
				}	
				
				
			} 
			else 
			{
				br
						.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<TR>");
				br.append("<TD  CLASS='multiControl' colspan='3'>"
						+ "No Record Found" + "</TD>");
				br.append("</TR>");
				br.append("</table> ");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();
	}
	
	
	
	/**
	 * This method is used to show item Details on ISSUE PAGE
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getExistingItemDetails(String strItemCategoryNo,
			String strHospitalCode, WebRowSet wb, String strRaisingStoreId,String strBudgetFlg)
			throws SQLException {
		StringBuffer br = new StringBuffer();

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;
		HisUtil hisutil = null;

		String strUnitComboValues = "";

		String strHiddenId = ""; // item id^brandid^RESERVED FLAG^GROUPID^SUBGROUP ID^CONSUMABLE FLAG
									// ^strItemCategory^strRaisingStoreId
	//	String strItemName = "";
		String strBrandName = "";
		String strAvlQty = "";
		String strAvlQtyWithUnitId = "";
		String strAvlQtyBaseVal = "";
		String strBalQty = "";
		String strSancUnitId = "";
		String strSancUnitName = "";
		String strBalQtyBaseVal = "";
		String strReqSancQty;
	//	String strRateBaseVal = "";
	//	String strRate = "";
	//	String strRateUnitId = "";
		String[] temp = null;
		String strReOrderFlg;
		String strApplyClass;
		String strCompSancUnit;

		int i = 0;

		try {
			hisutil = new HisUtil("mms", "IssueDeskTransHLP");
			bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();

			vo.setStrHospitalCode(strHospitalCode);
			if (wb.size() != 0) 
			{

				br.append("<table class='TABLEWIDTH' bgcolor='#086fa6' align='center'cellpadding='1px' cellspacing='1px'>");
				
				while (wb.next()) 
				{
					strHiddenId = wb.getString(1); // item id^brand id
			//		strItemName = wb.getString(2);
					strBrandName = wb.getString(3);
					strAvlQty = wb.getString(4);
					strBalQty = wb.getString(5);
					if (wb.getString(6) == null) 
					{
						strSancUnitId = "0";
					}
					else 
					{
						strSancUnitId = wb.getString(6);
					}
					strSancUnitName  = wb.getString(7);
					strBalQtyBaseVal = wb.getString(8);
					strReqSancQty    = wb.getString(9);
					
					strCompSancUnit  = wb.getString(11);  // Adding in Change Request 28-July-2011
									
					
					if (strBalQty.equals("0")) {
						strSancUnitName = " ";
					}
					
					
					/*
					 *  Change Color for Re-Order Level
					   System.out.println("Inside Issue Desk Trans HLP:::::"+wb.getString(10));
					   
					   if(wb.getString(10).equals("0")) 
				       {
				    	 strApplyClass = "Approved";				    	   
				       }
				       else
				       {
				    	 strApplyClass = "NotApproved";    				    	   
				       }
					*/

					//strBalQty = HisUtil.getAmountWithDecimal(strBalQty, 2); // By Amit Kr Date 23-Feb-2011
					//System.out.println("strHiddenId-" + strHiddenId);
					//System.out.println("strItemName-" + strItemName);
					//System.out.println("strBrandName-" + strBrandName);
					//System.out.println("strAvlQty-" + strAvlQty);
					//System.out.println("strBalQty-" + strBalQty);
					//System.out.println("strSancUnitId-" + strSancUnitId);
					//System.out.println("strSancUnitName-" + strSancUnitName);
					//System.out.println("strBalQtyBaseVal-" + strBalQtyBaseVal);
					//System.out.println("strItemCategory-" + strItemCategoryNo);
					//System.out.println("strRate-" + strRate);
					//System.out.println("strRateUnitId-" + strRateUnitId);
					temp = strAvlQty.replace("^", "#").split("#");

					strAvlQty = temp[0];
					strAvlQtyWithUnitId = temp[1];
					strAvlQtyBaseVal = temp[2];
					vo.setStrSancUnitId(strSancUnitId);
					// Calling BO Method
					bo.getUnitCombo(vo);
                     
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}

					if (vo.getUnitComboWS() != null	&& vo.getUnitComboWS().size() > 0) 
					{
					
						strUnitComboValues = hisutil.getOptionValue(vo
								.getUnitComboWS(), strCompSancUnit, "0^Select", true);
						vo.getUnitComboWS().beforeFirst(); // needed bcoz
															// sometimes it
															// gives invalid
															// cursor position
															// when there is
															// value in heap due
															// to loop
						
					} 
					else 
					{

						strUnitComboValues = "<option value='0'>Select Value</option>";
					}
					
					if(strBudgetFlg.equals("0"))
					{	
							br.append("<TR>");
							
							
		                    
							
							br.append("<TD WIDTH='32%' id='td1" + i + "' CLASS='multiControl'  >");
							br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk"
											+ i
											+ "' value= '"
											+ strHiddenId
											+ "^"
											+ strItemCategoryNo
											+ "^"
											+ strRaisingStoreId + "' /> ");
							br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
							
							br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value=" + wb.getString(10) + " />");
		
							
							br.append("<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
											+ i + "\");'>" + strBrandName + "</a></TD>");
							
							br.append("<TD WIDTH='10%' id='td2" + i + "' CLASS='multiControl'  >"
											+ strAvlQty
											+ "<input type='hidden' name='strAvlQty' id='strAvlQty"
											+ i
											+ "' value='"
											+ strAvlQtyWithUnitId
											+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal"
											+ i + "' value='" + strAvlQtyBaseVal
											+ "' /></TD>");
							
							br.append("<input type='hidden' name='strBalQty' id='strBalQty"
											+ i
											+ "' value='"
											+ strBalQty
											+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId"
											+ i
											+ "' value='"
											+ strSancUnitId
											+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal"
											+ i + "' value='" + strBalQtyBaseVal
											+ "' />");
		                    
							br.append("<TD WIDTH='14%' id='td3" + i + "' CLASS='multiControl'  >"+strReqSancQty+"</TD>");
							
		                    
							
							br.append("<TD WIDTH='10%' id='td4" + i + "' CLASS='multiControl' ><input type='text' maxlength='8' onkeypress='return QtyValidation("
											+ i
											+ ");' onkeyup='return QtyValidation("
											+ i
											+ ");' name='strIssueQty' id='strIssueQty"
											+ i
											+ "' class='txtFldMin' value='' > </TD>");
		                   
							br.append("<TD WIDTH='10%' id='td5" + i + "' CLASS='multiControl'  ><Select name='strIssueUnitId' onChange='return QtyValidation("
											+ i
											+ ");' id='strIssueUnitId"
											+ i
											+ "' >"
											+ strUnitComboValues + "</select></TD>");
		                    					
							
		                   
							br.append("<TD WIDTH='4%' id='td6" + i + "' CLASS='multiControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
											+ i
											+ "' value='' /> <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
											+ i + "\");' TITLE='Click Here For Item Preferences' >#</TD>");
							
							
							br.append("</TR>");
							br.append("</div>");
							i++;
				    }
					else
					{
						br.append("<TR>");
						
						               
						
						br.append("<TD WIDTH='27%' id='td1" + i + "' CLASS='multiControl'  >");
						br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk"
										+ i
										+ "' value= '"
										+ strHiddenId
										+ "^"
										+ strItemCategoryNo
										+ "^"
										+ strRaisingStoreId + "' /> ");
						br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
						
						br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value=" + wb.getString(10) + " />");
	
						
						br.append("<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
										+ i + "\");'>" + strBrandName + "</a></TD>");
						
						br.append("<TD WIDTH='7%' id='td2" + i + "' CLASS='multiControl'  >"
										+ strAvlQty
										+ "<input type='hidden' name='strAvlQty' id='strAvlQty"
										+ i
										+ "' value='"
										+ strAvlQtyWithUnitId
										+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal"
										+ i + "' value='" + strAvlQtyBaseVal
										+ "' /></TD>");
						
						br.append("<input type='hidden' name='strBalQty' id='strBalQty"
										+ i
										+ "' value='"
										+ strBalQty
										+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId"
										+ i
										+ "' value='"
										+ strSancUnitId
										+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal"
										+ i + "' value='" + strBalQtyBaseVal
										+ "' />");
	                    
						br.append("<TD WIDTH='12%' id='td3" + i + "' CLASS='multiControl'  >"+strReqSancQty+"</TD>");
						
	                    
						
						br.append("<TD WIDTH='10%' id='td4" + i + "' CLASS='multiControl' ><input type='text' maxlength='8' onkeypress='return QtyValidation("
										+ i
										+ ");' onkeyup='return QtyValidation("
										+ i
										+ ");' name='strIssueQty' id='strIssueQty"
										+ i
										+ "' class='txtFldMin' value='' > </TD>");
	                   
						br.append("<TD WIDTH='10%' id='td5" + i + "' CLASS='multiControl'  ><Select name='strIssueUnitId' onChange='return QtyValidation("
										+ i
										+ ");' id='strIssueUnitId"
										+ i
										+ "' >"
										+ strUnitComboValues + "</select></TD>");
						               					
						
	                   
						br.append("<TD WIDTH='10%' id='td7" + i + "' CLASS='multiControl'><input type='text' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"+i+"' ></TD>");
						br.append("<input type='hidden' name='strFinalCost' id='strFinalCost"	+ i	+ "' value='0.00' />");
						
						br.append("<TD WIDTH='4%' id='td8" + i + "' CLASS='multiControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
										+ i
										+ "' value='' /> <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
										+ i + "\");' TITLE='Click Here For Item Preferences' >#</TD>");
						
						
						br.append("</TR>");
						br.append("</div>");
						i++;
					}	
					
				}

				br.append("</table> ");
				if(strBudgetFlg.equals("1"))
				{
					br.append("<table class='TABLEWIDTH' align='center' cellpadding='1' cellspacing='1'>");
					br.append("<tr>");
					br.append("<td width='85%' class='LABEL'>Total Approx Cost(Rs):</td>");
					br.append("<td width='15%' class='CONTROL' style='color: red; font-weight: bold' align='center'>");
					br.append("<input type='text' style='color: red; font-weight: bold'  disabled='disabled' class='txtFldNormal'  value='0.00' name='strApproxAmtDiv' id='strApproxAmtDiv' >");
					br.append("<input type='hidden' name='strFinalApproxAmtDiv'></td><td width='4%' class='CONTROL'></td>");
					br.append("</tr>");
					br.append("</table>");	
				}
				
				
				
			} 
			else 
			{
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<TR>");
				br.append("<TD  CLASS='multiControl' colspan='8'>"
						+ "No Record Found" + "</TD>");
				br.append("</TR>");
				br.append("</table> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}
        //System.out.println("O/P String:::::"+br.toString());
		return br.toString();
	}

	
	
	/**
	 * This method is used to show a PopUp (ON CLICK OF AN ITEM NAME)
	 * 
	 * @param wb
	 * @param index
	 * @return
	 */
	public static String getPopUpInfo(WebRowSet wb, String index,String issueNo) 
	{
		StringBuffer br = null;
		String strItemName = "";
		String strBatchNo = "";
		String strReqQty = "";
		String strIssueQty = "";

		try 
		{
			br  = new StringBuffer();
			

			br.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px'>");
			br.append("<tr class='HEADER' align='left'><td style='cursor:pointer;cursor:pointer;font-family: Arial, Helvetica, sans-serif;font-size:13px;'>Issue No.&nbsp;"+issueNo+"&nbsp;::::&nbsp;Item Details</td> ");
			br.append("<td align='right'><img style='cursor: pointer; '  src='../../hisglobal/images/popUp_cancel.JPG' title='To Close PopUp Window' align='middle' onclick='hide_popup_menu(\"IssueItempopup\");'> </td></tr>");
			br.append("</tr>");
			br.append("</table> ");
			
			br.append("<table width='400' align='center' bgcolor='black'  border='0'  cellspacing ='1px'>");
			br.append("<tr>");
			br.append("<td class='multiRPTLabel' WIDTH='46%' >Drug Name</td>");
			br.append("<td class='multiRPTLabel' WIDTH='30%' >Batch No.</td>");
			br.append("<td class='multiRPTLabel' WIDTH='12%' >Req Qty.</td>");
			br.append("<td class='multiRPTLabel' WIDTH='12%' >Issued Qty.</td>");
			br.append("</tr>");
			br.append("</table> ");
			br.append("<table width='400' align='center' bgcolor='#086fa6'  border='0'  cellspacing ='1px'>");
			
			if (wb != null && wb.size() != 0) 
			{
				while (wb.next())

				{
					strItemName = wb.getString(7);
					strBatchNo  = wb.getString(8);
					strReqQty   = wb.getString(11);
					strIssueQty = wb.getString(9);

					if (strItemName == null || strItemName.equals("null"))
						strItemName = "-----";
					if (strBatchNo == null || strBatchNo.equals("null"))
						strBatchNo = "----";
					if (strReqQty == null|| strReqQty.equals("null"))
						strReqQty = "----";
					if (strIssueQty == null || strIssueQty.equals("null"))
						strIssueQty = "----";
					
					br.append("<tr>");
					br.append("<td WIDTH='46%' CLASS='multiPOControl' >"+ strItemName + "</td>");
					br.append("<td WIDTH='30%' CLASS='multiPOControl' >"+ strBatchNo  + "</td>");
					br.append("<td WIDTH='12%' CLASS='multiPOControl' >"+ strReqQty   + "</td>");
					br.append("<td WIDTH='12%' CLASS='multiPOControl' >"+ strIssueQty + "</td>");
					br.append("</tr>");
					i++;
				}
				
				br.append("</table>");
				br.append("<table width='400' align='center'  border='0'  cellspacing ='1px'>");
				br.append("<tr class='FOOTER'><td colspan='6'></td></tr>");
				br.append("</table>");
				
			} 
			else
			{
				br.append("<tr>");
				br.append("<td colspan='6'  CLASS='multiControl' ><DIV class='errMsg' align='center'> NO RECORD FOUND</div></td>");
				br.append("</tr>");
				br.append("</table> ");				
			}	
			
			br.append("@");
			br.append(index);

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "ERROR";

		}
		
		return br.toString();

	}
	
	
	public static String getIssueDtlsInitViewNEW(OffLineIssueForSpPPFB formBean) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		String strIssueBy = "";
		String strRecivedBy = "";
		String strPurchaseCost="";
		String strRemarks="";
		double cltamt  = 0.00;
		double totalCost = 0.00;		
		double cltamt1  = 0.00;
		double totalCostWithoutSC = 0.00;		
		String strStoreName="";
		 String returnTo="";
		int i=1;
		String strItemTotCost="0.00";
		String strItemTotCostWithOutSC ="0.00";
		String strBudgetUsed ="0.00";
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());	
		
		String configIssueRate = mmscofigutil.getStrConfigIssueRate();
		DecimalFormat myFormatter = new DecimalFormat("0.00");

		WebRowSet ws = formBean.getWsIssueDetails();
        
		String strIssueDate = "";

		if (formBean.getStrIssueDate().length() > 2) 
		{
			strIssueDate = formBean.getStrIssueDate();
		}
		
		String strTableWidth = "825";

		try 
		{
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
			
    		sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");

			sb.append(hospitalVO.getHospitalName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");

			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");

			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

			
			
			sb.append("<TABLE class='table table-striped' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
			.append(strTableWidth)
			.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Report For&nbsp;Special Issue Details</b></font></td></tr></table> ");
			
				
			
			if (formBean.getStrStoreName().length() != 0) 
			{
				if(!formBean.getStrModeVal().equals("4"))
				{
				sb.append(
								"<TABLE class='table' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth).append(
								"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>(").append(
								formBean.getStrStoreName()).append(
								")</b></font></td></tr></table>");
				}
				else
				{
					sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
				.append(strTableWidth).append(
						"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Acknowledging Store : ").append(
						formBean.getStrStoreName()).append(
						"</b></font></td></tr></table>");
				}

			}						
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup(),cancelToDesk();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");

			
			if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
			{	

				sb.append("<tr> ");
	
				sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue No. :", 15,0)).append(formBean.getStrIssueNo())
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue Date", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strIssueDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
							
				if (!formBean.getStrIndentNo().equals("0")) 
				{
					sb.append("<tr> ");
					sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Request No. :", 15,0)).append(formBean.getStrIndentNo())
							.append("</b></font></td> ");

					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Request Date", 15,0)).append(	":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIndentDate()).append("</b></font></td> ");
					sb.append("</tr> ");
	
				}
				
				
				sb.append("<tr> ");
				sb.append("<td width='50%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue To. :", 15,0)).append(formBean.getStrIssueTo().split("@")[0])
						.append("</b></font></td> ");

				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("", 15,0)).append(	"</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td> ");
				sb.append("</tr> ");
				
				
				sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");
									
				
			}				
			
			sb.append("</table> ");

			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
			sb.append("</td>");

			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch/Serial No.</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
			sb.append("</td> ");			  

			sb.append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
			sb.append("</td> ");
				
			
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					/*
					  Total 33 Value Return In Case of ModeVal 8 (Which Call in Case of Off-Line Issue Voucher)
					  1.Issue No
					  2.Issue Date
					  3.Issue To 
					  4.Issue By
					  5.Generic Name
					  6.Brand Name
					  7.Batch No
					  8.Expiry date
					  9.Issue rate
					  10.Issue Qty
					  11.Store Id
					  12.Item Id
					  13.Item Brand ID
					  14.Batch No
					  15.Expiry Date
					  16.Issue Rate
					  17.Issue Rate Unit Id
					  18.Issue Rate Base Unit Id
					  19.Issue Qty
					  20.Issue Qty Unit Id
					  21.Issue Qty Base Value
					  22.Item Sl No
					  23.Item SL No
					  24,Category Code
					  25.Issue Qty
					  26.Remarks
					  27.Final remarks
					  28.Received By
					  29.Cost
					  30.Total Avl Budget
					  31.Indent No
					  32.Indent Date
					  33.Purchase Rate With Unit e.g 101 No. 
					  34.Purchae Code
					  35.Location 
					  36.Balance Qty
					  37.hstnum_saleprice
					  38.hstnum_TAX
					 */		
					
					NumberFormat formatter = new DecimalFormat("############.##");  	

																		
					strStoreName    		= ws.getString(4);	
					strRemarks              = ws.getString(27);
					strRecivedBy    		= ws.getString(28);
					strItemTotCost          = ws.getString(29);
					
					strPurchaseCost         = ws.getString(33);  // With Unit Like e.g. 161 No.
										    
					strItemTotCost          = formatter.format(new BigDecimal(ws.getString(29)));  
					strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(34)));
						
												
					
					
					cltamt1  = Double.parseDouble(strItemTotCostWithOutSC);
					
					totalCostWithoutSC = totalCostWithoutSC + cltamt1;   //Calculate Total Cost Without Service Charge
					 
					cltamt  = Double.parseDouble(strItemTotCost);    
										
					totalCost = totalCost + cltamt;                      //Calculate Total Cost With Service Charge
											
					sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					
					sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
					sb.append(ws.getString(6));
					sb.append("</b></font></td> ");

					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));//debug
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:center;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(9));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:center;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(38));
					sb.append("</font></td> ");
					
					
					sb.append("<td style=\"text-align:center;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(10));
					sb.append("</font></td> ");
					
					if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5") )
					{

						
						sb.append("<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(new BigDecimal(strItemTotCost)));
						//myFormatter.format(Double.parseDouble(ws.getString(6)))
						sb.append("</font></td> ");  
					}
					if(formBean.getStrModeVal().equals("5"))
					{
						
						sb.append("<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(new Float(ws.getString(10).split(" ")[0])*new Float(ws.getString(9).split("/")[0])));
						//myFormatter.format(Double.parseDouble(ws.getString(6)))
						sb.append("</font></td> ");  
					}
					sb.append("</tr> ");
					i++;
								
				}
								
				if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
				{	
					NumberFormat formatter = new DecimalFormat("############.##");  
				    					
					String ServiceCharge ="";
					
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					
					sb.append("<tr>");
					sb.append("<td colspan='7' align='left'><hr size='2'></td>");
					sb.append("<td colspan='1' align='center'><hr size='2'></td>");
					
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='7' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><div align='right'><b>TOTAL Rs.(Round)</b></div></font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					//sb.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));	
					sb.append(Math.round(Double.parseDouble(FinaltotalCost)));
					sb.append("</font></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='7' align='left'><hr size='2'></td>");
					sb.append("<td colspan='1' align='center'><hr size='2'></td>");
					
					sb.append("</tr>");
					
					
					if(formBean.getStrModeVal().equals("2"))  // To Show Issue Off-Line Voucher
					{
						
							
						String FinaltotalCostWithoutSc = formatter.format(new BigDecimal(totalCostWithoutSC)); 
						if(configIssueRate.equals("") || configIssueRate == null)
							configIssueRate = "0";
						double IssueRatePercentage  = Double.parseDouble(configIssueRate);						
						double PurchaseCost         = Double.parseDouble(strItemTotCost);					
						double serviceCharge        = totalCost - totalCostWithoutSC;
						
						ServiceCharge               = formatter.format(new BigDecimal(serviceCharge));
						
						
						double costWithServiceChag = totalCostWithoutSC + serviceCharge;
						
								
						
					}				 
					
				
				}
				

					if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
					{
						if(!formBean.getStrModeVal().equals("3"))
						{	
							
					        sb.append("<tr> "); 
							sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received By:</font></td>");
							sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");							
							sb.append(strRecivedBy.trim());									
							sb.append("</font></td>");
					        sb.append("</tr> ");   							
					        sb.append("<tr> "); 
							sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:<b></font></td>");
							sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");
							
						
							sb.append(strRemarks);	
							sb.append("</font></td>");
					        sb.append("</tr> ");      
					        sb.append("<tr> ");
					        if(formBean.getStrModeVal().equals("1"))
					        {
					        	sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>[ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;"+formBean.getStrUserName()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
					        	sb.append("</tr> ");      
							    sb.append("<tr> ");
					        	sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>* In case of not issued items , kindly contact billing desk for refund.<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
					        }
					        else{
					        	sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>Issued By : "+formBean.getStrIssueTo().split("@")[1]+"<b>&nbsp;&nbsp;</font></td> ");	
					        }
							
							sb.append("</tr> ");
							//sb.append("<tr> ");
							//sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By on Behalf of RMSCL<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
							//sb.append("</tr> ");
							
						}
						else
						{
							
								sb.append("<tr> "); 
								sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
								sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");								
								sb.append(strRemarks);										
								sb.append("<br></font></td>");
						        sb.append("</tr> ");								
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strRecivedBy).append(
												")<b> &nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
							
						}	
						
										
					}
					else
					{
						
						sb.append("<tr> ");
						sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Received By : "+formBean.getStrIssueTo().split("@")[1]+"<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("</tr> ");
						
					}	
				}

			
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available/Requested Qty not available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
		finally {
			mmscofigutil = null;
		}

		return sb.toString();
	}

	

}