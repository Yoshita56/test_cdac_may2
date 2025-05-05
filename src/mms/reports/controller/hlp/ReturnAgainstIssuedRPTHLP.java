package mms.reports.controller.hlp;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.ReturnAgainstIssuedRPTVO;

public class ReturnAgainstIssuedRPTHLP {

/*private static final String strColor = "red";
private static final String defaultColor = "blue";
*/

public static String getIssuedDetail(WebRowSet wb)throws SQLException 
{
		StringBuffer br = new StringBuffer();

	    String strPatName = "";
		String strCrNo = "";
		String strIssuingStore = "";
		String strIssueNo = "";
		String strIssueDate = "";
		String strStoreId = "";
		

		int i = 0,j=1;

		try 
		{
			br.append("<div class='row m-0'>");
			br.append("<div id='' style='font-weight:350 !important ;font-size: 19px !important;'>&nbsp;Issued Details </div>");
			br.append("</div>");	
			
			br.append("<div class='row'>");
			br.append("<div class='col-md-12'>");
			br.append("<table class='table text-uppercase' align='center'>");
			br.append("<tr>");
			br.append("<thead class='thead-dark'>");
			br.append("<td  WIDTH='5%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>SNo</td>");
			br.append("<td  WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Patient Name</td>");
			br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>CR No</td>");
			br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Issuing Store</td>");
			br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Issue No</td>");
			br.append("<td  WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Issue Date</td>");
			br.append("<td  WIDTH='5%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>#</td>");
			br.append("</thead>");
			br.append("</tr>");
			
			
			if (wb.size() != 0) 
			{
			
				while (wb.next()) 
				{
					strPatName        = wb.getString(1);
					strCrNo           = wb.getString(2);
					strIssuingStore   = wb.getString(3);
					strIssueNo        = wb.getString(4);
					strIssueDate      = wb.getString(5);
					strStoreId        = wb.getString(9);
					
					br.append("<input type='hidden' name='strHlpCrNo'       id='strHlpCrNo"    +i+ "'  value=" + strCrNo + " />");
					br.append("<input type='hidden' name='strHlpIssueNo'    id='strHlpIssueNo" +i+ "'  value=" + strIssueNo + " />");
					br.append("<input type='hidden' name='strHlpStoreId'    id='strHlpStoreId" +i+ "'  value=" + strStoreId + " />");
					
					br.append("<tr>");	
					br.append("<td  WIDTH='5%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"+ j+ "</td>");							
					br.append("<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"  + strPatName + "</td>");
					br.append("<td WIDTH='20%' align='center'>");
					br.append("<input type='hidden' name='flag' id='flag" +i+ "' value=" + "0" + " />");
					br.append("<div class='popup' id='IssueItempopup' style='display: none'></div>");
					br.append("<a align='center' style='cursor:pointer;font-weight:350 !important ;font-size:16px;'  onClick='showPopUp(this,\""+ i + "\");'>" + strCrNo + "</a></td>");
					br.append("</td>");
					br.append("<td WIDTH='20%' align='center'   style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strIssuingStore + "</td>");
					br.append("<td WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strIssueNo + "</td>");
					br.append("<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strIssueDate + "</td>");
					br.append("<td WIDTH='5%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' ><img src='../../hisglobal/images/search_icon1.gif' onclick='generateIssueFunc(this,\""+ i + "\");' style='cursor: pointer;' title='Print Issue Item Details'></td>");
					br.append("</tr>");
					i++;
					j++;
				}

				br.append("</table> ");
				br.append("</div>");
				br.append("</div>");
			} else {
				br.append("<div class='row'>");
				br.append("<div class='col-md-12'>");
				br.append("<table class='table' style='font-weight:350 !important ;font-size: 16px !important;'>");
				br.append("<tr>");
				br.append("<td colspan='7' align='center' style='font-weight:350 !important ;font-size: 16px !important;color:red;'>"
						+ "No Record Found" + "</td>");
				br.append("</tr>");
				br.append("</table> ");
				br.append("</div>");
				br.append("</div>");
				br.append("</div>");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();
	}
	
public static String getReturnDetail(WebRowSet wb)throws SQLException 
{
		StringBuffer br = new StringBuffer();

	    String strPatName = "";
		String strCrNo = "";
		String strReturnStore = "";
		String strReturnNo = "";
		String strReturnDate = "";
		String strStoreId = "";
		

		int i = 0,j=1;

		try 
		{
			br.append("<div class='row m-0'>");
			br.append("<div id='' style='font-weight:350 !important ;font-size: 19px !important;'>&nbsp;Return Details </div>");
			br.append("</div>");
			
			br.append("<div class='row'>");
			br.append("<div class='col-md-12'>");
			br.append("<table class='table text-uppercase' align='center'>");
			br.append("<tr>");
			br.append("<thead class='thead-dark'>");
			br.append("<td  WIDTH='5%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>SNo</td>");
			br.append("<td  WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Patient Name</td>");
			br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>CR No</td>");
			br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Return To Store</td>");
			br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Return No</td>");
			br.append("<td  WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Return Date</td>");
			br.append("<td  WIDTH='5%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>#</td>");
			br.append("</thead>");
			br.append("</tr>");
			
			
			if (wb.size() != 0) 
			{
			
				while (wb.next()) 
				{
					strPatName        = wb.getString(1);
					strCrNo           = wb.getString(2);
					strReturnStore    = wb.getString(3);
					strReturnNo       = wb.getString(4);
					strReturnDate     = wb.getString(5);
					strStoreId        = wb.getString(8);
					
					br.append("<input type='hidden' name='strHlpCrNo'           id='strHlpCrNo" +i+ "'           value=" + strCrNo + " />");
					br.append("<input type='hidden' name='strHlpReturnNo'       id='strHlpReturnNo" +i+ "'       value=" + strReturnNo + " />");
					br.append("<input type='hidden' name='strHlpReturnStoreId'  id='strHlpReturnStoreId" +i+ "'  value=" + strStoreId + " />");
					br.append("<input type='hidden' name='strHlpReturnDate'     id='strHlpReturnDate" +i+ "'  	  value=" + strReturnDate + " />");

					
					br.append("<tr>");	
					br.append("<td  WIDTH='5%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"+ j+ "</td>");							
					br.append("<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"  + strPatName + "</td>");
					br.append("<td WIDTH='20%' align='center'>");
					br.append("<input type='hidden' name='flag' id='flag" +i+ "' value=" + "0" + " />");
					br.append("<div class='popup' id='IssueItempopup' style='display: none'></div>");
					br.append("<a align='center' style='cursor:pointer;font-weight:350 !important ;font-size:16px;'  onClick='showPopUp(this,\""+ i + "\");'>" + strCrNo + "</a></td>");
					br.append("</td>");
					br.append("<td WIDTH='20%' align='center'   style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strReturnStore + "</td>");
					br.append("<td WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strReturnNo + "</td>");
					br.append("<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strReturnDate + "</td>");
					br.append("<td WIDTH='5%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' ><img src='../../hisglobal/images/search_icon1.gif' onclick='generateReturnFunc(this,\""+ i + "\");' style='cursor: pointer;' title='Print Issue Item Details'></td>");
					br.append("</tr>");
					i++;
					j++;
				}

				br.append("</table> ");
				br.append("</div>");
				br.append("</div>");
			} else {
				br.append("<div class='row'>");
				br.append("<div class='col-md-12'>");
				br.append("<table class='table' style='font-weight:350 !important ;font-size: 16px !important;'>");
				br.append("<tr>");
				br.append("<td colspan='7' align='center' style='font-weight:350 !important ;font-size: 16px !important;color:red;'>"
						+ "No Record Found" + "</td>");
				br.append("</tr>");
				br.append("</table> ");
				br.append("</div>");
				br.append("</div>");
				br.append("</div>");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();
	}

public static String getIssueVoucher(ReturnAgainstIssuedRPTVO vo,String mode) throws Exception {
    StringBuffer sb = new StringBuffer("");
    int i = 1;
    ResourceBundle res = null;
    WebRowSet ws = null;
    WebRowSet ws1 = null;
    String strTableWidth = "850";

    try {
      
    	
  	  sb.append("<table   width='850' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
					+ " <tr> "
					+ " <td colspan='1'></td>"
					//+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/"+vo.getStrLogoName()+"' ></div></td>"
					+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
					);
  	  if(mode.equals("1"))
  	  {
  		  sb.append("<td colspan='1'><td colspan='1'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData_O();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();' /></div></td>");
  	  }
  	  else
  	  {
  		  if(mode.equals("2"))
	    	  {
	    		  sb.append("<td colspan='1'><td colspan='1'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData_O();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();' /></div></td>");
	    	  }
  		  else
  		  {
  		      sb.append("<td colspan='1'><td colspan='1'><div id='printImg' align='right'></div></td>");
  		  }    
  	  }
  	  sb.append("</tr>");			
  		
  	  sb.append("</table>");
			        
       sb.append("<table width='850' align='center' cellpadding='1px' cellspacing='1px'> ");
       sb.append("<tr>");
       sb.append("<td width='100%' align='center' colspan='5'><font face='Verdana, Arial, Helvetica, sans-serif' size='3'>Issue Invoice</font></td> ");
      

       /*
     		0	   NVL(HIPNUM_ADMNO, '0') 
     		1	^  NVL(HRGNUM_EPISODE_CODE, '0') 
     	    2	^  NVL(HRGNUM_VISIT_NO,'0') 
     		3	^  NVL(TO_CHAR(HIPDT_ADMDATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ')
     		4	^  NVL(HIPNUM_ADM_ADVNO,'0') 
     		5	^  NVL(GNUM_DEPT_CODE,'000')
     		6	^  NVL(HIPNUM_WARD_CODE,'0') 
     		7	^  NVL(HIPNUM_ROOM_CODE,'0') 
     		8	^  NVL(HIPNUM_BED_CODE,'0')
     		9	^  NVL(HIPNUM_TREAT_CATEG_CODE,'0')  
     	   10	^  NVL(HIPNUM_ISNEWBORN,'0') 
     	   11	^  NVL(HIPNUM_MOTHADMNO,'0') 
     	   12	^  NVL(HRGNUM_MLC_NO,'0')
     	   13	^  NVL(HIPNUM_OCCUP_ID,'0') 
     	   14	^  NVL(TO_CHAR(HIPDT_BEDALLOC_DATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ') 
     	   15	^  NVL(HIPNUM_LENGTHOFSTAY,'0'))
     	   16	^  NVL(GNUM_DEPTUNIT_CODE,'00000')
     	   17	^  hblnum_pataccount_status
	*/		
					
					
			/* vo.getStrPatientDtlHidVal()
            HRGDT_DOB || ''^'' ||GNUM_GENDER_CODE ||''^''||HGNUM_PAT_STATUS_CODE || ''^''||
	          HGNUM_PATIENT_CAT_CODE || ''^'' ||HRGNUM_IS_MLC    ||''^''||HRGNUM_ISNEWBORN      || ''^''|| HRGNUM_ID_NO
			*/
			// By Vivek	
       sb.append("</tr>");	        
       sb.append("<tr> ");
       sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>").append("CR No:</b></font></td> ");
       sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>").append(vo.getStrPuk()).append("</font></td> ");
       sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>").append("Issue Store:</b></font></td> ");
       sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>"+vo.getStrStoreName()+"</font></td> ");
       sb.append("</tr>");
       
       sb.append("<tr> ");	         
       sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>").append("Invoice No:</b></font></td> ");
       sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>").append(vo.getStrIssueNo()).append("</font></td> ");
       sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>").append("Invoice Date:</b></font></td> ");
       sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>").append(vo.getStrIssueDate()).append("</font></td> ");
       sb.append("</tr> ");
       sb.append("<tr> ");
       sb.append("<table width='850' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
       sb.append("<tr>");
       sb.append("<td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>");
       sb.append(vo.getStrPatientDtl());
       sb.append("</font></td> ");
       sb.append("</tr> ");
       sb.append("</table>");     
      
       sb.append("<table class='custom-table' width='850' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
       sb.append("<tr bgcolor='#cdc9c9'> ");
       sb.append("<td align='center' width='5%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>SL</b></font> ");
       sb.append("</td>");
       sb.append("<td align='center' width='39%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Product</b></font> ");
       sb.append("</td>");
       sb.append("<td align='center' width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Batch No.</b></font> ");
       sb.append("</td> ");
       sb.append("<td align='center' width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Expiry</b></font>");
       sb.append("</td> ");	       
       sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Qty</b></font>");
       sb.append("</td> ");
       sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>MRP</b></font>");
       sb.append("</td> ");
       sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Rate</b></font>");
       sb.append("</td> ");
       sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>DIS(%)</b></font>");
       sb.append("</td> ");
       sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Cost</b></font>");
       sb.append("</td> ");
       sb.append("</tr> ");
       float NetAmount = 0.0F;
       String rem = "";
       String user = "";
       double  dis,amount,markedprice,salePrice,per;
       ws = vo.getWsIssueDetails();
     
			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{	
					  /*
                     1. Issue No
                     2. Issue Date
                     3. Pat Name
                     4. Store Name
                     5. Generic Name
                     6. Brnad Name
                     7. BATCH
                     8. EXP Date
                     9. Rate / Unit
                    10. Issue Qty Wth Unit 
                    11. Store Id
                    12. Item Id
                    13. Brand Id
                    14. BATCH
                    15. Exp Date
                    16. Rate 
                    17. Rate Unit Id
                    18. Rate Base Value
                    19. Base Vale
                    20. Issue Qty Unit Id
                    21. Qty Base Value
                    22. Sl Npo
                    23. NVL
                    24. Catg Code
                    25. Bal Qty
                    26. NVL
                    27. Remarks
                    28. Rec By
                    29. HSTNUM_TOTAL_COST
                    30. Budget
                    31. NVL
                    32. Issue Date
                    33. MRP of Drug
                    34. Total Purchase Cost
                    35. Cr No 
                    36. Issue By User Name
                    37. Order By
                    38. Hosp Name
                    39. HSTSTR_LOCATION 
                  */
					
					vo.setStrUserName(ws.getString(36));
                  /*  
					    Discount = Marked Price � Selling Price
					    And Discount Percentage = (Discount/Marked price) x 100
				    */
					markedprice = Double.parseDouble(ws.getString(33));
					salePrice   = Double.parseDouble(ws.getString(16));
					if(Double.parseDouble(ws.getString(33))>0)
					{
						
						dis         = markedprice -  salePrice;
						per         = (dis/markedprice) * 100;
					}
					else
					{
						dis         = 0;
						per         = 0;  
					}
					
					
					sb.append("<tr > ");
					sb.append("<td align='center' width='5%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(i+".");
					sb.append("</font></td> ");					
					sb.append("<td align='left' width='39%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;' >");
					sb.append(ws.getString(6));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif'  style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(8));
					sb.append("</font></td> ");
					sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(10));
					sb.append("</font></td> ");
					sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(33));
					sb.append("</font></td> ");
					sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(16));
					sb.append("</font></td> ");
					sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(Math.round(per));
					sb.append("</font></td> ");
					sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(29));
					sb.append("</font></td> ");  									
					sb.append("</tr> ");
					NetAmount=NetAmount+ Float.parseFloat(ws.getString(29));
					i++;
								
				}							
					
					sb.append("<tr>");
					sb.append("<td colspan='8' align='right' style='padding: 1%;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>GRAND TOTAL</b></font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(Math.round(NetAmount));
					
					sb.append("</font></td>");
					sb.append("</tr>");
					
					 sb.append("<tr>");
			         sb.append("<td colspan='9' align='left'><hr size='1' style='margin-top: 0rem;border-top: 1px solid rgb(0, 0, 0);border-block-style: dashed;'></td>");			       
			         sb.append("</tr>");
						
					sb.append("<tr>");
					sb.append("<td colspan='4' align='left'><u><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Terms & Conditions</font></td>");
					sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>FOR I.G.I.M.S CENTRAL PHARMACY</font></td>");					
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td colspan='5' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Un-used Medicine must be returned before discharge</font></td>");
					sb.append("<td colspan='4' align='center'></td>");					
					sb.append("</tr>");						
					sb.append("<tr>");
					sb.append("<td colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>User:"+vo.getStrUserName()+"</font></td>");
					sb.append("<td colspan='3' align='left'>User Sign</td>");	
					sb.append("<td colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Authorised Signatory</font></td>");	
					sb.append("</tr>");
				        		
			} else {
          sb.append("<tr> ");
          sb.append("<td colspan='9' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>No Reocrd</b><br/><br/></font></td> ");
          sb.append("</tr> ");
       }

       sb.append("</table> ");
       sb.append("<table align='center' width='850' border='0' cellspacing='0' cellpadding='0' height='69'> ");
       sb.append("<tr>");
       sb.append("<td width='10%'></td>");
       sb.append("<td width='80%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
       sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
       sb.append("</tr> ");
       sb.append("</table>");
    } catch (Exception var16) {
       var16.printStackTrace();
       throw var16;
    } finally {
       if (ws != null) {
          ws.close();
          ws = null;
       }
    }
    return sb.toString();

}

public static String getReturnVoucher(ReturnAgainstIssuedRPTVO vo,String mode) throws Exception {
    StringBuffer sb = new StringBuffer("");
    int i = 1;
    ResourceBundle res = null;
    WebRowSet ws = null;
    WebRowSet ws1 = null;
    String strTableWidth = "825";

    try {
      
  	  
  	  sb.append("<table  width='850' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
					+ " <tr> "
					+ " <td colspan='1'></td>"
					//+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/"+vo.getStrLogoName()+"' ></div></td>"
					+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>");
  	  if(mode.equals("1"))
  	  {
  		  sb.append("<td colspan='1'><td colspan='1'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData_O();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();' /></div></td>");
  	  }
  	  else
  	  {
  		  sb.append("<td colspan='1'><td colspan='1'><div id='printImg' align='right'></div></td>");
  	  }
  	  sb.append("</tr>");			
  		
  	  sb.append("</table>");
			        
       sb.append("<table width='850' align='center' cellpadding='1px' cellspacing='1px'> ");
       sb.append("<tr>");
       sb.append("<td width='850' align='center' colspan='5'><font face='Verdana, Arial, Helvetica, sans-serif' size='3'>Return Invoice</font></td> ");
      

       /*
     		0	   NVL(HIPNUM_ADMNO, '0') 
     		1	^  NVL(HRGNUM_EPISODE_CODE, '0') 
     	    2	^  NVL(HRGNUM_VISIT_NO,'0') 
     		3	^  NVL(TO_CHAR(HIPDT_ADMDATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ')
     		4	^  NVL(HIPNUM_ADM_ADVNO,'0') 
     		5	^  NVL(GNUM_DEPT_CODE,'000')
     		6	^  NVL(HIPNUM_WARD_CODE,'0') 
     		7	^  NVL(HIPNUM_ROOM_CODE,'0') 
     		8	^  NVL(HIPNUM_BED_CODE,'0')
     		9	^  NVL(HIPNUM_TREAT_CATEG_CODE,'0')  
     	   10	^  NVL(HIPNUM_ISNEWBORN,'0') 
     	   11	^  NVL(HIPNUM_MOTHADMNO,'0') 
     	   12	^  NVL(HRGNUM_MLC_NO,'0')
     	   13	^  NVL(HIPNUM_OCCUP_ID,'0') 
     	   14	^  NVL(TO_CHAR(HIPDT_BEDALLOC_DATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ') 
     	   15	^  NVL(HIPNUM_LENGTHOFSTAY,'0'))
     	   16	^  NVL(GNUM_DEPTUNIT_CODE,'00000')
     	   17	^  hblnum_pataccount_status
	*/		
					
					
			/* vo.getStrPatientDtlHidVal()
            HRGDT_DOB || ''^'' ||GNUM_GENDER_CODE ||''^''||HGNUM_PAT_STATUS_CODE || ''^''||
	          HGNUM_PATIENT_CAT_CODE || ''^'' ||HRGNUM_IS_MLC    ||''^''||HRGNUM_ISNEWBORN      || ''^''|| HRGNUM_ID_NO
			*/
			// By Vivek	
       sb.append("</tr>");	        
       sb.append("<tr> ");
       sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>").append("CR No:</b></font></td> ");
       sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>").append(vo.getStrCrNo()).append("</font></td> ");
       sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>").append("Store:</b></font></td> ");
       sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>"+vo.getStrStoreName()+"</font></td> ");
       sb.append("</tr>");
       
       sb.append("<tr> ");	         
       sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>").append("Return No:</b></font></td> ");
       sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>").append(vo.getStrReturnNo()).append("</font></td> ");
       sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>").append("Return Date:</b></font></td> ");
       sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>").append(vo.getStrReturnDate()).append("</font></td> ");
       sb.append("</tr> ");
       sb.append("<tr> ");
       sb.append("<table width='850' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
       sb.append("<tr>");
       sb.append("<td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>");
       sb.append(vo.getStrPatientDtl());
       sb.append("</font></td> ");
       sb.append("</tr> ");
       sb.append("</table>");     
      
       sb.append("<table class='custom-table' width='850' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
       sb.append("<tr bgcolor='#cdc9c9'> ");
       sb.append("<td align='center' width='5%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>SL</b></font> ");
       sb.append("</td>");
       sb.append("<td align='center' width='39%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Product</b></font> ");
       sb.append("</td>");
       sb.append("<td align='center' width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Batch No.</b></font> ");
       sb.append("</td> ");
       sb.append("<td align='center' width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Expiry</b></font>");
       sb.append("</td> ");	       
       sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Qty</b></font>");
       sb.append("</td> ");
       sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>MRP</b></font>");
       sb.append("</td> ");
       sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Rate</b></font>");
       sb.append("</td> ");
       sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>DIS(%)</b></font>");
       sb.append("</td> ");
       sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Cost</b></font>");
       sb.append("</td> ");
       sb.append("</tr> ");
      
       float NetAmount = 0.0F;
       String rem = "";
       String user = "";
       double  dis,amount,markedprice,salePrice,per;
       ws = vo.getWsIssueDetails();
     
			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{	
					/*
		            1. Return No
		            2. Return Date
		            3. Patient Name ( Cr No ) @ issue By
		            4. Store Name
		            5. Generic Name
		            6. Brand Name
		            7. Batch No
		            8. Expiry Date 
		            9. Rate Wth Unit
		           10. Issue Qty wth Unit
		           11. Store Id
		           12. Item Id
		           13. Brand Id
		           14. Batch No
		           15. Exp Date
		           16. Rate Per Unit
		           17. Unit Id
		           18. Rate Base Value
		           19. NVL
		           20. Req Unit Id
		           21. Qty Base Value
		           22. SL No
		           23. Sl No
		           24. Catg Code
		           25. Rec by
		           26. Remarks
		           27.Loc @ Dl No
		           28.CR No
		           29.Mrp  
		           30.Cost of Item 
		         */
                 /*  
					    Discount = Marked Price � Selling Price
					    And Discount Percentage = (Discount/Marked price) x 100
				    */
					markedprice = Double.parseDouble(ws.getString(29));
					salePrice   = Double.parseDouble(ws.getString(16));
					dis         = markedprice -  salePrice;
					per         = (dis/markedprice) * 100;  
					
					
					sb.append("<tr> ");
					sb.append("<td align='center' width='5%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(i+".");
					sb.append("</font></td> ");					
					sb.append("<td align='left' width='39%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;' >");
					sb.append(ws.getString(6));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;' >");
					sb.append(ws.getString(8));
					sb.append("</font></td> ");
					sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(10));
					sb.append("</font></td> ");
					sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(29));
					sb.append("</font></td> ");
					sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(16));
					sb.append("</font></td> ");
					sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(Math.round(per));
					sb.append("</font></td> ");
					sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(30));
					sb.append("</font></td> ");  									
					sb.append("</tr> ");
					NetAmount=NetAmount+ Float.parseFloat(ws.getString(30));
					i++;
								
				}							
					
				
					
					sb.append("<tr>");
					sb.append("<td colspan='8' align='right' style='padding: 1%;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>GRAND TOTAL</b></font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(Math.round(NetAmount));
					
					sb.append("</font></td>");
					sb.append("</tr>");
					
					 sb.append("<tr>");
			         sb.append("<td colspan='9' align='left'><hr size='1' style='margin-top: 0rem;border-top: 1px solid rgb(0, 0, 0);border-block-style: dashed;'></td>");			       
			         sb.append("</tr>");
						
					sb.append("<tr>");
					sb.append("<td colspan='4' align='left'><u><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Terms & Conditions</font></td>");
					sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>FOR I.G.I.M.S CENTRAL PHARMACY</font></td>");					
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td colspan='5' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Un-used Medicine must be returned before discharge</font></td>");
					sb.append("<td colspan='4' align='center'></td>");					
					sb.append("</tr>");						
					sb.append("<tr>");
					sb.append("<td colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>User:"+vo.getStrUserName()+"</font></td>");
					sb.append("<td colspan='3' align='left'>User Sign</td>");	
					sb.append("<td colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Authorised Signatory</font></td>");	
					sb.append("</tr>");
				        		
			} else {
          sb.append("<tr> ");
          sb.append("<td colspan='9' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>No Reocrd</b><br/><br/></font></td> ");
          sb.append("</tr> ");
       }

       sb.append("</table> ");
       sb.append("<table align='center' width='850' border='0' cellspacing='0' cellpadding='0' height='69'> ");
       sb.append("<tr>");
       sb.append("<td width='10%'></td>");
       sb.append("<td width='80%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
       sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
       sb.append("</tr> ");
       sb.append("</table>");
    } catch (Exception var16) {
       var16.printStackTrace();
       throw var16;
    } finally {
       if (ws != null) {
          ws.close();
          ws = null;
       }

    }

    return sb.toString();
 }


}
