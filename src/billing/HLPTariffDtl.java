package billing;

import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

public class HLPTariffDtl
{ 
	public static float sum=0;
	/**
	 * This Method is Used to get Particular Details DivID 
	 * which we get After click on View Image
	 * Here we genrate the popup for Tariff Details
	 */
	public static String getTariffDtl(String strGrpId,String strAcctNo,String strHospCode) 
	{
		BillingVO voObj = new BillingVO();
		BillingBO boObj = new BillingBO();
		StringBuffer sb = null;
	    voObj.setStrValue1(strGrpId);
	    voObj.setStrValue2(strAcctNo);
	    voObj.setStrValue3(strHospCode);
	    boObj.getTariffDtl(voObj); 
	    try
	    {
	       if(voObj.getStrMsgType().equals("0"))
		   {
		       sb = new StringBuffer("");
	           WebRowSet ws = voObj.getGblWs2(); 
	     	   if (ws != null) 
			   {		           
			       sb.append("<table class='TABLEWIDTH' align='center' color='red' border='0' bgcolor='#000000' cellspacing ='1px'>"); 
				   sb.append("<tr><td width='11%' class='multiLabel'>ReqNo</td>");
				   sb.append("<td width='8%' class='multiLabel'>ReqDate</td>");
				   sb.append("<td width='15%' class='multiLabel'>RaisingDept/Ward</td>");
				   sb.append("<td width='21%' class='multiLabel'>TariffName</td>");
				   sb.append("<td width='3%' class='multiLabel'>Qty</td>");
				   sb.append("<td width='9%' class='multiLabel'>ActualAmt</td>");
				   sb.append("<td width='10%' class='multiLabel'>Exemption(Pkg/Disc)</td>");
				   sb.append("<td width='8%' class='multiLabel'>NetAmt</td>");
				   sb.append("<td width='8%' class='multiLabel'>Payment Mode</td>");
				   sb.append("<td width='7%' class='multiLabel'>Mode</td></tr>");
				   
			       String strReqNo   = null;
			       String strReceiptNo =null;
			       String strReqDate = null;
			       String strRaisingDptWard = null;
			       String strTariffName = null;
			       String strQty = null;
			       String strNetAmt = null;
			       double strNetAmtDiv=0;
			       String strActAmt = null;
			       String strExmAmt = null;
			       String strPayMode = null;
			       String mode=null;
			       
			       for(int i=0;ws.next();i++)
			       { 		
				     String[] data1 = ws.getString(11).replace("^", "#").split("#");
				     strReqNo  = data1[0];
				     strReceiptNo = data1[15];
				     strReqDate  = ws.getString(1);
				     strRaisingDptWard  = ws.getString(2)+"/"+ws.getString(3);
				     strTariffName  = ws.getString(4);
				     strQty  = ws.getString(5);
				     strActAmt  = ws.getString(9);
				     strNetAmt  = ws.getString(10);
				     strNetAmtDiv=Double.parseDouble(strNetAmt);
				     String Disc = ws.getString(7);
				     strExmAmt	= Double.parseDouble(strNetAmt)==0.00?strActAmt:Disc;
				     sum+=Float.parseFloat(strExmAmt);
				     strPayMode  = ws.getString(12);
				     
				     if(ws.getString(13).equals("1"))
				    	 mode="Online";
				     else
				    	 mode="Offline";
				     
				     if(strGrpId.equals(BillConfigUtil.GROUP_ID_DEPOSIT) && strNetAmtDiv!=0)
				    	 strNetAmtDiv=strNetAmtDiv*-1;
				     
	 		   	     if(strReqNo == null || strReqNo.equals("")) strReqNo = "-----";
				     if(strReceiptNo == null || strReceiptNo.equals("")) strReceiptNo = "--";
			   	     if(strReqDate == null || strReqDate.equals("")) strReqDate = "-----";
			         if(strRaisingDptWard == null || strRaisingDptWard.equals("")) strRaisingDptWard = "-----";
			         if(strTariffName == null || strTariffName.equals("")) strTariffName = "-----";
			         if(strQty == null || strQty.equals("")) strQty = "-----";
			         if(strNetAmt == null || strNetAmt.equals("")) 
			         {
			        	 strNetAmt = "-----";
			        	 strNetAmtDiv=0;			        	 
			         }
			         if(strActAmt == null || strActAmt.equals("")) strActAmt = "-----";
			         String ServcieTax = ws.getString(6);
			         String Penelty = ws.getString(8);
			         String TariffRate = data1[12];
			         String UnitName = data1[19];
			         
			         if(ServcieTax.equals("0") ||ServcieTax == null || ServcieTax.equals("")) ServcieTax = "---";
			         if(Disc.equals("0")||Disc == null || Disc.equals("")) Disc = "---";
			         if(Penelty .equals("0") || Penelty == null || Penelty.equals("")) Penelty = "---";
			         if(TariffRate.equals("0") || TariffRate == null || TariffRate.equals("")) TariffRate = "---";
			         if(UnitName .equals("0") || UnitName == null || UnitName.equals("")) UnitName = "---";
			         //strExmAmt	= Double.parseDouble(strExmAmt)==0.00?Disc:strExmAmt;
			         //strExmAmt	= Double.parseDouble(strNetAmt)==0.00?strActAmt:Disc;
			        	         
			         String str = ServcieTax+"^"+Disc+"^"+Penelty+"^"+TariffRate+"^"+UnitName;
					 sb.append("<tr>");
				     sb.append("<td width='12%' class='multiControl'>");
				     sb.append(strReqNo+"/"+strReceiptNo);			
				     sb.append("</td>");
				     sb.append("<td width='9%' class='multiControl'>");
				     sb.append(strReqDate);		
				    sb.append("</td>");
				    sb.append("<td width='12%' class='multiControl'>");		
				    sb.append(strRaisingDptWard);
				    sb.append("</td>");
				    sb.append("<td width='22%' class='multiControl'>");              
				    sb.append("<a name='tarriff' STYLE='cursor:pointer;cursor:hand;color:blue;'  value=''  onClick='tariffDtl(this,"+i+",\""+str+"\");'>"+strTariffName+"</a>");
				    sb.append("</td>");
				    sb.append("<td width='4%' class='multiControl'>");		
				    sb.append(strQty);
				    sb.append("</td>");
				    sb.append("<td width='9%' class='multiControl'>");		
				    sb.append(HisUtil.getAmountWithDecimal(strActAmt, 2));
				    sb.append("</td>");
				    sb.append("<td width='9%' class='multiControl'>");		
				    sb.append(HisUtil.getAmountWithDecimal(strExmAmt, 2));
				    sb.append("</td>");
				    if(Double.parseDouble(strNetAmt)==0.00)
				    	sb.append("<td width='8%' class='multiControlRed'>");
				    else
				    	sb.append("<td width='8%' class='multiControl'>");
				    sb.append(HisUtil.getAmountWithDecimal(strNetAmtDiv, 2));
				    sb.append("</td>");
				    sb.append("<td width='8%' class='multiControl'>");
					
				    sb.append(strPayMode);
				    sb.append("</td>");
				    sb.append("<td width='7%' class='multiControl'>");		
				    sb.append(mode);
				    sb.append("</td></tr>");
			     }
			      sb.append("</table>");
			      //System.out.println("sum="+sum);
		   }
		   else
		   {
	                sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
					sb.append("<tr>");
					sb.append("<td width='100%'  CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED CR NO </div>" + "</TD>");
					sb.append("</tr>");
					sb.append("</table></div>");				
		   } 	   
	  }
	  else
	  {
			  String err = voObj.getStrMsgString();   
			  sb = new StringBuffer("");
			  sb.append("ERROR####"+err);   
	   }       
	 }
	 catch (Exception e)
	 {
	 }
		return sb.toString();
	}
	
