package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.transactions.vo.SupplierReceiptVO;
import mms.MmsConfigUtil;
public class SupplierReceiptHLP {
	
	
	
	public static String getPrintItemDetails(WebRowSet ws,String hosCode,SupplierReceiptVO vo) throws Exception {

		StringBuffer sb = new StringBuffer("");
		String strMrnNo = "" , storeName = "",uc_req="",cat="";
		String strMrnDate = "";
		String strPONo="";
		String strPODate="";
		String strVendor="",strdcno="";
		String strItem="";
		String strSup="",strRej="",strRcd="",strInvoiceNo="-";
		String strAmount="0.00";
		double tot = 0.000,tmpRcd=0.0;
		String strOrderQty="";
		String PoDate;
	    String PoNo;
	    String MRP;
		int i=1;
		String strExpiryDt="",strbtch="",costtopat="",admchg="" , strmrp="",strPurRate="",strUser="",strRemarks="",strBrandId="",tmpId="0",strBal="",stritemTax="" , strRateWithTax="",manuf="";
		
		HisUtil util = new HisUtil("mms", "getChallanPrintDetails");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(hosCode);	
		
		//String configIssueRate = mmscofigutil.getStrConfigIssueRate();
		DecimalFormat myFormatter = new DecimalFormat("0.00");

		
		String strTableWidth = "700";

		try 
		{
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(hosCode);
			System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
		//	System.out.println("the ws length isa  "+ws.getKeyColumns());
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
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
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			//sb.append(hospitalVO.getCity());
			//sb.append(res.getString("CITY"));
			sb.append("Material Receipt Note  </font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<br> ");
			sb.append("<br> ");
			
			ws.beforeFirst();
			if(ws != null && ws.size() > 0)
			{
				ws.next();
				strMrnNo              = ws.getString("mrn_no");
				strMrnDate            = ws.getString("challan_dt");
				strPONo  		 	  = ws.getString("po_no");
				strPODate	  		  = ws.getString("podate");
				strVendor             = ws.getString("supp_info");
				strdcno				  = ws.getString("dc_no");
				
				storeName  			  = ws.getString("store");
				uc_req  			  = ws.getString("uc_req");
				cat  			  	  = ws.getString("cat");
				strRemarks            = ws.getString("remarks");
				strUser				  = ws.getString("usr");
				strInvoiceNo          = ws.getString("INV_NO");
				PoDate				  = ws.getString("PoDate");
				PoNo				  = ws.getString("PoNo");
				
				System.out.println("strMrnNo-----"+strMrnNo);
				System.out.println("strMrnDate----"+strMrnDate);
				System.out.println("strPONo-----"+strPONo);
				System.out.println("strPODate-----"+strPODate);
				System.out.println("strVendor----"+strVendor);
				System.out.println("strdcno----"+strdcno);
				System.out.println("strUser----"+strUser);
				System.out.println("storeName----"+storeName);
				System.out.println("uc_req-----"+uc_req);
				System.out.println("cat-----"+cat);
				System.out.println("strRemarks----"+strRemarks);
				System.out.println("strInvoiceNo-----"+strInvoiceNo);
		
				
				
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
				
				
				sb.append("<tr> ");
				sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Store Name : </b></font></td>");
				sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+storeName +"</b></font></td>");
				sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Category : </b></font></td>");
				sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+cat +"</b></font></td>");
				sb.append("</tr> ");
				
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>MRN No : </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strMrnNo +"</b></font></td>");
				sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>MRN Date : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1] +"</b></font></td>");
				sb.append("</tr> ");
				
			//	sb.append("<tr><td width='100%'>--------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				//sb.append("</tr> ");
				
				/*
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>No  : </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strPONo +"</b></font></td>");
				sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Date  : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strPODate +"</b></font></td>");
				sb.append("</tr> ");
				*/
				sb.append("<tr> ");
				sb.append("<td align='right' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan/Invoice No : </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[0]+"</b></font></td>");
				sb.append("<td align='right' width='58%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan/Invoice Date.  : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strMrnDate+"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier  : </b></font></td>");
				sb.append("<td align='left' width='80%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strVendor+"</b></font></td>");
				//sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Whether Uc.</b></font></td>");
				//sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+uc_req+"</b></font></td>");
				sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No : </b></font></td>");
				sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+PoNo+"</b></font></td>");
				/*sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1]+"</b></font></td>");*/
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Date : </b></font></td>");
				sb.append("<td align='left' width='80%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+PoDate+"</b></font></td>");
				//sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Whether Uc.</b></font></td>");
				//sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+uc_req+"</b></font></td>");
//				sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >PO Date</font></td>");
//				sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+PoDate+"</font></td>");
				/*sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1]+"</b></font></td>");*/
				sb.append("</tr> ");
				/*
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Purchase  : </b></font></td>");
				sb.append("<td align='left' width='80%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+vo.getStrItemBrandCombo()+"</b></font></td>");
				sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
				sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
				sb.append("</tr> ");
				*/
				
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
			sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
			sb.append("<tr> ");
			sb.append("<td align='center' width='2%'></td>");			
			sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Brand</b></font></td>");			
			sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Batch</b></font></td>");
			sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Expire</b></font></td>");
			sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif'   ><b>MRP</b></font></td>");
			sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Tax</b></font></td>");
			sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif'   ><b>Pur.Rate</b></font></td>");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur.Rate(With Tax)</b></font></td>");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Adm Chg/Unit</b></font></td>");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost To Pat.</b></font></td>");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'><b>Qty</b></font></td>");			
			sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
			sb.append("</tr> ");
			sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
			
			NumberFormat formatter = new DecimalFormat("############.##");  
			
			ws.beforeFirst();

				while (ws.next()) 
				{
						
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
						MRP				 	  = ws.getString(41);
						
					
						/*
						System.out.println("strItem-----"+strItem);
						System.out.println("strSup----"+strSup);
						System.out.println("strRej-----"+strRej);
						System.out.println("strRcd-----"+strRcd);						
						System.out.println("strOrderQty----"+strOrderQty);
						System.out.println("strmrp----"+strmrp);
						System.out.println("strExpiryDt----"+strExpiryDt);
						System.out.println("strbtch-----"+strbtch);
						System.out.println("strPurRate-----"+strPurRate);
						System.out.println("strBrandId----"+strBrandId);
						System.out.println("stritemTax-----"+stritemTax);
						System.out.println("costtopat-----"+costtopat);
						System.out.println("admchg-----"+admchg);
						*/
						
						
						
						//if(Double.parseDouble(admchg)>1000)
						//	admchg = Double.toString(1000.0);
						strRateWithTax = ws.getString("RATE_WITH_TAX");
						manuf = ws.getString("manuf");
						
						System.out.println("strAmount----"+strAmount);
						System.out.println("strRateWithTax----"+strRateWithTax);
						
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
					
					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(MRP);
					sb.append("</font></td> ");
					
					
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(stritemTax);
					sb.append("</font></td> ");
					
					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strPurRate);
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strRateWithTax);
					sb.append("</font></td> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(admchg);
					sb.append("</font></td> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+costtopat+"</font></td> ");
					sb.append("<td align='center' width='11%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strRcd);
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					//sb.append(Math.round((Double.parseDouble(strRateWithTax) * Double.parseDouble(strRcd))* 1000.0)/1000.0);
					sb.append(strAmount);					
					sb.append("</font></td></tr> ");
					
					
					
					i++;
					//tot=tot+(Double.parseDouble(strRateWithTax) * Double.parseDouble(strRcd));
					tot=tot+Double.parseDouble(strAmount);
					//tot=tot+Double.parseDo(strAmount);
					
					
					
					
					
					tmpId=strBrandId;

				}
				sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='5%' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>TOTAL</b></font></td>");
				sb.append("<td colspan='10'></td>");
				sb.append("<td align='center' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+formatter.format(new BigDecimal(tot)) +"</b></font></td>");
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
//
				sb.append("<td colspan='13' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
				sb.append("</tr> ");
				sb.append("</table>");
				
			}
				
				
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='6' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");
			System.out.println("printItemDetails in hlp: "+sb.toString());

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
		finally {
			mmscofigutil = null;
		}
		
		return sb.toString();
	}
	
	
	public static String getPrintItemDetails_RAI(WebRowSet ws, String hosCode, SupplierReceiptVO vo) throws Exception {
	      StringBuffer sb = new StringBuffer("");
	      String strMrnNo = "";
	      String storeName = "";
	      String uc_req = "";
	      String cat = "";
	      String strMrnDate = "";
	      String strPONo = "";
	      String strPODate = "";
	      String strVendor = "";
	      String strdcno = "";
	      String strItem = "";
	      String strSup = "";
	      String strRej = "";
	      String strRcd = "";
	      String strInvoiceNo = "-";
	      String strAmount = "0.00";
	      double tot = 0.0D;
	      double tmpRcd = 0.0D;
	      String strOrderQty = "";
	      int i = 1;
	      String strExpiryDt = "";
	      String strbtch = "";
	      String costtopat = "";
	      String admchg = "";
	      String strmrp = "";
	      String strPurRate = "";
	      String strUser = "";
	      String strRemarks = "";
	      String strBrandId = "";
	      String tmpId = "0";
	      String strBal = "";
	      String stritemTax = "";
	      String strRateWithTax = "";
	      String manuf = "";	     
	      new DecimalFormat("0.00");
	      String strTableWidth = "700";

	      try {
	         HisUtil hisUtil = new HisUtil("Global", "ReportUtil");
	         HospitalMstVO hospitalVO = hisUtil.getHospitalDetail(hosCode);
	         System.out.println("hospitalVO.getAddress1()" + hospitalVO.getHospitalName());
	         sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
	         sb.append("<tr><td width='8%'>&nbsp;</td> ");
	         sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
	         sb.append(hospitalVO.getHospitalName());
	         sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");
	         sb.append("<td width='8%'>&nbsp;</td> ");
	         sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
	         sb.append((hospitalVO.getAddress1() != "" && hospitalVO.getAddress1() != null ? hospitalVO.getAddress1() + "," : " ") + (hospitalVO.getAddress2() != "" && hospitalVO.getAddress2() != null ? hospitalVO.getAddress2() + "," : " ") + (hospitalVO.getCity() != "" && hospitalVO.getCity() != null ? hospitalVO.getCity() + "," : " ") + (hospitalVO.getPinCode() != "" && hospitalVO.getPinCode() != null ? hospitalVO.getPinCode() : " "));
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
	         if (ws != null && ws.size() > 0) {
	            ws.next();
	            strMrnNo = ws.getString("mrn_no");
	            strMrnDate = ws.getString("challan_dt");
	            strPONo = ws.getString("po_no");
	            strPODate = ws.getString("po_date");
	            strVendor = ws.getString("supp_info");
	            strdcno = ws.getString("dc_no");
	            strUser = ws.getString("usr");
	            storeName = ws.getString("store");
	            uc_req = ws.getString("uc_req");
	            cat = ws.getString("cat");
	            strRemarks = ws.getString("remarks");
	            strInvoiceNo = ws.getString("INV_NO");
	            /*
	            System.out.println("strMrnNo-----" + strMrnNo);
	            System.out.println("strMrnDate----" + strMrnDate);
	            System.out.println("strPONo-----" + strPONo);
	            System.out.println("strPODate-----" + strPODate);
	            System.out.println("strVendor----" + strVendor);
	            System.out.println("strdcno----" + strdcno);
	            System.out.println("strUser----" + strUser);
	            System.out.println("storeName----" + storeName);
	            System.out.println("uc_req-----" + uc_req);
	            System.out.println("cat-----" + cat);
	            System.out.println("strRemarks----" + strRemarks);
	            System.out.println("strInvoiceNo-----" + strInvoiceNo);
	            */
	            sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
	            sb.append("<tr> ");
	            sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Store Name : </b></font></td>");
	            sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>" + storeName + "</b></font></td>");
	            sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Category : </b></font></td>");
	            sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>" + cat + "</b></font></td>");
	            sb.append("</tr> ");
	            sb.append("<tr> ");
	            sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>MRN No : </b></font></td>");
	            sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>" + strMrnNo + "</b></font></td>");
	            sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>MRN Date : </b></font></td>");
	            sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>" + strdcno.split("#")[1] + "</b></font></td>");
	            sb.append("</tr> ");
	            sb.append("<tr> ");
	            sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>L.P.O No  : </b></font></td>");
	            sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>" + strPONo + "</b></font></td>");
	            sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>L.P.O Date  : </b></font></td>");
	            sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>" + strPODate + "</b></font></td>");
	            sb.append("</tr> ");
	            sb.append("<tr> ");
	            sb.append("<td align='right' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan/Invoice No : </b></font></td>");
	            sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>" + strdcno.split("#")[0] + "</b></font></td>");
	            sb.append("<td align='right' width='58%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan/Invoice Date.  : </b></font></td>");
	            sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>" + strMrnDate + "</b></font></td>");
	            sb.append("</tr> ");
	            sb.append("<tr> ");
	            sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier  : </b></font></td>");
	            sb.append("<td align='left' width='80%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>" + strVendor + "</b></font></td>");
	            sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
	            sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
	            sb.append("</tr> ");
	            sb.append("<tr><td width='100%' colspan='5'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
	            sb.append("</table> ");
	            sb.append("<table width='725' align='center' cellpadding='1px' cellspacing='1px'> ");
	            sb.append("<tr> ");
	            sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.NO.</b></font></td>");
	            sb.append("<td align='center' width='40%' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>ITEM DESCRIPTION</b></font></td>");
	            sb.append("<td align='center' width='40%'  colspan='6'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>QUANTITY</b></font></td>");
	            sb.append("<td align='center' width='11%' colspan=6><font face='Verdana, Arial, Helvetica, sans-serif' ><b>AMOUNT</b></font></td>");
	            sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
	            sb.append("</tr> ");
	            sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
	            sb.append("<tr> ");
	            sb.append("<td align='center' width='2%'></td>");
	            sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Brand</b></font></td>");
	            sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Batch</b></font></td>");
	            sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Expire</b></font></td>");
	            sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Tax</b></font></td>");
	            sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif'   ><b>Pur.Rate</b></font></td>");
	            sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur.Rate(With Tax)</b></font></td>");
	            sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Adm Chg/Unit</b></font></td>");
	            sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost To Pat.</b></font></td>");
	            sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'><b>Qty</b></font></td>");
	            sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
	            sb.append("</tr> ");
	            sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
	            ws.beforeFirst();

	            while(ws.next()) 
	            {
	               strItem = ws.getString("item");
	               strSup = ws.getString("sup_qty");
	               strRej = ws.getString("rej_qty");
	               strRcd = ws.getString("rcd_qty");
	               strAmount = ws.getString("rate");
	               strOrderQty = ws.getString("po_qty");
	               strmrp = ws.getString("mrp");
	               strExpiryDt = ws.getString("exp_dt");
	               strbtch = ws.getString("btch");
	               strPurRate = ws.getString("pur_rate");
	               strBrandId = ws.getString("id");
	               strBal = ws.getString("bal_qty");
	               stritemTax = ws.getString("item_tax");
	               costtopat = ws.getString("costtopat");
	               admchg = ws.getString("admchg");
	               /*
	               System.out.println("strItem-----" + strItem);
	               System.out.println("strSup----" + strSup);
	               System.out.println("strRej-----" + strRej);
	               System.out.println("strRcd-----" + strRcd);
	               System.out.println("strAmount----" + strAmount);
	               System.out.println("strOrderQty----" + strOrderQty);
	               System.out.println("strmrp----" + strmrp);
	               System.out.println("strExpiryDt----" + strExpiryDt);
	               System.out.println("strbtch-----" + strbtch);
	               System.out.println("strPurRate-----" + strPurRate);
	               System.out.println("strBrandId----" + strBrandId);
	               System.out.println("stritemTax-----" + stritemTax);
	               System.out.println("costtopat-----" + costtopat);
	               System.out.println("admchg-----" + admchg);
	               */
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
	               sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	               sb.append(strRateWithTax);
	               sb.append("</font></td> ");
	               sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	               sb.append(admchg);
	               sb.append("</font></td> ");
	               sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >" + costtopat + "</font></td> ");
	               sb.append("<td align='center' width='11%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	               sb.append(strRcd);
	               sb.append("</font></td> ");
	               sb.append("<td align='center' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	               //sb.append((double)Math.round(Double.parseDouble(strRateWithTax) * Double.parseDouble(strRcd) * 1000.0D) / 1000.0D);
	               sb.append(strAmount);
	               sb.append("</font></td></tr> ");
	               ++i;
	               //tot += Double.parseDouble(strRateWithTax) * Double.parseDouble(strRcd);
	               tot=tot+Double.parseDouble(strAmount);
	            }

	            sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
	            sb.append("<tr> ");
	            sb.append("<td align='right' width='5%' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>TOTAL</b></font></td>");
	            sb.append("<td colspan='9'></td>");
	            sb.append("<td align='center' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>" + (double)Math.round(tot * 1000.0D) / 1000.0D + "</b></font></td>");
	            sb.append("</tr> ");
	            sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
	            sb.append("<tr> ");
	            sb.append("<td colspan='13' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
	            sb.append("</tr> ");
	            sb.append("<tr> ");
	            sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Remarks : " + strRemarks + "<b></font><br></td> ");
	            sb.append("<td colspan='7' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By : " + strUser + "<b></font></td> ");
	            sb.append("</tr> ");
	            sb.append("<tr> ");
	            sb.append("<td colspan='13' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
	            sb.append("</tr> ");
	            sb.append("</table>");
	         } else {
	            sb.append("<tr> ");
	            sb.append("<td colspan='6' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
	            sb.append("</tr> ");
	         }

	         sb.append("</table> ");
	         System.out.println("printItemDetails in hlp: " + sb.toString());
	      } catch (Exception var49) {
	         var49.printStackTrace();
	         throw var49;
	      } finally {
	         Object var41 = null;
	      }

	      return sb.toString();
	   }
	
}
