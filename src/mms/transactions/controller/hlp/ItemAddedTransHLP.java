package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.IssueTransBO;
import mms.transactions.controller.fb.IssueTransFB;
import mms.transactions.vo.IssueTransVO;

public class ItemAddedTransHLP 
{
	
	public static String getItemAddedDetail(IssueTransFB formBean) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");		
		WebRowSet ws = null;
		String strHiddenId = "";
		sb.append("");
		int count=0;

	try 
	{
		ws = formBean.getWsCancelIssueDtl();
		if (ws != null && ws.size() > 0) 
		{
			String strAgeAndSex   = formBean.getStrPatientAgeUnit();
			String strPatientName = formBean.getStrPatientName();
			
			if (strAgeAndSex == null)
				strAgeAndSex = "----";
			if (strPatientName == null)
				strPatientName = "----";					
			sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");	
			//sb.append("<tr><td class='TITLE' colspan='4'>Patient Details</td></tr>");		
			sb.append("<tr><td width='25%' class='LABEL'>DDC Name</td>");
			sb.append("<td width='25%' class='CONTROL'>");
			sb.append(formBean.getStrDDCName());
			sb.append("</td>");
			sb.append("<td width='25%' class='LABEL'>Category</td>");
			sb.append("<td width='25%' class='CONTROL'>");
			sb.append(formBean.getStrItemCatgName());					
			sb.append("</td>");					
			sb.append("</tr>");		
			sb.append("<tr><td width='25%' class='LABEL'>Patient Name</td>");
			sb.append("<td width='25%' class='CONTROL'>");
			sb.append(strPatientName);
			sb.append("</td>");
			sb.append("<td width='25%' class='LABEL'>Age</td>");
			sb.append("<td width='25%' class='CONTROL'>");
			sb.append(strAgeAndSex);					
			sb.append("</td>");					
			sb.append("</tr>");					
			sb.append("<tr><td width='25%' class='LABEL'>Issue Date</td>");
			sb.append("<td width='25%' class='CONTROL'>");
			sb.append(formBean.getStrIssueDate());
			sb.append("</td>");
			sb.append("<td width='25%' class='LABEL'>CR No.</td>");
			sb.append("<td width='25%' class='CONTROL'>");
			sb.append(formBean.getStrCrNo());					
			sb.append("</td>");					
			sb.append("</tr>");					
			sb.append("</table>");
			sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='#6097BC'>");      
			sb.append("<tr><td class='TITLE' colspan='5'>Drug Detail(s)</td></tr>");	
			sb.append("<tr>");  
			sb.append("<td CLASS='multiRPTLabel' width='4%'><input name='chkmain' onclick='CheckedAll(this);' type='CHECKBOX'></td>");
			sb.append("<td width='36%' class='multiRPTLabel'>Drug Name</td>");
			sb.append("<td width='20%' class='multiRPTLabel'>Batch</td>");			
			sb.append("<td width='20%' class='multiRPTLabel'>Issue Qty</td>");
			sb.append("<td width='20%' class='multiRPTLabel'>Return Qty</td>");			
			sb.append("</tr>");
			sb.append("</table>");
			while (ws.next()) 
			{
				//System.out.println("Return Qty==>"+ws.getString(7));
				strHiddenId = ws.getString(1); //itemBrandId^Batch No^Item Sl no ^ Stock Status Code
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='#6097BC'>");       
				sb.append("<tr>"); 
				sb.append("<input type='hidden' name='strItemBrandId' id='strItemBrandId' value="+strHiddenId.split("\\^")[0]+"></td>");
				sb.append("<input type='hidden' name='strBatchNo'     id='strBatchNo'     value="+strHiddenId.split("\\^")[1]+"></td>");
				sb.append("<input type='hidden' name='strHiddenId'    id='strHiddenId'    value="+strHiddenId+"></td>");
				sb.append("<input type='hidden' name='strReturnQty'   id='strReturnQty'   value="+ws.getString(6)+"></td>");
				if(Integer.parseInt(ws.getString(6))==0)
				  sb.append("<td class='multiPOControl' width='4%'><input type='checkbox' name='strIssueChkIndex'  onClick='chkBoxClick(this,\""+count+"\");' id='strIssueChkIndex"+count+"' value='0' /></td>");
				else
				  sb.append("<td class='multiPOControl' width='4%'><input type='checkbox' name='strIssueChkIndex'  onClick='chkBoxClick(this,\""+count+"\");' id='strIssueChkIndex"+count+"' value='0' disabled /></td>");
				sb.append("<td width='36%' class='multiPOControl'>"+ ws.getString(2) +"</td>");
				sb.append("<td width='20%' class='multiPOControl'>"+ ws.getString(3) +"</td>");
				sb.append("<td width='20%' class='multiPOControl'>"+ ws.getString(4) +"</td>");
				sb.append("<td width='20%' class='multiPOControl'>"+ ws.getString(5) +"</td>");
				sb.append("</tr>");
				sb.append("</table>");
				count++;
					
		    }
	  } 
		
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
		throw new Exception("PatientDtlHLP-->getPatientDtl-->"+ e.getMessage());
	}
	finally 
	{
		if (ws != null) 
		{
			ws.close();
			ws = null;
		}
     }
	return sb.toString();
	}
	
    public static String getIssueRptForDotMatrix(IssueTransFB formBean)throws SQLException, UnsupportedEncodingException
    {	
	    String rptContents = "";
	    WebRowSet ws = formBean.getWsIssueDetails();
	    int i =1;
		if (ws != null && ws.size() > 0) 
		{
			/*
			  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
			  1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued By Doctor ^ Date ^ Cr No ^ Hindi Text  
			  2.Drug Name
			  3.Batch No 
			  4.Exp Date
			  5.Issue Qty
			 */	
			rptContents = "\n";
		    rptContents += "                             Testing Slip \n" + 
		    			   "                          Government of Rajasthan\n" + 
					   	   "                      Mukhyamantri Nishulk Dava Yojna\n";
		    rptContents += "\n     Hospital      :" + MakeRptStr(formBean.getStrHospitalName(),30) + " DDC      :"+formBean.getStrStoreName() +" "+  
						   "\n     Presc For     :" + MakeRptStr(formBean.getStrPatientName(),30) +  " Issue No.:" + formBean.getStrIssueNo() + 
						   "\n     By Doctor     :" + MakeRptStr(formBean.getStrPrescribedBy(),30) + " Date     :" + formBean.getStrIssueDate() +
						   "\n     CR No.        :" + MakeRptStr(formBean.getStrCrNo(),30) + "\t\n";
		
				rptContents += "   ---------------------------------------------------------------------------\n" + 
							   "   S.No  Drug Name                             Batch No.   Exp Date  Issue Qty\n" +
							   "   ---------------------------------------------------------------------------\n" ;
				while (ws.next()) 
				{
				  rptContents += MakeRptStr(String.valueOf(i)+".",3) + "" + MakeTariffStr(ws.getString(2),40,5) + " " +
				                 MakeRptStr(ws.getString(3),8) + "  " + MakeRptStr(ws.getString(4),10) + " " +
				                 MakeRptStr(ws.getString(5),4)+ "\n";	
				  i++;
				}
				rptContents += "   ---------------------------------------------------------------------------\n";
				rptContents += formBean.getStrHindiText();
				
				// Form Feed
				rptContents += String.valueOf((char)12);
			
		}
		return rptContents;
		
	}
    public static String MakeRptStr(String tempString,int len)
	  {
			if(tempString.length()<len)
			{
				int len1 = tempString.length();
				for(int i = 0;i<(len-len1);i++)
					tempString += " ";			
			}
		
			return tempString;	
	  }
		/*******************************************************end****/
		public static String MakeTariffStr(String Tname,int len,int prevSpace)
		{
				String Tname1 = "";
				String Tname2 = "";
				int i = 0;
				int len1 = 0;
						
				if(Tname.trim().length()>len)
				{
					Tname1 = Tname.substring(0,len) + "\n";
					for(i=0;i<prevSpace;i++)
						Tname1 += " ";
					
					Tname2 = "-" + Tname.substring(len);
					len1 = Tname2.length();
					if(len1 > len)
					{
						Tname2 = "-" + Tname.substring(len,len-1);
						len1 = Tname2.length();
					}
								
					Tname1 += Tname2;	
				}
				else
				{
					Tname1 = Tname;
					len1 = Tname1.length();
				}
				//
				for(i=0;i<(len-len1);i++)
					Tname1 += " ";
				
				return Tname1;	
			}


	
	/**
	 * This method is used to show issued item Details on VIEW PAGE2
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
		public static String getIssuedDetail(WebRowSet wb)throws SQLException 
		{
			StringBuffer br = new StringBuffer();

		    String strIssueDate = "";
			String strIssueNo = "";
			String strIndentingStore = "";
			String strIndentNo = "";
			String strIndentDate = "";

			int i = 0;

			try 
			{
				
				br.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellpadding='1px' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td class='multiRPTLabel' WIDTH='10%' align='CENTER'>#</td>");
				br.append("<td class='multiRPTLabel' WIDTH='15%' align='CENTER'>Issue Date</td>");
				br.append("<td class='multiRPTLabel' WIDTH='10%' align='CENTER'>Issue No</td>");
				br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>Issuing Store</td>");
				br.append("<td class='multiRPTLabel' WIDTH='15%' align='CENTER'>CR No</td>");
				br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>Patient Name</td>");
				//br.append("<td class='multiRPTLabel' WIDTH='10%' align='CENTER'>#</td>");
				br.append("</tr>");
				
				if (wb.size() != 0) 
				{
				
					while (wb.next()) 
					{
						strIssueDate      = wb.getString(2);
						strIssueNo        = wb.getString(1);
						strIndentingStore = wb.getString(3);
						strIndentNo       = wb.getString(4);
						strIndentDate     = wb.getString(5);
						br.append("<input type='hidden' name='strHlpIssueNo' id='strHlpIssueNo" +i+ "' value=" + strIssueNo + " />");
						br.append("<input type='hidden' name='strHlpIndentNo' id='strHlpIndentNo" +i+ "' value=" + strIndentNo + " />");
						br.append("<input type='hidden' name='strHlpIndentDate' id='strHlpIndentDate" +i+ "' value=" + strIndentDate + " />");
						br.append("<input type='hidden' name='strHlpCrNo' id='strHlpCrNo" +i+ "' value=" + wb.getString(6) + " />");
						br.append("<input type='hidden' name='strHlpPatientName' id='strHlpPatientName" +i+ "' value=" + wb.getString(7) + " />");
						
						br.append("<tr id='roww"+i+"'>");	
						if(wb.isFirst())
							br.append("<td WIDTH='10%' CLASS='multiPOControl' ><div name='plus' id='plusdiv"+i+"'><input type='radio' name='gender' checked onclick='validateIssue(\""+ i + "\");' style='cursor: pointer;' title='Click to show item details'></div></td>");
							else
							br.append("<td WIDTH='10%' CLASS='multiPOControl' ><div name='plus' id='plusdiv"+i+"'><input type='radio' name='gender'   onclick='validateIssue(\""+ i + "\");' style='cursor: pointer;' title='Click to show item details'></div></td>");
						br.append("<td WIDTH='15%' CLASS='multiPOControl' >"  + strIssueDate + "</td>");
						br.append("<td WIDTH='20%' CLASS='multiPOControl' >");
						br.append("<input type='hidden' name='flag' id='flag" +i+ "' value=" + "0" + " />");
						br.append("<div class='popup' id='IssueItempopup' style='display: none'></div>");					
						br.append(strIssueNo);
						br.append("</td>");
						br.append("<td WIDTH='10%' CLASS='multiPOControl' >"	+ strIndentingStore + "</td>");
						br.append("<td WIDTH='15%' CLASS='multiPOControl' >"	+ wb.getString(6) + "</td>");
						br.append("<td WIDTH='20%' CLASS='multiPOControl' >"	+ wb.getString(7) + "</td>");
						//br.append("<td WIDTH='10%' CLASS='multiPOControl' ><a href='#' onclick='addnewtab();'>New Request</a> </td>");
						//br.append("<td WIDTH='10%' CLASS='multiPOControl' ><img height='20px' width='30px' src='../../hisglobal/transactionutil/images/IssueOnDesk.png' onclick='validateIssue(\""+ i + "\");' style='cursor: pointer;' title='Click to Issue'><img src='../../hisglobal/images/search_icon1.gif' onclick='generateIssueReportFunc(this,\""+ i + "\");' style='cursor: pointer;' title='Print Issue Item Details'></td>");
						//br.append("<td WIDTH='10%' CLASS='multiPOControl' ><div name='plus' id='plusdiv"+i+"'><img height='20px' width='20px' src='../../hisglobal/images/plus.png' onclick='validateIssue(\""+ i + "\");' style='cursor: pointer;' title='Click to show item details'><img height='20px' width='20px' src='../../hisglobal/images/delete_on.gif' onclick='deleteIssue(\""+ i + "\");' style='cursor: pointer;' title='Click to delete issue req'></div></td>");
							
						br.append("</tr>");
						i++;
					}

					br.append("</table> ");
				} else {
					br
							.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
					br.append("<tr>");
					br.append("<td  CLASS='multiControl' colspan='5'>"
							+ "No Record Found" + "</td>");
					br.append("</tr>");
					br.append("</table> ");
				}

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return "ERROR";

			}

			return br.toString();
		}
	/**
	 * Gets the issue dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the issue dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getIssueDtlsInitView(IssueTransFB formBean) throws Exception {

		StringBuffer sb = new StringBuffer("");
		int i=1;
		
		ResourceBundle res = null;
		WebRowSet ws = null;
		
		String strTableWidth = "825";
		
		try 
		{
			res = mms.qryHandler_mms.res;
			if(res == null) 
			{
				res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = res;
			}

			ws = formBean.getWsIssueDetails();
			
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
			//System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
			//System.out.println("the ws length isa  "+ws.getKeyColumns());
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
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			//sb.append(hospitalVO.getCity());
			//sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			
			
			/*
			
			sb.append("<table align='center' width='").append(strTableWidth + "' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr>");
			sb.append("<td width='10%'></td>");			
			sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
//			sb.append("This is Testing Slip");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			
			sb.append("<tr>");
			sb.append("<td width='10%'></td>");			
			sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			sb.append(res.getString("PAT_ISSUE_TITLE1"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr>");
			sb.append("<td width='10%'></td>");					
			sb.append("<td width='90%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			sb.append(res.getString("PAT_ISSUE_TITLE2"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");		
			sb.append("<tr>");
			sb.append("<td width='10%'></td>");					
			sb.append("<td width='90%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			System.out.println("formBean.getStrHospitalName()"+formBean.getStrHospitalName());
			sb.append(formBean.getStrHospitalName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("</table>"); 	
			*/
			sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; '  name='PrintPage' tabindex='1' title='Print Page'");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(1);'/> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopupOne();' /></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
			
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");	
			
			sb.append("<tr>");
			sb.append("<td width='100%' align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue to Patient</b></font></td> ");
			sb.append("</tr>");
			
			/*sb.append("<tr> ");
			
			sb.append("<td width='50%' colspan='2'  align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrLocDL().split("@")[1])
					.append("</font></td> ");	*/		

			//sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("D.L. No.: </b></font></td> ");
			//sb.append("<td width='25%'  align='LEFT' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrLocDL().split("@")[0]).append(
					//"</font></td> ");
			//sb.append("</tr> ");
			/*************************************************1*******************************************************************/
			sb.append("<tr> ");	
			sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Patient:</b></font></td> ");
