package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.ApprovalDtlHlpBO;
import mms.transactions.vo.ApprovalDtlHlpVO;
/**
 * @author Amit Kumar
 * Date of Creation : 4/6/2009
 * Date of Modification :  /  / 2009
 * Version : 1.0
 * Module  : Store
 * Description : ApprovalDtlHLP file used globally to provide Approval Details
 *               for Specific Request Type.
 */


public class ApprovalDtlHLP 
{
	public static String getApprovalDtlPrint(String strFrmStoreId,String strHospCode,String strToStoreId,String strItemCatgCode,String strReqTypeId,String strReqNo) throws IOException 
	  {
		 /* Creating VO & BO Object Here */
		 ApprovalDtlHlpVO vo = new ApprovalDtlHlpVO();
		 ApprovalDtlHlpBO bo = new ApprovalDtlHlpBO();
		 /* Declaring Variable */
		 StringBuffer sb = new StringBuffer("");
		 String strLevelType     = "";
		 String strApplyClass    = "";
		 String strAuthorityName = "";
		 String strLevel         = "";
		 String strApprovalDate  = "";
		 WebRowSet ws = null;
		 WebRowSet ws1 = null;	
		 int i=0,j=0,k=0,l=0;
		
//		 System.out.println("From Store Id-->>"+strFrmStoreId);
//		 System.out.println("Hsp Code-->>"+strHospCode);
//		 System.out.println("Item Catg Id-->>"+strItemCatgCode);
//		 System.out.println("Req No-->>"+strReqNo);
//		 System.out.println("Req  Type Id-->>"+strReqTypeId);	
//		 System.out.println("To Store Id-->>"+strToStoreId);
		
		 
		 /* Setting Value in vo Object */
		 vo.setStrFrmStoreId(strFrmStoreId);
		 vo.setStrHospCode(strHospCode);
		 vo.setStrItemCatgCode(strItemCatgCode);
		 vo.setStrReqNo(strReqNo);
		 vo.setStrReqTypeId(strReqTypeId);
		 vo.setStrToStoreId(strToStoreId);
		 
		 System.out.println("<<--------------ApprovalDtlHLP.getApprovalDtlPrint------------->>");
		
		 /* Calling BO Method  */
		 bo.getApprovalDtlLevel1(vo);
		
		 if(!strToStoreId.equals("0"))
		 {	
		   bo.getApprovalDtlLevel2(vo);
		 }  
		
		  ws = vo.getGblWs1();
		 ws1 = vo.getGblWs2();
		 
		  /* sb.append("<table width='825' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
		 
		   sb.append("<tr bgcolor='#cdc9c9'> ");
			
			sb.append("<td align='center' width='35%'><font face='Verdana, Arial, Helvetica, sans-serif' >Authority Name</font> ");
			sb.append("</td>");			
		
			sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >Level</font>");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >Approval Date</font> ");
			sb.append("</td> ");			
		
			sb.append("</tr> "); */
		 
		     sb.append("<table width='825' align='center' cellpadding='1' cellspacing='1' border='0' style='font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px;'>");
			 sb.append("<tr bgcolor='#cdc9c9'>");
			 sb.append("<td align='center' width='35%'><b>Authority Name</b></td>");
			 sb.append("<td align='center' width='25%'><b>Level</b></td>");
			 sb.append("<td align='center' width='25%'><b>Approval Date</b></td>");
			 sb.append("</tr>");
			
			
		  try 
		   {
			  
			  if(vo.getStrMsgType().equals("0"))
			  {
				  if (ws != null && ws.size() != 0) 
					  
				  {				     	
					 for(i=0;ws.next();i++)
	                 {
					    	
						       strLevelType     = ws.getString(1).trim();
						       strAuthorityName = ws.getString(2).trim(); 
	 					       strLevel         = ws.getString(3).trim();
	 						   strApprovalDate  = ws.getString(4).trim();

	 						   if(strApprovalDate.equals("-")) 
		  				       {
		  				    	 strApplyClass = "Approved";				    	   
		  				       }
		  				       else
		  				       {
		  				    	 strApplyClass = "NotApproved";    				    	   
		  				       }	 
						        if(strLevelType.equals("Raising Level"))
		  				        {
						        	
						        	if(i==0)
						        	{	
								
								/*
								 * sb.append("<tr>"); sb.
								 * append("<td align='center' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>Approval Level</b></font></td> "
								 * ); sb.append("</tr>");
								 */
								 
						        	} 
		  					      	
		  											
		  						    if(strAuthorityName == null || strAuthorityName.equals("")) strAuthorityName = "-----";
		  	  				        if(strLevel == null || strLevel.equals("")) strLevel = "-----";
		  	  				        if(strApprovalDate == null || strApprovalDate.equals("")) strApprovalDate = "-----"; 
		  	                      
		  					    /*
								    sb.append("<tr>");
								    sb.append("<td width='35%' class='"+strApplyClass+"'>");
								    sb.append(strAuthorityName);
								    sb.append("</td>");
								    sb.append("<td width='25%' class='"+strApplyClass+"'>");
								    sb.append(strLevel);
								    sb.append("</td>");
								    sb.append("<td width='25%' class='"+strApplyClass+"'>");
								    sb.append(strApprovalDate);
								    sb.append("</td>");
								    sb.append("</tr>");
								    sb.append("<tr>"); */
		  	  				        
		  	  				        sb.append("<tr>");
								    sb.append("<td  align='center'  width='35%' class='" + strApplyClass + "'><font style='font-size: 12px;'>");
								    sb.append(strAuthorityName);
								    sb.append("</font></td>");

								    sb.append("<td  align='center' width='25%' class='" + strApplyClass + "'><font style='font-size: 12px;'>");
								    sb.append(strLevel);
								    sb.append("</font></td>");

								    sb.append("<td  align='center' width='25%' class='" + strApplyClass + "'><font style='font-size: 12px;'>");
								    sb.append(strApprovalDate);
								    sb.append("</font></td>");

								    sb.append("</tr>");

		  	                      
		  				        }
						        else
		  				        {	
						        	if(k==0)
						        	{	
						        	  //sb.append("<tr><td  colspan='3' class='CONTROL'><b>Admin Level(Raising) 1</b></td></tr>");
						        		
								/*
								 * sb.append("<tr>"); sb.
								 * append("<td align='center' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>Approval Level</b></font></td> "
								 * ); sb.append("</tr>");
								 */
						        	 } 
		  				        	 	k++;  	  					    	 											
		  						        if(strAuthorityName == null || strAuthorityName.equals("")) strAuthorityName = "-----";
		  	  				            if(strLevel == null || strLevel.equals("")) strLevel = "-----";
		  	  				            if(strApprovalDate == null || strApprovalDate.equals("")|| strApprovalDate.equals("----")) strApprovalDate = "-----"; 
		                     /*
		  	  				         sb.append("<tr>");
		  							 sb.append("<td class='"+strApplyClass+"' width='35%' >");
		  							 sb.append(strAuthorityName);
		  							 sb.append("</td>");
		  							 sb.append("<td width='25%' class='"+strApplyClass+"'>");
		  							 sb.append(strLevel);
		  							 sb.append("</td>");
		  							 sb.append("<td width='25%' class='"+strApplyClass+"'>");
		  							 sb.append(strApprovalDate);
		  							 sb.append("</td>");
		  							 sb.append("</tr>"); */
		  	  				            
		  	  				        sb.append("<tr>");
			  	  				        sb.append("<td  align='center' width='35%' class='" + strApplyClass + "'><font style='font-size: 12px;'>");
									    sb.append(strAuthorityName);
									    sb.append("</font></td>");
	
									    sb.append("<td  align='center' width='25%' class='" + strApplyClass + "'><font style='font-size: 12px;'>");
									    sb.append(strLevel);
									    sb.append("</font></td>");
	
									    sb.append("<td  align='center' width='25%' class='" + strApplyClass + "'><font style='font-size: 12px;'>");
									    sb.append(strApprovalDate);
									    sb.append("</font></td>");
								    sb.append("</tr>");
		  	                         
		  				        }
	                      }
				      }	
				      else
				      {
				    	  if(i==0)
				    	  {	  
				    	     //sb.append("<tr><td colspan='3' class='multiControl'><font color='red'>No Record Found For Raising Level 1</font></td></tr>");
				    	     sb.append("<tr>");		  				              
	  				         sb.append("<td align='center' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >No Record Found For Approval Level</font></td> ");
	  				         sb.append("</tr>");
				    	  }
				    	  if(k==0)
				    	  {
				    		 // sb.append("<tr><td colspan='3' class='multiControl'><font color='red'>No Record Found For Raising Admin (Level 1)</font></td></tr>");
				    		  sb.append("<tr>");		  				              
		  				      sb.append("<td align='center' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >No Record Found For Approval Level</font></td> ");
		  				      sb.append("</tr>");
				    	  }	  
		 			     
				      } 	 
			    }
			  else
			  {
					  String err = vo.getStrMsgString();   
					  sb.append("ERROR####"+err);   
					
			   }     
			  
			 }
			 catch (SQLException e) 
	         {
				 e.printStackTrace();
					new HisException("IndentViewTransaction","ApprovalDtlHLP .getApprovalDtlPrint() -->",e.getMessage());
			 }
			/*try 
			{
				if(vo.getStrMsgType().equals("0"))
				{
					  if (ws1 != null && ws1.size() != 0) 
					  {				     	
						    for(j=0;ws1.next();i++)
		                    {
						     
							       strLevelType     = ws1.getString(1).trim();
							       strApprovalDate  = ws1.getString(4).trim();
							       //System.out.println("strLevelType in 2"+strLevelType);
							       //System.out.println("strApprovalDate in 2"+strApprovalDate);
							       if(strApprovalDate.equals("-")) 
			  				       {
			  				    	 strApplyClass = "Approved";				    	   
			  				       }
			  				       else
			  				       {
			  				    	 strApplyClass = "NotApproved";    				    	   
			  				       }	 
							        if(strLevelType.equals("Recieving Level"))
			  				        {
							        	if(j==0)
							        	{	
			  				             //sb.append("<tr><td  colspan='3' class='CONTROL'><b>Approval Level 2</td></tr>");
			  				             sb.append("<tr>");		  				              
				  				         sb.append("<td align='center' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>Approval Level</b></font></td> ");
				  				         sb.append("</tr>");
							        	} 
			  					      	strAuthorityName = ws1.getString(2); 
			  					    	strLevel         = ws1.getString(3);
			  							strApprovalDate  = ws1.getString(4);
			  											
			  						    if(strAuthorityName == null || strAuthorityName.equals("")) strAuthorityName = "-----";
			  	  				        if(strLevel == null || strLevel.equals("")) strLevel = "-----";
			  	  				        if(strApprovalDate == null || strApprovalDate.equals("")|| strApprovalDate.equals("-")) strApprovalDate = "-----"; 
			  	                      
			  					    
									    sb.append("<tr>");
									 
									    sb.append("<td width='35%' class='"+strApplyClass+"'>");
									    sb.append(strAuthorityName);
									    sb.append("</td>");
									    sb.append("<td width='25%' class='"+strApplyClass+"'>");
									    sb.append(strLevel);
									    sb.append("</td>");
									    sb.append("<td width='25%' class='"+strApplyClass+"'>");
									    sb.append(strApprovalDate);
									    sb.append("</td>");
									    sb.append("</tr>");
			  	                      
			  				        }
							        else
			  				        {	
							        	
			  				        	if(l==0)
			  				        	{	
			  	  					     //sb.append("<tr><td  colspan='3' class='CONTROL'><b>Admin Level(Recieving) 2</b></td></tr>");
			  	  					     sb.append("<tr>");		  				              
				  				         sb.append("<td align='center' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>Approval Level</b></font></td> ");
				  				         sb.append("</tr>");
			  				        	}
			  				        	l++;
			  	  					    	strAuthorityName = ws1.getString(2);  
			  					    	    strLevel         = ws1.getString(3);
			  							    strApprovalDate  = ws1.getString(4);
			  											
			  						        if(strAuthorityName == null || strAuthorityName.equals("")) strAuthorityName = "-----";
			  	  				            if(strLevel == null || strLevel.equals("")) strLevel = "-----";
			  	  				            if(strApprovalDate == null || strApprovalDate.equals("")|| strApprovalDate.equals("-")) strApprovalDate = "-----"; 
			                     
			  	  				         sb.append("<tr>");
			  							 sb.append("<td class='"+strApplyClass+"' width='35%' >");
			  							 sb.append(strAuthorityName);
			  							 sb.append("</td>");
			  							 sb.append("<td width='25%' class='"+strApplyClass+"'>");
			  							 sb.append(strLevel);
			  							 sb.append("</td>");
			  							 sb.append("<td width='25%' class='"+strApplyClass+"'>");
			  							 sb.append(strApprovalDate);
			  							 sb.append("</td>");
			  							 sb.append("</tr>");
			  	                         
			  				        }
						        }
						  }	
					      else
					      {
					    	  if(j==0)
					    	  {	  
					    	     //sb.append("<tr><td colspan='3' class='multiControl'><font color='red'>No Record Found For Recieving Level 2</font></td></tr>");
					    		     sb.append("<tr>");		  				              
			  				         sb.append("<td align='center' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>Approval Level</b></font></td> ");
			  				         sb.append("</tr>");
					    	  }
					    	  if(l==0)
					    	  {
					    		  //sb.append("<tr><td colspan='3' class='multiControl'><font color='red'>No Record Found For Recieving Admin (Level 2)</font></td></tr>");  
					    		  sb.append("<tr>");		  				              
			  				         sb.append("<td align='center' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>Approval Level</b></font></td> ");
			  				         sb.append("</tr>");
					    	  }	  
			 			     
					      } 	 
				    }
				  else
				  {
						  String err = vo.getStrMsgString();   
						  sb.append("ERROR####"+err);   
						
				   }     
				  
			  }
	          catch (SQLException e) 
	          {
	        	  e.printStackTrace();
				new HisException(
						"IndentViewTransaction",
						"ApprovalDtlHLP.getApprovalDtlPrint() -->",
						e.getMessage());
			   }
			   */
	          
		    
		    sb.append("</table>");
		 
			return sb.toString();
  }
	
