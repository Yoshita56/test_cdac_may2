package mms.reports.controller.hlp;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.reports.controller.fb.IssueToPatientDetailRptFB;
import mms.reports.vo.IssueToPatientDetailRptVO;

public class IssueToPatientDetailRptHLP
{
	
	public static String getPatientIssueDtls(WebRowSet ws,IssueToPatientDetailRptVO vo, IssueToPatientDetailRptFB fb) throws Exception 
	{

		System.out.println("--------------------- IssueToPatientDetailRptHLP.getPatientIssueDtls -------------------------------");
		StringBuffer sb = new StringBuffer("");
		int i=1;	
        BigDecimal grandTotalQty = new BigDecimal(BigInteger.ZERO,  2);
		
		BigDecimal totalQty = null;
		
	
		String strTableWidth = "1100";
		try 
		{
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(vo.getStrHospCode());
			
			
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
	
					
			sb.append("<tr> "
		        + " <td colspan='1'></td>"
		        + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
				//+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
				+ " <td colspan='1'></td></tr>");
			sb.append("</table>");	
//			
			sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
					"<tr> "
					+ " <td colspan='3'></td>"
					+ " <td colspan='3'align='center' style='font-size:18px'>Issue to Patient Report</td>"
					+ " <td colspan='3'></td>");
			sb.append("</tr>");
			sb.append("<tr>"
					+ "<td align='center' colspan='12'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Store Name ::<b>"+fb.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
					
					+ " <tr>"
					+ "<td align='center' colspan='12'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Item Category ::<b>"+fb.getStrItemCategoryName()+"</b></font></td><td align='center' colspan='2'></td></tr>");
//			sb.append("<tr>"
//					+ "<td align='center' colspan='12'>"
//					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
//					+ "For CR No::<b>"+fb.getStrCrNo()+"</b></font></td><td align='center' colspan='2'></td></tr></table>");
			
			sb.append("</table>");
			/*
			 * sb.append("<table align='center' width='").append(strTableWidth).
			 * append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			 * sb.append("<tr><td width='8%'>&nbsp;</td> "); sb.
			 * append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> "
			 * );
			 * 
			 * sb.append(hospitalVO.getHospitalName());
			 * sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			 * sb.append("</tr> "); sb.append("<tr> ");
			 * sb.append("<td width='8%'>&nbsp;</td> "); sb.
			 * append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> "
			 * );
			 * sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" "
			 * :(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.
			 * getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+
			 * ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.
			 * getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)
			 * ?" ":(hospitalVO.getPinCode()))+"");
			 * 
			 * sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			 * sb.append("</tr> "); sb.append("<tr> ");
			 * sb.append("<td width='8%'>&nbsp;</td> "); sb.
			 * append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> "
			 * );
			 * sb.append(vo.getStrReportName()+"</font></b></td><td width='10%'>&nbsp; ");
			 * sb.append("</td> "); sb.append("</tr> "); sb.append("</table> ");
			 */
			sb.append("<br> ");
			sb.append("<br> ");
			
			ws.beforeFirst();
			if(ws != null && ws.size() > 0)
			{				
				sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='0px' cellspacing='0px'> ");				
				sb.append("<tr bgcolor='#cdc9c9'> ");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font>");
				sb.append("</td>");
							
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Patient Name/Age</b></font>");
				sb.append("</td>");	
				
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Date/No</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue By</b></font> ");
				sb.append("</td>");	
				
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch / Rate</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Exp Date</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font> ");
				sb.append("</td>");
				
				sb.append("</tr> ");	
			
				while (ws.next()) 
				{
					/*
					 * 1.Pat_Name
					 * 2.Issue_by_store
					 * 3.Item_name
					 * 4.Issue_qty
					 * 5.Generic_name
					 * 6.Exp_date
					 * 7.Cr_No
					 * 8.Batch_no
					 * 9.Issue_Date/No
					 * 
					 * */
						
					sb.append("<tr> ");					
					sb.append("<td style=\"text-align:center;\" width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");
					sb.append("<td  style=\"text-align:left;\"  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(1)+"<br> - "+ws.getString(7)+"");
					sb.append("</font></td>");
					
					sb.append("<td style=\"text-align:left;\"   width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(9));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:left;\"   width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(2));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:left;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(3));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:left;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(6));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:center;\" width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(4));
					sb.append("</font></td> ");
					sb.append("</tr> ");
					i++;
					
					totalQty = new BigDecimal(ws.getString(4));
					
					grandTotalQty = grandTotalQty.add(totalQty);
					

				}			    		
				
				sb.append("<tr> ");
				sb.append("<td colspan='7' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total:</b></font></td> ");
				sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+grandTotalQty+"</b></font></td> ");
				
				sb.append("</tr> ");
				
				sb.append("</table>");
				
			}			
			else 
			{
				
				
				sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='0px' cellspacing='0px'> ");				
				sb.append("<tr bgcolor='#cdc9c9'> ");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font>");
				sb.append("</td>");
							
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Patient Name/Age</b></font>");
				sb.append("</td>");	
				
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Date/No</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Req By</b></font> ");
				sb.append("</td>");	
				
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch / Rate</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Exp Date</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font> ");
				sb.append("</td>");
				
				sb.append("</tr> ");	
				
				sb.append("<tr><td colspan='8' style='color: red;text-align: center;margin: 7%;padding: 1%;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Details Not Found</b></font></td>");
				
				sb.append("</tr> ");
	
				}			    		
				sb.append("</table>");
				
				

//				sb.append("<tr> ");
//				sb.append("<td colspan='6' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
//				sb.append("</tr> ");

			
			//System.out.println("printItemDetails in hlp: "+sb.toString());

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
		finally {
			
		}
		
		return sb.toString();
	}
	
	public static String getPatientReturnDtls(WebRowSet ws,IssueToPatientDetailRptVO vo, IssueToPatientDetailRptFB fb) throws Exception 
	{

		System.out.println("--------------------- IssueToPatientDetailRptHLP.getPatientReturnDtls -------------------------------");
		StringBuffer sb = new StringBuffer("");
		int i=1;		
		BigDecimal grandTotalQty  = new BigDecimal(BigInteger.ZERO,  2);
		
		BigDecimal totalQty       = null;
		
        BigDecimal grandTotalCost = new BigDecimal(BigInteger.ZERO,  2);
		
		BigDecimal totalCost      = null;
	
		String strTableWidth = "1100";
		try 
		{
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(vo.getStrHospCode());
			
			sb.append("<table  id='mstTable' width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
					
			sb.append("<tr> "
		        + " <td colspan='1'></td>"
		        + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
				//+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
				+ " <td colspan='1'></td></tr>");
			sb.append("</table>");	
			
			sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
					"<tr> "
					+ " <td colspan='3'></td>"
					+ " <td colspan='3'align='center' style='font-size:18px'>Issue to Patient Report</td>"
					+ " <td colspan='3'></td>");
			sb.append("</tr>");
			
			sb.append("<tr>"
					+ "<td align='center' colspan='12'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Store Name ::<b>"+fb.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
					
					+ " <tr>"
					+ "<td align='center' colspan='12'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Item Category ::<b>"+fb.getStrItemCategoryName()+"</b></font></td><td align='center' colspan='2'></td></tr>");
			
//			sb.append("<tr>"
//					+ "<td align='center' colspan='12'>"
//					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
//					+ "For CR No::<b>"+fb.getStrCrNo()+"</b></font></td><td align='center' colspan='2'></td></tr>"); 
					
			sb.append(" <tr> <td align='center' colspan='3'></td>"
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "From Date ::<b>"+vo.getStrFromDate()+"</b> To Date ::<b>"+vo.getStrToDate()+"</b></font></td>"
							+ "<td align='center' colspan='2'>"
							+ "<div id='printid1' class='hidecontrol' style='float:right'>"
							+"</td></tr>");
		    sb.append("</table>");
			
			/*
			 * sb.append("<table align='center' width='").append(strTableWidth).
			 * append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			 * sb.append("<tr><td width='8%'>&nbsp;</td> "); sb.
			 * append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> "
			 * );
			 * 
			 * sb.append(hospitalVO.getHospitalName());
			 * sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			 * sb.append("</tr> "); sb.append("<tr> ");
			 * sb.append("<td width='8%'>&nbsp;</td> "); sb.
			 * append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> "
			 * );
			 * sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" "
			 * :(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.
			 * getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+
			 * ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.
			 * getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)
			 * ?" ":(hospitalVO.getPinCode()))+"");
			 * 
			 * sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			 * sb.append("</tr> "); sb.append("<tr> ");
			 * sb.append("<td width='8%'>&nbsp;</td> "); sb.
			 * append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> "
			 * );
			 * sb.append(vo.getStrReportName()+"</font></b></td><td width='10%'>&nbsp; ");
			 * sb.append("</td> "); sb.append("</tr> "); sb.append("</table> ");
			 */
			sb.append("<br> ");
			sb.append("<br> ");
			
			ws.beforeFirst();
			if(ws != null && ws.size() > 0)
			{				
				sb.append("<table id='mstTable' width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='0px' cellspacing='0px'> ");				
				sb.append("<tr bgcolor='#cdc9c9'> ");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font>");
				sb.append("</td>");
							
				sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Patient Name/Age</b></font>");
				sb.append("</td>");	
				
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Date/No</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return To</b></font> ");
				sb.append("</td>");	
				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Exp Date</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Qty</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font> ");
				sb.append("</td>");
				
				sb.append("</tr> ");	
			
				while (ws.next()) 
				{
					/*
					 * 1.Pat_Name
					 * 2.Return Store
					 * 3.Return No/Date
					 * 4.Item Name
					 * 5.Patient Type
					 * 6.Batch No
					 * 7.Rate/Unit
					 * 8.Return Qty
					 * 9.Total Cost
					 * 10.Exp Date
					 * 11.Patient Catg
					 * 12.Drug Type
					 * 13.PUK No
					 * */
						
					sb.append("<tr> ");					
					sb.append("<td style=\"text-align:center;\" width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");
					sb.append("<td  style=\"text-align:left;\"  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(1)+"<br> - "+ws.getString(13)+"");
					sb.append("</font></td>");
					
					sb.append("<td style=\"text-align:left;\"   width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(3));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:left;\"   width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(2));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:left;\" width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(4));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(10));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:center;\" width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:center;\" width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(9));
					sb.append("</font></td> ");
					
				
					sb.append("</tr> ");
					i++;
					
					totalQty       = new BigDecimal(ws.getString(8));
					
                    grandTotalQty  = grandTotalQty.add(totalQty);
                    
                    totalCost      = new BigDecimal(ws.getString(9));
					
                    grandTotalCost = grandTotalCost.add(totalCost);       
                   					

				}			    		
				sb.append("<tr> ");
				sb.append("<td colspan='6' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total:</b></font></td> ");
				sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+grandTotalQty+"</b></font></td> ");
				sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+grandTotalCost+"</b></font></td> ");
				sb.append("</tr> ");
				sb.append("</table>");
				
			}
				
				
			else 
			{

				sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='0px' cellspacing='0px'> ");				
				sb.append("<tr bgcolor='#cdc9c9'> ");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font>");
				sb.append("</td>");
							
				sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Patient Name/Age</b></font>");
				sb.append("</td>");	
				
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Date/No</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return To</b></font> ");
				sb.append("</td>");	
				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Exp Date</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Qty</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font> ");
				sb.append("</td>");
				
				sb.append("</tr> ");
				
				sb.append("</tr> ");	
				sb.append("<tr><td colspan='8' style='color: red;text-align: center;margin: 7%;padding: 1%;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Details Not Found</b></font></td>");
				sb.append("</tr> ");

			}

			sb.append("</table> ");
			//System.out.println("printItemDetails in hlp: "+sb.toString());

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
		finally {
			
		}
		
		return sb.toString();
	}
	
//validate
}
