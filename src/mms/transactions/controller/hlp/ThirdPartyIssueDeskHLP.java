package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.global.controller.MmsFB;
import mms.global.vo.MmsVO;
import mms.transactions.controller.fb.ThirdPartyIssueDeskFB;
import mms.transactions.vo.ThirdPartyIssueDeskVO;

/**
 * 
 * @author dell
 *
 */
public class ThirdPartyIssueDeskHLP {
	
	
	public static String getItemDetails(ThirdPartyIssueDeskVO voObj)
	 {
		StringBuffer sBuffer = new StringBuffer("");
	//	String strUnit=null;
		String strItemsSancId="";
		 try {
			 WebRowSet wb=voObj.getStrItemDetailsWS();
			 //System.out.println("ItemDetlWS_Size->"+wb.size());
			if(wb.size() != 0)
			{ 
				sBuffer.append("<table class='table'>");
				while(wb.next())
				{		     
	                    voObj.setStrGroupName(wb.getString(8));
	                    voObj.setStrRemarks(wb.getString(17));
	                    sBuffer.append("<input type='hidden' name='strReqNo'  value='"+voObj.getStrReqNo()+"' />");
					    sBuffer.append("<tr>");
						sBuffer.append("<td width='20%' align='left' style='font-weight:350 !important ;font-size: 16px !important;' >" + wb.getString(2) + "</td>");
						sBuffer.append("<td width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>" + wb.getString(3) + "</td>");
						sBuffer.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>" + wb.getString(14) + "</td>");
	  					sBuffer.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"+wb.getString(15)+" "+wb.getString(16)+"</td>");
	  					sBuffer.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"+wb.getString(4)+" "+wb.getString(12)+"</td>");
	  					sBuffer.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important'>"+wb.getString(6)+" "+wb.getString(13)+"</td>");
	  					sBuffer.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important'>"+wb.getString(9)+" "+wb.getString(11)+"</td>");
	  					sBuffer.append("</tr>");	
	  			}
                sBuffer.append("</table>");
               
	     }else {
			    sBuffer.append("<table class='table'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td colspan='7' align='center' style='font-weight:350 !important ;font-size: 16px !important >"
						+ "<div class='errMsg' align='center'> NO RECORD FOUND </div>" + "</td>");

			    sBuffer.append("</tr>");
			    sBuffer.append("</table>");
		   } 
			voObj.setStrItemsSancId(strItemsSancId);
		 }
		 catch(Exception e)
		 {
			 new HisException("Third Party Issue Transaction","ThirdPartyIssueSancTransHLP.getItemDetails()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}
	
	
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
	public static String getIssueDtlsInitView(ThirdPartyIssueDeskVO vo,ThirdPartyIssueDeskFB formBean) throws Exception {

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
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());	
		
		String configIssueRate = mmscofigutil.getStrConfigIssueRate();
		DecimalFormat myFormatter = new DecimalFormat("0.00");

		WebRowSet ws = vo.getWsIssueDetails();
        
		String strIssueDate = "";

		if (formBean.getStrIssueDate().length() > 2) 
		{
			strIssueDate = formBean.getStrIssueDate();
		}
		
		String strTableWidth = "825";

		try 
		{
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
			
			
			HttpServletRequest request=null;
			request = (HttpServletRequest) request;
                         Map require =new HashMap();
			             require.put("REQUEST", request);
			             require.put("FORMAT", "html");
			             require.put("HOSPCODE", formBean.getStrHospitalCode());

                        String strHeader=hisUtil.getHospitalHeaderMain(require); 
//			                        HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
                        System.out.println("----strHeader----"+strHeader);


			sb.append(strHeader.toString());
			                        sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
			                        sb.append("<tr> ");
			                        sb.append("<td align='right'>");
			                         sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			                        sb.append("<img style='cursor: pointer; '  name='PrintPage' tabindex='1' title='Print Page'");
			                        sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();'/> <img style='cursor: pointer; ' title='Cancel Process'  ");
			                        sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup(),cancelToDesk();' /></div>");
			                        sb.append(" </td> ");
			                        sb.append(" </tr> ");
			                        sb.append(" </table> ");
					
			sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Third Party Issue Details</b></font></td></tr></table> ");
 
			

			if (formBean.getStrStoreName().length() != 0) 
			{
				if(!formBean.getStrModeVal().equals("4"))
				{
				sb.append(
								"<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth).append(
								"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>(").append(
								formBean.getStrStoreName()).append(
								")</b></font></td></tr></table>");
				}
				else
				{
					sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
				.append(strTableWidth).append(
						"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Acknowledging Store : ").append(
						formBean.getStrStoreName()).append(
						"</b></font></td></tr></table>");
				}

			}
			
			sb.append(" <br> ");
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");

			
			

				sb.append("<tr> ");
	
				sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue No. :", 15,0)).append(formBean.getStrIssueNo())
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue Date", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strIssueDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
				sb.append("</table> ");
				
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
				
				sb.append("<tr> ");
				sb.append("<td width='22%' align='RIGHT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue To :", 15,0)).append("</b></font></td> ");
				sb.append("<td width='78%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueTo().split("@")[0])
						.append("</b></font></td> ");			
				sb.append("</tr> ");
                sb.append("</table> ");
				
				
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
			sb.append("</td>");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch/Serial No.</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
			sb.append("</td> ");
			if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
			{
				if(formBean.getStrModeVal().equals("2"))
				{
					sb.append("<td align='center' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sanc. Qty</b></font>");
					 sb.append("</td> ");
				}
			   sb.append("<td align='center' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty/Approved Qty</b></font>");
			   sb.append("</td> ");
			   if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
			   {	

			      sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
			      sb.append("</td> ");
			   }
			}
			else
			{
				sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Qty</b></font> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
			    sb.append("</td> ");
			}	
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					NumberFormat formatter = new DecimalFormat("############.##");  	

					if (formBean.getStrModeVal().equals("4")) 
					{
						
						strIssueBy              = ws.getString(28);
						strRecivedBy            = ws.getString(27);
						strItemTotCost  		= ws.getString(30);
						strPurchaseCost 		= ws.getString(32);
						strItemTotCost          = formatter.format(new BigDecimal(ws.getString(30)));
						//System.out.println("ws.getString(33)::::::::::::::::::::::"+ws.getString(33));
						if(ws.getString(33) == null || ws.getString(33).equals(""))
							strItemTotCostWithOutSC = "0";
						else
							strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(33)));
					} 
					else 
					{
						if (formBean.getStrModeVal().equals("2"))
						{							
							strStoreName    		= ws.getString(4);	
							strRemarks              = ws.getString(27);
							strRecivedBy    		= ws.getString(28);
							strItemTotCost          = ws.getString(29);
							
							strPurchaseCost         = ws.getString(33);  // With Unit Like e.g. 161 No.
												    
							strItemTotCost          = formatter.format(new BigDecimal(ws.getString(29)));  
							strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(34)));
						//	strBudgetUsed           = formatter.format(new BigDecimal(ws.getString(35)));
						}
						else
						{
							if(formBean.getStrModeVal().equals("3"))
							{
								
							//	strRemarks   = ws.getString(25);
							//	strRecivedBy = ws.getString(26);
							}
							else
							{
								if(formBean.getStrModeVal().equals("1") || formBean.getStrModeVal().equals("6"))
								{
									
									if(formBean.getStrModeVal().equals("1"))
									{
										strRemarks   = ws.getString(26);
										strRecivedBy = ws.getString(25);
									}
								
									strItemTotCost = formatter.format(new BigDecimal(Double.parseDouble(formatter.format(new BigDecimal(ws.getString(16)))) * Double.parseDouble(ws.getString(19))));
								}
							}
						}
						
					}
					
