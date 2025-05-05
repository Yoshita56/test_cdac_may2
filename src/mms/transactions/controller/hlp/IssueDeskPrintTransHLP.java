package mms.transactions.controller.hlp;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.MmsConfigUtil;
import mms.transactions.bo.IssueDeskPrintTransBO;
import mms.transactions.controller.fb.IssueDeskPrintTransFB;
import mms.transactions.vo.IssueDeskPrintTransVO;
import mms.transactions.vo.IssueDeskPrintTransVO;

public class IssueDeskPrintTransHLP 
{
	static int i = 0;
	
	public static String getIssueDtlsInitView(IssueDeskPrintTransFB formBean,IssueDeskPrintTransVO vo) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		int i=1;
		
		ResourceBundle res = null;
		WebRowSet ws  = null;
		WebRowSet ws1 = null;
		String strIndentRaisedBy = null,remarks="";
		
		String strTableWidth = "825",rem="";
		
		try 
		{
			res = mms.qryHandler_mms.res;
			if(res == null) 
			{
				res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = res;
			}

			ws  = vo.getStrItemDetailsWs();
			ws1 = vo.getStrIndentDetailsWs();
			
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(vo.getStrHospitalCode());
						
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>");
			//sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> &nbsp;&nbsp;&nbsp;");
			
			//sb.append("&nbsp;&nbsp;&nbsp;"+hospitalVO.getHospitalName());
			//sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
//			sb.append("<tr> ");
//			sb.append("<td width='8%'>&nbsp;</td> ");
//			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
//			sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
//			
//			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
//			sb.append("</tr> ");			
			sb.append("</table> ");	
			
			sb.append(
					"<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
			.append(strTableWidth)
			.append(
					"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue To Patient </b></font></td></tr></table> ");

			
			sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
				sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; '  name='PrintPage' tabindex='1' title='Print Page'");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();'/> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopupOne();' /></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
			
			if (ws1 != null && ws1.size() > 0) 
			{

				while (ws1.next()) 
				{
					/*
					 * 1.Req No
					 * 2.Indenting Store Name
					 * 3.Indent Date
					 * 4.Catg Name
					 * 5.Indent Type
					 * 6.To Store
					 * 7.Indent Status
					 * 8.Indent Period
					 * 9.Approved By
					 * 10.Approved Date
					 * 11.Approval Level
					 * 12.Patient Name ^ Catg Name
					 * 13.Indent Raised By
					 * 14.Remarks
					 * */
					
					String strReqNo       = ws1.getString(1);
					String strStoreName   = ws1.getString(2);
					String strIndentDate  = ws1.getString(3);
					String strItemCatg    = ws1.getString(4);
					String strIndentType  = ws1.getString(5);
					String strToStore     = ws1.getString(6);
					
					String strPatientName = ws1.getString(12).split("\\^")[0];
					String strPatientCatg = ws1.getString(12).split("\\^")[1];
					strIndentRaisedBy = ws1.getString(13);
					remarks = ws1.getString(14);
					
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
										
					sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");	
					
					sb.append("<tr> ");			
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Store Name:</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(strStoreName).append(
								"</font></td> ");
					
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Item Category:</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(strItemCatg).append(
								"</font></td> ");			
					sb.append("</tr> ");
					
					sb.append("<tr> ");	
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Indent No:</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(strReqNo).append(
								"</font></td> ");
					
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Indent Date:</b></font></td> ");
				    sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(strIndentDate)
							.append("</font></td> ");		     
				    sb.append("</tr> ");	
				    
				    sb.append("<tr> ");	
					
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Indent Type :</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(strIndentType).append(
								"</font></td> ");
					
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("To Store Name:</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(strToStore).append(
								"</font></td> ");					
					
					sb.append("</tr> ");	
					
                    sb.append("<tr> ");	
					
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Patient Dtls :</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrCrNo()+" / "+strPatientName).append(
								"</font></td> ");
					
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Patient Catg:</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(strPatientCatg).append(
								"</font></td> ");					
					
					sb.append("</tr> ");	
				
					sb.append("</table> ");
					
				}
			}			
			
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			/*
			 * sb.append("<tr>");
			 * sb.append("<td colspan='4' align='left'><hr size='2'></td>");
			 * sb.append("</tr>");
			 */
			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='10%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");					
			sb.append("<td align='center' width='45%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
			sb.append("</td>");				
			sb.append("<td align='right' width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Req Qty</b></font>");
			sb.append("</td> ");
			sb.append("<td align='right' width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Approved Qty</b></font>");
			sb.append("</td> ");    		
			sb.append("</tr> ");
			/*
			 * sb.append("<tr>");
			 * sb.append("<td colspan='4' align='left'><hr size='2'></td>");
			 * sb.append("</tr>");
			 */		
			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					/*
			    	    * 1.Issue  Qty/Unit
			    	    * 2.Return Qty/Unit
			    	    * 3.Item Name
			    	    * 4.Available Qty
			    	    * 5.Req Qty
			    	    * 6.Sanction Qty
			    	    * 7.Rate Per Unit
			    	    * 8.Cr_no
			    	    * 9.Patient Name
			    	    * 10.Emp No
			    	    * 11.Emp Name
			    	    * 12.Item Id
			    	    * 13.Item Brand id
			    	    * 14.Conversion Value
			    	    * 15.Unit Id
			    	    * 16.Round
			    	    * 17.req Qty Unit
			    	    * 18.Decode
			    	    * 19.Decode
			    	    * 20.NVL
			    	    * 21.Approval Remarks
			    	    * */		
									
					sb.append("<tr> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i+".");
					sb.append("</font></td> ");	
										
					sb.append("<td align='left' width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(ws.getString(3));
					sb.append("</font></td> ");					
					
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(5));
					sb.append("</font></td> ");	
					
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(5));
					sb.append("</font></td> ");
														
					sb.append("</tr> ");					
					i++;					
					rem=ws.getString(12);
					
								
				}								
									
					sb.append("<tr>");
					sb.append("<td colspan='4' align='left'><hr size='2'></td>");
								
					sb.append("</tr>");							
				
						
					sb.append("<tr>");
					sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks : </b></font>"+remarks+"</td>");
										
					sb.append("</tr>");
					
					sb.append("<tr>");					
					sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Raised By : </b></font> "+strIndentRaisedBy+"</td>");
					
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='4' align='left'></td>");
								
					sb.append("</tr>");
						
			        		
			} 
			else 
			{

				sb.append("<tr> ");
				sb.append("<td colspan='4' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}
			sb.append("</table> ");			
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr>");
			sb.append("<td width='10%'></td>");			
			sb.append("<td width='80%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			//sb.append(formBean.getStrHindiText());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");				
			sb.append("</table>"); 	

		} 
		catch (Exception e) 
		{

			e.printStackTrace();

			throw e;
		}
		finally
		{
			if(ws != null)
			{
				ws.close();
				ws = null;
			}
					
		}

		return sb.toString();
	  }
	