//			sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueNo())
//						.append("</b></font></td> ");
			sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >"+formBean.getStrPatientName()+"</font></td> ");			
	
			sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Store Name:</b></font></td> ");
			sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrStoreName()).append(
						"</font></td> ");
			sb.append("</tr> ");
			/**************************************************2*****************************************************************/
			
			sb.append("<tr> ");	
			sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Doctor:</b></font></td> ");
			sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrPrescribedBy())
						.append("</font></td> ");
	
			sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issue No:</b></font></td> ");
			sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrIssueNo()).append(
						"</font></td> ");
			sb.append("</tr> ");
			/**************************************************3******************************************************************/
			sb.append("<tr> ");	
			sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Reg.No:</b></font></td> ");
//			sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueNo())
//						.append("</b></font></td> ");
			sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >"+formBean.getStrRegNo()+"</font></td> ");
	
			sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issue Date:</b></font></td> ");
			sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrIssueDate()).append(
						"</font></td> ");
			sb.append("</tr> ");
			/***************************************************4*****************************************************************/
			sb.append("<tr> ");	
			
	
			sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("CR No:</b></font></td> ");
		     sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrCrNo())
					.append("</font></td> ");
		     if(formBean.getStrLFAccountNo() != null && !formBean.getStrLFAccountNo().equals("0"))
		     {
		    	 sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("LF No:</b></font></td> ");
		    	 sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrLFAccountNo())
					.append("</font></td> ");
		     }
		     else
		     {
		    	 sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
		    	 sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
		     }
		
			sb.append("</tr> ");
			/********************************************************************************************************************/
			sb.append("</table> ");
			
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			sb.append("<tr>");
			sb.append("<td colspan='4' align='left'><hr size='2'></td>");
			sb.append("<td colspan='3' align='center'><hr size='2'></td>");					
			sb.append("</tr>");
			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");						
			sb.append("<td align='center' width='35%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
			sb.append("</td>");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
			sb.append("</td> ");
			sb.append("<td align='right' width='10%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
			sb.append("</td> ");
    		sb.append("<td align='right'  width='10%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate(Rs.)</b></font>");
		sb.append("</td> ");
		sb.append("<td align='right'  width='10%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost(Rs.)</b></font>");
		sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr>");
			sb.append("<td colspan='4' align='left'><hr size='2'></td>");
			sb.append("<td colspan='3' align='center'><hr size='2'></td>");					
			sb.append("</tr>");
			//System.out.println("In HLP Size is::::::"+ws.size());
			float NetAmount=0;
			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
						
					/*
					  (Which Call in Case of Off-Line Issue Voucher)
					  1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued By Doctor ^ Date ^ Cr No ^ Hindi Text ^ Registration No 
					  2.Drug Name
					  3.Batch No 
					  4.Exp Date
					  5.Issue Qty
					 */	
					sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i+".");
					sb.append("</font></td> ");					
					sb.append("<td align='left' width='35%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(ws.getString(2));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(3));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(4));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(5));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(6));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");  									
					sb.append("</tr> ");
					NetAmount=NetAmount+ Float.parseFloat(ws.getString(7));
					i++;
								
				}								
					
