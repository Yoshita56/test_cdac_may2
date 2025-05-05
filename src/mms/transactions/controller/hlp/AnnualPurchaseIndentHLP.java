package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import mms.transactions.controller.fb.AnnualPurchaseIndentFB;
import mms.transactions.vo.AnnualPurchaseIndentVO;

public class AnnualPurchaseIndentHLP 
{

	
	public static String getNotIssueItemList(AnnualPurchaseIndentFB formBean,AnnualPurchaseIndentVO vo)throws Exception
	{
			
			StringBuffer sb = new StringBuffer("");
	
			WebRowSet ws = null;
			
			int count = 0,i=1;
			try
			{
			
			
				
			sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb.append("<td colspan='6' class='multiLabel' width='25%' style=\"text-align:left;\">Not Issue Item Detail(s)");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px' bgcolor='black'> ");
			sb.append("<tr>");
			sb.append("<td class='multiLabel' width='5%'>#</td> ");
			sb.append("<td class='multiLabel' width='25%'>Item Name</td> ");
			sb.append("<td class='multiLabel' width='8%'>Indent Qty(No)</td> ");
			sb.append("<td class='multiLabel' width='14%'>To Store</td>");
			sb.append("<td class='multiLabel' width='17%'>Indent Dtls</td>");
			sb.append("<td class='multiLabel' width='17%'>Issue  Dtls</td> ");			
			sb.append("</tr> ");
			
			sb.append("</table> ");
			sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px' bgcolor='#1277b5'> ");
			ws = vo.getNaDrugsDetailsWs();
			
			
			if(ws != null && ws.size() > 0)
			{
				
				while(ws.next())
				{
					
					count = count + 1;
					/*
					 * 1.From Store Name
					 * 2.To Store Name
					 * 3.Drug Name
					 * 4.Req Date
					 * 5.Indent Qty
					 * 6.A.HSTNUM_REQ_NO||'#'||TO_CHAR(A.HSTDT_REQ_DATE, 'dd/Mon/yyyy')||'#'||HSTNUM_ISSUE_NO||'#'||TO_CHAR(HSTDT_ISSUE_DATE, 'dd/Mon/yyyy')||'#'||A.HSTNUM_STORE_ID||'#'||A.HSTNUM_TOSTORE_ID
					 * 7.Indent Date
					 * */
					String strHidden         = ws.getString(6).split("\\#")[0]+"#"+ws.getString(6).split("\\#")[2]+"#"+ws.getString(6).split("\\#")[4]+"#"+ws.getString(6).split("\\#")[5];
					String strItemName       = ws.getString(3);					
					String strOrdQty         = ws.getString(5);
					String strFromStore      = ws.getString(1);
					String strToStore        = ws.getString(2);
					String strIndentNoDate   = ws.getString(6).split("\\#")[0]+" - "+ws.getString(6).split("\\#")[1];
					String strIssueNoDate    = ws.getString(6).split("\\#")[2]+" - "+ws.getString(6).split("\\#")[3];
				
					sb.append("<tr> ");					
					sb.append("<td CLASS='multiControl' width='5%'>"+i+ "<input type='hidden' value='"+strHidden+"' name='naDrugPK' id='naDrugPK"+count+"'></td>");
					sb.append("<td CLASS='multiControl' style=\"text-align:left;\"  width='25%'>"+strItemName+ "</td>");
					sb.append("<td CLASS='multiControl' width='8%'>"+strOrdQty+ "</td>");
					sb.append("<td CLASS='multiControl' width='14%'>"+strToStore+ "</td>");
					sb.append("<td CLASS='multiControl' width='17%'>"+strIndentNoDate + "</td>");
					sb.append("<td CLASS='multiControl' width='17%'>"+strIssueNoDate+ "</td>");
					sb.append("</tr> ");
					
					i++;
					
					
				}
				
			}else{
				
				sb.append("<tr> ");		 
				sb.append("<td colspan='6' class='multiControl' width='25%'><font color='red'>No Not Issue Drug(s) Record Available </font> ");
				sb.append("</td> ");
				sb.append("</tr> ");
				
			}		
			
			sb.append("</table> ");
			
			}catch (Exception e) {
				
				throw e;
				
			}finally{
				
			}
			
			return sb.toString();
		}
}
