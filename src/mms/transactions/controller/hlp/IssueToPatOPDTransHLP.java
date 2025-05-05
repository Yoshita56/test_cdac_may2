package mms.transactions.controller.hlp;

import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import billing.BillConfigUtil;
import billing.PrintBO;
import billing.PrintVO;
import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.GlobalVO;
import hisglobal.utility.HisPrinter;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.transactions.bo.IssueToPatOPDTransBO;
import mms.transactions.bo.OPDIssueToPatAutoTransBO;
import mms.transactions.controller.fb.IssueToPatOPDTransFB;
import mms.transactions.vo.IssueToPatOPDTransVO;
import mms.transactions.vo.OPDIssueToPatAutoTransVO;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class IssueToPatOPDTransHLP {
	
	public static int printLine = 0;
	public static final char FORMFEED = 12;
	public static int isServiceDiscountReq = 1;

	public static final char ESCAPECHAR = 27;
	public static final String BOLDON = ESCAPECHAR+""+'E';
	public static final String BOLDOFF = ESCAPECHAR+""+'F';
	
	public static String getPatientDtl(IssueToPatOPDTransFB formBean) throws Exception 
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
	
    public static String getIssueRptForDotMatrix(IssueToPatOPDTransFB formBean)throws SQLException, UnsupportedEncodingException
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
	public static String getIssueDtlsInitView(IssueToPatOPDTransFB formBean) throws Exception {

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
	
	
	 public static String getIssuePopUp(String strHospCode,String strStoreId,String strIssueNo)throws IOException 
	 {
		 /* Creating VO & BO Object Here */
		 IssueToPatOPDTransVO vo = new IssueToPatOPDTransVO();
		 IssueToPatOPDTransBO bo = new IssueToPatOPDTransBO();
		 
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
		
	//		IssueToPatOPDTransBO bo = null;
			IssueToPatOPDTransVO vo = null;
	//		HisUtil hisutil = null;
		
	//		String strUnitValues = "";
			int i = 0;
		
			try {
		//		hisutil = new HisUtil("mms", "IssueTransHLP");
		//		bo = new IssueToPatOPDTransBO();
				vo = new IssueToPatOPDTransVO();
					
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
	 
	 public static String getBilledItemDtls(IssueToPatOPDTransVO vo)throws SQLException 
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
	 
	/* replace with below HLP method  getIssueDetailsBS >> getPreviousIssueDetails==Issue no & date*/
	 public static String getIssueDetailsBS(WebRowSet ws)
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
								
								
					/*
					 * if(i>0) { if(3%(i)==0) { if(j>1)
					 * sb.append("<div class='row'  id='"+j+"-chunk' style='display:none;'>"); }
					 * }else sb.append("<div class='row'  id='1-chunk' >");
					 */
								
							
								sb.append("<div class='col-sm-4'>");
								String strIssueNo = ws.getString(1);
								String strIssueDate = ws.getString(2);
								String strIssueSoreID = ws.getString(3);
								if (strIssueNo == null)
									strIssueNo = "----";
								if (strIssueDate == null)
									strIssueDate = "----";
								
							
								sb.append("<input type='hidden' name='strIssueNo' id='strIssueNo"+i+"' value="+strIssueNo+" >");
								sb.append("<input type='hidden' name='strIssueSoreID' id='strIssueSoreID"+i+"' value="+strIssueSoreID+" >");
								sb.append("<p align='center'><i class='fa fa-folder fa-2x' style='color:blue' onclick='callIssuePop(this)'></i></p>");
								sb.append("<a name='strIssueDtl' id='strIssueDtl' STYLE='CURSOR:POINTER;color:rgba(75,75,75, 0.7)' onClick='getIssuePopUp(this, \""+i+"\" );'><p align='center'>");
								sb.append(strIssueNo +"</p><p align='center'>"+ strIssueDate);
								sb.append("</p></a>");
								sb.append("</div>");
						
					/*
					 * if(i>0) { if(3%(i)==0) { if(j>1) sb.append("</div>"); j++; }} else
					 * sb.append("</div>");
					 */
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
	 
	/* == new added for printing Issue no & date == */
	 public static String getPreviousIssueDetails(IssueToPatOPDTransVO vo ,WebRowSet ws) 
		{
			StringBuffer sb = new StringBuffer("");
			
			WebRowSet ws1 = vo.getStrIssueDetailWs(); 
			int i=1;
			
		    try
		    {
		   		sb.append("<div class='row'>"); 
				sb.append("<table class='table'>"); 
				sb.append("<tr>");
				sb.append("<td colspan='2'>");
				sb.append("<div id='' style='font-weight:350 !important ;font-size: 21px !important;'>&nbsp;Previous Issued Details </div>");
				sb.append("</td></tr></table>");
				sb.append("</div>");
				
				sb.append("<div class='row'>");
				sb.append("<div class='col-md-12'>");
				sb.append("<table class='table text-uppercase' align='center'>");
				sb.append("<thead class='thead-dark'>");
				sb.append("<tr>");
				sb.append("<th WIDTH='5%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>S.No</th>");
				sb.append("<th WIDTH='45%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Issue No / Issue Date</th>");
				sb.append("<th  WIDTH='45%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Patient Name [CR No]</th>");
				sb.append("<th  WIDTH='5%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>#</th>");
				sb.append("</tr>");
				sb.append("</thead>");
				
				
			/*
			 * String strIssueNo = ws1.getString(1); String strIssueDate = ws1.getString(2);
			 * String strIssueStoreID = ws1.getString(3);
			 * 
			 * if (strIssueNo == null) strIssueNo = "----"; if (strIssueDate == null)
			 * strIssueDate = "----";
			 * 
			 * 
			 */
				
					if(ws1.size() != 0)
					{
						while (ws1.next()) 
						{
						        /*
				                1.Issue No
				                2.Issue Date
				                3.Store Id
				                4.Pat Name
				                5.PUK_NO
				              */				
							
								sb.append("<input type='hidden' name='strIssueNo'     id='strIssueNo"+i+"'          value="+ws1.getString(1)+" >");
								sb.append("<input type='hidden' name='strIssueSoreID' id='strIssueSoreID"+i+"'      value="+ws1.getString(3)+" >");
								sb.append("<input type='hidden' name='strCrNo'        id='strCrNo"+i+"'             value="+ws1.getString(5)+" >");
													
								sb.append("<tr>");
								sb.append("<td  width='5%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");							
								sb.append(i);											//	S.No				
								sb.append("</td>");
								
								sb.append("<td  width='45%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");							
								sb.append(ws1.getString(1)+" / "+ws1.getString(2));		//	Issue No / Issue Date				
								sb.append("</td>");
								
								sb.append("<td  width='45%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");							
								sb.append(ws1.getString(4)+" ["+ws1.getString(5)+"]");	//	Patient Name [CR No]			
								sb.append("</td>");
								
								sb.append("<td width='5%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'><img src=\"../../hisglobal/images/search_icon1.gif\" onClick='getIssuePopUp(this, \""+i+"\" );' style=\"cursor: pointer;\" title=\"Print Previous Issue Details\"></td>");							
								
								sb.append("</tr>");
								i++;
						}
						
						sb.append("</table> ");
						sb.append("</div>");
						sb.append("</div>");
				} else {
				sb.append("<div class='row'>");
				sb.append("<div class='col-md-12'>");
				sb.append("<table class='table' style='font-weight:350 !important ;font-size: 16px !important;'>");
				sb.append("<tr>");
				sb.append("<td colspan='5' align='center' style='font-weight:350 !important ;font-size: 16px !important;color:red;'>"
						+ "No Record Found" + "</td>");
				sb.append("</tr>");
				sb.append("</table> ");
				sb.append("</div>");
				sb.append("</div>");
				sb.append("</div>");
			}
		 }
		 catch(Exception e)
		 {
			    e.printStackTrace();
			    new HisException("Local Purchase Report","BreakageItemDtlTransHLP.getBreakageDetails()-->",e.getMessage());
		  }
		     //System.out.println("sb"+sb);
		    return sb.toString();
		}
	 
	 public static String getIssuedDetailNEW(WebRowSet wb)throws SQLException 
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
				br.append("<div class='row'>");
				br.append("<table class='table'>"); 
				br.append("<tr>");
				br.append("<td colspan='2'>");
				br.append("<div id='' style='font-weight:350 !important ;font-size: 16px !important;'>&nbsp;Issue Details </div>");
				br.append("</td></tr></table>");
				br.append("</div>");
				
				br.append("<div class='row'>");
				br.append("<div class='col-md-12'>");
				br.append("<table class='table text-uppercase' align='center'>");
				br.append("<tr>");
				br.append("<thead class='thead-dark'>");
				br.append("<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Drug Name</td>");
				br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Issue/Return Qty</td>");
				br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Rate/Unit</td>");
				br.append("<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Cost</td>");
				br.append("</thead>");
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
						
						br.append("<tr>");	
						br.append("<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"  + strIssueDate + "</td>");
						br.append("<td WIDTH='20%' align='center'>");
						br.append("<input type='hidden' name='flag' id='flag" +i+ "' value=" + "0" + " />");
						br.append("<div class='popup' id='IssueItempopup' style='display: none'></div>");
						br.append("<a align='center' style='cursor:pointer;color:blue;font-weight:350 !important ;font-size:16px;' title='Issue No Item Details' onClick='showPopUp(this,\""+ i + "\");'>" + strIssueNo + "</a></td>");
						br.append("</td>");
						br.append("<td WIDTH='20%' align='left'   style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strIndentingStore + "</td>");
						br.append("<td WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strIndentNo + "</td>");
						br.append("<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"	+ strIndentDate + "</td>");
						br.append("<td WIDTH='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' ><img src='../../hisglobal/images/search_icon1.gif' onclick='generateIssueReportFunc(this,\""+ i + "\");' style='cursor: pointer;' title='Print Issue Item Details'></td>");
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

	 public static String getIssuePopUpBS(String strHospCode,String strStoreId,String strIssueNo,String strCrNo)throws IOException 
	 {
		 /* Creating VO & BO Object Here */
		 IssueToPatOPDTransVO vo = new IssueToPatOPDTransVO();
		 IssueToPatOPDTransBO bo = new IssueToPatOPDTransBO();
		 
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
		  
		   sb.append("<div>Issued Item Details</div>");
		   sb.append("<table width='100%' class='table' border='1px'>");
		   sb.append("<thead>");
		   sb.append("<tr>");
		   sb.append("<th scope='col' style='text-align:center' >Drug Name</th>");
		   sb.append("<th scope='col' style='text-align:center'>Issue/Return Qty</th>");
		   sb.append("<th scope='col' style='text-align:center'>Rate/Unit</th>");
		   sb.append("<th scope='col' style='text-align:center'>Cost</th>");
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
								    sb.append("<td  width='45%' style='text-align:left'>");
								    sb.append(strItemName);
								    sb.append("</td>");
								    sb.append("<td  width='15%' style='text-align:center'>");
								    sb.append(strIssueQtyUnit);
								    sb.append("</td>");
								    sb.append("<td width='25%' style='text-align:center'>");
								    sb.append(strRateUnit);
								    sb.append("</td>");
								    sb.append("<td width='15%' style='text-align:center'>");
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
	 
	 public static String getOnlineTreatmentDtls(WebRowSet ws , IssueToPatOPDTransFB formBean) throws Exception
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
	 
	/* ============= >> RJ47 */
	 
	 public static String getAfterSaveVoucher(IssueToPatOPDTransVO vo,String mode) throws Exception {
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
	    		  sb.append("<td colspan='1'><td colspan='1'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData_O();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='cancelToMainPage(1);' /></div></td>");
	    	  }
	    	  else
	    	  {
	    		  if(mode.equals("2"))
		    	  {
		    		  sb.append("<td colspan='1'><td colspan='1'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData_O();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='cancelToMainPage(2);' /></div></td>");
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
	        
	         sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
	         sb.append("<tr>");
	         sb.append("<td colspan='9' align='left'><hr size='1'></td>");	       
	         sb.append("</tr>");
	         sb.append("<tr bgcolor='#cdc9c9'> ");
	         sb.append("<td align='center' width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>SL</b></font> ");
	         sb.append("</td>");
	         sb.append("<td align='center' width='39%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>Product</b></font> ");
	         sb.append("</td>");
	         sb.append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>Batch No.</b></font> ");
	         sb.append("</td> ");
	         sb.append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>Expiry</b></font>");
	         sb.append("</td> ");	       
	         sb.append("<td align='right'  width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>Qty</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='right'  width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>MRP</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='right'  width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>Rate</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='right'  width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>DIS(%)</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='right'  width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>Cost</b></font>");
	         sb.append("</td> ");
	         sb.append("</tr> ");
	         sb.append("<tr>");
	         sb.append("<td colspan='9' align='left'><hr size='1'></td>");
	       
	         sb.append("</tr>");
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
						dis         = markedprice -  salePrice;
						per         = (dis/markedprice) * 100;  
						
						
						sb.append("<tr> ");
						sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
						sb.append(i+".");
						sb.append("</font></td> ");					
						sb.append("<td align='left' width='39%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(ws.getString(6));
						sb.append("</font></td> ");
						sb.append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(ws.getString(7));
						sb.append("</font></td> ");
						sb.append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
						sb.append(ws.getString(8));
						sb.append("</font></td> ");
						sb.append("<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
						sb.append(ws.getString(10));
						sb.append("</font></td> ");
						sb.append("<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
						sb.append(ws.getString(33));
						sb.append("</font></td> ");
						sb.append("<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
						sb.append(ws.getString(16));
						sb.append("</font></td> ");
						sb.append("<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
						sb.append(Math.round(per));
						sb.append("</font></td> ");
						sb.append("<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
						sb.append(ws.getString(29));
						sb.append("</font></td> ");  									
						sb.append("</tr> ");
						NetAmount=NetAmount+ Float.parseFloat(ws.getString(29));
						i++;
									
					}							
						
					 sb.append("<tr>");
			         sb.append("<td colspan='9' align='left'><hr size='1'></td>");			       
			         sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>GRAND TOTAL</b></font></td>");
						sb.append("<td colspan='1' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
						sb.append(Math.round(NetAmount));
						
						sb.append("</font></td>");
						sb.append("</tr>");
						
						 sb.append("<tr>");
				         sb.append("<td colspan='9' align='left'><hr size='1'></td>");			       
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
	 
	 public static boolean getIssuePopUpForDotMatrix_org(String strHospCode,String strStoreId,String strIssueNo,String strCrNo,HttpServletRequest request)throws Exception
	 {	
			/* Creating VO & BO Object Here */
			IssueToPatOPDTransVO vo = new IssueToPatOPDTransVO();
			IssueToPatOPDTransBO bo = new IssueToPatOPDTransBO();
			StringBuffer   contents = new StringBuffer("");
			HisUtil 		hisutil = new HisUtil("billing", "PrintHLP");
			boolean content = false;
		 try
		 {
			 
			/* Declaring Variable */		
			String rptContents     			= "";
			String strItemName     			= "";
			String strIssueQtyUnit 			= "";
			String strRateUnit 	  			= "";
			String strCost         			= "";				 
		    String strAgeAndSex 			= "";
			String strPatientName 			= "";
			String strFatherOrHusbandName 	= "";
			String strSpouseName 			= "";
			String strReligion 				= "";
			String strCategoryName 			= "";
			String strCategoryCode 			= "";					
			String strAddress 				= "";
			String strMlcNo 				= "";
			String strHiddenValue 			= ""; 
			String catGrp 					= "";
			String visitType 				= "";
			String episodeCode 				= "";			
			String strEmailId 				= "";
			String contactNo 				= "";
			
			String pat_net_amt     			= "";
			String unit_net_amt     		= "";
			String strUserName              = "";
			float NetAmount = 0.0F;
			
			
			
			/* Setting Value in vo Object */
			 vo.setStrStoreId(strStoreId);
			 vo.setStrHospitalCode(strHospCode);
			 vo.setStrIssueNo(strIssueNo);
			 vo.setStrCrNo(strCrNo); 		
		    /* Calling BO Method  */			   
			bo.getImgHeader(vo);
			bo.getDupDotMatrixVoucher(vo);  // pkg_mms_view.Proc_Emp_Issue_Detail    [ Mode - 3 ]
			                                // pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ]  
			
			WebRowSet ws = vo.getGblWs1();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					 strAgeAndSex 				= ws.getString(2);
					 strPatientName 			= ws.getString(3);
					 strFatherOrHusbandName 	= ws.getString(4);
					 strSpouseName 				= ws.getString(5);
					 strReligion 				= ws.getString(6);
					 strCategoryName 			= ws.getString(7);
					 strCategoryCode 			= ws.getString(8);					
					 strAddress 				= ws.getString(9);
					 strMlcNo 					= ws.getString(10);
					 strHiddenValue 			= ws.getString(11); 
					 catGrp 					= ws.getString(13);
					 visitType 					= ws.getString(15).split("\\^")[0];
					 episodeCode 				= ws.getString(15).split("\\^")[1];
					if (strHiddenValue == null)
						strHiddenValue = "----";
					String[] id 				= strHiddenValue.split("\\^");
					strEmailId 					= ws.getString(16);
					contactNo 				= "";
					contactNo =  id[13];

					if (strAgeAndSex == null)
						strAgeAndSex = "----";
					if (strPatientName == null)
						strPatientName = "----";
					if (strFatherOrHusbandName == null)
						strFatherOrHusbandName = "----";
					if (strSpouseName == null)
						strSpouseName = "----";
					if (strReligion == null)
						strReligion = "----";
					if (strCategoryName == null)
						strCategoryName = "----";
					if (strCategoryCode == null)
						strCategoryCode = "----";
					if (strAddress == null)
						strAddress = "----";					
					if (strMlcNo == null)
						strMlcNo = "-----";
					
				}
			}
			
		    if (vo.getStrMsgType().equals("1")) 
		    {
			   try 
			   {
				throw new Exception(vo.getStrMsgString());
					
			   } catch (Exception e) 
			   {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
		    }
					
			while(vo.getWsIssueDetails().next())
			{
				vo.setStrIssueDate(vo.getWsIssueDetails().getString(2));
				vo.setStrStoreName(vo.getWsIssueDetails().getString(4));				
				strUserName    = vo.getWsIssueDetails().getString(36);				
				unit_net_amt   = vo.getWsIssueDetails().getString(40);				
				NetAmount      = NetAmount+ Float.parseFloat(vo.getWsIssueDetails().getString(40));			
			}
			  vo.getWsIssueDetails().beforeFirst();
			
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
	           19. Issue Qty
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
	           40. ITEM_VALUE
	         */    
			contents.append(hisutil.appendSpace("[ DUPLICATE", 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n");
			printLine++;

			contents.append(hisutil.appendSpace(" CR No.", 10, 0)+ ": "+ hisutil.appendSpace(vo.getStrCrNo().toUpperCase(), 20, 0));//10+20=30+2
			contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(vo.getStrIssueDate(), 21, 0));//10+21=31+2						
			contents.append(hisutil.appendSpace("ISSUE No.", 10, 0)+ ": "+ hisutil.appendSpace(vo.getStrIssueNo(), 20, 0));//10+20=30+2
			contents.append("\n");
			printLine++;
			printLine++;
			
			contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strPatientName, 20, "~").get(0).toUpperCase(), 20, 0));
			contents.append(hisutil.appendSpace("Mobile No", 10, 0)+ ": "+ hisutil.appendSpace(contactNo, 21, 0));
			contents.append(hisutil.appendSpace(" ", 10, 0)+ " "+ hisutil.appendSpace(" ", 20, 0));
			
			contents.append("\n");
			printLine++;
			printLine++;
			
								
			contents.append(hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strCategoryName, 20, "~").get(0).toUpperCase(), 20, 0));
			contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(strAgeAndSex.toUpperCase(), 21, 0));
			contents.append(hisutil.appendSpace("ISSUE BY.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(vo.getStrStoreName(), 20, "~").get(0).toUpperCase(), 20, 0));
			//contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(serv_type, 19, "~").get(0).toUpperCase(), 20, 0));
			contents.append("\n");
			printLine++;
			printLine++;

			/*
			contents.append(hisutil.appendSpace(" SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type.toUpperCase(), 20, 0));
			contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(dept, 53, "~").get(0).toUpperCase(), 53, 0));
			contents.append("\n");
			printLine++;
			printLine++;		
			*/				
			
				
			contents.append("----------------------------------------------------------------------------------------------");
			contents.append("\n");
			printLine++;
			contents.append(hisutil.appendSpace("S.No.", 		5,	0));
			contents.append(hisutil.appendSpace("ITEM NAME", 	46,	0));
			contents.append(hisutil.appendSpace("BATCH", 		15,	0));
			contents.append(hisutil.appendSpace("RATE(Rs.)", 	10,	0));
			contents.append(hisutil.appendSpace("QTY.", 		8,	0));
			contents.append(hisutil.appendSpace("AMOUNT(Rs.)",  10,	0));
			contents.append("\n");
			printLine++;

			contents.append("----------------------------------------------------------------------------------------------");
			contents.append("\n");
			printLine++;
			
			int i =1;
			while(vo.getWsIssueDetails().next())
			{
				contents.append("\n");
				printLine++;
				contents.append(hisutil.appendSpace(String.valueOf(i),                   					5,	0));
				contents.append(hisutil.appendSpace(vo.getWsIssueDetails().getString(6).replaceAll("^\\s+", " "),					46,	0));
				contents.append(hisutil.appendSpace(vo.getWsIssueDetails().getString(7), 					15,	0));
				contents.append(hisutil.appendSpace(String.valueOf(vo.getWsIssueDetails().getString(16)), 	10,	0));
				contents.append(hisutil.appendSpace(vo.getWsIssueDetails().getString(19), 					8,	0));
				contents.append(hisutil.appendSpace(vo.getWsIssueDetails().getString(40), 					10,	0));
				contents.append("\n");
				printLine++;
				
				i++;
			}	
			contents.append("----------------------------------------------------------------------------------------------");
			contents.append("\n");
			printLine++;
			
			contents.append(hisutil.appendSpace("", 79,1)+hisutil.appendSpace("---------------",15,1));
			contents.append("\n");
			printLine++;
			contents.append(hisutil.appendSpace("TOTAL AMOUNT ",79, 1)+ hisutil.appendSpace(String.valueOf(NetAmount),5, 1));			
			contents.append("\n");
			printLine++;
			contents.append(hisutil.appendSpace("", 79,1)+hisutil.appendSpace("---------------",15,1));
			contents.append("\n");
			printLine++;
			
			
			contents.append(hisutil.appendSpace("BILLED AMT ",79, 1)+ hisutil.appendSpace(String.valueOf(NetAmount), 5, 1));			
			contents.append("\n");
			printLine++;
					
			contents.append(hisutil.appendSpace("COLLECTED AMT ",79, 1)+ hisutil.appendSpace(String.valueOf(NetAmount), 5, 1));
			contents.append("\n");
			printLine++;
			
			contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(String.valueOf(NetAmount)),94, 0));
			contents.append("\n");
			printLine++;
			printLine++;
			
			String contents3 = new String();
			
			contents3 = "\n \n "+ hisutil.appendSpace(strUserName + " (" + strUserName + ")", 79, 1);
			contents3 += "\n";
			printLine++;
			contents3 += hisutil.appendSpace("AUTHORISED SIGNATORY", 79, 1);
			contents3 += "\n";
			printLine++;			
			
			contents.append(contents3);
			
			
			content = PrintContents("1", "1", contents.toString(),request);
			System.out.println("Duplicate  Services------->\n" + contents.toString());
		 }
		 catch (Exception e)
		 {
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->"+ e.getMessage());
		 } 
		 finally
		 {
			vo = null;
			bo = null;
			hisutil = null;
		
		 }			
			
		  return content; 
			
			
			
	 }
	 
	 public static boolean getIssuePopUpForDotMatrix(String strHospCode,String strStoreId,String strIssueNo,String strCrNo,HttpServletRequest request)throws Exception
	 {	
			/* Creating VO & BO Object Here */
			OPDIssueToPatAutoTransVO vo = new OPDIssueToPatAutoTransVO();
			OPDIssueToPatAutoTransBO bo = new OPDIssueToPatAutoTransBO();
			StringBuffer       contents = new StringBuffer("");
			HisUtil 		    hisutil = new HisUtil("billing", "PrintHLP");
			boolean             content = false;
			int k = 0;
		 try
		 {
			 
			/* Declaring Variable */		
			String rptContents     			= "";
			String strItemName     			= "";
			String strIssueQtyUnit 			= "";
			String strRateUnit 	  			= "";
			String strCost         			= "";				 
		    String strAgeAndSex 			= "";
			String strPatientName 			= "";
			String strFatherOrHusbandName 	= "";
			String strSpouseName 			= "";
			String strReligion 				= "";
			String strCategoryName 			= "";
			String strCategoryCode 			= "";					
			String strAddress 				= "";
			String strMlcNo 				= "";
			String strHiddenValue 			= ""; 
			String catGrp 					= "";
			String visitType 				= "";
			String episodeCode 				= "";			
			String strEmailId 				= "";
			String contactNo 				= "";
			
			String pat_net_amt     			= "";
			String unit_net_amt     		= "";
			String strUserName              = "";
			float NetAmount = 0.0F;
			
			
			
			/* Setting Value in vo Object */
			 vo.setStrStoreId(strStoreId);
			 vo.setStrHospitalCode(strHospCode);
			 vo.setStrIssueNo(strIssueNo);
			 vo.setStrCrNo(strCrNo); 		
		    /* Calling BO Method  */			   
			bo.getImgHeader(vo);
			bo.getDupDotMatrixVoucher(vo);  // pkg_mms_view.Proc_Emp_Issue_Detail    [ Mode - 3 ]
			                                // pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ]  
			if (vo.getStrMsgType().equals("1")) 
		    {
			   try 
			   {
				throw new Exception(vo.getStrMsgString());
					
			   } catch (Exception e) 
			   {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
		    }
			
			WebRowSet ws = vo.getGblWs1();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					 strAgeAndSex 				= ws.getString(2);
					 strPatientName 			= ws.getString(3);
					 strFatherOrHusbandName 	= ws.getString(4);
					 strSpouseName 				= ws.getString(5);
					 strReligion 				= ws.getString(6);
					 strCategoryName 			= ws.getString(7);
					 strCategoryCode 			= ws.getString(8);					
					 strAddress 				= ws.getString(9);
					 strMlcNo 					= ws.getString(10);
					 strHiddenValue 			= ws.getString(11); 
					 catGrp 					= ws.getString(13);
					 visitType 					= ws.getString(15).split("\\^")[0];
					 episodeCode 				= ws.getString(15).split("\\^")[1];
					if (strHiddenValue == null)
						strHiddenValue = "----";
					String[] id 				= strHiddenValue.split("\\^");
					strEmailId 					= ws.getString(16);
					contactNo 				= "";
					if (strHiddenValue != null)
					{	
						contactNo =  id[13];
					}

					if (strAgeAndSex == null)
						strAgeAndSex = "----";
					if (strPatientName == null)
						strPatientName = "----";
					if (strFatherOrHusbandName == null)
						strFatherOrHusbandName = "----";
					if (strSpouseName == null)
						strSpouseName = "----";
					if (strReligion == null)
						strReligion = "----";
					if (strCategoryName == null)
						strCategoryName = "----";
					if (strCategoryCode == null)
						strCategoryCode = "----";
					if (strAddress == null)
						strAddress = "----";					
					if (strMlcNo == null)
						strMlcNo = "-----";
					
				}
			}    
					
			while(vo.getWsIssueDetails().next())
			{
				vo.setStrIssueDate(vo.getWsIssueDetails().getString(2));
				vo.setStrStoreName(vo.getWsIssueDetails().getString(4));
				if(k==0)
				{
					strUserName    = vo.getWsIssueDetails().getString(36);				
					unit_net_amt   = vo.getWsIssueDetails().getString(40);	
				}
				NetAmount      = NetAmount+ Float.parseFloat(vo.getWsIssueDetails().getString(40));		
				k++;
			}
			  vo.getWsIssueDetails().beforeFirst();
			
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
	           19. Issue Qty
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
	           40. ITEM_VALUE
	         */    
			contents.append(hisutil.appendSpace("[", 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n");
			printLine++;

			contents.append(hisutil.appendSpace(" CR No.", 10, 0)+ ": "+ hisutil.appendSpace(vo.getStrCrNo().toUpperCase(), 20, 0));//10+20=30+2
			contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(vo.getStrIssueDate(), 21, 0));//10+21=31+2						
			contents.append(hisutil.appendSpace("ISSUE No.", 10, 0)+ ": "+ hisutil.appendSpace(vo.getStrIssueNo(), 20, 0));//10+20=30+2
			contents.append("\n");
			printLine++;
			printLine++;
			
			contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strPatientName, 20, "~").get(0).toUpperCase(), 20, 0));
			contents.append(hisutil.appendSpace("Mobile No", 10, 0)+ ": "+ hisutil.appendSpace(contactNo, 21, 0));
			contents.append(hisutil.appendSpace(" ", 10, 0)+ " "+ hisutil.appendSpace(" ", 20, 0));
			
			contents.append("\n");
			printLine++;
			printLine++;
			
								
			contents.append(hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strCategoryName, 20, "~").get(0).toUpperCase(), 20, 0));
			contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(strAgeAndSex.toUpperCase(), 21, 0));
			contents.append(hisutil.appendSpace("ISSUE BY.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(vo.getStrStoreName(), 20, "~").get(0).toUpperCase(), 20, 0));
			//contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(serv_type, 19, "~").get(0).toUpperCase(), 20, 0));
			contents.append("\n");
			printLine++;
				
					
			int i =1;
			contents.append("<div class='receipt-container'>");
			contents.append("<div class='billing-details'>");
			while(vo.getWsIssueDetails().next())
			{
				
				OutputStream os=new ByteArrayOutputStream();
	  		       
		 		Barcode     barcode = BarcodeFactory.createCode128(vo.getWsIssueDetails().getString(7));
	 			
		 		barcode.setBarWidth(1);
	  		    barcode.setResolution(203);
	  		       //barcode.setBarHeight(10);
				  
	  		     Font font=new Font("Plain",Font.PLAIN,0);
	  		     barcode.setFont(font);
	  		     BarcodeImageHandler.writePNG(barcode, os);
					
	  		     /*
	  		     ByteArrayOutputStream bos=(ByteArrayOutputStream)os;
	  			 byte[] data=bos.toByteArray();
	  			 t.put(arrSaveString[6], data);
	  			
	  			try {
	  				bos.flush();
					os.flush();
					bos.close();
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
	  			
				if(i==1)
				{	
					contents.append("-----------------------------------------------------------------------------------------------");
					contents.append("<div class='billing-row'>");
					contents.append("<div class='billing-item1' align='center'>S.No.</div>");
					contents.append("<div class='billing-item2' align='center'>ITEM NAME</div>");
					contents.append("<div class='billing-item3' align='center'>BATCH</div>");
					contents.append("<div class='billing-item4' align='center'>RATE(Rs.)</div>");
					contents.append("<div class='billing-item5' align='center'>QTY.</div>");
					contents.append("<div class='billing-item6' align='center'>AMOUNT(Rs.)</div>");
					contents.append("</div>");
					contents.append("-----------------------------------------------------------------------------------------------");
				}
								
				contents.append("<div class='billing-row'>");
				contents.append("<div class='billing-item1' align='center'>"+String.valueOf(i)+"</div>");
				contents.append("<div class='billing-item2' align='left'>"+vo.getWsIssueDetails().getString(6)+"</div>");
				contents.append("<div class='billing-item3' align='center'>"+vo.getWsIssueDetails().getString(7)+"</div>");
				contents.append("<div class='billing-item4' align='right'>"+String.valueOf(vo.getWsIssueDetails().getString(16))+"</div>");
				contents.append("<div class='billing-item5' align='right'>"+vo.getWsIssueDetails().getString(19)+"</div>");
				contents.append("<div class='billing-item6' align='right'>"+vo.getWsIssueDetails().getString(40)+"</div>");
				contents.append("</div>");
			
				
				i++;
			}	
			
			contents.append("-----------------------------------------------------------------------------------------------");
			contents.append("\n");
			printLine++;
			
			contents.append("<div class='billing-row'>");
			contents.append("<div class='billing-item1' align='center'></div>");
			contents.append("<div class='billing-item2' align='left'></div>");
			contents.append("<div class='billing-item3' align='center'></div>");
			contents.append("<div class='billing-item4' align='right'></div>");
			contents.append("<div class='billing-item5' align='right'>TOTAL AMOUNT</div>");
			contents.append("<div class='billing-item6' align='right'>"+String.format("%1$,.2f", NetAmount)+"</div>");
			contents.append("</div>");
			
						
			contents.append(hisutil.appendSpace("", 79,1)+hisutil.appendSpace("---------------",15,1));
			contents.append("\n");
			printLine++;
			
			contents.append("</div>");
			contents.append("</div>");
						
			contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(String.valueOf(NetAmount)),94, 0));
			contents.append("\n");
			printLine++;
			printLine++;
			
			String contents3 = new String();
			
			contents3 = "\n \n "+ hisutil.appendSpace(strUserName + " (" + strUserName + ")", 79, 1);
			contents3 += "\n";
			printLine++;
			contents3 += hisutil.appendSpace("AUTHORISED SIGNATORY", 79, 1);
			contents3 += "\n";
			printLine++;			
			
			contents.append(contents3);
			
			/*
			contents.append("<div class=\"receipt-container\">" + 
					"    <div class=\"header\">" + 
					"        <h2>Billing Receipt</h2>" + 
					"        <p>Date: 2024-04-21</p>" + 
					"    </div>" + 				
					"    <div class=\"billing-details\">" + 					
					"        <div class=\"billing-row\">" + 
					"		    <div class=\"billing-item1\" align=\"center\">S.No.</div>" + 
					"            <div class=\"billing-item2\" align=\"center\">ITEM NAME</div>" + 
					"            <div class=\"billing-item3\" align=\"center\">BATCH</div>" + 
					"            <div class=\"billing-item4\" align=\"center\">RATE(Rs.)</div>" + 
					"            <div class=\"billing-item5\" align=\"center\">QTY.</div>" + 
					"			<div class=\"billing-item6\" align=\"center\">AMOUNT(Rs.)</div>" + 
					"        </div>" + 
					"        <div class=\"billing-row\">" + 
					"		    <div class=\"billing-item1\" align=\"center\">1.</div>" + 
					"            <div class=\"billing-item2\" align=\"left\">&#2949;&#2975;&#3021;&#2992;&#3014;&#2985;&#3019;&#2965;&#3021;&#2992;&#3019;&#2990;&#3021;&#2949;&#2975;</div>" + 
					"            <div class=\"billing-item3\" align=\"center\">BATCH#12216112</div>" + 
					"            <div class=\"billing-item4\" align=\"center\">$10.00</div>" + 
					"            <div class=\"billing-item5\" align=\"center\">2</div>" + 
					"			<div class=\"billing-item6\" align=\"center\">$30.00</div>" + 
					"        </div>" + 
					"         <div class=\"billing-row\">" + 
					"		    <div class=\"billing-item1\" align=\"center\">2.</div>" + 
					"            <div class=\"billing-item2\" align=\"left\">&#2949;&#2994;&#3021;&#2986;&#3014;&#2979;&#3021;&#2975;&#2970;&#3019;&#2994;&#3021; &#2990;&#2993;&#3021;&#2993;&#3009;&#2990;&#3021; </div>" + 
					"            <div class=\"billing-item3\" align=\"center\">TRAU239283</div>" + 
					"            <div class=\"billing-item4\" align=\"center\">$10.00</div>" + 
					"            <div class=\"billing-item5\" align=\"center\">8</div>" + 
					"			<div class=\"billing-item6\" align=\"center\">$322.00</div>" + 
					"        </div>" + 
					"		 <div class=\"billing-row\">" + 
					"		    <div class=\"billing-item1\" align=\"center\">3.</div>" + 
					"            <div class=\"billing-item2\" align=\"left\">&#2949;&#2994;&#3021;&#2986;&#3014;&#2979;&#3021;&#2975;&#2970;&#3019;&#2994;&#3021; &#2970;&#3014;&#2997;&#2986;&#3007;&#2995;&#3021; </div>" + 
					"            <div class=\"billing-item3\" align=\"center\">YTYDY237823</div>" + 
					"            <div class=\"billing-item4\" align=\"center\">$10.00</div>" + 
					"            <div class=\"billing-item5\" align=\"center\">66</div>" + 
					"			<div class=\"billing-item6\" align=\"center\">$4567.00</div>" + 
					"        </div>" + 
					"		 <div class=\"billing-row\">" + 
					"		    <div class=\"billing-item1\" align=\"center\">4.</div>" + 
					"            <div class=\"billing-item2\" align=\"left\">&#2949;&#2994;&#3021;&#2986;&#3014;&#2979;&#3021;&#2975;&#2970;&#3019;&#2994;&#3021; </div>" + 
					"            <div class=\"billing-item3\" align=\"center\">2323742397@#</div>" + 
					"            <div class=\"billing-item4\" align=\"center\">$222222.00</div>" + 
					"            <div class=\"billing-item5\" align=\"center\">45456464</div>" + 
					"			<div class=\"billing-item6\" align=\"center\">$304554645.00</div>" + 
					"        </div>" + 
					"		 " + 
					"		<div class=\"billing-row\">" + 
					"            <div class=\"billing-item1\" align=\"right\"></div>" + 
					"            <div class=\"billing-item2\" align=\"left\"></div>" + 
					"            <div class=\"billing-item3\" ></div>	" + 
					"			<div class=\"billing-item4\" ></div>			" + 
					"            <div class=\"billing-item5\" align=\"center\">Total</div>" + 
					"            <div class=\"billing-item6\" >$10000000.00</div>" + 
					"        </div>" + 
					"    </div>" + 				
					"</div>");
					*/
			
			content = PrintContents("1", "1", contents.toString(),request);
			System.out.println("Duplicate  Services------->\n" + contents.toString());
		 }
		 catch (Exception e)
		 {
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->"+ e.getMessage());
		 } 
		 finally
		 {
			vo = null;
			bo = null;
			hisutil = null;
		
		 }			
			
		  return content; 			
			
			
	 }
	 
	   /**
		 * OPD_SERVICES(vo) -- > This Method is Used to get Print Type in
		 * OPD_SERVICES Case
		 * 
		 * @throws Exception
		 */
		public static boolean OPD_SERVICES(String strBillNo, String strBServiceId,String strHospitalCode, 
											String strReceiptNo , HttpServletRequest request , 
											Map tariffPrintMap , String strIsDirectMode,
											int isDuplicateBill,
											String isCreditBill,
											String printCopyType 
											) throws Exception 
		{
			
	        System.out.println("------billing.OPD_SERVICES.findPrintType------");		
			System.out.println("strBServiceId------>"+strBServiceId);
			System.out.println("strBillNo------>"+strBillNo);
			System.out.println("strBServiceId------>"+strBServiceId);
			System.out.println("strHospitalCode------>"+strHospitalCode);
			System.out.println("isDuplicateBill------>"+isDuplicateBill);
			System.out.println("isDuplicateBill------>"+isDuplicateBill);
			System.out.println("------------------------------------------");

			if (strBillNo == null && strBillNo.length() != 10)
			{
				throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
			}
			if (strBServiceId == null && strBServiceId.length() != 2)
			{
				throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
			}
			if (strHospitalCode == null && strHospitalCode.length() != 3)
			{
				throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
			}
			
			PrintVO voObj = null;
			PrintBO boObj = null;
			HisUtil hisutil = null;
			WebRowSet ws = null, ws1 = null;
			StringBuffer contents = new StringBuffer("");
			String bill_date = null;
			String bill_no = null;
			String[] patient_name = null;
			String patient_category = null;
			String Crno = null;
			String pat_net_amt = null;
			String strHidden = null;
			String exp_amt = null;
			String clt_net_amt = null;
			String dept = null;
			String strHospDtl = null;
			BillConfigUtil billConfigUtil = null;
			String strIsCreditCat="0"; //0 no 1 yes credit category..
			String strClientName="---"; 
			//Map clNoPrintMap=null;
			String patTotAmt="0.00";
			String clientTotAmt="0.00";
			String tempStr="";
			String serv_type="";
			String creditno="---";
			String paymentdtls="";
			String argtscat="0"; //0 no 1 yes category..
			String staffcat="0";
			String PaymentModeName="";
			String paymentMode="";
			String paymentmode = "0";

			String BillType="";
			String Mobile="";
			boolean content = false;
			double concessionAmt=0.00;

			try
			{
				    billConfigUtil = new BillConfigUtil(strHospitalCode);
				
					voObj = new PrintVO();
					boObj = new PrintBO();
					hisutil = new HisUtil("billing", "PrintHLP");

					voObj.setStrReceiptNo(strReceiptNo);
					voObj.setStrBillNo(strBillNo);
					voObj.setStrHospCode(strHospitalCode);
					
					//strIsDirectMode=1 Cash Collecton Offline
					//strIsDirectMode=0 Cash Collecton Online
					if (strIsDirectMode == "1")
					{
						boObj.OPD_SERVICES_DIRECT(voObj);
					}else{
						boObj.OPD_SERVICES(voObj);
					}

					BillConfigUtil brt = new BillConfigUtil(strHospitalCode);
					String Footer = brt.getBillFormatFooter();
										
					if (strIsDirectMode == "1")
					{
						ws = voObj.getGblWs1();//a flield with name 'creditCat'=1 indicates it s a credit category..
					} 
					else
					{
						ws = voObj.getGblWs1();
						ws1 = voObj.getGblWs2();//fields related to credit category are received..
					}

					for (int k = 0; ws.next(); k++)
					{
						bill_no 			= ws.getString(1);
						bill_date 			= ws.getString(2);
						patient_name 		= ws.getString(3).replace("^", "#").split("#");
						patient_category 	= ws.getString(4);
						Crno 				= ws.getString(5);
						exp_amt 			= HisUtil.getAmountWithDecimal(ws.getString(6), 2);
						pat_net_amt 		= HisUtil.getAmountWithDecimal(ws.getString(7),2);
						clt_net_amt 		= HisUtil.getAmountWithDecimal(ws.getString(8),2);
						strHidden 			= ws.getString(9);
						serv_type			= ws.getString(10);
						dept 				= ws.getString(11);
						strHospDtl			= ws.getString(14);
						strIsCreditCat		= ws.getString(15);//1 yes its credit cat..
						strClientName		= ws.getString(16).equals("")?"---":ws.getString(16);//1 yes its credit cat..
						creditno			= ws.getString(17).equals("0")?"---":ws.getString(17);
						paymentdtls			= ws.getString(18);//.equals("")?"---":ws.getString(18);
						argtscat			= ws.getString(19);//1 yes its cat..
						staffcat			= ws.getString(21);
						paymentmode 		= ws.getString(22);

						double cltamt = Double.parseDouble(clt_net_amt);
						
						if (isDuplicateBill == 1)
						{
							contents.append(hisutil.appendSpace("DUPLICATE--", 40, 1)+hisutil.appendSpace(printCopyType.toUpperCase(), 54, 0));
							contents.append("\n");
							printLine++;
							printLine++;
						}
							contents.append(hisutil.appendSpace("["+ BillType, 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n");
							printLine++;

						contents.append(hisutil.appendSpace(" CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
						contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
						contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
						contents.append("\n");
						printLine++;
						printLine++;
						
						contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 20, "~").get(0).toUpperCase(), 20, 0));
						contents.append(hisutil.appendSpace("Mobile No", 10, 0)+ ": "+ hisutil.appendSpace(Mobile, 21, 0));
						contents.append(hisutil.appendSpace(" ", 10, 0)+ " "+ hisutil.appendSpace(" ", 20, 0));
						
						contents.append("\n");
						printLine++;
						printLine++;
						
											
						contents.append(hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
						contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
						contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 20, 0));
						//contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(serv_type, 19, "~").get(0).toUpperCase(), 20, 0));
						contents.append("\n");
						printLine++;
						printLine++;

						//contents.append(MakeClientDtlStr(strHidden));
						contents.append(hisutil.appendSpace(" SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type.toUpperCase(), 20, 0));
						contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(dept, 53, "~").get(0).toUpperCase(), 53, 0));
						contents.append("\n");
						printLine++;
						printLine++;						
						
							
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							contents.append(hisutil.appendSpace("S.No.", 6,	0));
							contents.append(hisutil.appendSpace("PROCEDURE/INVESTIGATION/SERVICE NAME", 40,	0));
							contents.append(hisutil.appendSpace("LOCATION", 15,	0));
							contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
							contents.append(hisutil.appendSpace("QTY.", 8,	0));
							contents.append(hisutil.appendSpace("AMOUNT(Rs.)", 15,	0));
							contents.append("\n");
							printLine++;

							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							
							

							// /iterating printMap for printing tariff based on group

							//concessionAmt=iterateMapForPrinting(tariffPrintMap, contents, brt);

							if (cltamt > 0)
							{
								contents.append(hisutil.appendSpace("EXPENSE AMT   : ",	67, 1)+ hisutil.appendSpace(exp_amt, 12, 1) + "\n");
								printLine++;
								contents.append(hisutil.appendSpace("PAID BY THIRD PARTY   : ", 68, 1)+ hisutil.appendSpace(clt_net_amt, 12, 1)+ "\n");
								printLine++;
								contents.append(hisutil.appendSpace("PAID BY PATIENT   : ", 67, 1)+ hisutil.appendSpace(pat_net_amt, 12, 1)+ "\n");
								printLine++;
							} 
							else
							{
								contents.append(hisutil.appendSpace("---------------", 93,1));
								contents.append("\n");
								printLine++;
								//contents.append(hisutil.appendSpace("TOTAL AMOUNT ",74, 1)+ hisutil.appendSpace(exp_amt, 8, 1));
								contents.append(hisutil.appendSpace("TOTAL AMOUNT ",84, 1)+ hisutil.appendSpace(pat_net_amt, 10, 1));
								contents.append("\n");
								printLine++;
								contents.append(hisutil.appendSpace("---------------", 93,1));
								contents.append("\n");
								printLine++;
							}

							contents.append("\n");
							printLine++;

							//contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
							if(!staffcat.equals("1"))
								contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
							else
								contents.append(hisutil.appendSpace("TOTAL CHARGES ",74, 1)+ hisutil.appendSpace(Double.toString(Math.abs(concessionAmt)), 7, 1));
							contents.append("\n");
							printLine++;
							
							contents.append(hisutil.appendSpace("EXEMPTION/CONCESSION AMT ",74, 1)+ hisutil.appendSpace(Double.toString(concessionAmt), 7, 1));
							contents.append("\n");
							printLine++;
							//contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
							contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
							contents.append("\n");
							printLine++;
							
							contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(pat_net_amt),94, 0));
							contents.append("\n");
							printLine++;
							printLine++;
							
							
											
					}  // Ist  For Loop 
					contents.append(hisutil.appendSpace("NOTE : AMOUNT,PATIENT SHARE AND CREDIT SHARE ARE IN RS.",94, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+paymentmode,94, 0));
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
					contents.append("\n");
					printLine++;
					
					/*contents.append(hisutil.appendSpace("(U): URGENT TARIFF SURCHARGE("+billConfigUtil.getStrUrgTrfSur()+"% EXTRA CHARGES)",94, 0));
					contents.append("\n");
					printLine++;*/
					
					if(argtscat.equals("1") && Double.parseDouble(clientTotAmt)>0.00)
					{
						if(Double.parseDouble(patTotAmt)==0.00)
						{
							contents.append("<b>");
							contents.append(hisutil.appendSpace("NO AMOUNT IS COLLECTED - CASHLESS SCHEME",94, 0));
							contents.append("</b>");
							contents.append("\n");
							printLine++;
						}
						if(Double.parseDouble(patTotAmt)>0.00)
						{
							contents.append("<b>");
							contents.append(hisutil.appendSpace("NO AMOUNT IS COLLECTED (LIMIT- Rs."+clientTotAmt+") - CASHLESS SCHEME",94, 0));
							contents.append("</b>");
							contents.append("\n");
							printLine++;
						}
					}

					if (strBillNo.startsWith("5"))
					{
						contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
					} 
					else
					{
						contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
					}
				

				strIsDirectMode = "0";
				
				content = PrintContents(strBServiceId, "1", contents.toString(),request);
				System.out.println("Opd Services------->" + contents.toString());
			} 
			catch (Exception e)
			{
				e.printStackTrace();
				throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->"+ e.getMessage());
			} 
			finally
			{
				voObj = null;
				boObj = null;
				hisutil = null;
				billConfigUtil = null;
			}

			return content;
		}
	 
		/**
		 * Footer(String ConCatVal) -- > This Method is Used to get Client Detail
		 * String If we pass Client Detail in Concat Format
		 * like:-Header1^Header2^Header3^Header4
		 */
		public static String Footer(String Footer, HttpServletRequest request,String strDisclaimer) throws Exception
		{
			String contents3 = new String();
			String F1 = null;
			String disclaimer = null;

			PrintVO voObj = null;
			PrintBO boObj = null;
			HisUtil hisutil = null;

			String strCounterName = "";
			String strUserName = "";

			if (Footer.equals("") || Footer.equals("-") || Footer.equals("0"))
			{
				F1 = "";
			} 
			else
			{
				F1 = Footer;
			}

			if (strDisclaimer.equals("") || strDisclaimer.equals("-")|| strDisclaimer.equals("0"))
			{
				disclaimer = "";
			} 
			else
			{
				disclaimer = strDisclaimer;
			}
			try
			{

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrIpAddress(request.getSession().getAttribute("IP_ADDR").toString());
				voObj.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				voObj.setStrHospCode(request.getSession().getAttribute(	"HOSPITAL_CODE").toString());
				boObj.getCounterAndUserName(voObj);

				if (voObj.getStrCounterAndUserName().next())
				{
					String strTemp[] = voObj.getStrCounterAndUserName().getString(1).replace("^", "#").split("#");
					strCounterName = strTemp[0].toUpperCase();
					strUserName = strTemp[1].toUpperCase();
				}
			} 
			catch (Exception e)
			{
				throw e;
			}

			
			contents3 = "\n \n "+ hisutil.appendSpace(strUserName + " (" + strCounterName + ")", 79, 1);
			contents3 += "\n";
			printLine++;
			contents3 += hisutil.appendSpace("AUTHORISED SIGNATORY", 79, 1);
			contents3 += "\n";
			printLine++;

			if (F1.trim().length() > 0)
			{
				contents3 += hisutil.appendSpace(F1,94, 0);
				//"\n                    " + ;
				printLine++;
			}
			if (disclaimer.trim().length() > 0)
			{
				contents3 += "\n                    " + disclaimer;
				printLine++;
			}

			
			return contents3;
		}
		
		public static synchronized boolean PrintContents(String bServiceId , String receiptType , String contents , HttpServletRequest request) throws Exception
		{
			contents += FORMFEED;
			HisPrinter hisPrinter = null;
			
			try
			{
				 hisPrinter = new HisPrinter();
				 hisPrinter.printFile(contents, "Billing", request);
			}
			catch (Exception e) 
			{
					throw new Exception("PrintHLP.PrintContents()-->"+e.getMessage());				 
			}
			finally
			{
				hisPrinter = null;
			}
			
			return true;
		}

	 
}
