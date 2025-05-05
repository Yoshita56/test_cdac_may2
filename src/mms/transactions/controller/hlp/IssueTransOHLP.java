package mms.transactions.controller.hlp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.GlobalVO;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.transactions.bo.IssueTransOBO;
import mms.transactions.bo.ReturnFromTransBO;
import mms.transactions.controller.fb.IssueTransOFB;
import mms.transactions.vo.IssueTransOVO;
import mms.transactions.vo.ReturnFromTransVO;

public class IssueTransOHLP {
	
	public static String getPatientDtl(IssueTransOFB formBean) throws Exception 
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
	
    public static String getIssueRptForDotMatrix(IssueTransOFB formBean)throws SQLException, UnsupportedEncodingException
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
	public static String getIssueDtlsInitView(IssueTransOFB formBean) throws Exception {

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
	
	 public static String getAfterSaveVoucher(IssueTransOVO vo,String mode) throws Exception {
	      StringBuffer sb = new StringBuffer("");
	      int i = 1;
	      ResourceBundle res = null;
	      WebRowSet ws = null;
	      WebRowSet ws1 = null;
	      String strTableWidth = "825";

	      try {
	        
	    	  
	    	  sb.append("<table  width='825' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ " <tr> "
						+ " <td colspan='1'></td>"
						+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>");
	    	  if(mode.equals("1"))
	    	  {
	    		  sb.append("<td colspan='1'><td colspan='1'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData_O();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();' /></div></td>");
	    	  }
	    	  else
	    	  {
	    		  if(mode.equals("2"))
		    	  {
		    		  sb.append("<td colspan='1'><td colspan='1'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData_O();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();'/></div></td>");
		    	  }
	    		  else
	    		  {
	    		      sb.append("<td colspan='1'><td colspan='1'><div id='printImg' align='right'></div></td>");
	    		  }    
	    	  }
	    	  sb.append("</tr>");			
	    		
	    	  sb.append("</table>");
				        
	         sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
	         sb.append("<tr>");
	         sb.append("<td width='100%' align='center' colspan='5'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Invoice</b></font></td> ");
	        

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
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>").append(vo.getStrIssueNumber()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>").append("Invoice Date:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>").append(vo.getStrIssueDate()).append("</font></td> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");
	         sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
	         sb.append("<tr>");
	         sb.append("<td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>");
	         sb.append(vo.getStrPatientDtl());
	         sb.append("</font></td> ");
	         sb.append("</tr> ");
	         sb.append("</table>");     
	        
	         sb.append("<table class='custom-table' width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
	         sb.append("<tr bgcolor='#cdc9c9'> ");
	         sb.append("<td align='center' 	width='5%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>SL</b></font> ");
	         sb.append("</td>");
	         sb.append("<td align='center' 	width='39%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Product</b></font> ");
	         sb.append("</td>");
	         sb.append("<td align='center' 	width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Batch No.</b></font> ");
	         sb.append("</td> ");
	         sb.append("<td align='center' 	width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>Expiry</b></font>");
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
						System.out.println("ws.getString(36)==============================="+ws.getString(36));
                        /*  
						    Discount = Marked Price � Selling Price
						    And Discount Percentage = (Discount/Marked price) x 100
					    */
						markedprice = Double.parseDouble(ws.getString(33));
						salePrice   = Double.parseDouble(ws.getString(16));
						dis         = markedprice -  salePrice;
						per         = (dis/markedprice) * 100;  					
						
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
				         System.out.println("TEST vo.getStrStoreId()"+vo.getStrStoreId());
						if(vo.getStrHospitalCode().equals("10811") && !vo.getStrStoreId().equals("10201249") )	
						{
							sb.append("<tr>");
							sb.append("<td colspan='4' align='left'><u><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Terms & Conditions</font></td>");
							sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>FOR I.G.I.M.S CENTRAL PHARMACY</font></td>");					
							sb.append("</tr>");	
						}
						else if (vo.getStrStoreId().equals("10201249") )
						{							
							sb.append("<tr>");
							sb.append("<td colspan='4' align='left'><u><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Terms & Conditions</font></td>");
							sb.append("<td colspan='5' align='right' style='font-family:Verdana, Arial, Helvetica, sans-serif; font-size:small;'><strong>FOR RIO MAIN STORE</strong></td>");
							sb.append("</tr>");
						}		
						else
						{							
							sb.append("<tr>");
							sb.append("<td colspan='4' align='left'><u><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Terms & Conditions</font></td>");
							sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'></font></td>");					
							sb.append("</tr>");
						}					
						
						sb.append("<tr>");
						sb.append("<td colspan='5' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Un-used Medicine must be returned before discharge</b></font></td>");
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
	         sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
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
	
	
	 public static String getIssuePopUp(String strHospCode,String strStoreId,String strIssueNo)throws IOException 
	 {
		 /* Creating VO & BO Object Here */
		 IssueTransOVO vo = new IssueTransOVO();
		 IssueTransOBO bo = new IssueTransOBO();
		 
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
											
						String strDeptName = ws.getString(1);
						String strUnitName = ws.getString(2);
						String strPrescribedBy = ws.getString(3);
						String strPrescriptionFor =    ws.getString(4);
						String strPrescriptionDate = ws.getString(5);
						String strPrescriptionFrom = ws.getString(9);
						
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
		
	//		IssueTransOBO bo = null;
			IssueTransOVO vo = null;
	//		HisUtil hisutil = null;
		
	//		String strUnitValues = "";
			int i = 0;
		
			try {
		//		hisutil = new HisUtil("mms", "IssueTransHLP");
		//		bo = new IssueTransOBO();
				vo = new IssueTransOVO();
					
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
	 
	 public static String getBilledItemDtls(IssueTransOVO vo)throws SQLException 
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
	 
	 public static String getIssueDetailsBS(WebRowSet ws,IssueTransOVO vo)
				throws SQLException {
					StringBuffer sb = new StringBuffer();
				
					int i = 0,j=1;
					
				
					try {
						
						if(ws != null && ws.size() > 0)
						{ 
							sb.append("<div class='row'>");
							
							sb.append("<div class='col-sm-1'><i class='fas fa-angle-double-left' onclick='nxtChunk(\"prev\")'></i></div>");
							sb.append("<div class='col-sm-10' id='chunks'>");
							
							while (ws.next()) 
							{
									
								
								if(i==0) {
									sb.append("<div class='row'  id='0-chunk' >");
								}
								if(i==(3*j)) {
									sb.append("<div class='row'  id='"+j+"-chunk' style='display:none;'>");
									j++;
								}
								
															
							
								sb.append("<div class='col-sm-4'>");
								String strIssueNo = ws.getString(1);
								String strIssueDate = ws.getString(2);
								String strIssueSoreID = ws.getString(3);
								if (strIssueNo == null)
									strIssueNo = "----";
								if (strIssueDate == null)
									strIssueDate = "----";
								
								sb.append("<input type='hidden' name='strCrNo'        id='strCrNo"+i+"'        value="+vo.getStrCrNum()+" >");								
								sb.append("<input type='hidden' name='strIssueNo'     id='strIssueNo"+i+"'     value="+strIssueNo+" >");
								sb.append("<input type='hidden' name='strIssueSoreID' id='strIssueSoreID"+i+"' value="+strIssueSoreID+" >");
								
								sb.append("<p align='center'><i class='fa fa-folder fa-2x' style='color:blue' onclick='callIssuePop(this)'></i></p>");
								sb.append("<a name='strIssueDtl' id='strIssueDtl' STYLE='CURSOR:POINTER;color:rgba(75,75,75, 0.7)' onClick='getIssuePopUp(this, \""+i+"\" );'><p align='center'>");
								sb.append(strIssueNo +"</p><p align='center'>"+ strIssueDate);
								sb.append("</p></a>");
								sb.append("</div>");
						
					
								//if(ws.size()>=((3*j)-1))
								if(i==((3*j)-1)) {
									 sb.append("</div>");
									
								}else {
									if(i==(ws.size()-1))
										 sb.append("</div>");
								}
								i++;
							}
							sb.append("</div><div class='col-sm-1'><i class='fas fa-angle-double-right' onclick='nxtChunk(\"nxt\")'></i></div>");	


							sb.append("</div>");
						}
						else {
							sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
							sb.append("<TR>");
							sb.append("<TD WIDTH='25%' align='center' colspan='4'><font color = 'red'>"
									+ "No Record Found" + "</font></TD>");
							sb.append("</TR>");
							sb.append("</table>");
							   				    
								
						   } 
					} catch (Exception e) {
						 e.printStackTrace();;
						throw new HisException("Issue Transaction","IssueTransHLP .getIssueDetails() -->",e.getMessage());
				
					}
				
					return sb.toString();
				}
	 public static String getIssuePopUpBS(String strHospCode,String strStoreId,String strIssueNo,String strCrNo)throws IOException 
	 {
		 /* Creating VO & BO Object Here */
		 IssueTransOVO vo = new IssueTransOVO();
		 IssueTransOBO bo = new IssueTransOBO();
		 
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
		 vo.setStrCrNo(strCrNo);
				
		 /* Calling BO Method  */
		  bo.getIssueDtlPopUp(vo);
		
		
		  ws = vo.getStrIssueDtlPopUpWs();
		  
		
		
		   
		   sb.append("<div>Issue Item Details</div>");
		   sb.append("<table width='100%' class='table' border='1px'>");
		   sb.append("<thead>");
		   sb.append("<tr>");
		   sb.append("<th scope='col'>Drug Name</th>");
		   sb.append("<th scope='col'>Issue/Return Qty</th>");
		   sb.append("<th scope='col' >Rate/Unit</th>");
		   sb.append("<th scope='col' >Cost</th>");
		   sb.append("</tr></thead>");
		   sb.append("<tbody>");
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
								    sb.append("<td  width='45%'>");
								    sb.append(strItemName);
								    sb.append("</td>");
								    sb.append("<td width='15%'>");
								    sb.append(strIssueQtyUnit);
								    sb.append("</td>");
								    sb.append("<td width='25%' >");
								    sb.append(strRateUnit);
								    sb.append("</td>");
								    sb.append("<td width='15%' >");
								    sb.append(strCost);
								    sb.append("</td>");
								    sb.append("</tr>");
		  	                      
		  				        }
					  sb.append("</tbody>");
						  }	
				
				      else
				      {
				    	  sb.append("<tr><td><font color='red'>No Matching Record Found</font></td></tr>");
		 			     
				      } 	 
			    
			 }
			 catch (SQLException e) 
	         {
				 
				throw	new HisException("Issue Transaction","IssueTransHLP .getIssuePopUp() -->",e.getMessage());
			 }
			
	         
		    sb.append("</table>");
		  
			return sb.toString();
		}
	 

	 public static String getOnlineTreatmentDtls(WebRowSet ws , IssueTransOFB formBean) throws Exception
		{ 
		 StringBuffer str = new StringBuffer("");
		 int i=1;
		 int count = 0;
		 int counts = 1;
		 String brandId="";
		 GlobalVO voObj = new GlobalVO();
		 WebRowSet ws1 =null;
		 HashMap<String, Integer> map=new HashMap<String, Integer>() ;
		 
		 	voObj.setStrValue1(formBean.getStrCrNo());
			voObj.setStrValue2(formBean.getStrHospitalCode());
			
			voObj.setStrValue3(formBean.getStrStoreId().split("\\^")[0]);
		 try{	
			 
				/*
				if (voObj.getStrMsgType().equals("1"))
				{
					throw new Exception(voObj.getStrMsgString());
				}*/
			 //PatientDtlBO boObj = new PatientDtlBO();
			// boObj.getPatientTreatmentDetails1(voObj);
			 	//ws1 = voObj.getGblWs2();
				
				//ws1 = voObj.getGblWs3();
				
				if (ws != null && ws.size() > 0)
				{			
					str.append("<table class='table'>");
					str.append("<thead><th style='text-align:left; width:32%;'>Item Name</th>");
					str.append("<th style='text-align:left; width:15%;'>Batch No</th>");
					str.append("<th style='text-align:center;width:10%;'>Available Qty</th>");
					str.append("<th style='text-align:center;width:15%;'>Req Qty</th>");
					str.append("<th  style=\"width:10%\"><font color=\"red\">*</font>Quantity</th>");
					str.append("<th  style=\"width:8%\"><font color=\"red\">*</font>Cost</th>");
					str.append("<th  style=\"width:10%\">-</th>");
					str.append("</thead>");
					str.append("<tbody>");
				    while (ws.next()) 
				    {  
				    	str.append("<tr>");
				    	String	itemParamValue=ws.getString(1);
						String strdrugName = ws.getString(2);
						String strRate=(itemParamValue.split("#")[1]).split("\\^")[1]; 
						String strDoseName = "";
						String strFrequency = "";
						String strStartDate = "";
						String strEndDate = "";
						String strAvalqty = ws.getString(1).split("\\^")[3];
						String strReqqty = ws.getString(3);
						String strBatchNo = ws.getString(1).split("\\^")[10];
					
						if (strdrugName == null)
							strdrugName = "----";
						if (strDoseName == null)
							strDoseName = "----";
						if (strFrequency == null)
							strFrequency = "----";
						if (strStartDate == null)
							strStartDate = "----";
						if (strEndDate == null)
							strEndDate = "----";
						
						brandId=ws.getString(4);
						
						if(map.containsKey(brandId)) 
						{
							if(map.get(brandId) >=0)
							{
								int a=	map.get(brandId)-Integer.parseInt(strAvalqty);
								if(a >=0 )
									map.put(brandId, -1) ;
								else
									map.put(brandId, a) ;
							}
						}
						else 
						{
							if(Integer.parseInt(strReqqty)- Integer.parseInt(strAvalqty) <= 0 )
								map.put(brandId, 0) ;
							else
								map.put(brandId, Integer.parseInt(strReqqty)- Integer.parseInt(strAvalqty)) ;
							
						}
						//str.append("<table class='table'>");
						
						//System.out.println(map);
						if(map.containsKey(brandId)) 
						{
							if(map.get(brandId) <=0 )
							{
								str.append("<td style='text-align:left; '>  ");
								str.append("<input type='hidden' name='itemParamValue' id='itemParamValue1-"
									+ i + "' value='" + itemParamValue + "'>");
								str.append("<input type='hidden' name='itemUserValue' id='itemUserValue1-"
									+ i + "' value='" + itemParamValue.split("#")[2] + "'>");
						    
								str.append("<input type='hidden' name='itemCalcValue' id='itemCalcValue1-"
									+ i + "' value='" + itemParamValue.split("#")[1] + "'>");
						   
								str.append(strdrugName);
								
								str.append("</td><td style='text-align:left;  '>");
								str.append(strBatchNo);
								
								str.append("</td><td style='text-align:center; '>");
								str.append(strAvalqty.replace("&", "<br>"));
								
								
								str.append("</td><td style='text-align:center; '>");
								str.append(strReqqty);
								//str.append("<td WIDTH='10%' CLASS='multiControl' ><input type='text' autocomplete='off' maxlength='15' onkeypress='return validateData(event,5);'  id='strQtyText1-"+ i + "' onblur='return QtyValidation('1-"+i+"');' name='strQtyText' class='txtFldMin' value='' > </td>");
								if(Float.parseFloat(strAvalqty.replace("&", "<br>")) > Float.parseFloat(strReqqty))
								str.append("<td style=''><div style='display: block;'><input type='number' autocomplete='off' min='1'  onkeypress='return validateData(event,5);' id='strQtyTreatText1-"+i+"' onblur='QtyTreatValidation(\"1-" + i + "\");'  name='strQtyText' class='form-control' value="+strReqqty+" ></div></td>");
								else
								str.append("<td style=''><div style='display: block;'><input type='number' autocomplete='off' min='1'  onkeypress='return validateData(event,5);' id='strQtyTreatText1-"+i+"' onblur='QtyTreatValidation(\"1-" + i + "\");'  name='strQtyText' class='form-control' value='' ></div></td>");
									
								//str.append("</td width='10%' class='multiControl'>");
								
								str.append("<td style=''>");
							    DecimalFormat df = new DecimalFormat("0.00");
							    Double totalCost=Double.parseDouble(strReqqty) * Double.parseDouble(strRate) ;
								str.append("<input name='strTotalCost' id='strTotalCost1-"+i+"'  class='form-control' type='hidden'>");
								str.append("<div id='strQuantityTreatText1-"+i+"'  style='display: block;'>");
								str.append("<input name='strTotalTreatCostText' id='strTotalTreatCostText1-"+i+"' class='form-control' value="+df.format(totalCost)+" maxlength='5'  readonly='' type='text'>");
								str.append("</div></td>");
							
								str.append("<td>");
								//str.append("<div id='strQuantityText1-"+i+"' align='center' style='display: block;'>");
								//str.append("<img style='cursor: pointer;height: 20px' id='strDeleteButtonDivId' tabindex='1' src='../../hisglobal/images/Minus.png' onclick='deleteRow('1-"+i+"','1','0');' title='Click here to Delete Item' onkeypress='onPressingEnter(this,event)'>");
								//str.append("</div></td>");
								str.append("</td></tr>");
								i++;
								count ++;
								counts++;
								brandId=ws.getString(4);
								
								Integer	strReqqty1= Integer.parseInt(strReqqty)- Integer.parseInt(strAvalqty) ;
								if(strReqqty1 <= 0 )
								map.put(brandId, 0) ;
							
						}
					}
			
					}				   
				    str.append("</tbody>");
					str.append("</table>");
					str.append("</div>");					
				} 
				else 
				{
					str.append("<table class='table'>");
					str.append("<thead><th style='text-align:left; width:32%;'>Item Name</th>");
					str.append("<th style='text-align:left; width:15%;'>Batch No</th>");
					str.append("<th style='text-align:center;width:10%;'>Available Qty</th>");
					str.append("<th style='text-align:center;width:15%;'>Req Qty</th>");
					str.append("<th  style=\"width:10%\"><font color=\"red\">*</font>Quantity</th>");
					str.append("<th  style=\"width:8%\"><font color=\"red\">*</font>Cost</th>");
					str.append("<th  style=\"width:10%\">-</th>");
					str.append("</thead>");
					str.append("<tr><td colspan='8'><font color='red'><b>No Prescribed Data Found/Items Already Issued</b></font></td></tr></table>");
				} 
			}
			catch (Exception e) 
			{  
				e.printStackTrace();
				throw new Exception("PatientDtlHLP-->patientTreatmentDtl-->"+ e.getMessage());
			} 
			finally
			{
				if (ws != null) 
				{
					ws.close();
					ws = null;
			  	}
			}
			return str.toString();
		}
	 
	 
	 public static String getIssuedDetailNEW(WebRowSet wb)throws SQLException 
	 {
			StringBuffer br = new StringBuffer();

		    String strPatName = "";
			String strCrNo = "";
			String strReturnStore = "";
			String strReturnNo = "";
			String strReturnDate = "";
			String strStoreId = "";
			

			int i = 0;

			try 
			{
				/*br.append("<div class='row'>");
				br.append("<table class='table'>"); 
				br.append("<tr>");
				br.append("<td colspan='2'>");
				br.append("<div id='' style='font-weight:350 !important ;font-size: 16px !important;'>&nbsp;Issue Details </div>");
				br.append("</td></tr></table>");
				br.append("</div>");*/
				
				br.append("<div><hr><p class='subHeaders mb-0 text-left'><i class='fas fa-th-list iround' style='font-size: 16px; color: #28a745' title=''></i>&nbsp;Issue Details</p></div>");

				br.append("<div class='row'>");
				br.append("<div class='col-md-12'>");
				br.append("<table class='table text-uppercase' align='center'>");
				br.append("<tr>");
				br.append("<thead class='thead-dark'>");
				br.append("<td  WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Patient Name</td>");
				br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>CR No</td>");
				br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Store</td>");
				br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Issue No</td>");
				br.append("<td  WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Issue Date</td>");
				br.append("<td  WIDTH='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>#</td>");
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
						strStoreId        = wb.getString(9);
						
						br.append("<input type='hidden' name='strHlpCrNo'        id='strHlpCrNo" +i+ "'     value=" + strCrNo + " />");
						br.append("<input type='hidden' name='strHlpReturnNo'    id='strHlpReturnNo" +i+ "' value=" + strReturnNo + " />");
						br.append("<input type='hidden' name='strHlpStoreId'     id='strHlpStoreId" +i+ "'  value=" + strStoreId + " />");
						
						br.append("<tr>");	
						br.append("<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"  + strPatName + "</td>");
						br.append("<td WIDTH='20%' align='center'>");
						br.append("<input type='hidden' name='flag' id='flag" +i+ "' value=" + "0" + " />");
						br.append("<div class='popup' id='IssueItempopup' style='display: none'></div>");
						br.append("<a align='center' style='cursor:pointer;color:blue;font-weight:350 !important ;font-size:16px;' title='Issue No Item Details' onClick='showPopUp(this,\""+ i + "\");'>" + strCrNo + "</a></td>");
						br.append("</td>");
						br.append("<td WIDTH='20%' align='left'   style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strReturnStore + "</td>");
						br.append("<td WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strReturnNo + "</td>");
						br.append("<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strReturnDate + "</td>");
						br.append("<td WIDTH='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' ><img src='../../hisglobal/images/search_icon1.gif' onclick='getIssuePopUpFromHLP(this,\""+ i + "\");' style='cursor: pointer;' title='Print Issue Item Details'></td>");
						br.append("</tr>");
						i++;
					}

					br.append("</table> ");
					br.append("</div>");
					br.append("</div>");
				} else {
					br.append("<div class='row'>");
					br.append("<div class='col-md-12'>");
					br.append("<table class='table' style='font-weight:350 !important ;font-size: 16px !important;'>");
					br.append("<tr>");
					br.append("<td colspan='5' align='center' style='font-weight:350 !important ;font-size: 16px !important;color:red;'>"
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
	 
	 public static String getItem_ALL_LIST(String strItemCategoryNo,
				String strHospitalCode, WebRowSet wb, String strStoreId)
			{
			StringBuffer sBuffer = new StringBuffer("");
			

			ReturnFromTransVO vo=null;
			ReturnFromTransBO bo= null;
			String strReturnUnitCombo = "";
			HisUtil hisutil = null;
			
			String strHiddenId = "";//total cost^unit id
			String unitId = "";
			String strBrdName = "";
			String strBtchSlNo = "";
			String strExpiryDt = "";
			String strBalQty = "",strRepeatQty="0";
//			String totalCost = "";
			String rateUnit = "";
			String rate = "";
			String rateUnitId ="";
			String manufDate = "";
			String consumable = "";
			String issueUnit = "";
			String returnUnit = "";
			String baseValue = "";
			String issueNo = "";
			String strOrgIssueStore="";
			
			int i = 0,j=1,totalQty=0;
			
			
			 try {
				 
				 bo = new ReturnFromTransBO();
				 vo = new ReturnFromTransVO();
				
				
				 hisutil = new HisUtil("MMS","ReturnFromTransHLP");
				 
				 if(wb.size() != 0){
				 
						sBuffer.append("<table class='table'><tr><thead class='thead-dark'>");
						sBuffer.append("<th width= '5%'>S No.");
						sBuffer.append("</th>");
						sBuffer.append("<th width= '50%'>Drug Name");
						sBuffer.append("</th>");						
						sBuffer.append("<th width= '15%'>Org Issue Qty");
						sBuffer.append("</th>");
						sBuffer.append("<th width= '15%' ><font color='red'>*</font>Repeat Qty");
						sBuffer.append("</th>");
						sBuffer.append("<th width= '15%'><font color='red'>*</font>Repeat Qty Unit");
						sBuffer.append("</th>");						
						sBuffer.append("</thead></tr>");
						sBuffer.append("<tbody>");
					 
					while(wb.next())
					{		     	
						 /*
		                    1.Hidden
		                    2.Drug Name
		                    3.Issue Qty 		                   
		                 */
						
						    strHiddenId   = wb.getString(1);
						     /*
						      HSTNUM_ITEM_ID ||'^'|| HSTNUM_ITEMBRAND_ID||'^'||HSTNUM_GROUP_ID||'^'||HSTNUM_SUBGROUP_ID||'^'||sstnum_item_cat_no
					         */
							strBrdName       = wb.getString(2);							
							strRepeatQty     = wb.getString(3);
							
							if(i==0)
							{
								totalQty =  Integer.parseInt(strRepeatQty);
							}
							else
							{
								totalQty =  totalQty+Integer.parseInt(strRepeatQty);
							}
							
							
							vo.setStrIssueQtyUnitId("6301");
							vo.setStrHospitalCode(strHospitalCode);
		  					
							vo.setStrIssueQtyUnitId(unitId);
							vo.setStrHospitalCode(strHospitalCode);
							
											  					
		  					if (vo.getStrMsgType().equals("1")) {
								throw new Exception(vo.getStrMsgString());
							}
		  							  					
		  					strReturnUnitCombo = "<option title='No.' selected='' value='6301^1^0'>No.</option>";  	
		  							  				
		  					if(strBrdName == null || strBrdName.equals("null") || strBrdName.equals("") )strBrdName = "---";
		  					if(strBtchSlNo == null || strBtchSlNo.equals("null") || strBtchSlNo.equals(""))strBtchSlNo = "---";
		  					if(strBalQty == null || strBalQty.equals("null") || strBalQty.equals(""))strBalQty = "---";
		  					
		  					sBuffer.append("<tr>");
		  					
		  					sBuffer.append("<td width= '5%'  align='left'>"+j+"</td>");	
		  					
		  					sBuffer.append("<td width= '50%' align='left'>"+strBrdName+"</td>");
		  						  					
		  					sBuffer.append("<input type='hidden' name='strHiddenId'    id='strHiddenId" + i +"'    value='"+ strHiddenId +"'/>");		
		  					sBuffer.append("<input type='hidden' name='itemParamValue' id='itemParamValue" + i +"' value='"+ strHiddenId +"'/>");	
		  					
		  					
		  					sBuffer.append("<td width= '15%' align='left'>"+strRepeatQty+"</td>");
		  					
		  					 sBuffer.append("<td width= '15%' align='center'>");
		  					 	sBuffer.append(
		  							"<input type='text' maxlength='8' autocomplete='off' onkeypress='return validateData(event,7);' onkeyup='quantityValidation("+i+");'  name='strReqQty'  id='strReqQty"
									+ i
									+ "' class='form-control' value='"+strRepeatQty+"'>");
		  					 sBuffer.append("</td>");
		  					 
		  					 sBuffer.append("<td width= '15%'>");
		  					 		sBuffer.append(
		  							"<Select name='strUnitName' disabled='disabled' class='browser-default custom-select' id='strUnitName"   
									+ i 
									+ "' onchange='quantityUnitValue("+i+");'>"
									+ strReturnUnitCombo + "</select>");
		  					
		  					 sBuffer.append("</td>");
		 					 sBuffer.append("</tr>");

										
		  					i++;  		
		  					j++;
		  				}
					    sBuffer.append("<tr>");  					
  					    sBuffer.append("<td colspan='3' align='right'>Total ::</td>");
  					    sBuffer.append("<td colspan='1' align='center'>");
  					    sBuffer.append("<div class='col-md-2' style='color: red; font-weight: bold'><div id='strNetCostDivId' align='center'>"+totalQty+"</div><input type='hidden' name='strNetCost' id='strNetCost' value='0'/></div>");
  					    sBuffer.append("</td>");
  					    sBuffer.append("<td colspan='1' align='right'></td>");
  					    sBuffer.append("</tr>");  
					
						sBuffer.append("</tbody></table>");

										
					sBuffer.append("<input type='hidden' name='strNetCost' id='strNetCost' value='0'/>");
						
				 }else
				 {
					 sBuffer.append("<div class='row rowFlex reFlex'>");
					 sBuffer.append("<div class='col-md-5' style='text-align: center;color: red;'>No Record Available");
					 sBuffer.append("</div>");
					 sBuffer.append("</div>");
					
				 }
		   
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
					return "ERROR";

		     }
		    return sBuffer.toString();
		 	}
	 
	        public static String patientRepeatTreatmentDtlfrmIPD(WebRowSet ws,IssueTransOVO vo)	throws Exception 
			{					
					StringBuffer str = new StringBuffer("");	
					str.append("");		
					String prevDrugName="";
					try 
					{									
											
						//System.out.println("ws:: HLp---"+ws.size());
						if (ws != null && ws.size() > 0)
						{						
							
							str.append("<table class='table'>");
							str.append("<thead>");
							str.append("<tr>");											
							str.append("<th style='text-align:center;' style='width:35%;text-align: center !important;'><b>Item Name</b></th>");
							str.append("<th style='text-align:center;' style='width:15%;text-align: center !important;'><b>Batch</b></th>");
							str.append("<th style='text-align:center;' style='width:10%;text-align: center !important;'><b>Exp Date</b></th>");
							str.append("<th style='text-align:center;' style='width:10%'><b>Avl Qty</b></th>");
							str.append("<th style='text-align:center;' style='width:10%'><b>Rate/Unit</b></th>");
							str.append("<th style='text-align:center;' style='width:10%'><b>Req Qty</b></th>");						
							str.append("<th style='text-align:center;' style='width:10%'><b>Cost</b></th>");						
							str.append("</tr>");
							str.append("</thead>");
							
							Integer i = 0,k=0,totalQty=0;
						    while (ws.next()) 
						    {
						    	/*
								  1. P_Key
								  2. Generic name
								  3. Brand Name
								  4. Avl Qty ^ Avl Qty @ Unit ^ Avl Qty
								  5. Issue Qty
								  6. Re-Order Flag
								  7. Unit Id 6301^1^0
								  8. Batch No
								  9. Avl Batch Count
								 10. Item Type
								 11. EDL Catg
								 12. DRUG COMBO
								 13. Sales Price [ In Case of Single Batch] 
								 14. Exp_Date  [ In Case of Single Batch]
								*/
						    	String p_key 			    = ws.getString(1);
								String strdrugName 			= ws.getString(3);								
								String strAvlQty    		= (ws.getString(4).split("\\@")[0]).split("\\^")[0];
								String strRepeatQty 		= ws.getString(5);	
								String strBatch     		= ws.getString(8);
								String strBatchCount  		= ws.getString(9);
								String strItemType  		= ws.getString(10);
								String strBatchCombo 	    = ws.getString(12);
								String strSalePrice 		= ws.getString(13);
								String strExpDate   		= ws.getString(14);
								
								
							
								if (strdrugName == null)
									strdrugName = "----";
								
								
															
								
								
								i++;
								
								/*
								       HSTNUM_ITEM_ID 
								     ^ HSTNUM_ITEMBRAND_ID
								     ^0
								     ^0
								     ^0
								     ^0'
								 * */
								
								if(!strdrugName.equals(prevDrugName))
								{
																			
									    str.append("<tbody>");	  
										if(Integer.parseInt(strBatchCount)== 1)
										{
											DecimalFormat df = new DecimalFormat("0.00");
											Double totalCost=Double.parseDouble("0") * Double.parseDouble(strSalePrice);	
											
											str.append("<input type='hidden' name='itemParamValue' id='itemParamValue"+ i + "' value='" + p_key + "'>");
											str.append("<input type='hidden' name='strAvlQty'      id='strAvlQty"+ i + "'      value='" + strAvlQty + "'>");
											str.append("<input type='hidden' name='strBatch'       id='strBatch"+ i + "'       value='" + strBatch + "'>");
											str.append("<input type='hidden' name='strSalePrice'   id='strSalePrice"+ i + "'   value='" + strSalePrice + "'>");
											str.append("<input type='hidden' name='strExpDate'     id='strExpDate"+ i + "'     value='" + strExpDate + "'>");
											
											str.append("<tr>");		
											str.append("<td   style='width:35%;font-weight: 400; font-size: 0.9rem; color: black;text-align:left;'>");
											str.append(strdrugName);
											str.append("</td>");	
											str.append("<td   style='width:15%;font-weight: 400; font-size: 0.9rem; color: black;text-align:center;'>");
											str.append(strBatch);																			
											str.append("</td>");
											str.append("<td   style='width:10%;font-weight: 400; font-size: 0.9rem; color: black;text-align:center;'>");
											str.append(strExpDate);																			
											str.append("</td>");
											str.append("<td  style='width:10%;font-weight: 400; font-size: 0.9rem; color: black;text-align:center;'>");
											str.append(strAvlQty);
											str.append("</td>");
											str.append("<td style='width:10%;font-weight: 400; font-size: 0.9rem; color: black;text-align:center;'>");
											str.append(strSalePrice);
											str.append("</td>");									
											str.append("<input type = 'hidden' name='strRequredQty' id='strRequredQty"+i+"' value='"+strRepeatQty+"'></td>");									
											str.append("<td style='width:10%;font-weight: 400; font-size: 0.9rem; color: black;text-align:center;'>");
											str.append("<input type='text' maxlength='8' autocomplete='off' onkeypress='return validateData(event,7);' onkeyup='repeatQtyValidation("+i+");'  name='strReqQty'  id='strReqQty"
													+ i
													+ "' class='form-control' value='0'>");
											str.append("</td>");								
											str.append("<td style='width:10%;font-weight: 400; font-size: 0.9rem; color: black;text-align:center;'>");
											//str.append(df.format(totalCost));
											str.append("<div id='costId"+i+"' style='display:block;'>"+df.format(totalCost)+"</div>");
											str.append("<input type = 'hidden' name='strCost' id='strCost"+i+"' value='"+df.format(totalCost)+"'></td>");									
											str.append("</td>");
											str.append("</tr>");			
										}
										if(Integer.parseInt(strBatchCount)> 1)
										{
											str.append("<input type='hidden' name='itemParamValue' id='itemParamValue"+ i + "' value='" + p_key + "'>");
											str.append("<input type='hidden' name='strAvlQty'      id='strAvlQty"+ i + "'      value='0'>");
											str.append("<input type='hidden' name='strBatch'       id='strBatch"+ i + "'       value='0'>");
											str.append("<input type='hidden' name='strSalePrice'   id='strSalePrice"+ i + "'   value='0'>");
											str.append("<input type='hidden' name='strExpDate'     id='strExpDate"+ i + "'     value='-'>");
											
											str.append("<tr>");		
											str.append("<td   style='width:35%;font-weight: 400; font-size: 0.9rem; color: black;text-align:left;'>");
											str.append(strdrugName);
											str.append("</td>");	
											str.append("<td   style='width:15%;font-weight: 400; font-size: 0.9rem; color: black;text-align:left;'>");
											str.append("<select name='strMultiRowBatch' id='strMultiRowBatch"+i+"' class='form-control form-control-sm' onchange='getBrandDtls(this,\""+i+"\");'>");
											str.append(strBatchCombo);	
											str.append("</select>");													
											str.append("</td>");
											str.append("<td   style='width:10%;font-weight: 400; font-size: 0.9rem; color: black;text-align:center;'>");
											//str.append(strExpDate);				
											str.append("<div id='expId"+i+"'>-</div>");
											str.append("</td>");
											str.append("<td  style='width:10%;font-weight: 400; font-size: 0.9rem; color: black;text-align:center;'>");
											//str.append(strAvlQty);
											str.append("<div id='avlQtyId"+i+"'>-</div>");
											str.append("</td>");
											str.append("<td style='width:10%;font-weight: 400; font-size: 0.9rem; color: black;text-align:center;'>");
											//str.append(strSalePrice);
											str.append("<div id='salePriceId"+i+"'>-</div>");
											str.append("</td>");									
											str.append("<input type = 'hidden' name='strRequredQty' id='strRequredQty"+i+"' value='"+strRepeatQty+"'></td>");									
											str.append("<td style='width:10%;font-weight: 400; font-size: 0.9rem; color: black;text-align:center;'>");
											str.append("<input type='text' maxlength='8' autocomplete='off'  onkeypress='return validateData(event,7);' onkeyup='repeatQtyValidation("+i+");'  name='strReqQty'  id='strReqQty"
													+ i
													+ "' class='form-control' value='0'>");
											str.append("</td>");										
											str.append("<td style='width:10%;font-weight: 400; font-size: 0.9rem; color: black;text-align:center;'>");
											str.append("<div id='costId"+i+"'>0.00</div>");
											str.append("<input type = 'hidden' name='strCost' id='strCost"+i+"' value='0.00'></td>");
											str.append("</td>");
											str.append("</tr>");			
											
												
										}
										
												
										str.append("</tbody>");		
										
										
								}	
													
								prevDrugName=strdrugName; 
								totalQty=0;
							
					
							}
						    str.append("</br>");
						    
						    str.append("<tr>");  					
						    str.append("<td colspan='5' align='right'>Total ::</td>");
						    str.append("<td colspan='1' align='center'>");
						    str.append("<div  style='color: red;'><div id='strNetQtyDivId'  align='center'>0</div><input type='hidden' name='strNetQty' id='strNetQty' value='0'/></div>");
						    str.append("</td>");
						    str.append("<td colspan='1' align='left'>");
						    str.append("<div style='color: red;'><div id='strNetCostDivId' align='left'>0.00</div><input type='hidden' name='strNetCost' id='strNetCost' value='0'/></div>");
						    str.append("</td>");
						    str.append("</tr>");  
	  					    
							str.append("</table>");						
							
							// str.append("</br>");
						} 
						else 
						{
							str.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
							str.append("<tr><td align='center'  class='multiControl' ><font color='red'><b>No record Found In Treatment Details</b></font></td></tr></table>");
							str.append("<input type='hidden' name='strTreatmentDtlCount' id='strTreatmentDtlCountId' value='0'>");
							
						} 
					}
					catch (Exception e) 
					{
						throw new Exception("PatientDtlHLP-->patientTreatmentDtl-->"+ e.getMessage());
					} 
					finally
					{
						if (ws != null) 
						{
							ws.close();
							ws = null;
					  	}
					}
					return str.toString();
		}
	 
}
