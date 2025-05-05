package hisglobal;

import hisglobal.exceptions.HisException;

import ipd.IpdBO;
import ipd.IpdVO;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.sql.rowset.WebRowSet;
public class PatientDetail implements Tag {

	PageContext pageContext;
	private String crNo = "0";
	private boolean address = false;
	public boolean isAddress() {
		return address;
	}
	public void setAddress(boolean address) {
		this.address = address;
	}
	public String getCrNo() {
		return crNo;
	}
	public void setCrNo(String crNo) {
		this.crNo = crNo;
	}
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}
	public int doStartTag() throws JspException {
		IpdVO voObj = null;
		WebRowSet ws = null;
		JspWriter jw = null;
		String isBPL="0";
		String isMLC="0";
		String isRefer="0";
		String isNewBorn="0";
		try {
			voObj = new IpdVO();
			jw = pageContext.getOut();
			ws = getPatientDtlsWs(voObj);
			//System.out.println("ws.size :"+ws.size());
			if (ws!=null && ws.size()>0) {
				try {
					if (ws.next()) {
						String strAgeAndSex = 			ws.getString(2);
						String strPatientName = 		ws.getString(3);
						String strFather = ws.getString(4);
						String strHusbandName=ws.getString(10);
						String strReligion =			ws.getString(5);
						String strCategoryName =		ws.getString(6);
						String strCategoryCode =		ws.getString(7);
						String strAddress =				ws.getString(8);
						String strMotherName=ws.getString(11);
						String strMotherPuk=ws.getString(12);
						String strEmailId=ws.getString(15);
						String strMotherDtl=strMotherName+"^"+strMotherPuk;
						if(strHusbandName == null) strHusbandName = "";//"---";
						String strHiddenPatDtl=strPatientName+"^"+strFather+"/"+strHusbandName+"^"+strCategoryName+"^"+strAgeAndSex+"^"+strAddress;
						if(strAgeAndSex == null) strAgeAndSex = "";
						if(strPatientName == null) strPatientName = "";
						if(strFather == null) strFather = "";
						if(strHusbandName == null) strHusbandName = "";
						if(strReligion == null) strReligion = "";
						if(strCategoryName == null) strCategoryName = "";
						if(strCategoryCode == null) strCategoryCode = "";
						if(strAddress == null) strAddress = "";
						
						if(ws.getObject("MotherPuk")!=null && !ws.getObject("MotherPuk").equals(""))		
						{
							isNewBorn="1";
							jw.print("<input type='hidden' name='strHiddenPatDtl' value='"+strHiddenPatDtl+"'><input type='hidden' name='strPatName' value='"+strPatientName+"'>");
							jw.print("<table class='TABLEWIDTH' border='0' cellspacing='1px' align='center' ><tr><td width='25%' class='LABEL'>Name</td>");
							jw.print("<td  width='25%' class='CONTROL' title='CR No:"+ws.getString(1)+"' style='cursor: pointer; cursor: hand'> ");
							jw.print(strPatientName);
							jw.print("</td>");
							jw.print("<td width='25%' class='LABEL'>Mother Name</td>");
							jw.print("<td  width='25%' class='CONTROL' title='Mother CR No.:"+strMotherPuk+"' style='cursor: pointer; cursor: hand'> ");
							jw.print("<font color='blue'>"+strMotherName+"</font>");
							jw.print("</td>");
						}
						else
						{
							jw.print("<input type='hidden' name='strHiddenPatDtl' value='"+strHiddenPatDtl+"'><input type='hidden' name='strPatName' value='"+strPatientName+"'>");
							jw.print("<table class='TABLEWIDTH' border='0' cellspacing='1px' align='center' ><tr><td width='25%' class='LABEL'>Name</td>");
							jw.print("<td colspan='3' width='75%' class='CONTROL' title='CR No:"+ws.getString(1)+"' style='cursor: pointer; cursor: hand'> ");
							jw.print(strPatientName);
							jw.print("</td>");
						}
						jw.print("</tr>");
						jw.print("<tr><td width='25%' class='LABEL'>Patient Category</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						jw.print(strCategoryName);
						jw.print("<input type='hidden' name='strCategoryCode' value='"+strCategoryCode+"'></td>");
						jw.print("<td width='25%' class='LABEL'>Age/Gender</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						jw.print(strAgeAndSex);
						jw.print("</td></tr>");
						jw.print("<tr><td width='25%' class='LABEL'>Father Name</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						jw.print(strFather);
						jw.print("</td>");
						jw.print("<td width='25%' class='LABEL'>Spouse Name</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						jw.print(strHusbandName);
						jw.print("</td></tr>");
						if(!(ws.getString(13).equals("0")))  //for BPL
						{
							isBPL="1";
							jw.print("<tr><td width='25%' class='LABEL'><font color='red' weight='strong'>Is BPL</font></td>");
							jw.print("<td width='25%' class='CONTROL'>Yes</td> ");
							
							jw.print("<td width='25%' class='LABEL'><font color='red' weight='strong'>BPL No.</font></td>");
							jw.print("<td width='25%' class='CONTROL'> ");
							jw.print("<font color='red'>"+ws.getString(13)+"</font></td>");
							jw.print("</tr>");
						}
						else
						{
							jw.print("<tr><td width='25%' class='LABEL'>Is BPL</td>");
							jw.print("<td width='25%' class='CONTROL'>No</td><td width='25%' colspan='2' class='LABEL'></td>");
							jw.print("</tr>");
						}
						
						if(!(ws.getString(9).equals("0")))  //for MLC
						{
							isMLC="1";
							jw.print("<tr><td width='25%' class='LABEL'>Is MLC</td>");
							jw.print("<td width='25%' class='CONTROL'>Yes</td> ");
							
							jw.print("<td width='25%' class='LABEL'>MLC No.</td>");
							jw.print("<td width='25%' class='CONTROL'> ");
							jw.print("<font color='red'>"+ws.getString(9)+"</font></td>");
							jw.print("</tr>");
						}else
						{
							jw.print("<tr><td width='25%' class='LABEL'>Is MLC</td>");
							jw.print("<td width='25%'class='CONTROL'>No</td> <td width='25%' colspan='2' class='LABEL'> ");
							jw.print("</tr>");
						}
						
						if(!(ws.getString(14).equals("0")))  //for Refer
						{
							isRefer="1";
							jw.print("<tr><td width='25%' class='LABEL'>Is Refered</td>");
							jw.print("<td width='25%' class='CONTROL'>Yes</td> ");
							
							jw.print("<td width='25%' class='LABEL'>Refered No.</td>");
							jw.print("<td width='25%' class='CONTROL'> ");
							jw.print("<font color='red'>"+ws.getString(14)+"</font></td>");
							jw.print("</tr>");
						}else
						{
							jw.print("<tr><td width='25%' class='LABEL'>Is Refered</td>");
							jw.print("<td width='25%' class='CONTROL'>No</td> <td width='25%' colspan='2' class='LABEL'>");
							jw.print("</tr>");
						}
						if(isAddress()){
							jw.print("<tr>");
							jw.print("<td width='25%' class='LABEL'>Address</td>");
							jw.print("<td colspan='3' class='CONTROL'>");
							jw.print(strAddress);
							jw.print("</td></tr>");
						}
						jw.print("<input type='hidden' name='strIsBPL' value='"+isBPL+"'>");
						jw.print("<input type='hidden' name='strBPLNo' value='"+ws.getString(13)+"'>");
						jw.print("<input type='hidden' name='strIsMLC' value='"+isMLC+"'>");
						jw.print("<input type='hidden' name='strMLCNo' value='"+ws.getString(9)+"'>");
						jw.print("<input type='hidden' name='strIsRefer' value='"+isRefer+"'>");
						jw.print("<input type='hidden' name='strReferNo' value='"+ws.getString(14)+"'>");
						jw.print("<input type='hidden' name='strIsNewBorn' value='"+isNewBorn+"'>");
						jw.print("<input type='hidden' name='strMotherDtl' value='"+strMotherDtl+"'>");
						jw.print("<input type='hidden' name='strEmailId' value='"+strEmailId+"'>");
						jw.print("<input type='hidden' name='strpack' value='"+ws.getString(16)+"'>");
						jw.print("</table>");
					}
				} catch (Exception e) {
					new Exception(e.getMessage()); 
				}
			}
			else
			{
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
			voObj.setStrMsgString("Error while getting patient detail");
			new HisException("IPD Transaction","PatientDetail Tag.doStartTag() -->",e.getMessage());
		}
		finally {
			try {
				jw.print("<input type='hidden' name='strGlbErrMsgTLD' value='"+voObj.getStrMsgString()+"'>");
				ws.close();
			}catch(Exception e) {}
			ws = null;
			voObj = null;
		}
		return EVAL_BODY_INCLUDE;
	}

	public Tag getParent() {
		return null;
	}

	public void release() {
	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	public void setParent(Tag tag) {
	}

    public WebRowSet getPatientDtlsWs(IpdVO voObj)throws Exception{
		
		WebRowSet ws = null;
		IpdBO boObj = new IpdBO();
		if(!this.getCrNo().equals("")){
		voObj.setStrValue1(this.getCrNo());
		boObj.getPatientDetails(voObj);
		}
		else{
			ws = null;
		}
		ws = voObj.getGblWs1();
		return ws;
}
}
