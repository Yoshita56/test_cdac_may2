/**
 * 
 */
package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.UtilityGenerationTransVO;

/**
 * Developer : Tanvi sappal
 * Version : 1.0
 * Date : 18/Jun/2009
 */
public class UtilityGenerationTransHLP 
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
	public static String getPrintStockDtl(UtilityGenerationTransVO vo, WebRowSet ws) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		String strStoreName = "";
		String batchNo = "0";
		String avlQty = "";
		String expiryDt = "";
		String stockStatus = "";
		String reservedQty = "";
		String blockedQty = "";
		String unitName = "",itemBrandName="";
		String activeQty = "";
		String inActiveQty = "";
		String quarantineQty = "";		
		int i=1;
		int count = 0;	
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
				
 		
		String strTableWidth = "700";
 		DecimalFormat myFormatter = new DecimalFormat("0.00");
 		Double activeQtyTotal=0.00,inActiveQtyTotal=0.00,quarantineQtyTotal=0.00;
		try 
		{
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td align='center'><div><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>");
			sb.append("</tr>");	
			sb.append("</table>");
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			
			sb.append("<tr>");
			sb.append("<td width='10%'></td>");			
			sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr>");			
			sb.append("<tr>");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append("Stock Detail(s)");
			sb.append("</font></b></td><td width='10%'>&nbsp;</td> ");
			sb.append("</tr>");
			sb.append("</table> ");			
			
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(1);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(1);' /></div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
            
			sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='3%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Store Name</b></font> ");
			sb.append("</td>");

			if(vo.getStrItemCategoryNo()!=null && vo.getStrItemCategoryNo().equals("10"))
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
			else
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Active Qty</b></font> ");
			sb.append("</td> ");
			
			//sb.append("<td align='center' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>In-Active Qty</b></font> ");
			//sb.append("</td> ");
			
			//sb.append("<td align='center' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Quarantine Qty</b></font> ");
		//	sb.append("</td> ");
			
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
			
					strStoreName = ws.getString(8);
	            	batchNo = ws.getString(15);
	            	expiryDt = ws.getString(18);
	            	avlQty = ws.getString(9);
	            	stockStatus = ws.getString(40);
	            	reservedQty = ws.getString(41);
	            	blockedQty = ws.getString(42);
	            	unitName = ws.getString(43);
	            	itemBrandName=ws.getString(2);
	            	
	            	activeQty = ws.getString(44) + " " + unitName;
	            	inActiveQty = ws.getString(45) + " " + unitName;
	            	quarantineQty = ws.getString(46) + " " + unitName;
	            	
	            	//itemBrandName=ws.getString(13);
  					
  					if(strStoreName == null || strStoreName.equals("null") || strStoreName.equals(""))strStoreName = "---";
  					if(batchNo == null || batchNo.equals("null") || batchNo.equals("") )batchNo = "---";
  					if(avlQty == null || avlQty.equals("null") || avlQty.equals(""))avlQty = "---";
  					if(expiryDt == null || expiryDt.equals("null") || expiryDt.equals(""))expiryDt = "---";
  					if(stockStatus == null || stockStatus.equals("null") || stockStatus.equals(""))stockStatus = "---";
  					if(itemBrandName == null || itemBrandName.equals("null") || itemBrandName.equals(""))itemBrandName = "---";
  					
  					if(activeQty == null || activeQty.equals("null") || activeQty.equals(""))activeQty = "---";
  					if(inActiveQty == null || inActiveQty.equals("null") || inActiveQty.equals(""))inActiveQty = "---";
  					if(quarantineQty == null || quarantineQty.equals("null") || quarantineQty.equals(""))quarantineQty = "---";
					
					sb.append("<tr> ");					
					sb.append("<td align='center' width='3%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");					
					sb.append("<td style=\"text-align:left;\"  width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strStoreName);
					sb.append("</font></td>");
					sb.append("<td style=\"text-align:left;\" width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(itemBrandName);
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:left;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(batchNo);
					sb.append("</font></td> ");					
					sb.append("<td style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(expiryDt);
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(activeQty);
					sb.append("</font></td> ");					
//					sb.append("<td style=\"text-align:right;\" width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//					sb.append(inActiveQty);
//					sb.append("</font></td> ");					
//					sb.append("<td style=\"text-align:right;\" width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//					sb.append(quarantineQty);
//					sb.append("</font></td> ");
					
					activeQtyTotal = activeQtyTotal +	Double.parseDouble(activeQty.split("\\ ")[0]);
  					inActiveQtyTotal    = inActiveQtyTotal	+ 	Double.parseDouble(inActiveQty.split("\\ ")[0]);
  					quarantineQtyTotal	= quarantineQtyTotal 	+ Double.parseDouble(quarantineQty.split("\\ ")[0]);
  					
					
					sb.append("</tr> ");	
					
					 
					 
					
					 
					
					i++;
					count++;
								
				}
				
				 sb.append("<tr>");
				 sb.append("<td width='3%'  style=\"text-align:right;\"></td>");
				 sb.append("<td width='12%'  style=\"text-align:right;\"></td>");
				 sb.append("<td width='2%'  style=\"text-align:right;\"></td>");
				 sb.append("<td width='10%'  style=\"text-align:right;\"></td>");
				 sb.append("<td width='15%'  style=\"text-align:right;\"><b></b></td>");
				 sb.append("<td width='10%'  style=\"text-align:right;\"><b>Total</b></td>");
				 sb.append("<td width='10%'  style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> <b>"+activeQtyTotal+" "+unitName+"</b></font></td>");
//				 sb.append("<td width='7%'  style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> <b>"+inActiveQtyTotal+" "+unitName+"</b></font></td>");
//				 sb.append("<td width='7%'  style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> <b>"+quarantineQtyTotal+" "+unitName+"</b></font></td>");
				 sb.append("</tr>");
			}	
			else 
			{

				sb.append("<tr> ");
				sb.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Detail(s) Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}
	
	public static String getPrintDtl(UtilityGenerationTransVO vo) throws Exception
	{
			StringBuffer sb1=new StringBuffer();
			String strTableWidth = "825";
			ResourceBundle res = mms.qryHandler_mms.res;
			int i=0;
			if(res == null) 
			{
				res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = res;
			}
			HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
			try
			{
				if(vo.getStrOrg().equalsIgnoreCase("null"))
				{
					vo.setStrOrg("");
				}
				sb1.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				sb1.append("<tr><td width='8%'>&nbsp;</td> ");
				sb1.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
				sb1.append(res.getString("REPORT_TITLE"));
				sb1.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb1.append("</tr> ");
				sb1.append("<tr> ");
				sb1.append("<td width='8%'>&nbsp;</td> ");
				sb1.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
				sb1.append(res.getString("FULL_TITLE"));
				sb1.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb1.append("</tr> ");
				sb1.append("<tr> ");
				sb1.append("<td width='8%'>&nbsp;</td> ");
				sb1.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
				sb1.append(res.getString("CITY"));
				sb1.append("</font></b></td><td width='10%'>&nbsp; ");
				sb1.append("</td> ");
				sb1.append("</tr> ");
				sb1.append("</table> ");
				sb1.append(" <br>");
				sb1.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
				.append(strTableWidth)
				.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>UTILITY CERTIFICATE ISSUED BY "+vo.getStrStoreName().toUpperCase()+"</b></font></td></tr></table> ");
				sb1.append("<table border='0' width='").append(strTableWidth)
				.append("' align='center'> ");
				sb1.append("<tr> ");
				sb1.append("<td align='right'>");
				sb1.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				sb1.append("<img style='cursor: pointer; ' title='Print Page'  ");
				sb1.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
				sb1.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup(),cancelToDesk();' /> </div></div>");
				sb1.append(" </td> ");
				sb1.append(" </tr> ");
				sb1.append(" </table>");
			
				sb1.append("<table align='center' width='825' border='0' cellspacing='1' cellpadding='1'>");
				sb1.append("<tr><td colspan = 6 ><hr size='1'></td></tr>");
					sb1.append("<tr> ");
					
					sb1.append("<td width='50%' colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; UTILITY Number : </b>").append(vo.getStrDept().substring(0,2).toUpperCase()+""+vo.getStrUTNo()).append("</font></td>") ;
					
		
					sb1.append("<td width='25%' colspan='1' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("DATE : </b></font></td> ");
					sb1.append("<td width='25%' colspan='2' align='left' >").append(util.getASDate("dd-MMM-yyyy")).append("</td> ");
					sb1.append("</tr> ");
					sb1.append("<tr><td colspan = 6 ><hr size='1'></td></tr>");
					sb1.append("</table> ");
					sb1.append("<table align='center' width='825' border='0' cellspacing='1' cellpadding='1'>");
					sb1.append("<tr> ");
						sb1.append("<td width='50%'   colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; InPatient NO &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : </b>").append(vo.getStrIpNo()).append("</font></td> ");
						 sb1.append("<td width='50%' colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(" CR NO &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        : </b>").append(vo.getStrPuk()).append("</font></td> ");
						sb1.append("</tr> ");
						sb1.append("<tr> ");
						sb1.append("<td width='50%'  colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Patient Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  : </b>").append(vo.getStrPatName().toUpperCase()).append("</font></td> ");
						sb1.append("<td width='50%' colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("WARD &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;         : </b>").append(vo.getStrWard().toUpperCase()).append("</font></td> ");
						sb1.append("</tr> ");
						sb1.append("<tr>");
						sb1.append("<td width='50%'   colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Age/Sex &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  : </b>").append(vo.getStragesex().toUpperCase()).append("</font></td> ");
						sb1.append("<td width='50%' colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("INDENT NO  &nbsp; : </b>").append(vo.getStrIndentNo()).append("</font></td> ");
						sb1.append("</tr>");
						sb1.append("<tr>");
						sb1.append("<td width='100%' colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Category/Organisation &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : </b>").append(vo.getStrCat().toUpperCase()).append("</font><b>/</b>").append(vo.getStrOrg().toUpperCase()).append("</td> ");
						//sb1.append("<td width='100%' colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
						sb1.append("</tr>");
			/*		sb1.append("<tr> ");
					sb1.append("<td width='50%' colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("CR NO : </b>").append(vo.getStrPuk()).append("</font></td> ");
					sb1.append("<td width='50%' colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
				sb1.append("</tr> "); */
					
					sb1.append("<tr>");
					//	sb1.append("<td width='50%' colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("WARD : </b>").append(vo.getStrWard().toUpperCase()).append("</font></td> ");
						sb1.append("<td width='100%'  colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; DIAGNOSIS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;             : </b>").append(vo.getStrDiag().toUpperCase()).append("</font></td> ");
					//	sb1.append("<td width='50%' colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
						//sb1.append("<td width='50%' colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
						sb1.append("</tr>");
						for(i=0;i<1;i++)
						{
							
						sb1.append("<tr> ");
						
						sb1.append("<td width='100%'  colspan='6' align='left'  ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Vendor Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;           : </b></font>").append(vo.getStrSupplier()[0].toUpperCase()).append("</font></td> ");
						//sb1.append("<td width='75%' colspan=3 align='LEFT' ></td> ");
						sb1.append("</tr>");
						}
					/*sb1.append("<tr> ");
					sb1.append("<td width='50%' colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("INDENT NO : </b>").append(vo.getStrIndentNo()).append("</font></td> ");
					sb1.append("<td width='50%' colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
				sb1.append("</tr> ");*/
				       sb1.append("<tr>");
				       sb1.append("<td width='100%'  colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Implant Charges &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        : </b>").append(vo.getStrImpCharges()).append("</font></td> ");
				      // sb1.append("<td width='50%' colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
			           sb1.append("</tr>");

			           sb1.append("<tr>");
			           sb1.append("<td width='100%' colspan='6'  align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Surgeon Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;          : </b>").append(vo.getStrDoctor()).append("</font></td> ");
			         //  sb1.append("<td width='50%'  align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
		               sb1.append("</tr>");

		               sb1.append("<tr>");
		               sb1.append("<td width='100%' colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Surgery Details &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        : </b>").append(vo.getStrSurgeonDetail()).append("</font></td> ");
		             //  sb1.append("<td width='50%' colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
	                   sb1.append("</tr> ");

	                   sb1.append("<tr> ");
	                   sb1.append("<td width='100%' colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Surgery Date &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;          : </b>").append(vo.getStrSurgeryDate()).append("</font></td> ");
	                 //  sb1.append("<td width='50%' colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
                       sb1.append("</tr><br> ");

                       sb1.append("<tr> ");
                       sb1.append("<td width='100%'  colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Surgery Charges &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       : </b>").append(vo.getStrSurgeonCharges()).append("</font></td> ");
                     //  sb1.append("<td width='50%' colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
                       sb1.append("</tr> ");
				//	sb1.append("<tr> ");
				//	sb1.append("<td width='100%' align='left' colspan=4 ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("BILLING PARTICULARS : </b></font></td> ");
					//sb1.append("<td width='75%' colspan=3 align='LEFT' ></td> ");
				//	sb1.append("</tr> ");
					
					//sb1.append("<tr><td colspan = 4 ><hr size='1'></td></tr>");
					//sb1.append("<tr> ");
					//sb1.append("<td width='50%' colspan='2' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("CODE & PROCEDURE </b></font></td> ");
					//sb1.append("<td width='50%' colspan='2' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("RATE (Rs.) </b></font></td> ");
					//sb1.append("</tr> ");
					//sb1.append("<tr><td colspan = 4 ><hr size='1'></td></tr>");
					
					sb1.append("</table>");
					sb1.append("<table align='center' width='825' border='0' cellspacing='1' cellpadding='1'>");
					sb1.append("<tr><td colspan = 6 ><hr size='1'></td></tr>");
					sb1.append("<tr> ");
					sb1.append("<td width='5%'  align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("&nbsp;&nbsp;&nbsp;Sno </b></font></td> ");
					sb1.append("<td width='30%'  align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Item Name</b></font></td> ");
					//sb1.append("<td width='20%'  align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("SUPPLIER NAME </b></font></td> ");
					sb1.append("<td width='20%'  align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Qty </b></font></td> ");
					sb1.append("<td width='15%'  align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Rate(Incl. of tax) </b></font></td> ");
					sb1.append("<td width='15%'  align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Handling Charges </b></font></td> ");
					sb1.append("<td width='15%'  align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Total  </b></font></td> ");
					sb1.append("</tr> ");
					sb1.append("<tr><td colspan = 6 ><hr size='1'></td></tr>");
					for(i=0;i<vo.getStrItem().length;i++)
					{
						
						double amt = Double.parseDouble(vo.getStrHandlingCharges()) + Double.parseDouble(vo.getStrRate()[i]) ;
						sb1.append("<tr> ");
						sb1.append("<td width='5%'  align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >&nbsp;&nbsp;&nbsp;").append(i+1).append(" </b></font></td> ");
						sb1.append("<td width='30%'  align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrItem()[i]).append("</font></td> ");
						//sb1.append("<td width='20%'  align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrSupplier()[i]).append("</font></td> ");
						sb1.append("<td width='20%'  align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrQty()[i].substring(0,4)).append("</font></td> ");
						sb1.append("<td width='15%'  align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrRate()[i]).append("</font></td> ");
						//if(i==0)
							sb1.append("<td width='15%'  align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrHandlingCharges()).append("</font></td> ");
					//	else
						//	sb1.append("<td width='15%'  align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append("</font></td> ");
						sb1.append("<td width='15%'  align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(amt).append("</font></td> ");
						sb1.append("</tr> ");
					}
					
					sb1.append("<tr><td colspan = 6 ><hr size='1'></td></tr>");
					
					sb1.append("</table>");
					
					sb1.append("<br><br> ");
					sb1.append("<br><br> ");
					sb1.append("<br><br> ");
					sb1.append("<br><br> ");
					sb1.append("<br><br> ");
					sb1.append("<br><br> ");
					sb1.append("<br><br> ");
					sb1.append("<br><br> ");
					sb1.append("<table align='center' width='825' border='0' cellspacing='0' cellpadding='0'>");
					sb1.append("<tr> ");
					sb1.append("<td width='50%' colspan=3 align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							"Signature Operating/Implanting Surgeon   ").append("</b></font></td> ");
					sb1.append("<td width='50%' colspan=3 align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Signature of head of the Dept./Head").append("</b></font></td> ");
					sb1.append("</tr> ");
					sb1.append("<tr><td colspan = 6 ><hr size='1'></td></tr>");
					sb1.append("</table>");
					
					sb1.append("<br>");
					sb1.append("<br>");
					
				/*sb1.append("<table align='center' width='825' border='0' cellspacing='0' cellpadding='0'>");
					sb1.append("<tr> ");
					
					sb1.append("<td width='50%' colspan=2 align='right'>.</td> ");
					sb1.append("<td width='50%' colspan=2 align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Signature of head of the Dept./Head").append("</b></font></td> ");
					sb1.append("</tr> ");
				sb1.append("</table>");*/
				
			}
			catch(Exception e){
		
				//System.out.println("Error"+e.getMessage());
				throw new Exception(e.getMessage());
			
		}
			return sb1.toString();
	}
	public static String createStockDetails1(UtilityGenerationTransVO vo, WebRowSet ws)throws Exception
	{ 
		StringBuffer br = new StringBuffer();
		try
		{
			if(ws != null )
			{
				
	            if(ws.size() > 0)
				{	
	            	ws.next();
	            	if(vo.getStrItemCategoryNo().equals("1"))
            			vo.setStrIpNo(ws.getString(17));
	            	else
	            		vo.setStrIpNo(ws.getString(20));
	            	br.append("<table  class='TABLEWIDTH' align='center' cellpadding='1px'  cellspacing='1px'>");
            		br.append("<tr>");
            		br.append("<td width='25%' class='LABEL'><div align='right'><b>Patient Name</b></div></td><td width='25%' class='CONTROL'><input type='hidden' name='strPatName' id='strPatName' value='"+ws.getString(1)+"' /><div align='left'> "+ws.getString(1)+"</div></td>");
            		br.append("<td width='25%' class='LABEL'><div align='right'><b>InPatient No.</b></div></td><td width='25%' class='CONTROL'><input type='hidden' name='strIpNo' id='strIpNo' value='"+vo.getStrIpNo()+"' /><div align='left'> "+vo.getStrIpNo()+"</div></td>");
            		br.append("</tr>");
            		br.append("<tr>");
            		br.append("<td width='25%' class='LABEL'><div align='right'><b>Category</b></div></td><td width='25%' class='CONTROL'><input type='hidden' name='strCat' id='strCat' value='"+ws.getString(2)+"' /><div align='left'> "+ws.getString(2)+"</div></td>");
            		br.append("<td width='25%' class='LABEL'><div align='right'><b>INDENT No.</b></div></td><td width='25%' class='CONTROL'><input type='hidden' name='strIndentNo' id='strIndentNo' value='"+ws.getString(8)+"' /><div align='left'> "+ws.getString(8)+"</div></td>");
            		br.append("</tr>");
            		br.append("<tr>");
            		br.append("<td width='25%' class='LABEL'><div align='right'><b>Department</b></div></td><td width='25%' class='CONTROL'><input type='hidden' name='strDept' id='strDept' value='"+ws.getString(5).split("@")[0]+"' /><div align='left'> "+ws.getString(5).split("@")[0]+"</div></td>");
            		br.append("<td width='25%' class='LABEL'><div align='right'><b>WARD</b></div></td><td width='25%' class='CONTROL'><input type='hidden' name='strWard' id='strWard' value='"+ws.getString(5).split("@")[2]+"' /><div align='left'> "+ws.getString(5).split("@")[2]+"</div></td>");
            		br.append("</tr>");
            		br.append("<tr>");
            		br.append("<td width='25%' class='LABEL'><div align='right'><b>DOCTOR</b></div></td><td width='25%' class='CONTROL'><input type='hidden' name='strDoctor' id='strDoctor' value='"+ws.getString(6)+"' /><div align='left'> "+ws.getString(6)+"</div></td>");
            		br.append("<td width='25%' class='LABEL'><div align='right'><b></b></div></td><td width='25%' class='CONTROL'><div align='left'></div></td>");
            		br.append("</tr>");
            		if(vo.getStrItemCategoryNo().equals("1"))
            		{
            			vo.setStrIpNo(ws.getString(17));
            			br.append("<tr>");
            			br.append("<td width='25%' class='LABEL'><div align='right'><b>Handling Charges</b></div></td><td width='25%' class='CONTROL'><input type='hidden' name='strWardCode' id='strWardCode' value='"+ws.getString(5).split("@")[3]+"' /><input type='hidden' name='strTreatmentCatCode' id='strTreatmentCatCode' value='"+ws.getString(14)+"' /><input type='hidden' name='stragesex' id='stragesex' value='"+ws.getString(18)+"' /><input type='hidden' name='strOrg' id='strOrg' value='"+ws.getString(19)+"' /><input type='text' name='strHandlingCharges' autocomplete='off' onkeypress='return validateData(event,7);' maxlength='10' ></td>");
	            		br.append("<td width='25%' class='LABEL'><div align='right'><b>Surgery Date</b></div></td><td width='25%' class='CONTROL'> ");
						br.append("<div style='' id='divASurDate'>");
						br.append(HisUtil.getDatePicker("strSurgeryDate", vo.getStrCtDate(), true));
						br.append("</div>");
						br.append("<div id='divSurDate'>");
						//br.append(vo.getStrCtDate());
						br.append("</div>");
						br.append("</td>");
						br.append("</tr>");
						br.append("<tr>");
            			br.append("<td width='25%' class='LABEL'><div align='right'><b>Implant Charges</b></div></td><td width='25%' class='CONTROL'><input type='text' name='strImpCharges' autocomplete='off' onkeypress='return validateData(event,7);' maxlength='10' ></td>");
            			br.append("<td width='25%' class='LABEL'><div align='right'><b>Surgery Charges</b></div></td><td width='25%' class='CONTROL'><input type='text' name='strSurgeonCharges' autocomplete='off' onkeypress='return validateData(event,7);' maxlength='10' ></td>");
            			br.append("</tr>");
						br.append("<tr>");
	            		br.append("<td width='25%' class='LABEL'><div align='right'><b>Surgery Details.</b></div></td><td width='75%' colspan=3 class='CONTROL'> <input type='text' name='strSurgeonDetail' size='100%' autocomplete='off'  maxlength='200' ></td>");	            		
	            		br.append("</tr>");
	            		br.append("<tr>");
	            		br.append("<td width='25%' class='LABEL'><div align='right'><b>Diagnosis.</b></div></td><td width='75%' colspan=3 class='CONTROL'> <input type='text' value='"+ws.getString(13)+"' name='strDiag' size='100%' autocomplete='off'  maxlength='200' ></td>");
	            		
	            		br.append("</tr>");
            		}
            		else
            		{
            			br.append("<tr>");
            			br.append("<td width='25%' class='LABEL'><div align='right'><b>Handling Charges</b></div></td><td width='25%' class='CONTROL'><input type='hidden' name='strWardCode' id='strWardCode' value='"+ws.getString(17)+"' /><input type='hidden' name='stragesex' id='stragesex' value='"+ws.getString(21)+"' /><input type='hidden' name='strOrg' id='strOrg' value='"+ws.getString(22)+"' /><input type='hidden' name='strTreatmentCatCode' id='strTreatmentCatCode' value='"+ws.getString(18)+"' /><input type='hidden' name='strBillNo' id='strBillNo' value='"+ws.getString(19).replace("^","@").split("@")[0]+"' /><input type='text' name='strHandlingCharges' onkeypress='return validateData(event,7);' value='"+ws.getString(13)+"' autocomplete='off'  maxlength='10' ></td>");
	            		br.append("<td width='25%' class='LABEL'><div align='right'><b>Surgery Date</b></div></td><td width='25%' class='CONTROL'> ");
						br.append("<div style='' id='divASurDate'>");
						br.append(HisUtil.getDatePicker("strSurgeryDate", ws.getString(14), true));
						br.append("</div>");
						br.append("<div id='divSurDate'>");
						br.append("");
						br.append("</div>");
						br.append("</td>");
						br.append("</tr>");
						br.append("<tr>");
            			br.append("<td width='25%' class='LABEL'><div align='right'><b>Implant Charges</b></div></td><td width='25%' class='CONTROL'><input type='text' name='strImpCharges' autocomplete='off' onkeypress='return validateData(event,7);' maxlength='10' value='"+ws.getString(23)+"'></td>");
            			br.append("<td width='25%' class='LABEL'><div align='right'><b>Surgery Charges</b></div></td><td width='25%' class='CONTROL'><input type='text' name='strSurgeonCharges' autocomplete='off' onkeypress='return validateData(event,7);' maxlength='10' value='"+ws.getString(24)+"' ></td>");
            			br.append("</tr>");
						br.append("<tr>");
	            		br.append("<td width='25%' class='LABEL'><div align='right'><b>Surgery Details.</b></div></td><td width='75%' colspan=3 class='CONTROL'> <input type='text' name='strSurgeonDetail' size='100%' autocomplete='off'  maxlength='200' value='"+ws.getString(25)+"' ></td>");
	            		
	            		br.append("</tr>");
	            		br.append("<tr>");
	            		br.append("<td width='25%' class='LABEL'><div align='right'><b>Diagnosis.</b></div></td><td width='75%' colspan=3 class='CONTROL'> <input type='text' value='"+ws.getString(15)+"' name='strDiag' size='100%' autocomplete='off'  maxlength='200' ></td>");
	            		
	            		br.append("</tr>");
            		}
            		ws.beforeFirst();
            		String supplierId=null;
            		int i=0;
            		br.append("</table><table  class='TABLEWIDTH' align='center' cellpadding='1px'  cellspacing='1px'>");
            		br.append("<tr class='TITLE'><td width='100%' class='TITLE'><div align='left'>Select Supplier</div></td></tr></table>");
            		br.append("</table><table  class='TABLEWIDTH' align='center' cellpadding='1px'  cellspacing='1px'>");
            		if(ws.next())
            		{
            			supplierId=ws.getString(4).split("\\$")[3];
            			if(!ws.getString(4).equals("0$0$0$0$0$0$0$0$0"))
	            		{	
            			// System.out.println("supplierId::::::::::::::::::"+supplierId);
            			 br.append("<tr><td width='25%' class='LABEL'><div align='right'><INPUT TYPE='checkbox'  name='strrSupplier' id='strrSupplier"+i+"' value='"+ws.getString(4).split("\\$")[3]+"' onclick='getItemdiv(this)' /></td><td width='25%' class='CONTROL'><div align='left'> "+ws.getString(4).split("\\$")[0]+"</div></td>");
            			 br.append("<td width='25%' class='LABEL'><div align='right'><b></b></div></td><td width='25%' class='CONTROL'><div align='left'></div></td></tr>");
            		
	            		}
            		
	            	}
            		ws.beforeFirst();
            		br.append("</table>");
            		br.append("<div id='itemlabel' style='display:none;'><table  class='TABLEWIDTH' align='center' cellpadding='1px'  cellspacing='1px'>");
            		br.append("<tr>");
            		
            		br.append("<td width='33%' class='LABEL'>Item Name</td><td width='33%' class='LABEL'><div align='center'>Qty</div></td><td width='34%' class='LABEL'><div align='center'>Rate</div></td></tr></table></div>");
	         
	            	//String ucitm="";
	            	//String supplierId=null;
	            	
            		while(ws.next())
	            	{
            			
            			if(ws.getString(4).split("\\$")[3].equals(supplierId))
            			{
	            		if(!ws.getString(4).equals("0$0$0$0$0$0$0$0$0"))
	            		{	
	            			//System.out.println("ws.getString(4)"+ws.getString(4).split("\\$")[3]);
	            			//String supplierId=ws.getString(4).split("\\$")[3];
	            			
	            			double amt = Math.round(Double.parseDouble(ws.getString(4).split("\\$")[1])*100.0)/100.0 ;
	            			
	            			br.append("<div id='"+ws.getString(4).split("\\$")[3]+"sup"+i+"' style='display:none;'>");
	            			br.append("<table  class='TABLEWIDTH' align='center' cellpadding='1px'  cellspacing='1px'>");
		            		br.append("<tr><td width='33%' class='CONTROL'><input type='hidden' name='strhidval' id='strhidval"+i+"' value='"+ws.getString(4)+"#"+ws.getString(15)+"' /><input type='hidden' name='strDPhoneEmail'  id='strDPhoneEmail' value='"+ws.getString(4).split("\\$")[2]+"' /><input type='hidden' name='strItemId' id='strItemId"+i+"' disabled='disabled'  value='"+ws.getString(16)+"#"+ws.getString(15)+"' /><input type='hidden' name='strItem' id='strItem"+i+"' disabled value='"+ws.getString(3)+"' /><input type='hidden' name='strQty' id='strQty"+i+"' disabled value='"+ws.getString(12)+"' /><input type='hidden' name='strStoreName' id='strStoreName' value='"+ws.getString(11)+"' /><div align='right'> "+ws.getString(3)+"</div></td>");
		            		//br.append("<td width='25%' class='CONTROL'><input type='hidden' name='strSupplier' id='strSupplier"+i+"' value='"+ws.getString(4).split("\\$")[0]+"' /><div align='right'> "+ws.getString(4).split("\\$")[0]+"</div></td>");
		            		br.append("<td width='33%' class='CONTROL'><input type='hidden' disabled name='strQty' id='strQty"+i+"' value='"+ws.getString(12)+"' /><div align='center'> "+ws.getString(12)+"</div></td>");
		            		br.append("<td width='34%' class='CONTROL'><input type='hidden' disabled name='strSupplierId' id='strSupplierId"+i+"' value='"+ws.getString(4).split("\\$")[3]+"' /><input type='hidden' name='strSupplier' id='strSupplier"+i+"' value='"+ws.getString(4).split("\\$")[0]+"' /><input type='hidden' name='strDCNo' id='strDCNo"+i+"' disabled value='"+ws.getString(4).split("\\$")[4]+"' /><input type='hidden' name='strInvoiceNo' disabled id='strInvoiceNo"+i+"' value='"+ws.getString(4).split("\\$")[5]+"' /><input type='hidden' name='strInvoiceDate' disabled id='strInvoiceDate"+i+"' value='"+ws.getString(4).split("\\$")[6]+"' /><input type='hidden' name='strPONo' disabled id='strPONo"+i+"' value='"+ws.getString(4).split("\\$")[7]+"' /><div align='center'><input type='text' id='strRate"+i+"' disabled onkeypress='return validateData(event,7);' name='strRate' disabled autocomplete='off'  maxlength='10' value='"+(Math.round(amt*100.0)/100.0)+"'></div></td>");
		            		br.append("</tr><tr style='display:none'><td><input type='checkbox'  name='chk' id='chkid"+i+"' disabled value='"+ws.getString(4).split("\\$")[3]+"'></td></tr></table></div>");
		            		supplierId=ws.getString(4).split("\\$")[3];
		            		//System.out.println("supplierId:::"+supplierId);
		            		i++;
	            			} 
	            		
            			
	            		else
	            		{
	            			br.append("<tr class='LABEL'>");
	    					br.append("<td colspan='4'><font color='red'>");
	    					br.append("<div align='center'>Item : "+ws.getString(3)+" is not available in inventory.So,UC for the item can't be generated</div></font></td>");
	    					br.append("</tr>");
	            		}
            			}
            			else
            			{
            				//double amt = Math.round((Double.parseDouble(ws.getString(12)) * Double.parseDouble(ws.getString(4).split("\\$")[1]))*100.0)/100.0 ;
            				double amt = Math.round(Double.parseDouble(ws.getString(4).split("\\$")[1])*100.0)/100.0 ;
            				br.append("<table  class='TABLEWIDTH' align='center' cellpadding='1px'  cellspacing='1px'>");
            				 br.append("<tr><td width='25%' class='LABEL'><input type='hidden' name='strhidval' id='strhidval"+i+"' value='"+ws.getString(4)+"#"+ws.getString(15)+"' /><div align='right'><INPUT TYPE='checkbox'  name='strrSupplier' id='strrSupplier"+i+"' value='"+ws.getString(4).split("\\$")[3]+"' onclick='getItemdiv(this)' /></td><td width='25%' class='CONTROL'><div align='left'> "+ws.getString(4).split("\\$")[0]+"</div></td>");
                			 br.append("<td width='25%' class='LABEL'><div align='right'><b></b></div></td><td width='25%' class='CONTROL'><div align='left'></div></td></tr></table>");
                			 br.append("<div id='"+ws.getString(4).split("\\$")[3]+"sup"+i+"' style='display:none;'>");
                			 br.append("<table  class='TABLEWIDTH' align='center' cellpadding='1px'  cellspacing='1px'>");
 		            		br.append("<tr><td width='33%' class='CONTROL'><input type='hidden' name='strDPhoneEmail' id='strDPhoneEmail' value='"+ws.getString(4).split("\\$")[2]+"' /><input type='hidden' name='strItemId' id='strItemId"+i+"' disabled='disabled' value='"+ws.getString(16)+"#"+ws.getString(15)+"' /><input type='hidden' name='strItem' id='strItem"+i+"' disabled value='"+ws.getString(3)+"' /><input type='hidden' name='strQty' id='strQty"+i+"' disabled value='"+ws.getString(12)+"' /><input type='hidden' name='strStoreId' id='strStoreId' value='"+ws.getString(10)+"' /><input type='hidden' name='strStoreName' id='strStoreName' value='"+ws.getString(11)+"' /><div align='right'> "+ws.getString(3)+"</div></td>");
 		            		//br.append("<td width='25%' class='CONTROL'><input type='hidden' name='strSupplier' id='strSupplier"+i+"' value='"+ws.getString(4).split("\\$")[0]+"' /><div align='right'> "+ws.getString(4).split("\\$")[0]+"</div></td>");
 		            		br.append("<td width='33%' class='CONTROL'><input type='hidden' name='strQty' disabled  id='strQty"+i+"' value='"+ws.getString(12)+"' /><div align='center'> "+ws.getString(12)+"</div></td>");
 		            		br.append("<td width='34%' class='CONTROL'><input type='hidden' disabled name='strSupplierId' id='strSupplierId"+i+"' value='"+ws.getString(4).split("\\$")[3]+"' /><input type='hidden' name='strSupplier' id='strSupplier"+i+"' value='"+ws.getString(4).split("\\$")[0]+"' /><input type='hidden' name='strDCNo' disabled id='strDCNo"+i+"' value='"+ws.getString(4).split("\\$")[4]+"' /><input type='hidden' disabled name='strInvoiceNo' id='strInvoiceNo"+i+"' value='"+ws.getString(4).split("\\$")[5]+"' /><input type='hidden' name='strInvoiceDate' disabled id='strInvoiceDate"+i+"' value='"+ws.getString(4).split("\\$")[6]+"' /><input type='hidden' disabled name='strPONo' id='strPONo"+i+"' disabled value='"+ws.getString(4).split("\\$")[7]+"' /><div align='center'><input type='text' id='strRate"+i+"'  onkeypress='return validateData(event,7);' name='strRate'  autocomplete='off'  maxlength='10' disabled value='"+amt+"'></div></td>");
 		            		br.append("</tr><tr style='display:none'><td><input type='checkbox'  name='chk' id='chkid"+i+"' disabled value='"+ws.getString(4).split("\\$")[3]+"'></td></tr></table></div>");
 		            		supplierId=ws.getString(4).split("\\$")[3];
 		            		//System.out.println("supplierId:::"+supplierId);
 		            		i++;
            			}
	            	} 
            		if(i==0)
            			br.append("<tr><td class='CONTROL'><input type='hidden' name='strDPhoneEmail' id='strDPhoneEmail' value='"+i+"' /></td></tr>");
	            	br.append("</table>");
				}
	            else
	            {
	            	br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'  cellspacing='1px'><tr class='LABEL'>");
					br.append("<td colspan='7'><font color='red'>Either patient is not admitted or Indent details not found</font></td>");
					br.append("</tr></table>");
	            }
			}
				
		}catch(Exception e){
		
				//System.out.println("Error"+e.getMessage());
				throw new Exception(e.getMessage());
			
		}
		finally
		{
			ws=null;
			
		}
	return br.toString();
	}
	
	public static String createUtilityNo(UtilityGenerationTransVO vo, WebRowSet ws)throws Exception
	{ 
		StringBuffer br = new StringBuffer();
		try
		{
			if(ws != null )
			{
				
	            if(ws.size() > 0)
				{	
	            
	            	ws.beforeFirst();
	            	br.append("<table  class='TABLEWIDTH' align='center' cellpadding='1px'  cellspacing='1px'>");
            	//	br.append("<tr><td width='25%' class='LABEL'><div align='left'><b></b></div></td><td width='75%' class='LABEL'><div align='left'>Utility No</div></td></tr>");
            		
            		
            		//	 br.append("<tr><td width='25%' class='LABEL'><div align='right'><INPUT TYPE='combo'  name='strUtilNo' id='strUtilNo' value='"+vo.getStrUtilNo()+"' onclick='getmodifyDtl(this)' /></td><td width='25%' class='CONTROL'><div align='left'> "+ws.getString(1)+"</div></td></tr>");
            			 
            			 br.append("<tr><td width='35%' class='LABEL'><div align='right'><b>Utility No</b></div></td>");
            			
            			 br.append("<td width='65%' class='CONTROL' ><div align='left'><select style='cursor:pointer;cursor:hand' name='strUtilNo' id='strUtilNo' class='comboNormal' dir='' title='' onChange='getmodifyDtl(this);'>"+vo.getStrUtilNo()+"</select></div></td></tr>");
	            		
          
            		br.append("</table>");
	            	
				}
	            else
	            {
	            	br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'  cellspacing='1px'><tr class='LABEL'>");
					br.append("<td colspan='7'><font color='red'>Either patient is not admitted or Indent details not found</font></td>");
					br.append("</tr></table>");
	            }
			}
				
		}catch(Exception e){
		
				//System.out.println("Error"+e.getMessage());
				throw new Exception(e.getMessage());
			
		}
		finally
		{
			ws=null;
			
		}
	return br.toString();
	}
	
	
	public static String createIndentNo(UtilityGenerationTransVO vo, WebRowSet ws)throws Exception
	{ 
		StringBuffer br = new StringBuffer();
		try
		{
			if(ws != null )
			{
				
	            if(ws.size() > 0)
				{	
	            
	            	ws.beforeFirst();
	            	br.append("<table  class='TABLEWIDTH' align='center' cellpadding='1px'  cellspacing='1px'>");
            	//	br.append("<tr><td width='25%' class='LABEL'><div align='left'><b></b></div></td><td width='75%' class='LABEL'><div align='left'>Utility No</div></td></tr>");
            		
            		
            		//	 br.append("<tr><td width='25%' class='LABEL'><div align='right'><INPUT TYPE='combo'  name='strUtilNo' id='strUtilNo' value='"+vo.getStrUtilNo()+"' onclick='getmodifyDtl(this)' /></td><td width='25%' class='CONTROL'><div align='left'> "+ws.getString(1)+"</div></td></tr>");
            			 
            			 br.append("<tr><td width='35%' class='LABEL'><div align='right'><b>Indent No</b></div></td>");
            			
            			 br.append("<td width='65%' class='CONTROL' ><div align='left'><select style='cursor:pointer;cursor:hand' name='strCmbIndentNo' id='strCmbIndentNo' class='comboNormal' dir='' title='' onChange='getNewDtl(this);'>"+vo.getStrCmbIndentNo()+"</select></div></td></tr>");
	            		
          
            		br.append("</table>");
	            	
				}
	            else
	            {
	            	br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'  cellspacing='1px'><tr class='LABEL'>");
					br.append("<td colspan='7'><font color='red'>Either patient is not admitted or Indent details not found</font></td>");
					br.append("</tr></table>");
	            }
			}
				
		}catch(Exception e){
		
				//System.out.println("Error"+e.getMessage());
				throw new Exception(e.getMessage());
			
		}
		finally
		{
			ws=null;
			
		}
	return br.toString();
	}
	
	public static String createStockDetails(UtilityGenerationTransVO vo, WebRowSet ws)throws Exception
	{ 
		StringBuffer br = new StringBuffer();
		
		String strStoreName = "";
		String batchNo = "0";
		String serialNo = null;
		String avlQty = "";
		String expiryDt = "";
		String stockStatus = "";
		String reservedQty = "";
		String blockedQty = "";
		String unitName = "",itemBrandName="";
		String mrp,branded;
		int i=0;
		
			try{
				
				br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				br.append("<tr class='TITLE'>");
				br.append("<td colspan='7'>Stock Details</td>");
				br.append("</tr>");
				br.append("<tr>");
				if(vo.getStrItemCategoryNo()!=null && vo.getStrItemCategoryNo().equals("1")){
					br.append("<tr><td width='15%' class='multiRPTLabel'><div align='left'><b>Store Name</b></div></td>");
					br.append("<td width='20%' class='multiRPTLabel'><div align='left'><b>Drug Name</b></div></td>");
				}else{
					br.append("<tr><td width='15%' class='multiRPTLabel'><div align='left'><b>Store Name</b></div></td>");
					br.append("<td width='20%' class='multiRPTLabel'><div align='left'><b>Item Name</b></div></td>");
				}
	  	        br.append("<td width='10%' class='multiRPTLabel'><div align='left'><b>Batch No</b></div></td>");
	  	        br.append("<td width='20%' class='multiRPTLabel'><div align='left'><b>MRP</b></div></td>");
	  	        br.append("<td width='15%' class='multiRPTLabel'><div align='left'><b>Avl Qty</b></div></td>");
	            br.append("<td width='10%' class='multiRPTLabel'><div align='left'><b>Expiry Date</b></div></td>");
	           // br.append("<td width='15%' class='multiRPTLabel'><div align='left'>Branded/Non-Branded</div></td>");
	            br.append("<td width='10%' class='multiRPTLabel'><div align='left'><b>Stock Status</b></div></td>");
	            br.append("</tr>");
				
				if(ws != null && ws.size() > 0){
					
					//System.out.println("ws size : "+ws.size());
					
		            while(ws.next())
					{		
		            	strStoreName = ws.getString(8);
		            	
		            	batchNo = ws.getString(15);
		            	
		            	if(!vo.getStrItemCategoryNo().equals("1"))
		            	serialNo = ws.getString(37);
		            	
		            	expiryDt = ws.getString(18);
		            	avlQty = ws.getString(9);
		            	stockStatus = ws.getString(40);
		            	
		            	reservedQty = ws.getString(41);
		            	blockedQty = ws.getString(42);
		            	unitName = ws.getString(43);
		            	itemBrandName=ws.getString(2);
		            	mrp=ws.getString(38);
		            	branded=ws.getString(47);
	  					if(strStoreName == null || strStoreName.equals("null") || strStoreName.equals(""))strStoreName = "---";
	  					if(batchNo == null || batchNo.equals("null") || batchNo.equals("") )batchNo = "---";
	  					if(serialNo == null || serialNo.equals("null") || serialNo.equals(""))serialNo = "---";
	  					if(avlQty == null || avlQty.equals("null") || avlQty.equals(""))avlQty = "---";
	  					if(expiryDt == null || expiryDt.equals("null") || expiryDt.equals(""))expiryDt = "---";
	  					if(stockStatus == null || stockStatus.equals("null") || stockStatus.equals(""))stockStatus = "---";
	  					if(itemBrandName == null || itemBrandName.equals("null") || itemBrandName.equals(""))itemBrandName = "---";
	  				
	  					br.append("<tr>");
	  					br.append("<td width='15%' class='multiPOControl'>"+strStoreName+"</td>");
	  					
	  					br.append("<td class='multiPOControl' width='20%'>");
	  					br.append(itemBrandName);
	  					br.append("<input type='hidden' name='strItemDetail' id='strItemDetail" +i+"' value='"+ws.getString(5)+"^"+ws.getString(19)+"^"+ws.getString(6)+"^"+ws.getString(25)+"^"+ws.getString(29)+"' /></td>");
	  					
	  					br.append("<td width='10%' class='multiPOControl'>"+batchNo+"</td>");
	  					br.append("<td width='20%' class='multiPOControl'>"+mrp+"</td>");
	  					br.append("<td width='15%' class='multiPOControl'>"+avlQty+"<input type='hidden' name='strAvlQty' id='strAvlQty" +i+"'"+
		  							"value='"+ reservedQty+" "+unitName+ "@"+ blockedQty +" "+unitName + "'/></td>");
	  					br.append("<td width='10%' class='multiPOControl'>"+expiryDt+"</td>");
	  				//	br.append("<td width='15%' class='multiPOControl'>"+branded+"</td>");
	  					br.append("<td width='10%' class='multiPOControl'>"+stockStatus+"</td>");
	  					
	  					br.append("</tr>");
	  					i++;
					}
		         
				}else{
					
					br.append("<tr class='multiPOControl'>");
					br.append("<td colspan='7'><font color='red'>No Record Available</font></td>");
					br.append("</tr>");
					
				}
			 
				   br.append("</table>");
				
		}catch(Exception e){
		
				//System.out.println("Error"+e.getMessage());
				throw new Exception(e.getMessage());
			
		}
		finally
		{
			ws=null;
			
		}
	return br.toString();
	}
	
	public static String createEmployeeStockDetails(UtilityGenerationTransVO vo,WebRowSet ws)throws Exception
	{ 
		StringBuffer br = new StringBuffer();
		
		String strEmpNo = "";
		String empName = "";
		String batchNo = "";
		String serialNo = "";
		String avlQty = "";
		String expiryDt = "";
		
		
			try{
				
				br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				br.append("<tr class='TITLE'>");
				br.append("<td colspan='6'>Employee Stock Details</td>");
				br.append("</tr>");
				br.append("<tr>");
				br.append("<tr><td width='15%' class='multiRPTLabel'><div align='center'>Emp No</div></td>");  
	  	        br.append("<td width='25%' class='multiRPTLabel'><div align='center'>Emp Name</div></td>");
	  	        br.append("<td width='10%' class='multiRPTLabel'><div align='center'>Batch No</div></td>");
	  	        br.append("<td width='20%' class='multiRPTLabel'><div align='center'>Serial No</div></td>");
	            br.append("<td width='20%' class='multiRPTLabel'><div align='center'>Avl Qty</div></td>");
	            br.append("<td width='10%' class='multiRPTLabel'><div align='center'>Expiry Date</div></td>");
	            br.append("</tr>");
				
	            if(ws != null && ws.size() > 0){
					
					//System.out.println("Emp ws size : "+ws.size());
					
		            while(ws.next())
					{		
		            	strEmpNo = ws.getString(1);
		            	empName = ws.getString(2);
		            	batchNo = ws.getString(3);
		            	serialNo = ws.getString(4);
		            	avlQty = ws.getString(5);
		            	expiryDt = ws.getString(6);
		            	
	  					
	  					if(strEmpNo == null || strEmpNo.equals("null") || strEmpNo.equals(""))strEmpNo = "---";
	  					if(batchNo == null || batchNo.equals("null") || batchNo.equals("") )batchNo = "---";
	  					if(serialNo == null || serialNo.equals("null") || serialNo.equals(""))serialNo = "---";
	  					if(avlQty == null || avlQty.equals("null") || avlQty.equals(""))avlQty = "---";
	  					if(expiryDt == null || expiryDt.equals("null") || expiryDt.equals(""))expiryDt = "---";
	  					if(empName == null || empName.equals("null") || empName.equals(""))empName = "---";
	  				
	  					br.append("<tr>");
	  					br.append("<td width='20%' class='multiPOControl'>"+strEmpNo+"</td>");
	  					br.append("<td width='20%' class='multiPOControl'>"+empName+"</td>");
	  					br.append("<td width='10%' class='multiPOControl'>"+batchNo+"</td>");
	  					br.append("<td width='10%' class='multiPOControl'>"+serialNo+"</td>");
	  					br.append("<td width='20%' class='multiPOControl'>"+avlQty+"</td>");
	  					br.append("<td width='20%' class='multiPOControl'>"+expiryDt+"</td>");
	  					
	  					
	  					br.append("</tr>");
					}
		           
				}else{
					
					br.append("<tr class='multiPOControl'>");
					br.append("<td colspan='6'><font color='red'>No Record Available</font></td>");
					br.append("</tr>");
					
				}
			 
				   br.append("</table>");
			 
		}catch(Exception e){
		
				throw new Exception(e.getMessage());
		
		}
		finally
		{
			ws=null;
			
		}
	return br.toString();
	}

}