	public static String getIndentDetails(IssueDeskPrintTransVO vo)
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
				.setStrMsgString("IssueDeskPrintTransHLP.getItemDetails() --> "
						+e.getMessage());
			vo.setStrMsgType("1");
		}
	return sb.toString();
	}
	
	  public static String getItemDetails(IssueDeskPrintTransVO vo)
	  {
			    StringBuffer sb = new StringBuffer("");
			    String strHiddenValue =""; 
				WebRowSet ws1 = vo.getStrItemDetailsWs();
				int i=0;
				try 
				{
					   System.out.println("----------------- IssueDeskPrintTransHLP . getItemDetails  -----------------SIZE----"+ws1.size());
				        //sb.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center'  border='0' cellspacing ='1px'>"); 
				        sb.append("<table class='table'>"); 
				        sb.append("<thead class='thead-dark' align='center'>");
				        sb.append("<tr>");
					    sb.append("<th width='50%' style='font-weight:350 !important ;font-size: 15px !important;'>Item Name</th>");					  
					    sb.append("<th width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>Req Qty</th>");
					    sb.append("<th width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>Approved Qty</th>");					
					    sb.append("</tr>");
					    sb.append("</thead>");

					  
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
						    	   /*
						    	    * 1.Issue  Qty/Unit
						    	    * 2.Return Qty/Unit
						    	    * 3.Item Name
						    	    * 4.Available Qty
						    	    * 5.Req Qty
						    	    * 6.Sanction Qty
						    	    * 7.Rate Per Unit
						    	    * 8.Cr_no
						    	    * 9.Patient Name
						    	    * 10.Emp No
						    	    * 11.Emp Name
						    	    * 12.Item Id
						    	    * 13.Item Brand id
						    	    * 14.Conversion Value
						    	    * 15.Unit Id
						    	    * 16.Round
						    	    * 17.req Qty Unit
						    	    * 18.Decode
						    	    * 19.Decode
						    	    * 20.NVL
						    	    * 21.Approval Remarks
						    	    * */						    	   
					    	    	strItemName      = ws1.getString(3);
							        strAvlQty        = ws1.getString(4);
							        strReqQty        = ws1.getString(5);
							        strSancQty       = ws1.getString(6);
							        strRate          = ws1.getString(7);
							        strHiddenValue   = ws1.getString(12)+"^"+ws1.getString(13)+"^"+vo.getStrLpRequestNo()+"^"+vo.getStrCrNo()+"^"+vo.getStrRaisingStoreId()+"^"+vo.getStrStoreId();
							         sb.append("<tbody>");
									 sb.append("<input type='hidden' name ='strHiddenValue'  value='"+strHiddenValue+"'>");
								
									 sb.append("<tr>");
									 sb.append("<td width='50%' align:left style='font-weight:350 !important ;font-size: 15px !important;'>");
									 sb.append(strItemName);
									 sb.append("</td>");
									 
									 sb.append("<td width='25%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
									 sb.append(strReqQty);
									 sb.append("</td>");
						
									 sb.append("<td width='25%' align='center'style='font-weight:350 !important ;font-size: 15px !important;'>");
									 sb.append(strSancQty);
									 sb.append("</td>");

									 sb.append("</tr>");
									i++;
								}
						        	 sb.append("<tbody>");
							    sb.append("</table>");
					  	     
				 	  }
					  else 
				 	  {
						    sb.append("<table class='table'>"); 
						    	sb.append("<tr>");
						    			sb.append("<td colspan='5'><div class='errMsg' align='center'><font color='red'> NO RECORD FOUND FOR SELECTED INDENT NO.</font></div></td>");
						    	sb.append("</tr>");
						    sb.append("</table>");
					   } 
				}
				catch(Exception e)
				{
					e.printStackTrace();
				    vo.setStrMsgString("IssueDeskPrintTransHLP.getItemDetails() --> "+e.getMessage());
					vo.setStrMsgType("1");
				}
			return sb.toString();
			}
	
	public static String getItemDetails1(IssueDeskPrintTransVO vo)
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
			    	   if(vo.getStrRaisingReqTypeId().equals("14"))
			    	   {	   
			    		   strCrNo    = ws1.getString(10);
				    	   strPatName = ws1.getString(11);
				    	   strEmpID   = ws1.getString(12);
				    	   strEmpName = ws1.getString(13);
			    	   }
			    	   if(vo.getStrRaisingReqTypeId().equals("12")||vo.getStrRaisingReqTypeId().equals("13"))
			    	   {
			    		   strCrNo    = ws1.getString(8);
				    	   strPatName = ws1.getString(9);
				    	   strEmpID   = ws1.getString(10);
				    	   strEmpName = ws1.getString(11);
			    		   
			    	   } 
			    	   if(vo.getStrRaisingReqTypeId().equals("13"))
			    	   {
			    		   strCrNo    = ws1.getString(8);
				    	   strPatName = ws1.getString(9);
				    	   strEmpID   = ws1.getString(10);
				    	   strEmpName = ws1.getString(11);
				    	   		    		   
			    	   } 
			    	   if(vo.getStrRaisingReqTypeId().equals("10"))
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
						//System.out.println("Before Condition--->>"+vo.getStrRaisingReqTypeId());
					  if(!vo.getStrRaisingReqTypeId().equals("10"))
				      {
						if(!vo.getStrRaisingReqTypeId().equals("14"))
						{	
						 if(k==0)
					     {	  
			             sb.append("<table class='TABLEWIDTH' align='center'   border='0'  cellspacing ='1px'>");
			             sb.append("<tr><td width='25%' class='LABEL'>CR NO</td>");
			             sb.append("<td width='25%' class='CONTROL'>");
			             sb.append(strCrNo);
			             sb.append("</td>");
			             sb.append("<td width='25%' class='LABEL'>Patient Name</td>");
			             sb.append("<td width='25%' class='CONTROL'>");
			             sb.append(strPatName);
			             sb.append("</td></tr>");
			             ////System.out.println("Insde View HLP:-->>"+vo.getStrRaisingReqTypeId());
			             if(vo.getStrRaisingReqTypeId().equals("12"))
			             {	   
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
				    	   if(vo.getStrRaisingReqTypeId().equals("10"))
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
				    	   
				    	   
				    	    if(vo.getStrRaisingReqTypeId().equals("12") || vo.getStrRaisingReqTypeId().equals("13"))
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
				    	    if(vo.getStrRaisingReqTypeId().equals("14"))
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
		     		   		//sb.append("<a name='tarriff' STYLE='cursor:pointer;cursor:pointer;color:blue;' title='Get Item Details' value=''  onClick='callingPoPUp(this,"+i+",\""+strHiddenValue+"\",\""+vo.getStrRaisingReqTypeId()+"\");'>"+strItemName+"</a>");
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
		    vo.setStrMsgString("IssueDeskPrintTransHLP.getItemDetails() --> "+e.getMessage());
			vo.setStrMsgType("1");
		}
	return sb.toString();
	}

	/**
	 * This method is used to show item Details on ISSUE PAGE
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getItemDetails(WebRowSet wb)
			throws SQLException {
		StringBuffer buff = null;
		try{
			buff=new StringBuffer();
			
		int count=0;
			
	
			if(wb!=null)
			{
				buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				buff.append("<tr>");
				buff.append("<td class='multiLabel'>Item Name</td>");
				//buff.append("<td class='multiLabel'>Sanction Qty.</td>");
				buff.append("<td class='multiLabel'>Sanction Qty.</td>");
				buff.append("</tr>");
				if(wb.size()!=0) 
				{
					while(wb.next()){
					buff.append("<tr>");
					buff.append("<td class='multiControl'>"+wb.getString(1)+"</td>");
					//buff.append("<td class='multiControl'>"+wb.getString(2)+" "+wb.getString(3)+"</td>");
					buff.append("<td class='multiControl'><a  onclick='openSpecification(this,"+(++count)+");' style='color:blue; cursor:pointer;' title='Click Here To View Detail' >"+wb.getString(4)+" "+wb.getString(3)+"</a>");
					buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl"+count+"' value='"+wb.getString(2)+"@"+wb.getString(3)+"@"+wb.getString(5)+"'>");
					buff.append("</td>");
					buff.append("</tr>");
				 }
					buff.append("</table>");
				}
				else{
					buff.append("<tr>");
					buff.append("<td class='multiControl' colspan='3'><font color='red'>No Record Found/Patient is not admitted</font></td>");
					buff.append("</tr>");
				}
			}
		
		
		}catch(Exception _err){
			try{
				_err.printStackTrace();
				throw new Exception("IssueDeskPrintTransHLP---->getItemDetails"+_err.getMessage());
			}catch(Exception e){
				
			}
		}
		
		return buff.toString();
	}
	/**
	 * This method is used to show item Details on ISSUE PAGE
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getIssueItemDetails(WebRowSet wb,String strCostReq,String strIssueStoreID,String hosCode,String strRaisingStoreId,String lpReqNo,IssueDeskPrintTransVO voObj)
			throws SQLException {
		StringBuffer buff = null;
		Double itemFinalCost=0.0;
		IssueDeskPrintTransVO vo =null;
		IssueDeskPrintTransBO bo = null;
		try{
			vo = new IssueDeskPrintTransVO();
			bo = new IssueDeskPrintTransBO();
			buff=new StringBuffer();
			String strRate="";
			String strRateUnit="";
			String strManuFacturingDate="";
			String strExpiryDate="";
			String strInHandQty="";
			String strRateBaseValue="";
			String strItemId="";
			String strItemBrandId="";
			String strBatchSlNo="";
			String strIssueQty="";
			String strIssueUnitId="";
			String strItemName="";
			String strUnitName="";
			String hiddenParam="";
			String avlQty = "";
			String temp[]=null;
			Double itemCost=0.00;
			String strTotalNoOfBatch = "";
			String strMRP;
			String strHiddenId = ""; // item id^brandid^RESERVED FLAG^GROUPID^SUBGROUP ID^CONSUMABLE FLAG^strItemCategory^strRaisingStoreId
			String TariffFlag="0";
			String grp="";
			WebRowSet brandWs=null;
			int i=0;
			String tariffcnt;
	
			if(wb!=null)
			{
				
				buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				buff.append("<tr>");
				buff.append("<td width='20%' class='multiLabel' align='left'>Item Name</td>");
				buff.append("<td width='20%' class='multiLabel' align='left'>Item Type</td>");
				//buff.append("<td class='multiLabel'>Batch/Sl.no.</td>");
			//	buff.append("<td class='multiLabel'>Expiry Date</td>");
				buff.append("<td width='10%' class='multiLabel' align='left'>Available Qty</td>");
				buff.append("<td width='10%' class='multiLabel' align='left'>Sanction Qty</td>");
				//buff.append("<td class='multiLabel'>Rate/Unit</td>");
				buff.append("<td width='10%' class='multiLabel' align='left'>Issue Qty</td>");
				buff.append("<td width='10%' class='multiLabel' align='left'>Batch</td>");
				buff.append("<td width='10%' class='multiLabel' align='left'>Expiry</td>");
				//buff.append("<td width='10%' class='multiLabel' align='left'>M.R.P.</td>");
				if(lpReqNo.equals("0"))
					buff.append("<td width='10%' class='multiLabel' align='left'>LP Qty</td>");
				//buff.append("<td width='10%' class='multiLabel' align='left'>Remarks</td>");
				//if(strCostReq.equals("1"))
				//	buff.append("<td class='multiLabel'>Item Cost</td>");
				buff.append("</tr>");
				if(wb.size()!=0) 
				{
					
					while(wb.next()){
					
						i++;
						//temp=wb.getString(6).replace('^', '#').split("#");
						//strRate=temp[0];
						//strRateUnit=temp[1];
						//strManuFacturingDate=temp[2];
						//strExpiryDate=temp[3];
						//strInHandQty=temp[4];
						//strRateBaseValue=temp[5];
						//avlQty=temp[6];
						strItemId=wb.getString(1);
						strItemBrandId=wb.getString(2);
						avlQty = wb.getString(6);
						strBatchSlNo=wb.getString(9);
						strIssueQty=wb.getString(3);
						strIssueUnitId=wb.getString(4);
						strItemName=wb.getString(7);
						strUnitName=wb.getString(5);
						grp=wb.getString(13);
						tariffcnt=wb.getString(12);
						strHiddenId = wb.getString(1)+"^"+wb.getString(2); // item id^brand id
						strTotalNoOfBatch = wb.getString(8);
						strMRP=wb.getString(11)==null ? "0" : wb.getString(11);
						//if(lpReqNo.equals("0"))
							TariffFlag = "1";//wb.getString(12);
						vo.setStrHospitalCode(hosCode);
						voObj.setStrItemId(strItemId);
						
						if (Integer.parseInt(strTotalNoOfBatch) == 1) { // Item ID ^ ItemBrand Id ^ Batch No ^ StoreID
							vo.setStrSingleItemDtl(strHiddenId.split("\\^")[0]+ "^" + strHiddenId.split("\\^")[1] + "^"+ wb.getString(13) + "^" + strIssueStoreID+ "^"+vo.getStrItemCategNo());
							bo.getSingleBatchItemDtl(vo);
						}
						if (Integer.parseInt(strTotalNoOfBatch) == 0) { // Item ID ^ ItemBrand Id ^ Batch No ^ StoreID
							vo.setStrSingleBatchDtlWs(null);
						}
												
						hiddenParam=strItemId+"@"+strItemBrandId+"@"+strIssueQty+"@"+strIssueUnitId+"@"+avlQty+"@"+strBatchSlNo+"@"+strMRP+"@"+grp+"@"+tariffcnt;
					if(!strRate.equals("0")&&!strRateUnit.equals("0") && !strManuFacturingDate.equals("0") && !strInHandQty.equals("0")&& !avlQty.equals("0")){	
						buff.append("<tr>");
						buff.append("<td width='30%' class='multiControl'><div id='itmNm"+i+"'> "+strItemName+" </div><input type='hidden' id='strItemParamValue"+i+"' name='strItemParamValue' value='"+
								hiddenParam+
								"' /></td>");
						buff.append("<td width='10%' class='multiControl'><div id='itmtype"+i+"'> "+wb.getString(14)+" </div></td>");
						buff.append("<input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk"
								+ i + "' value='" + avlQty + "' />");
						
						//buff.append("<td class='multiControl'>"+strBatchSlNo+"</td>");
						//buff.append("<td class='multiControl'><font color='red'>"+strExpiryDate+"</font></td>");
								
						buff.append("</td>");
						buff.append("<td width='10%' width='10%' class='multiControl' align='left'>"+avlQty + " "+ strUnitName +"</td>");
						buff.append("<td width='10%' width='10%' class='multiControl' align='left'>"+strIssueQty + " "+ strUnitName +"</td>");
					//	buff.append("<td class='multiControl'>"+strRate+"/ "+strUnitName+"</td>");
						if(lpReqNo.equals("0"))
							if(Integer.parseInt(tariffcnt) > 0)
								buff.append("<td width='10%' class='multiControl' align='left'><input type='hidden' name='itmnotissued' id='itmnotissued"+i+"' value ='' /><input type='text' class='txtFldNormal' id='strIssueQuantity"+i+"' name='strIssueQuantity' value='"+ ( Double.parseDouble(strIssueQty.split(" ")[0]) <= Double.parseDouble(avlQty.split(" ")[0]) ? strIssueQty.split(" ")[0] : "") + "' onkeypress='return validateData(event,7);' onkeyup='QtyValidation("+i+")'></td>");
							else
								buff.append("<td width='10%' class='multiControl' align='left'><input type='hidden' name='itmnotissued' id='itmnotissued"+i+"' value ='No Tariff found for below items : \n"+strItemName+"\n' /><input type='text' disabled=true class='txtFldNormal' id='strIssueQuantity"+i+"' name='strIssueQuantity' value='0' onkeypress='return validateData(event,7);' onkeyup='QtyValidation("+i+")'></td>");
						else
							buff.append("<td width='10%' class='multiControl' align='left'><input type='text' class='txtFldNormal' id='strIssueQuantity"+i+"' name='strIssueQuantity' value='"+ ( Double.parseDouble(strIssueQty.split(" ")[0]) <= Double.parseDouble(avlQty.split(" ")[0]) ? strIssueQty.split(" ")[0] : "") + "' onkeypress='return validateData(event,7);' onkeyup='QtyValidation("+i+")'></td>");
						buff.append("<input type='hidden' name='strTotalBatch' id='strTotalBatch"
								+ i + "' value='" + strTotalNoOfBatch + "' />");
						
						buff.append("<input type='hidden' name='strTotBatch' id='strTotBatch"
								+ i + "' value='" + strTotalNoOfBatch + "' />");

						if (Integer.parseInt(strTotalNoOfBatch) > 1) 
						{
							buff.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
									+ i
									+ "' value='' />");
							
							
							buff.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
									+ i
									+ "' value='' />");
							buff.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"+ i + "' value='' />");
							buff.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"+ i + "' value='' />");
							buff.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"+ i + "' value='' />");
							buff.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName"+ i + "' value='' />");
							buff.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"+ i + "' value='' />");
							buff.append("<input type='hidden' name='strStockQty'         id='strStockQty"+ i + "' value='' />");
							buff.append("<input type='hidden' name='strStockRate'        id='strStockRate"+ i + "' value='' />");
							buff.append("<input type='hidden' name='strCheckBatchExists' id='strCheckBatchExists"+ i + "' value='1' />");
							buff.append("<TD WIDTH='9%' id='td9"
									+ i
									+ "' CLASS='multiPOControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
									+ i
									+ "' value='' />"
									+ "<div name='issueDrugDtl' id='issueDrugDtl"
									+ i
									+ "'></div>"
									+ " <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
									+ i
									+ "\");' TITLE='Click Here For Item Preferences' >auto</TD>");
							buff.append("<TD WIDTH='9%' id='td8"
									+ i
									+ "' CLASS='multiPOControl' style=\"text-align:center;\" ><div name='expDrugDtl' id='expDrugDtl"
									+ i + "'></div></TD>");
							
						} 
						else 
						{
							if(vo.getStrSingleBatchDtlWs() != null && vo.getStrSingleBatchDtlWs().size() > 0)
							{
								
									if (vo.getStrSingleBatchDtlWs().next()) 
									{
										/*MMS_MST.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEM_ID),
										   Mms_Mst.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID),
										   HSTSTR_BATCH_NO,
										   NVL(TO_CHAR(HSTDT_MANUF_DATE , ''DD-Mon-yyyy''),'''') ,
										   NVL(TO_CHAR(HSTDT_EXPIRY_DATE, ''Mon/yyyy''),'''') ,
										   NVL(HSTNUM_RATE,0),
										   Mms_Mst.get_stock_dtl() AS AVAL_QTY,
										   MMS_MST.GET_SUPP_DTL(1,'||hosp_code||',HSTNUM_SUPPLIER_ID) as MANUF_NAME,
										   NVL(HSTNUM_RATE,0)||''/''||Mms_Mst.getUnitName(GNUM_HOSPITAL_CODE,
										   HSTNUM_RATE_UNITID) AS Rate_WTHUNIT,
										   HSTNUM_PO_NO,
										   HSTNUM_PROGRAMME_ID,
										   NVL(MMS_MST.GET_PROGRAMME_NAME(1,GNUM_HOSPITAL_CODE,HSTNUM_PROGRAMME_ID),''---''),
										   HSTNUM_SUPPLIER_ID*/
										
										buff.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
												+ i
												+ "' value='"
												+ vo.getStrSingleBatchDtlWs().getString(13)
												+ "' />");
										buff.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
												+ i
												+ "' value='"
												+ vo.getStrSingleBatchDtlWs().getString(11)
												+ "' />");
										buff.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");
										buff.append("<input type='hidden' name='strStockRate'        id='strStockRate"+ i+ "' value='"+ vo.getStrSingleBatchDtlWs().getString(6)+ "' />");
										buff.append("<input type='hidden' name='strStockQty'         id='strStockQty"+ i+ "' value='"+ vo.getStrSingleBatchDtlWs().getString(7).split("\\^")[0] + "' />");
										buff.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"+ i+ "' value='"+ vo.getStrSingleBatchDtlWs().getString(9)+ "' />");
	
										
										
										buff.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"
												+ i
												+ "' value='"
												+ vo.getStrSingleBatchDtlWs().getString(3)
												+ "' />");
										buff.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"
												+ i
												+ "' value='"
												+ vo.getStrSingleBatchDtlWs().getString(5)
												+ "' />");
										buff.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName"
												+ i
												+ "' value='"
												+ vo.getStrSingleBatchDtlWs().getString(8)
												+ "' />");
										buff.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName"
												+ i
												+ "' value='"
												+ vo.getStrSingleBatchDtlWs().getString(12)
												+ "' />");
										buff.append("<TD WIDTH='9%' id='td8"
												+ i
												+ "' CLASS='multiPOControl' style=\"text-align:center;\" >"
												+ vo.getStrSingleBatchDtlWs().getString(3)
												+ "</TD>");
										buff.append("<TD WIDTH='9%'  id='td9"
												+ i
												+ "' CLASS='multiPOControl' style=\"text-align:center;\"   >"
												+ ((vo.getStrSingleBatchDtlWs()
														.getString(5) == null || vo
														.getStrSingleBatchDtlWs()
														.getString(5).equals("")) ? "NA"
														: vo.getStrSingleBatchDtlWs()
																.getString(5)) + "</TD>");
									} 
									else 
									{
										
										
										buff.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
												+ i
												+ "' value='' />");
										buff.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
												+ i
												+ "' value='' />");
										
										buff.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");
										
										buff.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"+ i + "' value='' />");
										buff.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"+ i + "' value='' />");
										buff.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"+ i + "' value='' />");
										buff.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName"+ i + "' value='' />");
										buff.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"+ i + "' value='' />");
										buff.append("<input type='hidden' name='strStockQty'         id='strStockQty"+ i + "' value='' />");
										buff.append("<input type='hidden' name='strStockRate'        id='strStockRate"+ i + "' value='' />");
										buff.append("<TD WIDTH='8%' id='td8"
												+ i
												+ "' CLASS='multiPOControl' style=\"text-align:center;\" >NA </TD>");
										buff.append("<TD WIDTH='9%'  id='td9"
												+ i
												+ "' CLASS='multiPOControl' style=\"text-align:center;\" >NA</TD>");
									}
									buff.append("<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"+ i + "' value='0' />");
									buff.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId"
											+ i + "' value='' />");
	
								}
							else 
							{
								
								
								buff.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
										+ i
										+ "' value='' />");
								buff.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
										+ i
										+ "' value='' />");
								
								buff.append("<input type='hidden' name='strTotBatch' id='strTotBatch"	+ i + "' value='" + strTotalNoOfBatch + "' />");
								
								buff.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch"+ i + "' value='' />");
								buff.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"+ i + "' value='' />");
								buff.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"+ i + "' value='' />");
								buff.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName"+ i + "' value='' />");
								buff.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"+ i + "' value='' />");
								buff.append("<input type='hidden' name='strStockQty'         id='strStockQty"+ i + "' value='' />");
								buff.append("<input type='hidden' name='strStockRate'        id='strStockRate"+ i + "' value='' />");
								buff.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId" + i + "' value='' />");
								buff.append("<TD WIDTH='9%' id='td8"
										+ i
										+ "' CLASS='multiPOControl' style=\"text-align:center;\" >NA </TD>");
								buff.append("<TD WIDTH='9%'  id='td9"
										+ i
										+ "' CLASS='multiPOControl' style=\"text-align:center;\" >NA</TD>");
							}
						}
								buff.append("<input type='hidden' disabled='disabled' class='txtFldNormal'  value='0' name='finalCostDivId' id='finalCostDivId"
										+ i + "' >");
								buff.append("<input type='hidden' name='strFinalCost' id='strFinalCost"
										+ i + "' value='0.00' />");
						if(lpReqNo.equals("0"))
							buff.append("<td width='10%' class='multiControl' align='left'><input type='text' autocomplete='off' class='txtFldNormal' id='strBSQuantity"+i+"' name='strBSQuantity' value='' onkeypress='return validateData(event,7);' onkeyup='QtyValidation("+i+")'></td>");
						
						
						buff.append("</tr>");
						//itemFinalCost+=itemCost;
					}
					else
					{
						buff.append("<tr>");
						buff.append("<td width='30%' class='multiControl'>"+strItemName+"<input type='hidden' id='strItemParamValue"+i+"' name='strItemParamValue' value='"+
								hiddenParam+
								"' /></td>");
						buff.append("<td width='10%' class='multiControl'><div id='itmtype"+i+"'> "+wb.getString(14)+" </div></td>");
						buff.append("<td width='10%' class='multiControl' align='left'>"+avlQty+"</td>");
						buff.append("<td width='10%' class='multiControl' align='left'>"+strIssueQty + " "+ strUnitName +"</td>");
						buff.append("<td width='10%' class='multiControl' align='left'><input type='text' class='txtFldNormal' id='strIssueQuantity"+i+"' name='strIssueQuantity' value='"+ ( Double.parseDouble(avlQty.split(" ")[0]) != 0.0 ? avlQty.split(" ")[0] : "0") + "' onkeypress='return validateData(event,7);' onkeyup='QtyValidation("+i+")'></td>");
						buff.append("<TD WIDTH='10%' id='td8"+ i	+ "' CLASS='multiPOControl' style=\"text-align:center;\" >NA </TD>");
						buff.append("<TD WIDTH='10%'  id='td9"+ i+ "' CLASS='multiPOControl' style=\"text-align:center;\" >NA</TD>");
						

						buff.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId"+ i + "' value='' />");
						if(lpReqNo.equals("0"))
						  buff.append("<td width='10%' class='multiControl' align='left'><input type='text' class='txtFldNormal' id='strBSQuantity"+i+"' name='strBSQuantity' value='' onkeypress='return validateData(event,7);' onkeyup='QtyValidation("+i+")'></td>");
						

						buff.append("</tr>");
						
						
					}
					
				 }
					
					buff.append("</table>");
					
					
					if (strCostReq.equals("1")) {
						buff.append("<div>");
					}else{
						buff.append("<div style='display:none'>");
					}
					buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
					buff.append("<tr>");
					buff.append("<td bgcolor='black' colspan='6'></td>");
					buff.append("</tr>");
					buff.append("<tr>");
					buff.append("<td class='multiControl' colspan='5' width='88%'><div align='right'><b>TOTAL COST</b></div></td>");
					buff.append("<td class='multiControl' colspan='1' width='12%'><input type='hidden' name='strFinalCosttt' value='"+itemFinalCost +"'/>"+
							"<font color='red'><b>Rs."+Math.round(itemFinalCost)+"</b></font></td>");
					buff.append("</tr>");
					buff.append("<tr>");
					buff.append("<td bgcolor='black' colspan='6'></td>");
					buff.append("</tr>");
					buff.append("</table>");
					buff.append("</div>");
				}
				else{
						
						buff.append("<tr>");
						if (strCostReq.equals("1")) {
							buff.append("<td class='multiControl' colspan='6'><font color='red'>No Record Found/Patient is not admitted</font></td>");
						}else{
							buff.append("<td class='multiControl' colspan='5'><font color='red'>No Record Found/Patient is not admitted</font></td>");
						}
						buff.append("</tr>");
						buff.append("</table>");
				}
			}
