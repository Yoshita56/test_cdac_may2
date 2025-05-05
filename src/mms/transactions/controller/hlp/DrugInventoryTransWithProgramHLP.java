package mms.transactions.controller.hlp;

import java.text.DecimalFormat;

import javax.sql.rowset.WebRowSet;

import global.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.MmsConfigUtil;
import mms.transactions.controller.fb.DrugInventoryWithProgramTransFB;
import mms.transactions.vo.DrugInventoryWithProgramTransVO;

public class DrugInventoryTransWithProgramHLP {
	
	
	public static String getAddItemVoucherView(DrugInventoryWithProgramTransFB formBean,DrugInventoryWithProgramTransVO vo) throws Exception {

		StringBuffer sb = new StringBuffer("");
		String strIssueBy = "";
		String strRecivedBy = "";
		String strPurchaseCost="";
		String strRemarks="";
		/*
		String str2 = "76.39";
		float f = Float.parseFloat(str2);
		String str = "5";
		Float f = new Float(str);
		double d = f.doubleValue();
		
		*/
		double cltamt  = 0.00;
		double totalCost = 0.00;
		
		double cltamt1  = 0.00;
		double totalCostWithoutSC = 0.00;
		
		
		String strStoreName="";
		 String returnTo="";
		int i=1;
		String strItemTotCost="0.00";
		String strItemTotCostWithOutSC ="0.00";
		String strBudgetUsed ="0.00";
	
		
	
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());	
		
		String configIssueRate = mmscofigutil.getStrConfigIssueRate();
		DecimalFormat myFormatter = new DecimalFormat("0.00");

		WebRowSet ws = formBean.getWsItemDetails();
		
		String userName="";
		
		if(ws.next()){
			userName=ws.getString(12);
			ws.previous();
		}
		
        
		String strIssueDate = "";

		String strTableWidth = "100%";

		try 
		{
			
			
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
			//System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
			
			/*sb.append("<br><table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
            sb.append("<tr><td width='8%'><div><img src='/hisglobal/images/logo.png' width='100' style='margin-left: 100%;float: left;'></div></td> ");
            sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
            //sb.append(res.getString("REPORT_TITLE"));
            sb.append(hospitalVO.getHospitalName());
            sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
            sb.append("</tr> ");
            sb.append("<tr> ");
            sb.append("<td width='8%'>&nbsp;</td> ");
            sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
            sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
            //sb.append(res.getString("FULL_TITLE"));
            sb.append("</font></b></td> <td width='10%'><div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>"+
            " <img style='cursor: pointer; ' title='Print Page' "+  
             " src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process' "+  
              " src='../../hisglobal/images/stop.png' onClick='cancelToList();' /> </div></div></td> "); 
            sb.append("</tr> ");
            sb.append("<tr> ");
            sb.append("<td width='8%'>&nbsp;</td> ");
            sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
            //sb.append(hospitalVO.getCity());
            //sb.append(res.getString("CITY"));
            sb.append("</font></b></td><td width='10%'>&nbsp; ");
            sb.append("</td> ");
            sb.append("</tr> ");
            sb.append("</table> "); */
			

			/*sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
			.append(strTableWidth)
			.append("'><TR> "
					+ "<td align='center' colspan='3' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2' ><b>(Offline Entry Voucher)</b></font></td></tr>"
									+ "<TR> <td align='left' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2' ><b>Store Name:</b>"+formBean.getStrStoreName()+"</font></td>"
										+ " <td align='center'><font face='Verdana, Arial, Helvetica, sans-serif' size='2' ></font></td>"
								
								+ "<td align='right' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2' ></font></td></tr>"
										+ "<tr> <td align='left' colspan='4' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2' ><b>Category</b>:Drug</font></td></tr></table> ");
			sb.append(" <br> ");
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("</table> "); */
			
			  sb.append("<table  width='850' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ " <tr> "
						+ " <td colspan='12'><div align='center'>"
						+ "<img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td></tr>");
	    	 
			/*
			 * sb.append("<tr><td colspan='12'>" + "<div id='printid1' align='right'>" +
			 * "<img style='cursor: pointer; float: right;' title='Print Page' src='../../hisglobal/images/stop.png' onclick=\"cancel('CANCELPAGE');\" />"
			 * +
			 * "<img style='cursor: pointer; float: right;' title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onclick='printData();' />"
			 * + "</div></td></tr>");
			 */
			  
			  sb.append("<tr><td colspan='12'>"
				        + "<div id='printid1' align='right'>"
				        + "<img style='cursor: pointer; margin-right: 10px; float: right;' title='Cancel Page' src='../../hisglobal/images/stop.png' onclick=\"cancel('CANCELPAGE');\" />"
				        + "<img style='cursor: pointer; float: right;' title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onclick='printData();' />"
				        + "</div></td></tr>");

				
    		  sb.append("<tr><td width='100%' align='center' colspan='5'>"
    			         + "<font face='Verdana, Arial, Helvetica, sans-serif' size='3'>"
    			         + "<strong>Offline Entry Voucher</strong>"
    			         + "</font></td></tr>");
    		  
    		  sb.append("<tr><td align='center' colspan='12'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><strong>Store Name:</strong> " + formBean.getStrStoreName() + "</font></td></tr>");
    		  sb.append("<tr><td align='center' colspan='12'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><strong>Category:</strong> Drug</font></td></tr>");
    		  sb.append("</table>");

			
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px'  cellspacing='1px' border='1px solid black'> ");
			sb.append("<tr bgcolor='#cdc9c9'> ");
				sb.append("<td align='center' width='5%'><font size='1px' face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
				sb.append("</td>");
							
				sb.append("<td align='center' width='20%'><font size='1px' face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='10%'><font size='1px' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='10%'><font size='1px' face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='10%'><font size='1px' face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur Rate/Unit</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='10%'><font size='1px' face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax %</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='10%'><font size='1px' face='Verdana, Arial, Helvetica, sans-serif' ><b>Adm. Charges %</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='10%'><font size='1px' face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost to Patient</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='15%'><font size='1px' face='Verdana, Arial, Helvetica, sans-serif' ><b>New In hand Qty</b></font> ");
				sb.append("</td> ");
				
            sb.append("</tr> ");
            
            while(ws.next()){
            	
				sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(i);
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(ws.getString(3));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(ws.getString(4));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(ws.getString(5));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(ws.getString(6));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(ws.getString(8));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(ws.getString(9));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(ws.getString(11));
					sb.append("</font></td> ");
		            sb.append("</tr></table>");

				i++;
            	
            }
            sb.append("<br><p align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='2' ><b>User Name:</b>"+userName+"</font></p>");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			mmscofigutil = null;
		}
		return sb.toString();
	}

}
