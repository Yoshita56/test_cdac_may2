package mms.transactions.controller.hlp;

//import mms.hisglobal.hisconfig.HisLanguageProperties;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;

import hisglobal.utility.HisUtil;
import mms.transactions.controller.fb.PODeskPrintTransFB;

// TODO: Auto-generated Javadoc
/**
 * The Class PODeskGenerateTransHLP.
 * 
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 */
public class PODeskPrintTransNEWHLP 
{
	private StringBuffer htmlStr = new StringBuffer(1000);
		
	/**
	 * Gets the component detail.
	 * 
	 * @param formBean
	 *            the _po desk generate trans fb
	 * @return the component detail
	 */
	/*
	public static String getComponentDetail(
			PODeskPrintTransFB formBean,HttpServletRequest request) {
		StringBuffer sBuffer = null;

		try {
			sBuffer = new StringBuffer("");

			for (int nTmpI = 0; nTmpI < formBean
					.getStrComponentID().length; nTmpI++) 
			    {
				if (nTmpI == 0) {
					sBuffer.append("<table width='100%' align='center' border='0'  cellspacing='0px'><tr>");
					sBuffer.append("<td width='30%' class='LABEL'><div align='right'>"+"Please do not delete tag within"+" ##,"+"It is system defined tag"+" !!</div></td>");
				}

				sBuffer.append("<table width='100%' align='center' border='0'  cellspacing='0px'><tr>");
				sBuffer.append("<td width='30%' class='LABEL'>"
						+ formBean.getStrComponentName()[nTmpI]
						+ "</td>");
				sBuffer.append("<td width='60%' class='CONTROL'>"
						+ "<input type='hidden' name='strDComponentId' id='strDComponentId"
						+ nTmpI
						+ "' value='"
						+ formBean.getStrComponentID()[nTmpI]
						+ "'>"
						+ "<textarea name='strDComponentValue' id='strDComponentValue"
						+ nTmpI + "' style='width:700px; height:200px '>"
						+ formBean.getStrComponentValue()[nTmpI]
						+ "</textarea></td>");

				sBuffer.append("<td width='10%' class='CONTROL'><input type='checkbox' name='strChkComponent' onclick=\"checkComponentValue(this,'"
						+ nTmpI + "');\" checked></td>");
				sBuffer.append("</tr></table>");
			}
			if (formBean.getStrMsgType().equals("1"))
				throw new Exception(formBean.getStrMsgString());

		} catch (Exception _e) {
			_e.printStackTrace();
			formBean
					.setStrMsgString("PODeskGenerateTransHLP.getComponentDetail() --> "
							+ _e.getMessage());
			formBean.setStrMsgType("1");
		}
		return sBuffer.toString();
	}
	*/
	