//			else
//			
//			{
//				buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
//				buff.append("<tr>");
//				buff.append("<td class='multiLabel'>Patient is not Admitted</td></tr></table>");
//			}
		
		}catch(Exception _err){
			try{
				_err.printStackTrace();
				throw new Exception("IssueDeskPrintTransHLP---->getIssueItemDetails"+_err.getMessage());
			}catch(Exception e){
				
			}
		}
		
		return buff.toString();
	}

	
		/**
	 * This function is used to create view page (issue mode)
	 * @param _IssueDeskPrintTransFB
	 * @return
	 */
	public static String initViewForIssueAddPage(IssueDeskPrintTransFB _IssueDeskPrintTransFB)
	{
		StringBuffer buff=null;
		MmsConfigUtil mcu=null;
		try{
			mcu=new MmsConfigUtil(_IssueDeskPrintTransFB.getStrHospitalCode());
				buff=new StringBuffer(500);
				
			/*
			 * buff.append("<table class='table'>"); buff.append("<tr>");
			 * buff.append("<td class='LABEL' width='25%'>C.R No.</td>");
			 * buff.append("<td class='CONTROL' width='25%'>"+_IssueDeskPrintTransFB.
			 * getStrCrNo()+"</td>");
			 * buff.append("<td class='LABEL' width='25%'>Request No.</td>");
			 * buff.append("<td class='CONTROL' width='25%'>"+_IssueDeskPrintTransFB.
			 * getStrLpRequestNo()+"</td>"); buff.append("</tr>");
			 */
					
					  buff.append("<div class='container'>");
					  buff.append("<div class='row'>");
					  buff.append("<div class='col-sm-3'>C.R No.</div>");
					  buff.append("<div class='col-sm-3'>");
					  buff.append(_IssueDeskPrintTransFB.getStrCrNo());
					  buff.append("</div>");
					  buff.append("<div class='col-sm-3'>Request No.</div>");
					  buff.append("<div class='col-sm-3'>");
					  buff.append(_IssueDeskPrintTransFB.getStrLpRequestNo());
					  buff.append("</div></div>");
					
					if(_IssueDeskPrintTransFB.getStrBSReqNo() != null && !_IssueDeskPrintTransFB.getStrBSReqNo().equals("0"))
					{	
				/*
				 * buff.append("<tr>");
				 * buff.append("<td class='LABEL' width='25%'>LP Request No.</td>");
				 * buff.append("<td class='CONTROL' width='25%' colspan='3'>"
				 * +_IssueDeskPrintTransFB.getStrBSReqNo()+"</td>"); buff.append("</tr>");
				 */
					buff.append("<div class='row'>");
					buff.append("<div class='col-sm-3'>LP Request No.</div>");
					buff.append("<div class='col-sm-3'>");
				    buff.append(_IssueDeskPrintTransFB.getStrBSReqNo());
				    buff.append("</div>");
					buff.append("<div class='col-sm-3'></div>");
					buff.append("<div class='col-sm-3'></div>");
					}

					if(mcu.getStrBillingIntegration().equals("1"))
					{
				/*
				 * buff.append("<tr>");
				 * buff.append("<td class='LABEL' width='25%'>Account No.</td>");
				 * buff.append("<td class='CONTROL' width='25%'>"+_IssueDeskPrintTransFB.
				 * getStrPatAccountNo()+"</td>");
				 * buff.append("<td class='LABEL' width='25%'>Account Balance</td>");
				 * buff.append("<td class='CONTROL' width='25%'>"+_IssueDeskPrintTransFB.
				 * getStrBillingHiddenValue().split("\\^")[1]+"</td>"); buff.append("</tr>");
				 */
						
						buff.append("<div class='row'>");
						buff.append("<div class='col-sm-3'>Account No.</div>");
						buff.append("<div class='col-sm-3'>");
					    buff.append(_IssueDeskPrintTransFB.getStrPatAccountNo());
					    buff.append("</div>");
					    buff.append("<div class='col-sm-3'>Account Balance</div>");
						buff.append("<div class='col-sm-3'>");
//					    buff.append(_IssueDeskPrintTransFB.getStrBillingHiddenValue().split("\\^")[1]);
						 buff.append(_IssueDeskPrintTransFB.getStrPatAccountBal());
					    buff.append("</div>");
					    
					}
						buff.append("<input type='hidden' name='strBillingInt'   value='"+mcu.getStrBillingIntegration()+"'>");
						buff.append("<input type='hidden' name='strPatAccountNo' value='"+_IssueDeskPrintTransFB.getStrPatAccountNo()+"'>");
			/* buff.append("</table>"); */
					buff.append("</div>");
					return buff.toString();
				}catch(Exception _err)
		{
			try{
				throw new Exception("IssueDeskPrintTransHLP-->initViewForIssueAddPage"+_err.getMessage());
			}catch(Exception e){}
		}
		
		return buff.toString();
	}
	
	/**
	 * This function is used to create issued item detail part for return page
	 * @param _IssueDeskPrintTransFB
	 * @return
	 */
	public static String getIssuedItemDetails(WebRowSet wb,String hosp_code,String strCostReq)
	throws SQLException {
	
	StringBuffer buff = null;
	Double itemFinalCost=0.0;
	IssueDeskPrintTransVO vo=null;
	IssueDeskPrintTransBO bo=null;
	String strReturnUnitCombo="";
	
	HisUtil hisutil=null;
	try{
		buff=new StringBuffer();
		int i=0;
		vo=new IssueDeskPrintTransVO();
		bo=new IssueDeskPrintTransBO();
		
		 hisutil = new HisUtil("MMS","IssueDeskPrintTransHLP");
		 
		String temp[]=null;
	
		if(wb!=null)
		{
			buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
			buff.append("<tr>");
			buff.append("<td class='multiLabel' >Item Name</td>");
			buff.append("<td class='multiLabel' >Batch/Sl.no.</td>");
			buff.append("<td class='multiLabel' >Expiry Date</td>");
			buff.append("<td class='multiLabel' >Balance Qty</td>");
			buff.append("<td class='multiLabel' >Return Qty.</td>");
			buff.append("<td class='multiLabel' >Unit</td>");
			if(strCostReq.equals("1"))
				buff.append("<td class='multiLabel' >Cost</td>");
			buff.append("</tr>");
			if(wb.size()!=0) 
			{
				
				
				while(wb.next()){ 
					
					
					temp=wb.getString(1).replace('@', '#').split("#"); 
					vo.setStrHospitalCode(hosp_code);
					vo.setStrBalanceQtUnitId(temp[1]);
					bo.getUnitCombo(vo);
					
					if (vo.getUnitComboWs() != null
								&& vo.getUnitComboWs().size() > 0) {
							strReturnUnitCombo = hisutil.getOptionValue(vo.getUnitComboWs(), 
									"", "", true);
						} else {
							strReturnUnitCombo = "<option value='0'>Select Value</option>";
						}
				
				//	System.out.println(wb.getString(8));
					
					/*if(wb.getString(8).equals("-1") || wb.getString(8).equals("0")){
						buff.append("<tr>");
						buff.append("<td class='multiControl' >"+wb.getString(2)+"<input type='hidden' name='strItemParamValue' id='strItemParamValue" +i+"' value='"+
								wb.getString(1)+"' /></td>");
						buff.append("<td class='multiControl' >"+wb.getString(3)+"</td>");
						buff.append("<td class='multiControl' ><font color='red'>"+wb.getString(6)+"</font></td>");
						buff.append("<td class='multiControl' ><a  onclick='openSpecification(this,"+(i)+");' style='color:blue; cursor:pointer;' title='Click Here To View Balance Detail' >"+wb.getString(4)+" "+wb.getString(5)+"</a>");
						buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl"+i+"' value='"+wb.getString(4)+"@"+wb.getString(5)+"@"+wb.getString(7)+"'>"+"<input type='hidden' name='strBalanceQty' id='strBalanceQty" +i+"' value='"+
							wb.getString(4)+"' />"
								+"</td>");
						buff.append("<td class='multiControl' ><input type='text' name='strReturnQty' id='strReturnQty" +i+"' value='0' class='txtFldSmall'  maxlength='8' onkeypress='return validateData(event,7);', onkeyup='quantityUnitValue("+i+");'></td>");
						buff.append("<td class='multiControl' ><input type='hidden' name='itemCost' id='itemCost" +i+"' value=''><select name='strUnit' id='strUnit" +i+"' onchange='quantityUnitValue("+i+");' >"+strReturnUnitCombo+"</select>");
						if(!strCostReq.equals("1"))
							buff.append("<div id='itemCostId"+i+"' style='display:none'>0.00</div>");
						buff.append("</td>");
						if(strCostReq.equals("1"))
							buff.append("<td class='multiControl' >"+"<div id='itemCostId"+i+"'>0.00</div></td>");
						buff.append("</tr>");
					}
					else{
						buff.append("<tr>");
						buff.append("<td class='multiControlRed' >"+wb.getString(2)+"</td>");
						buff.append("<td class='multiControlRed' >"+wb.getString(3)+"</td>");
						buff.append("<td class='multiControlRed' >"+wb.getString(6)+"</td>");
						buff.append("<td class='multiControlRed' >"+wb.getString(4)+" "+wb.getString(5)+"<input type='hidden' name='strBalanceQty' id='strBalanceQty" +i+"' value='"+
							wb.getString(4)+"' />"
								+"</td>");
						//buff.append("<td class='multiControlRed' >"+wb.getString(7)+" "+wb.getString(5)+"</td>");
						buff.append("<td class='multiControlRed' ><input type='text' name='strReturnQty'  id='strReturnQty" +i+"'></td>");
						//buff.append("<td class='multiControlRed' >-</td>");
						buff.append("<td class='multiControlRed' >"+wb.getString(5)+"</td>");
						if(strCostReq.equals("1"))
							buff.append("<td class='multiControlRed' >-</td>");
						buff.append("</tr>");
					}*/
					
					
					if(!(wb.getString(8).equals("-1") || wb.getString(8).equals("0"))){
						buff.append("<tr>");
						buff.append("<td class='multiControl' >"+wb.getString(2)+"<input type='hidden' name='strItemParamValue' id='strItemParamValue" +i+"' value='"+
								wb.getString(1)+"' /></td>");
						buff.append("<td class='multiControl' >"+wb.getString(3)+"</td>");
						buff.append("<td class='multiControl' ><font color='red'>"+(wb.getString(6).equals(" ")?"NA":wb.getString(6))+"</font></td>");
						buff.append("<td class='multiControl' ><a  onclick='openSpecification(this,"+(i)+");' style='color:blue; cursor:pointer;' title='Click Here To View Balance Detail' >"+wb.getString(4)+" "+wb.getString(5)+"</a>");
						buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl"+i+"' value='"+wb.getString(4)+"@"+wb.getString(5)+"@"+wb.getString(7)+"'>"+"<input type='hidden' name='strBalanceQty' id='strBalanceQty" +i+"' value='"+
							wb.getString(4)+"' />"
								+"</td>");
						buff.append("<td class='multiControl' ><input type='text' autocomplete='off' name='strReturnQty' id='strReturnQty" +i+"' value='0' class='txtFldSmall'  maxlength='8' onkeypress='return validateData(event,7);', onkeyup='quantityUnitValue("+i+");'></td>");
						buff.append("<td class='multiControl' ><input type='hidden' name='itemCost' id='itemCost" +i+"' value=''><select name='strUnit' id='strUnit" +i+"' onchange='quantityUnitValue("+i+");' >"+strReturnUnitCombo+"</select>");
						if(!strCostReq.equals("1"))
							buff.append("<div id='itemCostId"+i+"' style='display:none'>0.00</div>");
						buff.append("</td>");
						if(strCostReq.equals("1"))
							buff.append("<td class='multiControl' >"+"<div id='itemCostId"+i+"'>0.00</div></td>");
						buff.append("</tr>");
					}
					else{
						buff.append("<tr>");
						buff.append("<td class='multiControlRed' >"+wb.getString(2)+"</td>");
						buff.append("<td class='multiControlRed' >"+wb.getString(3)+"</td>");
						buff.append("<td class='multiControlRed' >"+wb.getString(6)+"</td>");
						buff.append("<td class='multiControlRed' >"+wb.getString(4)+" "+wb.getString(5)+"<input type='hidden' name='strBalanceQty' id='strBalanceQty" +i+"' value='"+
							wb.getString(4)+"' />"
								+"</td>");
						//buff.append("<td class='multiControlRed' >"+wb.getString(7)+" "+wb.getString(5)+"</td>");
						buff.append("<td class='multiControlRed' ><input type='text' name='strReturnQty'  id='strReturnQty" +i+"'></td>");
						//buff.append("<td class='multiControlRed' >-</td>");
						buff.append("<td class='multiControlRed' >"+wb.getString(5)+"</td>");
						if(strCostReq.equals("1"))
							buff.append("<td class='multiControlRed' >-</td>");
						buff.append("</tr>");
					}
						
					//if(wb.getString(8).equals("-1") || wb.getString(8).equals("0")){
					   i++;
				    //} 
			 }
				buff.append("</table>");
				if(strCostReq.equals("1"))
					buff.append("<div id='totalCostDivId'>");
				else
					buff.append("<div id='totalCostDivId' style='display:none'>");
				buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				buff.append("<tr>");
				buff.append("<td bgcolor='black' colspan='7'></td>");
				buff.append("</tr>");
				buff.append("<tr>");
				buff.append("<td class='multiControl' width='90%' ><div align='right'><b>TOTAL COST</b></div></td>");
				buff.append("<td class='multiControl' width='10%'><div id='finalCostId'><font color='red'><b>Rs 0.00</b></font></div><input type='hidden' name='strFinalCost' value='"+itemFinalCost +"'/>"+
						"</td>");
				buff.append("</tr>");
				buff.append("<tr>");
				buff.append("<td bgcolor='black' colspan='7'></td>");
				buff.append("</tr>");
				buff.append("</table>");
				buff.append("</div>");
				
			}
			else{
				buff.append("<tr>");
				if(strCostReq.equals("1"))
					buff.append("<td class='multiControl' colspan='7'><font color='red'><b>No Record Found/Patient is not admitted</b></font></td>");
				else
					buff.append("<td class='multiControl' colspan='6'><font color='red'><b>No Record Found/Patient is not admitted</b></font></td>");
				buff.append("</tr>");
				buff.append("</table>");
			}
		}
	
	
	}catch(Exception _err){
		try{
			_err.printStackTrace();
			throw new Exception("IssueDeskPrintTransHLP---->getIssuedItemDetails"+_err.getMessage());
		}catch(Exception e){
			
		}
}

