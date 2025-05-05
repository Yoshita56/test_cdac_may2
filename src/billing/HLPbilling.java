package billing;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

public class HLPbilling extends DAObilling {
	
	private static final String strColor = "red";
	private static final String defaultColor = "blue";
	
	public HLPbilling()
	{
		
	}

	/** generate the tariff combo and set that in response
	 * 
	 * @param request
	 * @param response
	 */
	public void returnCombo(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response){
		String str="";		
		try{
			response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    String grp_ID = request.getParameter("group_Id");		    
		    str = getComboData(grp_ID);				   
		    out.print(str);
		}
		catch(Exception e)
		{
			new HisException("billing","HLPbilling.returnCombo()",e.getMessage());
	 
		}
	}
	
	/**  called from returnCombo 
	 * returns the tariff combo on the basis of group id
	 * @param grp_ID
	 * @return tariff combo string
	 */
	public String getComboData(String grp_ID){
		
		HisUtil hisutil = new HisUtil("billing","HLPbilling");		 
		String comboName = "combo";
		String html = "";
		StringBuffer strBuffer = new StringBuffer(1000);
		try{
			String actionData = "id ='"+ comboName + "#delIndex#' onChange=\"changeValue(this,'#delIndex#');\"";		  		  
			ArrayList Al_List = new ArrayList();		 
			Al_List = getComboList(grp_ID);		  			
				//if (combo == 1){			//combo required
			if (actionData == "")		
				strBuffer.append("<select name = " + comboName + " >");
			else
				strBuffer.append("<select name = " + comboName + " " + actionData + ">");
				//}			
			html = hisutil.getOptionValue(Al_List,"","");			
			strBuffer.append(html);
			strBuffer.append("</select>");
		}
		catch(Exception e)
		{
			new HisException("billing","HLPbilling.getComboData()",e.getMessage());
		}
	return strBuffer.toString();
	}
	
	/** generates the combo option string 
	 * called from billingMultiRow2.jsp
	 * @return combo option string
	 */
	public String  GroupCombo(){
		
		  HisUtil hisutil = new HisUtil("billing","HLPbilling");
		  String comboName = "group";		  		  
		  String html = "";		  
		  ArrayList Al_List = new ArrayList();
		  try{
			
			Al_List = groupComboData();
			html = hisutil.getOptionValue(Al_List,"","");
					    
		  }
		  catch(Exception e)
		  {
			  new HisException("billing","HLPbilling.GroupCombo()",e.getMessage());
		  }		  		  
	return html;
	}
	
