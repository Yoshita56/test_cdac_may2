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
public class PatientDetailTracking implements Tag {

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
							/*jw.print("<input type='hidden' name='strHiddenPatDtl' value='"+strHiddenPatDtl+"'><input type='hidden' name='strPatName' value='"+strPatientName+"'>");
							jw.print("<table class='TABLEWIDTH' border='0' cellspacing='1px' align='center' ><tr><td width='25%' class='LABEL'>Name</td>");
							jw.print("<td colspan='3' width='75%' class='CONTROL' title='CR No:"+ws.getString(1)+"' style='cursor: pointer; cursor: hand'> ");
							jw.print(strPatientName);
							jw.print("</td>");*/
							
							jw.print("<input type='hidden' name='strHiddenPatDtl' value='"+strHiddenPatDtl+"'><input type='hidden' name='strPatName' value='"+strPatientName+"'>");
							jw.print("<input type='hidden' name='strCategoryCode' value='"+strCategoryCode+"'>");
							/*jw.print("<table class='table'><thead><tr><th ></th><th></th><th></th><th></th></tr></thead>");
							jw.print("<tbody>");
							jw.print("<tr><td align='Right' class='LABEL'>Name</td>");
							jw.print("<td title='CR No:"+ws.getString(1)+"' style='cursor: pointer; cursor: hand'> ");
							jw.print(strPatientName);
							jw.print("</td>");
							jw.print("<td>");
							jw.print("</td>");
							jw.print("<td>");
							jw.print("</td>");*/
							/*jw.print("<div class='' style='color: #0c2a68'>");
							jw.print("<nav class='navbar navbar-expand-sm bg-primary navbar-dark' style='padding: .1rem 1rem; border-radius: .3rem; background-color: #d4cfbc  !important; line-height: 2.1'>");
							jw.print("<i class='fa fa-user'></i>&nbsp;&nbsp;&nbsp;&nbsp;");
							jw.print("<div><b>CR No:&nbsp;&nbsp;"+ws.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;  •&nbsp;&nbsp;&nbsp;&nbsp;Name:&nbsp;&nbsp;"+strPatientName+" &nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;&nbsp;&nbsp; AgeAndSex:&nbsp;&nbsp;"+strAgeAndSex+" &nbsp;&nbsp;&nbsp;&nbsp;• &nbsp;&nbsp;&nbsp;&nbsp;Father&nbsp;&nbsp;"+ strFather+"/"+strHusbandName+" &nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;&nbsp;&nbsp; CategoryName:&nbsp;&nbsp;"+strCategoryName);
							jw.print("</b></div></nav></div>");*/
							 /*jw.print("<div class='container' style='line-height: 0.5;'>\n");
							 jw.print("<div class='row justify-content-center'>\n");
							 jw.print("<div class='col-md-12'>\n");
							 jw.print("<div class='card'>\n");
							 jw.print("<article class='card-body'>\n");
							 jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Name:</label>&nbsp;&nbsp;"+strPatientName+"");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
/*
							jw.print("<div class='login-reg-panel'>");
							jw.print("<div class='login-info-box'>");
							jw.print("</div>");
							jw.print("<div class='register-info-box'>");
							jw.print("</div>");
							jw.print("<div class='white-panel'>");
							jw.print("<div class='login-show'>");
							jw.print("</div>");
							jw.print("<div class='register-show'>");
							jw.print("</div>");
							jw.print("</div>");
							jw.print("</div>");*/

							
							jw.print("<div class='row' id=''>");
							jw.print("<div class='col-xs-12 col-sm-4'>");
							jw.print("<div class='profile-user-info'>");
							
							jw.print("<div class='profile-info-row'>");
							jw.print("<div class='profile-info-name'>CR No:</div>");
							jw.print("<div class='profile-info-value'>");
							jw.print("<div>"+ws.getString(1)+"</div>");
							jw.print("</div>");
							jw.print("</div>");
							
							jw.print("<div class='profile-info-row'>");
							jw.print("<div class='profile-info-name'>Name:</div>");
							jw.print("<div class='profile-info-value'>");
							jw.print("<div>"+strPatientName+"</div>");
							jw.print("</div>");
							jw.print("</div>");
							jw.print("<div class='profile-info-row'>");
							jw.print("<div class='profile-info-name'>AgeAndSex:</div>");
							jw.print("<div class='profile-info-value'>");
							jw.print("<div>"+strAgeAndSex+"</div>");
							jw.print("</div>");
							jw.print("</div>");
							jw.print("<div class='profile-info-row'>");
							jw.print("<div class='profile-info-name'>Father:</div>");
							jw.print("<div class='profile-info-value'>");
							jw.print("<div>"+ strFather+"/"+strHusbandName+"</div>");
							jw.print("</div>");
							jw.print("</div>");
							jw.print("<div class='profile-info-row'>");
							jw.print("<div class='profile-info-name'>CategoryName:</div>");
							jw.print("<div class='profile-info-value'>");
							jw.print("<div>"+strCategoryName+"</div>");
							jw.print("</div>");
							jw.print("</div>");
							
