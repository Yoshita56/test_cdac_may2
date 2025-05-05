package mms.reports.controller.hlp;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.reports.controller.fb.DrugStockRPTFB;
import mms.reports.vo.DrugStockRPTVO;

public class DrugStockRPTHLP {

	private static final String strColor = "red";
	private static final String defaultColor = "blue";

public static String getIssueDetails(DrugStockRPTVO vo) 
	 {
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = vo.getWsItemCategoryCombo();
		int i=1;
		double totamt = 0.00;
		double Quantity = 0.00;
	    try
	    {
	    
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
					/*
					 * sb.
					 * append("<table align='center' cellspacing='1px' cellpadding='1px' border='0'>"
					 * +
					 * " <tr> <td width='8%' colspan='3'><div><img src='/INVMGM/hisglobal/images/logo.png' width='100' style='margin-left: 100%;float: left;'></div></td>"
					 * 
					 * + "<td align='center' colspan='3'>" +
					 * "<font face='Verdana, Arial, Helvetica, sans-serif' size='3'>" +
					 * "<b>"+"Acknowledge Report For Issue"+"</b>" +
					 * "</font></td><td align='center' colspan='2'><div id='printImg'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td></tr>"
					 * 
					 * + " <tr><td align='center' colspan='3'></td> " +
					 * "<td align='center' colspan='3'>" +
					 * "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
					 * "For Ack Name ::<b>"+vo.getStrStoreName()
					 * +"</b></font></td><td align='center' colspan='2'></td></tr>"
					 * 
					 * 
					 * + " <tr><td align='center' colspan='3'></td> " +
					 * "<td align='center' colspan='3'>" +
					 * "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
					 * "For Item Category ::<b>"+vo.getStrCategoryName()
					 * +"</b></font></td><td align='center' colspan='2'></td></tr>"
					 * 
					 * 
					 * + " <tr><td align='center' colspan='3'></td> " +
					 * "<td align='center' colspan='3'>" +
					 * "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
					 * "For ItemName ::<b>"+vo.getStrlpItemName()
					 * +"</b></font></td><td align='center' colspan='2'></td></tr>"
					 * 
					 * + " <tr> <td align='center' colspan='3'></td>" +
					 * "<td align='center' colspan='3'>" +
					 * "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
					 * "From Date ::<b>"+vo.getStrFinancialStartYear()+"</b> To Date ::<b>"+vo.
					 * getStrFinancialEndYear()+"</b></font></td>" +
					 * "<td align='center' colspan='2'>" +
					 * "<div id='printid1' class='hidecontrol' style='float:right'>" +"</td></tr>" +
					 * 
					 * "</table> <br>");
					 */
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ "<tr> "
				        + " <td colspan='1'></td>"
						+ " <td colspan='1'></td>"
						+ " <td colspan='1'><br><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td>");
				sb.append("</tr>");		
						
				sb.append("<tr> "
			        + " <td colspan='1'></td>"
			        + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
					//+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
					+ " <td colspan='1'></td>");
				sb.append("</tr></table>");		
			
				sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
						"<tr> "
						+ " <td colspan='3'></td>"
						+ " <td colspan='3'align='center' style='font-size:15px'><b>Acknowledge Report For Issue</b></td>"
						+ " <td colspan='3'></td>");
				sb.append("</tr>");
				
				
				sb.append(" <tr><td align='center' colspan='3'></td> " +
				  "<td align='center' colspan='3'>" +
				  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
				  "Acknowledged Store Name ::<b>"+vo.getStrStoreName()
				  +"</b></font></td><td align='center' colspan='2'></td></tr>");
				  
				sb.append(" <tr><td align='center' colspan='3'></td> " +
				  "<td align='center' colspan='3'>" +
				  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
				  "For Item Category ::<b>"+vo.getStrCategoryName() 
				  +"</b></font></td><td align='center' colspan='2'></td></tr>");
				 
				sb.append(" <tr><td align='center' colspan='3'></td> " +
						  "<td align='center' colspan='3'>" +
						  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
						  "For Item Name ::<b>"+vo.getStrlpItemName() 
						  +"</b></font></td><td align='center' colspan='2'></td></tr>");
				
