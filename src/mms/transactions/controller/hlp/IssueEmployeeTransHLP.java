package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.IssueTransBO;
import mms.transactions.controller.fb.IssueEmployeeTransFB;
import mms.transactions.vo.IssueTransVO;

public class IssueEmployeeTransHLP {
	
	 public static String getIssueDetails(WebRowSet ws)
		throws SQLException {
			StringBuffer sb = new StringBuffer();
		
			int i = 0;
		
			try {
				
				if(ws != null && ws.size() != 0)
				{ 
					sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
					
					while (ws.next()) 
					{
											
						String strIssueNo         = ws.getString(1);
						String strIssueDate           = ws.getString(2);
						
						if (strIssueNo == null)
							strIssueNo = "----";
						if (strIssueDate == null)
							strIssueDate = "----";
						
					
						sb.append("<input type='hidden' name='strIssueNo' id='strIssueNo"+i+"' value="+strIssueNo+" >");						
						sb.append("<tr><td width='50%' colspan ='2'  class='LABEL'>IssueNo. / IssueDate</td>");
						sb.append("<td width='50%' colspan ='2' class='CONTROL'><a name='strIssueDtl' id='strIssueDtl' STYLE='CURSOR:POINTER;color:blue' onClick='getIssuePopUp(this, \""+i+"\" );'>");
						sb.append(strIssueNo +"/"+ strIssueDate);
						sb.append("</td></tr>");
					
						i++;
					}
					
					sb.append("</table>");
				}
				else {
					   
					    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
					    sb.append("<tr>");
					    sb.append("<td colspan='4'  CLASS='multiControl' >"
								+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED DATA </div>" + "</TD>");

					    sb.append("</tr>");
					    sb.append("</table>");
					   				    
						
				   } 
			} catch (Exception e) {
				e.printStackTrace();
		
			}
		
			return sb.toString();
		}
	 
	 public static String getIssuePopUp(String strHospCode,String strStoreId,String strIssueNo) 
	 		throws IOException {
		 
		 /* Creating VO & BO Object Here */
		 IssueTransVO vo = new IssueTransVO();
		 IssueTransBO bo = new IssueTransBO();
		 
		 /* Declaring Variable */
		 StringBuffer sb = new StringBuffer("");
		 String strItemName        = "";
		 String strIssueQtyUnit    = "";
		 String strRateUnit 	   = "";
		 String strCost            = "";
		 WebRowSet ws = null;
				 
		 /* Setting Value in vo Object */
		 vo.setStrStoreId(strStoreId);
		 vo.setStrHospitalCode(strHospCode);
		 vo.setStrIssueNo(strIssueNo);
				
		 /* Calling BO Method  */
		  bo.getIssueDtlPopUp(vo);
		
		
		  ws = vo.getStrIssueDtlPopUpWs();
		  	   
		   sb.append("<table width='400' align='center' border='0' cellpadding ='1px' cellspacing ='1px'>"); 
		   sb.append("<tr class='HEADER'><td colspan='3'>Issue Item Details</td>"); 
		   sb.append("<th align='right' ><img  style='cursor:pointer;cursor:pointer'  title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG' onClick=hideIssueDetails('issueDtlId');>");
		   sb.append("</th>");
		   sb.append("</tr>");
		   sb.append("<tr><td width='25%' class='multiLabel'>Item Name</td>");
		   sb.append("<td width='25%' class='multiLabel'>Issue Qty</td>");
		   sb.append("<td width='25%' class='multiLabel'>Rate/Unit</td>");
		   sb.append("<td width='25%' class='multiLabel'>Cost</td></tr>");
	  try 
	   {
		  
			if (ws != null && ws.size() != 0) 
			 {				     	
				while(ws.next())
             {
				    	
					 strItemName     = ws.getString(1).trim();
					 strIssueQtyUnit = ws.getString(2).trim(); 
					 strRateUnit         = ws.getString(3).trim();
					 strCost  = ws.getString(4).trim();
				  		 						   			
	  						    if(strItemName == null || strItemName.equals("")) strItemName = "-----";
	  	  				        if(strIssueQtyUnit == null || strIssueQtyUnit.equals("")) strIssueQtyUnit = "-----";
	  	  				        if(strRateUnit == null || strRateUnit.equals("")) strRateUnit = "-----"; 
	  	  				        if(strCost == null || strCost.equals("")) strCost = "-----";
	  					    
							    sb.append("<tr>");
							 
							    sb.append("<td width='25%' class='multiControl'>");
							    sb.append(strItemName);
							    sb.append("</td>");
							    sb.append("<td width='25%' class='multiControl'>");
							    sb.append(strIssueQtyUnit);
							    sb.append("</td>");
							    sb.append("<td width='25%' class='multiControl'>");
							    sb.append(strRateUnit);
							    sb.append("</td>");
							    sb.append("<td width='25%' class='multiControl'>");
							    sb.append(strCost);
							    sb.append("</td>");
							    sb.append("</tr>");
	  	                      
	  				        }
					  }	
			      else
			      {
			    	  sb.append("<tr><td colspan='4' class='multiControl'><font color='red'>No Matching Record Found</font></td></tr>");
	 			     
			      } 	 
		    
		 }
		 catch (SQLException e) 
      {
			 
			throw	new HisException("Issue Employee Transaction","IssueEmployeeTransHLP .getIssuePopUp() -->",e.getMessage());
		 }
		
      
	    sb.append("</table>");
	  
		return sb.toString();
	}
	 
	 public static String getEmployeeDtl(WebRowSet ws, IssueEmployeeTransFB formbean)
	    {
			
			StringBuffer sb = new StringBuffer("");
			
			try {
				
				if(ws != null && ws.size() > 0)
				{ 
					if (ws.next()) 
					{
											
						String strDeptDesiId         = ws.getString(1);
						String strAgeSex          = ws.getString(2);
						String strEmployeeName         = ws.getString(3);
						String strDeptName  =    ws.getString(4);
						String strDesignation       = ws.getString(5);
						
						String[] temp = strDeptDesiId.replace("^", "#").split("#");
						
						String strDeptId = temp[0];
																	
												
						if (strDeptName == null)
							strDeptName = "----";
						if (strEmployeeName == null)
							strEmployeeName = "----";
						if (strAgeSex == null)
							strAgeSex = "----";
						if (strDesignation == null)
							strDesignation = "----";
						formbean.setStrEmployeeName(strEmployeeName);
						sb.append("<input type='hidden' name ='strDeptId'  value='"+strDeptId+"'>");
						sb.append("<input type='hidden' name ='strEmployeeName'  value='"+strEmployeeName+"'>");
						sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
						sb.append("<tr><td width='25%'  class='LABEL'>Employee Name</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strEmployeeName);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Age/Sex</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strAgeSex);
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Department</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strDeptName);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Designation</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strDesignation);
						sb.append("</td></tr>");
						
						sb.append("</table>");
						
					}
				}
				else {
					   
					    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
					    sb.append("<tr>");
					    sb.append("<td colspan='5'  CLASS='multiControl' >"
								+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED DATA </div>" + "</TD>");

					    sb.append("</tr>");
					    sb.append("</table>");
					    
					    
						
				   } 
			}catch(Exception e){
				 
				throw new HisException("Issue Transaction","IssueTransHLP.getRequestDetails()-->",e.getMessage());
			}
		return sb.toString();
		}

}