return buff.toString();
}
	
	
	
	public static String getIssuedItemDetailsNew(WebRowSet wb,String hosp_code,String strCostReq)
			throws SQLException {
			
			StringBuffer buff = null;
			Double itemFinalCost=0.0;
			IssueDeskPrintTransVO vo=null;
			IssueDeskPrintTransBO bo=null;
			String strReturnUnitCombo="";
			
			HisUtil hisutil=null;
			try{
				buff=new StringBuffer();
				int i=0;
				vo=new IssueDeskPrintTransVO();
				bo=new IssueDeskPrintTransBO();
				
				 hisutil = new HisUtil("MMS","IssueDeskPrintTransHLP");
				 
				String temp[]=null;
			
				if(wb!=null)
				{
					buff.append("<table class='table' align='center'cellpadding='1px' cellspacing='1px'>");
					buff.append("<thead>");
					buff.append("<th>Item Name</th>");
					buff.append("<th>Batch/Sl.no.</th>");
					buff.append("<th>Expiry Date</th>");
					buff.append("<th>Balance Qty</th>");
					buff.append("<th>Return Qty.</th>");
					buff.append("<th>Unit</th>");
					if(strCostReq.equals("1"))
						buff.append("<th >Cost</th>");
					buff.append("</thead>");
					if(wb.size()!=0) 
					{
						
						
						while(wb.next()){ 
							
							
							temp=wb.getString(1).replace('@', '#').split("#"); 
							vo.setStrHospitalCode(hosp_code);
							vo.setStrBalanceQtUnitId(temp[1]);
							bo.getUnitCombo(vo);
							
							if (vo.getUnitComboWs() != null
										&& vo.getUnitComboWs().size() > 0) {
									strReturnUnitCombo = hisutil.getOptionValue(vo.getUnitComboWs(), 
											"", "", true);
								} else {
									strReturnUnitCombo = "<option value='0'>Select Value</option>";
								}
						
						//	System.out.println(wb.getString(8));
							
							/*if(wb.getString(8).equals("-1") || wb.getString(8).equals("0")){
								buff.append("<tr>");
								buff.append("<td class='multiControl' >"+wb.getString(2)+"<input type='hidden' name='strItemParamValue' id='strItemParamValue" +i+"' value='"+
										wb.getString(1)+"' /></td>");
								buff.append("<td class='multiControl' >"+wb.getString(3)+"</td>");
								buff.append("<td class='multiControl' ><font color='red'>"+wb.getString(6)+"</font></td>");
								buff.append("<td class='multiControl' ><a  onclick='openSpecification(this,"+(i)+");' style='color:blue; cursor:pointer;' title='Click Here To View Balance Detail' >"+wb.getString(4)+" "+wb.getString(5)+"</a>");
								buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl"+i+"' value='"+wb.getString(4)+"@"+wb.getString(5)+"@"+wb.getString(7)+"'>"+"<input type='hidden' name='strBalanceQty' id='strBalanceQty" +i+"' value='"+
									wb.getString(4)+"' />"
										+"</td>");
								buff.append("<td class='multiControl' ><input type='text' name='strReturnQty' id='strReturnQty" +i+"' value='0' class='txtFldSmall'  maxlength='8' onkeypress='return validateData(event,7);', onkeyup='quantityUnitValue("+i+");'></td>");
								buff.append("<td class='multiControl' ><input type='hidden' name='itemCost' id='itemCost" +i+"' value=''><select name='strUnit' id='strUnit" +i+"' onchange='quantityUnitValue("+i+");' >"+strReturnUnitCombo+"</select>");
								if(!strCostReq.equals("1"))
									buff.append("<div id='itemCostId"+i+"' style='display:none'>0.00</div>");
								buff.append("</td>");
								if(strCostReq.equals("1"))
									buff.append("<td class='multiControl' >"+"<div id='itemCostId"+i+"'>0.00</div></td>");
								buff.append("</tr>");
							}
							else{
								buff.append("<tr>");
								buff.append("<td class='multiControlRed' >"+wb.getString(2)+"</td>");
								buff.append("<td class='multiControlRed' >"+wb.getString(3)+"</td>");
								buff.append("<td class='multiControlRed' >"+wb.getString(6)+"</td>");
								buff.append("<td class='multiControlRed' >"+wb.getString(4)+" "+wb.getString(5)+"<input type='hidden' name='strBalanceQty' id='strBalanceQty" +i+"' value='"+
									wb.getString(4)+"' />"
										+"</td>");
								//buff.append("<td class='multiControlRed' >"+wb.getString(7)+" "+wb.getString(5)+"</td>");
								buff.append("<td class='multiControlRed' ><input type='text' name='strReturnQty'  id='strReturnQty" +i+"'></td>");
								//buff.append("<td class='multiControlRed' >-</td>");
								buff.append("<td class='multiControlRed' >"+wb.getString(5)+"</td>");
								if(strCostReq.equals("1"))
									buff.append("<td class='multiControlRed' >-</td>");
								buff.append("</tr>");
							}*/
							
							
							if(!(wb.getString(8).equals("-1") || wb.getString(8).equals("0"))){
								buff.append("<tbody>");
								buff.append("<td >"+wb.getString(2)+"<input type='hidden' name='strItemParamValue' id='strItemParamValue" +i+"' value='"+
										wb.getString(1)+"' /></td>");
								buff.append("<td>"+wb.getString(3)+"</td>");
								buff.append("<td><font color='red'>"+(wb.getString(6).equals(" ")?"NA":wb.getString(6))+"</font></td>");
								buff.append("<td><a  onclick='openSpecification(this,"+(i)+");' style='color:blue; cursor:pointer;' title='Click Here To View Balance Detail' >"+wb.getString(4)+" "+wb.getString(5)+"</a>");
								buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl"+i+"' value='"+wb.getString(4)+"@"+wb.getString(5)+"@"+wb.getString(7)+"'>"+"<input type='hidden' name='strBalanceQty' id='strBalanceQty" +i+"' value='"+
									wb.getString(4)+"' />"
										+"</td>");
								buff.append("<td><input type='text' autocomplete='off' name='strReturnQty' id='strReturnQty" +i+"' value='0' class='txtFldSmall'  maxlength='8' onkeypress='return validateData(event,7);', onkeyup='quantityUnitValue("+i+");'></td>");
								buff.append("<td><input type='hidden' name='itemCost' id='itemCost" +i+"' value=''><select name='strUnit' id='strUnit" +i+"' onchange='quantityUnitValue("+i+");' >"+strReturnUnitCombo+"</select>");
								if(!strCostReq.equals("1"))
									buff.append("<div id='itemCostId"+i+"' style='display:none'>0.00</div>");
								buff.append("</td>");
								if(strCostReq.equals("1"))
									buff.append("<td>"+"<div id='itemCostId"+i+"'>0.00</div></td>");
								buff.append("</tbody>");
							}
							else{
								buff.append("<tbody>");
								buff.append("<td>"+wb.getString(2)+"</td>");
								buff.append("<td>"+wb.getString(3)+"</td>");
								buff.append("<td>"+wb.getString(6)+"</td>");
								buff.append("<td>"+wb.getString(4)+" "+wb.getString(5)+"<input type='hidden' name='strBalanceQty' id='strBalanceQty" +i+"' value='"+
									wb.getString(4)+"' />"
										+"</td>");
								//buff.append("<td class='multiControlRed' >"+wb.getString(7)+" "+wb.getString(5)+"</td>");
								buff.append("<td><input type='text' name='strReturnQty'  id='strReturnQty" +i+"'></td>");
								//buff.append("<td class='multiControlRed' >-</td>");
								buff.append("<td>"+wb.getString(5)+"</td>");
								if(strCostReq.equals("1"))
									buff.append("<td>-</td>");
								buff.append("</tbody>");
							}
								
							//if(wb.getString(8).equals("-1") || wb.getString(8).equals("0")){
							   i++;
						    //} 
					 }
						buff.append("</table>");
						if(strCostReq.equals("1"))
							buff.append("<div id='totalCostDivId'>");
						else
							buff.append("<div id='totalCostDivId' style='display:none'>");
						buff.append("<table class='table' align='center'cellpadding='1px' cellspacing='1px'>");
					/*
					 * buff.append("<tr>"); buff.append("<td bgcolor='black' colspan='7'></td>");
					 * buff.append("</tr>");
					 */
						buff.append("<tbody>");
						buff.append("<td width='90%' ><div align='right'><font color='red'><b>TOTAL COST</b></font></div></td>");
						buff.append("<td width='10%'><div id='finalCostId'><font color='red'><b>Rs 0.00</b></font></div><input type='hidden' name='strFinalCost' value='"+itemFinalCost +"'/>"+
								"</td>");
						buff.append("</tbody>");
					/*
					 * buff.append("<tr>"); buff.append("<td bgcolor='black' colspan='7'></td>");
					 * buff.append("</tr>");
					 */
						buff.append("</table>");
						buff.append("</div>");
						
					}
					else{
						buff.append("<tbody>");
						if(strCostReq.equals("1"))
							buff.append("<td colspan='7'><font color='red'><b>No Record Found/Patient is not admitted</b></font></td>");
						else
							buff.append("<td  colspan='6'><font color='red'><b>No Record Found/Patient is not admitted</b></font></td>");
						buff.append("</tbody>");
						buff.append("</table>");
					}
				}
			
			
			}catch(Exception _err){
				try{
					_err.printStackTrace();
					throw new Exception("IssueDeskPrintTransHLP---->getIssuedItemDetails"+_err.getMessage());
				}catch(Exception e){
					
				}
		}

		return buff.toString();
		}
	/**
	 * This function used to create view page for return mode 
	 * @param wb
	 * @param hosp_code
	 * @return
	 * @throws SQLException
	 */