//					NumberFormat formatter = new DecimalFormat("############.##");  				    					
//					String ServiceCharge ="";					
//					String FinaltotalCost = formatter.format(new BigDecimal(totalCost)); 					
					sb.append("<tr>");
					sb.append("<td colspan='4' align='left'><hr size='2'></td>");
					sb.append("<td colspan='3' align='center'><hr size='2'></td>");					
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>TOTAL Rs.(Round )</b></font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(Math.round(NetAmount));//
				//s	myFormatter.format(Double.parseDouble(FinaltotalCost)));				
					sb.append("</font></td>");
					sb.append("</tr>");					
						
//						double IssueRatePercentage  = Double.parseDouble(configIssueRate);
//						
//						double PurchaseCost         =  Double.parseDouble(strItemTotCost);
//				        
//				        totAmtStr = "(" + util.getAmountStr(FinaltotalCost)+ ")";
//						sb.append("<tr>");
//						sb.append("<td  colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'></font></td>");
//						sb.append("<td  colspan='6' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(Rs.) In Words :-" + totAmtStr + "</strong></font></td>");
//						sb.append("</tr>");
//						
//						sb.append("<tr> ");
//						sb.append("<td colspan='7' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>[ "+formBean.getStrIssueBy()+"]<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
//						sb.append("</tr> ");
						
						sb.append("<tr>");
						sb.append("<td colspan='4' align='left'></td>");
						sb.append("<td colspan='1' align='center'></td>");					
						sb.append("</tr>");	
						sb.append("<tr>");
						sb.append("<td colspan='4' align='left'></td>");
						sb.append("<td colspan='1' align='center'></td>");					
						sb.append("</tr>");
						
