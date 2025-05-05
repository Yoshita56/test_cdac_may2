package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.IndentReturnTransVO;
import mms.transactions.vo.IndentViewTransVO;

public class IndentReturnTransHLP
{

	   public static String getItemDetails1(IndentReturnTransVO vo)
		{
		    StringBuffer sb = new StringBuffer("");
		    String strHiddenValue =""; 
			WebRowSet ws1 = vo.getStrItemDetailsWs();
			int i=0;
			try 
			{
				if (ws1 != null) 
				{
					   String strCrNo   = null;
				       String strPatName = null;
				       String strEmpID = null;
				       String strEmpName = null;
				       while(ws1.next())
				       { 
				    	   if(vo.getStrReqTypeId().equals("14"))
				    	   {	   
				    		   strCrNo    = ws1.getString(10);
					    	   strPatName = ws1.getString(11);
					    	   strEmpID   = ws1.getString(12);
					    	   strEmpName = ws1.getString(13);
				    	   }
				    	   if(vo.getStrReqTypeId().equals("12")||vo.getStrReqTypeId().equals("13"))
				    	   {
				    		   strCrNo    = ws1.getString(8);
					    	   strPatName = ws1.getString(9);
					    	   strEmpID   = ws1.getString(10);
					    	   strEmpName = ws1.getString(11);
				    		   
				    	   } 
				    	   if(vo.getStrReqTypeId().equals("10"))
				    	   {	   
				    		   strCrNo    = ws1.getString(10);
					    	   strPatName = ws1.getString(11);
					    	   strEmpID   = ws1.getString(12);
					    	   strEmpName = ws1.getString(13);
				    	   }
				    	   
				    	    if(strCrNo == null || strCrNo.equals("")|| strCrNo.equals("0"))  strCrNo = "-------";
							if(strPatName == null || strPatName.equals("")) strPatName = "-------";
							if(strEmpID == null || strEmpID.equals("")|| strEmpID.equals("0")) strEmpID = "-------";
							if(strEmpName == null || strEmpName.equals("")) strEmpName = "-------";
				    	   
				           sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
				           sb.append("<tr><td width='25%' class='LABEL'>CR NO</td>");
				           sb.append("<td width='25%' class='CONTROL'>");
				           sb.append(strCrNo);
				           sb.append("</td>");
				           sb.append("<td width='25%' class='LABEL'>Patient Name</td>");
				           sb.append("<td width='25%' class='CONTROL'>");
				           sb.append(strPatName);
				           sb.append("</td></tr>");
				           sb.append("<tr><td width='25%' class='LABEL'>Emp ID</td>");
				           sb.append("<td width='25%' class='CONTROL'>");
				           sb.append(strEmpID);
				           sb.append("</td>");
				           sb.append("<td width='25%' class='LABEL'>Emp Name</td>");
				           sb.append("<td width='25%' class='CONTROL'>");
				           sb.append(strEmpName);
				           sb.append("</td></tr>");
				  }
				 sb.append("</table>");
				}
				ws1.beforeFirst();
				
			       sb.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px'>"); 
				   sb.append("<tr>");
				   sb.append("<td width='20%' class='multiLabel'>Item Name</td>");
				   sb.append("<td width='20%' class='multiLabel'>Available Qty</td>"); 
				   sb.append("<td width='20%' class='multiLabel'>Req Qty</td>");
				   sb.append("<td width='20%' class='multiLabel'>Sanction Qty</td>");
				   sb.append("<td width='20%' class='multiLabel'>Rate/Unit</td></tr>");
				  
				      if (ws1 != null) 
					  {
						   String strItemName   = null;
					       String strAvlQty = null;
					       String strReqQty = null;
					       String strSancQty = null;
					       String strRate = null;
					       String strIssueQty = null;
					       String strRetQty = null;
					       String strLstRecevDate = null;
					       String strLstRecevQty = null;
					       String strLstRetQtyUnitId = null;
					       while(ws1.next())
					       {
					    	   if(vo.getStrReqTypeId().equals("10"))
					    	    {
					    		    strIssueQty	        = ws1.getString(1);	
					    	    	strLstRecevQty      = ws1.getString(2);
					    	    	strLstRecevDate     = ws1.getString(3);
					    	    	strLstRetQtyUnitId  = ws1.getString(4);
					    	    	strItemName   = ws1.getString(5);
							        strAvlQty     = ws1.getString(6);
							        strReqQty     = ws1.getString(7);
							        strSancQty    = ws1.getString(8);
							        strRate       = ws1.getString(9);
					    	    	
							        strHiddenValue = strIssueQty+"^"+strLstRecevQty+"^"+strLstRecevDate+"^"+strLstRetQtyUnitId;
					    	    }	
					    	   
					    	   
					    	    if(vo.getStrReqTypeId().equals("12") || vo.getStrReqTypeId().equals("13"))
					    	    {
					    	    	strIssueQty	  = ws1.getString(1);	
					    	    	strRetQty     = ws1.getString(2);
					    	    	strItemName   = ws1.getString(3);
							        strAvlQty     = ws1.getString(4);
							        strReqQty     = ws1.getString(5);
							        strSancQty    = ws1.getString(6);
							        strRate       = ws1.getString(7);
							        strHiddenValue = strIssueQty+"^"+strRetQty;
							        
					    	    }	
					    	    if(vo.getStrReqTypeId().equals("14"))
					    	    {
					    	    	strIssueQty	        = ws1.getString(1);	
					    	    	strLstRecevQty      = ws1.getString(2);
					    	    	strLstRecevDate     = ws1.getString(3);
					    	    	strLstRetQtyUnitId  = ws1.getString(4);
					    	    	strItemName   = ws1.getString(5);
							        strAvlQty     = ws1.getString(6);
							        strReqQty     = ws1.getString(7);
							        strSancQty    = ws1.getString(8);
							        strRate       = ws1.getString(9);
					    	    	
					    	    	strHiddenValue = strIssueQty+"^"+strLstRecevQty+"^"+strLstRecevDate+"^"+strLstRetQtyUnitId;
					    	    }	
					    	    
					    	    
					    	    
					    	    if(strItemName == null || strItemName.equals(""))  strItemName = "-----";
								if(strAvlQty == null || strAvlQty.equals("")) strAvlQty = "-----";
								if(strReqQty == null || strReqQty.equals("")) strReqQty = "-----";
								if(strSancQty == null || strSancQty.equals("")) strSancQty = "-----";
								if(strRate == null || strRate.equals("")) strRate = "-----";
								sb.append("<input type='hidden' name ='strHiddenValue'  value='"+strHiddenValue+"'>");
								sb.append("<tr>");
								sb.append("<td width='20%' class='multiControl'>");
			     		   		sb.append("<a name='tarriff' value='' title='Get Item Details' STYLE='cursor:pointer;cursor:pointer;color:blue' onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
								sb.append("</td>");
								sb.append("<td width='20%' class='multiControl'>");
								sb.append(strAvlQty);
								sb.append("</td>");
								sb.append("<td width='20%' class='multiControl'>");
								sb.append(strReqQty);
								sb.append("</td>");
					
								sb.append("<td width='20%' class='multiControl'>");
								sb.append(strSancQty);
								sb.append("</td>");
								sb.append("<td  width='20%' class='multiControl'>");
								sb.append(strRate);
								sb.append("</td>");
								sb.append("</tr>");
								i++;
							}
						 sb.append("</table>");
				  	     
			 	  }/*else {
					    sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>"); 
					    sb.append("<tr>");
					    sb.append("<td colspan='5'  CLASS='multiControl' >"
								+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

					    sb.append("</tr>");
					    sb.append("</table>");
						
				   } */
			}
			catch(Exception e)
			{
			    vo.setStrMsgString("IndentViewTransHLP.getItemDetails() --> "+e.getMessage());
				vo.setStrMsgType("1");
			}
		return sb.toString();
		}
	
	
	
 public static String getItemDetails(IndentReturnTransVO vo)
	{
	    StringBuffer sb = new StringBuffer("");
	    String strHiddenValue =""; 
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		int i=0;
		try 
		{
		       sb.append("<table class='TABLEWIDTH' align='center' bgcolor='black' border='0' cellspacing ='1px'>"); 
			   sb.append("<tr>");
			   sb.append("<td width='20%' class='multiLabel'>Item Name</td>");
			   sb.append("<td width='20%' class='multiLabel'>Batch No/Sl No</td>"); 
			   sb.append("<td width='10%' class='multiLabel'>Aval Qty</td>");
			   if(vo.getStrReqTypeId().equals("18"))
				   sb.append("<td width='10%' class='multiLabel'>Req Qty</td>");
			   sb.append("<td width='20%' class='multiLabel'>Sanction Qty</td>");
			   sb.append("<td width='20%' class='multiLabel'>Rate/Unit</td></tr>");
			   sb.append("</table>");
			   sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' border='0' cellspacing ='1px'>"); 
			      if (ws1 != null) 
				  {
					   String strItemName   = null;
				       String strAvlQty = null;
				       String strReqQty = null;
				       String strSancQty = null;
				       String strRate = null;
				    //   String strIssueQty = null;
				       String strRateQty = null;
				       
				       String strLstPoNo = null;
				       String strLstPODate = null;
				       String strSancQtyUnit = null;
				       String strLstRecDate = null;
				       String strAvlQtyUnit =null;
				       
				       String strItemId = null;
				       String strItemBrandId = null;
				       String strStockStatusCode = null;
				       String strItemSlNo = null;
				       String strBatchNo = null;
				       			       
				       while(ws1.next())
				       {
				    	    if(vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("19"))
				    	    {
				    	    	strLstPoNo      = ws1.getString(1);
				    	    	strLstPODate    = ws1.getString(2);
				    	    	strLstRecDate   = ws1.getString(3);
				    	    	strItemName     = ws1.getString(4);
				    	    	strAvlQty       = ws1.getString(5);
				    	    //	strReqQty       = ws1.getString(6);
				    	    	strSancQty      = ws1.getString(7);
				    	    	
				    	    	strRateQty      = ws1.getString(8);
				    	    	//System.out.println("Batch No-16->>>"+ws1.getString(9));
						        strBatchNo      = ws1.getString(9);
						        strItemId       = ws1.getString(10);
						        strItemBrandId  = ws1.getString(11);
						        strStockStatusCode   = ws1.getString(12);
						        strAvlQtyUnit     = ws1.getString(13);
						        strSancQtyUnit    = ws1.getString(14);
						        strItemSlNo       = ws1.getString(15); 
						        
					            strHiddenValue    = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strItemId+"^"+strItemBrandId+"^"+strStockStatusCode+"^"+strAvlQtyUnit+"^"+strSancQtyUnit+"^"+strBatchNo+"^"+strAvlQty+"^"+strSancQty;
				    	    }	
				    	    		    	    
				    	    if(vo.getStrReqTypeId().equals("18"))
				    	    {
				    	    	strLstPoNo      = ws1.getString(1);
				    	    	strLstPODate    = ws1.getString(2);
				    	    	strLstRecDate   = ws1.getString(3);
				    	    	strItemName     = ws1.getString(4);
				    	    	strAvlQty       = ws1.getString(5);
				    	    	strReqQty       = ws1.getString(6);
				    	    	strSancQty      = ws1.getString(7);
				    	    	
				    	    	strRateQty      = ws1.getString(8);
				    	    	//System.out.println("Batch No-18->>>"+ws1.getString(9));
						        strBatchNo      = ws1.getString(9);
						        strItemId       = ws1.getString(10);
						        strItemBrandId  = ws1.getString(11);
						        strStockStatusCode   = ws1.getString(12);
						        strAvlQtyUnit     = ws1.getString(13);
						        strSancQtyUnit    = ws1.getString(14);
						        strItemSlNo       = ws1.getString(15); 
						        
						        
						        
						        strHiddenValue    = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strItemId+"^"+strItemBrandId+"^"+strStockStatusCode+"^"+strAvlQtyUnit+"^"+strSancQtyUnit+"^"+strBatchNo+"^"+strAvlQty+"^"+strSancQty;
				    	    }	
				    	   
				    	    			    	     		    	   
					  	    if(strItemName == null || strItemName.equals("")) strItemName = "-----";
							if(strAvlQty == null || strAvlQty.equals("")) strAvlQty = "-----";
							if(strBatchNo == null || strBatchNo.equals("")) strBatchNo = "-----";
							if(strSancQty == null || strSancQty.equals("")) strSancQty = "-----";
							if(strRate == null || strRate.equals("")) strRate = "-----";
							sb.append("<input type='hidden' name ='strBatchNo'  value='"+strBatchNo+"'>");
							sb.append("<input type='hidden' name ='strStockStatusCode'  value='"+strStockStatusCode+"'>");
							sb.append("<input type='hidden' name ='strItemSlNo'  value='"+strItemSlNo+"'>");
							sb.append("<input type='hidden' name ='strHiddenValue'  value='"+strHiddenValue+"'>");
							sb.append("<tr>");
							sb.append("<td width='20%' class='multiControl'>");
		     		   		sb.append("<a name='tarriff' value='' title='Get Item Details' STYLE='cursor:pointer;cursor:pointer;color:blue' onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
							sb.append("</td>");
							sb.append("<td width='20%' class='multiControl'>");
							sb.append(strBatchNo);
							sb.append("</td>");
							sb.append("<td width='10%' class='multiControl'>");
							sb.append(strAvlQty);
							sb.append("</td>");
							if(vo.getStrReqTypeId().equals("18"))
				    	    {
								sb.append("<td width='10%' class='multiControl'>");
								sb.append(strReqQty);
								sb.append("</td>");
				       		}
							sb.append("<td width='20%' class='multiControl'>");
							sb.append(strSancQty);
							sb.append("</td>");
							sb.append("<td  width='20%' class='multiControl'>");
							sb.append(strRateQty);
							sb.append("</td>");
							sb.append("</tr>");
							i++;
						}
					 sb.append("</table>");
			  	     
		 	  }else {
				    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#6097BC'  cellspacing ='1px'>"); 
				    sb.append("<tr>");
				    sb.append("<td colspan='5'  CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

				    sb.append("</tr>");
				    sb.append("</table>");
					
			   } 
		}
		catch(Exception e)
		{
		    vo.setStrMsgString("IndentViewTransHLP.getItemDetails() --> "+e.getMessage());
			vo.setStrMsgType("1");
		}
	return sb.toString();
	}
 public static String getIndentDetails(IndentReturnTransVO vo)
 {
		
		StringBuffer sb = new StringBuffer("");
		
		try {
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
										
					String strReqNo       = ws.getString(1);
					String strStoreName   = ws.getString(2);
					String strIndentDate  = ws.getString(3);
					String strItemCatg    = ws.getString(4);
					String strIndentType  = ws.getString(5);
					String strToStore     = ws.getString(6);
					
					if (strStoreName == null)
						strStoreName = "----";
					if (strItemCatg == null)
						strItemCatg = "----";
					if (strReqNo == null)
						strReqNo = "----";
					if (strIndentDate == null)
						strIndentDate = "----";
					if (strIndentType == null)
						strIndentType = "----";
					if (strToStore == null)
						strToStore = "----";
					sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
					//if(vo.getStrItemCategory()!=null && vo.getStrItemCategory().equals("10"))
					//	sb.append("<tr><td width='25%' class='LABEL'>Drug Warehouse Name</td>");
					//else
					sb.append("<tr><td width='25%' class='LABEL'>Store Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strStoreName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Item Category</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strItemCatg);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Indent No</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strReqNo);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Indent Date</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentDate);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Indent Type</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentType);
					sb.append("</td>");
					//if(vo.getStrItemCategory()!=null && vo.getStrItemCategory().equals("10"))
					//	sb.append("<td width='25%' class='LABEL'>To Drug Warehouse Name</td>");
					//else
					sb.append("<td width='25%' class='LABEL'>To Store Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strToStore);
					sb.append("</td></tr>");
					sb.append("</table>");
				}
			}
			else {
				    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
				    sb.append("<tr>");
				    sb.append("<td colspan='5'  CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

				    sb.append("</tr>");
				    sb.append("</table>");
					
			   } 
		}catch(Exception e){
			
			vo
				.setStrMsgString("IndentViewTransHLP.getItemDetails() --> "
						+e.getMessage());
			vo.setStrMsgType("1");
		}
	return sb.toString();
	}

public static String getApprovalDetails(IndentViewTransVO vo){
		
		StringBuffer br = new StringBuffer("");
		
		try {
								
			WebRowSet wb = vo.getStrApprovalDetailsWs();
			
			if(wb != null && wb.size() > 0)
			{
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				while (wb.next())
				{
						
					/* 
					String strApprovedBy = wb.getString(1);
					String strApprovedDate = wb.getString(2);
					String strStatus = wb.getString(3);
					
					if(strApprovedBy == null || strApprovedBy.equals("null"))strApprovedBy = "";
					if(strApprovedDate == null || strApprovedDate.equals("null"))strApprovedDate = "";
					if(strStatus == null || strStatus.equals("null"))strStatus = "";
				
					br.append("<tr>");
					br.append("<td width='5%' class='multiControl'>");
					
					br.append("<td width='30%' class='multiControl'>"+strApprovedBy+"</td>");
					br.append("<td width='30%' class='multiControl'>"+strApprovedDate+"</td>");
					br.append("<td width='30%' class='multiControl'>"+strStatus+"</td>");

					br.append("</tr>");	
					count++;
					br.append("<input type='hidden' name='strSize' value='"+count+"'>");*/
					
				}
				br.append("</table>");
			}else {
				    br.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
				    br.append("<tr>");
				    br.append("<td colspan='5'  CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

				    br.append("</tr>");
				    br.append("</table>");
					
			   } 
		}catch(Exception e){
			
			vo
				.setStrMsgString("IndentViewTransHLP.getApprovalDetails() --> "
						+e.getMessage());
			vo.setStrMsgType("1");
		}
	return br.toString();
	}
	

}