public static String getIssuedItemDetailsForReturnView(WebRowSet wb,String hosp_code)
	throws SQLException {
	StringBuffer buff = null;
	
	
	
	
	try{
		buff=new StringBuffer();
		int i=0;
		float tot=0;
		
		 
		
	
		if(wb!=null)
		{
			
			 	buff.append("<table class='table'>"); 
		        buff.append("<thead class='thead-dark' align='center'>");
		        buff.append("<tr>");
			    buff.append("<th width='35%' style='font-weight:350 !important ;font-size: 15px !important;'>Item Name</th>");					  
			    buff.append("<th width='10%' style='font-weight:350 !important ;font-size: 15px !important;'>Batch/Sl.no.</th>");
			    buff.append("<th width='10%' style='font-weight:350 !important ;font-size: 15px !important;'>M.R.P</th>");
			    buff.append("<th width='15%' style='font-weight:350 !important ;font-size: 15px !important;'>Expiry Date</th>");					
			    buff.append("<th width='10%' style='font-weight:350 !important ;font-size: 15px !important;'>Issued Qty</th>");					
			    buff.append("<th width='10%' style='font-weight:350 !important ;font-size: 15px !important;'>Return Qty.</th>");					
			    buff.append("<th width='10%' style='font-weight:350 !important ;font-size: 15px !important;'>Cost</th>");					
			    buff.append("</tr>");
			    buff.append("</thead>");
				/*
				 * buff.
				 * append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>"
				 * ); buff.append("<tr>");
				 * buff.append("<td class='multiLabel' width='35%'>Item Name</td>");
				 * buff.append("<td class='multiLabel' width='10%'>Batch/Sl.no.</td>");
				 * buff.append("<td class='multiLabel' width='10%'>M.R.P</td>");
				 * buff.append("<td class='multiLabel' width='15%'>Expiry Date</td>");
				 * buff.append("<td class='multiLabel' width='10%'>Issued Qty</td>");
				 * buff.append("<td class='multiLabel' width='10%'>Return Qty.</td>");
				 * buff.append("<td class='multiLabel' width='10%'>Cost</td>");
				 * buff.append("</tr>");
				 */
			if(wb.size()!=0) 
			{
				
				System.out.println("------------- IssueDeskPrintTransHLP.getIssuedItemDetailsForReturnView  ------Inside Size --------");
				/*
				 * 1.Hiiden Value
				 * round(HSTNUM_ISSUE_QTY)
				 *   ||'@'||HSTNUM_ISSUEQTY_UNITID
				 *   ||'@'||HSTNUM_STORE_ID||'@'||HSTNUM_ITEMBRAND_ID||'@'||HSTNUM_ITEM_ID||'@'||HSTSTR_BATCH_SL_NO
		             ||'@'||HSTSTR_ITEM_SL_NO||'@'||HSTNUM_STOCK_STATUS_CODE||'@'||HSTNUM_GROUP_ID||'@'||HSTNUM_SUBGROUP_ID||'@'||HSTNUM_RATE
		             ||'@'||HSTNUM_RATE_UNITID||'^'||Mms_Mst.GETUNITBASEVALUE(HSTNUM_RATE_UNITID,GNUM_HOSPITAL_CODE)
		             ||'@'||TO_CHAR(HSTDT_MANUF_DATE,'DD-Mon-yyyy')||'@'||NVL(TO_CHAR(HSTDT_EXPIRY_DATE,'DD-Mon-yyyy'),' ')
		             ||'@'|| round(Mms_Mst.GETUNITBASEVALUE(HSTNUM_ISSUEQTY_UNITID,GNUM_HOSPITAL_CODE),2)
				 * 
				 * 2.Drug_NAME
				 * 3.BATCH_NO
				 * 4.Balance_qty
				 * 5.Unit
				 * 6.EXP_DATE
				 * 7.RET_QTY
				 * 8.Validity				 
				 * */
				while(wb.next())
				{
					String temp[]=wb.getString(1).replace('@', '#').split("#");
					
					if(wb.getString(8).equals("-1") || wb.getString(8).equals("0"))
					{
						//System.out.println("-----A -------- wb.getString(8)-------"+wb.getString(8));
						buff.append("<tr>");
						buff.append("<td width='35%' align='left' style='font-weight:350 !important ;font-size: 15px !important;'>"+wb.getString(2)+"<input type='hidden' name='strItemParamValue' id='strItemParamValue" +i+"' value='"+
								wb.getString(1)+"' /></td>");
						buff.append("<td  width='10%' align='left' style='font-weight:350 !important ;font-size: 15px !important;'>"+wb.getString(3)+"</td>");
						buff.append("<td  width='10%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>"+temp[10]+"/"+wb.getString(5)+"</td>");
						buff.append("<td  width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'><font color='red'>"+wb.getString(6)+"</font></td>");
						
						
						buff.append("<td  width='10%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>"+temp[0]+" "+wb.getString(5)+"</a>");
						buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl"+i+"' value='"+wb.getString(4)+"@"+wb.getString(5)+"@"+wb.getString(7)+"'>"+"<input type='hidden' name='strBalanceQty' id='strBalanceQty" +i+"' value='"+
							wb.getString(4)+"' />"
								+"</td>");
						buff.append("<td  width='10%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>"+wb.getString(7)+" "+wb.getString(5)+"</td>");
						
						buff.append("<td  width='10%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>"+Math.round(( Float.parseFloat(wb.getString(4)) * Float.parseFloat(temp[10]) )* 100.0)/100.0+"</td>");
						buff.append("</tr>");
						tot+=Math.round(( Float.parseFloat(wb.getString(4)) * Float.parseFloat(temp[10]))*100.0)/100.0;
					}
					else
					{
						//System.out.println("----- B -------- wb.getString(8)-------"+wb.getString(8));
						
						buff.append("<tr>");
						buff.append("<td  width='35%' align='left'   style='font-weight:350 !important ;font-size: 15px !important;'>"+wb.getString(2)+"</td>");
						buff.append("<td  width='10%' align='left'   style='font-weight:350 !important ;font-size: 15px !important;'>"+wb.getString(3)+"</td>");
						buff.append("<td  width='10%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>"+temp[10]+"/"+wb.getString(5)+"</td>");
						buff.append("<td  width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>"+wb.getString(6)+"</td>");
						buff.append("<td  width='10%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>"+temp[0]+" "+wb.getString(5)+"<input type='hidden' name='strBalanceQty' id='strBalanceQty" +i+"' value='"+
							wb.getString(4)+"' />"
								+"</td>");
						buff.append("<td  width='10%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>"+wb.getString(7)+" "+wb.getString(5)+"</td>");
						buff.append("<td  width='10%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>"+Math.round(( Float.parseFloat(wb.getString(4)) * Float.parseFloat(temp[10])) * 100.0)/100.0+"</td>");
						buff.append("</tr>");
						tot+=Math.round(( Float.parseFloat(wb.getString(4)) * Float.parseFloat(temp[10]))*100.0)/100.0;
					}
						
					if(wb.getString(8).equals("-1") || wb.getString(8).equals("0"))
					{
					   i++;
				    } 
			 }
				buff.append("<tr>");
				//buff.append("<td class='multiControl' colspan='6'><div align='right'><b>Total Cost</b></div></td>");
				buff.append("<td  colspan='7' style='font-weight:350 !important ;font-size: 15px !important;'><div align='right'>Total Cost  :  "+tot+"</div></td>");
				buff.append("</tr>");
			
				buff.append("</table>");
			}
			else{
				buff.append("<tr>");
				buff.append("<td  colspan='6' style='font-weight:350 !important ;font-size: 15px !important;'><font color='red'>No Record Found</font></td>");
				buff.append("</tr>");
			}
		}
	
	
	}catch(Exception _err){
		try{
			_err.printStackTrace();
			throw new Exception("IssueDeskPrintTransHLP---->getIssuedItemDetails"+_err.getMessage());
		}catch(Exception e){
			
		}
	}
	
	return buff.toString();
}