//						sb.append("<tr> ");
//						sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Signature<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
//						sb.append("</tr> ");						
				        		
			} 
			else 
			{

				sb.append("<tr> ");
				sb.append("<td colspan='5' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
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
	
	
	 public static String getIssuePopUp(String strHospCode,String strStoreId,String strIssueNo)throws IOException 
	 {
		 /* Creating VO & BO Object Here */
		 IssueTransVO vo = new IssueTransVO();
		 IssueTransBO bo = new IssueTransBO();
		 
		 /* Declaring Variable */
		 StringBuffer sb              = new StringBuffer("");
		 String       strItemName     = "";
		 String       strIssueQtyUnit = "";
		 String       strRateUnit 	  = "";
		 String       strCost         = "";
		 WebRowSet    ws              = null;
				 
		 /* Setting Value in vo Object */
		 vo.setStrStoreId(strStoreId);
		 vo.setStrHospitalCode(strHospCode);
		 vo.setStrIssueNo(strIssueNo);
				
		 /* Calling BO Method  */
		  bo.getIssueDtlPopUp(vo);
		
		
		  ws = vo.getStrIssueDtlPopUpWs();
		  
		
		
		   
		   sb.append("<table width='500' align='center' border='0' cellpadding ='1px' cellspacing ='1px'>"); 
		   sb.append("<tr class='HEADER'><td colspan='3'>Issue Item Details</td>"); 
		   sb.append("<th align='right' ><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG' onClick=hideIssueDetails('popUpDiv1');hideIssueDetails('blanket');>");
		   sb.append("</th>");
		   sb.append("</tr>");
		   sb.append("</table>");
		   sb.append("<table width='500' align='center' border='0' cellpadding ='1px' cellspacing ='1px' bgcolor='#086fa6'>"); 
		   sb.append("<tr>");
		   sb.append("<td width='45%' class='multiRPTLabel'><font color='white'>Drug Name</font></td>");
		   sb.append("<td width='15%' class='multiRPTLabel'>Issue/Return Qty</td>");
		   sb.append("<td width='25%' class='multiRPTLabel'>Rate/Unit</td>");
		   sb.append("<td width='15%' class='multiRPTLabel'>Cost</td>");
		   sb.append("</tr>");
		   sb.append("</table>");
		   sb.append("<table width='500' align='center' border='0' cellpadding ='1px' cellspacing ='1px' bgcolor='#bdd9f0'>"); 
		  try 
		   {
			  
				  if (ws != null && ws.size() != 0) 
				  {				     	
					while(ws.next())
	                 {
					    	
									 strItemName     = ws.getString(1).trim();
									 strIssueQtyUnit = ws.getString(2).trim(); 
									 strRateUnit     = ws.getString(3).trim();
									 strCost         = ws.getString(4).trim();
							 						   			
		  						    if(strItemName == null || strItemName.equals("")) strItemName = "-----";
		  	  				        if(strIssueQtyUnit == null || strIssueQtyUnit.equals("")) strIssueQtyUnit = "-----";
		  	  				        if(strRateUnit == null || strRateUnit.equals("")) strRateUnit = "-----"; 
		  	  				        if(strCost == null || strCost.equals("")) strCost = "-----";
		  					    
								    sb.append("<tr>");
								    sb.append("<td align='left' width='45%' class='multiPOControl'>");
								    sb.append(strItemName);
								    sb.append("</td>");
								    sb.append("<td width='15%' class='multiPOControl'>");
								    sb.append(strIssueQtyUnit);
								    sb.append("</td>");
								    sb.append("<td width='25%' class='multiPOControl'>");
								    sb.append(strRateUnit);
								    sb.append("</td>");
								    sb.append("<td width='15%' class='multiPOControl'>");
								    sb.append(strCost);
								    sb.append("</td>");
								    sb.append("</tr>");
		  	                      
		  				        }
						  }	
				      else
				      {
				    	  sb.append("<tr><td colspan='4' class='multiControl'><font color='red'>No Matching Record Found</font></td></tr>");
		 			     
				      } 	 
			    
			 }
			 catch (SQLException e) 
	         {
				 
				throw	new HisException("Issue Transaction","IssueTransHLP .getIssuePopUp() -->",e.getMessage());
			 }
			
	         
		    sb.append("</table>");
		  
			return sb.toString();
		}
	 
	 public static String getRequestDetails(WebRowSet ws)
	    {
			
			StringBuffer sb = new StringBuffer("");
			
			try {
				
				if(ws != null && ws.size() > 0)
				{ 
					if (ws.next()) 
					{
											
						String strDeptName         = ws.getString(1);
						String strUnitName           = ws.getString(2);
						String strPrescribedBy         = ws.getString(3);
						String strPrescriptionFor  =    ws.getString(4);
						String strPrescriptionDate       = ws.getString(5);
						String strPrescriptionFrom       = ws.getString(9);
						
						String strDeptId = ws.getString(6);
						String strUnitId =	ws.getString(7);
						String strConsultantId = ws.getString(8);
						String strEpisodeCode = ws.getString(10);
						String strVisitNo = ws.getString(11);
						String strWardCode = ws.getString(12);
						String strAdmissionNo = ws.getString(13);
						String strEmployeeNo  = ws.getString(14);
						String strVisitTypeId = ws.getString(15);
						String strReqDate = ws.getString(16);
												
						String strHidReqVal = strDeptId+"^"+strUnitId+"^"+strConsultantId+"^"+strPrescribedBy+"^"+strPrescriptionFor+"^"+strPrescriptionFrom+"^"+strEpisodeCode+"^"+strVisitNo+"^"+strWardCode+"^"+strAdmissionNo+"^"+strEmployeeNo+"^"+strVisitTypeId+"^"+strReqDate;
						
						if (strDeptName == null)
							strDeptName = "----";
						if (strUnitName == null)
							strUnitName = "----";
						if (strPrescribedBy == null)
							strPrescribedBy = "----";
						if (strPrescriptionFor == null)
							strPrescriptionFor = "----";
						if (strPrescriptionDate == null)
							strPrescriptionDate = "----";
						if (strPrescriptionFrom == null)
							strPrescriptionFrom = "----";
						
						
						sb.append("<input type='hidden' name ='strHidReqVal'  value='"+strHidReqVal+"'>");
						
						sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px' >");
						sb.append("<input type='hidden' name='strReqDate' id='strReqDate' value='"+strPrescriptionDate+"'>");
						sb.append("<tr><td class='TITLE' colspan='4'>Request Details</td></tr>");
						sb.append("<tr><td width='25%'  class='LABEL'>Department</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strDeptName);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Unit</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strUnitName);
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Prescribed By</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strPrescribedBy);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Prescription For</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strPrescriptionFor);
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Prescription Date</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strPrescriptionDate);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Prescription From</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strPrescriptionFrom);
						sb.append("</td></tr>");
						sb.append("</table>");
						
					}
				}
				else {
					   
					sb.append("<TR>");
					sb.append("<TD WIDTH='25%' CLASS='multiControl' colspan='5'><font color = 'red'>"
							+ "No Record Found" + "</font></TD>");
					sb.append("</TR>");
					    
					    
						
				   } 
			}catch(Exception e){
				 
				throw new HisException("Issue Transaction","IssueTransHLP.getRequestDetails()-->",e.getMessage());
			}
		return sb.toString();
		}
	 
	 
	 public static String getItemDetails(String hosCode, WebRowSet wb)
		throws SQLException {
			StringBuffer br = new StringBuffer();
		
	//		IssueTransBO bo = null;
			IssueTransVO vo = null;
	//		HisUtil hisutil = null;
		
	//		String strUnitValues = "";
			int i = 0;
		
			try {
		//		hisutil = new HisUtil("mms", "IssueTransHLP");
		//		bo = new IssueTransBO();
				vo = new IssueTransVO();
					
				    br.append("<div id = 'itemDetailDivId' style='display:none'>");
					br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px' >");
					br.append("<tr><td class='TITLE' colspan='7'>Item Details(Online)</td></tr>");
					br.append("</table> ");
					br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px' bgcolor='#6097BC'>");
					br.append("<tr><td width='15%' class='multiLabel'>Item Name</td>");
					br.append("<td width='13%' class='multiLabel'>Avl Qty</td>");
					br.append("<td width='12%' class='multiLabel'>Balance Qty</td>");
					br.append("<td width='15%' class='multiLabel'>Dosage</td>");
					br.append("<td width='15%' class='multiLabel'>Frequency</td>");
					br.append("<td width='15%' class='multiLabel'>Days</td>");
					br.append("<td width='15%' class='multiLabel'>Quantity</td></tr>");
				
					if (wb != null && wb.size() > 0) 
					 {	
					
					   while (wb.next()) {
						   
							String strItemName = wb.getString(1);
							String strAvlQty = wb.getString(2);
							String strBalQty = wb.getString(3);
							String strReqQty = wb.getString(4);
							String strReqQtyUnitId = wb.getString(5);
							String strIssueQty = wb.getString(6);
						//	String strIssueQtyUnitId = wb.getString(7);
							String strGenItemId = wb.getString(8);
							String strItemBrandId = wb.getString(9);
							String strIssueQtyBaseVal = wb.getString(10);
							String strGroupId = wb.getString(11);
							String strSubGroupId = wb.getString(12);
							String strBalanceQty = wb.getString(13);
							
							String strDosageName = wb.getString(17);
							String strFrequencyName = wb.getString(18);
							String strDays = wb.getString(19);
							String strQuantity = wb.getString(20);
							
							String strHiddenDosageFreq = wb.getString(15)+"^"+wb.getString(16)+"^"+strDays+"^"+strQuantity;
							
							String strHidVal = strIssueQtyBaseVal+"^"+strGenItemId+"^"+strItemBrandId+"^"+strBalQty+"^"+strGroupId+"^"+strSubGroupId+"^"+strReqQtyUnitId+"^"+strBalanceQty;
							
							String strBalQtyDtl = strReqQty+"^"+strIssueQty;
							
							String[] temp = strAvlQty.replace('@', '#').split("#");
							
							String[] strAvailableQty = temp[0].split("\\^");
							String[] strUnitId = temp[1].split("\\^");
							vo.setStrIssueUnitId(strUnitId[0]);
							
//							System.out.println("strAvlQty--->"+strAvlQty);
//							System.out.println("strUnitId-->"+strUnitId[0]);
//							System.out.println("strAvailableQty-->"+strAvailableQty);
						
//							String strAvlBaseVal = strUnitId[1];
							
//							vo.setStrHospitalCode(hosCode);
							
//							bo.getUnitCombo(vo);
							  
					 
//					 		if (vo.getStrIssueUnitWs() !=null && vo.getStrIssueUnitWs().size() > 0) { 
						
//							 strUnitValues = hisutil.getOptionValue(vo .getStrIssueUnitWs(), "", "0^Select Value", true); 
									 
//							 } else {
//			 
//							  strUnitValues = "<option value='0'>Select Value</option>"; 
//								}
						   
						 		
						 		
						br.append("<input type='hidden' name='strAvlQty' id='strAvlQty"+i+"' value='"+strAvlQty+"'>"); 		
						br.append("<input type='hidden' name='strHidValue' id='strHidValue"+i+"' value='"+strHidVal+"'>");
					    br.append("<input type='hidden' name='strBalQtyDtl' id='strBalQtyDtl"+i+"' value="+strBalQtyDtl+" >");
					    br.append("<input type='hidden' name='strHiddenDosageFreq' id='strHiddenDosageFreq"+i+"' value='"+strHiddenDosageFreq+"'>");
						br.append("<TR>");
						
						br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >"
								+ strItemName + "</TD>");
						br.append("<TD WIDTH='13%' colspan='1' CLASS='multiControl' >"
								+ strAvailableQty[0] + "</TD>");
						br.append("<TD WIDTH='12%' colspan='1' CLASS='multiControl' ><a name='strBalQty' id='strBalQty"+i+"' STYLE='CURSOR:POINTER;color:blue' onClick='balQtyDtl(this,\"" + i + "\");'>" 
								+strBalQty+"</a></TD>");
						
						br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >"
								+ strDosageName + "</TD>");
						br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >"
								+ strFrequencyName + "</TD>");
						br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >"
								+ strDays + "</TD>");
						br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >"
								+ strQuantity + " No. </TD>"); 
												
						
					//	br.append("<TD WIDTH='18%' colspan='1' CLASS='multiControl' ><input type='text' name='strIssueQty' id='strIssueQty"+i+"' class='txtFldMin' maxlength='8' onkeyup='checkQtyWithoutUtility(\"" + i + "\",\"strIssueQty\",\"strIssueUnitId\",\""+strIssueQtyBaseVal+"\" , \"Issue Quantity should not be Greater than Balance Quantity\" ) , checkQtyWithoutUtility1(\"" + i + "\",\"strIssueQty\",\"strIssueUnitId\",\""+strAvlBaseVal+"\" , \"Issue Quantity should not be Greater than Available Quantity\" );' onkeypress='return validateData(event,7);' ></TD>");               
					//	br.append("<TD WIDTH='20%' colspan='1' CLASS='multiControl' ><select name='strIssueUnitId' id='strIssueUnitId"+i+"'  onchange='checkQtyWithoutUtility(\"" + i + "\",\"strIssueQty\",\"strIssueUnitId\",\""+strIssueQtyBaseVal+"\" , \"Issue Quantity should not be Greater than Balance Quantity\" ) , checkQtyWithoutUtility1(\"" + i + "\",\"strIssueQty\",\"strIssueUnitId\",\""+strAvlBaseVal+"\" , \"Issue Quantity should not be Greater than Available Quantity\" );' > "+ strUnitValues + "</select></TD>");
						
					//	br.append("<td class='multiControl' colspan='1' WIDTH='6%'><a  STYLE='CURSOR:POINTER;color:blue' title='Item Preferences'  onClick='getItemStockDtl(\"" + i + "\");'>#</a><input type='hidden' name='strHidDivId' id='strHidDivId"+i+"' value = '' ></td>");
						
						br.append("</TR>");
						i++;
					}
		
					br.append("</table> ");
					br.append("</div> ");
				} else {
					br.append("<div id = 'itemDetailDivId' style='display:none'>");
					br.append("<TR>");
					br.append("<TD WIDTH='25%' CLASS='multiControl' colspan='6'><font color = 'red'>"
							+ "No Record Found" + "</font></TD>");
					br.append("</TR>");
					br.append("</div> ");
				}
		
			} catch (Exception e) {
			 
				throw new HisException("Issue Transaction","IssueTransHLP .getItemDetails() -->",e.getMessage());
		
			}
		
			return br.toString();
		}
	 
	 public static String getIssueDetails(WebRowSet ws)
		throws SQLException {
			StringBuffer sb = new StringBuffer();
		
			int i = 0;
		
			try {
				
				if(ws != null && ws.size() > 0)
				{ 
					sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
					
					while (ws.next()) 
					{
											
						String strIssueNo = ws.getString(1);
						String strIssueDate = ws.getString(2);
						String strIssueSoreID = ws.getString(3);
						if (strIssueNo == null)
							strIssueNo = "----";
						if (strIssueDate == null)
							strIssueDate = "----";
						
					
						sb.append("<input type='hidden' name='strIssueNo' id='strIssueNo"+i+"' value="+strIssueNo+" >");
						sb.append("<input type='hidden' name='strIssueSoreID' id='strIssueSoreID"+i+"' value="+strIssueSoreID+" >");
						sb.append("<tr><td width='50%' colspan ='2'  class='LABEL'>IssueNo. / IssueDate</td>");
						sb.append("<td width='50%' colspan ='2' class='CONTROL'><a name='strIssueDtl' id='strIssueDtl' STYLE='CURSOR:POINTER;color:blue' onClick='getIssuePopUp(this, \""+i+"\" );'>");
						sb.append(strIssueNo +"/"+ strIssueDate);
						sb.append("</td></tr>");
				
						i++;
					}
					
					sb.append("</table>");
				}
				else {
					sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
					sb.append("<TR>");
					sb.append("<TD WIDTH='25%' CLASS='multiControl' colspan='4'><font color = 'red'>"
							+ "No Record Found" + "</font></TD>");
					sb.append("</TR>");
					sb.append("</table>");
					   				    
						
				   } 
			} catch (Exception e) {
				 
				throw new HisException("Issue Transaction","IssueTransHLP .getIssueDetails() -->",e.getMessage());
		
			}
		
			return sb.toString();
		}
	 
	 public static String getRequestDtls(WebRowSet wb)
		{ 
			StringBuffer br = new StringBuffer();
			int i=0;
						
			try{
				
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<tr><td class='TITLE' colspan='5'>Request Details(Online)</td></tr>");
				br.append("</table> ");
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px' bgcolor='black'>");
				br.append("<tr><td width='10%' class='multiLabel'>#</td>");
				br.append("<td width='25%' class='multiLabel'>Department</td>");
				br.append("<td width='20%' class='multiLabel'>Unit</td>");
				br.append("<td width='25%' class='multiLabel'>Prescribed By</td>");
				br.append("<td width='20%' class='multiLabel'>Prescribed Date</td>");
				br.append("<tr></table> ");
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px' bgcolor='#6097BC'>");
								
				if(wb != null && wb.size() > 0)
					{
						 
		                 while (wb.next())
		                    {
		                	 
		                	 	String strOnlineDept         = wb.getString(2);
								String strOnlineUnit           = wb.getString(3);
								String strOnlinePresBy			= wb.getString(4);
								String strOnlinePresDate			= wb.getString(5);
								String strRadioOnlineReqVal      = wb.getString(1);
								
								if (strOnlineDept == null)
									strOnlineDept = "----";
								if (strOnlineUnit == null)
									strOnlineUnit = "----";
								if (strOnlinePresBy == null)
									strOnlinePresBy = "----";
								if (strOnlinePresDate == null)
									strOnlinePresDate = "----";
		                	 
		                    	br.append("<TR>");
		                    	if(i==0 )
		                    		br.append("<TD WIDTH='10%' CLASS='multiControl'><input type='radio' name='strRadioOnlineReqVal' id = 'strRadioOnlineReqVal"+i+"' value="+ strRadioOnlineReqVal + " onclick='getRequestDetail(this);'  ></TD>");
		                    	else
		                    		br.append("<TD WIDTH='10%' CLASS='multiControl'><input type='radio' name='strRadioOnlineReqVal' value="+ strRadioOnlineReqVal + " onclick='getRequestDetail(this);' ></TD>");
		    				    br.append("<TD WIDTH='25%' CLASS='multiControl'>"+ strOnlineDept + "</TD>");
		    				    br.append("<TD WIDTH='20%' CLASS='multiControl'>"+ strOnlineUnit + "</TD>");
		    				    br.append("<TD WIDTH='25%' CLASS='multiControl'>"+ strOnlinePresBy + "</TD>");
		    				    br.append("<TD WIDTH='20%' CLASS='multiControl'>"+ strOnlinePresDate + "</TD>");
		    				    br.append("</TR>");
		    				    i++;  
		    				}
		                 br.append("</table> ");
					}else{
						br.append("<TR>");
				br.append("<TD WIDTH='25%' CLASS='multiControl' colspan='5'><font color = 'red'>"
						+ "No Record Found" + "</font></TD>");
				br.append("</TR>");
				
					}
				
			}catch(Exception e){
				throw new HisException("Issue Transaction","IssueTransHLP.getRequestDetails()-->",e.getMessage());
			}
		return br.toString();
		}
	 
	 public static String getBilledItemDtls(IssueTransVO vo)throws SQLException 
		{
			StringBuffer br = new StringBuffer();
			WebRowSet wb= vo.getStrBilledItemDetailWs();

		    String strIssueDate = "";
			String strIssueNo = "";
			String strIndentingStore = "";
			String strIndentNo = "";
			String strIndentDate = "";
			float tot=0;

			int i = 0;

			try 
			{
				br.append("<table class='TABLEWIDTH' align='center' cellpadding='1' cellspacing='1'>"); 
				br.append("<tr>");
				br.append("<td class='TITLE' colspan='2'><div id='minusdiv' style=''>");
				if (wb.size() != 0) 
				{
					wb.next();
					br.append("&nbsp;Billed Item Details against Receipt no. " + wb.getString(8).replace("^","#").split("#")[0] +" & Issue No : "+ wb.getString(1)+"</div>");
				}
				else
					br.append("&nbsp;Billed Item Details </div>");
				
				br.append("</td></tr></table>");
				
				br.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellpadding='1px' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td class='multiRPTLabel' WIDTH='35%' align='CENTER'>Item Name</td>");
				br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>Billed Qty</td>");
				br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>Batch/Serial No.</td>");
				br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>M.R.P.</td>");
				br.append("</tr>");
				wb.beforeFirst();
				if (wb.size() != 0) 
				{
				
					while (wb.next()) 
					{
						strIssueDate      = wb.getString(2);
						strIssueNo        = wb.getString(1);
						strIndentingStore = wb.getString(3);
						strIndentNo       = wb.getString(4);
						strIndentDate     = wb.getString(5);
						br.append("<input type='hidden' name='strHlpIssueNo' id='strHlpIssueNo" +i+ "' value=" + strIssueNo + " />");
						br.append("<input type='hidden' name='strHlpIndentNo' id='strHlpIndentNo" +i+ "' value=" + strIndentNo + " />");
						br.append("<input type='hidden' name='strHlpIndentDate' id='strHlpIndentDate" +i+ "' value=" + strIndentDate + " />");
						br.append("<input type='hidden' name='strHlpCrNo' id='strHlpCrNo" +i+ "' value=" + wb.getString(6) + " />");
						br.append("<input type='hidden' name='strHlpPatientName' id='strHlpPatientName" +i+ "' value=" + wb.getString(7) + " />");
						br.append("<input type='hidden' name='strHlpBillDtl' id='strHlpBillDtl" +i+ "' value=" + wb.getString(8) + " />");
						
						br.append("<tr>");	
						br.append("<td WIDTH='25%' CLASS='multiPOControl' >"  + wb.getString(9) + "</td>");
						br.append("<td WIDTH='20%' CLASS='multiPOControl' >"	+ wb.getString(8).replace("^","#").split("#")[1] + "</td>");
						br.append("<td WIDTH='20%' CLASS='multiPOControl' >"	+ wb.getString(10) + "</td>");
						br.append("<td WIDTH='20%' CLASS='multiPOControl' >"	+ wb.getString(11) + "</td>");

						br.append("</tr>");
						i++;
						tot+= Float.parseFloat(wb.getString(8).replace("^","#").split("#")[1].split(" ")[0]) * Float.parseFloat(wb.getString(11).split("/")[0]);
					}
					br.append("<tr>");
					br.append("<td colspan='4' CLASS='multiPOControl' ><div align='right'><b> Total Cost : " + tot + "</b></div></td>");
					br.append("</tr>");
					br.append("<tr>");
					br.append("<td colspan='4' CLASS='multiPOControl' ><div align='right'><a href='#' class='button' onclick='save();'><span class='issue'><div align='center'>Issue</div></span></a></div></td>");
					br.append("</tr>");
					br.append("</table> ");
				} else {
					br
							.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
					br.append("<tr>");
					br.append("<td  CLASS='multiControl' colspan='5'>"
							+ "No Record Found" + "</td>");
					br.append("</tr>");
					br.append("</table> ");
				}

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return "ERROR";

			}

			return br.toString();
		}

	}