							jw.print("</div>");
							jw.print("</div>");

							
						}
						/*jw.print("</tr>");
						jw.print("<tr><td align='Right' class='LABEL'>Patient Category</td>");
						jw.print("<td>");
						jw.print(strCategoryName);
						jw.print("<input type='hidden' name='strCategoryCode' value='"+strCategoryCode+"'></td>");
						jw.print("<td align='Right'  class='LABEL'>Age/Gender</td>");
						jw.print("<td>");
						jw.print(strAgeAndSex);
						jw.print("</td></tr>");
						jw.print("<tr><td align='Right'  class='LABEL'>Father Name</td>");
						jw.print("<td>");
						jw.print(strFather);
						jw.print("</td>");
						jw.print("<td align='Right'  class='LABEL'>Spouse Name</td>");
						jw.print("<td>");
						jw.print(strHusbandName);
						jw.print("</td></tr>");*/
						
						 /*jw.print("<div class='form-row'>");
						 jw.print("<div class='col form-group'>");
						 jw.print("</div>");
		                 jw.print("<div class='col form-group'>");
		                 jw.print("<input type='hidden' name='strCategoryCode' value='"+strCategoryCode+"'><label>Patient Category:</label>&nbsp;&nbsp;"+strCategoryName+"");
		                 jw.print("</div>");
		                 jw.print("<div class='col form-group'>");
		                 jw.print("<label>Age/Gender:</label>&nbsp;&nbsp;"+strAgeAndSex+"");
						 jw.print("</div>");
		                 jw.print("</div>");
		                 
		                 jw.print("<div class='form-row'>");
						 jw.print("<div class='col form-group'>");
						 jw.print("</div>");
		                 jw.print("<div class='col form-group'>");
		                 jw.print("<label>Father Name:</label>&nbsp;&nbsp;"+strFather+"");
		                 jw.print("</div>");
		                 jw.print("<div class='col form-group'>");
		                 jw.print("<label>Spouse Name:</label>&nbsp;&nbsp;"+strHusbandName+"");
						 jw.print("</div>");
		                 jw.print("</div>");*/
		                 
						
						
						
						if(!(ws.getString(13).equals("0")))  //for BPL
						{
							isBPL="1";
						/*	jw.print("<tr><td align='Right'><font color='red' weight='strong'>Is BPL</font></td>");
							jw.print("<td>Yes</td> ");	
							jw.print("<td align='Right'><font color='red' weight='strong'>BPL No.</font></td>");
							jw.print("<td> ");
							jw.print("<font color='red'>"+ws.getString(13)+"</font></td>");
							jw.print("</tr>");*/
							
							/* jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is BPL:</label>&nbsp;&nbsp;Yes");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>BPL No:</label>nbsp;&nbsp&;"+ws.getString(13)+"");
							 jw.print("</div>");
			                 jw.print("</div>");*/
			                 
						}
						else
						{
							/*jw.print("<tr><td align='Right' class='LABEL'>Is BPL</td>");
							jw.print("<td>No</td><td></td><td></td>");
							jw.print("</tr>");*/
							
							 /*jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is BPL:</label>&nbsp;&nbsp;No");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}
						
						if(!(ws.getString(9).equals("0")))  //for MLC
						{
							/*isMLC="1";
							jw.print("<tr><td align='Right'>Is MLC</td>");
							jw.print("<td>Yes</td> ");
							
							jw.print("<td align='Right'>MLC No.</td>");
							jw.print("<td> ");
							jw.print("<font color='red'>"+ws.getString(9)+"</font></td>");
							jw.print("</tr>");*/
							
							
							 /*jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is MLC:</label>&nbsp;&nbsp;Yes");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>MLC No:</label>nbsp;&nbsp&;"+ws.getString(9)+"");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}else
						{
							/*jw.print("<tr><td align='Right' class='LABEL'>Is MLC</td>");
							jw.print("<td>No</td><td></td><td></td> ");
							jw.print("</tr>");*/
							
							 /*jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is MLC:</label>&nbsp;&nbsp;No");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}
						
						if(!(ws.getString(14).equals("0")))  //for Refer
						{
							/*isRefer="1";
							jw.print("<tr><td align='Right' class='LABEL'>Is Refered</td>");
							jw.print("<td >Yes</td> ");
							
							jw.print("<td align='Right'>Refered No.</td>");
							jw.print("<td> ");
							jw.print("<font color='red'>"+ws.getString(14)+"</font></td>");
							jw.print("</tr>");*/
							
							/* jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is Refered:</label>&nbsp;&nbsp;Yes");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Refered No:</label>nbsp;&nbsp&;"+ws.getString(14)+"");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}else
						{/*
							jw.print("<tr><td align='Right' class='LABEL'>Is Refered</td>");
							jw.print("<td>No</td> <td></td> <td></td>");
							jw.print("</tr>");*/
							
							/* jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is Refered:</label>&nbsp;&nbsp;No");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}
						if(isAddress())
						{
							/*jw.print("<tr>");
							jw.print("<td width='25%' class='LABEL'>Address</td>");
							jw.print("<td colspan='3' class='CONTROL'>");
							jw.print(strAddress);
							jw.print("</td></tr>");*/
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
						
						//jw.print("</tbody>");

						//jw.print("</table>");
						
						
						 /*jw.print("</article>\n");*/
						/* jw.print("</div>\n");
						 jw.print("</div>\n");
						 jw.print("</div>\n");
						 jw.print("</div>\n");*/

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
