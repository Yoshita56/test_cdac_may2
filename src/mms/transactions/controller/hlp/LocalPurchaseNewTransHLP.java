package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.transactions.vo.AckSuppReceiptVO;
import mms.transactions.vo.LocalPurchaseNewTransVO;
import mms.MmsConfigUtil;
public class LocalPurchaseNewTransHLP {
	
	
	
	public static String getPrintItemDetails_OLD(WebRowSet ws,String hosCode,LocalPurchaseNewTransVO vo) throws Exception {

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
		String invoice_date="",strExpiryDt="",strbtch="",costtopat="",admchg="" , strmrp="",strPurRate="",strUser="",strRemarks="",strBrandId="",tmpId="0",strBal="",stritemTax="" , strRateWithTax="",manuf="";		
		int i=1;	
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
			//System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
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
				strMrnNo              = ws.getString("mrn_no");
				strMrnDate            = ws.getString("challan_dt");
				strPONo  		 	  = ws.getString("po_no");
				invoice_date	  	  = ws.getString("invoice_date");
				strVendor             = ws.getString("supp_info");
				strdcno				  = ws.getString("dc_no");
				strUser				  = ws.getString("usr");
				storeName  			  =ws.getString("store");
				uc_req  			  =ws.getString("uc_req");
				cat  			  	  =ws.getString("cat");
				strRemarks            =ws.getString("remarks");
				strPODate             =ws.getString("PoDate");
				
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
				
			//	sb.append("<tr><td width='100%'>--------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				//sb.append("</tr> ");
				
				System.out.println("strdcno---: "+strdcno);
				
				
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>L.P.O No  : </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strPONo +"</b></font></td>");
				sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>L.P.O Date.  : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strPODate +"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan/Invoice No.: </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[0]+"</b></font></td>");
				sb.append("<td align='right' width='58%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan/Invoice Date.  : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strMrnDate+"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier  : </b></font></td>");
				sb.append("<td align='left' width='80%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strVendor+"</b></font></td>");
				sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Whether Uc.</b></font></td>");
				sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+uc_req+"</b></font></td>");
				/*sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1]+"</b></font></td>");*/
				sb.append("</tr> ");
				
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Purchase  : </b></font></td>");
				sb.append("<td align='left' width='80%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[2]+"</b></font></td>");
				sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Date : </b></font></td>");
				sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b><b>"+strPODate+"</b></b></font></td>");
				/*sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1]+"</b></font></td>");*/
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
			
			ws.beforeFirst();

				while (ws.next()) 
				{
					NumberFormat formatter = new DecimalFormat("############.##");  	
						
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
						stritemTax				  = ws.getString("item_tax");
						costtopat				  = ws.getString("costtopat");
						admchg				  = ws.getString("admchg");
						if(Double.parseDouble(admchg)>1000)
							admchg = Double.toString(1000.0);
						strRateWithTax = ws.getString("RATE_WITH_TAX");
						manuf = ws.getString("manuf");
						
						//if(strBrandId.equals(tmpId))
						//	tmpRcd = tmpRcd+Double.parseDouble(strRcd);
						//else
						//	tmpRcd = Double.parseDouble(strRcd);
					sb.append("<tr> ");
					sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");
					
					
					/*sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strItem.split("/")[0]);
					sb.append("</font></td> ");*/
					sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strItem.split("/")[1]);
					sb.append("</font></td> ");
				/*	sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(manuf);
					sb.append("</font></td> ");*/
//					sb.append("<td align='left' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//					sb.append(strItem.split("/")[3]);
//					sb.append("</font></td> ");
					
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
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+costtopat+"</font></td> ");
					sb.append("<td align='center' width='11%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strRcd);
					sb.append("</font></td> ");
					//sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+strBal+"</font></td> ");
					sb.append("<td align='center' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(Math.round((Double.parseDouble(strRateWithTax) * Double.parseDouble(strRcd))* 1000.0)/1000.0);
					sb.append("</font></td></tr> ");
					
					
					
					i++;
					tot=tot+(Double.parseDouble(strRateWithTax) * Double.parseDouble(strRcd));
					tmpId=strBrandId;

				}
				sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='5%' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>TOTAL</b></font></td>");
				sb.append("<td colspan='9'></td>");
				sb.append("<td align='center' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+Math.round(tot * 1000.0)/1000.0+"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("<tr> ");
////			sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(").append(strRecivedBy).append(")<br><b> &nbsp;&nbsp;</font></td> ");
			    sb.append("<td colspan='13' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
			    sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Remarks : "+strRemarks+"<b></font><br></td> ");
				//sb.append("<td colspan='5' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Checked By <br><b> &nbsp;&nbsp;</font></td> ");
				sb.append("<td colspan='7' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By : "+strUser+"<b></font></td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
////				sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(").append(strRecivedBy).append(")<br><b> &nbsp;&nbsp;</font></td> ");
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
			//System.out.println("printItemDetails in hlp: "+sb.toString());

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
		finally {
			mmscofigutil = null;
		}
		
		return sb.toString();
	}
	
	public static String getPrintItemDetails(WebRowSet ws,String hosCode,LocalPurchaseNewTransVO vo) throws Exception 
	{

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
	    String strInvoiceNo="";
	    String MRP ="";
		int i=1;

		HisUtil util = new HisUtil("mms", "getChallanPrintDetails");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(hosCode);			
	
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		
	
		String strTableWidth = "725";

		try 
		{						
			sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
			sb.append("<tr> "
			        + " <td colspan='1'></td>"		
			        + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>"
			        + " <td colspan='1'></td>");
			sb.append("</tr></table>");				
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			sb.append(" Material IN-Ward");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");			
			sb.append("</table> ");	
			ws.beforeFirst();
			if(ws != null && ws.size() > 0)
			{
				
				/*      Updated Voucher Query Used in NEW LP Request 
		                Usefull Information 
		                ---------------------------------------------
		                hstnum_dc_no        ->  Invoice No of Screen
		                
		                hstnum_challan_date ->  Invoice Date of Screen 
		
		                hstnum_invoice_no   ->  BILL No of Screen
		
		                hstnum_invoice_date ->  BILL Date of Screen       
		   
		               1. Store Name
		               2. MRN_NO
		               3. INV_DATE
		               4. PO_NO
		               5. CHALLAN_DATE
		               6. ITEM_NAME
		               7. SUPPLIER / MFG INFO
		               8. QTY
		               9. Rej Qty
		              10. Rec Qty
		              11. RATE_WTH_TAX
		              12. hstnum_dc_no # hstnum_challan_date  AS INV_DATE
		              13. Qty
		              14. MRP
		              15. EXP_DATE
		              16. BATCH/SERIAL NO
		              17. RATE WTHOUT TAX
		              18. By User
		              19. BRAN DId
		              20. Bal Qty
		              21. DL NO
		              22. TAX
		              23. Rate Wth Tax
		              24. Mfg Name
		              25. Catg Name
		              26. UC Req
		              27. Admn Chg
		              28. Sale Price
		              29. Remarks
		              30. Supplier Id
		              31. Purchase Through Name
		              32. BILL No
		              33. Bill Date
		              34. Admin Chg
		              35. Mfg Date
		              36. Exp Date 
		              37. hstnum_supp_lp_no||'^'||HSTNUM_ITEMBRAND_ID
		              38. hstdt_expdelivery_date
		              39. hstdt_podate
		              40. hststr_lp_no as PO No
		              41. MRP
		              42. hstdt_podate
		*/
				ws.next();
				
				strRemarks            = ws.getString(29);
				strUser				  = ws.getString(18);
				
				sb.append("<table width='100%' align='center' cellpadding='1px' cellspacing='1px'> ");				
				sb.append("<tr> ");
				sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Store Name : </b></font></td>");
				sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+ws.getString(1) +"</b></font></td>");
				sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Category : </b></font></td>");
				sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+ws.getString(25) +"</b></font></td>");
				sb.append("</tr> ");		
								
				sb.append("<tr> ");
				sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No  : </b></font></td>");
				sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+ws.getString(40) +"</b></font></td>");
				sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Date  : </b></font></td>");
				sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+ws.getString(39) +"</b></font></td>");
				sb.append("</tr> ");
				
				sb.append("<tr> ");
				sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice No : </b></font></td>");
				sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+ws.getString(12).split("#")[0]+"</b></font></td>");
				sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice Date.  : </b></font></td>");
				sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+ws.getString(12).split("#")[1]+"</b></font></td>");
				sb.append("</tr> ");				
				
				sb.append("<tr> ");
				sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Bill No : </b></font></td>");
				sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+ws.getString(32)+"</b></font></td>");
				sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Bill Date.  : </b></font></td>");
				sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+ws.getString(33)+"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier  : </b></font></td>");
				sb.append("<td align='left'  colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+ws.getString(7)+"</b></font></td>");
				sb.append("</tr> ");
				sb.append("</table> ");
			
			sb.append("<table width='725' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr><td width='100%' colspan='9'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
			sb.append("<tr> ");
			sb.append("<td align='center' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.NO.</b></font></td>");
			sb.append("<td align='center' colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>ITEM DESCRIPTION</b></font></td>");
			sb.append("<td align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Qty</b></font></td>");		
			sb.append("<td align='center' colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>AMOUNT</b></font></td>");
			sb.append("</tr> ");
			sb.append("<tr><td width='100%' colspan='8'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
			sb.append("<tr> ");
			sb.append("<td align='center' 	width='5%' ></td>");			
			sb.append("<td align='left' 	width='30%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Brand</b></font></td>");			
			sb.append("<td align='left'	 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Serial No</b></font></td>");
			sb.append("<td align='left' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Tax(%)</b></font></td>");			
			sb.append("<td align='left'   	width='9%' ><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Rate</b></font></td>");
			sb.append("<td align='center' 	width='9%' ><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Rate<br>(With Tax)</b></font></td>");
			sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Qty</b></font></td>");			
			sb.append("<td align='center' 	width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Amount</b></font></td>");
			sb.append("</tr> ");
			sb.append("<tr><td width='100%' colspan='8'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
			
			NumberFormat formatter = new DecimalFormat("############.##");
			
			ws.beforeFirst();

				while (ws.next()) 
				{
					
					/*      Updated Voucher Query Used in NEW LP Request 
	                Usefull Information 
	                ---------------------------------------------
	                hstnum_dc_no        ->  Invoice No of Screen
	                
	                hstnum_challan_date ->  Invoice Date of Screen 
	
	                hstnum_invoice_no   ->  BILL No of Screen
	
	                hstnum_invoice_date ->  BILL Date of Screen       
	   
	               1. Store Name
	               2. MRN_NO
	               3. INV_DATE
	               4. PO_NO
	               5. CHALLAN_DATE
	               6. ITEM_NAME
	               7. SUPPLIER / MFG INFO
	               8. QTY
	               9. Rej Qty
	              10. Rec Qty
	              11. RATE_WTH_TAX
	              12. hstnum_dc_no # hstnum_challan_date  AS INV_DATE
	              13. Qty
	              14. MRP
	              15. EXP_DATE
	              16. BATCH/SERIAL NO
	              17. RATE WTHOUT TAX
	              18. By User
	              19. BRAN DId
	              20. Bal Qty
	              21. DL NO
	              22. TAX
	              23. Rate Wth Tax
	              24. Mfg Name
	              25. Catg Name
	              26. UC Req
	              27. Admn Chg
	              28. Sale Price
	              29. Remarks
	              30. Supplier Id
	              31. Purchase Through Name
	              32. BILL No
	              33. Bill Date
	              34. Admin Chg
	              35. Mfg Date
	              36. Exp Date 
	              37. hstnum_supp_lp_no||'^'||HSTNUM_ITEMBRAND_ID
	              38. hstdt_expdelivery_date
	              39. hstdt_podate
	              40. hststr_lp_no as PO No
	              41. MRP
	              42. hstdt_podate
	*/
					
				    strAmount			  = ws.getString(28);
						
					sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");	
					
				
					sb.append("<td align='left' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(6));
					sb.append("</font></td> ");
				
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(16));
					sb.append("</font></td> ");
					
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(22));
					sb.append("</font></td> ");					
										
					sb.append("<td align='left' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(17));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(23));
					sb.append("</font></td> ");
/*
					sb.append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(28));
					sb.append("</font></td> ");
					*/
					
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//					sb.append(Math.round((Double.parseDouble(strRateWithTax) * Double.parseDouble(strRcd))* 1000.0)/1000.0);
					sb.append(ws.getString(28));
					sb.append("</font></td></tr> ");
					
					
					
					i++;
//					tot=tot+(Double.parseDouble(strRateWithTax) * Double.parseDouble(strRcd));
					tot=tot+Double.parseDouble(strAmount);
					tmpId=strBrandId;

				}
				sb.append("<tr><td width='100%' colspan='8'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("<tr> ");
				sb.append("<td colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
				sb.append("<td colspan='6'  align='right'><b>TOTAL : </b></td>");
				sb.append("<td align='center' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+formatter.format(new BigDecimal(tot)) +"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='8'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("<tr> ");

			    sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
			    sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>Remarks : "+strRemarks+"<b></font><br></td> ");
				
				sb.append("<td colspan='4' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By : "+strUser+"<b></font></td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
//
				sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
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
			//System.out.println("printItemDetails in hlp: "+sb.toString());

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
