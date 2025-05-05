package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

public class HelpDeskTransHLP {
	
	 public static String getAcknowledgeDetails(WebRowSet ws)
	    {
		 int count = 0;
			int start = 1;
			StringBuffer sb = new StringBuffer("");
			//System.out.println("HLPWS: "+ws);
			try {
				
				if(ws != null && ws.size() > 0)
				{ 
					if (ws.next()) 
					{
											
						String strStoreName         = ws.getString(2);
						String strTransNo           = ws.getString(1);
						String strTransDate         = ws.getString(5);
						String strMenuName          = ws.getString(3);
						String strStatus            = ws.getString(4);
						String strProbSub           = ws.getString(6);
						
						String strProbDesc = ws.getString(7);
						String strPriority = ws.getString(8);
						String strSolution = ws.getString(9);
						String strSolutionDate = ws.getString(10);
						String strSubmitBy = ws.getString(11);
						String strRemarks = ws.getString(13);
						String solSubmitBy = ws.getString(14);
						String dept = ws.getString(15);
						String storeId=ws.getString(12);
						String strFileName=ws.getString(16);
						
						String strHidVal = strFileName;
						
						if (strStoreName == null)
							strStoreName = "----";
						if (strTransNo == null)
							strTransNo = "----";
						if (strTransDate == null)
							strTransDate = "----";
						if (strMenuName == null)
							strMenuName = "----";
						if (strStatus == null)
							strStatus = "----";
						if (strProbSub == null)
							strProbSub = "----";
						if (strSolution == null)
							strSolution = "----";
						if (strSolutionDate == null)
							strSolutionDate = "----";
						if (strRemarks == null)
							strRemarks = "----";
						if (solSubmitBy == null)
							solSubmitBy = "----";
						
						if (dept == null)
							dept = "----";
						
						sb.append("<input type='hidden' name = 'strHidVal' id ='strHidVal"+strHidVal+"'  value='"+strHidVal+"'>");
						
						sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
						sb.append("<tr><td width='25%' class='LABEL'>Store Name</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strStoreName);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Issue Regarding</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(dept);
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Issue No</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strTransNo);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Issue Raised Date</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strTransDate);
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Menu Name</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strMenuName);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Status</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strStatus);
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Issue Subject</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strProbSub);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Issue Description</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strProbDesc);
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Solution</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strSolution);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Solution Date</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strSolutionDate);
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Solution Given By</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(solSubmitBy);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Remarks</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strRemarks);
						sb.append("</td></tr>");
						
						if(strFileName!=null)
						{
						sb.append("<tr><td width='25%' class='LABEL'>DownloadFile</td>");
					sb.append("<td style=\"text-align:left;\"  class='multiControl' width='25%'>");
						sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strDmnld' id='strDmnld"+strHidVal+"' onClick='downloadfile(\""+strHidVal+"\")'>"+"Download"+"</a> &nbsp;");
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'></td>");
						sb.append("<td width='25%' class='CONTROL'></td></tr>");
						
						}
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
				 
				throw new HisException("HelpDesk Transaction","HelpDeskTransHLP.getAcknowledgeDetails()-->",e.getMessage());
			}
		return sb.toString();
		}
	
	
	/* public static String gettransno(WebRowSet ws)
	    { 
		 String strTransNo="";
		 try
		 {
		 
				if(ws != null && ws.size() > 0)
				{ 
					
					
						 strTransNo           = ws.getString(2);
						 System.out.println("trans no hlp "+ws.getString(2));
					}
				if(ws .equals(null))	
				{
					System.out.println("null entered");
				}
					
	    
		 }
catch(Exception e){
	throw new HisException("HelpDesk Transaction","HelpDeskTransHLP.gettransno()-->",e.getMessage());
}
return strTransNo;
}
*/
}