	public String getPoHlp(PODeskPrintTransFB formBean, HttpServletRequest request) throws SQLException
	{
	    String isDraftFlag = "";
	    HisUtil util = new HisUtil("", "");


		htmlStr = new StringBuffer(4000);

		htmlStr.append("<html>");
		htmlStr.append("<head>");
		// htmlStr.append("<title>PO Report</title>");
		htmlStr.append("</head>");
		
		htmlStr.append("<body>");
		htmlStr.append("<div id='prescriptionTile' style='box-shadow: 0.5px 0.5px 10px 2px #b0acac; border-radius: .35rem;padding:10px;'>");

		
		if(isDraftFlag.equals("0"))
		{
							   
		htmlStr.append("<div id='backgroundprint'>Draft Copy</div>");
		htmlStr.append("<div id='contentprint'>"); 
		}
		htmlStr.append("<div id='saveId' style='display : block'><div align='right' class='hidecontrol' id='printid1'>");
		htmlStr.append("<table width='95%' align='center' >");
		htmlStr.append("<tr> ");
		htmlStr.append("<td align='left'>");
		htmlStr.append("<div id='storeNameBarcode' style='float:left;'></div>");						
		htmlStr.append("</td> ");
					
		htmlStr.append("<td align='right'>");
		htmlStr.append("<img style='cursor: pointer;' title='Print'  src='../../hisglobal/images/printer_symbol.gif' onClick='printDataMain();' /> ");
		htmlStr.append("<img style='cursor: pointer;' title='Cancel'   src='../../hisglobal/images/stop.png' onClick='closePopup();' /> ");
		htmlStr.append("</td> ");
		htmlStr.append("</tr> ");
		htmlStr.append("</table> ");
		htmlStr.append("</div>");
		
		htmlStr.append("</div>");

		/**************************************** Header Details **********************************************/
		
	    htmlStr.append("<table cellpadding='1px' cellspacing='1px' width='95%' align='center'>");
		htmlStr.append("<tr>");					
		htmlStr.append("<td width='100%'>");
		htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");	
		htmlStr.append("<tr>");	
		htmlStr.append("<td align='center'><img src='../../hisglobal/images/aiims_inv_header.png'></td>");					
		htmlStr.append("</tr>");			                       
		htmlStr.append("</table>");
		htmlStr.append("</td>");						
		htmlStr.append("</tr>");		
		htmlStr.append("<tr>");					
		htmlStr.append("<td width='100%'>");
		htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");	
		htmlStr.append("<tr>");	
		if(formBean.getStrPOTypeId().equals("22"))
		{
		   htmlStr.append("<td align='center'><font face='Arial, Helvetica, sans-serif' size='3'><br><b><u>Local Purchase Order<u><b></font></td>");	
		}
		else
		{
		   htmlStr.append("<td align='center'><font face='Arial, Helvetica, sans-serif' size='3'><br><b><u>Purchase Order<u><b></font></td>");
		}
		
		htmlStr.append("</tr>");			                       
		htmlStr.append("</table>");
		htmlStr.append("</td>");						
		htmlStr.append("</tr>");	
		
		htmlStr.append("<tr>");					
		htmlStr.append("<td width='100%'>");
		htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
		
	   
	    String poNoWithDate = "";
		if (formBean.getWbPODtls() != null && formBean.getWbPODtls().size() > 0)
		{
			if(formBean.getWbPODtls().next())
			{
				poNoWithDate = formBean.getWbPODtls().getString(1);
			}
		}
		formBean.getWbPODtls().beforeFirst();
			
		htmlStr.append("<tr>");
		htmlStr.append("<td align='left' ><font face='Arial, Helvetica, sans-serif' size='2'><strong>File No :________________________________</strong></font></td>");
		htmlStr.append("</tr>");
		
		htmlStr.append("<tr>");
		htmlStr.append("<td align='center' ><font face='Arial, Helvetica, sans-serif' size='2'><strong>PURCHASE ORDER NO / Date  :- "+poNoWithDate+"</strong></font></td>");
		htmlStr.append("</tr>");
		
		htmlStr.append("<tr>");
		htmlStr.append("<td align='right' ><font face='Arial, Helvetica, sans-serif' size='2'><strong><u>GST of AIIMS, BBSR</u></strong>:________________________</font></td>");
		htmlStr.append("</tr>");
		
		htmlStr.append("</table>");
		htmlStr.append("</td>");						
		htmlStr.append("</tr>");	

		/**************************************** Header Details  END **********************************************/
	
		
		/**************************************** Supplier Details **********************************************/
		
		/*
        1.PO_WTH_DATE
        2.SUPP_NAME
        3.PO_TYPE
        4.CATG
        5.PO_REMARKS
        6.PO_ENTER_BY_USER_NAME
        7.PO_GEN_BY_STORE_NAME
        8.PURCHASE_SOURCE
        9.RATE_CONTRACT_ID
       10.RAT_COTRACT_QTY
       11.ITEM_NAME
       12.ITEM_CODE_NO
       13.RATE_WITHOUT_TAX
       14.ITEM_ORDER_QTY
       15.ITEM_COST_WITHOUT_TAX
       16.RATE_WITH_TAX
       17.ITEM_COST_WITH_TAX
       18.ITEM_TAX
       19.DELIVERY_DATE
       20.PACK_SIZE
       21.ENTER_BY_USER_NAME/DATE
       22.     INITCAP(F.HSTSTR_SUPPLIER_NAME) - 
       INITCAP(F.hststr_contact_person)  - 
       INITCAP(F.hststr_address)  - 
       INITCAP(F.hststr_city_name)  - 
       INITCAP(F.hststr_pincode)  - 
       INITCAP(F.hststr_phone1)  - 
       INITCAP(F.hststr_email1)  -              
       INITCAP(F.hststr_faxno1)  - 
       INITCAP(F.hststr_website)  - 
       INITCAP(F.gnum_countrycode)  - 
       INITCAP(F.gnum_statecode)
       23.P_KEY - B.HSTNUM_ITEMBRAND_ID||'^'||B.HSTNUM_SUPPLIER_ID||'^'||A.SSTNUM_POTYPE_ID||'^'||A.SSTNUM_ITEM_CAT_NO||'^'||A.HSTNUM_PO_NO||'^'||A.HSTNUM_STORE_ID
       24.ITEM_SPECIFICATION 
      */
		 int l=0;
		if (formBean.getWbPODtls() != null && formBean.getWbPODtls().size() > 0)
		{
			while(formBean.getWbPODtls().next())
			{	
				if(l==0)
				{	
				    /*
			          -------------------------------------
			         |       B1        |          B2       | 
			         |                 |                   |
			          -------------------------------------
			       */
			
				    htmlStr.append("<tr><td align='left'>");
				    htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
					htmlStr.append("<tr>");
					htmlStr.append("<td width ='50%'>");
					 
				        /* BLOCK - I  */
						htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='3'><strong><br><u>To,</u></strong></font></td>");
						htmlStr.append("</tr>");						
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> " +formBean.getWbPODtls().getString(22).split("\\-")[1] + "</font></td>");
						htmlStr.append("</tr>");
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong>" + formBean.getWbPODtls().getString(22).split("\\-")[0] + "</font></td>");
						htmlStr.append("</tr>");
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> " + formBean.getWbPODtls().getString(22).split("\\-")[2]+" "+formBean.getWbPODtls().getString(22).split("\\-")[3] +" Pin - "+formBean.getWbPODtls().getString(22).split("\\-")[4]+" Phone No - "+formBean.getWbPODtls().getString(22).split("\\-")[5]+ "</font></td>");
						htmlStr.append("</tr>");								
													
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> E-Mail - "+formBean.getWbPODtls().getString(22).split("\\-")[6]+ "</font></td>");
						htmlStr.append("</tr>");
						
					    htmlStr.append("</table>");
					
					
					htmlStr.append("</td>");
					
					htmlStr.append("<td width ='50%'>");
					
					    /* BLOCK - II  */
						htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='3'><strong><br><u>Authorized Distributor,</u></strong></font></td>");
						htmlStr.append("</tr>");						
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> ________________________________</font></td>");
						htmlStr.append("</tr>");
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong>________________________________</font></td>");
						htmlStr.append("</tr>");
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong>________________________________</font></td>");
						htmlStr.append("</tr>");
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> Mob - ________________________________</font></td>");
						htmlStr.append("</tr>");
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> E-Mail - ________________________________</font></td>");
						htmlStr.append("</tr>");
						
					    htmlStr.append("</table>"); 
					
					
					htmlStr.append("</td>");
					htmlStr.append("</tr>");
					htmlStr.append("</table>");
				   
				    htmlStr.append("</td></tr>");
				}
				l++;
			}
		}
		else
		{
				htmlStr.append("<tr><td align='left'>");
				htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='3'><strong>Vendor:</strong> - </font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='2'><strong>Address:</strong> - </font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='2'><strong>City:</strong> - </font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='2'><strong>Pin:</strong> - </font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='2'><strong>Phone:</strong> - <span style='padding-left:3em'><strong>Fax:</strong></span> - <span style='padding-left:3em'><strong>Email:</strong></span> - </font></td>");
				htmlStr.append("</tr>");				
				htmlStr.append("</table>");
				htmlStr.append("</td></tr>");
		}
				
		
		/**************************************** Supplier Details END**********************************************/
		
		/**************************************** Items Details     **********************************************/
		
		formBean.getWbPODtls().beforeFirst();
		
		double totalCost = 0.00;

		DecimalFormat myFormatter = new DecimalFormat("0.0000");
		int i = 1;
		try 
		{
			NumberFormat formatter = new DecimalFormat("############.##");				
		
			htmlStr.append("<tr><td align='left'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
			htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'><br><strong><u>Subject : Supply of Laboratory on Rate Contract Basis</u></strong> </font></td></tr>");
			htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'><br><strong>Ref :</strong> </font><br></td></tr>");
			htmlStr.append("</table>");
			htmlStr.append("</td></tr>");
			
			htmlStr.append("<tr><td align='left'>");
			htmlStr.append("<table width='100%' border='1' cellpadding='1px' cellspacing='0px'>");
			//htmlStr.append("<tr><td COLSPAN='9' align='center'><font face='Arial, Helvetica, sans-serif' size='4'><strong>"+"CONSIGNEE : </strong></font></td></tr>");
			htmlStr.append("<tr>");
			htmlStr.append("<td width='5%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>S.No.</strong></font></td>");
			htmlStr.append("<td width='5%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Item Code</strong></font></td>");
			htmlStr.append("<td width='20%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Item Name</strong></font></td>");
			htmlStr.append("<td width='6%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Pack Size</strong></font></td>");
			htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Rate</strong></font></td>");
			htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Req Qty(No.)</strong></font></td>");
			htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Amount</strong></font></td>");			
			htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>GST(%)</strong></font></td>");	
			htmlStr.append("<td width='12%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>GST Amount</strong></font></td>");				
			htmlStr.append("<td width='12%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Total including<br>GST in Rs</strong></font></td>");
			
			
			htmlStr.append("</tr>");				
			
			if (formBean.getWbPODtls() != null && formBean.getWbPODtls().size() > 0)
			{
				while(formBean.getWbPODtls().next())
				{
					/*
	                1.PO_WTH_DATE
	                2.SUPP_NAME
	                3.PO_TYPE
	                4.CATG
	                5.PO_REMARKS
	                6.PO_ENTER_BY_USER_NAME
	                7.PO_GEN_BY_STORE_NAME
	                8.PURCHASE_SOURCE
	                9.RATE_CONTRACT_ID
	               10.RAT_COTRACT_QTY
	               11.ITEM_NAME
	               12.ITEM_CODE_NO
	               13.RATE_WITHOUT_TAX
	               14.ITEM_ORDER_QTY
	               15.ITEM_COST_WITHOUT_TAX
	               16.RATE_WITH_TAX
	               17.ITEM_COST_WITH_TAX
	               18.ITEM_TAX
	               19.DELIVERY_DATE
	               20.PACK_SIZE
	               21.ENTER_BY_USER_NAME/DATE
	               22.     INITCAP(F.HSTSTR_SUPPLIER_NAME) - 
			       INITCAP(F.hststr_contact_person)  - 
			       INITCAP(F.hststr_address)  - 
			       INITCAP(F.hststr_city_name)  - 
			       INITCAP(F.hststr_pincode)  - 
			       INITCAP(F.hststr_phone1)  - 
			       INITCAP(F.hststr_email1)  -              
			       INITCAP(F.hststr_faxno1)  - 
			       INITCAP(F.hststr_website)  - 
			       INITCAP(F.gnum_countrycode)  - 
			       INITCAP(F.gnum_statecode)
	               23.P_KEY - B.HSTNUM_ITEMBRAND_ID||'^'||B.HSTNUM_SUPPLIER_ID||'^'||A.SSTNUM_POTYPE_ID||'^'||A.SSTNUM_ITEM_CAT_NO||'^'||A.HSTNUM_PO_NO||'^'||A.HSTNUM_STORE_ID
	               24.ITEM_SPECIFICATION 
	              */
					htmlStr.append("<tr>");									
					htmlStr.append("<td width='5%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+i+"</font></td>");  //SNo
					htmlStr.append("<td width='5%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(12)+"</font></td>");  //  Item Code
					htmlStr.append("<td width='20%' align='left'  ><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(11)+"</font></td>");  //  Name
					htmlStr.append("<td width='6%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(20)+"</font></td>");  //  Pack Size
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(13)+"</font></td>");  //  Rate
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(14)+"</font></td>");  //  Qty
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(15)+"</font></td>");  //  Amount Wthout Tax
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(18)+"</font></td>");  //  GST(%)				
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+myFormatter.format((Double.parseDouble(formBean.getWbPODtls().getString(17))-Double.parseDouble(formBean.getWbPODtls().getString(15))))+"</font></td>");
					htmlStr.append("<td width='10%' align='right' ><font face='Arial, Helvetica, sans-serif' size='2'>"+myFormatter.format(Double.parseDouble(formBean.getWbPODtls().getString(17)))+"</font></td>");
					
					totalCost = totalCost + Double.parseDouble(formBean.getWbPODtls().getString(17));
			
			
			
				i++;
				}
				
				formatter.format(new BigDecimal(totalCost));
				String amtStr = "(" + util.toInitCap(util.getAmountStr(myFormatter.format(totalCost))) + ")";
				htmlStr.append("<tr>");
				htmlStr.append("<td colspan='9' align='right'><font face='Arial, Helvetica, sans-serif' size='2'><br>Total Including GST in Rs : <strong>" + amtStr + "<br></strong></font></td>");
				htmlStr.append("<td colspan='1' align='right'><font face='Arial, Helvetica, sans-serif' size='2'><strong>"+ myFormatter.format(totalCost)+"</strong></font></td>");
				htmlStr.append("</tr>");				
				
				htmlStr.append("<tr>");
				htmlStr.append("<td colspan='2'  align='left'><font face='Arial, Helvetica, sans-serif' size='2'><br>Specification If Any<strong><br></strong></font></td>");
				htmlStr.append("<td colspan='8'  align='right'><font face='Arial, Helvetica, sans-serif' size='2'></font></td>");
				htmlStr.append("</tr>");
				
				htmlStr.append("<tr>");
				htmlStr.append("<td colspan='10' align='right'><font face='Arial, Helvetica, sans-serif' size='2'><br><strong>Sr. Procurement cum Store Officer</strong> </font></td>");
				htmlStr.append("</tr>");
				
				htmlStr.append("</table>");
				
				
			}
			else
			{
				
			}
			
			htmlStr.append("</td></tr>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	
		/**************************************** Items Details   END  **********************************************/
		
		/**************************************** PO COMPONENET  **********************************************/
		try 
		{
			
			
			int k =0;
			
			htmlStr.append("<tr><td align='left'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
			htmlStr.append("<tr><td align='right' colspan='2'></td></tr>");
			htmlStr.append("<tr><td align='left'  colspan='2'><font face='Arial, Helvetica, sans-serif' size='3'><u><b>TERMS AND CONDITIONS:</b></u></font></td></tr><br>");
			
			
			htmlStr.append("<tr><td align='justify' colspan='3'>");
			
			if (formBean.getWbPOComponentDtls() != null && formBean.getWbPOComponentDtls().size() > 0)
			{
				
					
					htmlStr.append("<table border='1px solid black' width='100%' cellpadding='0px' cellspacing='0px'>");	
					while(formBean.getWbPOComponentDtls().next())
					{
						htmlStr.append("<tr>");
						htmlStr.append("<td width='5%'  style='text-align:center'>"+(k+1)+"</td>");														
						htmlStr.append("<td width='15%' style='text-align:left;color:black;padding-left:1%;padding-top: 1%;padding-bottom: 1%;line-height: 132%;'>"+formBean.getWbPOComponentDtls().getString(2)+"</td>"); 	
						htmlStr.append("<td width='80%' style='text-align:left;color:black;padding-left:1%;padding-top: 1%;padding-bottom: 1%;line-height: 132%;'>"+formBean.getWbPOComponentDtls().getString(3)+"</td>");					
						htmlStr.append("</tr>");	
						k++;
					}
					htmlStr.append("</table>");		
								
					//htmlStr.append("<tr><td align='justify' colspan='3'><font face='Arial, Helvetica, sans-serif' size='2'><strong>"+(k+1)+". "+formBean.getWbPOComponentDtls().getString(2)+"</strong>" + " : " +  formBean.getWbPOComponentDtls().getString(3)+"</font></td></tr>");
						
				
			}			
			htmlStr.append("</td></tr>");			
			/**************************************** PO COMPONENET  END **********************************************/
			
			htmlStr.append("<tr><td width='100%' align='left'><br><font face='Arial, Helvetica, sans-serif' size='2'><b>NOTE : </b>All typographical error in this Purchase order will be corrected and shall accepted by the firm</font></td></tr>");				
			htmlStr.append("<tr><td align='right' colspan='3'></td></tr>");
			htmlStr.append("<tr><td width='100%' align='left'><br><font face='Arial, Helvetica, sans-serif' size='2'><b>Thanking You</font></td></tr>");				
			htmlStr.append("<tr><td align='right' colspan='3'><br></td></tr>");
			
			htmlStr.append("<tr>");
			htmlStr.append("<td colspan='3'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Yours Sincerely</strong></font></td>");
			htmlStr.append("</tr>");
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>____________________</strong></font></td>");
			htmlStr.append("</tr>");			
			htmlStr.append("</table>");
			htmlStr.append("</td>");
			htmlStr.append("</tr>");
			
			htmlStr.append("<tr>");
			htmlStr.append("<td colspan='3'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
			htmlStr.append("<tr>");
			if(formBean.getStrHospitalCode().equals("99912"))
			{	
			htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Administrative Officer</strong></font></td>");
			}
			else
			{
			htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Sr. Administrative Officer</strong></font></td>");	
			}
			htmlStr.append("</tr>");
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Phone : ____________________</strong></font></td>");
			htmlStr.append("</tr>");			
			htmlStr.append("</table>");
			htmlStr.append("</td>");
			htmlStr.append("</tr>");
							
						
			htmlStr.append("<tr>");
			htmlStr.append("<td colspan='3'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong><br>(Signature of Authorized Signatory)</strong></font></td>");
			htmlStr.append("</tr>");
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong><br>Seal and Stamp</strong></font></td>");
			htmlStr.append("</tr>");			
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%' align='left'><b>Copy To :-<b></td>");
			htmlStr.append("<td width='40%' ></td>");
			htmlStr.append("<td width='30%' align='center'></td>");
			htmlStr.append("</tr>");
			
			k=0;
			
			/****************************************  PO COPY TO  START  **********************************************/
		
			htmlStr.append("<tr><td align='justify' colspan='3'>");
			
			if (formBean.getWbCopyToDtlsDtls() != null && formBean.getWbCopyToDtlsDtls().size() > 0)
			{
				
					
					htmlStr.append("<table border='0' cellpadding='0px' width='100%' cellspacing='0px'>");	
					while(formBean.getWbCopyToDtlsDtls().next())
					{
						htmlStr.append("<tr>");
						htmlStr.append("<td width='5%'  style='text-align:center'>"+(k+1)+"</td>");														
						htmlStr.append("<td width='45%' style='text-align:left;color:black;padding-left:1%;'>"+formBean.getWbCopyToDtlsDtls().getString(1)+"</td>"); 	
						htmlStr.append("<td width='45%' style='text-align:right;color:black;padding-left:1%;'> - "+formBean.getWbCopyToDtlsDtls().getString(2)+"</td>");					
						htmlStr.append("</tr>");	
						k++;
					}
					htmlStr.append("</table>");			
					
				
			}
			
			htmlStr.append("</td></tr>");
			
			
			/****************************************  PO COPY TO  END   **********************************************/
										
			htmlStr.append("</table></td></tr>");		
			
			
/*************************************** SPECIFICATION OF ITEM START  **********************************************/	
			/*
			
			htmlStr.append("<tr>");					
			htmlStr.append("<td width='100%'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");	
			htmlStr.append("<tr>");				
			htmlStr.append("<td colspan='3' align='center'><font face='Arial, Helvetica, sans-serif' size='3'><br><b><u>SPECIFICATION OF ITEM<u><b></font></td>");			
			htmlStr.append("</tr>");			                       
														
			formBean.getWbPODtls().beforeFirst();
			
				
			htmlStr.append("<tr>");
			htmlStr.append("<td width='20%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>ITEM CODE</strong></font></td>");
			htmlStr.append("<td width='40%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>DESCRIPTION</strong></font></td>");
			htmlStr.append("<td width='40%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>SPECIFICATION</strong></font></td>");
			htmlStr.append("</tr>");			
			
			if (formBean.getWbPODtls() != null && formBean.getWbPODtls().size() > 0)
			{
				while(formBean.getWbPODtls().next())
				{
					
	                1.PO_WTH_DATE
	                2.SUPP_NAME
	                3.PO_TYPE
	                4.CATG
	                5.PO_REMARKS
	                6.PO_ENTER_BY_USER_NAME
	                7.PO_GEN_BY_STORE_NAME
	                8.PURCHASE_SOURCE
	                9.RATE_CONTRACT_ID
	               10.RAT_COTRACT_QTY
	               11.ITEM_NAME
	               12.ITEM_CODE_NO
	               13.RATE_WITHOUT_TAX
	               14.ITEM_ORDER_QTY
	               15.ITEM_COST_WITHOUT_TAX
	               16.RATE_WITH_TAX
	               17.ITEM_COST_WITH_TAX
	               18.ITEM_TAX
	               19.DELIVERY_DATE
	               20.PACK_SIZE
	               21.ENTER_BY_USER_NAME/DATE
	               22.     INITCAP(F.HSTSTR_SUPPLIER_NAME) - 
			       INITCAP(F.hststr_contact_person)  - 
			       INITCAP(F.hststr_address)  - 
			       INITCAP(F.hststr_city_name)  - 
			       INITCAP(F.hststr_pincode)  - 
			       INITCAP(F.hststr_phone1)  - 
			       INITCAP(F.hststr_email1)  -              
			       INITCAP(F.hststr_faxno1)  - 
			       INITCAP(F.hststr_website)  - 
			       INITCAP(F.gnum_countrycode)  - 
			       INITCAP(F.gnum_statecode)
	               23.P_KEY - B.HSTNUM_ITEMBRAND_ID||'^'||B.HSTNUM_SUPPLIER_ID||'^'||A.SSTNUM_POTYPE_ID||'^'||A.SSTNUM_ITEM_CAT_NO||'^'||A.HSTNUM_PO_NO||'^'||A.HSTNUM_STORE_ID
	               24.ITEM_SPECIFICATION 
	             
					htmlStr.append("<tr>");									
					htmlStr.append("<td width='20%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(12)+"</font></td>");  //  Item Code
					htmlStr.append("<td width='40%'  align='left'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(11)+"</font></td>");  //  Item Code
					htmlStr.append("<td width='40%'  align='left'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(24)+"</font></td>");  //  Name
					htmlStr.append("</tr>");	
		
				}
			}		
			htmlStr.append("</table>");
			htmlStr.append("</td></tr>");
			*/
			
			
			/*************************************** SPECIFICATION OF ITEM END  **********************************************/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**************************************************************************************/
		
		
		htmlStr.append("</table>");
		
		 if(isDraftFlag.equals("0"))
		   {
			 htmlStr.append("</div>");
		   }
		
		htmlStr.append("</div>");
			 
		htmlStr.append("</body>");
		
		htmlStr.append("</html>");

	
	
	return htmlStr.toString();
   }
	
	
	public String get_BHUV_Local_PoHlp(PODeskPrintTransFB formBean, HttpServletRequest request) throws SQLException
	{
	    String isDraftFlag = "";
	    HisUtil util = new HisUtil("", "");
	    String strComments 		= "-";
		String strAddNotes 		= "-";


		htmlStr = new StringBuffer(4000);

		htmlStr.append("<html>");
		htmlStr.append("<head>");
		// htmlStr.append("<title>PO Report</title>");
		htmlStr.append("</head>");
		
		htmlStr.append("<body>");
		htmlStr.append("<div id='prescriptionTile' style='box-shadow: 0.5px 0.5px 10px 2px #b0acac; border-radius: .35rem;padding:10px;'>");

		
		if(isDraftFlag.equals("0"))
		{
							   
		htmlStr.append("<div id='backgroundprint'>Draft Copy</div>");
		htmlStr.append("<div id='contentprint'>"); 
		}
		htmlStr.append("<div id='saveId' style='display : block'><div align='right' class='hidecontrol' id='printid1'>");
		htmlStr.append("<table width='95%' align='center' >");
		htmlStr.append("<tr> ");
		htmlStr.append("<td align='left'>");
		htmlStr.append("<div id='storeNameBarcode' style='float:left;'></div>");						
		htmlStr.append("</td> ");
					
		htmlStr.append("<td align='right'>");
		htmlStr.append("<img style='cursor: pointer;' title='Print'  src='../../hisglobal/images/printer_symbol.gif' onClick='printDataMain();' /> ");
		htmlStr.append("<img style='cursor: pointer;' title='Cancel'   src='../../hisglobal/images/stop.png' onClick='closePopup();' /> ");
		htmlStr.append("</td> ");
		htmlStr.append("</tr> ");
		htmlStr.append("</table> ");
		htmlStr.append("</div>");
		
		htmlStr.append("</div>");

		/**************************************** Header Details **********************************************/
		
	    htmlStr.append("<table cellpadding='1px' cellspacing='1px' width='95%' align='center'>");
		htmlStr.append("<tr>");					
		htmlStr.append("<td width='100%'>");
		htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");	
		htmlStr.append("<tr>");	
		htmlStr.append("<td align='center'><img src='../../hisglobal/images/aiims_inv_header.png'></td>");					
		htmlStr.append("</tr>");			                       
		htmlStr.append("</table>");
		htmlStr.append("</td>");						
		htmlStr.append("</tr>");		
		htmlStr.append("<tr>");					
		htmlStr.append("<td width='100%'>");
		htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");	
		htmlStr.append("<tr>");	
		if(formBean.getStrPOStatus().equals("1"))
		{
			htmlStr.append("<td align='center'><font face='Arial, Helvetica, sans-serif' size='3'><br><b><u>Draft LPO/NRC Receive Purchase Order<u><b></font></td>");	
		}
		else
		{	
		    htmlStr.append("<td align='center'><font face='Arial, Helvetica, sans-serif' size='3'><br><b><u>LPO/NRC Receive Purchase Order<u><b></font></td>");
		}
		
		
		htmlStr.append("</tr>");			                       
		htmlStr.append("</table>");
		htmlStr.append("</td>");						
		htmlStr.append("</tr>");	
		
		htmlStr.append("<tr>");					
		htmlStr.append("<td width='100%'>");
		htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
		
	   
	    String poNoWithDate = "";
		if (formBean.getWbPODtls() != null && formBean.getWbPODtls().size() > 0)
		{
			if(formBean.getWbPODtls().next())
			{
				poNoWithDate = formBean.getWbPODtls().getString(1);
			}
		}
		formBean.getWbPODtls().beforeFirst();
			
		htmlStr.append("<tr>");
		htmlStr.append("<td align='left' ><font face='Arial, Helvetica, sans-serif' size='2'><strong>File No :________________________________</strong></font></td>");
		htmlStr.append("</tr>");
		
		htmlStr.append("<tr>");
		htmlStr.append("<td align='center' ><font face='Arial, Helvetica, sans-serif' size='2'><strong>PURCHASE ORDER NO / Date  :- "+poNoWithDate+"</strong></font></td>");
		htmlStr.append("</tr>");
		
		htmlStr.append("<tr>");
		htmlStr.append("<td align='right' ><font face='Arial, Helvetica, sans-serif' size='2'><strong><u>GST of AIIMS, BBSR</u></strong>:________________________</font></td>");
		htmlStr.append("</tr>");
		
		htmlStr.append("</table>");
		htmlStr.append("</td>");						
		htmlStr.append("</tr>");	

		/**************************************** Header Details  END **********************************************/
	
		
		/**************************************** Supplier Details **********************************************/
		
		/*  For Draft PO
        ---------------------------
        1.PO_WTH_DATE
        2.SUPP_NAME
        3.PO_TYPE
        4.CATG
        5.PO_REMARKS
        6.PO_ENTER_BY_USER_NAME
        7.PO_GEN_BY_STORE_NAME
        8.PURCHASE_SOURCE
        9.RATE_CONTRACT_ID
       10.RAT_COTRACT_QTY
       11.ITEM_NAME
       12.ITEM_CODE_NO
       13.RATE_WITHOUT_TAX
       14.ITEM_ORDER_QTY
       15.ITEM_COST_WITHOUT_TAX
       16.RATE_WITH_TAX
       17.ITEM_COST_WITH_TAX
       18.ITEM_TAX
       19.DELIVERY_DATE
       20.PACK_SIZE
       21.ENTER_BY_USER_NAME/DATE
       22.     INITCAP(F.HSTSTR_SUPPLIER_NAME) - 
       INITCAP(F.hststr_contact_person)  - 
       INITCAP(F.hststr_address)  - 
       INITCAP(F.hststr_city_name)  - 
       INITCAP(F.hststr_pincode)  - 
       INITCAP(F.hststr_phone1)  - 
       INITCAP(F.hststr_email1)  -              
       INITCAP(F.hststr_faxno1)  - 
       INITCAP(F.hststr_website)  - 
       INITCAP(F.gnum_countrycode)  - 
       INITCAP(F.gnum_statecode)
       23.P_KEY - B.HSTNUM_ITEMBRAND_ID||'^'||B.HSTNUM_SUPPLIER_ID||'^'||A.SSTNUM_POTYPE_ID||'^'||A.SSTNUM_ITEM_CAT_NO||'^'||A.HSTNUM_PO_NO||'^'||A.HSTNUM_STORE_ID
       24.ITEM_SPECIFICATION 
       25.REMARKS
       26.COMMENTS
       27.NOTES
      */
		 int l=0;
		if (formBean.getWbPODtls() != null && formBean.getWbPODtls().size() > 0)
		{
			while(formBean.getWbPODtls().next())
			{	
				if(l==0)
				{	
				    /*
			          -------------------------------------
			         |       B1        |          B2       | 
			         |                 |                   |
			          -------------------------------------
			       */
			
				    htmlStr.append("<tr><td align='left'>");
				    htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
					htmlStr.append("<tr>");
					htmlStr.append("<td width ='50%'>");
					 
				        /* BLOCK - I  */
						htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='3'><strong><br><u>To,</u></strong></font></td>");
						htmlStr.append("</tr>");						
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> " +formBean.getWbPODtls().getString(22).split("\\-")[1] + "</font></td>");
						htmlStr.append("</tr>");
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong>" + formBean.getWbPODtls().getString(22).split("\\-")[0] + "</font></td>");
						htmlStr.append("</tr>");
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> " + formBean.getWbPODtls().getString(22).split("\\-")[2]+" "+formBean.getWbPODtls().getString(22).split("\\-")[3] +" Pin - "+formBean.getWbPODtls().getString(22).split("\\-")[4]+" Phone No - "+formBean.getWbPODtls().getString(22).split("\\-")[5]+ "</font></td>");
						htmlStr.append("</tr>");								
													
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> E-Mail - "+formBean.getWbPODtls().getString(22).split("\\-")[6]+ "</font></td>");
						htmlStr.append("</tr>");
						
					    htmlStr.append("</table>");
					
					
					htmlStr.append("</td>");
					
					htmlStr.append("<td width ='50%'>");
					
					    /* BLOCK - II  */
						htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'></td>");
						htmlStr.append("</tr>");						
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'></td>");
						htmlStr.append("</tr>");
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'></td>");
						htmlStr.append("</tr>");
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'></td>");
						htmlStr.append("</tr>");
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'></td>");
						htmlStr.append("</tr>");
						
						htmlStr.append("<tr>");
						htmlStr.append("<td align='left'></td>");
						htmlStr.append("</tr>");
						
					    htmlStr.append("</table>"); 
					
					
					htmlStr.append("</td>");
					htmlStr.append("</tr>");
					htmlStr.append("</table>");
				   
				    htmlStr.append("</td></tr>");
				}
				l++;
			}
		}
		else
		{
				htmlStr.append("<tr><td align='left'>");
				htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='3'><strong>Vendor:</strong> - </font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='2'><strong>Address:</strong> - </font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='2'><strong>City:</strong> - </font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='2'><strong>Pin:</strong> - </font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='2'><strong>Phone:</strong> - <span style='padding-left:3em'><strong>Fax:</strong></span> - <span style='padding-left:3em'><strong>Email:</strong></span> - </font></td>");
				htmlStr.append("</tr>");				
				htmlStr.append("</table>");
				htmlStr.append("</td></tr>");
		}
				
		
		/**************************************** Supplier Details END**********************************************/
		
		/**************************************** Items Details     **********************************************/
		
		formBean.getWbPODtls().beforeFirst();
		
		double totalCost = 0.00;

		DecimalFormat myFormatter = new DecimalFormat("0.0000");
		int i = 1;
		try 
		{
			NumberFormat formatter = new DecimalFormat("############.##");				
		
			htmlStr.append("<tr><td align='left'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
			htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'><br><strong><u>Subject : Supply of LPO/NRC Receive Purchase Order</u></strong> </font></td></tr>");
			htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'><br><strong>Ref :</strong> </font><br></td></tr>");
			htmlStr.append("</table>");
			htmlStr.append("</td></tr>");
			
			htmlStr.append("<tr><td align='left'>");
			htmlStr.append("<table width='100%' border='1' cellpadding='1px' cellspacing='0px'>");
			//htmlStr.append("<tr><td COLSPAN='9' align='center'><font face='Arial, Helvetica, sans-serif' size='4'><strong>"+"CONSIGNEE : </strong></font></td></tr>");
			htmlStr.append("<tr>");
			htmlStr.append("<td width='5%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>S.No.</strong></font></td>");
			htmlStr.append("<td width='5%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Item Code</strong></font></td>");
			htmlStr.append("<td width='20%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Item Name</strong></font></td>");
			htmlStr.append("<td width='6%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Pack Size</strong></font></td>");
			htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Rate</strong></font></td>");
			htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Req Qty(No.)</strong></font></td>");
			htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Amount</strong></font></td>");			
			htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>GST(%)</strong></font></td>");	
			htmlStr.append("<td width='12%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>GST Amount</strong></font></td>");				
			htmlStr.append("<td width='12%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Total including<br>GST in Rs</strong></font></td>");
			
			
			htmlStr.append("</tr>");				
			
			if (formBean.getWbPODtls() != null && formBean.getWbPODtls().size() > 0)
			{
				while(formBean.getWbPODtls().next())
				{
					/*  For Draft PO
	                ---------------------------
	                1.PO_WTH_DATE
	                2.SUPP_NAME
	                3.PO_TYPE
	                4.CATG
	                5.PO_REMARKS
	                6.PO_ENTER_BY_USER_NAME
	                7.PO_GEN_BY_STORE_NAME
	                8.PURCHASE_SOURCE
	                9.RATE_CONTRACT_ID
	               10.RAT_COTRACT_QTY
	               11.ITEM_NAME
	               12.ITEM_CODE_NO
	               13.RATE_WITHOUT_TAX
	               14.ITEM_ORDER_QTY
	               15.ITEM_COST_WITHOUT_TAX
	               16.RATE_WITH_TAX
	               17.ITEM_COST_WITH_TAX
	               18.ITEM_TAX
	               19.DELIVERY_DATE
	               20.PACK_SIZE
	               21.ENTER_BY_USER_NAME/DATE
	               22.     INITCAP(F.HSTSTR_SUPPLIER_NAME) - 
			       INITCAP(F.hststr_contact_person)  - 
			       INITCAP(F.hststr_address)  - 
			       INITCAP(F.hststr_city_name)  - 
			       INITCAP(F.hststr_pincode)  - 
			       INITCAP(F.hststr_phone1)  - 
			       INITCAP(F.hststr_email1)  -              
			       INITCAP(F.hststr_faxno1)  - 
			       INITCAP(F.hststr_website)  - 
			       INITCAP(F.gnum_countrycode)  - 
			       INITCAP(F.gnum_statecode)
	               23.P_KEY - B.HSTNUM_ITEMBRAND_ID||'^'||B.HSTNUM_SUPPLIER_ID||'^'||A.SSTNUM_POTYPE_ID||'^'||A.SSTNUM_ITEM_CAT_NO||'^'||A.HSTNUM_PO_NO||'^'||A.HSTNUM_STORE_ID
	               24.ITEM_SPECIFICATION 
	               25.REMARKS
	               26.COMMENTS
	               27.NOTES
	              */
					
					htmlStr.append("<tr>");									
					htmlStr.append("<td width='5%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+i+"</font></td>");  //SNo
					htmlStr.append("<td width='5%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(12)+"</font></td>");  //  Item Code
					htmlStr.append("<td width='20%' align='left'  ><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(11)+"</font></td>");  //  Name
					htmlStr.append("<td width='6%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(20)+"</font></td>");  //  Pack Size
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(13)+"</font></td>");  //  Rate
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(14)+"</font></td>");  //  Qty
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(15)+"</font></td>");  //  Amount Wthout Tax
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(18)+"</font></td>");  //  GST(%)				
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+myFormatter.format((Double.parseDouble(formBean.getWbPODtls().getString(17))-Double.parseDouble(formBean.getWbPODtls().getString(15))))+"</font></td>");
					htmlStr.append("<td width='10%' align='right' ><font face='Arial, Helvetica, sans-serif' size='2'>"+myFormatter.format(Double.parseDouble(formBean.getWbPODtls().getString(17)))+"</font></td>");
					
					totalCost = totalCost + Double.parseDouble(formBean.getWbPODtls().getString(17));
					
					strComments 		= formBean.getWbPODtls().getString(26) == null ? "-" : formBean.getWbPODtls().getString(26);
					strAddNotes 		= formBean.getWbPODtls().getString(27) == null ? "-" : formBean.getWbPODtls().getString(27);

			
			
			
				i++;
				}
				
				formatter.format(new BigDecimal(totalCost));
				String amtStr = "(" + util.toInitCap(util.getAmountStr(myFormatter.format(totalCost))) + ")";
				htmlStr.append("<tr>");
				htmlStr.append("<td colspan='9' align='right'><font face='Arial, Helvetica, sans-serif' size='2'><br>Total Including GST in Rs : <strong>" + amtStr + "<br></strong></font></td>");
				htmlStr.append("<td colspan='1' align='right'><font face='Arial, Helvetica, sans-serif' size='2'><strong>"+ myFormatter.format(totalCost)+"</strong></font></td>");
				htmlStr.append("</tr>");				
				
				htmlStr.append("<tr>");
				htmlStr.append("<td colspan='2'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><br>Notes If Any<strong><br></strong></font></td>");
				htmlStr.append("<td colspan='8'  align='left'><font face='Arial, Helvetica, sans-serif' size='2'>"+strAddNotes+"</font></td>");
				htmlStr.append("</tr>");
				
				if(!strComments.equals("-"))
				{
				htmlStr.append("<tr>");
				htmlStr.append("<td colspan='2'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><br>References and Comments<strong><br></strong></font></td>");
				htmlStr.append("<td colspan='8'  align='left'><font face='Arial, Helvetica, sans-serif' size='2'>"+strComments+"</font></td>");
				htmlStr.append("</tr>");
				}
				
				htmlStr.append("<tr>");
				htmlStr.append("<td colspan='10' align='right'><font face='Arial, Helvetica, sans-serif' size='2'><br><strong>Sr. Procurement cum Store Officer</strong> </font></td>");
				htmlStr.append("</tr>");
				
				htmlStr.append("</table>");
				
				
			}
			else
			{
				
			}
			
			htmlStr.append("</td></tr>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	
		/**************************************** Items Details   END  **********************************************/
		
		/**************************************** PO COMPONENET  **********************************************/
		try 
		{
			
			
			int k =0;
			
			htmlStr.append("<tr><td align='left'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
			htmlStr.append("<tr><td align='right' colspan='2'></td></tr>");
			htmlStr.append("<tr><td align='left'  colspan='2'><font face='Arial, Helvetica, sans-serif' size='3'><u><b>TERMS AND CONDITIONS:</b></u></font></td></tr><br>");
			
			
			htmlStr.append("<tr><td align='justify' colspan='3'>");
			
			if (formBean.getWbPOComponentDtls() != null && formBean.getWbPOComponentDtls().size() > 0)
			{
				
					
					htmlStr.append("<table border='1px solid black' width='100%' cellpadding='0px' cellspacing='0px'>");	
					while(formBean.getWbPOComponentDtls().next())
					{
						htmlStr.append("<tr>");
						htmlStr.append("<td width='5%'  style='text-align:center'>"+(k+1)+"</td>");														
						htmlStr.append("<td width='15%' style='text-align:left;color:black;padding-left:1%;padding-top: 1%;padding-bottom: 1%;line-height: 132%;'>"+formBean.getWbPOComponentDtls().getString(2)+"</td>"); 	
						htmlStr.append("<td width='80%' style='text-align:left;color:black;padding-left:1%;padding-top: 1%;padding-bottom: 1%;line-height: 132%;'>"+formBean.getWbPOComponentDtls().getString(3)+"</td>");					
						htmlStr.append("</tr>");	
						k++;
					}
					htmlStr.append("</table>");		
								
					//htmlStr.append("<tr><td align='justify' colspan='3'><font face='Arial, Helvetica, sans-serif' size='2'><strong>"+(k+1)+". "+formBean.getWbPOComponentDtls().getString(2)+"</strong>" + " : " +  formBean.getWbPOComponentDtls().getString(3)+"</font></td></tr>");
						
				
			}			
			htmlStr.append("</td></tr>");			
			/**************************************** PO COMPONENET  END **********************************************/
			
			htmlStr.append("<tr><td width='100%' align='left'><br><font face='Arial, Helvetica, sans-serif' size='2'><b>NOTE : </b>All typographical error in this Purchase order will be corrected and shall accepted by the firm</font></td></tr>");				
			htmlStr.append("<tr><td align='right' colspan='3'></td></tr>");
			htmlStr.append("<tr><td width='100%' align='left'><br><font face='Arial, Helvetica, sans-serif' size='2'><b>Thanking You</font></td></tr>");				
			htmlStr.append("<tr><td align='right' colspan='3'><br></td></tr>");
			
			htmlStr.append("<tr>");
			htmlStr.append("<td colspan='3'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Yours Sincerely</strong></font></td>");
			htmlStr.append("</tr>");
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>____________________</strong></font></td>");
			htmlStr.append("</tr>");			
			htmlStr.append("</table>");
			htmlStr.append("</td>");
			htmlStr.append("</tr>");
			
			htmlStr.append("<tr>");
			htmlStr.append("<td colspan='3'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Sr. Administrative Officer</strong></font></td>");
			htmlStr.append("</tr>");
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Phone : ____________________</strong></font></td>");
			htmlStr.append("</tr>");			
			htmlStr.append("</table>");
			htmlStr.append("</td>");
			htmlStr.append("</tr>");
							
						
			htmlStr.append("<tr>");
			htmlStr.append("<td colspan='3'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong><br>(Signature of Authorized Signatory)</strong></font></td>");
			htmlStr.append("</tr>");
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong><br>Seal and Stamp</strong></font></td>");
			htmlStr.append("</tr>");			
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%' align='left'><b>Copy To :-<b></td>");
			htmlStr.append("<td width='40%' ></td>");
			htmlStr.append("<td width='30%' align='center'></td>");
			htmlStr.append("</tr>");
			
			k=0;
			
			/****************************************  PO COPY TO  START  **********************************************/
		
			htmlStr.append("<tr><td align='justify' colspan='3'>");
			
			if (formBean.getWbCopyToDtlsDtls() != null && formBean.getWbCopyToDtlsDtls().size() > 0)
			{
				
					
					htmlStr.append("<table border='0' cellpadding='0px' width='100%' cellspacing='0px'>");	
					while(formBean.getWbCopyToDtlsDtls().next())
					{
						htmlStr.append("<tr>");
						htmlStr.append("<td width='5%'  style='text-align:center'>"+(k+1)+"</td>");														
						htmlStr.append("<td width='45%' style='text-align:left;color:black;padding-left:1%;'>"+formBean.getWbCopyToDtlsDtls().getString(1)+"</td>"); 	
						htmlStr.append("<td width='45%' style='text-align:right;color:black;padding-left:1%;'> - "+formBean.getWbCopyToDtlsDtls().getString(2)+"</td>");					
						htmlStr.append("</tr>");	
						k++;
					}
					htmlStr.append("</table>");			
					
				
			}
			
			htmlStr.append("</td></tr>");
			
			
			/****************************************  PO COPY TO  END   **********************************************/
										
			htmlStr.append("</table></td></tr>");		
			
			
            /*************************************** SPECIFICATION OF ITEM START  **********************************************/	
			/*
			
			htmlStr.append("<tr>");					
			htmlStr.append("<td width='100%'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");	
			htmlStr.append("<tr>");				
			htmlStr.append("<td colspan='3' align='center'><font face='Arial, Helvetica, sans-serif' size='3'><br><b><u>SPECIFICATION OF ITEM<u><b></font></td>");			
			htmlStr.append("</tr>");			                       
														
			formBean.getWbPODtls().beforeFirst();
			
				
			htmlStr.append("<tr>");
			htmlStr.append("<td width='20%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>ITEM CODE</strong></font></td>");
			htmlStr.append("<td width='40%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>DESCRIPTION</strong></font></td>");
			htmlStr.append("<td width='40%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>SPECIFICATION</strong></font></td>");
			htmlStr.append("</tr>");			
			
			if (formBean.getWbPODtls() != null && formBean.getWbPODtls().size() > 0)
			{
				while(formBean.getWbPODtls().next())
				{
					
	                1.PO_WTH_DATE
	                2.SUPP_NAME
	                3.PO_TYPE
	                4.CATG
	                5.PO_REMARKS
	                6.PO_ENTER_BY_USER_NAME
	                7.PO_GEN_BY_STORE_NAME
	                8.PURCHASE_SOURCE
	                9.RATE_CONTRACT_ID
	               10.RAT_COTRACT_QTY
	               11.ITEM_NAME
	               12.ITEM_CODE_NO
	               13.RATE_WITHOUT_TAX
	               14.ITEM_ORDER_QTY
	               15.ITEM_COST_WITHOUT_TAX
	               16.RATE_WITH_TAX
	               17.ITEM_COST_WITH_TAX
	               18.ITEM_TAX
	               19.DELIVERY_DATE
	               20.PACK_SIZE
	               21.ENTER_BY_USER_NAME/DATE
	               22.     INITCAP(F.HSTSTR_SUPPLIER_NAME) - 
			       INITCAP(F.hststr_contact_person)  - 
			       INITCAP(F.hststr_address)  - 
			       INITCAP(F.hststr_city_name)  - 
			       INITCAP(F.hststr_pincode)  - 
			       INITCAP(F.hststr_phone1)  - 
			       INITCAP(F.hststr_email1)  -              
			       INITCAP(F.hststr_faxno1)  - 
			       INITCAP(F.hststr_website)  - 
			       INITCAP(F.gnum_countrycode)  - 
			       INITCAP(F.gnum_statecode)
	               23.P_KEY - B.HSTNUM_ITEMBRAND_ID||'^'||B.HSTNUM_SUPPLIER_ID||'^'||A.SSTNUM_POTYPE_ID||'^'||A.SSTNUM_ITEM_CAT_NO||'^'||A.HSTNUM_PO_NO||'^'||A.HSTNUM_STORE_ID
	               24.ITEM_SPECIFICATION 
	             
					htmlStr.append("<tr>");									
					htmlStr.append("<td width='20%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(12)+"</font></td>");  //  Item Code
					htmlStr.append("<td width='40%'  align='left'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(11)+"</font></td>");  //  Item Code
					htmlStr.append("<td width='40%'  align='left'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(24)+"</font></td>");  //  Name
					htmlStr.append("</tr>");	
		
				}
			}		
			htmlStr.append("</table>");
			htmlStr.append("</td></tr>");
			*/
			
			
			/*************************************** SPECIFICATION OF ITEM END  **********************************************/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**************************************************************************************/
		
		
		htmlStr.append("</table>");
		
		 if(isDraftFlag.equals("0"))
		   {
			 htmlStr.append("</div>");
		   }
		
		htmlStr.append("</div>");
			 
		htmlStr.append("</body>");
		
		htmlStr.append("</html>");

	
	
	return htmlStr.toString();
   }


	
	
	public String getPoHlp_otherHosp(PODeskPrintTransFB formBean, HttpServletRequest request) throws SQLException
	{
	    String isDraftFlag = "";
	    HisUtil util = new HisUtil("", "");
	    
	    String strComments 		= "-";
		String strAddNotes 		= "-";


		htmlStr = new StringBuffer(4000);

		htmlStr.append("<html>");
		htmlStr.append("<head>");
		// htmlStr.append("<title>PO Report</title>");
		htmlStr.append("</head>");
		
		htmlStr.append("<body>");
		htmlStr.append("<div id='prescriptionTile' style='box-shadow: 0.5px 0.5px 10px 2px #b0acac; border-radius: .35rem;margin: 20px;padding:25px;'>");

		
		if(isDraftFlag.equals("0"))
		{
							   
		htmlStr.append("<div id='backgroundprint'>Draft Copy</div>");
		htmlStr.append("<div id='contentprint'>"); 
		}
		htmlStr.append("<div id='saveId' style='display : block'><div align='right' class='hidecontrol' id='printid1'>");
		htmlStr.append("<table width='95%' align='center'>");
		htmlStr.append("<tr> ");
		htmlStr.append("<td align='left'>");
		htmlStr.append("<div id='storeNameBarcode' style='float:left;'></div>");						
		htmlStr.append("</td> ");
					
		htmlStr.append("<td align='right'>");
		htmlStr.append("<img style='cursor: pointer;' title='Print'  src='../../hisglobal/images/printer_symbol.gif' onClick='printDataMain();' /> ");
		htmlStr.append("<img style='cursor: pointer;' title='Cancel'   src='../../hisglobal/images/stop.png' onClick='closePopup();' /> ");
		htmlStr.append("</td> ");
		htmlStr.append("</tr> ");
		htmlStr.append("</table> ");
		htmlStr.append("</div>");
		
		htmlStr.append("</div>");

		/**************************************** Header Details **********************************************/
		
		    htmlStr.append("<table cellpadding='1px' cellspacing='1px' width='95%' align='center'>");
			htmlStr.append("<tr>");					
			htmlStr.append("<td width='100%'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");	
			htmlStr.append("<tr>");	
			htmlStr.append("<td align='center'><img src='../../hisglobal/images/aiims_inv_header.png'></td>");					
			htmlStr.append("</tr>");			                       
			htmlStr.append("</table>");
			htmlStr.append("</td>");						
			htmlStr.append("</tr>");		
			htmlStr.append("<tr>");					
			htmlStr.append("<td width='100%'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");	
			htmlStr.append("<tr>");	
			
			if(formBean.getStrPOStatus().equals("1"))
			{
				htmlStr.append("<td align='center'><font face='Arial, Helvetica, sans-serif' size='3'><br><b><u>Draft Purchase Order<u><b></font></td>");
			}
			else
			{	
				htmlStr.append("<td align='center'><font face='Arial, Helvetica, sans-serif' size='3'><br><b><u>Purchase Order<u><b></font></td>");
			}
			
			
			
			htmlStr.append("</tr>");			                       
			htmlStr.append("</table>");
			htmlStr.append("</td>");						
			htmlStr.append("</tr>");	
			
			htmlStr.append("</table>");				
			
			
		   
		    String poNoWithDate = "";
			if (formBean.getWbPODtls() != null && formBean.getWbPODtls().size() > 0)
			{
				if(formBean.getWbPODtls().next())
				{
					poNoWithDate = formBean.getWbPODtls().getString(1);
				}
			}
			formBean.getWbPODtls().beforeFirst();
			if(formBean.getStrHospitalCode().equals("21917"))
			{	
				htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
				htmlStr.append("<tr>");
				htmlStr.append("<td align='left' ><font face='Arial, Helvetica, sans-serif' size='2'>File No :________________________________</font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("</table>");			
				
				htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
				htmlStr.append("<br><tr>");
				htmlStr.append("<td align='center' ><font face='Arial, Helvetica, sans-serif' size='2'><strong>PURCHASE ORDER NO / Date  :- "+poNoWithDate+"</strong></font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("</table>");			
				
				htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
				htmlStr.append("<br><tr>");
				htmlStr.append("<td align='right' ><font face='Arial, Helvetica, sans-serif' size='2'><strong><u>GST of AIIMS, BBSR: 21AAAGA0127K1Z5</u></strong></font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("</table>");			
			}
			else
			{
				htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
				htmlStr.append("<br><tr>");
				htmlStr.append("<td align='left' ><font face='Arial, Helvetica, sans-serif' size='2'><strong>Reference No / Date  :- "+poNoWithDate+"</strong></font></td>");
				htmlStr.append("</tr>");	
				htmlStr.append("</table>");			
			}			
		/***************************************** Headers Details END ********************************************/		
		/**************************************** Supplier Details ************************************************/
		
			 /*
            1.PO_WTH_DATE
            2.SUPP_NAME
            3.PO_TYPE
            4.CATG
            5.PO_REMARKS
            6.PO_ENTER_BY_USER_NAME
            7.PO_GEN_BY_STORE_NAME
            8.PURCHASE_SOURCE
            9.RATE_CONTRACT_ID
           10.RAT_COTRACT_QTY
           11.ITEM_NAME
           12.ITEM_CODE_NO
           13.RATE_WITHOUT_TAX
           14.ITEM_ORDER_QTY
           15.ITEM_COST_WITHOUT_TAX
           16.RATE_WITH_TAX
           17.ITEM_COST_WITH_TAX
           18.ITEM_TAX
           19.DELIVERY_DATE
           20.PACK_SIZE
           21.ENTER_BY_USER_NAME/DATE
           22.     INITCAP(F.HSTSTR_SUPPLIER_NAME) - 
	       INITCAP(F.hststr_contact_person)  - 
	       INITCAP(F.hststr_address)  - 
	       INITCAP(F.hststr_city_name)  - 
	       INITCAP(F.hststr_pincode)  - 
	       INITCAP(F.hststr_phone1)  - 
	       INITCAP(F.hststr_email1)  -              
	       INITCAP(F.hststr_faxno1)  - 
	       INITCAP(F.hststr_website)  - 
	       INITCAP(F.gnum_countrycode)  - 
	       INITCAP(F.gnum_statecode)
           23.P_KEY - B.HSTNUM_ITEMBRAND_ID||'^'||B.HSTNUM_SUPPLIER_ID||'^'||A.SSTNUM_POTYPE_ID||'^'||A.SSTNUM_ITEM_CAT_NO||'^'||A.HSTNUM_PO_NO||'^'||A.HSTNUM_STORE_ID
           24.ITEM_SPECIFICATION 
           25.REMARKS
           26.COMMENTS
           27.NOTES
          */
		 int l=0;
		if (formBean.getWbPODtls() != null && formBean.getWbPODtls().size() > 0)
		{
			while(formBean.getWbPODtls().next())
			{	
				if(l==0)
				{	
					if(formBean.getStrHospitalCode().equals("21917"))
					{	
						    /*
						          -------------------------------------
						         |       B1        |          B2       | 
						         |                 |                   |
						          -------------------------------------
						     */
						
						    htmlStr.append("<tr><td align='left'>");
						    htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
							htmlStr.append("<tr>");
							htmlStr.append("<td width ='50%'>");
							 
						        /* BLOCK - I  */
								htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
								htmlStr.append("<tr>");
								htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='3'><strong><br><u>To,</u></strong></font></td>");
								htmlStr.append("</tr>");						
								
								htmlStr.append("<tr>");
								htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> " +formBean.getWbPODtls().getString(22).split("\\-")[1] + "</font></td>");
								htmlStr.append("</tr>");
								
								htmlStr.append("<tr>");
								htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong>" + formBean.getWbPODtls().getString(22).split("\\-")[0] + "</font></td>");
								htmlStr.append("</tr>");
								
								htmlStr.append("<tr>");
								htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> " + formBean.getWbPODtls().getString(22).split("\\-")[2]+" "+formBean.getWbPODtls().getString(22).split("\\-")[3] +" Pin - "+formBean.getWbPODtls().getString(22).split("\\-")[4]+" Phone No - "+formBean.getWbPODtls().getString(22).split("\\-")[5]+ "</font></td>");
								htmlStr.append("</tr>");								
															
								htmlStr.append("<tr>");
								htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> E-Mail - "+formBean.getWbPODtls().getString(22).split("\\-")[6]+ "</font></td>");
								htmlStr.append("</tr>");
								
							    htmlStr.append("</table>");
							
							
							htmlStr.append("</td>");
							
							htmlStr.append("<td width ='50%'>");
							
							    /* BLOCK - II  */
								htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
								htmlStr.append("<tr>");
								htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='3'><strong><br><u>Authorized Distributor,</u></strong></font></td>");
								htmlStr.append("</tr>");						
								
								htmlStr.append("<tr>");
								htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> ________________________________</font></td>");
								htmlStr.append("</tr>");
								
								htmlStr.append("<tr>");
								htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong>________________________________</font></td>");
								htmlStr.append("</tr>");
								
								htmlStr.append("<tr>");
								htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong>________________________________</font></td>");
								htmlStr.append("</tr>");
								
								htmlStr.append("<tr>");
								htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> Mob - ________________________________</font></td>");
								htmlStr.append("</tr>");
								
								htmlStr.append("<tr>");
								htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> E-Mail - ________________________________</font></td>");
								htmlStr.append("</tr>");
								
							    htmlStr.append("</table>"); 
							
							
							htmlStr.append("</td>");
							htmlStr.append("</tr>");
							htmlStr.append("</table>");
						   
						    htmlStr.append("</td></tr>");
				   }
				   else
				   {
						    htmlStr.append("<tr><td align='left'>");
							htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
							htmlStr.append("<tr>");
							htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='3'><strong><br>To,</strong></font></td>");
							htmlStr.append("</tr>");						
							
							htmlStr.append("<tr>");
							htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> " +formBean.getWbPODtls().getString(22).split("\\-")[1] + "</font></td>");
							htmlStr.append("</tr>");
							
							htmlStr.append("<tr>");
							htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong>" + formBean.getWbPODtls().getString(22).split("\\-")[0] + "</font></td>");
							htmlStr.append("</tr>");
							
							htmlStr.append("<tr>");
							htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> " + formBean.getWbPODtls().getString(22).split("\\-")[2]+" "+formBean.getWbPODtls().getString(22).split("\\-")[3] +" Pin - "+formBean.getWbPODtls().getString(22).split("\\-")[4]+" Phone No - "+formBean.getWbPODtls().getString(22).split("\\-")[5]+ "</font></td>");
							htmlStr.append("</tr>");
							
							htmlStr.append("<tr>");
							htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong></strong> E-Mail - "+formBean.getWbPODtls().getString(22).split("\\-")[6]+ "</font></td>");
							htmlStr.append("</tr>");
							/*
							[ 0	]INITCAP(F.HSTSTR_SUPPLIER_NAME) - 
						       [ 1	]INITCAP(F.hststr_contact_person)  - 
						       [ 2	]INITCAP(F.hststr_address)  - 
						       [ 3	]INITCAP(F.hststr_city_name)  - 
						       [ 4	]INITCAP(F.hststr_pincode)  - 
						       [ 5	]INITCAP(F.hststr_phone1)  - 
						       [ 6	]INITCAP(F.hststr_email1)  -              
						       [ 7	]INITCAP(F.hststr_faxno1)  - 
						       [ 8	]INITCAP(F.hststr_website)  - 
						       [ 9	]INITCAP(F.gnum_countrycode)  - 
						       [10	]INITCAP(F.gnum_statecode)
							
							htmlStr.append("<tr>");
							htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='4'><strong></strong> " + formBean.getWbPODtls().getString(22).split("\\-")[5] + "</font></td>");
							htmlStr.append("</tr>");
							
							htmlStr.append("<tr>");
							htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='4'><strong></strong> " + formBean.getWbPODtls().getString(22).split("\\-")[7] + "</font></td>");
							htmlStr.append("</tr>");
							
							htmlStr.append("<tr>");
							htmlStr.append("<td align='left'><font face='Arial, Helvetica, sans-serif' size='4'><strong></strong> " + formBean.getWbPODtls().getString(22).split("\\-")[6] + "</font></td>");
							htmlStr.append("</tr>");			
							*/	
							
						  htmlStr.append("</table>");
						  htmlStr.append("</td></tr>");
					   
				   }
				}
				l++;
			}
		}
		else
		{
				htmlStr.append("<tr><td align='left'>");
				htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='3'><strong>Vendor:</strong> - </font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='2'><strong>Address:</strong> - </font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='2'><strong>City:</strong> - </font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='2'><strong>Pin:</strong> - </font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("<tr>");
				htmlStr.append("<td><font face='Arial, Helvetica, sans-serif' size='2'><strong>Phone:</strong> - <span style='padding-left:3em'><strong>Fax:</strong></span> - <span style='padding-left:3em'><strong>Email:</strong></span> - </font></td>");
				htmlStr.append("</tr>");				
				htmlStr.append("</table>");
				htmlStr.append("</td></tr>");
		}
				
		
		/*************************************** Supplier Details END  **********************************************/
		
		/*************************************** ITEM Details **********************************************/
		formBean.getWbPODtls().beforeFirst();
		
		double totalCost = 0.00;

		DecimalFormat myFormatter = new DecimalFormat("0.00");
		int i = 1;
		try 
		{
			NumberFormat formatter = new DecimalFormat("############.##");				
		
			htmlStr.append("<tr><td align='left'>");
			if(formBean.getStrHospitalCode().equals("21917"))
			{	
				htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
				htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'><br><strong><u>Subject</u> : Supply of ________________________________</strong> </font></td></tr>");
				htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'><br><strong>Ref :(i)	Our Tender document of NIT No.- ________________________________</strong> </font></td></tr>");
				htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong>     (ii) 	All Corrigenda and Notices issued against the subject Tender thereunto.</strong> </font></td></tr>");
				htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong>     (iii)	Your Technical Bid documents</strong> </font></td></tr>");
				htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong>     (iv)  Your Price bid submitted</strong> </font></td></tr>");
				htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'><strong>     (v)   Enclosed Specification as per Tender and accepted Sample</strong> </font></td></tr>");
				htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'><br>Sir , </font></td></tr>");	
				htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'><br>        You are requested to supply the subject item(s) as per the details Specifications, rates with the terms and conditions mentioned below</font></td></tr>");
				htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'>            mentioned below</font></td></tr>");	
				htmlStr.append("</table>");
			}
			else
			{
				htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
				htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'><br><strong><u>Subject</u> : Supply of ________________________________</strong> </font></td></tr>");
				htmlStr.append("<tr><td width='100%' align='left'><font face='Arial, Helvetica, sans-serif' size='2'><br><strong>Ref : ________________________________</strong> </font><br></td></tr>");			
				htmlStr.append("</table>");				
			}
			htmlStr.append("</td></tr>");
			
			htmlStr.append("<tr><td align='left'>");
			htmlStr.append("<table width='100%' border='1' cellpadding='1px' cellspacing='0px'>");
			//htmlStr.append("<tr><td COLSPAN='9' align='center'><font face='Arial, Helvetica, sans-serif' size='4'><strong>"+"CONSIGNEE : </strong></font></td></tr>");
				
			htmlStr.append("<tr>");
			htmlStr.append("<td width='5%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>S.No.</strong></font></td>");
			htmlStr.append("<td width='5%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Item Code</strong></font></td>");
			htmlStr.append("<td width='20%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Item Name</strong></font></td>");
			htmlStr.append("<td width='6%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Pack Size</strong></font></td>");
			htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Rate</strong></font></td>");
			htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Req Qty(No.)</strong></font></td>");
			htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Amount</strong></font></td>");			
			htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>GST(%)</strong></font></td>");	
			htmlStr.append("<td width='12%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>GST Amount</strong></font></td>");				
			htmlStr.append("<td width='12%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Total including<br>GST in Rs</strong></font></td>");
			htmlStr.append("</tr>");			
			
			if (formBean.getWbPODtls() != null && formBean.getWbPODtls().size() > 0)
			{
				while(formBean.getWbPODtls().next())
				{
					 /*
		            1.PO_WTH_DATE
		            2.SUPP_NAME
		            3.PO_TYPE
		            4.CATG
		            5.PO_REMARKS
		            6.PO_ENTER_BY_USER_NAME
		            7.PO_GEN_BY_STORE_NAME
		            8.PURCHASE_SOURCE
		            9.RATE_CONTRACT_ID
		           10.RAT_COTRACT_QTY
		           11.ITEM_NAME
		           12.ITEM_CODE_NO
		           13.RATE_WITHOUT_TAX
		           14.ITEM_ORDER_QTY
		           15.ITEM_COST_WITHOUT_TAX
		           16.RATE_WITH_TAX
		           17.ITEM_COST_WITH_TAX
		           18.ITEM_TAX
		           19.DELIVERY_DATE
		           20.PACK_SIZE
		           21.ENTER_BY_USER_NAME/DATE
		           22.     INITCAP(F.HSTSTR_SUPPLIER_NAME) - 
			       INITCAP(F.hststr_contact_person)  - 
			       INITCAP(F.hststr_address)  - 
			       INITCAP(F.hststr_city_name)  - 
			       INITCAP(F.hststr_pincode)  - 
			       INITCAP(F.hststr_phone1)  - 
			       INITCAP(F.hststr_email1)  -              
			       INITCAP(F.hststr_faxno1)  - 
			       INITCAP(F.hststr_website)  - 
			       INITCAP(F.gnum_countrycode)  - 
			       INITCAP(F.gnum_statecode)
		           23.P_KEY - B.HSTNUM_ITEMBRAND_ID||'^'||B.HSTNUM_SUPPLIER_ID||'^'||A.SSTNUM_POTYPE_ID||'^'||A.SSTNUM_ITEM_CAT_NO||'^'||A.HSTNUM_PO_NO||'^'||A.HSTNUM_STORE_ID
		           24.ITEM_SPECIFICATION 
		           25.REMARKS
		           26.COMMENTS
		           27.NOTES
		          */
					
					htmlStr.append("<tr>");									
					htmlStr.append("<td width='5%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+i+"</font></td>");  //SNo
					htmlStr.append("<td width='5%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(12)+"</font></td>");  //  Item Code
					htmlStr.append("<td width='20%' align='left'  ><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(11)+"</font></td>");  //  Name
					htmlStr.append("<td width='6%'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(20)+"</font></td>");  //  Pack Size
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(13)+"</font></td>");  //  Rate
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(14)+"</font></td>");  //  Qty
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(15)+"</font></td>");  //  Amount Wthout Tax
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+formBean.getWbPODtls().getString(18)+"</font></td>");  //  GST(%)				
					htmlStr.append("<td width='10%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'>"+myFormatter.format((Double.parseDouble(formBean.getWbPODtls().getString(17))-Double.parseDouble(formBean.getWbPODtls().getString(15))))+"</font></td>");
					htmlStr.append("<td width='10%' align='right' ><font face='Arial, Helvetica, sans-serif' size='2'>"+myFormatter.format(Double.parseDouble(formBean.getWbPODtls().getString(17)))+"</font></td>");
					
					totalCost = totalCost + Double.parseDouble(formBean.getWbPODtls().getString(17));
			
					strComments 		= formBean.getWbPODtls().getString(26) == null ? "-" : formBean.getWbPODtls().getString(26);
					strAddNotes 		= formBean.getWbPODtls().getString(27) == null ? "-" : formBean.getWbPODtls().getString(27);
			
			
				i++;
				}
				
				formatter.format(new BigDecimal(totalCost));
				String amtStr = "(" + util.toInitCap(util.getAmountStr(myFormatter.format(totalCost))) + ")";
				htmlStr.append("<tr>");
				htmlStr.append("<td colspan='9' align='right'><font face='Arial, Helvetica, sans-serif' size='2'><br>Total Including GST in Rs : <strong>" + amtStr + "<br></strong></font></td>");
				htmlStr.append("<td colspan='1' align='right'><font face='Arial, Helvetica, sans-serif' size='2'><strong>"+ myFormatter.format(totalCost)+"</strong></font></td>");
				htmlStr.append("</tr>");		
				
				
				
				htmlStr.append("<tr>");
				htmlStr.append("<td colspan='2'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><br>Notes If Any<strong><br></strong></font></td>");
				htmlStr.append("<td colspan='8'  align='left'><font face='Arial, Helvetica, sans-serif' size='2'>"+strAddNotes+"</font></td>");
				htmlStr.append("</tr>");
				
				if(!strComments.equals("-"))
				{
				htmlStr.append("<tr>");
				htmlStr.append("<td colspan='2'  align='center'><font face='Arial, Helvetica, sans-serif' size='2'><br>References and Comments<strong><br></strong></font></td>");
				htmlStr.append("<td colspan='8'  align='left'><font face='Arial, Helvetica, sans-serif' size='2'>"+strComments+"</font></td>");
				htmlStr.append("</tr>");
				}
				
				
				htmlStr.append("<tr>");
				htmlStr.append("<td colspan='10' align='right'><font face='Arial, Helvetica, sans-serif' size='2'><br><strong>Sr. Procurement cum Store Officer</strong> </font></td>");
				htmlStr.append("</tr>");
				
				htmlStr.append("</table>");
				htmlStr.append("</td></tr>");
				
			}
			else
			{
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*************************************** ITEM Details END  **********************************************/
		
	
		/*************************************** PO Component START  **********************************************/
		
		try 
		{
			
			
			int k =0;
			
			htmlStr.append("<tr><td align='left'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='1px'>");
			htmlStr.append("<tr><td align='right' colspan='3'></td></tr>");
			htmlStr.append("<tr><td align='left'  colspan='3'><font face='Arial, Helvetica, sans-serif' size='3'><u><b>TERMS AND CONDITIONS:</b></u></font></td></tr><br>");
			
			
			htmlStr.append("<tr><td align='justify' colspan='3'>");
			
			if (formBean.getWbPOComponentDtls() != null && formBean.getWbPOComponentDtls().size() > 0)
			{
				
					
					htmlStr.append("<table border='1px solid black' width='100%' cellpadding='0px' cellspacing='0px'>");	
					while(formBean.getWbPOComponentDtls().next())
					{
						htmlStr.append("<tr>");
						if(formBean.getStrHospitalCode().equals("21917"))
						{
							htmlStr.append("<td width='5%'  style='text-align:center'><b>( "+formBean.getWbPOComponentDtls().getString(4)+" )</b></td>");
						}	
						else
						{
						    htmlStr.append("<td width='5%'  style='text-align:center'><b>"+(k+1)+"</b></td>");
						}
						htmlStr.append("<td width='15%' style='text-align:left;color:black;padding-left:1%;padding-top: 1%;padding-bottom: 1%;line-height: 132%;'>"+formBean.getWbPOComponentDtls().getString(2)+"</td>"); 	
						htmlStr.append("<td width='80%' style='text-align:left;color:black;padding-left:1%;padding-top: 1%;padding-bottom: 1%;line-height: 132%;'>"+formBean.getWbPOComponentDtls().getString(3)+"</td>");					
						htmlStr.append("</tr>");	
						k++;
					}
					htmlStr.append("</table>");		
				
			}
			
			htmlStr.append("</td></tr>");
			
			/*************************************** PO Component END  **********************************************/
			
			htmlStr.append("<tr><td width='100%' align='left'><br><font face='Arial, Helvetica, sans-serif' size='2'><b>NOTE : </b>All typographical error in this Purchase order will be corrected and shall accepted by the firm</font></td></tr>");				
			htmlStr.append("<tr><td align='right' colspan='3'></td></tr>");
			htmlStr.append("<tr><td width='100%' align='left'><br><font face='Arial, Helvetica, sans-serif' size='2'><b>Thanking You</font></td></tr>");				
			htmlStr.append("<tr><td align='right' colspan='3'><br></td></tr>");
			
			htmlStr.append("<tr>");
			htmlStr.append("<td colspan='3'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Yours Sincerely</strong></font></td>");
			htmlStr.append("</tr>");
			if(formBean.getStrHospitalCode().equals("21917"))
			{
				htmlStr.append("<tr>");
				htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Shri. Kunal Chakraborty,</strong></font></td>");
				htmlStr.append("</tr>");
			}
			else
			{
				htmlStr.append("<tr>");
				htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>____________________________,</strong></font></td>");
				htmlStr.append("</tr>");
			}
			
			htmlStr.append("</table>");
			htmlStr.append("</td>");
			htmlStr.append("</tr>");
			
			htmlStr.append("<tr>");
			htmlStr.append("<td colspan='3'>");
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
			
			
			if(formBean.getStrHospitalCode().equals("21917"))
			{
				htmlStr.append("<tr>");
				htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Sr. Procurement-cum Store Officer(I/c)</strong></font></td>");
				htmlStr.append("</tr>");
			}
			else
			{
				htmlStr.append("<tr>");
				if(formBean.getStrHospitalCode().equals("99912"))
				{	
				htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Administrative Officer</strong></font></td>");
				}
				else
				{
				htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Sr. Administrative Officer</strong></font></td>");	
				}
				
				htmlStr.append("</tr>");
				htmlStr.append("<tr>");
				htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong>Phone : ____________________</strong></font></td>");
				htmlStr.append("</tr>");
			}
						
			htmlStr.append("</table>");
			htmlStr.append("</td>");
			htmlStr.append("</tr>");
							
						
			htmlStr.append("<tr>");
			htmlStr.append("<td colspan='3'>");			
			htmlStr.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'>");
			if(formBean.getStrHospitalCode().equals("21917"))
			{
						
			}
			else
			{	
				htmlStr.append("<tr>");
				htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong><br>(Signature of Authorized Signatory)</strong></font></td>");
				htmlStr.append("</tr>");
				htmlStr.append("<tr>");
				htmlStr.append("<td width='30%'></td><td width='40%'></td><td width='30%' align='center'><font face='Arial, Helvetica, sans-serif' size='2'><strong><br>Seal and Stamp</strong></font></td>");
				htmlStr.append("</tr>");
			}
			htmlStr.append("<tr>");
			htmlStr.append("<td width='30%' align='left'><b>Copy To :-(Internal)<b></td>");
			htmlStr.append("<td width='40%' ></td>");
			htmlStr.append("<td width='30%' align='center'></td>");
			htmlStr.append("</tr>");
			
			k=0;
		
			htmlStr.append("<tr><td align='justify' colspan='3'>");
			
			if (formBean.getWbCopyToDtlsDtls() != null && formBean.getWbCopyToDtlsDtls().size() > 0)
			{
				
					
					htmlStr.append("<table border='0' cellpadding='0px' width='100%' cellspacing='0px'>");	
					while(formBean.getWbCopyToDtlsDtls().next())
					{
						htmlStr.append("<tr>");
						htmlStr.append("<td width='5%'  style='text-align:center'>"+(k+1)+"</td>");														
						htmlStr.append("<td width='45%' style='text-align:left;color:black;padding-left:1%;'>"+formBean.getWbCopyToDtlsDtls().getString(1)+"</td>"); 	
						htmlStr.append("<td width='45%' style='text-align:right;color:black;padding-left:1%;'> - "+formBean.getWbCopyToDtlsDtls().getString(2)+"</td>");					
						htmlStr.append("</tr>");	
						k++;
					}
					htmlStr.append("</table>");			
					
				
			}
			
			htmlStr.append("</td></tr>");
			
			htmlStr.append("<td><tr>");
			htmlStr.append("<table border='0' cellpadding='0px' width='100%' cellspacing='0px'>");
			
			htmlStr.append("<br><tr>");
			htmlStr.append("<td width='30%' align='left'></td>");
			htmlStr.append("<td width='40%' ></td>");
			htmlStr.append("<td width='30%' align='center'></td>");
			htmlStr.append("</tr>");
									
			htmlStr.append("<br><tr>");
			htmlStr.append("<td width='30%' align='left'></td>");
			htmlStr.append("<td width='40%' ></td>");
			htmlStr.append("<td width='30%' align='center'><b>Sr. Procurement-cum Store Officer<b></td>");
			htmlStr.append("</tr>");
			htmlStr.append("</table>");			
			htmlStr.append("</td></tr>");
			
			/*************************************** SPECIFICATION OF ITEM START  **********************************************/
			
			formBean.getWbPODtls().beforeFirst();
			htmlStr.append("<td><tr>");
            
			htmlStr.append("<table border='0' cellpadding='0px' width='100%' cellspacing='0px'>");
			htmlStr.append("<br><br><tr>");
			htmlStr.append("<td width='30%' align=''></td>");
			htmlStr.append("<td width='40%' align='center'><u><b>SPECIFICATION OF ITEM</b></u></td>");
			htmlStr.append("<td width='30%' align=''></td>");
			htmlStr.append("</tr>");								
			htmlStr.append("</table>");	
			
			htmlStr.append("<br>");
			
			htmlStr.append("<table border='1px' cellpadding='0px' width='100%' cellspacing='0px'>");
			
			int t =0;			
			if (formBean.getWbPODtls() != null && formBean.getWbPODtls().size() > 0)
			{
				while(formBean.getWbPODtls().next())
				{
					 /*
		            1.PO_WTH_DATE
		            2.SUPP_NAME
		            3.PO_TYPE
		            4.CATG
		            5.PO_REMARKS
		            6.PO_ENTER_BY_USER_NAME
		            7.PO_GEN_BY_STORE_NAME
		            8.PURCHASE_SOURCE
		            9.RATE_CONTRACT_ID
		           10.RAT_COTRACT_QTY
		           11.ITEM_NAME
		           12.ITEM_CODE_NO
		           13.RATE_WITHOUT_TAX
		           14.ITEM_ORDER_QTY
		           15.ITEM_COST_WITHOUT_TAX
		           16.RATE_WITH_TAX
		           17.ITEM_COST_WITH_TAX
		           18.ITEM_TAX
		           19.DELIVERY_DATE
		           20.PACK_SIZE
		           21.ENTER_BY_USER_NAME/DATE
		           22.     INITCAP(F.HSTSTR_SUPPLIER_NAME) - 
			       INITCAP(F.hststr_contact_person)  - 
			       INITCAP(F.hststr_address)  - 
			       INITCAP(F.hststr_city_name)  - 
			       INITCAP(F.hststr_pincode)  - 
			       INITCAP(F.hststr_phone1)  - 
			       INITCAP(F.hststr_email1)  -              
			       INITCAP(F.hststr_faxno1)  - 
			       INITCAP(F.hststr_website)  - 
			       INITCAP(F.gnum_countrycode)  - 
			       INITCAP(F.gnum_statecode)
		           23.P_KEY - B.HSTNUM_ITEMBRAND_ID||'^'||B.HSTNUM_SUPPLIER_ID||'^'||A.SSTNUM_POTYPE_ID||'^'||A.SSTNUM_ITEM_CAT_NO||'^'||A.HSTNUM_PO_NO||'^'||A.HSTNUM_STORE_ID
		           24.ITEM_SPECIFICATION 
		           25.REMARKS
		           26.COMMENTS
		           27.NOTES
		          */
					if(t == 0 )
					{	
						htmlStr.append("<tr>");
						htmlStr.append("<td width='30%' align='center'><strong>ITEM CODE</strong></td>");
						htmlStr.append("<td width='40%' align='center'><strong>DESCRIPTION</strong></td>");
						htmlStr.append("<td width='30%' align='center'><strong>SPECIFICATION</strong></td>");
						htmlStr.append("</tr>");
					}
					
					htmlStr.append("<tr>");
					htmlStr.append("<td width='30%' align='center'>"+formBean.getWbPODtls().getString(12)+"</td>");
					htmlStr.append("<td width='40%' align='left'>"+formBean.getWbPODtls().getString(11)+"</td>");
					htmlStr.append("<td width='30%' align='left'>"+formBean.getWbPODtls().getString(24)+"</td>");
					htmlStr.append("</tr>");
					
					t++;
		
				}
			}	
			/*************************************** SPECIFICATION OF ITEM END  **********************************************/
					
			
			htmlStr.append("</table>");			
			htmlStr.append("</td></tr>");
			
			
			htmlStr.append("</table>");							
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		htmlStr.append("</table>");
		
		 if(isDraftFlag.equals("0"))
		   {
			 htmlStr.append("</div>");
		   }
		
		htmlStr.append("</div>");
			 
		htmlStr.append("</body>");
		
		htmlStr.append("</html>");

	
	
	return htmlStr.toString();
   }
	
	
		
	

}
