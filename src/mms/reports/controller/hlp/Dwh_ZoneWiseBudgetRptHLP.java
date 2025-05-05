package mms.reports.controller.hlp;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.Dwh_ZoneWiseBudgetRptVO;
public class Dwh_ZoneWiseBudgetRptHLP {
	
	public static String getZoneWiseBudgetPopUp1(Dwh_ZoneWiseBudgetRptVO vo) throws Exception 
	{
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		StringBuffer br = new StringBuffer();
		StringBuffer br1 = new StringBuffer();
		
		int count = 0;
		int count1 = 0;
		
		String DDWNAme="";
		//String amtStr = "";
		//String strPODate = "";
		String StrZone = "";
		String StrPmo = "";
		String StrMC = "";
		String MCDDWNAME = "";
		String MCPMO = "";
		
		double CMHOBud = 0.0;
		double PMOBUD = 0.0;
		double MCBUD = 0.0;
		double TOTBUD = 0.0;
		
		
		double CMHOBudgrptot = 0.0;
		double PMOBudgrptot = 0.0;
		double MCBudgrptot = 0.0;
		double TOTBudgrptot = 0.0;
		
		
		double CMHOBudgrandtot = 0.0;
		double PMOBudgrandtot = 0.0;
		double MCBudgrandtot = 0.0;
		double TOTBudgrandtot = 0.0;
		
		WebRowSet ws =null;
		hisglobal.utility.HisUtil util = null;
				
		//NumberFormat formatter = new DecimalFormat("############.##"); 
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		
		
		String rptType = "0";
		
		try
	    {
			util = new hisglobal.utility.HisUtil("DWH","Dwh_ZoneWiseBudgetRptHLP");
			
			ws  = vo.getStrScreentTwoWs();
			rptType = vo.getStrReportId();
			
			br.append("<HTML><HEAD><link href=\"../css/transaction.css\" rel=\"stylesheet\" type=\"text/css\">");
			br.append("<style type=\"text/css\">");
			br.append(".Btop {border-top:thin solid; border-color:black;}");
			br.append(".Bbottom { border-bottom:thin solid;border-color:black;}");
			br.append(".Bleft { border-left:thin solid;border-color:black;}");
			br.append(".Bright { border-right:thin solid;border-color:black;}");
			br.append("</style>");
			br.append("<script language='Javascript' src='../../mms/js/Dwh_ZoneWiseBudgetRpt.js'></script><body><form><table align='center' width='1150' border='0' cellspacing='0' cellpadding='0''> ");
			br.append("<tr>");
//			br.append("<td width='10%'><div  align='right'><img width='46px' height='39px' src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");
			br.append("<td width='10%'><div  align='right'><img width='46px' height='39px' src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
			br.append("<td width='80%' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			br.append(res.getString("REPORT_TITLE"));
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("</table> ");
						
			br.append("<table align='center' width='1150' border='0' cellspacing='0' cellpadding='0'> ");
			br.append("<tr><td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
			br.append("Zone Wise Budget Detail Report");			
			br.append("</font></b></td><td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
			br.append("For Financial Year: "+vo.getStrFromDate()+" - "+vo.getStrToDate());
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("</table> ");		
						
			br.append("<table border='0' width='1150' align='center'> ");
			br.append("<tr> ");
			br.append("<td align='right'>");
			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			br.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
			br.append(" </td> ");
			br.append(" </tr> ");
			br.append(" </table> ");
			
			
			//header
			br.append("<table width='1150' align='center' cellspacing='0px' cellpadding='0px'>");
		 	
			if (ws != null) 
			{
				if(ws.size() != 0)
				{
					while(ws.next())
					{
						
						
						
						if(count==0)
	    				{
							StrZone = ws.getString(1).trim();
							DDWNAme = ws.getString(2).trim();
							StrPmo = ws.getString(4).trim();
							//StrMC = ws.getString(6).trim();
							CMHOBud = Double.parseDouble(ws.getString(3));
							PMOBUD = Double.parseDouble(ws.getString(5));
							//MCBUD = Double.parseDouble(ws.getString(7));
							TOTBUD = Double.parseDouble(ws.getString(8));
							
							CMHOBudgrptot += CMHOBud;
							PMOBudgrptot += PMOBUD;
							//MCBudgrptot += MCBUD;
							TOTBudgrptot += TOTBUD;
							
	    					br1.append("<tr bgcolor = '#FCD59C'><td class = 'Bleft Bright' align = 'center' colspan=7>");
							br1.append("<font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + StrZone + "</b></font>");
							br1.append("</td></tr>");
							
							br1.append("<tr> ");
    						br1.append("<td class = 'Btop  Bleft Bright' style=\"text-align: center;\" valign = 'middle' colspan='1'  width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + DDWNAme+ "</b></font></td>\n");
        					br1.append("<td class = 'Btop Bright' style=\"text-align: right;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(CMHOBud) + "</font></td>\n");
        					br1.append("<td class = 'Btop Bright' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + StrPmo + "</font></td>\n");
        					
        					br1.append("<td class = 'Btop Bright' style=\"text-align: right;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(PMOBUD) + "</font></td>\n");
        					br1.append("<td class = 'Btop Bright' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Btop  Bright' style=\"text-align: right;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Btop  Bright' style=\"text-align: right;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(TOTBUD) + "</font></td>");
        					
        					br1.append("</tr>");
        					
        					/*
        					if(!StrMC.equalsIgnoreCase(ws.getString(6).trim()) && DDWNAme.equalsIgnoreCase(ws.getString(2).trim()) && StrPmo.equalsIgnoreCase(ws.getString(4).trim()) )
        					{
        						StrMC = ws.getString(6).trim();
        						br1.append("<tr> ");
        						br1.append("<td style=\"text-align: left;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
            					br1.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
            					br1.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
            					br1.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
            					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + StrMC + "</font></td>\n");
            					//br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandLogoPenCharge) + "</font></td>\n");
            					//br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandBrandPenCharge) + "</font></td>");
            					//br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandMRPPenCharge) + "</font></td>\n");
            					//br1.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandPaymentValue) + "</font></td>\n");
            					br1.append("</tr>");
            					
            					
        					}
        					*/
							
        					count++;
							
	    				}
	    				
	    				
						if(!StrZone.equalsIgnoreCase(ws.getString(1).trim()))
						{
							
							
							br1.append("<tr bgcolor = '#BCD2EE'> ");
							br1.append("<td class = 'Btop Bbottom  Bleft Bright' style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Group Total :</b></font></td>\n");
	    					br1.append("<td class = 'Btop Bbottom  Bright' style=\"text-align: right;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(CMHOBudgrptot) + "</b></font></td>\n");
	    					br1.append("<td class = 'Btop Bbottom  Bright' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>\n");
	    					br1.append("<td class = 'Btop Bbottom  Bright' style=\"text-align: right;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(PMOBudgrptot) + "</b></font></td>\n");
	    					br1.append("<td class = 'Btop Bbottom  Bright' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>\n");
	    					br1.append("<td class = 'Btop Bbottom  Bright' style=\"text-align: right;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(MCBudgrptot) + "</b></font></td>\n");
	    					br1.append("<td class = 'Btop Bbottom  Bright' style=\"text-align: right;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(TOTBudgrptot) + "</b></font></td>");
	    					
	    					br1.append("</tr>");
							
							StrZone = ws.getString(1).trim();
							br1.append("<tr bgcolor = '#FCD59C'><td class = 'Bleft Bright' align = 'center' colspan=7>");
							br1.append("<font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + StrZone + "</b></font>");
							br1.append("</td></tr>");
							
							CMHOBudgrandtot += CMHOBudgrptot;
							PMOBudgrandtot += PMOBudgrptot;
							MCBudgrandtot += MCBudgrptot;
							TOTBudgrandtot += TOTBudgrptot;
							
							
							
							
							CMHOBudgrptot = 0.0;
							PMOBudgrptot = 0.0;
							MCBudgrptot = 0.0;
							TOTBudgrptot = 0.0;
						}
							
						if(!DDWNAme.equalsIgnoreCase(ws.getString(2).trim()))
						{
							
							
							DDWNAme = ws.getString(2).trim();
						
							StrPmo = ws.getString(4).trim();
							MCDDWNAME = DDWNAme;
							MCPMO = StrPmo;
							
							CMHOBud = Double.parseDouble(ws.getString(3));
							PMOBUD = Double.parseDouble(ws.getString(5));
							TOTBUD = Double.parseDouble(ws.getString(8));
							
							//StrMC = ws.getString(6).trim();
							//br1.append("<table border = '1px'>");
							br1.append("<tr> ");
    						br1.append("<td class = 'Btop  Bleft Bright' style=\"text-align: center;\" colspan='1' valign = 'middle' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + DDWNAme+ "</b></font></td>\n");
        					br1.append("<td class = 'Btop  Bright' style=\"text-align: right;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(CMHOBud) + "</font></td>\n");
        					
        					br1.append("<td class = 'Btop Bright' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + StrPmo + "</font></td>\n");
        					
    						
        					br1.append("<td class = 'Btop Bright' style=\"text-align: right;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(PMOBUD) + "</font></td>\n");
        					br1.append("<td class = 'Btop Bright' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Btop Bright' style=\"text-align: left;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Btop Bright' style=\"text-align: right;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(TOTBUD) + "</font></td>\n");
        					
        					br1.append("</tr>");
        					//br1.append("</table>");
        					
        					CMHOBudgrptot += CMHOBud;
        					PMOBudgrptot += PMOBUD;
        					TOTBudgrptot += TOTBUD;
        					 
        					count1 = 0;
						}
						
						
						
							
						
						if(!StrPmo.equalsIgnoreCase(ws.getString(4).trim()))
						{
							StrPmo = ws.getString(4).trim();
							PMOBUD = Double.parseDouble(ws.getString(5));
							br1.append("<tr> ");
    						br1.append("<td class = 'Bleft Bright' style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Bright' style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Btop Bright' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + StrPmo + "</font></td>\n");
        					br1.append("<td class = 'Btop Bright' style=\"text-align: right;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(PMOBUD) + "</font></td>\n");
        					
        						
        					br1.append("<td class = 'Bright' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
    						
        					br1.append("<td class = 'Bright' style=\"text-align: left;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Bright' style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
        					
        					br1.append("</tr>");
        					
        					count1++;
        					PMOBudgrptot += PMOBUD;
        					 
    						
						}
						//if(MCDDWNAME.equalsIgnoreCase(ws.getString(2).trim()))
							//if(MCPMO.equalsIgnoreCase(ws.getString(4).trim()))
							
						if(!StrMC.equalsIgnoreCase(ws.getString(6).trim()) && count1==0)
						{
							
							MCBUD = Double.parseDouble(ws.getString(7));
							
							br1.append("<tr> ");
    						br1.append("<td class = 'Bleft Bright' style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Bright' style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Bright' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Bright' style=\"text-align: left;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Bright Bbottom' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(6).trim() + "</font></td>\n");
        					br1.append("<td class = 'Bright Bbottom' style=\"text-align: right;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(MCBUD) + "</font></td>\n");
        					br1.append("<td class = 'Bright' style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
        					
        					br1.append("</tr>");
        					
        					StrMC = ws.getString(6).trim();
        					MCBudgrptot += MCBUD;
        					 
    						//strPODate = ws.getString(9);
						}
						
						
						
						
				/*
						if(!StrMC.equalsIgnoreCase(ws.getString(6).trim()) && !StrPmo.equalsIgnoreCase(ws.getString(4).trim()))
						{
							
							MCBUD = Double.parseDouble(ws.getString(7));
							
							br1.append("<tr> ");
    						br1.append("<td class = 'Bleft Bright' style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Bright' style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Bright' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Bright' style=\"text-align: left;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>\n");
        					br1.append("<td class = 'Bright Bbottom' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(6).trim() + "</font></td>\n");
        					br1.append("<td class = 'Bright Bbottom' style=\"text-align: right;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(MCBUD) + "</font></td>\n");
        					br1.append("<td class = 'Bright' style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
        					
        					br1.append("</tr>");
        					
        					StrMC = ws.getString(6).trim();
        					MCBudgrptot += MCBUD;
        					 
    						//strPODate = ws.getString(9);
						}
						
    					*/
    		
					} //while loop
					
					//last row (payment detail info)
					if(count > 0)
					{
						//header
    					//br.append("<tr><td colspan='9'>&nbsp;</td></tr>");
    					
    					//br.append("<tr><td colspan='9'><hr></td></tr>");
    					br.append("<tr  bgcolor='#E3A869' > ");
    					br.append("<td class = 'Btop Bbottom Bleft Bright' style=\"text-align: center;\" colspan='1' width='12%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>DDW Name<b></font></td>\n");
    					br.append("<td class = 'Btop Bbottom Bleft Bright' style=\"text-align: center;\" colspan='1' width='10%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>CM&HO Budget<b></font></td>\n");
    					br.append("<td class = 'Btop Bbottom Bleft Bright' style=\"text-align: center;\" colspan='1' width='14%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>Name of PMO<b></font></td>\n");
    					br.append("<td class = 'Btop Bbottom Bleft Bright' style=\"text-align: center;\" colspan='1' width='9%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>PMO Budget<b></font></td>\n");
    					br.append("<td class = 'Btop Bbottom Bleft Bright' style=\"text-align: center;\" colspan='1' width='14%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>Name of Medical Collage<b></font></td>\n");
    					br.append("<td class = 'Btop Bbottom Bleft Bright' style=\"text-align: center;\" colspan='1' width='9%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>Medical Collage Budget<b></font></td>");
    					br.append("<td class = 'Btop Bbottom Bleft Bright' style=\"text-align: center;\" colspan='1' width='10%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Budget Alloted<b></font></td>\n");
    					
    					br.append("</tr>");
    					//br.append("<tr><td colspan='9'><hr></td></tr>");
    					br.append(br1);
    					
    					//last row
    					/*
    					br.append("<tr> ");
						br.append("<td style=\"text-align: left;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + DDWNAme +"</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(CMHOBud) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + StrPmo + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(PMOBUD) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + StrMC + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(MCBUD) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(TOTBUD) + "</font></td>");
    					
    					br.append("</tr>");
    					*/
    					//Zone wise total
    					
    					br.append("<tr bgcolor = '#BCD2EE'> ");
						br.append("<td class = 'Btop Bbottom Bleft Bright' style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Group Total :</b></font></td>\n");
    					br.append("<td class = 'Btop Bbottom Bright' style=\"text-align: right;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(CMHOBudgrptot) + "</b></font></td>\n");
    					br.append("<td class = 'Btop Bbottom Bright' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>\n");
    					br.append("<td class = 'Btop Bbottom Bright' style=\"text-align: right;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(PMOBudgrptot) + "</b></font></td>\n");
    					br.append("<td class = 'Btop Bbottom Bright' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>\n");
    					br.append("<td class = 'Btop Bbottom Bright' style=\"text-align: right;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(MCBudgrptot) + "</b></font></td>\n");
    					br.append("<td class = 'Btop Bbottom Bright' style=\"text-align: right;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(TOTBudgrptot) + "</b></font></td>");
    					
    					br.append("</tr>");
    					
    					
    					CMHOBudgrandtot += CMHOBudgrptot;
    					PMOBudgrandtot += PMOBudgrptot;
						MCBudgrandtot += MCBudgrptot;
						TOTBudgrandtot += TOTBudgrptot;
    					
    					
    					
    					//grand total
    					br.append("<tr bgcolor = '#E3A869'> ");
						br.append("<td class = 'Bbottom Bleft Bright' style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Grand Total :</b></font></td>\n");
    					br.append("<td class = 'Bbottom Bright' style=\"text-align: right;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(CMHOBudgrandtot) + "</b></font></td>\n");
    					br.append("<td class = 'Bbottom Bright' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>\n");
    					br.append("<td class = 'Bbottom Bright' style=\"text-align: right;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(PMOBudgrandtot) + "</b></font></td>\n");
    					br.append("<td class = 'Bbottom Bright' style=\"text-align: left;\" colspan='1' width='14%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>\n");
    					br.append("<td class = 'Bbottom Bright' style=\"text-align: right;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(MCBudgrandtot) + "</b></font></td>\n");
    					br.append("<td class = 'Bbottom Bright' style=\"text-align: right;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(TOTBudgrandtot) + "</b></font></td>");
    					
    					br.append("</tr>");
    					//br.append("<tr><td colspan='9'><hr></td></tr>");
    					
					}
					
					if(ws != null)
					{
						ws.close();
						ws = null;
					}
				} //ws.size <> 0
				else
				{
					br.append("<tr>");
					br.append("<td colspan='7'><b><div id='id' align='center'>No Data Found</div></b></td>");
					br.append("</tr>");
				}
			}
			else
			{
				br.append("<tr>");
				br.append("<td colspan='7'><b><div id='id' align='center'>No Data Found</div></b></td>");
				br.append("</tr>");
			}
		}//try
		catch (Exception e) {	
		    e.printStackTrace();
		    
		    br.append("<tr>");
			br.append("<td colspan='7'><b><div id='id' align='center'>No Data Found</div></b></td>");
			br.append("</tr>");
			br.append("</table>");
			
			if(ws != null)
			{
				ws.close();
				ws = null;
			}
			
			throw new Exception("Dwh_ZoneWiseBudgetRptHLP.getSupplierPerformabceDetailsPopUp1()->"+e.getMessage());
		}
		
		br.append("</table>");
		 	
		return br.toString();	
				
	}

}
