package mms.reports.controller.hlp;

import hisglobal.utility.HisUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.HelpDeskRptVO;

public class HelpDeskRptHLP
{
	public static String getScreenTwo(WebRowSet ws) throws Exception 
	{
		
		////System.out.println("HLP Entered");
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 100;
		final int PAGE_PER_BLOCK = 100;
		
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		try
	    {/* Value Pass in Web Row Set
    	    1. DDW NAME
    	    2. Department Name , 
            3. Menu Name
            4. Problem Subject 
            5. Problem Description
            6. Status
            7. Issue Number
            8. Issue Entry Date
            9. Solution
            10. Solution Entry Date
            11. Remarks
            12. Problem Submitted By
            13. Solution Submitted By
            14. File Name 
    	 */ 
			
			
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Help Desk Details</td></tr></table>");	
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
			    br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
			 br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
			 br.append("<tr>");
			 br.append("<td class='LABEL'>");
			 //NumberFormat formatter = new DecimalFormat("############.##");  
			 
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
				
				br.append("<td CLASS='multiLabel' colspan='1' width='5%'>Sl No.</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='15%'>DDW Name</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Department</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Menu Name</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Issue Subject</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Issue Raised Date</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Status</td>");/*Brahmam*/
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>File Download Link </td>");/*brahmam*/
				
				//br.append("<td CLASS='multiLabel' colspan='1' width='25%'>PO Value</td>");
				
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
			    	    1. DDW NAME
			    	    2. Department Name , 
			            3. Menu Name
			            4. Problem Subject 
			            5. Problem Description
			            6. Status
			            7. Issue Number
			            8. Issue Entry Date
			            9. Solution
			            10. Solution Entry Date
			            11. Remarks
			            12. Problem Submitted By
			            13. Solution Submitted By
			            14. File Name 
			            */  
						String DDWName = ws.getString(1);
						String DeptName = ws.getString(2);
						String MenuName = ws.getString(3);
						String ProbSubject = ws.getString(4);
						String ProbDesc = ws.getString(5);
						String Status = ws.getString(6);
						String IssueNo = ws.getString(7);
						String IssueDate = ws.getString(8);
						String Solution = ws.getString(9);
						String SolutionDate = ws.getString(10);
						String Remarks = ws.getString(11);
						String ProbSubmitBy = ws.getString(12);
						String SolSubmitBy = ws.getString(13);
						String FileName = ws.getString(14);
						String StatusFlg = ws.getString(15);
						
						
						if (DDWName == null)
							DDWName = "----";
						if (DeptName == null)
							DeptName = "----";
						if (MenuName == null)
							MenuName = "----";
						if (ProbSubject == null)
							ProbSubject = "----";
						if (ProbDesc == null)
							ProbDesc = "----";
						if (Status == null)
							Status = "----";
						if (IssueNo == null)
							IssueNo = "----";
						if (IssueDate == null)
							IssueDate = "----";
						if (Solution == null)
							Solution = "----";
						if (SolutionDate == null)
							SolutionDate = "----";
						if (Remarks == null)
							Remarks = "----";
						if (ProbSubmitBy == null)
							ProbSubmitBy = "----";
						if (SolSubmitBy == null)
							SolSubmitBy = "----";
						//if (FileName == null)
							//FileName = "----";
						String ProbDesc1 = ProbDesc.replace(System.getProperty("line.separator")," ");
						String Solution1 = Solution.replace(System.getProperty("line.separator")," ");
						String Remarks1 = Remarks.replace(System.getProperty("line.separator")," ");
						//String Remarks1=Remarks.replace(" ","@@$$");
						
						String strCheckHidValue = ws.getString(14);	/*Brahmam*/	
				        ////System.out.println("strCheckHidValue:  "+strCheckHidValue);
						br.append("<tr>");
						br.append("<input type='hidden' name='demandFlg'  value='1'>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+strCheckHidValue+"' value='"+strCheckHidValue+"'>");
						br.append("<td class='multiControl' colspan='1' width='5%'>");
						br.append(start);
						br.append("</td>");
						
						
				
						br.append("<td style=\"text-align:left;\" class='multiControl' colspan='1' width='15%'>"+DDWName+"</td>");
						br.append("<td style=\"text-align:left;\" class='multiControl' colspan='1' width='15%'>"+DeptName+"</td>");
						br.append("<td style=\"text-align:left;\" class='multiControl' colspan='1' width='15%'>"+MenuName+"</td>");
			
						br.append("<td style=\"text-align:left;\" class='multiControl' width='20%'><a style='color:blue;cursor: pointer' title='Click to View the Issue Description' onclick='showIssueDescDtls(this,\""+ProbDesc1+"\",\""+IssueNo+"\",\""+DDWName+"\");'>"+ProbSubject+"</a></td> ");
						br.append("<td style=\"text-align:center;\" class='multiControl' colspan='1' width='10%'>"+IssueDate+"</td>");
						br.append("<td style=\"text-align:left;\" class='multiControl' width='10%'><a style='color:blue;cursor: pointer' title='Click to View the Status Description' onclick='showStatusDescDtls(this,\""+StatusFlg+"\",\""+IssueNo+"\",\""+DDWName+"\",\""+Solution1+"\",\""+SolutionDate+"\",\""+Remarks1+"\");'>"+Status+"</a></td> ");/*Brahmam*/
						
						if(FileName!=null)
						{
						br.append("<td style=\"text-align:center;\" class='multiControl' title = 'click to Download the file attached' colspan='1' width='10%'>");/*Brahmam*/
						br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strDmnld' id='strDmnld"+strCheckHidValue+"' onClick='downloadfile(\""+strCheckHidValue+"\")'>"+"Download"+"</a> &nbsp;");
						br.append("</td>");
						}
						else
						{
							br.append("<td style=\"text-align:center;\" class='multiControl' colspan='1' width='10%'>----</td>");
						}
						//br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='20%'></td>");/*Brahmam*/
											
						//br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(12)+"</td>");
						
						
						br.append("</tr>");
						
						
						
						count++ ;
						start++;
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
		    	    1. DDW NAME
		    	    2. Department Name , 
		            3. Menu Name
		            4. Problem Subject 
		            5. Problem Description
		            6. Status
		            7. Issue Number
		            8. Issue Entry Date
		            9. Solution
		            10. Solution Entry Date
		            11. Remarks
		            12. Problem Submitted By
		            13. Solution Submitted By
		            14. File Name 
		            */  	
					String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14);	/* brahmam Changed*/	
					////System.out.println("if 0 records then strCheckHidValue:  "+strCheckHidValue);
					
					br.append("<tr>");
					br.append("<input type='hidden' name='demandFlg'  value='1'>");
					br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
					br.append("<td class='multiControl' colspan='1' width='5%'>");
					br.append(start);
					br.append("</td>");
					
					
					//br.append("<td style=\"text-align:left;\" class='multiControl' colspan='1' width='20%'>");
					//br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strSupplierID' id='strSupplierID"+count+"' onClick='getSupplierDtlPopUp(\""+count+"\")'>"+ws.getString(1)+"</a> &nbsp;");
					//br.append("</td>");
					//br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(1)))+"</td>");
					//br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(2)))+"</td>");
					//br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='15%'>"+myFormatter.format(Double.parseDouble(ws.getString(3)))+"</td>");/*brahmam*/
					//br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(4)))+"</td>");
					//br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(5)))+"</td>");
					
					//br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(12)+"</td>");
					
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
				 
				
				 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				 br.append("<tr>");
				 br.append("<td CLASS='multiLabel' colspan='1' width='5%'>Sl No.</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='15%'>DDW Name</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Department</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Menu Name</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Issue Subject</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Issue Raised Date</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Status</td>");/*Brahmam*/
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>File Download Link </td>");/*brahmam*/
				 
				 br.append("</tr>");
				 br.append("<input type='hidden' name='demandFlg'  value='0'>");
	           	 br.append("<tr>");  
	           	 br.append("<td class='multiControl' colspan='8'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	 br.append("</table>");
	           	
					
			   }
			} 
		    else
				{
					 
					// //System.out.println("No Data");
					 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
					 br.append("<tr>");
					 br.append("<td CLASS='multiLabel' colspan='1' width='5%'>Sl No.</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='15%'>DDW Name</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Menu Name</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='30%'>Issue Subject</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Issue Raised Date</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Status</td>");/*Brahmam*/
						br.append("<td CLASS='multiLabel' colspan='1' width='10%'>File Download Link </td>");/*brahmam*/
					 
					 br.append("</tr>");
					 br.append("<input type='hidden' name='demandFlg'  value='0'>");
		          	 br.append("<tr>");  
		          	 br.append("<td class='multiControl' colspan='8'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
		          	 br.append("</table>");
		          	
						
				   }
	     }
		
	catch (Exception e) {	
		 
			throw new Exception("OffLineIssueIndentTransHLP.getScreenTwo()->"+e.getMessage());
		}
		return br.toString();
	}
	
	
	/**
	 * Gets the issue dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the issue dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getPrintScreenTwo(HelpDeskRptVO vo) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		
		
		int i=1;
		int count = 0;
		
		
		
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		WebRowSet ws = vo.getStrScreentTwoWs();
		String strHiddenValue = vo.getStrHiddenValue();
 		String strTableWidth = "700";
 		DecimalFormat myFormatter = new DecimalFormat("0.00");

		try 
		{
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			
			sb.append("<tr>");
//			sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");		
			sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
			sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr>");			
			sb.append("<tr>");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append("Help Desk Details");
			sb.append("</font></b></td><td width='10%'>&nbsp;</td> ");
			sb.append("</tr>");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> Between :: ");
			sb.append(vo.getStrFromDate()+"  TO  " +vo.getStrToDate());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

			
			
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(4);' /> <img style='cursor: pointer; ' title='Get Back Report'  ");
			sb.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(4);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(4);' /></div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
		
			sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='3%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>DDW Name</b></font> ");
			sb.append("</td>");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Depatment</b></font> ");
			sb.append("</td>");

			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Menu Name</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='17%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Subject</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Raised Date</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Status</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Resolved/Rejected Date</b></font> ");
			sb.append("</td> ");
			
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
			
					
					
					String DDWName = ws.getString(1);
					String DeptName = ws.getString(2);
					String MenuName = ws.getString(3);
					String ProbSubject = ws.getString(4);
					String ProbDesc = ws.getString(5);
					String Status = ws.getString(6);
					String IssueNo = ws.getString(7);
					String IssueDate = ws.getString(8);
					String Solution = ws.getString(9);
					String SolutionDate = ws.getString(10);
					String Remarks = ws.getString(11);
					String ProbSubmitBy = ws.getString(12);
					String SolSubmitBy = ws.getString(13);
					String FileName = ws.getString(14);
					String StatusFlg = ws.getString(15);
					
					
					if (DDWName == null)
						DDWName = "----";
					if (DeptName == null)
						DeptName = "----";
					if (MenuName == null)
						MenuName = "----";
					if (ProbSubject == null)
						ProbSubject = "----";
					if (ProbDesc == null)
						ProbDesc = "----";
					if (Status == null)
						Status = "----";
					if (IssueNo == null)
						IssueNo = "----";
					if (IssueDate == null)
						IssueDate = "----";
					if (Solution == null)
						Solution = "----";
					if (SolutionDate == null)
						SolutionDate = "----";
					if (Remarks == null)
						Remarks = "----";
					if (ProbSubmitBy == null)
						ProbSubmitBy = "----";
					if (SolSubmitBy == null)
						SolSubmitBy = "----";
							
							NumberFormat formatter = new DecimalFormat("############.##");  
						    
							
							
					//String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+strHiddenValue;		
					sb.append("<tr> ");
					//sb.append("<input type='hidden' name='strPoHidValue' id='strPoHidValue"+count+"' value='"+strCheckHidValue+"'>");
					sb.append("<td align='center' width='3%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:left;\"  width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(DDWName);
					sb.append("</font></td>");
					sb.append("<td style=\"text-align:left;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(DeptName);
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:left;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(MenuName);
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:left;\" width='17%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ProbSubject);
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:left;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(IssueDate);
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:left;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(Status);
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:left;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(SolutionDate);
					sb.append("</font></td> ");
//					sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//					sb.append(ws.getString(6));
//					sb.append("</font></td> ");
					sb.append("</tr> ");					
					
					i++;
					count++;
								
				}
					
				
			}	
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}

}
