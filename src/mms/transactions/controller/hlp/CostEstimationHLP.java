package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import mms.MmsConfigUtil;

public class CostEstimationHLP 
{
	
	/**
	 * Gets the issue dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the issue dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String printCostEstimation(String strHiddenValue,String strTotalCost,String strHospitalCode) throws Exception 
	{
		StringBuffer sb = new StringBuffer("");
		
		String strResponse[] = null;		
 		String strTableWidth = "700";
 		
 		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(strHospitalCode);	
		NumberFormat formatter = new DecimalFormat("############.##");  
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		HisUtil util = null;
		int j=1;
		String totAmtStr = "";
		try 
		{
			util = new HisUtil("","");
            sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td align='center'><div><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr>");
			//sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");			
			sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr>");			
			sb.append("<tr>");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append("Cost Estimation Sheet");
			sb.append("</font></b></td><td width='10%'>&nbsp;</td> ");
			sb.append("</tr>");	
			sb.append("<tr>");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
			sb.append("As On");
			sb.append("</font></b><b>");
			sb.append(util.getASDate("dd-MMM-yyyy H:mm:ss"));
			sb.append("<b></td> ");
			sb.append("</tr>");
			sb.append("</table> ");		
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='hideTransferPopup();' /></div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
		
			sb.append("<table width='").append(strTableWidth).append("' align='center' border='0px' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr>");				
		    sb.append("<td colspan='5' align='right'><hr size='2'></td>");
			sb.append("</tr>");
			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");								
			sb.append("<td align='center' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
			sb.append("</td>");					
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Req Qty</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Approx Cost</b></font> ");
			sb.append("</td> ");					
			sb.append("</tr> ");
			sb.append("<tr>");				
			sb.append("<td colspan='5' align='right'><hr size='2'></td>");			
			sb.append("</tr>");
			
			    strResponse = strHiddenValue.replace("$$$$", "#").split("#");
			    for (int i = 0; i < strResponse.length; i++) 
				{
			    	 //    Drug Name                  #            Rate                  ""  Unit Name            #     Quantity      #      Cost          
			    	
					
					sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(j);
					sb.append("</b></font></td> ");
					sb.append("<td style=\"text-align:left;\" width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strResponse[i].split("\\^")[0].replace("0/0", "%"));
					sb.append("</font></td> ");
					sb.append("<td  style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strResponse[i].split("\\^")[1]);
					sb.append("</font></td> ");
					sb.append("<td  style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strResponse[i].split("\\^")[2]);
					sb.append("</font></td> ");
					sb.append("<td  style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strResponse[i].split("\\^")[3]);
					sb.append("</font></td> ");
					j++;
				}	
			    sb.append("<tr>");				
				sb.append("<td colspan='5' align='right'><hr size='2'></td>");
				//sb.append("<td colspan='2' align='center'><hr size='2' width='50%'></td>");
				sb.append("</tr>");
			    sb.append("<tr>");
				sb.append("<td colspan='3' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Approx Cost(Rs.)</b></font></td>");
				sb.append("<td colspan='2' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(strTotalCost);				
				sb.append("</font></td>");
				
				totAmtStr = "(" + util.getAmountStr(strTotalCost)+ ")";
				sb.append("<tr>");
				sb.append("<td  colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>&nbsp;</font></td>");
				sb.append("<td  colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + totAmtStr + "</strong></font></td>");
				sb.append("</tr>");			
				sb.append("</table> ");

		} 
		catch (Exception e) 
		{

			e.printStackTrace();

			throw e;
		}

		return sb.toString();

		
	}

}