				sb.append(" <tr> <td align='center' colspan='3'></td>"
				+ "<td align='center' colspan='3'>"
				+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
				+ "From Date ::<b>"+vo.getStrFinancialStartYear()+"</b> To Date ::<b>"+vo.getStrFinancialEndYear()+"</b></font></td>"
						+ "<td align='center' colspan='2'>"
						+ "<div id='printid1' class='hidecontrol' style='float:right'>"
						+"</td></tr>");
				
				sb.append(" <tr> "
				        + " <td colspan='1'></td>"
						+ " <td colspan='1'></td>"
						+ " <td colspan='1'><br></td>");
				sb.append("</tr>");
			
				sb.append("</table>");
				sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<tr>");
		        sb.append("<td width='5%' align='center'><b>S.No</b>");
			    sb.append("</td>");
		        sb.append("<td width='17%' align='center'><b>Issue No [Date] </b>");
			    sb.append("</td>");
			    sb.append("<td width='15%' align='center'><b>Supplier Name</b>");
			    sb.append("</td>");
			    sb.append("<td width='10%' align='center'><b>Ack By</b>");
			    sb.append("</td>");
			    sb.append("<td width='25%' align='center'><b>Item Name</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Batch No.</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Expiry Date</b>");
		        sb.append("</td>");
		        sb.append("<td width='8%' align='center'><b>Qty</b>");
		        sb.append("</td>");
		        sb.append("</tr>");
				while(ws.next())
				{		
							if(i==0)
							{
//								Quantity = Double.parseDouble(ws.getString(8));
//								totamt = Double.parseDouble(ws.getString(12));
							}
							else
							{
//								Quantity = Quantity + Double.parseDouble(ws.getString(8));
//								totamt = totamt + Double.parseDouble(ws.getString(12));
							}
					
							sb.append("<tr>");
							sb.append("<td  width='5%' align='center' >");							
							sb.append(i);											//	S.No				
							sb.append("</td>");
							sb.append("<td  width='17%' align='center' >");							
							sb.append(ws.getString(1));								//	Issue No/Issue Date				
							sb.append("</td>");
							sb.append("<td  width='15%' align='left'>");
							sb.append(ws.getString(15));							//	Supplier Name							
							sb.append("</td>");
							sb.append("<td  width='10%' align='center'>");
							sb.append(ws.getString(14));							//	Ack By						
							sb.append("</td>");
							
							sb.append("<td  width='25%' align='left'>");
							sb.append(ws.getString(4));								//	Item Name
							sb.append("</td>");
							sb.append("<td  width='10%' align='center'>");								
							sb.append(ws.getString(5));								//	Batch No.					
							sb.append("</td>");
							sb.append("<td  width='10%' align='center'>");
							sb.append(ws.getString(6));								//	Expiry Date
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='right'>");			//  Qty
							sb.append(ws.getString(8));									
							sb.append("</td>");
							
							sb.append("</tr>");
							i++;
							
				}
				
//							sb.append("<tr background-color='red'>");
//							sb.append("<td  colspan='6' align='right'>");
//							sb.append("<b>");
//							sb.append("Total");
//							sb.append("</b>");
//							sb.append("</td>");
//							sb.append("<td align='right'>");
//							sb.append("<b>"+Math.round(Quantity)+"</b>");											
//							sb.append("</td>");
//							sb.append("<td align='right'>");
//							sb.append("");											
//							sb.append("</td>");
//							sb.append("<td align='right'>");
//							sb.append("<b>"+Math.round(totamt)+"</b>");											
//							sb.append("</td>");
//							sb.append("</tr>");
			
				sb.append("</table>");
			}
		else
		{
		 	sb.append("<table align='center' cellspacing='1px' bgcolor='white' cellpadding='1px' border='1px solid black' style='border-collapse:collapse;'>");		
			sb.append("<td ><font color='red'>No Record Found</font></td>");
			sb.append("</tr>");
			sb.append("</table>");
		}
	   } 
		
	 }
	 catch(Exception e)
	 {
		    e.printStackTrace();
		    new HisException("Local Purchase Report","BreakageItemDtlTransHLP.getBreakageDetails()-->",e.getMessage());
	  }
	     //System.out.println("sb"+sb);
	    return sb.toString();
	}

