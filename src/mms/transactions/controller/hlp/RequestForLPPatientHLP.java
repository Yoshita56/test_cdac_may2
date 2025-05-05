package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.RequestForLPPatientVO;

public class RequestForLPPatientHLP {
	
	public static String getItemDetails1(RequestForLPPatientVO vo)
	{
	    StringBuffer sb = new StringBuffer("");
	    String strHiddenValue =""; 
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		String[] tmpqty;
		int i=0,k=0;
		try 
		{
			if (ws1 != null && ws1.size()>0) 
			{
				   String strCrNo   = null;
			       String strPatName = null;
			       String strEmpID = null;
			       String strEmpName = null;
			       if(k==0)
			       {
			       while(ws1.next())
			       { 
			    	   if(vo.getStrReqType().equals("14"))
			    	   {	   
			    		   strCrNo    = ws1.getString(10);
				    	   strPatName = ws1.getString(11);
				    	   strEmpID   = ws1.getString(12);
				    	   strEmpName = ws1.getString(13);
			    	   }
			    	   if(vo.getStrReqType().equals("12")||vo.getStrReqType().equals("13") ||vo.getStrReqType().equals("86") )
			    	   {
			    		   strCrNo    = ws1.getString(8);
				    	   strPatName = ws1.getString(9);
				    	   strEmpID   = ws1.getString(10);
				    	   strEmpName = ws1.getString(11);
			    		   
			    	   } 
			    	   if(vo.getStrReqType().equals("13"))
			    	   {
			    		   strCrNo    = ws1.getString(8);
				    	   strPatName = ws1.getString(9);
				    	   strEmpID   = ws1.getString(10);
				    	   strEmpName = ws1.getString(11);
				    	   		    		   
			    	   } 
			    	   if(vo.getStrReqType().equals("10"))
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
						//System.out.println("Before Condition--->>"+vo.getStrReqTypeId());
					  if(!vo.getStrReqType().equals("10"))
				      {
						if(!vo.getStrReqType().equals("14"))
						{	
						 if(k==0)
					     {	  
			             sb.append("<table class='TABLEWIDTH' align='center'   border='0'  cellspacing ='1px'>");
			             sb.append("<tr><td width='25%' class='LABEL'>CR NO</td>");
			             sb.append("<td width='25%' class='CONTROL'><input type='hidden' name='strCrNo' value='"+strCrNo+"'><input type='hidden' name='strBSReqNo' value='"+vo.getStrIndentNo()+"'>");
			             sb.append(strCrNo);
			             sb.append("</td>");
			             sb.append("<td width='25%' class='LABEL'>Patient Name</td>");
			             sb.append("<td width='25%' class='CONTROL'>");
			             sb.append(strPatName);
			             sb.append("</td></tr>");
			             ////System.out.println("Insde View HLP:-->>"+vo.getStrReqTypeId());
			             if(vo.getStrReqType().equals("12"))
			             {	   
			              sb.append("<tr><td width='25%' class='LABEL'>Emp ID</td>");
			              sb.append("<td width='25%' class='CONTROL'>");
			              sb.append(strEmpID);
			              sb.append("</td>");
			              sb.append("<td width='25%' class='LABEL'>Emp Name</td>");
			              sb.append("<td width='25%' class='CONTROL'>");
			              sb.append(strEmpName);
			              sb.append("</td></tr>");
			            }
				       }
			          }
					  k++;
				     } 
				  }
			   sb.append("</table>");
			 }
			}
			
			   ws1.beforeFirst();
			
		       sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC'  border='0' cellspacing ='1px'>"); 
			   sb.append("<tr>");
			   sb.append("<td width='20%' class='multiLabel'>Item Name</td>");
			   sb.append("<td width='20%' class='multiLabel'>Avalaible Qty</td>"); 
			   sb.append("<td width='20%' class='multiLabel'>Req Qty</td>");
			   sb.append("<td width='20%' class='multiLabel'>Approved Qty</td>");
			   sb.append("<td width='20%' class='multiLabel'>Rate/Unit</td></tr>");
			  
			      if (ws1 != null && ws1.size()>0) 
				  {
			    	  tmpqty = new String[ws1.size()];
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
				       String itemParamValue = null;
				       String strUnitName = null;
				       while(ws1.next())
				       {
				    	   if(vo.getStrReqType().equals("10"))
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
				    	    	
						        strHiddenValue = strIssueQty+"^"+strLstRecevQty+"^"+strLstRecevDate+"^"+strLstRetQtyUnitId+"^"+strItemName;
				    	    }	
				    	   
				    	   
				    	    if(vo.getStrReqType().equals("12") || vo.getStrReqType().equals("13") ||vo.getStrReqType().equals("86") )
				    	    {
				    	    	strIssueQty	  = ws1.getString(1);	
				    	    	strRetQty     = ws1.getString(2);
				    	    	strItemName   = ws1.getString(3);
						        strAvlQty     = ws1.getString(4);
						        strReqQty     = ws1.getString(5);
						        strSancQty    = ws1.getString(6);
						        strRate       = ws1.getString(7);
						        strHiddenValue = strIssueQty+"^"+strRetQty+"^"+strItemName;
						        itemParamValue = ws1.getString(24);
						        strUnitName = ws1.getString(15);
						        tmpqty[i]=strReqQty;
						        
				    	    }	
				    	    if(vo.getStrReqType().equals("14"))
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
				    	    	
				    	    	strHiddenValue = strIssueQty+"^"+strLstRecevQty+"^"+strLstRecevDate+"^"+strLstRetQtyUnitId+"^"+strItemName;
				    	    }	
				    	    
				    	    
				    	    
				    	    if(strItemName == null || strItemName.equals(""))  strItemName = "-----";
							if(strAvlQty == null || strAvlQty.equals("")) strAvlQty = "-----";
							if(strReqQty == null || strReqQty.equals("")) strReqQty = "-----";
							if(strSancQty == null || strSancQty.equals("")) strSancQty = "-----";
							if(strRate == null || strRate.equals("")) strRate = "-----";
							sb.append("<input type='hidden' name ='strHiddenValue'  value='"+strHiddenValue+"'>");
							sb.append("<tr>");
							sb.append("<td width='20%' class='multiControl'><input type = 'hidden' name='itemParamValue' id='itemParamValue-"+i+"' value='"+itemParamValue+"'>");
		     		   		//sb.append("<a name='tarriff' STYLE='cursor:pointer;cursor:pointer;color:blue;' title='Get Item Details' value=''  onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
							sb.append(strItemName);
		     		   		sb.append("</td>");
							sb.append("<td width='20%' class='multiControl'>");
							sb.append(strAvlQty);
							sb.append("</td>");
							sb.append("<td width='20%' class='multiControl'><input type='hidden' name='strReqQty' id='strReqQty"+i+"' value='"+strReqQty+"'> ");
							sb.append(strReqQty);
							sb.append("</td>");
				
							sb.append("<td width='20%' class='multiControl'><input type='hidden' name='strUnitName' id='strUnitName"+i+"' value='"+strUnitName+"'>");
							sb.append(strSancQty);
							sb.append("</td>");
							sb.append("<td  width='20%' class='multiControl'>");
							sb.append(strRate);
							sb.append("</td>");
							sb.append("</tr>");
							i++;
						}
					 sb.append("</table>");
					 vo.setStrReqQty(tmpqty);
			  	     
		 	  }
			      else 
			      {
				    sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>"); 
				    sb.append("<tr>");
				    sb.append("<td colspan='5'  CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

				    sb.append("</tr>");
				    sb.append("</table>");
					
			   } 
		}
		catch(Exception e)
		{
		    vo.setStrMsgString("RequestForLPPatientHLP.getItemDetails() --> "+e.getMessage());
			vo.setStrMsgType("1");
		}
		
