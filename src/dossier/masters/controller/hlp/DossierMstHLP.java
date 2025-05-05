package dossier.masters.controller.hlp;

import ipd.IpdConfigUtil;

import java.util.ResourceBundle;

import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import dossier.masters.vo.*;

public class DossierMstHLP {

	/*
	 * Function to get department details for view
	 * 
	 * 
	 * 
	 */
	public static String getDeptNamesForView(DossierMstVO vo)
	{
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws=vo.getDeptDetailWS();

		int size=4;
		int count=1;
		int i=1;
		System.out.println("Web row set size --->>> "+ws.size());
		try
		{
			sb.append("<table class='TABLEWIDTH' cellspacing='1px' cellpadding='0px' align='center'>");
			sb.append("<tbody>");
			
			
			
				if(ws.size()>0){
					while(ws.next()){
						sb.append("<td colspan='2' class='LABEL' width='45%'>"+count+".</td>");
						sb.append("<td colspan='2' class='CONTROL' width='45%'>");
						sb.append("<div id='strDepartmentNameId"+count+"'>");
						sb.append(ws.getString(1));
						sb.append("</div>");
						sb.append("</td>");
						sb.append("</tr>");
								
						count++;

					}
										
				}
				else{
					sb.append("<tr>");
					sb.append("<td class='LABEL' style='color:red;text-align:center;'>No Record Found.</td>");
					sb.append("</tr>");
					
				}
				ws.beforeFirst();	
				
				sb.append("</tbody></table>");
				
		}
		
		catch(Exception e)
		{
			
			vo.setStrMsgString("DossierItemMstHLP.getDeptNamesForView() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

}