public static String getIssuedItemDetailsForReturnViewNew(WebRowSet wb,String hosp_code)
	throws SQLException {
	StringBuffer buff = null;
	
	
	
	
	try{
		buff=new StringBuffer();
		int i=0;
		float tot=0;
		
		 
		
	
		if(wb!=null)
		{
			buff.append("<table class='table' cellpadding='1px' cellspacing='1px'>");
			buff.append("<thead>");
			buff.append("<th text-align='left' width='35%'>Item Name</th>");
			buff.append("<th  text-align='left' width='10%'>Batch/Sl.no.</th>");
			buff.append("<th text-align='right' width='10%'>M.R.P</th>");
			buff.append("<th text-align='left' width='15%'>Expiry Date</th>");
			buff.append("<th  text-align='right' width='10%'>Issued Qty</th>");
			buff.append("<th text-align='right' width='10%'>Return Qty.</th>");
			buff.append("<th text-align='right' width='10%'>Cost</th>");
			
			buff.append("</thead>");
			if(wb.size()!=0) 
			{
				
				
				
				while(wb.next()){
					
					String temp[]=wb.getString(1).replace('@', '#').split("#");
					if(wb.getString(8).equals("-1") || wb.getString(8).equals("0")){
						buff.append("<tbody>");
						buff.append("<td  width='35%'>"+wb.getString(2)+"<input type='hidden' name='strItemParamValue' id='strItemParamValue" +i+"' value='"+
								wb.getString(1)+"' /></td>");
						buff.append("<td  width='10%'>"+wb.getString(3)+"</td>");
						buff.append("<td  width='10%'>"+temp[10]+"/"+wb.getString(5)+"</td>");
						buff.append("<td  width='15%'><font color='red'>"+wb.getString(6)+"</font></td>");
						
						
						buff.append("<td  width='10%'>"+temp[0]+" "+wb.getString(5)+"</a>");
						buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl"+i+"' value='"+wb.getString(4)+"@"+wb.getString(5)+"@"+wb.getString(7)+"'>"+"<input type='hidden' name='strBalanceQty' id='strBalanceQty" +i+"' value='"+
							wb.getString(4)+"' />"
								+"</td>");
						buff.append("<td  width='10%'>"+wb.getString(7)+" "+wb.getString(5)+"</td>");
						
						buff.append("<td  width='10%'>"+Math.round(( Float.parseFloat(wb.getString(4)) * Float.parseFloat(temp[10]) )* 100.0)/100.0+"</td>");
						buff.append("</tbody>");
						tot+=Math.round(( Float.parseFloat(wb.getString(4)) * Float.parseFloat(temp[10]))*100.0)/100.0;
					}
					else{
						buff.append("<tbody>");
						buff.append("<td  width='35%'>"+wb.getString(2)+"</td>");
						buff.append("<td  width='10%'>"+wb.getString(3)+"</td>");
						buff.append("<td  width='10%'>"+temp[10]+"/"+wb.getString(5)+"</td>");
						buff.append("<td  width='15%'>"+wb.getString(6)+"</td>");
						buff.append("<td  width='10%'>"+temp[0]+" "+wb.getString(5)+"<input type='hidden' name='strBalanceQty' id='strBalanceQty" +i+"' value='"+
							wb.getString(4)+"' />"
								+"</td>");
						buff.append("<td  width='10%'>"+wb.getString(7)+" "+wb.getString(5)+"</td>");
						buff.append("<td  width='10%'>"+Math.round(( Float.parseFloat(wb.getString(4)) * Float.parseFloat(temp[10])) * 100.0)/100.0+"</td>");
						buff.append("</tbody>");
						tot+=Math.round(( Float.parseFloat(wb.getString(4)) * Float.parseFloat(temp[10]))*100.0)/100.0;
					}
						
					if(wb.getString(8).equals("-1") || wb.getString(8).equals("0")){
					   i++;
				    } 
			 }
				buff.append("<tr>");
				//buff.append("<td  colspan='6'><div align='right'><b>Total Cost</b></div></td>");
				buff.append("<td  colspan='7'><div align='right'><font color='red'>Total Cost  :  "+tot+"</font></div></td>");
				buff.append("</tr>");
			
				buff.append("</table>");
			}
			else{
				buff.append("<tbody>");
				buff.append("<td  colspan='6'><font color='red'>No Record Found</font></td>");
				buff.append("</tbody>");
			}
		}
	
	
	}catch(Exception _err){
		try{
			_err.printStackTrace();
			throw new Exception("IssueDeskPrintTransHLP---->getIssuedItemDetails"+_err.getMessage());
		}catch(Exception e){
			
		}
	}
	
	return buff.toString();
  }


public static String getIndent_ItemDetailsBS(IssueDeskPrintTransVO vo)
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
		    vo.setStrMsgString("IssueDeskPrintTransHLP.getItemDetails() --> "+e.getMessage());
			vo.setStrMsgType("1");
		}
	return sb.toString();
	}


public static String getIndent_DetailsBS(IssueDeskPrintTransVO vo)
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
			.setStrMsgString("IssueDeskPrintTransHLP.getItemDetails() --> "
					+e.getMessage());
		vo.setStrMsgType("1");
	}
return sb.toString();
}



}