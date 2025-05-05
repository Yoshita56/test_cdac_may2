package mms.transactions.controller.hlp;

import java.math.BigInteger;

import javax.sql.rowset.WebRowSet;

import com.ibm.icu.math.BigDecimal;
import com.ibm.icu.text.DecimalFormat;
import com.ibm.icu.text.NumberFormat;

import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.transactions.controller.fb.SupplierTransactionRecordFB;
import mms.transactions.vo.SupplierTransactionRecordVO;

public class SupplierTransactionRecordHLP {
	private static final String strColor = "red";
	private static final String defaultColor = "blue";

	
	public static String getPrintItemDetails(WebRowSet ws, String hosCode) throws Exception {
	    System.out.println("--------------------- SupplierTransactionRecordHLP.getPrintItemDetails A-------------------------------");

	    StringBuilder sb = new StringBuilder();
	    String strMrnNo = "", strMrnDate = "", strPONo = "", strPODate = "", strVendor = "", strdcno = "", strUser = "", 
	           strRemarks = "", strLECNo = "AAATEST", strDiffAmount = "0", strItem = "", strbtch = "", strExpiryDt = "", 
	           stritemTax = "", strPurRate = "", strRateWithTax = "", admchg = "", costtopat = "", strRcd = "" ,strCurrentDate = "",strDiff="";
	    
	    int i = 1;  // Serial number counter
	    DecimalFormat myFormatter = new DecimalFormat("0.00");
	    BigDecimal totalAmount = BigDecimal.ZERO;
	    BigDecimal totalDiffAmount = BigDecimal.ZERO;
	    BigDecimal totalNet= BigDecimal.ZERO;



	    try {
	        HisUtil hisUtil = new HisUtil("Global", "ReportUtil");
	        
	        strCurrentDate = hisUtil.getASDate("dd-MMM-yyyy hh:mm"); 

	        HospitalMstVO hospitalVO = hisUtil.getHospitalDetail(hosCode);

	        sb.append("<table class='invoice-table-header-dtls' style='width:100%; font-size: 14px;'>\n");
		        sb.append("<tr>")
		            .append("<td colspan='12' style='text-align: right;'>")
		            .append("<div id='printImg' style='display: inline-block;'>")
		            .append("<img style='cursor: pointer; margin-right: 5px;' title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onclick='printData();' />")
		            .append("<img style='cursor: pointer;' title='Close Page' src='../../hisglobal/images/stop.png' onclick='hideIssuePopup();' />")
		            .append("</div>")
		            .append("</td>")
		        .append("</tr>");
	
		        sb.append("<tr>");
		            sb.append("<td style='width:20%;'></td>");  
		            sb.append("<td style='width:60%; text-align:center;'>");  
		            sb.append("<b>");
		            sb.append(hospitalVO.getHospitalName());
		            sb.append("</b></td>");
		            sb.append("<td style='width:20%;'></td>");  
		        sb.append("</tr>");
	
		        sb.append("<tr>");
		            sb.append("<td style='width:20%;'></td>");  
		            sb.append("<td style='width:60%; text-align:center; font-size: 12px; font-weight:normal;'>");
		            sb.append("<b>");
		            sb.append(((hospitalVO.getAddress1() == "" || hospitalVO.getAddress1() == null) ? " "
		                    : (hospitalVO.getAddress1() + ",")) +
		                    ((hospitalVO.getAddress2() == "" || hospitalVO.getAddress2() == null) ? " "
		                    : (hospitalVO.getAddress2() + ",")) +
		                    ((hospitalVO.getCity() == "" || hospitalVO.getCity() == null) ? " "
		                    : (hospitalVO.getCity() + ",")) +
		                    ((hospitalVO.getPinCode() == "" || hospitalVO.getPinCode() == null) ? " "
		                    : (hospitalVO.getPinCode())));
		            sb.append("</b></td>");
		            sb.append("<td style='width:20%;'></td>");  
	
		        sb.append("</tr>");
	
		        sb.append("<tr>");
		            sb.append("<td style='width:20%;'></td>");  
		            sb.append("<td style='width:60%; text-align:center;'>");
		            sb.append("<b>");
		            sb.append("Material Receipt Note (Local Purchase Offline)</b>");
		            sb.append("</td>");
		            sb.append("<td style='width:20%;'></td>");  
		        sb.append("</tr>");
		        
		        sb.append("<tr>");
			        sb.append("<td style='width:20%;'></td>");  
			        sb.append("<td style='width:60%; text-align:center; font-size: 12px;'>");
			        sb.append("Report Date & Time: <b>").append(strCurrentDate).append("</b>");
			        sb.append("</td>");
			        sb.append("<td style='width:20%;'></td>");  
		        sb.append("</tr>");
	        sb.append("</table>\n");
	        
		    System.out.println("--------------------- SupplierTransactionRecordHLP.getPrintItemDetails B-------------------------------");


//			ws.beforeFirst();
	        if (ws != null && ws.size() > 0) {
	            ws.next();

	            strMrnNo = ws.getString("mrn_no") != null ? ws.getString("mrn_no") : "";
	            strMrnDate = ws.getString("challan_dt") != null ? ws.getString("challan_dt") : "";
	            strPONo = ws.getString("po_no") != null ? ws.getString("po_no") : "";
	            strPODate = ws.getString("hstnum_invoice_date") != null ? ws.getString("hstnum_invoice_date") : "";
	            strVendor = ws.getString("supp_info") != null ? ws.getString("supp_info") : "";
	            strdcno = ws.getString("dc_no") != null ? ws.getString("dc_no") : "";
	            
	            //invoice-table-header-dtls  
	            sb.append("<table class='invoice-table-header-dtls' style='width:100%; font-size: 12px;'>\n");
		            sb.append("<tr><td style='width:48%; text-align:right; padding:5px;'><strong>MRN No:</strong> ")
		                .append(strMrnNo).append("</td>");
		            sb.append("<td style='width:4%;'></td>");  
		            sb.append("<td style='width:48%; text-align:left; padding:5px;'><strong>PO No:</strong> ").append(strPONo)
		                .append("</td></tr>\n");
		            
		            sb.append("<tr><td style='width:48%; text-align:right; padding:5px;'><strong>Vendor:</strong> ").append(strVendor)
		                .append("</td>");
		            sb.append("<td style='width:4%;'></td>");  
		            sb.append("<td style='width:48%; text-align:left; padding:5px;'><strong>DC No:</strong> ")
		                .append(strdcno.split("#")[0]).append("</td></tr>\n");
		            
		            sb.append("<tr><td style='width:48%; text-align:right; padding:5px;'><strong>MRN Date:</strong> ")
		                .append(strMrnDate).append("</td>");
		            sb.append("<td style='width:4%;'></td>");  
		            sb.append("<td style='width:48%; text-align:left; padding:5px;'><strong>PO Date:</strong> ").append(strPODate)
		                .append("</td></tr>\n");
	            sb.append("</table>\n");
	        } 
	         
	        sb.append("<table class='invoice-table'>\n");
            sb.append("<thead><tr>\n");
	            sb.append("<th>S.No.</th>");
                sb.append( "<th>Brand</th>");
                sb.append( "<th>Batch No.</th>");
                sb.append( "<th>Exp Dt</th>");
                sb.append( "<th>Tax</th>");
                sb.append( "<th>Rate</th>");
                sb.append( "<th>Rate(Incl.Tax)</th>");
	            sb.append("<th>Adm Chg</th>");
                sb.append( "<th>Cost to Pat.</th>");
                sb.append( "<th>Rcd</th>");
               // sb.append( "<th>Difference</th>");
                sb.append( "<th>Total</th>\n");
            sb.append("</tr></thead>\n");
            sb.append("<tbody>\n");

            if (ws != null && ws.size() > 0) {
	            
	            strUser = ws.getString("usr") != null ? ws.getString("usr") : "";
	            strRemarks = ws.getString("remarks") != null ? ws.getString("remarks") : "";
	            
	            strItem = ws.getString("item");
                strbtch = ws.getString("btch");
                strExpiryDt = ws.getString("exp_dt");
                stritemTax = ws.getString("item_tax");
                strPurRate = ws.getString("pur_rate");
                strRateWithTax = ws.getString("RATE_WITH_TAX");
                admchg = ws.getString("admchg");
                costtopat = ws.getString("costtopat");
                strRcd = ws.getString("rcd_qty");
             //   strDiff = ws.getString(32);

                
                if (admchg != null && Double.parseDouble(admchg) > 1000) {
                    admchg = "1000.0";
                }

                BigDecimal rateWithTax = strRateWithTax != null ? new BigDecimal(strRateWithTax) : BigDecimal.ZERO;
                BigDecimal rcdQty = strRcd != null ? new BigDecimal(strRcd) : BigDecimal.ZERO;
//                BigDecimal totalCost = rateWithTax.multiply(rcdQty);
                BigDecimal totalCost = (new BigDecimal(strRateWithTax)).multiply(new BigDecimal(strRcd));
            //    BigDecimal totalDiff = new BigDecimal(strDiff);
                
	            sb.append("<tr>\n");
                sb.append("<td>").append(i).append("</td>");
                sb.append("<td style='text-align:left;' >").append(strItem).append("</td>");
                sb.append("<td>").append(strbtch).append("</td>");
                sb.append("<td>").append(strExpiryDt).append("</td>");
                sb.append("<td>").append(stritemTax).append("</td>");
                sb.append("<td>").append(strPurRate).append("</td>");
                sb.append("<td>").append(strRateWithTax).append("</td>");
                sb.append("<td>").append(admchg).append("</td>");
                sb.append("<td>").append(costtopat).append("</td>");
                sb.append("<td>").append(strRcd).append("</td>\n");

                sb.append("<td>").append(myFormatter.format(totalCost)).append("</td>\n");
                sb.append("</tr>\n");

                totalAmount = totalAmount.add(totalCost);
                //totalDiffAmount = totalDiffAmount.add(totalDiff);
                //totalNet = totalAmount.add(totalDiffAmount);

                System.out.println("Total Net: " + totalNet);
                i++;
                
                sb.append("<tr><td colspan='10' style='text-align:right;'>"
                		+ "<strong>TOTAL</strong></td>")
                		//.append("<td>").append(myFormatter.format(totalDiffAmount)).append("</td>")
                		.append("<td>").append(myFormatter.format(totalAmount)).append("</td></tr>\n");

	            sb.append("<tr>");
	            sb.append("<td colspan='10' style='text-align: right;'><strong>NET TOTAL</strong> ")
	               .append("<strong style='margin-left: 5px;'>").append("").append("</strong></td>\n");
	            sb.append("</tr>\n");
	            
                sb.append("<br><tr><td colspan='12' style='text-align: left;'><strong>Remarks:</strong> ").append(strRemarks).append("</td></tr>\n");
                sb.append("<tr><td colspan='12' style='text-align: left;'><strong>Received By:</strong> ").append(strUser).append("</td></tr>\n");

	        } 
            if (i == 1) {
                sb.append("<tr>\n");
                sb.append("<td colspan='12' style='text-align: center; padding:20px; color: red;'>No Records Found</td>\n");
                sb.append("</tr>\n");
            }
	        sb.append("</tbody>\n");
	        sb.append("</table>\n");

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return sb.toString();
	}


	
	public static String getPrintItemDetails_org_old(WebRowSet ws,String hosCode) throws Exception 
	{

		System.out.println("--------------------- SupplierTransactionRecordHLP.getPrintItemDetails -------------------------------");
		StringBuffer sb = new StringBuffer("");
		String strMrnNo = "" , storeName = "",uc_req="",cat="";
		String strMrnDate = "";
		String strPONo="";
		String strPODate="";
		String strVendor="",strdcno="";
		String strItem="";
		String strSup="",strRej="",strRcd="";
		String strAmount="0.00";
		double tot = 0.000,tmpRcd=0.0;
		String strOrderQty="";
		String strExpiryDt="",strbtch="",costtopat="",admchg="" , strmrp="",strPurRate="",strUser="",strRemarks="",strBrandId="",tmpId="0",strBal="",stritemTax="" , strRateWithTax="",manuf="";
		
		String strLECNo="0.00";
		String strDiffAmount="0.00";
		int i=1;
	
		HisUtil util = new HisUtil("mms", "getChallanPrintDetails");
		
		
		String strItemTotCost = "0.00";
		
		DecimalFormat myFormatter = new DecimalFormat("0.00");
	//		
		String strTableWidth = "700";
		
		BigDecimal totalAmount = new BigDecimal(BigInteger.ZERO,  2);
		BigDecimal      amount = new BigDecimal(BigInteger.ZERO,  2);

		try 
		{
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(hosCode);
			
			/*	sb.append("<div id=\"saveId\" style=\"display: block;\">")
				  .append("<div id=\"printid1\" class=\"hidecontrol\" align=\"right\">")
				  .append("<img style=\"cursor: pointer; margin-right: 0px;\" title=\"Print Page\" src=\"../../hisglobal/images/printer_symbol.gif\" ")
				  .append("onclick=\"printDataOne('1')\">")
				  .append("<img style=\"cursor: pointer;\" title=\"Cancel Process\" src=\"../../hisglobal/images/stop.png\" ")
				  .append("onclick=\"cancelPage('GETDATATABLEONSELECTION')\">")
				  .append("</div>") 
				  .append("</div>");*/
			
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
  
			sb.append("<tr><td colspan='12'>"
					+ "<div id='printImg' align='right'>"
					+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' "
					+ "onClick='printData();' />"
					+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' "
					+ "onClick='hideIssuePopup();' />"
					+ "</div></td></tr>");
			
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(hospitalVO.getHospitalName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			sb.append("Material Receipt Note ( Local Purchase Offline ) </font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<br> ");
			sb.append("<br> ");
			
			ws.beforeFirst();
			if(ws != null && ws.size() > 0)
			{
				ws.next();
				/*strMrnNo              = ws.getString("mrn_no");
				strMrnDate            = ws.getString("challan_dt");
				strPONo  		 	  = ws.getString("po_no");
//				strPODate	  		  = ws.getString("po_date");
				strPODate	  		  = ws.getString("invoice_date");
				strVendor             = ws.getString("supp_info");
				strdcno				  = ws.getString("dc_no");
				strUser				  = ws.getString("usr");
				storeName  			  = ws.getString("store");
				uc_req  			  = ws.getString("uc_req");
				cat  			      = ws.getString("cat");
				strRemarks            = ws.getString("remarks");
				strLECNo              = ws.getString("LEC_NO");
				strDiffAmount         = ws.getString("DIFF_AMT");
				*/
				
				strMrnNo              = ws.getString("mrn_no") != null ? ws.getString("mrn_no") : "";
				strMrnDate            = ws.getString("challan_dt") != null ? ws.getString("challan_dt") : "";
				strPONo               = ws.getString("po_no") != null ? ws.getString("po_no") : "";
//				strPODate	  		  = ws.getString("po_date");
				strPODate             = ws.getString("invoice_date") != null ? ws.getString("invoice_date") : ""; 
				strVendor             = ws.getString("supp_info") != null ? ws.getString("supp_info") : "";
				strdcno               = ws.getString("dc_no") != null ? ws.getString("dc_no") : "";
				strUser               = ws.getString("usr") != null ? ws.getString("usr") : "";
				storeName             = ws.getString("store") != null ? ws.getString("store") : "";
				uc_req                = ws.getString("uc_req") != null ? ws.getString("uc_req") : "";
				cat                   = ws.getString("cat") != null ? ws.getString("cat") : "";
				strRemarks            = ws.getString("remarks") != null ? ws.getString("remarks") : "";
				/*strLECNo              = ws.getString("LEC_NO") != null ? ws.getString("LEC_NO") : "";
				strDiffAmount         = ws.getString("DIFF_AMT") != null ? ws.getString("DIFF_AMT") : "0"; */
				strLECNo              ="AAATEST";
				strDiffAmount         = "0"; 
				
				
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
				
				
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Store Name. : </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+storeName +"</b></font></td>");
				sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Category. : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+cat +"</b></font></td>");
				sb.append("</tr> ");
				
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>MRN No. : </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strMrnNo +"</b></font></td>");
				sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>MRN Date. : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1] +"</b></font></td>");
				sb.append("</tr> ");
				
				
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>L.P.O No  : </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strPONo +"</b></font></td>");
				sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>L.P.O Date  : </b></font></td>");
				//sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+ws.getString("lpo_date") +"</b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+ws.getString("PoDate") +"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='17%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice No.: </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[0]+"</b></font></td>");
				sb.append("<td align='right' width='58%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice Date.  : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strMrnDate+"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier  : </b></font></td>");
				sb.append("<td align='left' width='70%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strVendor+"</b></font></td>");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Whether Uc.</b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+uc_req+"</b></font></td>");
				/*sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1]+"</b></font></td>");*/
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>LEC No : </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strLECNo+"</b></font></td>");
				sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Diff in Amt(Rs) : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strDiffAmount+"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='5'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("</table> ");
				
			
			
			sb.append("<table width='725' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.NO.</b></font></td>");
			sb.append("<td align='center' width='40%' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>ITEM DESCRIPTION</b></font></td>");
			sb.append("<td align='center' width='40%'  colspan='6'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>QUANTITY</b></font></td>");
			//sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sup. Qty</b></font></td>");
			//sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rej. Qty</b></font></td>");
			sb.append("<td align='center' width='11%' colspan=6><font face='Verdana, Arial, Helvetica, sans-serif' ><b>AMOUNT</b></font></td>");
			sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
			sb.append("</tr> ");
			
			sb.append("<tr> ");
			sb.append("<td align='center' width='2%'></td>");
			/*sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Generic</b></font></td>");*/
			sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Brand</b></font></td>");
			//sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Manufacturer Name</b></font></td>");
			//sb.append("<td align='left' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Code</b></font></td>");
			sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
			sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Exp Dt</b></font></td>");
			sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax</b></font></td>");
			sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur. Rate</b></font></td>");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur.Rate(With Tax)</b></font></td>");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Adm Chg/Unit</b></font></td>");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost To Pat.</b></font></td>");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rcd</b></font></td>");
			//sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Bal</b></font></td>");
			sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
			sb.append("</tr> ");
			sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
			
			ws.beforeFirst();
			
			 

				while (ws.next()) 
				{
					NumberFormat formatter = new DecimalFormat("################.##");  	
						
						strItem				  = ws.getString("item");
						strSup				  = ws.getString("sup_qty");
						strRej				  = ws.getString("rej_qty");
						strRcd				  = ws.getString("rcd_qty");
						strAmount			  = ws.getString("rate");
						strOrderQty			  = ws.getString("po_qty");
						strmrp				  = ws.getString("mrp");
						strExpiryDt			  = ws.getString("exp_dt");
						strbtch 			  = ws.getString("btch");
						strPurRate			  = ws.getString("pur_rate");
						strBrandId			  = ws.getString("id");
						strBal				  = ws.getString("bal_qty");
						stritemTax			  = ws.getString("item_tax");
						costtopat			  = ws.getString("costtopat");
						admchg				  = ws.getString("admchg");
						if(Double.parseDouble(admchg)>1000)
							admchg = Double.toString(1000.0);
						strRateWithTax = ws.getString("RATE_WITH_TAX");
						manuf = ws.getString("manuf");
						
					
					sb.append("<tr> ");
					sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");					
				
					sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strItem);
					sb.append("</font></td> ");
									
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strbtch);
					sb.append("</font></td> ");
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strExpiryDt);
					sb.append("</font></td> ");
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(stritemTax);
					sb.append("</font></td> ");
					
					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strPurRate);
					sb.append("</font></td> ");
					
					//System.out.println("strPurRate-------"+strPurRate);
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strRateWithTax);
					sb.append("</font></td> ");
					
					//System.out.println("strRateWithTax-------"+strRateWithTax);
					
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(admchg);
					sb.append("</font></td> ");
					
					//System.out.println("admchg-------"+admchg);
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+costtopat+"</font></td> ");
					
					//System.out.println("costtopat-------"+costtopat);
					
					sb.append("<td align='center' width='11%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strRcd);
					sb.append("</font></td> ");							
					 //Amount
					 
					  
					  BigDecimal totalCost = new BigDecimal(strRateWithTax).multiply(new BigDecimal(strRcd));
					 
					  
					 // System.out.println("amount-------"+amount);
					  
					sb.append("<td align='center' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					//sb.append(Math.round((Double.parseDouble(formatter.format(new BigDecimal(strRateWithTax))) * Double.parseDouble(formatter.format(new BigDecimal(strRcd))))* 1000.0)/1000.0);
					sb.append(totalCost);
					sb.append("</font></td></tr> ");
					
					totalAmount = totalAmount.add(totalCost);
													
					
					i++;
					//tot=tot+(Double.parseDouble(formatter.format(new BigDecimal(strRateWithTax))) * Double.parseDouble(formatter.format(new BigDecimal(strRcd))));
					
					tmpId=strBrandId;

				}
				sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='5%' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>TOTAL</b></font></td>");
				sb.append("<td colspan='9'></td>");
				sb.append("<td align='center' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+totalAmount+"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("<tr> ");

			    sb.append("<td colspan='13' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
			    sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Remarks : "+strRemarks+"<b></font><br></td> ");
				
				sb.append("<td colspan='7' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By : "+strUser+"<b></font></td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td colspan='13' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
				sb.append("</tr> ");
				sb.append("</table>");
				
			}
			else 
			{
				sb.append("<tr> ");
				sb.append("<td colspan='6' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
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
	




	public static String getNewReceivedItemsList(SupplierTransactionRecordFB formBean) {

		StringBuffer sb = null;

		final int LMIT_VAL = 10;

		WebRowSet ws = formBean.getWsReceivedItemList();

		try {

			sb = new StringBuffer("");

			if (ws != null && ws.size() > 0) {

				ws.beforeFirst();

				int noOfRecords = ws.size();

				int layerNo = noOfRecords / LMIT_VAL;

				int reminder = noOfRecords % LMIT_VAL;
				int totalLayer = layerNo;

				if (reminder > 0)
					totalLayer = totalLayer + 1;

				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='TITLE' colspan='6'>&nbsp;Received Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr>");
				sb.append("<td class='LABEL' colspan='6'>&nbsp;");
				for (int i = 1; i <= totalLayer; i++) {

					if (i == 1) {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + strColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i + "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					} else {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + defaultColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i + "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					}
				}
				sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr> ");
				sb.append("<td class='multiLabel' width='20%'>Received No. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Received Date ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Institute");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Item Name ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='10%'>Received Qty. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='10%'>Status");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("</table> ");

				for (int i = 1; i <= totalLayer; i++) {

					if (i != totalLayer && totalLayer != 1) {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i + "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i + "' style='display:none'>");
						}
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						for (int j = 0; j < LMIT_VAL; j++) {
							ws.next();

							sb.append("<tr> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='10%'>").append(ws.getString(5));
							sb.append("</td> ");
							if (ws.getString(6).equals("0")) {
								sb.append("<td class='multiControl' width='10%'>Active");
								sb.append("</td> ");
							}
							if (ws.getString(6).equals("40")) {
								sb.append("<td class='multiControl' width='10%'>Pending");
								sb.append("</td> ");
							}
							sb.append("</tr> ");
						}
						sb.append("</table>");
						sb.append("</div>");

					} else {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i + "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i + "' style='display:none'>");
						}

						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						for (int k = 0; k < reminder; k++) {
							ws.next();
							sb.append("<tr> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='10%'>").append(ws.getString(5));
							sb.append("</td> ");
							if (ws.getString(6).equals("0")) {
								sb.append("<td class='multiControl' width='10%'>Active");
								sb.append("</td> ");
							}
							if (ws.getString(6).equals("40")) {
								sb.append("<td class='multiControl' width='10%'>Pending");
								sb.append("</td> ");
							}
							sb.append("</tr> ");

						}
						sb.append("</table>");
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						sb.append("<tr> ");
						sb.append("<td class='TITLE' colspan='6'>");
						sb.append("</td> ");
						sb.append("</tr>  ");
						sb.append("</table>");
						sb.append("</div>");

					}

				}

			} else {
				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='TITLE' colspan='6'>&nbsp;Received Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr> ");
				sb.append("<td class='multiLabel' width='20%'>Gifted No. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Gifted Date ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Gifted By ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Item Name ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='10%'>Qty. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='10%'>Status");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("</table> ");

				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append(
						"<tr><td class='multiControl' colspan='5' ><font color='red'>No Matching Record Found</font></td></tr>");
				sb.append("</table>");

			}

		} catch (Exception e) {

		}
		return sb.toString();
	}

	public static String getNewReceivedItemsListNEW(SupplierTransactionRecordFB formBean) {

		StringBuffer sb = null;

		final int LMIT_VAL = 10;

		WebRowSet ws = formBean.getWsReceivedItemList();

		try {

			sb = new StringBuffer("");

			if (ws != null && ws.size() > 0) {

				ws.beforeFirst();

				int noOfRecords = ws.size();

				int layerNo = noOfRecords / LMIT_VAL;

				int reminder = noOfRecords % LMIT_VAL;
				int totalLayer = layerNo;

				if (reminder > 0)
					totalLayer = totalLayer + 1;

				sb.append("<table class='table table-striped' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='float-left' colspan='6'>&nbsp;Received Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr>");
				sb.append("<td class='LABEL' colspan='6'>&nbsp;");
				for (int i = 1; i <= totalLayer; i++) {

					if (i == 1) {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + strColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i + "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					} else {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + defaultColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i + "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					}
				}
				sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr> ");
				sb.append("<td class='' width='20%'>Received No. ");
				sb.append("</td> ");
				sb.append("<td class='' width='20%'>Received Date ");
				sb.append("</td> ");
				sb.append("<td class='' width='20%'>Institute");
				sb.append("</td> ");
				sb.append("<td class='' width='20%'>Item Name ");
				sb.append("</td> ");
				sb.append("<td class='' width='10%'>Received Qty. ");
				sb.append("</td> ");
				sb.append("<td class='' width='10%'>Status");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("</table> ");

				for (int i = 1; i <= totalLayer; i++) {

					if (i != totalLayer && totalLayer != 1) {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i + "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i + "' style='display:none'>");
						}
						sb.append(
								"<table class='table table-striped' align='center' cellpadding='1px' cellspacing='1px'> ");
						for (int j = 0; j < LMIT_VAL; j++) {
							ws.next();

							sb.append("<tr> ");
							sb.append("<td class='' width='20%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='' width='20%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='' width='20%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");
							sb.append("<td class='' width='10%'>").append(ws.getString(5));
							sb.append("</td> ");
							if (ws.getString(6).equals("0")) {
								sb.append("<td class='' width='10%'>Active");
								sb.append("</td> ");
							}
							if (ws.getString(6).equals("40")) {
								sb.append("<td class='' width='10%'>Pending");
								sb.append("</td> ");
							}
							sb.append("</tr> ");
						}
						sb.append("</table>");
						sb.append("</div>");

					} else {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i + "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i + "' style='display:none'>");
						}

						sb.append(
								"<table class='table table-striped' align='center' cellpadding='1px' cellspacing='1px'> ");
						for (int k = 0; k < reminder; k++) {
							ws.next();
							sb.append("<tr> ");
							sb.append("<td class='' width='20%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='' width='20%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='' width='20%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");
							sb.append("<td class='' width='10%'>").append(ws.getString(5));
							sb.append("</td> ");
							if (ws.getString(6).equals("0")) {
								sb.append("<td class='' width='10%'>Active");
								sb.append("</td> ");
							}
							if (ws.getString(6).equals("40")) {
								sb.append("<td class='' width='10%'>Pending");
								sb.append("</td> ");
							}
							sb.append("</tr> ");

						}
						sb.append("</table>");
						sb.append(
								"<table class='table table-striped' align='center' cellpadding='1px' cellspacing='1px'> ");
						sb.append("<tr> ");
						sb.append("<td class='TITLE' colspan='6'>");
						sb.append("</td> ");
						sb.append("</tr>  ");
						sb.append("</table>");
						sb.append("</div>");

					}

				}

			} else {
				sb.append(
						"<table class='table table-striped text-uppercase' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='' colspan='6'>&nbsp;Received Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr> ");
				sb.append("<td class='' width='20%' style='font-weight:bold;'>Gifted No. ");
				sb.append("</td> ");
				sb.append("<td class='' width='20%' style='font-weight:bold;'>Gifted Date ");
				sb.append("</td> ");
				sb.append("<td class='' width='20%' style='font-weight:bold;'>Gifted By ");
				sb.append("</td> ");
				sb.append("<td class='' width='20%' style='font-weight:bold;'>Item Name ");
				sb.append("</td> ");
				sb.append("<td class='' width='10%' style='font-weight:bold;'>Qty. ");
				sb.append("</td> ");
				sb.append("<td class='' width='10%' style='font-weight:bold;'>Status");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("</table> ");

				sb.append("<table class='table' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr><td class='' colspan='5' ><font color='red'>No Matching Record Found</font></td></tr>");
				sb.append("</table>");

			}

		} catch (Exception e) {

		}

		return sb.toString();
	}

	public static String getUpdateReceivedItemsList(SupplierTransactionRecordFB formBean) {

		StringBuffer sb = null;

		final int LMIT_VAL = 10;

		WebRowSet ws = formBean.getWsReceivedItemList();

		try {

			sb = new StringBuffer("");

			if (ws != null && ws.size() > 0) {

				ws.beforeFirst();

				int noOfRecords = ws.size();

				int layerNo = noOfRecords / LMIT_VAL;

				int reminder = noOfRecords % LMIT_VAL;
				int totalLayer = layerNo;

				if (reminder > 0)
					totalLayer = totalLayer + 1;

				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='TITLE' colspan='6'>&nbsp;Received Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr>");
				sb.append("<td class='LABEL' colspan='6'>&nbsp;");
				for (int i = 1; i <= totalLayer; i++) {

					if (i == 1) {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + strColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i + "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					} else {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + defaultColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i + "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					}
				}
				sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr> ");
				sb.append("<td class='multiLabel' width='10%'>#");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='15%'>Received No");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='15%'>Received Date ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Institute");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Item Name ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Received Qty");
				sb.append("</td> ");

				sb.append("</tr>  ");
				sb.append("</table> ");

				for (int i = 1; i <= totalLayer; i++) {

					if (i != totalLayer && totalLayer != 1) {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i + "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i + "' style='display:none'>");
						}
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						for (int j = 0; j < LMIT_VAL; j++) {
							ws.next();

							sb.append("<tr> ");

							sb.append("<td class='multiControl' width='10%'>");
							sb.append("<input type='radio'  name='strReceivedItemApprovedMode' value='1'/>");
							sb.append("</td> ");

							sb.append("<td class='multiControl' width='15%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='15%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(5));
							sb.append("</td> ");

							sb.append("</tr> ");
						}
						sb.append("</table>");
						sb.append("</div>");

					} else {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i + "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i + "' style='display:none'>");
						}

						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						for (int k = 0; k < reminder; k++) {
							ws.next();
							sb.append("<tr> ");
							sb.append("<td class='multiControl' width='10%'>");
							sb.append("<input type='radio'  name='strReceivedItemApprovedMode' value='1'/>");
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='15%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='15%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");

							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(5));
							sb.append("</td> ");

							sb.append("</tr> ");

						}
						sb.append("</table>");
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						sb.append("<tr> ");
						sb.append("<td class='TITLE' colspan='6'>");
						sb.append("</td> ");
						sb.append("</tr>  ");
						sb.append("</table>");
						sb.append("</div>");

					}

				}

			} else {
				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='TITLE' colspan='6'>&nbsp;Received Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr> ");
				sb.append("<td class='multiLabel' width='20%'>Gifted No. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Gifted Date ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Gifted By ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Item Name ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Qty. ");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("</table> ");

				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append(
						"<tr><td class='multiControl' colspan='5' ><font color='red'>No Matching Record Found</font></td></tr>");
				sb.append("</table>");
			}

		} catch (Exception e) {

		}
		return sb.toString();
	}

	public static String getUpdateReceivedItemsListNEW(SupplierTransactionRecordFB formBean) {

		StringBuffer sb = null;

		final int LMIT_VAL = 10;

		WebRowSet ws = formBean.getWsReceivedItemList();

		try {

			sb = new StringBuffer("");

			if (ws != null && ws.size() > 0) {

				ws.beforeFirst();

				int noOfRecords = ws.size();

				int layerNo = noOfRecords / LMIT_VAL;

				int reminder = noOfRecords % LMIT_VAL;
				int totalLayer = layerNo;

				if (reminder > 0)
					totalLayer = totalLayer + 1;

				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='TITLE' colspan='6'>&nbsp;Received Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr>");
				sb.append("<td class='LABEL' colspan='6'>&nbsp;");
				for (int i = 1; i <= totalLayer; i++) {

					if (i == 1) {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + strColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i + "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					} else {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + defaultColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i + "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					}
				}
				sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr> ");
				sb.append("<td class='multiLabel' width='10%'>#");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='15%'>Received No");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='15%'>Received Date ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Institute");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Item Name ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Received Qty");
				sb.append("</td> ");

				sb.append("</tr>  ");
				sb.append("</table> ");

				for (int i = 1; i <= totalLayer; i++) {

					if (i != totalLayer && totalLayer != 1) {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i + "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i + "' style='display:none'>");
						}
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						for (int j = 0; j < LMIT_VAL; j++) {
							ws.next();

							sb.append("<tr> ");

							sb.append("<td class='multiControl' width='10%'>");
							sb.append("<input type='radio'  name='strReceivedItemApprovedMode' value='1'/>");
							sb.append("</td> ");

							sb.append("<td class='multiControl' width='15%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='15%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(5));
							sb.append("</td> ");

							sb.append("</tr> ");
						}
						sb.append("</table>");
						sb.append("</div>");

					} else {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i + "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i + "' style='display:none'>");
						}

						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						for (int k = 0; k < reminder; k++) {
							ws.next();
							sb.append("<tr> ");
							sb.append("<td class='multiControl' width='10%'>");
							sb.append("<input type='radio'  name='strReceivedItemApprovedMode' value='1'/>");
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='15%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='15%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");

							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(5));
							sb.append("</td> ");

							sb.append("</tr> ");

						}
						sb.append("</table>");
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						sb.append("<tr> ");
						sb.append("<td class='TITLE' colspan='6'>");
						sb.append("</td> ");
						sb.append("</tr>  ");
						sb.append("</table>");
						sb.append("</div>");

					}

				}

			} else {
				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='TITLE' colspan='6'>&nbsp;Received Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr> ");
				sb.append("<td class='multiLabel' width='20%'>Gifted No. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Gifted Date ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Gifted By ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Item Name ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Qty. ");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("</table> ");

				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append(
						"<tr><td class='multiControl' colspan='5' ><font color='red'>No Matching Record Found</font></td></tr>");
				sb.append("</table>");
			}

		} catch (Exception e) {

		}
		return sb.toString();
	}

	public static String getReceivedItemsListtest(SupplierTransactionRecordFB formBean) {

		StringBuffer sb = null;

		final int LMIT_VAL = 10;

		WebRowSet ws = formBean.getWsReceivedItemList();

		try {

			sb = new StringBuffer("");

			if (ws != null && ws.size() > 0) {

				ws.beforeFirst();

				int noOfRecords = ws.size();

				int layerNo = noOfRecords / LMIT_VAL;

				int reminder = noOfRecords % LMIT_VAL;
				int totalLayer = layerNo;

				if (reminder > 0)
					totalLayer = totalLayer + 1;

				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='TITLE' colspan='7'>&nbsp;Received Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");

				sb.append("<tr>");
				sb.append("<td class='LABEL' colspan='7'>&nbsp;");
				for (int i = 1; i <= totalLayer; i++) {

					if (i == 1) {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + strColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i + "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					} else {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + defaultColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i + "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					}
				}
				sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr> ");
				sb.append("<td class='multiLabel' width='20%'>Received No. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='10%'>Received Date ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Third Party Name");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Drug Name ");
				sb.append("</td> ");

				sb.append("<td class='multiLabel' width='10%'>Batch No. ");
				sb.append("</td> ");

				sb.append("<td class='multiLabel' width='10%'>Expiry Date ");
				sb.append("</td> ");

				sb.append("<td class='multiLabel' width='10%'>Received Qty. ");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("</table> ");

				for (int i = 1; i <= totalLayer; i++) {

					if (i != totalLayer && totalLayer != 1) {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i + "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i + "' style='display:none'>");
						}
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						for (int j = 0; j < LMIT_VAL; j++) {
							ws.next();

							sb.append("<tr> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='10%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='10%'>").append(ws.getString(6));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='10%'>").append(ws.getString(8));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='10%'>").append(ws.getString(5));
							sb.append("</td> ");
							sb.append("</tr> ");
						}
						sb.append("</table>");
						sb.append("</div>");

					} else {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i + "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i + "' style='display:none'>");
						}

						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						for (int k = 0; k < reminder; k++) {
							ws.next();
							sb.append("<tr> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='10%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='10%'>").append(ws.getString(6));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='10%'>").append(ws.getString(8));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='10%'>").append(ws.getString(5));
							sb.append("</td> ");
							sb.append("</tr> ");

						}
						sb.append("</table>");
						sb.append("</div>");

					}

				}

			} else {
				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='TITLE' colspan='7'>&nbsp;Received Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr> ");
				sb.append("<td class='multiLabel' width='20%'>Received No. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Received Date ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Received By ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Drug Name ");
				sb.append("</td> ");

				sb.append("<td class='multiLabel' width='10%'>Batch No. ");
				sb.append("</td> ");

				sb.append("<td class='multiLabel' width='10%'>Expiry Date ");
				sb.append("</td> ");

				sb.append("<td class='multiLabel' width='20%'>Received Qty.");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("</table> ");

				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append(
						"<tr><td class='multiControl' colspan='7' ><font color='red'>No Matching Record Found</font></td></tr>");
				sb.append("</table>");
			}

		} catch (Exception e) {

		}
		return sb.toString();
	}

	/*	ORG
		public static String getReceivedItemsList(SupplierTransactionRecordFB formBean) {
	
			StringBuffer sb = null;
	
			final int LMIT_VAL = 10;
	
			WebRowSet ws = formBean.getWsReceivedItemList();
	
			try {
	
				sb = new StringBuffer("");
	
				
					if (ws != null && ws.size() > 0) {
	
						ws.beforeFirst();
	
						int noOfRecords = ws.size();
	
						int layerNo = noOfRecords / LMIT_VAL;
	
						int reminder = noOfRecords % LMIT_VAL;
						int totalLayer = layerNo;
	
						if (reminder > 0)
							totalLayer = totalLayer + 1;
	
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						sb.append("<tr> ");
						sb.append("<td class='TITLE' colspan='7'>&nbsp;Received Item Details");
						sb.append("</td> ");
						sb.append("</tr>  ");
						
						sb.append("<tr>");
						sb.append("<td class='LABEL' colspan='7'>&nbsp;");
						for (int i = 1; i <= totalLayer; i++) {
	
							if (i == 1) {
								sb.append("<a STYLE='CURSOR:POINTER; color:"+ strColor + "' name='linId' id='linId" + i
										+ "' onClick='layerIndexNavigator(\"" + i
										+ "\",\"" + totalLayer + "\")'>" + i
										+ "</a> &nbsp;");
							}
							else 
							{
								sb.append("<a STYLE='CURSOR:POINTER; color:"+ defaultColor + "' name='linId' id='linId"	+ i + "' onClick='layerIndexNavigator(\""
										+ i + "\",\"" + totalLayer + "\")'>" + i
										+ "</a> &nbsp;");
							}
						}
						sb.append("</td>");
						sb.append("</tr>");
	
						sb.append("<tr> ");
						sb.append("<td class='multiLabel' width='20%'>Received No. ");
						sb.append("</td> ");
						sb.append("<td class='multiLabel' width='10%'>Received Date ");
						sb.append("</td> ");
						sb.append("<td class='multiLabel' width='20%'>Third Party Name");
						sb.append("</td> ");
						sb.append("<td class='multiLabel' width='20%'>Drug Name ");
						sb.append("</td> ");
						
						sb.append("<td class='multiLabel' width='10%'>Batch No. ");
						sb.append("</td> ");
						
						sb.append("<td class='multiLabel' width='10%'>Expiry Date ");
						sb.append("</td> ");
						
						sb.append("<td class='multiLabel' width='10%'>Received Qty. ");
						sb.append("</td> ");
						sb.append("</tr>  ");
						sb.append("</table> ");
	
						for (int i = 1; i <= totalLayer; i++) {
	
							if (i != totalLayer && totalLayer != 1) {
								if (i == 1) {
									sb.append("<div id='tariffDivId" + i
											+ "' style='display:block'>");
								} else {
									sb.append("<div id='tariffDivId" + i
											+ "' style='display:none'>");
								}
								sb
										.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
								for (int j = 0; j < LMIT_VAL; j++) {
									ws.next();
	
									sb.append("<tr> ");
									sb.append("<td class='multiControl' width='20%'>").append(ws.getString(1));
									sb.append("</td> ");
									sb.append("<td class='multiControl' width='10%'>").append(ws.getString(2));
									sb.append("</td> ");
									sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
									sb.append("</td> ");
									sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
									sb.append("</td> ");
									sb.append("<td class='multiControl' width='10%'>").append(ws.getString(6));
									sb.append("</td> ");
									sb.append("<td class='multiControl' width='10%'>").append(ws.getString(8));
									sb.append("</td> ");
									sb.append("<td class='multiControl' width='10%'>").append(ws.getString(5));
									sb.append("</td> ");
									sb.append("</tr> ");
								}
								sb.append("</table>");
								sb.append("</div>");
	
							} else {
								if (i == 1) {
									sb.append("<div id='tariffDivId" + i
											+ "' style='display:block'>");
								} else {
									sb.append("<div id='tariffDivId" + i
											+ "' style='display:none'>");
								}
	
								sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
								for (int k = 0; k < reminder; k++) {
									ws.next();
									sb.append("<tr> ");
									sb.append("<td class='multiControl' width='20%'>").append(ws.getString(1));
									sb.append("</td> ");
									sb.append("<td class='multiControl' width='10%'>").append(ws.getString(2));
									sb.append("</td> ");
									sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
									sb.append("</td> ");
									sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
									sb.append("</td> ");
									sb.append("<td class='multiControl' width='10%'>").append(ws.getString(6));
									sb.append("</td> ");
									sb.append("<td class='multiControl' width='10%'>").append(ws.getString(8));
									sb.append("</td> ");
									sb.append("<td class='multiControl' width='10%'>").append(ws.getString(5));
									sb.append("</td> ");
									sb.append("</tr> ");
	
								}
								sb.append("</table>");
								sb.append("</div>");
	
							}
	
						}
	
					} else {
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						sb.append("<tr> ");
						sb.append("<td class='TITLE' colspan='7'>&nbsp;Received Item Details");
						sb.append("</td> ");
						sb.append("</tr>  ");
						sb.append("<tr> ");
						sb.append("<td class='multiLabel' width='20%'>Received No. ");
						sb.append("</td> ");
						sb.append("<td class='multiLabel' width='20%'>Received Date ");
						sb.append("</td> ");
						sb.append("<td class='multiLabel' width='20%'>Received By ");
						sb.append("</td> ");
						sb.append("<td class='multiLabel' width='20%'>Drug Name ");
						sb.append("</td> ");
						
						sb.append("<td class='multiLabel' width='10%'>Batch No. ");
						sb.append("</td> ");
						
						sb.append("<td class='multiLabel' width='10%'>Expiry Date ");
						sb.append("</td> ");
						
						sb.append("<td class='multiLabel' width='20%'>Received Qty.");
						sb.append("</td> ");
						sb.append("</tr>  ");
						sb.append("</table> ");
						
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						sb.append("<tr><td class='multiControl' colspan='7' ><font color='red'>No Matching Record Found</font></td></tr>");
						sb.append("</table>");
					}
	
			
			} catch (Exception e) {
	
			} 
	
			return sb.toString();
	
		}
	*/

	public static String getReceivedItemsList(SupplierTransactionRecordFB formBean, SupplierTransactionRecordVO vo) {
		StringBuffer sb = new StringBuffer();

		WebRowSet ws = formBean.getWsReceivedItemList();
		String strStoreId = "";
		String strStoreName = "";

		String strItemCategoryId = "";
		String strItemCategoryNo = "";

		String strFinancialStartYear = "";
		String strFinancialEndYear = "";
		String strReceivedNo = ""; // Initialize outside the loop

		try {
			if (ws != null && ws.size() > 0) {
				ws.beforeFirst();
				sb.append("<div id='wrapper'>");
				sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");

				sb.append("<tr>");
				sb.append(
						"<td colspan='12' align='left' style='font-size:18px;font-weight:normal;'>Received Item Details</td>");
				sb.append("</tr>");

				sb.append("</table>");

				sb.append("<div id='tariffDivId1' style='display:block'>");
				sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='1px'>");
				sb.append("<tr>");
				sb.append("<th style='width:5%;'>S.No.</th>");
				sb.append("<th style='width:10%;'>Received No.</th>");
				sb.append("<th style='width:15%;'>Received Date</th>");
				sb.append("<th style='width:20%;'>Third Party Name</th>");
				sb.append("<th style='width:20%;'>Drug Name</th>");
				sb.append("<th style='width:10%;'>Batch No.</th>");
				sb.append("<th style='width:10%;'>Expiry Date</th>");
				sb.append("<th style='width:10%;'>Received Qty.</th>");
				sb.append("<th style='width:5%;'>#</th>");
				sb.append("</tr>");

				int i = 1;
				while (ws.next()) {
					strReceivedNo = ws.getString(1);

					strStoreId = vo.getStrStoreId();
					strStoreName = vo.getStrStoreName();
					strItemCategoryId = vo.getStrItemCategoryId();
					strItemCategoryNo = vo.getStrItemCategoryNo();

					strFinancialStartYear = vo.getStrFinancialStartYear();
					strFinancialEndYear = vo.getStrFinancialEndYear();

					sb.append("<input type='hidden' name='strHlpStoreId'    id='strHlpStoreId" + i + "'  value="
							+ strStoreId + " />");
//					   sb.append("<input type='hidden' name='strHlpStoreName'    id='strHlpStoreName"    +i+ "'  value=" + strStoreName + " />");
					sb.append("<input type='hidden' name='strHlpStoreName' id='strHlpStoreName" + i + "' value=\""
							+ strStoreName + "\" />");

					sb.append("<input type='hidden' name='strHlpItemCategoryNo'    id='strHlpItemCategoryNo" + i
							+ "'  value=" + strItemCategoryNo + " />");

					sb.append("<input type='hidden' name='strHlpFinancialStartYear'    id='strHlpFinancialStartYear" + i
							+ "'  value=" + strFinancialStartYear + " />");
					sb.append("<input type='hidden' name='strHlpFinancialEndYear'    id='strHlpFinancialEndYear" + i
							+ "'  value=" + strFinancialEndYear + " />");
					sb.append("<input type='hidden' name='strHlpReceivedNo'    id='strHlpReceivedNo" + i + "'  value="
							+ strReceivedNo + " />");

					sb.append("<tr>");
					sb.append("<td>").append(i).append("</td>");
					sb.append("<td>").append(ws.getString(1)).append("</td>");
					sb.append("<td>").append(ws.getString(2)).append("</td>");
					sb.append("<td>").append(ws.getString(3)).append("</td>");
					sb.append("<td>").append(ws.getString(4)).append("</td>");
					sb.append("<td>").append(ws.getString(6)).append("</td>");
					sb.append("<td>").append(ws.getString(8)).append("</td>");
					sb.append("<td>").append(ws.getString(5)).append("</td>");
					sb.append("<td><i class='fa fa-search highlight-icon' onclick='generateIssueFunc(this,").append(i)
							.append(");'  style='cursor: pointer;' title='Print Details'></i></td>");
					sb.append("</tr>");
					i++;
				}
				sb.append("</table>");
				sb.append("</div>");

				sb.append("</div>"); // End of wrapper
			} else {
				sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
				sb.append("<tr><td colspan='8'><b>Received Item Details</b></td></tr>");
				sb.append("</table>");
				sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='1px'>");
				sb.append("<tr>");
				sb.append("<th style='width:5%;'>S.No.</th>");
				sb.append("<th style='width:10%;'>Received No.</th>");
				sb.append("<th style='width:15%;'>Received Date</th>");
				sb.append("<th style='width:20%;'>Third Party Name</th>");
				sb.append("<th style='width:20%;'>Drug Name</th>");
				sb.append("<th style='width:10%;'>Batch No.</th>");
				sb.append("<th style='width:10%;'>Expiry Date</th>");
				sb.append("<th style='width:10%;'>Received Qty.</th>");
				sb.append("<th style='width:5%;'>#</th>");
				sb.append("</tr>");
				sb.append("<tr><td colspan='9' style='text-align:center;'><b>No Matching Record Found</b></td></tr>");
				sb.append("</table>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	// RJ
	public static String getvoucherPrintDetails(SupplierTransactionRecordFB fb, SupplierTransactionRecordVO vo) {
		double sum1 = 0;
		StringBuffer sb = new StringBuffer("");
		HisUtil util = new HisUtil("mms", "getvoucherPrintDetails");
		WebRowSet ws = null;
		String strTableWidth = "700";
		String Remarks = "";
		int sno = 1;
		double totamt = 0.0;

		try {
			sb.append("<table width='850' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
			sb.append("<tr>");
			sb.append("<td colspan='1' align='center'>");
			sb.append("<img src='/INVMGM/hisglobal/images/aiims_inv_header.png' >");
			sb.append("</td>");
			sb.append("<td colspan='1' align='right'>");
			sb.append("<div id='printVoucrId'>");
			sb.append(
					"<img style='cursor: pointer; margin-right: 10px;' title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printVoucher();' />");
			sb.append(
					"<img style='cursor: pointer;' title='Cancel' src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();' />");
			sb.append("</div>");
			sb.append("</td>");
			sb.append("</tr>");

			/*
			sb.append("<div style='width: 100%; text-align: center; margin-bottom: 10px;'>");
			sb.append("<h6 style='font-family: Verdana, Arial, Helvetica, sans-serif;'>Third Party Received Voucher</h6>");
			sb.append("</div>");
			*/
			sb.append("<tr>");
			sb.append(
					"<td colspan='12' align='center' style='font-size:18px;font-weight:normal;'>Third Party Received Voucher</td>");
			sb.append("</tr>");
			sb.append("</table>");

			ws = vo.getWsReceivedItemListIndividual();

			if (ws != null && ws.size() > 0) {
				while (ws.next()) {
					Remarks = ws.getString(18);

					sb.append("<table align='center' cellpadding='1px' cellspacing='1px'>");
					sb.append("<tr>");
					sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif'>");
					sb.append(util.appendSpace("<b>Store Name</b>", 15, 0)).append(" : ").append(vo.getStrStoreName())
							.append("</font></td>");

					sb.append("<td width='25%' align='center' ><font face='Verdana, Arial, Helvetica, sans-serif'>");
					sb.append(util.appendSpace("<b>Item Category</b>", 15, 0)).append(" : ")
							.append(vo.getStrItemCategoryNo()).append("</font></td>");
					sb.append("</tr>");

					sb.append("<tr>");
					sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif'>");
					sb.append(util.appendSpace("<b>Receive No</b>", 15, 0)).append(" : ").append(ws.getString(1))
							.append("</font></td>");

					sb.append("<td width='25%' align='center' ><font face='Verdana, Arial, Helvetica, sans-serif'>");
					sb.append(util.appendSpace("<b>Receive Date</b>", 15, 0)).append(" : ").append(ws.getString(2))
							.append("</font></td>");
					sb.append("</tr>");

					sb.append("<tr>");
					sb.append("<td width='25%' align='center' ><font face='Verdana, Arial, Helvetica, sans-serif'>");
					sb.append(util.appendSpace("<b>Print Date</b>", 15, 0)).append(" : ").append(fb.getStrCurrentDate())
							.append("</font></td>");

					sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif'>");
					sb.append(util.appendSpace("<b>User Name</b>", 15, 0)).append(" : ").append(ws.getString(14))
							.append("</font></td>");

					sb.append("</tr>");
					sb.append("</table> ");
				}

				sb.append("<table class='table' align='center' style='border-collapse: collapse; border: 1px solid;'>");
				sb.append("<tr bgcolor='#cdc9c9'> ");
				sb.append(
						"<td  align='center'width='3%'  style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>S.No.</b></font></td>");
				sb.append(
						"<td align='center' width='20%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>Third Party Name</b></font></td>");
				sb.append(
						"<td align='center' width='18%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td> ");
				sb.append(
						"<td align='center' width='10%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch</b></font></td>  ");
				sb.append(
						"<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>  ");
				sb.append(
						"<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>  ");
				sb.append(
						"<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate</b></font></td>  ");
				// sb.append("<td align='center' width='5%' style='border: 1px solid;'><font
				// face='Verdana, Arial, Helvetica, sans-serif' ><b>Gst</b></font></td> ");
				// sb.append("<td align='center' width='5%' style='border: 1px solid;'><font
				// face='Verdana, Arial, Helvetica, sans-serif' ><b>Adm(tax)</b></font></td> ");
				sb.append(
						"<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate(Inc.Gst)</b></font></td>  ");
				sb.append(
						"<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sale Rate</b></font></td>  ");
				sb.append(
						"<td align='center' width='12%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font></td>  ");
				sb.append("</tr> ");

				ws.beforeFirst();
				while (ws.next()) {

					sb.append("<tr>");
					sb.append(
							"<td align='center' width='3%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>")
							.append(sno++).append("</font></td>");
					sb.append(
							"<td align='left'   width='20%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>")
							.append(ws.getString(3)).append("</font></td>"); // Third Party Name
					sb.append(
							"<td align='left'   width='18%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>")
							.append(ws.getString(4)).append("</font></td>");// Drug
					sb.append(
							"<td align='center' width='10%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>")
							.append(ws.getString(6)).append("</font></td>");// Batch
					sb.append(
							"<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>")
							.append(ws.getString(8)).append("</font></td>");// Expiry
					sb.append(
							"<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>")
							.append(ws.getString(5)).append("</font></td>");// Received qty
					sb.append(
							"<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >")
							.append(ws.getString(10)).append("</font></td>");// Rate
//	                  sb.append("<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>").append(ws.getString(15)).append("</font></td>");//Gst
//	                  sb.append("<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>").append(ws.getString(16)).append("</font></td>");//Admin Tax
					sb.append(
							"<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>")
							.append(ws.getString(11)).append("</font></td>");// Rate with gst
					sb.append(
							"<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>")
							.append(ws.getString(12)).append("</font></td>");// Sale Rate
					sb.append(
							"<td align='center' width='12%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>")
							.append(ws.getString(13)).append("</font></td>");// Total
					sb.append("</tr>");

					totamt += Double.parseDouble(ws.getString(13));
				}

				sb.append("<tr>");
				sb.append(
						"<td  colspan='9' align='right' style='border-collapse: collapse; border: 1px solid;'><b> TOTAL</b></td>");
				sb.append("<td  colspan='1'> " + String.format("%.2f", totamt) + "</td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append(
						"<td colspan='12' style='text-align: left; border-collapse: collapse; border: 1px solid;'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:</b> "
								+ Remarks + "</b></font></td> ");
				sb.append("</tr> ");

				sb.append("</table> ");
			} else {
				// If no data
				sb.append("<tr> ");
				sb.append(
						"<td colspan='12' rowspan='2' align='center' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/>Details Not Available</font></td> ");
				sb.append("</tr> ");
				sb.append("</table> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();
	}
}
