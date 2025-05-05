package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 13/Apr/2009
 * Modif Date : / /2009 
*/
public class IssueToEmployeeTransHLP 
{
	public static String getOnLineItemDetails(WebRowSet wb)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		 try {
			if(wb.size() != 0)
			{ 
				 sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");       
				 sBuffer.append("<tr class='TITLE'><td colspan='8'>Item Details</td></tr>");
				 
				 sBuffer.append("<tr><td width='20%' class='multiLabel'><div align='center'>Item Name</div></td>");  
	  	         sBuffer.append("<td width='21%' class='multiLabel'><div align='center'>Brand Name</div></td>");
	  	         sBuffer.append("<td width='12%' class='multiLabel'><div align='center'>Avalaible Qty</div></td>");
	  	         sBuffer.append("<td width='12%' class='multiLabel'><div align='center'>Issued Qty</div></td>");
	             sBuffer.append("<td width='20%' class='multiLabel'><div align='center'>Rate Unit / Pkg Id</div></td>");
	             sBuffer.append("</tr>");
				while(wb.next())
				{		     
	                            
	                	String strItemName = wb.getString(1);
	  					String strBrandName = wb.getString(2);
	  					String strRateUnit = wb.getString(3);
	  					String strTax = wb.getString(1);
	  					String strReqQty = wb.getString(2);
	  					String strSuppliedQty = wb.getString(3);
	  					
	  					if(strItemName == null || strItemName.equals("null") || strItemName.equals(""))strItemName = "---";
	  					if(strBrandName == null || strBrandName.equals("null") || strBrandName.equals("") )strBrandName = "---";
	  					if(strRateUnit == null || strRateUnit.equals("null") || strRateUnit.equals(""))strRateUnit = "---";
	  					if(strTax == null || strTax.equals("null") || strTax.equals(""))strTax = "---";
	  					if(strReqQty == null || strReqQty.equals("null") || strReqQty.equals(""))strReqQty = "---";
	  					if(strSuppliedQty == null || strSuppliedQty.equals("null") || strSuppliedQty.equals(""))strSuppliedQty = "---";
	  				
	  					sBuffer.append("<tr>");
	  					sBuffer.append("<td width='20%' class='multiControl'>'"+strItemName+"'</td>");
   					    sBuffer.append("<td width='21%' class='multiControl'>'"+strBrandName+"'</td>");
  					    sBuffer.append("<td width='12%' class='multiControl'>'"+strItemName+"'</td>");
	  					sBuffer.append("<td width='12%' class='multiControl'>'"+strBrandName+"'</td>");
	  					sBuffer.append("<td width='20%' class='multiControl'>'"+strItemName+"'</td>");
	  					sBuffer.append("</tr>");
	  					 					
	  				}
				                  
	     }else {
			    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td colspan='7'  CLASS='multiControl' >"
						+ "<div class='errMsg' align='center'> NO  DETAILS FOUND </div>" + "</td>");

			    sBuffer.append("</tr>");
			    sBuffer.append("</table>");
		   } 
		 }
		 catch(Exception e)
		 {
			 new HisException("Issue To Employee Transaction","IssueToEmployeeTransHLP.getOnLineItemDetails()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}
	public static String getEmpDetails(WebRowSet ws)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		try {
			if(ws.size() != 0)
			{ 
			while(ws.next())
				{	
				    String strDeptDesigCode = ws.getString(1);
					String strAgeAndSex     = ws.getString(2);
					String strEmpName   = ws.getString(3);
					String strDeptName      = ws.getString(4);
					String strDesignation   = ws.getString(5);
									
					if(strAgeAndSex == null) strAgeAndSex = "";
					if(strEmpName == null) strEmpName = "";
					if(strDeptName == null) strDeptName = "";
					if(strDesignation == null) strDesignation = "";
					
					 sBuffer.append("<table class='TABLEWIDTH' border='0' cellspacing='1px' align='center' ><tr><td width='25%' class='LABEL'>Name</td>");
					 sBuffer.append("<input type='hidden' name='strCategoryCode' value='"+strDeptDesigCode+"'></td>");
					 sBuffer.append("<td colspan='3' width='25%' class='CONTROL'> ");
					 sBuffer.append(strEmpName);
					 sBuffer.append("</td></tr>");
					 sBuffer.append("<tr><td width='25%' class='LABEL'>Age/Gender</td>");
					 sBuffer.append("<td width='25%' class='CONTROL'>");
					 sBuffer.append(strAgeAndSex);
					 sBuffer.append("<td width='25%' class='LABEL'>Designation</td>");
					 sBuffer.append("<td width='25%' class='CONTROL'>");
					 sBuffer.append(strDesignation);
					 sBuffer.append("</td></tr>");
					 sBuffer.append("<tr><td width='25%' class='LABEL'>Dept Name</td>");
					 sBuffer.append("<td width='25%' class='CONTROL'>");
					 sBuffer.append(strDeptName);
					 sBuffer.append("<td width='25%' class='LABEL'></td>");
					 sBuffer.append("<td width='25%' class='CONTROL'></td>");
					 sBuffer.append("</tr>");
					 sBuffer.append("</table>");
		               
			    }
            }
			else 
			{
		    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
		    sBuffer.append("<tr>");
		    sBuffer.append("<td colspan='7'  CLASS='multiControl' >"
					+ "<div class='errMsg' align='center'> NO DETAILS FOUND FOR SELECTED EMP NO. </div>" + "</td>");

		    sBuffer.append("</tr>");
		    sBuffer.append("</table>");
	   } 
	 }
	 catch(Exception e)
	 {
		 new HisException("Issue To Employee Transaction","IssueToEmployeeTransHLP.getEmpDetails()-->",e.getMessage());
     }
    return sBuffer.toString();
 	}

	
	
	public static String getPreviousIssueDetails(WebRowSet wb)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		 try {
			if(wb.size() != 0)
			{ 
				    
				while(wb.next())
				{		     
	                   	String strItemName = wb.getString(1);
	  					String strBrandName = wb.getString(2);
	  					String strRateUnit = wb.getString(3);
	  					String strTax = wb.getString(1);
	  					String strReqQty = wb.getString(2);
	  					String strSuppliedQty = wb.getString(3);
	  					
	  					if(strItemName == null || strItemName.equals("null") || strItemName.equals(""))strItemName = "---";
	  					if(strBrandName == null || strBrandName.equals("null") || strBrandName.equals("") )strBrandName = "---";
	  					if(strRateUnit == null || strRateUnit.equals("null") || strRateUnit.equals(""))strRateUnit = "---";
	  					if(strTax == null || strTax.equals("null") || strTax.equals(""))strTax = "---";
	  					if(strReqQty == null || strReqQty.equals("null") || strReqQty.equals(""))strReqQty = "---";
	  					if(strSuppliedQty == null || strSuppliedQty.equals("null") || strSuppliedQty.equals(""))strSuppliedQty = "---";
	  				
	  					sBuffer.append("<table class='TABLEWIDTH' align='center'>");
						sBuffer.append("<tr><td width='25%' class='LABEL'>Issue No:</td>");
						sBuffer.append("<td width='25%' class='CONTROL' name='strClientName'> ");
						sBuffer.append(strItemName);
						sBuffer.append("</td>");
						sBuffer.append("<td width='25%' class='LABEL'>Issue Date:</td>");
						sBuffer.append("<td width='25%' class='CONTROL' name='strClientType'>");
						sBuffer.append(strBrandName);
						sBuffer.append("</td>");
						sBuffer.append("</tr>");
		
						sBuffer.append("<tr><td width='25%' class='LABEL'>Prescribed By:</td>");
						sBuffer.append("<td width='25%' class='CONTROL' name='strCltAppSancAmt'> ");
						sBuffer.append(strBrandName);
						sBuffer.append("</td>");
						sBuffer.append("<td width='25%' class='LABEL'>Prescription Date:</td>");
						sBuffer.append("<td width='25%' class='CONTROL' name='strApplNoDate'>");
						sBuffer.append(strBrandName);
						sBuffer.append("</td>");
						sBuffer.append("</tr>");
						sBuffer.append("</table>");
						
						 sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");       
						 		 
						 sBuffer.append("<tr><td width='19%' class='multiLabel'><div align='center'>Item Name</div></td>");  
			  	         sBuffer.append("<td width='19%' class='multiLabel'><div align='center'>Brand Name</div></td>");
			  	         sBuffer.append("<td width='16%' class='multiLabel'><div align='center'>Batch No/Sl No</div></td>");
			  	         sBuffer.append("<td width='16%' class='multiLabel'><div align='center'>Expiry Date</div></td>");
			             sBuffer.append("<td width='15%' class='multiLabel'><div align='center'>Issue Qty</div></td>");
			             sBuffer.append("</tr>");
						
			  					sBuffer.append("<tr>");
			  				    sBuffer.append("<td width='19%' class='multiControl'>" + strItemName + "</td>");
		     					sBuffer.append("<td width='19%' class='multiControl'><select name='strBillType' class='comboMin'><option value='1'>Consolidated</option><option value='2'>Detailed</option></select></td>");
		    					sBuffer.append("<td width='16%' class='multiControl'>" + strItemName + "</td>");
			  					sBuffer.append("<td width='16%' class='multiControl'></td>");
			  					sBuffer.append("<td width='15%' class='multiControl'><input type='text' class='txtFldMin' name='flagConfig'  value='"+0+"'></td>");
			  					sBuffer.append("</tr>");
			  				    sBuffer.append("</table>");
						    				               
				    }
	            }
				else 
				{
			    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td colspan='7'  CLASS='multiControl' >"
						+ "<div class='errMsg' align='center'> NO  DETAILS FOUND  </div>" + "</td>");

			    sBuffer.append("</tr>");
			    sBuffer.append("</table>");
		   } 
		 }
		 catch(Exception e)
		 {
			  new HisException("Issue To Employee Transaction","IssueToEmployeeTransHLP.getPreviousIssueDetails()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}
	
	
	
	
	

}