	/** Generate the tariff combo on the basis of group id
	 * 2
	 * @param request
	 * @param response
	 */
	public void returnTariffCombo(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response){

		String grp_ID = "";
		String finalIndex = "";
		String html = "";		
		ArrayList Al_List = new ArrayList();
		finalIndex = request.getParameter("finalIndex");
		StringBuffer strBuffer = new StringBuffer(1000);
		String comboName = "tariff";		
		String actionData = "id ='"+ comboName +"1-"+finalIndex+ "' onChange=\"fun('#delIndex#');\" ";
		HisUtil hisutil = new HisUtil("billing","HLPbilling");
		try{
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		   
		    grp_ID = request.getParameter("group_Id");
		    Al_List = tariffComboData(grp_ID);
		    
		    if (actionData == "")		
				strBuffer.append("<select name = " + comboName + " >");
		    else
				strBuffer.append("<select name = " + comboName + " " + actionData + ">");
		    			 		    
			html = hisutil.getOptionValue(Al_List,"","");
			strBuffer.append(html);	 
			out.print(strBuffer.toString());
		  }
		  catch(Exception e){
			  new HisException("billing","HLPbilling.returnTariffCombo()",e.getMessage());
		  }
		  
	}
    ////////////////////////Return Client Header Detail String//////////////////////////	
	public static String getHeaderDtl(String strchk)
	 {
		    StringBuffer sBuffer = new StringBuffer("");
		    BillingVO voObj = new BillingVO();
			BillingBO boObj = new BillingBO();
            voObj.setStrValue1(strchk);
		 try
		   {    
			     boObj.getHeaderDetailsWS(voObj);
			     WebRowSet ws = voObj.getGblWs1();
			     ////////////////////////////////////////////////////////////

			     if(ws.next())
			     {
			      String strClientName  =  ws.getString(1);
				  String strClientType  =  ws.getString(2);
				  String strPaymentType =  ws.getString(9);
				  String strRegNo       =  ws.getString(3);
				  String strAddress     =  ws.getString(5);
				  String strContactPerson =  ws.getString(4);
				  String strContacNo      =  ws.getString(6);
				  String strIsOPD =  ws.getString(10);
				  String strIsIPD =  ws.getString(11);
				  String strIsEME =  ws.getString(12);
			      String strClientID = ws.getString(13);
			  //    System.out.println("isOPD In BillHeaderHLP->"+strClientID);
			
			     
			     /////////////////////////////////////////////////////////////////  
			    		
			         
			          sBuffer.append("<input type='hidden' name='strPaymentType' value="+strPaymentType+">");
					  sBuffer.append("<input type='hidden' name='strClientID' value="+strClientID+">");
	           					         
			          sBuffer.append("<table width='100%' align='center'" + " border='0'><tr>");
			          sBuffer.append("<td width='25%' class='multiControl'>");
			          sBuffer.append("Client Name</td>");
	 	              sBuffer.append("<td width='25%' class='multiControl'>");    
	 	              sBuffer.append("<input type='text' name='strClientName' class='' maxlength ='15' id='strClientName' return validateData(event,4);>"+strClientName+"</td>");
	 	              sBuffer.append("</td>");
	 	              sBuffer.append("<td width='25%' class='multiControl'>");
			          sBuffer.append("Client Type</td>");
	 	              sBuffer.append("<td width='25%' class='multiControl'>");    
		              sBuffer.append("<input type='text' name='strClientType' class='' id='strClinetType'  return validateData(event,5);>"+strClientType+"</td>");
		              sBuffer.append("</tr>");
		              
		              sBuffer.append("<tr>");
		              sBuffer.append("<td width='25%' class='multiControl'>");
			          sBuffer.append("Reg No:</td>");
	 	              sBuffer.append("<td width='25%' class='multiControl'>");    
	 	              sBuffer.append("<input type='text' name='strRegNo' class='' maxlength ='15' id='strChequeNo' return validateData(event,5);>"+strRegNo+"</td>");
	 	              sBuffer.append("</td>");
	 	              sBuffer.append("<td width='25%' class='multiControl'>");
			          sBuffer.append("Contact Person</td>");
	 	              sBuffer.append("<td width='25%' class='multiControl'>");    
		              sBuffer.append("<input type='text' name='strContactPerson' class='' id='strContactPerson' return validateData(event,4);>"+strContactPerson+"</td>");
		              sBuffer.append("</tr>");
		              
		              sBuffer.append("<tr>");
		              sBuffer.append("<td width='25%' class='multiControl'>");
			          sBuffer.append("Address:</td>");
	 	              sBuffer.append("<td width='25%' class='multiControl'>");    
	 	              sBuffer.append("<input type='text' name='strAddress' class='' maxlength ='15' id='strAddress' return validateData(event,3);>"+strAddress+"</td>");
	 	              sBuffer.append("</td>");
	 	              sBuffer.append("<td width='25%' class='multiControl'>");
			          sBuffer.append("Contact No</td>");
	 	              sBuffer.append("<td width='25%' class='multiControl'>");    
		              sBuffer.append("<input type='text'name='strContacNo' class='' id='strContacNo'  return validateData(event,2);>"+strContacNo+"</td>");
		              sBuffer.append("</tr>");
		              
		              sBuffer.append("<tr>");
		              sBuffer.append("<td width='25%' class='multiControl'>");
			          sBuffer.append("Payment Type:</td>");
	 	              sBuffer.append("<td width='25%' class='multiControl'>");    
	 	              sBuffer.append("<input type='text' name='strPaymentType' class='' maxlength ='15' id='strPaymentType' return validateData(event,3);>"+strPaymentType+"</td>");
	 	              sBuffer.append("</td>");
	 	              sBuffer.append("<td width='25%' class='multiControl'>");
			          sBuffer.append("</td>");
	 	              sBuffer.append("<td width='25%' class='multiControl'>");    
		              sBuffer.append("<input type='text'name='' class='' id=''></td>");
		              sBuffer.append("</tr>");
		              
		              sBuffer.append("</table>");
		             
		                sBuffer.append("<table width='100%' align='center'" + " border='0'><tr>");
		                sBuffer.append("<tr><td colspan='4' class='TITLE'>Client Covers</td></tr>");
                     	sBuffer.append("<tr><td colspan='4'>");
                       sBuffer.append("<table width='100%' align='center'>");
                       if(strIsOPD.trim().equals("1")&& strIsIPD.trim().equals("0")&& strIsEME.trim().equals("0"))
                       {
                            sBuffer.append("<tr><td  class='LABEL'><input type='checkbox' name='strIsIPD' value='1' checked>OPD Covers</td>");
                            sBuffer.append("<td  class='LABEL'><input type='checkbox' name='strIsOPD' value='0' >IPD Covers</td>");
                            sBuffer.append("<td  class='LABEL'><input type='checkbox' name='strIsEME' value='0' >Emergency Covers</td>");
                       }
                       if(strIsOPD.trim().equals("0")&& strIsIPD.trim().equals("1")&& strIsEME.trim().equals("0"))
                       {
                       	 sBuffer.append("<tr><td  class='LABEL'><input type='checkbox' name='strIsIPD' value='0'>OPD Covers</td>");
                            sBuffer.append("<td  class='LABEL'><input type='checkbox' name='strIsOPD' value='1' checked>IPD Covers</td>");
                            sBuffer.append("<td  class='LABEL'><input type='checkbox' name='strIsEME' value='0' >Emergency Covers</td>");

                       }
                       if(strIsOPD.trim().equals("0")&& strIsIPD.trim().equals("0") && strIsEME.trim().equals("1"))
                       {
                       	 sBuffer.append("<tr><td  class='LABEL'><input type='checkbox' name='strIsIPD' value='0' >OPD Covers</td>");
                            sBuffer.append("<td  class='LABEL'><input type='checkbox' name='strIsOPD' value='0' >IPD Covers</td>");
                            sBuffer.append("<td  class='LABEL'><input type='checkbox' name='strIsEME' value='1' checked>Emergency Covers</td>");

                       }
					    sBuffer.append("</tr>");
					    sBuffer.append("</table>");
					    sBuffer.append("</td></tr>");
					    sBuffer.append("</table>");
			    }
	     }
		 catch(Exception e)
		 {
	 
			 new HisException("Client Verification Trans","BillHeaderHLP.getHeader()-->",e.getMessage());
	     }
	   
	     
	     return sBuffer.toString();
		
	 }	
public static String getTariffChargeView(WebRowSet ws){
		
		StringBuffer sb = new StringBuffer("");
		
		String strRate = "";
		
		final int LMIT_VAL = 15;
		
		sb.append("<table width='100%'>");
		
		try{
		
		if(ws != null){
			
			if(ws.size() != 0){
				
				ws.beforeFirst();
				
                sb.append("<table width='100%'  id='table_id' >");
				
				sb.append("<thead>");
				
				sb.append("<tr>");
				sb.append("<th class='multiLabel'>#</th><th class='multiLabel'>Tariff Code</th><th class='multiLabel'>Tariff Name</th> <th class='multiLabel'>Rate (<img src='../../hisglobal/images/INR.png'>)</th>   ");
				sb.append("</tr>");				
				sb.append("</thead>");				
				sb.append("<tbody>");
				
				
				 while(	ws.next()){
							
							strRate = ws.getString(1).replace("^", "#").split("#")[4];
							
							strRate = HisUtil.getAmountWithDecimal(strRate, 2);
							
							sb.append("<tr ><td class='multiControl' width='5%'><input type='radio' name='strTariffVal' value='");
							sb.append(ws.getString(1));
							sb.append("' onClick='setTariffName(this,\""+ws.getString(2)+"\");'></td><td class='CONTROL' width='15%' >"+ws.getString(3)+"</td><td class='CONTROL' width='60%' >&nbsp;&nbsp;"+ws.getString(2)+"</td><td class='CONTROL' width='20%' >&nbsp;&nbsp;"+strRate+"</td>  ");
							sb.append("</tr>");
							
					}
						 
						 sb.append("</tbody></table>");
				
			}else{
				
				sb.append("<tr><td class='multiControl'><font color='red'>No Matching Record Found</font></td></tr>");
			}
			
			
		}else{
			throw new Exception("WebRowSet should not be null");
		}
		
		}catch(Exception e){
			
		 
			
			 new HisException("Global TariffSearch","billing.HLPBilling.getTariffChargeView()-->",e.getMessage());
		}
		
		sb.append("</table>");
		
		//System.out.println(" "+sb.toString());
		
		return sb.toString();
	}

public static String getTariffCodeChargeView(WebRowSet ws){
	
	StringBuffer sb = new StringBuffer("");
	String strRate = "";
	
	final int LMIT_VAL = 15;
	
	sb.append("<table width='100%'>");
	
	try{
	
	if(ws != null){
		
		if(ws.size() != 0){
			
			ws.beforeFirst();
			
			/*int noOfRecords = ws.size();
								
			int layerNo = noOfRecords / LMIT_VAL;
							
			int reminder = noOfRecords % LMIT_VAL;
			int totalLayer = layerNo;
			
			if(reminder > 0) totalLayer = totalLayer + 1;
			
			sb.append("<tr>");
			sb.append("<td class='TITLE'>&nbsp;");
			for(int i=1; i<= totalLayer ; i++){
				
				if(i == 1){
				sb.append("<a STYLE='CURSOR:POINTER; color:"+strColor+"' name='linId' id='linId"+i+"' onClick='trfCodelayerIndexNavigator(\""+i+"\",\""+totalLayer+"\")'>"+i+"</a> &nbsp;");
				}else{
					sb.append("<a STYLE='CURSOR:POINTER; color:"+defaultColor+"' name='linId' id='linId"+i+"' onClick='trfCodelayerIndexNavigator(\""+i+"\",\""+totalLayer+"\")'>"+i+"</a> &nbsp;");
				}
			}
			sb.append("</td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td >");
			
			for(int i=1; i<= totalLayer ; i++){
				
				if(i != totalLayer && totalLayer != 1){
					if(i == 1){
					sb.append("<div id='tariffDivId"+i+"' style='display:block'>");
					}else{
						sb.append("<div id='tariffDivId"+i+"' style='display:none'>");
					}
					sb.append("<table width='100%' cellpadding='1px' cellpadding='1px' >");
					sb.append("<tr>");
					sb.append("<td class='multiLabel'>#</td><td class='multiLabel'>Tariff Code</td><td class='multiLabel'>Tariff Name</td> <td class='multiLabel'>Rate (<img src='../../hisglobal/images/INR.png'>)</td>  ");
					sb.append("</tr>");
					for(int j=0; j<LMIT_VAL ; j++){
						ws.next();
						
						strRate = ws.getString(1).replace("^", "#").split("#")[4];
						
						strRate = HisUtil.getAmountWithDecimal(strRate, 2);
						
						sb.append("<tr ><td class='multiControl' width='5%'><input type='radio' name='strTariffVal' value='");
						sb.append(ws.getString(1));
						sb.append("' onClick='setTariffCode(this,\""+ws.getString(3)+"\");'></td><td class='multiControl' width='15%' >"+ws.getString(3)+"</td><td class='CONTROL' width='60%' >&nbsp;&nbsp;"+ws.getString(2)+"</td><td class='CONTROL' width='20%' >&nbsp;&nbsp;"+strRate+"</td>  ");
						}
					sb.append("</table>");
					sb.append("</div>");
					
				}else{
					if(i == 1){
						sb.append("<div id='tariffDivId"+i+"' style='display:block'>");
						}else{
							sb.append("<div id='tariffDivId"+i+"' style='display:none'>");
						}
					
					sb.append("<table width='100%' cellpadding='1'>");
					sb.append("<tr>");
					sb.append("<td class='multiLabel'>#</td><td class='multiLabel'>Tariff Code</td><td class='multiLabel'>Tariff Name</td> <td class='multiLabel'>Rate (<img src='../../hisglobal/images/INR.png'>)</td>  ");
					sb.append("</tr>");
					for(int k=0; k<reminder ;k++){
						ws.next();
						
						strRate = ws.getString(1).replace("^", "#").split("#")[4];
						
						strRate = HisUtil.getAmountWithDecimal(strRate, 2);
						
						sb.append("<tr ><td class='multiControl' width='5%'><input type='radio' name='strTariffVal' value='");
						sb.append(ws.getString(1));
						sb.append("' onClick='setTariffCode(this,\""+ws.getString(3)+"\");'></td><td class='multiControl' width='15%' >"+ws.getString(3)+"</td><td class='CONTROL' width='60%' >&nbsp;&nbsp;"+ws.getString(2)+"</td><td class='CONTROL' width='20%' >&nbsp;&nbsp;"+strRate+"</td>  ");
					}
					sb.append("</table>");
					sb.append("</div>");
					
				}
				
			}
			
			sb.append("</td>");
			sb.append("</'tr>");
			
		}else{
			
			sb.append("<tr><td class='multiControl'><font color='red'>No Matching Record Found</font></td></tr>");
		}*/
            sb.append("<table width='100%'  id='table_id' >");
			
			sb.append("<thead>");			
			sb.append("<tr>");
			sb.append("<th class='multiLabel'>#</th><th class='multiLabel'>Tariff Code</th><th class='multiLabel'>Tariff Name</th> <th class='multiLabel'>Rate (<img src='../../hisglobal/images/INR.png'>)</th> ");
			sb.append("</tr>");			
			sb.append("</thead>");			
			sb.append("<tbody>");			
			
			 while(	ws.next()){
						
						strRate = ws.getString(1).replace("^", "#").split("#")[4];
						
						strRate = HisUtil.getAmountWithDecimal(strRate, 2);
						
						sb.append("<tr ><td class='multiControl' width='5%'><input type='radio' name='strTariffVal' value='");
						sb.append(ws.getString(1));
						sb.append("' onClick='setTariffCode(this,\""+ws.getString(3)+"\");'></td><td class='CONTROL' width='15%' >"+ws.getString(3)+"</td><td class='CONTROL' width='60%' >&nbsp;&nbsp;"+ws.getString(2)+"</td><td class='CONTROL' width='20%' >&nbsp;&nbsp;"+strRate+"</td>  ");
						sb.append("</tr>");
						
				}
					 
					 sb.append("</tbody></table>");
									
		}
			 
			 sb.append("</tbody></table>");
		
	}else{
		throw new Exception("WebRowSet should not be null");
	}
	
	}catch(Exception e){
		
	 
		
		 new HisException("Global TariffSearch","billing.HLPBilling.getTariffCodeChargeView()-->",e.getMessage());
	}
	
	sb.append("</table>");
	
	//System.out.println(" "+sb.toString());
	
	return sb.toString();
}

public static String getPackageDetails(WebRowSet ws)
{	
	StringBuffer sb = new StringBuffer("");
	String strRate = "";
	int idx=-1;
	final int LMIT_VAL = 15;
	
	sb.append("<table width='100%'>");
	
	try
	{	
		if(ws != null)
		{		
			if(ws.size() != 0)
			{			
				//ws.beforeFirst();			
				int noOfRecords = ws.size();								
				int layerNo = noOfRecords / LMIT_VAL;							
				int reminder = noOfRecords % LMIT_VAL;
				int totalLayer = layerNo;			
				if(reminder > 0) totalLayer = totalLayer + 1;
				
				sb.append("<tr>");
				sb.append("<td class='TITLE'>&nbsp;");
				ws.first();
				sb.append("<a STYLE='CURSOR:POINTER; color:white' name='linId' '>Pacakge Name :- "+ws.getString(1)+"</a> &nbsp;");
				/*for(int i=1; i<= totalLayer ; i++)
				{				
					if(i == 1)
					{
						sb.append("<a STYLE='CURSOR:POINTER; color:"+strColor+"' name='linId' '>"+"</a> &nbsp;");
					}
					else
					{
						sb.append("<a STYLE='CURSOR:POINTER; color:"+defaultColor+"' name='linId' '>"+i+"</a> &nbsp;");
					}
				}*/
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td >");
				
				for(int i=1; i<= totalLayer ; i++)
				{				
					if(i != totalLayer && totalLayer != 1)
					{
						if(i == 1)
						{
							sb.append("<div id='tariffDivId"+i+"' style='display:block'>");
						}
						else
						{
							sb.append("<div id='tariffDivId"+i+"' style='display:none'>");
						}
						sb.append("<table width='100%'style='background-color: black;>");
						sb.append("<tr>");
						sb.append("<td class='multiLabel' style='display:none'></td>"
								+ "<td class='multiLabel'>Tariff Name</td>"
								+ "<td class='multiLabel'>Total Qty.</td>"
								+ "<td class='multiLabel'>Consumed Qty.</td>"
								+ "<td class='multiLabel'>Available Qty.</td>"
								+ " <td class='multiLabel'>Rate (<img src='../../hisglobal/images/INR.png'>)</td>  ");
						sb.append("</tr>");
						for(int j=0; j<LMIT_VAL ; j++)
						{
							//ws.first();
							
							idx++;
							String trId="TRALLTARIFFHLP"+idx;
							//strRate = ws.getString(1).replace("^", "#").split("#")[4];
							
							//strRate = HisUtil.getAmountWithDecimal(strRate, 2);
							sb.append("<input type='hidden' name='deleteFlag' value='0' id='deleteFlag"+idx+"'>");
							//sb.append("<input type='hidden' name='grpid' value='"+ws.getString(1).replace("^", "#").split("#")[1]+"' id='grpid"+idx+"'>");
							
							sb.append("<tr><td class='trfTd' width='5%' style='display:none'>"
									+ "<input type='radio' style='display: none;' name='strTariffVal' id='strTariffVal"+idx+"'  onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1'  readonly value='");
							sb.append(ws.getString(1));
							sb.append("'></td>"
									+ "<td class='trfTd' width='40%' ><input type='text'  tabindex='1' name='strtariffname'      id='strtariffname"+idx+"'  	   onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1' value='"+ ws.getString(2) +"' readonly></td>"
									+ "<td class='trfTd' width='10%' ><input type='text'  tabindex='1' name='strtariffcode'      id='strtariffcode"+idx+"'  	   onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1' value='"+ws.getString(3) +"' readonly></td>"
									+ "<td class='trfTd' width='15%' ><input type='text'  tabindex='1' name='strtariffcode'      id='strtariffcode"+idx+"'  	   onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1' value='"+ws.getString(4) +"' readonly></td>"
									+ "<td class='trfTd' width='15%' ><input type='text'  tabindex='1' name='strtariffcode'      id='strtariffcode"+idx+"'  	   onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1' value='"+ws.getString(5) +"' readonly></td>"
									+ "<td class='trfTd' width='20%' ><input type='text'  tabindex='1' name='strrate'      id='strrate"+idx+"'  	   onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1' value='"+ ws.getString(7) +"' readonly></td>  ");
							ws.next();
						}
						sb.append("</table>");
						sb.append("</div>");						
					}
					else
					{
						if(i == 1)
						{
							sb.append("<div id='tariffDivId"+i+"' style='display:block'>");
						}
						else
						{
							sb.append("<div id='tariffDivId"+i+"' style='display:none'>");
						}						
						sb.append("<table width='100%' style='background-color: black;>");
						sb.append("<tr>");
						sb.append("<td class='multiLabel' style='display:none'></td>"
								+ "<td class='multiLabel'>Tariff Name</td>"
								+ "<td class='multiLabel'>Total Qty.</td>"
								+ "<td class='multiLabel'>Consumed Qty.</td>"
								+ "<td class='multiLabel'>Available Qty.</td>"
								+ " <td class='multiLabel'>Rate (<img src='../../hisglobal/images/INR.png'>)</td>  ");
						sb.append("</tr>");
						
						for(int k=0; k<reminder ;k++)
						{
							//ws.first();
							
							idx++;
							String trId="TRALLTARIFFHLP"+idx;
							//strRate = HisUtil.getAmountWithDecimal(strRate, 2);
							sb.append("<input type='hidden' name='deleteFlag' value='0' id='deleteFlag"+idx+"'>");
							//sb.append("<input type='hidden' name='grpid' value='"+ws.getString(1).replace("^", "#").split("#")[1]+"' id='grpid"+idx+"'>");
							
							sb.append("<tr><td class='trfTd' width='5%' style='display:none'>"
									+ "<input type='radio' style='display: none;' name='strTariffVal' id='strTariffVal"+idx+"'  onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1'  readonly value='");
							sb.append(ws.getString(1));
							sb.append("' ></td>"
									+ "<td class='trfTd' width='50%' ><input type='text'  tabindex='1' name='strtariffname'      id='strtariffname"+idx+"'  	   onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1' value='"+ ws.getString(2) +"' readonly></td>"
									+ "<td class='trfTd' width='10%' ><input type='text'  tabindex='1' name='strtariffcode'      id='strtariffcode"+idx+"'  	   onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1' value='"+ws.getString(3) +"' readonly></td>"
									+ "<td class='trfTd' width='15%' ><input type='text'  tabindex='1' name='strtariffcode'      id='strtariffcode"+idx+"'  	   onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1' value='"+ws.getString(4) +"' readonly></td>"
									+ "<td class='trfTd' width='15%' ><input type='text'  tabindex='1' name='strtariffcode'      id='strtariffcode"+idx+"'  	   onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1' value='"+ws.getString(5) +"' readonly></td>"
									+ "<td class='trfTd' width='20%' ><input type='text'  tabindex='1' name='strrate'      id='strrate"+idx+"'  	   onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1' value='"+ ws.getString(7) +"' readonly></td>  ");
							ws.next();
						 }
						sb.append("</table>");
						sb.append("</div>");						
					}					
				}				
				sb.append("</td>");
				sb.append("</'tr>");			
			}
			else
			{			
				sb.append("<tr><td class='multiControl'><font color='red'>No Matching Record Found</font></td></tr>");
			}		
		}
		else
		{
			throw new Exception("WebRowSet should not be null");
		}	
	}
	catch(Exception e){
		
	 e.printStackTrace();
		
		 new HisException("Global TariffSearch","billing.HLPBilling.getTariffCodeChargeView()-->",e.getMessage());
	}
	
	sb.append("</table>");
	
	//System.out.println(" "+sb.toString());
	
	return sb.toString();
}

public static String getTariffCodeChargeView2(WebRowSet ws)
{	
	StringBuffer sb = new StringBuffer("");
	String strRate = "";
	String grpid = "";
	int idx=-1;
	final int LMIT_VAL = 15;
	
	sb.append("<table width='100%'>");
	
	try
	{	
		if(ws != null)
		{		
			if(ws.size() != 0)
			{			
				ws.beforeFirst();			
                sb.append("<table width='100%'  id='table_id' >");
				
				sb.append("<thead>");
				
				sb.append("<tr>");
				sb.append("<th class='multiLabel' style='display:none'></th><th class='multiLabel'>Drug Name</th><th class='multiLabel'>Drug Code</th> <th class='multiLabel'>Rate (<img src='../../hisglobal/images/INR.png'>)</th>  ");
				sb.append("</tr>");
				
				sb.append("</thead>");
				
				sb.append("<tbody>");
				
				
				 while(	ws.next()){
							idx++;
							String trId="TRALLTARIFFHLP"+idx;
							strRate = ws.getString(1).replace("^", "#").split("#")[4];
							
							grpid= ws.getString(1).replace("^", "#").split("#")[1];
							
							
							
							strRate = HisUtil.getAmountWithDecimal(strRate, 2);
							sb.append("<tr>");
							sb.append("<input type='hidden' name='deleteFlag' value='0' id='deleteFlag"+idx+"'>");
							sb.append("<input type='hidden' name='grpid' value='"+ws.getString(1).replace("^", "#").split("#")[1]+"' id='grpid"+idx+"'>");
							//sb.append("<input type='hidden' name='flag' value='2' id='flag"+idx+"'>");
							sb.append("<td class='trfTd' width='5%' style='display:none'>"+ws.getString(2)+"<input type='radio' style='display: none;' name='strTariffVal' id='strTariffVal"+idx+"'  onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1'  readonly value='");
							sb.append(ws.getString(1));
							sb.append("' onClick='setTariffCode(this,\""+ws.getString(3)+"\");'></td><td class='trfTd' width='60%' ><input type='text'  tabindex='1' name='strtariffname'      id='strtariffname"+idx+"'  	   onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1' value='"+ ws.getString(2) +"' readonly><font style='display:none;'>"+ ws.getString(2) +"</font></td><td class='trfTd' width='15%' ><input type='text'  tabindex='1' name='strtariffcode'      id='strtariffcode"+idx+"'  	   onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1' value='"+ws.getString(3) +"' readonly><font style='display:none;'>"+ ws.getString(3) +"</font></td>"
									+ "<td class='trfTd' width='20%' ><input type='text'  tabindex='1' name='strrate'      id='strrate"+idx+"'  	   onkeypress='moveUpDown(event,this,"+idx+");'  onkeyup=\"deleteRow(event,this,"+idx+",'"+trId+"')\" onkeydown=\"checkFirstKey(event)\" class='editor-texts1' value='"+ strRate +"' readonly><font style='display:none;'>"+ strRate +"</font></td>  ");
							/*sb.append("<td class='trfTd'  width='5%' style='display:none'></td> ");
							sb.append("<td class='trfTd' style='color: black ;' width='60%' onkeyup='abc(this,event,"+idx+");'  onkeypress='setDrugNew(this,"+ws.getString(1).replace("^", "#").split("#")[0]+",event,"+idx+","+grpid+");'  ondblclick='setDrugNewMouse(this,"+ws.getString(1).replace("^", "#").split("#")[0]+",event,"+idx+","+grpid+");' tabindex='1' id='strtariffname"+idx+"' ><b>"+ ws.getString(2) +"</b></td><td class='trfTd' style='color: black ;' onkeyup='abc(this,event,"+idx+");' onkeypress='setDrugNew(this,"+ws.getString(1).replace("^", "#").split("#")[0]+",event,"+idx+","+grpid+");' ondblclick='setDrugNewMouse("+ws.getString(1).replace("^", "#").split("#")[0]+",event,"+idx+","+grpid+");' width='15%' id='strtariffcode"+idx+"' tabindex='1' >"+ ws.getString(3) +"</td><td class='trfTd' style='color: black ;' onkeyup='abc(this,event,"+idx+");' onkeypress='setDrugNew(this,"+ws.getString(1).replace("^", "#").split("#")[0]+",event,"+idx+","+grpid+");' ondblclick='setDrugNewMouse("+ws.getString(1).replace("^", "#").split("#")[0]+",event,"+idx+","+grpid+");' width='20%' tabindex='1'  id='strRate"+idx+"'>"+ strRate +"</td>  ");*/
							sb.append("</tr>");
							
					}
						 
						 sb.append("</tbody></table>");	
			}
			else
			{			
				sb.append("<tr><td class='multiControl'><font color='red'>No Matching Record Found</font></td></tr>");
			}		
		}
		else
		{
			throw new Exception("WebRowSet should not be null");
		}	
	}
	catch(Exception e){
		
	 
		
		 new HisException("Global TariffSearch","billing.HLPBilling.getTariffCodeChargeView()-->",e.getMessage());
	}
	
	sb.append("</table>");
	
	//System.out.println(" "+sb.toString());
	
	return sb.toString();
}

