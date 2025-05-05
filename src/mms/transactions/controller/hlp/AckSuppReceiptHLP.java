package mms.transactions.controller.hlp;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.MmsConfigUtil;
import mms.transactions.vo.AckSuppReceiptVO;
public class AckSuppReceiptHLP 

{
	
	
	
	public static String getLPDrugDetails(WebRowSet ws,String hosCode,AckSuppReceiptVO vo) throws Exception {

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
		String strExpiryDt="",rateWthTax="",strbtch="",costtopat="",admchg="" , strmrp="",strPurRate="",strUser="",strRemarks="",strBrandId="",tmpId="0",strBal="",stritemTax="" , strRateWithTax="",manuf="";
		
		int i=1,k=0;	
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

		double sumCost = 0.000;
		int    sumQty  = 0 , z=0;

		try 
		{
			
			
			ws.beforeFirst();
			if(ws != null && ws.size() > 0)
			{
				ws.next();

				
				String store      			= ws.getString(1);
				String mrn_no 	   			= ws.getString(2);
				String challan_dt 			= ws.getString(3);
				String po_no 	   			= ws.getString(4);
				String po_date 				= ws.getString(5);
//				String item 				= ws.getString(6);
				String supp_info 			= ws.getString(7);
//				String sup_qty 				= ws.getString(8);
//				String rej_qty 				= ws.getString(9);
//				String rcd_qty 				= ws.getString(10);
//				String rate 				= ws.getString(11);
				String dc_no 				= ws.getString(12);
//				String po_qty 				= ws.getString(13);
				String mrp 					= ws.getString(14);
//				String exp_dt 				= ws.getString(15);
//				String btch 				= ws.getString(16);
				String pur_rate 			= ws.getString(17);
				String usr 					= ws.getString(18);
				String id 					= ws.getString(19);
				String bal_qty 				= ws.getString(20);
				String dlno 				= ws.getString(21);
//				String item_tax 			= ws.getString(22);
				String rate_with_tax 		= ws.getString(23);
				manuf						= ws.getString(24);
				cat 						= ws.getString(25);
				uc_req 						= ws.getString(26);
//				String admchg1 				= ws.getString(27);
				String costtopat1 			= ws.getString(28);
				String remarks1 			= ws.getString(29);
				String hstnum_supplier_id 	= ws.getString(30);
				String gnum_institute_code 	= ws.getString(31);
				String BillNo 				= ws.getString(32);
				String BillDate 			= ws.getString(33);
//				String GST					= ws.getString(34);
//				String Manu_dt				= ws.getString(35);
//				String Exp_dt				= ws.getString(36);
				String strExpectedDate      = ws.getString(38);
				
				sb.append("<input type='hidden' name='strInvoiceNo'    id='strInvoiceNo'      value='"+BillNo+"' />");
				sb.append("<input type='hidden' name='strInvoiceDate'  id='strInvoiceDate'    value='"+BillDate+"' />");
				sb.append("<input type='hidden' name='strSupplierId'  id='strSupplierId'    value='"+hstnum_supplier_id+"' />");
				sb.append("<input type='hidden' name='strDCNo'  id='strDCNo'    value='"+dc_no+"' />");
				
				
				sb.append("<div class='row'> ");
				sb.append("<div class='col-sm-2'></div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Store Name : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+store +"</div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Category : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+cat +"</div>");
				sb.append("</div> ");
				
				sb.append("<div class='row'> ");
				sb.append("<div class='col-sm-2' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'></div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>MRN No. : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+mrn_no+"</div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>MRN Date. : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+challan_dt+"</div>");
				sb.append("</div> ");
				
				
				sb.append("<div class='row'> ");
				sb.append("<div class='col-sm-2' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'></div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>P.O No  : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+po_no +"</div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Invoice Date.  : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+po_date +"</div>");
				sb.append("</div> ");
				
				sb.append("<div class='row'> ");
				sb.append("<div class='col-sm-2'></div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Bill No.: </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+BillNo+"</div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Bill Date.  : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+BillDate+"</div>");
				sb.append("</div> ");
				
				sb.append("<div class='row'> ");
				sb.append("<div class='col-sm-2'></div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Purchase  : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+gnum_institute_code+"</div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Expected Del. Date :</div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+strExpectedDate+"</div>");
				sb.append("</div> ");
				
				sb.append("<div class='row'> ");
				sb.append("<div class='col-sm-2'></div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Supplier  : </div>");
				sb.append("<div class='col-sm-8' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;line-height: normal;'>"+supp_info+"</div>");
				//sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'></div>");
				//sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'></div>");
				sb.append("</div> ");
												
												
				sb.append("<table class='table table-hover' id='POITable' style='margin-top:2%;'>");
				sb.append("<thead> "); 
				sb.append("<tr>");
				sb.append("<th style='padding-top: 1%;'>Batch No.<font color='red'>*</font></th>");
				sb.append("<th>Name<font color='red'>*</font></th>");
				sb.append("<th>Mfg Date<font color='red'>*</font></th>");
				sb.append("<th>Exp Date<font color='red'>*</font></th>");
				//sb.append("<th>Category</th>");
				/*
				if(vo.getStrItemCategoryNo().equals("10"))
				{
					sb.append("<th>Mfg Date<font color='red'>*</font></th>");
					sb.append("<th>Exp Date<font color='red'>*</font></th>");
			    }
				else
				{
					sb.append("<th>Mfg Date</th>");
					sb.append("<th>Exp Date</th>");	
				}
				*/
				sb.append("<th>Total Qty<font color='red'>*</font></th>");
				sb.append("<th>Rate<font color='red'>*</font></th>");
				sb.append("<th>GST(%)<font color='red'>*</font></th>");
				sb.append("<th>MRP<font color='red'>*</font></th>");
				sb.append("<th>Adm(%)<font color='red'>*</font></th>");
				sb.append("<th>Cost<font color='red'>*</font></th>");
//				sb.append("<th><button type='button' class='btn btn-info' onclick='insRow();'style='padding: 3px .55rem;font-size: 13px;'><i class='fa fa-plus'></i></button></th>");
			    sb.append("</tr>");
	
				sb.append("</thead> ");
				sb.append("<tbody id='RowId'>");
				String btches=" ";
				
		    	ws.beforeFirst();
				while (ws.next()) 
				{
					
						
//						strItem				  = ws.getString("item");
						String item 		  = ws.getString(6);
						String sup_qty 		  = ws.getString(8);
						cat 				  = ws.getString(25);
						String costWthTax	  = ws.getString(11);  // As Value ( Qty * Rate Wth Tax)
						String rej_qty 		  = ws.getString(9);
						String rcd_qty 		  = ws.getString(10);
						String po_qty 		  = ws.getString(13);
						String Manu_dt		  = ws.getString(35);
						String Exp_dt		  = ws.getString(36);
						String admn_tax		  = ws.getString(34);
						String btch 		  = ws.getString(16);
						admchg 		  		  = ws.getString(27);
						String item_tax 	  = ws.getString(22);
						String manuf1		  = ws.getString(24);
						String pKey 		  = ws.getString(37);
//						strRej				  = ws.getString("rej_qty");
//						strRcd				  = ws.getString("rcd_qty");
//						strAmount			  = ws.getString("rate");
//						strOrderQty			  = ws.getString("po_qty");
//						strmrp				  = ws.getString("mrp");
//						strExpiryDt			  = ws.getString("exp_dt");
//						strbtch 			  = ws.getString("btch");
						strPurRate			  = ws.getString("pur_rate");   // Purchase Rate With Out Tax 
//						strBrandId			  = ws.getString("id");
//						strBal				  = ws.getString("bal_qty");
//						stritemTax			  = ws.getString("item_tax");
						rateWthTax			  = ws.getString("costtopat");  // Purcahse Rate With Tax
//						admchg				  = ws.getString("admchg");
						String MRP      			= ws.getString(41);
						if(Double.parseDouble(admchg)>1000)
							admchg = Double.toString(1000.0);
//						strRateWithTax = ws.getString("RATE_WITH_TAX");
						manuf1 = ws.getString(24);
						
						
						if(k==0)
						{
							
							sumCost = Double.parseDouble(ws.getString(11));
							sumQty  = Integer.parseInt(ws.getString(10));							
							
						}
						else
						{	
							sumCost = sumCost + Double.parseDouble(ws.getString(11));
						    sumQty  = sumQty  + Integer.parseInt(ws.getString(10));
						}
								
					sb.append("<tr id='0' style='display:none;'>");					
					sb.append("<input type='hidden' name='pKey'    id='pKey"+k +"'    value='"+pKey+"' />");
					sb.append("<input type='hidden' name='dateVal' id='dateVal"+k +"' value='"+Manu_dt+"^"+Exp_dt+"' />");	
					sb.append("<td  style='width: 25%;padding: .25rem;'>");
					sb.append("<td style='width: 9%;'><label><bean:write  name='SupplierReceiptBean' property='strItemCategoeryName' filter='false' /></label></td>");
					sb.append("</td>");
					sb.append("</tr>");					
					sb.append("<tr id='1'>");					
					sb.append("<td class='py-3' style='width: 14%;padding:  .25rem;'><input type='text' maxlength='27' autocomplete='off' id = 'strbatchno"+i+"' name='strbatchno' onkeyup='uppercasefn(this)' class='form-control' value='"+btch+"'></td>");
					sb.append("<td class='py-3' hidden style='width: 14%;padding:  .25rem;'><input type='text' maxlength='27' autocomplete='off' id = 'stroldbatchno"+i+"' name='strOldBatchNo' onkeyup='uppercasefn(this)' class='form-control' value='"+btch+"'></td>");
					sb.append("<td class='py-4' style='width: 35%;padding: .25rem;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(item);
					sb.append("</font></td> ");
													        
					sb.append("<td class='py-3' style='width: 19%;padding: .25rem;'><input id='strMfgDate"+k+"' type='text' name='strMfgDate' value='"+Manu_dt+"'></td>");
				
					sb.append("<td class='py-3' style='width: 19%;padding: .25rem;'><input id='strExpDate"+k+"' type='text' name='strExpDate'></td>");
					
					sb.append("<td class='py-3' style='width: 11%; padding: .25rem;'><input type='text' onkeypress='return validateData(event,5);' class='form-control' autocomplete='off' name='strTotalQty'  id='strTotalQty"+k+"' onchange='calQty(this,"+k+");' value='"+sup_qty+"'></td>");
					
					sb.append("<td class='py-3' style='width: 12%; padding: .25rem;'><input type='text' onkeypress='return validateData(event,7);' class='form-control' autocomplete='off' name='strPurRate'  id='strPurRate"+k+"' onchange='calQty(this,"+k+");' value='"+strPurRate+"'></td>");
					
					sb.append("<td class='py-3' style='width: 7%; padding: .25rem;'><input type='text' onkeypress='return validateData(event,7);' class='form-control' autocomplete='off' name='strGST'       id='strGST"+k+"'     maxlength='5' onchange='calQty(this,"+k+");' value='"+item_tax+"'></td>");
					
					sb.append("<td class='py-3' style='width: 7%; padding: .25rem;'><input type='text' onkeypress='' class='form-control' autocomplete='off' name='strMRP'       id='strMRP"+k+"'      onchange='' value='"+MRP+"'></td>");
					
					sb.append("<td class='py-3' style='width: 7%; padding: .25rem;'><input type='text' onkeypress='return validateData(event,7);' class='form-control' autocomplete='off' name='strAdmchg'    id='strAdmchg"+k+"'  maxlength='5' onchange='calQty(this,"+k+");' value='"+admn_tax+"'></td>");
					sb.append("<td class='py-4 p-3' style='width: 7%; padding: .25rem;'><font color='red'><b><div name='Totalcost' id='TotalCost"+k+"'>"+costWthTax+"</div></b></font></td>");

					sb.append("<input type='hidden' name='strBrandId' value='' />");
					sb.append("</tr>");
					
					sb.append("<tr id='2'>");
					sb.append("<td colspan=5 style='align:right;'>");
					//sb.append("<input type='hidden' name='strPurRate' id='strPurRate"+k+"' value=''/>");				
					
					sb.append("<div  style='color: #173479;font-weight: bold;'>");
		
					sb.append("Pur Rate/Unit(incl Taxes):&nbsp;<label style='color: #736767;'>");
					//sb.append(rateWthTax);
					sb.append("<font color='red'><div name='purRateWthTaxDiv' id='purRateWthTaxDiv"+k+"'>"+rateWthTax+"</div></font>");
					sb.append("<input type='hidden' name='strPurWidTax' id='strPurWidTax"+k+"' value='"+rateWthTax+"'/>");
					sb.append("</label>");
					sb.append("</div>");
					sb.append("</td>");
										
					
					sb.append("<td colspan=5 style='align:left;'>");
					sb.append("<div  style='color: #173479;font-weight: bold;'>");
					sb.append("<input type='hidden' name='strCosttoPat' id='strCosttoPat"+k+"' value='"+costWthTax+"'/>");
					sb.append("Cost :&nbsp;<label style='color: #736767;'>");
					//sb.append(costWthTax);
					sb.append("<font color='red'><div id='costtopat1Div"+k+"'>"+costWthTax+"</div></font>");
					sb.append("</label>");
					sb.append("</div>");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr style='display:none;'>");
					sb.append("<td  style='width: 7%;padding: .25rem;'>.</td>");
					sb.append("<td style='width: 25%;padding: .25rem;'>Selected Drug Name: </td>");
					sb.append("<td style='width: 25%;padding: .25rem;'><div id='DrugNameId' style='font-weight:bold'></div></td>");
					sb.append("</tr>");
			 

					i++;
					k++;
				}													
				sb.append("<tr>");					
				sb.append("<td colspan='4'>");	
				sb.append("<div  style='color: #173479;font-weight: bold;align:right;'>");
				sb.append("Total Qty :&nbsp;");
				sb.append("</div>");
				sb.append("</td>");
				sb.append("<td colspan='1'>");				
				sb.append("<font color='red'><b><div id='totalQtyDiv'>"+sumQty+"</div></b></font>");
				sb.append("</td>");
				sb.append("<td colspan='4'>");	
				sb.append("<div  style='color: #173479;font-weight: bold;align:right;'>");
				sb.append("Total Cost :&nbsp;");
				sb.append("</div>");
				sb.append("</td>");
				sb.append("<td colspan='1'>");				
				sb.append("<font color='red'><b><div id='totalCostDiv'>"+sumCost+"</div></b></font>");
				sb.append("</td>");				
				sb.append("</tr>");	
				
				sb.append("<tr>");					
				sb.append("<td colspan='4'>");
				sb.append("</td>");				
				sb.append("<td colspan='4'>");	
				sb.append("<div  style='color: #173479;font-weight: bold;align:right;'>");
				sb.append("Difference in Amount :&nbsp;");
				sb.append("</div>");
				sb.append("</td>");
				sb.append("<td colspan='1'>");
				sb.append("<select name='strDifferenceAmtSign'  class='browser-default custom-select'>");
				sb.append("<option value='+'>+</option>");
				sb.append("<option value='-'>-</option>");
				sb.append("</select>");
				sb.append("</td>");
				sb.append("<td colspan='1'>");					
				sb.append("<input type='text' class='form-control' onkeyup='' value='0' name='strDifferenceAmt'  onkeypress='return validateData(event,7);' id='strDifferenceAmt' onkeypress='' autocomplete='off'>");

				sb.append("</td>");				
				sb.append("</tr>");
					
				sb.append("</table>");
				
			}
				
		
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='9' align='center'><br/>Details Not Available<br/><br/></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");
			sb.append("</div> ");
			
//			System.out.println("printItemDetails in hlp: "+sb.toString());

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
		finally {
			mmscofigutil = null;
		}
		
		return sb.toString();
	}
	
	public static String getLPItemDetails(WebRowSet ws,String hosCode,AckSuppReceiptVO vo) throws Exception {

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
		String strExpiryDt="",rateWthTax="",strbtch="",costtopat="",admchg="" , strmrp="",strPurRate="",strUser="",strRemarks="",strBrandId="",tmpId="0",strBal="",stritemTax="" , strRateWithTax="",manuf="";
		
		int i=1,k=0;	
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

		double sumCost = 0.000;
		int    sumQty  = 0 , z=0;

		try 
		{
			
			
			ws.beforeFirst();
			if(ws != null && ws.size() > 0)
			{
				ws.next();

				
				String store      			= ws.getString(1);
				String mrn_no 	   			= ws.getString(2);
				String challan_dt 			= ws.getString(3);
				String po_no 	   			= ws.getString(4);
				String po_date 				= ws.getString(5);
//				String item 				= ws.getString(6);
				String supp_info 			= ws.getString(7);
//				String sup_qty 				= ws.getString(8);
//				String rej_qty 				= ws.getString(9);
//				String rcd_qty 				= ws.getString(10);
//				String rate 				= ws.getString(11);
				String dc_no 				= ws.getString(12);
//				String po_qty 				= ws.getString(13);
				String mrp 					= ws.getString(14);
//				String exp_dt 				= ws.getString(15);
//				String btch 				= ws.getString(16);
				String pur_rate 			= ws.getString(17);
				String usr 					= ws.getString(18);
				String id 					= ws.getString(19);
				String bal_qty 				= ws.getString(20);
				String dlno 				= ws.getString(21);
//				String item_tax 			= ws.getString(22);
				String rate_with_tax 		= ws.getString(23);
				manuf						= ws.getString(24);
				cat 						= ws.getString(25);
				uc_req 						= ws.getString(26);
//				String admchg1 				= ws.getString(27);
				String costtopat1 			= ws.getString(28);
				String remarks1 			= ws.getString(29);
				String hstnum_supplier_id 	= ws.getString(30);
				String gnum_institute_code 	= ws.getString(31);
				String BillNo 				= ws.getString(32);
				String BillDate 			= ws.getString(33);
//				String GST					= ws.getString(34);
//				String Manu_dt				= ws.getString(35);
//				String Exp_dt				= ws.getString(36);
				String strExpectedDate      = ws.getString(38);
				
				

				sb.append("<input type='hidden' name='strInvoiceNo'    id='strInvoiceNo'      value='"+BillNo+"' />");
				sb.append("<input type='hidden' name='strInvoiceDate'  id='strInvoiceDate'    value='"+BillDate+"' />");
				sb.append("<input type='hidden' name='strSupplierId'  id='strSupplierId'    value='"+hstnum_supplier_id+"' />");
				sb.append("<input type='hidden' name='strDCNo'  id='strDCNo'    value='"+dc_no+"' />");
				
				
				sb.append("<div class='row'> ");
				sb.append("<div class='col-sm-2'></div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Store Name : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+store +"</div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Category : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+cat +"</div>");
				sb.append("</div> ");
				
				sb.append("<div class='row'> ");
				sb.append("<div class='col-sm-2' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'></div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>MRN No. : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+mrn_no+"</div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>MRN Date. : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+challan_dt+"</div>");
				sb.append("</div> ");
				
				
				sb.append("<div class='row'> ");
				sb.append("<div class='col-sm-2' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'></div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>P.O No  : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+po_no +"</div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Invoice Date.  : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+po_date +"</div>");
				sb.append("</div> ");
				
				sb.append("<div class='row'> ");
				sb.append("<div class='col-sm-2'></div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Bill No.: </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+BillNo+"</div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Bill Date.  : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+BillDate+"</div>");
				sb.append("</div> ");
				
				sb.append("<div class='row'> ");
				sb.append("<div class='col-sm-2'></div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Purchase  : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+gnum_institute_code+"</div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Expected Del. Date :</div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>"+strExpectedDate+"</div>");
				sb.append("</div> ");
				
				sb.append("<div class='row'> ");
				sb.append("<div class='col-sm-2'></div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'>Supplier  : </div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;line-height: normal;'>"+supp_info+"</div>");
				sb.append("<div class='col-sm-2  text-right' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'></div>");
				sb.append("<div class='col-sm-3' style='font-size: 13px;font-family: Verdana, Arial, Helvetica, sans-serif;font-weight: bold;'></div>");
				sb.append("</div> ");
												
				
				
				
				sb.append("<table class='table table-hover' id='POITable' style='margin-top:2%;'>");
				sb.append("<thead> "); 
				sb.append("<tr>");
				sb.append("<th style='padding-top: 1%;'>Batch No.<font color='red'>*</font></th>");
				sb.append("<th>Name<font color='red'>*</font></th>");
				//sb.append("<th>Category</th>");
				
				sb.append("<th>Mfg Date</th>");
				sb.append("<th>Exp Date</th>");					
				sb.append("<th>Total Qty<font color='red'>*</font></th>");
				sb.append("<th>Total Amt.<font color='red'>*</font></th>");
				sb.append("<th>GST(%)<font color='red'>*</font></th>");
				sb.append("<th>MRP<font color='red'>*</font></th>");
				sb.append("<th>Adm(%)<font color='red'>*</font></th>");
				sb.append("<th>Cost<font color='red'>*</font></th>");
//				sb.append("<th><button type='button' class='btn btn-info' onclick='insRow();'style='padding: 3px .55rem;font-size: 13px;'><i class='fa fa-plus'></i></button></th>");
			    sb.append("</tr>");
	
				sb.append("</thead> ");
				sb.append("<tbody id='RowId'>");
				String btches=" ";
				
		    	ws.beforeFirst();
				while (ws.next()) 
				{
					
						
//						strItem				  = ws.getString("item");
						String item 		  = ws.getString(6);
						String sup_qty 		  = ws.getString(8);
						cat 				  = ws.getString(25);
						String costWthTax	  = ws.getString(11);  // As Value ( Qty * Rate Wth Tax)
						String rej_qty 		  = ws.getString(9);
						String rcd_qty 		  = ws.getString(10);
						String po_qty 		  = ws.getString(13);
						String Manu_dt		  = ws.getString(35);
						String Exp_dt		  = ws.getString(36);
						String admn_tax		  = ws.getString(34);
						String btch 		  = ws.getString(16);
						admchg 		  		  = ws.getString(27);
						String item_tax 	  = ws.getString(22);
						String manuf1		  = ws.getString(24);
						String pKey 		  = ws.getString(37);
//						strRej				  = ws.getString("rej_qty");
//						strRcd				  = ws.getString("rcd_qty");
//						strAmount			  = ws.getString("rate");
//						strOrderQty			  = ws.getString("po_qty");
//						strmrp				  = ws.getString("mrp");
//						strExpiryDt			  = ws.getString("exp_dt");
//						strbtch 			  = ws.getString("btch");
						strPurRate			  = ws.getString("pur_rate");   // Purchase Rate With Out Tax 
//						strBrandId			  = ws.getString("id");
//						strBal				  = ws.getString("bal_qty");
//						stritemTax			  = ws.getString("item_tax");
						rateWthTax			  = ws.getString("costtopat");  // Purcahse Rate With Tax
//						admchg				  = ws.getString("admchg");
						String MRP1      	  = ws.getString(41);
						
						if(Double.parseDouble(admchg)>1000)
							admchg = Double.toString(1000.0);
//						strRateWithTax = ws.getString("RATE_WITH_TAX");
						manuf1 = ws.getString(24);
						
						
						if(k==0)
						{
							
							sumCost = Double.parseDouble(ws.getString(11));
							sumQty  = Integer.parseInt(ws.getString(10));							
							
						}
						else
						{	
							sumCost = sumCost + Double.parseDouble(ws.getString(11));
						    sumQty  = sumQty  + Integer.parseInt(ws.getString(10));
						}
							
						
							
												
								
					sb.append("<tr id='0' style='display:none;'>");
					
					sb.append("<input type='hidden' name='pKey'    id='pKey"+k +"'    value='"+pKey+"' />");
					sb.append("<input type='hidden' name='dateVal' id='dateVal"+k +"' value='"+Manu_dt+"^"+Exp_dt+"' />");	
					sb.append("<td  style='width: 25%;padding: .25rem;'>");
					sb.append("<td style='width: 9%;'><label><bean:write  name='SupplierReceiptBean' property='strItemCategoeryName' filter='false' /></label></td>");
					sb.append("</td>");
					sb.append("</tr>");					
					sb.append("<tr id='1'>");					
					sb.append("<td class='py-3' style='width: 10%;padding:  .25rem;'><input type='text' maxlength='27' autocomplete='off' id = 'strbatchno"+i+"' name='strbatchno' onkeyup='uppercasefn(this)' class='form-control' value='"+btch+"'></td>");
				
					sb.append("<td class='py-4' style='width: 41%;padding: .25rem;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(item);
					sb.append("</font></td> ");
													        
					sb.append("<td class='py-3' style='width: 20%;padding: .25rem;'><input id='strMfgDate"+k+"' type='text' name='strMfgDate' value='"+Manu_dt+"'></td>");
				
					sb.append("<td class='py-3' style='width: 22%;padding: .25rem;'><input id='strExpDate"+k+"' type='text' name='strExpDate'></td>");
					
					sb.append("<td class='py-3' style='width: 10%; padding: .25rem;'><input type='text' onkeypress='return validateData(event,5);' class='form-control' autocomplete='off' name='strTotalQty'  id='strTotalQty"+k+"' onchange='calQty(this,"+k+");' value='"+sup_qty+"'></td>");
					
					sb.append("<td class='py-3' style='width: 7%; padding: .25rem;'><input type='text' onkeypress='return validateData(event,7);' class='form-control' autocomplete='off' name='strPurRate'  id='strPurRate"+k+"' onchange='calQty(this,"+k+");' value='"+strPurRate+"'></td>");
					
					sb.append("<td class='py-3' style='width: 6%; padding: .25rem;'><input type='text' onkeypress='return validateData(event,7);' class='form-control' autocomplete='off' name='strGST'       id='strGST"+k+"'     maxlength='5' onchange='calQty(this,"+k+");' value='"+item_tax+"'></td>");
					
					sb.append("<td class='py-3' style='width: 6%; padding: .25rem;'><input type='text' onkeypress='' class='form-control' autocomplete='off' name='strMRP'       id='strMRP"+k+"'      onchange='' value='"+MRP1+"'></td>");
					
					sb.append("<td class='py-3' style='width: 8%; padding: .25rem;'><input type='text' onkeypress='return validateData(event,7);' class='form-control' autocomplete='off' name='strAdmchg'    id='strAdmchg"+k+"'  maxlength='5' onchange='calQty(this,"+k+");' value='"+admn_tax+"'></td>");
					sb.append("<td class='py-4 p-3' style='width: 8%; padding: .25rem;'><font color='red'><b><div name='Totalcost' id='TotalCost"+k+"'>"+costWthTax+"</div></b></font></td>");

					sb.append("<input type='hidden' name='strBrandId' value='' />");
					sb.append("</tr>");
					
					sb.append("<tr id='2'>");
					sb.append("<td colspan=4 style='align:right;'>");
					//sb.append("<input type='hidden' name='strPurRate' id='strPurRate"+k+"' value=''/>");				
					
					sb.append("<div  style='color: #173479;font-weight: bold;'>");
		
					sb.append("Pur Rate/Unit(incl Taxes):&nbsp;<label style='color: #736767;'>");
					//sb.append(rateWthTax);
					sb.append("<font color='red'><div name='purRateWthTaxDiv' id='purRateWthTaxDiv"+k+"'>"+rateWthTax+"</div></font>");
					sb.append("<input type='hidden' name='strPurWidTax' id='strPurWidTax"+k+"' value='"+rateWthTax+"'/>");
					sb.append("</label>");
					sb.append("</div>");
					sb.append("</td>");
										
					
					sb.append("<td colspan=5 style='align:left;'>");
					sb.append("<div  style='color: #173479;font-weight: bold;'>");
					sb.append("<input type='hidden' name='strCosttoPat' id='strCosttoPat"+k+"' value='"+costWthTax+"'/>");
					sb.append("Cost :&nbsp;<label style='color: #736767;'>");
					//sb.append(costWthTax);
					sb.append("<font color='red'><div id='costtopat1Div"+k+"'>"+costWthTax+"</div></font>");
					sb.append("</label>");
					sb.append("</div>");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr style='display:none;'>");
					sb.append("<td  style='width: 7%;padding: .25rem;'>.</td>");
					sb.append("<td style='width: 25%;padding: .25rem;'>Selected Drug Name: </td>");
					sb.append("<td style='width: 25%;padding: .25rem;'><div id='DrugNameId' style='font-weight:bold'></div></td>");
					sb.append("</tr>");
			 

					i++;
					k++;
				}													
				sb.append("<tr>");					
				sb.append("<td colspan='4'>");	
				sb.append("<div  style='color: #173479;font-weight: bold;align:right;'>");
				sb.append("Total Qty :&nbsp;");
				sb.append("</div>");
				sb.append("</td>");
				sb.append("<td colspan='1'>");
				
				sb.append("<font color='red'><b><div id='totalQtyDiv'>"+sumQty+"</div></b></font>");
				sb.append("</td>");
				sb.append("<td colspan='3'>");	
				sb.append("<div  style='color: #173479;font-weight: bold;align:right;'>");
				sb.append("Total Cost :&nbsp;");
				sb.append("</div>");
				sb.append("</td>");
				sb.append("<td colspan='1'>");				
				sb.append("<font color='red'><b><div id='totalCostDiv'>"+sumCost+"</div></b></font>");
				sb.append("</td>");				
				
					
				sb.append("</table>");
				
			}
				
		
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='9' align='center'><br/>Details Not Available<br/><br/></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");
			sb.append("</div> ");
			
//			System.out.println("printItemDetails in hlp: "+sb.toString());

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
		finally {
			mmscofigutil = null;
		}
		
		return sb.toString();
	}
	
	
	
	public static String getPrintItemDetails(WebRowSet ws,String hosCode,AckSuppReceiptVO vo) throws Exception 
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
		String strExpiryDt="",strbtch="",costtopat="",admchg="" , strmrp="",strPurRate="",strUser="",strRemarks="",strBrandId="",tmpId="0",strBal="",stritemTax="" , strRateWithTax="",manuf="",purchase_through="",strInvoiceDate="";
	    String strInvoiceNo="";
	    String MRP ="";  //31
		int i=1;
		double diffInAmt = 0.000;
		String diffAmtSign = "";

		HisUtil util = new HisUtil("mms", "getChallanPrintDetails");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(hosCode);			
	
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
			sb.append("Material Receipt Note </font></b></td><td width='10%'>&nbsp; ");
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
				strUser				  = ws.getString("usr");
				storeName  			  = ws.getString("store");
				uc_req  			  = ws.getString("uc_req");
				cat  			  	  = ws.getString("cat");
				strRemarks            = ws.getString("remarks");
				strInvoiceNo          = ws.getString("INV_NO");
				strInvoiceDate          = ws.getString("hstnum_invoice_date");
				purchase_through      = ws.getString(31);
                diffInAmt             = Double.parseDouble(ws.getString("DIFF_AMT").split("\\$")[1]);
				
				diffAmtSign           = ws.getString("DIFF_AMT").split("\\$")[0]; 
				
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
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Bill No : </b></font></td>");
				sb.append("<td align='left' width='40%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strInvoiceNo+"</b></font></td>");
				//sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Whether Uc.</b></font></td>");
				//sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+uc_req+"</b></font></td>");
				sb.append("<td align='right' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Bill Date : </b></font></td>");
				sb.append("<td align='left' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strInvoiceDate+"</b></font></td>");
				/*sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1]+"</b></font></td>");*/
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No : </b></font></td>");
				sb.append("<td align='left' width='40%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strPONo+"</b></font></td>");
				//sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Whether Uc.</b></font></td>");
				//sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+uc_req+"</b></font></td>");
				sb.append("<td align='right' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Date : </b></font></td>");
				sb.append("<td align='left' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strPODate+"</b></font></td>");
				/*sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1]+"</b></font></td>");*/
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier  : </b></font></td>");
				sb.append("<td align='left' width='40%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strVendor+"</b></font></td>");
				//sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Whether Uc.</b></font></td>");
				//sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+uc_req+"</b></font></td>");
				sb.append("<td align='right' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Purchase Through : </b></font></td>");
				sb.append("<td align='left' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+purchase_through+"</b></font></td>");
				/*sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1]+"</b></font></td>");*/
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
			sb.append("<tr><td width='100%' colspan='13'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
			sb.append("<tr> ");
			sb.append("<td align='center' width='2%'></td>");			
			sb.append("<td align='left' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Brand</b></font></td>");			
			sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Batch</b></font></td>");
			//sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Expire</b></font></td>");
			sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Tax</b></font></td>");
			sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>MRP</b></font></td>");
			sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif'   ><b>Pur.Rate</b></font></td>");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur.Rate(With Tax)</b></font></td>");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Adm Chg/Unit</b></font></td>");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost To Pat.</b></font></td>");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'><b>Qty</b></font></td>");			
			sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
			sb.append("</tr> ");
			sb.append("<tr><td width='100%' colspan='13'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
			
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
						MRP				  	  = ws.getString(41);
						
						//if(Double.parseDouble(admchg)>1000)
						//	admchg = Double.toString(1000.0);
						strRateWithTax = ws.getString("RATE_WITH_TAX");
						manuf = ws.getString("manuf");
						
					sb.append("<tr> ");
					sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");	
					
				
					sb.append("<td align='left' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strItem);
					sb.append("</font></td> ");
				
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strbtch);
					sb.append("</font></td> ");
					/*
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strExpiryDt);
					sb.append("</font></td> ");
					*/
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(stritemTax);
					sb.append("</font></td> ");
					
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(MRP);
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
//					sb.append(Math.round((Double.parseDouble(strRateWithTax) * Double.parseDouble(strRcd))* 1000.0)/1000.0);
					sb.append(strAmount);
					sb.append("</font></td></tr> ");
					
					
					
					i++;
//					tot=tot+(Double.parseDouble(strRateWithTax) * Double.parseDouble(strRcd));
					tot=tot+Double.parseDouble(strAmount);
					tmpId=strBrandId;

				}
				sb.append("<tr><td width='100%' colspan='13'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='5%' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>TOTAL</b></font></td>");
				sb.append("<td colspan='10'></td>");
//				sb.append("<td align='center' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+Math.round(tot * 1000.0)/1000.0+"</b></font></td>");
				sb.append("<td align='center' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+formatter.format(new BigDecimal(tot)) +"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='13'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				
				//sb.append("<tr> ");
			    //sb.append("<td colspan='12' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
			    //sb.append("</tr> ");
				if(diffInAmt> 0)
				{
					sb.append("<tr> ");
					sb.append("<td style='text-align:right;' width='5%' colspan='10'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Diff Amt [ "+diffAmtSign+" ]</b></font></td>");
					sb.append("<td style='text-align:right;'colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+diffInAmt+"</b></font></td>");
					sb.append("</tr> ");
					sb.append("<tr> ");
					sb.append("<td style='text-align:right;' width='5%' colspan='10'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Final TOTAL</b></font></td>");
					
					if(diffAmtSign.equals("+"))
					{	
					  sb.append("<td style='text-align:right;' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+(tot+diffInAmt)+"</b></font></td>");
					}
					else
					{
					  sb.append("<td style='text-align:right;' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+(tot-diffInAmt)+"</b></font></td>");	
					}
					sb.append("</tr> ");
				}	    
				
			    sb.append("<tr> ");
				sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Remarks : "+strRemarks+"<b></font><br></td> ");
				
				sb.append("<td colspan='7' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By : "+strUser+"<b></font></td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
//
				sb.append("<td colspan='12' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
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
	
	
	public static String getPrintDrugDetails(WebRowSet ws,String hosCode,AckSuppReceiptVO vo) throws Exception 
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
	    String PoDate;
	    String PoNo;
	    String MRP;	   
	    double diffInAmt = 0.000;
	    String diffAmtSign = "";
		int i=1;

		HisUtil util = new HisUtil("mms", "getChallanPrintDetails");			
	
		DecimalFormat myFormatter = new DecimalFormat("0.00");

	
		String strTableWidth = "700";

		try 
		{
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(hosCode);
			
		//	System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
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
			sb.append("Material Receipt Note </font></b></td><td width='10%'>&nbsp; ");
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
				strPODate	  		  = ws.getString("po_date");
				strVendor             = ws.getString("supp_info");
				strdcno				  = ws.getString("dc_no");
				strUser				  = ws.getString("usr");
				storeName  			  = ws.getString("store");
				uc_req  			  = ws.getString("uc_req");
				cat  			  	  = ws.getString("cat");
				strRemarks            = ws.getString("remarks");
				strInvoiceNo          = ws.getString("INV_NO");
				PoDate				  = ws.getString("PoDate");
				PoNo				  = ws.getString("PoNo");
				
				diffInAmt             = Double.parseDouble(ws.getString("DIFF_AMT").split("\\$")[1]);
				
				diffAmtSign           = ws.getString("DIFF_AMT").split("\\$")[0]; 
						
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
			sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>MRP</b></font></td>");
			sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Tax</b></font></td>");
			sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif'   ><b>Pur.Rate</b></font></td>");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur.Rate<br>(With Tax)</b></font></td>");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Adm Chg/Unit</b></font></td>");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost <br>To Pat.</b></font></td>");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'><b>Qty</b></font></td>");			
			sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font></td>");
			sb.append("</tr> ");
			sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
			
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
						
						//if(Double.parseDouble(admchg)>1000)
						//	admchg = Double.toString(1000.0);
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
					tmpId=strBrandId;

				}
				sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("<tr> ");
				sb.append("<td style='text-align:right;' width='5%' colspan='10'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>TOTAL</b></font></td>");
				sb.append("<td style='text-align:right;' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+Math.round(tot * 1000.0)/1000.0+"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
							    
				if(diffInAmt> 0)
				{
					sb.append("<tr> ");
					sb.append("<td style='text-align:right;' width='5%' colspan='10'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Diff Amt [ "+diffAmtSign+" ]</b></font></td>");
					sb.append("<td style='text-align:right;'colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+diffInAmt+"</b></font></td>");
					sb.append("</tr> ");
					sb.append("<tr> ");
					sb.append("<td style='text-align:right;' width='5%' colspan='10'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Final TOTAL</b></font></td>");
					
					if(diffAmtSign.equals("+"))
					{	
					  sb.append("<td style='text-align:right;' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+(tot+diffInAmt)+"</b></font></td>");
					}
					else
					{
					  sb.append("<td style='text-align:right;' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+(tot-diffInAmt)+"</b></font></td>");	
					}
					sb.append("</tr> ");
				}	          
			  
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
			//System.out.println("printItemDetails in hlp: "+sb.toString());

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
		finally {
			
		}
		return sb.toString();
	}
	
	public static String getModify_Details(WebRowSet ws,String hosCode,AckSuppReceiptVO vo) throws Exception 
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
	    String PoDate;
	    String PoNo;
	    String MRP;	   
	    double diffInAmt = 0.000;
	    String diffAmtSign = "";
		int i=1;

		HisUtil util = new HisUtil("mms", "getChallanPrintDetails");			
	
		DecimalFormat myFormatter = new DecimalFormat("0.00");

	
		String strTableWidth = "700";

		try 
		{
			
			sb.append("<br> ");			
			ws.beforeFirst();
			if(ws != null && ws.size() > 0)
			{
				ws.next();
				strMrnNo              = ws.getString("mrn_no");
				strMrnDate            = ws.getString("challan_dt");
				strPONo  		 	  = ws.getString("po_no");
				strPODate	  		  = ws.getString("po_date");
				strVendor             = ws.getString("supp_info");
				strdcno				  = ws.getString("dc_no");
				strUser				  = ws.getString("usr");
				storeName  			  = ws.getString("store");
				uc_req  			  = ws.getString("uc_req");
				cat  			  	  = ws.getString("cat");
				strRemarks            = ws.getString("remarks");
				strInvoiceNo          = ws.getString("INV_NO");
				PoDate				  = ws.getString("PoDate");
				PoNo				  = ws.getString("PoNo");
				
				diffInAmt             = Double.parseDouble(ws.getString("DIFF_AMT").split("\\$")[1]);
				
				diffAmtSign           = ws.getString("DIFF_AMT").split("\\$")[0]; 
						
									
			
				sb.append("<table width='100%' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.NO.</b></font></td>");
				sb.append("<td align='center' width='40%' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>ITEM DESCRIPTION</b></font></td>");
				sb.append("<td align='center' width='40%'  colspan='6'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>QUANTITY</b></font></td>");			
				sb.append("<td align='center' width='11%' colspan=6><font face='Verdana, Arial, Helvetica, sans-serif' ><b>AMOUNT</b></font></td>");
				sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='14'><hr style='margin: 8px 0px;border-top: 1px solid black;'></td></tr> ");
				sb.append("<tr> ");
				sb.append("<td align='center' width='2%'></td>");			
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Brand</b></font></td>");			
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Batch</b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Expire</b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>MRP</b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Tax</b></font></td>");
				sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif'   ><b>Pur.Rate</b></font></td>");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur.Rate<br>(With Tax)</b></font></td>");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Adm Chg/Unit</b></font></td>");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost <br>To Pat.</b></font></td>");
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'><b>Qty</b></font></td>");			
				sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='14'><hr style='margin: 8px 0px;border-top: 1px solid black;'></td></tr> ");
				
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
						
						//if(Double.parseDouble(admchg)>1000)
						//	admchg = Double.toString(1000.0);
						strRateWithTax = ws.getString("RATE_WITH_TAX");
						manuf = ws.getString("manuf");
					
					sb.append("<tr hidden>");
					sb.append("<td>"
							+ "<input hidden id='strMrnNo' name='strMrnNo' value='"+strMrnNo+"'>"
							+ "</td>");
					sb.append("<tr>");
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
					tmpId=strBrandId;

				}
				sb.append("<tr><td width='100%' colspan='14'><hr style='margin: 8px 0px;border-top: 1px solid black;'></td></tr> ");
				sb.append("<tr> ");
				sb.append("<td style='text-align:right;' width='5%' colspan='10'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>TOTAL</b></font></td>");
				sb.append("<td style='text-align:right;' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+Math.round(tot * 1000.0)/1000.0+"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='14'><hr style='margin: 8px 0px;border-top: 1px solid black;'></td></tr> ");
							    
				if(diffInAmt> 0)
				{
					sb.append("<tr> ");
					sb.append("<td style='text-align:right;' width='5%' colspan='10'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Diff Amt [ "+diffAmtSign+" ]</b></font></td>");
					sb.append("<td style='text-align:right;'colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+diffInAmt+"</b></font></td>");
					sb.append("</tr> ");
					sb.append("<tr> ");
					sb.append("<td style='text-align:right;' width='5%' colspan='10'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Final TOTAL</b></font></td>");
					
					if(diffAmtSign.equals("+"))
					{	
					  sb.append("<td style='text-align:right;' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+(tot+diffInAmt)+"</b></font></td>");
					}
					else
					{
					  sb.append("<td style='text-align:right;' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+(tot-diffInAmt)+"</b></font></td>");	
					}
					sb.append("</tr> ");
				}	          
			  
				
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
			
		}
		return sb.toString();
	}
	


}
