package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.IndentViewTransVO;

public class IndentViewTransHLP 
{
	
	public static String getItemDetails1Print(IndentViewTransVO vo)
	{
	    StringBuffer sb = new StringBuffer("");
	    String strHiddenValue =""; 
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		int i=0,k=0,j=1;
		try 
		{
			if (ws1 != null && ws1.size()>0) 
			{
				   String strCrNo   = null;
			       String strPatName = null;
			       String strEmpID = null;
			       String strEmpName = null;
			       if(k==0)
			       {
			       while(ws1.next())
			       { 
			    	   if(vo.getStrReqTypeId().equals("14"))
			    	   {	   
			    		   strCrNo    = ws1.getString(10);
				    	   strPatName = ws1.getString(11);
				    	   strEmpID   = ws1.getString(12);
				    	   strEmpName = ws1.getString(13);
			    	   }
			    	   if(vo.getStrReqTypeId().equals("12")||vo.getStrReqTypeId().equals("13"))
			    	   {
			    		   strCrNo = ws1.getString(8);
							strPatName = ws1.getString(9);
							strEmpID = ws1.getString(10);
							/*
							 * AHIS_FUNCTION.GETCATEGORYNAME(A.HGNUM_PATIENT_CAT_CODE,A.GNUM_HOSPITAL_CODE) ||'^'||				     
						       INITCAP(HRGSTR_FNAME)||
						       DECODE(SIGN(LENGTH(TRIM(HRGSTR_MNAME))-0),1,' '||TRIM(INITCAP(HRGSTR_MNAME)))||
						       DECODE(SIGN(LENGTH(TRIM(HRGSTR_LNAME))-0),1,' '||
						       TRIM(INITCAP(HRGSTR_LNAME)))||' - '||AHIS_UTIL.AGE_SEX(HRGNUM_PUK::CHARACTER VARYING)||'[ '||HRGNUM_PUK||' ]' 
						       || '^' ||HRGNUM_IS_MLC||'^'||HRGNUM_ISNEWBORN ||'^'||HRGSTR_FATHER_NAME				       
						       ||'^'||NVL(HRGNUM_IS_DEAD,0)||'^'||nvl((select gstr_hospital_name from gblt_hospital_mst where gnum_hospital_code=a.gnum_hospital_code),'')
						       ||'^'||TO_CHAR(GDT_ENTRY_DATE,'DD-MON-YYYY HH24:MI:SS')||'^'||NVL(HRGSTR_EMG_CNTC,'')
						       ||'^'||DECODE(HRGNUM_ISNEWBORN,0,'NO','YES:MOTHER CR '||HRGNUM_MOTHER_PUK) 
						       
						       0 - General                                              Patient Category
						       1 - Gabru Jawan - 25 Yr/Male[ 279162100000665 ]          Patient Dtls
						       2 - 0                                                    HRGNUM_IS_MLC            
						       3 - 0                                                    HRGNUM_ISNEWBORN  
						       4 - Sdds                                                 HRGSTR_FATHER_NAME
						       5 - 0                                                    HRGNUM_IS_DEAD
						       6 - All India Institute of Medical Sciences, Nagpur      HOSP_NAME 
						       7 - 03-MAY-2021 18:11:02                                 ADDMISSION DATE
						       8 -                                                      HRGSTR_EMG_CNTC
						       9 - NO                                                   HRGNUM_ISNEWBORN 
							 * 
							 * */
							strEmpName = ws1.getString(11);
							/*
							 * 0 - Dept Name                                            
						       1 - Dept Unit Name                                       
						       2 - Ward Name                                                      
						       3 - Room No                                             
						       4 - Bed No                                               
						       5 - Patient Catg                                         
						       6 - Consultant Name                                       
						       7 - IS New Born                                          
						       8 - Bill Catg 
						       9 - Addmission No
						      10 - Admission Date 
							 * 
							 * */
			    		   
			    	   } 
			    	   if(vo.getStrReqTypeId().equals("13"))
			    	   {
			    		   strCrNo    = ws1.getString(8);
				    	   strPatName = ws1.getString(9);
				    	   strEmpID   = ws1.getString(10);
				    	   strEmpName = ws1.getString(11);
				    	   		    		   
			    	   } 
			    	   if(vo.getStrReqTypeId().equals("10"))
			    	   {	   
			    		   strCrNo    = ws1.getString(10);
				    	   strPatName = ws1.getString(11);
				    	   strEmpID   = ws1.getString(12);
				    	   strEmpName = ws1.getString(13);
			    	   }
			    	   
			    	    if(strCrNo == null || strCrNo.equals("")|| strCrNo.equals("0"))  strCrNo = "-------";
						if(strPatName == null || strPatName.equals("")) strPatName = "-------";
						if(strEmpID == null || strEmpID.equals("")|| strEmpID.equals("0")) strEmpID = "-------";
						if(strEmpName == null || strEmpName.equals("")) strEmpName = "-------";
						//System.out.println("Before Condition--->>"+vo.getStrReqTypeId());
					  if(!vo.getStrReqTypeId().equals("10"))
				      {
						  if (vo.getStrReqTypeId().equals("13")) 
							{
								if (k == 0) 
								{

									String strArr[]     = strEmpID.split("\\^");
									String strAddmArr[] = strEmpName.split("\\^");	
									
									sb.append("<table width='825' align='center' cellpadding='1px' cellspacing='1px' border='0px' style='font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px;'>");
									sb.append("<tr>");
									sb.append("<td align='right' width='25%' style='font-weight: bold;'>CR NO:</td>");
									sb.append("<td align='left' width='25%'>" + strCrNo + "</td>");
									sb.append("<td align='right' width='25%' style='font-weight: bold;'>Patient Dtl:</td>");
									sb.append("<td align='left' width='25%'>" + strArr[1] + "</td>");
									sb.append("</tr>");
									
									sb.append("<tr>");
									sb.append("<td align='right' width='25%' style='font-weight: bold;'>Category:</td>");
									sb.append("<td align='left' width='25%'>" + strArr[0] + "</td>");
									sb.append("<td align='right' width='25%' style='font-weight: bold;'>Department Name:</td>");
									sb.append("<td align='left' width='25%'>" + strAddmArr[0] + "</td>");
									sb.append("</tr>");
									
									sb.append("<tr>");
									sb.append("<td align='right' width='25%' style='font-weight: bold;'>Unit Name:</td>");
									sb.append("<td align='left' width='25%'>" + strAddmArr[1] + "</td>");
									sb.append("<td align='right' width='25%' style='font-weight: bold;'>Ward Name:</td>");
									sb.append("<td align='left' width='25%'>" + strAddmArr[2] + "</td>");
									sb.append("</tr>");
									
									sb.append("<tr>");
									sb.append("<td align='right' width='25%' style='font-weight: bold;'>Room / Bed:</td>");
									sb.append("<td align='left' width='25%'>" + strAddmArr[3] + " / " + strAddmArr[4] + "</td>");
									sb.append("<td align='right' width='25%' style='font-weight: bold;'>Admission Dtl:</td>");
									sb.append("<td align='left' width='25%'>" + strAddmArr[9] + " [ " + strAddmArr[10] + " ]" + "</td>");
									sb.append("</tr>");					
									
									/*
									 * 0 - Dept Name                                            
								       1 - Dept Unit Name                                       
								       2 - Ward Name                                                      
								       3 - Room No                                             
								       4 - Bed No                                               
								       5 - Patient Catg                                         
								       6 - Consultant Name                                       
								       7 - IS New Born                                          
								       8 - Bill Catg 
								       9 - Addmission No
								      10 - Admission Date 
									 * 
									 * */
									
									/*
									   0 - General                                              Patient Category
								       1 - Gabru Jawan - 25 Yr/Male[ 279162100000665 ]          Patient Dtls
								       2 - 0                                                    HRGNUM_IS_MLC            
								       3 - 0                                                    HRGNUM_ISNEWBORN  
								       4 - Sdds                                                 HRGSTR_FATHER_NAME
								       5 - 0                                                    HRGNUM_IS_DEAD
								       6 - All India Institute of Medical Sciences, Nagpur      HOSP_NAME 
								       7 - 03-MAY-2021 18:11:02                                 ADDMISSION DATE
								       8 -                                                      HRGSTR_EMG_CNTC
								       9 - NO                                                   HRGNUM_ISNEWBORN 
									 * 
									 * */
								}
							} else {

								if (vo.getStrReqTypeId().equals("12"))
								{
									if (k == 0) 
									{										
										sb.append("<tr>");
										sb.append("<td align='right' width='25%' style='font-weight: bold;'><font face='Verdana, Arial, Helvetica, sans-serif' >Emp ID:</font></td>");
										sb.append("<td align='left' width='25%' style='font-weight: bold;'><font face='Verdana, Arial, Helvetica, sans-serif' >" + strEmpID + "</font></td>");
										sb.append("<td align='right' width='25%' style='font-weight: bold;'><font face='Verdana, Arial, Helvetica, sans-serif' >Emp Name:</font></td>");
										sb.append("<td align='left' width='25%' style='font-weight: bold;'><font face='Verdana, Arial, Helvetica, sans-serif' >" + strEmpName + "</font></td>");
										sb.append("</tr>");

									}
								}
							}
					  k++;
				     } 
				  }
			   sb.append("</table>");
			 }
			}
			
			   ws1.beforeFirst();	
		    
			   
			   
			       sb.append("<table width='825' align='center' cellpadding='1' cellspacing='1' border='0' style='font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px;'>");
				   sb.append("<tr bgcolor='#cdc9c9'>");
					   sb.append("<td align='center' width='5%' style='font-weight: bold;'><font face='Verdana, Arial, Helvetica, sans-serif'>S.No.</font></td>");
					   sb.append("<td align='center' width='45%' style='font-weight: bold;'><font face='Verdana, Arial, Helvetica, sans-serif'>Item Name</font></td>");
					   sb.append("<td align='center' width='15%' style='font-weight: bold;'><font face='Verdana, Arial, Helvetica, sans-serif'>Req Qty</font></td>");
					   sb.append("<td align='center' width='15%' style='font-weight: bold;'><font face='Verdana, Arial, Helvetica, sans-serif'>Approved Qty/Issue Qty</font></td>");
				   sb.append("</tr>");

			   // Add your table rows here

			/* sb.append("</table>"); */

			  
			      if (ws1 != null && ws1.size()>0) 
				  {
					   String strItemName   = null;
				       String strAvlQty = null;
				       String strReqQty = null;
				       String strSancQty = null;
				       String strRate = null;
				       String strIssueQty = null;
				       String strRetQty = null;
				       String strLstRecevDate = null;
				       String strLstRecevQty = null;
				       String strLstRetQtyUnitId = null;
				       while(ws1.next())
				       {
				    	   if(vo.getStrReqTypeId().equals("10"))
				    	    {
				    		    strIssueQty	        = ws1.getString(1);	
				    	    	strLstRecevQty      = ws1.getString(2);
				    	    	strLstRecevDate     = ws1.getString(3);
				    	    	strLstRetQtyUnitId  = ws1.getString(4);
				    	    	strItemName   = ws1.getString(5);
						        strAvlQty     = ws1.getString(6);
						        strReqQty     = ws1.getString(7);
						        strSancQty    = ws1.getString(8);
						        strRate       = ws1.getString(9);
				    	    	
						        strHiddenValue = strIssueQty+"^"+strLstRecevQty+"^"+strLstRecevDate+"^"+strLstRetQtyUnitId+"^"+strItemName;
				    	    }	
				    	   
				    	   
				    	    if(vo.getStrReqTypeId().equals("12") || vo.getStrReqTypeId().equals("13"))
				    	    {
				    	    	strIssueQty	  = ws1.getString(1);	
				    	    	strRetQty     = ws1.getString(2);
				    	    	strItemName   = ws1.getString(3);
						        strAvlQty     = ws1.getString(4);
						        strReqQty     = ws1.getString(5);
						        strSancQty    = ws1.getString(6);
						        strRate       = ws1.getString(7);
						        strHiddenValue = strIssueQty+"^"+strRetQty+"^"+strItemName;
						        
				    	    }	
				    	    if(vo.getStrReqTypeId().equals("14"))
				    	    {
				    	    	strIssueQty	        = ws1.getString(1);	
				    	    	strLstRecevQty      = ws1.getString(2);
				    	    	strLstRecevDate     = ws1.getString(3);
				    	    	strLstRetQtyUnitId  = ws1.getString(4);
				    	    	strItemName   = ws1.getString(5);
						        strAvlQty     = ws1.getString(6);
						        strReqQty     = ws1.getString(7);
						        strSancQty    = ws1.getString(8);
						        strRate       = ws1.getString(9);
				    	    	
				    	    	strHiddenValue = strIssueQty+"^"+strLstRecevQty+"^"+strLstRecevDate+"^"+strLstRetQtyUnitId+"^"+strItemName;
				    	    }	
				    	    
				    	    
				    	    
				    	    if(strItemName == null || strItemName.equals(""))  strItemName = "-----";
							if(strAvlQty == null || strAvlQty.equals("")) strAvlQty = "-----";
							if(strReqQty == null || strReqQty.equals("")) strReqQty = "-----";
							if(strSancQty == null || strSancQty.equals("")) strSancQty = "-----";
							if(strRate == null || strRate.equals("")) strRate = "-----";
						
							sb.append("<tr>");
								sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>" + j + "</b></font></td>");
								sb.append("<td align='left' width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + strItemName + "</font></td>");
								sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + strReqQty + "</font></td>");
								sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + strSancQty + "</font></td>");
							sb.append("</tr>");

							
							i++;
							j++;
						}
					 sb.append("</table>");
			  	     
		 	  }
			      else 
			      {			    	    
			    	  sb.append("<table width='825' align='center' cellpadding='1' cellspacing='1' border='0' style='font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px;'>");
				    	  sb.append("<tr>");
				    	  	sb.append("<td align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>No Record Found</b></font></td>");
				    	  sb.append("</tr>");
			    	  sb.append("</table>");

			   } 
		}
		catch(Exception e)
		{
		    vo.setStrMsgString("IndentViewTransHLP.getItemDetails() --> "+e.getMessage());
			vo.setStrMsgType("1");
		}
	return sb.toString();
	}
	
	public static String getItemDetails1(IndentViewTransVO vo)
	{
	    StringBuffer sb = new StringBuffer("");
	    String strHiddenValue ="",strIndentStatus=""; 
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		int i=0,k=0;
		try 
		{
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					 strIndentStatus   = ws.getString(7);  // 99 - Rejected  50- Processed 40 - Final Approved 49 - In-Process 45 - Indent Closed 
				}
			}
			ws.beforeFirst();
			
			if (ws1 != null && ws1.size()>0) 
			{
				   String strCrNo   = null;
			       String strPatName = null;
			       String strEmpID = null;
			       String strEmpName = null;
			       if(k==0)
			       {
			       while(ws1.next())
			       { 
			    	   if(vo.getStrReqTypeId().equals("14"))
			    	   {	   
			    		   strCrNo    = ws1.getString(10);
				    	   strPatName = ws1.getString(11);
				    	   strEmpID   = ws1.getString(12);
				    	   strEmpName = ws1.getString(13);
			    	   }
			    	   if(vo.getStrReqTypeId().equals("12")||vo.getStrReqTypeId().equals("13"))
			    	   {
			    		   strCrNo = ws1.getString(8);
							strPatName = ws1.getString(9);
							strEmpID = ws1.getString(10);
							/*
							 * AHIS_FUNCTION.GETCATEGORYNAME(A.HGNUM_PATIENT_CAT_CODE,A.GNUM_HOSPITAL_CODE) ||'^'||				     
						       INITCAP(HRGSTR_FNAME)||
						       DECODE(SIGN(LENGTH(TRIM(HRGSTR_MNAME))-0),1,' '||TRIM(INITCAP(HRGSTR_MNAME)))||
						       DECODE(SIGN(LENGTH(TRIM(HRGSTR_LNAME))-0),1,' '||
						       TRIM(INITCAP(HRGSTR_LNAME)))||' - '||AHIS_UTIL.AGE_SEX(HRGNUM_PUK::CHARACTER VARYING)||'[ '||HRGNUM_PUK||' ]' 
						       || '^' ||HRGNUM_IS_MLC||'^'||HRGNUM_ISNEWBORN ||'^'||HRGSTR_FATHER_NAME				       
						       ||'^'||NVL(HRGNUM_IS_DEAD,0)||'^'||nvl((select gstr_hospital_name from gblt_hospital_mst where gnum_hospital_code=a.gnum_hospital_code),'')
						       ||'^'||TO_CHAR(GDT_ENTRY_DATE,'DD-MON-YYYY HH24:MI:SS')||'^'||NVL(HRGSTR_EMG_CNTC,'')
						       ||'^'||DECODE(HRGNUM_ISNEWBORN,0,'NO','YES:MOTHER CR '||HRGNUM_MOTHER_PUK) 
						       
						       0 - General                                              Patient Category
						       1 - Gabru Jawan - 25 Yr/Male[ 279162100000665 ]          Patient Dtls
						       2 - 0                                                    HRGNUM_IS_MLC            
						       3 - 0                                                    HRGNUM_ISNEWBORN  
						       4 - Sdds                                                 HRGSTR_FATHER_NAME
						       5 - 0                                                    HRGNUM_IS_DEAD
						       6 - All India Institute of Medical Sciences, Nagpur      HOSP_NAME 
						       7 - 03-MAY-2021 18:11:02                                 ADDMISSION DATE
						       8 -                                                      HRGSTR_EMG_CNTC
						       9 - NO                                                   HRGNUM_ISNEWBORN 
							 * 
							 * */
							strEmpName = ws1.getString(11);
							/*
							 * 0 - Dept Name                                            
						       1 - Dept Unit Name                                       
						       2 - Ward Name                                                      
						       3 - Room No                                             
						       4 - Bed No                                               
						       5 - Patient Catg                                         
						       6 - Consultant Name                                       
						       7 - IS New Born                                          
						       8 - Bill Catg 
						       9 - Addmission No
						      10 - Admission Date 
							 * 
							 * */
			    		   
			    	   } 
			    	   if(vo.getStrReqTypeId().equals("13"))
			    	   {
			    		   strCrNo    = ws1.getString(8);
				    	   strPatName = ws1.getString(9);
				    	   strEmpID   = ws1.getString(10);
				    	   strEmpName = ws1.getString(11);
				    	   		    		   
			    	   } 
			    	   if(vo.getStrReqTypeId().equals("10"))
			    	   {	   
			    		   strCrNo    = ws1.getString(10);
				    	   strPatName = ws1.getString(11);
				    	   strEmpID   = ws1.getString(12);
				    	   strEmpName = ws1.getString(13);
			    	   }
			    	   
			    	    if(strCrNo == null || strCrNo.equals("")|| strCrNo.equals("0"))  strCrNo = "-------";
						if(strPatName == null || strPatName.equals("")) strPatName = "-------";
						if(strEmpID == null || strEmpID.equals("")|| strEmpID.equals("0")) strEmpID = "-------";
						if(strEmpName == null || strEmpName.equals("")) strEmpName = "-------";
						//System.out.println("Before Condition--->>"+vo.getStrReqTypeId());
					  if(!vo.getStrReqTypeId().equals("10"))
				      {
						  if (vo.getStrReqTypeId().equals("13")) 
							{
								if (k == 0) 
								{
									String strArr[]     = strEmpID.split("\\^");
									String strAddmArr[] = strEmpName.split("\\^");
									
									sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
									sb.append("<tr><td width='25%' class='LABEL'>CR NO</td>");
									sb.append("<td width='25%' class='CONTROL'>");
									sb.append(strCrNo);
									sb.append("</td>");
									sb.append("<td width='25%' class='LABEL'>Patient Dtl</td>");
									sb.append("<td width='25%' class='CONTROL'>");
									sb.append(strArr[1]);
									sb.append("</td></tr>");
									sb.append("<tr><td width='25%' class='LABEL'>Category</td>");
									sb.append("<td width='25%' class='CONTROL'>");
									sb.append(strArr[0]);
									sb.append("</td>");
									sb.append("<td width='25%' class='LABEL'>Department Name</td>");
									sb.append("<td width='25%' class='CONTROL'>");
									sb.append(strAddmArr[0]);
									sb.append("</td></tr>");
									sb.append("<tr><td width='25%' class='LABEL'>Unit Name</td>");
									sb.append("<td width='25%' class='CONTROL'>");
									sb.append(strAddmArr[1]);
									sb.append("</td>");
									sb.append("<td width='25%' class='LABEL'>Ward Name</td>");
									sb.append("<td width='25%' class='CONTROL'>");
									sb.append(strAddmArr[2]);
									sb.append("</td></tr>");
									sb.append("<tr><td width='25%' class='LABEL'>Room / Bed</td>");
									sb.append("<td width='25%' class='CONTROL'>");
									sb.append(strAddmArr[3]+" / "+ strAddmArr[4] );
									sb.append("</td>");
									sb.append("<td width='25%' class='LABEL'>Addmission Dtl</td>");
									sb.append("<td width='25%' class='CONTROL'>");
									sb.append(strAddmArr[9]+" [ "+ strAddmArr[10] +" ]");
									sb.append("</td></tr>");
									/*
									 * 0 - Dept Name                                            
								       1 - Dept Unit Name                                       
								       2 - Ward Name                                                      
								       3 - Room No                                             
								       4 - Bed No                                               
								       5 - Patient Catg                                         
								       6 - Consultant Name                                       
								       7 - IS New Born                                          
								       8 - Bill Catg 
								       9 - Addmission No
								      10 - Admission Date 
									 * 
									 * */
									
									/*
									   0 - General                                              Patient Category
								       1 - Gabru Jawan - 25 Yr/Male[ 279162100000665 ]          Patient Dtls
								       2 - 0                                                    HRGNUM_IS_MLC            
								       3 - 0                                                    HRGNUM_ISNEWBORN  
								       4 - Sdds                                                 HRGSTR_FATHER_NAME
								       5 - 0                                                    HRGNUM_IS_DEAD
								       6 - All India Institute of Medical Sciences, Nagpur      HOSP_NAME 
								       7 - 03-MAY-2021 18:11:02                                 ADDMISSION DATE
								       8 -                                                      HRGSTR_EMG_CNTC
								       9 - NO                                                   HRGNUM_ISNEWBORN 
									 * 
									 * */
								}
							} else {

								if (vo.getStrReqTypeId().equals("12")) {
									if (k == 0) {
										sb.append("<tr><td width='25%' class='LABEL'>Emp ID</td>");
										sb.append("<td width='25%' class='CONTROL'>");
										sb.append(strEmpID);
										sb.append("</td>");
										sb.append("<td width='25%' class='LABEL'>Emp Name</td>");
										sb.append("<td width='25%' class='CONTROL'>");
										sb.append(strEmpName);
										sb.append("</td></tr>");
									}
								}
							}
					  k++;
				     } 
				  }
			   sb.append("</table>");
			 }
			}
			
			   ws1.beforeFirst();
			
		       sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC'  border='0' cellspacing ='1px'>"); 
			   sb.append("<tr>");
			   sb.append("<td width='25%' class='multiLabel'>Item Name</td>");
			  // sb.append("<td width='20%' class='multiLabel'>Avalaible Qty</td>"); 
			   sb.append("<td width='25%' class='multiLabel'>Req Qty</td>");
			   sb.append("<td width='25%' class='multiLabel'>Approved Qty/Issue Qty</td>");
			 //  sb.append("<td width='25%' class='multiLabel'>Rate/Unit</td></tr>");
			  
			      if (ws1 != null && ws1.size()>0) 
				  {
					   String strItemName   = null;
				       String strAvlQty = null;
				       String strReqQty = null;
				       String strSancQty = null;
				       String strRate = null;
				       String strIssueQty = null;
				       String strRetQty = null;
				       String strLstRecevDate = null;
				       String strLstRecevQty = null;
				       String strLstRetQtyUnitId = null;
				       while(ws1.next())
				       {
				    	   if(vo.getStrReqTypeId().equals("10"))
				    	    {
				    		    strIssueQty	        = ws1.getString(1);	
				    	    	strLstRecevQty      = ws1.getString(2);
				    	    	strLstRecevDate     = ws1.getString(3);
				    	    	strLstRetQtyUnitId  = ws1.getString(4);
				    	    	strItemName   = ws1.getString(5);
						        strAvlQty     = ws1.getString(6);
						        strReqQty     = ws1.getString(7);
						        strSancQty    = ws1.getString(8);
						        strRate       = ws1.getString(9);
				    	    	
						        strHiddenValue = strIssueQty+"^"+strLstRecevQty+"^"+strLstRecevDate+"^"+strLstRetQtyUnitId+"^"+strItemName;
				    	    }	
				    	   
				    	   
				    	    if(vo.getStrReqTypeId().equals("12") || vo.getStrReqTypeId().equals("13"))
				    	    {
				    	    	strIssueQty	  = ws1.getString(1);	
				    	    	strRetQty     = ws1.getString(2);
				    	    	strItemName   = ws1.getString(3);
						        strAvlQty     = ws1.getString(4);
						        strReqQty     = ws1.getString(5);
						        strSancQty    = ws1.getString(6);
						        strRate       = ws1.getString(7);
						        strHiddenValue = strIssueQty+"^"+strRetQty+"^"+strItemName;
						        
				    	    }	
				    	    if(vo.getStrReqTypeId().equals("14"))
				    	    {
				    	    	strIssueQty	        = ws1.getString(1);	
				    	    	strLstRecevQty      = ws1.getString(2);
				    	    	strLstRecevDate     = ws1.getString(3);
				    	    	strLstRetQtyUnitId  = ws1.getString(4);
				    	    	strItemName   = ws1.getString(5);
						        strAvlQty     = ws1.getString(6);
						        strReqQty     = ws1.getString(7);
						        strSancQty    = ws1.getString(8);
						        strRate       = ws1.getString(9);
				    	    	
				    	    	strHiddenValue = strIssueQty+"^"+strLstRecevQty+"^"+strLstRecevDate+"^"+strLstRetQtyUnitId+"^"+strItemName;
				    	    }	
				    	    
				    	    
				    	    
				    	    if(strItemName == null || strItemName.equals(""))  strItemName = "-----";
							if(strAvlQty == null || strAvlQty.equals("")) strAvlQty = "-----";
							if(strReqQty == null || strReqQty.equals("")) strReqQty = "-----";
							if(strSancQty == null || strSancQty.equals("")) strSancQty = "-----";
							if(strRate == null || strRate.equals("")) strRate = "-----";
							sb.append("<input type='hidden' name ='strHiddenValue'  value='"+strHiddenValue+"'>");
							sb.append("<tr>");
							sb.append("<td width='25%' class='multiControl'>");
		     		   		//sb.append("<a name='tarriff' STYLE='cursor:pointer;cursor:pointer;color:blue;' title='Get Item Details' value=''  onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
							sb.append(strItemName);
		     		   		sb.append("</td>");
//							sb.append("<td width='20%' class='multiControl'>");
//							sb.append(strAvlQty);
//							sb.append("</td>");
							sb.append("<td width='25%' class='multiControl'>");
							sb.append(strReqQty);
							sb.append("</td>");
				
							sb.append("<td width='25%' class='multiControl'>");
							sb.append(strSancQty);
							sb.append("</td>");
//							sb.append("<td  width='25%' class='multiControl'>");
//							sb.append(strRate);
//							sb.append("</td>");
							sb.append("</tr>");
							i++;
						}
					 sb.append("</table>");
			  	     
		 	  }
			      else 
			      {
				    sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>"); 
				    sb.append("<tr>");
				    sb.append("<td colspan='5'  CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

				    sb.append("</tr>");
				    sb.append("</table>");
					
			   } 
		}
		catch(Exception e)
		{
		    vo.setStrMsgString("IndentViewTransHLP.getItemDetails() --> "+e.getMessage());
			vo.setStrMsgType("1");
		}
	return sb.toString();
	}
	 
	public static String getItemDetailsBS1(IndentViewTransVO vo)
		{
		    StringBuffer sb = new StringBuffer("");
		    String strHiddenValue =""; 
			WebRowSet ws1 = vo.getStrItemDetailsWs();
			int i=0,k=0;
			try 
			{
				if (ws1 != null && ws1.size()>0) 
				{
					   String strCrNo   = null;
				       String strPatName = null;
				       String strEmpID = null;
				       String strEmpName = null;
				       if(k==0)
				       {
				       while(ws1.next())
				       { 
				    	   if(vo.getStrReqTypeId().equals("14"))
				    	   {	   
				    		   strCrNo    = ws1.getString(10);
					    	   strPatName = ws1.getString(11);
					    	   strEmpID   = ws1.getString(12);
					    	   strEmpName = ws1.getString(13);
				    	   }
				    	   if(vo.getStrReqTypeId().equals("12")||vo.getStrReqTypeId().equals("13"))
				    	   {
				    		   strCrNo    = ws1.getString(8);
					    	   strPatName = ws1.getString(9);
					    	   strEmpID   = ws1.getString(10);
					    	   strEmpName = ws1.getString(11);
				    		   
				    	   } 
				    	   if(vo.getStrReqTypeId().equals("13"))
				    	   {
				    		   strCrNo    = ws1.getString(8);
					    	   strPatName = ws1.getString(9);
					    	   strEmpID   = ws1.getString(10);
					    	   strEmpName = ws1.getString(11);
					    	   		    		   
				    	   } 
				    	   if(vo.getStrReqTypeId().equals("10"))
				    	   {	   
				    		   strCrNo    = ws1.getString(10);
					    	   strPatName = ws1.getString(11);
					    	   strEmpID   = ws1.getString(12);
					    	   strEmpName = ws1.getString(13);
				    	   }
				    	   
				    	    if(strCrNo == null || strCrNo.equals("")|| strCrNo.equals("0"))  strCrNo = "-------";
							if(strPatName == null || strPatName.equals("")) strPatName = "-------";
							if(strEmpID == null || strEmpID.equals("")|| strEmpID.equals("0")) strEmpID = "-------";
							if(strEmpName == null || strEmpName.equals("")) strEmpName = "-------";
							//System.out.println("Before Condition--->>"+vo.getStrReqTypeId());
						  if(!vo.getStrReqTypeId().equals("10"))
					      {
							if(!vo.getStrReqTypeId().equals("14"))
							{	
							 if(k==0)
						     {
								 
								 sb.append("<div class='row'>");
									sb.append("<div class='col-sm-2'><label>CR NO</label>");
									sb.append("</div>");
									sb.append("<div class='col-sm-2'>");
									sb.append(strCrNo);
									sb.append("</div>");
									sb.append("<div class='col-sm-2'><label>Patient Name</label>");
									sb.append("</div>");
									sb.append("<div class='col-sm-2'>");
									sb.append(strPatName);
									sb.append("</div>");
									sb.append("<div class='col-sm-2'>");
									sb.append("</div>");
									sb.append("<div class='col-sm-2'>");
									sb.append("</div>");
									sb.append("</div>");
									
									
				            
				             ////System.out.println("Insde View HLP:-->>"+vo.getStrReqTypeId());
				             if(vo.getStrReqTypeId().equals("12"))
				             {	   
				              
				              sb.append("<div class='row'>");
								sb.append("<div class='col-sm-2'><label>Emp ID</label>");
								sb.append("</div>");
								sb.append("<div class='col-sm-2'>");
								sb.append(strEmpID);
								sb.append("</div>");
								sb.append("<div class='col-sm-2'><label>Emp Name</label>");
								sb.append("</div>");
								sb.append("<div class='col-sm-2'>");
								sb.append(strEmpName);
								sb.append("</div>");
								sb.append("<div class='col-sm-2'>");
								sb.append("</div>");
								sb.append("<div class='col-sm-2'>");
								sb.append("</div>");
								sb.append("</div>");
								
				            }
					       }
				          }
						  k++;
					     } 
					  }
				 }
				}
				
				   ws1.beforeFirst();
				
				   sb.append("<table class='table'>"); 
				   sb.append("<thead class='thead-dark' align='center'><tr>");
				   sb.append("<th width='60%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
				  // sb.append("<th width='20%' class='multiLabel'>Avalaible Qty</th>"); 
				   sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
				   sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Approved Qty</th></tr></thead><tbody>");
				 //  sb.append("<td width='25%' class='multiLabel'>Rate/Unit</td></tr>");
				  
				      if (ws1 != null && ws1.size()>0) 
					  {
						   String strItemName   = null;
					       String strAvlQty = null;
					       String strReqQty = null;
					       String strSancQty = null;
					       String strRate = null;
					       String strIssueQty = null;
					       String strRetQty = null;
					       String strLstRecevDate = null;
					       String strLstRecevQty = null;
					       String strLstRetQtyUnitId = null;
					       while(ws1.next())
					       {
					    	   if(vo.getStrReqTypeId().equals("10"))
					    	    {
					    		    strIssueQty	        = ws1.getString(1);	
					    	    	strLstRecevQty      = ws1.getString(2);
					    	    	strLstRecevDate     = ws1.getString(3);
					    	    	strLstRetQtyUnitId  = ws1.getString(4);
					    	    	strItemName   = ws1.getString(5);
							        strAvlQty     = ws1.getString(6);
							        strReqQty     = ws1.getString(7);
							        strSancQty    = ws1.getString(8);
							        strRate       = ws1.getString(9);
					    	    	
							        strHiddenValue = strIssueQty+"^"+strLstRecevQty+"^"+strLstRecevDate+"^"+strLstRetQtyUnitId+"^"+strItemName;
					    	    }	
					    	   
					    	   
					    	    if(vo.getStrReqTypeId().equals("12") || vo.getStrReqTypeId().equals("13"))
					    	    {
					    	    	strIssueQty	  = ws1.getString(1);	
					    	    	strRetQty     = ws1.getString(2);
					    	    	strItemName   = ws1.getString(3);
							        strAvlQty     = ws1.getString(4);
							        strReqQty     = ws1.getString(5);
							        strSancQty    = ws1.getString(6);
							        strRate       = ws1.getString(7);
							        strHiddenValue = strIssueQty+"^"+strRetQty+"^"+strItemName;
							        
					    	    }	
					    	    if(vo.getStrReqTypeId().equals("14"))
					    	    {
					    	    	strIssueQty	        = ws1.getString(1);	
					    	    	strLstRecevQty      = ws1.getString(2);
					    	    	strLstRecevDate     = ws1.getString(3);
					    	    	strLstRetQtyUnitId  = ws1.getString(4);
					    	    	strItemName   = ws1.getString(5);
							        strAvlQty     = ws1.getString(6);
							        strReqQty     = ws1.getString(7);
							        strSancQty    = ws1.getString(8);
							        strRate       = ws1.getString(9);
					    	    	
					    	    	strHiddenValue = strIssueQty+"^"+strLstRecevQty+"^"+strLstRecevDate+"^"+strLstRetQtyUnitId+"^"+strItemName;
					    	    }	
					    	    
					    	    
					    	    
					    	    if(strItemName == null || strItemName.equals(""))  strItemName = "-----";
								if(strAvlQty == null || strAvlQty.equals("")) strAvlQty = "-----";
								if(strReqQty == null || strReqQty.equals("")) strReqQty = "-----";
								if(strSancQty == null || strSancQty.equals("")) strSancQty = "-----";
								if(strRate == null || strRate.equals("")) strRate = "-----";
								sb.append("<input type='hidden' name ='strHiddenValue'  value='"+strHiddenValue+"'>");
								sb.append("<tr>");
								sb.append("<td width='60%' style='font-weight:350 !important ;font-size: 15px !important;'>");
			     		   		//sb.append("<a name='tarriff' STYLE='cursor:pointer;cursor:pointer;color:blue;' title='Get Item Details' value=''  onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
								sb.append(strItemName);
			     		   		sb.append("</td>");
//								sb.append("<td width='20%' class='multiControl'>");
//								sb.append(strAvlQty);
//								sb.append("</td>");
								sb.append("<td width='20%' style='font-weight:350 !important ;font-size: 15px !important;'>");
								sb.append(strReqQty);
								sb.append("</td>");
					
								sb.append("<td width='20%' style='font-weight:350 !important ;font-size: 15px !important;'>");
								sb.append(strSancQty);
								sb.append("</td>");
//								sb.append("<td  width='25%' class='multiControl'>");
//								sb.append(strRate);
//								sb.append("</td>");
								sb.append("</tr>");
								i++;
							}
						 sb.append("</tbody></table>");
				  	     
			 	  }
				      else 
				      {
					    sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>"); 
					    sb.append("<tr>");
					    sb.append("<td colspan='5'  class='multiControl' >"
								+ "<div class='errMsg' align='center'> No Record Found For Selected Indent No. </div>" + "</td>");

					    sb.append("</tr>");
					    sb.append("</table>");
						
				   } 
			}
			catch(Exception e)
			{
			    vo.setStrMsgString("IndentViewTransHLP.getItemDetails() --> "+e.getMessage());
				vo.setStrMsgType("1");
			}
		return sb.toString();
		}
	   
    public static String getItemDetails(IndentViewTransVO vo)
		{
		    StringBuffer sb = new StringBuffer("");
		    String strHiddenValue =""; 
			WebRowSet ws1 = vo.getStrItemDetailsWs();
			String strIndentStatus   ="0";
			int i=0;
			try 
			{
				
				WebRowSet ws = vo.getStrIndentDetailsWs();
				if (ws != null && ws.size() > 0) 
				{
					if (ws.next()) 
					{
						 strIndentStatus   = ws.getString(7);  // 99 - Rejected  50- Processed 40 - Final Approved 49 - In-Process 45 - Indent Closed 
					}
				}
				ws.beforeFirst();
				
				
			       sb.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center'  border='0' cellspacing ='1px'>"); 
				   if(vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("18")||vo.getStrReqTypeId().equals("19"))
				   {
					    sb.append("<tr>");
					    sb.append("<td width='20%' class='multiLabel'>Item Name</td>");
					    sb.append("<td width='15%' class='multiLabel'>Batch No</td>"); 					
					    sb.append("<td width='15%' class='multiLabel'>Req Qty</td>");
					    sb.append("<td width='15%' class='multiLabel'>Approved Qt/Issue Qty</td>");					
					    sb.append("</tr>");   
				   }
				   else
				   {	   
				        sb.append("<tr>");
					    sb.append("<td width='40%' class='multiLabel'>Item Name</td>");				
					    sb.append("<td width='15%' class='multiLabel'>Req Qty</td>");
					    if(strIndentStatus.equals("99"))
					    {
					    	sb.append("<td width='15%' class='multiLabel'>Approved Qt/Issue Qty</td>");
					    }
					    else
					    {
					        sb.append("<td width='15%' class='multiLabel'>Approved Qty</td>");
					    }
					    sb.append("</tr>");
				   }  
				  
				      if (ws1 != null) 
					  {
						   String strItemName   = null;
					       String strAvlQty = null;
					       String strReqQty = null;
					       String strSancQty = null;
					       String strRate = null;
					       String strIssueQty = null;
					       String strReOrderLevel = null;
					       String strLstIndentQty = null;
					       String strLstIssueQty = null;
					       String strLstYerConsump = null;
					       String strLstPoNo = null;
					       String strLstPODate = null;
					       String strLstRecQty = null;
					       String strLstRecDate = null;
					       String strLstSupplBy =null;
					       String strExpDate = null;
					       String strGrpName = null;
					       String strSubGrpName = null;
					       String strBatchNo = null;
					       			       
					       while(ws1.next())
					       {
					    	    if(vo.getStrReqTypeId().equals("11")||vo.getStrReqTypeId().equals("86")||vo.getStrReqTypeId().equals("90"))
					    	    {
					    	    	strLstPoNo       = ws1.getString(1);
					    	    	strLstPODate     = ws1.getString(2);
					    	    	strLstRecDate    = ws1.getString(3);
					    	    	strLstSupplBy    = ws1.getString(4);
					    	    	strLstYerConsump = ws1.getString(5);
					    	    	strReOrderLevel  = ws1.getString(6);
					    	    	strLstRecQty     = ws1.getString(7);
					    	    	
					    	    	strItemName    = ws1.getString(8);
							        strAvlQty      = ws1.getString(9);
							        strReqQty      = ws1.getString(10);
							        strSancQty     = ws1.getString(11);
							        strRate        = ws1.getString(12);
							        strHiddenValue = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strLstSupplBy+"^"+strLstYerConsump+"^"+strReOrderLevel+"^"+strLstRecQty+"^"+strItemName;
							        
					    	    }	
					    	    if(vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("19") )
					    	    {
					    	    	strLstPoNo      = ws1.getString(1);
					    	    	strLstPODate    = ws1.getString(2);
					    	    	strLstRecDate   = ws1.getString(3);
					    	    	strExpDate      = ws1.getString(4);
					    	    	strLstSupplBy   = ws1.getString(5);
					    	    	strGrpName      = ws1.getString(6);
					    	    	strSubGrpName   = ws1.getString(7);
					    	    	strBatchNo      = ws1.getString(8);
					    	    	
					    	    	strItemName     = ws1.getString(9);
							        strAvlQty       = ws1.getString(10);
							        strReqQty       = ws1.getString(11);
							        strSancQty      = ws1.getString(12);
							        strRate         = ws1.getString(13);
						            strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strExpDate+"^"+strLstSupplBy+"^"+strGrpName+"^"+strSubGrpName+"^"+strItemName;
					    	    }	
					    	    
					    	    if(vo.getStrReqTypeId().equals("15"))
					    	    {
					    	    	strLstPoNo      = ws1.getString(1);
					    	    	strLstPODate    = ws1.getString(2);
					    	    	strLstRecDate   = ws1.getString(3);
					    	    	strLstSupplBy   = ws1.getString(4);
					    	    	strGrpName      = ws1.getString(5);
					    	    	strSubGrpName   = ws1.getString(6);
					    	    	
					    	    	strItemName     = ws1.getString(7);
							        strAvlQty       = ws1.getString(8);
							        strReqQty       = ws1.getString(9);
							        strSancQty      = ws1.getString(10);
							        strRate         = ws1.getString(11);
						            strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strLstSupplBy+"^"+strGrpName+"^"+strSubGrpName+"^"+strItemName;
					    	    }	
					    	    	    
					    	    
					    	    if(vo.getStrReqTypeId().equals("18"))
					    	    {
					    	    	strLstPoNo      = ws1.getString(1);
					    	    	strLstPODate    = ws1.getString(2);
					    	    	strGrpName      = ws1.getString(3);
					    	    	strSubGrpName   = ws1.getString(4);
					    	    	strExpDate      = ws1.getString(5);
					    	    	strBatchNo      = ws1.getString(6);
					    	    	strItemName     = ws1.getString(7);
							        strAvlQty       = ws1.getString(8);
							        strReqQty       = ws1.getString(9);
							        strSancQty      = ws1.getString(10);
							        strRate         = ws1.getString(11);
							        strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strGrpName+"^"+strSubGrpName+"^"+strExpDate+"^"+strItemName;
					    	    }	
					    	    if(vo.getStrReqTypeId().equals("17"))
					    	    {
					    	    	strIssueQty      = ws1.getString(1);
					    	    	strReOrderLevel  = ws1.getString(2);
					    	    	strLstIndentQty  = ws1.getString(3);
					    	    	strLstIssueQty   = ws1.getString(4);
					    	    	strItemName      = ws1.getString(5);
							        strAvlQty        = ws1.getString(6);
							        strReqQty        = ws1.getString(7);
							        strSancQty       = ws1.getString(8);
							        strRate          = ws1.getString(9);
							        strHiddenValue   = strIssueQty+"^"+strReOrderLevel+"^"+strLstIndentQty+"^"+strLstIssueQty+"^"+strItemName;
					    	    }	
					    	    			    	     		    	   
						  	    if(strItemName == null || strItemName.equals("")) strItemName = "-----";
								if(strAvlQty == null || strAvlQty.equals("")) strAvlQty = "-----";
								if(strReqQty == null || strReqQty.equals("")) strReqQty = "-----";
								if(strSancQty == null || strSancQty.equals("")) strSancQty = "-----";
								if(strRate == null || strRate.equals("")) strRate = "-----";
								if(strBatchNo == null || strBatchNo.equals("")) strBatchNo = "-----";
								
								if(vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("18")|| vo.getStrReqTypeId().equals("19"))
								{
								 
									 sb.append("<input type='hidden' name ='strHiddenValue'  value='"+strHiddenValue+"'>");
									 sb.append("<tr>");
									 sb.append("<td width='20%' class='multiControl'>");
									 sb.append(strItemName);
									 sb.append("</td>");
									 sb.append("<td width='15%' class='multiControl'>");
									 sb.append(strBatchNo);
									 sb.append("</td>");
									 sb.append("<td width='15%' class='multiControl'>");
									 sb.append(strReqQty);
									 sb.append("</td>");						
									 sb.append("<td width='15%' class='multiControl'>");
									 sb.append(strSancQty);
									 sb.append("</td>");
									 sb.append("</tr>");
																	
								}
								else
								{	
									 sb.append("<input type='hidden' name ='strHiddenValue'  value='"+strHiddenValue+"'>");
									 sb.append("<tr>");
									 sb.append("<td width='40%' class='multiControl' style=\'text-align:left;\'>");
									 sb.append(strItemName);
									 sb.append("</td>");
									 sb.append("<td width='15%' class='multiControl'>");
									 sb.append(strReqQty);
									 sb.append("</td>");					
									 sb.append("<td width='15%' class='multiControl'>");
									 if(strIndentStatus.equals("99"))
									 {
										 sb.append(strSancQty+"/ NA ");
									 }
									 else
									 {
										 
										 sb.append(strSancQty);
									 }
									 sb.append("</td>");
									 sb.append("</tr>");
								}
								i++;
							}
						 sb.append("</table>");
				  	     
			 	  }else {
					    sb.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center'  border='0'  cellspacing ='1px'>"); 
					    sb.append("<tr>");
					    sb.append("<td colspan='5'  CLASS='multiControl' >"
								+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

					    sb.append("</tr>");
					    sb.append("</table>");
						
				   } 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			    vo.setStrMsgString("IndentViewTransHLP.getItemDetails() --> "+e.getMessage());
				vo.setStrMsgType("1");
			}
		return sb.toString();
		}
	   
	public static String getItemDetailsPrint(IndentViewTransVO vo)
	 		{
	 		    StringBuffer sb = new StringBuffer("");
	 		    String strHiddenValue ="",strIndentStatus=""; 
	 			WebRowSet ws1 = vo.getStrItemDetailsWs();
	 			int i=0;
	 			try 
	 			{
	 				
	 				WebRowSet ws = vo.getStrIndentDetailsWs();
	 				if (ws != null && ws.size() > 0) 
	 				{
	 					if (ws.next()) 
	 					{
	 						 strIndentStatus   = ws.getString(7);  // 99 - Rejected  50- Processed 40 - Final Approved 49 - In-Process 45 - Indent Closed 
	 					}
	 				}
	 				ws.beforeFirst();
	 				
	 				  sb.append("<table width='825' align='center' cellpadding='1' cellspacing='1' border='0' style='font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px;'>");
			      
		 				 if (vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("18") || vo.getStrReqTypeId().equals("19")) {
		 				    sb.append("<tr bgcolor='#cdc9c9'>");
		 				    sb.append("<td align='center' width='20%'><font><b>Item Name</b></font></td>");
		 				    sb.append("<td align='center' width='15%'><font><b>Batch No</b></font></td>");
		 				    sb.append("<td align='center' width='15%'><font><b>Req Qty</b></font></td>");
		 				    sb.append("<td align='center' width='15%'><font><b>Approved / Issue Qty</b></font></td>");
		 				    sb.append("</tr>");
		 				}  
		 			
	 				   else
	 				   {	   
		 				
		 				sb.append("<tr bgcolor='#cdc9c9'>");
		 				sb.append("<td align='center' width='40%'><font><b>Item Name</b></font></td>");
		 				sb.append("<td align='center' width='15%'><font><b>Req Qty</b></font></td>");
		 				//sb.append("</tr>");

		 				if(strIndentStatus.equals("99"))
		 				{
			 				sb.append("<td align='center' width='15%'><font><b>Issue Qty</b></font>");
			 				sb.append("</td> ");
		 				}
		 				else
		 				{
		 					sb.append("<td align='center' width='15%'><font><b>Approved/Issue Qty</b></font>");
			 				sb.append("</td> ");
		 				}
					    sb.append("</tr>");   
	 				   }
	 				   
	 				  
	 				      if (ws1 != null) 
	 					  {
	 						   String strItemName   = null;
	 					       String strAvlQty = null;
	 					       String strReqQty = null;
	 					       String strSancQty = null;
	 					       String strRate = null;
	 					       String strIssueQty = null;
	 					       String strReOrderLevel = null;
	 					       String strLstIndentQty = null;
	 					       String strLstIssueQty = null;
	 					       String strLstYerConsump = null;
	 					       String strLstPoNo = null;
	 					       String strLstPODate = null;
	 					       String strLstRecQty = null;
	 					       String strLstRecDate = null;
	 					       String strLstSupplBy =null;
	 					       String strExpDate = null;
	 					       String strGrpName = null;
	 					       String strSubGrpName = null;
	 					       String strBatchNo = null;
	 					       			       
	 					       while(ws1.next())
	 					       {
	 					    	    if(vo.getStrReqTypeId().equals("11")||vo.getStrReqTypeId().equals("86")||vo.getStrReqTypeId().equals("90"))
	 					    	    {
	 					    	    	strLstPoNo       = ws1.getString(1);
	 					    	    	strLstPODate     = ws1.getString(2);
	 					    	    	strLstRecDate    = ws1.getString(3);
	 					    	    	strLstSupplBy    = ws1.getString(4);
	 					    	    	strLstYerConsump = ws1.getString(5);
	 					    	    	strReOrderLevel  = ws1.getString(6);
	 					    	    	strLstRecQty     = ws1.getString(7);
	 					    	    	
	 					    	    	strItemName    = ws1.getString(8);
	 							        strAvlQty      = ws1.getString(9);
	 							        strReqQty      = ws1.getString(10);
	 							        strSancQty     = ws1.getString(11);
	 							        strRate        = ws1.getString(12);
	 							        strHiddenValue = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strLstSupplBy+"^"+strLstYerConsump+"^"+strReOrderLevel+"^"+strLstRecQty+"^"+strItemName;
	 							        
	 					    	    }	
	 					    	    if(vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("19") )
	 					    	    {
	 					    	    	strLstPoNo      = ws1.getString(1);
	 					    	    	strLstPODate    = ws1.getString(2);
	 					    	    	strLstRecDate   = ws1.getString(3);
	 					    	    	strExpDate      = ws1.getString(4);
	 					    	    	strLstSupplBy   = ws1.getString(5);
	 					    	    	strGrpName      = ws1.getString(6);
	 					    	    	strSubGrpName   = ws1.getString(7);
	 					    	    	strBatchNo      = ws1.getString(8);
	 					    	    	
	 					    	    	strItemName     = ws1.getString(9);
	 							        strAvlQty       = ws1.getString(10);
	 							        strReqQty       = ws1.getString(11);
	 							        strSancQty      = ws1.getString(12);
	 							        strRate         = ws1.getString(13);
	 						            strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strExpDate+"^"+strLstSupplBy+"^"+strGrpName+"^"+strSubGrpName+"^"+strItemName;
	 					    	    }	
	 					    	    
	 					    	    if(vo.getStrReqTypeId().equals("15"))
	 					    	    {
	 					    	    	strLstPoNo      = ws1.getString(1);
	 					    	    	strLstPODate    = ws1.getString(2);
	 					    	    	strLstRecDate   = ws1.getString(3);
	 					    	    	strLstSupplBy   = ws1.getString(4);
	 					    	    	strGrpName      = ws1.getString(5);
	 					    	    	strSubGrpName   = ws1.getString(6);
	 					    	    	
	 					    	    	strItemName     = ws1.getString(7);
	 							        strAvlQty       = ws1.getString(8);
	 							        strReqQty       = ws1.getString(9);
	 							        strSancQty      = ws1.getString(10);
	 							        strRate         = ws1.getString(11);
	 						            strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strLstSupplBy+"^"+strGrpName+"^"+strSubGrpName+"^"+strItemName;
	 					    	    }	
	 					    	    	    
	 					    	    
	 					    	    if(vo.getStrReqTypeId().equals("18"))
	 					    	    {
	 					    	    	strLstPoNo      = ws1.getString(1);
	 					    	    	strLstPODate    = ws1.getString(2);
	 					    	    	strGrpName      = ws1.getString(3);
	 					    	    	strSubGrpName   = ws1.getString(4);
	 					    	    	strExpDate      = ws1.getString(5);
	 					    	    	strBatchNo      = ws1.getString(6);
	 					    	    	strItemName     = ws1.getString(7);
	 							        strAvlQty       = ws1.getString(8);
	 							        strReqQty       = ws1.getString(9);
	 							        strSancQty      = ws1.getString(10);
	 							        strRate         = ws1.getString(11);
	 							        strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strGrpName+"^"+strSubGrpName+"^"+strExpDate+"^"+strItemName;
	 					    	    }	
	 					    	    if(vo.getStrReqTypeId().equals("17") || vo.getStrReqTypeId().equals("23"))
	 					    	    {
	 					    	    	strIssueQty      = ws1.getString(1);
	 					    	    	strReOrderLevel  = ws1.getString(2);
	 					    	    	strLstIndentQty  = ws1.getString(3);
	 					    	    	strLstIssueQty   = ws1.getString(4);
	 					    	    	strItemName      = ws1.getString(5);
	 							        strAvlQty        = ws1.getString(6);
	 							        strReqQty        = ws1.getString(7);
	 							        strSancQty       = ws1.getString(8);
	 							        strRate          = ws1.getString(9);
	 							        strHiddenValue   = strIssueQty+"^"+strReOrderLevel+"^"+strLstIndentQty+"^"+strLstIssueQty+"^"+strItemName;
	 					    	    }	
	 					    	    			    	     		    	   
	 						  	    if(strItemName == null || strItemName.equals("")) strItemName = "-----";
	 								if(strAvlQty == null || strAvlQty.equals("")) strAvlQty = "-----";
	 								if(strReqQty == null || strReqQty.equals("")) strReqQty = "-----";
	 								if(strSancQty == null || strSancQty.equals("")) strSancQty = "-----";
	 								if(strRate == null || strRate.equals("")) strRate = "-----";
	 								if(strBatchNo == null || strBatchNo.equals("")) strBatchNo = "-----";
	 								
	 								if(vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("18")|| vo.getStrReqTypeId().equals("19"))
	 								{
	 									sb.append("<tr>");
	 									sb.append("<td align='left'   width='20%'><font size='2'>" + strItemName + "</font></td>");
	 									sb.append("<td align='center' width='15%'><font size='2'>" + strBatchNo + "</font></td>");
	 									sb.append("<td align='center' width='15%'><font size='2'>" + strReqQty + "</font></td>");
	 									sb.append("<td align='center' width='15%'><font size='2'>" + strSancQty + "</font></td>");
	 									sb.append("</tr>");
	 								}
	 								else
	 								{	
	 									sb.append("<tr>");
	 									sb.append("<td align='left' width='40%'><font size='2'>" + strItemName + "</font></td>");
	 									sb.append("<td align='center' width='15%'><font size='2'>" + strReqQty + "</font></td>");
	 									//sb.append("</tr>");
	 									
	 									if(strIndentStatus.equals("99"))
	 									{
		 									sb.append("<td align='center' width='15%'><font size='2'>NA</font></td>");

	 									}
	 									else
	 									{
		 									sb.append("<td align='center' width='15%'><font size='2'>" + strSancQty + "</font></td>");
	 									}
	 									
	 									sb.append("</tr>");
 									
	 								}
	 								i++;
	 							}
	 						 sb.append("</table>");
	 				  	     
	 			 	  }else {
		 					sb.append("<table width='825' align='center' cellpadding='1' cellspacing='1' border='0' style='font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px;'>");
		 					sb.append("<tr>");
		 					sb.append("<td align='center' colspan='5'><font><b>No Record Found</b></font></td>");
		 					sb.append("</tr>");
		 					sb.append("</table>");
	 				   } 
	 			}
	 			catch(Exception e)
	 			{
	 				e.printStackTrace();
	 			    vo.setStrMsgString("IndentViewTransHLP.getItemDetails() --> "+e.getMessage());
	 				vo.setStrMsgType("1");
	 			}
	 		return sb.toString();
	 		}
	
    public static String getItemDetailsBS(IndentViewTransVO vo)
	{
	    StringBuffer sb = new StringBuffer("");
	    String strHiddenValue =""; 
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		int i=0;
		try 
		{
		       sb.append("<table class='table'>");
		       sb.append("<thead class='thead-dark'>"); 
			   if(vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("18")||vo.getStrReqTypeId().equals("19"))
			   {
				    sb.append("<tr>");
				    sb.append("<th width='30%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
				    sb.append("<th width='30%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Batch No</th>"); 
				 //   sb.append("<th width='15%' class='multiLabel'>Aval Qty</th>"); 
				    sb.append("<th width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
				    sb.append("<th width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Approved Qty</th>");
				 //   sb.append("<th width='20%' class='multiLabel'>Rate/Unit</th>");
				    
				    sb.append("</tr>");
				    sb.append("</thead>");   
			   }
			   else
			   {	   
			    sb.append("<tr>");
			    sb.append("<th width='40%' align='center'style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
			  //  sb.append("<th width='15%' class='multiLabel'>Avalaible Qty</th>"); 
			    sb.append("<th width='30%' align='center'style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
			    sb.append("<th width='30%' align='center'style='font-weight:350 !important ;font-size: 16px !important;'>Approved Qty</th>");
			   // sb.append("<th width='15%' class='multiLabel'>Rate/Unit</th>");
			    sb.append("</tr>");
			   }
			   sb.append("</thead><tbody>"); 
			  
			      if (ws1 != null) 
				  {
					   String strItemName   = null;
				       String strAvlQty = null;
				       String strReqQty = null;
				       String strSancQty = null;
				       String strRate = null;
				       String strIssueQty = null;
				       String strReOrderLevel = null;
				       String strLstIndentQty = null;
				       String strLstIssueQty = null;
				       String strLstYerConsump = null;
				       String strLstPoNo = null;
				       String strLstPODate = null;
				       String strLstRecQty = null;
				       String strLstRecDate = null;
				       String strLstSupplBy =null;
				       String strExpDate = null;
				       String strGrpName = null;
				       String strSubGrpName = null;
				       String strBatchNo = null;
				       			       
				       while(ws1.next())
				       {
				    	    if(vo.getStrReqTypeId().equals("11")||vo.getStrReqTypeId().equals("86")||vo.getStrReqTypeId().equals("90"))
				    	    {
				    	    	strLstPoNo       = ws1.getString(1);
				    	    	strLstPODate     = ws1.getString(2);
				    	    	strLstRecDate    = ws1.getString(3);
				    	    	strLstSupplBy    = ws1.getString(4);
				    	    	strLstYerConsump = ws1.getString(5);
				    	    	strReOrderLevel  = ws1.getString(6);
				    	    	strLstRecQty     = ws1.getString(7);
				    	    	
				    	    	strItemName    = ws1.getString(8);
						        strAvlQty      = ws1.getString(9);
						        strReqQty      = ws1.getString(10);
						        strSancQty     = ws1.getString(11);
						        strRate        = ws1.getString(12);
						        strHiddenValue = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strLstSupplBy+"^"+strLstYerConsump+"^"+strReOrderLevel+"^"+strLstRecQty+"^"+strItemName;
						        
				    	    }	
				    	    if(vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("19") )
				    	    {
				    	    	strLstPoNo      = ws1.getString(1);
				    	    	strLstPODate    = ws1.getString(2);
				    	    	strLstRecDate   = ws1.getString(3);
				    	    	strExpDate      = ws1.getString(4);
				    	    	strLstSupplBy   = ws1.getString(5);
				    	    	strGrpName      = ws1.getString(6);
				    	    	strSubGrpName   = ws1.getString(7);
				    	    	strBatchNo      = ws1.getString(8);
				    	    	
				    	    	strItemName     = ws1.getString(9);
						        strAvlQty       = ws1.getString(10);
						        strReqQty       = ws1.getString(11);
						        strSancQty      = ws1.getString(12);
						        strRate         = ws1.getString(13);
					            strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strExpDate+"^"+strLstSupplBy+"^"+strGrpName+"^"+strSubGrpName+"^"+strItemName;
				    	    }	
				    	    
				    	    if(vo.getStrReqTypeId().equals("15"))
				    	    {
				    	    	strLstPoNo      = ws1.getString(1);
				    	    	strLstPODate    = ws1.getString(2);
				    	    	strLstRecDate   = ws1.getString(3);
				    	    	strLstSupplBy   = ws1.getString(4);
				    	    	strGrpName      = ws1.getString(5);
				    	    	strSubGrpName   = ws1.getString(6);
				    	    	
				    	    	strItemName     = ws1.getString(7);
						        strAvlQty       = ws1.getString(8);
						        strReqQty       = ws1.getString(9);
						        strSancQty      = ws1.getString(10);
						        strRate         = ws1.getString(11);
					            strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strLstSupplBy+"^"+strGrpName+"^"+strSubGrpName+"^"+strItemName;
				    	    }	
				    	    	    
				    	    
				    	    if(vo.getStrReqTypeId().equals("18"))
				    	    {
				    	    	strLstPoNo      = ws1.getString(1);
				    	    	strLstPODate    = ws1.getString(2);
				    	    	strGrpName      = ws1.getString(3);
				    	    	strSubGrpName   = ws1.getString(4);
				    	    	strExpDate      = ws1.getString(5);
				    	    	strBatchNo      = ws1.getString(6);
				    	    	strItemName     = ws1.getString(7);
						        strAvlQty       = ws1.getString(8);
						        strReqQty       = ws1.getString(9);
						        strSancQty      = ws1.getString(10);
						        strRate         = ws1.getString(11);
						        strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strGrpName+"^"+strSubGrpName+"^"+strExpDate+"^"+strItemName;
				    	    }	
				    	    if(vo.getStrReqTypeId().equals("17") || vo.getStrReqTypeId().equals("23"))
				    	    {
				    	    	strIssueQty      = ws1.getString(1);
				    	    	strReOrderLevel  = ws1.getString(2);
				    	    	strLstIndentQty  = ws1.getString(3);
				    	    	strLstIssueQty   = ws1.getString(4);
				    	    	strItemName      = ws1.getString(5);
						        strAvlQty        = ws1.getString(6);
						        strReqQty        = ws1.getString(7);
						        strSancQty       = ws1.getString(8);
						        strRate          = ws1.getString(9);
						        strHiddenValue   = strIssueQty+"^"+strReOrderLevel+"^"+strLstIndentQty+"^"+strLstIssueQty+"^"+strItemName;
				    	    }	
				    	    			    	     		    	   
					  	    if(strItemName == null || strItemName.equals("")) strItemName = "-----";
							if(strAvlQty == null || strAvlQty.equals("")) strAvlQty = "-----";
							if(strReqQty == null || strReqQty.equals("")) strReqQty = "-----";
							if(strSancQty == null || strSancQty.equals("")) strSancQty = "-----";
							if(strRate == null || strRate.equals("")) strRate = "-----";
							if(strBatchNo == null || strBatchNo.equals("")) strBatchNo = "-----";
							
							if(vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("18")|| vo.getStrReqTypeId().equals("19"))
							{
							 
								 sb.append("<input type='hidden' name ='strHiddenValue'  value='"+strHiddenValue+"'>");
								 sb.append("<tr>");
								 sb.append("<td width='30%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
			     		   		// sb.append("<a name='tarriff' value='' href='#' onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
			     		   		 //sb.append("<a name='tarriff' STYLE='cursor:pointer;cursor:pointer;color:blue;' title='Get Item Details' value=''  onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
								 sb.append(strItemName);
								 sb.append("</td>");
								 sb.append("<td width='30%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
								 sb.append(strBatchNo);
								// sb.append("</td>");								 
								// sb.append("<td width='15%' class='multiControl'>");
								// sb.append(strAvlQty);
								 sb.append("</td>");
								 sb.append("<td width='20%' align='center'style='font-weight:350 !important ;font-size: 16px !important;'>");
								 sb.append(strReqQty);
								 sb.append("</td>");
					
								 sb.append("<td width='20%' align='center'style='font-weight:350 !important ;font-size: 16px !important;'>");
								 sb.append(strSancQty);
								 sb.append("</td>");
//								 sb.append("<td  width='20%' class='multiControl'>");
//								 sb.append(strRate);
//								 sb.append("</td>");
								 sb.append("</tr>");
																
							}
							else
							{	
								 sb.append("<input type='hidden' name ='strHiddenValue'  value='"+strHiddenValue+"'>");
								 sb.append("<tr>");
								 sb.append("<td width='40%' align='left' style='font-weight:350 !important ;font-size: 16px !important;'>");
			     		   		 //sb.append("<a name='tarriff' value='' href='#' onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
			     		   		 //sb.append("<a name='tarriff' STYLE='cursor:pointer;cursor:pointer;color:blue;' title='Get Item Details' value=''  onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
								 sb.append(strItemName);
	//							 sb.append("</td>");
	//							 sb.append("<td width='15%' class='multiControl'>");
	//							 sb.append(strAvlQty);
								 sb.append("</td>");
								 sb.append("<td width='30%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
								 sb.append(strReqQty);
								 sb.append("</td>");
					
								 sb.append("<td width='30%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
								 sb.append(strSancQty);
								 sb.append("</td>");
	//							 sb.append("<td  width='15%' class='multiControl'>");
	//							 sb.append(strRate);
	//							 sb.append("</td>");
								 sb.append("</tr>");
							}
							i++;
						}
					 sb.append("</tbody></table>");
			  	     
		 	  }else {
				    sb.append("<table class='table'>"); 
				    sb.append("<tr>");
				    sb.append("<td colspan='5'  style='font-weight:350 !important ;font-size: 16px !important;' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

				    sb.append("</tr>");
				    sb.append("</table>");
					
			   } 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		    vo.setStrMsgString("IndentViewTransHLP.getItemDetails() --> "+e.getMessage());
			vo.setStrMsgType("1");
		}
	return sb.toString();
	}
   
    public static String getIndentDetailsModify(IndentViewTransVO vo)
    {
		
		StringBuffer sb = new StringBuffer("");
		
		try {
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
										
					String strReqNo       = ws.getString(1);
					String strStoreName   = ws.getString(2);
					String strIndentDate  = ws.getString(3);
					String strItemCatg    = ws.getString(4);
					String strIndentType  = ws.getString(5);
					String strToStore     = ws.getString(6);
					
					if (strStoreName == null)
						strStoreName = "----";
					if (strItemCatg == null)
						strItemCatg = "----";
					if (strReqNo == null)
						strReqNo = "----";
					if (strIndentDate == null)
						strIndentDate = "----";
					if (strIndentType == null)
						strIndentType = "----";
					if (strToStore == null)
						strToStore = "----";
					sb.append("<table class='TABLEWIDTH'  align='center'  border='0'  cellspacing ='1px'>");
					if(vo.getStrItemCategory()!=null && vo.getStrItemCategory().equals("10"))
						sb.append("<tr><td width='25%' class='LABEL'>Drug Warehouse Name</td>");
					else
						sb.append("<tr><td width='25%' class='LABEL'>Store Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strStoreName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Item Category</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strItemCatg);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Indent No</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strReqNo);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Indent Date</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentDate);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Indent Type</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentType);
					sb.append("</td>");
					if(vo.getStrItemCategory()!=null && vo.getStrItemCategory().equals("10"))
						sb.append("<td width='25%' class='LABEL'>To Drug Warehouse Name</td>");
					else
						sb.append("<td width='25%' class='LABEL'>To Store Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strToStore);
					sb.append("</td></tr>");
					sb.append("<tr>");
					 sb.append("<input type='hidden' name ='strIndentNo'  value='"+strReqNo+"'>");
					 sb.append("<input type='hidden' name ='strRaisingStore'  value='"+vo.getStrStoreId()+"'>");
					 //private String strIndentTypeId="";
					 sb.append("<input type='hidden' name ='strIndentTypeId'  value='"+vo.getStrReqTypeId()+"'>");
					 sb.append("</tr>");
					sb.append("</table>");
				}
			}
			else {
				    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#6097BC' cellspacing ='1px'>"); 
				    sb.append("<tr>");
				    sb.append("<td colspan='5'  CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

				    sb.append("</tr>");
				    sb.append("</table>");
					
			   } 
		}catch(Exception e){
			
			vo
				.setStrMsgString("IndentViewTransHLP.getItemDetails() --> "
						+e.getMessage());
			vo.setStrMsgType("1");
		}
	return sb.toString();
	}

    public static String getApprovalDetails(IndentViewTransVO vo){
		
		StringBuffer br = new StringBuffer("");
		
		try {
								
			WebRowSet wb = vo.getStrApprovalDetailsWs();
			
			if(wb != null && wb.size() > 0)
			{
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				while (wb.next())
				{
						
					/* 
					String strApprovedBy = wb.getString(1);
					String strApprovedDate = wb.getString(2);
					String strStatus = wb.getString(3);
					
					if(strApprovedBy == null || strApprovedBy.equals("null"))strApprovedBy = "";
					if(strApprovedDate == null || strApprovedDate.equals("null"))strApprovedDate = "";
					if(strStatus == null || strStatus.equals("null"))strStatus = "";
				
					br.append("<tr>");
					br.append("<td width='5%' class='multiControl'>");
					
					br.append("<td width='30%' class='multiControl'>"+strApprovedBy+"</td>");
					br.append("<td width='30%' class='multiControl'>"+strApprovedDate+"</td>");
					br.append("<td width='30%' class='multiControl'>"+strStatus+"</td>");

					br.append("</tr>");	
					count++;
					br.append("<input type='hidden' name='strSize' value='"+count+"'>");*/
					
				}
				br.append("</table>");
			}
			else
			{
				    br.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#6097BC' cellspacing ='1px'>"); 
				    br.append("<tr>");
				    br.append("<td colspan='5'  CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

				    br.append("</tr>");
				    br.append("</table>");
					
			 } 
		}catch(Exception e){
			
			vo
				.setStrMsgString("IndentViewTransHLP.getApprovalDetails() --> "
						+e.getMessage());
			vo.setStrMsgType("1");
		}
	return br.toString();
	}

    public static String getItemDetailsModify(IndentViewTransVO vo)
{
    StringBuffer sb = new StringBuffer("");
    String strHiddenValue =""; 
	WebRowSet ws1 = vo.getStrItemDetailsWs();
	int i=0;
	try 
	{
	       sb.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center'  border='0' cellspacing ='1px'>"); 
		   if(vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("18")||vo.getStrReqTypeId().equals("19"))
		   {
			    sb.append("<tr>");
			    sb.append("<td width='20%' class='multiLabel'>Item Name</td>");
			    sb.append("<td width='15%' class='multiLabel'>Batch No</td>"); 
			  //  sb.append("<td width='15%' class='multiLabel'>Aval Qty</td>"); 
			    sb.append("<td width='15%' class='multiLabel'>Req Qty</td>");
			    sb.append("<td width='15%' class='multiLabel'>Approved Qty</td>");
			  //  sb.append("<td width='20%' class='multiLabel'>Rate/Unit</td>");
			    sb.append("</tr>");   
		   }
		   else
		   {	   
	        sb.append("<tr>");
		    sb.append("<td width='40%' class='multiLabel'>Item Name</td>");
		  //  sb.append("<td width='15%' class='multiLabel'>Avalaible Qty</td>"); 
		    sb.append("<td width='15%' class='multiLabel'>Req Qty</td>");
		   
		 //   sb.append("<td width='15%' class='multiLabel'>Rate/Unit</td>");
		    sb.append("</tr>");
		   }
		   
		  
		      if (ws1 != null) 
			  {
				   String strItemName   = null;
			       String strAvlQty = null;
			       String strReqQty = null;
			       String strSancQty = null;
			       String strRate = null;
			       String strIssueQty = null;
			       String strReOrderLevel = null;
			       String strLstIndentQty = null;
			       String strLstIssueQty = null;
			       String strLstYerConsump = null;
			       String strLstPoNo = null;
			       String strLstPODate = null;
			       String strLstRecQty = null;
			       String strLstRecDate = null;
			       String strLstSupplBy =null;
			       String strExpDate = null;
			       String strGrpName = null;
			       String strSubGrpName = null;
			       String strBatchNo = null;
			       int IntRecQty=0;
			       String strItemBrandIds="";
			       			       
			       while(ws1.next())
			       {
			    	    if(vo.getStrReqTypeId().equals("11")||vo.getStrReqTypeId().equals("86"))
			    	    {
			    	    	strLstPoNo       = ws1.getString(1);
			    	    	strLstPODate     = ws1.getString(2);
			    	    	strLstRecDate    = ws1.getString(3);
			    	    	strLstSupplBy    = ws1.getString(4);
			    	    	strLstYerConsump = ws1.getString(5);
			    	    	strReOrderLevel  = ws1.getString(6);
			    	    	strLstRecQty     = ws1.getString(7);
			    	    	
			    	    	strItemName    = ws1.getString(8);
					        strAvlQty      = ws1.getString(9);
					        strReqQty      = ws1.getString(10);
					        strReqQty = strReqQty.split(" ")[0];
					        strItemBrandIds = ws1.getString(14);
					        strSancQty     = ws1.getString(11);
					        strRate        = ws1.getString(12);
					        strHiddenValue = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strLstSupplBy+"^"+strLstYerConsump+"^"+strReOrderLevel+"^"+strLstRecQty+"^"+strItemName;
					        
			    	    }	
			    	    if(vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("19") )
			    	    {
			    	    	strLstPoNo      = ws1.getString(1);
			    	    	strLstPODate    = ws1.getString(2);
			    	    	strLstRecDate   = ws1.getString(3);
			    	    	strExpDate      = ws1.getString(4);
			    	    	strLstSupplBy   = ws1.getString(5);
			    	    	strGrpName      = ws1.getString(6);
			    	    	strSubGrpName   = ws1.getString(7);
			    	    	strBatchNo      = ws1.getString(8);
			    	    	
			    	    	strItemName     = ws1.getString(9);
					        strAvlQty       = ws1.getString(10);
					        strReqQty       = ws1.getString(11);
					        strSancQty      = ws1.getString(12);
					        strRate         = ws1.getString(13);
				            strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strExpDate+"^"+strLstSupplBy+"^"+strGrpName+"^"+strSubGrpName+"^"+strItemName;
			    	    }	
			    	    
			    	    if(vo.getStrReqTypeId().equals("15"))
			    	    {
			    	    	strLstPoNo      = ws1.getString(1);
			    	    	strLstPODate    = ws1.getString(2);
			    	    	strLstRecDate   = ws1.getString(3);
			    	    	strLstSupplBy   = ws1.getString(4);
			    	    	strGrpName      = ws1.getString(5);
			    	    	strSubGrpName   = ws1.getString(6);
			    	    	
			    	    	strItemName     = ws1.getString(7);
					        strAvlQty       = ws1.getString(8);
					        strReqQty       = ws1.getString(9);
					        strSancQty      = ws1.getString(10);
					        strRate         = ws1.getString(11);
				            strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strLstSupplBy+"^"+strGrpName+"^"+strSubGrpName+"^"+strItemName;
			    	    }	
			    	    	    
			    	    
			    	    if(vo.getStrReqTypeId().equals("18"))
			    	    {
			    	    	strLstPoNo      = ws1.getString(1);
			    	    	strLstPODate    = ws1.getString(2);
			    	    	strGrpName      = ws1.getString(3);
			    	    	strSubGrpName   = ws1.getString(4);
			    	    	strExpDate      = ws1.getString(5);
			    	    	strBatchNo      = ws1.getString(6);
			    	    	strItemName     = ws1.getString(7);
					        strAvlQty       = ws1.getString(8);
					        strReqQty       = ws1.getString(9);
					        strSancQty      = ws1.getString(10);
					        strRate         = ws1.getString(11);
					        strHiddenValue  = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strGrpName+"^"+strSubGrpName+"^"+strExpDate+"^"+strItemName;
			    	    }	
			    	    if(vo.getStrReqTypeId().equals("17"))
			    	    {
			    	    	strIssueQty      = ws1.getString(1);
			    	    	strReOrderLevel  = ws1.getString(2);
			    	    	strLstIndentQty  = ws1.getString(3);
			    	    	strLstIssueQty   = ws1.getString(4);
			    	    	strItemName      = ws1.getString(5);
					        strAvlQty        = ws1.getString(6);
					        System.out.println("strReqQty+++>>"+strReqQty);
					         
					        strReqQty        = ws1.getString(7).split(" ")[0];
					        strSancQty       = ws1.getString(8);
					        strRate          = ws1.getString(9);
					        //added by shefali garg on 13 Nov 2014
					        if(strItemBrandIds!="")
					        strItemBrandIds = strItemBrandIds+"^"+ws1.getString(13);
					        else
					        strItemBrandIds = ws1.getString(13);
					      //  strItemQtyModified= ws1.getString(arg0)
					        strHiddenValue   = strIssueQty+"^"+strReOrderLevel+"^"+strLstIndentQty+"^"+strLstIssueQty+"^"+strItemName;
			    	    }	
			    	    			    	     		    	   
				  	    if(strItemName == null || strItemName.equals("")) strItemName = "-----";
						if(strAvlQty == null || strAvlQty.equals("")) strAvlQty = "-----";
						if(strReqQty == null || strReqQty.equals("")) strReqQty = "-----";
						if(strSancQty == null || strSancQty.equals("")) strSancQty = "-----";
						if(strRate == null || strRate.equals("")) strRate = "-----";
						if(strBatchNo == null || strBatchNo.equals("")) strBatchNo = "-----";
						
						if(vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("18")|| vo.getStrReqTypeId().equals("19"))
						{
						 
							 sb.append("<input type='hidden' name ='strHiddenValue'  value='"+strHiddenValue+"'>");
							 
							 sb.append("<tr>");
							 sb.append("<td width='20%' class='multiControl'>");
		     		   		// sb.append("<a name='tarriff' value='' href='#' onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
		     		   		 //sb.append("<a name='tarriff' STYLE='cursor:pointer;cursor:pointer;color:blue;' title='Get Item Details' value=''  onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrReqTypeId()+"\");'>"+strItemName+"</a>");
							 sb.append(strItemName);
							 sb.append("</td>");
							 sb.append("<td width='15%' class='multiControl'>");
							 sb.append(strBatchNo);
							 sb.append("</td>");								 
							// sb.append("<td width='15%' class='multiControl'>");
							// sb.append(strAvlQty);
							// sb.append("</td>");
							 sb.append("<td width='15%' class='multiControl'>");
							 sb.append("input type='text' name ='strReqQty'  value='"+strReqQty+"'>");

						
							 sb.append("</td>");
				
							 sb.append("<td width='15%' class='multiControl'>");
							 sb.append(strSancQty);
							 sb.append("</td>");
							 sb.append("</tr>");
															
						}
						else
						{	
						 sb.append("<input type='hidden' name ='strHiddenValue'  value='"+strHiddenValue+"'>");
						 sb.append("<tr>");
						 sb.append("<td width='40%' class='multiControl' style=\'text-align:left;\'>");
						 sb.append(strItemName);
						 sb.append("</td>");
						 sb.append("<td width='15%' class='multiControl'>");
						 sb.append("<input type='text' name ='strReqQty'  onkeypress='return validateData(event,5);' value='"+strReqQty+"'>");
						 sb.append("</td>");
			
					  
						 sb.append("</tr>");
						 sb.append("<tr>");
						}
						
						i++;
					}
			     sb.append("<tr><input type='hidden' name ='strItemBrandIds'  value='"+strItemBrandIds+"'>");
				 sb.append("<input type='hidden' name ='strModifedQty'  value=''></tr>");

			     sb.append("</table>");
		  	     
	 	  }else {
			    sb.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center'  border='0'  cellspacing ='1px'>"); 
			    sb.append("<tr>");
			    sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

			    sb.append("</tr>");
			    sb.append("</table>");
				
		   } 
	}
	catch(Exception e)
	{
		e.printStackTrace();
	    vo.setStrMsgString("IndentViewTransHLP.getItemDetails() --> "+e.getMessage());
		vo.setStrMsgType("1");
	}
	return sb.toString();
}
    
    public static String getIndentDetailsBS(IndentViewTransVO vo)
{
	
	StringBuffer sb = new StringBuffer("");
	
	try {
		WebRowSet ws = vo.getStrIndentDetailsWs();
		if (ws != null && ws.size() > 0) 
		{
			if (ws.next()) 
			{
				/*
	            1.Indent No
	            2.Store Name  
	            3.Indent Date
	            4.Catg Name
	            5.Indent Type Name
	            6.To_Store_Name
	            7.Indent Status
	            8.Indent Period
	            9.Approved By
	           10.Approval Date
	           11.Last Approval Level
	           12.Remarks 
	          */
									
				String strReqNo       = ws.getString(1);
				String strStoreName   = ws.getString(2);
				String strIndentDate  = ws.getString(3);
				String strItemCatg    = ws.getString(4);
				String strIndentType  = ws.getString(5);
				String strToStore     = ws.getString(6);
				String strRemarks     = ws.getString(12);
				
				if (strStoreName == null)
					strStoreName = "----";
				if (strItemCatg == null)
					strItemCatg = "----";
				if (strReqNo == null)
					strReqNo = "----";
				if (strIndentDate == null)
					strIndentDate = "----";
				if (strIndentType == null)
					strIndentType = "----";
				if (strToStore == null)
					strToStore = "----";
				
				sb.append("<div class='row'>");				
				sb.append("<div class='col-sm-2'><label>Store Name:</label>");
				sb.append("</div>");
				sb.append("<div class='col-sm-2' style='font-weight: initial;'>");
				sb.append(strStoreName);
				sb.append("</div>");
				sb.append("<div class='col-sm-2'><label>Category:<label>");
				sb.append("</div>");
				sb.append("<div class='col-sm-2' style='font-weight: initial;'>");
				sb.append(strItemCatg);
				sb.append("</div>");
				sb.append("<div class='col-sm-2'><label>Indent No:</label>");
				sb.append("</div>");
				sb.append("<div class='col-sm-2' style='font-weight: initial;'>");
				sb.append(strReqNo);
				sb.append("</div>");
				sb.append("</div>");
				
				sb.append("<div class='row'>");
				sb.append("<div class='col-sm-2'><label>Indent Date:</label>");
				sb.append("</div>");
				sb.append("<div class='col-sm-2' style='font-weight: initial;'>");
				sb.append(strIndentDate);
				sb.append("</div>");
				sb.append("<div class='col-sm-2'><label>Indent Type:</label>");
				sb.append("</div>");
				sb.append("<div class='col-sm-2' style='font-weight: initial;'>");
				sb.append(strIndentType);
				sb.append("</div>");					
				sb.append("<div class='col-sm-2'><label>To Store Name:</label>");
				sb.append("</div>");
				sb.append("<div class='col-sm-2' style='font-weight: initial;'>");
				sb.append(strToStore);
				sb.append("</div>");
				sb.append("</div>");				
				sb.append("<div class='row'>");
				sb.append("<div class='col-sm-2'><label>Remarks:</label>");
				sb.append("</div>");
				sb.append("<div class='col-sm-10' style='font-weight: initial;'><b>");
				sb.append(strRemarks);
				sb.append("</b></div>");				
				sb.append("</div>");
				
			}
		}
		else {
			    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#6097BC' cellspacing ='1px'>"); 
			    sb.append("<tr>");
			    sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

			    sb.append("</tr>");
			    sb.append("</table>");
				
		   } 
	}catch(Exception e){
		
		vo
			.setStrMsgString("IndentViewTransHLP.getItemDetails() --> "
					+e.getMessage());
		vo.setStrMsgType("1");
	}
return sb.toString();
}
    
    public static String getIndentDetails(IndentViewTransVO vo)
{
	
	StringBuffer sb = new StringBuffer("");
	
	try {
		WebRowSet ws = vo.getStrIndentDetailsWs();
		if (ws != null && ws.size() > 0) 
		{
			if (ws.next()) 
			{
									
				String strReqNo       	= ws.getString(1);
				String strStoreName   	= ws.getString(2);
				String strIndentDate  	= ws.getString(3);
				String strItemCatg    	= ws.getString(4);
				String strIndentType  	= ws.getString(5);
				String strToStore     	= ws.getString(6);
				String strIndentStatus  = ws.getString(7);  // 99 - Rejected  50- Processed 40 - Final Approved 49 - In-Process 45 - Indent Closed 
				
				if (strStoreName == null)
					strStoreName = "----";
				if (strItemCatg == null)
					strItemCatg = "----";
				if (strReqNo == null)
					strReqNo = "----";
				if (strIndentDate == null)
					strIndentDate = "----";
				if (strIndentType == null)
					strIndentType = "----";
				if (strToStore == null)
					strToStore = "----";
				sb.append("<table class='TABLEWIDTH'  align='center'  border='0'  cellspacing ='1px'>");
				if(strIndentStatus.equals("99"))
				{
				  sb.append("<tr><td  colspan='4' class='LABEL'><div align='center'>NA SLIP</div></td>");
				  sb.append("</tr>");
				}
				
				sb.append("<tr><td width='25%' class='LABEL'>Store Name</td>");
				sb.append("<td width='25%' class='CONTROL'>");
				sb.append(strStoreName);
				sb.append("</td>");
				sb.append("<td width='25%' class='LABEL'>Item Category</td>");
				sb.append("<td width='25%' class='CONTROL'>");
				sb.append(strItemCatg);
				sb.append("</td></tr>");
				sb.append("<tr><td width='25%' class='LABEL'>Indent No</td>");
				sb.append("<td width='25%' class='CONTROL'>");
				sb.append(strReqNo);
				sb.append("</td>");
				sb.append("<td width='25%' class='LABEL'>Indent Date</td>");
				sb.append("<td width='25%' class='CONTROL'>");
				sb.append(strIndentDate);
				sb.append("</td></tr>");
				sb.append("<tr><td width='25%' class='LABEL'>Indent Type</td>");
				sb.append("<td width='25%' class='CONTROL'>");
				sb.append(strIndentType);
				sb.append("</td>");
				sb.append("<td width='25%' class='LABEL'>To Store Name</td>");
				sb.append("<td width='25%' class='CONTROL'>");
				sb.append(strToStore);
				sb.append("</td></tr>");
				sb.append("</table>");
			}
		}
		else {
			    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#6097BC' cellspacing ='1px'>"); 
			    sb.append("<tr>");
			    sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

			    sb.append("</tr>");
			    sb.append("</table>");
				
		   } 
	}catch(Exception e){
		
		vo
			.setStrMsgString("IndentViewTransHLP.getItemDetails() --> "
					+e.getMessage());
		vo.setStrMsgType("1");
	}
return sb.toString();
}

    public static String getIndentDetailsPrint(IndentViewTransVO vo)
{
	
	StringBuffer sb = new StringBuffer("");
	
	try {
		WebRowSet ws = vo.getStrIndentDetailsWs();
		if (ws != null && ws.size() > 0) 
		{
			if (ws.next()) 
			{
				/*
	            1.Indent No
	            2.Store Name  
	            3.Indent Date
	            4.Catg Name
	            5.Indent Type Name
	            6.To_Store_Name
	            7.Indent Status
	            8.Indent Period
	            9.Approved By
	           10.Approval Date
	           11.Last Approval Level
	           12.Remarks 
	           13.Rejected By Approver Flag
	          */
				
				String strReqNo         = ws.getString(1);
				String strStoreName     = ws.getString(2);
				String strIndentDate    = ws.getString(3);
				String strItemCatg      = ws.getString(4);
				String strIndentType    = ws.getString(5);
				String strToStore       = ws.getString(6);
				String strIndentStatus  = ws.getString(7);  // 99 - Rejected  50- Processed 40 - Final Approved 49 - In-Process 45 - Indent Closed 
				String strIndentLevel   = ws.getString(11);
				String strRemarks       = ws.getString(12);
				String strRejectedByApp = ws.getString(13); // '89 ' -- 89 Rejected By Approver , -- 99  External / NA  , 0 Indent
				String strIndenter 		= ws.getString(14);
				
				
				if (strStoreName == null)
					strStoreName = "----";
				if (strItemCatg == null)
					strItemCatg = "----";
				if (strReqNo == null)
					strReqNo = "----";
				if (strIndentDate == null)
					strIndentDate = "----";
				if (strIndentType == null)
					strIndentType = "----";
				if (strToStore == null)
					strToStore = "----";
				
				System.out.println("--------- IndentViewTransHLP.getIndentDetailsPrint ------------");
				
				System.out.println("strIndentStatus  ----"+strIndentStatus);
				
				System.out.println("strRejectedByApp ----"+strRejectedByApp);
								
				
				sb.append("<table width='825' align='center' cellpadding='1' cellspacing='1' border='0' style='font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px;'>");

				if (strIndentStatus.equals("99") && vo.getStrHospitalCode().equals("21917")) // 21917
				{
				    sb.append("<tr>");
				    sb.append("<td align='center' colspan='4'><font size='2'><b><u> External Indent Slip </u></b></font></td>");
				    sb.append("</tr>");
				    sb.append("<tr>");
				    sb.append("<td align='center' colspan='4'><font size='2'><b><u>Indent book for Drugs/Consumables to be procured on emergency basis when not available at Central Pharmacy (within Rs.25000/-)</u><b></font></td>");
				    sb.append("</tr>");
				}
				else
				{
				    if (strIndentStatus.equals("99") && strRejectedByApp.equals("89"))
				    {
				        sb.append("<tr>");
				        sb.append("<td align='center' colspan='4'><font size='2'><b><u> Rejected By Approver </u></b></font></td>");				        
				        sb.append("</tr>");
				    }
				    else
				    {
				        if (strIndentStatus.equals("99") && strRejectedByApp.equals("99"))
				        {
				            sb.append("<tr style='text-decoration-line: underline;'>");
				            sb.append("<td align='center' colspan='4' style='margin-bottom: 1%;padding-bottom: 2%;'><font style='font-size: 96%;'><b><u> External / NA Certificate </u></b></font></td>");
				            sb.append("</tr>");
				        }
				        else
				        {
				            sb.append("<tr>");
				            sb.append("<td align='center' colspan='4'><font size='2'><b><u> Indent Slip </u></b></font></td>");
				            sb.append("</tr>");
				        }
				    }
				}

				sb.append("</table>");		
							
				sb.append("<table width='825' align='center' cellpadding='1' cellspacing='1' border='0' style='font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px;'>");

				sb.append("<tr>");
				sb.append("<td align='right' width='12%'><b >Raising Store:</b></td>");
				sb.append("<td align='left' width='16%'>" + strStoreName + "</td>");
				sb.append("<td align='right' width='12%'><b >Category:</b></td>");
				sb.append("<td align='left' width='16%'>" + strItemCatg + "</td>");
				sb.append("<td align='right' width='12%'><b >Indent Type:</b></td>");
				sb.append("<td align='left' width='16%'>" + strIndentType + "</td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append("<td align='right' width='12%'><b >Indent No:</b></td>");
				sb.append("<td align='left' width='20%'>" + strReqNo + "</td>");
				sb.append("<td align='right' width='12%'><b >Indent Date:</b></td>");
				sb.append("<td align='left' width='20%'>" + strIndentDate + "</td>");
				sb.append("<td align='right' width='12%'><b >To Store:</b></td>");
				sb.append("<td align='left' width='20%'>" + strToStore + "</td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append("<td align='right' width='12%'><b >Indenter :</b></td>");
				sb.append("<td align='left' width='20%'>" + strIndenter + "</td>");
				sb.append("<td align='right' colspan='1' width='12%'><b >Remarks:</b></td>");
				sb.append("<td align='left'  colspan='3'>" + strRemarks + "</td>");
				sb.append("</tr>");

				sb.append("</table>");


			}
		}
		else {
			    sb.append("<table width='825' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			    sb.append("<tr>");
			    sb.append("<td colspan='5'  >"
						+ "<DIV class='errMsg' align='center'> No Record Found For Selected Indent No.</div>" + "</TD>");

			    sb.append("</tr>");
			    sb.append("</table>");
				
		   } 
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
		vo
			.setStrMsgString("IndentViewTransHLP.getIndentDetailsPrint() --> "
					+e.getMessage());
		vo.setStrMsgType("1");
	}
return sb.toString();
}

}