    public static String getPatientListingView(BillingVO voObj) 
    {
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = voObj.getGblWs1();

		try 
		{
	
			int start = Integer.parseInt(voObj.getStrValue4());
			int actualBlockSet = Integer.parseInt(voObj.getStrValue7());	
			final int REC_PER_PAGE = Integer.parseInt(voObj.getStrValue6());
			final int PAGE_PER_BLOCK = 10;			
			int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
			int totalRecordsToManipulate = totalFetchRecord - 1;			
			int previous = 1;
			int next = 0;
		
			if (ws != null) {
				
				if(ws.size() != 0)
				{				
					int actualFetchRecord = ws.size();				
					if(actualBlockSet == 1) actualBlockSet = actualBlockSet + 1;
					
					next = ((actualBlockSet * PAGE_PER_BLOCK) - PAGE_PER_BLOCK) + 1; 
					previous = (((actualBlockSet - 2) * PAGE_PER_BLOCK) - PAGE_PER_BLOCK) + 1; 
						
					if(totalFetchRecord != actualFetchRecord)
					{				
						totalFetchRecord = actualFetchRecord;
						totalRecordsToManipulate = actualFetchRecord;
						next = 0;				
					}			
					
					int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
					int reminder = totalRecordsToManipulate % REC_PER_PAGE;
									
					
					if (reminder > 0)
						totalLayer = totalLayer + 1;
		
				/*	sb
							.append("<table width='100%'align='center' cellspacing='1px'>");
		
					sb.append("<tr>");
					sb.append("<td class='LABEL'>&nbsp;");
		
					if (start != 1){
						sb
								.append("<a href='#' onClick='fetchPatientList(\""+previous+"\",\""+(actualBlockSet - 1)+"\");'> &lt;&lt; Previous</a> &nbsp;");
						
					}
					for (int i = 1; i <= totalLayer; i++) {
						sb.append("<a href='#' onClick='trfCodelayerIndexNavigator(\"" + i
								+ "\",\"" + totalLayer + "\")'>" + (i + start - 1)
								+ "</a> &nbsp;");
					}
		
					if (next > 0 )
						sb.append("<a href='#' onClick='fetchPatientList(\""+next+"\",\""+(actualBlockSet + 1)+"\");'> Next &gt;&gt;</a>");
		
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("</table>");
		*/
					
					
					
					// added content 
					
					sb.append("<table width='100%'align='center' cellspacing='1px'>");
					sb.append("<tr>");
					sb.append("<td class='LABEL'>&nbsp;");
		
					if (start != 1)
					{
						sb.append("<a STYLE='CURSOR:POINTER'  onClick='fetchPatientList(\""+previous+"\",\""+(actualBlockSet - 1)+"\");'> <FONT COLOR='"+strColor+"'> &lt;&lt; Previous</FONT> </a> &nbsp;");
					}
					for (int i = 1; i <= totalLayer; i++) 
					{
						
						if(i == 1)
						{
							sb.append("<a STYLE='CURSOR:POINTER; color:"+strColor+"' name='linId' id='linId"+i+"' onClick='layerIndexNavigator(\"" + i
									+ "\",\"" + totalLayer + "\")'>");	
							sb.append((i + start - 1));				
						}
						else
						{
							sb.append("<a STYLE='CURSOR:POINTER; color:"+defaultColor+"' name='linId' id='linId"+i+"' onClick='layerIndexNavigator(\"" + i
									+ "\",\"" + totalLayer + "\")'>");
							sb.append((i + start - 1));
						}
						sb.append("</a> &nbsp;");
					}
		
					if (next > 0 )
						sb.append("<a STYLE='CURSOR:POINTER' onClick='fetchPatientList(\""+next+"\",\""+(actualBlockSet + 1)+"\");'> <FONT COLOR='"+strColor+"'> Next &gt;&gt;</FONT></a>");
		
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("</table>");
					
					sb.append("<table width='100%'align='center' cellspacing='1px'>");
					sb.append("<tr class='style_x'>");
					sb.append("<td width='3%'class='multiLabelSmall'></td>");
					
					if(!voObj.getStrValue1().equals("7"))
					{
						sb.append("<td width='18%'class='multiLabelSmall'>CR No.</td>");			
					}
					sb.append("<td width='23%'class='multiLabelSmall'>Patient Name</td>");
					sb.append("<td width='24%'class='multiLabelSmall'>Hospital Service</td>");
					sb.append("<td width='20%'class='multiLabelSmall'>Request Type</td>");
					sb.append("<td width='12%'class='multiLabelSmall'>Request Date</td>");
					sb.append("</tr>");
					sb.append("</table>");
		
					for (int i = 1; i <= totalLayer; i++) 
					{
						if (i < totalLayer || (i == totalLayer && reminder == 0)) 
						{
							if (i == 1) 
							{
								sb.append("<div id='tariffDivId" + i+ "' style='display:block'>");
							} 
							else 
							{
								sb.append("<div id='tariffDivId" + i+ "' style='display:none'>");
							}
		
							sb.append("<table width='100%'align='center' cellspacing='1px'>");
							for (int j = 0; j < REC_PER_PAGE; j++) 
							{
								ws.next();						
								sb.append("<tr class='style_x'>");
								
								if(ws.getString(6).equals("1"))
								{
									sb.append("<td class='multiControlSmall' width='3%'><input type='radio' name='strCrNo' value='"+ws.getString(5)+"' </td>");
							
									if(!voObj.getStrValue1().equals("7"))
									{
										sb.append("<td class='multiControlSmall' width='18%' >"+ws.getString(5)+"</td>");								
									}
									sb.append("<td class='multiControlSmallLeft' width='23%'>"+ws.getString(4)+"</td>");
									sb.append("<td class='multiControlSmall' width='24%'>"+ws.getString(2)+"</td>");
									sb.append("<td class='multiControlSmallLeft' width='20%'>"+ws.getString(3)+"</td>");
									sb.append("<td class='multiControlSmall' width='12%'>"+ws.getString(1)+"</td>");					
								}
								else
								{
									sb.append("<td class='multiLabelSmall' width='3%'>");
									sb.append("<img onkeypress='onPressingEnter(this,event)' style='cursor: pointer;' onmouseover='Tip(\""+ws.getString(7).replace("^", "#").split("#")[2]+"\",SHADOW,true)' onmouseout='UnTip()'  src='../../hisglobal/images/info.png' align='middle'>");
									sb.append("</td>");
									
									if(!voObj.getStrValue1().equals("7"))
									{
										sb.append("<td class='multiControlSmall' width='18%' style='color:red;'>"+ws.getString(5)+"</td>");								
									}
										sb.append("<td class='multiControlSmallLeft' width='23%' style='color:red;'>"+ws.getString(4)+"</td>");
										sb.append("<td class='multiControlSmall' width='24%' style='color:red;'>"+ws.getString(2)+"</td>");
										sb.append("<td class='multiControlSmallLeft' width='20%' style='color:red;'>"+ws.getString(3)+"</td>");
										sb.append("<td class='multiControlSmall' width='12%' style='color:red;'>"+ws.getString(1)+"</td>");							
								}
								
								sb.append("</tr>");
							}
							sb.append("</table>");
							sb.append("</div>");		
						} 
						else 
						{
							if (i == 1) 
							{
								sb.append("<div id='tariffDivId" + i+ "' style='display:block'>");
							} 
							else 
							{
								sb.append("<div id='tariffDivId" + i+ "' style='display:none'>");
							}
							sb.append("<table width='100%'align='center' cellspacing='1px'>");
							for (int k = 0; k < reminder; k++) 
							{
								ws.next();						
								sb.append("<tr class='style_x'>");
								
								if(ws.getString(6).equals("1"))
								{							
									sb.append("<td class='multiControlSmall' width='3%'><input type='radio' name='strCrNo' value='"+ws.getString(5)+"'</td>");					
							
									if(!voObj.getStrValue1().equals("7"))
									{
										sb.append("<td class='multiControlSmall' width='18%'>"+ws.getString(5)+"</td>");								
									}
									sb.append("<td class='multiControlSmallLeft' width='23%'>"+ws.getString(4)+"</td>");						
									sb.append("<td class='multiControlSmall' width='24%'>"+ws.getString(2)+"</td>");						
									sb.append("<td class='multiControlSmallLeft' width='20%'>"+ws.getString(3)+"</td>");
									sb.append("<td class='multiControlSmall' width='12%'>"+ws.getString(1)+"</td>");					
								}
								else
								{							
									sb.append("<td class='multiLabelSmall' width='3%'>");
									sb.append("<img onkeypress='onPressingEnter(this,event)' style='cursor: pointer;' onmouseover='Tip(\""+ws.getString(7).replace("^", "#").split("#")[2]+"\",SHADOW,true)' onmouseout='UnTip()'  src='../../hisglobal/images/info.png' align='middle'>");
									sb.append("</td>");
									
									if(!voObj.getStrValue1().equals("7"))
									{
										sb.append("<td class='multiControlSmall' width='18%' style='color:red;'>"+ws.getString(5)+"</td>");								
									}
										sb.append("<td class='multiControlSmallLeft' width='23%' style='color:red;'>"+ws.getString(4)+"</td>");
										sb.append("<td class='multiControlSmall' width='24%' style='color:red;'>"+ws.getString(2)+"</td>");
										sb.append("<td class='multiControlSmallLeft' width='20%' style='color:red;'>"+ws.getString(3)+"</td>");
										sb.append("<td class='multiControlSmall' width='12%' style='color:red;'>"+ws.getString(1)+"</td>");							
								}				
								
								sb.append("</tr>");
							}
							sb.append("</table>");
							sb.append("</div>");
						}
					}					
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("</table>");				
				}
				else 
				{
					sb.append("<table width='100%'align='center' cellspacing='1px'>");
					sb.append("<tr><td class='multiControl'><font color='red'>No Matching Record Found</font></td></tr>");
					sb.append("</table>");
				}			
			} 
			else 
			{
				throw new Exception("Patient List WebRowSet is Null");
			}
		} 
		catch (Exception e) 
		{
			new HisException("Global Patient Listing","billing.HLPBilling.getPatientListingView()-->", e.getMessage());
		}

		return sb.toString();

}