	public static String getApprovalDtl(String strFrmStoreId,String strHospCode,String strToStoreId,String strItemCatgCode,String strReqTypeId,String strReqNo) throws IOException 
	  {
		 /* Creating VO & BO Object Here */
		 ApprovalDtlHlpVO vo = new ApprovalDtlHlpVO();
		 ApprovalDtlHlpBO bo = new ApprovalDtlHlpBO();
		 /* Declaring Variable */
		 StringBuffer sb = new StringBuffer("");
		 String strLevelType     = "";
		 String strApplyClass    = "";
		 String strAuthorityName = "";
		 String strLevel         = "";
		 String strApprovalDate  = "";
		 WebRowSet ws = null;
		 WebRowSet ws1 = null;	
		 int i=0,j=0,k=0,l=0;
		
//		 System.out.println("From Store Id-->>"+strFrmStoreId);
//		 System.out.println("Hsp Code-->>"+strHospCode);
//		 System.out.println("Item Catg Id-->>"+strItemCatgCode);
//		 System.out.println("Req No-->>"+strReqNo);
//		 System.out.println("Req  Type Id-->>"+strReqTypeId);	
//		 System.out.println("To Store Id-->>"+strToStoreId);
		
		 
		 /* Setting Value in vo Object */
		 vo.setStrFrmStoreId(strFrmStoreId);
		 vo.setStrHospCode(strHospCode);
		 vo.setStrItemCatgCode(strItemCatgCode);
		 vo.setStrReqNo(strReqNo);
		 vo.setStrReqTypeId(strReqTypeId);
		 vo.setStrToStoreId(strToStoreId);
		 
		 System.out.println("<<--------------ApprovalDtlHLP.getApprovalDtl------------->>");
		
		 /* Calling BO Method  */
		 bo.getApprovalDtlLevel1(vo);
		
		 if(!strToStoreId.equals("0"))
		 {	
		   bo.getApprovalDtlLevel2(vo);
		 }  
		
		  ws = vo.getGblWs1();
		  ws1 = vo.getGblWs2();
		 
		   sb.append("<table class='table'>"); 
		   sb.append("<thead class='thead-dark'>"); 
		   sb.append("<tr><th width='40%' style='font-weight:350 !important ;font-size: 16px !important;' >Authority Name</th>");
		   sb.append("<th     width='30%' style='font-weight:350 !important ;font-size: 16px !important;' >Level</th>");
		   sb.append("<th     width='30%' style='font-weight:350 !important ;font-size: 16px !important;' >Approval Date</th></thead></tr>");
		  try 
		   {
			  
			  if(vo.getStrMsgType().equals("0"))
			  {
				  if (ws != null && ws.size() != 0) 
				  {				     	
					 for(i=0;ws.next();i++)
	                 {
					    	 
						       strLevelType     = ws.getString(1).trim();
						       strAuthorityName = ws.getString(2).trim(); 
	 					       strLevel         = ws.getString(3).trim();
	 						   strApprovalDate  = ws.getString(4).trim();

	 						   if(strApprovalDate.equals("-")) 
		  				       {
		  				    	 strApplyClass = "Approved";				    	   
		  				       }
		  				       else
		  				       {
		  				    	 strApplyClass = "NotApproved";    				    	   
		  				       }	 
						        if(strLevelType.equals("Raising Level"))
		  				        {
						        	
						        	/*RJif(i==0)
						        	{	
		  				              sb.append("<tr>"); 
		  				              sb.append("<td align='center' colspan='3' style='font-weight:350 !important ;font-size: 15px !important;'><font face='Verdana, Arial, Helvetica, sans-serif' size='2' ><b>Approval Level</b></font></td>"); 
		  				              sb.append("</tr>");
						        	} */
		  					      	
		  											
		  						    if(strAuthorityName == null || strAuthorityName.equals("")) strAuthorityName = "-----";
		  	  				        if(strLevel == null || strLevel.equals("")) strLevel = "-----";
		  	  				        if(strApprovalDate == null || strApprovalDate.equals("")) strApprovalDate = "-----"; 
		  	                      
		  					    
								    sb.append("<tr>");
								    sb.append("<td align='center' width='40%' style='font-weight:350 !important ;font-size: 15px !important;'>");
								    sb.append(strAuthorityName);
								    sb.append("</td>");
								    sb.append("<td align='center' width='30%' style='font-weight:350 !important ;font-size: 15px !important;'>");
								    sb.append(strLevel);
								    sb.append("</td>");
								    sb.append("<td align='center' width='30%' style='font-weight:350 !important ;font-size: 15px !important;'>");
								    sb.append(strApprovalDate);
								    sb.append("</td>");
								    sb.append("</tr>");
		  	                      
		  				        }
						        else
		  				        {	
						        	if(k==0)
						        	{	
						        	  sb.append("<tr><td  colspan='3' style='font-weight:350 !important ;font-size: 15px !important;'>Admin Level(Raising) 1</td></tr>");
						        	 } 
		  				        	 	k++;  	  					    	 											
		  						        if(strAuthorityName == null || strAuthorityName.equals("")) strAuthorityName = "-----";
		  	  				            if(strLevel == null || strLevel.equals("")) strLevel = "-----";
		  	  				            if(strApprovalDate == null || strApprovalDate.equals("")|| strApprovalDate.equals("----")) strApprovalDate = "-----"; 
		                     
		  	  				         sb.append("<tr>");
		  							 sb.append("<td align='center'   width='40%' style='font-weight:350 !important ;font-size: 15px !important;' >");
		  							 sb.append(strAuthorityName);
		  							 sb.append("</td>");
		  							 sb.append("<td align='center' width='30%' style='font-weight:350 !important ;font-size: 15px !important;'>");
		  							 sb.append(strLevel);
		  							 sb.append("</td>");
		  							 sb.append("<td align='center' width='30%' style='font-weight:350 !important ;font-size: 15px !important;'>");
		  							 sb.append(strApprovalDate);
		  							 sb.append("</td>");
		  							 sb.append("</tr>");
		  	                         
		  				        }
	                      }
				      }	
				      else
				      {
				    	  if(i==0)
				    	  {	  
					    	 sb.append("<tr><td colspan='3' align='center' style='font-weight:350 !important ;font-size: 15px !important;'><font color='red'>No Record Found For Raising Level 1</font></td></tr>");

				    	  }
				    	  if(k==0)
				    	  {
					    	 sb.append("<tr><td colspan='3' align='center' style='font-weight:350 !important ;font-size: 15px !important;'><font color='red'>No Record Found For Raising Admin (Level 1)</font></td></tr>");
				    	  }	  
		 			     
				      } 	 
			    }
			  else
			  {
					  String err = vo.getStrMsgString();   
					  sb.append("ERROR####"+err);   
					
			   }     
			  
			 }
			 catch (SQLException e) 
	         {
				 e.printStackTrace();
					new HisException("IndentViewTransaction","ApprovalDtlHLP .getApprovalDtl() -->",e.getMessage());
			 }
			try 
			{
				if(vo.getStrMsgType().equals("0"))
				{
					  if (ws1 != null && ws1.size() != 0) 
					  {				     	
						    for(j=0;ws1.next();i++)
		                    {
						     
							       strLevelType     = ws1.getString(1).trim();
							       strApprovalDate  = ws1.getString(4).trim();
							       //System.out.println("strLevelType in 2"+strLevelType);
							       //System.out.println("strApprovalDate in 2"+strApprovalDate);
							       if(strApprovalDate.equals("-")) 
			  				       {
			  				    	 strApplyClass = "Approved";				    	   
			  				       }
			  				       else
			  				       {
			  				    	 strApplyClass = "NotApproved";    				    	   
			  				       }	 
							        if(strLevelType.equals("Recieving Level"))
			  				        {
							        	if(j==0)
							        	{	
			  				             sb.append("<tr><td  colspan='3' style='font-weight:350 !important ;font-size: 15px !important;'>Approval Level 2</td></tr>");
							        	} 
			  					      	strAuthorityName = ws1.getString(2); 
			  					    	strLevel         = ws1.getString(3);
			  							strApprovalDate  = ws1.getString(4);
			  											
			  						    if(strAuthorityName == null || strAuthorityName.equals("")) strAuthorityName = "-----";
			  	  				        if(strLevel == null || strLevel.equals("")) strLevel = "-----";
			  	  				        if(strApprovalDate == null || strApprovalDate.equals("")|| strApprovalDate.equals("-")) strApprovalDate = "-----"; 
			  	                      

			  	  				         sb.append("<tr>");
			  							 sb.append("<td align='center'   width='40%' style='font-weight:350 !important ;font-size: 15px !important;' >");
			  							 sb.append(strAuthorityName);
			  							 sb.append("</td>");
			  							 sb.append("<td align='center' width='30%' style='font-weight:350 !important ;font-size: 15px !important;'>");
			  							 sb.append(strLevel);
			  							 sb.append("</td>");
			  							 sb.append("<td align='center' width='30%' style='font-weight:350 !important ;font-size: 15px !important;'>");
			  							 sb.append(strApprovalDate);
			  							 sb.append("</td>");
			  							 sb.append("</tr>");
			  	                      
			  				        }
							        else
			  				        {	
							        	
			  				        	if(l==0)
			  				        	{	
			  	  					      sb.append("<tr><td  colspan='3' style='font-weight:350 !important ;font-size: 15px !important;'>Admin Level(Recieving) 2</td></tr>");
			  				        	}
			  				        	l++;
			  	  					    	strAuthorityName = ws1.getString(2);  
			  					    	    strLevel         = ws1.getString(3);
			  							    strApprovalDate  = ws1.getString(4);
			  											
			  						        if(strAuthorityName == null || strAuthorityName.equals("")) strAuthorityName = "-----";
			  	  				            if(strLevel == null || strLevel.equals("")) strLevel = "-----";
			  	  				            if(strApprovalDate == null || strApprovalDate.equals("")|| strApprovalDate.equals("-")) strApprovalDate = "-----"; 
			                     
			  	  				         sb.append("<tr>");
			  							 sb.append("<td width='40%'  align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
			  							 sb.append(strAuthorityName);
			  							 sb.append("</td>");
			  							 sb.append("<td  width='30%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
			  							 sb.append(strLevel);
			  							 sb.append("</td>");
			  							 sb.append("<td  width='30%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
			  							 sb.append(strApprovalDate);
			  							 sb.append("</td>");
			  							 sb.append("</tr>");
			  				        }
						        }
						  }	
					      else
					      {
					    	 /*RJ if(j==0)
					    	  {	  
						    	  sb.append("<tr><td colspan='3' align='center' style='font-weight:350 !important ;font-size: 15px !important;'><font color='red'>No Record Found For Recieving Level 2</font></td></tr>");
					    	  }
					    	  if(l==0)
					    	  {
						    	  sb.append("<tr><td colspan='3' align='center' style='font-weight:350 !important ;font-size: 15px !important;'><font color='red'>No Record Found For Recieving Admin (Level 2)</font></td></tr>");
	
					    	  }	 */ 
			 			     
					      } 	 
				    }
				  else
				  {
						  String err = vo.getStrMsgString();   
						  sb.append("ERROR####"+err);   
						
				   }     
				  
			  }
	          catch (SQLException e) 
	          {
	        	  e.printStackTrace();
				new HisException(
						"IndentViewTransaction",
						"ApprovalDtlHLP.getApprovalDtl() -->",
						e.getMessage());
			   }
	          
		    
		    sb.append("</table>");
		 
			return sb.toString();
		}	
	  	
    public static String getApprovalDtlBS(String strFrmStoreId,String strHospCode,String strToStoreId,String strItemCatgCode,String strReqTypeId,String strReqNo) throws IOException 
  {
	 /* Creating VO & BO Object Here */
	 ApprovalDtlHlpVO vo = new ApprovalDtlHlpVO();
	 ApprovalDtlHlpBO bo = new ApprovalDtlHlpBO();
	 /* Declaring Variable */
	 StringBuffer sb = new StringBuffer("");
	 String strLevelType     = "";
	 String strApplyClass    = "";
	 String strAuthorityName = "";
	 String strLevel         = "";
	 String strApprovalDate  = "";
	 WebRowSet ws = null;
	 WebRowSet ws1 = null;	
	 int i=0,j=0,k=0,l=0;
	
//	 System.out.println("From Store Id-->>"+strFrmStoreId);
//	 System.out.println("Hsp Code-->>"+strHospCode);
//	 System.out.println("Item Catg Id-->>"+strItemCatgCode);
//	 System.out.println("Req No-->>"+strReqNo);
//	 System.out.println("Req  Type Id-->>"+strReqTypeId);	
//	 System.out.println("To Store Id-->>"+strToStoreId);
	
	 
	 /* Setting Value in vo Object */
	 vo.setStrFrmStoreId(strFrmStoreId);
	 vo.setStrHospCode(strHospCode);
	 vo.setStrItemCatgCode(strItemCatgCode);
	 vo.setStrReqNo(strReqNo);
	 vo.setStrReqTypeId(strReqTypeId);
	 vo.setStrToStoreId(strToStoreId);
	
	 /* Calling BO Method  */
	 bo.getApprovalDtlLevel1(vo);
	
	 if(!strToStoreId.equals("0"))
	 {	
	   bo.getApprovalDtlLevel2(vo);
	 }  
	
	  ws = vo.getGblWs1();
	 ws1 = vo.getGblWs2();
	 
	   sb.append("<table class='table'>"); 
	   sb.append("<thead class='thead-dark' align='center'><tr><th width='40%' style='font-weight:350 !important ;font-size: 16px !important;'>Authority Name</th>");
	   sb.append("<th width='30%' style='font-weight:350 !important ;font-size: 16px !important;'>Level</th>");
	   sb.append("<th width='30%' style='font-weight:350 !important ;font-size: 16px !important;'>Approval Date</th></tr></thead>");
	  try 
	   {
		  
		  if(vo.getStrMsgType().equals("0"))
		  {
			  if (ws != null && ws.size() != 0) 
			  {				     	
				 for(i=0;ws.next();i++)
                 {
				    	
					       strLevelType     = ws.getString(1).trim();
					       strAuthorityName = ws.getString(2).trim(); 
 					       strLevel         = ws.getString(3).trim();
 						   strApprovalDate  = ws.getString(4).trim();

 						   if(strApprovalDate.equals("-")) 
	  				       {
	  				    	 strApplyClass = "Approved";				    	   
	  				       }
	  				       else
	  				       {
	  				    	 strApplyClass = "NotApproved";    				    	   
	  				       }	 
					        if(strLevelType.equals("Raising Level"))
	  				        {
					        	
					        	if(i==0)
					        	{	
	  				              sb.append("<tr><td style='font-weight:350 !important ;font-size: 15px !important;'>Raising Level 1</td></tr>");
					        	} 
	  					      	
	  											
	  						    if(strAuthorityName == null || strAuthorityName.equals("")) strAuthorityName = "-----";
	  	  				        if(strLevel == null || strLevel.equals("")) strLevel = "-----";
	  	  				        if(strApprovalDate == null || strApprovalDate.equals("")) strApprovalDate = "-----"; 
	  	                      
	  					    
							    sb.append("<tr>");
							 
							    sb.append("<td width='40%' align='left' style='font-weight:350 !important ;font-size: 15px !important;'>");
							    sb.append(strAuthorityName);
							    sb.append("</td>");
							    sb.append("<td width='30%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
							    sb.append(strLevel);
							    sb.append("</td>");
							    sb.append("<td width='30%' align='center'style='font-weight:350 !important ;font-size: 15px !important;'>");
							    sb.append(strApprovalDate);
							    sb.append("</td>");
							    sb.append("</tr>");
	  	                      
	  				        }
					        else
	  				        {	
					        	if(k==0)
					        	{	
					        	  sb.append("<tr><td style='font-weight:350 !important ;font-size: 15px !important;'>Admin Level(Raising) 1</td></tr>");
					        	 } 
	  				        	 	k++;  	  					    	 											
	  						        if(strAuthorityName == null || strAuthorityName.equals("")) strAuthorityName = "-----";
	  	  				            if(strLevel == null || strLevel.equals("")) strLevel = "-----";
	  	  				            if(strApprovalDate == null || strApprovalDate.equals("")|| strApprovalDate.equals("----")) strApprovalDate = "-----"; 
	                     
	  	  				         sb.append("<tr>");
	  							 sb.append("<td width='40%' align='left' style='font-weight:350 !important ;font-size: 15px !important;'>");
	  							 sb.append(strAuthorityName);
	  							 sb.append("</td>");
	  							 sb.append("<td width='30%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
	  							 sb.append(strLevel);
	  							 sb.append("</td>");
	  							 sb.append("<td width='30%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
	  							 sb.append(strApprovalDate);
	  							 sb.append("</td>");
	  							 sb.append("</tr>");
	  	                         
	  				        }
                      }
			      }	
			      else
			      {
			    	  if(i==0)
			    	  {	  
			    	     sb.append("<tr><td></td><td><div class='alert alert-danger' style='font-weight:350 !important ;font-size: 15px !important;padding:0.25rem;border-radius:1.5rem'" + 
		    	     		"'>No Record Found For Raising Level 1</div></td><td></td></tr>");
			    	  }
			    	  if(k==0)
			    	  {
			    		  sb.append("<tr><td></td><td><div class='alert alert-danger' style='font-weight:350 !important ;font-size: 15px !important;padding:0.25rem;border-radius:1.5rem'>No Record Found For Raising Admin (Level 1)</div></td><td></td></tr>");  
			    	  }	  
	 			     
			      } 	 
		    }
		  else
		  {
				  String err = vo.getStrMsgString();   
				  sb.append("ERROR####"+err);   
				
		   }     
		  
		 }
		 catch (SQLException e) 
         {
				new HisException("IndentViewTransaction","ApprovalDtlHLP .getApprovalDtl() -->",e.getMessage());
		 }
		try 
		{
			if(vo.getStrMsgType().equals("0"))
			{
				  if (ws1 != null && ws1.size() != 0) 
				  {				     	
					    for(j=0;ws1.next();i++)
	                    {
					     
						       strLevelType     = ws1.getString(1).trim();
						       strApprovalDate  = ws1.getString(4).trim();
						       //System.out.println("strLevelType in 2"+strLevelType);
						       //System.out.println("strApprovalDate in 2"+strApprovalDate);
						       if(strApprovalDate.equals("-")) 
		  				       {
		  				    	 strApplyClass = "Approved";				    	   
		  				       }
		  				       else
		  				       {
		  				    	 strApplyClass = "NotApproved";    				    	   
		  				       }	 
						        if(strLevelType.equals("Recieving Level"))
		  				        {
						        	if(j==0)
						        	{	
		  				             sb.append("<tr><td scope='col' style='font-weight:350 !important ;font-size: 15px !important;'>Recieving Level 2</td></tr>");
						        	} 
		  					      	strAuthorityName = ws1.getString(2); 
		  					    	strLevel         = ws1.getString(3);
		  							strApprovalDate  = ws1.getString(4);
		  											
		  						    if(strAuthorityName == null || strAuthorityName.equals("")) strAuthorityName = "-----";
		  	  				        if(strLevel == null || strLevel.equals("")) strLevel = "-----";
		  	  				        if(strApprovalDate == null || strApprovalDate.equals("")|| strApprovalDate.equals("-")) strApprovalDate = "-----"; 
		  	                      
		  					    
								    sb.append("<tr>");
								 
								    sb.append("<td width='40%' align='left'    style='font-weight:350 !important ;font-size: 15px !important;'>");
								    sb.append(strAuthorityName);
								    sb.append("</td>");
								    sb.append("<td width='30%' align='center'  style='font-weight:350 !important ;font-size: 15px !important;'>");
								    sb.append(strLevel);
								    sb.append("</td>");
								    sb.append("<td width='30%' align='center'  style='font-weight:350 !important ;font-size: 15px !important;'>");
								    sb.append(strApprovalDate);
								    sb.append("</td>");
								    sb.append("</tr>");
		  	                      
		  				        }
						        else
		  				        {	
						        	
		  				        	if(l==0)
		  				        	{	
		  	  					      sb.append("<tr><td  style='font-weight:350 !important ;font-size: 15px !important;'>Admin Level(Recieving) 2</td></tr>");
		  				        	}
		  				        	l++;
		  	  					    	strAuthorityName = ws1.getString(2);  
		  					    	    strLevel         = ws1.getString(3);
		  							    strApprovalDate  = ws1.getString(4);
		  											
		  						        if(strAuthorityName == null || strAuthorityName.equals("")) strAuthorityName = "-----";
		  	  				            if(strLevel == null || strLevel.equals("")) strLevel = "-----";
		  	  				            if(strApprovalDate == null || strApprovalDate.equals("")|| strApprovalDate.equals("-")) strApprovalDate = "-----"; 
		                     
		  	  				         sb.append("<tr>");
		  							 sb.append("<td width='40%' align='left'  style='font-weight:350 !important ;font-size: 15px !important;'>");
		  							 sb.append(strAuthorityName);
		  							 sb.append("</td>");
		  							 sb.append("<td width='30%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
		  							 sb.append(strLevel);
		  							 sb.append("</td>");
		  							 sb.append("<td width='30%' align='center'  style='font-weight:350 !important ;font-size: 15px !important;'>");
		  							 sb.append(strApprovalDate);
		  							 sb.append("</td>");
		  							 sb.append("</tr>");
		  	                         
		  				        }
					        }
					  }	
				      else
				      {
				    	  if(j==0)
				    	  {	  
				    	     sb.append("<tr><td></td><td><div class='alert alert-danger'  style='font-weight:350 !important ;font-size: 15px !important;padding:0.25rem;border-radius:1.5rem'>No Record Found For Recieving Level 2</div></td><td></td></tr>");
				    	  }
				    	  if(l==0)
				    	  {
				    		  sb.append("<tr><td></td><td><div class='alert alert-danger'  style='font-weight:350 !important ;font-size: 15px !important;padding:0.25rem;border-radius:1.5rem'>No Record Found For Recieving Admin (Level 2)</div></td><td></td></tr>");  
				    	  }	  
		 			     
				      } 	 
			    }
			  else
			  {
					  String err = vo.getStrMsgString();   
					  sb.append("ERROR####"+err);   
					
			   }     
			  
		  }
          catch (SQLException e) 
          {
			new HisException(
					"IndentViewTransaction",
					"ApprovalDtlHLP.getApprovalDtl() -->",
					e.getMessage());
		   }
          
	    
	    sb.append("</table>");
	 
		return sb.toString();
	}
  
    public static String getPreTechApprovalDtl(String strFrmStoreId,String strHospCode,String strToStoreId,String strItemCatgCode,String strReqTypeId,String strReqNo,String strSeatId) throws IOException 
  {
	 /* Creating VO & BO Object Here */
	 ApprovalDtlHlpVO vo = new ApprovalDtlHlpVO();
	 ApprovalDtlHlpBO bo = new ApprovalDtlHlpBO();
	 /* Declaring Variable */
	 StringBuffer sb = new StringBuffer("");
	
	 WebRowSet ws = null;
     String	 strCommitteName;
     String	 strUserName; 
     String	 strApprovalDate ;
     String	 strApprovalStatus = null;
	 
	
//	 System.out.println("From Store Id-->>"+strFrmStoreId);
//	 System.out.println("Hsp Code-->>"+strHospCode);
//	 System.out.println("Item Catg Id-->>"+strItemCatgCode);
//	 System.out.println("Req No-->>"+strReqNo);
//	 System.out.println("Req  Type Id-->>"+strReqTypeId);	
//	 System.out.println("To Store Id-->>"+strToStoreId);
	
	 
		 /* Setting Value in vo Object */
		 vo.setStrFrmStoreId(strFrmStoreId);
		 vo.setStrHospCode(strHospCode);
		 vo.setStrItemCatgCode(strItemCatgCode);
		 vo.setStrSeatId(strSeatId);
		 vo.setStrReqNo(strReqNo);
		 vo.setStrReqTypeId(strReqTypeId);
		 vo.setStrToStoreId(strToStoreId);
		
		 /* Calling BO Method  */
		 bo.getPreTechApprovalDtl(vo);
	
		   ws = vo.getGblWs3();
		     
		   try 
		   {
		  
		    if(vo.getStrMsgType().equals("0"))
		    {
			    if (ws != null && ws.size() != 0) 
			    {	
			    	if(ws.next())
					{
				  	
							   strCommitteName     = ws.getString(1).trim();
						       strUserName         = ws.getString(2).trim(); 
						       strApprovalDate     = ws.getString(3).trim();
						       strApprovalStatus   = ws.getString(4).trim();
						       
					        	
						    if(!strUserName.equals("-"))
						    {   
	  											
	  						    if(strCommitteName == null || strCommitteName.equals("")) strCommitteName = "-----";
	  	  				        if(strApprovalStatus == null || strApprovalStatus.equals("")) strApprovalStatus = "-----";
	  	  				        if(strApprovalDate == null || strApprovalDate.equals("")) strApprovalDate = "-----"; 
	  	                      
		  	  				    sb.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing='1px' align='center' >");
		  	  				    sb.append("<tr class='TITLE'>");
		  	  				    sb.append("<td colspan='4'>Pre-Tech Approval</td>");
		  	  				    sb.append("</tr>");
		  	  				    sb.append("</table>");
	  					    
		  	  				    sb.append("<table class='TABLEWIDTH' border='0' cellspacing='1px' align='center' >");
								sb.append("<tr><td width='25%' class='LABEL'>Committe Name</td>");
								sb.append("<td width='25%' class='CONTROL'>");
								sb.append("<font color='blue'>"+strCommitteName+"</font>");
								sb.append("</td>");
								sb.append("<td width='25%' class='LABEL'>User name</td>");
								sb.append("<td width='25%' class='CONTROL'>");
								sb.append("<font color='blue'>"+strUserName+"</font>");
								sb.append("</td></tr>");
								sb.append("<tr><td width='25%' class='LABEL'>Approval Date</td>");
								sb.append("<td width='25%' class='CONTROL'>");
								sb.append("<font color='blue'>"+strApprovalDate+"</font>");
								sb.append("</td>");
								sb.append("<td width='25%' class='LABEL'>Approval Status</td>");
								sb.append("<td width='25%' class='CONTROL'>");
								sb.append("<font color='blue'>"+strApprovalStatus+"</font>");
								
								sb.append("</td></tr>");
								sb.append("</table>"); 
	  	                   
						    }
					}    
                     
			      }	
			      else
			      {
			    	      sb.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing='1px' align='center' >");
			    		  sb.append("<tr><td colspan='4' class='multiControl'><font color='red'>No Record Found For Pre-Tech Approval</font></td></tr>");  
			    		  sb.append("</table>"); 
	 			     
			      } 	 
		    }
		  else
		  {
				  String err = vo.getStrMsgString();   
				  sb.append("ERROR####"+err);   
				
		   }     
		  
		 }
		 catch (SQLException e) 
         {
			   // e.printStackTrace();
				new HisException("IndentViewTransaction","ApprovalDtlHLP .getPreTechApprovalDtl() -->",e.getMessage());
		 }
		//System.out.println("HLP OP/////"+sb.toString());	 
		return sb.toString();
	}
    
    /**
	 * Gets the approval dtl new.
	 * 
	 * @param strFrmStoreId the str frm store id
	 * @param strHospCode the str hosp code
	 * @param strReqStatus the str req status
	 * @param strReqNo the str req no
	 * @return the approval dtl new
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String getApprovalDtlNew(String strFrmStoreId, String strHospCode, String strReqStatus, String strReqNo,HttpServletRequest request) throws IOException {
		/* Creating VO & BO Object Here */
		ApprovalDtlHlpVO vo = new ApprovalDtlHlpVO();
		ApprovalDtlHlpBO bo = new ApprovalDtlHlpBO();

		/* Declaring Variable */
		StringBuffer sb = new StringBuffer("");
		String strApplyClass = "";
		String strLevelType = "", strUserName = "";
		String strUserLevel = "";
		String strApprovalDate = "";
		int i = 1;
		WebRowSet ws = null;
		/* Setting Value in vo Object */
		vo.setStrFrmStoreId(strFrmStoreId);
		vo.setStrHospCode(strHospCode);
		vo.setStrReqNo(strReqNo);
		vo.setStrReqStatus(strReqStatus);

		/* Calling BO Method */
		bo.getApprovalDtl(vo);

		ws = vo.getGblWs1();

		sb.append("<br><div class='line'><table class='TABLEWIDTH' align='center' cellspacing='0px' cellpadding='1px'>");
		sb.append("<tr><td width='100%'><div id='approvalId'>Approval Detail(s)</div></td></tr>");
		sb.append("</table></div>");
		sb.append("<table id='mainTableRptId' class='TABLEWIDTH' align='center' border='0' cellpadding ='1px' cellspacing ='0px'>");
		sb.append("<thead><tr>");
		sb.append("<tr id='tableHeaderId'>");
		sb.append("<tr><td width='5%' class='multiLabel'>S.No.</td>");
		sb.append("<td width='25%' class='multiLabel'>Level Type</td>");
		sb.append("<td width='25%' class='multiLabel'>User Name</td>");
		sb.append("<td width='20%' class='multiLabel'>User Level</td>");
		sb.append("<td width='25%' class='multiLabel'>Approval Date</td></tr>");
		sb.append("</thead><tbody>");
		try {

			if (vo.getStrMsgType().equals("0")) 
			{
				if (ws != null && ws.size() != 0) 
				{
					while (ws.next()) 
					{

						strLevelType    = ws.getString(1).trim();
						strUserName     = ws.getString(2).trim();
						strUserLevel    = ws.getString(3).trim();
						if(ws.getString(4).equals("-")) 
						{	
						    
						    strApprovalDate = "-";
						}
						else
						{
							strApprovalDate = ws.getString(4).trim();	
						}

						if (strApprovalDate.equals("-")) 
						{
							strApplyClass = "Approved";
						} 
						else 
						{
							strApplyClass = "NotApproved";
						}

						if (strUserName == null || strUserName.equals("")) {
							strUserName = "-----";
						}
						if (strUserLevel == null || strUserLevel.equals("")) {
							strUserLevel = "-----";
						}
						if (strApprovalDate == null || strApprovalDate.equals("")) {
							strApprovalDate = "-----";
						}

						sb.append("<tr>");
						sb.append("<td width='5%' class='" + strApplyClass + "'>");
						sb.append(i);
						sb.append("</td>");
						sb.append("<td width='25%' class='" + strApplyClass + "'>");
						sb.append(strLevelType);
						sb.append("</td>");
						sb.append("<td width='25%' class='" + strApplyClass + "'>");
						sb.append(strUserName);
						sb.append("</td>");
						sb.append("<td width='20%' class='" + strApplyClass + "'>");
						sb.append(strUserLevel);
						sb.append("</td>");
						sb.append("<td width='25%' class='" + strApplyClass + "'>");
						sb.append(strApprovalDate);
						sb.append("</td>");
						sb.append("</tr>");

						i++;
						sb.append("</tbody>");
						sb.append("</table>");
					}
				} else {
					sb.append("<tr><td colspan='5' class='multiControl'><font color='red'>No Record Found</font></td></tr>");
				}
			} else {
				String err = vo.getStrMsgString();
				sb.append("ERROR####" + err);

			}

		} catch (SQLException e) {
			new HisException("IndentViewTransaction", "ApprovalDtlHLP .getApprovalDtlNew() -->", e.getMessage());
		}
		sb.append("</table>");

		return sb.toString();
	}
	

}
