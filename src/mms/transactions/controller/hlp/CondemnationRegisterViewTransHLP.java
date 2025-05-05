package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

public class CondemnationRegisterViewTransHLP {
	
	public static String getRequestDetails(WebRowSet wb)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		 try {
			if(wb != null && wb.size() > 0)
			{ 
			
				 sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black'>");       
	            
				 sBuffer.append("<tr>");
				 
				 sBuffer.append("<td width='30%' class='multiLabel'><div align='center'>Request No</div></td>");  
	  	         sBuffer.append("<td width='35%' class='multiLabel'><div align='center'>RequestDate</div></td>");
	  	         sBuffer.append("<td width='35%' class='multiLabel'><div align='center'>Raising Store</div></td>");
	            
	             sBuffer.append("</tr>");
	             wb.beforeFirst();
				while(wb.next())
				{
						String strRequestNo = wb.getString(1);
	  					String strRequestDate = wb.getString(2);
	  					String strRaisingStore = wb.getString(3);
	  					
	  					if(strRequestNo == null || strRequestNo.equals("null") || strRequestNo.equals(""))strRequestNo = "---";
	  					if(strRequestDate == null || strRequestDate.equals("null") || strRequestDate.equals("") )strRequestDate = "---";
	  					if(strRaisingStore == null || strRaisingStore.equals("null") || strRaisingStore.equals(""))strRaisingStore = "---";
	  				
	  					sBuffer.append("<tr>");
	  					
	  					sBuffer.append("<td width='30%' class='multiControl'>"+strRequestNo+"</td>");
	  					sBuffer.append("<td width='35%' class='multiControl'>"+strRequestDate+"</td>");
	  					sBuffer.append("<td width='35%' class='multiControl'>"+strRaisingStore+"</td>");
	  					
	  					sBuffer.append("</tr>");	
	  				}
                sBuffer.append("</table>");
             
                
	     }else {
			    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td class='multiControl'><div class='errMsg' align='center'> NO REQUEST DETAILS FOUND </div></td>");
			    sBuffer.append("</tr>");
			    sBuffer.append("</table>");
			  
		   } 
		 }
		 catch(Exception e)
		 {
		 
			throw new HisException("Condemnation Register Transaction","CondemnationRegisterViewTransHLP.getRequestDetails()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}


	public static String getItemDetails(WebRowSet ws)
	{
		WebRowSet wb=null;
		StringBuffer buff=null;
		int count=0;
		double itemCost=0;
		
		try
		{
			wb=ws;
			buff=new StringBuffer();
			
			if(wb!=null)
			{
				buff.append("<div><table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				buff.append("<tr>");
				buff.append("<td class='multiLabel'>Item Name</td>");
				buff.append("<td class='multiLabel'>Sanction Qty</td>");
				buff.append("<td class='multiLabel' >Item cost (Rs.)</td>");
				buff.append("</tr>");
				if(wb.size()!=0)
				{
					while(wb.next()){
						buff.append("<tr>");
						buff.append("<td class='multiControl'><a  onclick='openSpecification(this,"+(++count)+");' style='color:blue; cursor:pointer;' title='Click Here To View Item Detail' >"+wb.getString(1)+"</a>");
						buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl"+count+"' value='"+wb.getString(1)+"@"+wb.getString(5)+"@"+wb.getString(12)+"@"+wb.getString(7)+"@"+wb.getString(9)+" "+wb.getString(11)+"@"+wb.getString(6)+"' >"
						+"<input type='hidden' name='strItemDtlHidden' value='"+wb.getString(2)+"@"+wb.getString(3)+"@"+wb.getString(4)+"@"+wb.getString(13)+"' >");
						buff.append("</td>");
						buff.append("<td class='multiControl'>"+wb.getString(4)+" "+wb.getString(11)+"</td>");
						
						buff.append("<td class='multiControl'>"+HisUtil.getAmountWithDecimal(wb.getString(8), 2)+"</td>");
						buff.append("</tr>");
						itemCost+=Double.parseDouble(wb.getString(8));
						
					}
					buff.append("<tr>");
					buff.append("<td bgcolor='black' colspan='3'></td></tr>");
					buff.append("<tr>");
					buff.append("<td class='multiControl' width='33.33%'></td><td class='multiControl' width='33.33%'>Net Cost</td><td class='multiControl'><font color='red'><b>Rs. "+HisUtil.getAmountWithDecimal(itemCost, 2)
							+"<input type='hidden' name='strItemNetCost' value='"+HisUtil.getAmountWithDecimal(itemCost, 2)+"'/></font></b></td></tr>");
					buff.append("<tr>");
					buff.append("<td bgcolor='black' colspan='3'></td>");
					buff.append("</tr>");
									
					
				}
				else
				{
					buff.append("<tr>");
					buff.append("<td class='multiControl' colspan='5'><font color='red'>No Record Found</font></td>");
					buff.append("</tr>");
				}
				buff.append("</table></div>");
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return buff.toString();
	}
	
	/**
	 * This function is used to fetch requested item Detail For lot Process
	 * @param wb
	 * @return
	 */
	public static String getItemDtl(WebRowSet wb) throws Exception
	 {
		StringBuffer sBuffer = new StringBuffer("");
		int count=0;
		 try {
			if(wb != null && wb.size() > 0)
			{ 
			
				 sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black'>");       
	            
				 sBuffer.append("<tr>");
				 
				 sBuffer.append("<td width='30%' class='multiLabel'><div align='center'>Generic Item Name</div></td>");  
	  	         sBuffer.append("<td width='35%' class='multiLabel'><div align='center'>Item Name</div></td>");
	  	         sBuffer.append("<td width='35%' class='multiLabel'><div align='center'>Complied Qty.</div></td>");
	            
	             sBuffer.append("</tr>");
	             wb.beforeFirst();
				while(wb.next())
				{
						sBuffer.append("<tr>");
	  					sBuffer.append("<td width='30%' class='multiControl'>"+wb.getString(1)+"</td>");
	  					sBuffer.append("<td class='multiControl'><a  onclick='openSpecification(this,"+(++count)+");' style='color:blue; cursor:pointer;' title='Click Here To View Item Detail' >"+wb.getString(2)+"</a>");
	  					sBuffer.append("<input type='hidden' name='strItemDtl' id='strItemDtl"+count+"' value='"+wb.getString(9)+"@"+wb.getString(10)+"@"+wb.getString(11)+"@"+wb.getString(12)+"@"+wb.getString(13)+"@"+wb.getString(2)+"'>");
	  					sBuffer.append("</td>");
						
	  					sBuffer.append("<td width='35%' class='multiControl'>"+wb.getString(7)+" "+wb.getString(8)+"</td>");
	  					
	  					sBuffer.append("</tr>");	
	  				}
                sBuffer.append("</table>");
             
                
	     }else {
			    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td class='multiControl'><div class='errMsg' align='center'> NO Record Found</div></td>");
			    sBuffer.append("</tr>");
			    sBuffer.append("</table>");
			  
		   } 
		 }
		 catch(Exception e)
		 {
			 
			 
				throw new Exception("CondemnationRegisterViewTransHLP.getItemDtl"+e.getMessage());
		 
	     }
	    return sBuffer.toString();
	 	}

}