    public static String getReceiptListingView(BillingVO voObj) {

    	StringBuffer sb = new StringBuffer("");

    	WebRowSet ws = voObj.getGblWs1();

    	try {

    		int start = Integer.parseInt(voObj.getStrValue4());
    		int actualBlockSet = Integer.parseInt(voObj.getStrValue7());

    		final int REC_PER_PAGE = Integer.parseInt(voObj.getStrValue6());
    		final int PAGE_PER_BLOCK = 10;
    		
    		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
    		int totalRecordsToManipulate = totalFetchRecord - 1;
    		
    		int previous = 1;
    		int next = 0;
    	
    		if (ws != null) {
    			
    			if(ws.size() != 0){
    				
    				
    			int actualFetchRecord = ws.size();
    			
    			if(actualBlockSet == 1) actualBlockSet = actualBlockSet + 1;
    			
    			next = ((actualBlockSet * PAGE_PER_BLOCK) - PAGE_PER_BLOCK) + 1; 
    			previous = (((actualBlockSet - 2) * PAGE_PER_BLOCK) - PAGE_PER_BLOCK) + 1; 
    				
    			if(totalFetchRecord != actualFetchRecord){
    				
    				totalFetchRecord = actualFetchRecord;
    				totalRecordsToManipulate = actualFetchRecord;
    				next = 0;					
    				
    			}
    			
    			
    			int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
    			int reminder = totalRecordsToManipulate % REC_PER_PAGE;
    							
    			
    			if (reminder > 0)
    				totalLayer = totalLayer + 1;

    		
    			
    			sb
    			.append("<table width='100%'align='center' cellspacing='1px'>");

    	sb.append("<tr>");
    	sb.append("<td class='LABEL'>&nbsp;");

    	if (start != 1){
    		sb
    				.append("<a STYLE='CURSOR:POINTER'  onClick='fetchPatientList(\""+previous+"\",\""+(actualBlockSet - 1)+"\");'> <FONT COLOR='"+strColor+"'> &lt;&lt; Previous</FONT> </a> &nbsp;");
    		
    	}
    	for (int i = 1; i <= totalLayer; i++) {
    		
    		if(i == 1){
    			sb.append("<a STYLE='CURSOR:POINTER; color:"+strColor+"' name='linId' id='linId"+i+"' onClick='layerIndexNavigator(\"" + i
    					+ "\",\"" + totalLayer + "\")'>");	
    		sb.append((i + start - 1));
    		
    		}else{
    			sb.append("<a STYLE='CURSOR:POINTER; color:"+defaultColor+"' name='linId' id='linId"+i+"' onClick='layerIndexNavigator(\"" + i
    					+ "\",\"" + totalLayer + "\")'>");
    			sb.append((i + start - 1));
    		}
    		sb.append("</a> &nbsp;");
    	}

    	if (next > 0 )
    		sb.append("<a STYLE='CURSOR:POINTER' onClick='fetchPatientList(\""+next+"\",\""+(actualBlockSet + 1)+"\");'> <FONT COLOR='"+strColor+"'> Next &gt;&gt;</FONT></a>");

    	sb.append("</td>");
    	sb.append("</tr>");
    	sb.append("</table>");
    
    	sb
    					.append("<table width='100%'align='center' cellspacing='1px'>");

    			sb.append("<tr>");
    			sb.append("<td width='4%'class='multiLabel'>");
    			sb.append("</td>");
    			
    			sb.append("<td width='18%'class='multiLabel'>CR No.");
    			sb.append("</td>");
    			
    			sb.append("<td width='20%'class='multiLabel'>Patient Name");
    			sb.append("</td>");
    			sb.append("<td width='16%'class='multiLabel'>Admission No.");
    			sb.append("</td>");
    			sb.append("<td width='16%'class='multiLabel'>Receipt No.");
    			sb.append("</td>");
    			sb.append("<td width='16%'class='multiLabel'>Receipt Date");
    			sb.append("</td>");
    			sb.append("<td width='10%'class='multiLabel'>Receipt Amount");
    			sb.append("</td>");
    			sb.append("</tr>");
    			sb.append("</table>");

    			for (int i = 1; i <= totalLayer; i++) {

    				if (i < totalLayer || (i == totalLayer && reminder == 0)) {
    					if (i == 1) {
    						sb.append("<div id='tariffDivId" + i
    								+ "' style='display:block'>");
    					} else {
    						sb.append("<div id='tariffDivId" + i
    								+ "' style='display:none'>");
    					}

    					sb
    							.append("<table width='100%'align='center' cellspacing='1px'>");
    					for (int j = 0; j < REC_PER_PAGE; j++) {
    						ws.next();
    						
    						sb.append("<tr >");
    						
    						
    							
    							sb
    							.append("<td class='multiLabel' width='4%'><input type='radio' name='strRcptNo' value='");
    					sb.append(ws.getString(7));
    					sb.append("'></td>");
    					
    					
    						sb.append("<td class='multiControl' width='18%' >");
    						sb.append(ws.getString(1));
    						sb.append("</td>");
    						
    						sb.append("<td class='multiControl' width='20%' >");
    						sb.append(ws.getString(2));
    						sb.append("</td>");
    						sb.append("<td class='multiControl' width='16%'  >");
    						sb.append(ws.getString(3));
    						sb.append("</td>");
    						sb.append("<td class='multiControl' width='16%'  >");
    						sb.append(ws.getString(4));
    						sb.append("</td>");
    						sb.append("<td class='multiControl' width='16%'  >");
    						sb.append(ws.getString(5));
    						sb.append("</td>");
    						sb.append("<td class='multiControl' width='10%'  >");
    						sb.append(ws.getString(6));
    						sb.append("</td>");
    						
    						
    					
    						
    						sb.append("</tr>");
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
    					sb
    							.append("<table width='100%'align='center' cellspacing='1px'>");
    					for (int k = 0; k < reminder; k++) {
    						ws.next();
    						
    						
    						sb.append("<tr >");
    						
    						
    							
    							sb
    							.append("<td class='multiLabel' width='4%'><input type='radio' name='strRcptNo' value='");
    					sb.append(ws.getString(7));
    					sb.append("'></td>");
    					
    					
    						sb.append("<td class='multiControl' width='18%'>");
    						sb.append(ws.getString(1));
    						sb.append("</td>");
    						
    						sb.append("<td class='multiControl' width='20%'>");
    						sb.append(ws.getString(2));
    						sb.append("</td>");
    						sb.append("<td class='multiControl' width='16%'>");
    						sb.append(ws.getString(3));
    						sb.append("</td>");
    						sb.append("<td class='multiControl' width='16%'>");
    						sb.append(ws.getString(4));
    						sb.append("</td>");
    						sb.append("<td class='multiControl' width='16%'>");
    						sb.append(ws.getString(5));
    						sb.append("</td>");
    						sb.append("<td class='multiControl' width='10%'  >");
    						sb.append(ws.getString(6));
    						sb.append("</td>");
    						
    						
    						sb.append("</tr>");
    					}
    					sb.append("</table>");
    					sb.append("</div>");

    				}

    			}
    			
    			sb.append("</td>");
    			sb.append("</tr>");

    			sb.append("</table>");
    			
    			}else {
    				sb.append("<table width='100%'align='center' cellspacing='1px'>");
    				sb.append("<tr><td class='multiControl'><font color='red'>No Matching Record Found</font></td></tr>");
    				sb.append("</table>");
    			}
    			
    			
    			
    		} else {

    			throw new Exception("Patient List WebRowSet is Null");

    		}

    	} catch (Exception e) {
    		
    	 
    		
    		new HisException("Global Patient Listing",
    				"billing.HLPBilling.getPatientListingView()-->", e
    						.getMessage());
    	}

    	return sb.toString();

    }
	public static void getCashCollectionDetailView(BillingVO voObj, HttpServletRequest _request) {
		WebRowSet ws = voObj.getGblWs1();
		
		try {

			
			if (ws != null) {
				
				if(ws.size() != 0){
					
					ws.next();
							
				
					Double netAmount=   ws.getDouble(3)+ws.getDouble(4);
				_request.setAttribute("userName",ws.getString(1));
				_request.setAttribute("totalBill", ws.getString(2));
				_request.setAttribute("recievedAmount", HisUtil.getAmountWithDecimal(ws.getDouble(3),2));
				_request.setAttribute("refundAmount", HisUtil.getAmountWithDecimal(ws.getDouble(4),2));
				_request.setAttribute("netAmount", HisUtil.getAmountWithDecimal(netAmount,2));
			
				System.out.println("recievedAmount"+ws.getDouble(3));
				
			} else {

				throw new Exception("Cash Collection WebRowSet is Null");

			}
			}
			} catch (Exception e) {
			
		 
			
			new HisException("Cash Collection Detail",
					"billing.HLPBilling.getCashCollectionDetailView()-->", e
							.getMessage());
		}

	}

	public static String getCreditLetterListComboOffline(BillingVO voObj,String ID,boolean disabled,boolean completeCombo,String hosp,String bill) //Based On CR No & Cat Code
	{
		StringBuffer sb = new StringBuffer("");
		String comboID="strCreditLetterNoId"+ID;
		String addID="addCreditLetter"+ID;
		
		if(completeCombo)//Make Combo Only when completeCombo true--Cash Online otherwise options only
		{		
			if(disabled)
				sb.append("<select class='comboMax' name='strCreditLetterNo' id='"+comboID+"' disabled> ");
			else
				sb.append("<select class='comboMax' name='strCreditLetterNo' id='"+comboID+"'> ");
		}
		
		WebRowSet ws =null;
		try 
		{	
			if(hosp.equals("2") && bill.equals("11"))
				DAObilling.getCreditLettersList1(voObj);
			else
				DAObilling.getCreditLettersList(voObj);
			ws=voObj.getCreditLetterListWS();			
			
			if (ws != null) 
			{
				if(ws.size() != 0)
				{
					//ws.next();
					if (ws!= null && ws.size() > 0) 
					{
						sb.append(new HisUtil("Billing", "HLPBilling").getOptionValue(ws, "", "", false));
						sb.append("<option value='0'>Select Value</option>");
						sb.append("</select>");
						sb.append("<img onkeypress='onPressingEnter(this,event)' id='"+addID+"' style='cursor: pointer; display:none;' onclick='addNewCreditLetter(this,1)' src='../../hisglobal/images/plus.gif' align='middle'>");
					} 
					else 
					{
						sb.append("<option value='0'>Select Value</option>");
						sb.append("</select>");
						if(ID.equals("1"))//GIVE PLUS BUTTON ON FIRST ROW ONLY. IN ONE BILL ONLY ONE CREDIT LETTER WILL BE CONSUMED.IF ALREADY CREDIT LETTER PRESENT THEN USER NOT ALLOWED TO ADD NEW LETTER							
						sb.append("<img onkeypress='onPressingEnter(this,event)' id='"+addID+"' style='cursor: pointer; display:none;' onclick='addNewCreditLetter(this,1)' src='../../hisglobal/images/plus.gif' align='middle'>");
					}				
				} 
				else 
				{
					sb.append("<option value='0'>Select Value</option>");
					sb.append("</select>");
					if(ID.equals("1"))//GIVE PLUS BUTTON ON FIRST ROW ONLY. IN ONE BILL ONLY ONE CREDIT LETTER WILL BE CONSUMED.IF ALREADY CREDIT LETTER PRESENT THEN USER NOT ALLOWED TO ADD NEW LETTER
					sb.append("<img onkeypress='onPressingEnter(this,event)' id='"+addID+"' style='cursor: pointer; display:none;' onclick='addNewCreditLetter(this,1)' src='../../hisglobal/images/plus.gif' align='middle'>");
					//throw new Exception("Cash Collection WebRowSet is Null");
				}
			}
			else
			{
				sb.append("<option value='0'>Select Value</option>");
				sb.append("</select>");
				throw new Exception("Cash Collection WebRowSet is Null");
			}
		}
		catch (Exception e) 
		{			
			new HisException("Billing","billing.HLPBilling.getCreditLetterListComboOffline()-->", e.getMessage());
		}
		

		sb.append("<input type='hidden' name='strCreditBillFlag' id='strCreditBillFlag"+ ID+ "' value='1' >");
		sb.append("<input type='hidden' name='strCreditFilePath' id='strCreditFilePath"+ ID	+ "'>");
		//sb.append("<input type='hidden' name='strCreditClientNo' id='strCreditClientNo"+ ID+ "' value='"+strCreditClientNo+"' >");
		//sb.append("<input type='hidden' name='strCreditBillStatus' id='strCreditBillStatus"+ ID	+ "' value='"+strCreditBillStatus+"' >");
		//sb.append("<input type='hidden' name='strCreditClientName' id='strCreditClientName"+ ID+ "' value='" +strCreditClientName+"' >");
		
		
		sb.append("<input type='hidden' name='strClientPatientNo' id='strClientPatientNo"	+ ID+ "'>");
		sb.append("<input type='hidden' name='strCreditBillApprovalDone' value='2' id='strCreditBillApprovalDone"	+ ID+ "'>");//Direct --No Approval
		
//		sb.append("<input type='hidden' name='strEmployeeId'>");
//		sb.append("<input type='hidden' name='strEmployeeName'>");
//		sb.append("<input type='hidden' name='strRalationId'>");
//		sb.append("<input type='hidden' name='strCardValidity'>");
		
		return sb.toString();
	}
	public static String getCreditLetterListComboEmpty(BillingVO voObj,String ID,boolean disabled,boolean completeCombo) 
	{
		StringBuffer sb = new StringBuffer("");	
		String comboID="strCreditLetterNoId"+ID;
		
		if(completeCombo)//Make Combo Only when completeCombo true--Cash Online otherwise options only
		{		
			if(disabled)
				sb.append("<select class='browser-default custom-select smallCombo' name='strCreditLetterNo' id='"+comboID+"' disabled> ");
			else
				sb.append("<select class='browser-default custom-select smallCombo' name='strCreditLetterNo' id='"+comboID+"'> ");
		}
		//sb.append("<select class='comboMax' name='strCreditLetterNo' id='"+comboID+"' disabled> ");
		sb.append("<option value='0'>Select Value</option>");
		sb.append("</select>");		
		sb.append("<input type='hidden' name='strCreditBillFlag' id='strCreditBillFlag"+ ID+ "' value='0' >");
		sb.append("<input type='hidden' name='strClientPatientNo' id='strClientPatientNo"	+ ID+ "'>");					
		sb.append("<input type='hidden' name='strCreditFilePath' id='strClientPatientNo"	+ ID+ "'>");					
		//sb.append("<input type='hidden' name='strCreditClientNo'>");					
//		sb.append("<input type='hidden' name='strEmployeeId'>");					
//		sb.append("<input type='hidden' name='strEmployeeName'>");					
//		sb.append("<input type='hidden' name='strRalationId'>");					
//		sb.append("<input type='hidden' name='strCardValidity'>");
		sb.append("<input type='hidden' name='strCreditBillApprovalDone' value='2' id='strCreditBillApprovalDone"	+ ID+ "'>");//Direct --No Approval
		return sb.toString();
	}
	public static String getCreditLetterListComboOnline(BillingVO voObj,String ID,boolean disabled,boolean completeCombo) //Based On CR No & Cat Code
	{
		StringBuffer sb = new StringBuffer("");
		String comboID="strCreditLetterNoId"+ID;
		String addID="addCreditLetter"+ID;
		
		if(completeCombo)//Make Combo Only when completeCombo true--Cash Online otherwise options only
		{		
			if(disabled)
				sb.append("<select class='comboMax' name='strCreditLetterNo' id='"+comboID+"' disabled> ");
			else
				sb.append("<select class='comboMax' name='strCreditLetterNo' id='"+comboID+"'> ");
		}
		
		WebRowSet ws =null;
		try 
		{			
			DAObilling.getCreditLettersList(voObj);
			ws=voObj.getCreditLetterListWS();			
			
			if (ws != null) 
			{
				if(ws.size() != 0)
				{
					//ws.next();
					if (ws!= null && ws.size() > 0) 
					{
						sb.append(new HisUtil("Billing", "HLPBilling").getOptionValue(ws, "", "", false));
						sb.append("<option value='0'>Select Value</option>");
						sb.append("</select>");
						sb.append("<img onkeypress='onPressingEnter(this,event)' id='"+addID+"' style='cursor: pointer; display:none;' onclick='addNewCreditLetter(this,0)' src='../../hisglobal/images/plus.gif' align='middle'>");
					} 
					else 
					{
						sb.append("<option value='0'>Select Value</option>");
						sb.append("</select>");
						if(ID.equals("1"))//GIVE PLUS BUTTON ON FIRST ROW ONLY. IN ONE BILL ONLY ONE CREDIT LETTER WILL BE CONSUMED.IF ALREADY CREDIT LETTER PRESENT THEN USER NOT ALLOWED TO ADD NEW LETTER							
						sb.append("<img onkeypress='onPressingEnter(this,event)' id='"+addID+"' style='cursor: pointer; display:none;' onclick='addNewCreditLetter(this,0)' src='../../hisglobal/images/plus.gif' align='middle'>");
					}				
				} 
				else 
				{
					sb.append("<option value='0'>Select Value</option>");
					sb.append("</select>");
					if(ID.equals("1"))//GIVE PLUS BUTTON ON FIRST ROW ONLY. IN ONE BILL ONLY ONE CREDIT LETTER WILL BE CONSUMED.IF ALREADY CREDIT LETTER PRESENT THEN USER NOT ALLOWED TO ADD NEW LETTER
					sb.append("<img onkeypress='onPressingEnter(this,event)' id='"+addID+"' style='cursor: pointer; display:none;' onclick='addNewCreditLetter(this,0)' src='../../hisglobal/images/plus.gif' align='middle'>");
					//throw new Exception("Cash Collection WebRowSet is Null");
				}
			}
			else
			{
				sb.append("<option value='0'>Select Value</option>");
				sb.append("</select>");
				throw new Exception("Cash Collection WebRowSet is Null");
			}
		}
		catch (Exception e) 
		{			
			new HisException("Billing","billing.HLPBilling.getCreditLetterListComboOnline()-->", e.getMessage());
		}
		

		sb.append("<input type='hidden' name='strCreditBillFlag' id='strCreditBillFlag"+ ID+ "' value='1' >");
		sb.append("<input type='hidden' name='strCreditFilePath' id='strCreditFilePath"+ ID	+ "'>");
		//sb.append("<input type='hidden' name='strCreditClientNo' id='strCreditClientNo"+ ID+ "' value='"+strCreditClientNo+"' >");
		//sb.append("<input type='hidden' name='strCreditBillStatus' id='strCreditBillStatus"+ ID	+ "' value='"+strCreditBillStatus+"' >");
		//sb.append("<input type='hidden' name='strCreditClientName' id='strCreditClientName"+ ID+ "' value='" +strCreditClientName+"' >");
		
		
		sb.append("<input type='hidden' name='strClientPatientNo' id='strClientPatientNo"	+ ID+ "'>");
		sb.append("<input type='hidden' name='strCreditBillApprovalDone' value='2' id='strCreditBillApprovalDone"	+ ID+ "'>");//Direct --No Approval
		
//		sb.append("<input type='hidden' name='strEmployeeId'>");
//		sb.append("<input type='hidden' name='strEmployeeName'>");
//		sb.append("<input type='hidden' name='strRalationId'>");
//		sb.append("<input type='hidden' name='strCardValidity'>");
		
		return sb.toString();
	}
	
	
	public static String getTariffCodeChargeView1(WebRowSet ws)
	{	
		StringBuffer sb = new StringBuffer("");
		String strRate = "";
		String grpid="";
		int idx=-1;
		final int LMIT_VAL = 15;
		
		sb.append("<table width='100%'>");
		
		try
		{	
			if(ws != null)
			{		
				if(ws.size() != 0)
				{			
					ws.beforeFirst();		
					sb.append("<table width='100%'  id='table_id' >");					
					sb.append("<thead>");					
					sb.append("<tr>");
					sb.append("<th class='multiLabel'>#</th><th class='multiLabel'>Tariff Code</th><th class='multiLabel'>Tariff Name</th> <th class='multiLabel'>Rate (<img src='../../hisglobal/images/INR.png'>)</th>  ");
					sb.append("</tr>");					
					sb.append("</thead>");					
					sb.append("<tbody>");
					
					
					 while(	ws.next())
					 {
						idx++;
						String trId="TRSEARCHTARIFF"+idx;
						strRate = ws.getString(1).replace("^", "#").split("#")[4];
						grpid= ws.getString(1).replace("^", "#").split("#")[1];
						sb.append("<tr id='"+trId+"'>");
						strRate = HisUtil.getAmountWithDecimal(strRate, 2);
						sb.append("<input type='hidden' name='grpid' value='"+ws.getString(1).replace("^", "#").split("#")[1]+"' id='grpid"+idx+"'>");
						sb.append("<td class='trfTd' width='5%'><input type='radio'  tabindex='1' name='strTariffVal' id='strTariffVal"+idx+"'   onkeyup='moveUpDown(event,this,"+idx+");'  class='editor-texts1'  value='"+ws.getString(1)+"' onClick='setTariffCode(this,\""+ws.getString(3)+"\");'></td>");
						sb.append("<td class='trfTd' width='15%'><input type='text'  tabindex='1' name='strtariffcode' id='strtariffcode"+idx+"' onkeyup='moveUpDown(event,this,"+idx+");' class='editor-texts1' value='"+ws.getString(3) +"' readonly><font style='display:none;'>"+ ws.getString(3) +"</font></td>");
						sb.append("<td class='trfTd' width='60%'><input type='text'  tabindex='1' name='strtariffname' id='strtariffname"+idx+"' onkeyup='moveUpDown(event,this,"+idx+");' class='editor-texts1' value='"+ ws.getString(2) +"' readonly><font style='display:none;'>"+ ws.getString(2) +"</font></td>");
						sb.append("<td class='trfTd' width='20%'><input type='text'  tabindex='1' name='strrate'      id='strrate"+idx+"'  	  onkeyup='moveUpDown(event,this,"+idx+");' class='editor-texts1' value='"+ strRate +"' readonly><font style='display:none;'>"+ strRate +"</font></td>  ");
						
						sb.append("</tr>");
											
					 }
					 
					 sb.append("</tbody></table>");					 
				}
				else
				{			
					sb.append("<div class='alert alert-danger'>NO MATCHING RECORD FOUND!...</font></div>");
				}		
			}
			else
			{
				throw new Exception("WebRowSet should not be null");
			}	
		}
		catch(Exception e)
		{		
			 new HisException("Global TariffSearch","billing.HLPBilling.getTariffCodeChargeView()-->",e.getMessage());
		}
		
		sb.append("</table>");
		
		//System.out.println(" "+sb.toString());
		
		return sb.toString();
	}
	public static String getTariffCodeChargeView3(WebRowSet ws){
		
		StringBuffer sb = new StringBuffer("");
		String strRate = "";
		
		
		final int LMIT_VAL = 15;
		
		sb.append("<table width='100%'>");
		
		try{
		
		if(ws != null){
			
			if(ws.size() != 0){
				
				ws.beforeFirst();
				
                		sb.append("<table width='100%'  id='table_id' >");
				
						sb.append("<thead>");
				
						sb.append("<tr>");
						sb.append("<th class='multiLabel'>#</th><th class='multiLabel'>Drug Code</th><th class='multiLabel'>Drug Name</th> <th class='multiLabel'>Rate (<img src='../../hisglobal/images/INR.png'>)</th>  ");
						sb.append("</tr>");
						
						sb.append("</thead>");
						
						sb.append("<tbody>");
						
						
						 while(	ws.next()){
							strRate = ws.getString(1).replace("^", "#").split("#")[4];
							
							strRate = HisUtil.getAmountWithDecimal(strRate, 2);
							
							sb.append("<tr><td class='multiControl' width='5%'><input type='radio' name='strTariffVal' value='");
							sb.append(ws.getString(1));
							sb.append("' onClick='setTariffCode(this,\""+ws.getString(3)+"^"+"107"+"\");'></td><td class='CONTROL' width='15%' >"+ws.getString(3)+"</td><td class='CONTROL' width='60%' >&nbsp;&nbsp;"+ws.getString(2)+"</td><td class='CONTROL' width='20%' >&nbsp;&nbsp;"+strRate+"</td>  ");
							sb.append("</tr>");
							
							}
								 
								 sb.append("</tbody></table>");
			}else{
				
				sb.append("<div class='alert alert-danger'>NO MATCHING RECORD FOUND!...</font></div>");
			}
			
			
		}else{
			throw new Exception("WebRowSet should not be null");
		}
		
		}catch(Exception e){
			
		 
			
			 new HisException("Global TariffSearch","billing.HLPBilling.getTariffCodeChargeView3()-->",e.getMessage());
		}
		
		sb.append("</table>");
		
		//System.out.println(" "+sb.toString());
		
		return sb.toString();
	}
	
	public static String getPatientListingView_BS(BillingVO voObj) 
    {
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = voObj.getGblWs1();

		try 
		{
	
			int start = Integer.parseInt(voObj.getStrValue4());
			int actualBlockSet = Integer.parseInt(voObj.getStrValue7());	
			final int REC_PER_PAGE = Integer.parseInt(voObj.getStrValue6());
			final int PAGE_PER_BLOCK = 10;			
			int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
			int totalRecordsToManipulate = totalFetchRecord - 1;			
			int previous = 1;
			int next = 0;
			//System.out.println("size------------"+ws.size());
			if (ws != null) {
				
				if(ws.size() != 0)
				{				
					int actualFetchRecord = ws.size();				
					if(actualBlockSet == 1) actualBlockSet = actualBlockSet + 1;
					
					next = ((actualBlockSet * PAGE_PER_BLOCK) - PAGE_PER_BLOCK) + 1; 
					previous = (((actualBlockSet - 2) * PAGE_PER_BLOCK) - PAGE_PER_BLOCK) + 1; 
						
					if(totalFetchRecord != actualFetchRecord)
					{				
						totalFetchRecord = actualFetchRecord;
						totalRecordsToManipulate = actualFetchRecord;
						next = 0;				
					}			
					
					int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
					int reminder = totalRecordsToManipulate % REC_PER_PAGE;
									
					
					if (reminder > 0)
						totalLayer = totalLayer + 1;
		
				/*	sb
							.append("<table width='100%'align='center' cellspacing='1px'>");
		
					sb.append("<tr>");
					sb.append("<td class='LABEL'>&nbsp;");
		
					if (start != 1){
						sb
								.append("<a href='#' onClick='fetchPatientList(\""+previous+"\",\""+(actualBlockSet - 1)+"\");'> &lt;&lt; Previous</a> &nbsp;");
						
					}
					for (int i = 1; i <= totalLayer; i++) {
						sb.append("<a href='#' onClick='trfCodelayerIndexNavigator(\"" + i
								+ "\",\"" + totalLayer + "\")'>" + (i + start - 1)
								+ "</a> &nbsp;");
					}
		
					if (next > 0 )
						sb.append("<a href='#' onClick='fetchPatientList(\""+next+"\",\""+(actualBlockSet + 1)+"\");'> Next &gt;&gt;</a>");
		
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("</table>");
		*/
					
					
					
					// added content 
					
					/*sb.append("<table width='100%'align='center' cellspacing='1px'>");
					sb.append("<tr>");
					sb.append("<td class='LABEL'>&nbsp;");
		
					if (start != 1)
					{
						sb.append("<a STYLE='CURSOR:POINTER'  onClick='fetchPatientList(\""+previous+"\",\""+(actualBlockSet - 1)+"\");'> <FONT COLOR='"+strColor+"'> &lt;&lt; Previous</FONT> </a> &nbsp;");
					}
					for (int i = 1; i <= totalLayer; i++) 
					{
						
						if(i == 1)
						{
							sb.append("<a STYLE='CURSOR:POINTER; color:"+strColor+"' name='linId' id='linId"+i+"' onClick='layerIndexNavigator(\"" + i
									+ "\",\"" + totalLayer + "\")'>");	
							sb.append((i + start - 1));				
						}
						else
						{
							sb.append("<a STYLE='CURSOR:POINTER; color:"+defaultColor+"' name='linId' id='linId"+i+"' onClick='layerIndexNavigator(\"" + i
									+ "\",\"" + totalLayer + "\")'>");
							sb.append((i + start - 1));
						}
						sb.append("</a> &nbsp;");
					}
		
					if (next > 0 )
						sb.append("<a STYLE='CURSOR:POINTER' onClick='fetchPatientList(\""+next+"\",\""+(actualBlockSet + 1)+"\");'> <FONT COLOR='"+strColor+"'> Next &gt;&gt;</FONT></a>");
		
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("</table>");*/
					
					sb.append("<table id='dtable' class='table table-striped' style='width:100%;line-height: 0.8;'>");
					sb.append("<thead>");
					sb.append("<tr>");
					sb.append("<th></th>");
					if(!voObj.getStrValue1().equals("7"))
					{
						sb.append("<th>CR No.</th>");			
					}
					sb.append("<th>Patient Name</th>");
					sb.append("<th>Hospital Service</th>");
					sb.append("<th>Request Type</th>");
					sb.append("<th>Request Date</th>");
					sb.append("</tr>");
					sb.append("</thead>");
					sb.append("<tbody>");
					for (int i = 1; i <= totalLayer; i++) 
					{
						if (i < totalLayer || (i == totalLayer && reminder == 0)) 
						{
							if (i == 1) 
							{
								sb.append("<div id='tariffDivId" + i+ "' style='display:block'>");
							} 
							else 
							{
								sb.append("<div id='tariffDivId" + i+ "' style='display:none'>");
							}
		
							//sb.append("<table width='100%'align='center' cellspacing='1px'>");
							
							for (int j = 0; j < REC_PER_PAGE; j++) 
							{
								ws.next();						
								sb.append("<tr>");
								//System.out.println("ws.getString(6)------------"+ws.getString(6));
								//System.out.println("voObj.getStrValue1()------------"+voObj.getStrValue1());
								
								if(ws.getString(6).equals("1"))
								{
									sb.append("<td width='3%'><label class='container'><input type='radio' name='strCrNoBs' value='"+ws.getString(5)+"'");
									sb.append("' onclick='setCrNoModal();'><span class='checkmark'></span></label></td>");
							
									if(!voObj.getStrValue1().equals("7"))
									{
										sb.append("<td>"+ws.getString(5)+"</td>");								
									}
									sb.append("<td>"+ws.getString(4)+"</td>");
									sb.append("<td>"+ws.getString(2)+"</td>");
									sb.append("<td>"+ws.getString(3)+"</td>");
									sb.append("<td>"+ws.getString(1)+"</td>");					
								}
								else
								{
									sb.append("<td width='3%'>");
									sb.append("<img onkeypress='onPressingEnter(this,event)' style='cursor: pointer;' onmouseover='Tip(\""+ws.getString(7).replace("^", "#").split("#")[2]+"\",SHADOW,true)' onmouseout='UnTip()'  src='../../hisglobal/images/info.png' align='middle'>");
									sb.append("</td>");
									
									if(!voObj.getStrValue1().equals("7"))
									{
										sb.append("<td>"+ws.getString(5)+"</td>");								
									}
										sb.append("<td>"+ws.getString(4)+"</td>");
										sb.append("<td>"+ws.getString(2)+"</td>");
										sb.append("<td>"+ws.getString(3)+"</td>");
										sb.append("<td>"+ws.getString(1)+"</td>");							
								}
								
								sb.append("</tr>");
							}
							
							//sb.append("</table>");
							sb.append("</div>");		
						} 
						else 
						{
							if (i == 1) 
							{
								sb.append("<div id='tariffDivId" + i+ "' style='display:block'>");
							} 
							else 
							{
								sb.append("<div id='tariffDivId" + i+ "' style='display:none'>");
							}
							//sb.append("<table width='100%'align='center' cellspacing='1px'>");
							
							for (int k = 0; k < reminder; k++) 
							{
								ws.next();						
								sb.append("<tr>");
								
								if(ws.getString(6).equals("1"))
								{							
									sb.append("<td width='3%'><label class='container'><input type='radio' name='strCrNoBs' value='"+ws.getString(5)+"'");	
									sb.append("' onclick='setCrNoModal();'><span class='checkmark'></span></label></td>");
							
									if(!voObj.getStrValue1().equals("7"))
									{
										sb.append("<td>"+ws.getString(5)+"</td>");								
									}
									sb.append("<td>"+ws.getString(4)+"</td>");						
									sb.append("<td>"+ws.getString(2)+"</td>");						
									sb.append("<td>"+ws.getString(3)+"</td>");
									sb.append("<td>"+ws.getString(1)+"</td>");					
								}
								else
								{							
									sb.append("<td width='3%'>");
									sb.append("<img onkeypress='onPressingEnter(this,event)' style='cursor: pointer;' onmouseover='Tip(\""+ws.getString(7).replace("^", "#").split("#")[2]+"\",SHADOW,true)' onmouseout='UnTip()'  src='../../hisglobal/images/info.png' align='middle'>");
									sb.append("</td>");
									
									if(!voObj.getStrValue1().equals("7"))
									{
										sb.append("<td>"+ws.getString(5)+"</td>");								
									}
										sb.append("<td>"+ws.getString(4)+"</td>");
										sb.append("<td>"+ws.getString(2)+"</td>");
										sb.append("<td>"+ws.getString(3)+"</td>");
										sb.append("<td>"+ws.getString(1)+"</td>");							
								}				
								
								sb.append("</tr>");
							}
							
							//sb.append("</table>");
							sb.append("</div>");
						}
					}					
					//sb.append("</td>");
					//sb.append("</tr>");
					sb.append("</tbody>");
					sb.append("</table>");				
				}
				else 
				{
					sb.append("<div class='alert alert-danger'>No Matching Record Found</font></div>");
				}			
			} 
			else 
			{
				throw new Exception("Patient List WebRowSet is Null");
			}
			
			  sb.append("<script>"); sb.append("modalDataTable();");
			  sb.append("</script>");
			 
		} 
		catch (Exception e) 
		{
			new HisException("Global Patient Listing","billing.HLPBilling.getPatientListingView()-->", e.getMessage());
		}

		return sb.toString();

}
	
	public static String getCreditLetterListComboOffline_BS(BillingVO voObj,String ID,boolean disabled,boolean completeCombo,String hosp,String bill) //Based On CR No & Cat Code
	{
		StringBuffer sb = new StringBuffer("");
		String comboID="strCreditLetterNoId"+ID;
		String addID="addCreditLetter"+ID;
		
		if(completeCombo)//Make Combo Only when completeCombo true--Cash Online otherwise options only
		{		
			if(disabled)
				sb.append("<select class='browser-default custom-select' name='strCreditLetterNo' id='"+comboID+"' disabled> ");
			else
				sb.append("<select class='browser-default custom-select' name='strCreditLetterNo' id='"+comboID+"'> ");
		}
		
		WebRowSet ws =null;
		try 
		{	
			if(hosp.equals("2") && bill.equals("11"))
				DAObilling.getCreditLettersList1(voObj);
			else
				DAObilling.getCreditLettersList(voObj);
			ws=voObj.getCreditLetterListWS();			
			
			if (ws != null) 
			{
				if(ws.size() != 0)
				{
					//ws.next();
					if (ws!= null && ws.size() > 0) 
					{
						sb.append(new HisUtil("Billing", "HLPBilling").getOptionValue(ws, "", "", false));
						sb.append("<option value='0'>Select Value</option>");
						sb.append("</select>");
						sb.append("<img onkeypress='onPressingEnter(this,event)' id='"+addID+"' style='cursor: pointer; display:none;' onclick='addNewCreditLetter(this,1)' src='../../hisglobal/images/plus.gif' align='middle'>");
					} 
					else 
					{
						sb.append("<option value='0'>Select Value</option>");
						sb.append("</select>");
						if(ID.equals("1"))//GIVE PLUS BUTTON ON FIRST ROW ONLY. IN ONE BILL ONLY ONE CREDIT LETTER WILL BE CONSUMED.IF ALREADY CREDIT LETTER PRESENT THEN USER NOT ALLOWED TO ADD NEW LETTER							
						sb.append("<img onkeypress='onPressingEnter(this,event)' id='"+addID+"' style='cursor: pointer; display:none;' onclick='addNewCreditLetter(this,1)' src='../../hisglobal/images/plus.gif' align='middle'>");
					}				
				} 
				else 
				{
					sb.append("<option value='0'>Select Value</option>");
					sb.append("</select>");
					if(ID.equals("1"))//GIVE PLUS BUTTON ON FIRST ROW ONLY. IN ONE BILL ONLY ONE CREDIT LETTER WILL BE CONSUMED.IF ALREADY CREDIT LETTER PRESENT THEN USER NOT ALLOWED TO ADD NEW LETTER
					sb.append("<img onkeypress='onPressingEnter(this,event)' id='"+addID+"' style='cursor: pointer; display:none;' onclick='addNewCreditLetter(this,1)' src='../../hisglobal/images/plus.gif' align='middle'>");
					//throw new Exception("Cash Collection WebRowSet is Null");
				}
			}
			else
			{
				sb.append("<option value='0'>Select Value</option>");
				sb.append("</select>");
				throw new Exception("Cash Collection WebRowSet is Null");
			}
		}
		catch (Exception e) 
		{			
			new HisException("Billing","billing.HLPBilling.getCreditLetterListComboOffline_BS()-->", e.getMessage());
		}
		sb.append("<input type='hidden' name='strCreditBillFlag' id='strCreditBillFlag"+ ID+ "' value='1' >");
		sb.append("<input type='hidden' name='strCreditFilePath' id='strCreditFilePath"+ ID	+ "'>");
		sb.append("<input type='hidden' name='strClientPatientNo' id='strClientPatientNo"	+ ID+ "'>");
		sb.append("<input type='hidden' name='strCreditBillApprovalDone' value='2' id='strCreditBillApprovalDone"	+ ID+ "'>");//Direct --No Approval
		
		return sb.toString();
	}

}
