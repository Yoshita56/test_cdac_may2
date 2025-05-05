package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

public class BillApprovalViewTransHLP {
	
	
	public static String getScheduleDtl(WebRowSet wb)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		Double totalCost=0.00;
		 try {
			if(wb!=null)
			{ 
				 sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");       
 	            
				 sBuffer.append("<tr>");
				 
				 sBuffer.append("<td width='18%' class='multiLabel'><div align='center'>Schedule No.</div></td>");  
	  	         sBuffer.append("<td width='18%' class='multiLabel'><div align='center'>Schedule Date</div></td>");
	  	         sBuffer.append("<td width='17%' class='multiLabel'><div align='center'>Schedule Type</div></td>");
	  	         sBuffer.append("<td width='17%' class='multiLabel'><div align='center'>Cost</div></td>");
	             sBuffer.append("</tr>");
				if(wb.size()!=0){
					while(wb.next())
					{
							 String strScheduleNo=wb.getString(1);
							 String strScheduleDate=wb.getString(2);
							 String strScheduleType=wb.getString(3);
							 String strScheduleCost=wb.getString(4);
							 
							 if(strScheduleNo==null ||  strScheduleNo.equals("")){
								 strScheduleNo="---";
							 }
							 if(strScheduleDate==null ||  strScheduleDate.equals("")){
								 strScheduleDate="---";
							 }
							 if(strScheduleType==null ||  strScheduleType.equals("")){
								 strScheduleType="---";
							 }
							 if(strScheduleCost==null ||  strScheduleCost.equals("") || strScheduleCost.equals("0")){
								 strScheduleCost="0.00";
							 }
							 if(!strScheduleCost.equals("0.00"))
								 strScheduleCost=HisUtil.getAmountWithDecimal(strScheduleCost,2);
							 totalCost+=Double.parseDouble(strScheduleCost);
							 
		  					sBuffer.append("<tr>");
		  					
		  					sBuffer.append("<td width='18%' class='multiControl'>"+strScheduleNo+"</td>");
		  					sBuffer.append("<td width='18%' class='multiControl'>"+strScheduleDate+"</td>");
		  					sBuffer.append("<td width='17%' class='multiControl'>"+strScheduleType+"</td>");
		  					sBuffer.append("<td width='17%' class='multiControl'>"+strScheduleCost+"</td>");
		  					sBuffer.append("</tr>");	
		  				}
					sBuffer.append("<tr>");
					sBuffer.append("<td bgcolor='black' colspan='4'></td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td class='multiControl' colspan='3' ><div align='right'><b>TOTAL COST</b></div></td>");
					sBuffer.append("<td class='multiControl' colspan='1'><input type='hidden' name='strFinalCost' value='"+totalCost +"'/>"+
							"<font color='red'><b>Rs."+HisUtil.getAmountWithDecimal(totalCost,2)+"</b></font></td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td bgcolor='black' colspan='4'></td>");
					sBuffer.append("</tr>");
	                  sBuffer.append("</table>");
				}
				else{
					sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
				    sBuffer.append("<tr>");
				    sBuffer.append("<td CLASS='multiControl' colspan='4' >"
							+ "<font color='red'><b>No Record Found</b></font>" + "</td>");

				    sBuffer.append("</tr>");
				    sBuffer.append("</table>");
				}
	               
                  
	     }else {
			    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td CLASS='multiControl' colspan='4' >"
						+ "<div class='errMsg' align='center'><font color='red'>No Record Found</font></div>" + "</td>");

			    sBuffer.append("</tr>");
			    sBuffer.append("</table>");
		   } 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 new HisException("Bill Approval Transaction","BillApprovalViewTransHLP.getScheduleDtl()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}
	
	
	
	
	}
