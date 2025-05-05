package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;
import javax.sql.rowset.WebRowSet;
import mms.transactions.controller.fb.CondemnationRegisterTransFB;




public class CondemnRegisterTransHLP {
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
	
	public static String getRequestDetails(WebRowSet ws)
	{
		WebRowSet wb=null;
		StringBuffer buff=null;
		
		try
		{
			wb=ws;
			buff=new StringBuffer();
			if(wb!=null)
			{
				buff.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black'>");
				buff.append("<tr>");
				buff.append("<td class='multiLabel'>Request No</td>");
				buff.append("<td class='multiLabel'>Request Date</td>");
				buff.append("<td class='multiLabel'>Raising Store</td>");
				if(wb.size()!=0)
				{
					while(ws.next()){
						buff.append("<tr>");
						buff.append("<td class='multiControl'>"+ws.getString(1)+"</td>");
						buff.append("<td class='multiControl'>"+ws.getString(2)+"</td>");
						buff.append("<td class='multiControl'>"+ws.getString(3)+"</td>");
						buff.append("</tr>");
					}
				}
				else
				{
					buff.append("<tr>");
					buff.append("<td class='multiControl' colspan='5'><font color='red'>No Record Found</font></td>");
					buff.append("</tr>");
				}
				buff.append("</table>");
			}
			else
			{
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return buff.toString();
	}

	public static String createMemberDetails(CondemnationRegisterTransFB _CondemnationRegisterTransFB)
	{ 
		StringBuffer br = new StringBuffer();
		WebRowSet wb1=null;
		int count=0;
			try{
				wb1=_CondemnationRegisterTransFB.getCommitteMemberWS();
				br.append("<table width='400'>\n");
				br.append("<tr class='HEADER'>\n");
				br.append("<td colspan='2'>Committee Member Details</td>");
				br.append("</tr>\n");
				br.append("<tr>\n");
				br.append("<td class='multiLabel'>\n");
				br.append("Committe Member Name");
				br.append("</td>");
				br.append("<td class='multiLabel'>\n");
				br.append("Recommendation");
				br.append("</td>");
				br.append("</tr>\n");
				
				//System.out.println("size of Webrowsswt"+wb1.size());
				if(wb1!=null && wb1.size()!=0){
					
					
					while(wb1.next())
					{
						br.append("<tr>\n");
						br.append("<td class='multiControl'>\n");
						br.append("<input type='hidden' name='strCommitteeMemberHidden' value='"+wb1.getString(1)+"' id='strCommitteeMemberHiddenId="+(++count)+"'/>");
						br.append(wb1.getString(2)+"</td>");
						br.append("<td class='multiControl'>\n");
						br.append("<textarea rows='2' cols='15' name='strMemberRecommendation'></textarea>");
						br.append("</td>");
						br.append("</tr>\n");
					}
				}
				else
				{
					br.append("<tr>\n");
					br.append("<td class='multiControl' colspan='2'>\n");
					br.append("No Record Found");
					br.append("</tr>\n");
				}
				
				br.append("<tr class='FOOTER'>");
				br.append("<td colspan='2' align ='center'></td>");
				br.append("</tr>");
				br.append("<tr>\n");
				br.append("<td  colspan='2' align='center'>\n");
				br.append("<img src='../../hisglobal/images/btn-ok.png' 	onClick='closePopUpDiv();' style='cursor: pointer;' title='Click Here To Save Remarks'>&nbsp;");
				br.append("<img src='../../hisglobal/images/btn-clr.png' onClick='clearData();' style='cursor: pointer;' title='Click Here To Clear Data'>&nbsp;");
				br.append("<img src='../../hisglobal/images/close_tab.png' onClick='closePopUpDiv();' style='cursor: pointer;' title='Click Here To Close Popup'>");
				br.append("</td></tr>\n");
				br.append("</table>");
		
		}catch(Exception e){
			try{
				throw new Exception(e.getMessage());
			}
			catch(Exception e1)
			{}
		}
		finally
		{
			wb1=null;
			
		}
	return br.toString();
	}

}