public static String getTransferDetails_OLD(DrugStockRPTVO vo,HttpServletRequest request) 
{
	StringBuffer sb = new StringBuffer("");
	WebRowSet ws = vo.getWsItemCategoryCombo();
	int i=1;
	double totamt = 0.00;
	double Quantity = 0.00;
	String strTableWidth = "825";
	int tot = 0;
    HisUtil hisUtil= null;
    HospitalMstVO hospitalVO=null;
    try 
    {
    
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
				
				hisUtil    = new HisUtil("Global","ReportUtil");
				//
				
				/*
				hospitalVO = hisUtil.getHospitalDetail(vo.getStrHospitalCode());
				sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				
				sb.append("<tr><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td>");
				sb.append("</tr>");		
				
				sb.append("<tr>"
						+ "<td width='10%'>"
						+ "<div><img src='/INVMGM/hisglobal/images/logo.png' width='100' style='margin-left: 100%;float: left;'></div></td> &nbsp;&nbsp;&nbsp;&nbsp;");
				
				sb.append("<td width='80%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> &nbsp;&nbsp;&nbsp;");
				//sb.append(res.getString("REPORT_TITLE"));
				sb.append("&nbsp;&nbsp;&nbsp;"+hospitalVO.getHospitalName());
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				
				sb.append("<tr> ");
				sb.append("<td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
				sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
				//sb.append(res.getString("FULL_TITLE"));
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");	
				
				sb.append("</table> ");		
				
				*/
	
			
	
				//HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
//				Map require =new HashMap();
//				 require.put("REQUEST", request);
//				 require.put("FORMAT", "html");
//				 require.put("HOSPCODE", vo.getStrHospitalCode());
//				
//				String strHeader=hisUtil.getHospitalHeaderMain(require); 
//				//			                        HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
//				System.out.println("----strHeader----"+strHeader);
//	
//	
//				sb.append(strHeader.toString());
                sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
                sb.append("<tr> ");
                sb.append("<td align='right'>");
                 sb.append("<div id='saveId' style='display : block'> <div id='printImg' class='hidecontrol' align='right'>");
                sb.append("<img style='cursor: pointer; '  name='PrintPage' tabindex='1' title='Print Page'");
                sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();'/></div>");
                sb.append(" </td> ");
                sb.append(" </tr> ");
                sb.append("<tr> "
        		        + " <td colspan='1'></td>"
        		        + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
        				//+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
        				+ " <td colspan='1'></td>");
                sb.append(" </tr> ");
                sb.append(" </table> ");
	
				sb.append("<table class='table table-striped table-light border' align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<tr>");
		        sb.append("<td width='5%' align='center' class='py-4'><b>S.No</b>");
			    sb.append("</td>");
		        sb.append("<td width='15%' align='center' class='py-4'><b>Issuing Store</b>");
			    sb.append("</td>");
			    sb.append("<td width='15%' align='center' class='py-4'><b>Drug Code</b>");
		        sb.append("</td>");
			    sb.append("<td width='30%' align='center' class='py-4'><b>Item Name</b>");
		        sb.append("</td>");
			    sb.append("<td width='10%' align='center' class='py-4'><b>Opening Balance</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center' class='py-4'><b>Issue Qty</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center' class='py-4'><b>Closing Balance</b>");
		        sb.append("</td>");	       
		        sb.append("</tr>");
		      
	
				while(ws.next())
				{		
					 /*
				       1. Store Name
				       2. Item Name
				       3. Entry Date
				       4. Opening Balance
				       5. Issue Qty
				       6. Closing Balance
				       7. Drug Code
				    */
						
							sb.append("<tr>");
							sb.append("<td  class='py-4' width='5%' align='center' >");							
							sb.append(i);																		//	S.No				
							sb.append("</td>");
							sb.append("<td class='py-4' width='15%' align='left' >");							
							sb.append(ws.getString(1));														//	Store			
							sb.append("</td>");
							
							sb.append("<td class='py-4' width='15%' align='center'>");
							sb.append(ws.getString(7));															//	Item Code
							sb.append("</td>");
							
							sb.append("<td class='py-4' width='30%' align='left'>");
							sb.append(ws.getString(2));															//	Item Name
							sb.append("</td>");
													
							
							sb.append("<td class='py-4' width='10%' align='center'>");							//  Opening Balance
							sb.append(ws.getString(4));									
							sb.append("</td>");
	
							sb.append("<td class='py-4' width='10%' align='center'>");							//  Issue Qty
							sb.append(ws.getString(5));									
							sb.append("</td>");
							sb.append("<td class='py-4' width='10%' align='left'>");							//  Closing Balance
							sb.append(ws.getString(6));									
							sb.append("</td>");
							
							sb.append("</tr>");
							i++;
							tot      = tot+(Integer.parseInt(ws.getString(5)));
							
				}
				
				sb.append("<tr> ");
				sb.append("<td colspan='5' align='right'  class='py-4'><b>TOTAL :: </b></td>");			
				sb.append("<td colspan='1' align='center' class='py-4'><b>"+tot+"</b></td>");	
				sb.append("<td colspan='1' align='center' class='py-4'><b></b></td>");
				sb.append("</tr>");
	
			
				sb.append("</table>");
			}
		else
		{
		 	sb.append("<table align='center' cellspacing='1px' bgcolor='white' cellpadding='1px' border='1px solid black' style='border-collapse:collapse;'>");		
			sb.append("<td ><font color='red'>No Record Found</font></td>");
			sb.append("</tr>");
			sb.append("</table>");
		}
	   } 
	
 }
 catch(Exception e)
 {
	    e.printStackTrace();
	    new HisException("Local Purchase Report","BreakageItemDtlTransHLP.getBreakageDetails()-->",e.getMessage());
  }