					cltamt1  = Double.parseDouble(strItemTotCostWithOutSC);
					
					totalCostWithoutSC = totalCostWithoutSC + cltamt1;   //Calculate Total Cost Without Service Charge
					 
					cltamt  = Double.parseDouble(strItemTotCost);    
										
					totalCost = totalCost + cltamt;                      //Calculate Total Cost With Service Charge
											
					sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					
					sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
					sb.append(ws.getString(6));
					sb.append("</b></font></td> ");

					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));//debug
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(9));
					sb.append("</font></td> ");
					if(formBean.getStrModeVal().equals("2"))
					{
						sb.append("<td style=\"text-align:center;\" width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(37));
						sb.append("</font></td> ");
					}
					sb.append("<td style=\"text-align:center;\" width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(10));
					sb.append("</font></td> ");
					if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5") )
					{

						sb.append("</font></td> ");  
						sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(new BigDecimal(strItemTotCost)));
						//myFormatter.format(Double.parseDouble(ws.getString(6)))
						sb.append("</font></td> ");  
					}
					if(formBean.getStrModeVal().equals("5"))
					{
						sb.append("</font></td> ");  
						sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(new Float(ws.getString(10).split(" ")[0])*new Float(ws.getString(9).split("/")[0])));
						//myFormatter.format(Double.parseDouble(ws.getString(6)))
						sb.append("</font></td> ");  
					}
					sb.append("</tr> ");
					i++;
								
				}
								
				if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
				{	
					NumberFormat formatter = new DecimalFormat("############.##");  
				    					
					String ServiceCharge ="";
					
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='left'><hr size='2'></td>");
					sb.append("<td colspan='2' align='center'><hr size='2'></td>");
					
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><div align='right'><b>TOTAL Rs.(Round)</b></div></font></td>");
					sb.append("<td colspan='2' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					//sb.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));	
					sb.append(Math.round(Double.parseDouble(FinaltotalCost)));
					sb.append("</font></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='left'><hr size='2'></td>");
					sb.append("<td colspan='2' align='center'><hr size='2'></td>");
					
					sb.append("</tr>");
					
					
					if(formBean.getStrModeVal().equals("2") || formBean.getStrModeVal().equals("4"))  // To Show Issue Off-Line Voucher
					{
						/*  pkg_mms_view.proc_issue_detail [ Mode 1 ]
						 1.Issue No( Indent Store) , 
						 2.Issue Date 
						 3.Issue To (Pateint Name @ User) 
						 4.Issue Store Name To Issue To 
						 5.Generic name 
						 6.Drug name 
						 7.EXP_Date[DD-MON-YYYY] 
						 8. Rate/Unit 
						 9. Issue Qty/Unit 
						 10.Store Is 
						 11.Item_Id 
						 12. Brand_ID 
						 13.BATCH 
						 14. Exp_Date 
						 15. Rate 
						 16. Rate Unit Id 
						 17. Base Value 
						 18.Issue Qty 
						 19.Issue Qty Unit Id 
						 20.Qty Base Value 
						 21. Item Sl No 
						 22.SL_no 
						 23.Catg_Code 
						 24.Req_Type_Name 
						 25.RECIEVE_BY  
						 26.REMARKS 
						 27.BS_NO 
						 28.HSTSTR_LOCATION @ DL_NO 
						 29.HBLNUM_REQ_NO 
						 30.INDENT_NO^INDENT_DATE^ADMN_NO
						 31.HSTNUM_ICD_CODE 
						 32.SUPP_NAME 
						 33.OPERATION_DTL 
						 34.Issue_By_user_Name 
						 */			
						
						
						/* pkg_mms_view.proc_issue_detail [ Mode 2 ]
						  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
						  1.Issue No
						  2.Issue Date
						  3.Issue To 
						  4.Issue By
						  5.Generic Name
						  6.Brand Name
						  7.Batch No
						  8.Expiry date
						  9.Issue rate
						  10.Issue Qty
						  11.Store Id
						  12.Item Id
						  13.Item Brand ID
						  14.Batch No
						  15.Expiry Date
						  16.Issue Rate
						  17.Issue Rate Unit Id
						  18.Issue Rate Base Unit Id
						  19.Issue Qty
						  20.Issue Qty Unit Id
						  21.Issue Qty Base Value
						  22.Item Sl No
						  23.Item SL No
						  24,Category Code
						  25.Issue Qty
						  26.Remarks
						  27.Final remarks
						  28.Received By
						  29.Cost
						  30.Total Avl Budget
						  31.Indent No
						  32.Indent Date
						  33.Purchase Rate e.g 101 No.
						  34.Cost With Purchae Rate 
						  35.Budget Used
						 */
						String FinaltotalCostWithoutSc = formatter.format(new BigDecimal(totalCostWithoutSC)); 
						if(configIssueRate.equals("") || configIssueRate == null)
							configIssueRate = "0";
						double IssueRatePercentage  = Double.parseDouble(configIssueRate);
						//System.out.println("IssueRatePercentage==>"+IssueRatePercentage);
						//System.out.println("Total Cost Of Item Without SC==>"+FinaltotalCostWithoutSc);
						//System.out.println("Total Cost of Ite With SC==>"+FinaltotalCost);
						
						double PurchaseCost         =  Double.parseDouble(strItemTotCost);
						//double serviceCharge        = totalCost *((IssueRatePercentage-100)/100);
						double serviceCharge        = totalCost - totalCostWithoutSC;
						
						ServiceCharge        = formatter.format(new BigDecimal(serviceCharge));
						//System.out.println("Service Charge==>"+ServiceCharge);
						
						double costWithServiceChag = totalCostWithoutSC + serviceCharge;	
									
						
					}				 
					
				
				}
				if (formBean.getStrModeVal().equals("4")) 
				{

					
					sb.append("<tr> "); 
					sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
					sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
					sb.append(formBean.getStrFinalRemarks());
					sb.append("<br></font></td>");
			        sb.append("</tr> ");
					
					
					sb.append("<tr> ");
					if(!formBean.getStrModeVal().equals("4"))
					{
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("</tr> ");
						sb.append("<tr> ");
	//					sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(").append(strRecivedBy).append(")<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(")
								.append(strIssueBy).append(
										")<br><b> &nbsp;&nbsp;</font></td> ");
					}
					else
					{
						sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br>.</font></td> ");
						sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Acknowledged By :").append(formBean.getStrUserName()).append("<br><b> &nbsp;&nbsp;</font></td> ");
					}
					sb.append("</tr> ");

				} 
				
				else 
				{

					if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
					{
						if(!formBean.getStrModeVal().equals("3"))
						{	
							
					        sb.append("<tr> "); 
							sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received By:</font></td>");
							sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");							
							sb.append(strRecivedBy.trim());									
							sb.append("</font></td>");
					        sb.append("</tr> ");   							
					        sb.append("<tr> "); 
							sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:<b></font></td>");
							sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");
							
							sb.append(strRemarks);	
							sb.append("</font></td>");
					        sb.append("</tr> ");   
					        
					        sb.append("<tr> "); 
							sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Approval Remarks:<b></font></td>");
							sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");							
							sb.append(formBean.getStrApprovalRemarks().trim());	
							sb.append("</font></td>");
					        sb.append("</tr> ");    
					        					       					        
					        sb.append("<tr> ");
					        if(formBean.getStrModeVal().equals("1"))
					        {
					        	sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>[ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;"+formBean.getStrUserName()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
					        	sb.append("</tr> ");      
							    sb.append("<tr> ");
					        	sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>* In case of not issued items , kindly contact billing desk for refund.<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
					        }
					        else{
					        	sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>Issued By : "+formBean.getStrIssueTo().split("@")[1]+"<b>&nbsp;&nbsp;</font></td> ");	
					        }
							sb.append("</tr> ");
							if(formBean.getStrModeVal().equals("2"))
					        {
							sb.append("<tr> ");
				        	sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>Approval Remarks :<b>&nbsp;&nbsp;</font></td></tr> ");
				        	int lth = formBean.getStrApprovalRemarks().split("#").length;
				        	for(int q=0;q<lth;q++)
				        		sb.append("<tr><td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b> "+(q+1)+'.' +formBean.getStrApprovalRemarks().split("#")[q]+"<b>&nbsp;&nbsp;</font></td></tr> ");
				        	//sb.append("</tr> ");
					        }
							//sb.append("<tr> ");
							//sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By on Behalf of RMSCL<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
							//sb.append("</tr> ");
							
						}
						else
						{
							if(formBean.getStrModeVal().equals("3"))
							{
							
								sb.append("<tr> "); 
								sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
								sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
								sb.append(strRemarks);	
								sb.append("<br></font></td>");
						        sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issue By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(formBean.getStrIssueTo().split("@")[1]).append(
												")<b> &nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								
							}
							else
							{
								sb.append("<tr> "); 
								sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
								sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");								
								sb.append(strRemarks);										
								sb.append("<br></font></td>");
						        sb.append("</tr> ");								
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strRecivedBy).append(
												")<b> &nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
							}
						}	
						
										
					}
					else
					{
						
						sb.append("<tr> ");
						sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Received By : "+formBean.getStrIssueTo().split("@")[1]+"<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("</tr> ");
						
					}	
				}

			} 
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available/Requested Qty not available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");
			
			System.out.println("------------ MMSHLP.getIssueDtlsInitView ------[ Mode - "+formBean.getStrModeVal()+"]-----END-----");
			

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



