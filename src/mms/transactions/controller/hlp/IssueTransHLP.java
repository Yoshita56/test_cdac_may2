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
import mms.transactions.bo.IssueTransBO;
import mms.transactions.controller.fb.IssueTransFB;
import mms.transactions.vo.IssueDeskTransVO;
import mms.transactions.vo.IssueTransVO;
import mms.transactions.vo.IssueTransVO;

public class IssueTransHLP 
{
	
	public static String getPatientDtl(IssueTransFB formBean) throws Exception 
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
	 
	 public static String GET_PAT_LIST_HLP(WebRowSet wb)
		{ 
			StringBuffer sb = new StringBuffer();
			int i=0;
						
			try
			{
						
				sb.append("<table class='table' align='center' style='border: 1px solid black; border-collapse: collapse;'>");
				sb.append("<thead class='thead' >" );
				sb.append("<tr>");
				sb.append("<th colspan='7' style='align:left;font-weight: 400; font-size: 0.8rem; color: #000000;'>Request Details(Online)</th>");	
				sb.append("</tr> ");
				sb.append("<tr>");
				sb.append("<th scope='col' width='5%'     style='border: 1px solid black; border-collapse: collapse;' bgcolor='#ECFFDC'><b>#</b></th>");			
				sb.append("<th scope='col' width='30%'    style='border: 1px solid black; border-collapse: collapse;font-weight: 400; font-size: 0.8rem; color: #000000;'><b>Details</b></th>");
				sb.append("<th scope='col' width='15%'    style='border: 1px solid black; border-collapse: collapse;font-weight: 400; font-size: 0.8rem; color: #000000;'><b>Dept. Name</b></th>");
				sb.append("<th scope='col' width='15%'    style='border: 1px solid black; border-collapse: collapse;font-weight: 400; font-size: 0.8rem; color: #000000;'><b>Dept. Unit Name</b></th>");
				sb.append("<th scope='col' width='10%'    style='border: 1px solid black; border-collapse: collapse;font-weight: 400; font-size: 0.8rem; color: #000000;'><b>Ward</b></th>");	
				sb.append("<th scope='col' width='15%'    style='border: 1px solid black; border-collapse: collapse;font-weight: 400; font-size: 0.8rem; color: #000000;'><b>Presc. By</b></th>");
				sb.append("<th scope='col' width='10%'    style='border: 1px solid black; border-collapse: collapse;font-weight: 400; font-size: 0.8rem; color: #000000;'><b>Date</b></th>");			
				sb.append("</tr> ");
								
				if(wb != null && wb.size() > 0)
				{
						 
		                 while (wb.next())
		                    {
		                	 /*
		   		          1. P_KEY [ A.HRGNUM_EPISODE_CODE || '^' || A.HRGNUM_VISIT_NO||'^'||A.HRGNUM_PUK ]
		   		          2. PAT_NAME [ CR_NO ]
		   		          3. DEPT_NAME
		   		          4. DEPT_UNIT_NAME
		   		          5. PRES BY
		   		          6. PRES_DATE
		   		          7. DEPT NAME @ DEPT UNIT NAME @ WARD NAME @ ROOM NAME @ BED NAME
		   		        */
		   				

		                		String pKey                     = wb.getString(1);
		                	 	String patName                  = wb.getString(2);
								String deptName                 = wb.getString(3);
								String deptUnitName  			= wb.getString(4);
								String presBy           		= wb.getString(5);
								String presDate                 = wb.getString(6);
								String wardName                 = wb.getString(7).split("\\@")[2];
							
								sb.append("<tr> ");																
								sb.append("<td width='5%'  colspan='1' bgcolor='#ECFFDC' id='check"+i+"'>");
								sb.append("<input type='radio' title='View' name='arrBasePkey' value='"+ pKey+"' id='arrBasePkey"+i+"' onclick='showDeliveryDateDetails(1,this,\""+ i + "\");'>");
								sb.append("</td> ");				
							
								sb.append("<td  style=\'text-align:left;font-weight: 400; font-size: 0.8rem; color: #000000;\'   width='30%' style='border: 1px solid black;'>");
								sb.append(patName);
								sb.append("</td> ");
							
								sb.append("<td style=\'text-align:left;font-weight: 400; font-size: 0.8rem; color: #000000;\'    width='15%' style='border: 1px solid black;'>");
								sb.append(deptName);
								sb.append("</td> ");
								
								sb.append("<td style=\'text-align:left;font-weight: 400; font-size: 0.8rem; color: #000000;\'   width='15%' style='border: 1px solid black;'>");
								sb.append(deptUnitName);
								sb.append("</td> ");
								
								sb.append("<td style=\'text-align:center;font-weight: 400; font-size: 0.8rem; color: #000000;\' width='10%' style='border: 1px solid black;'>");
								sb.append(wardName);
								sb.append("</td> ");
																
								sb.append("<td style=\'text-align:left;font-weight: 400; font-size: 0.8rem; color: #000000;\'  width='15%' style='border: 1px solid black;'>");
								sb.append(presBy);
								sb.append("</td> ");	
								
								
								sb.append("<td style=\'text-align:center;font-weight: 400; font-size: 0.8rem; color: #000000;\' width='10%' style='border: 1px solid black;'>");
								sb.append(presDate);
								sb.append("</td> ");
								
								
								sb.append("</tr> ");					
								
								i++;
		    				   
		    				}
		                 sb.append("<thead> ");
		 				 sb.append("</table>");
				}
				else
				{
					sb.append("<tr> ");
					sb.append("<td colspan='8' style=\'text-align:center;\'>Request Details(Online) Not Available</td> ");
					sb.append("</tr> ");
					sb.append("<thead> ");
	 				sb.append("</table>");
				
				}
				
			}catch(Exception e){
				throw new HisException("Issue Transaction","IssueTransHLP.GET_PAT_LIST_HLP()-->",e.getMessage());
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
	 public static String getIssuePopUpBS(String strHospCode,String strStoreId,String strIssueNo)throws IOException 
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
	 

	 public static String getOnlineTreatmentDtls(WebRowSet ws , IssueTransFB formBean) throws Exception
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
	 
	 
	 /**
		 * This method is used to show item Details on ISSUE PAGE
		 * 
		 * @param wb
		 * @param strItemCategory
		 * @param strHospitalCode
		 * @return
		 */
		public static String getItemDetails_Drug
		(
				String strItemCategoryNo, 
				String strHospitalCode, WebRowSet wb,
				String strRaisingStoreId, 
				String strBudgetFlg, 
				String strIssueStoreID
		) throws SQLException 
		{
			StringBuffer br = new StringBuffer();
			
			IssueTransVO vo = null;
			IssueTransBO bo = null;
			   
			HisUtil hisutil = null;

			String strUnitComboValues = "";

			String strHiddenId = ""; // item id^brandid^RESERVED FLAG^GROUPID^SUBGROUP ID^CONSUMABLE FLAG
										// ^strItemCategory^strRaisingStoreId
			// String strItemName = "";
			String strBrandName = "";
			String strAvlQty = "";
			String strAvlQtyWithUnitId = "";
			String strAvlQtyBaseVal = "";
			String strBalQty = "";
			String strSancUnitId = "";
			String strSancUnitName = "";
			String strBalQtyBaseVal = "";
			String strReqSancQty;
			// String strRateBaseVal = "";
			// String strRate = "";
			// String strRateUnitId = "";
			String[] temp = null;
			String strReOrderFlg;
			String strApplyClass;
			String strCompSancUnit;
			String strReceivingStoreAvlQty = "";
			String strTotalNoOfBatch = "";
			String strCost ="0.00";
			int i = 0;

			try 
			{
				hisutil = new HisUtil("mms", "IssueTransHLP");
				
				bo = new IssueTransBO();
				vo = new IssueTransVO();
				vo.setStrHospitalCode(strHospitalCode);
				if (wb.size() != 0) 
				{

					//br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center'cellpadding='1px' cellspacing='1px'>");
					br.append("<table class='table'>");
					br.append("<thead>");
					br.append("<tr>");							
					br.append("<th style='text-align:center;' style='width:36%;text-align: center !important;'><b>Item Name</b></th>");
					//br.append("<th style='text-align:center;' style='width:8%;text-align: center !important;'><b>Item Type</b></th>");
					//br.append("<th style='text-align:center;' style='width:8%'><b>Indent Store Qty</b></th>");
					br.append("<th style='text-align:center;' style='width:8%'><b>Avl Qty</b></th>");
					br.append("<th style='text-align:center;' style='width:8%'><b>Req Qty</b></th>");						
					br.append("<th style='text-align:center;' style='width:8%'><b>Issue Qty</b></th>");					
					br.append("<th style='text-align:center;' style='width:16%'><b>Batch</b></th>");	
					br.append("<th style='text-align:center;' style='width:16%'><b>Exp Date</b></th>");	
					br.append("<th style='text-align:center;' style='width:8%'><b>Cost</b></th>");						
					//br.append("<th style='text-align:center;' style='width:8%'><b>Remarks</b></th>");	
					//br.append("<th style='text-align:center;' style='width:8%'><b>LP Qty</b></th>");	
					
					br.append("</tr>");
					br.append("</thead>");

					while (wb.next()) 
					{
						/*
		                  1. P_Key [ HSTNUM_ITEM_ID||'^'||HSTNUM_ITEMBRAND_ID||'^0^0^0^0' ]
		                  2. Generic Name
		                  3. Brand Name
		                  4. Avl Qty
		                  5. Balance Qtty
		                  6. Unit Id
		                  7. Unit Name
		                  8. Requestd Qty
		                  9. Requested / Sanction Qty
		                 10. Re-Order
		                 11. Unit Id    6301 ^ 1 ^ 0
		                 12. 0 Null Value
		                 13. Batch 
		                 14. Rec Store Avl Qty
		                 15. Total No Of Batch
		                 16. Drug Type
		                 17. EDL Catg 
		                 18. Sale Price
				         */
						
						
						strHiddenId 			= wb.getString(1); // item id^brand id						
						strBrandName 			= wb.getString(3);
						strAvlQty 				= wb.getString(4);
						strBalQty 				= wb.getString(5);					
						if (wb.getString(6) == null) 
						{
							strSancUnitId 		= "0";
						} 
						else 
						{
							strSancUnitId 		= wb.getString(6);
						}
						strSancUnitName 		= wb.getString(7);
						strBalQtyBaseVal 		= wb.getString(8);

						strReqSancQty 			= wb.getString(8);

						strCompSancUnit 		= wb.getString(11); // Adding in Change Request 28-July-2011
						strReceivingStoreAvlQty = wb.getString(14);
						strTotalNoOfBatch 		= wb.getString(15); 
						
						if (strBalQty.equals("0")) 
						{
							strSancUnitName = " ";
						}
						
						System.out.println("-IssueTransHLP.getItemDetails_Drug - strHiddenId-"+strHiddenId);
						System.out.println("-- strTotalNoOfBatch-"+strTotalNoOfBatch);

						if (Integer.parseInt(strTotalNoOfBatch) == 1) 
						{
							System.out.println("*****************************************************");
							// Item ID ^ ItemBrand Id ^ Batch No ^ StoreID ^ Catg NO
							vo.setStrSingleItemDtl(strHiddenId.split("\\^")[0] + "^" + strHiddenId.split("\\^")[1] + "^"
									+ wb.getString(13) + "^" + strIssueStoreID + "^" + strItemCategoryNo);
							System.out.println("-- IssueTransHLP.getItemDetails_Drug ** Single Batch Dtl -Pkg_Mms_View.proc_itemStock_dtl [ Mode - 7 ]-");
							bo.getSingleBatchItemDtl(vo); 
							
							// Pkg_Mms_View.proc_itemStock_dtl [ Mode - 7 ]
							
							 /*
		                      1.Generic Name
		                      2.Brand Name
		                      3.Batch No
		                      4.Mfg Date
		                      5.Exp Date
		                      6.Rate
		                      7.Avl Qty
		                      8.Mfg Name
		                      9.Rate With Unit
		                     10.PO No
		                     11. Prg Id
		                     12. NA
		                     13. Supp Id    		                   
				             */
							
						}
						if (Integer.parseInt(strTotalNoOfBatch) == 0) 
						{
							// Item ID ^ ItemBrand Id ^ Batch No ^ StoreID
							vo.setStrSingleBatchDtlWs(null);
						}	

						if (((wb.getString(17)==null||wb.getString(17).equals(""))?"0":wb.getString(17)).equals("1")) 
						{
							strApplyClass = "width:32%;text-align: center !important;";
						} else {
							strApplyClass = "width:32%;text-align: center !important;";
						}
						temp 				= strAvlQty.replace("^", "#").split("#");

						strAvlQty 			= temp[0];
						strAvlQtyWithUnitId = temp[1];
						strAvlQtyBaseVal 	= temp[2];
						
						vo.setStrSancUnitId(strSancUnitId);
						

						strUnitComboValues = "<option value='6301'>No</option>";
						
						
							System.out.println("--- IssueTransHLP -  A ---");

							br.append("<tr>");

							br.append("<td  id='td1" + i + "'  style='width:36%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:left;'  >");
							br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk" + i
									+ "' value= '" + strHiddenId + "^" + strItemCategoryNo + "^" + strRaisingStoreId
									+ "' /> ");
							br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");

							br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value="
									+ wb.getString(10) + " />");
							br.append(
									" <input type='hidden' name='strReceivingStoreAvlQtyChk' id='strReceivingStoreAvlQtyChk"
											+ i + "' value=" + strReceivingStoreAvlQty + " />");
							br.append(" <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk" + i + "' value="
									+ strAvlQty + " />");
							/*
							br.append(" <input type='hidden' name='strBrandNameVal' id='strBrandNameVal" + i + "' value="
									+ strBrandName + " />");
							*/

							//br.append("<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""+ i + "\");'>" + strBrandName + "</a>");
							br.append(strBrandName);
							br.append("</td>");
							
							//br.append("<td  id='td16" + i + "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;' >" + wb.getString(16)+ " </td>");
							//br.append("<td  id='td17" + i + "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'>" + strReceivingStoreAvlQty	+ " </td>");
							
							br.append("<td WIDTH='5%' id='td2" + i + "'  style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;' ><b>" + strAvlQty	+ "</b><input type='hidden' name='strAvlQty' id='strAvlQty" + i + "' value='"
									+ strAvlQtyWithUnitId
									+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal" + i
									+ "' value='" + strAvlQtyBaseVal + "' />");
							br.append("</td>");
							

							br.append("<input type='hidden' name='strBalQty' id='strBalQty" + i + "' value='" + strBalQty
									+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId" + i + "' value='"
									+ strSancUnitId
									+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal" + i
									+ "' value='" + strBalQtyBaseVal + "' />");

							br.append("<td  id='td3" + i + "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'  ><b>" + strReqSancQty+ "");
							br.append("</b></td>");
							
																
							if (Integer.parseInt(strTotalNoOfBatch) == 1) 
							{		

								br.append("<td  id='td4" + i
										+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;' >"
										+ "<input type='text' autocomplete='off' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
										+ i + ");' name='strIssueQty' id='strIssueQty" + i
										+ "' class='form-control' value='"+strReqSancQty+"' >");
								br.append("</td>");
							}
							else
							{	
								br.append("<td  id='td4" + i
										+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;' >"
										+ "<input type='text' autocomplete='off' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
										+ i + ");' name='strIssueQty' id='strIssueQty" + i
										+ "' class='form-control' value='"+strReqSancQty+"'  >");
								br.append("</td>");
							}

							br.append("<input type='hidden' name='strTotalBatch' id='strTotalBatch" + i + "' value='"
									+ strTotalNoOfBatch + "' />");

							br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i + "' value='"
									+ strTotalNoOfBatch + "' />");

							if (Integer.parseInt(strTotalNoOfBatch) > 1) 
							{
								System.out.println("--- IssueTransHLP -  B ---");

								br.append("<input type='hidden' name='strSingleManufId'    id='strSingleManufId" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strSingleProgId'     id='strSingleProgId" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strStockQty'         id='strStockQty" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strStockRate'        id='strStockRate" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strCheckBatchExists' id='strCheckBatchExists" + i
										+ "' value='1' />");
								br.append("<input type='hidden' name='strSingleMfgDate'    id='strSingleMfgDate"
										+ i + "' value='' />");
								
								br.append("<td id='td9" + i
										+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
										+ i + "' value='' />" + "<div name='issueDrugDtl' id='issueDrugDtl" + i + "'></div>"
										+ " <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callIpdIssueStockDetails(this,\""
										+ i + "\");' TITLE='Click Here For Item Batch List' ><b>AUTO</b></td>");
								
								br.append("<TD style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;' id='td8" + i
										+ "' style='" + strApplyClass + "' ><div name='expDrugDtl' id='expDrugDtl"
										+ i + "'></div></td>");

							} 
							else 
							{
								if (vo.getStrSingleBatchDtlWs() != null && vo.getStrSingleBatchDtlWs().size() > 0) 
								{

									if (vo.getStrSingleBatchDtlWs().next()) 
									{
										 /*
					                      1.Generic Name
					                      2.Brand Name
					                      3.Batch No
					                      4.Mfg Date
					                      5.Exp Date
					                      6.Sale Price
					                      7.Avl Qty
					                      8.Mfg Name
					                      9.Rate With Unit
					                     10.PO No
					                     11. Prg Id
					                     12. NA
					                     13. Supp Id    					                   
							             */
										System.out.println("--- IssueTransHLP -  C ---");		
										
										br.append("<input type='hidden' name='strSingleMfgDate'      id='strSingleMfgDate"
												+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(4) + "' />");
										br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry" + i
												+ "' value='" + vo.getStrSingleBatchDtlWs().getString(5) + "' />");	
										br.append("<input type='hidden' name='strStockRate'        id='strStockRate" + i
												+ "' value='" + vo.getStrSingleBatchDtlWs().getString(6) + "' />");	
										br.append("<input type='hidden' name='strStockQty'         id='strStockQty" + i
												+ "' value='" + vo.getStrSingleBatchDtlWs().getString(7).split("\\^")[0]
												+ "' />");
										
										
										br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
												+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(13) + "' />");
										br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
												+ "' value='" + vo.getStrSingleBatchDtlWs().getString(11) + "' />");
										br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i
												+ "' value='" + strTotalNoOfBatch + "' />");		
										br.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"
														+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(9)
														+ "' />");
										br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch" + i
												+ "' value='" + vo.getStrSingleBatchDtlWs().getString(3) + "' />");										
										br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName"
												+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(8) + "' />");
										br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName"
												+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(12) + "' />");										
										br.append("<input type='hidden' name='strCheckBatchExists' id='strCheckBatchExists"	+ i + "' value='0' />");
										br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId" + i	+ "' value='' />");										
										br.append("<td  id='td8" + i
												+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;' ><b>"
												+ vo.getStrSingleBatchDtlWs().getString(3) + "</b></td>");
										
										br.append("<td  id='td9" + i
												+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'   ><b>"
												+ ((vo.getStrSingleBatchDtlWs().getString(5) == null
														|| vo.getStrSingleBatchDtlWs().getString(5).equals("")) ? "NA"
																: vo.getStrSingleBatchDtlWs().getString(5))
												+ "</b></td>");
									} 
									

								}
								else
								{
									System.out.println("--- IssueTransHLP -  G --[ When BATCH Not Avaliable ]--");
									
									br.append("<input type='hidden' name='strSingleMfgDate'      id='strSingleMfgDate"
											+ i + "' value='-' />");
									br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry" + i
											+ "' value='-' />");	
									br.append("<input type='hidden' name='strStockRate'        id='strStockRate" + i
											+ "' value='0' />");	
									br.append("<input type='hidden' name='strStockQty'         id='strStockQty" + i
											+ "' value='0' />");
									
									
									br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
											+ i + "' value='-' />");
									br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
											+ "' value='-' />");
									br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i
											+ "' value='0' />");		
									br.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"
													+ i + "' value='0' />");
									br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch" + i
											+ "' value='0' />");										
									br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName"
											+ i + "' value='-' />");
									br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName"
											+ i + "' value='-' />");										
									br.append("<input type='hidden' name='strCheckBatchExists' id='strCheckBatchExists"	+ i + "' value='0' />");
									br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId" + i	+ "' value='' />");										
									br.append("<td  id='td8" + i
											+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;' >No Batch</td>");
									
									br.append("<td  id='td9" + i
											+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'   >-</td>");
								}
								br.append("<input type='hidden' disabled='disabled' class=''  value='0.00' name='finalCostDivId' id='finalCostDivId"
												+ i + "' >");
								br.append("<input type='hidden' name='strFinalCost' id='strFinalCost" + i
										+ "' value='0.00' />");
							}
							
							

							System.out.println("--- IssueTransHLP -  F ---");

							/*
							br.append("<td  id='td5" + i
									+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;' >"
									+ "<Select name='strIssueUnitId' onChange='return QtyValidation("
									+ i + ");' id='strIssueUnitId" + i + "' >" + strUnitComboValues + "</select>");
							br.append("</td>");
							*/
							
							br.append("<input type='hidden' class='form-control' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strIssueUnitId' id='strIssueUnitId"+ i + "' value='6301' >");
							
							br.append("<input type='hidden' class='form-control' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strItemRemarks' id='strItemRemarks"+ i + "' value='NA' >");

							/*
							br.append("<td  id='td6" + i + "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'  >"
									+ "<textarea  class='' size = '100' maxlength='500' onkeypress='return validateData(event,9);' name='strItemRemarks' id='strItemRemarks"
									+ i + "' value='' ></textarea></TD>");
									*/
							
							br.append("<input type='hidden' class='form-control' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"+ i + "' value='" + strReqSancQty.split(" ")[0] + "' >");

							/*
							if (strAvlQty.equals("0.00"))
								br.append("<TD WIDTH='10%' id='td8" + i + "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'  >"
										+ "<input type='text' class='form-control' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
										+ i + "' value='" + strReqSancQty.split(" ")[0] + "' ></TD>");
							else
								br.append("<TD WIDTH='10%' id='td8" + i + "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'  >"
										+ "<input type='text' class='' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
										+ i + "' value='' ></TD>");
										*/
							if (Integer.parseInt(strTotalNoOfBatch) == 1) 
							{
							  br.append("<td id='td8" + i + "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'  >"
									+ "<div name='issu"
									+ "CostDiv' id='issueCostDiv" + i + "'>"+Math.round((Double.parseDouble(strReqSancQty) * Double.parseDouble(wb.getString(18))))+"</div>");
							}
							else
							{
								 br.append("<td id='td8" + i + "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'  >"
											+ "<div name='issu"
											+ "CostDiv' id='issueCostDiv" + i + "'>0.00</div>");
								
							}
							
							br.append("</td>");
							
							br.append("</tr>");
							br.append("</div>");
							i++;

										

					}

					br.append("</table> ");
				} 
				else 
				{
										
					br.append("<table class='table'>");
					br.append("<thead>");
					br.append("<tr>");						
					br.append("<th align='center' ><b>Item Name</b></th>");
					br.append("<th align='center' ><b>Avl Qty</b></th>");
					br.append("<th align='center' ><b>Req Qty</b></th>");
					br.append("<th align='center' ><b>Issue Qty</b></th>");
					br.append("<th align='center' ><b>Batch</b></th>");
					br.append("<th align='center' ><b>Exp Date</b></th>");
					br.append("<th align='center' ><b>Cost</b></th>");						
					br.append("</tr>");
					br.append("</thead>");
					br.append("<tr><td align='center'  style='text-align:center;><font color='black'><b>No Record Found </b></font></td></tr>");
					br.append("</table>");			
							
				}

			} catch (Exception e) {
				e.printStackTrace();
				return "ERROR";

			}
			//// System.out.println("O/P String:::::"+br.toString());
			return br.toString();
		}
		
		
		public static String getStockItemDtlsInitView_Org(IssueTransFB formBean) throws Exception 
		{

			StringBuffer sb = new StringBuffer("");

			WebRowSet ws = formBean.getWsStockDetails();
			HisUtil util = new HisUtil("IssueDeskTrans Stock Detail Util", "IssueDeskTransHLP");
			IssueDeskTransVO vo = new IssueDeskTransVO();
			int count = 0;

			boolean flag = false;

			String strHiddenVal = "0";
			String[] strHiddenValList = null;
			String[] strTemp = null;
			String[] strChkList = null;
			String[] strQtyList = null;
			String[] strUnitList = null;

			String[] strHiddenCost = null;
			String[] strHiddenTotalCost = null;

			String strTempQtyVal = "";
			String strTempUnitVal = "";
			String strTempCost = "0.00";
			String strTempTotalCost = "0.00";
			String strTableWidth = "100%";
			try 
			{

				StringBuffer strChkVal = new StringBuffer("");
				if (formBean.getStrModeVal().equals("1")) 
				{

					sb.append("<table width='" + strTableWidth + "' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr class='HEADER'> ");
					sb.append("<input type='hidden' name='strIndex' id='strIndex' value='" + formBean.getStrIndex() + "'>");
					sb.append("<input type='hidden' name='strParentIndex' id='strParentIndex" + count + "' value='"
							+ formBean.getStrParentIndex() + "'>");
					if (formBean.getStrItemCategoryId().equals("10")) 
					{

						sb.append("<td colspan='4'>Drug Stock Detail(s) </td> ");

					} 
					else 
					{
						sb.append("<td colspan='4'>Item Stock Detail(s) </td> ");
					}
					sb.append("</tr> ");
					sb.append("<tr> ");
					if (formBean.getStrItemCategoryId().equals("10")) {

						sb.append("<td width='50%' class='LABEL'>Drug Name</td> ");

					} else {
						sb.append("<td width='50%' class='LABEL'>Item Name</td> ");
					}

					sb.append("<td width='50%' class='CONTROL'>" + formBean.getStrItemName() + "</td> ");
					sb.append("</tr> ");
					sb.append("<tr> ");
					sb.append("<td width='50%' class='LABEL'>Issue Qty.</td> ");
					sb.append("<td width='50%' class='CONTROL'>" + formBean.getStrIndentIssueQty() + " No <input type='hidden' class='txtFldNormal' ");
					sb.append("name='strItemIssueQty' value='" + formBean.getStrIndentIssueQty()
							+ "'><input type='hidden' class='txtFldNormal' ");
					sb.append("name='strItemIssueQtyBaseVal' value='" + formBean.getStrIssueQtyInBase() + "'></td> ");

					sb.append("</tr> ");
					sb.append("</table> ");

					sb.append("<table width='" + strTableWidth + "' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr class='TITLE'> ");
					if (!formBean.getStrItemCategoryId().equals("10")) {
						sb.append("<td colspan='10'>Item Detail(s)</td> ");
					} else {
						sb.append("<td colspan='10'>Drug Detail(s)</td> ");
					}
					sb.append("</tr> ");
					sb.append("<tr> ");
					sb.append("<td class='multiRPTLabel' width='5%'>#");
					sb.append("</td> ");
					sb.append("<td class='multiRPTLabel' width='14%'>Batch No. ");
					sb.append("</td> ");
					sb.append("<td class='multiRPTLabel' width='10%'>Expiry Date ");
					sb.append("</td> ");
					sb.append("<td class='multiRPTLabel' width='10%'>Avl. Qty. ");
					sb.append("</td> ");
					sb.append("<td class='multiRPTLabel' width='7%'>Rate/Unit");
					sb.append("</td> ");
					sb.append("<td class='multiRPTLabel' width='12%'><font color='red'>*</font>Issue Qty. ");
					sb.append("</td> ");
					sb.append("<td class='multiRPTLabel' width='8%'><font color='red'>*</font>Unit ");
					sb.append("</td> ");
					if (formBean.getUsrArg().equals("1")) // Means Budget Required
					{
						sb.append("<td class='multiRPTLabel' width='14%'>Cost");
						sb.append("</td> ");
					}
					sb.append("</tr> ");

					// System.out.println("----IssueDeskHLP . getStockItemDtlsInitView
					// ---SIZE--"+ws.size());

					if (ws != null && ws.size() > 0) 
					{

						while (ws.next()) 
						{							
							strChkVal = new StringBuffer();							
							String strExpDate = "";
							if (ws.getString(18) != null && ws.getString(18).length() > 10) 
							{
								strExpDate = ws.getString(18);
							}
							if (formBean.getStrItemCategoryId().equals("10")) 
							{

								strChkVal.append(ws.getString(11)).append("^").append(ws.getString(12)).append("^")
										.append(ws.getString(13)).append("^").append(ws.getString(15)).append("^")
										.append(ws.getString(14)).append("^0").append("^").append(strExpDate).append("^")
										.append(ws.getString(19)).append("^").append(ws.getString(20)).append("^")
										.append(ws.getString(21)).append("^").append(ws.getString(23)).append("^")
										.append(ws.getString(24)).append("^").append(ws.getString(38)).append("^")
										.append(ws.getString(39));
							} 
							else 
							{

								strChkVal.append(ws.getString(11)).append("^").append(ws.getString(12)).append("^")
										.append(ws.getString(13)).append("^").append(ws.getString(15)).append("^")
										.append(ws.getString(14)).append("^").append(ws.getString(37)).append("^")
										.append(strExpDate).append("^").append(ws.getString(19)).append("^")
										.append(ws.getString(20)).append("^").append(ws.getString(21)).append("^")
										.append(ws.getString(23)).append("^").append(ws.getString(24)).append("^")
										.append(ws.getString(38)).append("^").append(ws.getString(39));

							}
							count = count + 1;
							sb.append("<tr>");
							strHiddenVal = formBean.getStrHiddenVal();
							if (strHiddenVal.length() > 1) 
							{
								strHiddenValList = strHiddenVal.split("@");
								strChkList = new String[strHiddenValList.length];
								strQtyList = new String[strHiddenValList.length];
								strUnitList = new String[strHiddenValList.length];
								strHiddenTotalCost = new String[strHiddenValList.length];
								strHiddenCost = new String[strHiddenValList.length];
								//// System.out.println("length::::::"+strHiddenValList.length);
								for (int i = 0, stopI = strHiddenValList.length; i < stopI; i++) 
								{
									// //System.out.println("Hidden val:::"+strHiddenValList[i]);
									strTemp = strHiddenValList[i].replace("^", "#").split("#");
									strChkList[i] = new StringBuffer(strTemp[0]).append("^").append(strTemp[1]).append("^")
											.append(strTemp[2]).append("^").append(strTemp[3]).append("^")
											.append(strTemp[4]).append("^").append(strTemp[5]).append("^")
											.append(strTemp[6]).append("^").append(strTemp[7]).append("^")
											.append(strTemp[8]).append("^").append(strTemp[9]).append("^")
											.append(strTemp[10]).append("^").append(strTemp[11]).append("^")
											.append(strTemp[12]).append("^").append(strTemp[13]).toString();

									strQtyList[i] = strTemp[14];
									strUnitList[i] = strTemp[15];
									strHiddenCost[i] = strTemp[18];
									strHiddenTotalCost[i] = strTemp[19];
								}
							}

							if (strChkList != null) 
							{

								for (int i = 0, stopI = strChkList.length; i < stopI; i++) 
								{
									String content = strChkList[i];

									if (content.equalsIgnoreCase(strChkVal.toString())) 
									{
										flag = true;
										strTempQtyVal = strQtyList[i];
										strTempUnitVal = strUnitList[i];

										strTempCost = strHiddenCost[i];
										strTempTotalCost = strHiddenTotalCost[i];

									}

								}

							}
							if (flag) 
							{
								sb.append(
										"<td class='multiPOControl' width='5%'><input type='checkbox' name='strStockDtlsChk' id='strStockDtlsChk"
												+ count + "' checked='checked'  value='" + strChkVal.toString()
												+ "' onclick='checkStockDetails(this,\"" + count + "\");'> ");

							} else 
							{

								sb.append(
										"<td class='multiPOControl' width='5%'><input type='checkbox' name='strStockDtlsChk' id='strStockDtlsChk"
												+ count + "' value='" + strChkVal.toString()
												+ "' onclick='checkStockDetails(this,\"" + count + "\");'> ");

							}
							sb.append("</td> ");							
							sb.append("<td class='multiPOControl' width='14%'>");
							sb.append(ws.getString(15));
							sb.append("</td> ");
							sb.append("<td class='multiPOControl' width='10%'>");
							sb.append(strExpDate);
							sb.append("</td> ");
							sb.append("<td class='multiPOControl' width='10%'>");
							sb.append(ws.getString(9).split("\\ ")[0]);
							sb.append("</td> ");
							sb.append("<td class='multiPOControl' width='7%'>");
							sb.append(ws.getString(23) + "/" + ws.getString(9).split("\\ ")[1]);

							sb.append("<input type='hidden' name='strAvlDrugBatch'    id='strAvlDrugBatch" + count
									+ "'    value='" + ws.getString(15) + "'>");
							sb.append("<input type='hidden' name='strDrugBatchAvlQty' id='strDrugBatchAvlQty" + count
									+ "' value='" + ws.getString(9).split("\\ ")[0] + "'>");
							sb.append("<input type='hidden' name='strRate'            id='strRate" + count
									+ "'            value='" + ws.getString(23) + "'>");
							sb.append("<input type='hidden' name='strRate'            id='strPurchaseRate" + count
									+ "'    value='" + ws.getString(23) + "'>");
							sb.append("</td> ");

							sb.append("<td class='multiPOControl' width='12%'>");

							if (flag) 
							{
								// Method in issueDesk_trans.js File
								sb.append("<input type='text' autocomplete='off' class='txtFldMin' maxlength='7' value='"
										+ strTempQtyVal
										+ "' onkeypress='return validateData(event,7);' onkeyup='checkAvailQtyIpdIssue(\""
										+ count
										+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\",\"strStockCostId\");' name='strAvailableQty' id='strAvailableQty"
										+ count + "'>");

							} 
							else 
							{

								sb.append(
										"<input type='text' autocomplete='off' class='txtFldMin' maxlength='7' disabled='disabled' onkeypress='return validateData(event,7);' onkeyup='checkAvailQtyIpdIssue(\""
												+ count
												+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");' name='strAvailableQty' id='strAvailableQty"
												+ count + "'>");

							}

							sb.append("</td> ");

							sb.append("<td class='multiPOControl' width='8%'>");
							sb.append("<input type='hidden' name='strDrugDtls'         id='strDrugDtls" + (count - 1)
									+ "'  value='" + ws.getString(15) + "'>");
							sb.append("<input type='hidden' name='strExpDtls'          id='strExpDtls" + (count - 1)
									+ "'  value='" + strExpDate + "'>");
							sb.append("<input type='hidden' name='strMrpDtls'          id='strMrpDtls" + (count - 1)
									+ "'  value='" + ws.getString(23) + "'>");

							if (flag) 
							{

								sb.append("<select name='strAvailableQtyUnit' class='comboMin' id='strAvailableQtyUnit"
										+ count + "' onchange='checkAvailQtyIpdIssue(\"" + count
										+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");'>");
								

								sb.append("<option value='6301^1^0'>No</option>");
								

								sb.append("</select>");

							} 
							else 
							{

								sb.append(
										"<select name='strAvailableQtyUnit' disabled='disabled' class='comboMin' id='strAvailableQtyUnit"
												+ count + "' onchange='checkAvailQtyIpdIssue(\"" + count
												+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");' >");

								

								sb.append("<option value='6301^1^0'>No</option>");
								

								sb.append("</select>");

							}
							sb.append("<input type='hidden' name='strBatchCost'    id='strBatchCost" + count+ "'    value='0'>");
							sb.append("</td> ");
							sb.append("</tr> ");

							flag = false;

							strTempQtyVal = "";
							strTempUnitVal = "0";
						}

					} else {

						sb.append("<tr> ");
						sb.append(
								"<td colspan='8' class='multiPOControl'><font color='red'><b>Details Not Available</b></font></td> ");
						sb.append("</tr> ");

					}

					sb.append("</table> ");
					
					sb.append("<input type='hidden' name='strApproxAmt' value='0'></td> ");

					sb.append("<table width='" + strTableWidth + "' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr class='FOOTER'> ");
					sb.append("<td colspan='4'><font size='2' color='red'>*</font> Mandatory Fields  </td> ");
					sb.append("</tr> ");
					sb.append("</table> ");

					sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
					sb.append("<tr> ");
					sb.append("<td align='center'><img style='cursor: pointer; ' ");
					sb.append(" src='../../hisglobal/images/btn-ok.png' ");
					sb.append(" onClick='return validateIssueStockPopUp();' title='Save Record'/>  ");
					sb.append(" <img style='cursor: pointer; ' title='Cancel Process'  ");
					sb.append(" src='../../hisglobal/images/close_tab.png' onClick='cancelStockIpdIssueDtls(this,\""
							+ (count - 1) + "\");' /> ");
					sb.append(" </td> ");
					sb.append(" </tr> ");
					sb.append(" </table> ");

				}

			} catch (Exception e) {

				e.printStackTrace();

				throw e;
			}

			return sb.toString();
	    }
		

		public static String getStockItemDtlsInitView(IssueTransFB formBean) throws Exception 
		{

			StringBuffer sb = new StringBuffer("");

			WebRowSet ws = formBean.getWsStockDetails();
			HisUtil util = new HisUtil("IssueDeskTrans Stock Detail Util", "IssueDeskTransHLP");
			IssueDeskTransVO vo = new IssueDeskTransVO();
			int count = 0;

			boolean flag = false;

			String strHiddenVal = "0";
			String[] strHiddenValList = null;
			String[] strTemp = null;
			String[] strChkList = null;
			String[] strQtyList = null;
			String[] strUnitList = null;

			String[] strHiddenCost = null;
			String[] strHiddenTotalCost = null;

			String strTempQtyVal = "";
			String strTempUnitVal = "";
			String strTempCost = "0.00";
			String strTempTotalCost = "0.00";
			String strTableWidth = "100%";
			try 
			{

				StringBuffer strChkVal = new StringBuffer("");
				if (formBean.getStrModeVal().equals("1")) 
				{										
					
					sb.append("<table class='table'>");
					sb.append("<thead>");
					sb.append("<input type='hidden' name='strIndex' id='strIndex' value='" + formBean.getStrIndex() + "'>");
					sb.append("<input type='hidden' name='strParentIndex' id='strParentIndex" + count + "' value='"
							+ formBean.getStrParentIndex() + "'>");
					if (formBean.getStrItemCategoryId().equals("10")) 
					{

						sb.append("<th colspan='7'>Drug Stock Detail(s) </td> ");

					} 
					else 
					{
						sb.append("<th colspan='7'>Item Stock Detail(s) </td> ");
					}
					sb.append("</tr> ");
					sb.append("<tr> ");
					sb.append("<th  colspan='3' style='text-align: right !important;'><b>Req Qty:</td> ");
					sb.append("<th  colspan='4' style='text-align: left !important;color: #0000FF'><b>" + formBean.getStrIndentIssueQty() + " No <input type='hidden' class='txtFldNormal' ");
					sb.append("name='strItemIssueQty' value='" + formBean.getStrIndentIssueQty()
							+ "'><input type='hidden' class='txtFldNormal' ");
					sb.append("name='strItemIssueQtyBaseVal' value='" + formBean.getStrIssueQtyInBase() + "'></th> ");
					sb.append("</tr> ");					
					sb.append("<tr>");		
					sb.append("<th  style='width:5% ;text-align: center !important;'><b>#</b></th>");
					sb.append("<th  style='width:18%;text-align: center !important;'><b>Batch</b></th>");					
					sb.append("<th  style='width:16%;text-align: center !important;'><b>Exp Date</b></th>");
					sb.append("<th  style='width:10%;text-align: center !important;'><b>Avl Qty</b></th>");
					sb.append("<th  style='width:10%;text-align: center !important;'><b>Rate</b></th>");	
					sb.append("<th  style='width:10%;text-align: center !important;'><b>Issue Qty</b></th>");
					sb.append("<th  style='width:10%;text-align: center !important;'><b>Unit</b></th>");
					//sb.append("<th  style='width:10%;text-align: center !important;'><b>Cost<b></th> ");					
					sb.append("</tr>");
					sb.append("</thead>");

					/*
					sb.append("<tr> ");
					sb.append("<td class='multiRPTLabel' width='5%'>#");
					sb.append("</td> ");
					sb.append("<td class='multiRPTLabel' width='14%'>Batch No. ");
					sb.append("</td> ");
					sb.append("<td class='multiRPTLabel' width='10%'>Expiry Date ");
					sb.append("</td> ");
					sb.append("<td class='multiRPTLabel' width='10%'>Avl. Qty. ");
					sb.append("</td> ");
					sb.append("<td class='multiRPTLabel' width='7%'>Rate/Unit");
					sb.append("</td> ");
					sb.append("<td class='multiRPTLabel' width='12%'><font color='red'>*</font>Issue Qty. ");
					sb.append("</td> ");
					sb.append("<td class='multiRPTLabel' width='8%'><font color='red'>*</font>Unit ");
					sb.append("</td> ");
					if (formBean.getUsrArg().equals("1")) // Means Budget Required
					{
						sb.append("<td class='multiRPTLabel' width='14%'>Cost");
						sb.append("</td> ");
					}
					sb.append("</tr> ");
					*/
					

					// System.out.println("----IssueDeskHLP . getStockItemDtlsInitView
					// ---SIZE--"+ws.size());

					if (ws != null && ws.size() > 0) 
					{

						while (ws.next()) 
						{		
							
							sb.append("<tr>");
							
							strChkVal = new StringBuffer();							
							String strExpDate = "";
							if (ws.getString(18) != null && ws.getString(18).length() > 10) 
							{
								strExpDate = ws.getString(18);
							}
							if (formBean.getStrItemCategoryId().equals("10")) 
							{

								strChkVal.append(ws.getString(11)).append("^").append(ws.getString(12)).append("^")
										.append(ws.getString(13)).append("^").append(ws.getString(15)).append("^")
										.append(ws.getString(14)).append("^0").append("^").append(strExpDate).append("^")
										.append(ws.getString(19)).append("^").append(ws.getString(20)).append("^")
										.append(ws.getString(21)).append("^").append(ws.getString(23)).append("^")
										.append(ws.getString(24)).append("^").append(ws.getString(38)).append("^")
										.append(ws.getString(39));
							} 
							else 
							{

								strChkVal.append(ws.getString(11)).append("^").append(ws.getString(12)).append("^")
										.append(ws.getString(13)).append("^").append(ws.getString(15)).append("^")
										.append(ws.getString(14)).append("^").append(ws.getString(37)).append("^")
										.append(strExpDate).append("^").append(ws.getString(19)).append("^")
										.append(ws.getString(20)).append("^").append(ws.getString(21)).append("^")
										.append(ws.getString(23)).append("^").append(ws.getString(24)).append("^")
										.append(ws.getString(38)).append("^").append(ws.getString(39));

							}
							count = count + 1;
							
							strHiddenVal = formBean.getStrHiddenVal();
							if (strHiddenVal.length() > 1) 
							{
								strHiddenValList = strHiddenVal.split("@");
								strChkList = new String[strHiddenValList.length];
								strQtyList = new String[strHiddenValList.length];
								strUnitList = new String[strHiddenValList.length];
								strHiddenTotalCost = new String[strHiddenValList.length];
								strHiddenCost = new String[strHiddenValList.length];
								//// System.out.println("length::::::"+strHiddenValList.length);
								for (int i = 0, stopI = strHiddenValList.length; i < stopI; i++) 
								{
									// //System.out.println("Hidden val:::"+strHiddenValList[i]);
									strTemp = strHiddenValList[i].replace("^", "#").split("#");
									strChkList[i] = new StringBuffer(strTemp[0]).append("^").append(strTemp[1]).append("^")
											.append(strTemp[2]).append("^").append(strTemp[3]).append("^")
											.append(strTemp[4]).append("^").append(strTemp[5]).append("^")
											.append(strTemp[6]).append("^").append(strTemp[7]).append("^")
											.append(strTemp[8]).append("^").append(strTemp[9]).append("^")
											.append(strTemp[10]).append("^").append(strTemp[11]).append("^")
											.append(strTemp[12]).append("^").append(strTemp[13]).toString();

									strQtyList[i] = strTemp[14];
									strUnitList[i] = strTemp[15];
									strHiddenCost[i] = strTemp[18];
									strHiddenTotalCost[i] = strTemp[19];
								}
							}

							if (strChkList != null) 
							{

								for (int i = 0, stopI = strChkList.length; i < stopI; i++) 
								{
									String content = strChkList[i];

									if (content.equalsIgnoreCase(strChkVal.toString())) 
									{
										flag = true;
										strTempQtyVal = strQtyList[i];
										strTempUnitVal = strUnitList[i];

										strTempCost = strHiddenCost[i];
										strTempTotalCost = strHiddenTotalCost[i];

									}

								}

							}
							if (flag) 
							{
								sb.append(
										"<td style='width:5%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'><input type='checkbox' name='strStockDtlsChk' id='strStockDtlsChk"
												+ count + "' checked='checked'  value='" + strChkVal.toString()
												+ "' onclick='checkStockDetails(this,\"" + count + "\");'> ");

							} else 
							{

								sb.append(
										"<td style='width:5%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'><input type='checkbox' name='strStockDtlsChk' id='strStockDtlsChk"
												+ count + "' value='" + strChkVal.toString()
												+ "' onclick='checkStockDetails(this,\"" + count + "\");'> ");

							}
							sb.append("</td> ");							
							sb.append("<td style='width:18%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'>");
							sb.append(ws.getString(15));
							sb.append("</td> ");
							sb.append("<td style='width:16%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'>");
							sb.append(strExpDate);
							sb.append("</td> ");
							sb.append("<td style='width:10%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'>");
							sb.append(ws.getString(9).split("\\ ")[0]);
							sb.append("</td> ");
							sb.append("<td style='width:10%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'>");
							//sb.append(ws.getString(23) + "/" + ws.getString(9).split("\\ ")[1]);
							sb.append(ws.getString(23));
							
							sb.append("<input type='hidden' name='strAvlDrugBatch'    id='strAvlDrugBatch" + count
									+ "'    value='" + ws.getString(15) + "'>");
							sb.append("<input type='hidden' name='strDrugBatchAvlQty' id='strDrugBatchAvlQty" + count
									+ "' value='" + ws.getString(9).split("\\ ")[0] + "'>");
							sb.append("<input type='hidden' name='strRate'            id='strRate" + count
									+ "'            value='" + ws.getString(23) + "'>");
							sb.append("<input type='hidden' name='strRate'            id='strPurchaseRate" + count
									+ "'    value='" + ws.getString(23) + "'>");
							sb.append("</td> ");

							sb.append("<td style='width:10%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'>");

							if (flag) 
							{
								// Method in issueDesk_trans.js File
								sb.append("<input type='text' autocomplete='off' class='form-control' maxlength='7' value='"
										+ strTempQtyVal
										+ "' onkeypress='return validateData(event,7);' onkeyup='checkAvailQtyIpdIssue(\""
										+ count
										+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\",\"strStockCostId\");' name='strAvailableQty' id='strAvailableQty"
										+ count + "'>");

							} 
							else 
							{

								sb.append(
										"<input type='text' autocomplete='off' class='form-control' maxlength='7' disabled='disabled' onkeypress='return validateData(event,7);' onkeyup='checkAvailQtyIpdIssue(\""
												+ count
												+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");' name='strAvailableQty' id='strAvailableQty"
												+ count + "'>");

							}

							sb.append("</td> ");

							sb.append("<td style='width:10%;font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;'>");
							sb.append("<input type='hidden' name='strDrugDtls'         id='strDrugDtls" + (count - 1)
									+ "'  value='" + ws.getString(15) + "'>");
							sb.append("<input type='hidden' name='strExpDtls'          id='strExpDtls" + (count - 1)
									+ "'  value='" + strExpDate + "'>");
							sb.append("<input type='hidden' name='strMrpDtls'          id='strMrpDtls" + (count - 1)
									+ "'  value='" + ws.getString(23) + "'>");

							if (flag) 
							{

								sb.append("<select name='strAvailableQtyUnit' class='' id='strAvailableQtyUnit"
										+ count + "' onchange='checkAvailQtyIpdIssue(\"" + count
										+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");'>");
								

								sb.append("<option value='6301^1^0'>No</option>");
								

								sb.append("</select>");

							} 
							else 
							{

								sb.append(
										"<select name='strAvailableQtyUnit' disabled='disabled' class='' id='strAvailableQtyUnit"
												+ count + "' onchange='checkAvailQtyIpdIssue(\"" + count
												+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");' >");

								

								sb.append("<option value='6301^1^0'>No</option>");
								

								sb.append("</select>");

							}
							sb.append("<input type='hidden' name='strBatchCost'    id='strBatchCost" + count+ "'    value='0'>");
							sb.append("</td> ");
							sb.append("</tr> ");

							flag = false;

							strTempQtyVal = "";
							strTempUnitVal = "0";
						}

					} else {

						sb.append("<tr> ");
						sb.append("<td colspan='7' style='font-weight: 400; font-size: 0.8rem; color: #000000;text-align:center;' class=''><font color='red'><b>Details Not Available</b></font></td> ");
						sb.append("</tr> ");

					}

					sb.append("</table> ");
					
					sb.append("<input type='hidden' name='strApproxAmt' value='0'></td> ");

					sb.append("<table class='table' width='" + strTableWidth + "' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr class=''> ");
					sb.append("<td colspan='4'><font size='2' color='red'>*</font> Mandatory Fields  </td> ");
					sb.append("</tr> ");
					sb.append("</table> ");

					sb.append("<table class='table' border='0' width='" + strTableWidth + "' align='center'> ");
					sb.append("<tr> ");
					sb.append("<td align='center'><img style='cursor: pointer; ' ");
					sb.append(" src='../../hisglobal/images/btn-ok.png' ");
					sb.append(" onClick='return validateIssueStockPopUp();' title='Save Record'/>  ");
					sb.append(" <img style='cursor: pointer; ' title='Cancel Process'  ");
					sb.append(" src='../../hisglobal/images/close_tab.png' onClick='cancelStockIpdIssueDtls(this,\""
							+ (count - 1) + "\");' /> ");
					sb.append(" </td> ");
					sb.append(" </tr> ");
					sb.append(" </table> ");

				}

			} catch (Exception e) {

				e.printStackTrace();

				throw e;
			}

			return sb.toString();
	    }
		
		
		public static String getIPDNAList(IssueTransVO vo) throws Exception 
		{

			StringBuffer sb = new StringBuffer("");
			int i=1;
			
			ResourceBundle res = null;
			WebRowSet ws = null;
			
			String strTableWidth    = "825";
			String generatedByUser  = "";			
			try 
			{
				ws = vo.getTreatmentDtlHLPWs();
				
				HisUtil hisUtil=new HisUtil("Global","ReportUtil");
				HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(vo.getStrHospitalCode());
				sb.append("<table width='100%' border='0' cellpadding='1px' cellspacing='0px'><tbody><tr><td align='center'><img src='../../hisglobal/images/aiims_inv_header.png'></td></tr></tbody></table>");
				sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
				sb.append("<tr> ");
				sb.append("<td align='right'>");
	 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				sb.append("<img style='cursor: pointer; '  name='PrintPage' tabindex='1' title='Print Page'");
				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printNAData();'/> <img style='cursor: pointer; ' title='Cancel Process'  ");
				sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopupTwo();' /></div>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");	
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");					
				sb.append("<tr>");
				sb.append("<td width='100%' align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b><u>NA Certificate</u></b></font></td> ");
				sb.append("</tr>");					
				sb.append("</table> ");
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
		        
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
					
		                
		        
		         sb.append("<tr> ");
		         sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
		         sb.append("<tr>");
		         sb.append("<td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>");
		         sb.append(vo.getStrPatientDtl());
		         sb.append("</font></td> ");
		         sb.append("</tr> ");
		         sb.append("</table>");   
				
				
				/* vo.setStrHiddenPatDtl(strHiddenPatDtl);
				 * Amika Soni Kumar^
				 * HARISH SONI/Suman Koni^
				 * General^
				 * 24 Yr/F^
				 * HN4543,Venue2 24,Noida,Gautam Buddha Nagar,Uttar Pradesh-230230^
				 * All India Institute of Medical Sciences, Mangalagiri^
				 * null^
				 * 9829234234
				 * */
				
				/* vo.setStrAdmissionDtlHidVal(strAdmissionDtlHidVal);
				   ADMNO^
				   EPCODE^
				   VISITNO^
				   ADMDATETIME^
				   ADMADVNO^
				   DEPTCODE^
				   WARDCODE^
				   ROOMCODE^
				   BEDCODE^
				   TREATCATCODE^
				   ISNEWBORN^
				   MOTHERADMNO^
				   MLCNO^
				   OCCUPID^
				   BEDALLOCDATETIME^
				   LENGTHOFSTAY
				*/		
				if (ws != null && ws.size() > 0) 
				{

					while (ws.next()) 
					{
						generatedByUser = ws.getString(7);
					}
				}	
				ws.beforeFirst();
				
				
				
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
				sb.append("<tr bgcolor='#cdc9c9'> ");
				sb.append("<td style=\"text-align:center;\" width='5%'> <font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
				sb.append("</td>");						
				//sb.append("<td style=\"text-align:center;\"  width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Dept Name</b></font>");
				//sb.append("</td> ");
				sb.append("<td style=\"text-align:center;\" width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
				sb.append("</td>");
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Dosage</b></font> ");
				sb.append("</td> ");
				//sb.append("<td style=\"text-align:center;\" width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Visit Dtl</b></font>");
				//sb.append("</td> ");
				sb.append("<td style=\"text-align:center;\"  width='15%'><font face='Verdana, Arial, Helvetica, sans-serif'><b>Req Qty</b></font>");
				sb.append("</td> ");
				sb.append("<td style=\"text-align:center;\"  width='15%'><font face='Verdana, Arial, Helvetica, sans-serif'><b>Issue Qty</b></font>");
				sb.append("</td> ");
				sb.append("</tr> ");
				sb.append("<tr>");
				sb.append("<td colspan='3' align='left'><hr size='2'></td>");
				sb.append("<td colspan='2' align='center'><hr size='2'></td>");					
				sb.append("</tr>");			
				
				if (ws != null && ws.size() > 0) 
				{

					while (ws.next()) 
					{
							
						/*
						  1. Drug Name
						  2. Dose Name
						  3. For Days
						  4. Prescription Date  - Time
						  5. Dept Name 
						  6. Req Qty
						  7. Report Generated By
						 */	
						sb.append("<tr> ");
						sb.append("<td style=\"text:align:center;\"  width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(i+".");
						sb.append("</font></td> ");					
						//sb.append("<td style=\"text-align:left;\"    width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						//sb.append(ws.getString(5));
						//sb.append("</font></td> ");
						sb.append("<td style=\"text-align:left;\"    width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(1));
						sb.append("</font></td> ");
						sb.append("<td style=\"text-align:center;\"  width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(2));
						sb.append("</font></td> ");
						//sb.append("<td style=\"text-align:center;\"  width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						//sb.append(ws.getString(4));
						//sb.append("</font></td> ");
						sb.append("<td style=\"text-align:center;\"  width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(6));
						sb.append("</font></td> ");
						sb.append("<td style=\"text-align:center;\"  width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append("NA");
						sb.append("</font></td> ");  									
						sb.append("</tr> ");						
						i++;
									
					}							
						
					sb.append("<tr>");
					sb.append("<td colspan='3' align='left'><hr size='2'></td>");
					sb.append("<td colspan='2' align='center'><hr size='2'></td>");					
					sb.append("</tr>");	
					
					sb.append("<tr> ");
					sb.append("<td colspan='3' align='right'></td> ");
					sb.append("<td colspan='2' align='center'></td> ");
					sb.append("</tr> ");
					
					sb.append("<tr> ");
					sb.append("<td colspan='3' align='right'></td> ");
					sb.append("<td colspan='2' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Gene.By User<br><b></font></td> ");
					sb.append("</tr> ");
					sb.append("<tr> ");
					sb.append("<td colspan='3' align='right'></td> ");					
					sb.append("<td colspan='2' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >"+generatedByUser+"[ "+vo.getStrCurrentDate()+" ]</font></td> ");
					sb.append("</tr> ");					
				
				} 
				else 
				{

					sb.append("<tr> ");
					sb.append("<td colspan='5' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>NO NA LIST</b><br/><br/></font></td> ");
					sb.append("</tr> ");

				}
				sb.append("</table> ");			
				

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
		
		
		 public static String getAfterSaveVoucher(IssueTransVO vo,String mode) throws Exception {
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
		    		  sb.append("<td colspan='1'><td colspan='1'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData_O();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();'  /></div></td>");
		    	  }
		    	  else
		    	  {
		    		  if(mode.equals("3"))
			    	  {
			    		  sb.append("<td colspan='1'><td colspan='1'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData_O();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='cancelToMainPage(3);'/></div></td>");
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
		                      40. ITEM_VALUE 
		                    */
							
							vo.setStrUserName(ws.getString(36));
							//System.out.println("ws.getString(36)==============================="+ws.getString(36));
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
							sb.append(ws.getString(6));//Product
							sb.append("</font></td> ");
							sb.append("<td align='center' width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif'  style='FONT-SIZE: 11px;'>");
							sb.append(ws.getString(7));//Batch 
							sb.append("</font></td> ");
							sb.append("<td align='center' width='8%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
							sb.append(ws.getString(8));//Expiry
							sb.append("</font></td> ");
							sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
							sb.append(ws.getString(10));//
							sb.append("</font></td> ");
							sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
							sb.append(ws.getString(33));//Qty
							sb.append("</font></td> ");
							sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
							sb.append(ws.getString(16));//MRP
							sb.append("</font></td> ");
							sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
							sb.append(Math.round(per));//DIS(%)
							sb.append("</font></td> ");
							sb.append("<td style='text-align:right;border: 1px solid black;' width='8%' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
							sb.append(ws.getString(40));//Cost changing from 29 >> 40 item_value
							sb.append("</font></td> ");  									
							sb.append("</tr> ");
							NetAmount=NetAmount+ Float.parseFloat(ws.getString(40));
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
							if(vo.getStrHospitalCode().equals("10811"))	
							{
								sb.append("<tr>");
								sb.append("<td colspan='4' align='left'><u><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Terms & Conditions</font></td>");
								sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>FOR I.G.I.M.S CENTRAL PHARMACY</font></td>");					
								//sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'></font></td>");
								sb.append("</tr>");	
							}
							else
							{							
								
								sb.append("<tr>");
								sb.append("<td colspan='4' align='left'><u><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Terms & Conditions</font></td>");
								sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'></font></td>");					
								//sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'></font></td>");
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
		
	 
}