//     System.out.println("sb"+sb);
       return sb.toString();
}

public static String getTransferDetails(DrugStockRPTVO vo,HttpServletRequest request,DrugStockRPTFB formBean) throws Exception 
{
	//WebRowSet wsItem = null;
	StringBuffer br = new StringBuffer(2000);
	
	WebRowSet ws1=null;
	
	int i=0;
	String curSubStoreName="";
	String preSubStoreName="";
	
	String curGroupName="";
	String preGroupName="";
	
	String curOpeningBalance="";
	String preOpeningBalance="";
	
	int count=0;
	DecimalFormat myFormatter = new DecimalFormat("0.00");
	

	double totalCost = 0;
	double subGrpTotalInHandQty = 0;
	
	double totalInHandQty = 0;
		
	
	HisUtil util = new HisUtil("MMS Transactions", "IssueDetailRptHLP");
	try 
	{
			ws1 = vo.getWsItemCategoryCombo(); 
			//make header
			br.append("<div id='wrapper' align='center'>");
			
			br.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
					+ " <tr> "
			//		+ " <td colspan='1'></td>"
		          + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
					//+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
		          );
			//	+ " <td colspan='1'></td>");
			br.append("</tr>");
			
			br.append(" <tr> "				
					+ " <td colspan='12'align='center'><b>Daily Drug Stock</b></td>");				
			br.append("</tr>");
			
			br.append(" <tr> "			
					+ " <td colspan='12'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td>");
			br.append("</tr>");
			
			br.append("</table>");	
			
			br.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"						
					+ " <tr><td align='center' colspan='3'></td> "
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 					
					
					+ " <tr><td align='center' colspan='3'></td> "
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Category ::<b>"+vo.getStrCategoryName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
					
					
					+ " <tr><td align='center' colspan='3'></td> "
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Type ::<b>"+vo.getStrItemBrandName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
					
					+ " <tr><td align='center' colspan='3'></td> "
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "Report Date & Time  ::<b>"+formBean.getStrCurrentDate()+"</b></font></td><td align='center' colspan='2'></td></tr>"
										
					+"</table> <br>");
					 
			
			br.append("<table  width='100%'  align='center' cellspacing='0px' cellpadding='1px' border='1px'>");		
			br.append("<tr id='tableHeaderId' style='background-color:#D3D3D3;'>");			 			
			br.append("<th colspan='1' height='30' style='width: 5%; color:black;'  style='text-center;'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong> S.No. </strong></font></th>");
			br.append("<th colspan='1' height='30' style='width:15%; color:black;'  style='text-center;'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong> Issuing Store </strong></font></th>");
			br.append("<th colspan='1' height='30' style='width:15%; color:black;'	style='text-center;'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong> Drug Code</strong></font></th>");
			br.append("<th colspan='1' height='30' style='width:30%; color:black;'	style='text-center;'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Name</strong></font></th>");
			br.append("<th colspan='1' height='30' style='width:10%; color:black;'  style='text-center;'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong> Opening Stock</strong></font></th>");
			br.append("<th colspan='1' height='30' style='width:10%; color:black;'  style='text-center;'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong> Issue Qty </strong></font></th>");
			br.append("<th colspan='1' height='30' style='width:10%; color:black;'  style='text-center;'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong> Closing Stock</strong></font></th>");

			br.append("</tr>");
			
			
				if (ws1.size() > 0) 
				{				
	
					while (ws1.next()) 
					{
						
						
							//groupTotalCose+=Double.parseDouble(ws1.getString("12"));
							curGroupName       = ws1.getString(2);
							curOpeningBalance  = ws1.getString(4);
							
							
							if((!preGroupName.equals(curGroupName))&& preGroupName !="" )
							{
								
								br.append("<tr bgcolor='' >");
								br.append("<td colspan='5' width='10%' height='20' align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong> Total :</strong></font></td>");
								br.append("<td colspan='1' width='10%' height='20' align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
												+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
								br.append("<td colspan='1' width='10%' height='20' align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+(myFormatter.format(totalInHandQty).split("\\.")[0])+"</strong></font></td>");
								
								br.append("</tr>");
									
								subGrpTotalInHandQty=0;
																
								totalInHandQty    = 0;
									
							}
							 /*
						       1. Store Name
						       2. Item Name
						       3. Entry Date
						       4. Opening Balance
						       5. Issue Qty
						       6. Closing Balance
						       7. Drug Code
						    */
							
							
							
							if(!curGroupName.equals(preGroupName))
							{
								br.append("<tr>");
								
								br.append("<td colspan='4' style=\"text-align:left;  width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><b> "+curGroupName+ "</b></font></td>");
								br.append("<td colspan='1' style=\"text-align:right; width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><b> "+curOpeningBalance+ "</b></font></td>");
								br.append("<td colspan='1' style=\"text-align:left;  width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'></font></td>");
								br.append("<td colspan='1' style=\"text-align:left;  width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'></font></td>");
								br.append("</tr>");
								
								totalInHandQty    = Integer.parseInt(curOpeningBalance);
							}
							
							//System.out.println("---Before SubTract---"+totalInHandQty);							
							subGrpTotalInHandQty  += Integer.parseInt(ws1.getString(5));  // Issue Qty							
							totalInHandQty        = totalInHandQty - Integer.parseInt(ws1.getString(5));							
							//System.out.println("---After SubTract---"+totalInHandQty);
							
							/*
						       1. Store Name
						       2. Item Name
						       3. Entry Date
						       4. Opening Balance
						       5. Issue Qty
						       6. Closing Balance
						       7. Drug Code
						    */
							
								
							br.append("<tr style=''>");
						    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ (i+1) + "</font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:15%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'></font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:15%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'></font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:30%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'></font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'></font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(5) + "</font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ (myFormatter.format(totalInHandQty).split("\\.")[0]) + "</font></td>");
						    br.append("</tr>");
							
							
						
			
						count++;
						i++;
						
						preGroupName      = curGroupName;
						preOpeningBalance = curOpeningBalance;
						
						
						//System.out.println("---A.1--"+i+"-"+totalInHandQty);
					
						
				  }
					 
					  
					  br.append("<tr bgcolor='' >");
					  br.append("<td colspan='5' width='10%' height='20' align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong> Total :</strong></font></td>");
					  br.append("<td colspan='1' width='10%' height='20' align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
										+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
					  br.append("<td colspan='1' width='10%' height='20' align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+(myFormatter.format(totalInHandQty).split("\\.")[0])+"</strong></font></td>");
						
					  br.append("</tr>");
				 
				}
				else 
				{
				br.append("<tr>");
				br.append("<td colspan='7'   height='30' style=\"color: black; font-weight: bold;\" width='100%' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong>No Data Found</strong></font></td>");
				br.append("</tr>");
			
				}
				
				i=i++;
				
				br.append("</table><br><br>");
		} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (ws1 != null) {
			ws1.close();
			ws1 = null;
		}

	}
	
	return (br.toString()+"</div>");
}


}