package mms.transactions.controller.hlp;


import javax.sql.rowset.WebRowSet;

public class LotsDtlHlpView {
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
	             sBuffer.append("</table>");
	             sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='#6097BC'>"); 
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
			 
			 
				throw new Exception("LotsDtlHlpView.getItemDtl"+e.getMessage());
		 
	     }
	    return sBuffer.toString();
	 	}


	
}