	return sb.toString();
	}



public static String getItemDetails(RequestForLPPatientVO vo)
{
    StringBuffer sb = new StringBuffer("");
    String strHiddenValue =""; 
	WebRowSet ws1 = vo.getStrItemDetailsWs();
	int i=0;
	try 
	{
	       sb.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center'  border='0' cellspacing ='1px'>"); 
		   if(vo.getStrReqType().equals("16") || vo.getStrReqType().equals("18")||vo.getStrReqType().equals("19"))
		   {
			    sb.append("<tr>");
			    sb.append("<td width='20%' class='multiLabel'>Item Name</td>");
			    sb.append("<td width='15%' class='multiLabel'>Batch No</td>"); 
			 //   sb.append("<td width='15%' class='multiLabel'>Aval Qty</td>"); 
			    sb.append("<td width='15%' class='multiLabel'>Req Qty</td>");
			    sb.append("<td width='15%' class='multiLabel'>Approved Qty</td>");
			    sb.append("<td width='20%' class='multiLabel'>Rate/Unit</td>");
			    sb.append("</tr>");   
		   }
		   else
		   {	   
	        sb.append("<tr>");
		    sb.append("<td width='40%' class='multiLabel'>Item Name</td>");
		  //  sb.append("<td width='15%' class='multiLabel'>Avalaible Qty</td>"); 
		    sb.append("<td width='15%' class='multiLabel'>Req Qty</td>");
		    sb.append("<td width='15%' class='multiLabel'>Approved Qty</td>");
		    sb.append("<td width='15%' class='multiLabel'>Rate/Unit</td>");
		    sb.append("</tr>");
		   }
		   
		  
		      if (ws1 != null) 
			  {
				   String strItemName   = null;
			       String strAvlQty = null;
			       String strReqQty = null;
			       String strSancQty = null;
			       String strRate = null;
			       String strIssueQty = null;
			       String strReOrderLevel = null;
			       String strLstIndentQty = null;
			       String strLstIssueQty = null;
			       String strLstYerConsump = null;
			       String strLstPoNo = null;
			       String strLstPODate = null;
			       String strLstRecQty = null;
			       String strLstRecDate = null;
			       String strLstSupplBy =null;
			       String strExpDate = null;
			       String strGrpName = null;
			       String strSubGrpName = null;
			       String strBatchNo = null;
			       			       
			       while(ws1.next())
			       {
			    	    if(vo.getStrReqType().equals("11")||vo.getStrReqType().equals("86"))
			    	    {
			    	    	strLstPoNo       = ws1.getString(1);
			    	    	strLstPODate     = ws1.getString(2);
			    	    	strLstRecDate    = ws1.getString(3);
			    	    	strLstSupplBy    = ws1.getString(4);
			    	    	strLstYerConsump = ws1.getString(5);
			    	    	strReOrderLevel  = ws1.getString(6);
			    	    	strLstRecQty     = ws1.getString(7);
			    	    	
			    	    	strItemName    = ws1.getString(8);
					        strAvlQty      = ws1.getString(9);
					        strReqQty      = ws1.getString(10);
					        strSancQty     = ws1.getString(11);
					        strRate        = ws1.getString(12);
					        strHiddenValue = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strLstSupplBy+"^"+strLstYerConsump+"^"+strReOrderLevel+"^"+strLstRecQty+"^"+strItemName;
					        
			    	    }	
			    	    if(vo.getStrReqType().equals("16") || vo.getStrReqType().equals("19") )
			    	    {
			    	    	strLstPoNo      = ws1.getString(1);
			    	    	strLstPODate    = ws1.getString(2);
			    	    	strLstRecDate   = ws1.getString(3);
			    	    	strExpDate      = ws1.getString(4);
			    	    	strLstSupplBy   = ws1.getString(5);
			    	    	strGrpName      = ws1.getString(6);
			    	    	strSubGrpName   = ws1.getString(7);
			    	    	strBatchNo      = ws1.getString(8);
			    	    	
			    	    	strItemName     = ws1.getString(9);
					        strAvlQty       = ws1.getString(10);
					        strReqQty       = ws1.getString(11);
					        strSancQty      = ws1.getString(12);
					        strRate         = ws1.getString(13);
				            strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strExpDate+"^"+strLstSupplBy+"^"+strGrpName+"^"+strSubGrpName+"^"+strItemName;
			    	    }	
			    	    
			    	    if(vo.getStrReqType().equals("15"))
			    	    {
			    	    	strLstPoNo      = ws1.getString(1);
			    	    	strLstPODate    = ws1.getString(2);
			    	    	strLstRecDate   = ws1.getString(3);
			    	    	strLstSupplBy   = ws1.getString(4);
			    	    	strGrpName      = ws1.getString(5);
			    	    	strSubGrpName   = ws1.getString(6);
			    	    	
			    	    	strItemName     = ws1.getString(7);
					        strAvlQty       = ws1.getString(8);
					        strReqQty       = ws1.getString(9);
					        strSancQty      = ws1.getString(10);
					        strRate         = ws1.getString(11);
				            strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strLstSupplBy+"^"+strGrpName+"^"+strSubGrpName+"^"+strItemName;
			    	    }	
			    	    	    
			    	    
			    	    if(vo.getStrReqType().equals("18"))
			    	    {
			    	    	strLstPoNo      = ws1.getString(1);
			    	    	strLstPODate    = ws1.getString(2);
			    	    	strGrpName      = ws1.getString(3);
			    	    	strSubGrpName   = ws1.getString(4);
			    	    	strExpDate      = ws1.getString(5);
			    	    	strBatchNo      = ws1.getString(6);
			    	    	strItemName     = ws1.getString(7);
					        strAvlQty       = ws1.getString(8);
					        strReqQty       = ws1.getString(9);
					        strSancQty      = ws1.getString(10);
					        strRate         = ws1.getString(11);
					        strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strGrpName+"^"+strSubGrpName+"^"+strExpDate+"^"+strItemName;
			    	    }	
			    	    if(vo.getStrReqType().equals("17"))
			    	    {
			    	    	strIssueQty      = ws1.getString(1);
			    	    	strReOrderLevel  = ws1.getString(2);
			    	    	strLstIndentQty  = ws1.getString(3);
			    	    	strLstIssueQty   = ws1.getString(4);
			    	    	strItemName      = ws1.getString(5);
					        strAvlQty        = ws1.getString(6);
					        strReqQty        = ws1.getString(7);
					        strSancQty       = ws1.getString(8);
					        strRate          = ws1.getString(9);
					        strHiddenValue   = strIssueQty+"^"+strReOrderLevel+"^"+strLstIndentQty+"^"+strLstIssueQty+"^"+strItemName;
			    	    }	
			    	    			    	     		    	   
				  	    if(strItemName == null || strItemName.equals("")) strItemName = "-----";
						if(strAvlQty == null || strAvlQty.equals("")) strAvlQty = "-----";
						if(strReqQty == null || strReqQty.equals("")) strReqQty = "-----";
						if(strSancQty == null || strSancQty.equals("")) strSancQty = "-----";
						if(strRate == null || strRate.equals("")) strRate = "-----";
						if(strBatchNo == null || strBatchNo.equals("")) strBatchNo = "-----";
						
						if(vo.getStrReqType().equals("16") || vo.getStrReqType().equals("18")|| vo.getStrReqType().equals("19"))
						{
						 
							 sb.append("<input type='hidden' name ='strHiddenValue'  value='"+strHiddenValue+"'>");
							 sb.append("<tr>");
							 sb.append("<td width='20%' class='multiControl'>");
		     		   		// sb.append("<a name='tarriff' value='' href='#' onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
		     		   		 //sb.append("<a name='tarriff' STYLE='cursor:pointer;cursor:pointer;color:blue;' title='Get Item Details' value=''  onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
							 sb.append(strItemName);
							 sb.append("</td>");
							 sb.append("<td width='15%' class='multiControl'>");
							 sb.append(strBatchNo);
							// sb.append("</td>");								 
							// sb.append("<td width='15%' class='multiControl'>");
							// sb.append(strAvlQty);
							 sb.append("</td>");
							 sb.append("<td width='15%' class='multiControl'>");
							 sb.append(strReqQty);
							 sb.append("</td>");
				
							 sb.append("<td width='15%' class='multiControl'>");
							 sb.append(strSancQty);
							 sb.append("</td>");
							 sb.append("<td  width='20%' class='multiControl'>");
							 sb.append(strRate);
							 sb.append("</td>");
							 sb.append("</tr>");
															
						}
						else
						{	
						 sb.append("<input type='hidden' name ='strHiddenValue'  value='"+strHiddenValue+"'>");
						 sb.append("<tr>");
						 sb.append("<td width='40%' class='multiControl' style=\'text-align:left;\'>");
	     		   		 //sb.append("<a name='tarriff' value='' href='#' onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
	     		   		 //sb.append("<a name='tarriff' STYLE='cursor:pointer;cursor:pointer;color:blue;' title='Get Item Details' value=''  onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
						 sb.append(strItemName);
//						 sb.append("</td>");
//						 sb.append("<td width='15%' class='multiControl'>");
//						 sb.append(strAvlQty);
						 sb.append("</td>");
						 sb.append("<td width='15%' class='multiControl'>");
						 sb.append(strReqQty);
						 sb.append("</td>");
			
						 sb.append("<td width='15%' class='multiControl'>");
						 sb.append(strSancQty);
						 sb.append("</td>");
						 sb.append("<td  width='15%' class='multiControl'>");
						 sb.append(strRate);
						 sb.append("</td>");
						 sb.append("</tr>");
						}
						i++;
					}
				 sb.append("</table>");
		  	     
	 	  }else {
			    sb.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center'  border='0'  cellspacing ='1px'>"); 
			    sb.append("<tr>");
			    sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

			    sb.append("</tr>");
			    sb.append("</table>");
				
		   } 
	}
	catch(Exception e)
	{
		e.printStackTrace();
	    vo.setStrMsgString("RequestForLPPatientHLP.getItemDetails() --> "+e.getMessage());
		vo.setStrMsgType("1");
	}
return sb.toString();
}


}
