package mms.transactions.controller.hlp;


import javax.sql.rowset.WebRowSet;

import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.transactions.vo.ReturnAndCondemnationRegisterTransVO;


public class ReturnAndCondemnationRegisterTransHLP {
	public static String getReturnOrCondemnDrugListHlp(ReturnAndCondemnationRegisterTransVO vo) {
		StringBuffer br = new StringBuffer();
		int i = 0 , avlQty = 0;
		WebRowSet wb = vo.getWsNOSQItemDetail();					
		try
		{
			
			if (wb != null && wb.size() > 0) 
			{
				
					br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr class='TITLE'>");
					br.append("<td colspan='9'><div id='' align='left'>Order Details</div></td></tr>");
					br.append("<tr>");
					br.append("<td WIDTH='5%'    colspan='1' class='multiRPTLabel'>#</td>");
					br.append("<td WIDTH='24%'   colspan='1' class='multiRPTLabel'>Drug Name</td>");
					br.append("<td WIDTH='10%'   colspan='1' class='multiRPTLabel'>PO/Date</td>");
					br.append("<td WIDTH='9%'    colspan='1' class='multiRPTLabel'>Batch No</td>");
					br.append("<td WIDTH='8%'    colspan='1' class='multiRPTLabel'>Avl Qty</td>");	
					br.append("<td WIDTH='9%'    colspan='1' class='multiRPTLabel'>Return/Condmn Qty</td>");
					br.append("<td WIDTH='16%'   colspan='1' class='multiRPTLabel'>Action</td>");
					br.append("<td WIDTH='9%'    colspan='1' class='multiRPTLabel'>Order No.</td>");
					br.append("<td WIDTH='10%'   colspan='1' class='multiRPTLabel'>Order Date</td>");
					br.append("</tr> ");
					br.append("</table> ");
					br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px' >");
					while (wb.next()) 
					{
					  /*
						 1 ITEM_NAME
                    	 2 HSTNUM_ITEMBRAND_ID
                    	 3 HSTSTR_BATCH_SL_NO
                    	 4 DECODE(HSTNUM_NEW_ORDER_TYPE,1,'Replacement',2,'Condemnation')
                    	 5 HSTNUM_NEW_ORDER_TYPE
                    	 6 HSTNUM_NEW_ORDER_NO
                    	 7 HSTDT_NEW_ORDER_DATE
                    	 8 DECODE(HSTNUM_DRUG_TYPE_FLAG,1,'NOSQ',2,'Rejected',3,'Expired')
                    	 9 STORE_NAME
                    	10 HSTNUM_STORE_ID
                    	11 AVL_QTY
                    	12 HSTNUM_NEW_ORDER_TYPE
                    	13 HSTNUM_DRUG_TYPE_FLAG
                    	14 HIDDEN_VALUE   (HSTNUM_ITEM_ID || ''^'' || HSTNUM_ITEMBRAND_ID || ''^'' || HSTSTR_BATCH_SL_NO || ''^'' || 
			                    HSTNUM_OLD_PO_NO || ''^'' || HSTNUM_NEW_ORDER_NO || ''^'' || HSTNUM_SUPPLIER_ID || ''^'' || 
			                    HSTNUM_DRUG_TYPE_FLAG||''^''||HSTNUM_NEW_ORDER_TYPE)
			            15 HSTNUM_RET_CONDEMN_QTY        
					  */
						
						
					String strHiddenValue = wb.getString(14)+"^"+wb.getString(11);					
					
					avlQty  = Integer.parseInt(wb.getString(11)) - Integer.parseInt(wb.getString(15));
					
					br.append("<TR>");										
					br.append("<td width='5%' class='multiRPTLabel' id='check"+i+"'><input type='checkbox' title='View' name='strNosqDrugs' value='"+strHiddenValue+ "' id='strNosqDrugs' onclick='onCheckRadioButton(\""+strHiddenValue+"\",\""+ i + "\");'></td>");
					br.append("</td>");						
					br.append("<TD WIDTH='24%'  colspan='1' CLASS='multiRPTControl'>"+ wb.getString(1) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'>"+ wb.getString(16) + "</TD>");
					br.append("<TD WIDTH='9%'   colspan='1' CLASS='multiRPTControl'>"+ wb.getString(3) + "</TD>");
					br.append("<TD WIDTH='8%'   colspan='1' CLASS='multiRPTControl'>"+ avlQty + "</TD>");
					br.append("<TD WIDTH='9%'   colspan='1' CLASS='multiRPTControl'>"+ wb.getString(15) + "</TD>");
					br.append("<TD WIDTH='16%'  colspan='1' CLASS='multiRPTControl'>"+ wb.getString(4) + "</TD>");
					br.append("<TD WIDTH='9%'   colspan='1' CLASS='multiRPTControl'>"+ wb.getString(6) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'>"+ wb.getString(7) + "</TD>");
					
					br.append("</TR>");
					i++;
				}  					
					br.append("</table> ");

						

			}
			if (wb.size() == 0) 
			{
				br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
				br.append("<tr class='TITLE'>");
				br.append("<td colspan='9'><div id='' align='left'>Order Details</div></td></tr>");
				br.append("<tr>");
				br.append("<td WIDTH='5%'    colspan='1' class='multiRPTLabel'>#</td>");
				br.append("<td WIDTH='24%'   colspan='1' class='multiRPTLabel'>Drug Name</td>");
				br.append("<td WIDTH='10%'   colspan='1' class='multiRPTLabel'>PO/Date</td>");
				br.append("<td WIDTH='9%'    colspan='1' class='multiRPTLabel'>Batch No</td>");
				br.append("<td WIDTH='8%'    colspan='1' class='multiRPTLabel'>Avl Qty</td>");	
				br.append("<td WIDTH='9%'    colspan='1' class='multiRPTLabel'>Return/Condmn Qty</td>");
				br.append("<td WIDTH='16%'   colspan='1' class='multiRPTLabel'>Action</td>");
				br.append("<td WIDTH='9%'    colspan='1' class='multiRPTLabel'>Order No.</td>");
				br.append("<td WIDTH='10%'   colspan='1' class='multiRPTLabel'>Order Date</td>");
				br.append("</tr> ");
				br.append("</table> ");
				br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
				br.append("<TR>");
				br.append("<td class='multiRPTControl' colspan='9><b><div id='id' align='center' color='Red'>No Record Found</div></b></td>");
				br.append("</TR>");
				br.append("</table> ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return br.toString();
	}

	public static String getvoucherPrintDetails(ReturnAndCondemnationRegisterTransVO vo) 
	{
		double sum1=0;
		StringBuffer sb = new StringBuffer("");
		String strReceivedQty = "";
		String strOrderNo="" , strOrderDate="";
		HisUtil util = new HisUtil("mms", "getvoucherPrintDetails");
		WebRowSet ws = null ;
		String strTableWidth = "700";
		String Remarks="";
		int sno=1;
		try 
		{
			/*ResourceBundle res = mms.qryHandler_mms.res;
			if(res == null) 
			{
				res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = res;
			}
			ws	=	vo.getWsNOSQItemDetail();
			if (ws != null && ws.size() > 0) 
			{
				ws.next();
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");*/
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(vo.getStrHospitalCode());
			//System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
			//System.out.println("the ws length isa  "+ws.getKeyColumns());
//			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			
			
			
			/*
			RJ47
			sb.append("<table align='center' width='800px' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
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
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			//sb.append(hospitalVO.getCity());
			//sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			ws	=	vo.getWsNOSQItemDetail();
			if (ws != null && ws.size() > 0) 
			{
				ws.next();
			sb.append("</tr> ");
			RJ47	*/		
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
			sb.append("<tr> ");

			ws	=	vo.getWsNOSQItemDetail();
			if (ws != null && ws.size() > 0) 
			{
				ws.next();
			sb.append("</tr> ");
			sb.append("<tr> "
			        + " <td colspan='1'></td>"
			        + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
					//+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
					+ " <td colspan='1'></td>");
				sb.append("</tr></table>");		
			
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			if(ws.getString(16).equals("2"))
			{
			sb.append("<div align='center'><td width='82%'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'>Condemnation voucher</div>");
			}
			else
			{
				sb.append("<div align='center'><td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'>Supplier Debit Note</div>");
			}
			
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");		
			
			sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='").append(strTableWidth).append(
			"'></table> ");
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataForTransfer();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideTransferPopup();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			
//            sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
			 sb.append("<table align='center' cellpadding='1px' cellspacing='1px'> ");

            /*
             1 STORE_NAME,
             2 HSTNUM_STORE_ID
			 3 ITEM_NAME 
             4 BATCH_NO
             5 GNUM_HOSPITAL_CODE
             6 SUPPLIER_NAME
             7 Exp_Date
             8 RET_CONDEMN_QTY
             9 ACTION
             10 ORDER_NO
             11 ORDER_DATE
             12 RET_CONDEMN_DATE
             13 RETURN_TO
             14 CONDEMNATION_TYPE
             15 CONDEMN_REMARKS
             16 HSTNUM_RET_CONDEMN_FLAG
            */
            
            
			}
			ws.beforeFirst();
            if (ws != null && ws.size() > 0) 
			{

            	if(ws.next())
            	{
            		 Remarks=ws.getString(23);
            		if(ws.getString(16).equals("1"))
            		{
            			
            			sb.append("<tr> ");
    					/*sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
    							util.appendSpace("Store Name", 15,0)).append(" : "+ws.getString(1)+"</b></font></td> ");*/
    					
    					if(ws.getString(16).equals("1"))
    					{
    						sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
    							util.appendSpace("<b>Store Name</b>", 15,0)).append(" : "+ws.getString(1)+"</font></td> ");
    						 sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
    									util.appendSpace("<b>Order Date</b>", 15,0)).append(" : "+ws.getString(11)+"</font></td> ");
    					}
    					else
    					{
    						/*sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
    								util.appendSpace("Condemnation Type", 15,0)).append(" : "+ws.getString(14)+"</b></font></td> ");						
    						*/
    						sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
    								util.appendSpace("<b>Store Name</b>", 15,0)).append(" : "+ws.getString(1)+"</font></td> ");
    							 sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
    										util.appendSpace("<b>Order Date</b>", 15,0)).append(" : "+ws.getString(11)+"</font></td> ");
    					}
    					
    				     sb.append("</tr> ");
    				     if(ws.getString(16).equals("1"))
    						{
    				     
    				     sb.append("<tr> ");
    				     sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
    								util.appendSpace("Debit Note No", 15,0)+"</b>").append(" : "+ws.getString(27)+"</font></td> ");
    				     
    				     sb.append("<td width='25%' align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
 								util.appendSpace("<b>Supplier Name</b>", 15,0)).append(" : "+ws.getString(6)+"</font></td> ");
    				     sb.append("</tr> ");
    						}
    				     else
    						{
    				     
    				     sb.append("<tr> ");
    				     sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
    								util.appendSpace("Condemnation voucher No.", 15,0)+"</b>").append(" : "+ws.getString(27)+"</font></td> ");
    				     sb.append("<td width='25%' align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
 								util.appendSpace("<b>Supplier Name</b>", 15,0)).append(" : "+ws.getString(6)+"</font></td> ");
    				     
    				     sb.append("</tr> ");
    						}

					
					 sb.append("<tr colspan='4'> ");
            		 sb.append("<td width='25%' align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
								util.appendSpace("<b>Supplier Address</b>", 15,0)).append(" : "+ws.getString(22)+"</font></td> ");
					 sb.append("</tr> ");
            		}

            	}	
							
			
//				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
				
            	sb.append("<table class='table' align='center' style='border-collapse: collapse; border: 1px solid;'>");
				
				sb.append("<tr bgcolor='#cdc9c9'> ");
				sb.append("<td  width='5%' align='left' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>S.No.</b></font></td>");
				sb.append("<td  width='25%' align='left' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>Item Name</b></font></td>");
				sb.append("<td  width='5%' align='left' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>RC S.No.</b></font> ");
				sb.append("</td>");
				
				sb.append("<td width='8%' align='left' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>Batch No.</b></font> ");
				sb.append("</td> ");
				//sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return/Condemn Qty</b></font> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice No</b></font> ");
				sb.append("</td> ");
				
				/*if(ws.getString(16).equals("2"))
				{
					sb.append("<td align='center' width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Condemnation Type</b></font> ");
					sb.append("</td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Condemn Date</b></font> ");
					sb.append("</td> ");
				}*/
				//else
				//{
					//sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Date</b></font> ");
				sb.append("<td align='center' width='10%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry</b></font></td>  ");
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font></td>  ");
					sb.append("<td align='center' width='27%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks</b></font></td>  ");
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax</b></font></td>  ");
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate(With Tax)</b></font></td>  ");
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty.</b></font></td>  ");
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font></td>  ");
				
				//}
				
				sb.append("</tr> ");

				
						
				ws.beforeFirst();	
				while (ws.next()) 
				{
					sb.append("<tr> ");
					sb.append("<td align='left' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(sno++);
					sb.append("</font></td> ");
					sb.append("<td align='left' width='25%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(3));
					sb.append("</font></td> ");
					sb.append("<td align='left' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(28));
					sb.append("</font></td> ");
					sb.append("<td align='left' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(4));
					sb.append("</font></td> ");
					/*sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));
					sb.append("</font></td> ");*/
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(21));
					sb.append("</font></td> ");
					
					//if(ws.getString(16).equals("2"))
					//{
					//	sb.append("<td align='center' width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					//	sb.append(ws.getString(14));
				//		sb.append("</font></td> ");
				//	}
					
					//sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					//sb.append(ws.getString(12));
					//sb.append("</font></td> ");
					sb.append("<td align='center' width='10%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(17));
					sb.append("</font></td> ");
					
					
					
					sb.append("<td align='left' width='27%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(26));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(24));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(25));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(18));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(19));
					sum1=sum1+Double.parseDouble(ws.getString(19));
					sb.append("</font></td> ");
//					
//					sb.append("<td align='center' width='27%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//					sb.append(ws.getString(26));
//					sb.append("</font></td> ");
//					
					sb.append("</tr> ");
					
					//sb.append("<tr><br/><br/>");
					//sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Remarks : "+ws.getString(15)+"</b><br/><br/></font></td> ");
					//sb.append("</tr> ");
								
				 }
				sb.append("<tr>");
				
				
				
				sb.append("<td colspan='12' style='text-align: right;' ><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Return Total: "+HisUtil.getAmountWithDecimal(sum1,2)+"</font></td> ");
				sb.append("</tr> ");
//				sb.append("<tr>");
//				HisUtil his= new HisUtil("", "");
				
//				sb.append("<td colspan='12' style='text-align: right;' align='left'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Return Amount:</b> "+his.getAmountStr( String.valueOf(HisUtil.getAmountWithDecimal(sum1,0)))+"</b></font></td> ");
//				sb.append("</tr> ");
				sb.append("<tr>");
				//HisUtil his= new HisUtil("", "");
				
				sb.append("<td colspan='12' style='text-align: left;'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:</b> "+Remarks+"</b></font></td> ");
				sb.append("</tr> ");
			} 
			else 
			{

				sb.append("<tr> ");
				sb.append("<td colspan='11' align='center' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/>Details Not Available</font></td> ");
				sb.append("</tr> ");

			}
            
			
			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return sb.toString();
	}	
}