	public static String getTariffDtlBS(String strGrpId,String strAcctNo,String strHospCode) 
	{
		BillingVO voObj = new BillingVO();
		BillingBO boObj = new BillingBO();
		StringBuffer sb = null;
	    voObj.setStrValue1(strGrpId);
	    voObj.setStrValue2(strAcctNo);
	    voObj.setStrValue3(strHospCode);
	    boObj.getTariffDtl(voObj); 
	    try
	    {
	       if(voObj.getStrMsgType().equals("0"))
		   {
		       sb = new StringBuffer("");
	           WebRowSet ws = voObj.getGblWs2(); 
	     	   if (ws != null) 
			   {		           
			       sb.append("<table class='table'>"); 
				   sb.append("<thead><tr><th>ReqNo</th>");
				   sb.append("<th>ReqDate</th>");
				   sb.append("<th>RaisingDept/Ward</th>");
				   sb.append("<th>TariffName</th>");
				   sb.append("<th>Qty</th>");
				   sb.append("<th>ActualAmt</th>");
				   sb.append("<th>Exemption(Pkg/Disc)</th>");
				   sb.append("<th>NetAmt</th>");
				   sb.append("<th>Payment Mode</th>");
				   sb.append("<th>Mode</th></tr></thead>");
				   
			       String strReqNo   = null;
			       String strReceiptNo =null;
			       String strReqDate = null;
			       String strRaisingDptWard = null;
			       String strTariffName = null;
			       String strQty = null;
			       String strNetAmt = null;
			       double strNetAmtDiv=0;
			       String strActAmt = null;
			       String strExmAmt = null;
			       String strPayMode = null;
			       String mode=null;
			       
			       for(int i=0;ws.next();i++)
			       { 		
				     String[] data1 = ws.getString(11).replace("^", "#").split("#");
				     strReqNo  = data1[0];
				     strReceiptNo = data1[15];
				     strReqDate  = ws.getString(1);
				     strRaisingDptWard  = ws.getString(2)+"/"+ws.getString(3);
				     strTariffName  = ws.getString(4);
				     strQty  = ws.getString(5);
				     strActAmt  = ws.getString(9);
				     strNetAmt  = ws.getString(10);
				     strNetAmtDiv=Double.parseDouble(strNetAmt);
				     String Disc = ws.getString(7);
				     strExmAmt	= Double.parseDouble(strNetAmt)==0.00?strActAmt:Disc;
				     sum+=Float.parseFloat(strExmAmt);
				     strPayMode  = ws.getString(12);
				     
				     if(ws.getString(13).equals("1"))
				    	 mode="Online";
				     else
				    	 mode="Offline";
				     
				     if(strGrpId.equals(BillConfigUtil.GROUP_ID_DEPOSIT) && strNetAmtDiv!=0)
				    	 strNetAmtDiv=strNetAmtDiv*-1;
				     
	 		   	     if(strReqNo == null || strReqNo.equals("")) strReqNo = "-----";
				     if(strReceiptNo == null || strReceiptNo.equals("")) strReceiptNo = "--";
			   	     if(strReqDate == null || strReqDate.equals("")) strReqDate = "-----";
			         if(strRaisingDptWard == null || strRaisingDptWard.equals("")) strRaisingDptWard = "-----";
			         if(strTariffName == null || strTariffName.equals("")) strTariffName = "-----";
			         if(strQty == null || strQty.equals("")) strQty = "-----";
			         if(strNetAmt == null || strNetAmt.equals("")) 
			         {
			        	 strNetAmt = "-----";
			        	 strNetAmtDiv=0;			        	 
			         }
			         if(strActAmt == null || strActAmt.equals("")) strActAmt = "-----";
			         String ServcieTax = ws.getString(6);
			         String Penelty = ws.getString(8);
			         String TariffRate = data1[12];
			         String UnitName = data1[19];
			         
			         if(ServcieTax.equals("0") ||ServcieTax == null || ServcieTax.equals("")) ServcieTax = "---";
			         if(Disc.equals("0")||Disc == null || Disc.equals("")) Disc = "---";
			         if(Penelty .equals("0") || Penelty == null || Penelty.equals("")) Penelty = "---";
			         if(TariffRate.equals("0") || TariffRate == null || TariffRate.equals("")) TariffRate = "---";
			         if(UnitName .equals("0") || UnitName == null || UnitName.equals("")) UnitName = "---";
			         //strExmAmt	= Double.parseDouble(strExmAmt)==0.00?Disc:strExmAmt;
			         //strExmAmt	= Double.parseDouble(strNetAmt)==0.00?strActAmt:Disc;
			        	         
			         String str = ServcieTax+"^"+Disc+"^"+Penelty+"^"+TariffRate+"^"+UnitName;
					 sb.append("<tbody><tr>");
				     sb.append("<td>");
				     sb.append(strReqNo+"/"+strReceiptNo);			
				     sb.append("</td>");
				     sb.append("<td>");
				     sb.append(strReqDate);		
				    sb.append("</td>");
				    sb.append("<td>");		
				    sb.append(strRaisingDptWard);
				    sb.append("</td>");
				    sb.append("<td>");              
				    sb.append("<a name='tarriff' class='btn btn-info' STYLE='cursor:pointer;cursor:hand;width: 100%;padding: 0.175rem 0.75rem;' data-toggle=\"modal\" data-target=\"#tarrifDetailsModel\" value=''  onClick='tariffDtl(this,"+i+",\""+str+"\");'>"+strTariffName+"</a>");
				    sb.append("</td>");
				    sb.append("<td>");		
				    sb.append(strQty);
				    sb.append("</td>");
				    sb.append("<td>");		
				    sb.append(HisUtil.getAmountWithDecimal(strActAmt, 2));
				    sb.append("</td>");
				    sb.append("<td>");		
				    sb.append(HisUtil.getAmountWithDecimal(strExmAmt, 2));
				    sb.append("</td>");
				    if(Double.parseDouble(strNetAmt)==0.00)
				    	sb.append("<td>");
				    else
				    	sb.append("<td>");
				    sb.append(HisUtil.getAmountWithDecimal(strNetAmtDiv, 2));
				    sb.append("</td>");
				    sb.append("<td>");
					
				    sb.append(strPayMode);
				    sb.append("</td>");
				    sb.append("<td>");		
				    sb.append(mode);
				    sb.append("</td></tr>");
			     }
			      sb.append("</tbody</table>");
			      //System.out.println("sum="+sum);
		   }
		   else
		   {
	                sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
					sb.append("<tr>");
					sb.append("<td width='100%'  CLASS='multiControl' >"
							+ "<DIV class='alert alert-danger' align='center'>NO RECORD FOUND FOR SELECTED CR NO!... </div>" + "</TD>");
					sb.append("</tr>");
					sb.append("</table></div>");				
		   } 	   
	  }
	  else
	  {
			  String err = voObj.getStrMsgString();   
			  sb = new StringBuffer("");
			  sb.append("ERROR####"+err);   
	   }       
	 }
	 catch (Exception e)
	 {
	 }
		return sb.toString();
	}
}